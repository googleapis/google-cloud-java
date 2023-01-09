package com.google.iam.admin.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Creates and manages Identity and Access Management (IAM) resources.
 * You can use this service to work with all of the following resources:
 * * **Service accounts**, which identify an application or a virtual machine
 *   (VM) instance rather than a person
 * * **Service account keys**, which service accounts use to authenticate with
 *   Google APIs
 * * **IAM policies for service accounts**, which specify the roles that a
 *   principal has for the service account
 * * **IAM custom roles**, which help you limit the number of permissions that
 *   you grant to principals
 * In addition, you can use this service to complete the following tasks, among
 * others:
 * * Test whether a service account can use specific permissions
 * * Check which roles you can grant for a specific resource
 * * Lint, or validate, condition expressions in an IAM policy
 * When you read data from the IAM API, each read is eventually consistent. In
 * other words, if you write data with the IAM API, then immediately read that
 * data, the read operation might return an older version of the data. To deal
 * with this behavior, your application can retry the request with truncated
 * exponential backoff.
 * In contrast, writing data to the IAM API is sequentially consistent. In other
 * words, write operations are always processed in the order in which they were
 * received.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/iam/admin/v1/iam.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class IAMGrpc {

  private IAMGrpc() {}

  public static final String SERVICE_NAME = "google.iam.admin.v1.IAM";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.iam.admin.v1.ListServiceAccountsRequest,
      com.google.iam.admin.v1.ListServiceAccountsResponse> getListServiceAccountsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListServiceAccounts",
      requestType = com.google.iam.admin.v1.ListServiceAccountsRequest.class,
      responseType = com.google.iam.admin.v1.ListServiceAccountsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.admin.v1.ListServiceAccountsRequest,
      com.google.iam.admin.v1.ListServiceAccountsResponse> getListServiceAccountsMethod() {
    io.grpc.MethodDescriptor<com.google.iam.admin.v1.ListServiceAccountsRequest, com.google.iam.admin.v1.ListServiceAccountsResponse> getListServiceAccountsMethod;
    if ((getListServiceAccountsMethod = IAMGrpc.getListServiceAccountsMethod) == null) {
      synchronized (IAMGrpc.class) {
        if ((getListServiceAccountsMethod = IAMGrpc.getListServiceAccountsMethod) == null) {
          IAMGrpc.getListServiceAccountsMethod = getListServiceAccountsMethod =
              io.grpc.MethodDescriptor.<com.google.iam.admin.v1.ListServiceAccountsRequest, com.google.iam.admin.v1.ListServiceAccountsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListServiceAccounts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.ListServiceAccountsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.ListServiceAccountsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new IAMMethodDescriptorSupplier("ListServiceAccounts"))
              .build();
        }
      }
    }
    return getListServiceAccountsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.admin.v1.GetServiceAccountRequest,
      com.google.iam.admin.v1.ServiceAccount> getGetServiceAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetServiceAccount",
      requestType = com.google.iam.admin.v1.GetServiceAccountRequest.class,
      responseType = com.google.iam.admin.v1.ServiceAccount.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.admin.v1.GetServiceAccountRequest,
      com.google.iam.admin.v1.ServiceAccount> getGetServiceAccountMethod() {
    io.grpc.MethodDescriptor<com.google.iam.admin.v1.GetServiceAccountRequest, com.google.iam.admin.v1.ServiceAccount> getGetServiceAccountMethod;
    if ((getGetServiceAccountMethod = IAMGrpc.getGetServiceAccountMethod) == null) {
      synchronized (IAMGrpc.class) {
        if ((getGetServiceAccountMethod = IAMGrpc.getGetServiceAccountMethod) == null) {
          IAMGrpc.getGetServiceAccountMethod = getGetServiceAccountMethod =
              io.grpc.MethodDescriptor.<com.google.iam.admin.v1.GetServiceAccountRequest, com.google.iam.admin.v1.ServiceAccount>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetServiceAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.GetServiceAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.ServiceAccount.getDefaultInstance()))
              .setSchemaDescriptor(new IAMMethodDescriptorSupplier("GetServiceAccount"))
              .build();
        }
      }
    }
    return getGetServiceAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.admin.v1.CreateServiceAccountRequest,
      com.google.iam.admin.v1.ServiceAccount> getCreateServiceAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateServiceAccount",
      requestType = com.google.iam.admin.v1.CreateServiceAccountRequest.class,
      responseType = com.google.iam.admin.v1.ServiceAccount.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.admin.v1.CreateServiceAccountRequest,
      com.google.iam.admin.v1.ServiceAccount> getCreateServiceAccountMethod() {
    io.grpc.MethodDescriptor<com.google.iam.admin.v1.CreateServiceAccountRequest, com.google.iam.admin.v1.ServiceAccount> getCreateServiceAccountMethod;
    if ((getCreateServiceAccountMethod = IAMGrpc.getCreateServiceAccountMethod) == null) {
      synchronized (IAMGrpc.class) {
        if ((getCreateServiceAccountMethod = IAMGrpc.getCreateServiceAccountMethod) == null) {
          IAMGrpc.getCreateServiceAccountMethod = getCreateServiceAccountMethod =
              io.grpc.MethodDescriptor.<com.google.iam.admin.v1.CreateServiceAccountRequest, com.google.iam.admin.v1.ServiceAccount>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateServiceAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.CreateServiceAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.ServiceAccount.getDefaultInstance()))
              .setSchemaDescriptor(new IAMMethodDescriptorSupplier("CreateServiceAccount"))
              .build();
        }
      }
    }
    return getCreateServiceAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.admin.v1.ServiceAccount,
      com.google.iam.admin.v1.ServiceAccount> getUpdateServiceAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateServiceAccount",
      requestType = com.google.iam.admin.v1.ServiceAccount.class,
      responseType = com.google.iam.admin.v1.ServiceAccount.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.admin.v1.ServiceAccount,
      com.google.iam.admin.v1.ServiceAccount> getUpdateServiceAccountMethod() {
    io.grpc.MethodDescriptor<com.google.iam.admin.v1.ServiceAccount, com.google.iam.admin.v1.ServiceAccount> getUpdateServiceAccountMethod;
    if ((getUpdateServiceAccountMethod = IAMGrpc.getUpdateServiceAccountMethod) == null) {
      synchronized (IAMGrpc.class) {
        if ((getUpdateServiceAccountMethod = IAMGrpc.getUpdateServiceAccountMethod) == null) {
          IAMGrpc.getUpdateServiceAccountMethod = getUpdateServiceAccountMethod =
              io.grpc.MethodDescriptor.<com.google.iam.admin.v1.ServiceAccount, com.google.iam.admin.v1.ServiceAccount>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateServiceAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.ServiceAccount.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.ServiceAccount.getDefaultInstance()))
              .setSchemaDescriptor(new IAMMethodDescriptorSupplier("UpdateServiceAccount"))
              .build();
        }
      }
    }
    return getUpdateServiceAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.admin.v1.PatchServiceAccountRequest,
      com.google.iam.admin.v1.ServiceAccount> getPatchServiceAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PatchServiceAccount",
      requestType = com.google.iam.admin.v1.PatchServiceAccountRequest.class,
      responseType = com.google.iam.admin.v1.ServiceAccount.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.admin.v1.PatchServiceAccountRequest,
      com.google.iam.admin.v1.ServiceAccount> getPatchServiceAccountMethod() {
    io.grpc.MethodDescriptor<com.google.iam.admin.v1.PatchServiceAccountRequest, com.google.iam.admin.v1.ServiceAccount> getPatchServiceAccountMethod;
    if ((getPatchServiceAccountMethod = IAMGrpc.getPatchServiceAccountMethod) == null) {
      synchronized (IAMGrpc.class) {
        if ((getPatchServiceAccountMethod = IAMGrpc.getPatchServiceAccountMethod) == null) {
          IAMGrpc.getPatchServiceAccountMethod = getPatchServiceAccountMethod =
              io.grpc.MethodDescriptor.<com.google.iam.admin.v1.PatchServiceAccountRequest, com.google.iam.admin.v1.ServiceAccount>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PatchServiceAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.PatchServiceAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.ServiceAccount.getDefaultInstance()))
              .setSchemaDescriptor(new IAMMethodDescriptorSupplier("PatchServiceAccount"))
              .build();
        }
      }
    }
    return getPatchServiceAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.admin.v1.DeleteServiceAccountRequest,
      com.google.protobuf.Empty> getDeleteServiceAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteServiceAccount",
      requestType = com.google.iam.admin.v1.DeleteServiceAccountRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.admin.v1.DeleteServiceAccountRequest,
      com.google.protobuf.Empty> getDeleteServiceAccountMethod() {
    io.grpc.MethodDescriptor<com.google.iam.admin.v1.DeleteServiceAccountRequest, com.google.protobuf.Empty> getDeleteServiceAccountMethod;
    if ((getDeleteServiceAccountMethod = IAMGrpc.getDeleteServiceAccountMethod) == null) {
      synchronized (IAMGrpc.class) {
        if ((getDeleteServiceAccountMethod = IAMGrpc.getDeleteServiceAccountMethod) == null) {
          IAMGrpc.getDeleteServiceAccountMethod = getDeleteServiceAccountMethod =
              io.grpc.MethodDescriptor.<com.google.iam.admin.v1.DeleteServiceAccountRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteServiceAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.DeleteServiceAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new IAMMethodDescriptorSupplier("DeleteServiceAccount"))
              .build();
        }
      }
    }
    return getDeleteServiceAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.admin.v1.UndeleteServiceAccountRequest,
      com.google.iam.admin.v1.UndeleteServiceAccountResponse> getUndeleteServiceAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UndeleteServiceAccount",
      requestType = com.google.iam.admin.v1.UndeleteServiceAccountRequest.class,
      responseType = com.google.iam.admin.v1.UndeleteServiceAccountResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.admin.v1.UndeleteServiceAccountRequest,
      com.google.iam.admin.v1.UndeleteServiceAccountResponse> getUndeleteServiceAccountMethod() {
    io.grpc.MethodDescriptor<com.google.iam.admin.v1.UndeleteServiceAccountRequest, com.google.iam.admin.v1.UndeleteServiceAccountResponse> getUndeleteServiceAccountMethod;
    if ((getUndeleteServiceAccountMethod = IAMGrpc.getUndeleteServiceAccountMethod) == null) {
      synchronized (IAMGrpc.class) {
        if ((getUndeleteServiceAccountMethod = IAMGrpc.getUndeleteServiceAccountMethod) == null) {
          IAMGrpc.getUndeleteServiceAccountMethod = getUndeleteServiceAccountMethod =
              io.grpc.MethodDescriptor.<com.google.iam.admin.v1.UndeleteServiceAccountRequest, com.google.iam.admin.v1.UndeleteServiceAccountResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UndeleteServiceAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.UndeleteServiceAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.UndeleteServiceAccountResponse.getDefaultInstance()))
              .setSchemaDescriptor(new IAMMethodDescriptorSupplier("UndeleteServiceAccount"))
              .build();
        }
      }
    }
    return getUndeleteServiceAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.admin.v1.EnableServiceAccountRequest,
      com.google.protobuf.Empty> getEnableServiceAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EnableServiceAccount",
      requestType = com.google.iam.admin.v1.EnableServiceAccountRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.admin.v1.EnableServiceAccountRequest,
      com.google.protobuf.Empty> getEnableServiceAccountMethod() {
    io.grpc.MethodDescriptor<com.google.iam.admin.v1.EnableServiceAccountRequest, com.google.protobuf.Empty> getEnableServiceAccountMethod;
    if ((getEnableServiceAccountMethod = IAMGrpc.getEnableServiceAccountMethod) == null) {
      synchronized (IAMGrpc.class) {
        if ((getEnableServiceAccountMethod = IAMGrpc.getEnableServiceAccountMethod) == null) {
          IAMGrpc.getEnableServiceAccountMethod = getEnableServiceAccountMethod =
              io.grpc.MethodDescriptor.<com.google.iam.admin.v1.EnableServiceAccountRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EnableServiceAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.EnableServiceAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new IAMMethodDescriptorSupplier("EnableServiceAccount"))
              .build();
        }
      }
    }
    return getEnableServiceAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.admin.v1.DisableServiceAccountRequest,
      com.google.protobuf.Empty> getDisableServiceAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DisableServiceAccount",
      requestType = com.google.iam.admin.v1.DisableServiceAccountRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.admin.v1.DisableServiceAccountRequest,
      com.google.protobuf.Empty> getDisableServiceAccountMethod() {
    io.grpc.MethodDescriptor<com.google.iam.admin.v1.DisableServiceAccountRequest, com.google.protobuf.Empty> getDisableServiceAccountMethod;
    if ((getDisableServiceAccountMethod = IAMGrpc.getDisableServiceAccountMethod) == null) {
      synchronized (IAMGrpc.class) {
        if ((getDisableServiceAccountMethod = IAMGrpc.getDisableServiceAccountMethod) == null) {
          IAMGrpc.getDisableServiceAccountMethod = getDisableServiceAccountMethod =
              io.grpc.MethodDescriptor.<com.google.iam.admin.v1.DisableServiceAccountRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DisableServiceAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.DisableServiceAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new IAMMethodDescriptorSupplier("DisableServiceAccount"))
              .build();
        }
      }
    }
    return getDisableServiceAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.admin.v1.ListServiceAccountKeysRequest,
      com.google.iam.admin.v1.ListServiceAccountKeysResponse> getListServiceAccountKeysMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListServiceAccountKeys",
      requestType = com.google.iam.admin.v1.ListServiceAccountKeysRequest.class,
      responseType = com.google.iam.admin.v1.ListServiceAccountKeysResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.admin.v1.ListServiceAccountKeysRequest,
      com.google.iam.admin.v1.ListServiceAccountKeysResponse> getListServiceAccountKeysMethod() {
    io.grpc.MethodDescriptor<com.google.iam.admin.v1.ListServiceAccountKeysRequest, com.google.iam.admin.v1.ListServiceAccountKeysResponse> getListServiceAccountKeysMethod;
    if ((getListServiceAccountKeysMethod = IAMGrpc.getListServiceAccountKeysMethod) == null) {
      synchronized (IAMGrpc.class) {
        if ((getListServiceAccountKeysMethod = IAMGrpc.getListServiceAccountKeysMethod) == null) {
          IAMGrpc.getListServiceAccountKeysMethod = getListServiceAccountKeysMethod =
              io.grpc.MethodDescriptor.<com.google.iam.admin.v1.ListServiceAccountKeysRequest, com.google.iam.admin.v1.ListServiceAccountKeysResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListServiceAccountKeys"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.ListServiceAccountKeysRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.ListServiceAccountKeysResponse.getDefaultInstance()))
              .setSchemaDescriptor(new IAMMethodDescriptorSupplier("ListServiceAccountKeys"))
              .build();
        }
      }
    }
    return getListServiceAccountKeysMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.admin.v1.GetServiceAccountKeyRequest,
      com.google.iam.admin.v1.ServiceAccountKey> getGetServiceAccountKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetServiceAccountKey",
      requestType = com.google.iam.admin.v1.GetServiceAccountKeyRequest.class,
      responseType = com.google.iam.admin.v1.ServiceAccountKey.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.admin.v1.GetServiceAccountKeyRequest,
      com.google.iam.admin.v1.ServiceAccountKey> getGetServiceAccountKeyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.admin.v1.GetServiceAccountKeyRequest, com.google.iam.admin.v1.ServiceAccountKey> getGetServiceAccountKeyMethod;
    if ((getGetServiceAccountKeyMethod = IAMGrpc.getGetServiceAccountKeyMethod) == null) {
      synchronized (IAMGrpc.class) {
        if ((getGetServiceAccountKeyMethod = IAMGrpc.getGetServiceAccountKeyMethod) == null) {
          IAMGrpc.getGetServiceAccountKeyMethod = getGetServiceAccountKeyMethod =
              io.grpc.MethodDescriptor.<com.google.iam.admin.v1.GetServiceAccountKeyRequest, com.google.iam.admin.v1.ServiceAccountKey>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetServiceAccountKey"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.GetServiceAccountKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.ServiceAccountKey.getDefaultInstance()))
              .setSchemaDescriptor(new IAMMethodDescriptorSupplier("GetServiceAccountKey"))
              .build();
        }
      }
    }
    return getGetServiceAccountKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.admin.v1.CreateServiceAccountKeyRequest,
      com.google.iam.admin.v1.ServiceAccountKey> getCreateServiceAccountKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateServiceAccountKey",
      requestType = com.google.iam.admin.v1.CreateServiceAccountKeyRequest.class,
      responseType = com.google.iam.admin.v1.ServiceAccountKey.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.admin.v1.CreateServiceAccountKeyRequest,
      com.google.iam.admin.v1.ServiceAccountKey> getCreateServiceAccountKeyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.admin.v1.CreateServiceAccountKeyRequest, com.google.iam.admin.v1.ServiceAccountKey> getCreateServiceAccountKeyMethod;
    if ((getCreateServiceAccountKeyMethod = IAMGrpc.getCreateServiceAccountKeyMethod) == null) {
      synchronized (IAMGrpc.class) {
        if ((getCreateServiceAccountKeyMethod = IAMGrpc.getCreateServiceAccountKeyMethod) == null) {
          IAMGrpc.getCreateServiceAccountKeyMethod = getCreateServiceAccountKeyMethod =
              io.grpc.MethodDescriptor.<com.google.iam.admin.v1.CreateServiceAccountKeyRequest, com.google.iam.admin.v1.ServiceAccountKey>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateServiceAccountKey"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.CreateServiceAccountKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.ServiceAccountKey.getDefaultInstance()))
              .setSchemaDescriptor(new IAMMethodDescriptorSupplier("CreateServiceAccountKey"))
              .build();
        }
      }
    }
    return getCreateServiceAccountKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.admin.v1.UploadServiceAccountKeyRequest,
      com.google.iam.admin.v1.ServiceAccountKey> getUploadServiceAccountKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UploadServiceAccountKey",
      requestType = com.google.iam.admin.v1.UploadServiceAccountKeyRequest.class,
      responseType = com.google.iam.admin.v1.ServiceAccountKey.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.admin.v1.UploadServiceAccountKeyRequest,
      com.google.iam.admin.v1.ServiceAccountKey> getUploadServiceAccountKeyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.admin.v1.UploadServiceAccountKeyRequest, com.google.iam.admin.v1.ServiceAccountKey> getUploadServiceAccountKeyMethod;
    if ((getUploadServiceAccountKeyMethod = IAMGrpc.getUploadServiceAccountKeyMethod) == null) {
      synchronized (IAMGrpc.class) {
        if ((getUploadServiceAccountKeyMethod = IAMGrpc.getUploadServiceAccountKeyMethod) == null) {
          IAMGrpc.getUploadServiceAccountKeyMethod = getUploadServiceAccountKeyMethod =
              io.grpc.MethodDescriptor.<com.google.iam.admin.v1.UploadServiceAccountKeyRequest, com.google.iam.admin.v1.ServiceAccountKey>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UploadServiceAccountKey"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.UploadServiceAccountKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.ServiceAccountKey.getDefaultInstance()))
              .setSchemaDescriptor(new IAMMethodDescriptorSupplier("UploadServiceAccountKey"))
              .build();
        }
      }
    }
    return getUploadServiceAccountKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.admin.v1.DeleteServiceAccountKeyRequest,
      com.google.protobuf.Empty> getDeleteServiceAccountKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteServiceAccountKey",
      requestType = com.google.iam.admin.v1.DeleteServiceAccountKeyRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.admin.v1.DeleteServiceAccountKeyRequest,
      com.google.protobuf.Empty> getDeleteServiceAccountKeyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.admin.v1.DeleteServiceAccountKeyRequest, com.google.protobuf.Empty> getDeleteServiceAccountKeyMethod;
    if ((getDeleteServiceAccountKeyMethod = IAMGrpc.getDeleteServiceAccountKeyMethod) == null) {
      synchronized (IAMGrpc.class) {
        if ((getDeleteServiceAccountKeyMethod = IAMGrpc.getDeleteServiceAccountKeyMethod) == null) {
          IAMGrpc.getDeleteServiceAccountKeyMethod = getDeleteServiceAccountKeyMethod =
              io.grpc.MethodDescriptor.<com.google.iam.admin.v1.DeleteServiceAccountKeyRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteServiceAccountKey"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.DeleteServiceAccountKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new IAMMethodDescriptorSupplier("DeleteServiceAccountKey"))
              .build();
        }
      }
    }
    return getDeleteServiceAccountKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.admin.v1.DisableServiceAccountKeyRequest,
      com.google.protobuf.Empty> getDisableServiceAccountKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DisableServiceAccountKey",
      requestType = com.google.iam.admin.v1.DisableServiceAccountKeyRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.admin.v1.DisableServiceAccountKeyRequest,
      com.google.protobuf.Empty> getDisableServiceAccountKeyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.admin.v1.DisableServiceAccountKeyRequest, com.google.protobuf.Empty> getDisableServiceAccountKeyMethod;
    if ((getDisableServiceAccountKeyMethod = IAMGrpc.getDisableServiceAccountKeyMethod) == null) {
      synchronized (IAMGrpc.class) {
        if ((getDisableServiceAccountKeyMethod = IAMGrpc.getDisableServiceAccountKeyMethod) == null) {
          IAMGrpc.getDisableServiceAccountKeyMethod = getDisableServiceAccountKeyMethod =
              io.grpc.MethodDescriptor.<com.google.iam.admin.v1.DisableServiceAccountKeyRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DisableServiceAccountKey"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.DisableServiceAccountKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new IAMMethodDescriptorSupplier("DisableServiceAccountKey"))
              .build();
        }
      }
    }
    return getDisableServiceAccountKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.admin.v1.EnableServiceAccountKeyRequest,
      com.google.protobuf.Empty> getEnableServiceAccountKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EnableServiceAccountKey",
      requestType = com.google.iam.admin.v1.EnableServiceAccountKeyRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.admin.v1.EnableServiceAccountKeyRequest,
      com.google.protobuf.Empty> getEnableServiceAccountKeyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.admin.v1.EnableServiceAccountKeyRequest, com.google.protobuf.Empty> getEnableServiceAccountKeyMethod;
    if ((getEnableServiceAccountKeyMethod = IAMGrpc.getEnableServiceAccountKeyMethod) == null) {
      synchronized (IAMGrpc.class) {
        if ((getEnableServiceAccountKeyMethod = IAMGrpc.getEnableServiceAccountKeyMethod) == null) {
          IAMGrpc.getEnableServiceAccountKeyMethod = getEnableServiceAccountKeyMethod =
              io.grpc.MethodDescriptor.<com.google.iam.admin.v1.EnableServiceAccountKeyRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EnableServiceAccountKey"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.EnableServiceAccountKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new IAMMethodDescriptorSupplier("EnableServiceAccountKey"))
              .build();
        }
      }
    }
    return getEnableServiceAccountKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.admin.v1.SignBlobRequest,
      com.google.iam.admin.v1.SignBlobResponse> getSignBlobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SignBlob",
      requestType = com.google.iam.admin.v1.SignBlobRequest.class,
      responseType = com.google.iam.admin.v1.SignBlobResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.admin.v1.SignBlobRequest,
      com.google.iam.admin.v1.SignBlobResponse> getSignBlobMethod() {
    io.grpc.MethodDescriptor<com.google.iam.admin.v1.SignBlobRequest, com.google.iam.admin.v1.SignBlobResponse> getSignBlobMethod;
    if ((getSignBlobMethod = IAMGrpc.getSignBlobMethod) == null) {
      synchronized (IAMGrpc.class) {
        if ((getSignBlobMethod = IAMGrpc.getSignBlobMethod) == null) {
          IAMGrpc.getSignBlobMethod = getSignBlobMethod =
              io.grpc.MethodDescriptor.<com.google.iam.admin.v1.SignBlobRequest, com.google.iam.admin.v1.SignBlobResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SignBlob"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.SignBlobRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.SignBlobResponse.getDefaultInstance()))
              .setSchemaDescriptor(new IAMMethodDescriptorSupplier("SignBlob"))
              .build();
        }
      }
    }
    return getSignBlobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.admin.v1.SignJwtRequest,
      com.google.iam.admin.v1.SignJwtResponse> getSignJwtMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SignJwt",
      requestType = com.google.iam.admin.v1.SignJwtRequest.class,
      responseType = com.google.iam.admin.v1.SignJwtResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.admin.v1.SignJwtRequest,
      com.google.iam.admin.v1.SignJwtResponse> getSignJwtMethod() {
    io.grpc.MethodDescriptor<com.google.iam.admin.v1.SignJwtRequest, com.google.iam.admin.v1.SignJwtResponse> getSignJwtMethod;
    if ((getSignJwtMethod = IAMGrpc.getSignJwtMethod) == null) {
      synchronized (IAMGrpc.class) {
        if ((getSignJwtMethod = IAMGrpc.getSignJwtMethod) == null) {
          IAMGrpc.getSignJwtMethod = getSignJwtMethod =
              io.grpc.MethodDescriptor.<com.google.iam.admin.v1.SignJwtRequest, com.google.iam.admin.v1.SignJwtResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SignJwt"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.SignJwtRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.SignJwtResponse.getDefaultInstance()))
              .setSchemaDescriptor(new IAMMethodDescriptorSupplier("SignJwt"))
              .build();
        }
      }
    }
    return getSignJwtMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest,
      com.google.iam.v1.Policy> getGetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIamPolicy",
      requestType = com.google.iam.v1.GetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest,
      com.google.iam.v1.Policy> getGetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy> getGetIamPolicyMethod;
    if ((getGetIamPolicyMethod = IAMGrpc.getGetIamPolicyMethod) == null) {
      synchronized (IAMGrpc.class) {
        if ((getGetIamPolicyMethod = IAMGrpc.getGetIamPolicyMethod) == null) {
          IAMGrpc.getGetIamPolicyMethod = getGetIamPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIamPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.GetIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.Policy.getDefaultInstance()))
              .setSchemaDescriptor(new IAMMethodDescriptorSupplier("GetIamPolicy"))
              .build();
        }
      }
    }
    return getGetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest,
      com.google.iam.v1.Policy> getSetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetIamPolicy",
      requestType = com.google.iam.v1.SetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest,
      com.google.iam.v1.Policy> getSetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy> getSetIamPolicyMethod;
    if ((getSetIamPolicyMethod = IAMGrpc.getSetIamPolicyMethod) == null) {
      synchronized (IAMGrpc.class) {
        if ((getSetIamPolicyMethod = IAMGrpc.getSetIamPolicyMethod) == null) {
          IAMGrpc.getSetIamPolicyMethod = getSetIamPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetIamPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.SetIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.Policy.getDefaultInstance()))
              .setSchemaDescriptor(new IAMMethodDescriptorSupplier("SetIamPolicy"))
              .build();
        }
      }
    }
    return getSetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest,
      com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TestIamPermissions",
      requestType = com.google.iam.v1.TestIamPermissionsRequest.class,
      responseType = com.google.iam.v1.TestIamPermissionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest,
      com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethod;
    if ((getTestIamPermissionsMethod = IAMGrpc.getTestIamPermissionsMethod) == null) {
      synchronized (IAMGrpc.class) {
        if ((getTestIamPermissionsMethod = IAMGrpc.getTestIamPermissionsMethod) == null) {
          IAMGrpc.getTestIamPermissionsMethod = getTestIamPermissionsMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TestIamPermissions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.TestIamPermissionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new IAMMethodDescriptorSupplier("TestIamPermissions"))
              .build();
        }
      }
    }
    return getTestIamPermissionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.admin.v1.QueryGrantableRolesRequest,
      com.google.iam.admin.v1.QueryGrantableRolesResponse> getQueryGrantableRolesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QueryGrantableRoles",
      requestType = com.google.iam.admin.v1.QueryGrantableRolesRequest.class,
      responseType = com.google.iam.admin.v1.QueryGrantableRolesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.admin.v1.QueryGrantableRolesRequest,
      com.google.iam.admin.v1.QueryGrantableRolesResponse> getQueryGrantableRolesMethod() {
    io.grpc.MethodDescriptor<com.google.iam.admin.v1.QueryGrantableRolesRequest, com.google.iam.admin.v1.QueryGrantableRolesResponse> getQueryGrantableRolesMethod;
    if ((getQueryGrantableRolesMethod = IAMGrpc.getQueryGrantableRolesMethod) == null) {
      synchronized (IAMGrpc.class) {
        if ((getQueryGrantableRolesMethod = IAMGrpc.getQueryGrantableRolesMethod) == null) {
          IAMGrpc.getQueryGrantableRolesMethod = getQueryGrantableRolesMethod =
              io.grpc.MethodDescriptor.<com.google.iam.admin.v1.QueryGrantableRolesRequest, com.google.iam.admin.v1.QueryGrantableRolesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "QueryGrantableRoles"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.QueryGrantableRolesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.QueryGrantableRolesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new IAMMethodDescriptorSupplier("QueryGrantableRoles"))
              .build();
        }
      }
    }
    return getQueryGrantableRolesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.admin.v1.ListRolesRequest,
      com.google.iam.admin.v1.ListRolesResponse> getListRolesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRoles",
      requestType = com.google.iam.admin.v1.ListRolesRequest.class,
      responseType = com.google.iam.admin.v1.ListRolesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.admin.v1.ListRolesRequest,
      com.google.iam.admin.v1.ListRolesResponse> getListRolesMethod() {
    io.grpc.MethodDescriptor<com.google.iam.admin.v1.ListRolesRequest, com.google.iam.admin.v1.ListRolesResponse> getListRolesMethod;
    if ((getListRolesMethod = IAMGrpc.getListRolesMethod) == null) {
      synchronized (IAMGrpc.class) {
        if ((getListRolesMethod = IAMGrpc.getListRolesMethod) == null) {
          IAMGrpc.getListRolesMethod = getListRolesMethod =
              io.grpc.MethodDescriptor.<com.google.iam.admin.v1.ListRolesRequest, com.google.iam.admin.v1.ListRolesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRoles"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.ListRolesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.ListRolesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new IAMMethodDescriptorSupplier("ListRoles"))
              .build();
        }
      }
    }
    return getListRolesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.admin.v1.GetRoleRequest,
      com.google.iam.admin.v1.Role> getGetRoleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRole",
      requestType = com.google.iam.admin.v1.GetRoleRequest.class,
      responseType = com.google.iam.admin.v1.Role.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.admin.v1.GetRoleRequest,
      com.google.iam.admin.v1.Role> getGetRoleMethod() {
    io.grpc.MethodDescriptor<com.google.iam.admin.v1.GetRoleRequest, com.google.iam.admin.v1.Role> getGetRoleMethod;
    if ((getGetRoleMethod = IAMGrpc.getGetRoleMethod) == null) {
      synchronized (IAMGrpc.class) {
        if ((getGetRoleMethod = IAMGrpc.getGetRoleMethod) == null) {
          IAMGrpc.getGetRoleMethod = getGetRoleMethod =
              io.grpc.MethodDescriptor.<com.google.iam.admin.v1.GetRoleRequest, com.google.iam.admin.v1.Role>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRole"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.GetRoleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.Role.getDefaultInstance()))
              .setSchemaDescriptor(new IAMMethodDescriptorSupplier("GetRole"))
              .build();
        }
      }
    }
    return getGetRoleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.admin.v1.CreateRoleRequest,
      com.google.iam.admin.v1.Role> getCreateRoleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRole",
      requestType = com.google.iam.admin.v1.CreateRoleRequest.class,
      responseType = com.google.iam.admin.v1.Role.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.admin.v1.CreateRoleRequest,
      com.google.iam.admin.v1.Role> getCreateRoleMethod() {
    io.grpc.MethodDescriptor<com.google.iam.admin.v1.CreateRoleRequest, com.google.iam.admin.v1.Role> getCreateRoleMethod;
    if ((getCreateRoleMethod = IAMGrpc.getCreateRoleMethod) == null) {
      synchronized (IAMGrpc.class) {
        if ((getCreateRoleMethod = IAMGrpc.getCreateRoleMethod) == null) {
          IAMGrpc.getCreateRoleMethod = getCreateRoleMethod =
              io.grpc.MethodDescriptor.<com.google.iam.admin.v1.CreateRoleRequest, com.google.iam.admin.v1.Role>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateRole"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.CreateRoleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.Role.getDefaultInstance()))
              .setSchemaDescriptor(new IAMMethodDescriptorSupplier("CreateRole"))
              .build();
        }
      }
    }
    return getCreateRoleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.admin.v1.UpdateRoleRequest,
      com.google.iam.admin.v1.Role> getUpdateRoleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateRole",
      requestType = com.google.iam.admin.v1.UpdateRoleRequest.class,
      responseType = com.google.iam.admin.v1.Role.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.admin.v1.UpdateRoleRequest,
      com.google.iam.admin.v1.Role> getUpdateRoleMethod() {
    io.grpc.MethodDescriptor<com.google.iam.admin.v1.UpdateRoleRequest, com.google.iam.admin.v1.Role> getUpdateRoleMethod;
    if ((getUpdateRoleMethod = IAMGrpc.getUpdateRoleMethod) == null) {
      synchronized (IAMGrpc.class) {
        if ((getUpdateRoleMethod = IAMGrpc.getUpdateRoleMethod) == null) {
          IAMGrpc.getUpdateRoleMethod = getUpdateRoleMethod =
              io.grpc.MethodDescriptor.<com.google.iam.admin.v1.UpdateRoleRequest, com.google.iam.admin.v1.Role>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateRole"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.UpdateRoleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.Role.getDefaultInstance()))
              .setSchemaDescriptor(new IAMMethodDescriptorSupplier("UpdateRole"))
              .build();
        }
      }
    }
    return getUpdateRoleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.admin.v1.DeleteRoleRequest,
      com.google.iam.admin.v1.Role> getDeleteRoleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRole",
      requestType = com.google.iam.admin.v1.DeleteRoleRequest.class,
      responseType = com.google.iam.admin.v1.Role.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.admin.v1.DeleteRoleRequest,
      com.google.iam.admin.v1.Role> getDeleteRoleMethod() {
    io.grpc.MethodDescriptor<com.google.iam.admin.v1.DeleteRoleRequest, com.google.iam.admin.v1.Role> getDeleteRoleMethod;
    if ((getDeleteRoleMethod = IAMGrpc.getDeleteRoleMethod) == null) {
      synchronized (IAMGrpc.class) {
        if ((getDeleteRoleMethod = IAMGrpc.getDeleteRoleMethod) == null) {
          IAMGrpc.getDeleteRoleMethod = getDeleteRoleMethod =
              io.grpc.MethodDescriptor.<com.google.iam.admin.v1.DeleteRoleRequest, com.google.iam.admin.v1.Role>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteRole"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.DeleteRoleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.Role.getDefaultInstance()))
              .setSchemaDescriptor(new IAMMethodDescriptorSupplier("DeleteRole"))
              .build();
        }
      }
    }
    return getDeleteRoleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.admin.v1.UndeleteRoleRequest,
      com.google.iam.admin.v1.Role> getUndeleteRoleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UndeleteRole",
      requestType = com.google.iam.admin.v1.UndeleteRoleRequest.class,
      responseType = com.google.iam.admin.v1.Role.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.admin.v1.UndeleteRoleRequest,
      com.google.iam.admin.v1.Role> getUndeleteRoleMethod() {
    io.grpc.MethodDescriptor<com.google.iam.admin.v1.UndeleteRoleRequest, com.google.iam.admin.v1.Role> getUndeleteRoleMethod;
    if ((getUndeleteRoleMethod = IAMGrpc.getUndeleteRoleMethod) == null) {
      synchronized (IAMGrpc.class) {
        if ((getUndeleteRoleMethod = IAMGrpc.getUndeleteRoleMethod) == null) {
          IAMGrpc.getUndeleteRoleMethod = getUndeleteRoleMethod =
              io.grpc.MethodDescriptor.<com.google.iam.admin.v1.UndeleteRoleRequest, com.google.iam.admin.v1.Role>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UndeleteRole"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.UndeleteRoleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.Role.getDefaultInstance()))
              .setSchemaDescriptor(new IAMMethodDescriptorSupplier("UndeleteRole"))
              .build();
        }
      }
    }
    return getUndeleteRoleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.admin.v1.QueryTestablePermissionsRequest,
      com.google.iam.admin.v1.QueryTestablePermissionsResponse> getQueryTestablePermissionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QueryTestablePermissions",
      requestType = com.google.iam.admin.v1.QueryTestablePermissionsRequest.class,
      responseType = com.google.iam.admin.v1.QueryTestablePermissionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.admin.v1.QueryTestablePermissionsRequest,
      com.google.iam.admin.v1.QueryTestablePermissionsResponse> getQueryTestablePermissionsMethod() {
    io.grpc.MethodDescriptor<com.google.iam.admin.v1.QueryTestablePermissionsRequest, com.google.iam.admin.v1.QueryTestablePermissionsResponse> getQueryTestablePermissionsMethod;
    if ((getQueryTestablePermissionsMethod = IAMGrpc.getQueryTestablePermissionsMethod) == null) {
      synchronized (IAMGrpc.class) {
        if ((getQueryTestablePermissionsMethod = IAMGrpc.getQueryTestablePermissionsMethod) == null) {
          IAMGrpc.getQueryTestablePermissionsMethod = getQueryTestablePermissionsMethod =
              io.grpc.MethodDescriptor.<com.google.iam.admin.v1.QueryTestablePermissionsRequest, com.google.iam.admin.v1.QueryTestablePermissionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "QueryTestablePermissions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.QueryTestablePermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.QueryTestablePermissionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new IAMMethodDescriptorSupplier("QueryTestablePermissions"))
              .build();
        }
      }
    }
    return getQueryTestablePermissionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.admin.v1.QueryAuditableServicesRequest,
      com.google.iam.admin.v1.QueryAuditableServicesResponse> getQueryAuditableServicesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QueryAuditableServices",
      requestType = com.google.iam.admin.v1.QueryAuditableServicesRequest.class,
      responseType = com.google.iam.admin.v1.QueryAuditableServicesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.admin.v1.QueryAuditableServicesRequest,
      com.google.iam.admin.v1.QueryAuditableServicesResponse> getQueryAuditableServicesMethod() {
    io.grpc.MethodDescriptor<com.google.iam.admin.v1.QueryAuditableServicesRequest, com.google.iam.admin.v1.QueryAuditableServicesResponse> getQueryAuditableServicesMethod;
    if ((getQueryAuditableServicesMethod = IAMGrpc.getQueryAuditableServicesMethod) == null) {
      synchronized (IAMGrpc.class) {
        if ((getQueryAuditableServicesMethod = IAMGrpc.getQueryAuditableServicesMethod) == null) {
          IAMGrpc.getQueryAuditableServicesMethod = getQueryAuditableServicesMethod =
              io.grpc.MethodDescriptor.<com.google.iam.admin.v1.QueryAuditableServicesRequest, com.google.iam.admin.v1.QueryAuditableServicesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "QueryAuditableServices"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.QueryAuditableServicesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.QueryAuditableServicesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new IAMMethodDescriptorSupplier("QueryAuditableServices"))
              .build();
        }
      }
    }
    return getQueryAuditableServicesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.admin.v1.LintPolicyRequest,
      com.google.iam.admin.v1.LintPolicyResponse> getLintPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LintPolicy",
      requestType = com.google.iam.admin.v1.LintPolicyRequest.class,
      responseType = com.google.iam.admin.v1.LintPolicyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.admin.v1.LintPolicyRequest,
      com.google.iam.admin.v1.LintPolicyResponse> getLintPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.admin.v1.LintPolicyRequest, com.google.iam.admin.v1.LintPolicyResponse> getLintPolicyMethod;
    if ((getLintPolicyMethod = IAMGrpc.getLintPolicyMethod) == null) {
      synchronized (IAMGrpc.class) {
        if ((getLintPolicyMethod = IAMGrpc.getLintPolicyMethod) == null) {
          IAMGrpc.getLintPolicyMethod = getLintPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.iam.admin.v1.LintPolicyRequest, com.google.iam.admin.v1.LintPolicyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LintPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.LintPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.admin.v1.LintPolicyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new IAMMethodDescriptorSupplier("LintPolicy"))
              .build();
        }
      }
    }
    return getLintPolicyMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static IAMStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IAMStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IAMStub>() {
        @java.lang.Override
        public IAMStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IAMStub(channel, callOptions);
        }
      };
    return IAMStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static IAMBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IAMBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IAMBlockingStub>() {
        @java.lang.Override
        public IAMBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IAMBlockingStub(channel, callOptions);
        }
      };
    return IAMBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static IAMFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IAMFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IAMFutureStub>() {
        @java.lang.Override
        public IAMFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IAMFutureStub(channel, callOptions);
        }
      };
    return IAMFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Creates and manages Identity and Access Management (IAM) resources.
   * You can use this service to work with all of the following resources:
   * * **Service accounts**, which identify an application or a virtual machine
   *   (VM) instance rather than a person
   * * **Service account keys**, which service accounts use to authenticate with
   *   Google APIs
   * * **IAM policies for service accounts**, which specify the roles that a
   *   principal has for the service account
   * * **IAM custom roles**, which help you limit the number of permissions that
   *   you grant to principals
   * In addition, you can use this service to complete the following tasks, among
   * others:
   * * Test whether a service account can use specific permissions
   * * Check which roles you can grant for a specific resource
   * * Lint, or validate, condition expressions in an IAM policy
   * When you read data from the IAM API, each read is eventually consistent. In
   * other words, if you write data with the IAM API, then immediately read that
   * data, the read operation might return an older version of the data. To deal
   * with this behavior, your application can retry the request with truncated
   * exponential backoff.
   * In contrast, writing data to the IAM API is sequentially consistent. In other
   * words, write operations are always processed in the order in which they were
   * received.
   * </pre>
   */
  public static abstract class IAMImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists every [ServiceAccount][google.iam.admin.v1.ServiceAccount] that belongs to a specific project.
     * </pre>
     */
    public void listServiceAccounts(com.google.iam.admin.v1.ListServiceAccountsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.ListServiceAccountsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListServiceAccountsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * </pre>
     */
    public void getServiceAccount(com.google.iam.admin.v1.GetServiceAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.ServiceAccount> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetServiceAccountMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * </pre>
     */
    public void createServiceAccount(com.google.iam.admin.v1.CreateServiceAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.ServiceAccount> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateServiceAccountMethod(), responseObserver);
    }

    /**
     * <pre>
     * **Note:** We are in the process of deprecating this method. Use
     * [PatchServiceAccount][google.iam.admin.v1.IAM.PatchServiceAccount] instead.
     * Updates a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * You can update only the `display_name` field.
     * </pre>
     */
    public void updateServiceAccount(com.google.iam.admin.v1.ServiceAccount request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.ServiceAccount> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateServiceAccountMethod(), responseObserver);
    }

    /**
     * <pre>
     * Patches a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * </pre>
     */
    public void patchServiceAccount(com.google.iam.admin.v1.PatchServiceAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.ServiceAccount> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPatchServiceAccountMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * **Warning:** After you delete a service account, you might not be able to
     * undelete it. If you know that you need to re-enable the service account in
     * the future, use [DisableServiceAccount][google.iam.admin.v1.IAM.DisableServiceAccount] instead.
     * If you delete a service account, IAM permanently removes the service
     * account 30 days later. Google Cloud cannot recover the service account
     * after it is permanently removed, even if you file a support request.
     * To help avoid unplanned outages, we recommend that you disable the service
     * account before you delete it. Use [DisableServiceAccount][google.iam.admin.v1.IAM.DisableServiceAccount] to disable the
     * service account, then wait at least 24 hours and watch for unintended
     * consequences. If there are no unintended consequences, you can delete the
     * service account.
     * </pre>
     */
    public void deleteServiceAccount(com.google.iam.admin.v1.DeleteServiceAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteServiceAccountMethod(), responseObserver);
    }

    /**
     * <pre>
     * Restores a deleted [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * **Important:** It is not always possible to restore a deleted service
     * account. Use this method only as a last resort.
     * After you delete a service account, IAM permanently removes the service
     * account 30 days later. There is no way to restore a deleted service account
     * that has been permanently removed.
     * </pre>
     */
    public void undeleteServiceAccount(com.google.iam.admin.v1.UndeleteServiceAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.UndeleteServiceAccountResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUndeleteServiceAccountMethod(), responseObserver);
    }

    /**
     * <pre>
     * Enables a [ServiceAccount][google.iam.admin.v1.ServiceAccount] that was disabled by
     * [DisableServiceAccount][google.iam.admin.v1.IAM.DisableServiceAccount].
     * If the service account is already enabled, then this method has no effect.
     * If the service account was disabled by other means—for example, if Google
     * disabled the service account because it was compromised—you cannot use this
     * method to enable the service account.
     * </pre>
     */
    public void enableServiceAccount(com.google.iam.admin.v1.EnableServiceAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEnableServiceAccountMethod(), responseObserver);
    }

    /**
     * <pre>
     * Disables a [ServiceAccount][google.iam.admin.v1.ServiceAccount] immediately.
     * If an application uses the service account to authenticate, that
     * application can no longer call Google APIs or access Google Cloud
     * resources. Existing access tokens for the service account are rejected, and
     * requests for new access tokens will fail.
     * To re-enable the service account, use [EnableServiceAccount][google.iam.admin.v1.IAM.EnableServiceAccount]. After you
     * re-enable the service account, its existing access tokens will be accepted,
     * and you can request new access tokens.
     * To help avoid unplanned outages, we recommend that you disable the service
     * account before you delete it. Use this method to disable the service
     * account, then wait at least 24 hours and watch for unintended consequences.
     * If there are no unintended consequences, you can delete the service account
     * with [DeleteServiceAccount][google.iam.admin.v1.IAM.DeleteServiceAccount].
     * </pre>
     */
    public void disableServiceAccount(com.google.iam.admin.v1.DisableServiceAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDisableServiceAccountMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists every [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey] for a service account.
     * </pre>
     */
    public void listServiceAccountKeys(com.google.iam.admin.v1.ListServiceAccountKeysRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.ListServiceAccountKeysResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListServiceAccountKeysMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey].
     * </pre>
     */
    public void getServiceAccountKey(com.google.iam.admin.v1.GetServiceAccountKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.ServiceAccountKey> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetServiceAccountKeyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey].
     * </pre>
     */
    public void createServiceAccountKey(com.google.iam.admin.v1.CreateServiceAccountKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.ServiceAccountKey> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateServiceAccountKeyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Uploads the public key portion of a key pair that you manage, and
     * associates the public key with a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * After you upload the public key, you can use the private key from the key
     * pair as a service account key.
     * </pre>
     */
    public void uploadServiceAccountKey(com.google.iam.admin.v1.UploadServiceAccountKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.ServiceAccountKey> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUploadServiceAccountKeyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey]. Deleting a service account key does not
     * revoke short-lived credentials that have been issued based on the service
     * account key.
     * </pre>
     */
    public void deleteServiceAccountKey(com.google.iam.admin.v1.DeleteServiceAccountKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteServiceAccountKeyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Disable a [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey]. A disabled service account key can be
     * re-enabled with [EnableServiceAccountKey][google.iam.admin.v1.IAM.EnableServiceAccountKey].
     * </pre>
     */
    public void disableServiceAccountKey(com.google.iam.admin.v1.DisableServiceAccountKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDisableServiceAccountKeyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Enable a [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey].
     * </pre>
     */
    public void enableServiceAccountKey(com.google.iam.admin.v1.EnableServiceAccountKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEnableServiceAccountKeyMethod(), responseObserver);
    }

    /**
     * <pre>
     * **Note:** This method is deprecated. Use the
     * [`signBlob`](https://cloud.google.com/iam/help/rest-credentials/v1/projects.serviceAccounts/signBlob)
     * method in the IAM Service Account Credentials API instead. If you currently
     * use this method, see the [migration
     * guide](https://cloud.google.com/iam/help/credentials/migrate-api) for
     * instructions.
     * Signs a blob using the system-managed private key for a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * </pre>
     */
    @java.lang.Deprecated
    public void signBlob(com.google.iam.admin.v1.SignBlobRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.SignBlobResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSignBlobMethod(), responseObserver);
    }

    /**
     * <pre>
     * **Note:** This method is deprecated. Use the
     * [`signJwt`](https://cloud.google.com/iam/help/rest-credentials/v1/projects.serviceAccounts/signJwt)
     * method in the IAM Service Account Credentials API instead. If you currently
     * use this method, see the [migration
     * guide](https://cloud.google.com/iam/help/credentials/migrate-api) for
     * instructions.
     * Signs a JSON Web Token (JWT) using the system-managed private key for a
     * [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * </pre>
     */
    @java.lang.Deprecated
    public void signJwt(com.google.iam.admin.v1.SignJwtRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.SignJwtResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSignJwtMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the IAM policy that is attached to a [ServiceAccount][google.iam.admin.v1.ServiceAccount]. This IAM
     * policy specifies which principals have access to the service account.
     * This method does not tell you whether the service account has been granted
     * any roles on other resources. To check whether a service account has role
     * grants on a resource, use the `getIamPolicy` method for that resource. For
     * example, to view the role grants for a project, call the Resource Manager
     * API's
     * [`projects.getIamPolicy`](https://cloud.google.com/resource-manager/reference/rest/v1/projects/getIamPolicy)
     * method.
     * </pre>
     */
    public void getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetIamPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Sets the IAM policy that is attached to a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * Use this method to grant or revoke access to the service account. For
     * example, you could grant a principal the ability to impersonate the service
     * account.
     * This method does not enable the service account to access other resources.
     * To grant roles to a service account on a resource, follow these steps:
     * 1. Call the resource's `getIamPolicy` method to get its current IAM policy.
     * 2. Edit the policy so that it binds the service account to an IAM role for
     * the resource.
     * 3. Call the resource's `setIamPolicy` method to update its IAM policy.
     * For detailed instructions, see
     * [Manage access to project, folders, and
     * organizations](https://cloud.google.com/iam/help/service-accounts/granting-access-to-service-accounts)
     * or [Manage access to other
     * resources](https://cloud.google.com/iam/help/access/manage-other-resources).
     * </pre>
     */
    public void setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetIamPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Tests whether the caller has the specified permissions on a
     * [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * </pre>
     */
    public void testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTestIamPermissionsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists roles that can be granted on a Google Cloud resource. A role is
     * grantable if the IAM policy for the resource can contain bindings to the
     * role.
     * </pre>
     */
    public void queryGrantableRoles(com.google.iam.admin.v1.QueryGrantableRolesRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.QueryGrantableRolesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getQueryGrantableRolesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists every predefined [Role][google.iam.admin.v1.Role] that IAM supports, or every custom role
     * that is defined for an organization or project.
     * </pre>
     */
    public void listRoles(com.google.iam.admin.v1.ListRolesRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.ListRolesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListRolesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the definition of a [Role][google.iam.admin.v1.Role].
     * </pre>
     */
    public void getRole(com.google.iam.admin.v1.GetRoleRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.Role> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetRoleMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new custom [Role][google.iam.admin.v1.Role].
     * </pre>
     */
    public void createRole(com.google.iam.admin.v1.CreateRoleRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.Role> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateRoleMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the definition of a custom [Role][google.iam.admin.v1.Role].
     * </pre>
     */
    public void updateRole(com.google.iam.admin.v1.UpdateRoleRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.Role> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateRoleMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a custom [Role][google.iam.admin.v1.Role].
     * When you delete a custom role, the following changes occur immediately:
     * * You cannot bind a principal to the custom role in an IAM
     * [Policy][google.iam.v1.Policy].
     * * Existing bindings to the custom role are not changed, but they have no
     * effect.
     * * By default, the response from [ListRoles][google.iam.admin.v1.IAM.ListRoles] does not include the custom
     * role.
     * You have 7 days to undelete the custom role. After 7 days, the following
     * changes occur:
     * * The custom role is permanently deleted and cannot be recovered.
     * * If an IAM policy contains a binding to the custom role, the binding is
     * permanently removed.
     * </pre>
     */
    public void deleteRole(com.google.iam.admin.v1.DeleteRoleRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.Role> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteRoleMethod(), responseObserver);
    }

    /**
     * <pre>
     * Undeletes a custom [Role][google.iam.admin.v1.Role].
     * </pre>
     */
    public void undeleteRole(com.google.iam.admin.v1.UndeleteRoleRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.Role> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUndeleteRoleMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists every permission that you can test on a resource. A permission is
     * testable if you can check whether a principal has that permission on the
     * resource.
     * </pre>
     */
    public void queryTestablePermissions(com.google.iam.admin.v1.QueryTestablePermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.QueryTestablePermissionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getQueryTestablePermissionsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns a list of services that allow you to opt into audit logs that are
     * not generated by default.
     * To learn more about audit logs, see the [Logging
     * documentation](https://cloud.google.com/logging/docs/audit).
     * </pre>
     */
    public void queryAuditableServices(com.google.iam.admin.v1.QueryAuditableServicesRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.QueryAuditableServicesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getQueryAuditableServicesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lints, or validates, an IAM policy. Currently checks the
     * [google.iam.v1.Binding.condition][google.iam.v1.Binding.condition] field, which contains a condition
     * expression for a role binding.
     * Successful calls to this method always return an HTTP `200 OK` status code,
     * even if the linter detects an issue in the IAM policy.
     * </pre>
     */
    public void lintPolicy(com.google.iam.admin.v1.LintPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.LintPolicyResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLintPolicyMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListServiceAccountsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.admin.v1.ListServiceAccountsRequest,
                com.google.iam.admin.v1.ListServiceAccountsResponse>(
                  this, METHODID_LIST_SERVICE_ACCOUNTS)))
          .addMethod(
            getGetServiceAccountMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.admin.v1.GetServiceAccountRequest,
                com.google.iam.admin.v1.ServiceAccount>(
                  this, METHODID_GET_SERVICE_ACCOUNT)))
          .addMethod(
            getCreateServiceAccountMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.admin.v1.CreateServiceAccountRequest,
                com.google.iam.admin.v1.ServiceAccount>(
                  this, METHODID_CREATE_SERVICE_ACCOUNT)))
          .addMethod(
            getUpdateServiceAccountMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.admin.v1.ServiceAccount,
                com.google.iam.admin.v1.ServiceAccount>(
                  this, METHODID_UPDATE_SERVICE_ACCOUNT)))
          .addMethod(
            getPatchServiceAccountMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.admin.v1.PatchServiceAccountRequest,
                com.google.iam.admin.v1.ServiceAccount>(
                  this, METHODID_PATCH_SERVICE_ACCOUNT)))
          .addMethod(
            getDeleteServiceAccountMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.admin.v1.DeleteServiceAccountRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_SERVICE_ACCOUNT)))
          .addMethod(
            getUndeleteServiceAccountMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.admin.v1.UndeleteServiceAccountRequest,
                com.google.iam.admin.v1.UndeleteServiceAccountResponse>(
                  this, METHODID_UNDELETE_SERVICE_ACCOUNT)))
          .addMethod(
            getEnableServiceAccountMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.admin.v1.EnableServiceAccountRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_ENABLE_SERVICE_ACCOUNT)))
          .addMethod(
            getDisableServiceAccountMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.admin.v1.DisableServiceAccountRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DISABLE_SERVICE_ACCOUNT)))
          .addMethod(
            getListServiceAccountKeysMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.admin.v1.ListServiceAccountKeysRequest,
                com.google.iam.admin.v1.ListServiceAccountKeysResponse>(
                  this, METHODID_LIST_SERVICE_ACCOUNT_KEYS)))
          .addMethod(
            getGetServiceAccountKeyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.admin.v1.GetServiceAccountKeyRequest,
                com.google.iam.admin.v1.ServiceAccountKey>(
                  this, METHODID_GET_SERVICE_ACCOUNT_KEY)))
          .addMethod(
            getCreateServiceAccountKeyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.admin.v1.CreateServiceAccountKeyRequest,
                com.google.iam.admin.v1.ServiceAccountKey>(
                  this, METHODID_CREATE_SERVICE_ACCOUNT_KEY)))
          .addMethod(
            getUploadServiceAccountKeyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.admin.v1.UploadServiceAccountKeyRequest,
                com.google.iam.admin.v1.ServiceAccountKey>(
                  this, METHODID_UPLOAD_SERVICE_ACCOUNT_KEY)))
          .addMethod(
            getDeleteServiceAccountKeyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.admin.v1.DeleteServiceAccountKeyRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_SERVICE_ACCOUNT_KEY)))
          .addMethod(
            getDisableServiceAccountKeyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.admin.v1.DisableServiceAccountKeyRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DISABLE_SERVICE_ACCOUNT_KEY)))
          .addMethod(
            getEnableServiceAccountKeyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.admin.v1.EnableServiceAccountKeyRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_ENABLE_SERVICE_ACCOUNT_KEY)))
          .addMethod(
            getSignBlobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.admin.v1.SignBlobRequest,
                com.google.iam.admin.v1.SignBlobResponse>(
                  this, METHODID_SIGN_BLOB)))
          .addMethod(
            getSignJwtMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.admin.v1.SignJwtRequest,
                com.google.iam.admin.v1.SignJwtResponse>(
                  this, METHODID_SIGN_JWT)))
          .addMethod(
            getGetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.GetIamPolicyRequest,
                com.google.iam.v1.Policy>(
                  this, METHODID_GET_IAM_POLICY)))
          .addMethod(
            getSetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.SetIamPolicyRequest,
                com.google.iam.v1.Policy>(
                  this, METHODID_SET_IAM_POLICY)))
          .addMethod(
            getTestIamPermissionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.TestIamPermissionsRequest,
                com.google.iam.v1.TestIamPermissionsResponse>(
                  this, METHODID_TEST_IAM_PERMISSIONS)))
          .addMethod(
            getQueryGrantableRolesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.admin.v1.QueryGrantableRolesRequest,
                com.google.iam.admin.v1.QueryGrantableRolesResponse>(
                  this, METHODID_QUERY_GRANTABLE_ROLES)))
          .addMethod(
            getListRolesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.admin.v1.ListRolesRequest,
                com.google.iam.admin.v1.ListRolesResponse>(
                  this, METHODID_LIST_ROLES)))
          .addMethod(
            getGetRoleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.admin.v1.GetRoleRequest,
                com.google.iam.admin.v1.Role>(
                  this, METHODID_GET_ROLE)))
          .addMethod(
            getCreateRoleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.admin.v1.CreateRoleRequest,
                com.google.iam.admin.v1.Role>(
                  this, METHODID_CREATE_ROLE)))
          .addMethod(
            getUpdateRoleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.admin.v1.UpdateRoleRequest,
                com.google.iam.admin.v1.Role>(
                  this, METHODID_UPDATE_ROLE)))
          .addMethod(
            getDeleteRoleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.admin.v1.DeleteRoleRequest,
                com.google.iam.admin.v1.Role>(
                  this, METHODID_DELETE_ROLE)))
          .addMethod(
            getUndeleteRoleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.admin.v1.UndeleteRoleRequest,
                com.google.iam.admin.v1.Role>(
                  this, METHODID_UNDELETE_ROLE)))
          .addMethod(
            getQueryTestablePermissionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.admin.v1.QueryTestablePermissionsRequest,
                com.google.iam.admin.v1.QueryTestablePermissionsResponse>(
                  this, METHODID_QUERY_TESTABLE_PERMISSIONS)))
          .addMethod(
            getQueryAuditableServicesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.admin.v1.QueryAuditableServicesRequest,
                com.google.iam.admin.v1.QueryAuditableServicesResponse>(
                  this, METHODID_QUERY_AUDITABLE_SERVICES)))
          .addMethod(
            getLintPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.admin.v1.LintPolicyRequest,
                com.google.iam.admin.v1.LintPolicyResponse>(
                  this, METHODID_LINT_POLICY)))
          .build();
    }
  }

  /**
   * <pre>
   * Creates and manages Identity and Access Management (IAM) resources.
   * You can use this service to work with all of the following resources:
   * * **Service accounts**, which identify an application or a virtual machine
   *   (VM) instance rather than a person
   * * **Service account keys**, which service accounts use to authenticate with
   *   Google APIs
   * * **IAM policies for service accounts**, which specify the roles that a
   *   principal has for the service account
   * * **IAM custom roles**, which help you limit the number of permissions that
   *   you grant to principals
   * In addition, you can use this service to complete the following tasks, among
   * others:
   * * Test whether a service account can use specific permissions
   * * Check which roles you can grant for a specific resource
   * * Lint, or validate, condition expressions in an IAM policy
   * When you read data from the IAM API, each read is eventually consistent. In
   * other words, if you write data with the IAM API, then immediately read that
   * data, the read operation might return an older version of the data. To deal
   * with this behavior, your application can retry the request with truncated
   * exponential backoff.
   * In contrast, writing data to the IAM API is sequentially consistent. In other
   * words, write operations are always processed in the order in which they were
   * received.
   * </pre>
   */
  public static final class IAMStub extends io.grpc.stub.AbstractAsyncStub<IAMStub> {
    private IAMStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IAMStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IAMStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists every [ServiceAccount][google.iam.admin.v1.ServiceAccount] that belongs to a specific project.
     * </pre>
     */
    public void listServiceAccounts(com.google.iam.admin.v1.ListServiceAccountsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.ListServiceAccountsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListServiceAccountsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * </pre>
     */
    public void getServiceAccount(com.google.iam.admin.v1.GetServiceAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.ServiceAccount> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetServiceAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * </pre>
     */
    public void createServiceAccount(com.google.iam.admin.v1.CreateServiceAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.ServiceAccount> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateServiceAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * **Note:** We are in the process of deprecating this method. Use
     * [PatchServiceAccount][google.iam.admin.v1.IAM.PatchServiceAccount] instead.
     * Updates a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * You can update only the `display_name` field.
     * </pre>
     */
    public void updateServiceAccount(com.google.iam.admin.v1.ServiceAccount request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.ServiceAccount> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateServiceAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Patches a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * </pre>
     */
    public void patchServiceAccount(com.google.iam.admin.v1.PatchServiceAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.ServiceAccount> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPatchServiceAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * **Warning:** After you delete a service account, you might not be able to
     * undelete it. If you know that you need to re-enable the service account in
     * the future, use [DisableServiceAccount][google.iam.admin.v1.IAM.DisableServiceAccount] instead.
     * If you delete a service account, IAM permanently removes the service
     * account 30 days later. Google Cloud cannot recover the service account
     * after it is permanently removed, even if you file a support request.
     * To help avoid unplanned outages, we recommend that you disable the service
     * account before you delete it. Use [DisableServiceAccount][google.iam.admin.v1.IAM.DisableServiceAccount] to disable the
     * service account, then wait at least 24 hours and watch for unintended
     * consequences. If there are no unintended consequences, you can delete the
     * service account.
     * </pre>
     */
    public void deleteServiceAccount(com.google.iam.admin.v1.DeleteServiceAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteServiceAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Restores a deleted [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * **Important:** It is not always possible to restore a deleted service
     * account. Use this method only as a last resort.
     * After you delete a service account, IAM permanently removes the service
     * account 30 days later. There is no way to restore a deleted service account
     * that has been permanently removed.
     * </pre>
     */
    public void undeleteServiceAccount(com.google.iam.admin.v1.UndeleteServiceAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.UndeleteServiceAccountResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUndeleteServiceAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Enables a [ServiceAccount][google.iam.admin.v1.ServiceAccount] that was disabled by
     * [DisableServiceAccount][google.iam.admin.v1.IAM.DisableServiceAccount].
     * If the service account is already enabled, then this method has no effect.
     * If the service account was disabled by other means—for example, if Google
     * disabled the service account because it was compromised—you cannot use this
     * method to enable the service account.
     * </pre>
     */
    public void enableServiceAccount(com.google.iam.admin.v1.EnableServiceAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEnableServiceAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Disables a [ServiceAccount][google.iam.admin.v1.ServiceAccount] immediately.
     * If an application uses the service account to authenticate, that
     * application can no longer call Google APIs or access Google Cloud
     * resources. Existing access tokens for the service account are rejected, and
     * requests for new access tokens will fail.
     * To re-enable the service account, use [EnableServiceAccount][google.iam.admin.v1.IAM.EnableServiceAccount]. After you
     * re-enable the service account, its existing access tokens will be accepted,
     * and you can request new access tokens.
     * To help avoid unplanned outages, we recommend that you disable the service
     * account before you delete it. Use this method to disable the service
     * account, then wait at least 24 hours and watch for unintended consequences.
     * If there are no unintended consequences, you can delete the service account
     * with [DeleteServiceAccount][google.iam.admin.v1.IAM.DeleteServiceAccount].
     * </pre>
     */
    public void disableServiceAccount(com.google.iam.admin.v1.DisableServiceAccountRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDisableServiceAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists every [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey] for a service account.
     * </pre>
     */
    public void listServiceAccountKeys(com.google.iam.admin.v1.ListServiceAccountKeysRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.ListServiceAccountKeysResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListServiceAccountKeysMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey].
     * </pre>
     */
    public void getServiceAccountKey(com.google.iam.admin.v1.GetServiceAccountKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.ServiceAccountKey> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetServiceAccountKeyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey].
     * </pre>
     */
    public void createServiceAccountKey(com.google.iam.admin.v1.CreateServiceAccountKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.ServiceAccountKey> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateServiceAccountKeyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Uploads the public key portion of a key pair that you manage, and
     * associates the public key with a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * After you upload the public key, you can use the private key from the key
     * pair as a service account key.
     * </pre>
     */
    public void uploadServiceAccountKey(com.google.iam.admin.v1.UploadServiceAccountKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.ServiceAccountKey> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUploadServiceAccountKeyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey]. Deleting a service account key does not
     * revoke short-lived credentials that have been issued based on the service
     * account key.
     * </pre>
     */
    public void deleteServiceAccountKey(com.google.iam.admin.v1.DeleteServiceAccountKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteServiceAccountKeyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Disable a [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey]. A disabled service account key can be
     * re-enabled with [EnableServiceAccountKey][google.iam.admin.v1.IAM.EnableServiceAccountKey].
     * </pre>
     */
    public void disableServiceAccountKey(com.google.iam.admin.v1.DisableServiceAccountKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDisableServiceAccountKeyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Enable a [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey].
     * </pre>
     */
    public void enableServiceAccountKey(com.google.iam.admin.v1.EnableServiceAccountKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEnableServiceAccountKeyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * **Note:** This method is deprecated. Use the
     * [`signBlob`](https://cloud.google.com/iam/help/rest-credentials/v1/projects.serviceAccounts/signBlob)
     * method in the IAM Service Account Credentials API instead. If you currently
     * use this method, see the [migration
     * guide](https://cloud.google.com/iam/help/credentials/migrate-api) for
     * instructions.
     * Signs a blob using the system-managed private key for a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * </pre>
     */
    @java.lang.Deprecated
    public void signBlob(com.google.iam.admin.v1.SignBlobRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.SignBlobResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSignBlobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * **Note:** This method is deprecated. Use the
     * [`signJwt`](https://cloud.google.com/iam/help/rest-credentials/v1/projects.serviceAccounts/signJwt)
     * method in the IAM Service Account Credentials API instead. If you currently
     * use this method, see the [migration
     * guide](https://cloud.google.com/iam/help/credentials/migrate-api) for
     * instructions.
     * Signs a JSON Web Token (JWT) using the system-managed private key for a
     * [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * </pre>
     */
    @java.lang.Deprecated
    public void signJwt(com.google.iam.admin.v1.SignJwtRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.SignJwtResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSignJwtMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the IAM policy that is attached to a [ServiceAccount][google.iam.admin.v1.ServiceAccount]. This IAM
     * policy specifies which principals have access to the service account.
     * This method does not tell you whether the service account has been granted
     * any roles on other resources. To check whether a service account has role
     * grants on a resource, use the `getIamPolicy` method for that resource. For
     * example, to view the role grants for a project, call the Resource Manager
     * API's
     * [`projects.getIamPolicy`](https://cloud.google.com/resource-manager/reference/rest/v1/projects/getIamPolicy)
     * method.
     * </pre>
     */
    public void getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Sets the IAM policy that is attached to a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * Use this method to grant or revoke access to the service account. For
     * example, you could grant a principal the ability to impersonate the service
     * account.
     * This method does not enable the service account to access other resources.
     * To grant roles to a service account on a resource, follow these steps:
     * 1. Call the resource's `getIamPolicy` method to get its current IAM policy.
     * 2. Edit the policy so that it binds the service account to an IAM role for
     * the resource.
     * 3. Call the resource's `setIamPolicy` method to update its IAM policy.
     * For detailed instructions, see
     * [Manage access to project, folders, and
     * organizations](https://cloud.google.com/iam/help/service-accounts/granting-access-to-service-accounts)
     * or [Manage access to other
     * resources](https://cloud.google.com/iam/help/access/manage-other-resources).
     * </pre>
     */
    public void setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Tests whether the caller has the specified permissions on a
     * [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * </pre>
     */
    public void testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists roles that can be granted on a Google Cloud resource. A role is
     * grantable if the IAM policy for the resource can contain bindings to the
     * role.
     * </pre>
     */
    public void queryGrantableRoles(com.google.iam.admin.v1.QueryGrantableRolesRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.QueryGrantableRolesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getQueryGrantableRolesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists every predefined [Role][google.iam.admin.v1.Role] that IAM supports, or every custom role
     * that is defined for an organization or project.
     * </pre>
     */
    public void listRoles(com.google.iam.admin.v1.ListRolesRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.ListRolesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRolesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the definition of a [Role][google.iam.admin.v1.Role].
     * </pre>
     */
    public void getRole(com.google.iam.admin.v1.GetRoleRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.Role> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRoleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new custom [Role][google.iam.admin.v1.Role].
     * </pre>
     */
    public void createRole(com.google.iam.admin.v1.CreateRoleRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.Role> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateRoleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the definition of a custom [Role][google.iam.admin.v1.Role].
     * </pre>
     */
    public void updateRole(com.google.iam.admin.v1.UpdateRoleRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.Role> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateRoleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a custom [Role][google.iam.admin.v1.Role].
     * When you delete a custom role, the following changes occur immediately:
     * * You cannot bind a principal to the custom role in an IAM
     * [Policy][google.iam.v1.Policy].
     * * Existing bindings to the custom role are not changed, but they have no
     * effect.
     * * By default, the response from [ListRoles][google.iam.admin.v1.IAM.ListRoles] does not include the custom
     * role.
     * You have 7 days to undelete the custom role. After 7 days, the following
     * changes occur:
     * * The custom role is permanently deleted and cannot be recovered.
     * * If an IAM policy contains a binding to the custom role, the binding is
     * permanently removed.
     * </pre>
     */
    public void deleteRole(com.google.iam.admin.v1.DeleteRoleRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.Role> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteRoleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Undeletes a custom [Role][google.iam.admin.v1.Role].
     * </pre>
     */
    public void undeleteRole(com.google.iam.admin.v1.UndeleteRoleRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.Role> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUndeleteRoleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists every permission that you can test on a resource. A permission is
     * testable if you can check whether a principal has that permission on the
     * resource.
     * </pre>
     */
    public void queryTestablePermissions(com.google.iam.admin.v1.QueryTestablePermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.QueryTestablePermissionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getQueryTestablePermissionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns a list of services that allow you to opt into audit logs that are
     * not generated by default.
     * To learn more about audit logs, see the [Logging
     * documentation](https://cloud.google.com/logging/docs/audit).
     * </pre>
     */
    public void queryAuditableServices(com.google.iam.admin.v1.QueryAuditableServicesRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.QueryAuditableServicesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getQueryAuditableServicesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lints, or validates, an IAM policy. Currently checks the
     * [google.iam.v1.Binding.condition][google.iam.v1.Binding.condition] field, which contains a condition
     * expression for a role binding.
     * Successful calls to this method always return an HTTP `200 OK` status code,
     * even if the linter detects an issue in the IAM policy.
     * </pre>
     */
    public void lintPolicy(com.google.iam.admin.v1.LintPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.admin.v1.LintPolicyResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLintPolicyMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Creates and manages Identity and Access Management (IAM) resources.
   * You can use this service to work with all of the following resources:
   * * **Service accounts**, which identify an application or a virtual machine
   *   (VM) instance rather than a person
   * * **Service account keys**, which service accounts use to authenticate with
   *   Google APIs
   * * **IAM policies for service accounts**, which specify the roles that a
   *   principal has for the service account
   * * **IAM custom roles**, which help you limit the number of permissions that
   *   you grant to principals
   * In addition, you can use this service to complete the following tasks, among
   * others:
   * * Test whether a service account can use specific permissions
   * * Check which roles you can grant for a specific resource
   * * Lint, or validate, condition expressions in an IAM policy
   * When you read data from the IAM API, each read is eventually consistent. In
   * other words, if you write data with the IAM API, then immediately read that
   * data, the read operation might return an older version of the data. To deal
   * with this behavior, your application can retry the request with truncated
   * exponential backoff.
   * In contrast, writing data to the IAM API is sequentially consistent. In other
   * words, write operations are always processed in the order in which they were
   * received.
   * </pre>
   */
  public static final class IAMBlockingStub extends io.grpc.stub.AbstractBlockingStub<IAMBlockingStub> {
    private IAMBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IAMBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IAMBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists every [ServiceAccount][google.iam.admin.v1.ServiceAccount] that belongs to a specific project.
     * </pre>
     */
    public com.google.iam.admin.v1.ListServiceAccountsResponse listServiceAccounts(com.google.iam.admin.v1.ListServiceAccountsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListServiceAccountsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * </pre>
     */
    public com.google.iam.admin.v1.ServiceAccount getServiceAccount(com.google.iam.admin.v1.GetServiceAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetServiceAccountMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * </pre>
     */
    public com.google.iam.admin.v1.ServiceAccount createServiceAccount(com.google.iam.admin.v1.CreateServiceAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateServiceAccountMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * **Note:** We are in the process of deprecating this method. Use
     * [PatchServiceAccount][google.iam.admin.v1.IAM.PatchServiceAccount] instead.
     * Updates a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * You can update only the `display_name` field.
     * </pre>
     */
    public com.google.iam.admin.v1.ServiceAccount updateServiceAccount(com.google.iam.admin.v1.ServiceAccount request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateServiceAccountMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Patches a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * </pre>
     */
    public com.google.iam.admin.v1.ServiceAccount patchServiceAccount(com.google.iam.admin.v1.PatchServiceAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPatchServiceAccountMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * **Warning:** After you delete a service account, you might not be able to
     * undelete it. If you know that you need to re-enable the service account in
     * the future, use [DisableServiceAccount][google.iam.admin.v1.IAM.DisableServiceAccount] instead.
     * If you delete a service account, IAM permanently removes the service
     * account 30 days later. Google Cloud cannot recover the service account
     * after it is permanently removed, even if you file a support request.
     * To help avoid unplanned outages, we recommend that you disable the service
     * account before you delete it. Use [DisableServiceAccount][google.iam.admin.v1.IAM.DisableServiceAccount] to disable the
     * service account, then wait at least 24 hours and watch for unintended
     * consequences. If there are no unintended consequences, you can delete the
     * service account.
     * </pre>
     */
    public com.google.protobuf.Empty deleteServiceAccount(com.google.iam.admin.v1.DeleteServiceAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteServiceAccountMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Restores a deleted [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * **Important:** It is not always possible to restore a deleted service
     * account. Use this method only as a last resort.
     * After you delete a service account, IAM permanently removes the service
     * account 30 days later. There is no way to restore a deleted service account
     * that has been permanently removed.
     * </pre>
     */
    public com.google.iam.admin.v1.UndeleteServiceAccountResponse undeleteServiceAccount(com.google.iam.admin.v1.UndeleteServiceAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUndeleteServiceAccountMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Enables a [ServiceAccount][google.iam.admin.v1.ServiceAccount] that was disabled by
     * [DisableServiceAccount][google.iam.admin.v1.IAM.DisableServiceAccount].
     * If the service account is already enabled, then this method has no effect.
     * If the service account was disabled by other means—for example, if Google
     * disabled the service account because it was compromised—you cannot use this
     * method to enable the service account.
     * </pre>
     */
    public com.google.protobuf.Empty enableServiceAccount(com.google.iam.admin.v1.EnableServiceAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEnableServiceAccountMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Disables a [ServiceAccount][google.iam.admin.v1.ServiceAccount] immediately.
     * If an application uses the service account to authenticate, that
     * application can no longer call Google APIs or access Google Cloud
     * resources. Existing access tokens for the service account are rejected, and
     * requests for new access tokens will fail.
     * To re-enable the service account, use [EnableServiceAccount][google.iam.admin.v1.IAM.EnableServiceAccount]. After you
     * re-enable the service account, its existing access tokens will be accepted,
     * and you can request new access tokens.
     * To help avoid unplanned outages, we recommend that you disable the service
     * account before you delete it. Use this method to disable the service
     * account, then wait at least 24 hours and watch for unintended consequences.
     * If there are no unintended consequences, you can delete the service account
     * with [DeleteServiceAccount][google.iam.admin.v1.IAM.DeleteServiceAccount].
     * </pre>
     */
    public com.google.protobuf.Empty disableServiceAccount(com.google.iam.admin.v1.DisableServiceAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDisableServiceAccountMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists every [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey] for a service account.
     * </pre>
     */
    public com.google.iam.admin.v1.ListServiceAccountKeysResponse listServiceAccountKeys(com.google.iam.admin.v1.ListServiceAccountKeysRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListServiceAccountKeysMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey].
     * </pre>
     */
    public com.google.iam.admin.v1.ServiceAccountKey getServiceAccountKey(com.google.iam.admin.v1.GetServiceAccountKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetServiceAccountKeyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey].
     * </pre>
     */
    public com.google.iam.admin.v1.ServiceAccountKey createServiceAccountKey(com.google.iam.admin.v1.CreateServiceAccountKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateServiceAccountKeyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Uploads the public key portion of a key pair that you manage, and
     * associates the public key with a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * After you upload the public key, you can use the private key from the key
     * pair as a service account key.
     * </pre>
     */
    public com.google.iam.admin.v1.ServiceAccountKey uploadServiceAccountKey(com.google.iam.admin.v1.UploadServiceAccountKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUploadServiceAccountKeyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey]. Deleting a service account key does not
     * revoke short-lived credentials that have been issued based on the service
     * account key.
     * </pre>
     */
    public com.google.protobuf.Empty deleteServiceAccountKey(com.google.iam.admin.v1.DeleteServiceAccountKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteServiceAccountKeyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Disable a [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey]. A disabled service account key can be
     * re-enabled with [EnableServiceAccountKey][google.iam.admin.v1.IAM.EnableServiceAccountKey].
     * </pre>
     */
    public com.google.protobuf.Empty disableServiceAccountKey(com.google.iam.admin.v1.DisableServiceAccountKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDisableServiceAccountKeyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Enable a [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey].
     * </pre>
     */
    public com.google.protobuf.Empty enableServiceAccountKey(com.google.iam.admin.v1.EnableServiceAccountKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEnableServiceAccountKeyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * **Note:** This method is deprecated. Use the
     * [`signBlob`](https://cloud.google.com/iam/help/rest-credentials/v1/projects.serviceAccounts/signBlob)
     * method in the IAM Service Account Credentials API instead. If you currently
     * use this method, see the [migration
     * guide](https://cloud.google.com/iam/help/credentials/migrate-api) for
     * instructions.
     * Signs a blob using the system-managed private key for a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.iam.admin.v1.SignBlobResponse signBlob(com.google.iam.admin.v1.SignBlobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSignBlobMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * **Note:** This method is deprecated. Use the
     * [`signJwt`](https://cloud.google.com/iam/help/rest-credentials/v1/projects.serviceAccounts/signJwt)
     * method in the IAM Service Account Credentials API instead. If you currently
     * use this method, see the [migration
     * guide](https://cloud.google.com/iam/help/credentials/migrate-api) for
     * instructions.
     * Signs a JSON Web Token (JWT) using the system-managed private key for a
     * [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.iam.admin.v1.SignJwtResponse signJwt(com.google.iam.admin.v1.SignJwtRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSignJwtMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the IAM policy that is attached to a [ServiceAccount][google.iam.admin.v1.ServiceAccount]. This IAM
     * policy specifies which principals have access to the service account.
     * This method does not tell you whether the service account has been granted
     * any roles on other resources. To check whether a service account has role
     * grants on a resource, use the `getIamPolicy` method for that resource. For
     * example, to view the role grants for a project, call the Resource Manager
     * API's
     * [`projects.getIamPolicy`](https://cloud.google.com/resource-manager/reference/rest/v1/projects/getIamPolicy)
     * method.
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Sets the IAM policy that is attached to a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * Use this method to grant or revoke access to the service account. For
     * example, you could grant a principal the ability to impersonate the service
     * account.
     * This method does not enable the service account to access other resources.
     * To grant roles to a service account on a resource, follow these steps:
     * 1. Call the resource's `getIamPolicy` method to get its current IAM policy.
     * 2. Edit the policy so that it binds the service account to an IAM role for
     * the resource.
     * 3. Call the resource's `setIamPolicy` method to update its IAM policy.
     * For detailed instructions, see
     * [Manage access to project, folders, and
     * organizations](https://cloud.google.com/iam/help/service-accounts/granting-access-to-service-accounts)
     * or [Manage access to other
     * resources](https://cloud.google.com/iam/help/access/manage-other-resources).
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Tests whether the caller has the specified permissions on a
     * [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists roles that can be granted on a Google Cloud resource. A role is
     * grantable if the IAM policy for the resource can contain bindings to the
     * role.
     * </pre>
     */
    public com.google.iam.admin.v1.QueryGrantableRolesResponse queryGrantableRoles(com.google.iam.admin.v1.QueryGrantableRolesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQueryGrantableRolesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists every predefined [Role][google.iam.admin.v1.Role] that IAM supports, or every custom role
     * that is defined for an organization or project.
     * </pre>
     */
    public com.google.iam.admin.v1.ListRolesResponse listRoles(com.google.iam.admin.v1.ListRolesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRolesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the definition of a [Role][google.iam.admin.v1.Role].
     * </pre>
     */
    public com.google.iam.admin.v1.Role getRole(com.google.iam.admin.v1.GetRoleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRoleMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new custom [Role][google.iam.admin.v1.Role].
     * </pre>
     */
    public com.google.iam.admin.v1.Role createRole(com.google.iam.admin.v1.CreateRoleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRoleMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the definition of a custom [Role][google.iam.admin.v1.Role].
     * </pre>
     */
    public com.google.iam.admin.v1.Role updateRole(com.google.iam.admin.v1.UpdateRoleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateRoleMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a custom [Role][google.iam.admin.v1.Role].
     * When you delete a custom role, the following changes occur immediately:
     * * You cannot bind a principal to the custom role in an IAM
     * [Policy][google.iam.v1.Policy].
     * * Existing bindings to the custom role are not changed, but they have no
     * effect.
     * * By default, the response from [ListRoles][google.iam.admin.v1.IAM.ListRoles] does not include the custom
     * role.
     * You have 7 days to undelete the custom role. After 7 days, the following
     * changes occur:
     * * The custom role is permanently deleted and cannot be recovered.
     * * If an IAM policy contains a binding to the custom role, the binding is
     * permanently removed.
     * </pre>
     */
    public com.google.iam.admin.v1.Role deleteRole(com.google.iam.admin.v1.DeleteRoleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRoleMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Undeletes a custom [Role][google.iam.admin.v1.Role].
     * </pre>
     */
    public com.google.iam.admin.v1.Role undeleteRole(com.google.iam.admin.v1.UndeleteRoleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUndeleteRoleMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists every permission that you can test on a resource. A permission is
     * testable if you can check whether a principal has that permission on the
     * resource.
     * </pre>
     */
    public com.google.iam.admin.v1.QueryTestablePermissionsResponse queryTestablePermissions(com.google.iam.admin.v1.QueryTestablePermissionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQueryTestablePermissionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns a list of services that allow you to opt into audit logs that are
     * not generated by default.
     * To learn more about audit logs, see the [Logging
     * documentation](https://cloud.google.com/logging/docs/audit).
     * </pre>
     */
    public com.google.iam.admin.v1.QueryAuditableServicesResponse queryAuditableServices(com.google.iam.admin.v1.QueryAuditableServicesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQueryAuditableServicesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lints, or validates, an IAM policy. Currently checks the
     * [google.iam.v1.Binding.condition][google.iam.v1.Binding.condition] field, which contains a condition
     * expression for a role binding.
     * Successful calls to this method always return an HTTP `200 OK` status code,
     * even if the linter detects an issue in the IAM policy.
     * </pre>
     */
    public com.google.iam.admin.v1.LintPolicyResponse lintPolicy(com.google.iam.admin.v1.LintPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLintPolicyMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Creates and manages Identity and Access Management (IAM) resources.
   * You can use this service to work with all of the following resources:
   * * **Service accounts**, which identify an application or a virtual machine
   *   (VM) instance rather than a person
   * * **Service account keys**, which service accounts use to authenticate with
   *   Google APIs
   * * **IAM policies for service accounts**, which specify the roles that a
   *   principal has for the service account
   * * **IAM custom roles**, which help you limit the number of permissions that
   *   you grant to principals
   * In addition, you can use this service to complete the following tasks, among
   * others:
   * * Test whether a service account can use specific permissions
   * * Check which roles you can grant for a specific resource
   * * Lint, or validate, condition expressions in an IAM policy
   * When you read data from the IAM API, each read is eventually consistent. In
   * other words, if you write data with the IAM API, then immediately read that
   * data, the read operation might return an older version of the data. To deal
   * with this behavior, your application can retry the request with truncated
   * exponential backoff.
   * In contrast, writing data to the IAM API is sequentially consistent. In other
   * words, write operations are always processed in the order in which they were
   * received.
   * </pre>
   */
  public static final class IAMFutureStub extends io.grpc.stub.AbstractFutureStub<IAMFutureStub> {
    private IAMFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IAMFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IAMFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists every [ServiceAccount][google.iam.admin.v1.ServiceAccount] that belongs to a specific project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.admin.v1.ListServiceAccountsResponse> listServiceAccounts(
        com.google.iam.admin.v1.ListServiceAccountsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListServiceAccountsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.admin.v1.ServiceAccount> getServiceAccount(
        com.google.iam.admin.v1.GetServiceAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetServiceAccountMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.admin.v1.ServiceAccount> createServiceAccount(
        com.google.iam.admin.v1.CreateServiceAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateServiceAccountMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * **Note:** We are in the process of deprecating this method. Use
     * [PatchServiceAccount][google.iam.admin.v1.IAM.PatchServiceAccount] instead.
     * Updates a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * You can update only the `display_name` field.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.admin.v1.ServiceAccount> updateServiceAccount(
        com.google.iam.admin.v1.ServiceAccount request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateServiceAccountMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Patches a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.admin.v1.ServiceAccount> patchServiceAccount(
        com.google.iam.admin.v1.PatchServiceAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPatchServiceAccountMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * **Warning:** After you delete a service account, you might not be able to
     * undelete it. If you know that you need to re-enable the service account in
     * the future, use [DisableServiceAccount][google.iam.admin.v1.IAM.DisableServiceAccount] instead.
     * If you delete a service account, IAM permanently removes the service
     * account 30 days later. Google Cloud cannot recover the service account
     * after it is permanently removed, even if you file a support request.
     * To help avoid unplanned outages, we recommend that you disable the service
     * account before you delete it. Use [DisableServiceAccount][google.iam.admin.v1.IAM.DisableServiceAccount] to disable the
     * service account, then wait at least 24 hours and watch for unintended
     * consequences. If there are no unintended consequences, you can delete the
     * service account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteServiceAccount(
        com.google.iam.admin.v1.DeleteServiceAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteServiceAccountMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Restores a deleted [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * **Important:** It is not always possible to restore a deleted service
     * account. Use this method only as a last resort.
     * After you delete a service account, IAM permanently removes the service
     * account 30 days later. There is no way to restore a deleted service account
     * that has been permanently removed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.admin.v1.UndeleteServiceAccountResponse> undeleteServiceAccount(
        com.google.iam.admin.v1.UndeleteServiceAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUndeleteServiceAccountMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Enables a [ServiceAccount][google.iam.admin.v1.ServiceAccount] that was disabled by
     * [DisableServiceAccount][google.iam.admin.v1.IAM.DisableServiceAccount].
     * If the service account is already enabled, then this method has no effect.
     * If the service account was disabled by other means—for example, if Google
     * disabled the service account because it was compromised—you cannot use this
     * method to enable the service account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> enableServiceAccount(
        com.google.iam.admin.v1.EnableServiceAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEnableServiceAccountMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Disables a [ServiceAccount][google.iam.admin.v1.ServiceAccount] immediately.
     * If an application uses the service account to authenticate, that
     * application can no longer call Google APIs or access Google Cloud
     * resources. Existing access tokens for the service account are rejected, and
     * requests for new access tokens will fail.
     * To re-enable the service account, use [EnableServiceAccount][google.iam.admin.v1.IAM.EnableServiceAccount]. After you
     * re-enable the service account, its existing access tokens will be accepted,
     * and you can request new access tokens.
     * To help avoid unplanned outages, we recommend that you disable the service
     * account before you delete it. Use this method to disable the service
     * account, then wait at least 24 hours and watch for unintended consequences.
     * If there are no unintended consequences, you can delete the service account
     * with [DeleteServiceAccount][google.iam.admin.v1.IAM.DeleteServiceAccount].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> disableServiceAccount(
        com.google.iam.admin.v1.DisableServiceAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDisableServiceAccountMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists every [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey] for a service account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.admin.v1.ListServiceAccountKeysResponse> listServiceAccountKeys(
        com.google.iam.admin.v1.ListServiceAccountKeysRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListServiceAccountKeysMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.admin.v1.ServiceAccountKey> getServiceAccountKey(
        com.google.iam.admin.v1.GetServiceAccountKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetServiceAccountKeyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.admin.v1.ServiceAccountKey> createServiceAccountKey(
        com.google.iam.admin.v1.CreateServiceAccountKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateServiceAccountKeyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Uploads the public key portion of a key pair that you manage, and
     * associates the public key with a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * After you upload the public key, you can use the private key from the key
     * pair as a service account key.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.admin.v1.ServiceAccountKey> uploadServiceAccountKey(
        com.google.iam.admin.v1.UploadServiceAccountKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUploadServiceAccountKeyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey]. Deleting a service account key does not
     * revoke short-lived credentials that have been issued based on the service
     * account key.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteServiceAccountKey(
        com.google.iam.admin.v1.DeleteServiceAccountKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteServiceAccountKeyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Disable a [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey]. A disabled service account key can be
     * re-enabled with [EnableServiceAccountKey][google.iam.admin.v1.IAM.EnableServiceAccountKey].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> disableServiceAccountKey(
        com.google.iam.admin.v1.DisableServiceAccountKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDisableServiceAccountKeyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Enable a [ServiceAccountKey][google.iam.admin.v1.ServiceAccountKey].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> enableServiceAccountKey(
        com.google.iam.admin.v1.EnableServiceAccountKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEnableServiceAccountKeyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * **Note:** This method is deprecated. Use the
     * [`signBlob`](https://cloud.google.com/iam/help/rest-credentials/v1/projects.serviceAccounts/signBlob)
     * method in the IAM Service Account Credentials API instead. If you currently
     * use this method, see the [migration
     * guide](https://cloud.google.com/iam/help/credentials/migrate-api) for
     * instructions.
     * Signs a blob using the system-managed private key for a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.admin.v1.SignBlobResponse> signBlob(
        com.google.iam.admin.v1.SignBlobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSignBlobMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * **Note:** This method is deprecated. Use the
     * [`signJwt`](https://cloud.google.com/iam/help/rest-credentials/v1/projects.serviceAccounts/signJwt)
     * method in the IAM Service Account Credentials API instead. If you currently
     * use this method, see the [migration
     * guide](https://cloud.google.com/iam/help/credentials/migrate-api) for
     * instructions.
     * Signs a JSON Web Token (JWT) using the system-managed private key for a
     * [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.admin.v1.SignJwtResponse> signJwt(
        com.google.iam.admin.v1.SignJwtRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSignJwtMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the IAM policy that is attached to a [ServiceAccount][google.iam.admin.v1.ServiceAccount]. This IAM
     * policy specifies which principals have access to the service account.
     * This method does not tell you whether the service account has been granted
     * any roles on other resources. To check whether a service account has role
     * grants on a resource, use the `getIamPolicy` method for that resource. For
     * example, to view the role grants for a project, call the Resource Manager
     * API's
     * [`projects.getIamPolicy`](https://cloud.google.com/resource-manager/reference/rest/v1/projects/getIamPolicy)
     * method.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy> getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Sets the IAM policy that is attached to a [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * Use this method to grant or revoke access to the service account. For
     * example, you could grant a principal the ability to impersonate the service
     * account.
     * This method does not enable the service account to access other resources.
     * To grant roles to a service account on a resource, follow these steps:
     * 1. Call the resource's `getIamPolicy` method to get its current IAM policy.
     * 2. Edit the policy so that it binds the service account to an IAM role for
     * the resource.
     * 3. Call the resource's `setIamPolicy` method to update its IAM policy.
     * For detailed instructions, see
     * [Manage access to project, folders, and
     * organizations](https://cloud.google.com/iam/help/service-accounts/granting-access-to-service-accounts)
     * or [Manage access to other
     * resources](https://cloud.google.com/iam/help/access/manage-other-resources).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy> setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Tests whether the caller has the specified permissions on a
     * [ServiceAccount][google.iam.admin.v1.ServiceAccount].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.TestIamPermissionsResponse> testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists roles that can be granted on a Google Cloud resource. A role is
     * grantable if the IAM policy for the resource can contain bindings to the
     * role.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.admin.v1.QueryGrantableRolesResponse> queryGrantableRoles(
        com.google.iam.admin.v1.QueryGrantableRolesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getQueryGrantableRolesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists every predefined [Role][google.iam.admin.v1.Role] that IAM supports, or every custom role
     * that is defined for an organization or project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.admin.v1.ListRolesResponse> listRoles(
        com.google.iam.admin.v1.ListRolesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRolesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the definition of a [Role][google.iam.admin.v1.Role].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.admin.v1.Role> getRole(
        com.google.iam.admin.v1.GetRoleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRoleMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new custom [Role][google.iam.admin.v1.Role].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.admin.v1.Role> createRole(
        com.google.iam.admin.v1.CreateRoleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateRoleMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the definition of a custom [Role][google.iam.admin.v1.Role].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.admin.v1.Role> updateRole(
        com.google.iam.admin.v1.UpdateRoleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateRoleMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a custom [Role][google.iam.admin.v1.Role].
     * When you delete a custom role, the following changes occur immediately:
     * * You cannot bind a principal to the custom role in an IAM
     * [Policy][google.iam.v1.Policy].
     * * Existing bindings to the custom role are not changed, but they have no
     * effect.
     * * By default, the response from [ListRoles][google.iam.admin.v1.IAM.ListRoles] does not include the custom
     * role.
     * You have 7 days to undelete the custom role. After 7 days, the following
     * changes occur:
     * * The custom role is permanently deleted and cannot be recovered.
     * * If an IAM policy contains a binding to the custom role, the binding is
     * permanently removed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.admin.v1.Role> deleteRole(
        com.google.iam.admin.v1.DeleteRoleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteRoleMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Undeletes a custom [Role][google.iam.admin.v1.Role].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.admin.v1.Role> undeleteRole(
        com.google.iam.admin.v1.UndeleteRoleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUndeleteRoleMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists every permission that you can test on a resource. A permission is
     * testable if you can check whether a principal has that permission on the
     * resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.admin.v1.QueryTestablePermissionsResponse> queryTestablePermissions(
        com.google.iam.admin.v1.QueryTestablePermissionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getQueryTestablePermissionsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns a list of services that allow you to opt into audit logs that are
     * not generated by default.
     * To learn more about audit logs, see the [Logging
     * documentation](https://cloud.google.com/logging/docs/audit).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.admin.v1.QueryAuditableServicesResponse> queryAuditableServices(
        com.google.iam.admin.v1.QueryAuditableServicesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getQueryAuditableServicesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lints, or validates, an IAM policy. Currently checks the
     * [google.iam.v1.Binding.condition][google.iam.v1.Binding.condition] field, which contains a condition
     * expression for a role binding.
     * Successful calls to this method always return an HTTP `200 OK` status code,
     * even if the linter detects an issue in the IAM policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.admin.v1.LintPolicyResponse> lintPolicy(
        com.google.iam.admin.v1.LintPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLintPolicyMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_SERVICE_ACCOUNTS = 0;
  private static final int METHODID_GET_SERVICE_ACCOUNT = 1;
  private static final int METHODID_CREATE_SERVICE_ACCOUNT = 2;
  private static final int METHODID_UPDATE_SERVICE_ACCOUNT = 3;
  private static final int METHODID_PATCH_SERVICE_ACCOUNT = 4;
  private static final int METHODID_DELETE_SERVICE_ACCOUNT = 5;
  private static final int METHODID_UNDELETE_SERVICE_ACCOUNT = 6;
  private static final int METHODID_ENABLE_SERVICE_ACCOUNT = 7;
  private static final int METHODID_DISABLE_SERVICE_ACCOUNT = 8;
  private static final int METHODID_LIST_SERVICE_ACCOUNT_KEYS = 9;
  private static final int METHODID_GET_SERVICE_ACCOUNT_KEY = 10;
  private static final int METHODID_CREATE_SERVICE_ACCOUNT_KEY = 11;
  private static final int METHODID_UPLOAD_SERVICE_ACCOUNT_KEY = 12;
  private static final int METHODID_DELETE_SERVICE_ACCOUNT_KEY = 13;
  private static final int METHODID_DISABLE_SERVICE_ACCOUNT_KEY = 14;
  private static final int METHODID_ENABLE_SERVICE_ACCOUNT_KEY = 15;
  private static final int METHODID_SIGN_BLOB = 16;
  private static final int METHODID_SIGN_JWT = 17;
  private static final int METHODID_GET_IAM_POLICY = 18;
  private static final int METHODID_SET_IAM_POLICY = 19;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 20;
  private static final int METHODID_QUERY_GRANTABLE_ROLES = 21;
  private static final int METHODID_LIST_ROLES = 22;
  private static final int METHODID_GET_ROLE = 23;
  private static final int METHODID_CREATE_ROLE = 24;
  private static final int METHODID_UPDATE_ROLE = 25;
  private static final int METHODID_DELETE_ROLE = 26;
  private static final int METHODID_UNDELETE_ROLE = 27;
  private static final int METHODID_QUERY_TESTABLE_PERMISSIONS = 28;
  private static final int METHODID_QUERY_AUDITABLE_SERVICES = 29;
  private static final int METHODID_LINT_POLICY = 30;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final IAMImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(IAMImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_SERVICE_ACCOUNTS:
          serviceImpl.listServiceAccounts((com.google.iam.admin.v1.ListServiceAccountsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.admin.v1.ListServiceAccountsResponse>) responseObserver);
          break;
        case METHODID_GET_SERVICE_ACCOUNT:
          serviceImpl.getServiceAccount((com.google.iam.admin.v1.GetServiceAccountRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.admin.v1.ServiceAccount>) responseObserver);
          break;
        case METHODID_CREATE_SERVICE_ACCOUNT:
          serviceImpl.createServiceAccount((com.google.iam.admin.v1.CreateServiceAccountRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.admin.v1.ServiceAccount>) responseObserver);
          break;
        case METHODID_UPDATE_SERVICE_ACCOUNT:
          serviceImpl.updateServiceAccount((com.google.iam.admin.v1.ServiceAccount) request,
              (io.grpc.stub.StreamObserver<com.google.iam.admin.v1.ServiceAccount>) responseObserver);
          break;
        case METHODID_PATCH_SERVICE_ACCOUNT:
          serviceImpl.patchServiceAccount((com.google.iam.admin.v1.PatchServiceAccountRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.admin.v1.ServiceAccount>) responseObserver);
          break;
        case METHODID_DELETE_SERVICE_ACCOUNT:
          serviceImpl.deleteServiceAccount((com.google.iam.admin.v1.DeleteServiceAccountRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UNDELETE_SERVICE_ACCOUNT:
          serviceImpl.undeleteServiceAccount((com.google.iam.admin.v1.UndeleteServiceAccountRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.admin.v1.UndeleteServiceAccountResponse>) responseObserver);
          break;
        case METHODID_ENABLE_SERVICE_ACCOUNT:
          serviceImpl.enableServiceAccount((com.google.iam.admin.v1.EnableServiceAccountRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_DISABLE_SERVICE_ACCOUNT:
          serviceImpl.disableServiceAccount((com.google.iam.admin.v1.DisableServiceAccountRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_SERVICE_ACCOUNT_KEYS:
          serviceImpl.listServiceAccountKeys((com.google.iam.admin.v1.ListServiceAccountKeysRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.admin.v1.ListServiceAccountKeysResponse>) responseObserver);
          break;
        case METHODID_GET_SERVICE_ACCOUNT_KEY:
          serviceImpl.getServiceAccountKey((com.google.iam.admin.v1.GetServiceAccountKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.admin.v1.ServiceAccountKey>) responseObserver);
          break;
        case METHODID_CREATE_SERVICE_ACCOUNT_KEY:
          serviceImpl.createServiceAccountKey((com.google.iam.admin.v1.CreateServiceAccountKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.admin.v1.ServiceAccountKey>) responseObserver);
          break;
        case METHODID_UPLOAD_SERVICE_ACCOUNT_KEY:
          serviceImpl.uploadServiceAccountKey((com.google.iam.admin.v1.UploadServiceAccountKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.admin.v1.ServiceAccountKey>) responseObserver);
          break;
        case METHODID_DELETE_SERVICE_ACCOUNT_KEY:
          serviceImpl.deleteServiceAccountKey((com.google.iam.admin.v1.DeleteServiceAccountKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_DISABLE_SERVICE_ACCOUNT_KEY:
          serviceImpl.disableServiceAccountKey((com.google.iam.admin.v1.DisableServiceAccountKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_ENABLE_SERVICE_ACCOUNT_KEY:
          serviceImpl.enableServiceAccountKey((com.google.iam.admin.v1.EnableServiceAccountKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_SIGN_BLOB:
          serviceImpl.signBlob((com.google.iam.admin.v1.SignBlobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.admin.v1.SignBlobResponse>) responseObserver);
          break;
        case METHODID_SIGN_JWT:
          serviceImpl.signJwt((com.google.iam.admin.v1.SignJwtRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.admin.v1.SignJwtResponse>) responseObserver);
          break;
        case METHODID_GET_IAM_POLICY:
          serviceImpl.getIamPolicy((com.google.iam.v1.GetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_SET_IAM_POLICY:
          serviceImpl.setIamPolicy((com.google.iam.v1.SetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_TEST_IAM_PERMISSIONS:
          serviceImpl.testIamPermissions((com.google.iam.v1.TestIamPermissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>) responseObserver);
          break;
        case METHODID_QUERY_GRANTABLE_ROLES:
          serviceImpl.queryGrantableRoles((com.google.iam.admin.v1.QueryGrantableRolesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.admin.v1.QueryGrantableRolesResponse>) responseObserver);
          break;
        case METHODID_LIST_ROLES:
          serviceImpl.listRoles((com.google.iam.admin.v1.ListRolesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.admin.v1.ListRolesResponse>) responseObserver);
          break;
        case METHODID_GET_ROLE:
          serviceImpl.getRole((com.google.iam.admin.v1.GetRoleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.admin.v1.Role>) responseObserver);
          break;
        case METHODID_CREATE_ROLE:
          serviceImpl.createRole((com.google.iam.admin.v1.CreateRoleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.admin.v1.Role>) responseObserver);
          break;
        case METHODID_UPDATE_ROLE:
          serviceImpl.updateRole((com.google.iam.admin.v1.UpdateRoleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.admin.v1.Role>) responseObserver);
          break;
        case METHODID_DELETE_ROLE:
          serviceImpl.deleteRole((com.google.iam.admin.v1.DeleteRoleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.admin.v1.Role>) responseObserver);
          break;
        case METHODID_UNDELETE_ROLE:
          serviceImpl.undeleteRole((com.google.iam.admin.v1.UndeleteRoleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.admin.v1.Role>) responseObserver);
          break;
        case METHODID_QUERY_TESTABLE_PERMISSIONS:
          serviceImpl.queryTestablePermissions((com.google.iam.admin.v1.QueryTestablePermissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.admin.v1.QueryTestablePermissionsResponse>) responseObserver);
          break;
        case METHODID_QUERY_AUDITABLE_SERVICES:
          serviceImpl.queryAuditableServices((com.google.iam.admin.v1.QueryAuditableServicesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.admin.v1.QueryAuditableServicesResponse>) responseObserver);
          break;
        case METHODID_LINT_POLICY:
          serviceImpl.lintPolicy((com.google.iam.admin.v1.LintPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.admin.v1.LintPolicyResponse>) responseObserver);
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

  private static abstract class IAMBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    IAMBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.iam.admin.v1.Iam.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("IAM");
    }
  }

  private static final class IAMFileDescriptorSupplier
      extends IAMBaseDescriptorSupplier {
    IAMFileDescriptorSupplier() {}
  }

  private static final class IAMMethodDescriptorSupplier
      extends IAMBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    IAMMethodDescriptorSupplier(String methodName) {
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
      synchronized (IAMGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new IAMFileDescriptorSupplier())
              .addMethod(getListServiceAccountsMethod())
              .addMethod(getGetServiceAccountMethod())
              .addMethod(getCreateServiceAccountMethod())
              .addMethod(getUpdateServiceAccountMethod())
              .addMethod(getPatchServiceAccountMethod())
              .addMethod(getDeleteServiceAccountMethod())
              .addMethod(getUndeleteServiceAccountMethod())
              .addMethod(getEnableServiceAccountMethod())
              .addMethod(getDisableServiceAccountMethod())
              .addMethod(getListServiceAccountKeysMethod())
              .addMethod(getGetServiceAccountKeyMethod())
              .addMethod(getCreateServiceAccountKeyMethod())
              .addMethod(getUploadServiceAccountKeyMethod())
              .addMethod(getDeleteServiceAccountKeyMethod())
              .addMethod(getDisableServiceAccountKeyMethod())
              .addMethod(getEnableServiceAccountKeyMethod())
              .addMethod(getSignBlobMethod())
              .addMethod(getSignJwtMethod())
              .addMethod(getGetIamPolicyMethod())
              .addMethod(getSetIamPolicyMethod())
              .addMethod(getTestIamPermissionsMethod())
              .addMethod(getQueryGrantableRolesMethod())
              .addMethod(getListRolesMethod())
              .addMethod(getGetRoleMethod())
              .addMethod(getCreateRoleMethod())
              .addMethod(getUpdateRoleMethod())
              .addMethod(getDeleteRoleMethod())
              .addMethod(getUndeleteRoleMethod())
              .addMethod(getQueryTestablePermissionsMethod())
              .addMethod(getQueryAuditableServicesMethod())
              .addMethod(getLintPolicyMethod())
              .build();
        }
      }
    }
    return result;
  }
}
