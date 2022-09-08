package com.google.cloud.accessapproval.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * This API allows a customer to manage accesses to cloud resources by
 * Google personnel. It defines the following resource model:
 * - The API has a collection of
 *   [ApprovalRequest][google.cloud.accessapproval.v1.ApprovalRequest]
 *   resources, named `approvalRequests/{approval_request}`
 * - The API has top-level settings per Project/Folder/Organization, named
 *   `accessApprovalSettings`
 * The service also periodically emails a list of recipients, defined at the
 * Project/Folder/Organization level in the accessApprovalSettings, when there
 * is a pending ApprovalRequest for them to act on. The ApprovalRequests can
 * also optionally be published to a Pub/Sub topic owned by the customer
 * (contact support if you would like to enable Pub/Sub notifications).
 * ApprovalRequests can be approved or dismissed. Google personnel can only
 * access the indicated resource or resources if the request is approved
 * (subject to some exclusions:
 * https://cloud.google.com/access-approval/docs/overview#exclusions).
 * Note: Using Access Approval functionality will mean that Google may not be
 * able to meet the SLAs for your chosen products, as any support response times
 * may be dramatically increased. As such the SLAs do not apply to any service
 * disruption to the extent impacted by Customer's use of Access Approval. Do
 * not enable Access Approval for projects where you may require high service
 * availability and rapid response by Google Cloud Support.
 * After a request is approved or dismissed, no further action may be taken on
 * it. Requests with the requested_expiration in the past or with no activity
 * for 14 days are considered dismissed. When an approval expires, the request
 * is considered dismissed.
 * If a request is not approved or dismissed, we call it pending.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/accessapproval/v1/accessapproval.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AccessApprovalGrpc {

  private AccessApprovalGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.accessapproval.v1.AccessApproval";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.accessapproval.v1.ListApprovalRequestsMessage,
      com.google.cloud.accessapproval.v1.ListApprovalRequestsResponse> getListApprovalRequestsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListApprovalRequests",
      requestType = com.google.cloud.accessapproval.v1.ListApprovalRequestsMessage.class,
      responseType = com.google.cloud.accessapproval.v1.ListApprovalRequestsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.accessapproval.v1.ListApprovalRequestsMessage,
      com.google.cloud.accessapproval.v1.ListApprovalRequestsResponse> getListApprovalRequestsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.accessapproval.v1.ListApprovalRequestsMessage, com.google.cloud.accessapproval.v1.ListApprovalRequestsResponse> getListApprovalRequestsMethod;
    if ((getListApprovalRequestsMethod = AccessApprovalGrpc.getListApprovalRequestsMethod) == null) {
      synchronized (AccessApprovalGrpc.class) {
        if ((getListApprovalRequestsMethod = AccessApprovalGrpc.getListApprovalRequestsMethod) == null) {
          AccessApprovalGrpc.getListApprovalRequestsMethod = getListApprovalRequestsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.accessapproval.v1.ListApprovalRequestsMessage, com.google.cloud.accessapproval.v1.ListApprovalRequestsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListApprovalRequests"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.accessapproval.v1.ListApprovalRequestsMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.accessapproval.v1.ListApprovalRequestsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AccessApprovalMethodDescriptorSupplier("ListApprovalRequests"))
              .build();
        }
      }
    }
    return getListApprovalRequestsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.accessapproval.v1.GetApprovalRequestMessage,
      com.google.cloud.accessapproval.v1.ApprovalRequest> getGetApprovalRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetApprovalRequest",
      requestType = com.google.cloud.accessapproval.v1.GetApprovalRequestMessage.class,
      responseType = com.google.cloud.accessapproval.v1.ApprovalRequest.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.accessapproval.v1.GetApprovalRequestMessage,
      com.google.cloud.accessapproval.v1.ApprovalRequest> getGetApprovalRequestMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.accessapproval.v1.GetApprovalRequestMessage, com.google.cloud.accessapproval.v1.ApprovalRequest> getGetApprovalRequestMethod;
    if ((getGetApprovalRequestMethod = AccessApprovalGrpc.getGetApprovalRequestMethod) == null) {
      synchronized (AccessApprovalGrpc.class) {
        if ((getGetApprovalRequestMethod = AccessApprovalGrpc.getGetApprovalRequestMethod) == null) {
          AccessApprovalGrpc.getGetApprovalRequestMethod = getGetApprovalRequestMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.accessapproval.v1.GetApprovalRequestMessage, com.google.cloud.accessapproval.v1.ApprovalRequest>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetApprovalRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.accessapproval.v1.GetApprovalRequestMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.accessapproval.v1.ApprovalRequest.getDefaultInstance()))
              .setSchemaDescriptor(new AccessApprovalMethodDescriptorSupplier("GetApprovalRequest"))
              .build();
        }
      }
    }
    return getGetApprovalRequestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.accessapproval.v1.ApproveApprovalRequestMessage,
      com.google.cloud.accessapproval.v1.ApprovalRequest> getApproveApprovalRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ApproveApprovalRequest",
      requestType = com.google.cloud.accessapproval.v1.ApproveApprovalRequestMessage.class,
      responseType = com.google.cloud.accessapproval.v1.ApprovalRequest.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.accessapproval.v1.ApproveApprovalRequestMessage,
      com.google.cloud.accessapproval.v1.ApprovalRequest> getApproveApprovalRequestMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.accessapproval.v1.ApproveApprovalRequestMessage, com.google.cloud.accessapproval.v1.ApprovalRequest> getApproveApprovalRequestMethod;
    if ((getApproveApprovalRequestMethod = AccessApprovalGrpc.getApproveApprovalRequestMethod) == null) {
      synchronized (AccessApprovalGrpc.class) {
        if ((getApproveApprovalRequestMethod = AccessApprovalGrpc.getApproveApprovalRequestMethod) == null) {
          AccessApprovalGrpc.getApproveApprovalRequestMethod = getApproveApprovalRequestMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.accessapproval.v1.ApproveApprovalRequestMessage, com.google.cloud.accessapproval.v1.ApprovalRequest>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ApproveApprovalRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.accessapproval.v1.ApproveApprovalRequestMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.accessapproval.v1.ApprovalRequest.getDefaultInstance()))
              .setSchemaDescriptor(new AccessApprovalMethodDescriptorSupplier("ApproveApprovalRequest"))
              .build();
        }
      }
    }
    return getApproveApprovalRequestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.accessapproval.v1.DismissApprovalRequestMessage,
      com.google.cloud.accessapproval.v1.ApprovalRequest> getDismissApprovalRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DismissApprovalRequest",
      requestType = com.google.cloud.accessapproval.v1.DismissApprovalRequestMessage.class,
      responseType = com.google.cloud.accessapproval.v1.ApprovalRequest.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.accessapproval.v1.DismissApprovalRequestMessage,
      com.google.cloud.accessapproval.v1.ApprovalRequest> getDismissApprovalRequestMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.accessapproval.v1.DismissApprovalRequestMessage, com.google.cloud.accessapproval.v1.ApprovalRequest> getDismissApprovalRequestMethod;
    if ((getDismissApprovalRequestMethod = AccessApprovalGrpc.getDismissApprovalRequestMethod) == null) {
      synchronized (AccessApprovalGrpc.class) {
        if ((getDismissApprovalRequestMethod = AccessApprovalGrpc.getDismissApprovalRequestMethod) == null) {
          AccessApprovalGrpc.getDismissApprovalRequestMethod = getDismissApprovalRequestMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.accessapproval.v1.DismissApprovalRequestMessage, com.google.cloud.accessapproval.v1.ApprovalRequest>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DismissApprovalRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.accessapproval.v1.DismissApprovalRequestMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.accessapproval.v1.ApprovalRequest.getDefaultInstance()))
              .setSchemaDescriptor(new AccessApprovalMethodDescriptorSupplier("DismissApprovalRequest"))
              .build();
        }
      }
    }
    return getDismissApprovalRequestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.accessapproval.v1.InvalidateApprovalRequestMessage,
      com.google.cloud.accessapproval.v1.ApprovalRequest> getInvalidateApprovalRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InvalidateApprovalRequest",
      requestType = com.google.cloud.accessapproval.v1.InvalidateApprovalRequestMessage.class,
      responseType = com.google.cloud.accessapproval.v1.ApprovalRequest.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.accessapproval.v1.InvalidateApprovalRequestMessage,
      com.google.cloud.accessapproval.v1.ApprovalRequest> getInvalidateApprovalRequestMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.accessapproval.v1.InvalidateApprovalRequestMessage, com.google.cloud.accessapproval.v1.ApprovalRequest> getInvalidateApprovalRequestMethod;
    if ((getInvalidateApprovalRequestMethod = AccessApprovalGrpc.getInvalidateApprovalRequestMethod) == null) {
      synchronized (AccessApprovalGrpc.class) {
        if ((getInvalidateApprovalRequestMethod = AccessApprovalGrpc.getInvalidateApprovalRequestMethod) == null) {
          AccessApprovalGrpc.getInvalidateApprovalRequestMethod = getInvalidateApprovalRequestMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.accessapproval.v1.InvalidateApprovalRequestMessage, com.google.cloud.accessapproval.v1.ApprovalRequest>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "InvalidateApprovalRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.accessapproval.v1.InvalidateApprovalRequestMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.accessapproval.v1.ApprovalRequest.getDefaultInstance()))
              .setSchemaDescriptor(new AccessApprovalMethodDescriptorSupplier("InvalidateApprovalRequest"))
              .build();
        }
      }
    }
    return getInvalidateApprovalRequestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.accessapproval.v1.GetAccessApprovalSettingsMessage,
      com.google.cloud.accessapproval.v1.AccessApprovalSettings> getGetAccessApprovalSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAccessApprovalSettings",
      requestType = com.google.cloud.accessapproval.v1.GetAccessApprovalSettingsMessage.class,
      responseType = com.google.cloud.accessapproval.v1.AccessApprovalSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.accessapproval.v1.GetAccessApprovalSettingsMessage,
      com.google.cloud.accessapproval.v1.AccessApprovalSettings> getGetAccessApprovalSettingsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.accessapproval.v1.GetAccessApprovalSettingsMessage, com.google.cloud.accessapproval.v1.AccessApprovalSettings> getGetAccessApprovalSettingsMethod;
    if ((getGetAccessApprovalSettingsMethod = AccessApprovalGrpc.getGetAccessApprovalSettingsMethod) == null) {
      synchronized (AccessApprovalGrpc.class) {
        if ((getGetAccessApprovalSettingsMethod = AccessApprovalGrpc.getGetAccessApprovalSettingsMethod) == null) {
          AccessApprovalGrpc.getGetAccessApprovalSettingsMethod = getGetAccessApprovalSettingsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.accessapproval.v1.GetAccessApprovalSettingsMessage, com.google.cloud.accessapproval.v1.AccessApprovalSettings>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAccessApprovalSettings"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.accessapproval.v1.GetAccessApprovalSettingsMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.accessapproval.v1.AccessApprovalSettings.getDefaultInstance()))
              .setSchemaDescriptor(new AccessApprovalMethodDescriptorSupplier("GetAccessApprovalSettings"))
              .build();
        }
      }
    }
    return getGetAccessApprovalSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.accessapproval.v1.UpdateAccessApprovalSettingsMessage,
      com.google.cloud.accessapproval.v1.AccessApprovalSettings> getUpdateAccessApprovalSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAccessApprovalSettings",
      requestType = com.google.cloud.accessapproval.v1.UpdateAccessApprovalSettingsMessage.class,
      responseType = com.google.cloud.accessapproval.v1.AccessApprovalSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.accessapproval.v1.UpdateAccessApprovalSettingsMessage,
      com.google.cloud.accessapproval.v1.AccessApprovalSettings> getUpdateAccessApprovalSettingsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.accessapproval.v1.UpdateAccessApprovalSettingsMessage, com.google.cloud.accessapproval.v1.AccessApprovalSettings> getUpdateAccessApprovalSettingsMethod;
    if ((getUpdateAccessApprovalSettingsMethod = AccessApprovalGrpc.getUpdateAccessApprovalSettingsMethod) == null) {
      synchronized (AccessApprovalGrpc.class) {
        if ((getUpdateAccessApprovalSettingsMethod = AccessApprovalGrpc.getUpdateAccessApprovalSettingsMethod) == null) {
          AccessApprovalGrpc.getUpdateAccessApprovalSettingsMethod = getUpdateAccessApprovalSettingsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.accessapproval.v1.UpdateAccessApprovalSettingsMessage, com.google.cloud.accessapproval.v1.AccessApprovalSettings>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAccessApprovalSettings"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.accessapproval.v1.UpdateAccessApprovalSettingsMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.accessapproval.v1.AccessApprovalSettings.getDefaultInstance()))
              .setSchemaDescriptor(new AccessApprovalMethodDescriptorSupplier("UpdateAccessApprovalSettings"))
              .build();
        }
      }
    }
    return getUpdateAccessApprovalSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.accessapproval.v1.DeleteAccessApprovalSettingsMessage,
      com.google.protobuf.Empty> getDeleteAccessApprovalSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAccessApprovalSettings",
      requestType = com.google.cloud.accessapproval.v1.DeleteAccessApprovalSettingsMessage.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.accessapproval.v1.DeleteAccessApprovalSettingsMessage,
      com.google.protobuf.Empty> getDeleteAccessApprovalSettingsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.accessapproval.v1.DeleteAccessApprovalSettingsMessage, com.google.protobuf.Empty> getDeleteAccessApprovalSettingsMethod;
    if ((getDeleteAccessApprovalSettingsMethod = AccessApprovalGrpc.getDeleteAccessApprovalSettingsMethod) == null) {
      synchronized (AccessApprovalGrpc.class) {
        if ((getDeleteAccessApprovalSettingsMethod = AccessApprovalGrpc.getDeleteAccessApprovalSettingsMethod) == null) {
          AccessApprovalGrpc.getDeleteAccessApprovalSettingsMethod = getDeleteAccessApprovalSettingsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.accessapproval.v1.DeleteAccessApprovalSettingsMessage, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAccessApprovalSettings"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.accessapproval.v1.DeleteAccessApprovalSettingsMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new AccessApprovalMethodDescriptorSupplier("DeleteAccessApprovalSettings"))
              .build();
        }
      }
    }
    return getDeleteAccessApprovalSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.accessapproval.v1.GetAccessApprovalServiceAccountMessage,
      com.google.cloud.accessapproval.v1.AccessApprovalServiceAccount> getGetAccessApprovalServiceAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAccessApprovalServiceAccount",
      requestType = com.google.cloud.accessapproval.v1.GetAccessApprovalServiceAccountMessage.class,
      responseType = com.google.cloud.accessapproval.v1.AccessApprovalServiceAccount.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.accessapproval.v1.GetAccessApprovalServiceAccountMessage,
      com.google.cloud.accessapproval.v1.AccessApprovalServiceAccount> getGetAccessApprovalServiceAccountMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.accessapproval.v1.GetAccessApprovalServiceAccountMessage, com.google.cloud.accessapproval.v1.AccessApprovalServiceAccount> getGetAccessApprovalServiceAccountMethod;
    if ((getGetAccessApprovalServiceAccountMethod = AccessApprovalGrpc.getGetAccessApprovalServiceAccountMethod) == null) {
      synchronized (AccessApprovalGrpc.class) {
        if ((getGetAccessApprovalServiceAccountMethod = AccessApprovalGrpc.getGetAccessApprovalServiceAccountMethod) == null) {
          AccessApprovalGrpc.getGetAccessApprovalServiceAccountMethod = getGetAccessApprovalServiceAccountMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.accessapproval.v1.GetAccessApprovalServiceAccountMessage, com.google.cloud.accessapproval.v1.AccessApprovalServiceAccount>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAccessApprovalServiceAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.accessapproval.v1.GetAccessApprovalServiceAccountMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.accessapproval.v1.AccessApprovalServiceAccount.getDefaultInstance()))
              .setSchemaDescriptor(new AccessApprovalMethodDescriptorSupplier("GetAccessApprovalServiceAccount"))
              .build();
        }
      }
    }
    return getGetAccessApprovalServiceAccountMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AccessApprovalStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccessApprovalStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AccessApprovalStub>() {
        @java.lang.Override
        public AccessApprovalStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AccessApprovalStub(channel, callOptions);
        }
      };
    return AccessApprovalStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AccessApprovalBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccessApprovalBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AccessApprovalBlockingStub>() {
        @java.lang.Override
        public AccessApprovalBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AccessApprovalBlockingStub(channel, callOptions);
        }
      };
    return AccessApprovalBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AccessApprovalFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AccessApprovalFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AccessApprovalFutureStub>() {
        @java.lang.Override
        public AccessApprovalFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AccessApprovalFutureStub(channel, callOptions);
        }
      };
    return AccessApprovalFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * This API allows a customer to manage accesses to cloud resources by
   * Google personnel. It defines the following resource model:
   * - The API has a collection of
   *   [ApprovalRequest][google.cloud.accessapproval.v1.ApprovalRequest]
   *   resources, named `approvalRequests/{approval_request}`
   * - The API has top-level settings per Project/Folder/Organization, named
   *   `accessApprovalSettings`
   * The service also periodically emails a list of recipients, defined at the
   * Project/Folder/Organization level in the accessApprovalSettings, when there
   * is a pending ApprovalRequest for them to act on. The ApprovalRequests can
   * also optionally be published to a Pub/Sub topic owned by the customer
   * (contact support if you would like to enable Pub/Sub notifications).
   * ApprovalRequests can be approved or dismissed. Google personnel can only
   * access the indicated resource or resources if the request is approved
   * (subject to some exclusions:
   * https://cloud.google.com/access-approval/docs/overview#exclusions).
   * Note: Using Access Approval functionality will mean that Google may not be
   * able to meet the SLAs for your chosen products, as any support response times
   * may be dramatically increased. As such the SLAs do not apply to any service
   * disruption to the extent impacted by Customer's use of Access Approval. Do
   * not enable Access Approval for projects where you may require high service
   * availability and rapid response by Google Cloud Support.
   * After a request is approved or dismissed, no further action may be taken on
   * it. Requests with the requested_expiration in the past or with no activity
   * for 14 days are considered dismissed. When an approval expires, the request
   * is considered dismissed.
   * If a request is not approved or dismissed, we call it pending.
   * </pre>
   */
  public static abstract class AccessApprovalImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists approval requests associated with a project, folder, or organization.
     * Approval requests can be filtered by state (pending, active, dismissed).
     * The order is reverse chronological.
     * </pre>
     */
    public void listApprovalRequests(com.google.cloud.accessapproval.v1.ListApprovalRequestsMessage request,
        io.grpc.stub.StreamObserver<com.google.cloud.accessapproval.v1.ListApprovalRequestsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListApprovalRequestsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets an approval request. Returns NOT_FOUND if the request does not exist.
     * </pre>
     */
    public void getApprovalRequest(com.google.cloud.accessapproval.v1.GetApprovalRequestMessage request,
        io.grpc.stub.StreamObserver<com.google.cloud.accessapproval.v1.ApprovalRequest> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetApprovalRequestMethod(), responseObserver);
    }

    /**
     * <pre>
     * Approves a request and returns the updated ApprovalRequest.
     * Returns NOT_FOUND if the request does not exist. Returns
     * FAILED_PRECONDITION if the request exists but is not in a pending state.
     * </pre>
     */
    public void approveApprovalRequest(com.google.cloud.accessapproval.v1.ApproveApprovalRequestMessage request,
        io.grpc.stub.StreamObserver<com.google.cloud.accessapproval.v1.ApprovalRequest> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getApproveApprovalRequestMethod(), responseObserver);
    }

    /**
     * <pre>
     * Dismisses a request. Returns the updated ApprovalRequest.
     * NOTE: This does not deny access to the resource if another request has been
     * made and approved. It is equivalent in effect to ignoring the request
     * altogether.
     * Returns NOT_FOUND if the request does not exist.
     * Returns FAILED_PRECONDITION if the request exists but is not in a pending
     * state.
     * </pre>
     */
    public void dismissApprovalRequest(com.google.cloud.accessapproval.v1.DismissApprovalRequestMessage request,
        io.grpc.stub.StreamObserver<com.google.cloud.accessapproval.v1.ApprovalRequest> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDismissApprovalRequestMethod(), responseObserver);
    }

    /**
     * <pre>
     * Invalidates an existing ApprovalRequest. Returns the updated
     * ApprovalRequest.
     * NOTE: This does not deny access to the resource if another request has been
     * made and approved. It only invalidates a single approval.
     * Returns FAILED_PRECONDITION if the request exists but is not in an approved
     * state.
     * </pre>
     */
    public void invalidateApprovalRequest(com.google.cloud.accessapproval.v1.InvalidateApprovalRequestMessage request,
        io.grpc.stub.StreamObserver<com.google.cloud.accessapproval.v1.ApprovalRequest> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getInvalidateApprovalRequestMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the settings associated with a project, folder, or organization.
     * </pre>
     */
    public void getAccessApprovalSettings(com.google.cloud.accessapproval.v1.GetAccessApprovalSettingsMessage request,
        io.grpc.stub.StreamObserver<com.google.cloud.accessapproval.v1.AccessApprovalSettings> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAccessApprovalSettingsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the settings associated with a project, folder, or organization.
     * Settings to update are determined by the value of field_mask.
     * </pre>
     */
    public void updateAccessApprovalSettings(com.google.cloud.accessapproval.v1.UpdateAccessApprovalSettingsMessage request,
        io.grpc.stub.StreamObserver<com.google.cloud.accessapproval.v1.AccessApprovalSettings> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateAccessApprovalSettingsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes the settings associated with a project, folder, or organization.
     * This will have the effect of disabling Access Approval for the project,
     * folder, or organization, but only if all ancestors also have Access
     * Approval disabled. If Access Approval is enabled at a higher level of the
     * hierarchy, then Access Approval will still be enabled at this level as
     * the settings are inherited.
     * </pre>
     */
    public void deleteAccessApprovalSettings(com.google.cloud.accessapproval.v1.DeleteAccessApprovalSettingsMessage request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteAccessApprovalSettingsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Retrieves the service account that is used by Access Approval to access KMS
     * keys for signing approved approval requests.
     * </pre>
     */
    public void getAccessApprovalServiceAccount(com.google.cloud.accessapproval.v1.GetAccessApprovalServiceAccountMessage request,
        io.grpc.stub.StreamObserver<com.google.cloud.accessapproval.v1.AccessApprovalServiceAccount> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAccessApprovalServiceAccountMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListApprovalRequestsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.accessapproval.v1.ListApprovalRequestsMessage,
                com.google.cloud.accessapproval.v1.ListApprovalRequestsResponse>(
                  this, METHODID_LIST_APPROVAL_REQUESTS)))
          .addMethod(
            getGetApprovalRequestMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.accessapproval.v1.GetApprovalRequestMessage,
                com.google.cloud.accessapproval.v1.ApprovalRequest>(
                  this, METHODID_GET_APPROVAL_REQUEST)))
          .addMethod(
            getApproveApprovalRequestMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.accessapproval.v1.ApproveApprovalRequestMessage,
                com.google.cloud.accessapproval.v1.ApprovalRequest>(
                  this, METHODID_APPROVE_APPROVAL_REQUEST)))
          .addMethod(
            getDismissApprovalRequestMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.accessapproval.v1.DismissApprovalRequestMessage,
                com.google.cloud.accessapproval.v1.ApprovalRequest>(
                  this, METHODID_DISMISS_APPROVAL_REQUEST)))
          .addMethod(
            getInvalidateApprovalRequestMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.accessapproval.v1.InvalidateApprovalRequestMessage,
                com.google.cloud.accessapproval.v1.ApprovalRequest>(
                  this, METHODID_INVALIDATE_APPROVAL_REQUEST)))
          .addMethod(
            getGetAccessApprovalSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.accessapproval.v1.GetAccessApprovalSettingsMessage,
                com.google.cloud.accessapproval.v1.AccessApprovalSettings>(
                  this, METHODID_GET_ACCESS_APPROVAL_SETTINGS)))
          .addMethod(
            getUpdateAccessApprovalSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.accessapproval.v1.UpdateAccessApprovalSettingsMessage,
                com.google.cloud.accessapproval.v1.AccessApprovalSettings>(
                  this, METHODID_UPDATE_ACCESS_APPROVAL_SETTINGS)))
          .addMethod(
            getDeleteAccessApprovalSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.accessapproval.v1.DeleteAccessApprovalSettingsMessage,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_ACCESS_APPROVAL_SETTINGS)))
          .addMethod(
            getGetAccessApprovalServiceAccountMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.accessapproval.v1.GetAccessApprovalServiceAccountMessage,
                com.google.cloud.accessapproval.v1.AccessApprovalServiceAccount>(
                  this, METHODID_GET_ACCESS_APPROVAL_SERVICE_ACCOUNT)))
          .build();
    }
  }

  /**
   * <pre>
   * This API allows a customer to manage accesses to cloud resources by
   * Google personnel. It defines the following resource model:
   * - The API has a collection of
   *   [ApprovalRequest][google.cloud.accessapproval.v1.ApprovalRequest]
   *   resources, named `approvalRequests/{approval_request}`
   * - The API has top-level settings per Project/Folder/Organization, named
   *   `accessApprovalSettings`
   * The service also periodically emails a list of recipients, defined at the
   * Project/Folder/Organization level in the accessApprovalSettings, when there
   * is a pending ApprovalRequest for them to act on. The ApprovalRequests can
   * also optionally be published to a Pub/Sub topic owned by the customer
   * (contact support if you would like to enable Pub/Sub notifications).
   * ApprovalRequests can be approved or dismissed. Google personnel can only
   * access the indicated resource or resources if the request is approved
   * (subject to some exclusions:
   * https://cloud.google.com/access-approval/docs/overview#exclusions).
   * Note: Using Access Approval functionality will mean that Google may not be
   * able to meet the SLAs for your chosen products, as any support response times
   * may be dramatically increased. As such the SLAs do not apply to any service
   * disruption to the extent impacted by Customer's use of Access Approval. Do
   * not enable Access Approval for projects where you may require high service
   * availability and rapid response by Google Cloud Support.
   * After a request is approved or dismissed, no further action may be taken on
   * it. Requests with the requested_expiration in the past or with no activity
   * for 14 days are considered dismissed. When an approval expires, the request
   * is considered dismissed.
   * If a request is not approved or dismissed, we call it pending.
   * </pre>
   */
  public static final class AccessApprovalStub extends io.grpc.stub.AbstractAsyncStub<AccessApprovalStub> {
    private AccessApprovalStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccessApprovalStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccessApprovalStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists approval requests associated with a project, folder, or organization.
     * Approval requests can be filtered by state (pending, active, dismissed).
     * The order is reverse chronological.
     * </pre>
     */
    public void listApprovalRequests(com.google.cloud.accessapproval.v1.ListApprovalRequestsMessage request,
        io.grpc.stub.StreamObserver<com.google.cloud.accessapproval.v1.ListApprovalRequestsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListApprovalRequestsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets an approval request. Returns NOT_FOUND if the request does not exist.
     * </pre>
     */
    public void getApprovalRequest(com.google.cloud.accessapproval.v1.GetApprovalRequestMessage request,
        io.grpc.stub.StreamObserver<com.google.cloud.accessapproval.v1.ApprovalRequest> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetApprovalRequestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Approves a request and returns the updated ApprovalRequest.
     * Returns NOT_FOUND if the request does not exist. Returns
     * FAILED_PRECONDITION if the request exists but is not in a pending state.
     * </pre>
     */
    public void approveApprovalRequest(com.google.cloud.accessapproval.v1.ApproveApprovalRequestMessage request,
        io.grpc.stub.StreamObserver<com.google.cloud.accessapproval.v1.ApprovalRequest> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getApproveApprovalRequestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Dismisses a request. Returns the updated ApprovalRequest.
     * NOTE: This does not deny access to the resource if another request has been
     * made and approved. It is equivalent in effect to ignoring the request
     * altogether.
     * Returns NOT_FOUND if the request does not exist.
     * Returns FAILED_PRECONDITION if the request exists but is not in a pending
     * state.
     * </pre>
     */
    public void dismissApprovalRequest(com.google.cloud.accessapproval.v1.DismissApprovalRequestMessage request,
        io.grpc.stub.StreamObserver<com.google.cloud.accessapproval.v1.ApprovalRequest> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDismissApprovalRequestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Invalidates an existing ApprovalRequest. Returns the updated
     * ApprovalRequest.
     * NOTE: This does not deny access to the resource if another request has been
     * made and approved. It only invalidates a single approval.
     * Returns FAILED_PRECONDITION if the request exists but is not in an approved
     * state.
     * </pre>
     */
    public void invalidateApprovalRequest(com.google.cloud.accessapproval.v1.InvalidateApprovalRequestMessage request,
        io.grpc.stub.StreamObserver<com.google.cloud.accessapproval.v1.ApprovalRequest> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInvalidateApprovalRequestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the settings associated with a project, folder, or organization.
     * </pre>
     */
    public void getAccessApprovalSettings(com.google.cloud.accessapproval.v1.GetAccessApprovalSettingsMessage request,
        io.grpc.stub.StreamObserver<com.google.cloud.accessapproval.v1.AccessApprovalSettings> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAccessApprovalSettingsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the settings associated with a project, folder, or organization.
     * Settings to update are determined by the value of field_mask.
     * </pre>
     */
    public void updateAccessApprovalSettings(com.google.cloud.accessapproval.v1.UpdateAccessApprovalSettingsMessage request,
        io.grpc.stub.StreamObserver<com.google.cloud.accessapproval.v1.AccessApprovalSettings> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAccessApprovalSettingsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes the settings associated with a project, folder, or organization.
     * This will have the effect of disabling Access Approval for the project,
     * folder, or organization, but only if all ancestors also have Access
     * Approval disabled. If Access Approval is enabled at a higher level of the
     * hierarchy, then Access Approval will still be enabled at this level as
     * the settings are inherited.
     * </pre>
     */
    public void deleteAccessApprovalSettings(com.google.cloud.accessapproval.v1.DeleteAccessApprovalSettingsMessage request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAccessApprovalSettingsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Retrieves the service account that is used by Access Approval to access KMS
     * keys for signing approved approval requests.
     * </pre>
     */
    public void getAccessApprovalServiceAccount(com.google.cloud.accessapproval.v1.GetAccessApprovalServiceAccountMessage request,
        io.grpc.stub.StreamObserver<com.google.cloud.accessapproval.v1.AccessApprovalServiceAccount> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAccessApprovalServiceAccountMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * This API allows a customer to manage accesses to cloud resources by
   * Google personnel. It defines the following resource model:
   * - The API has a collection of
   *   [ApprovalRequest][google.cloud.accessapproval.v1.ApprovalRequest]
   *   resources, named `approvalRequests/{approval_request}`
   * - The API has top-level settings per Project/Folder/Organization, named
   *   `accessApprovalSettings`
   * The service also periodically emails a list of recipients, defined at the
   * Project/Folder/Organization level in the accessApprovalSettings, when there
   * is a pending ApprovalRequest for them to act on. The ApprovalRequests can
   * also optionally be published to a Pub/Sub topic owned by the customer
   * (contact support if you would like to enable Pub/Sub notifications).
   * ApprovalRequests can be approved or dismissed. Google personnel can only
   * access the indicated resource or resources if the request is approved
   * (subject to some exclusions:
   * https://cloud.google.com/access-approval/docs/overview#exclusions).
   * Note: Using Access Approval functionality will mean that Google may not be
   * able to meet the SLAs for your chosen products, as any support response times
   * may be dramatically increased. As such the SLAs do not apply to any service
   * disruption to the extent impacted by Customer's use of Access Approval. Do
   * not enable Access Approval for projects where you may require high service
   * availability and rapid response by Google Cloud Support.
   * After a request is approved or dismissed, no further action may be taken on
   * it. Requests with the requested_expiration in the past or with no activity
   * for 14 days are considered dismissed. When an approval expires, the request
   * is considered dismissed.
   * If a request is not approved or dismissed, we call it pending.
   * </pre>
   */
  public static final class AccessApprovalBlockingStub extends io.grpc.stub.AbstractBlockingStub<AccessApprovalBlockingStub> {
    private AccessApprovalBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccessApprovalBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccessApprovalBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists approval requests associated with a project, folder, or organization.
     * Approval requests can be filtered by state (pending, active, dismissed).
     * The order is reverse chronological.
     * </pre>
     */
    public com.google.cloud.accessapproval.v1.ListApprovalRequestsResponse listApprovalRequests(com.google.cloud.accessapproval.v1.ListApprovalRequestsMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListApprovalRequestsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets an approval request. Returns NOT_FOUND if the request does not exist.
     * </pre>
     */
    public com.google.cloud.accessapproval.v1.ApprovalRequest getApprovalRequest(com.google.cloud.accessapproval.v1.GetApprovalRequestMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetApprovalRequestMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Approves a request and returns the updated ApprovalRequest.
     * Returns NOT_FOUND if the request does not exist. Returns
     * FAILED_PRECONDITION if the request exists but is not in a pending state.
     * </pre>
     */
    public com.google.cloud.accessapproval.v1.ApprovalRequest approveApprovalRequest(com.google.cloud.accessapproval.v1.ApproveApprovalRequestMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getApproveApprovalRequestMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Dismisses a request. Returns the updated ApprovalRequest.
     * NOTE: This does not deny access to the resource if another request has been
     * made and approved. It is equivalent in effect to ignoring the request
     * altogether.
     * Returns NOT_FOUND if the request does not exist.
     * Returns FAILED_PRECONDITION if the request exists but is not in a pending
     * state.
     * </pre>
     */
    public com.google.cloud.accessapproval.v1.ApprovalRequest dismissApprovalRequest(com.google.cloud.accessapproval.v1.DismissApprovalRequestMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDismissApprovalRequestMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Invalidates an existing ApprovalRequest. Returns the updated
     * ApprovalRequest.
     * NOTE: This does not deny access to the resource if another request has been
     * made and approved. It only invalidates a single approval.
     * Returns FAILED_PRECONDITION if the request exists but is not in an approved
     * state.
     * </pre>
     */
    public com.google.cloud.accessapproval.v1.ApprovalRequest invalidateApprovalRequest(com.google.cloud.accessapproval.v1.InvalidateApprovalRequestMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInvalidateApprovalRequestMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the settings associated with a project, folder, or organization.
     * </pre>
     */
    public com.google.cloud.accessapproval.v1.AccessApprovalSettings getAccessApprovalSettings(com.google.cloud.accessapproval.v1.GetAccessApprovalSettingsMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAccessApprovalSettingsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the settings associated with a project, folder, or organization.
     * Settings to update are determined by the value of field_mask.
     * </pre>
     */
    public com.google.cloud.accessapproval.v1.AccessApprovalSettings updateAccessApprovalSettings(com.google.cloud.accessapproval.v1.UpdateAccessApprovalSettingsMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAccessApprovalSettingsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes the settings associated with a project, folder, or organization.
     * This will have the effect of disabling Access Approval for the project,
     * folder, or organization, but only if all ancestors also have Access
     * Approval disabled. If Access Approval is enabled at a higher level of the
     * hierarchy, then Access Approval will still be enabled at this level as
     * the settings are inherited.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAccessApprovalSettings(com.google.cloud.accessapproval.v1.DeleteAccessApprovalSettingsMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAccessApprovalSettingsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Retrieves the service account that is used by Access Approval to access KMS
     * keys for signing approved approval requests.
     * </pre>
     */
    public com.google.cloud.accessapproval.v1.AccessApprovalServiceAccount getAccessApprovalServiceAccount(com.google.cloud.accessapproval.v1.GetAccessApprovalServiceAccountMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAccessApprovalServiceAccountMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * This API allows a customer to manage accesses to cloud resources by
   * Google personnel. It defines the following resource model:
   * - The API has a collection of
   *   [ApprovalRequest][google.cloud.accessapproval.v1.ApprovalRequest]
   *   resources, named `approvalRequests/{approval_request}`
   * - The API has top-level settings per Project/Folder/Organization, named
   *   `accessApprovalSettings`
   * The service also periodically emails a list of recipients, defined at the
   * Project/Folder/Organization level in the accessApprovalSettings, when there
   * is a pending ApprovalRequest for them to act on. The ApprovalRequests can
   * also optionally be published to a Pub/Sub topic owned by the customer
   * (contact support if you would like to enable Pub/Sub notifications).
   * ApprovalRequests can be approved or dismissed. Google personnel can only
   * access the indicated resource or resources if the request is approved
   * (subject to some exclusions:
   * https://cloud.google.com/access-approval/docs/overview#exclusions).
   * Note: Using Access Approval functionality will mean that Google may not be
   * able to meet the SLAs for your chosen products, as any support response times
   * may be dramatically increased. As such the SLAs do not apply to any service
   * disruption to the extent impacted by Customer's use of Access Approval. Do
   * not enable Access Approval for projects where you may require high service
   * availability and rapid response by Google Cloud Support.
   * After a request is approved or dismissed, no further action may be taken on
   * it. Requests with the requested_expiration in the past or with no activity
   * for 14 days are considered dismissed. When an approval expires, the request
   * is considered dismissed.
   * If a request is not approved or dismissed, we call it pending.
   * </pre>
   */
  public static final class AccessApprovalFutureStub extends io.grpc.stub.AbstractFutureStub<AccessApprovalFutureStub> {
    private AccessApprovalFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccessApprovalFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AccessApprovalFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists approval requests associated with a project, folder, or organization.
     * Approval requests can be filtered by state (pending, active, dismissed).
     * The order is reverse chronological.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.accessapproval.v1.ListApprovalRequestsResponse> listApprovalRequests(
        com.google.cloud.accessapproval.v1.ListApprovalRequestsMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListApprovalRequestsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets an approval request. Returns NOT_FOUND if the request does not exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.accessapproval.v1.ApprovalRequest> getApprovalRequest(
        com.google.cloud.accessapproval.v1.GetApprovalRequestMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetApprovalRequestMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Approves a request and returns the updated ApprovalRequest.
     * Returns NOT_FOUND if the request does not exist. Returns
     * FAILED_PRECONDITION if the request exists but is not in a pending state.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.accessapproval.v1.ApprovalRequest> approveApprovalRequest(
        com.google.cloud.accessapproval.v1.ApproveApprovalRequestMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getApproveApprovalRequestMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Dismisses a request. Returns the updated ApprovalRequest.
     * NOTE: This does not deny access to the resource if another request has been
     * made and approved. It is equivalent in effect to ignoring the request
     * altogether.
     * Returns NOT_FOUND if the request does not exist.
     * Returns FAILED_PRECONDITION if the request exists but is not in a pending
     * state.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.accessapproval.v1.ApprovalRequest> dismissApprovalRequest(
        com.google.cloud.accessapproval.v1.DismissApprovalRequestMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDismissApprovalRequestMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Invalidates an existing ApprovalRequest. Returns the updated
     * ApprovalRequest.
     * NOTE: This does not deny access to the resource if another request has been
     * made and approved. It only invalidates a single approval.
     * Returns FAILED_PRECONDITION if the request exists but is not in an approved
     * state.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.accessapproval.v1.ApprovalRequest> invalidateApprovalRequest(
        com.google.cloud.accessapproval.v1.InvalidateApprovalRequestMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInvalidateApprovalRequestMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the settings associated with a project, folder, or organization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.accessapproval.v1.AccessApprovalSettings> getAccessApprovalSettings(
        com.google.cloud.accessapproval.v1.GetAccessApprovalSettingsMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAccessApprovalSettingsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the settings associated with a project, folder, or organization.
     * Settings to update are determined by the value of field_mask.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.accessapproval.v1.AccessApprovalSettings> updateAccessApprovalSettings(
        com.google.cloud.accessapproval.v1.UpdateAccessApprovalSettingsMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAccessApprovalSettingsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes the settings associated with a project, folder, or organization.
     * This will have the effect of disabling Access Approval for the project,
     * folder, or organization, but only if all ancestors also have Access
     * Approval disabled. If Access Approval is enabled at a higher level of the
     * hierarchy, then Access Approval will still be enabled at this level as
     * the settings are inherited.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteAccessApprovalSettings(
        com.google.cloud.accessapproval.v1.DeleteAccessApprovalSettingsMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAccessApprovalSettingsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Retrieves the service account that is used by Access Approval to access KMS
     * keys for signing approved approval requests.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.accessapproval.v1.AccessApprovalServiceAccount> getAccessApprovalServiceAccount(
        com.google.cloud.accessapproval.v1.GetAccessApprovalServiceAccountMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAccessApprovalServiceAccountMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_APPROVAL_REQUESTS = 0;
  private static final int METHODID_GET_APPROVAL_REQUEST = 1;
  private static final int METHODID_APPROVE_APPROVAL_REQUEST = 2;
  private static final int METHODID_DISMISS_APPROVAL_REQUEST = 3;
  private static final int METHODID_INVALIDATE_APPROVAL_REQUEST = 4;
  private static final int METHODID_GET_ACCESS_APPROVAL_SETTINGS = 5;
  private static final int METHODID_UPDATE_ACCESS_APPROVAL_SETTINGS = 6;
  private static final int METHODID_DELETE_ACCESS_APPROVAL_SETTINGS = 7;
  private static final int METHODID_GET_ACCESS_APPROVAL_SERVICE_ACCOUNT = 8;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AccessApprovalImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AccessApprovalImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_APPROVAL_REQUESTS:
          serviceImpl.listApprovalRequests((com.google.cloud.accessapproval.v1.ListApprovalRequestsMessage) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.accessapproval.v1.ListApprovalRequestsResponse>) responseObserver);
          break;
        case METHODID_GET_APPROVAL_REQUEST:
          serviceImpl.getApprovalRequest((com.google.cloud.accessapproval.v1.GetApprovalRequestMessage) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.accessapproval.v1.ApprovalRequest>) responseObserver);
          break;
        case METHODID_APPROVE_APPROVAL_REQUEST:
          serviceImpl.approveApprovalRequest((com.google.cloud.accessapproval.v1.ApproveApprovalRequestMessage) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.accessapproval.v1.ApprovalRequest>) responseObserver);
          break;
        case METHODID_DISMISS_APPROVAL_REQUEST:
          serviceImpl.dismissApprovalRequest((com.google.cloud.accessapproval.v1.DismissApprovalRequestMessage) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.accessapproval.v1.ApprovalRequest>) responseObserver);
          break;
        case METHODID_INVALIDATE_APPROVAL_REQUEST:
          serviceImpl.invalidateApprovalRequest((com.google.cloud.accessapproval.v1.InvalidateApprovalRequestMessage) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.accessapproval.v1.ApprovalRequest>) responseObserver);
          break;
        case METHODID_GET_ACCESS_APPROVAL_SETTINGS:
          serviceImpl.getAccessApprovalSettings((com.google.cloud.accessapproval.v1.GetAccessApprovalSettingsMessage) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.accessapproval.v1.AccessApprovalSettings>) responseObserver);
          break;
        case METHODID_UPDATE_ACCESS_APPROVAL_SETTINGS:
          serviceImpl.updateAccessApprovalSettings((com.google.cloud.accessapproval.v1.UpdateAccessApprovalSettingsMessage) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.accessapproval.v1.AccessApprovalSettings>) responseObserver);
          break;
        case METHODID_DELETE_ACCESS_APPROVAL_SETTINGS:
          serviceImpl.deleteAccessApprovalSettings((com.google.cloud.accessapproval.v1.DeleteAccessApprovalSettingsMessage) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_ACCESS_APPROVAL_SERVICE_ACCOUNT:
          serviceImpl.getAccessApprovalServiceAccount((com.google.cloud.accessapproval.v1.GetAccessApprovalServiceAccountMessage) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.accessapproval.v1.AccessApprovalServiceAccount>) responseObserver);
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

  private static abstract class AccessApprovalBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AccessApprovalBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.accessapproval.v1.AccessApprovalProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AccessApproval");
    }
  }

  private static final class AccessApprovalFileDescriptorSupplier
      extends AccessApprovalBaseDescriptorSupplier {
    AccessApprovalFileDescriptorSupplier() {}
  }

  private static final class AccessApprovalMethodDescriptorSupplier
      extends AccessApprovalBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AccessApprovalMethodDescriptorSupplier(String methodName) {
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
      synchronized (AccessApprovalGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AccessApprovalFileDescriptorSupplier())
              .addMethod(getListApprovalRequestsMethod())
              .addMethod(getGetApprovalRequestMethod())
              .addMethod(getApproveApprovalRequestMethod())
              .addMethod(getDismissApprovalRequestMethod())
              .addMethod(getInvalidateApprovalRequestMethod())
              .addMethod(getGetAccessApprovalSettingsMethod())
              .addMethod(getUpdateAccessApprovalSettingsMethod())
              .addMethod(getDeleteAccessApprovalSettingsMethod())
              .addMethod(getGetAccessApprovalServiceAccountMethod())
              .build();
        }
      }
    }
    return result;
  }
}
