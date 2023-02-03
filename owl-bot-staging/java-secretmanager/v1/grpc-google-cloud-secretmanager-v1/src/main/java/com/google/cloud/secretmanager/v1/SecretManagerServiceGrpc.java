package com.google.cloud.secretmanager.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Secret Manager Service
 * Manages secrets and operations using those secrets. Implements a REST
 * model with the following objects:
 * * [Secret][google.cloud.secretmanager.v1.Secret]
 * * [SecretVersion][google.cloud.secretmanager.v1.SecretVersion]
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/secretmanager/v1/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SecretManagerServiceGrpc {

  private SecretManagerServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.secretmanager.v1.SecretManagerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.secretmanager.v1.ListSecretsRequest,
      com.google.cloud.secretmanager.v1.ListSecretsResponse> getListSecretsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSecrets",
      requestType = com.google.cloud.secretmanager.v1.ListSecretsRequest.class,
      responseType = com.google.cloud.secretmanager.v1.ListSecretsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.secretmanager.v1.ListSecretsRequest,
      com.google.cloud.secretmanager.v1.ListSecretsResponse> getListSecretsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.secretmanager.v1.ListSecretsRequest, com.google.cloud.secretmanager.v1.ListSecretsResponse> getListSecretsMethod;
    if ((getListSecretsMethod = SecretManagerServiceGrpc.getListSecretsMethod) == null) {
      synchronized (SecretManagerServiceGrpc.class) {
        if ((getListSecretsMethod = SecretManagerServiceGrpc.getListSecretsMethod) == null) {
          SecretManagerServiceGrpc.getListSecretsMethod = getListSecretsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.secretmanager.v1.ListSecretsRequest, com.google.cloud.secretmanager.v1.ListSecretsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSecrets"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.secretmanager.v1.ListSecretsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.secretmanager.v1.ListSecretsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SecretManagerServiceMethodDescriptorSupplier("ListSecrets"))
              .build();
        }
      }
    }
    return getListSecretsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.secretmanager.v1.CreateSecretRequest,
      com.google.cloud.secretmanager.v1.Secret> getCreateSecretMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSecret",
      requestType = com.google.cloud.secretmanager.v1.CreateSecretRequest.class,
      responseType = com.google.cloud.secretmanager.v1.Secret.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.secretmanager.v1.CreateSecretRequest,
      com.google.cloud.secretmanager.v1.Secret> getCreateSecretMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.secretmanager.v1.CreateSecretRequest, com.google.cloud.secretmanager.v1.Secret> getCreateSecretMethod;
    if ((getCreateSecretMethod = SecretManagerServiceGrpc.getCreateSecretMethod) == null) {
      synchronized (SecretManagerServiceGrpc.class) {
        if ((getCreateSecretMethod = SecretManagerServiceGrpc.getCreateSecretMethod) == null) {
          SecretManagerServiceGrpc.getCreateSecretMethod = getCreateSecretMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.secretmanager.v1.CreateSecretRequest, com.google.cloud.secretmanager.v1.Secret>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSecret"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.secretmanager.v1.CreateSecretRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.secretmanager.v1.Secret.getDefaultInstance()))
              .setSchemaDescriptor(new SecretManagerServiceMethodDescriptorSupplier("CreateSecret"))
              .build();
        }
      }
    }
    return getCreateSecretMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.secretmanager.v1.AddSecretVersionRequest,
      com.google.cloud.secretmanager.v1.SecretVersion> getAddSecretVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddSecretVersion",
      requestType = com.google.cloud.secretmanager.v1.AddSecretVersionRequest.class,
      responseType = com.google.cloud.secretmanager.v1.SecretVersion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.secretmanager.v1.AddSecretVersionRequest,
      com.google.cloud.secretmanager.v1.SecretVersion> getAddSecretVersionMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.secretmanager.v1.AddSecretVersionRequest, com.google.cloud.secretmanager.v1.SecretVersion> getAddSecretVersionMethod;
    if ((getAddSecretVersionMethod = SecretManagerServiceGrpc.getAddSecretVersionMethod) == null) {
      synchronized (SecretManagerServiceGrpc.class) {
        if ((getAddSecretVersionMethod = SecretManagerServiceGrpc.getAddSecretVersionMethod) == null) {
          SecretManagerServiceGrpc.getAddSecretVersionMethod = getAddSecretVersionMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.secretmanager.v1.AddSecretVersionRequest, com.google.cloud.secretmanager.v1.SecretVersion>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddSecretVersion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.secretmanager.v1.AddSecretVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.secretmanager.v1.SecretVersion.getDefaultInstance()))
              .setSchemaDescriptor(new SecretManagerServiceMethodDescriptorSupplier("AddSecretVersion"))
              .build();
        }
      }
    }
    return getAddSecretVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.secretmanager.v1.GetSecretRequest,
      com.google.cloud.secretmanager.v1.Secret> getGetSecretMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSecret",
      requestType = com.google.cloud.secretmanager.v1.GetSecretRequest.class,
      responseType = com.google.cloud.secretmanager.v1.Secret.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.secretmanager.v1.GetSecretRequest,
      com.google.cloud.secretmanager.v1.Secret> getGetSecretMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.secretmanager.v1.GetSecretRequest, com.google.cloud.secretmanager.v1.Secret> getGetSecretMethod;
    if ((getGetSecretMethod = SecretManagerServiceGrpc.getGetSecretMethod) == null) {
      synchronized (SecretManagerServiceGrpc.class) {
        if ((getGetSecretMethod = SecretManagerServiceGrpc.getGetSecretMethod) == null) {
          SecretManagerServiceGrpc.getGetSecretMethod = getGetSecretMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.secretmanager.v1.GetSecretRequest, com.google.cloud.secretmanager.v1.Secret>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSecret"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.secretmanager.v1.GetSecretRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.secretmanager.v1.Secret.getDefaultInstance()))
              .setSchemaDescriptor(new SecretManagerServiceMethodDescriptorSupplier("GetSecret"))
              .build();
        }
      }
    }
    return getGetSecretMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.secretmanager.v1.UpdateSecretRequest,
      com.google.cloud.secretmanager.v1.Secret> getUpdateSecretMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSecret",
      requestType = com.google.cloud.secretmanager.v1.UpdateSecretRequest.class,
      responseType = com.google.cloud.secretmanager.v1.Secret.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.secretmanager.v1.UpdateSecretRequest,
      com.google.cloud.secretmanager.v1.Secret> getUpdateSecretMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.secretmanager.v1.UpdateSecretRequest, com.google.cloud.secretmanager.v1.Secret> getUpdateSecretMethod;
    if ((getUpdateSecretMethod = SecretManagerServiceGrpc.getUpdateSecretMethod) == null) {
      synchronized (SecretManagerServiceGrpc.class) {
        if ((getUpdateSecretMethod = SecretManagerServiceGrpc.getUpdateSecretMethod) == null) {
          SecretManagerServiceGrpc.getUpdateSecretMethod = getUpdateSecretMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.secretmanager.v1.UpdateSecretRequest, com.google.cloud.secretmanager.v1.Secret>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSecret"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.secretmanager.v1.UpdateSecretRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.secretmanager.v1.Secret.getDefaultInstance()))
              .setSchemaDescriptor(new SecretManagerServiceMethodDescriptorSupplier("UpdateSecret"))
              .build();
        }
      }
    }
    return getUpdateSecretMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.secretmanager.v1.DeleteSecretRequest,
      com.google.protobuf.Empty> getDeleteSecretMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSecret",
      requestType = com.google.cloud.secretmanager.v1.DeleteSecretRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.secretmanager.v1.DeleteSecretRequest,
      com.google.protobuf.Empty> getDeleteSecretMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.secretmanager.v1.DeleteSecretRequest, com.google.protobuf.Empty> getDeleteSecretMethod;
    if ((getDeleteSecretMethod = SecretManagerServiceGrpc.getDeleteSecretMethod) == null) {
      synchronized (SecretManagerServiceGrpc.class) {
        if ((getDeleteSecretMethod = SecretManagerServiceGrpc.getDeleteSecretMethod) == null) {
          SecretManagerServiceGrpc.getDeleteSecretMethod = getDeleteSecretMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.secretmanager.v1.DeleteSecretRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSecret"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.secretmanager.v1.DeleteSecretRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new SecretManagerServiceMethodDescriptorSupplier("DeleteSecret"))
              .build();
        }
      }
    }
    return getDeleteSecretMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.secretmanager.v1.ListSecretVersionsRequest,
      com.google.cloud.secretmanager.v1.ListSecretVersionsResponse> getListSecretVersionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSecretVersions",
      requestType = com.google.cloud.secretmanager.v1.ListSecretVersionsRequest.class,
      responseType = com.google.cloud.secretmanager.v1.ListSecretVersionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.secretmanager.v1.ListSecretVersionsRequest,
      com.google.cloud.secretmanager.v1.ListSecretVersionsResponse> getListSecretVersionsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.secretmanager.v1.ListSecretVersionsRequest, com.google.cloud.secretmanager.v1.ListSecretVersionsResponse> getListSecretVersionsMethod;
    if ((getListSecretVersionsMethod = SecretManagerServiceGrpc.getListSecretVersionsMethod) == null) {
      synchronized (SecretManagerServiceGrpc.class) {
        if ((getListSecretVersionsMethod = SecretManagerServiceGrpc.getListSecretVersionsMethod) == null) {
          SecretManagerServiceGrpc.getListSecretVersionsMethod = getListSecretVersionsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.secretmanager.v1.ListSecretVersionsRequest, com.google.cloud.secretmanager.v1.ListSecretVersionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSecretVersions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.secretmanager.v1.ListSecretVersionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.secretmanager.v1.ListSecretVersionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SecretManagerServiceMethodDescriptorSupplier("ListSecretVersions"))
              .build();
        }
      }
    }
    return getListSecretVersionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.secretmanager.v1.GetSecretVersionRequest,
      com.google.cloud.secretmanager.v1.SecretVersion> getGetSecretVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSecretVersion",
      requestType = com.google.cloud.secretmanager.v1.GetSecretVersionRequest.class,
      responseType = com.google.cloud.secretmanager.v1.SecretVersion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.secretmanager.v1.GetSecretVersionRequest,
      com.google.cloud.secretmanager.v1.SecretVersion> getGetSecretVersionMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.secretmanager.v1.GetSecretVersionRequest, com.google.cloud.secretmanager.v1.SecretVersion> getGetSecretVersionMethod;
    if ((getGetSecretVersionMethod = SecretManagerServiceGrpc.getGetSecretVersionMethod) == null) {
      synchronized (SecretManagerServiceGrpc.class) {
        if ((getGetSecretVersionMethod = SecretManagerServiceGrpc.getGetSecretVersionMethod) == null) {
          SecretManagerServiceGrpc.getGetSecretVersionMethod = getGetSecretVersionMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.secretmanager.v1.GetSecretVersionRequest, com.google.cloud.secretmanager.v1.SecretVersion>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSecretVersion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.secretmanager.v1.GetSecretVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.secretmanager.v1.SecretVersion.getDefaultInstance()))
              .setSchemaDescriptor(new SecretManagerServiceMethodDescriptorSupplier("GetSecretVersion"))
              .build();
        }
      }
    }
    return getGetSecretVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.secretmanager.v1.AccessSecretVersionRequest,
      com.google.cloud.secretmanager.v1.AccessSecretVersionResponse> getAccessSecretVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AccessSecretVersion",
      requestType = com.google.cloud.secretmanager.v1.AccessSecretVersionRequest.class,
      responseType = com.google.cloud.secretmanager.v1.AccessSecretVersionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.secretmanager.v1.AccessSecretVersionRequest,
      com.google.cloud.secretmanager.v1.AccessSecretVersionResponse> getAccessSecretVersionMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.secretmanager.v1.AccessSecretVersionRequest, com.google.cloud.secretmanager.v1.AccessSecretVersionResponse> getAccessSecretVersionMethod;
    if ((getAccessSecretVersionMethod = SecretManagerServiceGrpc.getAccessSecretVersionMethod) == null) {
      synchronized (SecretManagerServiceGrpc.class) {
        if ((getAccessSecretVersionMethod = SecretManagerServiceGrpc.getAccessSecretVersionMethod) == null) {
          SecretManagerServiceGrpc.getAccessSecretVersionMethod = getAccessSecretVersionMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.secretmanager.v1.AccessSecretVersionRequest, com.google.cloud.secretmanager.v1.AccessSecretVersionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AccessSecretVersion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.secretmanager.v1.AccessSecretVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.secretmanager.v1.AccessSecretVersionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SecretManagerServiceMethodDescriptorSupplier("AccessSecretVersion"))
              .build();
        }
      }
    }
    return getAccessSecretVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.secretmanager.v1.DisableSecretVersionRequest,
      com.google.cloud.secretmanager.v1.SecretVersion> getDisableSecretVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DisableSecretVersion",
      requestType = com.google.cloud.secretmanager.v1.DisableSecretVersionRequest.class,
      responseType = com.google.cloud.secretmanager.v1.SecretVersion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.secretmanager.v1.DisableSecretVersionRequest,
      com.google.cloud.secretmanager.v1.SecretVersion> getDisableSecretVersionMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.secretmanager.v1.DisableSecretVersionRequest, com.google.cloud.secretmanager.v1.SecretVersion> getDisableSecretVersionMethod;
    if ((getDisableSecretVersionMethod = SecretManagerServiceGrpc.getDisableSecretVersionMethod) == null) {
      synchronized (SecretManagerServiceGrpc.class) {
        if ((getDisableSecretVersionMethod = SecretManagerServiceGrpc.getDisableSecretVersionMethod) == null) {
          SecretManagerServiceGrpc.getDisableSecretVersionMethod = getDisableSecretVersionMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.secretmanager.v1.DisableSecretVersionRequest, com.google.cloud.secretmanager.v1.SecretVersion>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DisableSecretVersion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.secretmanager.v1.DisableSecretVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.secretmanager.v1.SecretVersion.getDefaultInstance()))
              .setSchemaDescriptor(new SecretManagerServiceMethodDescriptorSupplier("DisableSecretVersion"))
              .build();
        }
      }
    }
    return getDisableSecretVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.secretmanager.v1.EnableSecretVersionRequest,
      com.google.cloud.secretmanager.v1.SecretVersion> getEnableSecretVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EnableSecretVersion",
      requestType = com.google.cloud.secretmanager.v1.EnableSecretVersionRequest.class,
      responseType = com.google.cloud.secretmanager.v1.SecretVersion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.secretmanager.v1.EnableSecretVersionRequest,
      com.google.cloud.secretmanager.v1.SecretVersion> getEnableSecretVersionMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.secretmanager.v1.EnableSecretVersionRequest, com.google.cloud.secretmanager.v1.SecretVersion> getEnableSecretVersionMethod;
    if ((getEnableSecretVersionMethod = SecretManagerServiceGrpc.getEnableSecretVersionMethod) == null) {
      synchronized (SecretManagerServiceGrpc.class) {
        if ((getEnableSecretVersionMethod = SecretManagerServiceGrpc.getEnableSecretVersionMethod) == null) {
          SecretManagerServiceGrpc.getEnableSecretVersionMethod = getEnableSecretVersionMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.secretmanager.v1.EnableSecretVersionRequest, com.google.cloud.secretmanager.v1.SecretVersion>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EnableSecretVersion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.secretmanager.v1.EnableSecretVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.secretmanager.v1.SecretVersion.getDefaultInstance()))
              .setSchemaDescriptor(new SecretManagerServiceMethodDescriptorSupplier("EnableSecretVersion"))
              .build();
        }
      }
    }
    return getEnableSecretVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.secretmanager.v1.DestroySecretVersionRequest,
      com.google.cloud.secretmanager.v1.SecretVersion> getDestroySecretVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DestroySecretVersion",
      requestType = com.google.cloud.secretmanager.v1.DestroySecretVersionRequest.class,
      responseType = com.google.cloud.secretmanager.v1.SecretVersion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.secretmanager.v1.DestroySecretVersionRequest,
      com.google.cloud.secretmanager.v1.SecretVersion> getDestroySecretVersionMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.secretmanager.v1.DestroySecretVersionRequest, com.google.cloud.secretmanager.v1.SecretVersion> getDestroySecretVersionMethod;
    if ((getDestroySecretVersionMethod = SecretManagerServiceGrpc.getDestroySecretVersionMethod) == null) {
      synchronized (SecretManagerServiceGrpc.class) {
        if ((getDestroySecretVersionMethod = SecretManagerServiceGrpc.getDestroySecretVersionMethod) == null) {
          SecretManagerServiceGrpc.getDestroySecretVersionMethod = getDestroySecretVersionMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.secretmanager.v1.DestroySecretVersionRequest, com.google.cloud.secretmanager.v1.SecretVersion>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DestroySecretVersion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.secretmanager.v1.DestroySecretVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.secretmanager.v1.SecretVersion.getDefaultInstance()))
              .setSchemaDescriptor(new SecretManagerServiceMethodDescriptorSupplier("DestroySecretVersion"))
              .build();
        }
      }
    }
    return getDestroySecretVersionMethod;
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
    if ((getSetIamPolicyMethod = SecretManagerServiceGrpc.getSetIamPolicyMethod) == null) {
      synchronized (SecretManagerServiceGrpc.class) {
        if ((getSetIamPolicyMethod = SecretManagerServiceGrpc.getSetIamPolicyMethod) == null) {
          SecretManagerServiceGrpc.getSetIamPolicyMethod = getSetIamPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetIamPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.SetIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.Policy.getDefaultInstance()))
              .setSchemaDescriptor(new SecretManagerServiceMethodDescriptorSupplier("SetIamPolicy"))
              .build();
        }
      }
    }
    return getSetIamPolicyMethod;
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
    if ((getGetIamPolicyMethod = SecretManagerServiceGrpc.getGetIamPolicyMethod) == null) {
      synchronized (SecretManagerServiceGrpc.class) {
        if ((getGetIamPolicyMethod = SecretManagerServiceGrpc.getGetIamPolicyMethod) == null) {
          SecretManagerServiceGrpc.getGetIamPolicyMethod = getGetIamPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIamPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.GetIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.Policy.getDefaultInstance()))
              .setSchemaDescriptor(new SecretManagerServiceMethodDescriptorSupplier("GetIamPolicy"))
              .build();
        }
      }
    }
    return getGetIamPolicyMethod;
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
    if ((getTestIamPermissionsMethod = SecretManagerServiceGrpc.getTestIamPermissionsMethod) == null) {
      synchronized (SecretManagerServiceGrpc.class) {
        if ((getTestIamPermissionsMethod = SecretManagerServiceGrpc.getTestIamPermissionsMethod) == null) {
          SecretManagerServiceGrpc.getTestIamPermissionsMethod = getTestIamPermissionsMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TestIamPermissions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.TestIamPermissionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SecretManagerServiceMethodDescriptorSupplier("TestIamPermissions"))
              .build();
        }
      }
    }
    return getTestIamPermissionsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SecretManagerServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecretManagerServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SecretManagerServiceStub>() {
        @java.lang.Override
        public SecretManagerServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SecretManagerServiceStub(channel, callOptions);
        }
      };
    return SecretManagerServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SecretManagerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecretManagerServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SecretManagerServiceBlockingStub>() {
        @java.lang.Override
        public SecretManagerServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SecretManagerServiceBlockingStub(channel, callOptions);
        }
      };
    return SecretManagerServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SecretManagerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecretManagerServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SecretManagerServiceFutureStub>() {
        @java.lang.Override
        public SecretManagerServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SecretManagerServiceFutureStub(channel, callOptions);
        }
      };
    return SecretManagerServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Secret Manager Service
   * Manages secrets and operations using those secrets. Implements a REST
   * model with the following objects:
   * * [Secret][google.cloud.secretmanager.v1.Secret]
   * * [SecretVersion][google.cloud.secretmanager.v1.SecretVersion]
   * </pre>
   */
  public static abstract class SecretManagerServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists [Secrets][google.cloud.secretmanager.v1.Secret].
     * </pre>
     */
    public void listSecrets(com.google.cloud.secretmanager.v1.ListSecretsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.secretmanager.v1.ListSecretsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListSecretsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new [Secret][google.cloud.secretmanager.v1.Secret] containing no [SecretVersions][google.cloud.secretmanager.v1.SecretVersion].
     * </pre>
     */
    public void createSecret(com.google.cloud.secretmanager.v1.CreateSecretRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.secretmanager.v1.Secret> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateSecretMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new [SecretVersion][google.cloud.secretmanager.v1.SecretVersion] containing secret data and attaches
     * it to an existing [Secret][google.cloud.secretmanager.v1.Secret].
     * </pre>
     */
    public void addSecretVersion(com.google.cloud.secretmanager.v1.AddSecretVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.secretmanager.v1.SecretVersion> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddSecretVersionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets metadata for a given [Secret][google.cloud.secretmanager.v1.Secret].
     * </pre>
     */
    public void getSecret(com.google.cloud.secretmanager.v1.GetSecretRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.secretmanager.v1.Secret> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSecretMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates metadata of an existing [Secret][google.cloud.secretmanager.v1.Secret].
     * </pre>
     */
    public void updateSecret(com.google.cloud.secretmanager.v1.UpdateSecretRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.secretmanager.v1.Secret> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateSecretMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a [Secret][google.cloud.secretmanager.v1.Secret].
     * </pre>
     */
    public void deleteSecret(com.google.cloud.secretmanager.v1.DeleteSecretRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteSecretMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists [SecretVersions][google.cloud.secretmanager.v1.SecretVersion]. This call does not return secret
     * data.
     * </pre>
     */
    public void listSecretVersions(com.google.cloud.secretmanager.v1.ListSecretVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.secretmanager.v1.ListSecretVersionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListSecretVersionsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets metadata for a [SecretVersion][google.cloud.secretmanager.v1.SecretVersion].
     * `projects/&#42;&#47;secrets/&#42;&#47;versions/latest` is an alias to the most recently
     * created [SecretVersion][google.cloud.secretmanager.v1.SecretVersion].
     * </pre>
     */
    public void getSecretVersion(com.google.cloud.secretmanager.v1.GetSecretVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.secretmanager.v1.SecretVersion> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSecretVersionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Accesses a [SecretVersion][google.cloud.secretmanager.v1.SecretVersion]. This call returns the secret data.
     * `projects/&#42;&#47;secrets/&#42;&#47;versions/latest` is an alias to the most recently
     * created [SecretVersion][google.cloud.secretmanager.v1.SecretVersion].
     * </pre>
     */
    public void accessSecretVersion(com.google.cloud.secretmanager.v1.AccessSecretVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.secretmanager.v1.AccessSecretVersionResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAccessSecretVersionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Disables a [SecretVersion][google.cloud.secretmanager.v1.SecretVersion].
     * Sets the [state][google.cloud.secretmanager.v1.SecretVersion.state] of the [SecretVersion][google.cloud.secretmanager.v1.SecretVersion] to
     * [DISABLED][google.cloud.secretmanager.v1.SecretVersion.State.DISABLED].
     * </pre>
     */
    public void disableSecretVersion(com.google.cloud.secretmanager.v1.DisableSecretVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.secretmanager.v1.SecretVersion> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDisableSecretVersionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Enables a [SecretVersion][google.cloud.secretmanager.v1.SecretVersion].
     * Sets the [state][google.cloud.secretmanager.v1.SecretVersion.state] of the [SecretVersion][google.cloud.secretmanager.v1.SecretVersion] to
     * [ENABLED][google.cloud.secretmanager.v1.SecretVersion.State.ENABLED].
     * </pre>
     */
    public void enableSecretVersion(com.google.cloud.secretmanager.v1.EnableSecretVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.secretmanager.v1.SecretVersion> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEnableSecretVersionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Destroys a [SecretVersion][google.cloud.secretmanager.v1.SecretVersion].
     * Sets the [state][google.cloud.secretmanager.v1.SecretVersion.state] of the [SecretVersion][google.cloud.secretmanager.v1.SecretVersion] to
     * [DESTROYED][google.cloud.secretmanager.v1.SecretVersion.State.DESTROYED] and irrevocably destroys the
     * secret data.
     * </pre>
     */
    public void destroySecretVersion(com.google.cloud.secretmanager.v1.DestroySecretVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.secretmanager.v1.SecretVersion> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDestroySecretVersionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Sets the access control policy on the specified secret. Replaces any
     * existing policy.
     * Permissions on [SecretVersions][google.cloud.secretmanager.v1.SecretVersion] are enforced according
     * to the policy set on the associated [Secret][google.cloud.secretmanager.v1.Secret].
     * </pre>
     */
    public void setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetIamPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the access control policy for a secret.
     * Returns empty policy if the secret exists and does not have a policy set.
     * </pre>
     */
    public void getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetIamPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns permissions that a caller has for the specified secret.
     * If the secret does not exist, this call returns an empty set of
     * permissions, not a NOT_FOUND error.
     * Note: This operation is designed to be used for building permission-aware
     * UIs and command-line tools, not for authorization checking. This operation
     * may "fail open" without warning.
     * </pre>
     */
    public void testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTestIamPermissionsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListSecretsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.secretmanager.v1.ListSecretsRequest,
                com.google.cloud.secretmanager.v1.ListSecretsResponse>(
                  this, METHODID_LIST_SECRETS)))
          .addMethod(
            getCreateSecretMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.secretmanager.v1.CreateSecretRequest,
                com.google.cloud.secretmanager.v1.Secret>(
                  this, METHODID_CREATE_SECRET)))
          .addMethod(
            getAddSecretVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.secretmanager.v1.AddSecretVersionRequest,
                com.google.cloud.secretmanager.v1.SecretVersion>(
                  this, METHODID_ADD_SECRET_VERSION)))
          .addMethod(
            getGetSecretMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.secretmanager.v1.GetSecretRequest,
                com.google.cloud.secretmanager.v1.Secret>(
                  this, METHODID_GET_SECRET)))
          .addMethod(
            getUpdateSecretMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.secretmanager.v1.UpdateSecretRequest,
                com.google.cloud.secretmanager.v1.Secret>(
                  this, METHODID_UPDATE_SECRET)))
          .addMethod(
            getDeleteSecretMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.secretmanager.v1.DeleteSecretRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_SECRET)))
          .addMethod(
            getListSecretVersionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.secretmanager.v1.ListSecretVersionsRequest,
                com.google.cloud.secretmanager.v1.ListSecretVersionsResponse>(
                  this, METHODID_LIST_SECRET_VERSIONS)))
          .addMethod(
            getGetSecretVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.secretmanager.v1.GetSecretVersionRequest,
                com.google.cloud.secretmanager.v1.SecretVersion>(
                  this, METHODID_GET_SECRET_VERSION)))
          .addMethod(
            getAccessSecretVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.secretmanager.v1.AccessSecretVersionRequest,
                com.google.cloud.secretmanager.v1.AccessSecretVersionResponse>(
                  this, METHODID_ACCESS_SECRET_VERSION)))
          .addMethod(
            getDisableSecretVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.secretmanager.v1.DisableSecretVersionRequest,
                com.google.cloud.secretmanager.v1.SecretVersion>(
                  this, METHODID_DISABLE_SECRET_VERSION)))
          .addMethod(
            getEnableSecretVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.secretmanager.v1.EnableSecretVersionRequest,
                com.google.cloud.secretmanager.v1.SecretVersion>(
                  this, METHODID_ENABLE_SECRET_VERSION)))
          .addMethod(
            getDestroySecretVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.secretmanager.v1.DestroySecretVersionRequest,
                com.google.cloud.secretmanager.v1.SecretVersion>(
                  this, METHODID_DESTROY_SECRET_VERSION)))
          .addMethod(
            getSetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.SetIamPolicyRequest,
                com.google.iam.v1.Policy>(
                  this, METHODID_SET_IAM_POLICY)))
          .addMethod(
            getGetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.GetIamPolicyRequest,
                com.google.iam.v1.Policy>(
                  this, METHODID_GET_IAM_POLICY)))
          .addMethod(
            getTestIamPermissionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.TestIamPermissionsRequest,
                com.google.iam.v1.TestIamPermissionsResponse>(
                  this, METHODID_TEST_IAM_PERMISSIONS)))
          .build();
    }
  }

  /**
   * <pre>
   * Secret Manager Service
   * Manages secrets and operations using those secrets. Implements a REST
   * model with the following objects:
   * * [Secret][google.cloud.secretmanager.v1.Secret]
   * * [SecretVersion][google.cloud.secretmanager.v1.SecretVersion]
   * </pre>
   */
  public static final class SecretManagerServiceStub extends io.grpc.stub.AbstractAsyncStub<SecretManagerServiceStub> {
    private SecretManagerServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecretManagerServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecretManagerServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists [Secrets][google.cloud.secretmanager.v1.Secret].
     * </pre>
     */
    public void listSecrets(com.google.cloud.secretmanager.v1.ListSecretsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.secretmanager.v1.ListSecretsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSecretsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new [Secret][google.cloud.secretmanager.v1.Secret] containing no [SecretVersions][google.cloud.secretmanager.v1.SecretVersion].
     * </pre>
     */
    public void createSecret(com.google.cloud.secretmanager.v1.CreateSecretRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.secretmanager.v1.Secret> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSecretMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new [SecretVersion][google.cloud.secretmanager.v1.SecretVersion] containing secret data and attaches
     * it to an existing [Secret][google.cloud.secretmanager.v1.Secret].
     * </pre>
     */
    public void addSecretVersion(com.google.cloud.secretmanager.v1.AddSecretVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.secretmanager.v1.SecretVersion> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddSecretVersionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets metadata for a given [Secret][google.cloud.secretmanager.v1.Secret].
     * </pre>
     */
    public void getSecret(com.google.cloud.secretmanager.v1.GetSecretRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.secretmanager.v1.Secret> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSecretMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates metadata of an existing [Secret][google.cloud.secretmanager.v1.Secret].
     * </pre>
     */
    public void updateSecret(com.google.cloud.secretmanager.v1.UpdateSecretRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.secretmanager.v1.Secret> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSecretMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a [Secret][google.cloud.secretmanager.v1.Secret].
     * </pre>
     */
    public void deleteSecret(com.google.cloud.secretmanager.v1.DeleteSecretRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSecretMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists [SecretVersions][google.cloud.secretmanager.v1.SecretVersion]. This call does not return secret
     * data.
     * </pre>
     */
    public void listSecretVersions(com.google.cloud.secretmanager.v1.ListSecretVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.secretmanager.v1.ListSecretVersionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSecretVersionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets metadata for a [SecretVersion][google.cloud.secretmanager.v1.SecretVersion].
     * `projects/&#42;&#47;secrets/&#42;&#47;versions/latest` is an alias to the most recently
     * created [SecretVersion][google.cloud.secretmanager.v1.SecretVersion].
     * </pre>
     */
    public void getSecretVersion(com.google.cloud.secretmanager.v1.GetSecretVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.secretmanager.v1.SecretVersion> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSecretVersionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Accesses a [SecretVersion][google.cloud.secretmanager.v1.SecretVersion]. This call returns the secret data.
     * `projects/&#42;&#47;secrets/&#42;&#47;versions/latest` is an alias to the most recently
     * created [SecretVersion][google.cloud.secretmanager.v1.SecretVersion].
     * </pre>
     */
    public void accessSecretVersion(com.google.cloud.secretmanager.v1.AccessSecretVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.secretmanager.v1.AccessSecretVersionResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAccessSecretVersionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Disables a [SecretVersion][google.cloud.secretmanager.v1.SecretVersion].
     * Sets the [state][google.cloud.secretmanager.v1.SecretVersion.state] of the [SecretVersion][google.cloud.secretmanager.v1.SecretVersion] to
     * [DISABLED][google.cloud.secretmanager.v1.SecretVersion.State.DISABLED].
     * </pre>
     */
    public void disableSecretVersion(com.google.cloud.secretmanager.v1.DisableSecretVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.secretmanager.v1.SecretVersion> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDisableSecretVersionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Enables a [SecretVersion][google.cloud.secretmanager.v1.SecretVersion].
     * Sets the [state][google.cloud.secretmanager.v1.SecretVersion.state] of the [SecretVersion][google.cloud.secretmanager.v1.SecretVersion] to
     * [ENABLED][google.cloud.secretmanager.v1.SecretVersion.State.ENABLED].
     * </pre>
     */
    public void enableSecretVersion(com.google.cloud.secretmanager.v1.EnableSecretVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.secretmanager.v1.SecretVersion> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEnableSecretVersionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Destroys a [SecretVersion][google.cloud.secretmanager.v1.SecretVersion].
     * Sets the [state][google.cloud.secretmanager.v1.SecretVersion.state] of the [SecretVersion][google.cloud.secretmanager.v1.SecretVersion] to
     * [DESTROYED][google.cloud.secretmanager.v1.SecretVersion.State.DESTROYED] and irrevocably destroys the
     * secret data.
     * </pre>
     */
    public void destroySecretVersion(com.google.cloud.secretmanager.v1.DestroySecretVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.secretmanager.v1.SecretVersion> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDestroySecretVersionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Sets the access control policy on the specified secret. Replaces any
     * existing policy.
     * Permissions on [SecretVersions][google.cloud.secretmanager.v1.SecretVersion] are enforced according
     * to the policy set on the associated [Secret][google.cloud.secretmanager.v1.Secret].
     * </pre>
     */
    public void setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the access control policy for a secret.
     * Returns empty policy if the secret exists and does not have a policy set.
     * </pre>
     */
    public void getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns permissions that a caller has for the specified secret.
     * If the secret does not exist, this call returns an empty set of
     * permissions, not a NOT_FOUND error.
     * Note: This operation is designed to be used for building permission-aware
     * UIs and command-line tools, not for authorization checking. This operation
     * may "fail open" without warning.
     * </pre>
     */
    public void testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Secret Manager Service
   * Manages secrets and operations using those secrets. Implements a REST
   * model with the following objects:
   * * [Secret][google.cloud.secretmanager.v1.Secret]
   * * [SecretVersion][google.cloud.secretmanager.v1.SecretVersion]
   * </pre>
   */
  public static final class SecretManagerServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<SecretManagerServiceBlockingStub> {
    private SecretManagerServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecretManagerServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecretManagerServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists [Secrets][google.cloud.secretmanager.v1.Secret].
     * </pre>
     */
    public com.google.cloud.secretmanager.v1.ListSecretsResponse listSecrets(com.google.cloud.secretmanager.v1.ListSecretsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSecretsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new [Secret][google.cloud.secretmanager.v1.Secret] containing no [SecretVersions][google.cloud.secretmanager.v1.SecretVersion].
     * </pre>
     */
    public com.google.cloud.secretmanager.v1.Secret createSecret(com.google.cloud.secretmanager.v1.CreateSecretRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSecretMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new [SecretVersion][google.cloud.secretmanager.v1.SecretVersion] containing secret data and attaches
     * it to an existing [Secret][google.cloud.secretmanager.v1.Secret].
     * </pre>
     */
    public com.google.cloud.secretmanager.v1.SecretVersion addSecretVersion(com.google.cloud.secretmanager.v1.AddSecretVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddSecretVersionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets metadata for a given [Secret][google.cloud.secretmanager.v1.Secret].
     * </pre>
     */
    public com.google.cloud.secretmanager.v1.Secret getSecret(com.google.cloud.secretmanager.v1.GetSecretRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSecretMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates metadata of an existing [Secret][google.cloud.secretmanager.v1.Secret].
     * </pre>
     */
    public com.google.cloud.secretmanager.v1.Secret updateSecret(com.google.cloud.secretmanager.v1.UpdateSecretRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSecretMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a [Secret][google.cloud.secretmanager.v1.Secret].
     * </pre>
     */
    public com.google.protobuf.Empty deleteSecret(com.google.cloud.secretmanager.v1.DeleteSecretRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSecretMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists [SecretVersions][google.cloud.secretmanager.v1.SecretVersion]. This call does not return secret
     * data.
     * </pre>
     */
    public com.google.cloud.secretmanager.v1.ListSecretVersionsResponse listSecretVersions(com.google.cloud.secretmanager.v1.ListSecretVersionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSecretVersionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets metadata for a [SecretVersion][google.cloud.secretmanager.v1.SecretVersion].
     * `projects/&#42;&#47;secrets/&#42;&#47;versions/latest` is an alias to the most recently
     * created [SecretVersion][google.cloud.secretmanager.v1.SecretVersion].
     * </pre>
     */
    public com.google.cloud.secretmanager.v1.SecretVersion getSecretVersion(com.google.cloud.secretmanager.v1.GetSecretVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSecretVersionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Accesses a [SecretVersion][google.cloud.secretmanager.v1.SecretVersion]. This call returns the secret data.
     * `projects/&#42;&#47;secrets/&#42;&#47;versions/latest` is an alias to the most recently
     * created [SecretVersion][google.cloud.secretmanager.v1.SecretVersion].
     * </pre>
     */
    public com.google.cloud.secretmanager.v1.AccessSecretVersionResponse accessSecretVersion(com.google.cloud.secretmanager.v1.AccessSecretVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAccessSecretVersionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Disables a [SecretVersion][google.cloud.secretmanager.v1.SecretVersion].
     * Sets the [state][google.cloud.secretmanager.v1.SecretVersion.state] of the [SecretVersion][google.cloud.secretmanager.v1.SecretVersion] to
     * [DISABLED][google.cloud.secretmanager.v1.SecretVersion.State.DISABLED].
     * </pre>
     */
    public com.google.cloud.secretmanager.v1.SecretVersion disableSecretVersion(com.google.cloud.secretmanager.v1.DisableSecretVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDisableSecretVersionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Enables a [SecretVersion][google.cloud.secretmanager.v1.SecretVersion].
     * Sets the [state][google.cloud.secretmanager.v1.SecretVersion.state] of the [SecretVersion][google.cloud.secretmanager.v1.SecretVersion] to
     * [ENABLED][google.cloud.secretmanager.v1.SecretVersion.State.ENABLED].
     * </pre>
     */
    public com.google.cloud.secretmanager.v1.SecretVersion enableSecretVersion(com.google.cloud.secretmanager.v1.EnableSecretVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEnableSecretVersionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Destroys a [SecretVersion][google.cloud.secretmanager.v1.SecretVersion].
     * Sets the [state][google.cloud.secretmanager.v1.SecretVersion.state] of the [SecretVersion][google.cloud.secretmanager.v1.SecretVersion] to
     * [DESTROYED][google.cloud.secretmanager.v1.SecretVersion.State.DESTROYED] and irrevocably destroys the
     * secret data.
     * </pre>
     */
    public com.google.cloud.secretmanager.v1.SecretVersion destroySecretVersion(com.google.cloud.secretmanager.v1.DestroySecretVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDestroySecretVersionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Sets the access control policy on the specified secret. Replaces any
     * existing policy.
     * Permissions on [SecretVersions][google.cloud.secretmanager.v1.SecretVersion] are enforced according
     * to the policy set on the associated [Secret][google.cloud.secretmanager.v1.Secret].
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the access control policy for a secret.
     * Returns empty policy if the secret exists and does not have a policy set.
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns permissions that a caller has for the specified secret.
     * If the secret does not exist, this call returns an empty set of
     * permissions, not a NOT_FOUND error.
     * Note: This operation is designed to be used for building permission-aware
     * UIs and command-line tools, not for authorization checking. This operation
     * may "fail open" without warning.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Secret Manager Service
   * Manages secrets and operations using those secrets. Implements a REST
   * model with the following objects:
   * * [Secret][google.cloud.secretmanager.v1.Secret]
   * * [SecretVersion][google.cloud.secretmanager.v1.SecretVersion]
   * </pre>
   */
  public static final class SecretManagerServiceFutureStub extends io.grpc.stub.AbstractFutureStub<SecretManagerServiceFutureStub> {
    private SecretManagerServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecretManagerServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecretManagerServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists [Secrets][google.cloud.secretmanager.v1.Secret].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.secretmanager.v1.ListSecretsResponse> listSecrets(
        com.google.cloud.secretmanager.v1.ListSecretsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSecretsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new [Secret][google.cloud.secretmanager.v1.Secret] containing no [SecretVersions][google.cloud.secretmanager.v1.SecretVersion].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.secretmanager.v1.Secret> createSecret(
        com.google.cloud.secretmanager.v1.CreateSecretRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSecretMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new [SecretVersion][google.cloud.secretmanager.v1.SecretVersion] containing secret data and attaches
     * it to an existing [Secret][google.cloud.secretmanager.v1.Secret].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.secretmanager.v1.SecretVersion> addSecretVersion(
        com.google.cloud.secretmanager.v1.AddSecretVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddSecretVersionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets metadata for a given [Secret][google.cloud.secretmanager.v1.Secret].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.secretmanager.v1.Secret> getSecret(
        com.google.cloud.secretmanager.v1.GetSecretRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSecretMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates metadata of an existing [Secret][google.cloud.secretmanager.v1.Secret].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.secretmanager.v1.Secret> updateSecret(
        com.google.cloud.secretmanager.v1.UpdateSecretRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSecretMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a [Secret][google.cloud.secretmanager.v1.Secret].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteSecret(
        com.google.cloud.secretmanager.v1.DeleteSecretRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSecretMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists [SecretVersions][google.cloud.secretmanager.v1.SecretVersion]. This call does not return secret
     * data.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.secretmanager.v1.ListSecretVersionsResponse> listSecretVersions(
        com.google.cloud.secretmanager.v1.ListSecretVersionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSecretVersionsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets metadata for a [SecretVersion][google.cloud.secretmanager.v1.SecretVersion].
     * `projects/&#42;&#47;secrets/&#42;&#47;versions/latest` is an alias to the most recently
     * created [SecretVersion][google.cloud.secretmanager.v1.SecretVersion].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.secretmanager.v1.SecretVersion> getSecretVersion(
        com.google.cloud.secretmanager.v1.GetSecretVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSecretVersionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Accesses a [SecretVersion][google.cloud.secretmanager.v1.SecretVersion]. This call returns the secret data.
     * `projects/&#42;&#47;secrets/&#42;&#47;versions/latest` is an alias to the most recently
     * created [SecretVersion][google.cloud.secretmanager.v1.SecretVersion].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.secretmanager.v1.AccessSecretVersionResponse> accessSecretVersion(
        com.google.cloud.secretmanager.v1.AccessSecretVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAccessSecretVersionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Disables a [SecretVersion][google.cloud.secretmanager.v1.SecretVersion].
     * Sets the [state][google.cloud.secretmanager.v1.SecretVersion.state] of the [SecretVersion][google.cloud.secretmanager.v1.SecretVersion] to
     * [DISABLED][google.cloud.secretmanager.v1.SecretVersion.State.DISABLED].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.secretmanager.v1.SecretVersion> disableSecretVersion(
        com.google.cloud.secretmanager.v1.DisableSecretVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDisableSecretVersionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Enables a [SecretVersion][google.cloud.secretmanager.v1.SecretVersion].
     * Sets the [state][google.cloud.secretmanager.v1.SecretVersion.state] of the [SecretVersion][google.cloud.secretmanager.v1.SecretVersion] to
     * [ENABLED][google.cloud.secretmanager.v1.SecretVersion.State.ENABLED].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.secretmanager.v1.SecretVersion> enableSecretVersion(
        com.google.cloud.secretmanager.v1.EnableSecretVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEnableSecretVersionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Destroys a [SecretVersion][google.cloud.secretmanager.v1.SecretVersion].
     * Sets the [state][google.cloud.secretmanager.v1.SecretVersion.state] of the [SecretVersion][google.cloud.secretmanager.v1.SecretVersion] to
     * [DESTROYED][google.cloud.secretmanager.v1.SecretVersion.State.DESTROYED] and irrevocably destroys the
     * secret data.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.secretmanager.v1.SecretVersion> destroySecretVersion(
        com.google.cloud.secretmanager.v1.DestroySecretVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDestroySecretVersionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Sets the access control policy on the specified secret. Replaces any
     * existing policy.
     * Permissions on [SecretVersions][google.cloud.secretmanager.v1.SecretVersion] are enforced according
     * to the policy set on the associated [Secret][google.cloud.secretmanager.v1.Secret].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy> setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the access control policy for a secret.
     * Returns empty policy if the secret exists and does not have a policy set.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy> getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns permissions that a caller has for the specified secret.
     * If the secret does not exist, this call returns an empty set of
     * permissions, not a NOT_FOUND error.
     * Note: This operation is designed to be used for building permission-aware
     * UIs and command-line tools, not for authorization checking. This operation
     * may "fail open" without warning.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.TestIamPermissionsResponse> testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_SECRETS = 0;
  private static final int METHODID_CREATE_SECRET = 1;
  private static final int METHODID_ADD_SECRET_VERSION = 2;
  private static final int METHODID_GET_SECRET = 3;
  private static final int METHODID_UPDATE_SECRET = 4;
  private static final int METHODID_DELETE_SECRET = 5;
  private static final int METHODID_LIST_SECRET_VERSIONS = 6;
  private static final int METHODID_GET_SECRET_VERSION = 7;
  private static final int METHODID_ACCESS_SECRET_VERSION = 8;
  private static final int METHODID_DISABLE_SECRET_VERSION = 9;
  private static final int METHODID_ENABLE_SECRET_VERSION = 10;
  private static final int METHODID_DESTROY_SECRET_VERSION = 11;
  private static final int METHODID_SET_IAM_POLICY = 12;
  private static final int METHODID_GET_IAM_POLICY = 13;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 14;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SecretManagerServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SecretManagerServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_SECRETS:
          serviceImpl.listSecrets((com.google.cloud.secretmanager.v1.ListSecretsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.secretmanager.v1.ListSecretsResponse>) responseObserver);
          break;
        case METHODID_CREATE_SECRET:
          serviceImpl.createSecret((com.google.cloud.secretmanager.v1.CreateSecretRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.secretmanager.v1.Secret>) responseObserver);
          break;
        case METHODID_ADD_SECRET_VERSION:
          serviceImpl.addSecretVersion((com.google.cloud.secretmanager.v1.AddSecretVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.secretmanager.v1.SecretVersion>) responseObserver);
          break;
        case METHODID_GET_SECRET:
          serviceImpl.getSecret((com.google.cloud.secretmanager.v1.GetSecretRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.secretmanager.v1.Secret>) responseObserver);
          break;
        case METHODID_UPDATE_SECRET:
          serviceImpl.updateSecret((com.google.cloud.secretmanager.v1.UpdateSecretRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.secretmanager.v1.Secret>) responseObserver);
          break;
        case METHODID_DELETE_SECRET:
          serviceImpl.deleteSecret((com.google.cloud.secretmanager.v1.DeleteSecretRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_SECRET_VERSIONS:
          serviceImpl.listSecretVersions((com.google.cloud.secretmanager.v1.ListSecretVersionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.secretmanager.v1.ListSecretVersionsResponse>) responseObserver);
          break;
        case METHODID_GET_SECRET_VERSION:
          serviceImpl.getSecretVersion((com.google.cloud.secretmanager.v1.GetSecretVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.secretmanager.v1.SecretVersion>) responseObserver);
          break;
        case METHODID_ACCESS_SECRET_VERSION:
          serviceImpl.accessSecretVersion((com.google.cloud.secretmanager.v1.AccessSecretVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.secretmanager.v1.AccessSecretVersionResponse>) responseObserver);
          break;
        case METHODID_DISABLE_SECRET_VERSION:
          serviceImpl.disableSecretVersion((com.google.cloud.secretmanager.v1.DisableSecretVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.secretmanager.v1.SecretVersion>) responseObserver);
          break;
        case METHODID_ENABLE_SECRET_VERSION:
          serviceImpl.enableSecretVersion((com.google.cloud.secretmanager.v1.EnableSecretVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.secretmanager.v1.SecretVersion>) responseObserver);
          break;
        case METHODID_DESTROY_SECRET_VERSION:
          serviceImpl.destroySecretVersion((com.google.cloud.secretmanager.v1.DestroySecretVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.secretmanager.v1.SecretVersion>) responseObserver);
          break;
        case METHODID_SET_IAM_POLICY:
          serviceImpl.setIamPolicy((com.google.iam.v1.SetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_GET_IAM_POLICY:
          serviceImpl.getIamPolicy((com.google.iam.v1.GetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_TEST_IAM_PERMISSIONS:
          serviceImpl.testIamPermissions((com.google.iam.v1.TestIamPermissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>) responseObserver);
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

  private static abstract class SecretManagerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SecretManagerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.secretmanager.v1.ServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SecretManagerService");
    }
  }

  private static final class SecretManagerServiceFileDescriptorSupplier
      extends SecretManagerServiceBaseDescriptorSupplier {
    SecretManagerServiceFileDescriptorSupplier() {}
  }

  private static final class SecretManagerServiceMethodDescriptorSupplier
      extends SecretManagerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SecretManagerServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SecretManagerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SecretManagerServiceFileDescriptorSupplier())
              .addMethod(getListSecretsMethod())
              .addMethod(getCreateSecretMethod())
              .addMethod(getAddSecretVersionMethod())
              .addMethod(getGetSecretMethod())
              .addMethod(getUpdateSecretMethod())
              .addMethod(getDeleteSecretMethod())
              .addMethod(getListSecretVersionsMethod())
              .addMethod(getGetSecretVersionMethod())
              .addMethod(getAccessSecretVersionMethod())
              .addMethod(getDisableSecretVersionMethod())
              .addMethod(getEnableSecretVersionMethod())
              .addMethod(getDestroySecretVersionMethod())
              .addMethod(getSetIamPolicyMethod())
              .addMethod(getGetIamPolicyMethod())
              .addMethod(getTestIamPermissionsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
