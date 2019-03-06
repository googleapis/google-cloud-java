package com.google.cloud.kms.v1;

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
 * Google Cloud Key Management Service
 * Manages cryptographic keys and operations using those keys. Implements a REST
 * model with the following objects:
 * * [KeyRing][google.cloud.kms.v1.KeyRing]
 * * [CryptoKey][google.cloud.kms.v1.CryptoKey]
 * * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
 * If you are using manual gRPC libraries, see
 * [Using gRPC with Cloud KMS](https://cloud.google.com/kms/docs/grpc).
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/kms/v1/service.proto")
public final class KeyManagementServiceGrpc {

  private KeyManagementServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.kms.v1.KeyManagementService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListKeyRingsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.ListKeyRingsRequest, com.google.cloud.kms.v1.ListKeyRingsResponse>
      METHOD_LIST_KEY_RINGS = getListKeyRingsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.ListKeyRingsRequest, com.google.cloud.kms.v1.ListKeyRingsResponse>
      getListKeyRingsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.ListKeyRingsRequest, com.google.cloud.kms.v1.ListKeyRingsResponse>
      getListKeyRingsMethod() {
    return getListKeyRingsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.ListKeyRingsRequest, com.google.cloud.kms.v1.ListKeyRingsResponse>
      getListKeyRingsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.v1.ListKeyRingsRequest,
            com.google.cloud.kms.v1.ListKeyRingsResponse>
        getListKeyRingsMethod;
    if ((getListKeyRingsMethod = KeyManagementServiceGrpc.getListKeyRingsMethod) == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getListKeyRingsMethod = KeyManagementServiceGrpc.getListKeyRingsMethod) == null) {
          KeyManagementServiceGrpc.getListKeyRingsMethod =
              getListKeyRingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.v1.ListKeyRingsRequest,
                          com.google.cloud.kms.v1.ListKeyRingsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.kms.v1.KeyManagementService", "ListKeyRings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.ListKeyRingsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.ListKeyRingsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new KeyManagementServiceMethodDescriptorSupplier("ListKeyRings"))
                      .build();
        }
      }
    }
    return getListKeyRingsMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListCryptoKeysMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.ListCryptoKeysRequest,
          com.google.cloud.kms.v1.ListCryptoKeysResponse>
      METHOD_LIST_CRYPTO_KEYS = getListCryptoKeysMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.ListCryptoKeysRequest,
          com.google.cloud.kms.v1.ListCryptoKeysResponse>
      getListCryptoKeysMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.ListCryptoKeysRequest,
          com.google.cloud.kms.v1.ListCryptoKeysResponse>
      getListCryptoKeysMethod() {
    return getListCryptoKeysMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.ListCryptoKeysRequest,
          com.google.cloud.kms.v1.ListCryptoKeysResponse>
      getListCryptoKeysMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.v1.ListCryptoKeysRequest,
            com.google.cloud.kms.v1.ListCryptoKeysResponse>
        getListCryptoKeysMethod;
    if ((getListCryptoKeysMethod = KeyManagementServiceGrpc.getListCryptoKeysMethod) == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getListCryptoKeysMethod = KeyManagementServiceGrpc.getListCryptoKeysMethod) == null) {
          KeyManagementServiceGrpc.getListCryptoKeysMethod =
              getListCryptoKeysMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.v1.ListCryptoKeysRequest,
                          com.google.cloud.kms.v1.ListCryptoKeysResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.kms.v1.KeyManagementService", "ListCryptoKeys"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.ListCryptoKeysRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.ListCryptoKeysResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new KeyManagementServiceMethodDescriptorSupplier("ListCryptoKeys"))
                      .build();
        }
      }
    }
    return getListCryptoKeysMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListCryptoKeyVersionsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.ListCryptoKeyVersionsRequest,
          com.google.cloud.kms.v1.ListCryptoKeyVersionsResponse>
      METHOD_LIST_CRYPTO_KEY_VERSIONS = getListCryptoKeyVersionsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.ListCryptoKeyVersionsRequest,
          com.google.cloud.kms.v1.ListCryptoKeyVersionsResponse>
      getListCryptoKeyVersionsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.ListCryptoKeyVersionsRequest,
          com.google.cloud.kms.v1.ListCryptoKeyVersionsResponse>
      getListCryptoKeyVersionsMethod() {
    return getListCryptoKeyVersionsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.ListCryptoKeyVersionsRequest,
          com.google.cloud.kms.v1.ListCryptoKeyVersionsResponse>
      getListCryptoKeyVersionsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.v1.ListCryptoKeyVersionsRequest,
            com.google.cloud.kms.v1.ListCryptoKeyVersionsResponse>
        getListCryptoKeyVersionsMethod;
    if ((getListCryptoKeyVersionsMethod = KeyManagementServiceGrpc.getListCryptoKeyVersionsMethod)
        == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getListCryptoKeyVersionsMethod =
                KeyManagementServiceGrpc.getListCryptoKeyVersionsMethod)
            == null) {
          KeyManagementServiceGrpc.getListCryptoKeyVersionsMethod =
              getListCryptoKeyVersionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.v1.ListCryptoKeyVersionsRequest,
                          com.google.cloud.kms.v1.ListCryptoKeyVersionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.kms.v1.KeyManagementService", "ListCryptoKeyVersions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.ListCryptoKeyVersionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.ListCryptoKeyVersionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new KeyManagementServiceMethodDescriptorSupplier("ListCryptoKeyVersions"))
                      .build();
        }
      }
    }
    return getListCryptoKeyVersionsMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetKeyRingMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.GetKeyRingRequest, com.google.cloud.kms.v1.KeyRing>
      METHOD_GET_KEY_RING = getGetKeyRingMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.GetKeyRingRequest, com.google.cloud.kms.v1.KeyRing>
      getGetKeyRingMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.GetKeyRingRequest, com.google.cloud.kms.v1.KeyRing>
      getGetKeyRingMethod() {
    return getGetKeyRingMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.GetKeyRingRequest, com.google.cloud.kms.v1.KeyRing>
      getGetKeyRingMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.v1.GetKeyRingRequest, com.google.cloud.kms.v1.KeyRing>
        getGetKeyRingMethod;
    if ((getGetKeyRingMethod = KeyManagementServiceGrpc.getGetKeyRingMethod) == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getGetKeyRingMethod = KeyManagementServiceGrpc.getGetKeyRingMethod) == null) {
          KeyManagementServiceGrpc.getGetKeyRingMethod =
              getGetKeyRingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.v1.GetKeyRingRequest, com.google.cloud.kms.v1.KeyRing>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.kms.v1.KeyManagementService", "GetKeyRing"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.GetKeyRingRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.KeyRing.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new KeyManagementServiceMethodDescriptorSupplier("GetKeyRing"))
                      .build();
        }
      }
    }
    return getGetKeyRingMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetCryptoKeyMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.GetCryptoKeyRequest, com.google.cloud.kms.v1.CryptoKey>
      METHOD_GET_CRYPTO_KEY = getGetCryptoKeyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.GetCryptoKeyRequest, com.google.cloud.kms.v1.CryptoKey>
      getGetCryptoKeyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.GetCryptoKeyRequest, com.google.cloud.kms.v1.CryptoKey>
      getGetCryptoKeyMethod() {
    return getGetCryptoKeyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.GetCryptoKeyRequest, com.google.cloud.kms.v1.CryptoKey>
      getGetCryptoKeyMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.v1.GetCryptoKeyRequest, com.google.cloud.kms.v1.CryptoKey>
        getGetCryptoKeyMethod;
    if ((getGetCryptoKeyMethod = KeyManagementServiceGrpc.getGetCryptoKeyMethod) == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getGetCryptoKeyMethod = KeyManagementServiceGrpc.getGetCryptoKeyMethod) == null) {
          KeyManagementServiceGrpc.getGetCryptoKeyMethod =
              getGetCryptoKeyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.v1.GetCryptoKeyRequest,
                          com.google.cloud.kms.v1.CryptoKey>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.kms.v1.KeyManagementService", "GetCryptoKey"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.GetCryptoKeyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.CryptoKey.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new KeyManagementServiceMethodDescriptorSupplier("GetCryptoKey"))
                      .build();
        }
      }
    }
    return getGetCryptoKeyMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetCryptoKeyVersionMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.GetCryptoKeyVersionRequest,
          com.google.cloud.kms.v1.CryptoKeyVersion>
      METHOD_GET_CRYPTO_KEY_VERSION = getGetCryptoKeyVersionMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.GetCryptoKeyVersionRequest,
          com.google.cloud.kms.v1.CryptoKeyVersion>
      getGetCryptoKeyVersionMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.GetCryptoKeyVersionRequest,
          com.google.cloud.kms.v1.CryptoKeyVersion>
      getGetCryptoKeyVersionMethod() {
    return getGetCryptoKeyVersionMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.GetCryptoKeyVersionRequest,
          com.google.cloud.kms.v1.CryptoKeyVersion>
      getGetCryptoKeyVersionMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.v1.GetCryptoKeyVersionRequest,
            com.google.cloud.kms.v1.CryptoKeyVersion>
        getGetCryptoKeyVersionMethod;
    if ((getGetCryptoKeyVersionMethod = KeyManagementServiceGrpc.getGetCryptoKeyVersionMethod)
        == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getGetCryptoKeyVersionMethod = KeyManagementServiceGrpc.getGetCryptoKeyVersionMethod)
            == null) {
          KeyManagementServiceGrpc.getGetCryptoKeyVersionMethod =
              getGetCryptoKeyVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.v1.GetCryptoKeyVersionRequest,
                          com.google.cloud.kms.v1.CryptoKeyVersion>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.kms.v1.KeyManagementService", "GetCryptoKeyVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.GetCryptoKeyVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.CryptoKeyVersion.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new KeyManagementServiceMethodDescriptorSupplier("GetCryptoKeyVersion"))
                      .build();
        }
      }
    }
    return getGetCryptoKeyVersionMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetPublicKeyMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.GetPublicKeyRequest, com.google.cloud.kms.v1.PublicKey>
      METHOD_GET_PUBLIC_KEY = getGetPublicKeyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.GetPublicKeyRequest, com.google.cloud.kms.v1.PublicKey>
      getGetPublicKeyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.GetPublicKeyRequest, com.google.cloud.kms.v1.PublicKey>
      getGetPublicKeyMethod() {
    return getGetPublicKeyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.GetPublicKeyRequest, com.google.cloud.kms.v1.PublicKey>
      getGetPublicKeyMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.v1.GetPublicKeyRequest, com.google.cloud.kms.v1.PublicKey>
        getGetPublicKeyMethod;
    if ((getGetPublicKeyMethod = KeyManagementServiceGrpc.getGetPublicKeyMethod) == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getGetPublicKeyMethod = KeyManagementServiceGrpc.getGetPublicKeyMethod) == null) {
          KeyManagementServiceGrpc.getGetPublicKeyMethod =
              getGetPublicKeyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.v1.GetPublicKeyRequest,
                          com.google.cloud.kms.v1.PublicKey>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.kms.v1.KeyManagementService", "GetPublicKey"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.GetPublicKeyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.PublicKey.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new KeyManagementServiceMethodDescriptorSupplier("GetPublicKey"))
                      .build();
        }
      }
    }
    return getGetPublicKeyMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateKeyRingMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.CreateKeyRingRequest, com.google.cloud.kms.v1.KeyRing>
      METHOD_CREATE_KEY_RING = getCreateKeyRingMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.CreateKeyRingRequest, com.google.cloud.kms.v1.KeyRing>
      getCreateKeyRingMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.CreateKeyRingRequest, com.google.cloud.kms.v1.KeyRing>
      getCreateKeyRingMethod() {
    return getCreateKeyRingMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.CreateKeyRingRequest, com.google.cloud.kms.v1.KeyRing>
      getCreateKeyRingMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.v1.CreateKeyRingRequest, com.google.cloud.kms.v1.KeyRing>
        getCreateKeyRingMethod;
    if ((getCreateKeyRingMethod = KeyManagementServiceGrpc.getCreateKeyRingMethod) == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getCreateKeyRingMethod = KeyManagementServiceGrpc.getCreateKeyRingMethod) == null) {
          KeyManagementServiceGrpc.getCreateKeyRingMethod =
              getCreateKeyRingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.v1.CreateKeyRingRequest,
                          com.google.cloud.kms.v1.KeyRing>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.kms.v1.KeyManagementService", "CreateKeyRing"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.CreateKeyRingRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.KeyRing.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new KeyManagementServiceMethodDescriptorSupplier("CreateKeyRing"))
                      .build();
        }
      }
    }
    return getCreateKeyRingMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateCryptoKeyMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.CreateCryptoKeyRequest, com.google.cloud.kms.v1.CryptoKey>
      METHOD_CREATE_CRYPTO_KEY = getCreateCryptoKeyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.CreateCryptoKeyRequest, com.google.cloud.kms.v1.CryptoKey>
      getCreateCryptoKeyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.CreateCryptoKeyRequest, com.google.cloud.kms.v1.CryptoKey>
      getCreateCryptoKeyMethod() {
    return getCreateCryptoKeyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.CreateCryptoKeyRequest, com.google.cloud.kms.v1.CryptoKey>
      getCreateCryptoKeyMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.v1.CreateCryptoKeyRequest, com.google.cloud.kms.v1.CryptoKey>
        getCreateCryptoKeyMethod;
    if ((getCreateCryptoKeyMethod = KeyManagementServiceGrpc.getCreateCryptoKeyMethod) == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getCreateCryptoKeyMethod = KeyManagementServiceGrpc.getCreateCryptoKeyMethod)
            == null) {
          KeyManagementServiceGrpc.getCreateCryptoKeyMethod =
              getCreateCryptoKeyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.v1.CreateCryptoKeyRequest,
                          com.google.cloud.kms.v1.CryptoKey>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.kms.v1.KeyManagementService", "CreateCryptoKey"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.CreateCryptoKeyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.CryptoKey.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new KeyManagementServiceMethodDescriptorSupplier("CreateCryptoKey"))
                      .build();
        }
      }
    }
    return getCreateCryptoKeyMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateCryptoKeyVersionMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.CreateCryptoKeyVersionRequest,
          com.google.cloud.kms.v1.CryptoKeyVersion>
      METHOD_CREATE_CRYPTO_KEY_VERSION = getCreateCryptoKeyVersionMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.CreateCryptoKeyVersionRequest,
          com.google.cloud.kms.v1.CryptoKeyVersion>
      getCreateCryptoKeyVersionMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.CreateCryptoKeyVersionRequest,
          com.google.cloud.kms.v1.CryptoKeyVersion>
      getCreateCryptoKeyVersionMethod() {
    return getCreateCryptoKeyVersionMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.CreateCryptoKeyVersionRequest,
          com.google.cloud.kms.v1.CryptoKeyVersion>
      getCreateCryptoKeyVersionMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.v1.CreateCryptoKeyVersionRequest,
            com.google.cloud.kms.v1.CryptoKeyVersion>
        getCreateCryptoKeyVersionMethod;
    if ((getCreateCryptoKeyVersionMethod = KeyManagementServiceGrpc.getCreateCryptoKeyVersionMethod)
        == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getCreateCryptoKeyVersionMethod =
                KeyManagementServiceGrpc.getCreateCryptoKeyVersionMethod)
            == null) {
          KeyManagementServiceGrpc.getCreateCryptoKeyVersionMethod =
              getCreateCryptoKeyVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.v1.CreateCryptoKeyVersionRequest,
                          com.google.cloud.kms.v1.CryptoKeyVersion>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.kms.v1.KeyManagementService", "CreateCryptoKeyVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.CreateCryptoKeyVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.CryptoKeyVersion.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new KeyManagementServiceMethodDescriptorSupplier(
                              "CreateCryptoKeyVersion"))
                      .build();
        }
      }
    }
    return getCreateCryptoKeyVersionMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateCryptoKeyMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.UpdateCryptoKeyRequest, com.google.cloud.kms.v1.CryptoKey>
      METHOD_UPDATE_CRYPTO_KEY = getUpdateCryptoKeyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.UpdateCryptoKeyRequest, com.google.cloud.kms.v1.CryptoKey>
      getUpdateCryptoKeyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.UpdateCryptoKeyRequest, com.google.cloud.kms.v1.CryptoKey>
      getUpdateCryptoKeyMethod() {
    return getUpdateCryptoKeyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.UpdateCryptoKeyRequest, com.google.cloud.kms.v1.CryptoKey>
      getUpdateCryptoKeyMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.v1.UpdateCryptoKeyRequest, com.google.cloud.kms.v1.CryptoKey>
        getUpdateCryptoKeyMethod;
    if ((getUpdateCryptoKeyMethod = KeyManagementServiceGrpc.getUpdateCryptoKeyMethod) == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getUpdateCryptoKeyMethod = KeyManagementServiceGrpc.getUpdateCryptoKeyMethod)
            == null) {
          KeyManagementServiceGrpc.getUpdateCryptoKeyMethod =
              getUpdateCryptoKeyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.v1.UpdateCryptoKeyRequest,
                          com.google.cloud.kms.v1.CryptoKey>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.kms.v1.KeyManagementService", "UpdateCryptoKey"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.UpdateCryptoKeyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.CryptoKey.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new KeyManagementServiceMethodDescriptorSupplier("UpdateCryptoKey"))
                      .build();
        }
      }
    }
    return getUpdateCryptoKeyMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateCryptoKeyVersionMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.UpdateCryptoKeyVersionRequest,
          com.google.cloud.kms.v1.CryptoKeyVersion>
      METHOD_UPDATE_CRYPTO_KEY_VERSION = getUpdateCryptoKeyVersionMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.UpdateCryptoKeyVersionRequest,
          com.google.cloud.kms.v1.CryptoKeyVersion>
      getUpdateCryptoKeyVersionMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.UpdateCryptoKeyVersionRequest,
          com.google.cloud.kms.v1.CryptoKeyVersion>
      getUpdateCryptoKeyVersionMethod() {
    return getUpdateCryptoKeyVersionMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.UpdateCryptoKeyVersionRequest,
          com.google.cloud.kms.v1.CryptoKeyVersion>
      getUpdateCryptoKeyVersionMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.v1.UpdateCryptoKeyVersionRequest,
            com.google.cloud.kms.v1.CryptoKeyVersion>
        getUpdateCryptoKeyVersionMethod;
    if ((getUpdateCryptoKeyVersionMethod = KeyManagementServiceGrpc.getUpdateCryptoKeyVersionMethod)
        == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getUpdateCryptoKeyVersionMethod =
                KeyManagementServiceGrpc.getUpdateCryptoKeyVersionMethod)
            == null) {
          KeyManagementServiceGrpc.getUpdateCryptoKeyVersionMethod =
              getUpdateCryptoKeyVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.v1.UpdateCryptoKeyVersionRequest,
                          com.google.cloud.kms.v1.CryptoKeyVersion>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.kms.v1.KeyManagementService", "UpdateCryptoKeyVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.UpdateCryptoKeyVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.CryptoKeyVersion.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new KeyManagementServiceMethodDescriptorSupplier(
                              "UpdateCryptoKeyVersion"))
                      .build();
        }
      }
    }
    return getUpdateCryptoKeyVersionMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getEncryptMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.EncryptRequest, com.google.cloud.kms.v1.EncryptResponse>
      METHOD_ENCRYPT = getEncryptMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.EncryptRequest, com.google.cloud.kms.v1.EncryptResponse>
      getEncryptMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.EncryptRequest, com.google.cloud.kms.v1.EncryptResponse>
      getEncryptMethod() {
    return getEncryptMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.EncryptRequest, com.google.cloud.kms.v1.EncryptResponse>
      getEncryptMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.v1.EncryptRequest, com.google.cloud.kms.v1.EncryptResponse>
        getEncryptMethod;
    if ((getEncryptMethod = KeyManagementServiceGrpc.getEncryptMethod) == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getEncryptMethod = KeyManagementServiceGrpc.getEncryptMethod) == null) {
          KeyManagementServiceGrpc.getEncryptMethod =
              getEncryptMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.v1.EncryptRequest,
                          com.google.cloud.kms.v1.EncryptResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.kms.v1.KeyManagementService", "Encrypt"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.EncryptRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.EncryptResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new KeyManagementServiceMethodDescriptorSupplier("Encrypt"))
                      .build();
        }
      }
    }
    return getEncryptMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDecryptMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.DecryptRequest, com.google.cloud.kms.v1.DecryptResponse>
      METHOD_DECRYPT = getDecryptMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.DecryptRequest, com.google.cloud.kms.v1.DecryptResponse>
      getDecryptMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.DecryptRequest, com.google.cloud.kms.v1.DecryptResponse>
      getDecryptMethod() {
    return getDecryptMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.DecryptRequest, com.google.cloud.kms.v1.DecryptResponse>
      getDecryptMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.v1.DecryptRequest, com.google.cloud.kms.v1.DecryptResponse>
        getDecryptMethod;
    if ((getDecryptMethod = KeyManagementServiceGrpc.getDecryptMethod) == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getDecryptMethod = KeyManagementServiceGrpc.getDecryptMethod) == null) {
          KeyManagementServiceGrpc.getDecryptMethod =
              getDecryptMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.v1.DecryptRequest,
                          com.google.cloud.kms.v1.DecryptResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.kms.v1.KeyManagementService", "Decrypt"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.DecryptRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.DecryptResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new KeyManagementServiceMethodDescriptorSupplier("Decrypt"))
                      .build();
        }
      }
    }
    return getDecryptMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAsymmetricSignMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.AsymmetricSignRequest,
          com.google.cloud.kms.v1.AsymmetricSignResponse>
      METHOD_ASYMMETRIC_SIGN = getAsymmetricSignMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.AsymmetricSignRequest,
          com.google.cloud.kms.v1.AsymmetricSignResponse>
      getAsymmetricSignMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.AsymmetricSignRequest,
          com.google.cloud.kms.v1.AsymmetricSignResponse>
      getAsymmetricSignMethod() {
    return getAsymmetricSignMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.AsymmetricSignRequest,
          com.google.cloud.kms.v1.AsymmetricSignResponse>
      getAsymmetricSignMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.v1.AsymmetricSignRequest,
            com.google.cloud.kms.v1.AsymmetricSignResponse>
        getAsymmetricSignMethod;
    if ((getAsymmetricSignMethod = KeyManagementServiceGrpc.getAsymmetricSignMethod) == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getAsymmetricSignMethod = KeyManagementServiceGrpc.getAsymmetricSignMethod) == null) {
          KeyManagementServiceGrpc.getAsymmetricSignMethod =
              getAsymmetricSignMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.v1.AsymmetricSignRequest,
                          com.google.cloud.kms.v1.AsymmetricSignResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.kms.v1.KeyManagementService", "AsymmetricSign"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.AsymmetricSignRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.AsymmetricSignResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new KeyManagementServiceMethodDescriptorSupplier("AsymmetricSign"))
                      .build();
        }
      }
    }
    return getAsymmetricSignMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAsymmetricDecryptMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.AsymmetricDecryptRequest,
          com.google.cloud.kms.v1.AsymmetricDecryptResponse>
      METHOD_ASYMMETRIC_DECRYPT = getAsymmetricDecryptMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.AsymmetricDecryptRequest,
          com.google.cloud.kms.v1.AsymmetricDecryptResponse>
      getAsymmetricDecryptMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.AsymmetricDecryptRequest,
          com.google.cloud.kms.v1.AsymmetricDecryptResponse>
      getAsymmetricDecryptMethod() {
    return getAsymmetricDecryptMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.AsymmetricDecryptRequest,
          com.google.cloud.kms.v1.AsymmetricDecryptResponse>
      getAsymmetricDecryptMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.v1.AsymmetricDecryptRequest,
            com.google.cloud.kms.v1.AsymmetricDecryptResponse>
        getAsymmetricDecryptMethod;
    if ((getAsymmetricDecryptMethod = KeyManagementServiceGrpc.getAsymmetricDecryptMethod)
        == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getAsymmetricDecryptMethod = KeyManagementServiceGrpc.getAsymmetricDecryptMethod)
            == null) {
          KeyManagementServiceGrpc.getAsymmetricDecryptMethod =
              getAsymmetricDecryptMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.v1.AsymmetricDecryptRequest,
                          com.google.cloud.kms.v1.AsymmetricDecryptResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.kms.v1.KeyManagementService", "AsymmetricDecrypt"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.AsymmetricDecryptRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.AsymmetricDecryptResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new KeyManagementServiceMethodDescriptorSupplier("AsymmetricDecrypt"))
                      .build();
        }
      }
    }
    return getAsymmetricDecryptMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateCryptoKeyPrimaryVersionMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.UpdateCryptoKeyPrimaryVersionRequest,
          com.google.cloud.kms.v1.CryptoKey>
      METHOD_UPDATE_CRYPTO_KEY_PRIMARY_VERSION = getUpdateCryptoKeyPrimaryVersionMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.UpdateCryptoKeyPrimaryVersionRequest,
          com.google.cloud.kms.v1.CryptoKey>
      getUpdateCryptoKeyPrimaryVersionMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.UpdateCryptoKeyPrimaryVersionRequest,
          com.google.cloud.kms.v1.CryptoKey>
      getUpdateCryptoKeyPrimaryVersionMethod() {
    return getUpdateCryptoKeyPrimaryVersionMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.UpdateCryptoKeyPrimaryVersionRequest,
          com.google.cloud.kms.v1.CryptoKey>
      getUpdateCryptoKeyPrimaryVersionMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.v1.UpdateCryptoKeyPrimaryVersionRequest,
            com.google.cloud.kms.v1.CryptoKey>
        getUpdateCryptoKeyPrimaryVersionMethod;
    if ((getUpdateCryptoKeyPrimaryVersionMethod =
            KeyManagementServiceGrpc.getUpdateCryptoKeyPrimaryVersionMethod)
        == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getUpdateCryptoKeyPrimaryVersionMethod =
                KeyManagementServiceGrpc.getUpdateCryptoKeyPrimaryVersionMethod)
            == null) {
          KeyManagementServiceGrpc.getUpdateCryptoKeyPrimaryVersionMethod =
              getUpdateCryptoKeyPrimaryVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.v1.UpdateCryptoKeyPrimaryVersionRequest,
                          com.google.cloud.kms.v1.CryptoKey>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.kms.v1.KeyManagementService",
                              "UpdateCryptoKeyPrimaryVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.UpdateCryptoKeyPrimaryVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.CryptoKey.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new KeyManagementServiceMethodDescriptorSupplier(
                              "UpdateCryptoKeyPrimaryVersion"))
                      .build();
        }
      }
    }
    return getUpdateCryptoKeyPrimaryVersionMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDestroyCryptoKeyVersionMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.DestroyCryptoKeyVersionRequest,
          com.google.cloud.kms.v1.CryptoKeyVersion>
      METHOD_DESTROY_CRYPTO_KEY_VERSION = getDestroyCryptoKeyVersionMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.DestroyCryptoKeyVersionRequest,
          com.google.cloud.kms.v1.CryptoKeyVersion>
      getDestroyCryptoKeyVersionMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.DestroyCryptoKeyVersionRequest,
          com.google.cloud.kms.v1.CryptoKeyVersion>
      getDestroyCryptoKeyVersionMethod() {
    return getDestroyCryptoKeyVersionMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.DestroyCryptoKeyVersionRequest,
          com.google.cloud.kms.v1.CryptoKeyVersion>
      getDestroyCryptoKeyVersionMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.v1.DestroyCryptoKeyVersionRequest,
            com.google.cloud.kms.v1.CryptoKeyVersion>
        getDestroyCryptoKeyVersionMethod;
    if ((getDestroyCryptoKeyVersionMethod =
            KeyManagementServiceGrpc.getDestroyCryptoKeyVersionMethod)
        == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getDestroyCryptoKeyVersionMethod =
                KeyManagementServiceGrpc.getDestroyCryptoKeyVersionMethod)
            == null) {
          KeyManagementServiceGrpc.getDestroyCryptoKeyVersionMethod =
              getDestroyCryptoKeyVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.v1.DestroyCryptoKeyVersionRequest,
                          com.google.cloud.kms.v1.CryptoKeyVersion>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.kms.v1.KeyManagementService",
                              "DestroyCryptoKeyVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.DestroyCryptoKeyVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.CryptoKeyVersion.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new KeyManagementServiceMethodDescriptorSupplier(
                              "DestroyCryptoKeyVersion"))
                      .build();
        }
      }
    }
    return getDestroyCryptoKeyVersionMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getRestoreCryptoKeyVersionMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.RestoreCryptoKeyVersionRequest,
          com.google.cloud.kms.v1.CryptoKeyVersion>
      METHOD_RESTORE_CRYPTO_KEY_VERSION = getRestoreCryptoKeyVersionMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.RestoreCryptoKeyVersionRequest,
          com.google.cloud.kms.v1.CryptoKeyVersion>
      getRestoreCryptoKeyVersionMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.RestoreCryptoKeyVersionRequest,
          com.google.cloud.kms.v1.CryptoKeyVersion>
      getRestoreCryptoKeyVersionMethod() {
    return getRestoreCryptoKeyVersionMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.RestoreCryptoKeyVersionRequest,
          com.google.cloud.kms.v1.CryptoKeyVersion>
      getRestoreCryptoKeyVersionMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.v1.RestoreCryptoKeyVersionRequest,
            com.google.cloud.kms.v1.CryptoKeyVersion>
        getRestoreCryptoKeyVersionMethod;
    if ((getRestoreCryptoKeyVersionMethod =
            KeyManagementServiceGrpc.getRestoreCryptoKeyVersionMethod)
        == null) {
      synchronized (KeyManagementServiceGrpc.class) {
        if ((getRestoreCryptoKeyVersionMethod =
                KeyManagementServiceGrpc.getRestoreCryptoKeyVersionMethod)
            == null) {
          KeyManagementServiceGrpc.getRestoreCryptoKeyVersionMethod =
              getRestoreCryptoKeyVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.v1.RestoreCryptoKeyVersionRequest,
                          com.google.cloud.kms.v1.CryptoKeyVersion>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.kms.v1.KeyManagementService",
                              "RestoreCryptoKeyVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.RestoreCryptoKeyVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.CryptoKeyVersion.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new KeyManagementServiceMethodDescriptorSupplier(
                              "RestoreCryptoKeyVersion"))
                      .build();
        }
      }
    }
    return getRestoreCryptoKeyVersionMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static KeyManagementServiceStub newStub(io.grpc.Channel channel) {
    return new KeyManagementServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static KeyManagementServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new KeyManagementServiceBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static KeyManagementServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    return new KeyManagementServiceFutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * Google Cloud Key Management Service
   * Manages cryptographic keys and operations using those keys. Implements a REST
   * model with the following objects:
   * * [KeyRing][google.cloud.kms.v1.KeyRing]
   * * [CryptoKey][google.cloud.kms.v1.CryptoKey]
   * * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
   * If you are using manual gRPC libraries, see
   * [Using gRPC with Cloud KMS](https://cloud.google.com/kms/docs/grpc).
   * </pre>
   */
  public abstract static class KeyManagementServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Lists [KeyRings][google.cloud.kms.v1.KeyRing].
     * </pre>
     */
    public void listKeyRings(
        com.google.cloud.kms.v1.ListKeyRingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ListKeyRingsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListKeyRingsMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists [CryptoKeys][google.cloud.kms.v1.CryptoKey].
     * </pre>
     */
    public void listCryptoKeys(
        com.google.cloud.kms.v1.ListCryptoKeysRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ListCryptoKeysResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListCryptoKeysMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists [CryptoKeyVersions][google.cloud.kms.v1.CryptoKeyVersion].
     * </pre>
     */
    public void listCryptoKeyVersions(
        com.google.cloud.kms.v1.ListCryptoKeyVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ListCryptoKeyVersionsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListCryptoKeyVersionsMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for a given [KeyRing][google.cloud.kms.v1.KeyRing].
     * </pre>
     */
    public void getKeyRing(
        com.google.cloud.kms.v1.GetKeyRingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.KeyRing> responseObserver) {
      asyncUnimplementedUnaryCall(getGetKeyRingMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for a given [CryptoKey][google.cloud.kms.v1.CryptoKey], as
     * well as its [primary][google.cloud.kms.v1.CryptoKey.primary]
     * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
     * </pre>
     */
    public void getCryptoKey(
        com.google.cloud.kms.v1.GetCryptoKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKey> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCryptoKeyMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for a given
     * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
     * </pre>
     */
    public void getCryptoKeyVersion(
        com.google.cloud.kms.v1.GetCryptoKeyVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKeyVersion> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCryptoKeyVersionMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the public key for the given
     * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]. The
     * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
     * [ASYMMETRIC_SIGN][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ASYMMETRIC_SIGN]
     * or
     * [ASYMMETRIC_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ASYMMETRIC_DECRYPT].
     * </pre>
     */
    public void getPublicKey(
        com.google.cloud.kms.v1.GetPublicKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.PublicKey> responseObserver) {
      asyncUnimplementedUnaryCall(getGetPublicKeyMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new [KeyRing][google.cloud.kms.v1.KeyRing] in a given Project and
     * Location.
     * </pre>
     */
    public void createKeyRing(
        com.google.cloud.kms.v1.CreateKeyRingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.KeyRing> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateKeyRingMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new [CryptoKey][google.cloud.kms.v1.CryptoKey] within a
     * [KeyRing][google.cloud.kms.v1.KeyRing].
     * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] and
     * [CryptoKey.version_template.algorithm][google.cloud.kms.v1.CryptoKeyVersionTemplate.algorithm]
     * are required.
     * </pre>
     */
    public void createCryptoKey(
        com.google.cloud.kms.v1.CreateCryptoKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKey> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateCryptoKeyMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] in a
     * [CryptoKey][google.cloud.kms.v1.CryptoKey].
     * The server will assign the next sequential id. If unset,
     * [state][google.cloud.kms.v1.CryptoKeyVersion.state] will be set to
     * [ENABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.ENABLED].
     * </pre>
     */
    public void createCryptoKeyVersion(
        com.google.cloud.kms.v1.CreateCryptoKeyVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKeyVersion> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateCryptoKeyVersionMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a [CryptoKey][google.cloud.kms.v1.CryptoKey].
     * </pre>
     */
    public void updateCryptoKey(
        com.google.cloud.kms.v1.UpdateCryptoKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKey> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateCryptoKeyMethodHelper(), responseObserver);
    }

    /**
     *
     *
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
    public void updateCryptoKeyVersion(
        com.google.cloud.kms.v1.UpdateCryptoKeyVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKeyVersion> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateCryptoKeyVersionMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Encrypts data, so that it can only be recovered by a call to
     * [Decrypt][google.cloud.kms.v1.KeyManagementService.Decrypt]. The
     * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
     * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
     * </pre>
     */
    public void encrypt(
        com.google.cloud.kms.v1.EncryptRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.EncryptResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getEncryptMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Decrypts data that was protected by
     * [Encrypt][google.cloud.kms.v1.KeyManagementService.Encrypt]. The
     * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
     * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
     * </pre>
     */
    public void decrypt(
        com.google.cloud.kms.v1.DecryptRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.DecryptResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDecryptMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Signs data using a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
     * with [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose]
     * ASYMMETRIC_SIGN, producing a signature that can be verified with the public
     * key retrieved from
     * [GetPublicKey][google.cloud.kms.v1.KeyManagementService.GetPublicKey].
     * </pre>
     */
    public void asymmetricSign(
        com.google.cloud.kms.v1.AsymmetricSignRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.AsymmetricSignResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getAsymmetricSignMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Decrypts data that was encrypted with a public key retrieved from
     * [GetPublicKey][google.cloud.kms.v1.KeyManagementService.GetPublicKey]
     * corresponding to a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
     * with [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose]
     * ASYMMETRIC_DECRYPT.
     * </pre>
     */
    public void asymmetricDecrypt(
        com.google.cloud.kms.v1.AsymmetricDecryptRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.AsymmetricDecryptResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getAsymmetricDecryptMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update the version of a [CryptoKey][google.cloud.kms.v1.CryptoKey] that
     * will be used in
     * [Encrypt][google.cloud.kms.v1.KeyManagementService.Encrypt].
     * Returns an error if called on an asymmetric key.
     * </pre>
     */
    public void updateCryptoKeyPrimaryVersion(
        com.google.cloud.kms.v1.UpdateCryptoKeyPrimaryVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKey> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateCryptoKeyPrimaryVersionMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Schedule a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] for
     * destruction.
     * Upon calling this method,
     * [CryptoKeyVersion.state][google.cloud.kms.v1.CryptoKeyVersion.state] will
     * be set to
     * [DESTROY_SCHEDULED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROY_SCHEDULED]
     * and [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] will
     * be set to a time 24 hours in the future, at which point the
     * [state][google.cloud.kms.v1.CryptoKeyVersion.state] will be changed to
     * [DESTROYED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROYED],
     * and the key material will be irrevocably destroyed.
     * Before the
     * [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] is
     * reached,
     * [RestoreCryptoKeyVersion][google.cloud.kms.v1.KeyManagementService.RestoreCryptoKeyVersion]
     * may be called to reverse the process.
     * </pre>
     */
    public void destroyCryptoKeyVersion(
        com.google.cloud.kms.v1.DestroyCryptoKeyVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKeyVersion> responseObserver) {
      asyncUnimplementedUnaryCall(getDestroyCryptoKeyVersionMethodHelper(), responseObserver);
    }

    /**
     *
     *
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
    public void restoreCryptoKeyVersion(
        com.google.cloud.kms.v1.RestoreCryptoKeyVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKeyVersion> responseObserver) {
      asyncUnimplementedUnaryCall(getRestoreCryptoKeyVersionMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListKeyRingsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.kms.v1.ListKeyRingsRequest,
                      com.google.cloud.kms.v1.ListKeyRingsResponse>(this, METHODID_LIST_KEY_RINGS)))
          .addMethod(
              getListCryptoKeysMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.kms.v1.ListCryptoKeysRequest,
                      com.google.cloud.kms.v1.ListCryptoKeysResponse>(
                      this, METHODID_LIST_CRYPTO_KEYS)))
          .addMethod(
              getListCryptoKeyVersionsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.kms.v1.ListCryptoKeyVersionsRequest,
                      com.google.cloud.kms.v1.ListCryptoKeyVersionsResponse>(
                      this, METHODID_LIST_CRYPTO_KEY_VERSIONS)))
          .addMethod(
              getGetKeyRingMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.kms.v1.GetKeyRingRequest, com.google.cloud.kms.v1.KeyRing>(
                      this, METHODID_GET_KEY_RING)))
          .addMethod(
              getGetCryptoKeyMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.kms.v1.GetCryptoKeyRequest,
                      com.google.cloud.kms.v1.CryptoKey>(this, METHODID_GET_CRYPTO_KEY)))
          .addMethod(
              getGetCryptoKeyVersionMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.kms.v1.GetCryptoKeyVersionRequest,
                      com.google.cloud.kms.v1.CryptoKeyVersion>(
                      this, METHODID_GET_CRYPTO_KEY_VERSION)))
          .addMethod(
              getGetPublicKeyMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.kms.v1.GetPublicKeyRequest,
                      com.google.cloud.kms.v1.PublicKey>(this, METHODID_GET_PUBLIC_KEY)))
          .addMethod(
              getCreateKeyRingMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.kms.v1.CreateKeyRingRequest,
                      com.google.cloud.kms.v1.KeyRing>(this, METHODID_CREATE_KEY_RING)))
          .addMethod(
              getCreateCryptoKeyMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.kms.v1.CreateCryptoKeyRequest,
                      com.google.cloud.kms.v1.CryptoKey>(this, METHODID_CREATE_CRYPTO_KEY)))
          .addMethod(
              getCreateCryptoKeyVersionMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.kms.v1.CreateCryptoKeyVersionRequest,
                      com.google.cloud.kms.v1.CryptoKeyVersion>(
                      this, METHODID_CREATE_CRYPTO_KEY_VERSION)))
          .addMethod(
              getUpdateCryptoKeyMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.kms.v1.UpdateCryptoKeyRequest,
                      com.google.cloud.kms.v1.CryptoKey>(this, METHODID_UPDATE_CRYPTO_KEY)))
          .addMethod(
              getUpdateCryptoKeyVersionMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.kms.v1.UpdateCryptoKeyVersionRequest,
                      com.google.cloud.kms.v1.CryptoKeyVersion>(
                      this, METHODID_UPDATE_CRYPTO_KEY_VERSION)))
          .addMethod(
              getEncryptMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.kms.v1.EncryptRequest,
                      com.google.cloud.kms.v1.EncryptResponse>(this, METHODID_ENCRYPT)))
          .addMethod(
              getDecryptMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.kms.v1.DecryptRequest,
                      com.google.cloud.kms.v1.DecryptResponse>(this, METHODID_DECRYPT)))
          .addMethod(
              getAsymmetricSignMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.kms.v1.AsymmetricSignRequest,
                      com.google.cloud.kms.v1.AsymmetricSignResponse>(
                      this, METHODID_ASYMMETRIC_SIGN)))
          .addMethod(
              getAsymmetricDecryptMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.kms.v1.AsymmetricDecryptRequest,
                      com.google.cloud.kms.v1.AsymmetricDecryptResponse>(
                      this, METHODID_ASYMMETRIC_DECRYPT)))
          .addMethod(
              getUpdateCryptoKeyPrimaryVersionMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.kms.v1.UpdateCryptoKeyPrimaryVersionRequest,
                      com.google.cloud.kms.v1.CryptoKey>(
                      this, METHODID_UPDATE_CRYPTO_KEY_PRIMARY_VERSION)))
          .addMethod(
              getDestroyCryptoKeyVersionMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.kms.v1.DestroyCryptoKeyVersionRequest,
                      com.google.cloud.kms.v1.CryptoKeyVersion>(
                      this, METHODID_DESTROY_CRYPTO_KEY_VERSION)))
          .addMethod(
              getRestoreCryptoKeyVersionMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.kms.v1.RestoreCryptoKeyVersionRequest,
                      com.google.cloud.kms.v1.CryptoKeyVersion>(
                      this, METHODID_RESTORE_CRYPTO_KEY_VERSION)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Google Cloud Key Management Service
   * Manages cryptographic keys and operations using those keys. Implements a REST
   * model with the following objects:
   * * [KeyRing][google.cloud.kms.v1.KeyRing]
   * * [CryptoKey][google.cloud.kms.v1.CryptoKey]
   * * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
   * If you are using manual gRPC libraries, see
   * [Using gRPC with Cloud KMS](https://cloud.google.com/kms/docs/grpc).
   * </pre>
   */
  public static final class KeyManagementServiceStub
      extends io.grpc.stub.AbstractStub<KeyManagementServiceStub> {
    private KeyManagementServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private KeyManagementServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KeyManagementServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new KeyManagementServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists [KeyRings][google.cloud.kms.v1.KeyRing].
     * </pre>
     */
    public void listKeyRings(
        com.google.cloud.kms.v1.ListKeyRingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ListKeyRingsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListKeyRingsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists [CryptoKeys][google.cloud.kms.v1.CryptoKey].
     * </pre>
     */
    public void listCryptoKeys(
        com.google.cloud.kms.v1.ListCryptoKeysRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ListCryptoKeysResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListCryptoKeysMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists [CryptoKeyVersions][google.cloud.kms.v1.CryptoKeyVersion].
     * </pre>
     */
    public void listCryptoKeyVersions(
        com.google.cloud.kms.v1.ListCryptoKeyVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ListCryptoKeyVersionsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListCryptoKeyVersionsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for a given [KeyRing][google.cloud.kms.v1.KeyRing].
     * </pre>
     */
    public void getKeyRing(
        com.google.cloud.kms.v1.GetKeyRingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.KeyRing> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetKeyRingMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for a given [CryptoKey][google.cloud.kms.v1.CryptoKey], as
     * well as its [primary][google.cloud.kms.v1.CryptoKey.primary]
     * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
     * </pre>
     */
    public void getCryptoKey(
        com.google.cloud.kms.v1.GetCryptoKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKey> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCryptoKeyMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for a given
     * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
     * </pre>
     */
    public void getCryptoKeyVersion(
        com.google.cloud.kms.v1.GetCryptoKeyVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKeyVersion> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCryptoKeyVersionMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the public key for the given
     * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]. The
     * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
     * [ASYMMETRIC_SIGN][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ASYMMETRIC_SIGN]
     * or
     * [ASYMMETRIC_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ASYMMETRIC_DECRYPT].
     * </pre>
     */
    public void getPublicKey(
        com.google.cloud.kms.v1.GetPublicKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.PublicKey> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetPublicKeyMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new [KeyRing][google.cloud.kms.v1.KeyRing] in a given Project and
     * Location.
     * </pre>
     */
    public void createKeyRing(
        com.google.cloud.kms.v1.CreateKeyRingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.KeyRing> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateKeyRingMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new [CryptoKey][google.cloud.kms.v1.CryptoKey] within a
     * [KeyRing][google.cloud.kms.v1.KeyRing].
     * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] and
     * [CryptoKey.version_template.algorithm][google.cloud.kms.v1.CryptoKeyVersionTemplate.algorithm]
     * are required.
     * </pre>
     */
    public void createCryptoKey(
        com.google.cloud.kms.v1.CreateCryptoKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKey> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateCryptoKeyMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] in a
     * [CryptoKey][google.cloud.kms.v1.CryptoKey].
     * The server will assign the next sequential id. If unset,
     * [state][google.cloud.kms.v1.CryptoKeyVersion.state] will be set to
     * [ENABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.ENABLED].
     * </pre>
     */
    public void createCryptoKeyVersion(
        com.google.cloud.kms.v1.CreateCryptoKeyVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKeyVersion> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateCryptoKeyVersionMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a [CryptoKey][google.cloud.kms.v1.CryptoKey].
     * </pre>
     */
    public void updateCryptoKey(
        com.google.cloud.kms.v1.UpdateCryptoKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKey> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateCryptoKeyMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
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
    public void updateCryptoKeyVersion(
        com.google.cloud.kms.v1.UpdateCryptoKeyVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKeyVersion> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateCryptoKeyVersionMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Encrypts data, so that it can only be recovered by a call to
     * [Decrypt][google.cloud.kms.v1.KeyManagementService.Decrypt]. The
     * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
     * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
     * </pre>
     */
    public void encrypt(
        com.google.cloud.kms.v1.EncryptRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.EncryptResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getEncryptMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Decrypts data that was protected by
     * [Encrypt][google.cloud.kms.v1.KeyManagementService.Encrypt]. The
     * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
     * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
     * </pre>
     */
    public void decrypt(
        com.google.cloud.kms.v1.DecryptRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.DecryptResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDecryptMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Signs data using a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
     * with [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose]
     * ASYMMETRIC_SIGN, producing a signature that can be verified with the public
     * key retrieved from
     * [GetPublicKey][google.cloud.kms.v1.KeyManagementService.GetPublicKey].
     * </pre>
     */
    public void asymmetricSign(
        com.google.cloud.kms.v1.AsymmetricSignRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.AsymmetricSignResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAsymmetricSignMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Decrypts data that was encrypted with a public key retrieved from
     * [GetPublicKey][google.cloud.kms.v1.KeyManagementService.GetPublicKey]
     * corresponding to a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
     * with [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose]
     * ASYMMETRIC_DECRYPT.
     * </pre>
     */
    public void asymmetricDecrypt(
        com.google.cloud.kms.v1.AsymmetricDecryptRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.AsymmetricDecryptResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAsymmetricDecryptMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update the version of a [CryptoKey][google.cloud.kms.v1.CryptoKey] that
     * will be used in
     * [Encrypt][google.cloud.kms.v1.KeyManagementService.Encrypt].
     * Returns an error if called on an asymmetric key.
     * </pre>
     */
    public void updateCryptoKeyPrimaryVersion(
        com.google.cloud.kms.v1.UpdateCryptoKeyPrimaryVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKey> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateCryptoKeyPrimaryVersionMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Schedule a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] for
     * destruction.
     * Upon calling this method,
     * [CryptoKeyVersion.state][google.cloud.kms.v1.CryptoKeyVersion.state] will
     * be set to
     * [DESTROY_SCHEDULED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROY_SCHEDULED]
     * and [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] will
     * be set to a time 24 hours in the future, at which point the
     * [state][google.cloud.kms.v1.CryptoKeyVersion.state] will be changed to
     * [DESTROYED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROYED],
     * and the key material will be irrevocably destroyed.
     * Before the
     * [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] is
     * reached,
     * [RestoreCryptoKeyVersion][google.cloud.kms.v1.KeyManagementService.RestoreCryptoKeyVersion]
     * may be called to reverse the process.
     * </pre>
     */
    public void destroyCryptoKeyVersion(
        com.google.cloud.kms.v1.DestroyCryptoKeyVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKeyVersion> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDestroyCryptoKeyVersionMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
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
    public void restoreCryptoKeyVersion(
        com.google.cloud.kms.v1.RestoreCryptoKeyVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKeyVersion> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRestoreCryptoKeyVersionMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Google Cloud Key Management Service
   * Manages cryptographic keys and operations using those keys. Implements a REST
   * model with the following objects:
   * * [KeyRing][google.cloud.kms.v1.KeyRing]
   * * [CryptoKey][google.cloud.kms.v1.CryptoKey]
   * * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
   * If you are using manual gRPC libraries, see
   * [Using gRPC with Cloud KMS](https://cloud.google.com/kms/docs/grpc).
   * </pre>
   */
  public static final class KeyManagementServiceBlockingStub
      extends io.grpc.stub.AbstractStub<KeyManagementServiceBlockingStub> {
    private KeyManagementServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

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
     *
     *
     * <pre>
     * Lists [KeyRings][google.cloud.kms.v1.KeyRing].
     * </pre>
     */
    public com.google.cloud.kms.v1.ListKeyRingsResponse listKeyRings(
        com.google.cloud.kms.v1.ListKeyRingsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListKeyRingsMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists [CryptoKeys][google.cloud.kms.v1.CryptoKey].
     * </pre>
     */
    public com.google.cloud.kms.v1.ListCryptoKeysResponse listCryptoKeys(
        com.google.cloud.kms.v1.ListCryptoKeysRequest request) {
      return blockingUnaryCall(
          getChannel(), getListCryptoKeysMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists [CryptoKeyVersions][google.cloud.kms.v1.CryptoKeyVersion].
     * </pre>
     */
    public com.google.cloud.kms.v1.ListCryptoKeyVersionsResponse listCryptoKeyVersions(
        com.google.cloud.kms.v1.ListCryptoKeyVersionsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListCryptoKeyVersionsMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for a given [KeyRing][google.cloud.kms.v1.KeyRing].
     * </pre>
     */
    public com.google.cloud.kms.v1.KeyRing getKeyRing(
        com.google.cloud.kms.v1.GetKeyRingRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetKeyRingMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for a given [CryptoKey][google.cloud.kms.v1.CryptoKey], as
     * well as its [primary][google.cloud.kms.v1.CryptoKey.primary]
     * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
     * </pre>
     */
    public com.google.cloud.kms.v1.CryptoKey getCryptoKey(
        com.google.cloud.kms.v1.GetCryptoKeyRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetCryptoKeyMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for a given
     * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
     * </pre>
     */
    public com.google.cloud.kms.v1.CryptoKeyVersion getCryptoKeyVersion(
        com.google.cloud.kms.v1.GetCryptoKeyVersionRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetCryptoKeyVersionMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the public key for the given
     * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]. The
     * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
     * [ASYMMETRIC_SIGN][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ASYMMETRIC_SIGN]
     * or
     * [ASYMMETRIC_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ASYMMETRIC_DECRYPT].
     * </pre>
     */
    public com.google.cloud.kms.v1.PublicKey getPublicKey(
        com.google.cloud.kms.v1.GetPublicKeyRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetPublicKeyMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new [KeyRing][google.cloud.kms.v1.KeyRing] in a given Project and
     * Location.
     * </pre>
     */
    public com.google.cloud.kms.v1.KeyRing createKeyRing(
        com.google.cloud.kms.v1.CreateKeyRingRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateKeyRingMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new [CryptoKey][google.cloud.kms.v1.CryptoKey] within a
     * [KeyRing][google.cloud.kms.v1.KeyRing].
     * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] and
     * [CryptoKey.version_template.algorithm][google.cloud.kms.v1.CryptoKeyVersionTemplate.algorithm]
     * are required.
     * </pre>
     */
    public com.google.cloud.kms.v1.CryptoKey createCryptoKey(
        com.google.cloud.kms.v1.CreateCryptoKeyRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateCryptoKeyMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] in a
     * [CryptoKey][google.cloud.kms.v1.CryptoKey].
     * The server will assign the next sequential id. If unset,
     * [state][google.cloud.kms.v1.CryptoKeyVersion.state] will be set to
     * [ENABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.ENABLED].
     * </pre>
     */
    public com.google.cloud.kms.v1.CryptoKeyVersion createCryptoKeyVersion(
        com.google.cloud.kms.v1.CreateCryptoKeyVersionRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateCryptoKeyVersionMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a [CryptoKey][google.cloud.kms.v1.CryptoKey].
     * </pre>
     */
    public com.google.cloud.kms.v1.CryptoKey updateCryptoKey(
        com.google.cloud.kms.v1.UpdateCryptoKeyRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateCryptoKeyMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
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
    public com.google.cloud.kms.v1.CryptoKeyVersion updateCryptoKeyVersion(
        com.google.cloud.kms.v1.UpdateCryptoKeyVersionRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateCryptoKeyVersionMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Encrypts data, so that it can only be recovered by a call to
     * [Decrypt][google.cloud.kms.v1.KeyManagementService.Decrypt]. The
     * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
     * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
     * </pre>
     */
    public com.google.cloud.kms.v1.EncryptResponse encrypt(
        com.google.cloud.kms.v1.EncryptRequest request) {
      return blockingUnaryCall(getChannel(), getEncryptMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Decrypts data that was protected by
     * [Encrypt][google.cloud.kms.v1.KeyManagementService.Encrypt]. The
     * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
     * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
     * </pre>
     */
    public com.google.cloud.kms.v1.DecryptResponse decrypt(
        com.google.cloud.kms.v1.DecryptRequest request) {
      return blockingUnaryCall(getChannel(), getDecryptMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Signs data using a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
     * with [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose]
     * ASYMMETRIC_SIGN, producing a signature that can be verified with the public
     * key retrieved from
     * [GetPublicKey][google.cloud.kms.v1.KeyManagementService.GetPublicKey].
     * </pre>
     */
    public com.google.cloud.kms.v1.AsymmetricSignResponse asymmetricSign(
        com.google.cloud.kms.v1.AsymmetricSignRequest request) {
      return blockingUnaryCall(
          getChannel(), getAsymmetricSignMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Decrypts data that was encrypted with a public key retrieved from
     * [GetPublicKey][google.cloud.kms.v1.KeyManagementService.GetPublicKey]
     * corresponding to a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
     * with [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose]
     * ASYMMETRIC_DECRYPT.
     * </pre>
     */
    public com.google.cloud.kms.v1.AsymmetricDecryptResponse asymmetricDecrypt(
        com.google.cloud.kms.v1.AsymmetricDecryptRequest request) {
      return blockingUnaryCall(
          getChannel(), getAsymmetricDecryptMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update the version of a [CryptoKey][google.cloud.kms.v1.CryptoKey] that
     * will be used in
     * [Encrypt][google.cloud.kms.v1.KeyManagementService.Encrypt].
     * Returns an error if called on an asymmetric key.
     * </pre>
     */
    public com.google.cloud.kms.v1.CryptoKey updateCryptoKeyPrimaryVersion(
        com.google.cloud.kms.v1.UpdateCryptoKeyPrimaryVersionRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateCryptoKeyPrimaryVersionMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Schedule a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] for
     * destruction.
     * Upon calling this method,
     * [CryptoKeyVersion.state][google.cloud.kms.v1.CryptoKeyVersion.state] will
     * be set to
     * [DESTROY_SCHEDULED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROY_SCHEDULED]
     * and [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] will
     * be set to a time 24 hours in the future, at which point the
     * [state][google.cloud.kms.v1.CryptoKeyVersion.state] will be changed to
     * [DESTROYED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROYED],
     * and the key material will be irrevocably destroyed.
     * Before the
     * [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] is
     * reached,
     * [RestoreCryptoKeyVersion][google.cloud.kms.v1.KeyManagementService.RestoreCryptoKeyVersion]
     * may be called to reverse the process.
     * </pre>
     */
    public com.google.cloud.kms.v1.CryptoKeyVersion destroyCryptoKeyVersion(
        com.google.cloud.kms.v1.DestroyCryptoKeyVersionRequest request) {
      return blockingUnaryCall(
          getChannel(), getDestroyCryptoKeyVersionMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
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
    public com.google.cloud.kms.v1.CryptoKeyVersion restoreCryptoKeyVersion(
        com.google.cloud.kms.v1.RestoreCryptoKeyVersionRequest request) {
      return blockingUnaryCall(
          getChannel(), getRestoreCryptoKeyVersionMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Google Cloud Key Management Service
   * Manages cryptographic keys and operations using those keys. Implements a REST
   * model with the following objects:
   * * [KeyRing][google.cloud.kms.v1.KeyRing]
   * * [CryptoKey][google.cloud.kms.v1.CryptoKey]
   * * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
   * If you are using manual gRPC libraries, see
   * [Using gRPC with Cloud KMS](https://cloud.google.com/kms/docs/grpc).
   * </pre>
   */
  public static final class KeyManagementServiceFutureStub
      extends io.grpc.stub.AbstractStub<KeyManagementServiceFutureStub> {
    private KeyManagementServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

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
     *
     *
     * <pre>
     * Lists [KeyRings][google.cloud.kms.v1.KeyRing].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.kms.v1.ListKeyRingsResponse>
        listKeyRings(com.google.cloud.kms.v1.ListKeyRingsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListKeyRingsMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists [CryptoKeys][google.cloud.kms.v1.CryptoKey].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.kms.v1.ListCryptoKeysResponse>
        listCryptoKeys(com.google.cloud.kms.v1.ListCryptoKeysRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListCryptoKeysMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists [CryptoKeyVersions][google.cloud.kms.v1.CryptoKeyVersion].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.kms.v1.ListCryptoKeyVersionsResponse>
        listCryptoKeyVersions(com.google.cloud.kms.v1.ListCryptoKeyVersionsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListCryptoKeyVersionsMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for a given [KeyRing][google.cloud.kms.v1.KeyRing].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.KeyRing>
        getKeyRing(com.google.cloud.kms.v1.GetKeyRingRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetKeyRingMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for a given [CryptoKey][google.cloud.kms.v1.CryptoKey], as
     * well as its [primary][google.cloud.kms.v1.CryptoKey.primary]
     * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.CryptoKey>
        getCryptoKey(com.google.cloud.kms.v1.GetCryptoKeyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCryptoKeyMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for a given
     * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.kms.v1.CryptoKeyVersion>
        getCryptoKeyVersion(com.google.cloud.kms.v1.GetCryptoKeyVersionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCryptoKeyVersionMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the public key for the given
     * [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]. The
     * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
     * [ASYMMETRIC_SIGN][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ASYMMETRIC_SIGN]
     * or
     * [ASYMMETRIC_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ASYMMETRIC_DECRYPT].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.PublicKey>
        getPublicKey(com.google.cloud.kms.v1.GetPublicKeyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetPublicKeyMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new [KeyRing][google.cloud.kms.v1.KeyRing] in a given Project and
     * Location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.KeyRing>
        createKeyRing(com.google.cloud.kms.v1.CreateKeyRingRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateKeyRingMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new [CryptoKey][google.cloud.kms.v1.CryptoKey] within a
     * [KeyRing][google.cloud.kms.v1.KeyRing].
     * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] and
     * [CryptoKey.version_template.algorithm][google.cloud.kms.v1.CryptoKeyVersionTemplate.algorithm]
     * are required.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.CryptoKey>
        createCryptoKey(com.google.cloud.kms.v1.CreateCryptoKeyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateCryptoKeyMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] in a
     * [CryptoKey][google.cloud.kms.v1.CryptoKey].
     * The server will assign the next sequential id. If unset,
     * [state][google.cloud.kms.v1.CryptoKeyVersion.state] will be set to
     * [ENABLED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.ENABLED].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.kms.v1.CryptoKeyVersion>
        createCryptoKeyVersion(com.google.cloud.kms.v1.CreateCryptoKeyVersionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateCryptoKeyVersionMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a [CryptoKey][google.cloud.kms.v1.CryptoKey].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.CryptoKey>
        updateCryptoKey(com.google.cloud.kms.v1.UpdateCryptoKeyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateCryptoKeyMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
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
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.kms.v1.CryptoKeyVersion>
        updateCryptoKeyVersion(com.google.cloud.kms.v1.UpdateCryptoKeyVersionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateCryptoKeyVersionMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Encrypts data, so that it can only be recovered by a call to
     * [Decrypt][google.cloud.kms.v1.KeyManagementService.Decrypt]. The
     * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
     * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.kms.v1.EncryptResponse>
        encrypt(com.google.cloud.kms.v1.EncryptRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getEncryptMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Decrypts data that was protected by
     * [Encrypt][google.cloud.kms.v1.KeyManagementService.Encrypt]. The
     * [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose] must be
     * [ENCRYPT_DECRYPT][google.cloud.kms.v1.CryptoKey.CryptoKeyPurpose.ENCRYPT_DECRYPT].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.kms.v1.DecryptResponse>
        decrypt(com.google.cloud.kms.v1.DecryptRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDecryptMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Signs data using a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
     * with [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose]
     * ASYMMETRIC_SIGN, producing a signature that can be verified with the public
     * key retrieved from
     * [GetPublicKey][google.cloud.kms.v1.KeyManagementService.GetPublicKey].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.kms.v1.AsymmetricSignResponse>
        asymmetricSign(com.google.cloud.kms.v1.AsymmetricSignRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAsymmetricSignMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Decrypts data that was encrypted with a public key retrieved from
     * [GetPublicKey][google.cloud.kms.v1.KeyManagementService.GetPublicKey]
     * corresponding to a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion]
     * with [CryptoKey.purpose][google.cloud.kms.v1.CryptoKey.purpose]
     * ASYMMETRIC_DECRYPT.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.kms.v1.AsymmetricDecryptResponse>
        asymmetricDecrypt(com.google.cloud.kms.v1.AsymmetricDecryptRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAsymmetricDecryptMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update the version of a [CryptoKey][google.cloud.kms.v1.CryptoKey] that
     * will be used in
     * [Encrypt][google.cloud.kms.v1.KeyManagementService.Encrypt].
     * Returns an error if called on an asymmetric key.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.CryptoKey>
        updateCryptoKeyPrimaryVersion(
            com.google.cloud.kms.v1.UpdateCryptoKeyPrimaryVersionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateCryptoKeyPrimaryVersionMethodHelper(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Schedule a [CryptoKeyVersion][google.cloud.kms.v1.CryptoKeyVersion] for
     * destruction.
     * Upon calling this method,
     * [CryptoKeyVersion.state][google.cloud.kms.v1.CryptoKeyVersion.state] will
     * be set to
     * [DESTROY_SCHEDULED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROY_SCHEDULED]
     * and [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] will
     * be set to a time 24 hours in the future, at which point the
     * [state][google.cloud.kms.v1.CryptoKeyVersion.state] will be changed to
     * [DESTROYED][google.cloud.kms.v1.CryptoKeyVersion.CryptoKeyVersionState.DESTROYED],
     * and the key material will be irrevocably destroyed.
     * Before the
     * [destroy_time][google.cloud.kms.v1.CryptoKeyVersion.destroy_time] is
     * reached,
     * [RestoreCryptoKeyVersion][google.cloud.kms.v1.KeyManagementService.RestoreCryptoKeyVersion]
     * may be called to reverse the process.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.kms.v1.CryptoKeyVersion>
        destroyCryptoKeyVersion(com.google.cloud.kms.v1.DestroyCryptoKeyVersionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDestroyCryptoKeyVersionMethodHelper(), getCallOptions()),
          request);
    }

    /**
     *
     *
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
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.kms.v1.CryptoKeyVersion>
        restoreCryptoKeyVersion(com.google.cloud.kms.v1.RestoreCryptoKeyVersionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRestoreCryptoKeyVersionMethodHelper(), getCallOptions()),
          request);
    }
  }

  private static final int METHODID_LIST_KEY_RINGS = 0;
  private static final int METHODID_LIST_CRYPTO_KEYS = 1;
  private static final int METHODID_LIST_CRYPTO_KEY_VERSIONS = 2;
  private static final int METHODID_GET_KEY_RING = 3;
  private static final int METHODID_GET_CRYPTO_KEY = 4;
  private static final int METHODID_GET_CRYPTO_KEY_VERSION = 5;
  private static final int METHODID_GET_PUBLIC_KEY = 6;
  private static final int METHODID_CREATE_KEY_RING = 7;
  private static final int METHODID_CREATE_CRYPTO_KEY = 8;
  private static final int METHODID_CREATE_CRYPTO_KEY_VERSION = 9;
  private static final int METHODID_UPDATE_CRYPTO_KEY = 10;
  private static final int METHODID_UPDATE_CRYPTO_KEY_VERSION = 11;
  private static final int METHODID_ENCRYPT = 12;
  private static final int METHODID_DECRYPT = 13;
  private static final int METHODID_ASYMMETRIC_SIGN = 14;
  private static final int METHODID_ASYMMETRIC_DECRYPT = 15;
  private static final int METHODID_UPDATE_CRYPTO_KEY_PRIMARY_VERSION = 16;
  private static final int METHODID_DESTROY_CRYPTO_KEY_VERSION = 17;
  private static final int METHODID_RESTORE_CRYPTO_KEY_VERSION = 18;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
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
          serviceImpl.listKeyRings(
              (com.google.cloud.kms.v1.ListKeyRingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ListKeyRingsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_CRYPTO_KEYS:
          serviceImpl.listCryptoKeys(
              (com.google.cloud.kms.v1.ListCryptoKeysRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ListCryptoKeysResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_CRYPTO_KEY_VERSIONS:
          serviceImpl.listCryptoKeyVersions(
              (com.google.cloud.kms.v1.ListCryptoKeyVersionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ListCryptoKeyVersionsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_KEY_RING:
          serviceImpl.getKeyRing(
              (com.google.cloud.kms.v1.GetKeyRingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.KeyRing>) responseObserver);
          break;
        case METHODID_GET_CRYPTO_KEY:
          serviceImpl.getCryptoKey(
              (com.google.cloud.kms.v1.GetCryptoKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKey>) responseObserver);
          break;
        case METHODID_GET_CRYPTO_KEY_VERSION:
          serviceImpl.getCryptoKeyVersion(
              (com.google.cloud.kms.v1.GetCryptoKeyVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKeyVersion>)
                  responseObserver);
          break;
        case METHODID_GET_PUBLIC_KEY:
          serviceImpl.getPublicKey(
              (com.google.cloud.kms.v1.GetPublicKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.PublicKey>) responseObserver);
          break;
        case METHODID_CREATE_KEY_RING:
          serviceImpl.createKeyRing(
              (com.google.cloud.kms.v1.CreateKeyRingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.KeyRing>) responseObserver);
          break;
        case METHODID_CREATE_CRYPTO_KEY:
          serviceImpl.createCryptoKey(
              (com.google.cloud.kms.v1.CreateCryptoKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKey>) responseObserver);
          break;
        case METHODID_CREATE_CRYPTO_KEY_VERSION:
          serviceImpl.createCryptoKeyVersion(
              (com.google.cloud.kms.v1.CreateCryptoKeyVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKeyVersion>)
                  responseObserver);
          break;
        case METHODID_UPDATE_CRYPTO_KEY:
          serviceImpl.updateCryptoKey(
              (com.google.cloud.kms.v1.UpdateCryptoKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKey>) responseObserver);
          break;
        case METHODID_UPDATE_CRYPTO_KEY_VERSION:
          serviceImpl.updateCryptoKeyVersion(
              (com.google.cloud.kms.v1.UpdateCryptoKeyVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKeyVersion>)
                  responseObserver);
          break;
        case METHODID_ENCRYPT:
          serviceImpl.encrypt(
              (com.google.cloud.kms.v1.EncryptRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.EncryptResponse>)
                  responseObserver);
          break;
        case METHODID_DECRYPT:
          serviceImpl.decrypt(
              (com.google.cloud.kms.v1.DecryptRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.DecryptResponse>)
                  responseObserver);
          break;
        case METHODID_ASYMMETRIC_SIGN:
          serviceImpl.asymmetricSign(
              (com.google.cloud.kms.v1.AsymmetricSignRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.AsymmetricSignResponse>)
                  responseObserver);
          break;
        case METHODID_ASYMMETRIC_DECRYPT:
          serviceImpl.asymmetricDecrypt(
              (com.google.cloud.kms.v1.AsymmetricDecryptRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.AsymmetricDecryptResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_CRYPTO_KEY_PRIMARY_VERSION:
          serviceImpl.updateCryptoKeyPrimaryVersion(
              (com.google.cloud.kms.v1.UpdateCryptoKeyPrimaryVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKey>) responseObserver);
          break;
        case METHODID_DESTROY_CRYPTO_KEY_VERSION:
          serviceImpl.destroyCryptoKeyVersion(
              (com.google.cloud.kms.v1.DestroyCryptoKeyVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKeyVersion>)
                  responseObserver);
          break;
        case METHODID_RESTORE_CRYPTO_KEY_VERSION:
          serviceImpl.restoreCryptoKeyVersion(
              (com.google.cloud.kms.v1.RestoreCryptoKeyVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.CryptoKeyVersion>)
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

  private abstract static class KeyManagementServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
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
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new KeyManagementServiceFileDescriptorSupplier())
                      .addMethod(getListKeyRingsMethodHelper())
                      .addMethod(getListCryptoKeysMethodHelper())
                      .addMethod(getListCryptoKeyVersionsMethodHelper())
                      .addMethod(getGetKeyRingMethodHelper())
                      .addMethod(getGetCryptoKeyMethodHelper())
                      .addMethod(getGetCryptoKeyVersionMethodHelper())
                      .addMethod(getGetPublicKeyMethodHelper())
                      .addMethod(getCreateKeyRingMethodHelper())
                      .addMethod(getCreateCryptoKeyMethodHelper())
                      .addMethod(getCreateCryptoKeyVersionMethodHelper())
                      .addMethod(getUpdateCryptoKeyMethodHelper())
                      .addMethod(getUpdateCryptoKeyVersionMethodHelper())
                      .addMethod(getEncryptMethodHelper())
                      .addMethod(getDecryptMethodHelper())
                      .addMethod(getAsymmetricSignMethodHelper())
                      .addMethod(getAsymmetricDecryptMethodHelper())
                      .addMethod(getUpdateCryptoKeyPrimaryVersionMethodHelper())
                      .addMethod(getDestroyCryptoKeyVersionMethodHelper())
                      .addMethod(getRestoreCryptoKeyVersionMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
