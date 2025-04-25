/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.certificatemanager.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * API Overview
 * Certificates Manager API allows customers to see and manage all their TLS
 * certificates.
 * Certificates Manager API service provides methods to manage certificates,
 * group them into collections, and create serving configuration that can be
 * easily applied to other Cloud resources e.g. Target Proxies.
 * Data Model
 * The Certificates Manager service exposes the following resources:
 * * `Certificate` that describes a single TLS certificate.
 * * `CertificateMap` that describes a collection of certificates that can be
 * attached to a target resource.
 * * `CertificateMapEntry` that describes a single configuration entry that
 * consists of a SNI and a group of certificates. It's a subresource of
 * CertificateMap.
 * Certificate, CertificateMap and CertificateMapEntry IDs
 * have to fully match the regexp `[a-z0-9-]{1,63}`. In other words,
 * - only lower case letters, digits, and hyphen are allowed
 * - length of the resource ID has to be in [1,63] range.
 * Provides methods to manage Cloud Certificate Manager entities.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/certificatemanager/v1/certificate_manager.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CertificateManagerGrpc {

  private CertificateManagerGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.certificatemanager.v1.CertificateManager";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.ListCertificatesRequest,
          com.google.cloud.certificatemanager.v1.ListCertificatesResponse>
      getListCertificatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCertificates",
      requestType = com.google.cloud.certificatemanager.v1.ListCertificatesRequest.class,
      responseType = com.google.cloud.certificatemanager.v1.ListCertificatesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.ListCertificatesRequest,
          com.google.cloud.certificatemanager.v1.ListCertificatesResponse>
      getListCertificatesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.certificatemanager.v1.ListCertificatesRequest,
            com.google.cloud.certificatemanager.v1.ListCertificatesResponse>
        getListCertificatesMethod;
    if ((getListCertificatesMethod = CertificateManagerGrpc.getListCertificatesMethod) == null) {
      synchronized (CertificateManagerGrpc.class) {
        if ((getListCertificatesMethod = CertificateManagerGrpc.getListCertificatesMethod)
            == null) {
          CertificateManagerGrpc.getListCertificatesMethod =
              getListCertificatesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.certificatemanager.v1.ListCertificatesRequest,
                          com.google.cloud.certificatemanager.v1.ListCertificatesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCertificates"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1.ListCertificatesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1.ListCertificatesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateManagerMethodDescriptorSupplier("ListCertificates"))
                      .build();
        }
      }
    }
    return getListCertificatesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.GetCertificateRequest,
          com.google.cloud.certificatemanager.v1.Certificate>
      getGetCertificateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCertificate",
      requestType = com.google.cloud.certificatemanager.v1.GetCertificateRequest.class,
      responseType = com.google.cloud.certificatemanager.v1.Certificate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.GetCertificateRequest,
          com.google.cloud.certificatemanager.v1.Certificate>
      getGetCertificateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.certificatemanager.v1.GetCertificateRequest,
            com.google.cloud.certificatemanager.v1.Certificate>
        getGetCertificateMethod;
    if ((getGetCertificateMethod = CertificateManagerGrpc.getGetCertificateMethod) == null) {
      synchronized (CertificateManagerGrpc.class) {
        if ((getGetCertificateMethod = CertificateManagerGrpc.getGetCertificateMethod) == null) {
          CertificateManagerGrpc.getGetCertificateMethod =
              getGetCertificateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.certificatemanager.v1.GetCertificateRequest,
                          com.google.cloud.certificatemanager.v1.Certificate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCertificate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1.GetCertificateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1.Certificate
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateManagerMethodDescriptorSupplier("GetCertificate"))
                      .build();
        }
      }
    }
    return getGetCertificateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.CreateCertificateRequest,
          com.google.longrunning.Operation>
      getCreateCertificateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCertificate",
      requestType = com.google.cloud.certificatemanager.v1.CreateCertificateRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.CreateCertificateRequest,
          com.google.longrunning.Operation>
      getCreateCertificateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.certificatemanager.v1.CreateCertificateRequest,
            com.google.longrunning.Operation>
        getCreateCertificateMethod;
    if ((getCreateCertificateMethod = CertificateManagerGrpc.getCreateCertificateMethod) == null) {
      synchronized (CertificateManagerGrpc.class) {
        if ((getCreateCertificateMethod = CertificateManagerGrpc.getCreateCertificateMethod)
            == null) {
          CertificateManagerGrpc.getCreateCertificateMethod =
              getCreateCertificateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.certificatemanager.v1.CreateCertificateRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCertificate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1.CreateCertificateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateManagerMethodDescriptorSupplier("CreateCertificate"))
                      .build();
        }
      }
    }
    return getCreateCertificateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.UpdateCertificateRequest,
          com.google.longrunning.Operation>
      getUpdateCertificateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCertificate",
      requestType = com.google.cloud.certificatemanager.v1.UpdateCertificateRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.UpdateCertificateRequest,
          com.google.longrunning.Operation>
      getUpdateCertificateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.certificatemanager.v1.UpdateCertificateRequest,
            com.google.longrunning.Operation>
        getUpdateCertificateMethod;
    if ((getUpdateCertificateMethod = CertificateManagerGrpc.getUpdateCertificateMethod) == null) {
      synchronized (CertificateManagerGrpc.class) {
        if ((getUpdateCertificateMethod = CertificateManagerGrpc.getUpdateCertificateMethod)
            == null) {
          CertificateManagerGrpc.getUpdateCertificateMethod =
              getUpdateCertificateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.certificatemanager.v1.UpdateCertificateRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCertificate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1.UpdateCertificateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateManagerMethodDescriptorSupplier("UpdateCertificate"))
                      .build();
        }
      }
    }
    return getUpdateCertificateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.DeleteCertificateRequest,
          com.google.longrunning.Operation>
      getDeleteCertificateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCertificate",
      requestType = com.google.cloud.certificatemanager.v1.DeleteCertificateRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.DeleteCertificateRequest,
          com.google.longrunning.Operation>
      getDeleteCertificateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.certificatemanager.v1.DeleteCertificateRequest,
            com.google.longrunning.Operation>
        getDeleteCertificateMethod;
    if ((getDeleteCertificateMethod = CertificateManagerGrpc.getDeleteCertificateMethod) == null) {
      synchronized (CertificateManagerGrpc.class) {
        if ((getDeleteCertificateMethod = CertificateManagerGrpc.getDeleteCertificateMethod)
            == null) {
          CertificateManagerGrpc.getDeleteCertificateMethod =
              getDeleteCertificateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.certificatemanager.v1.DeleteCertificateRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCertificate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1.DeleteCertificateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateManagerMethodDescriptorSupplier("DeleteCertificate"))
                      .build();
        }
      }
    }
    return getDeleteCertificateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.ListCertificateMapsRequest,
          com.google.cloud.certificatemanager.v1.ListCertificateMapsResponse>
      getListCertificateMapsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCertificateMaps",
      requestType = com.google.cloud.certificatemanager.v1.ListCertificateMapsRequest.class,
      responseType = com.google.cloud.certificatemanager.v1.ListCertificateMapsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.ListCertificateMapsRequest,
          com.google.cloud.certificatemanager.v1.ListCertificateMapsResponse>
      getListCertificateMapsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.certificatemanager.v1.ListCertificateMapsRequest,
            com.google.cloud.certificatemanager.v1.ListCertificateMapsResponse>
        getListCertificateMapsMethod;
    if ((getListCertificateMapsMethod = CertificateManagerGrpc.getListCertificateMapsMethod)
        == null) {
      synchronized (CertificateManagerGrpc.class) {
        if ((getListCertificateMapsMethod = CertificateManagerGrpc.getListCertificateMapsMethod)
            == null) {
          CertificateManagerGrpc.getListCertificateMapsMethod =
              getListCertificateMapsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.certificatemanager.v1.ListCertificateMapsRequest,
                          com.google.cloud.certificatemanager.v1.ListCertificateMapsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListCertificateMaps"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1.ListCertificateMapsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1.ListCertificateMapsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateManagerMethodDescriptorSupplier("ListCertificateMaps"))
                      .build();
        }
      }
    }
    return getListCertificateMapsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.GetCertificateMapRequest,
          com.google.cloud.certificatemanager.v1.CertificateMap>
      getGetCertificateMapMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCertificateMap",
      requestType = com.google.cloud.certificatemanager.v1.GetCertificateMapRequest.class,
      responseType = com.google.cloud.certificatemanager.v1.CertificateMap.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.GetCertificateMapRequest,
          com.google.cloud.certificatemanager.v1.CertificateMap>
      getGetCertificateMapMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.certificatemanager.v1.GetCertificateMapRequest,
            com.google.cloud.certificatemanager.v1.CertificateMap>
        getGetCertificateMapMethod;
    if ((getGetCertificateMapMethod = CertificateManagerGrpc.getGetCertificateMapMethod) == null) {
      synchronized (CertificateManagerGrpc.class) {
        if ((getGetCertificateMapMethod = CertificateManagerGrpc.getGetCertificateMapMethod)
            == null) {
          CertificateManagerGrpc.getGetCertificateMapMethod =
              getGetCertificateMapMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.certificatemanager.v1.GetCertificateMapRequest,
                          com.google.cloud.certificatemanager.v1.CertificateMap>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCertificateMap"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1.GetCertificateMapRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1.CertificateMap
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateManagerMethodDescriptorSupplier("GetCertificateMap"))
                      .build();
        }
      }
    }
    return getGetCertificateMapMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.CreateCertificateMapRequest,
          com.google.longrunning.Operation>
      getCreateCertificateMapMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCertificateMap",
      requestType = com.google.cloud.certificatemanager.v1.CreateCertificateMapRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.CreateCertificateMapRequest,
          com.google.longrunning.Operation>
      getCreateCertificateMapMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.certificatemanager.v1.CreateCertificateMapRequest,
            com.google.longrunning.Operation>
        getCreateCertificateMapMethod;
    if ((getCreateCertificateMapMethod = CertificateManagerGrpc.getCreateCertificateMapMethod)
        == null) {
      synchronized (CertificateManagerGrpc.class) {
        if ((getCreateCertificateMapMethod = CertificateManagerGrpc.getCreateCertificateMapMethod)
            == null) {
          CertificateManagerGrpc.getCreateCertificateMapMethod =
              getCreateCertificateMapMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.certificatemanager.v1.CreateCertificateMapRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateCertificateMap"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1.CreateCertificateMapRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateManagerMethodDescriptorSupplier("CreateCertificateMap"))
                      .build();
        }
      }
    }
    return getCreateCertificateMapMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.UpdateCertificateMapRequest,
          com.google.longrunning.Operation>
      getUpdateCertificateMapMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCertificateMap",
      requestType = com.google.cloud.certificatemanager.v1.UpdateCertificateMapRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.UpdateCertificateMapRequest,
          com.google.longrunning.Operation>
      getUpdateCertificateMapMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.certificatemanager.v1.UpdateCertificateMapRequest,
            com.google.longrunning.Operation>
        getUpdateCertificateMapMethod;
    if ((getUpdateCertificateMapMethod = CertificateManagerGrpc.getUpdateCertificateMapMethod)
        == null) {
      synchronized (CertificateManagerGrpc.class) {
        if ((getUpdateCertificateMapMethod = CertificateManagerGrpc.getUpdateCertificateMapMethod)
            == null) {
          CertificateManagerGrpc.getUpdateCertificateMapMethod =
              getUpdateCertificateMapMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.certificatemanager.v1.UpdateCertificateMapRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateCertificateMap"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1.UpdateCertificateMapRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateManagerMethodDescriptorSupplier("UpdateCertificateMap"))
                      .build();
        }
      }
    }
    return getUpdateCertificateMapMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.DeleteCertificateMapRequest,
          com.google.longrunning.Operation>
      getDeleteCertificateMapMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCertificateMap",
      requestType = com.google.cloud.certificatemanager.v1.DeleteCertificateMapRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.DeleteCertificateMapRequest,
          com.google.longrunning.Operation>
      getDeleteCertificateMapMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.certificatemanager.v1.DeleteCertificateMapRequest,
            com.google.longrunning.Operation>
        getDeleteCertificateMapMethod;
    if ((getDeleteCertificateMapMethod = CertificateManagerGrpc.getDeleteCertificateMapMethod)
        == null) {
      synchronized (CertificateManagerGrpc.class) {
        if ((getDeleteCertificateMapMethod = CertificateManagerGrpc.getDeleteCertificateMapMethod)
            == null) {
          CertificateManagerGrpc.getDeleteCertificateMapMethod =
              getDeleteCertificateMapMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.certificatemanager.v1.DeleteCertificateMapRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteCertificateMap"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1.DeleteCertificateMapRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateManagerMethodDescriptorSupplier("DeleteCertificateMap"))
                      .build();
        }
      }
    }
    return getDeleteCertificateMapMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.ListCertificateMapEntriesRequest,
          com.google.cloud.certificatemanager.v1.ListCertificateMapEntriesResponse>
      getListCertificateMapEntriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCertificateMapEntries",
      requestType = com.google.cloud.certificatemanager.v1.ListCertificateMapEntriesRequest.class,
      responseType = com.google.cloud.certificatemanager.v1.ListCertificateMapEntriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.ListCertificateMapEntriesRequest,
          com.google.cloud.certificatemanager.v1.ListCertificateMapEntriesResponse>
      getListCertificateMapEntriesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.certificatemanager.v1.ListCertificateMapEntriesRequest,
            com.google.cloud.certificatemanager.v1.ListCertificateMapEntriesResponse>
        getListCertificateMapEntriesMethod;
    if ((getListCertificateMapEntriesMethod =
            CertificateManagerGrpc.getListCertificateMapEntriesMethod)
        == null) {
      synchronized (CertificateManagerGrpc.class) {
        if ((getListCertificateMapEntriesMethod =
                CertificateManagerGrpc.getListCertificateMapEntriesMethod)
            == null) {
          CertificateManagerGrpc.getListCertificateMapEntriesMethod =
              getListCertificateMapEntriesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.certificatemanager.v1.ListCertificateMapEntriesRequest,
                          com.google.cloud.certificatemanager.v1.ListCertificateMapEntriesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListCertificateMapEntries"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1
                                  .ListCertificateMapEntriesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1
                                  .ListCertificateMapEntriesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateManagerMethodDescriptorSupplier(
                              "ListCertificateMapEntries"))
                      .build();
        }
      }
    }
    return getListCertificateMapEntriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.GetCertificateMapEntryRequest,
          com.google.cloud.certificatemanager.v1.CertificateMapEntry>
      getGetCertificateMapEntryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCertificateMapEntry",
      requestType = com.google.cloud.certificatemanager.v1.GetCertificateMapEntryRequest.class,
      responseType = com.google.cloud.certificatemanager.v1.CertificateMapEntry.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.GetCertificateMapEntryRequest,
          com.google.cloud.certificatemanager.v1.CertificateMapEntry>
      getGetCertificateMapEntryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.certificatemanager.v1.GetCertificateMapEntryRequest,
            com.google.cloud.certificatemanager.v1.CertificateMapEntry>
        getGetCertificateMapEntryMethod;
    if ((getGetCertificateMapEntryMethod = CertificateManagerGrpc.getGetCertificateMapEntryMethod)
        == null) {
      synchronized (CertificateManagerGrpc.class) {
        if ((getGetCertificateMapEntryMethod =
                CertificateManagerGrpc.getGetCertificateMapEntryMethod)
            == null) {
          CertificateManagerGrpc.getGetCertificateMapEntryMethod =
              getGetCertificateMapEntryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.certificatemanager.v1.GetCertificateMapEntryRequest,
                          com.google.cloud.certificatemanager.v1.CertificateMapEntry>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetCertificateMapEntry"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1.GetCertificateMapEntryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1.CertificateMapEntry
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateManagerMethodDescriptorSupplier("GetCertificateMapEntry"))
                      .build();
        }
      }
    }
    return getGetCertificateMapEntryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.CreateCertificateMapEntryRequest,
          com.google.longrunning.Operation>
      getCreateCertificateMapEntryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCertificateMapEntry",
      requestType = com.google.cloud.certificatemanager.v1.CreateCertificateMapEntryRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.CreateCertificateMapEntryRequest,
          com.google.longrunning.Operation>
      getCreateCertificateMapEntryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.certificatemanager.v1.CreateCertificateMapEntryRequest,
            com.google.longrunning.Operation>
        getCreateCertificateMapEntryMethod;
    if ((getCreateCertificateMapEntryMethod =
            CertificateManagerGrpc.getCreateCertificateMapEntryMethod)
        == null) {
      synchronized (CertificateManagerGrpc.class) {
        if ((getCreateCertificateMapEntryMethod =
                CertificateManagerGrpc.getCreateCertificateMapEntryMethod)
            == null) {
          CertificateManagerGrpc.getCreateCertificateMapEntryMethod =
              getCreateCertificateMapEntryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.certificatemanager.v1.CreateCertificateMapEntryRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateCertificateMapEntry"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1
                                  .CreateCertificateMapEntryRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateManagerMethodDescriptorSupplier(
                              "CreateCertificateMapEntry"))
                      .build();
        }
      }
    }
    return getCreateCertificateMapEntryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.UpdateCertificateMapEntryRequest,
          com.google.longrunning.Operation>
      getUpdateCertificateMapEntryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCertificateMapEntry",
      requestType = com.google.cloud.certificatemanager.v1.UpdateCertificateMapEntryRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.UpdateCertificateMapEntryRequest,
          com.google.longrunning.Operation>
      getUpdateCertificateMapEntryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.certificatemanager.v1.UpdateCertificateMapEntryRequest,
            com.google.longrunning.Operation>
        getUpdateCertificateMapEntryMethod;
    if ((getUpdateCertificateMapEntryMethod =
            CertificateManagerGrpc.getUpdateCertificateMapEntryMethod)
        == null) {
      synchronized (CertificateManagerGrpc.class) {
        if ((getUpdateCertificateMapEntryMethod =
                CertificateManagerGrpc.getUpdateCertificateMapEntryMethod)
            == null) {
          CertificateManagerGrpc.getUpdateCertificateMapEntryMethod =
              getUpdateCertificateMapEntryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.certificatemanager.v1.UpdateCertificateMapEntryRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateCertificateMapEntry"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1
                                  .UpdateCertificateMapEntryRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateManagerMethodDescriptorSupplier(
                              "UpdateCertificateMapEntry"))
                      .build();
        }
      }
    }
    return getUpdateCertificateMapEntryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.DeleteCertificateMapEntryRequest,
          com.google.longrunning.Operation>
      getDeleteCertificateMapEntryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCertificateMapEntry",
      requestType = com.google.cloud.certificatemanager.v1.DeleteCertificateMapEntryRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.DeleteCertificateMapEntryRequest,
          com.google.longrunning.Operation>
      getDeleteCertificateMapEntryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.certificatemanager.v1.DeleteCertificateMapEntryRequest,
            com.google.longrunning.Operation>
        getDeleteCertificateMapEntryMethod;
    if ((getDeleteCertificateMapEntryMethod =
            CertificateManagerGrpc.getDeleteCertificateMapEntryMethod)
        == null) {
      synchronized (CertificateManagerGrpc.class) {
        if ((getDeleteCertificateMapEntryMethod =
                CertificateManagerGrpc.getDeleteCertificateMapEntryMethod)
            == null) {
          CertificateManagerGrpc.getDeleteCertificateMapEntryMethod =
              getDeleteCertificateMapEntryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.certificatemanager.v1.DeleteCertificateMapEntryRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteCertificateMapEntry"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1
                                  .DeleteCertificateMapEntryRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateManagerMethodDescriptorSupplier(
                              "DeleteCertificateMapEntry"))
                      .build();
        }
      }
    }
    return getDeleteCertificateMapEntryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.ListDnsAuthorizationsRequest,
          com.google.cloud.certificatemanager.v1.ListDnsAuthorizationsResponse>
      getListDnsAuthorizationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDnsAuthorizations",
      requestType = com.google.cloud.certificatemanager.v1.ListDnsAuthorizationsRequest.class,
      responseType = com.google.cloud.certificatemanager.v1.ListDnsAuthorizationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.ListDnsAuthorizationsRequest,
          com.google.cloud.certificatemanager.v1.ListDnsAuthorizationsResponse>
      getListDnsAuthorizationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.certificatemanager.v1.ListDnsAuthorizationsRequest,
            com.google.cloud.certificatemanager.v1.ListDnsAuthorizationsResponse>
        getListDnsAuthorizationsMethod;
    if ((getListDnsAuthorizationsMethod = CertificateManagerGrpc.getListDnsAuthorizationsMethod)
        == null) {
      synchronized (CertificateManagerGrpc.class) {
        if ((getListDnsAuthorizationsMethod = CertificateManagerGrpc.getListDnsAuthorizationsMethod)
            == null) {
          CertificateManagerGrpc.getListDnsAuthorizationsMethod =
              getListDnsAuthorizationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.certificatemanager.v1.ListDnsAuthorizationsRequest,
                          com.google.cloud.certificatemanager.v1.ListDnsAuthorizationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListDnsAuthorizations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1.ListDnsAuthorizationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1.ListDnsAuthorizationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateManagerMethodDescriptorSupplier("ListDnsAuthorizations"))
                      .build();
        }
      }
    }
    return getListDnsAuthorizationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.GetDnsAuthorizationRequest,
          com.google.cloud.certificatemanager.v1.DnsAuthorization>
      getGetDnsAuthorizationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDnsAuthorization",
      requestType = com.google.cloud.certificatemanager.v1.GetDnsAuthorizationRequest.class,
      responseType = com.google.cloud.certificatemanager.v1.DnsAuthorization.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.GetDnsAuthorizationRequest,
          com.google.cloud.certificatemanager.v1.DnsAuthorization>
      getGetDnsAuthorizationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.certificatemanager.v1.GetDnsAuthorizationRequest,
            com.google.cloud.certificatemanager.v1.DnsAuthorization>
        getGetDnsAuthorizationMethod;
    if ((getGetDnsAuthorizationMethod = CertificateManagerGrpc.getGetDnsAuthorizationMethod)
        == null) {
      synchronized (CertificateManagerGrpc.class) {
        if ((getGetDnsAuthorizationMethod = CertificateManagerGrpc.getGetDnsAuthorizationMethod)
            == null) {
          CertificateManagerGrpc.getGetDnsAuthorizationMethod =
              getGetDnsAuthorizationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.certificatemanager.v1.GetDnsAuthorizationRequest,
                          com.google.cloud.certificatemanager.v1.DnsAuthorization>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetDnsAuthorization"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1.GetDnsAuthorizationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1.DnsAuthorization
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateManagerMethodDescriptorSupplier("GetDnsAuthorization"))
                      .build();
        }
      }
    }
    return getGetDnsAuthorizationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.CreateDnsAuthorizationRequest,
          com.google.longrunning.Operation>
      getCreateDnsAuthorizationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDnsAuthorization",
      requestType = com.google.cloud.certificatemanager.v1.CreateDnsAuthorizationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.CreateDnsAuthorizationRequest,
          com.google.longrunning.Operation>
      getCreateDnsAuthorizationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.certificatemanager.v1.CreateDnsAuthorizationRequest,
            com.google.longrunning.Operation>
        getCreateDnsAuthorizationMethod;
    if ((getCreateDnsAuthorizationMethod = CertificateManagerGrpc.getCreateDnsAuthorizationMethod)
        == null) {
      synchronized (CertificateManagerGrpc.class) {
        if ((getCreateDnsAuthorizationMethod =
                CertificateManagerGrpc.getCreateDnsAuthorizationMethod)
            == null) {
          CertificateManagerGrpc.getCreateDnsAuthorizationMethod =
              getCreateDnsAuthorizationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.certificatemanager.v1.CreateDnsAuthorizationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateDnsAuthorization"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1.CreateDnsAuthorizationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateManagerMethodDescriptorSupplier("CreateDnsAuthorization"))
                      .build();
        }
      }
    }
    return getCreateDnsAuthorizationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.UpdateDnsAuthorizationRequest,
          com.google.longrunning.Operation>
      getUpdateDnsAuthorizationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDnsAuthorization",
      requestType = com.google.cloud.certificatemanager.v1.UpdateDnsAuthorizationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.UpdateDnsAuthorizationRequest,
          com.google.longrunning.Operation>
      getUpdateDnsAuthorizationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.certificatemanager.v1.UpdateDnsAuthorizationRequest,
            com.google.longrunning.Operation>
        getUpdateDnsAuthorizationMethod;
    if ((getUpdateDnsAuthorizationMethod = CertificateManagerGrpc.getUpdateDnsAuthorizationMethod)
        == null) {
      synchronized (CertificateManagerGrpc.class) {
        if ((getUpdateDnsAuthorizationMethod =
                CertificateManagerGrpc.getUpdateDnsAuthorizationMethod)
            == null) {
          CertificateManagerGrpc.getUpdateDnsAuthorizationMethod =
              getUpdateDnsAuthorizationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.certificatemanager.v1.UpdateDnsAuthorizationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateDnsAuthorization"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1.UpdateDnsAuthorizationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateManagerMethodDescriptorSupplier("UpdateDnsAuthorization"))
                      .build();
        }
      }
    }
    return getUpdateDnsAuthorizationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.DeleteDnsAuthorizationRequest,
          com.google.longrunning.Operation>
      getDeleteDnsAuthorizationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDnsAuthorization",
      requestType = com.google.cloud.certificatemanager.v1.DeleteDnsAuthorizationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.DeleteDnsAuthorizationRequest,
          com.google.longrunning.Operation>
      getDeleteDnsAuthorizationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.certificatemanager.v1.DeleteDnsAuthorizationRequest,
            com.google.longrunning.Operation>
        getDeleteDnsAuthorizationMethod;
    if ((getDeleteDnsAuthorizationMethod = CertificateManagerGrpc.getDeleteDnsAuthorizationMethod)
        == null) {
      synchronized (CertificateManagerGrpc.class) {
        if ((getDeleteDnsAuthorizationMethod =
                CertificateManagerGrpc.getDeleteDnsAuthorizationMethod)
            == null) {
          CertificateManagerGrpc.getDeleteDnsAuthorizationMethod =
              getDeleteDnsAuthorizationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.certificatemanager.v1.DeleteDnsAuthorizationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteDnsAuthorization"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1.DeleteDnsAuthorizationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateManagerMethodDescriptorSupplier("DeleteDnsAuthorization"))
                      .build();
        }
      }
    }
    return getDeleteDnsAuthorizationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.ListCertificateIssuanceConfigsRequest,
          com.google.cloud.certificatemanager.v1.ListCertificateIssuanceConfigsResponse>
      getListCertificateIssuanceConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCertificateIssuanceConfigs",
      requestType =
          com.google.cloud.certificatemanager.v1.ListCertificateIssuanceConfigsRequest.class,
      responseType =
          com.google.cloud.certificatemanager.v1.ListCertificateIssuanceConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.ListCertificateIssuanceConfigsRequest,
          com.google.cloud.certificatemanager.v1.ListCertificateIssuanceConfigsResponse>
      getListCertificateIssuanceConfigsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.certificatemanager.v1.ListCertificateIssuanceConfigsRequest,
            com.google.cloud.certificatemanager.v1.ListCertificateIssuanceConfigsResponse>
        getListCertificateIssuanceConfigsMethod;
    if ((getListCertificateIssuanceConfigsMethod =
            CertificateManagerGrpc.getListCertificateIssuanceConfigsMethod)
        == null) {
      synchronized (CertificateManagerGrpc.class) {
        if ((getListCertificateIssuanceConfigsMethod =
                CertificateManagerGrpc.getListCertificateIssuanceConfigsMethod)
            == null) {
          CertificateManagerGrpc.getListCertificateIssuanceConfigsMethod =
              getListCertificateIssuanceConfigsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.certificatemanager.v1
                              .ListCertificateIssuanceConfigsRequest,
                          com.google.cloud.certificatemanager.v1
                              .ListCertificateIssuanceConfigsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListCertificateIssuanceConfigs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1
                                  .ListCertificateIssuanceConfigsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1
                                  .ListCertificateIssuanceConfigsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateManagerMethodDescriptorSupplier(
                              "ListCertificateIssuanceConfigs"))
                      .build();
        }
      }
    }
    return getListCertificateIssuanceConfigsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.GetCertificateIssuanceConfigRequest,
          com.google.cloud.certificatemanager.v1.CertificateIssuanceConfig>
      getGetCertificateIssuanceConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCertificateIssuanceConfig",
      requestType =
          com.google.cloud.certificatemanager.v1.GetCertificateIssuanceConfigRequest.class,
      responseType = com.google.cloud.certificatemanager.v1.CertificateIssuanceConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.GetCertificateIssuanceConfigRequest,
          com.google.cloud.certificatemanager.v1.CertificateIssuanceConfig>
      getGetCertificateIssuanceConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.certificatemanager.v1.GetCertificateIssuanceConfigRequest,
            com.google.cloud.certificatemanager.v1.CertificateIssuanceConfig>
        getGetCertificateIssuanceConfigMethod;
    if ((getGetCertificateIssuanceConfigMethod =
            CertificateManagerGrpc.getGetCertificateIssuanceConfigMethod)
        == null) {
      synchronized (CertificateManagerGrpc.class) {
        if ((getGetCertificateIssuanceConfigMethod =
                CertificateManagerGrpc.getGetCertificateIssuanceConfigMethod)
            == null) {
          CertificateManagerGrpc.getGetCertificateIssuanceConfigMethod =
              getGetCertificateIssuanceConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.certificatemanager.v1.GetCertificateIssuanceConfigRequest,
                          com.google.cloud.certificatemanager.v1.CertificateIssuanceConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetCertificateIssuanceConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1
                                  .GetCertificateIssuanceConfigRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1.CertificateIssuanceConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateManagerMethodDescriptorSupplier(
                              "GetCertificateIssuanceConfig"))
                      .build();
        }
      }
    }
    return getGetCertificateIssuanceConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.CreateCertificateIssuanceConfigRequest,
          com.google.longrunning.Operation>
      getCreateCertificateIssuanceConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCertificateIssuanceConfig",
      requestType =
          com.google.cloud.certificatemanager.v1.CreateCertificateIssuanceConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.CreateCertificateIssuanceConfigRequest,
          com.google.longrunning.Operation>
      getCreateCertificateIssuanceConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.certificatemanager.v1.CreateCertificateIssuanceConfigRequest,
            com.google.longrunning.Operation>
        getCreateCertificateIssuanceConfigMethod;
    if ((getCreateCertificateIssuanceConfigMethod =
            CertificateManagerGrpc.getCreateCertificateIssuanceConfigMethod)
        == null) {
      synchronized (CertificateManagerGrpc.class) {
        if ((getCreateCertificateIssuanceConfigMethod =
                CertificateManagerGrpc.getCreateCertificateIssuanceConfigMethod)
            == null) {
          CertificateManagerGrpc.getCreateCertificateIssuanceConfigMethod =
              getCreateCertificateIssuanceConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.certificatemanager.v1
                              .CreateCertificateIssuanceConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateCertificateIssuanceConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1
                                  .CreateCertificateIssuanceConfigRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateManagerMethodDescriptorSupplier(
                              "CreateCertificateIssuanceConfig"))
                      .build();
        }
      }
    }
    return getCreateCertificateIssuanceConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.DeleteCertificateIssuanceConfigRequest,
          com.google.longrunning.Operation>
      getDeleteCertificateIssuanceConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCertificateIssuanceConfig",
      requestType =
          com.google.cloud.certificatemanager.v1.DeleteCertificateIssuanceConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.DeleteCertificateIssuanceConfigRequest,
          com.google.longrunning.Operation>
      getDeleteCertificateIssuanceConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.certificatemanager.v1.DeleteCertificateIssuanceConfigRequest,
            com.google.longrunning.Operation>
        getDeleteCertificateIssuanceConfigMethod;
    if ((getDeleteCertificateIssuanceConfigMethod =
            CertificateManagerGrpc.getDeleteCertificateIssuanceConfigMethod)
        == null) {
      synchronized (CertificateManagerGrpc.class) {
        if ((getDeleteCertificateIssuanceConfigMethod =
                CertificateManagerGrpc.getDeleteCertificateIssuanceConfigMethod)
            == null) {
          CertificateManagerGrpc.getDeleteCertificateIssuanceConfigMethod =
              getDeleteCertificateIssuanceConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.certificatemanager.v1
                              .DeleteCertificateIssuanceConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteCertificateIssuanceConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1
                                  .DeleteCertificateIssuanceConfigRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateManagerMethodDescriptorSupplier(
                              "DeleteCertificateIssuanceConfig"))
                      .build();
        }
      }
    }
    return getDeleteCertificateIssuanceConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.ListTrustConfigsRequest,
          com.google.cloud.certificatemanager.v1.ListTrustConfigsResponse>
      getListTrustConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTrustConfigs",
      requestType = com.google.cloud.certificatemanager.v1.ListTrustConfigsRequest.class,
      responseType = com.google.cloud.certificatemanager.v1.ListTrustConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.ListTrustConfigsRequest,
          com.google.cloud.certificatemanager.v1.ListTrustConfigsResponse>
      getListTrustConfigsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.certificatemanager.v1.ListTrustConfigsRequest,
            com.google.cloud.certificatemanager.v1.ListTrustConfigsResponse>
        getListTrustConfigsMethod;
    if ((getListTrustConfigsMethod = CertificateManagerGrpc.getListTrustConfigsMethod) == null) {
      synchronized (CertificateManagerGrpc.class) {
        if ((getListTrustConfigsMethod = CertificateManagerGrpc.getListTrustConfigsMethod)
            == null) {
          CertificateManagerGrpc.getListTrustConfigsMethod =
              getListTrustConfigsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.certificatemanager.v1.ListTrustConfigsRequest,
                          com.google.cloud.certificatemanager.v1.ListTrustConfigsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTrustConfigs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1.ListTrustConfigsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1.ListTrustConfigsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateManagerMethodDescriptorSupplier("ListTrustConfigs"))
                      .build();
        }
      }
    }
    return getListTrustConfigsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.GetTrustConfigRequest,
          com.google.cloud.certificatemanager.v1.TrustConfig>
      getGetTrustConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTrustConfig",
      requestType = com.google.cloud.certificatemanager.v1.GetTrustConfigRequest.class,
      responseType = com.google.cloud.certificatemanager.v1.TrustConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.GetTrustConfigRequest,
          com.google.cloud.certificatemanager.v1.TrustConfig>
      getGetTrustConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.certificatemanager.v1.GetTrustConfigRequest,
            com.google.cloud.certificatemanager.v1.TrustConfig>
        getGetTrustConfigMethod;
    if ((getGetTrustConfigMethod = CertificateManagerGrpc.getGetTrustConfigMethod) == null) {
      synchronized (CertificateManagerGrpc.class) {
        if ((getGetTrustConfigMethod = CertificateManagerGrpc.getGetTrustConfigMethod) == null) {
          CertificateManagerGrpc.getGetTrustConfigMethod =
              getGetTrustConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.certificatemanager.v1.GetTrustConfigRequest,
                          com.google.cloud.certificatemanager.v1.TrustConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTrustConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1.GetTrustConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1.TrustConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateManagerMethodDescriptorSupplier("GetTrustConfig"))
                      .build();
        }
      }
    }
    return getGetTrustConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.CreateTrustConfigRequest,
          com.google.longrunning.Operation>
      getCreateTrustConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTrustConfig",
      requestType = com.google.cloud.certificatemanager.v1.CreateTrustConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.CreateTrustConfigRequest,
          com.google.longrunning.Operation>
      getCreateTrustConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.certificatemanager.v1.CreateTrustConfigRequest,
            com.google.longrunning.Operation>
        getCreateTrustConfigMethod;
    if ((getCreateTrustConfigMethod = CertificateManagerGrpc.getCreateTrustConfigMethod) == null) {
      synchronized (CertificateManagerGrpc.class) {
        if ((getCreateTrustConfigMethod = CertificateManagerGrpc.getCreateTrustConfigMethod)
            == null) {
          CertificateManagerGrpc.getCreateTrustConfigMethod =
              getCreateTrustConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.certificatemanager.v1.CreateTrustConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTrustConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1.CreateTrustConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateManagerMethodDescriptorSupplier("CreateTrustConfig"))
                      .build();
        }
      }
    }
    return getCreateTrustConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.UpdateTrustConfigRequest,
          com.google.longrunning.Operation>
      getUpdateTrustConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTrustConfig",
      requestType = com.google.cloud.certificatemanager.v1.UpdateTrustConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.UpdateTrustConfigRequest,
          com.google.longrunning.Operation>
      getUpdateTrustConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.certificatemanager.v1.UpdateTrustConfigRequest,
            com.google.longrunning.Operation>
        getUpdateTrustConfigMethod;
    if ((getUpdateTrustConfigMethod = CertificateManagerGrpc.getUpdateTrustConfigMethod) == null) {
      synchronized (CertificateManagerGrpc.class) {
        if ((getUpdateTrustConfigMethod = CertificateManagerGrpc.getUpdateTrustConfigMethod)
            == null) {
          CertificateManagerGrpc.getUpdateTrustConfigMethod =
              getUpdateTrustConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.certificatemanager.v1.UpdateTrustConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTrustConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1.UpdateTrustConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateManagerMethodDescriptorSupplier("UpdateTrustConfig"))
                      .build();
        }
      }
    }
    return getUpdateTrustConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.DeleteTrustConfigRequest,
          com.google.longrunning.Operation>
      getDeleteTrustConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTrustConfig",
      requestType = com.google.cloud.certificatemanager.v1.DeleteTrustConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.certificatemanager.v1.DeleteTrustConfigRequest,
          com.google.longrunning.Operation>
      getDeleteTrustConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.certificatemanager.v1.DeleteTrustConfigRequest,
            com.google.longrunning.Operation>
        getDeleteTrustConfigMethod;
    if ((getDeleteTrustConfigMethod = CertificateManagerGrpc.getDeleteTrustConfigMethod) == null) {
      synchronized (CertificateManagerGrpc.class) {
        if ((getDeleteTrustConfigMethod = CertificateManagerGrpc.getDeleteTrustConfigMethod)
            == null) {
          CertificateManagerGrpc.getDeleteTrustConfigMethod =
              getDeleteTrustConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.certificatemanager.v1.DeleteTrustConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTrustConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.certificatemanager.v1.DeleteTrustConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateManagerMethodDescriptorSupplier("DeleteTrustConfig"))
                      .build();
        }
      }
    }
    return getDeleteTrustConfigMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static CertificateManagerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CertificateManagerStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CertificateManagerStub>() {
          @java.lang.Override
          public CertificateManagerStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CertificateManagerStub(channel, callOptions);
          }
        };
    return CertificateManagerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CertificateManagerBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CertificateManagerBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CertificateManagerBlockingStub>() {
          @java.lang.Override
          public CertificateManagerBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CertificateManagerBlockingStub(channel, callOptions);
          }
        };
    return CertificateManagerBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static CertificateManagerFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CertificateManagerFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CertificateManagerFutureStub>() {
          @java.lang.Override
          public CertificateManagerFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CertificateManagerFutureStub(channel, callOptions);
          }
        };
    return CertificateManagerFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * API Overview
   * Certificates Manager API allows customers to see and manage all their TLS
   * certificates.
   * Certificates Manager API service provides methods to manage certificates,
   * group them into collections, and create serving configuration that can be
   * easily applied to other Cloud resources e.g. Target Proxies.
   * Data Model
   * The Certificates Manager service exposes the following resources:
   * * `Certificate` that describes a single TLS certificate.
   * * `CertificateMap` that describes a collection of certificates that can be
   * attached to a target resource.
   * * `CertificateMapEntry` that describes a single configuration entry that
   * consists of a SNI and a group of certificates. It's a subresource of
   * CertificateMap.
   * Certificate, CertificateMap and CertificateMapEntry IDs
   * have to fully match the regexp `[a-z0-9-]{1,63}`. In other words,
   * - only lower case letters, digits, and hyphen are allowed
   * - length of the resource ID has to be in [1,63] range.
   * Provides methods to manage Cloud Certificate Manager entities.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists Certificates in a given project and location.
     * </pre>
     */
    default void listCertificates(
        com.google.cloud.certificatemanager.v1.ListCertificatesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.certificatemanager.v1.ListCertificatesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCertificatesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Certificate.
     * </pre>
     */
    default void getCertificate(
        com.google.cloud.certificatemanager.v1.GetCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.certificatemanager.v1.Certificate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCertificateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Certificate in a given project and location.
     * </pre>
     */
    default void createCertificate(
        com.google.cloud.certificatemanager.v1.CreateCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateCertificateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a Certificate.
     * </pre>
     */
    default void updateCertificate(
        com.google.cloud.certificatemanager.v1.UpdateCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateCertificateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Certificate.
     * </pre>
     */
    default void deleteCertificate(
        com.google.cloud.certificatemanager.v1.DeleteCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteCertificateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists CertificateMaps in a given project and location.
     * </pre>
     */
    default void listCertificateMaps(
        com.google.cloud.certificatemanager.v1.ListCertificateMapsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.certificatemanager.v1.ListCertificateMapsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCertificateMapsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single CertificateMap.
     * </pre>
     */
    default void getCertificateMap(
        com.google.cloud.certificatemanager.v1.GetCertificateMapRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.certificatemanager.v1.CertificateMap>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCertificateMapMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new CertificateMap in a given project and location.
     * </pre>
     */
    default void createCertificateMap(
        com.google.cloud.certificatemanager.v1.CreateCertificateMapRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateCertificateMapMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a CertificateMap.
     * </pre>
     */
    default void updateCertificateMap(
        com.google.cloud.certificatemanager.v1.UpdateCertificateMapRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateCertificateMapMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single CertificateMap. A Certificate Map can't be deleted
     * if it contains Certificate Map Entries. Remove all the entries from
     * the map before calling this method.
     * </pre>
     */
    default void deleteCertificateMap(
        com.google.cloud.certificatemanager.v1.DeleteCertificateMapRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteCertificateMapMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists CertificateMapEntries in a given project and location.
     * </pre>
     */
    default void listCertificateMapEntries(
        com.google.cloud.certificatemanager.v1.ListCertificateMapEntriesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.certificatemanager.v1.ListCertificateMapEntriesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCertificateMapEntriesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single CertificateMapEntry.
     * </pre>
     */
    default void getCertificateMapEntry(
        com.google.cloud.certificatemanager.v1.GetCertificateMapEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.certificatemanager.v1.CertificateMapEntry>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCertificateMapEntryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new CertificateMapEntry in a given project and location.
     * </pre>
     */
    default void createCertificateMapEntry(
        com.google.cloud.certificatemanager.v1.CreateCertificateMapEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateCertificateMapEntryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a CertificateMapEntry.
     * </pre>
     */
    default void updateCertificateMapEntry(
        com.google.cloud.certificatemanager.v1.UpdateCertificateMapEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateCertificateMapEntryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single CertificateMapEntry.
     * </pre>
     */
    default void deleteCertificateMapEntry(
        com.google.cloud.certificatemanager.v1.DeleteCertificateMapEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteCertificateMapEntryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists DnsAuthorizations in a given project and location.
     * </pre>
     */
    default void listDnsAuthorizations(
        com.google.cloud.certificatemanager.v1.ListDnsAuthorizationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.certificatemanager.v1.ListDnsAuthorizationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDnsAuthorizationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single DnsAuthorization.
     * </pre>
     */
    default void getDnsAuthorization(
        com.google.cloud.certificatemanager.v1.GetDnsAuthorizationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.certificatemanager.v1.DnsAuthorization>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDnsAuthorizationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new DnsAuthorization in a given project and location.
     * </pre>
     */
    default void createDnsAuthorization(
        com.google.cloud.certificatemanager.v1.CreateDnsAuthorizationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDnsAuthorizationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a DnsAuthorization.
     * </pre>
     */
    default void updateDnsAuthorization(
        com.google.cloud.certificatemanager.v1.UpdateDnsAuthorizationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDnsAuthorizationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single DnsAuthorization.
     * </pre>
     */
    default void deleteDnsAuthorization(
        com.google.cloud.certificatemanager.v1.DeleteDnsAuthorizationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDnsAuthorizationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists CertificateIssuanceConfigs in a given project and location.
     * </pre>
     */
    default void listCertificateIssuanceConfigs(
        com.google.cloud.certificatemanager.v1.ListCertificateIssuanceConfigsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.certificatemanager.v1.ListCertificateIssuanceConfigsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCertificateIssuanceConfigsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single CertificateIssuanceConfig.
     * </pre>
     */
    default void getCertificateIssuanceConfig(
        com.google.cloud.certificatemanager.v1.GetCertificateIssuanceConfigRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.certificatemanager.v1.CertificateIssuanceConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCertificateIssuanceConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new CertificateIssuanceConfig in a given project and location.
     * </pre>
     */
    default void createCertificateIssuanceConfig(
        com.google.cloud.certificatemanager.v1.CreateCertificateIssuanceConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateCertificateIssuanceConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single CertificateIssuanceConfig.
     * </pre>
     */
    default void deleteCertificateIssuanceConfig(
        com.google.cloud.certificatemanager.v1.DeleteCertificateIssuanceConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteCertificateIssuanceConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists TrustConfigs in a given project and location.
     * </pre>
     */
    default void listTrustConfigs(
        com.google.cloud.certificatemanager.v1.ListTrustConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.certificatemanager.v1.ListTrustConfigsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListTrustConfigsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single TrustConfig.
     * </pre>
     */
    default void getTrustConfig(
        com.google.cloud.certificatemanager.v1.GetTrustConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.certificatemanager.v1.TrustConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetTrustConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new TrustConfig in a given project and location.
     * </pre>
     */
    default void createTrustConfig(
        com.google.cloud.certificatemanager.v1.CreateTrustConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateTrustConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a TrustConfig.
     * </pre>
     */
    default void updateTrustConfig(
        com.google.cloud.certificatemanager.v1.UpdateTrustConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateTrustConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single TrustConfig.
     * </pre>
     */
    default void deleteTrustConfig(
        com.google.cloud.certificatemanager.v1.DeleteTrustConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteTrustConfigMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CertificateManager.
   *
   * <pre>
   * API Overview
   * Certificates Manager API allows customers to see and manage all their TLS
   * certificates.
   * Certificates Manager API service provides methods to manage certificates,
   * group them into collections, and create serving configuration that can be
   * easily applied to other Cloud resources e.g. Target Proxies.
   * Data Model
   * The Certificates Manager service exposes the following resources:
   * * `Certificate` that describes a single TLS certificate.
   * * `CertificateMap` that describes a collection of certificates that can be
   * attached to a target resource.
   * * `CertificateMapEntry` that describes a single configuration entry that
   * consists of a SNI and a group of certificates. It's a subresource of
   * CertificateMap.
   * Certificate, CertificateMap and CertificateMapEntry IDs
   * have to fully match the regexp `[a-z0-9-]{1,63}`. In other words,
   * - only lower case letters, digits, and hyphen are allowed
   * - length of the resource ID has to be in [1,63] range.
   * Provides methods to manage Cloud Certificate Manager entities.
   * </pre>
   */
  public abstract static class CertificateManagerImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return CertificateManagerGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CertificateManager.
   *
   * <pre>
   * API Overview
   * Certificates Manager API allows customers to see and manage all their TLS
   * certificates.
   * Certificates Manager API service provides methods to manage certificates,
   * group them into collections, and create serving configuration that can be
   * easily applied to other Cloud resources e.g. Target Proxies.
   * Data Model
   * The Certificates Manager service exposes the following resources:
   * * `Certificate` that describes a single TLS certificate.
   * * `CertificateMap` that describes a collection of certificates that can be
   * attached to a target resource.
   * * `CertificateMapEntry` that describes a single configuration entry that
   * consists of a SNI and a group of certificates. It's a subresource of
   * CertificateMap.
   * Certificate, CertificateMap and CertificateMapEntry IDs
   * have to fully match the regexp `[a-z0-9-]{1,63}`. In other words,
   * - only lower case letters, digits, and hyphen are allowed
   * - length of the resource ID has to be in [1,63] range.
   * Provides methods to manage Cloud Certificate Manager entities.
   * </pre>
   */
  public static final class CertificateManagerStub
      extends io.grpc.stub.AbstractAsyncStub<CertificateManagerStub> {
    private CertificateManagerStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CertificateManagerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CertificateManagerStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Certificates in a given project and location.
     * </pre>
     */
    public void listCertificates(
        com.google.cloud.certificatemanager.v1.ListCertificatesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.certificatemanager.v1.ListCertificatesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCertificatesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Certificate.
     * </pre>
     */
    public void getCertificate(
        com.google.cloud.certificatemanager.v1.GetCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.certificatemanager.v1.Certificate>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCertificateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Certificate in a given project and location.
     * </pre>
     */
    public void createCertificate(
        com.google.cloud.certificatemanager.v1.CreateCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCertificateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a Certificate.
     * </pre>
     */
    public void updateCertificate(
        com.google.cloud.certificatemanager.v1.UpdateCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCertificateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Certificate.
     * </pre>
     */
    public void deleteCertificate(
        com.google.cloud.certificatemanager.v1.DeleteCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCertificateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists CertificateMaps in a given project and location.
     * </pre>
     */
    public void listCertificateMaps(
        com.google.cloud.certificatemanager.v1.ListCertificateMapsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.certificatemanager.v1.ListCertificateMapsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCertificateMapsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single CertificateMap.
     * </pre>
     */
    public void getCertificateMap(
        com.google.cloud.certificatemanager.v1.GetCertificateMapRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.certificatemanager.v1.CertificateMap>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCertificateMapMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new CertificateMap in a given project and location.
     * </pre>
     */
    public void createCertificateMap(
        com.google.cloud.certificatemanager.v1.CreateCertificateMapRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCertificateMapMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a CertificateMap.
     * </pre>
     */
    public void updateCertificateMap(
        com.google.cloud.certificatemanager.v1.UpdateCertificateMapRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCertificateMapMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single CertificateMap. A Certificate Map can't be deleted
     * if it contains Certificate Map Entries. Remove all the entries from
     * the map before calling this method.
     * </pre>
     */
    public void deleteCertificateMap(
        com.google.cloud.certificatemanager.v1.DeleteCertificateMapRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCertificateMapMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists CertificateMapEntries in a given project and location.
     * </pre>
     */
    public void listCertificateMapEntries(
        com.google.cloud.certificatemanager.v1.ListCertificateMapEntriesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.certificatemanager.v1.ListCertificateMapEntriesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCertificateMapEntriesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single CertificateMapEntry.
     * </pre>
     */
    public void getCertificateMapEntry(
        com.google.cloud.certificatemanager.v1.GetCertificateMapEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.certificatemanager.v1.CertificateMapEntry>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCertificateMapEntryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new CertificateMapEntry in a given project and location.
     * </pre>
     */
    public void createCertificateMapEntry(
        com.google.cloud.certificatemanager.v1.CreateCertificateMapEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCertificateMapEntryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a CertificateMapEntry.
     * </pre>
     */
    public void updateCertificateMapEntry(
        com.google.cloud.certificatemanager.v1.UpdateCertificateMapEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCertificateMapEntryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single CertificateMapEntry.
     * </pre>
     */
    public void deleteCertificateMapEntry(
        com.google.cloud.certificatemanager.v1.DeleteCertificateMapEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCertificateMapEntryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists DnsAuthorizations in a given project and location.
     * </pre>
     */
    public void listDnsAuthorizations(
        com.google.cloud.certificatemanager.v1.ListDnsAuthorizationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.certificatemanager.v1.ListDnsAuthorizationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDnsAuthorizationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single DnsAuthorization.
     * </pre>
     */
    public void getDnsAuthorization(
        com.google.cloud.certificatemanager.v1.GetDnsAuthorizationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.certificatemanager.v1.DnsAuthorization>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDnsAuthorizationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new DnsAuthorization in a given project and location.
     * </pre>
     */
    public void createDnsAuthorization(
        com.google.cloud.certificatemanager.v1.CreateDnsAuthorizationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDnsAuthorizationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a DnsAuthorization.
     * </pre>
     */
    public void updateDnsAuthorization(
        com.google.cloud.certificatemanager.v1.UpdateDnsAuthorizationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDnsAuthorizationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single DnsAuthorization.
     * </pre>
     */
    public void deleteDnsAuthorization(
        com.google.cloud.certificatemanager.v1.DeleteDnsAuthorizationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDnsAuthorizationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists CertificateIssuanceConfigs in a given project and location.
     * </pre>
     */
    public void listCertificateIssuanceConfigs(
        com.google.cloud.certificatemanager.v1.ListCertificateIssuanceConfigsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.certificatemanager.v1.ListCertificateIssuanceConfigsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCertificateIssuanceConfigsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single CertificateIssuanceConfig.
     * </pre>
     */
    public void getCertificateIssuanceConfig(
        com.google.cloud.certificatemanager.v1.GetCertificateIssuanceConfigRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.certificatemanager.v1.CertificateIssuanceConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCertificateIssuanceConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new CertificateIssuanceConfig in a given project and location.
     * </pre>
     */
    public void createCertificateIssuanceConfig(
        com.google.cloud.certificatemanager.v1.CreateCertificateIssuanceConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCertificateIssuanceConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single CertificateIssuanceConfig.
     * </pre>
     */
    public void deleteCertificateIssuanceConfig(
        com.google.cloud.certificatemanager.v1.DeleteCertificateIssuanceConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCertificateIssuanceConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists TrustConfigs in a given project and location.
     * </pre>
     */
    public void listTrustConfigs(
        com.google.cloud.certificatemanager.v1.ListTrustConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.certificatemanager.v1.ListTrustConfigsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTrustConfigsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single TrustConfig.
     * </pre>
     */
    public void getTrustConfig(
        com.google.cloud.certificatemanager.v1.GetTrustConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.certificatemanager.v1.TrustConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTrustConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new TrustConfig in a given project and location.
     * </pre>
     */
    public void createTrustConfig(
        com.google.cloud.certificatemanager.v1.CreateTrustConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTrustConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a TrustConfig.
     * </pre>
     */
    public void updateTrustConfig(
        com.google.cloud.certificatemanager.v1.UpdateTrustConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTrustConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single TrustConfig.
     * </pre>
     */
    public void deleteTrustConfig(
        com.google.cloud.certificatemanager.v1.DeleteTrustConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTrustConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CertificateManager.
   *
   * <pre>
   * API Overview
   * Certificates Manager API allows customers to see and manage all their TLS
   * certificates.
   * Certificates Manager API service provides methods to manage certificates,
   * group them into collections, and create serving configuration that can be
   * easily applied to other Cloud resources e.g. Target Proxies.
   * Data Model
   * The Certificates Manager service exposes the following resources:
   * * `Certificate` that describes a single TLS certificate.
   * * `CertificateMap` that describes a collection of certificates that can be
   * attached to a target resource.
   * * `CertificateMapEntry` that describes a single configuration entry that
   * consists of a SNI and a group of certificates. It's a subresource of
   * CertificateMap.
   * Certificate, CertificateMap and CertificateMapEntry IDs
   * have to fully match the regexp `[a-z0-9-]{1,63}`. In other words,
   * - only lower case letters, digits, and hyphen are allowed
   * - length of the resource ID has to be in [1,63] range.
   * Provides methods to manage Cloud Certificate Manager entities.
   * </pre>
   */
  public static final class CertificateManagerBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CertificateManagerBlockingStub> {
    private CertificateManagerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CertificateManagerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CertificateManagerBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Certificates in a given project and location.
     * </pre>
     */
    public com.google.cloud.certificatemanager.v1.ListCertificatesResponse listCertificates(
        com.google.cloud.certificatemanager.v1.ListCertificatesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCertificatesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Certificate.
     * </pre>
     */
    public com.google.cloud.certificatemanager.v1.Certificate getCertificate(
        com.google.cloud.certificatemanager.v1.GetCertificateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCertificateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Certificate in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createCertificate(
        com.google.cloud.certificatemanager.v1.CreateCertificateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCertificateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a Certificate.
     * </pre>
     */
    public com.google.longrunning.Operation updateCertificate(
        com.google.cloud.certificatemanager.v1.UpdateCertificateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCertificateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Certificate.
     * </pre>
     */
    public com.google.longrunning.Operation deleteCertificate(
        com.google.cloud.certificatemanager.v1.DeleteCertificateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCertificateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists CertificateMaps in a given project and location.
     * </pre>
     */
    public com.google.cloud.certificatemanager.v1.ListCertificateMapsResponse listCertificateMaps(
        com.google.cloud.certificatemanager.v1.ListCertificateMapsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCertificateMapsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single CertificateMap.
     * </pre>
     */
    public com.google.cloud.certificatemanager.v1.CertificateMap getCertificateMap(
        com.google.cloud.certificatemanager.v1.GetCertificateMapRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCertificateMapMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new CertificateMap in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createCertificateMap(
        com.google.cloud.certificatemanager.v1.CreateCertificateMapRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCertificateMapMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a CertificateMap.
     * </pre>
     */
    public com.google.longrunning.Operation updateCertificateMap(
        com.google.cloud.certificatemanager.v1.UpdateCertificateMapRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCertificateMapMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single CertificateMap. A Certificate Map can't be deleted
     * if it contains Certificate Map Entries. Remove all the entries from
     * the map before calling this method.
     * </pre>
     */
    public com.google.longrunning.Operation deleteCertificateMap(
        com.google.cloud.certificatemanager.v1.DeleteCertificateMapRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCertificateMapMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists CertificateMapEntries in a given project and location.
     * </pre>
     */
    public com.google.cloud.certificatemanager.v1.ListCertificateMapEntriesResponse
        listCertificateMapEntries(
            com.google.cloud.certificatemanager.v1.ListCertificateMapEntriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCertificateMapEntriesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single CertificateMapEntry.
     * </pre>
     */
    public com.google.cloud.certificatemanager.v1.CertificateMapEntry getCertificateMapEntry(
        com.google.cloud.certificatemanager.v1.GetCertificateMapEntryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCertificateMapEntryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new CertificateMapEntry in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createCertificateMapEntry(
        com.google.cloud.certificatemanager.v1.CreateCertificateMapEntryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCertificateMapEntryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a CertificateMapEntry.
     * </pre>
     */
    public com.google.longrunning.Operation updateCertificateMapEntry(
        com.google.cloud.certificatemanager.v1.UpdateCertificateMapEntryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCertificateMapEntryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single CertificateMapEntry.
     * </pre>
     */
    public com.google.longrunning.Operation deleteCertificateMapEntry(
        com.google.cloud.certificatemanager.v1.DeleteCertificateMapEntryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCertificateMapEntryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DnsAuthorizations in a given project and location.
     * </pre>
     */
    public com.google.cloud.certificatemanager.v1.ListDnsAuthorizationsResponse
        listDnsAuthorizations(
            com.google.cloud.certificatemanager.v1.ListDnsAuthorizationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDnsAuthorizationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single DnsAuthorization.
     * </pre>
     */
    public com.google.cloud.certificatemanager.v1.DnsAuthorization getDnsAuthorization(
        com.google.cloud.certificatemanager.v1.GetDnsAuthorizationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDnsAuthorizationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new DnsAuthorization in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createDnsAuthorization(
        com.google.cloud.certificatemanager.v1.CreateDnsAuthorizationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDnsAuthorizationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a DnsAuthorization.
     * </pre>
     */
    public com.google.longrunning.Operation updateDnsAuthorization(
        com.google.cloud.certificatemanager.v1.UpdateDnsAuthorizationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDnsAuthorizationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single DnsAuthorization.
     * </pre>
     */
    public com.google.longrunning.Operation deleteDnsAuthorization(
        com.google.cloud.certificatemanager.v1.DeleteDnsAuthorizationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDnsAuthorizationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists CertificateIssuanceConfigs in a given project and location.
     * </pre>
     */
    public com.google.cloud.certificatemanager.v1.ListCertificateIssuanceConfigsResponse
        listCertificateIssuanceConfigs(
            com.google.cloud.certificatemanager.v1.ListCertificateIssuanceConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCertificateIssuanceConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single CertificateIssuanceConfig.
     * </pre>
     */
    public com.google.cloud.certificatemanager.v1.CertificateIssuanceConfig
        getCertificateIssuanceConfig(
            com.google.cloud.certificatemanager.v1.GetCertificateIssuanceConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCertificateIssuanceConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new CertificateIssuanceConfig in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createCertificateIssuanceConfig(
        com.google.cloud.certificatemanager.v1.CreateCertificateIssuanceConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCertificateIssuanceConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single CertificateIssuanceConfig.
     * </pre>
     */
    public com.google.longrunning.Operation deleteCertificateIssuanceConfig(
        com.google.cloud.certificatemanager.v1.DeleteCertificateIssuanceConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCertificateIssuanceConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists TrustConfigs in a given project and location.
     * </pre>
     */
    public com.google.cloud.certificatemanager.v1.ListTrustConfigsResponse listTrustConfigs(
        com.google.cloud.certificatemanager.v1.ListTrustConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTrustConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single TrustConfig.
     * </pre>
     */
    public com.google.cloud.certificatemanager.v1.TrustConfig getTrustConfig(
        com.google.cloud.certificatemanager.v1.GetTrustConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTrustConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new TrustConfig in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createTrustConfig(
        com.google.cloud.certificatemanager.v1.CreateTrustConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTrustConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a TrustConfig.
     * </pre>
     */
    public com.google.longrunning.Operation updateTrustConfig(
        com.google.cloud.certificatemanager.v1.UpdateTrustConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTrustConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single TrustConfig.
     * </pre>
     */
    public com.google.longrunning.Operation deleteTrustConfig(
        com.google.cloud.certificatemanager.v1.DeleteTrustConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTrustConfigMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CertificateManager.
   *
   * <pre>
   * API Overview
   * Certificates Manager API allows customers to see and manage all their TLS
   * certificates.
   * Certificates Manager API service provides methods to manage certificates,
   * group them into collections, and create serving configuration that can be
   * easily applied to other Cloud resources e.g. Target Proxies.
   * Data Model
   * The Certificates Manager service exposes the following resources:
   * * `Certificate` that describes a single TLS certificate.
   * * `CertificateMap` that describes a collection of certificates that can be
   * attached to a target resource.
   * * `CertificateMapEntry` that describes a single configuration entry that
   * consists of a SNI and a group of certificates. It's a subresource of
   * CertificateMap.
   * Certificate, CertificateMap and CertificateMapEntry IDs
   * have to fully match the regexp `[a-z0-9-]{1,63}`. In other words,
   * - only lower case letters, digits, and hyphen are allowed
   * - length of the resource ID has to be in [1,63] range.
   * Provides methods to manage Cloud Certificate Manager entities.
   * </pre>
   */
  public static final class CertificateManagerFutureStub
      extends io.grpc.stub.AbstractFutureStub<CertificateManagerFutureStub> {
    private CertificateManagerFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CertificateManagerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CertificateManagerFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Certificates in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.certificatemanager.v1.ListCertificatesResponse>
        listCertificates(com.google.cloud.certificatemanager.v1.ListCertificatesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCertificatesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Certificate.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.certificatemanager.v1.Certificate>
        getCertificate(com.google.cloud.certificatemanager.v1.GetCertificateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCertificateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Certificate in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createCertificate(com.google.cloud.certificatemanager.v1.CreateCertificateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCertificateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a Certificate.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateCertificate(com.google.cloud.certificatemanager.v1.UpdateCertificateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCertificateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Certificate.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteCertificate(com.google.cloud.certificatemanager.v1.DeleteCertificateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCertificateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists CertificateMaps in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.certificatemanager.v1.ListCertificateMapsResponse>
        listCertificateMaps(
            com.google.cloud.certificatemanager.v1.ListCertificateMapsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCertificateMapsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single CertificateMap.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.certificatemanager.v1.CertificateMap>
        getCertificateMap(com.google.cloud.certificatemanager.v1.GetCertificateMapRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCertificateMapMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new CertificateMap in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createCertificateMap(
            com.google.cloud.certificatemanager.v1.CreateCertificateMapRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCertificateMapMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a CertificateMap.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateCertificateMap(
            com.google.cloud.certificatemanager.v1.UpdateCertificateMapRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCertificateMapMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single CertificateMap. A Certificate Map can't be deleted
     * if it contains Certificate Map Entries. Remove all the entries from
     * the map before calling this method.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteCertificateMap(
            com.google.cloud.certificatemanager.v1.DeleteCertificateMapRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCertificateMapMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists CertificateMapEntries in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.certificatemanager.v1.ListCertificateMapEntriesResponse>
        listCertificateMapEntries(
            com.google.cloud.certificatemanager.v1.ListCertificateMapEntriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCertificateMapEntriesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single CertificateMapEntry.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.certificatemanager.v1.CertificateMapEntry>
        getCertificateMapEntry(
            com.google.cloud.certificatemanager.v1.GetCertificateMapEntryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCertificateMapEntryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new CertificateMapEntry in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createCertificateMapEntry(
            com.google.cloud.certificatemanager.v1.CreateCertificateMapEntryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCertificateMapEntryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a CertificateMapEntry.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateCertificateMapEntry(
            com.google.cloud.certificatemanager.v1.UpdateCertificateMapEntryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCertificateMapEntryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single CertificateMapEntry.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteCertificateMapEntry(
            com.google.cloud.certificatemanager.v1.DeleteCertificateMapEntryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCertificateMapEntryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DnsAuthorizations in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.certificatemanager.v1.ListDnsAuthorizationsResponse>
        listDnsAuthorizations(
            com.google.cloud.certificatemanager.v1.ListDnsAuthorizationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDnsAuthorizationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single DnsAuthorization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.certificatemanager.v1.DnsAuthorization>
        getDnsAuthorization(
            com.google.cloud.certificatemanager.v1.GetDnsAuthorizationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDnsAuthorizationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new DnsAuthorization in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createDnsAuthorization(
            com.google.cloud.certificatemanager.v1.CreateDnsAuthorizationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDnsAuthorizationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a DnsAuthorization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateDnsAuthorization(
            com.google.cloud.certificatemanager.v1.UpdateDnsAuthorizationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDnsAuthorizationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single DnsAuthorization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteDnsAuthorization(
            com.google.cloud.certificatemanager.v1.DeleteDnsAuthorizationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDnsAuthorizationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists CertificateIssuanceConfigs in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.certificatemanager.v1.ListCertificateIssuanceConfigsResponse>
        listCertificateIssuanceConfigs(
            com.google.cloud.certificatemanager.v1.ListCertificateIssuanceConfigsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCertificateIssuanceConfigsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single CertificateIssuanceConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.certificatemanager.v1.CertificateIssuanceConfig>
        getCertificateIssuanceConfig(
            com.google.cloud.certificatemanager.v1.GetCertificateIssuanceConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCertificateIssuanceConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new CertificateIssuanceConfig in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createCertificateIssuanceConfig(
            com.google.cloud.certificatemanager.v1.CreateCertificateIssuanceConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCertificateIssuanceConfigMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single CertificateIssuanceConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteCertificateIssuanceConfig(
            com.google.cloud.certificatemanager.v1.DeleteCertificateIssuanceConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCertificateIssuanceConfigMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists TrustConfigs in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.certificatemanager.v1.ListTrustConfigsResponse>
        listTrustConfigs(com.google.cloud.certificatemanager.v1.ListTrustConfigsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTrustConfigsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single TrustConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.certificatemanager.v1.TrustConfig>
        getTrustConfig(com.google.cloud.certificatemanager.v1.GetTrustConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTrustConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new TrustConfig in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createTrustConfig(com.google.cloud.certificatemanager.v1.CreateTrustConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTrustConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a TrustConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateTrustConfig(com.google.cloud.certificatemanager.v1.UpdateTrustConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTrustConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single TrustConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteTrustConfig(com.google.cloud.certificatemanager.v1.DeleteTrustConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTrustConfigMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_CERTIFICATES = 0;
  private static final int METHODID_GET_CERTIFICATE = 1;
  private static final int METHODID_CREATE_CERTIFICATE = 2;
  private static final int METHODID_UPDATE_CERTIFICATE = 3;
  private static final int METHODID_DELETE_CERTIFICATE = 4;
  private static final int METHODID_LIST_CERTIFICATE_MAPS = 5;
  private static final int METHODID_GET_CERTIFICATE_MAP = 6;
  private static final int METHODID_CREATE_CERTIFICATE_MAP = 7;
  private static final int METHODID_UPDATE_CERTIFICATE_MAP = 8;
  private static final int METHODID_DELETE_CERTIFICATE_MAP = 9;
  private static final int METHODID_LIST_CERTIFICATE_MAP_ENTRIES = 10;
  private static final int METHODID_GET_CERTIFICATE_MAP_ENTRY = 11;
  private static final int METHODID_CREATE_CERTIFICATE_MAP_ENTRY = 12;
  private static final int METHODID_UPDATE_CERTIFICATE_MAP_ENTRY = 13;
  private static final int METHODID_DELETE_CERTIFICATE_MAP_ENTRY = 14;
  private static final int METHODID_LIST_DNS_AUTHORIZATIONS = 15;
  private static final int METHODID_GET_DNS_AUTHORIZATION = 16;
  private static final int METHODID_CREATE_DNS_AUTHORIZATION = 17;
  private static final int METHODID_UPDATE_DNS_AUTHORIZATION = 18;
  private static final int METHODID_DELETE_DNS_AUTHORIZATION = 19;
  private static final int METHODID_LIST_CERTIFICATE_ISSUANCE_CONFIGS = 20;
  private static final int METHODID_GET_CERTIFICATE_ISSUANCE_CONFIG = 21;
  private static final int METHODID_CREATE_CERTIFICATE_ISSUANCE_CONFIG = 22;
  private static final int METHODID_DELETE_CERTIFICATE_ISSUANCE_CONFIG = 23;
  private static final int METHODID_LIST_TRUST_CONFIGS = 24;
  private static final int METHODID_GET_TRUST_CONFIG = 25;
  private static final int METHODID_CREATE_TRUST_CONFIG = 26;
  private static final int METHODID_UPDATE_TRUST_CONFIG = 27;
  private static final int METHODID_DELETE_TRUST_CONFIG = 28;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
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
        case METHODID_LIST_CERTIFICATES:
          serviceImpl.listCertificates(
              (com.google.cloud.certificatemanager.v1.ListCertificatesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.certificatemanager.v1.ListCertificatesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CERTIFICATE:
          serviceImpl.getCertificate(
              (com.google.cloud.certificatemanager.v1.GetCertificateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.certificatemanager.v1.Certificate>)
                  responseObserver);
          break;
        case METHODID_CREATE_CERTIFICATE:
          serviceImpl.createCertificate(
              (com.google.cloud.certificatemanager.v1.CreateCertificateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_CERTIFICATE:
          serviceImpl.updateCertificate(
              (com.google.cloud.certificatemanager.v1.UpdateCertificateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CERTIFICATE:
          serviceImpl.deleteCertificate(
              (com.google.cloud.certificatemanager.v1.DeleteCertificateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_CERTIFICATE_MAPS:
          serviceImpl.listCertificateMaps(
              (com.google.cloud.certificatemanager.v1.ListCertificateMapsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.certificatemanager.v1.ListCertificateMapsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CERTIFICATE_MAP:
          serviceImpl.getCertificateMap(
              (com.google.cloud.certificatemanager.v1.GetCertificateMapRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.certificatemanager.v1.CertificateMap>)
                  responseObserver);
          break;
        case METHODID_CREATE_CERTIFICATE_MAP:
          serviceImpl.createCertificateMap(
              (com.google.cloud.certificatemanager.v1.CreateCertificateMapRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_CERTIFICATE_MAP:
          serviceImpl.updateCertificateMap(
              (com.google.cloud.certificatemanager.v1.UpdateCertificateMapRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CERTIFICATE_MAP:
          serviceImpl.deleteCertificateMap(
              (com.google.cloud.certificatemanager.v1.DeleteCertificateMapRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_CERTIFICATE_MAP_ENTRIES:
          serviceImpl.listCertificateMapEntries(
              (com.google.cloud.certificatemanager.v1.ListCertificateMapEntriesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.certificatemanager.v1.ListCertificateMapEntriesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CERTIFICATE_MAP_ENTRY:
          serviceImpl.getCertificateMapEntry(
              (com.google.cloud.certificatemanager.v1.GetCertificateMapEntryRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.certificatemanager.v1.CertificateMapEntry>)
                  responseObserver);
          break;
        case METHODID_CREATE_CERTIFICATE_MAP_ENTRY:
          serviceImpl.createCertificateMapEntry(
              (com.google.cloud.certificatemanager.v1.CreateCertificateMapEntryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_CERTIFICATE_MAP_ENTRY:
          serviceImpl.updateCertificateMapEntry(
              (com.google.cloud.certificatemanager.v1.UpdateCertificateMapEntryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CERTIFICATE_MAP_ENTRY:
          serviceImpl.deleteCertificateMapEntry(
              (com.google.cloud.certificatemanager.v1.DeleteCertificateMapEntryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_DNS_AUTHORIZATIONS:
          serviceImpl.listDnsAuthorizations(
              (com.google.cloud.certificatemanager.v1.ListDnsAuthorizationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.certificatemanager.v1.ListDnsAuthorizationsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_DNS_AUTHORIZATION:
          serviceImpl.getDnsAuthorization(
              (com.google.cloud.certificatemanager.v1.GetDnsAuthorizationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.certificatemanager.v1.DnsAuthorization>)
                  responseObserver);
          break;
        case METHODID_CREATE_DNS_AUTHORIZATION:
          serviceImpl.createDnsAuthorization(
              (com.google.cloud.certificatemanager.v1.CreateDnsAuthorizationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_DNS_AUTHORIZATION:
          serviceImpl.updateDnsAuthorization(
              (com.google.cloud.certificatemanager.v1.UpdateDnsAuthorizationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_DNS_AUTHORIZATION:
          serviceImpl.deleteDnsAuthorization(
              (com.google.cloud.certificatemanager.v1.DeleteDnsAuthorizationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_CERTIFICATE_ISSUANCE_CONFIGS:
          serviceImpl.listCertificateIssuanceConfigs(
              (com.google.cloud.certificatemanager.v1.ListCertificateIssuanceConfigsRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.certificatemanager.v1
                          .ListCertificateIssuanceConfigsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CERTIFICATE_ISSUANCE_CONFIG:
          serviceImpl.getCertificateIssuanceConfig(
              (com.google.cloud.certificatemanager.v1.GetCertificateIssuanceConfigRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.certificatemanager.v1.CertificateIssuanceConfig>)
                  responseObserver);
          break;
        case METHODID_CREATE_CERTIFICATE_ISSUANCE_CONFIG:
          serviceImpl.createCertificateIssuanceConfig(
              (com.google.cloud.certificatemanager.v1.CreateCertificateIssuanceConfigRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CERTIFICATE_ISSUANCE_CONFIG:
          serviceImpl.deleteCertificateIssuanceConfig(
              (com.google.cloud.certificatemanager.v1.DeleteCertificateIssuanceConfigRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_TRUST_CONFIGS:
          serviceImpl.listTrustConfigs(
              (com.google.cloud.certificatemanager.v1.ListTrustConfigsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.certificatemanager.v1.ListTrustConfigsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_TRUST_CONFIG:
          serviceImpl.getTrustConfig(
              (com.google.cloud.certificatemanager.v1.GetTrustConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.certificatemanager.v1.TrustConfig>)
                  responseObserver);
          break;
        case METHODID_CREATE_TRUST_CONFIG:
          serviceImpl.createTrustConfig(
              (com.google.cloud.certificatemanager.v1.CreateTrustConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_TRUST_CONFIG:
          serviceImpl.updateTrustConfig(
              (com.google.cloud.certificatemanager.v1.UpdateTrustConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_TRUST_CONFIG:
          serviceImpl.deleteTrustConfig(
              (com.google.cloud.certificatemanager.v1.DeleteTrustConfigRequest) request,
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getListCertificatesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.certificatemanager.v1.ListCertificatesRequest,
                    com.google.cloud.certificatemanager.v1.ListCertificatesResponse>(
                    service, METHODID_LIST_CERTIFICATES)))
        .addMethod(
            getGetCertificateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.certificatemanager.v1.GetCertificateRequest,
                    com.google.cloud.certificatemanager.v1.Certificate>(
                    service, METHODID_GET_CERTIFICATE)))
        .addMethod(
            getCreateCertificateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.certificatemanager.v1.CreateCertificateRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_CERTIFICATE)))
        .addMethod(
            getUpdateCertificateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.certificatemanager.v1.UpdateCertificateRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_CERTIFICATE)))
        .addMethod(
            getDeleteCertificateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.certificatemanager.v1.DeleteCertificateRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_CERTIFICATE)))
        .addMethod(
            getListCertificateMapsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.certificatemanager.v1.ListCertificateMapsRequest,
                    com.google.cloud.certificatemanager.v1.ListCertificateMapsResponse>(
                    service, METHODID_LIST_CERTIFICATE_MAPS)))
        .addMethod(
            getGetCertificateMapMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.certificatemanager.v1.GetCertificateMapRequest,
                    com.google.cloud.certificatemanager.v1.CertificateMap>(
                    service, METHODID_GET_CERTIFICATE_MAP)))
        .addMethod(
            getCreateCertificateMapMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.certificatemanager.v1.CreateCertificateMapRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_CERTIFICATE_MAP)))
        .addMethod(
            getUpdateCertificateMapMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.certificatemanager.v1.UpdateCertificateMapRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_CERTIFICATE_MAP)))
        .addMethod(
            getDeleteCertificateMapMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.certificatemanager.v1.DeleteCertificateMapRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_CERTIFICATE_MAP)))
        .addMethod(
            getListCertificateMapEntriesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.certificatemanager.v1.ListCertificateMapEntriesRequest,
                    com.google.cloud.certificatemanager.v1.ListCertificateMapEntriesResponse>(
                    service, METHODID_LIST_CERTIFICATE_MAP_ENTRIES)))
        .addMethod(
            getGetCertificateMapEntryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.certificatemanager.v1.GetCertificateMapEntryRequest,
                    com.google.cloud.certificatemanager.v1.CertificateMapEntry>(
                    service, METHODID_GET_CERTIFICATE_MAP_ENTRY)))
        .addMethod(
            getCreateCertificateMapEntryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.certificatemanager.v1.CreateCertificateMapEntryRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_CERTIFICATE_MAP_ENTRY)))
        .addMethod(
            getUpdateCertificateMapEntryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.certificatemanager.v1.UpdateCertificateMapEntryRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_CERTIFICATE_MAP_ENTRY)))
        .addMethod(
            getDeleteCertificateMapEntryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.certificatemanager.v1.DeleteCertificateMapEntryRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_CERTIFICATE_MAP_ENTRY)))
        .addMethod(
            getListDnsAuthorizationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.certificatemanager.v1.ListDnsAuthorizationsRequest,
                    com.google.cloud.certificatemanager.v1.ListDnsAuthorizationsResponse>(
                    service, METHODID_LIST_DNS_AUTHORIZATIONS)))
        .addMethod(
            getGetDnsAuthorizationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.certificatemanager.v1.GetDnsAuthorizationRequest,
                    com.google.cloud.certificatemanager.v1.DnsAuthorization>(
                    service, METHODID_GET_DNS_AUTHORIZATION)))
        .addMethod(
            getCreateDnsAuthorizationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.certificatemanager.v1.CreateDnsAuthorizationRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_DNS_AUTHORIZATION)))
        .addMethod(
            getUpdateDnsAuthorizationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.certificatemanager.v1.UpdateDnsAuthorizationRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_DNS_AUTHORIZATION)))
        .addMethod(
            getDeleteDnsAuthorizationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.certificatemanager.v1.DeleteDnsAuthorizationRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_DNS_AUTHORIZATION)))
        .addMethod(
            getListCertificateIssuanceConfigsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.certificatemanager.v1.ListCertificateIssuanceConfigsRequest,
                    com.google.cloud.certificatemanager.v1.ListCertificateIssuanceConfigsResponse>(
                    service, METHODID_LIST_CERTIFICATE_ISSUANCE_CONFIGS)))
        .addMethod(
            getGetCertificateIssuanceConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.certificatemanager.v1.GetCertificateIssuanceConfigRequest,
                    com.google.cloud.certificatemanager.v1.CertificateIssuanceConfig>(
                    service, METHODID_GET_CERTIFICATE_ISSUANCE_CONFIG)))
        .addMethod(
            getCreateCertificateIssuanceConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.certificatemanager.v1.CreateCertificateIssuanceConfigRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_CERTIFICATE_ISSUANCE_CONFIG)))
        .addMethod(
            getDeleteCertificateIssuanceConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.certificatemanager.v1.DeleteCertificateIssuanceConfigRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_CERTIFICATE_ISSUANCE_CONFIG)))
        .addMethod(
            getListTrustConfigsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.certificatemanager.v1.ListTrustConfigsRequest,
                    com.google.cloud.certificatemanager.v1.ListTrustConfigsResponse>(
                    service, METHODID_LIST_TRUST_CONFIGS)))
        .addMethod(
            getGetTrustConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.certificatemanager.v1.GetTrustConfigRequest,
                    com.google.cloud.certificatemanager.v1.TrustConfig>(
                    service, METHODID_GET_TRUST_CONFIG)))
        .addMethod(
            getCreateTrustConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.certificatemanager.v1.CreateTrustConfigRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_TRUST_CONFIG)))
        .addMethod(
            getUpdateTrustConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.certificatemanager.v1.UpdateTrustConfigRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_TRUST_CONFIG)))
        .addMethod(
            getDeleteTrustConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.certificatemanager.v1.DeleteTrustConfigRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_TRUST_CONFIG)))
        .build();
  }

  private abstract static class CertificateManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CertificateManagerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.certificatemanager.v1.CertificateManagerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CertificateManager");
    }
  }

  private static final class CertificateManagerFileDescriptorSupplier
      extends CertificateManagerBaseDescriptorSupplier {
    CertificateManagerFileDescriptorSupplier() {}
  }

  private static final class CertificateManagerMethodDescriptorSupplier
      extends CertificateManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CertificateManagerMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CertificateManagerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new CertificateManagerFileDescriptorSupplier())
                      .addMethod(getListCertificatesMethod())
                      .addMethod(getGetCertificateMethod())
                      .addMethod(getCreateCertificateMethod())
                      .addMethod(getUpdateCertificateMethod())
                      .addMethod(getDeleteCertificateMethod())
                      .addMethod(getListCertificateMapsMethod())
                      .addMethod(getGetCertificateMapMethod())
                      .addMethod(getCreateCertificateMapMethod())
                      .addMethod(getUpdateCertificateMapMethod())
                      .addMethod(getDeleteCertificateMapMethod())
                      .addMethod(getListCertificateMapEntriesMethod())
                      .addMethod(getGetCertificateMapEntryMethod())
                      .addMethod(getCreateCertificateMapEntryMethod())
                      .addMethod(getUpdateCertificateMapEntryMethod())
                      .addMethod(getDeleteCertificateMapEntryMethod())
                      .addMethod(getListDnsAuthorizationsMethod())
                      .addMethod(getGetDnsAuthorizationMethod())
                      .addMethod(getCreateDnsAuthorizationMethod())
                      .addMethod(getUpdateDnsAuthorizationMethod())
                      .addMethod(getDeleteDnsAuthorizationMethod())
                      .addMethod(getListCertificateIssuanceConfigsMethod())
                      .addMethod(getGetCertificateIssuanceConfigMethod())
                      .addMethod(getCreateCertificateIssuanceConfigMethod())
                      .addMethod(getDeleteCertificateIssuanceConfigMethod())
                      .addMethod(getListTrustConfigsMethod())
                      .addMethod(getGetTrustConfigMethod())
                      .addMethod(getCreateTrustConfigMethod())
                      .addMethod(getUpdateTrustConfigMethod())
                      .addMethod(getDeleteTrustConfigMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
