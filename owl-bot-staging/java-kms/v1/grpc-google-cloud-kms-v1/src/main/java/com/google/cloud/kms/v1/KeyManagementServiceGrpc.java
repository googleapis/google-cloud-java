package com.google.cloud.kms.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Google Cloud Key Management Service
 * Manages cryptographic keys and operations using those keys. Implements a REST
 * model with the following objects:
 * * [KeyRing][google.cloud.kms.v1.KeyRing]
 * * [CryptoKey][google.cloud.kms.v1.CryptoKey]
 * * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
 * * [ImportJob][google.cloud.kms.v1.ImportJob]
 * If you are using manual gRPC libraries, see
 * [Using gRPC with Cloud KMS](https://cloud.google.com/kms/docs/grpc).
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/kms/v1/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class KeyManagementServiceGrpc {

  private KeyManagementServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.kms.v1.KeyManagementService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.kms.v1.ListKeyRingsRequest,
      com.google.cloud.kms.v1.ListKeyRingsResponse> getListKeyRingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListKeyRings",
      requestType = com.google.cloud.kms.v1.ListKeyRingsRequest.class,
      responseType = com.google.cloud.kms.v1.ListKeyRingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.kms.v1.ListKeyRingsRequest,
      com.google.cloud.kms.v1.ListKeyRingsResponse> getListKeyRingsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.kms.v1.ListKeyRingsRequest, com.google.cloud.kms.v1.ListKeyRingsResponse> getListKeyRingsMethod;
    if ((getListKeyRingsMethod = KeyManagementServiceGrpc.getListKeyRingsMethod) == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getListKeyRingsMethod = KeyManagementServiceGrpc.getListKeyRingsMethod) == null) {
          KeyManagementServiceGrpc.getListKeyRingsMethod = getListKeyRingsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.kms.v1.ListKeyRingsRequest, com.google.cloud.kms.v1.ListKeyRingsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListKeyRings"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.ListKeyRingsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.ListKeyRingsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new KeyManagementServiceMethodDescriptorSupplier("ListKeyRings"))
              .build();
        }
      }
    }
    return getListKeyRingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.kms.v1.ListCryptoKeysRequest,
      com.google.cloud.kms.v1.ListCryptoKeysResponse> getListCryptoKeysMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCryptoKeys",
      requestType = com.google.cloud.kms.v1.ListCryptoKeysRequest.class,
      responseType = com.google.cloud.kms.v1.ListCryptoKeysResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.kms.v1.ListCryptoKeysRequest,
      com.google.cloud.kms.v1.ListCryptoKeysResponse> getListCryptoKeysMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.kms.v1.ListCryptoKeysRequest, com.google.cloud.kms.v1.ListCryptoKeysResponse> getListCryptoKeysMethod;
    if ((getListCryptoKeysMethod = KeyManagementServiceGrpc.getListCryptoKeysMethod) == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getListCryptoKeysMethod = KeyManagementServiceGrpc.getListCryptoKeysMethod) == null) {
          KeyManagementServiceGrpc.getListCryptoKeysMethod = getListCryptoKeysMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.kms.v1.ListCryptoKeysRequest, com.google.cloud.kms.v1.ListCryptoKeysResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCryptoKeys"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.ListCryptoKeysRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.ListCryptoKeysResponse.getDefaultInstance()))
              .setSchemaDescriptor(new KeyManagementServiceMethodDescriptorSupplier("ListCryptoKeys"))
              .build();
        }
      }
    }
    return getListCryptoKeysMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.kms.v1.ListCryptoKeyVersionsRequest,
      com.google.cloud.kms.v1.ListCryptoKeyVersionsResponse> getListCryptoKeyVersionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCryptoKeyVersions",
      requestType = com.google.cloud.kms.v1.ListCryptoKeyVersionsRequest.class,
      responseType = com.google.cloud.kms.v1.ListCryptoKeyVersionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.kms.v1.ListCryptoKeyVersionsRequest,
      com.google.cloud.kms.v1.ListCryptoKeyVersionsResponse> getListCryptoKeyVersionsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.kms.v1.ListCryptoKeyVersionsRequest, com.google.cloud.kms.v1.ListCryptoKeyVersionsResponse> getListCryptoKeyVersionsMethod;
    if ((getListCryptoKeyVersionsMethod = KeyManagementServiceGrpc.getListCryptoKeyVersionsMethod) == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getListCryptoKeyVersionsMethod = KeyManagementServiceGrpc.getListCryptoKeyVersionsMethod) == null) {
          KeyManagementServiceGrpc.getListCryptoKeyVersionsMethod = getListCryptoKeyVersionsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.kms.v1.ListCryptoKeyVersionsRequest, com.google.cloud.kms.v1.ListCryptoKeyVersionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCryptoKeyVersions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.ListCryptoKeyVersionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.ListCryptoKeyVersionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new KeyManagementServiceMethodDescriptorSupplier("ListCryptoKeyVersions"))
              .build();
        }
      }
    }
    return getListCryptoKeyVersionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.kms.v1.ListImportJobsRequest,
      com.google.cloud.kms.v1.ListImportJobsResponse> getListImportJobsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListImportJobs",
      requestType = com.google.cloud.kms.v1.ListImportJobsRequest.class,
      responseType = com.google.cloud.kms.v1.ListImportJobsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.kms.v1.ListImportJobsRequest,
      com.google.cloud.kms.v1.ListImportJobsResponse> getListImportJobsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.kms.v1.ListImportJobsRequest, com.google.cloud.kms.v1.ListImportJobsResponse> getListImportJobsMethod;
    if ((getListImportJobsMethod = KeyManagementServiceGrpc.getListImportJobsMethod) == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getListImportJobsMethod = KeyManagementServiceGrpc.getListImportJobsMethod) == null) {
          KeyManagementServiceGrpc.getListImportJobsMethod = getListImportJobsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.kms.v1.ListImportJobsRequest, com.google.cloud.kms.v1.ListImportJobsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListImportJobs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.ListImportJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.ListImportJobsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new KeyManagementServiceMethodDescriptorSupplier("ListImportJobs"))
              .build();
        }
      }
    }
    return getListImportJobsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.kms.v1.GetKeyRingRequest,
      com.google.cloud.kms.v1.KeyRing> getGetKeyRingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetKeyRing",
      requestType = com.google.cloud.kms.v1.GetKeyRingRequest.class,
      responseType = com.google.cloud.kms.v1.KeyRing.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.kms.v1.GetKeyRingRequest,
      com.google.cloud.kms.v1.KeyRing> getGetKeyRingMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.kms.v1.GetKeyRingRequest, com.google.cloud.kms.v1.KeyRing> getGetKeyRingMethod;
    if ((getGetKeyRingMethod = KeyManagementServiceGrpc.getGetKeyRingMethod) == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getGetKeyRingMethod = KeyManagementServiceGrpc.getGetKeyRingMethod) == null) {
          KeyManagementServiceGrpc.getGetKeyRingMethod = getGetKeyRingMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.kms.v1.GetKeyRingRequest, com.google.cloud.kms.v1.KeyRing>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetKeyRing"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.GetKeyRingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.KeyRing.getDefaultInstance()))
              .setSchemaDescriptor(new KeyManagementServiceMethodDescriptorSupplier("GetKeyRing"))
              .build();
        }
      }
    }
    return getGetKeyRingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.kms.v1.GetCryptoKeyRequest,
      com.google.cloud.kms.v1.CryptoKey> getGetCryptoKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCryptoKey",
      requestType = com.google.cloud.kms.v1.GetCryptoKeyRequest.class,
      responseType = com.google.cloud.kms.v1.CryptoKey.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.kms.v1.GetCryptoKeyRequest,
      com.google.cloud.kms.v1.CryptoKey> getGetCryptoKeyMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.kms.v1.GetCryptoKeyRequest, com.google.cloud.kms.v1.CryptoKey> getGetCryptoKeyMethod;
    if ((getGetCryptoKeyMethod = KeyManagementServiceGrpc.getGetCryptoKeyMethod) == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getGetCryptoKeyMethod = KeyManagementServiceGrpc.getGetCryptoKeyMethod) == null) {
          KeyManagementServiceGrpc.getGetCryptoKeyMethod = getGetCryptoKeyMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.kms.v1.GetCryptoKeyRequest, com.google.cloud.kms.v1.CryptoKey>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCryptoKey"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.GetCryptoKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.CryptoKey.getDefaultInstance()))
              .setSchemaDescriptor(new KeyManagementServiceMethodDescriptorSupplier("GetCryptoKey"))
              .build();
        }
      }
    }
    return getGetCryptoKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.kms.v1.GetCryptoKeyVersionRequest,
      com.google.cloud.kms.v1.CryptoKeyVersion> getGetCryptoKeyVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCryptoKeyVersion",
      requestType = com.google.cloud.kms.v1.GetCryptoKeyVersionRequest.class,
      responseType = com.google.cloud.kms.v1.CryptoKeyVersion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.kms.v1.GetCryptoKeyVersionRequest,
      com.google.cloud.kms.v1.CryptoKeyVersion> getGetCryptoKeyVersionMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.kms.v1.GetCryptoKeyVersionRequest, com.google.cloud.kms.v1.CryptoKeyVersion> getGetCryptoKeyVersionMethod;
    if ((getGetCryptoKeyVersionMethod = KeyManagementServiceGrpc.getGetCryptoKeyVersionMethod) == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getGetCryptoKeyVersionMethod = KeyManagementServiceGrpc.getGetCryptoKeyVersionMethod) == null) {
          KeyManagementServiceGrpc.getGetCryptoKeyVersionMethod = getGetCryptoKeyVersionMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.kms.v1.GetCryptoKeyVersionRequest, com.google.cloud.kms.v1.CryptoKeyVersion>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCryptoKeyVersion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.GetCryptoKeyVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.CryptoKeyVersion.getDefaultInstance()))
              .setSchemaDescriptor(new KeyManagementServiceMethodDescriptorSupplier("GetCryptoKeyVersion"))
              .build();
        }
      }
    }
    return getGetCryptoKeyVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.kms.v1.GetPublicKeyRequest,
      com.google.cloud.kms.v1.PublicKey> getGetPublicKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPublicKey",
      requestType = com.google.cloud.kms.v1.GetPublicKeyRequest.class,
      responseType = com.google.cloud.kms.v1.PublicKey.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.kms.v1.GetPublicKeyRequest,
      com.google.cloud.kms.v1.PublicKey> getGetPublicKeyMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.kms.v1.GetPublicKeyRequest, com.google.cloud.kms.v1.PublicKey> getGetPublicKeyMethod;
    if ((getGetPublicKeyMethod = KeyManagementServiceGrpc.getGetPublicKeyMethod) == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getGetPublicKeyMethod = KeyManagementServiceGrpc.getGetPublicKeyMethod) == null) {
          KeyManagementServiceGrpc.getGetPublicKeyMethod = getGetPublicKeyMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.kms.v1.GetPublicKeyRequest, com.google.cloud.kms.v1.PublicKey>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPublicKey"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.GetPublicKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.PublicKey.getDefaultInstance()))
              .setSchemaDescriptor(new KeyManagementServiceMethodDescriptorSupplier("GetPublicKey"))
              .build();
        }
      }
    }
    return getGetPublicKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.kms.v1.GetImportJobRequest,
      com.google.cloud.kms.v1.ImportJob> getGetImportJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetImportJob",
      requestType = com.google.cloud.kms.v1.GetImportJobRequest.class,
      responseType = com.google.cloud.kms.v1.ImportJob.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.kms.v1.GetImportJobRequest,
      com.google.cloud.kms.v1.ImportJob> getGetImportJobMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.kms.v1.GetImportJobRequest, com.google.cloud.kms.v1.ImportJob> getGetImportJobMethod;
    if ((getGetImportJobMethod = KeyManagementServiceGrpc.getGetImportJobMethod) == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getGetImportJobMethod = KeyManagementServiceGrpc.getGetImportJobMethod) == null) {
          KeyManagementServiceGrpc.getGetImportJobMethod = getGetImportJobMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.kms.v1.GetImportJobRequest, com.google.cloud.kms.v1.ImportJob>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetImportJob"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.GetImportJobRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.ImportJob.getDefaultInstance()))
              .setSchemaDescriptor(new KeyManagementServiceMethodDescriptorSupplier("GetImportJob"))
              .build();
        }
      }
    }
    return getGetImportJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.kms.v1.CreateKeyRingRequest,
      com.google.cloud.kms.v1.KeyRing> getCreateKeyRingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateKeyRing",
      requestType = com.google.cloud.kms.v1.CreateKeyRingRequest.class,
      responseType = com.google.cloud.kms.v1.KeyRing.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.kms.v1.CreateKeyRingRequest,
      com.google.cloud.kms.v1.KeyRing> getCreateKeyRingMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.kms.v1.CreateKeyRingRequest, com.google.cloud.kms.v1.KeyRing> getCreateKeyRingMethod;
    if ((getCreateKeyRingMethod = KeyManagementServiceGrpc.getCreateKeyRingMethod) == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getCreateKeyRingMethod = KeyManagementServiceGrpc.getCreateKeyRingMethod) == null) {
          KeyManagementServiceGrpc.getCreateKeyRingMethod = getCreateKeyRingMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.kms.v1.CreateKeyRingRequest, com.google.cloud.kms.v1.KeyRing>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateKeyRing"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.CreateKeyRingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.KeyRing.getDefaultInstance()))
              .setSchemaDescriptor(new KeyManagementServiceMethodDescriptorSupplier("CreateKeyRing"))
              .build();
        }
      }
    }
    return getCreateKeyRingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.kms.v1.CreateCryptoKeyRequest,
      com.google.cloud.kms.v1.CryptoKey> getCreateCryptoKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCryptoKey",
      requestType = com.google.cloud.kms.v1.CreateCryptoKeyRequest.class,
      responseType = com.google.cloud.kms.v1.CryptoKey.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.kms.v1.CreateCryptoKeyRequest,
      com.google.cloud.kms.v1.CryptoKey> getCreateCryptoKeyMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.kms.v1.CreateCryptoKeyRequest, com.google.cloud.kms.v1.CryptoKey> getCreateCryptoKeyMethod;
    if ((getCreateCryptoKeyMethod = KeyManagementServiceGrpc.getCreateCryptoKeyMethod) == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getCreateCryptoKeyMethod = KeyManagementServiceGrpc.getCreateCryptoKeyMethod) == null) {
          KeyManagementServiceGrpc.getCreateCryptoKeyMethod = getCreateCryptoKeyMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.kms.v1.CreateCryptoKeyRequest, com.google.cloud.kms.v1.CryptoKey>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCryptoKey"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.CreateCryptoKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.CryptoKey.getDefaultInstance()))
              .setSchemaDescriptor(new KeyManagementServiceMethodDescriptorSupplier("CreateCryptoKey"))
              .build();
        }
      }
    }
    return getCreateCryptoKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.kms.v1.CreateCryptoKeyVersionRequest,
      com.google.cloud.kms.v1.CryptoKeyVersion> getCreateCryptoKeyVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCryptoKeyVersion",
      requestType = com.google.cloud.kms.v1.CreateCryptoKeyVersionRequest.class,
      responseType = com.google.cloud.kms.v1.CryptoKeyVersion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.kms.v1.CreateCryptoKeyVersionRequest,
      com.google.cloud.kms.v1.CryptoKeyVersion> getCreateCryptoKeyVersionMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.kms.v1.CreateCryptoKeyVersionRequest, com.google.cloud.kms.v1.CryptoKeyVersion> getCreateCryptoKeyVersionMethod;
    if ((getCreateCryptoKeyVersionMethod = KeyManagementServiceGrpc.getCreateCryptoKeyVersionMethod) == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getCreateCryptoKeyVersionMethod = KeyManagementServiceGrpc.getCreateCryptoKeyVersionMethod) == null) {
          KeyManagementServiceGrpc.getCreateCryptoKeyVersionMethod = getCreateCryptoKeyVersionMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.kms.v1.CreateCryptoKeyVersionRequest, com.google.cloud.kms.v1.CryptoKeyVersion>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCryptoKeyVersion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.CreateCryptoKeyVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.CryptoKeyVersion.getDefaultInstance()))
              .setSchemaDescriptor(new KeyManagementServiceMethodDescriptorSupplier("CreateCryptoKeyVersion"))
              .build();
        }
      }
    }
    return getCreateCryptoKeyVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.kms.v1.ImportCryptoKeyVersionRequest,
      com.google.cloud.kms.v1.CryptoKeyVersion> getImportCryptoKeyVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportCryptoKeyVersion",
      requestType = com.google.cloud.kms.v1.ImportCryptoKeyVersionRequest.class,
      responseType = com.google.cloud.kms.v1.CryptoKeyVersion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.kms.v1.ImportCryptoKeyVersionRequest,
      com.google.cloud.kms.v1.CryptoKeyVersion> getImportCryptoKeyVersionMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.kms.v1.ImportCryptoKeyVersionRequest, com.google.cloud.kms.v1.CryptoKeyVersion> getImportCryptoKeyVersionMethod;
    if ((getImportCryptoKeyVersionMethod = KeyManagementServiceGrpc.getImportCryptoKeyVersionMethod) == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getImportCryptoKeyVersionMethod = KeyManagementServiceGrpc.getImportCryptoKeyVersionMethod) == null) {
          KeyManagementServiceGrpc.getImportCryptoKeyVersionMethod = getImportCryptoKeyVersionMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.kms.v1.ImportCryptoKeyVersionRequest, com.google.cloud.kms.v1.CryptoKeyVersion>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportCryptoKeyVersion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.ImportCryptoKeyVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.CryptoKeyVersion.getDefaultInstance()))
              .setSchemaDescriptor(new KeyManagementServiceMethodDescriptorSupplier("ImportCryptoKeyVersion"))
              .build();
        }
      }
    }
    return getImportCryptoKeyVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.kms.v1.CreateImportJobRequest,
      com.google.cloud.kms.v1.ImportJob> getCreateImportJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateImportJob",
      requestType = com.google.cloud.kms.v1.CreateImportJobRequest.class,
      responseType = com.google.cloud.kms.v1.ImportJob.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.kms.v1.CreateImportJobRequest,
      com.google.cloud.kms.v1.ImportJob> getCreateImportJobMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.kms.v1.CreateImportJobRequest, com.google.cloud.kms.v1.ImportJob> getCreateImportJobMethod;
    if ((getCreateImportJobMethod = KeyManagementServiceGrpc.getCreateImportJobMethod) == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getCreateImportJobMethod = KeyManagementServiceGrpc.getCreateImportJobMethod) == null) {
          KeyManagementServiceGrpc.getCreateImportJobMethod = getCreateImportJobMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.kms.v1.CreateImportJobRequest, com.google.cloud.kms.v1.ImportJob>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateImportJob"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.CreateImportJobRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.ImportJob.getDefaultInstance()))
              .setSchemaDescriptor(new KeyManagementServiceMethodDescriptorSupplier("CreateImportJob"))
              .build();
        }
      }
    }
    return getCreateImportJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.kms.v1.UpdateCryptoKeyRequest,
      com.google.cloud.kms.v1.CryptoKey> getUpdateCryptoKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCryptoKey",
      requestType = com.google.cloud.kms.v1.UpdateCryptoKeyRequest.class,
      responseType = com.google.cloud.kms.v1.CryptoKey.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.kms.v1.UpdateCryptoKeyRequest,
      com.google.cloud.kms.v1.CryptoKey> getUpdateCryptoKeyMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.kms.v1.UpdateCryptoKeyRequest, com.google.cloud.kms.v1.CryptoKey> getUpdateCryptoKeyMethod;
    if ((getUpdateCryptoKeyMethod = KeyManagementServiceGrpc.getUpdateCryptoKeyMethod) == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getUpdateCryptoKeyMethod = KeyManagementServiceGrpc.getUpdateCryptoKeyMethod) == null) {
          KeyManagementServiceGrpc.getUpdateCryptoKeyMethod = getUpdateCryptoKeyMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.kms.v1.UpdateCryptoKeyRequest, com.google.cloud.kms.v1.CryptoKey>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCryptoKey"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.UpdateCryptoKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.CryptoKey.getDefaultInstance()))
              .setSchemaDescriptor(new KeyManagementServiceMethodDescriptorSupplier("UpdateCryptoKey"))
              .build();
        }
      }
    }
    return getUpdateCryptoKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.kms.v1.UpdateCryptoKeyVersionRequest,
      com.google.cloud.kms.v1.CryptoKeyVersion> getUpdateCryptoKeyVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCryptoKeyVersion",
      requestType = com.google.cloud.kms.v1.UpdateCryptoKeyVersionRequest.class,
      responseType = com.google.cloud.kms.v1.CryptoKeyVersion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.kms.v1.UpdateCryptoKeyVersionRequest,
      com.google.cloud.kms.v1.CryptoKeyVersion> getUpdateCryptoKeyVersionMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.kms.v1.UpdateCryptoKeyVersionRequest, com.google.cloud.kms.v1.CryptoKeyVersion> getUpdateCryptoKeyVersionMethod;
    if ((getUpdateCryptoKeyVersionMethod = KeyManagementServiceGrpc.getUpdateCryptoKeyVersionMethod) == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getUpdateCryptoKeyVersionMethod = KeyManagementServiceGrpc.getUpdateCryptoKeyVersionMethod) == null) {
          KeyManagementServiceGrpc.getUpdateCryptoKeyVersionMethod = getUpdateCryptoKeyVersionMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.kms.v1.UpdateCryptoKeyVersionRequest, com.google.cloud.kms.v1.CryptoKeyVersion>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCryptoKeyVersion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.UpdateCryptoKeyVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.CryptoKeyVersion.getDefaultInstance()))
              .setSchemaDescriptor(new KeyManagementServiceMethodDescriptorSupplier("UpdateCryptoKeyVersion"))
              .build();
        }
      }
    }
    return getUpdateCryptoKeyVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.kms.v1.UpdateCryptoKeyPrimaryVersionRequest,
      com.google.cloud.kms.v1.CryptoKey> getUpdateCryptoKeyPrimaryVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCryptoKeyPrimaryVersion",
      requestType = com.google.cloud.kms.v1.UpdateCryptoKeyPrimaryVersionRequest.class,
      responseType = com.google.cloud.kms.v1.CryptoKey.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.kms.v1.UpdateCryptoKeyPrimaryVersionRequest,
      com.google.cloud.kms.v1.CryptoKey> getUpdateCryptoKeyPrimaryVersionMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.kms.v1.UpdateCryptoKeyPrimaryVersionRequest, com.google.cloud.kms.v1.CryptoKey> getUpdateCryptoKeyPrimaryVersionMethod;
    if ((getUpdateCryptoKeyPrimaryVersionMethod = KeyManagementServiceGrpc.getUpdateCryptoKeyPrimaryVersionMethod) == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getUpdateCryptoKeyPrimaryVersionMethod = KeyManagementServiceGrpc.getUpdateCryptoKeyPrimaryVersionMethod) == null) {
          KeyManagementServiceGrpc.getUpdateCryptoKeyPrimaryVersionMethod = getUpdateCryptoKeyPrimaryVersionMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.kms.v1.UpdateCryptoKeyPrimaryVersionRequest, com.google.cloud.kms.v1.CryptoKey>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCryptoKeyPrimaryVersion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.UpdateCryptoKeyPrimaryVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.CryptoKey.getDefaultInstance()))
              .setSchemaDescriptor(new KeyManagementServiceMethodDescriptorSupplier("UpdateCryptoKeyPrimaryVersion"))
              .build();
        }
      }
    }
    return getUpdateCryptoKeyPrimaryVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.kms.v1.DestroyCryptoKeyVersionRequest,
      com.google.cloud.kms.v1.CryptoKeyVersion> getDestroyCryptoKeyVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DestroyCryptoKeyVersion",
      requestType = com.google.cloud.kms.v1.DestroyCryptoKeyVersionRequest.class,
      responseType = com.google.cloud.kms.v1.CryptoKeyVersion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.kms.v1.DestroyCryptoKeyVersionRequest,
      com.google.cloud.kms.v1.CryptoKeyVersion> getDestroyCryptoKeyVersionMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.kms.v1.DestroyCryptoKeyVersionRequest, com.google.cloud.kms.v1.CryptoKeyVersion> getDestroyCryptoKeyVersionMethod;
    if ((getDestroyCryptoKeyVersionMethod = KeyManagementServiceGrpc.getDestroyCryptoKeyVersionMethod) == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getDestroyCryptoKeyVersionMethod = KeyManagementServiceGrpc.getDestroyCryptoKeyVersionMethod) == null) {
          KeyManagementServiceGrpc.getDestroyCryptoKeyVersionMethod = getDestroyCryptoKeyVersionMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.kms.v1.DestroyCryptoKeyVersionRequest, com.google.cloud.kms.v1.CryptoKeyVersion>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DestroyCryptoKeyVersion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.DestroyCryptoKeyVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.CryptoKeyVersion.getDefaultInstance()))
              .setSchemaDescriptor(new KeyManagementServiceMethodDescriptorSupplier("DestroyCryptoKeyVersion"))
              .build();
        }
      }
    }
    return getDestroyCryptoKeyVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.kms.v1.RestoreCryptoKeyVersionRequest,
      com.google.cloud.kms.v1.CryptoKeyVersion> getRestoreCryptoKeyVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RestoreCryptoKeyVersion",
      requestType = com.google.cloud.kms.v1.RestoreCryptoKeyVersionRequest.class,
      responseType = com.google.cloud.kms.v1.CryptoKeyVersion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.kms.v1.RestoreCryptoKeyVersionRequest,
      com.google.cloud.kms.v1.CryptoKeyVersion> getRestoreCryptoKeyVersionMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.kms.v1.RestoreCryptoKeyVersionRequest, com.google.cloud.kms.v1.CryptoKeyVersion> getRestoreCryptoKeyVersionMethod;
    if ((getRestoreCryptoKeyVersionMethod = KeyManagementServiceGrpc.getRestoreCryptoKeyVersionMethod) == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getRestoreCryptoKeyVersionMethod = KeyManagementServiceGrpc.getRestoreCryptoKeyVersionMethod) == null) {
          KeyManagementServiceGrpc.getRestoreCryptoKeyVersionMethod = getRestoreCryptoKeyVersionMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.kms.v1.RestoreCryptoKeyVersionRequest, com.google.cloud.kms.v1.CryptoKeyVersion>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RestoreCryptoKeyVersion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.RestoreCryptoKeyVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.CryptoKeyVersion.getDefaultInstance()))
              .setSchemaDescriptor(new KeyManagementServiceMethodDescriptorSupplier("RestoreCryptoKeyVersion"))
              .build();
        }
      }
    }
    return getRestoreCryptoKeyVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.kms.v1.EncryptRequest,
      com.google.cloud.kms.v1.EncryptResponse> getEncryptMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Encrypt",
      requestType = com.google.cloud.kms.v1.EncryptRequest.class,
      responseType = com.google.cloud.kms.v1.EncryptResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.kms.v1.EncryptRequest,
      com.google.cloud.kms.v1.EncryptResponse> getEncryptMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.kms.v1.EncryptRequest, com.google.cloud.kms.v1.EncryptResponse> getEncryptMethod;
    if ((getEncryptMethod = KeyManagementServiceGrpc.getEncryptMethod) == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getEncryptMethod = KeyManagementServiceGrpc.getEncryptMethod) == null) {
          KeyManagementServiceGrpc.getEncryptMethod = getEncryptMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.kms.v1.EncryptRequest, com.google.cloud.kms.v1.EncryptResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Encrypt"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.EncryptRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.EncryptResponse.getDefaultInstance()))
              .setSchemaDescriptor(new KeyManagementServiceMethodDescriptorSupplier("Encrypt"))
              .build();
        }
      }
    }
    return getEncryptMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.kms.v1.DecryptRequest,
      com.google.cloud.kms.v1.DecryptResponse> getDecryptMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Decrypt",
      requestType = com.google.cloud.kms.v1.DecryptRequest.class,
      responseType = com.google.cloud.kms.v1.DecryptResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.kms.v1.DecryptRequest,
      com.google.cloud.kms.v1.DecryptResponse> getDecryptMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.kms.v1.DecryptRequest, com.google.cloud.kms.v1.DecryptResponse> getDecryptMethod;
    if ((getDecryptMethod = KeyManagementServiceGrpc.getDecryptMethod) == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getDecryptMethod = KeyManagementServiceGrpc.getDecryptMethod) == null) {
          KeyManagementServiceGrpc.getDecryptMethod = getDecryptMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.kms.v1.DecryptRequest, com.google.cloud.kms.v1.DecryptResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Decrypt"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.DecryptRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.DecryptResponse.getDefaultInstance()))
              .setSchemaDescriptor(new KeyManagementServiceMethodDescriptorSupplier("Decrypt"))
              .build();
        }
      }
    }
    return getDecryptMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.kms.v1.AsymmetricSignRequest,
      com.google.cloud.kms.v1.AsymmetricSignResponse> getAsymmetricSignMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AsymmetricSign",
      requestType = com.google.cloud.kms.v1.AsymmetricSignRequest.class,
      responseType = com.google.cloud.kms.v1.AsymmetricSignResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.kms.v1.AsymmetricSignRequest,
      com.google.cloud.kms.v1.AsymmetricSignResponse> getAsymmetricSignMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.kms.v1.AsymmetricSignRequest, com.google.cloud.kms.v1.AsymmetricSignResponse> getAsymmetricSignMethod;
    if ((getAsymmetricSignMethod = KeyManagementServiceGrpc.getAsymmetricSignMethod) == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getAsymmetricSignMethod = KeyManagementServiceGrpc.getAsymmetricSignMethod) == null) {
          KeyManagementServiceGrpc.getAsymmetricSignMethod = getAsymmetricSignMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.kms.v1.AsymmetricSignRequest, com.google.cloud.kms.v1.AsymmetricSignResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AsymmetricSign"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.AsymmetricSignRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.AsymmetricSignResponse.getDefaultInstance()))
              .setSchemaDescriptor(new KeyManagementServiceMethodDescriptorSupplier("AsymmetricSign"))
              .build();
        }
      }
    }
    return getAsymmetricSignMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.kms.v1.AsymmetricDecryptRequest,
      com.google.cloud.kms.v1.AsymmetricDecryptResponse> getAsymmetricDecryptMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AsymmetricDecrypt",
      requestType = com.google.cloud.kms.v1.AsymmetricDecryptRequest.class,
      responseType = com.google.cloud.kms.v1.AsymmetricDecryptResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.kms.v1.AsymmetricDecryptRequest,
      com.google.cloud.kms.v1.AsymmetricDecryptResponse> getAsymmetricDecryptMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.kms.v1.AsymmetricDecryptRequest, com.google.cloud.kms.v1.AsymmetricDecryptResponse> getAsymmetricDecryptMethod;
    if ((getAsymmetricDecryptMethod = KeyManagementServiceGrpc.getAsymmetricDecryptMethod) == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getAsymmetricDecryptMethod = KeyManagementServiceGrpc.getAsymmetricDecryptMethod) == null) {
          KeyManagementServiceGrpc.getAsymmetricDecryptMethod = getAsymmetricDecryptMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.kms.v1.AsymmetricDecryptRequest, com.google.cloud.kms.v1.AsymmetricDecryptResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AsymmetricDecrypt"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.AsymmetricDecryptRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.AsymmetricDecryptResponse.getDefaultInstance()))
              .setSchemaDescriptor(new KeyManagementServiceMethodDescriptorSupplier("AsymmetricDecrypt"))
              .build();
        }
      }
    }
    return getAsymmetricDecryptMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.kms.v1.MacSignRequest,
      com.google.cloud.kms.v1.MacSignResponse> getMacSignMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MacSign",
      requestType = com.google.cloud.kms.v1.MacSignRequest.class,
      responseType = com.google.cloud.kms.v1.MacSignResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.kms.v1.MacSignRequest,
      com.google.cloud.kms.v1.MacSignResponse> getMacSignMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.kms.v1.MacSignRequest, com.google.cloud.kms.v1.MacSignResponse> getMacSignMethod;
    if ((getMacSignMethod = KeyManagementServiceGrpc.getMacSignMethod) == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getMacSignMethod = KeyManagementServiceGrpc.getMacSignMethod) == null) {
          KeyManagementServiceGrpc.getMacSignMethod = getMacSignMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.kms.v1.MacSignRequest, com.google.cloud.kms.v1.MacSignResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MacSign"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.MacSignRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.MacSignResponse.getDefaultInstance()))
              .setSchemaDescriptor(new KeyManagementServiceMethodDescriptorSupplier("MacSign"))
              .build();
        }
      }
    }
    return getMacSignMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.kms.v1.MacVerifyRequest,
      com.google.cloud.kms.v1.MacVerifyResponse> getMacVerifyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MacVerify",
      requestType = com.google.cloud.kms.v1.MacVerifyRequest.class,
      responseType = com.google.cloud.kms.v1.MacVerifyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.kms.v1.MacVerifyRequest,
      com.google.cloud.kms.v1.MacVerifyResponse> getMacVerifyMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.kms.v1.MacVerifyRequest, com.google.cloud.kms.v1.MacVerifyResponse> getMacVerifyMethod;
    if ((getMacVerifyMethod = KeyManagementServiceGrpc.getMacVerifyMethod) == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getMacVerifyMethod = KeyManagementServiceGrpc.getMacVerifyMethod) == null) {
          KeyManagementServiceGrpc.getMacVerifyMethod = getMacVerifyMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.kms.v1.MacVerifyRequest, com.google.cloud.kms.v1.MacVerifyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MacVerify"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.MacVerifyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.MacVerifyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new KeyManagementServiceMethodDescriptorSupplier("MacVerify"))
              .build();
        }
      }
    }
    return getMacVerifyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.kms.v1.GenerateRandomBytesRequest,
      com.google.cloud.kms.v1.GenerateRandomBytesResponse> getGenerateRandomBytesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateRandomBytes",
      requestType = com.google.cloud.kms.v1.GenerateRandomBytesRequest.class,
      responseType = com.google.cloud.kms.v1.GenerateRandomBytesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.kms.v1.GenerateRandomBytesRequest,
      com.google.cloud.kms.v1.GenerateRandomBytesResponse> getGenerateRandomBytesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.kms.v1.GenerateRandomBytesRequest, com.google.cloud.kms.v1.GenerateRandomBytesResponse> getGenerateRandomBytesMethod;
    if ((getGenerateRandomBytesMethod = KeyManagementServiceGrpc.getGenerateRandomBytesMethod) == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getGenerateRandomBytesMethod = KeyManagementServiceGrpc.getGenerateRandomBytesMethod) == null) {
          KeyManagementServiceGrpc.getGenerateRandomBytesMethod = getGenerateRandomBytesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.kms.v1.GenerateRandomBytesRequest, com.google.cloud.kms.v1.GenerateRandomBytesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateRandomBytes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.GenerateRandomBytesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.GenerateRandomBytesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new KeyManagementServiceMethodDescriptorSupplier("GenerateRandomBytes"))
              .build();
        }
      }
    }
    return getGenerateRandomBytesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static KeyManagementServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<KeyManagementServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<KeyManagementServiceStub>() {
        @java.lang.Override
        public KeyManagementServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new KeyManagementServiceStub(channel, callOptions);
        }
      };
    return KeyManagementServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static KeyManagementServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<KeyManagementServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<KeyManagementServiceBlockingStub>() {
        @java.lang.Override
        public KeyManagementServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new KeyManagementServiceBlockingStub(channel, callOptions);
        }
      };
    return KeyManagementServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static KeyManagementServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<KeyManagementServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<KeyManagementServiceFutureStub>() {
        @java.lang.Override
        public KeyManagementServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new KeyManagementServiceFutureStub(channel, callOptions);
        }
      };
    return KeyManagementServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Google Cloud Key Management Service
   * Manages cryptographic keys and operations using those keys. Implements a REST
   * model with the following objects:
   * * [KeyRing][google.cloud.kms.v1.KeyRing]
   * * [CryptoKey][google.cloud.kms.v1.CryptoKey]
   * * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
   * * [ImportJob][google.cloud.kms.v1.ImportJob]
   * If you are using manual gRPC libraries, see
   * [Using gRPC with Cloud KMS](https://cloud.google.com/kms/docs/grpc).
   * </pre>
   */
  public static abstract class KeyManagementServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists [KeyRings][google.cloud.kms.v1.KeyRing].
     * </pre>
     */
    public void listKeyRings(com.google.cloud.kms.v1.ListKeyRingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ListKeyRingsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListKeyRingsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists [CryptoKeys][google.cloud.kms.v1.CryptoKey].
     * </pre>
     */
    public void listCryptoKeys(com.google.cloud.kms.v1.ListCryptoKeysRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ListCryptoKeysResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListCryptoKeysMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists [CryptoKeyVersions][google.cloud.kms.v1.CryptoKeyVersion].
     * </pre>
     */
    public void listCryptoKeyVersions(com.google.cloud.kms.v1.ListCryptoKeyVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ListCryptoKeyVersionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListCryptoKeyVersionsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists [ImportJobs][google.cloud.kms.v1.ImportJob].
     * </pre>
     */
    public void listImportJobs(com.google.cloud.kms.v1.ListImportJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ListImportJobsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListImportJobsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns metadata for a given [KeyRing][google.cloud.kms.v1.KeyRing].
     * </pre>
     */
    public void getKeyRing(com.google.cloud.kms.v1.GetKeyRingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.KeyRing> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetKeyRingMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns metadata for a given [CryptoKey][google.cloud.kms.v1.CryptoKey], as
     * well as its [primary][google.cloud.kms.v1.CryptoKey.primary]
     * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
     * </pre>
     */
    public void getCryptoKey(com.google.cloud.kms.v1.GetCryptoKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKey> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCryptoKeyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns metadata for a given
     * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
     * </pre>
     */
    public void getCryptoKeyVersion(com.google.cloud.kms.v1.GetCryptoKeyVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKeyVersion> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCryptoKeyVersionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns the public key for the given
     * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]. The
     * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
     * [ASYMMETRIC_SIGN][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ASYMMETRIC_SIGN]
     * or
     * [ASYMMETRIC_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ASYMMETRIC_DECRYPT].
     * </pre>
     */
    public void getPublicKey(com.google.cloud.kms.v1.GetPublicKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.PublicKey> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPublicKeyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns metadata for a given [ImportJob][google.cloud.kms.v1.ImportJob].
     * </pre>
     */
    public void getImportJob(com.google.cloud.kms.v1.GetImportJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ImportJob> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetImportJobMethod(), responseObserver);
    }

    /**
     * <pre>
     * Create a new [KeyRing][google.cloud.kms.v1.KeyRing] in a given Project and
     * Location.
     * </pre>
     */
    public void createKeyRing(com.google.cloud.kms.v1.CreateKeyRingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.KeyRing> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateKeyRingMethod(), responseObserver);
    }

    /**
     * <pre>
     * Create a new [CryptoKey][google.cloud.kms.v1.CryptoKey] within a
     * [KeyRing][google.cloud.kms.v1.KeyRing].
     * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] and
     * [CryptoKey.version_template.algorithm][google.cloud.kms.v1.CryptoKeyVersionTemplate.algorithm]
     * are required.
     * </pre>
     */
    public void createCryptoKey(com.google.cloud.kms.v1.CreateCryptoKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKey> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateCryptoKeyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Create a new [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] in a
     * [CryptoKey][google.cloud.kms.v1.CryptoKey].
     * The server will assign the next sequential id. If unset,
     * [state][google.cloud.kms.v1.CryptoKeyVersion.state] will be set to
     * [ENABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.ENABLED].
     * </pre>
     */
    public void createCryptoKeyVersion(com.google.cloud.kms.v1.CreateCryptoKeyVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKeyVersion> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateCryptoKeyVersionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Import wrapped key material into a
     * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
     * All requests must specify a [CryptoKey][google.cloud.kms.v1.CryptoKey]. If
     * a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] is additionally
     * specified in the request, key material will be reimported into that
     * version. Otherwise, a new version will be created, and will be assigned the
     * next sequential id within the [CryptoKey][google.cloud.kms.v1.CryptoKey].
     * </pre>
     */
    public void importCryptoKeyVersion(com.google.cloud.kms.v1.ImportCryptoKeyVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKeyVersion> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getImportCryptoKeyVersionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Create a new [ImportJob][google.cloud.kms.v1.ImportJob] within a
     * [KeyRing][google.cloud.kms.v1.KeyRing].
     * [ImportJob.import_method][google.cloud.kms.v1.ImportJob.import_method] is
     * required.
     * </pre>
     */
    public void createImportJob(com.google.cloud.kms.v1.CreateImportJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ImportJob> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateImportJobMethod(), responseObserver);
    }

    /**
     * <pre>
     * Update a [CryptoKey][google.cloud.kms.v1.CryptoKey].
     * </pre>
     */
    public void updateCryptoKey(com.google.cloud.kms.v1.UpdateCryptoKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKey> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateCryptoKeyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Update a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]'s
     * metadata.
     * [state][google.cloud.kms.v1.CryptoKeyVersion.state] may be changed between
     * [ENABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.ENABLED]
     * and
     * [DISABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DISABLED]
     * using this method. See
     * [DestroyCryptoKeyVersion][google.cloud.kms.v1.KeyManagementService.DestroyCryptoKeyVersion]
     * and
     * [RestoreCryptoKeyVersion][google.cloud.kms.v1.KeyManagementService.RestoreCryptoKeyVersion]
     * to move between other states.
     * </pre>
     */
    public void updateCryptoKeyVersion(com.google.cloud.kms.v1.UpdateCryptoKeyVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKeyVersion> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateCryptoKeyVersionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Update the version of a [CryptoKey][google.cloud.kms.v1.CryptoKey] that
     * will be used in
     * [Encrypt][google.cloud.kms.v1.KeyManagementService.Encrypt].
     * Returns an error if called on a key whose purpose is not
     * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
     * </pre>
     */
    public void updateCryptoKeyPrimaryVersion(com.google.cloud.kms.v1.UpdateCryptoKeyPrimaryVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKey> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateCryptoKeyPrimaryVersionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Schedule a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] for
     * destruction.
     * Upon calling this method,
     * [CryptoKeyVersion.state][google.cloud.kms.v1.CryptoKeyVersion.state] will
     * be set to
     * [DESTROY_SCHEDULED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROY_SCHEDULED],
     * and [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] will
     * be set to the time
     * [destroy_scheduled_duration][google.cloud.kms.v1.CryptoKey.destroy_scheduled_duration]
     * in the future. At that time, the
     * [state][google.cloud.kms.v1.CryptoKeyVersion.state] will automatically
     * change to
     * [DESTROYED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROYED],
     * and the key material will be irrevocably destroyed.
     * Before the
     * [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] is
     * reached,
     * [RestoreCryptoKeyVersion][google.cloud.kms.v1.KeyManagementService.RestoreCryptoKeyVersion]
     * may be called to reverse the process.
     * </pre>
     */
    public void destroyCryptoKeyVersion(com.google.cloud.kms.v1.DestroyCryptoKeyVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKeyVersion> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDestroyCryptoKeyVersionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Restore a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] in the
     * [DESTROY_SCHEDULED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROY_SCHEDULED]
     * state.
     * Upon restoration of the CryptoKeyVersion,
     * [state][google.cloud.kms.v1.CryptoKeyVersion.state] will be set to
     * [DISABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DISABLED],
     * and [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] will
     * be cleared.
     * </pre>
     */
    public void restoreCryptoKeyVersion(com.google.cloud.kms.v1.RestoreCryptoKeyVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKeyVersion> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRestoreCryptoKeyVersionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Encrypts data, so that it can only be recovered by a call to
     * [Decrypt][google.cloud.kms.v1.KeyManagementService.Decrypt]. The
     * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
     * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
     * </pre>
     */
    public void encrypt(com.google.cloud.kms.v1.EncryptRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.EncryptResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEncryptMethod(), responseObserver);
    }

    /**
     * <pre>
     * Decrypts data that was protected by
     * [Encrypt][google.cloud.kms.v1.KeyManagementService.Encrypt]. The
     * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
     * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
     * </pre>
     */
    public void decrypt(com.google.cloud.kms.v1.DecryptRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.DecryptResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDecryptMethod(), responseObserver);
    }

    /**
     * <pre>
     * Signs data using a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
     * with [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose]
     * ASYMMETRIC_SIGN, producing a signature that can be verified with the public
     * key retrieved from
     * [GetPublicKey][google.cloud.kms.v1.KeyManagementService.GetPublicKey].
     * </pre>
     */
    public void asymmetricSign(com.google.cloud.kms.v1.AsymmetricSignRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.AsymmetricSignResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAsymmetricSignMethod(), responseObserver);
    }

    /**
     * <pre>
     * Decrypts data that was encrypted with a public key retrieved from
     * [GetPublicKey][google.cloud.kms.v1.KeyManagementService.GetPublicKey]
     * corresponding to a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
     * with [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose]
     * ASYMMETRIC_DECRYPT.
     * </pre>
     */
    public void asymmetricDecrypt(com.google.cloud.kms.v1.AsymmetricDecryptRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.AsymmetricDecryptResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAsymmetricDecryptMethod(), responseObserver);
    }

    /**
     * <pre>
     * Signs data using a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
     * with [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] MAC,
     * producing a tag that can be verified by another source with the same key.
     * </pre>
     */
    public void macSign(com.google.cloud.kms.v1.MacSignRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.MacSignResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMacSignMethod(), responseObserver);
    }

    /**
     * <pre>
     * Verifies MAC tag using a
     * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] with
     * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] MAC, and returns
     * a response that indicates whether or not the verification was successful.
     * </pre>
     */
    public void macVerify(com.google.cloud.kms.v1.MacVerifyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.MacVerifyResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMacVerifyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Generate random bytes using the Cloud KMS randomness source in the provided
     * location.
     * </pre>
     */
    public void generateRandomBytes(com.google.cloud.kms.v1.GenerateRandomBytesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.GenerateRandomBytesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateRandomBytesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListKeyRingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.kms.v1.ListKeyRingsRequest,
                com.google.cloud.kms.v1.ListKeyRingsResponse>(
                  this, METHODID_LIST_KEY_RINGS)))
          .addMethod(
            getListCryptoKeysMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.kms.v1.ListCryptoKeysRequest,
                com.google.cloud.kms.v1.ListCryptoKeysResponse>(
                  this, METHODID_LIST_CRYPTO_KEYS)))
          .addMethod(
            getListCryptoKeyVersionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.kms.v1.ListCryptoKeyVersionsRequest,
                com.google.cloud.kms.v1.ListCryptoKeyVersionsResponse>(
                  this, METHODID_LIST_CRYPTO_KEY_VERSIONS)))
          .addMethod(
            getListImportJobsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.kms.v1.ListImportJobsRequest,
                com.google.cloud.kms.v1.ListImportJobsResponse>(
                  this, METHODID_LIST_IMPORT_JOBS)))
          .addMethod(
            getGetKeyRingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.kms.v1.GetKeyRingRequest,
                com.google.cloud.kms.v1.KeyRing>(
                  this, METHODID_GET_KEY_RING)))
          .addMethod(
            getGetCryptoKeyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.kms.v1.GetCryptoKeyRequest,
                com.google.cloud.kms.v1.CryptoKey>(
                  this, METHODID_GET_CRYPTO_KEY)))
          .addMethod(
            getGetCryptoKeyVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.kms.v1.GetCryptoKeyVersionRequest,
                com.google.cloud.kms.v1.CryptoKeyVersion>(
                  this, METHODID_GET_CRYPTO_KEY_VERSION)))
          .addMethod(
            getGetPublicKeyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.kms.v1.GetPublicKeyRequest,
                com.google.cloud.kms.v1.PublicKey>(
                  this, METHODID_GET_PUBLIC_KEY)))
          .addMethod(
            getGetImportJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.kms.v1.GetImportJobRequest,
                com.google.cloud.kms.v1.ImportJob>(
                  this, METHODID_GET_IMPORT_JOB)))
          .addMethod(
            getCreateKeyRingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.kms.v1.CreateKeyRingRequest,
                com.google.cloud.kms.v1.KeyRing>(
                  this, METHODID_CREATE_KEY_RING)))
          .addMethod(
            getCreateCryptoKeyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.kms.v1.CreateCryptoKeyRequest,
                com.google.cloud.kms.v1.CryptoKey>(
                  this, METHODID_CREATE_CRYPTO_KEY)))
          .addMethod(
            getCreateCryptoKeyVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.kms.v1.CreateCryptoKeyVersionRequest,
                com.google.cloud.kms.v1.CryptoKeyVersion>(
                  this, METHODID_CREATE_CRYPTO_KEY_VERSION)))
          .addMethod(
            getImportCryptoKeyVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.kms.v1.ImportCryptoKeyVersionRequest,
                com.google.cloud.kms.v1.CryptoKeyVersion>(
                  this, METHODID_IMPORT_CRYPTO_KEY_VERSION)))
          .addMethod(
            getCreateImportJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.kms.v1.CreateImportJobRequest,
                com.google.cloud.kms.v1.ImportJob>(
                  this, METHODID_CREATE_IMPORT_JOB)))
          .addMethod(
            getUpdateCryptoKeyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.kms.v1.UpdateCryptoKeyRequest,
                com.google.cloud.kms.v1.CryptoKey>(
                  this, METHODID_UPDATE_CRYPTO_KEY)))
          .addMethod(
            getUpdateCryptoKeyVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.kms.v1.UpdateCryptoKeyVersionRequest,
                com.google.cloud.kms.v1.CryptoKeyVersion>(
                  this, METHODID_UPDATE_CRYPTO_KEY_VERSION)))
          .addMethod(
            getUpdateCryptoKeyPrimaryVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.kms.v1.UpdateCryptoKeyPrimaryVersionRequest,
                com.google.cloud.kms.v1.CryptoKey>(
                  this, METHODID_UPDATE_CRYPTO_KEY_PRIMARY_VERSION)))
          .addMethod(
            getDestroyCryptoKeyVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.kms.v1.DestroyCryptoKeyVersionRequest,
                com.google.cloud.kms.v1.CryptoKeyVersion>(
                  this, METHODID_DESTROY_CRYPTO_KEY_VERSION)))
          .addMethod(
            getRestoreCryptoKeyVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.kms.v1.RestoreCryptoKeyVersionRequest,
                com.google.cloud.kms.v1.CryptoKeyVersion>(
                  this, METHODID_RESTORE_CRYPTO_KEY_VERSION)))
          .addMethod(
            getEncryptMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.kms.v1.EncryptRequest,
                com.google.cloud.kms.v1.EncryptResponse>(
                  this, METHODID_ENCRYPT)))
          .addMethod(
            getDecryptMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.kms.v1.DecryptRequest,
                com.google.cloud.kms.v1.DecryptResponse>(
                  this, METHODID_DECRYPT)))
          .addMethod(
            getAsymmetricSignMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.kms.v1.AsymmetricSignRequest,
                com.google.cloud.kms.v1.AsymmetricSignResponse>(
                  this, METHODID_ASYMMETRIC_SIGN)))
          .addMethod(
            getAsymmetricDecryptMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.kms.v1.AsymmetricDecryptRequest,
                com.google.cloud.kms.v1.AsymmetricDecryptResponse>(
                  this, METHODID_ASYMMETRIC_DECRYPT)))
          .addMethod(
            getMacSignMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.kms.v1.MacSignRequest,
                com.google.cloud.kms.v1.MacSignResponse>(
                  this, METHODID_MAC_SIGN)))
          .addMethod(
            getMacVerifyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.kms.v1.MacVerifyRequest,
                com.google.cloud.kms.v1.MacVerifyResponse>(
                  this, METHODID_MAC_VERIFY)))
          .addMethod(
            getGenerateRandomBytesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.kms.v1.GenerateRandomBytesRequest,
                com.google.cloud.kms.v1.GenerateRandomBytesResponse>(
                  this, METHODID_GENERATE_RANDOM_BYTES)))
          .build();
    }
  }

  /**
   * <pre>
   * Google Cloud Key Management Service
   * Manages cryptographic keys and operations using those keys. Implements a REST
   * model with the following objects:
   * * [KeyRing][google.cloud.kms.v1.KeyRing]
   * * [CryptoKey][google.cloud.kms.v1.CryptoKey]
   * * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
   * * [ImportJob][google.cloud.kms.v1.ImportJob]
   * If you are using manual gRPC libraries, see
   * [Using gRPC with Cloud KMS](https://cloud.google.com/kms/docs/grpc).
   * </pre>
   */
  public static final class KeyManagementServiceStub extends io.grpc.stub.AbstractAsyncStub<KeyManagementServiceStub> {
    private KeyManagementServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KeyManagementServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new KeyManagementServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists [KeyRings][google.cloud.kms.v1.KeyRing].
     * </pre>
     */
    public void listKeyRings(com.google.cloud.kms.v1.ListKeyRingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ListKeyRingsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListKeyRingsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists [CryptoKeys][google.cloud.kms.v1.CryptoKey].
     * </pre>
     */
    public void listCryptoKeys(com.google.cloud.kms.v1.ListCryptoKeysRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ListCryptoKeysResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCryptoKeysMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists [CryptoKeyVersions][google.cloud.kms.v1.CryptoKeyVersion].
     * </pre>
     */
    public void listCryptoKeyVersions(com.google.cloud.kms.v1.ListCryptoKeyVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ListCryptoKeyVersionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCryptoKeyVersionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists [ImportJobs][google.cloud.kms.v1.ImportJob].
     * </pre>
     */
    public void listImportJobs(com.google.cloud.kms.v1.ListImportJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ListImportJobsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListImportJobsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns metadata for a given [KeyRing][google.cloud.kms.v1.KeyRing].
     * </pre>
     */
    public void getKeyRing(com.google.cloud.kms.v1.GetKeyRingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.KeyRing> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetKeyRingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns metadata for a given [CryptoKey][google.cloud.kms.v1.CryptoKey], as
     * well as its [primary][google.cloud.kms.v1.CryptoKey.primary]
     * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
     * </pre>
     */
    public void getCryptoKey(com.google.cloud.kms.v1.GetCryptoKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKey> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCryptoKeyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns metadata for a given
     * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
     * </pre>
     */
    public void getCryptoKeyVersion(com.google.cloud.kms.v1.GetCryptoKeyVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKeyVersion> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCryptoKeyVersionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns the public key for the given
     * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]. The
     * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
     * [ASYMMETRIC_SIGN][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ASYMMETRIC_SIGN]
     * or
     * [ASYMMETRIC_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ASYMMETRIC_DECRYPT].
     * </pre>
     */
    public void getPublicKey(com.google.cloud.kms.v1.GetPublicKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.PublicKey> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPublicKeyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns metadata for a given [ImportJob][google.cloud.kms.v1.ImportJob].
     * </pre>
     */
    public void getImportJob(com.google.cloud.kms.v1.GetImportJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ImportJob> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetImportJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Create a new [KeyRing][google.cloud.kms.v1.KeyRing] in a given Project and
     * Location.
     * </pre>
     */
    public void createKeyRing(com.google.cloud.kms.v1.CreateKeyRingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.KeyRing> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateKeyRingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Create a new [CryptoKey][google.cloud.kms.v1.CryptoKey] within a
     * [KeyRing][google.cloud.kms.v1.KeyRing].
     * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] and
     * [CryptoKey.version_template.algorithm][google.cloud.kms.v1.CryptoKeyVersionTemplate.algorithm]
     * are required.
     * </pre>
     */
    public void createCryptoKey(com.google.cloud.kms.v1.CreateCryptoKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKey> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCryptoKeyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Create a new [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] in a
     * [CryptoKey][google.cloud.kms.v1.CryptoKey].
     * The server will assign the next sequential id. If unset,
     * [state][google.cloud.kms.v1.CryptoKeyVersion.state] will be set to
     * [ENABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.ENABLED].
     * </pre>
     */
    public void createCryptoKeyVersion(com.google.cloud.kms.v1.CreateCryptoKeyVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKeyVersion> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCryptoKeyVersionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Import wrapped key material into a
     * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
     * All requests must specify a [CryptoKey][google.cloud.kms.v1.CryptoKey]. If
     * a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] is additionally
     * specified in the request, key material will be reimported into that
     * version. Otherwise, a new version will be created, and will be assigned the
     * next sequential id within the [CryptoKey][google.cloud.kms.v1.CryptoKey].
     * </pre>
     */
    public void importCryptoKeyVersion(com.google.cloud.kms.v1.ImportCryptoKeyVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKeyVersion> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportCryptoKeyVersionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Create a new [ImportJob][google.cloud.kms.v1.ImportJob] within a
     * [KeyRing][google.cloud.kms.v1.KeyRing].
     * [ImportJob.import_method][google.cloud.kms.v1.ImportJob.import_method] is
     * required.
     * </pre>
     */
    public void createImportJob(com.google.cloud.kms.v1.CreateImportJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ImportJob> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateImportJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Update a [CryptoKey][google.cloud.kms.v1.CryptoKey].
     * </pre>
     */
    public void updateCryptoKey(com.google.cloud.kms.v1.UpdateCryptoKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKey> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCryptoKeyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Update a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]'s
     * metadata.
     * [state][google.cloud.kms.v1.CryptoKeyVersion.state] may be changed between
     * [ENABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.ENABLED]
     * and
     * [DISABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DISABLED]
     * using this method. See
     * [DestroyCryptoKeyVersion][google.cloud.kms.v1.KeyManagementService.DestroyCryptoKeyVersion]
     * and
     * [RestoreCryptoKeyVersion][google.cloud.kms.v1.KeyManagementService.RestoreCryptoKeyVersion]
     * to move between other states.
     * </pre>
     */
    public void updateCryptoKeyVersion(com.google.cloud.kms.v1.UpdateCryptoKeyVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKeyVersion> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCryptoKeyVersionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Update the version of a [CryptoKey][google.cloud.kms.v1.CryptoKey] that
     * will be used in
     * [Encrypt][google.cloud.kms.v1.KeyManagementService.Encrypt].
     * Returns an error if called on a key whose purpose is not
     * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
     * </pre>
     */
    public void updateCryptoKeyPrimaryVersion(com.google.cloud.kms.v1.UpdateCryptoKeyPrimaryVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKey> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCryptoKeyPrimaryVersionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Schedule a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] for
     * destruction.
     * Upon calling this method,
     * [CryptoKeyVersion.state][google.cloud.kms.v1.CryptoKeyVersion.state] will
     * be set to
     * [DESTROY_SCHEDULED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROY_SCHEDULED],
     * and [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] will
     * be set to the time
     * [destroy_scheduled_duration][google.cloud.kms.v1.CryptoKey.destroy_scheduled_duration]
     * in the future. At that time, the
     * [state][google.cloud.kms.v1.CryptoKeyVersion.state] will automatically
     * change to
     * [DESTROYED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROYED],
     * and the key material will be irrevocably destroyed.
     * Before the
     * [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] is
     * reached,
     * [RestoreCryptoKeyVersion][google.cloud.kms.v1.KeyManagementService.RestoreCryptoKeyVersion]
     * may be called to reverse the process.
     * </pre>
     */
    public void destroyCryptoKeyVersion(com.google.cloud.kms.v1.DestroyCryptoKeyVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKeyVersion> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDestroyCryptoKeyVersionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Restore a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] in the
     * [DESTROY_SCHEDULED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROY_SCHEDULED]
     * state.
     * Upon restoration of the CryptoKeyVersion,
     * [state][google.cloud.kms.v1.CryptoKeyVersion.state] will be set to
     * [DISABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DISABLED],
     * and [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] will
     * be cleared.
     * </pre>
     */
    public void restoreCryptoKeyVersion(com.google.cloud.kms.v1.RestoreCryptoKeyVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKeyVersion> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRestoreCryptoKeyVersionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Encrypts data, so that it can only be recovered by a call to
     * [Decrypt][google.cloud.kms.v1.KeyManagementService.Decrypt]. The
     * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
     * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
     * </pre>
     */
    public void encrypt(com.google.cloud.kms.v1.EncryptRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.EncryptResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEncryptMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Decrypts data that was protected by
     * [Encrypt][google.cloud.kms.v1.KeyManagementService.Encrypt]. The
     * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
     * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
     * </pre>
     */
    public void decrypt(com.google.cloud.kms.v1.DecryptRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.DecryptResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDecryptMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Signs data using a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
     * with [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose]
     * ASYMMETRIC_SIGN, producing a signature that can be verified with the public
     * key retrieved from
     * [GetPublicKey][google.cloud.kms.v1.KeyManagementService.GetPublicKey].
     * </pre>
     */
    public void asymmetricSign(com.google.cloud.kms.v1.AsymmetricSignRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.AsymmetricSignResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAsymmetricSignMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Decrypts data that was encrypted with a public key retrieved from
     * [GetPublicKey][google.cloud.kms.v1.KeyManagementService.GetPublicKey]
     * corresponding to a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
     * with [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose]
     * ASYMMETRIC_DECRYPT.
     * </pre>
     */
    public void asymmetricDecrypt(com.google.cloud.kms.v1.AsymmetricDecryptRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.AsymmetricDecryptResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAsymmetricDecryptMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Signs data using a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
     * with [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] MAC,
     * producing a tag that can be verified by another source with the same key.
     * </pre>
     */
    public void macSign(com.google.cloud.kms.v1.MacSignRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.MacSignResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMacSignMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Verifies MAC tag using a
     * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] with
     * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] MAC, and returns
     * a response that indicates whether or not the verification was successful.
     * </pre>
     */
    public void macVerify(com.google.cloud.kms.v1.MacVerifyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.MacVerifyResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMacVerifyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Generate random bytes using the Cloud KMS randomness source in the provided
     * location.
     * </pre>
     */
    public void generateRandomBytes(com.google.cloud.kms.v1.GenerateRandomBytesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.GenerateRandomBytesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateRandomBytesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Google Cloud Key Management Service
   * Manages cryptographic keys and operations using those keys. Implements a REST
   * model with the following objects:
   * * [KeyRing][google.cloud.kms.v1.KeyRing]
   * * [CryptoKey][google.cloud.kms.v1.CryptoKey]
   * * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
   * * [ImportJob][google.cloud.kms.v1.ImportJob]
   * If you are using manual gRPC libraries, see
   * [Using gRPC with Cloud KMS](https://cloud.google.com/kms/docs/grpc).
   * </pre>
   */
  public static final class KeyManagementServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<KeyManagementServiceBlockingStub> {
    private KeyManagementServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KeyManagementServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new KeyManagementServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists [KeyRings][google.cloud.kms.v1.KeyRing].
     * </pre>
     */
    public com.google.cloud.kms.v1.ListKeyRingsResponse listKeyRings(com.google.cloud.kms.v1.ListKeyRingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListKeyRingsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists [CryptoKeys][google.cloud.kms.v1.CryptoKey].
     * </pre>
     */
    public com.google.cloud.kms.v1.ListCryptoKeysResponse listCryptoKeys(com.google.cloud.kms.v1.ListCryptoKeysRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCryptoKeysMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists [CryptoKeyVersions][google.cloud.kms.v1.CryptoKeyVersion].
     * </pre>
     */
    public com.google.cloud.kms.v1.ListCryptoKeyVersionsResponse listCryptoKeyVersions(com.google.cloud.kms.v1.ListCryptoKeyVersionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCryptoKeyVersionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists [ImportJobs][google.cloud.kms.v1.ImportJob].
     * </pre>
     */
    public com.google.cloud.kms.v1.ListImportJobsResponse listImportJobs(com.google.cloud.kms.v1.ListImportJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListImportJobsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns metadata for a given [KeyRing][google.cloud.kms.v1.KeyRing].
     * </pre>
     */
    public com.google.cloud.kms.v1.KeyRing getKeyRing(com.google.cloud.kms.v1.GetKeyRingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetKeyRingMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns metadata for a given [CryptoKey][google.cloud.kms.v1.CryptoKey], as
     * well as its [primary][google.cloud.kms.v1.CryptoKey.primary]
     * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
     * </pre>
     */
    public com.google.cloud.kms.v1.CryptoKey getCryptoKey(com.google.cloud.kms.v1.GetCryptoKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCryptoKeyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns metadata for a given
     * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
     * </pre>
     */
    public com.google.cloud.kms.v1.CryptoKeyVersion getCryptoKeyVersion(com.google.cloud.kms.v1.GetCryptoKeyVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCryptoKeyVersionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns the public key for the given
     * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]. The
     * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
     * [ASYMMETRIC_SIGN][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ASYMMETRIC_SIGN]
     * or
     * [ASYMMETRIC_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ASYMMETRIC_DECRYPT].
     * </pre>
     */
    public com.google.cloud.kms.v1.PublicKey getPublicKey(com.google.cloud.kms.v1.GetPublicKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPublicKeyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns metadata for a given [ImportJob][google.cloud.kms.v1.ImportJob].
     * </pre>
     */
    public com.google.cloud.kms.v1.ImportJob getImportJob(com.google.cloud.kms.v1.GetImportJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetImportJobMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Create a new [KeyRing][google.cloud.kms.v1.KeyRing] in a given Project and
     * Location.
     * </pre>
     */
    public com.google.cloud.kms.v1.KeyRing createKeyRing(com.google.cloud.kms.v1.CreateKeyRingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateKeyRingMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Create a new [CryptoKey][google.cloud.kms.v1.CryptoKey] within a
     * [KeyRing][google.cloud.kms.v1.KeyRing].
     * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] and
     * [CryptoKey.version_template.algorithm][google.cloud.kms.v1.CryptoKeyVersionTemplate.algorithm]
     * are required.
     * </pre>
     */
    public com.google.cloud.kms.v1.CryptoKey createCryptoKey(com.google.cloud.kms.v1.CreateCryptoKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCryptoKeyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Create a new [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] in a
     * [CryptoKey][google.cloud.kms.v1.CryptoKey].
     * The server will assign the next sequential id. If unset,
     * [state][google.cloud.kms.v1.CryptoKeyVersion.state] will be set to
     * [ENABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.ENABLED].
     * </pre>
     */
    public com.google.cloud.kms.v1.CryptoKeyVersion createCryptoKeyVersion(com.google.cloud.kms.v1.CreateCryptoKeyVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCryptoKeyVersionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Import wrapped key material into a
     * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
     * All requests must specify a [CryptoKey][google.cloud.kms.v1.CryptoKey]. If
     * a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] is additionally
     * specified in the request, key material will be reimported into that
     * version. Otherwise, a new version will be created, and will be assigned the
     * next sequential id within the [CryptoKey][google.cloud.kms.v1.CryptoKey].
     * </pre>
     */
    public com.google.cloud.kms.v1.CryptoKeyVersion importCryptoKeyVersion(com.google.cloud.kms.v1.ImportCryptoKeyVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportCryptoKeyVersionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Create a new [ImportJob][google.cloud.kms.v1.ImportJob] within a
     * [KeyRing][google.cloud.kms.v1.KeyRing].
     * [ImportJob.import_method][google.cloud.kms.v1.ImportJob.import_method] is
     * required.
     * </pre>
     */
    public com.google.cloud.kms.v1.ImportJob createImportJob(com.google.cloud.kms.v1.CreateImportJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateImportJobMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Update a [CryptoKey][google.cloud.kms.v1.CryptoKey].
     * </pre>
     */
    public com.google.cloud.kms.v1.CryptoKey updateCryptoKey(com.google.cloud.kms.v1.UpdateCryptoKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCryptoKeyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Update a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]'s
     * metadata.
     * [state][google.cloud.kms.v1.CryptoKeyVersion.state] may be changed between
     * [ENABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.ENABLED]
     * and
     * [DISABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DISABLED]
     * using this method. See
     * [DestroyCryptoKeyVersion][google.cloud.kms.v1.KeyManagementService.DestroyCryptoKeyVersion]
     * and
     * [RestoreCryptoKeyVersion][google.cloud.kms.v1.KeyManagementService.RestoreCryptoKeyVersion]
     * to move between other states.
     * </pre>
     */
    public com.google.cloud.kms.v1.CryptoKeyVersion updateCryptoKeyVersion(com.google.cloud.kms.v1.UpdateCryptoKeyVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCryptoKeyVersionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Update the version of a [CryptoKey][google.cloud.kms.v1.CryptoKey] that
     * will be used in
     * [Encrypt][google.cloud.kms.v1.KeyManagementService.Encrypt].
     * Returns an error if called on a key whose purpose is not
     * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
     * </pre>
     */
    public com.google.cloud.kms.v1.CryptoKey updateCryptoKeyPrimaryVersion(com.google.cloud.kms.v1.UpdateCryptoKeyPrimaryVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCryptoKeyPrimaryVersionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Schedule a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] for
     * destruction.
     * Upon calling this method,
     * [CryptoKeyVersion.state][google.cloud.kms.v1.CryptoKeyVersion.state] will
     * be set to
     * [DESTROY_SCHEDULED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROY_SCHEDULED],
     * and [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] will
     * be set to the time
     * [destroy_scheduled_duration][google.cloud.kms.v1.CryptoKey.destroy_scheduled_duration]
     * in the future. At that time, the
     * [state][google.cloud.kms.v1.CryptoKeyVersion.state] will automatically
     * change to
     * [DESTROYED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROYED],
     * and the key material will be irrevocably destroyed.
     * Before the
     * [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] is
     * reached,
     * [RestoreCryptoKeyVersion][google.cloud.kms.v1.KeyManagementService.RestoreCryptoKeyVersion]
     * may be called to reverse the process.
     * </pre>
     */
    public com.google.cloud.kms.v1.CryptoKeyVersion destroyCryptoKeyVersion(com.google.cloud.kms.v1.DestroyCryptoKeyVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDestroyCryptoKeyVersionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Restore a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] in the
     * [DESTROY_SCHEDULED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROY_SCHEDULED]
     * state.
     * Upon restoration of the CryptoKeyVersion,
     * [state][google.cloud.kms.v1.CryptoKeyVersion.state] will be set to
     * [DISABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DISABLED],
     * and [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] will
     * be cleared.
     * </pre>
     */
    public com.google.cloud.kms.v1.CryptoKeyVersion restoreCryptoKeyVersion(com.google.cloud.kms.v1.RestoreCryptoKeyVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestoreCryptoKeyVersionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Encrypts data, so that it can only be recovered by a call to
     * [Decrypt][google.cloud.kms.v1.KeyManagementService.Decrypt]. The
     * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
     * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
     * </pre>
     */
    public com.google.cloud.kms.v1.EncryptResponse encrypt(com.google.cloud.kms.v1.EncryptRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEncryptMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Decrypts data that was protected by
     * [Encrypt][google.cloud.kms.v1.KeyManagementService.Encrypt]. The
     * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
     * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
     * </pre>
     */
    public com.google.cloud.kms.v1.DecryptResponse decrypt(com.google.cloud.kms.v1.DecryptRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDecryptMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Signs data using a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
     * with [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose]
     * ASYMMETRIC_SIGN, producing a signature that can be verified with the public
     * key retrieved from
     * [GetPublicKey][google.cloud.kms.v1.KeyManagementService.GetPublicKey].
     * </pre>
     */
    public com.google.cloud.kms.v1.AsymmetricSignResponse asymmetricSign(com.google.cloud.kms.v1.AsymmetricSignRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAsymmetricSignMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Decrypts data that was encrypted with a public key retrieved from
     * [GetPublicKey][google.cloud.kms.v1.KeyManagementService.GetPublicKey]
     * corresponding to a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
     * with [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose]
     * ASYMMETRIC_DECRYPT.
     * </pre>
     */
    public com.google.cloud.kms.v1.AsymmetricDecryptResponse asymmetricDecrypt(com.google.cloud.kms.v1.AsymmetricDecryptRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAsymmetricDecryptMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Signs data using a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
     * with [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] MAC,
     * producing a tag that can be verified by another source with the same key.
     * </pre>
     */
    public com.google.cloud.kms.v1.MacSignResponse macSign(com.google.cloud.kms.v1.MacSignRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMacSignMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Verifies MAC tag using a
     * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] with
     * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] MAC, and returns
     * a response that indicates whether or not the verification was successful.
     * </pre>
     */
    public com.google.cloud.kms.v1.MacVerifyResponse macVerify(com.google.cloud.kms.v1.MacVerifyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMacVerifyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Generate random bytes using the Cloud KMS randomness source in the provided
     * location.
     * </pre>
     */
    public com.google.cloud.kms.v1.GenerateRandomBytesResponse generateRandomBytes(com.google.cloud.kms.v1.GenerateRandomBytesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateRandomBytesMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Google Cloud Key Management Service
   * Manages cryptographic keys and operations using those keys. Implements a REST
   * model with the following objects:
   * * [KeyRing][google.cloud.kms.v1.KeyRing]
   * * [CryptoKey][google.cloud.kms.v1.CryptoKey]
   * * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
   * * [ImportJob][google.cloud.kms.v1.ImportJob]
   * If you are using manual gRPC libraries, see
   * [Using gRPC with Cloud KMS](https://cloud.google.com/kms/docs/grpc).
   * </pre>
   */
  public static final class KeyManagementServiceFutureStub extends io.grpc.stub.AbstractFutureStub<KeyManagementServiceFutureStub> {
    private KeyManagementServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KeyManagementServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new KeyManagementServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists [KeyRings][google.cloud.kms.v1.KeyRing].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.ListKeyRingsResponse> listKeyRings(
        com.google.cloud.kms.v1.ListKeyRingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListKeyRingsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists [CryptoKeys][google.cloud.kms.v1.CryptoKey].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.ListCryptoKeysResponse> listCryptoKeys(
        com.google.cloud.kms.v1.ListCryptoKeysRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCryptoKeysMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists [CryptoKeyVersions][google.cloud.kms.v1.CryptoKeyVersion].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.ListCryptoKeyVersionsResponse> listCryptoKeyVersions(
        com.google.cloud.kms.v1.ListCryptoKeyVersionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCryptoKeyVersionsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists [ImportJobs][google.cloud.kms.v1.ImportJob].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.ListImportJobsResponse> listImportJobs(
        com.google.cloud.kms.v1.ListImportJobsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListImportJobsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns metadata for a given [KeyRing][google.cloud.kms.v1.KeyRing].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.KeyRing> getKeyRing(
        com.google.cloud.kms.v1.GetKeyRingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetKeyRingMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns metadata for a given [CryptoKey][google.cloud.kms.v1.CryptoKey], as
     * well as its [primary][google.cloud.kms.v1.CryptoKey.primary]
     * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.CryptoKey> getCryptoKey(
        com.google.cloud.kms.v1.GetCryptoKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCryptoKeyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns metadata for a given
     * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.CryptoKeyVersion> getCryptoKeyVersion(
        com.google.cloud.kms.v1.GetCryptoKeyVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCryptoKeyVersionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns the public key for the given
     * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]. The
     * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
     * [ASYMMETRIC_SIGN][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ASYMMETRIC_SIGN]
     * or
     * [ASYMMETRIC_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ASYMMETRIC_DECRYPT].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.PublicKey> getPublicKey(
        com.google.cloud.kms.v1.GetPublicKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPublicKeyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns metadata for a given [ImportJob][google.cloud.kms.v1.ImportJob].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.ImportJob> getImportJob(
        com.google.cloud.kms.v1.GetImportJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetImportJobMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Create a new [KeyRing][google.cloud.kms.v1.KeyRing] in a given Project and
     * Location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.KeyRing> createKeyRing(
        com.google.cloud.kms.v1.CreateKeyRingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateKeyRingMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Create a new [CryptoKey][google.cloud.kms.v1.CryptoKey] within a
     * [KeyRing][google.cloud.kms.v1.KeyRing].
     * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] and
     * [CryptoKey.version_template.algorithm][google.cloud.kms.v1.CryptoKeyVersionTemplate.algorithm]
     * are required.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.CryptoKey> createCryptoKey(
        com.google.cloud.kms.v1.CreateCryptoKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCryptoKeyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Create a new [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] in a
     * [CryptoKey][google.cloud.kms.v1.CryptoKey].
     * The server will assign the next sequential id. If unset,
     * [state][google.cloud.kms.v1.CryptoKeyVersion.state] will be set to
     * [ENABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.ENABLED].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.CryptoKeyVersion> createCryptoKeyVersion(
        com.google.cloud.kms.v1.CreateCryptoKeyVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCryptoKeyVersionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Import wrapped key material into a
     * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
     * All requests must specify a [CryptoKey][google.cloud.kms.v1.CryptoKey]. If
     * a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] is additionally
     * specified in the request, key material will be reimported into that
     * version. Otherwise, a new version will be created, and will be assigned the
     * next sequential id within the [CryptoKey][google.cloud.kms.v1.CryptoKey].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.CryptoKeyVersion> importCryptoKeyVersion(
        com.google.cloud.kms.v1.ImportCryptoKeyVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportCryptoKeyVersionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Create a new [ImportJob][google.cloud.kms.v1.ImportJob] within a
     * [KeyRing][google.cloud.kms.v1.KeyRing].
     * [ImportJob.import_method][google.cloud.kms.v1.ImportJob.import_method] is
     * required.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.ImportJob> createImportJob(
        com.google.cloud.kms.v1.CreateImportJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateImportJobMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Update a [CryptoKey][google.cloud.kms.v1.CryptoKey].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.CryptoKey> updateCryptoKey(
        com.google.cloud.kms.v1.UpdateCryptoKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCryptoKeyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Update a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]'s
     * metadata.
     * [state][google.cloud.kms.v1.CryptoKeyVersion.state] may be changed between
     * [ENABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.ENABLED]
     * and
     * [DISABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DISABLED]
     * using this method. See
     * [DestroyCryptoKeyVersion][google.cloud.kms.v1.KeyManagementService.DestroyCryptoKeyVersion]
     * and
     * [RestoreCryptoKeyVersion][google.cloud.kms.v1.KeyManagementService.RestoreCryptoKeyVersion]
     * to move between other states.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.CryptoKeyVersion> updateCryptoKeyVersion(
        com.google.cloud.kms.v1.UpdateCryptoKeyVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCryptoKeyVersionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Update the version of a [CryptoKey][google.cloud.kms.v1.CryptoKey] that
     * will be used in
     * [Encrypt][google.cloud.kms.v1.KeyManagementService.Encrypt].
     * Returns an error if called on a key whose purpose is not
     * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.CryptoKey> updateCryptoKeyPrimaryVersion(
        com.google.cloud.kms.v1.UpdateCryptoKeyPrimaryVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCryptoKeyPrimaryVersionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Schedule a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] for
     * destruction.
     * Upon calling this method,
     * [CryptoKeyVersion.state][google.cloud.kms.v1.CryptoKeyVersion.state] will
     * be set to
     * [DESTROY_SCHEDULED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROY_SCHEDULED],
     * and [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] will
     * be set to the time
     * [destroy_scheduled_duration][google.cloud.kms.v1.CryptoKey.destroy_scheduled_duration]
     * in the future. At that time, the
     * [state][google.cloud.kms.v1.CryptoKeyVersion.state] will automatically
     * change to
     * [DESTROYED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROYED],
     * and the key material will be irrevocably destroyed.
     * Before the
     * [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] is
     * reached,
     * [RestoreCryptoKeyVersion][google.cloud.kms.v1.KeyManagementService.RestoreCryptoKeyVersion]
     * may be called to reverse the process.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.CryptoKeyVersion> destroyCryptoKeyVersion(
        com.google.cloud.kms.v1.DestroyCryptoKeyVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDestroyCryptoKeyVersionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Restore a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] in the
     * [DESTROY_SCHEDULED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROY_SCHEDULED]
     * state.
     * Upon restoration of the CryptoKeyVersion,
     * [state][google.cloud.kms.v1.CryptoKeyVersion.state] will be set to
     * [DISABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DISABLED],
     * and [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] will
     * be cleared.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.CryptoKeyVersion> restoreCryptoKeyVersion(
        com.google.cloud.kms.v1.RestoreCryptoKeyVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRestoreCryptoKeyVersionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Encrypts data, so that it can only be recovered by a call to
     * [Decrypt][google.cloud.kms.v1.KeyManagementService.Decrypt]. The
     * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
     * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.EncryptResponse> encrypt(
        com.google.cloud.kms.v1.EncryptRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEncryptMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Decrypts data that was protected by
     * [Encrypt][google.cloud.kms.v1.KeyManagementService.Encrypt]. The
     * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
     * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.DecryptResponse> decrypt(
        com.google.cloud.kms.v1.DecryptRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDecryptMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Signs data using a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
     * with [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose]
     * ASYMMETRIC_SIGN, producing a signature that can be verified with the public
     * key retrieved from
     * [GetPublicKey][google.cloud.kms.v1.KeyManagementService.GetPublicKey].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.AsymmetricSignResponse> asymmetricSign(
        com.google.cloud.kms.v1.AsymmetricSignRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAsymmetricSignMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Decrypts data that was encrypted with a public key retrieved from
     * [GetPublicKey][google.cloud.kms.v1.KeyManagementService.GetPublicKey]
     * corresponding to a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
     * with [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose]
     * ASYMMETRIC_DECRYPT.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.AsymmetricDecryptResponse> asymmetricDecrypt(
        com.google.cloud.kms.v1.AsymmetricDecryptRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAsymmetricDecryptMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Signs data using a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
     * with [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] MAC,
     * producing a tag that can be verified by another source with the same key.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.MacSignResponse> macSign(
        com.google.cloud.kms.v1.MacSignRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMacSignMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Verifies MAC tag using a
     * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] with
     * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] MAC, and returns
     * a response that indicates whether or not the verification was successful.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.MacVerifyResponse> macVerify(
        com.google.cloud.kms.v1.MacVerifyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMacVerifyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Generate random bytes using the Cloud KMS randomness source in the provided
     * location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.GenerateRandomBytesResponse> generateRandomBytes(
        com.google.cloud.kms.v1.GenerateRandomBytesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateRandomBytesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_KEY_RINGS = 0;
  private static final int METHODID_LIST_CRYPTO_KEYS = 1;
  private static final int METHODID_LIST_CRYPTO_KEY_VERSIONS = 2;
  private static final int METHODID_LIST_IMPORT_JOBS = 3;
  private static final int METHODID_GET_KEY_RING = 4;
  private static final int METHODID_GET_CRYPTO_KEY = 5;
  private static final int METHODID_GET_CRYPTO_KEY_VERSION = 6;
  private static final int METHODID_GET_PUBLIC_KEY = 7;
  private static final int METHODID_GET_IMPORT_JOB = 8;
  private static final int METHODID_CREATE_KEY_RING = 9;
  private static final int METHODID_CREATE_CRYPTO_KEY = 10;
  private static final int METHODID_CREATE_CRYPTO_KEY_VERSION = 11;
  private static final int METHODID_IMPORT_CRYPTO_KEY_VERSION = 12;
  private static final int METHODID_CREATE_IMPORT_JOB = 13;
  private static final int METHODID_UPDATE_CRYPTO_KEY = 14;
  private static final int METHODID_UPDATE_CRYPTO_KEY_VERSION = 15;
  private static final int METHODID_UPDATE_CRYPTO_KEY_PRIMARY_VERSION = 16;
  private static final int METHODID_DESTROY_CRYPTO_KEY_VERSION = 17;
  private static final int METHODID_RESTORE_CRYPTO_KEY_VERSION = 18;
  private static final int METHODID_ENCRYPT = 19;
  private static final int METHODID_DECRYPT = 20;
  private static final int METHODID_ASYMMETRIC_SIGN = 21;
  private static final int METHODID_ASYMMETRIC_DECRYPT = 22;
  private static final int METHODID_MAC_SIGN = 23;
  private static final int METHODID_MAC_VERIFY = 24;
  private static final int METHODID_GENERATE_RANDOM_BYTES = 25;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final KeyManagementServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(KeyManagementServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_KEY_RINGS:
          serviceImpl.listKeyRings((com.google.cloud.kms.v1.ListKeyRingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ListKeyRingsResponse>) responseObserver);
          break;
        case METHODID_LIST_CRYPTO_KEYS:
          serviceImpl.listCryptoKeys((com.google.cloud.kms.v1.ListCryptoKeysRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ListCryptoKeysResponse>) responseObserver);
          break;
        case METHODID_LIST_CRYPTO_KEY_VERSIONS:
          serviceImpl.listCryptoKeyVersions((com.google.cloud.kms.v1.ListCryptoKeyVersionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ListCryptoKeyVersionsResponse>) responseObserver);
          break;
        case METHODID_LIST_IMPORT_JOBS:
          serviceImpl.listImportJobs((com.google.cloud.kms.v1.ListImportJobsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ListImportJobsResponse>) responseObserver);
          break;
        case METHODID_GET_KEY_RING:
          serviceImpl.getKeyRing((com.google.cloud.kms.v1.GetKeyRingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.KeyRing>) responseObserver);
          break;
        case METHODID_GET_CRYPTO_KEY:
          serviceImpl.getCryptoKey((com.google.cloud.kms.v1.GetCryptoKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKey>) responseObserver);
          break;
        case METHODID_GET_CRYPTO_KEY_VERSION:
          serviceImpl.getCryptoKeyVersion((com.google.cloud.kms.v1.GetCryptoKeyVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKeyVersion>) responseObserver);
          break;
        case METHODID_GET_PUBLIC_KEY:
          serviceImpl.getPublicKey((com.google.cloud.kms.v1.GetPublicKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.PublicKey>) responseObserver);
          break;
        case METHODID_GET_IMPORT_JOB:
          serviceImpl.getImportJob((com.google.cloud.kms.v1.GetImportJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ImportJob>) responseObserver);
          break;
        case METHODID_CREATE_KEY_RING:
          serviceImpl.createKeyRing((com.google.cloud.kms.v1.CreateKeyRingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.KeyRing>) responseObserver);
          break;
        case METHODID_CREATE_CRYPTO_KEY:
          serviceImpl.createCryptoKey((com.google.cloud.kms.v1.CreateCryptoKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKey>) responseObserver);
          break;
        case METHODID_CREATE_CRYPTO_KEY_VERSION:
          serviceImpl.createCryptoKeyVersion((com.google.cloud.kms.v1.CreateCryptoKeyVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKeyVersion>) responseObserver);
          break;
        case METHODID_IMPORT_CRYPTO_KEY_VERSION:
          serviceImpl.importCryptoKeyVersion((com.google.cloud.kms.v1.ImportCryptoKeyVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKeyVersion>) responseObserver);
          break;
        case METHODID_CREATE_IMPORT_JOB:
          serviceImpl.createImportJob((com.google.cloud.kms.v1.CreateImportJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ImportJob>) responseObserver);
          break;
        case METHODID_UPDATE_CRYPTO_KEY:
          serviceImpl.updateCryptoKey((com.google.cloud.kms.v1.UpdateCryptoKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKey>) responseObserver);
          break;
        case METHODID_UPDATE_CRYPTO_KEY_VERSION:
          serviceImpl.updateCryptoKeyVersion((com.google.cloud.kms.v1.UpdateCryptoKeyVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKeyVersion>) responseObserver);
          break;
        case METHODID_UPDATE_CRYPTO_KEY_PRIMARY_VERSION:
          serviceImpl.updateCryptoKeyPrimaryVersion((com.google.cloud.kms.v1.UpdateCryptoKeyPrimaryVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKey>) responseObserver);
          break;
        case METHODID_DESTROY_CRYPTO_KEY_VERSION:
          serviceImpl.destroyCryptoKeyVersion((com.google.cloud.kms.v1.DestroyCryptoKeyVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKeyVersion>) responseObserver);
          break;
        case METHODID_RESTORE_CRYPTO_KEY_VERSION:
          serviceImpl.restoreCryptoKeyVersion((com.google.cloud.kms.v1.RestoreCryptoKeyVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKeyVersion>) responseObserver);
          break;
        case METHODID_ENCRYPT:
          serviceImpl.encrypt((com.google.cloud.kms.v1.EncryptRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.EncryptResponse>) responseObserver);
          break;
        case METHODID_DECRYPT:
          serviceImpl.decrypt((com.google.cloud.kms.v1.DecryptRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.DecryptResponse>) responseObserver);
          break;
        case METHODID_ASYMMETRIC_SIGN:
          serviceImpl.asymmetricSign((com.google.cloud.kms.v1.AsymmetricSignRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.AsymmetricSignResponse>) responseObserver);
          break;
        case METHODID_ASYMMETRIC_DECRYPT:
          serviceImpl.asymmetricDecrypt((com.google.cloud.kms.v1.AsymmetricDecryptRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.AsymmetricDecryptResponse>) responseObserver);
          break;
        case METHODID_MAC_SIGN:
          serviceImpl.macSign((com.google.cloud.kms.v1.MacSignRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.MacSignResponse>) responseObserver);
          break;
        case METHODID_MAC_VERIFY:
          serviceImpl.macVerify((com.google.cloud.kms.v1.MacVerifyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.MacVerifyResponse>) responseObserver);
          break;
        case METHODID_GENERATE_RANDOM_BYTES:
          serviceImpl.generateRandomBytes((com.google.cloud.kms.v1.GenerateRandomBytesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.GenerateRandomBytesResponse>) responseObserver);
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

  private static abstract class KeyManagementServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    KeyManagementServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.kms.v1.KmsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("KeyManagementService");
    }
  }

  private static final class KeyManagementServiceFileDescriptorSupplier
      extends KeyManagementServiceBaseDescriptorSupplier {
    KeyManagementServiceFileDescriptorSupplier() {}
  }

  private static final class KeyManagementServiceMethodDescriptorSupplier
      extends KeyManagementServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    KeyManagementServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (KeyManagementServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new KeyManagementServiceFileDescriptorSupplier())
              .addMethod(getListKeyRingsMethod())
              .addMethod(getListCryptoKeysMethod())
              .addMethod(getListCryptoKeyVersionsMethod())
              .addMethod(getListImportJobsMethod())
              .addMethod(getGetKeyRingMethod())
              .addMethod(getGetCryptoKeyMethod())
              .addMethod(getGetCryptoKeyVersionMethod())
              .addMethod(getGetPublicKeyMethod())
              .addMethod(getGetImportJobMethod())
              .addMethod(getCreateKeyRingMethod())
              .addMethod(getCreateCryptoKeyMethod())
              .addMethod(getCreateCryptoKeyVersionMethod())
              .addMethod(getImportCryptoKeyVersionMethod())
              .addMethod(getCreateImportJobMethod())
              .addMethod(getUpdateCryptoKeyMethod())
              .addMethod(getUpdateCryptoKeyVersionMethod())
              .addMethod(getUpdateCryptoKeyPrimaryVersionMethod())
              .addMethod(getDestroyCryptoKeyVersionMethod())
              .addMethod(getRestoreCryptoKeyVersionMethod())
              .addMethod(getEncryptMethod())
              .addMethod(getDecryptMethod())
              .addMethod(getAsymmetricSignMethod())
              .addMethod(getAsymmetricDecryptMethod())
              .addMethod(getMacSignMethod())
              .addMethod(getMacVerifyMethod())
              .addMethod(getGenerateRandomBytesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
