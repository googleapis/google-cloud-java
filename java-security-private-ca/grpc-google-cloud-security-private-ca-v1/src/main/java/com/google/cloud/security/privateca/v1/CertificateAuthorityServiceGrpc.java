/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.security.privateca.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * [Certificate Authority Service][google.cloud.security.privateca.v1.CertificateAuthorityService] manages private
 * certificate authorities and issued certificates.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/security/privateca/v1/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CertificateAuthorityServiceGrpc {

  private CertificateAuthorityServiceGrpc() {}

  public static final String SERVICE_NAME =
      "google.cloud.security.privateca.v1.CertificateAuthorityService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.CreateCertificateRequest,
          com.google.cloud.security.privateca.v1.Certificate>
      getCreateCertificateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCertificate",
      requestType = com.google.cloud.security.privateca.v1.CreateCertificateRequest.class,
      responseType = com.google.cloud.security.privateca.v1.Certificate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.CreateCertificateRequest,
          com.google.cloud.security.privateca.v1.Certificate>
      getCreateCertificateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1.CreateCertificateRequest,
            com.google.cloud.security.privateca.v1.Certificate>
        getCreateCertificateMethod;
    if ((getCreateCertificateMethod = CertificateAuthorityServiceGrpc.getCreateCertificateMethod)
        == null) {
      synchronized (CertificateAuthorityServiceGrpc.class) {
        if ((getCreateCertificateMethod =
                CertificateAuthorityServiceGrpc.getCreateCertificateMethod)
            == null) {
          CertificateAuthorityServiceGrpc.getCreateCertificateMethod =
              getCreateCertificateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.privateca.v1.CreateCertificateRequest,
                          com.google.cloud.security.privateca.v1.Certificate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCertificate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1.CreateCertificateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1.Certificate
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateAuthorityServiceMethodDescriptorSupplier(
                              "CreateCertificate"))
                      .build();
        }
      }
    }
    return getCreateCertificateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.GetCertificateRequest,
          com.google.cloud.security.privateca.v1.Certificate>
      getGetCertificateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCertificate",
      requestType = com.google.cloud.security.privateca.v1.GetCertificateRequest.class,
      responseType = com.google.cloud.security.privateca.v1.Certificate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.GetCertificateRequest,
          com.google.cloud.security.privateca.v1.Certificate>
      getGetCertificateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1.GetCertificateRequest,
            com.google.cloud.security.privateca.v1.Certificate>
        getGetCertificateMethod;
    if ((getGetCertificateMethod = CertificateAuthorityServiceGrpc.getGetCertificateMethod)
        == null) {
      synchronized (CertificateAuthorityServiceGrpc.class) {
        if ((getGetCertificateMethod = CertificateAuthorityServiceGrpc.getGetCertificateMethod)
            == null) {
          CertificateAuthorityServiceGrpc.getGetCertificateMethod =
              getGetCertificateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.privateca.v1.GetCertificateRequest,
                          com.google.cloud.security.privateca.v1.Certificate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCertificate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1.GetCertificateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1.Certificate
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateAuthorityServiceMethodDescriptorSupplier("GetCertificate"))
                      .build();
        }
      }
    }
    return getGetCertificateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.ListCertificatesRequest,
          com.google.cloud.security.privateca.v1.ListCertificatesResponse>
      getListCertificatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCertificates",
      requestType = com.google.cloud.security.privateca.v1.ListCertificatesRequest.class,
      responseType = com.google.cloud.security.privateca.v1.ListCertificatesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.ListCertificatesRequest,
          com.google.cloud.security.privateca.v1.ListCertificatesResponse>
      getListCertificatesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1.ListCertificatesRequest,
            com.google.cloud.security.privateca.v1.ListCertificatesResponse>
        getListCertificatesMethod;
    if ((getListCertificatesMethod = CertificateAuthorityServiceGrpc.getListCertificatesMethod)
        == null) {
      synchronized (CertificateAuthorityServiceGrpc.class) {
        if ((getListCertificatesMethod = CertificateAuthorityServiceGrpc.getListCertificatesMethod)
            == null) {
          CertificateAuthorityServiceGrpc.getListCertificatesMethod =
              getListCertificatesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.privateca.v1.ListCertificatesRequest,
                          com.google.cloud.security.privateca.v1.ListCertificatesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCertificates"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1.ListCertificatesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1.ListCertificatesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateAuthorityServiceMethodDescriptorSupplier(
                              "ListCertificates"))
                      .build();
        }
      }
    }
    return getListCertificatesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.RevokeCertificateRequest,
          com.google.cloud.security.privateca.v1.Certificate>
      getRevokeCertificateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RevokeCertificate",
      requestType = com.google.cloud.security.privateca.v1.RevokeCertificateRequest.class,
      responseType = com.google.cloud.security.privateca.v1.Certificate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.RevokeCertificateRequest,
          com.google.cloud.security.privateca.v1.Certificate>
      getRevokeCertificateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1.RevokeCertificateRequest,
            com.google.cloud.security.privateca.v1.Certificate>
        getRevokeCertificateMethod;
    if ((getRevokeCertificateMethod = CertificateAuthorityServiceGrpc.getRevokeCertificateMethod)
        == null) {
      synchronized (CertificateAuthorityServiceGrpc.class) {
        if ((getRevokeCertificateMethod =
                CertificateAuthorityServiceGrpc.getRevokeCertificateMethod)
            == null) {
          CertificateAuthorityServiceGrpc.getRevokeCertificateMethod =
              getRevokeCertificateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.privateca.v1.RevokeCertificateRequest,
                          com.google.cloud.security.privateca.v1.Certificate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RevokeCertificate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1.RevokeCertificateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1.Certificate
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateAuthorityServiceMethodDescriptorSupplier(
                              "RevokeCertificate"))
                      .build();
        }
      }
    }
    return getRevokeCertificateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.UpdateCertificateRequest,
          com.google.cloud.security.privateca.v1.Certificate>
      getUpdateCertificateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCertificate",
      requestType = com.google.cloud.security.privateca.v1.UpdateCertificateRequest.class,
      responseType = com.google.cloud.security.privateca.v1.Certificate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.UpdateCertificateRequest,
          com.google.cloud.security.privateca.v1.Certificate>
      getUpdateCertificateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1.UpdateCertificateRequest,
            com.google.cloud.security.privateca.v1.Certificate>
        getUpdateCertificateMethod;
    if ((getUpdateCertificateMethod = CertificateAuthorityServiceGrpc.getUpdateCertificateMethod)
        == null) {
      synchronized (CertificateAuthorityServiceGrpc.class) {
        if ((getUpdateCertificateMethod =
                CertificateAuthorityServiceGrpc.getUpdateCertificateMethod)
            == null) {
          CertificateAuthorityServiceGrpc.getUpdateCertificateMethod =
              getUpdateCertificateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.privateca.v1.UpdateCertificateRequest,
                          com.google.cloud.security.privateca.v1.Certificate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCertificate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1.UpdateCertificateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1.Certificate
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateAuthorityServiceMethodDescriptorSupplier(
                              "UpdateCertificate"))
                      .build();
        }
      }
    }
    return getUpdateCertificateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.ActivateCertificateAuthorityRequest,
          com.google.longrunning.Operation>
      getActivateCertificateAuthorityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ActivateCertificateAuthority",
      requestType =
          com.google.cloud.security.privateca.v1.ActivateCertificateAuthorityRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.ActivateCertificateAuthorityRequest,
          com.google.longrunning.Operation>
      getActivateCertificateAuthorityMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1.ActivateCertificateAuthorityRequest,
            com.google.longrunning.Operation>
        getActivateCertificateAuthorityMethod;
    if ((getActivateCertificateAuthorityMethod =
            CertificateAuthorityServiceGrpc.getActivateCertificateAuthorityMethod)
        == null) {
      synchronized (CertificateAuthorityServiceGrpc.class) {
        if ((getActivateCertificateAuthorityMethod =
                CertificateAuthorityServiceGrpc.getActivateCertificateAuthorityMethod)
            == null) {
          CertificateAuthorityServiceGrpc.getActivateCertificateAuthorityMethod =
              getActivateCertificateAuthorityMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.privateca.v1.ActivateCertificateAuthorityRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ActivateCertificateAuthority"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1
                                  .ActivateCertificateAuthorityRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateAuthorityServiceMethodDescriptorSupplier(
                              "ActivateCertificateAuthority"))
                      .build();
        }
      }
    }
    return getActivateCertificateAuthorityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.CreateCertificateAuthorityRequest,
          com.google.longrunning.Operation>
      getCreateCertificateAuthorityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCertificateAuthority",
      requestType = com.google.cloud.security.privateca.v1.CreateCertificateAuthorityRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.CreateCertificateAuthorityRequest,
          com.google.longrunning.Operation>
      getCreateCertificateAuthorityMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1.CreateCertificateAuthorityRequest,
            com.google.longrunning.Operation>
        getCreateCertificateAuthorityMethod;
    if ((getCreateCertificateAuthorityMethod =
            CertificateAuthorityServiceGrpc.getCreateCertificateAuthorityMethod)
        == null) {
      synchronized (CertificateAuthorityServiceGrpc.class) {
        if ((getCreateCertificateAuthorityMethod =
                CertificateAuthorityServiceGrpc.getCreateCertificateAuthorityMethod)
            == null) {
          CertificateAuthorityServiceGrpc.getCreateCertificateAuthorityMethod =
              getCreateCertificateAuthorityMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.privateca.v1.CreateCertificateAuthorityRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateCertificateAuthority"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1
                                  .CreateCertificateAuthorityRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateAuthorityServiceMethodDescriptorSupplier(
                              "CreateCertificateAuthority"))
                      .build();
        }
      }
    }
    return getCreateCertificateAuthorityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.DisableCertificateAuthorityRequest,
          com.google.longrunning.Operation>
      getDisableCertificateAuthorityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DisableCertificateAuthority",
      requestType = com.google.cloud.security.privateca.v1.DisableCertificateAuthorityRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.DisableCertificateAuthorityRequest,
          com.google.longrunning.Operation>
      getDisableCertificateAuthorityMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1.DisableCertificateAuthorityRequest,
            com.google.longrunning.Operation>
        getDisableCertificateAuthorityMethod;
    if ((getDisableCertificateAuthorityMethod =
            CertificateAuthorityServiceGrpc.getDisableCertificateAuthorityMethod)
        == null) {
      synchronized (CertificateAuthorityServiceGrpc.class) {
        if ((getDisableCertificateAuthorityMethod =
                CertificateAuthorityServiceGrpc.getDisableCertificateAuthorityMethod)
            == null) {
          CertificateAuthorityServiceGrpc.getDisableCertificateAuthorityMethod =
              getDisableCertificateAuthorityMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.privateca.v1.DisableCertificateAuthorityRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DisableCertificateAuthority"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1
                                  .DisableCertificateAuthorityRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateAuthorityServiceMethodDescriptorSupplier(
                              "DisableCertificateAuthority"))
                      .build();
        }
      }
    }
    return getDisableCertificateAuthorityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.EnableCertificateAuthorityRequest,
          com.google.longrunning.Operation>
      getEnableCertificateAuthorityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EnableCertificateAuthority",
      requestType = com.google.cloud.security.privateca.v1.EnableCertificateAuthorityRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.EnableCertificateAuthorityRequest,
          com.google.longrunning.Operation>
      getEnableCertificateAuthorityMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1.EnableCertificateAuthorityRequest,
            com.google.longrunning.Operation>
        getEnableCertificateAuthorityMethod;
    if ((getEnableCertificateAuthorityMethod =
            CertificateAuthorityServiceGrpc.getEnableCertificateAuthorityMethod)
        == null) {
      synchronized (CertificateAuthorityServiceGrpc.class) {
        if ((getEnableCertificateAuthorityMethod =
                CertificateAuthorityServiceGrpc.getEnableCertificateAuthorityMethod)
            == null) {
          CertificateAuthorityServiceGrpc.getEnableCertificateAuthorityMethod =
              getEnableCertificateAuthorityMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.privateca.v1.EnableCertificateAuthorityRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "EnableCertificateAuthority"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1
                                  .EnableCertificateAuthorityRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateAuthorityServiceMethodDescriptorSupplier(
                              "EnableCertificateAuthority"))
                      .build();
        }
      }
    }
    return getEnableCertificateAuthorityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.FetchCertificateAuthorityCsrRequest,
          com.google.cloud.security.privateca.v1.FetchCertificateAuthorityCsrResponse>
      getFetchCertificateAuthorityCsrMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchCertificateAuthorityCsr",
      requestType =
          com.google.cloud.security.privateca.v1.FetchCertificateAuthorityCsrRequest.class,
      responseType =
          com.google.cloud.security.privateca.v1.FetchCertificateAuthorityCsrResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.FetchCertificateAuthorityCsrRequest,
          com.google.cloud.security.privateca.v1.FetchCertificateAuthorityCsrResponse>
      getFetchCertificateAuthorityCsrMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1.FetchCertificateAuthorityCsrRequest,
            com.google.cloud.security.privateca.v1.FetchCertificateAuthorityCsrResponse>
        getFetchCertificateAuthorityCsrMethod;
    if ((getFetchCertificateAuthorityCsrMethod =
            CertificateAuthorityServiceGrpc.getFetchCertificateAuthorityCsrMethod)
        == null) {
      synchronized (CertificateAuthorityServiceGrpc.class) {
        if ((getFetchCertificateAuthorityCsrMethod =
                CertificateAuthorityServiceGrpc.getFetchCertificateAuthorityCsrMethod)
            == null) {
          CertificateAuthorityServiceGrpc.getFetchCertificateAuthorityCsrMethod =
              getFetchCertificateAuthorityCsrMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.privateca.v1.FetchCertificateAuthorityCsrRequest,
                          com.google.cloud.security.privateca.v1
                              .FetchCertificateAuthorityCsrResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "FetchCertificateAuthorityCsr"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1
                                  .FetchCertificateAuthorityCsrRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1
                                  .FetchCertificateAuthorityCsrResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateAuthorityServiceMethodDescriptorSupplier(
                              "FetchCertificateAuthorityCsr"))
                      .build();
        }
      }
    }
    return getFetchCertificateAuthorityCsrMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.GetCertificateAuthorityRequest,
          com.google.cloud.security.privateca.v1.CertificateAuthority>
      getGetCertificateAuthorityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCertificateAuthority",
      requestType = com.google.cloud.security.privateca.v1.GetCertificateAuthorityRequest.class,
      responseType = com.google.cloud.security.privateca.v1.CertificateAuthority.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.GetCertificateAuthorityRequest,
          com.google.cloud.security.privateca.v1.CertificateAuthority>
      getGetCertificateAuthorityMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1.GetCertificateAuthorityRequest,
            com.google.cloud.security.privateca.v1.CertificateAuthority>
        getGetCertificateAuthorityMethod;
    if ((getGetCertificateAuthorityMethod =
            CertificateAuthorityServiceGrpc.getGetCertificateAuthorityMethod)
        == null) {
      synchronized (CertificateAuthorityServiceGrpc.class) {
        if ((getGetCertificateAuthorityMethod =
                CertificateAuthorityServiceGrpc.getGetCertificateAuthorityMethod)
            == null) {
          CertificateAuthorityServiceGrpc.getGetCertificateAuthorityMethod =
              getGetCertificateAuthorityMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.privateca.v1.GetCertificateAuthorityRequest,
                          com.google.cloud.security.privateca.v1.CertificateAuthority>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetCertificateAuthority"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1.GetCertificateAuthorityRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1.CertificateAuthority
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateAuthorityServiceMethodDescriptorSupplier(
                              "GetCertificateAuthority"))
                      .build();
        }
      }
    }
    return getGetCertificateAuthorityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.ListCertificateAuthoritiesRequest,
          com.google.cloud.security.privateca.v1.ListCertificateAuthoritiesResponse>
      getListCertificateAuthoritiesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCertificateAuthorities",
      requestType = com.google.cloud.security.privateca.v1.ListCertificateAuthoritiesRequest.class,
      responseType =
          com.google.cloud.security.privateca.v1.ListCertificateAuthoritiesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.ListCertificateAuthoritiesRequest,
          com.google.cloud.security.privateca.v1.ListCertificateAuthoritiesResponse>
      getListCertificateAuthoritiesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1.ListCertificateAuthoritiesRequest,
            com.google.cloud.security.privateca.v1.ListCertificateAuthoritiesResponse>
        getListCertificateAuthoritiesMethod;
    if ((getListCertificateAuthoritiesMethod =
            CertificateAuthorityServiceGrpc.getListCertificateAuthoritiesMethod)
        == null) {
      synchronized (CertificateAuthorityServiceGrpc.class) {
        if ((getListCertificateAuthoritiesMethod =
                CertificateAuthorityServiceGrpc.getListCertificateAuthoritiesMethod)
            == null) {
          CertificateAuthorityServiceGrpc.getListCertificateAuthoritiesMethod =
              getListCertificateAuthoritiesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.privateca.v1.ListCertificateAuthoritiesRequest,
                          com.google.cloud.security.privateca.v1.ListCertificateAuthoritiesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListCertificateAuthorities"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1
                                  .ListCertificateAuthoritiesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1
                                  .ListCertificateAuthoritiesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateAuthorityServiceMethodDescriptorSupplier(
                              "ListCertificateAuthorities"))
                      .build();
        }
      }
    }
    return getListCertificateAuthoritiesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.UndeleteCertificateAuthorityRequest,
          com.google.longrunning.Operation>
      getUndeleteCertificateAuthorityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UndeleteCertificateAuthority",
      requestType =
          com.google.cloud.security.privateca.v1.UndeleteCertificateAuthorityRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.UndeleteCertificateAuthorityRequest,
          com.google.longrunning.Operation>
      getUndeleteCertificateAuthorityMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1.UndeleteCertificateAuthorityRequest,
            com.google.longrunning.Operation>
        getUndeleteCertificateAuthorityMethod;
    if ((getUndeleteCertificateAuthorityMethod =
            CertificateAuthorityServiceGrpc.getUndeleteCertificateAuthorityMethod)
        == null) {
      synchronized (CertificateAuthorityServiceGrpc.class) {
        if ((getUndeleteCertificateAuthorityMethod =
                CertificateAuthorityServiceGrpc.getUndeleteCertificateAuthorityMethod)
            == null) {
          CertificateAuthorityServiceGrpc.getUndeleteCertificateAuthorityMethod =
              getUndeleteCertificateAuthorityMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.privateca.v1.UndeleteCertificateAuthorityRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UndeleteCertificateAuthority"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1
                                  .UndeleteCertificateAuthorityRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateAuthorityServiceMethodDescriptorSupplier(
                              "UndeleteCertificateAuthority"))
                      .build();
        }
      }
    }
    return getUndeleteCertificateAuthorityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.DeleteCertificateAuthorityRequest,
          com.google.longrunning.Operation>
      getDeleteCertificateAuthorityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCertificateAuthority",
      requestType = com.google.cloud.security.privateca.v1.DeleteCertificateAuthorityRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.DeleteCertificateAuthorityRequest,
          com.google.longrunning.Operation>
      getDeleteCertificateAuthorityMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1.DeleteCertificateAuthorityRequest,
            com.google.longrunning.Operation>
        getDeleteCertificateAuthorityMethod;
    if ((getDeleteCertificateAuthorityMethod =
            CertificateAuthorityServiceGrpc.getDeleteCertificateAuthorityMethod)
        == null) {
      synchronized (CertificateAuthorityServiceGrpc.class) {
        if ((getDeleteCertificateAuthorityMethod =
                CertificateAuthorityServiceGrpc.getDeleteCertificateAuthorityMethod)
            == null) {
          CertificateAuthorityServiceGrpc.getDeleteCertificateAuthorityMethod =
              getDeleteCertificateAuthorityMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.privateca.v1.DeleteCertificateAuthorityRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteCertificateAuthority"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1
                                  .DeleteCertificateAuthorityRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateAuthorityServiceMethodDescriptorSupplier(
                              "DeleteCertificateAuthority"))
                      .build();
        }
      }
    }
    return getDeleteCertificateAuthorityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.UpdateCertificateAuthorityRequest,
          com.google.longrunning.Operation>
      getUpdateCertificateAuthorityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCertificateAuthority",
      requestType = com.google.cloud.security.privateca.v1.UpdateCertificateAuthorityRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.UpdateCertificateAuthorityRequest,
          com.google.longrunning.Operation>
      getUpdateCertificateAuthorityMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1.UpdateCertificateAuthorityRequest,
            com.google.longrunning.Operation>
        getUpdateCertificateAuthorityMethod;
    if ((getUpdateCertificateAuthorityMethod =
            CertificateAuthorityServiceGrpc.getUpdateCertificateAuthorityMethod)
        == null) {
      synchronized (CertificateAuthorityServiceGrpc.class) {
        if ((getUpdateCertificateAuthorityMethod =
                CertificateAuthorityServiceGrpc.getUpdateCertificateAuthorityMethod)
            == null) {
          CertificateAuthorityServiceGrpc.getUpdateCertificateAuthorityMethod =
              getUpdateCertificateAuthorityMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.privateca.v1.UpdateCertificateAuthorityRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateCertificateAuthority"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1
                                  .UpdateCertificateAuthorityRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateAuthorityServiceMethodDescriptorSupplier(
                              "UpdateCertificateAuthority"))
                      .build();
        }
      }
    }
    return getUpdateCertificateAuthorityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.CreateCaPoolRequest,
          com.google.longrunning.Operation>
      getCreateCaPoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCaPool",
      requestType = com.google.cloud.security.privateca.v1.CreateCaPoolRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.CreateCaPoolRequest,
          com.google.longrunning.Operation>
      getCreateCaPoolMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1.CreateCaPoolRequest,
            com.google.longrunning.Operation>
        getCreateCaPoolMethod;
    if ((getCreateCaPoolMethod = CertificateAuthorityServiceGrpc.getCreateCaPoolMethod) == null) {
      synchronized (CertificateAuthorityServiceGrpc.class) {
        if ((getCreateCaPoolMethod = CertificateAuthorityServiceGrpc.getCreateCaPoolMethod)
            == null) {
          CertificateAuthorityServiceGrpc.getCreateCaPoolMethod =
              getCreateCaPoolMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.privateca.v1.CreateCaPoolRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCaPool"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1.CreateCaPoolRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateAuthorityServiceMethodDescriptorSupplier("CreateCaPool"))
                      .build();
        }
      }
    }
    return getCreateCaPoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.UpdateCaPoolRequest,
          com.google.longrunning.Operation>
      getUpdateCaPoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCaPool",
      requestType = com.google.cloud.security.privateca.v1.UpdateCaPoolRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.UpdateCaPoolRequest,
          com.google.longrunning.Operation>
      getUpdateCaPoolMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1.UpdateCaPoolRequest,
            com.google.longrunning.Operation>
        getUpdateCaPoolMethod;
    if ((getUpdateCaPoolMethod = CertificateAuthorityServiceGrpc.getUpdateCaPoolMethod) == null) {
      synchronized (CertificateAuthorityServiceGrpc.class) {
        if ((getUpdateCaPoolMethod = CertificateAuthorityServiceGrpc.getUpdateCaPoolMethod)
            == null) {
          CertificateAuthorityServiceGrpc.getUpdateCaPoolMethod =
              getUpdateCaPoolMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.privateca.v1.UpdateCaPoolRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCaPool"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1.UpdateCaPoolRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateAuthorityServiceMethodDescriptorSupplier("UpdateCaPool"))
                      .build();
        }
      }
    }
    return getUpdateCaPoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.GetCaPoolRequest,
          com.google.cloud.security.privateca.v1.CaPool>
      getGetCaPoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCaPool",
      requestType = com.google.cloud.security.privateca.v1.GetCaPoolRequest.class,
      responseType = com.google.cloud.security.privateca.v1.CaPool.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.GetCaPoolRequest,
          com.google.cloud.security.privateca.v1.CaPool>
      getGetCaPoolMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1.GetCaPoolRequest,
            com.google.cloud.security.privateca.v1.CaPool>
        getGetCaPoolMethod;
    if ((getGetCaPoolMethod = CertificateAuthorityServiceGrpc.getGetCaPoolMethod) == null) {
      synchronized (CertificateAuthorityServiceGrpc.class) {
        if ((getGetCaPoolMethod = CertificateAuthorityServiceGrpc.getGetCaPoolMethod) == null) {
          CertificateAuthorityServiceGrpc.getGetCaPoolMethod =
              getGetCaPoolMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.privateca.v1.GetCaPoolRequest,
                          com.google.cloud.security.privateca.v1.CaPool>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCaPool"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1.GetCaPoolRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1.CaPool.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateAuthorityServiceMethodDescriptorSupplier("GetCaPool"))
                      .build();
        }
      }
    }
    return getGetCaPoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.ListCaPoolsRequest,
          com.google.cloud.security.privateca.v1.ListCaPoolsResponse>
      getListCaPoolsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCaPools",
      requestType = com.google.cloud.security.privateca.v1.ListCaPoolsRequest.class,
      responseType = com.google.cloud.security.privateca.v1.ListCaPoolsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.ListCaPoolsRequest,
          com.google.cloud.security.privateca.v1.ListCaPoolsResponse>
      getListCaPoolsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1.ListCaPoolsRequest,
            com.google.cloud.security.privateca.v1.ListCaPoolsResponse>
        getListCaPoolsMethod;
    if ((getListCaPoolsMethod = CertificateAuthorityServiceGrpc.getListCaPoolsMethod) == null) {
      synchronized (CertificateAuthorityServiceGrpc.class) {
        if ((getListCaPoolsMethod = CertificateAuthorityServiceGrpc.getListCaPoolsMethod) == null) {
          CertificateAuthorityServiceGrpc.getListCaPoolsMethod =
              getListCaPoolsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.privateca.v1.ListCaPoolsRequest,
                          com.google.cloud.security.privateca.v1.ListCaPoolsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCaPools"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1.ListCaPoolsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1.ListCaPoolsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateAuthorityServiceMethodDescriptorSupplier("ListCaPools"))
                      .build();
        }
      }
    }
    return getListCaPoolsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.DeleteCaPoolRequest,
          com.google.longrunning.Operation>
      getDeleteCaPoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCaPool",
      requestType = com.google.cloud.security.privateca.v1.DeleteCaPoolRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.DeleteCaPoolRequest,
          com.google.longrunning.Operation>
      getDeleteCaPoolMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1.DeleteCaPoolRequest,
            com.google.longrunning.Operation>
        getDeleteCaPoolMethod;
    if ((getDeleteCaPoolMethod = CertificateAuthorityServiceGrpc.getDeleteCaPoolMethod) == null) {
      synchronized (CertificateAuthorityServiceGrpc.class) {
        if ((getDeleteCaPoolMethod = CertificateAuthorityServiceGrpc.getDeleteCaPoolMethod)
            == null) {
          CertificateAuthorityServiceGrpc.getDeleteCaPoolMethod =
              getDeleteCaPoolMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.privateca.v1.DeleteCaPoolRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCaPool"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1.DeleteCaPoolRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateAuthorityServiceMethodDescriptorSupplier("DeleteCaPool"))
                      .build();
        }
      }
    }
    return getDeleteCaPoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.FetchCaCertsRequest,
          com.google.cloud.security.privateca.v1.FetchCaCertsResponse>
      getFetchCaCertsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchCaCerts",
      requestType = com.google.cloud.security.privateca.v1.FetchCaCertsRequest.class,
      responseType = com.google.cloud.security.privateca.v1.FetchCaCertsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.FetchCaCertsRequest,
          com.google.cloud.security.privateca.v1.FetchCaCertsResponse>
      getFetchCaCertsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1.FetchCaCertsRequest,
            com.google.cloud.security.privateca.v1.FetchCaCertsResponse>
        getFetchCaCertsMethod;
    if ((getFetchCaCertsMethod = CertificateAuthorityServiceGrpc.getFetchCaCertsMethod) == null) {
      synchronized (CertificateAuthorityServiceGrpc.class) {
        if ((getFetchCaCertsMethod = CertificateAuthorityServiceGrpc.getFetchCaCertsMethod)
            == null) {
          CertificateAuthorityServiceGrpc.getFetchCaCertsMethod =
              getFetchCaCertsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.privateca.v1.FetchCaCertsRequest,
                          com.google.cloud.security.privateca.v1.FetchCaCertsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FetchCaCerts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1.FetchCaCertsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1.FetchCaCertsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateAuthorityServiceMethodDescriptorSupplier("FetchCaCerts"))
                      .build();
        }
      }
    }
    return getFetchCaCertsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.GetCertificateRevocationListRequest,
          com.google.cloud.security.privateca.v1.CertificateRevocationList>
      getGetCertificateRevocationListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCertificateRevocationList",
      requestType =
          com.google.cloud.security.privateca.v1.GetCertificateRevocationListRequest.class,
      responseType = com.google.cloud.security.privateca.v1.CertificateRevocationList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.GetCertificateRevocationListRequest,
          com.google.cloud.security.privateca.v1.CertificateRevocationList>
      getGetCertificateRevocationListMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1.GetCertificateRevocationListRequest,
            com.google.cloud.security.privateca.v1.CertificateRevocationList>
        getGetCertificateRevocationListMethod;
    if ((getGetCertificateRevocationListMethod =
            CertificateAuthorityServiceGrpc.getGetCertificateRevocationListMethod)
        == null) {
      synchronized (CertificateAuthorityServiceGrpc.class) {
        if ((getGetCertificateRevocationListMethod =
                CertificateAuthorityServiceGrpc.getGetCertificateRevocationListMethod)
            == null) {
          CertificateAuthorityServiceGrpc.getGetCertificateRevocationListMethod =
              getGetCertificateRevocationListMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.privateca.v1.GetCertificateRevocationListRequest,
                          com.google.cloud.security.privateca.v1.CertificateRevocationList>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetCertificateRevocationList"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1
                                  .GetCertificateRevocationListRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1.CertificateRevocationList
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateAuthorityServiceMethodDescriptorSupplier(
                              "GetCertificateRevocationList"))
                      .build();
        }
      }
    }
    return getGetCertificateRevocationListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.ListCertificateRevocationListsRequest,
          com.google.cloud.security.privateca.v1.ListCertificateRevocationListsResponse>
      getListCertificateRevocationListsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCertificateRevocationLists",
      requestType =
          com.google.cloud.security.privateca.v1.ListCertificateRevocationListsRequest.class,
      responseType =
          com.google.cloud.security.privateca.v1.ListCertificateRevocationListsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.ListCertificateRevocationListsRequest,
          com.google.cloud.security.privateca.v1.ListCertificateRevocationListsResponse>
      getListCertificateRevocationListsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1.ListCertificateRevocationListsRequest,
            com.google.cloud.security.privateca.v1.ListCertificateRevocationListsResponse>
        getListCertificateRevocationListsMethod;
    if ((getListCertificateRevocationListsMethod =
            CertificateAuthorityServiceGrpc.getListCertificateRevocationListsMethod)
        == null) {
      synchronized (CertificateAuthorityServiceGrpc.class) {
        if ((getListCertificateRevocationListsMethod =
                CertificateAuthorityServiceGrpc.getListCertificateRevocationListsMethod)
            == null) {
          CertificateAuthorityServiceGrpc.getListCertificateRevocationListsMethod =
              getListCertificateRevocationListsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.privateca.v1
                              .ListCertificateRevocationListsRequest,
                          com.google.cloud.security.privateca.v1
                              .ListCertificateRevocationListsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListCertificateRevocationLists"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1
                                  .ListCertificateRevocationListsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1
                                  .ListCertificateRevocationListsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateAuthorityServiceMethodDescriptorSupplier(
                              "ListCertificateRevocationLists"))
                      .build();
        }
      }
    }
    return getListCertificateRevocationListsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.UpdateCertificateRevocationListRequest,
          com.google.longrunning.Operation>
      getUpdateCertificateRevocationListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCertificateRevocationList",
      requestType =
          com.google.cloud.security.privateca.v1.UpdateCertificateRevocationListRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.UpdateCertificateRevocationListRequest,
          com.google.longrunning.Operation>
      getUpdateCertificateRevocationListMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1.UpdateCertificateRevocationListRequest,
            com.google.longrunning.Operation>
        getUpdateCertificateRevocationListMethod;
    if ((getUpdateCertificateRevocationListMethod =
            CertificateAuthorityServiceGrpc.getUpdateCertificateRevocationListMethod)
        == null) {
      synchronized (CertificateAuthorityServiceGrpc.class) {
        if ((getUpdateCertificateRevocationListMethod =
                CertificateAuthorityServiceGrpc.getUpdateCertificateRevocationListMethod)
            == null) {
          CertificateAuthorityServiceGrpc.getUpdateCertificateRevocationListMethod =
              getUpdateCertificateRevocationListMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.privateca.v1
                              .UpdateCertificateRevocationListRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateCertificateRevocationList"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1
                                  .UpdateCertificateRevocationListRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateAuthorityServiceMethodDescriptorSupplier(
                              "UpdateCertificateRevocationList"))
                      .build();
        }
      }
    }
    return getUpdateCertificateRevocationListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.CreateCertificateTemplateRequest,
          com.google.longrunning.Operation>
      getCreateCertificateTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCertificateTemplate",
      requestType = com.google.cloud.security.privateca.v1.CreateCertificateTemplateRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.CreateCertificateTemplateRequest,
          com.google.longrunning.Operation>
      getCreateCertificateTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1.CreateCertificateTemplateRequest,
            com.google.longrunning.Operation>
        getCreateCertificateTemplateMethod;
    if ((getCreateCertificateTemplateMethod =
            CertificateAuthorityServiceGrpc.getCreateCertificateTemplateMethod)
        == null) {
      synchronized (CertificateAuthorityServiceGrpc.class) {
        if ((getCreateCertificateTemplateMethod =
                CertificateAuthorityServiceGrpc.getCreateCertificateTemplateMethod)
            == null) {
          CertificateAuthorityServiceGrpc.getCreateCertificateTemplateMethod =
              getCreateCertificateTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.privateca.v1.CreateCertificateTemplateRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateCertificateTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1
                                  .CreateCertificateTemplateRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateAuthorityServiceMethodDescriptorSupplier(
                              "CreateCertificateTemplate"))
                      .build();
        }
      }
    }
    return getCreateCertificateTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.DeleteCertificateTemplateRequest,
          com.google.longrunning.Operation>
      getDeleteCertificateTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCertificateTemplate",
      requestType = com.google.cloud.security.privateca.v1.DeleteCertificateTemplateRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.DeleteCertificateTemplateRequest,
          com.google.longrunning.Operation>
      getDeleteCertificateTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1.DeleteCertificateTemplateRequest,
            com.google.longrunning.Operation>
        getDeleteCertificateTemplateMethod;
    if ((getDeleteCertificateTemplateMethod =
            CertificateAuthorityServiceGrpc.getDeleteCertificateTemplateMethod)
        == null) {
      synchronized (CertificateAuthorityServiceGrpc.class) {
        if ((getDeleteCertificateTemplateMethod =
                CertificateAuthorityServiceGrpc.getDeleteCertificateTemplateMethod)
            == null) {
          CertificateAuthorityServiceGrpc.getDeleteCertificateTemplateMethod =
              getDeleteCertificateTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.privateca.v1.DeleteCertificateTemplateRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteCertificateTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1
                                  .DeleteCertificateTemplateRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateAuthorityServiceMethodDescriptorSupplier(
                              "DeleteCertificateTemplate"))
                      .build();
        }
      }
    }
    return getDeleteCertificateTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.GetCertificateTemplateRequest,
          com.google.cloud.security.privateca.v1.CertificateTemplate>
      getGetCertificateTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCertificateTemplate",
      requestType = com.google.cloud.security.privateca.v1.GetCertificateTemplateRequest.class,
      responseType = com.google.cloud.security.privateca.v1.CertificateTemplate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.GetCertificateTemplateRequest,
          com.google.cloud.security.privateca.v1.CertificateTemplate>
      getGetCertificateTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1.GetCertificateTemplateRequest,
            com.google.cloud.security.privateca.v1.CertificateTemplate>
        getGetCertificateTemplateMethod;
    if ((getGetCertificateTemplateMethod =
            CertificateAuthorityServiceGrpc.getGetCertificateTemplateMethod)
        == null) {
      synchronized (CertificateAuthorityServiceGrpc.class) {
        if ((getGetCertificateTemplateMethod =
                CertificateAuthorityServiceGrpc.getGetCertificateTemplateMethod)
            == null) {
          CertificateAuthorityServiceGrpc.getGetCertificateTemplateMethod =
              getGetCertificateTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.privateca.v1.GetCertificateTemplateRequest,
                          com.google.cloud.security.privateca.v1.CertificateTemplate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetCertificateTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1.GetCertificateTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1.CertificateTemplate
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateAuthorityServiceMethodDescriptorSupplier(
                              "GetCertificateTemplate"))
                      .build();
        }
      }
    }
    return getGetCertificateTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.ListCertificateTemplatesRequest,
          com.google.cloud.security.privateca.v1.ListCertificateTemplatesResponse>
      getListCertificateTemplatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCertificateTemplates",
      requestType = com.google.cloud.security.privateca.v1.ListCertificateTemplatesRequest.class,
      responseType = com.google.cloud.security.privateca.v1.ListCertificateTemplatesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.ListCertificateTemplatesRequest,
          com.google.cloud.security.privateca.v1.ListCertificateTemplatesResponse>
      getListCertificateTemplatesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1.ListCertificateTemplatesRequest,
            com.google.cloud.security.privateca.v1.ListCertificateTemplatesResponse>
        getListCertificateTemplatesMethod;
    if ((getListCertificateTemplatesMethod =
            CertificateAuthorityServiceGrpc.getListCertificateTemplatesMethod)
        == null) {
      synchronized (CertificateAuthorityServiceGrpc.class) {
        if ((getListCertificateTemplatesMethod =
                CertificateAuthorityServiceGrpc.getListCertificateTemplatesMethod)
            == null) {
          CertificateAuthorityServiceGrpc.getListCertificateTemplatesMethod =
              getListCertificateTemplatesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.privateca.v1.ListCertificateTemplatesRequest,
                          com.google.cloud.security.privateca.v1.ListCertificateTemplatesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListCertificateTemplates"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1.ListCertificateTemplatesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1
                                  .ListCertificateTemplatesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateAuthorityServiceMethodDescriptorSupplier(
                              "ListCertificateTemplates"))
                      .build();
        }
      }
    }
    return getListCertificateTemplatesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.UpdateCertificateTemplateRequest,
          com.google.longrunning.Operation>
      getUpdateCertificateTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCertificateTemplate",
      requestType = com.google.cloud.security.privateca.v1.UpdateCertificateTemplateRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1.UpdateCertificateTemplateRequest,
          com.google.longrunning.Operation>
      getUpdateCertificateTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1.UpdateCertificateTemplateRequest,
            com.google.longrunning.Operation>
        getUpdateCertificateTemplateMethod;
    if ((getUpdateCertificateTemplateMethod =
            CertificateAuthorityServiceGrpc.getUpdateCertificateTemplateMethod)
        == null) {
      synchronized (CertificateAuthorityServiceGrpc.class) {
        if ((getUpdateCertificateTemplateMethod =
                CertificateAuthorityServiceGrpc.getUpdateCertificateTemplateMethod)
            == null) {
          CertificateAuthorityServiceGrpc.getUpdateCertificateTemplateMethod =
              getUpdateCertificateTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.privateca.v1.UpdateCertificateTemplateRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateCertificateTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1
                                  .UpdateCertificateTemplateRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateAuthorityServiceMethodDescriptorSupplier(
                              "UpdateCertificateTemplate"))
                      .build();
        }
      }
    }
    return getUpdateCertificateTemplateMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static CertificateAuthorityServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CertificateAuthorityServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CertificateAuthorityServiceStub>() {
          @java.lang.Override
          public CertificateAuthorityServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CertificateAuthorityServiceStub(channel, callOptions);
          }
        };
    return CertificateAuthorityServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CertificateAuthorityServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CertificateAuthorityServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CertificateAuthorityServiceBlockingStub>() {
          @java.lang.Override
          public CertificateAuthorityServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CertificateAuthorityServiceBlockingStub(channel, callOptions);
          }
        };
    return CertificateAuthorityServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static CertificateAuthorityServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CertificateAuthorityServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CertificateAuthorityServiceFutureStub>() {
          @java.lang.Override
          public CertificateAuthorityServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CertificateAuthorityServiceFutureStub(channel, callOptions);
          }
        };
    return CertificateAuthorityServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * [Certificate Authority Service][google.cloud.security.privateca.v1.CertificateAuthorityService] manages private
   * certificate authorities and issued certificates.
   * </pre>
   */
  public abstract static class CertificateAuthorityServiceImplBase
      implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Create a new [Certificate][google.cloud.security.privateca.v1.Certificate] in a given Project, Location from a particular
     * [CaPool][google.cloud.security.privateca.v1.CaPool].
     * </pre>
     */
    public void createCertificate(
        com.google.cloud.security.privateca.v1.CreateCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1.Certificate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateCertificateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a [Certificate][google.cloud.security.privateca.v1.Certificate].
     * </pre>
     */
    public void getCertificate(
        com.google.cloud.security.privateca.v1.GetCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1.Certificate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCertificateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists [Certificates][google.cloud.security.privateca.v1.Certificate].
     * </pre>
     */
    public void listCertificates(
        com.google.cloud.security.privateca.v1.ListCertificatesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1.ListCertificatesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCertificatesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Revoke a [Certificate][google.cloud.security.privateca.v1.Certificate].
     * </pre>
     */
    public void revokeCertificate(
        com.google.cloud.security.privateca.v1.RevokeCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1.Certificate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRevokeCertificateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a [Certificate][google.cloud.security.privateca.v1.Certificate]. Currently, the only field you can update is the
     * [labels][google.cloud.security.privateca.v1.Certificate.labels] field.
     * </pre>
     */
    public void updateCertificate(
        com.google.cloud.security.privateca.v1.UpdateCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1.Certificate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateCertificateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Activate a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] that is in state
     * [AWAITING_USER_ACTIVATION][google.cloud.security.privateca.v1.CertificateAuthority.State.AWAITING_USER_ACTIVATION]
     * and is of type [SUBORDINATE][google.cloud.security.privateca.v1.CertificateAuthority.Type.SUBORDINATE]. After
     * the parent Certificate Authority signs a certificate signing request from
     * [FetchCertificateAuthorityCsr][google.cloud.security.privateca.v1.CertificateAuthorityService.FetchCertificateAuthorityCsr], this method can complete the activation
     * process.
     * </pre>
     */
    public void activateCertificateAuthority(
        com.google.cloud.security.privateca.v1.ActivateCertificateAuthorityRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getActivateCertificateAuthorityMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] in a given Project and Location.
     * </pre>
     */
    public void createCertificateAuthority(
        com.google.cloud.security.privateca.v1.CreateCertificateAuthorityRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateCertificateAuthorityMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Disable a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
     * </pre>
     */
    public void disableCertificateAuthority(
        com.google.cloud.security.privateca.v1.DisableCertificateAuthorityRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDisableCertificateAuthorityMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Enable a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
     * </pre>
     */
    public void enableCertificateAuthority(
        com.google.cloud.security.privateca.v1.EnableCertificateAuthorityRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getEnableCertificateAuthorityMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetch a certificate signing request (CSR) from a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority]
     * that is in state
     * [AWAITING_USER_ACTIVATION][google.cloud.security.privateca.v1.CertificateAuthority.State.AWAITING_USER_ACTIVATION]
     * and is of type [SUBORDINATE][google.cloud.security.privateca.v1.CertificateAuthority.Type.SUBORDINATE]. The
     * CSR must then be signed by the desired parent Certificate Authority, which
     * could be another [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] resource, or could be an on-prem
     * certificate authority. See also [ActivateCertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthorityService.ActivateCertificateAuthority].
     * </pre>
     */
    public void fetchCertificateAuthorityCsr(
        com.google.cloud.security.privateca.v1.FetchCertificateAuthorityCsrRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.security.privateca.v1.FetchCertificateAuthorityCsrResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFetchCertificateAuthorityCsrMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
     * </pre>
     */
    public void getCertificateAuthority(
        com.google.cloud.security.privateca.v1.GetCertificateAuthorityRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1.CertificateAuthority>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCertificateAuthorityMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists [CertificateAuthorities][google.cloud.security.privateca.v1.CertificateAuthority].
     * </pre>
     */
    public void listCertificateAuthorities(
        com.google.cloud.security.privateca.v1.ListCertificateAuthoritiesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.security.privateca.v1.ListCertificateAuthoritiesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCertificateAuthoritiesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Undelete a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] that has been deleted.
     * </pre>
     */
    public void undeleteCertificateAuthority(
        com.google.cloud.security.privateca.v1.UndeleteCertificateAuthorityRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUndeleteCertificateAuthorityMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
     * </pre>
     */
    public void deleteCertificateAuthority(
        com.google.cloud.security.privateca.v1.DeleteCertificateAuthorityRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteCertificateAuthorityMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
     * </pre>
     */
    public void updateCertificateAuthority(
        com.google.cloud.security.privateca.v1.UpdateCertificateAuthorityRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateCertificateAuthorityMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a [CaPool][google.cloud.security.privateca.v1.CaPool].
     * </pre>
     */
    public void createCaPool(
        com.google.cloud.security.privateca.v1.CreateCaPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateCaPoolMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a [CaPool][google.cloud.security.privateca.v1.CaPool].
     * </pre>
     */
    public void updateCaPool(
        com.google.cloud.security.privateca.v1.UpdateCaPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateCaPoolMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a [CaPool][google.cloud.security.privateca.v1.CaPool].
     * </pre>
     */
    public void getCaPool(
        com.google.cloud.security.privateca.v1.GetCaPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1.CaPool>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCaPoolMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists [CaPools][google.cloud.security.privateca.v1.CaPool].
     * </pre>
     */
    public void listCaPools(
        com.google.cloud.security.privateca.v1.ListCaPoolsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1.ListCaPoolsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCaPoolsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a [CaPool][google.cloud.security.privateca.v1.CaPool].
     * </pre>
     */
    public void deleteCaPool(
        com.google.cloud.security.privateca.v1.DeleteCaPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteCaPoolMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * FetchCaCerts returns the current trust anchor for the [CaPool][google.cloud.security.privateca.v1.CaPool]. This will
     * include CA certificate chains for all ACTIVE [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority]
     * resources in the [CaPool][google.cloud.security.privateca.v1.CaPool].
     * </pre>
     */
    public void fetchCaCerts(
        com.google.cloud.security.privateca.v1.FetchCaCertsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1.FetchCaCertsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFetchCaCertsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a [CertificateRevocationList][google.cloud.security.privateca.v1.CertificateRevocationList].
     * </pre>
     */
    public void getCertificateRevocationList(
        com.google.cloud.security.privateca.v1.GetCertificateRevocationListRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.security.privateca.v1.CertificateRevocationList>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCertificateRevocationListMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists [CertificateRevocationLists][google.cloud.security.privateca.v1.CertificateRevocationList].
     * </pre>
     */
    public void listCertificateRevocationLists(
        com.google.cloud.security.privateca.v1.ListCertificateRevocationListsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.security.privateca.v1.ListCertificateRevocationListsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCertificateRevocationListsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a [CertificateRevocationList][google.cloud.security.privateca.v1.CertificateRevocationList].
     * </pre>
     */
    public void updateCertificateRevocationList(
        com.google.cloud.security.privateca.v1.UpdateCertificateRevocationListRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateCertificateRevocationListMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate] in a given Project and Location.
     * </pre>
     */
    public void createCertificateTemplate(
        com.google.cloud.security.privateca.v1.CreateCertificateTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateCertificateTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * DeleteCertificateTemplate deletes a [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate].
     * </pre>
     */
    public void deleteCertificateTemplate(
        com.google.cloud.security.privateca.v1.DeleteCertificateTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteCertificateTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate].
     * </pre>
     */
    public void getCertificateTemplate(
        com.google.cloud.security.privateca.v1.GetCertificateTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1.CertificateTemplate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCertificateTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists [CertificateTemplates][google.cloud.security.privateca.v1.CertificateTemplate].
     * </pre>
     */
    public void listCertificateTemplates(
        com.google.cloud.security.privateca.v1.ListCertificateTemplatesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.security.privateca.v1.ListCertificateTemplatesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCertificateTemplatesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate].
     * </pre>
     */
    public void updateCertificateTemplate(
        com.google.cloud.security.privateca.v1.UpdateCertificateTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateCertificateTemplateMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateCertificateMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1.CreateCertificateRequest,
                      com.google.cloud.security.privateca.v1.Certificate>(
                      this, METHODID_CREATE_CERTIFICATE)))
          .addMethod(
              getGetCertificateMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1.GetCertificateRequest,
                      com.google.cloud.security.privateca.v1.Certificate>(
                      this, METHODID_GET_CERTIFICATE)))
          .addMethod(
              getListCertificatesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1.ListCertificatesRequest,
                      com.google.cloud.security.privateca.v1.ListCertificatesResponse>(
                      this, METHODID_LIST_CERTIFICATES)))
          .addMethod(
              getRevokeCertificateMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1.RevokeCertificateRequest,
                      com.google.cloud.security.privateca.v1.Certificate>(
                      this, METHODID_REVOKE_CERTIFICATE)))
          .addMethod(
              getUpdateCertificateMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1.UpdateCertificateRequest,
                      com.google.cloud.security.privateca.v1.Certificate>(
                      this, METHODID_UPDATE_CERTIFICATE)))
          .addMethod(
              getActivateCertificateAuthorityMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1.ActivateCertificateAuthorityRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_ACTIVATE_CERTIFICATE_AUTHORITY)))
          .addMethod(
              getCreateCertificateAuthorityMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1.CreateCertificateAuthorityRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_CREATE_CERTIFICATE_AUTHORITY)))
          .addMethod(
              getDisableCertificateAuthorityMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1.DisableCertificateAuthorityRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_DISABLE_CERTIFICATE_AUTHORITY)))
          .addMethod(
              getEnableCertificateAuthorityMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1.EnableCertificateAuthorityRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_ENABLE_CERTIFICATE_AUTHORITY)))
          .addMethod(
              getFetchCertificateAuthorityCsrMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1.FetchCertificateAuthorityCsrRequest,
                      com.google.cloud.security.privateca.v1.FetchCertificateAuthorityCsrResponse>(
                      this, METHODID_FETCH_CERTIFICATE_AUTHORITY_CSR)))
          .addMethod(
              getGetCertificateAuthorityMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1.GetCertificateAuthorityRequest,
                      com.google.cloud.security.privateca.v1.CertificateAuthority>(
                      this, METHODID_GET_CERTIFICATE_AUTHORITY)))
          .addMethod(
              getListCertificateAuthoritiesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1.ListCertificateAuthoritiesRequest,
                      com.google.cloud.security.privateca.v1.ListCertificateAuthoritiesResponse>(
                      this, METHODID_LIST_CERTIFICATE_AUTHORITIES)))
          .addMethod(
              getUndeleteCertificateAuthorityMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1.UndeleteCertificateAuthorityRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_UNDELETE_CERTIFICATE_AUTHORITY)))
          .addMethod(
              getDeleteCertificateAuthorityMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1.DeleteCertificateAuthorityRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_DELETE_CERTIFICATE_AUTHORITY)))
          .addMethod(
              getUpdateCertificateAuthorityMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1.UpdateCertificateAuthorityRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_UPDATE_CERTIFICATE_AUTHORITY)))
          .addMethod(
              getCreateCaPoolMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1.CreateCaPoolRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_CA_POOL)))
          .addMethod(
              getUpdateCaPoolMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1.UpdateCaPoolRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_CA_POOL)))
          .addMethod(
              getGetCaPoolMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1.GetCaPoolRequest,
                      com.google.cloud.security.privateca.v1.CaPool>(this, METHODID_GET_CA_POOL)))
          .addMethod(
              getListCaPoolsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1.ListCaPoolsRequest,
                      com.google.cloud.security.privateca.v1.ListCaPoolsResponse>(
                      this, METHODID_LIST_CA_POOLS)))
          .addMethod(
              getDeleteCaPoolMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1.DeleteCaPoolRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_CA_POOL)))
          .addMethod(
              getFetchCaCertsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1.FetchCaCertsRequest,
                      com.google.cloud.security.privateca.v1.FetchCaCertsResponse>(
                      this, METHODID_FETCH_CA_CERTS)))
          .addMethod(
              getGetCertificateRevocationListMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1.GetCertificateRevocationListRequest,
                      com.google.cloud.security.privateca.v1.CertificateRevocationList>(
                      this, METHODID_GET_CERTIFICATE_REVOCATION_LIST)))
          .addMethod(
              getListCertificateRevocationListsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1.ListCertificateRevocationListsRequest,
                      com.google.cloud.security.privateca.v1
                          .ListCertificateRevocationListsResponse>(
                      this, METHODID_LIST_CERTIFICATE_REVOCATION_LISTS)))
          .addMethod(
              getUpdateCertificateRevocationListMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1.UpdateCertificateRevocationListRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_UPDATE_CERTIFICATE_REVOCATION_LIST)))
          .addMethod(
              getCreateCertificateTemplateMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1.CreateCertificateTemplateRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_CREATE_CERTIFICATE_TEMPLATE)))
          .addMethod(
              getDeleteCertificateTemplateMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1.DeleteCertificateTemplateRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_DELETE_CERTIFICATE_TEMPLATE)))
          .addMethod(
              getGetCertificateTemplateMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1.GetCertificateTemplateRequest,
                      com.google.cloud.security.privateca.v1.CertificateTemplate>(
                      this, METHODID_GET_CERTIFICATE_TEMPLATE)))
          .addMethod(
              getListCertificateTemplatesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1.ListCertificateTemplatesRequest,
                      com.google.cloud.security.privateca.v1.ListCertificateTemplatesResponse>(
                      this, METHODID_LIST_CERTIFICATE_TEMPLATES)))
          .addMethod(
              getUpdateCertificateTemplateMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1.UpdateCertificateTemplateRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_UPDATE_CERTIFICATE_TEMPLATE)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * [Certificate Authority Service][google.cloud.security.privateca.v1.CertificateAuthorityService] manages private
   * certificate authorities and issued certificates.
   * </pre>
   */
  public static final class CertificateAuthorityServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CertificateAuthorityServiceStub> {
    private CertificateAuthorityServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CertificateAuthorityServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CertificateAuthorityServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a new [Certificate][google.cloud.security.privateca.v1.Certificate] in a given Project, Location from a particular
     * [CaPool][google.cloud.security.privateca.v1.CaPool].
     * </pre>
     */
    public void createCertificate(
        com.google.cloud.security.privateca.v1.CreateCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1.Certificate>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCertificateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a [Certificate][google.cloud.security.privateca.v1.Certificate].
     * </pre>
     */
    public void getCertificate(
        com.google.cloud.security.privateca.v1.GetCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1.Certificate>
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
     * Lists [Certificates][google.cloud.security.privateca.v1.Certificate].
     * </pre>
     */
    public void listCertificates(
        com.google.cloud.security.privateca.v1.ListCertificatesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1.ListCertificatesResponse>
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
     * Revoke a [Certificate][google.cloud.security.privateca.v1.Certificate].
     * </pre>
     */
    public void revokeCertificate(
        com.google.cloud.security.privateca.v1.RevokeCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1.Certificate>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRevokeCertificateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a [Certificate][google.cloud.security.privateca.v1.Certificate]. Currently, the only field you can update is the
     * [labels][google.cloud.security.privateca.v1.Certificate.labels] field.
     * </pre>
     */
    public void updateCertificate(
        com.google.cloud.security.privateca.v1.UpdateCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1.Certificate>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCertificateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Activate a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] that is in state
     * [AWAITING_USER_ACTIVATION][google.cloud.security.privateca.v1.CertificateAuthority.State.AWAITING_USER_ACTIVATION]
     * and is of type [SUBORDINATE][google.cloud.security.privateca.v1.CertificateAuthority.Type.SUBORDINATE]. After
     * the parent Certificate Authority signs a certificate signing request from
     * [FetchCertificateAuthorityCsr][google.cloud.security.privateca.v1.CertificateAuthorityService.FetchCertificateAuthorityCsr], this method can complete the activation
     * process.
     * </pre>
     */
    public void activateCertificateAuthority(
        com.google.cloud.security.privateca.v1.ActivateCertificateAuthorityRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getActivateCertificateAuthorityMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] in a given Project and Location.
     * </pre>
     */
    public void createCertificateAuthority(
        com.google.cloud.security.privateca.v1.CreateCertificateAuthorityRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCertificateAuthorityMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Disable a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
     * </pre>
     */
    public void disableCertificateAuthority(
        com.google.cloud.security.privateca.v1.DisableCertificateAuthorityRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDisableCertificateAuthorityMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Enable a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
     * </pre>
     */
    public void enableCertificateAuthority(
        com.google.cloud.security.privateca.v1.EnableCertificateAuthorityRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEnableCertificateAuthorityMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetch a certificate signing request (CSR) from a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority]
     * that is in state
     * [AWAITING_USER_ACTIVATION][google.cloud.security.privateca.v1.CertificateAuthority.State.AWAITING_USER_ACTIVATION]
     * and is of type [SUBORDINATE][google.cloud.security.privateca.v1.CertificateAuthority.Type.SUBORDINATE]. The
     * CSR must then be signed by the desired parent Certificate Authority, which
     * could be another [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] resource, or could be an on-prem
     * certificate authority. See also [ActivateCertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthorityService.ActivateCertificateAuthority].
     * </pre>
     */
    public void fetchCertificateAuthorityCsr(
        com.google.cloud.security.privateca.v1.FetchCertificateAuthorityCsrRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.security.privateca.v1.FetchCertificateAuthorityCsrResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchCertificateAuthorityCsrMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
     * </pre>
     */
    public void getCertificateAuthority(
        com.google.cloud.security.privateca.v1.GetCertificateAuthorityRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1.CertificateAuthority>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCertificateAuthorityMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists [CertificateAuthorities][google.cloud.security.privateca.v1.CertificateAuthority].
     * </pre>
     */
    public void listCertificateAuthorities(
        com.google.cloud.security.privateca.v1.ListCertificateAuthoritiesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.security.privateca.v1.ListCertificateAuthoritiesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCertificateAuthoritiesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Undelete a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] that has been deleted.
     * </pre>
     */
    public void undeleteCertificateAuthority(
        com.google.cloud.security.privateca.v1.UndeleteCertificateAuthorityRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUndeleteCertificateAuthorityMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
     * </pre>
     */
    public void deleteCertificateAuthority(
        com.google.cloud.security.privateca.v1.DeleteCertificateAuthorityRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCertificateAuthorityMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
     * </pre>
     */
    public void updateCertificateAuthority(
        com.google.cloud.security.privateca.v1.UpdateCertificateAuthorityRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCertificateAuthorityMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a [CaPool][google.cloud.security.privateca.v1.CaPool].
     * </pre>
     */
    public void createCaPool(
        com.google.cloud.security.privateca.v1.CreateCaPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCaPoolMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a [CaPool][google.cloud.security.privateca.v1.CaPool].
     * </pre>
     */
    public void updateCaPool(
        com.google.cloud.security.privateca.v1.UpdateCaPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCaPoolMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a [CaPool][google.cloud.security.privateca.v1.CaPool].
     * </pre>
     */
    public void getCaPool(
        com.google.cloud.security.privateca.v1.GetCaPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1.CaPool>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCaPoolMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists [CaPools][google.cloud.security.privateca.v1.CaPool].
     * </pre>
     */
    public void listCaPools(
        com.google.cloud.security.privateca.v1.ListCaPoolsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1.ListCaPoolsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCaPoolsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a [CaPool][google.cloud.security.privateca.v1.CaPool].
     * </pre>
     */
    public void deleteCaPool(
        com.google.cloud.security.privateca.v1.DeleteCaPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCaPoolMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * FetchCaCerts returns the current trust anchor for the [CaPool][google.cloud.security.privateca.v1.CaPool]. This will
     * include CA certificate chains for all ACTIVE [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority]
     * resources in the [CaPool][google.cloud.security.privateca.v1.CaPool].
     * </pre>
     */
    public void fetchCaCerts(
        com.google.cloud.security.privateca.v1.FetchCaCertsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1.FetchCaCertsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchCaCertsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a [CertificateRevocationList][google.cloud.security.privateca.v1.CertificateRevocationList].
     * </pre>
     */
    public void getCertificateRevocationList(
        com.google.cloud.security.privateca.v1.GetCertificateRevocationListRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.security.privateca.v1.CertificateRevocationList>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCertificateRevocationListMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists [CertificateRevocationLists][google.cloud.security.privateca.v1.CertificateRevocationList].
     * </pre>
     */
    public void listCertificateRevocationLists(
        com.google.cloud.security.privateca.v1.ListCertificateRevocationListsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.security.privateca.v1.ListCertificateRevocationListsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCertificateRevocationListsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a [CertificateRevocationList][google.cloud.security.privateca.v1.CertificateRevocationList].
     * </pre>
     */
    public void updateCertificateRevocationList(
        com.google.cloud.security.privateca.v1.UpdateCertificateRevocationListRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCertificateRevocationListMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate] in a given Project and Location.
     * </pre>
     */
    public void createCertificateTemplate(
        com.google.cloud.security.privateca.v1.CreateCertificateTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCertificateTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * DeleteCertificateTemplate deletes a [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate].
     * </pre>
     */
    public void deleteCertificateTemplate(
        com.google.cloud.security.privateca.v1.DeleteCertificateTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCertificateTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate].
     * </pre>
     */
    public void getCertificateTemplate(
        com.google.cloud.security.privateca.v1.GetCertificateTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1.CertificateTemplate>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCertificateTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists [CertificateTemplates][google.cloud.security.privateca.v1.CertificateTemplate].
     * </pre>
     */
    public void listCertificateTemplates(
        com.google.cloud.security.privateca.v1.ListCertificateTemplatesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.security.privateca.v1.ListCertificateTemplatesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCertificateTemplatesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate].
     * </pre>
     */
    public void updateCertificateTemplate(
        com.google.cloud.security.privateca.v1.UpdateCertificateTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCertificateTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * [Certificate Authority Service][google.cloud.security.privateca.v1.CertificateAuthorityService] manages private
   * certificate authorities and issued certificates.
   * </pre>
   */
  public static final class CertificateAuthorityServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CertificateAuthorityServiceBlockingStub> {
    private CertificateAuthorityServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CertificateAuthorityServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CertificateAuthorityServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a new [Certificate][google.cloud.security.privateca.v1.Certificate] in a given Project, Location from a particular
     * [CaPool][google.cloud.security.privateca.v1.CaPool].
     * </pre>
     */
    public com.google.cloud.security.privateca.v1.Certificate createCertificate(
        com.google.cloud.security.privateca.v1.CreateCertificateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCertificateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a [Certificate][google.cloud.security.privateca.v1.Certificate].
     * </pre>
     */
    public com.google.cloud.security.privateca.v1.Certificate getCertificate(
        com.google.cloud.security.privateca.v1.GetCertificateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCertificateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists [Certificates][google.cloud.security.privateca.v1.Certificate].
     * </pre>
     */
    public com.google.cloud.security.privateca.v1.ListCertificatesResponse listCertificates(
        com.google.cloud.security.privateca.v1.ListCertificatesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCertificatesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Revoke a [Certificate][google.cloud.security.privateca.v1.Certificate].
     * </pre>
     */
    public com.google.cloud.security.privateca.v1.Certificate revokeCertificate(
        com.google.cloud.security.privateca.v1.RevokeCertificateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRevokeCertificateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a [Certificate][google.cloud.security.privateca.v1.Certificate]. Currently, the only field you can update is the
     * [labels][google.cloud.security.privateca.v1.Certificate.labels] field.
     * </pre>
     */
    public com.google.cloud.security.privateca.v1.Certificate updateCertificate(
        com.google.cloud.security.privateca.v1.UpdateCertificateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCertificateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Activate a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] that is in state
     * [AWAITING_USER_ACTIVATION][google.cloud.security.privateca.v1.CertificateAuthority.State.AWAITING_USER_ACTIVATION]
     * and is of type [SUBORDINATE][google.cloud.security.privateca.v1.CertificateAuthority.Type.SUBORDINATE]. After
     * the parent Certificate Authority signs a certificate signing request from
     * [FetchCertificateAuthorityCsr][google.cloud.security.privateca.v1.CertificateAuthorityService.FetchCertificateAuthorityCsr], this method can complete the activation
     * process.
     * </pre>
     */
    public com.google.longrunning.Operation activateCertificateAuthority(
        com.google.cloud.security.privateca.v1.ActivateCertificateAuthorityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getActivateCertificateAuthorityMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] in a given Project and Location.
     * </pre>
     */
    public com.google.longrunning.Operation createCertificateAuthority(
        com.google.cloud.security.privateca.v1.CreateCertificateAuthorityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCertificateAuthorityMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Disable a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
     * </pre>
     */
    public com.google.longrunning.Operation disableCertificateAuthority(
        com.google.cloud.security.privateca.v1.DisableCertificateAuthorityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDisableCertificateAuthorityMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Enable a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
     * </pre>
     */
    public com.google.longrunning.Operation enableCertificateAuthority(
        com.google.cloud.security.privateca.v1.EnableCertificateAuthorityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEnableCertificateAuthorityMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetch a certificate signing request (CSR) from a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority]
     * that is in state
     * [AWAITING_USER_ACTIVATION][google.cloud.security.privateca.v1.CertificateAuthority.State.AWAITING_USER_ACTIVATION]
     * and is of type [SUBORDINATE][google.cloud.security.privateca.v1.CertificateAuthority.Type.SUBORDINATE]. The
     * CSR must then be signed by the desired parent Certificate Authority, which
     * could be another [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] resource, or could be an on-prem
     * certificate authority. See also [ActivateCertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthorityService.ActivateCertificateAuthority].
     * </pre>
     */
    public com.google.cloud.security.privateca.v1.FetchCertificateAuthorityCsrResponse
        fetchCertificateAuthorityCsr(
            com.google.cloud.security.privateca.v1.FetchCertificateAuthorityCsrRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchCertificateAuthorityCsrMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
     * </pre>
     */
    public com.google.cloud.security.privateca.v1.CertificateAuthority getCertificateAuthority(
        com.google.cloud.security.privateca.v1.GetCertificateAuthorityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCertificateAuthorityMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists [CertificateAuthorities][google.cloud.security.privateca.v1.CertificateAuthority].
     * </pre>
     */
    public com.google.cloud.security.privateca.v1.ListCertificateAuthoritiesResponse
        listCertificateAuthorities(
            com.google.cloud.security.privateca.v1.ListCertificateAuthoritiesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCertificateAuthoritiesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Undelete a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] that has been deleted.
     * </pre>
     */
    public com.google.longrunning.Operation undeleteCertificateAuthority(
        com.google.cloud.security.privateca.v1.UndeleteCertificateAuthorityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUndeleteCertificateAuthorityMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
     * </pre>
     */
    public com.google.longrunning.Operation deleteCertificateAuthority(
        com.google.cloud.security.privateca.v1.DeleteCertificateAuthorityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCertificateAuthorityMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
     * </pre>
     */
    public com.google.longrunning.Operation updateCertificateAuthority(
        com.google.cloud.security.privateca.v1.UpdateCertificateAuthorityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCertificateAuthorityMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a [CaPool][google.cloud.security.privateca.v1.CaPool].
     * </pre>
     */
    public com.google.longrunning.Operation createCaPool(
        com.google.cloud.security.privateca.v1.CreateCaPoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCaPoolMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a [CaPool][google.cloud.security.privateca.v1.CaPool].
     * </pre>
     */
    public com.google.longrunning.Operation updateCaPool(
        com.google.cloud.security.privateca.v1.UpdateCaPoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCaPoolMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a [CaPool][google.cloud.security.privateca.v1.CaPool].
     * </pre>
     */
    public com.google.cloud.security.privateca.v1.CaPool getCaPool(
        com.google.cloud.security.privateca.v1.GetCaPoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCaPoolMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists [CaPools][google.cloud.security.privateca.v1.CaPool].
     * </pre>
     */
    public com.google.cloud.security.privateca.v1.ListCaPoolsResponse listCaPools(
        com.google.cloud.security.privateca.v1.ListCaPoolsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCaPoolsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a [CaPool][google.cloud.security.privateca.v1.CaPool].
     * </pre>
     */
    public com.google.longrunning.Operation deleteCaPool(
        com.google.cloud.security.privateca.v1.DeleteCaPoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCaPoolMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * FetchCaCerts returns the current trust anchor for the [CaPool][google.cloud.security.privateca.v1.CaPool]. This will
     * include CA certificate chains for all ACTIVE [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority]
     * resources in the [CaPool][google.cloud.security.privateca.v1.CaPool].
     * </pre>
     */
    public com.google.cloud.security.privateca.v1.FetchCaCertsResponse fetchCaCerts(
        com.google.cloud.security.privateca.v1.FetchCaCertsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchCaCertsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a [CertificateRevocationList][google.cloud.security.privateca.v1.CertificateRevocationList].
     * </pre>
     */
    public com.google.cloud.security.privateca.v1.CertificateRevocationList
        getCertificateRevocationList(
            com.google.cloud.security.privateca.v1.GetCertificateRevocationListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCertificateRevocationListMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists [CertificateRevocationLists][google.cloud.security.privateca.v1.CertificateRevocationList].
     * </pre>
     */
    public com.google.cloud.security.privateca.v1.ListCertificateRevocationListsResponse
        listCertificateRevocationLists(
            com.google.cloud.security.privateca.v1.ListCertificateRevocationListsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCertificateRevocationListsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a [CertificateRevocationList][google.cloud.security.privateca.v1.CertificateRevocationList].
     * </pre>
     */
    public com.google.longrunning.Operation updateCertificateRevocationList(
        com.google.cloud.security.privateca.v1.UpdateCertificateRevocationListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCertificateRevocationListMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate] in a given Project and Location.
     * </pre>
     */
    public com.google.longrunning.Operation createCertificateTemplate(
        com.google.cloud.security.privateca.v1.CreateCertificateTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCertificateTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * DeleteCertificateTemplate deletes a [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate].
     * </pre>
     */
    public com.google.longrunning.Operation deleteCertificateTemplate(
        com.google.cloud.security.privateca.v1.DeleteCertificateTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCertificateTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate].
     * </pre>
     */
    public com.google.cloud.security.privateca.v1.CertificateTemplate getCertificateTemplate(
        com.google.cloud.security.privateca.v1.GetCertificateTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCertificateTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists [CertificateTemplates][google.cloud.security.privateca.v1.CertificateTemplate].
     * </pre>
     */
    public com.google.cloud.security.privateca.v1.ListCertificateTemplatesResponse
        listCertificateTemplates(
            com.google.cloud.security.privateca.v1.ListCertificateTemplatesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCertificateTemplatesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate].
     * </pre>
     */
    public com.google.longrunning.Operation updateCertificateTemplate(
        com.google.cloud.security.privateca.v1.UpdateCertificateTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCertificateTemplateMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * [Certificate Authority Service][google.cloud.security.privateca.v1.CertificateAuthorityService] manages private
   * certificate authorities and issued certificates.
   * </pre>
   */
  public static final class CertificateAuthorityServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CertificateAuthorityServiceFutureStub> {
    private CertificateAuthorityServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CertificateAuthorityServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CertificateAuthorityServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a new [Certificate][google.cloud.security.privateca.v1.Certificate] in a given Project, Location from a particular
     * [CaPool][google.cloud.security.privateca.v1.CaPool].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.security.privateca.v1.Certificate>
        createCertificate(com.google.cloud.security.privateca.v1.CreateCertificateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCertificateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a [Certificate][google.cloud.security.privateca.v1.Certificate].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.security.privateca.v1.Certificate>
        getCertificate(com.google.cloud.security.privateca.v1.GetCertificateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCertificateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists [Certificates][google.cloud.security.privateca.v1.Certificate].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.security.privateca.v1.ListCertificatesResponse>
        listCertificates(com.google.cloud.security.privateca.v1.ListCertificatesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCertificatesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Revoke a [Certificate][google.cloud.security.privateca.v1.Certificate].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.security.privateca.v1.Certificate>
        revokeCertificate(com.google.cloud.security.privateca.v1.RevokeCertificateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRevokeCertificateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a [Certificate][google.cloud.security.privateca.v1.Certificate]. Currently, the only field you can update is the
     * [labels][google.cloud.security.privateca.v1.Certificate.labels] field.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.security.privateca.v1.Certificate>
        updateCertificate(com.google.cloud.security.privateca.v1.UpdateCertificateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCertificateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Activate a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] that is in state
     * [AWAITING_USER_ACTIVATION][google.cloud.security.privateca.v1.CertificateAuthority.State.AWAITING_USER_ACTIVATION]
     * and is of type [SUBORDINATE][google.cloud.security.privateca.v1.CertificateAuthority.Type.SUBORDINATE]. After
     * the parent Certificate Authority signs a certificate signing request from
     * [FetchCertificateAuthorityCsr][google.cloud.security.privateca.v1.CertificateAuthorityService.FetchCertificateAuthorityCsr], this method can complete the activation
     * process.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        activateCertificateAuthority(
            com.google.cloud.security.privateca.v1.ActivateCertificateAuthorityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getActivateCertificateAuthorityMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] in a given Project and Location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createCertificateAuthority(
            com.google.cloud.security.privateca.v1.CreateCertificateAuthorityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCertificateAuthorityMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Disable a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        disableCertificateAuthority(
            com.google.cloud.security.privateca.v1.DisableCertificateAuthorityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDisableCertificateAuthorityMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Enable a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        enableCertificateAuthority(
            com.google.cloud.security.privateca.v1.EnableCertificateAuthorityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEnableCertificateAuthorityMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Fetch a certificate signing request (CSR) from a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority]
     * that is in state
     * [AWAITING_USER_ACTIVATION][google.cloud.security.privateca.v1.CertificateAuthority.State.AWAITING_USER_ACTIVATION]
     * and is of type [SUBORDINATE][google.cloud.security.privateca.v1.CertificateAuthority.Type.SUBORDINATE]. The
     * CSR must then be signed by the desired parent Certificate Authority, which
     * could be another [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] resource, or could be an on-prem
     * certificate authority. See also [ActivateCertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthorityService.ActivateCertificateAuthority].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.security.privateca.v1.FetchCertificateAuthorityCsrResponse>
        fetchCertificateAuthorityCsr(
            com.google.cloud.security.privateca.v1.FetchCertificateAuthorityCsrRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchCertificateAuthorityCsrMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.security.privateca.v1.CertificateAuthority>
        getCertificateAuthority(
            com.google.cloud.security.privateca.v1.GetCertificateAuthorityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCertificateAuthorityMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists [CertificateAuthorities][google.cloud.security.privateca.v1.CertificateAuthority].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.security.privateca.v1.ListCertificateAuthoritiesResponse>
        listCertificateAuthorities(
            com.google.cloud.security.privateca.v1.ListCertificateAuthoritiesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCertificateAuthoritiesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Undelete a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority] that has been deleted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        undeleteCertificateAuthority(
            com.google.cloud.security.privateca.v1.UndeleteCertificateAuthorityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUndeleteCertificateAuthorityMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteCertificateAuthority(
            com.google.cloud.security.privateca.v1.DeleteCertificateAuthorityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCertificateAuthorityMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateCertificateAuthority(
            com.google.cloud.security.privateca.v1.UpdateCertificateAuthorityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCertificateAuthorityMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a [CaPool][google.cloud.security.privateca.v1.CaPool].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createCaPool(com.google.cloud.security.privateca.v1.CreateCaPoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCaPoolMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a [CaPool][google.cloud.security.privateca.v1.CaPool].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateCaPool(com.google.cloud.security.privateca.v1.UpdateCaPoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCaPoolMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a [CaPool][google.cloud.security.privateca.v1.CaPool].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.security.privateca.v1.CaPool>
        getCaPool(com.google.cloud.security.privateca.v1.GetCaPoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCaPoolMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists [CaPools][google.cloud.security.privateca.v1.CaPool].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.security.privateca.v1.ListCaPoolsResponse>
        listCaPools(com.google.cloud.security.privateca.v1.ListCaPoolsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCaPoolsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a [CaPool][google.cloud.security.privateca.v1.CaPool].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteCaPool(com.google.cloud.security.privateca.v1.DeleteCaPoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCaPoolMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * FetchCaCerts returns the current trust anchor for the [CaPool][google.cloud.security.privateca.v1.CaPool]. This will
     * include CA certificate chains for all ACTIVE [CertificateAuthority][google.cloud.security.privateca.v1.CertificateAuthority]
     * resources in the [CaPool][google.cloud.security.privateca.v1.CaPool].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.security.privateca.v1.FetchCaCertsResponse>
        fetchCaCerts(com.google.cloud.security.privateca.v1.FetchCaCertsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchCaCertsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a [CertificateRevocationList][google.cloud.security.privateca.v1.CertificateRevocationList].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.security.privateca.v1.CertificateRevocationList>
        getCertificateRevocationList(
            com.google.cloud.security.privateca.v1.GetCertificateRevocationListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCertificateRevocationListMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists [CertificateRevocationLists][google.cloud.security.privateca.v1.CertificateRevocationList].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.security.privateca.v1.ListCertificateRevocationListsResponse>
        listCertificateRevocationLists(
            com.google.cloud.security.privateca.v1.ListCertificateRevocationListsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCertificateRevocationListsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Update a [CertificateRevocationList][google.cloud.security.privateca.v1.CertificateRevocationList].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateCertificateRevocationList(
            com.google.cloud.security.privateca.v1.UpdateCertificateRevocationListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCertificateRevocationListMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Create a new [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate] in a given Project and Location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createCertificateTemplate(
            com.google.cloud.security.privateca.v1.CreateCertificateTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCertificateTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * DeleteCertificateTemplate deletes a [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteCertificateTemplate(
            com.google.cloud.security.privateca.v1.DeleteCertificateTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCertificateTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.security.privateca.v1.CertificateTemplate>
        getCertificateTemplate(
            com.google.cloud.security.privateca.v1.GetCertificateTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCertificateTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists [CertificateTemplates][google.cloud.security.privateca.v1.CertificateTemplate].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.security.privateca.v1.ListCertificateTemplatesResponse>
        listCertificateTemplates(
            com.google.cloud.security.privateca.v1.ListCertificateTemplatesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCertificateTemplatesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a [CertificateTemplate][google.cloud.security.privateca.v1.CertificateTemplate].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateCertificateTemplate(
            com.google.cloud.security.privateca.v1.UpdateCertificateTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCertificateTemplateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_CERTIFICATE = 0;
  private static final int METHODID_GET_CERTIFICATE = 1;
  private static final int METHODID_LIST_CERTIFICATES = 2;
  private static final int METHODID_REVOKE_CERTIFICATE = 3;
  private static final int METHODID_UPDATE_CERTIFICATE = 4;
  private static final int METHODID_ACTIVATE_CERTIFICATE_AUTHORITY = 5;
  private static final int METHODID_CREATE_CERTIFICATE_AUTHORITY = 6;
  private static final int METHODID_DISABLE_CERTIFICATE_AUTHORITY = 7;
  private static final int METHODID_ENABLE_CERTIFICATE_AUTHORITY = 8;
  private static final int METHODID_FETCH_CERTIFICATE_AUTHORITY_CSR = 9;
  private static final int METHODID_GET_CERTIFICATE_AUTHORITY = 10;
  private static final int METHODID_LIST_CERTIFICATE_AUTHORITIES = 11;
  private static final int METHODID_UNDELETE_CERTIFICATE_AUTHORITY = 12;
  private static final int METHODID_DELETE_CERTIFICATE_AUTHORITY = 13;
  private static final int METHODID_UPDATE_CERTIFICATE_AUTHORITY = 14;
  private static final int METHODID_CREATE_CA_POOL = 15;
  private static final int METHODID_UPDATE_CA_POOL = 16;
  private static final int METHODID_GET_CA_POOL = 17;
  private static final int METHODID_LIST_CA_POOLS = 18;
  private static final int METHODID_DELETE_CA_POOL = 19;
  private static final int METHODID_FETCH_CA_CERTS = 20;
  private static final int METHODID_GET_CERTIFICATE_REVOCATION_LIST = 21;
  private static final int METHODID_LIST_CERTIFICATE_REVOCATION_LISTS = 22;
  private static final int METHODID_UPDATE_CERTIFICATE_REVOCATION_LIST = 23;
  private static final int METHODID_CREATE_CERTIFICATE_TEMPLATE = 24;
  private static final int METHODID_DELETE_CERTIFICATE_TEMPLATE = 25;
  private static final int METHODID_GET_CERTIFICATE_TEMPLATE = 26;
  private static final int METHODID_LIST_CERTIFICATE_TEMPLATES = 27;
  private static final int METHODID_UPDATE_CERTIFICATE_TEMPLATE = 28;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CertificateAuthorityServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CertificateAuthorityServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_CERTIFICATE:
          serviceImpl.createCertificate(
              (com.google.cloud.security.privateca.v1.CreateCertificateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1.Certificate>)
                  responseObserver);
          break;
        case METHODID_GET_CERTIFICATE:
          serviceImpl.getCertificate(
              (com.google.cloud.security.privateca.v1.GetCertificateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1.Certificate>)
                  responseObserver);
          break;
        case METHODID_LIST_CERTIFICATES:
          serviceImpl.listCertificates(
              (com.google.cloud.security.privateca.v1.ListCertificatesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.security.privateca.v1.ListCertificatesResponse>)
                  responseObserver);
          break;
        case METHODID_REVOKE_CERTIFICATE:
          serviceImpl.revokeCertificate(
              (com.google.cloud.security.privateca.v1.RevokeCertificateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1.Certificate>)
                  responseObserver);
          break;
        case METHODID_UPDATE_CERTIFICATE:
          serviceImpl.updateCertificate(
              (com.google.cloud.security.privateca.v1.UpdateCertificateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1.Certificate>)
                  responseObserver);
          break;
        case METHODID_ACTIVATE_CERTIFICATE_AUTHORITY:
          serviceImpl.activateCertificateAuthority(
              (com.google.cloud.security.privateca.v1.ActivateCertificateAuthorityRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_CERTIFICATE_AUTHORITY:
          serviceImpl.createCertificateAuthority(
              (com.google.cloud.security.privateca.v1.CreateCertificateAuthorityRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DISABLE_CERTIFICATE_AUTHORITY:
          serviceImpl.disableCertificateAuthority(
              (com.google.cloud.security.privateca.v1.DisableCertificateAuthorityRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_ENABLE_CERTIFICATE_AUTHORITY:
          serviceImpl.enableCertificateAuthority(
              (com.google.cloud.security.privateca.v1.EnableCertificateAuthorityRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_FETCH_CERTIFICATE_AUTHORITY_CSR:
          serviceImpl.fetchCertificateAuthorityCsr(
              (com.google.cloud.security.privateca.v1.FetchCertificateAuthorityCsrRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.security.privateca.v1.FetchCertificateAuthorityCsrResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CERTIFICATE_AUTHORITY:
          serviceImpl.getCertificateAuthority(
              (com.google.cloud.security.privateca.v1.GetCertificateAuthorityRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.security.privateca.v1.CertificateAuthority>)
                  responseObserver);
          break;
        case METHODID_LIST_CERTIFICATE_AUTHORITIES:
          serviceImpl.listCertificateAuthorities(
              (com.google.cloud.security.privateca.v1.ListCertificateAuthoritiesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.security.privateca.v1.ListCertificateAuthoritiesResponse>)
                  responseObserver);
          break;
        case METHODID_UNDELETE_CERTIFICATE_AUTHORITY:
          serviceImpl.undeleteCertificateAuthority(
              (com.google.cloud.security.privateca.v1.UndeleteCertificateAuthorityRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CERTIFICATE_AUTHORITY:
          serviceImpl.deleteCertificateAuthority(
              (com.google.cloud.security.privateca.v1.DeleteCertificateAuthorityRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_CERTIFICATE_AUTHORITY:
          serviceImpl.updateCertificateAuthority(
              (com.google.cloud.security.privateca.v1.UpdateCertificateAuthorityRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_CA_POOL:
          serviceImpl.createCaPool(
              (com.google.cloud.security.privateca.v1.CreateCaPoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_CA_POOL:
          serviceImpl.updateCaPool(
              (com.google.cloud.security.privateca.v1.UpdateCaPoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_CA_POOL:
          serviceImpl.getCaPool(
              (com.google.cloud.security.privateca.v1.GetCaPoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1.CaPool>)
                  responseObserver);
          break;
        case METHODID_LIST_CA_POOLS:
          serviceImpl.listCaPools(
              (com.google.cloud.security.privateca.v1.ListCaPoolsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.security.privateca.v1.ListCaPoolsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_CA_POOL:
          serviceImpl.deleteCaPool(
              (com.google.cloud.security.privateca.v1.DeleteCaPoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_FETCH_CA_CERTS:
          serviceImpl.fetchCaCerts(
              (com.google.cloud.security.privateca.v1.FetchCaCertsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.security.privateca.v1.FetchCaCertsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CERTIFICATE_REVOCATION_LIST:
          serviceImpl.getCertificateRevocationList(
              (com.google.cloud.security.privateca.v1.GetCertificateRevocationListRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.security.privateca.v1.CertificateRevocationList>)
                  responseObserver);
          break;
        case METHODID_LIST_CERTIFICATE_REVOCATION_LISTS:
          serviceImpl.listCertificateRevocationLists(
              (com.google.cloud.security.privateca.v1.ListCertificateRevocationListsRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.security.privateca.v1
                          .ListCertificateRevocationListsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_CERTIFICATE_REVOCATION_LIST:
          serviceImpl.updateCertificateRevocationList(
              (com.google.cloud.security.privateca.v1.UpdateCertificateRevocationListRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_CERTIFICATE_TEMPLATE:
          serviceImpl.createCertificateTemplate(
              (com.google.cloud.security.privateca.v1.CreateCertificateTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CERTIFICATE_TEMPLATE:
          serviceImpl.deleteCertificateTemplate(
              (com.google.cloud.security.privateca.v1.DeleteCertificateTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_CERTIFICATE_TEMPLATE:
          serviceImpl.getCertificateTemplate(
              (com.google.cloud.security.privateca.v1.GetCertificateTemplateRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.security.privateca.v1.CertificateTemplate>)
                  responseObserver);
          break;
        case METHODID_LIST_CERTIFICATE_TEMPLATES:
          serviceImpl.listCertificateTemplates(
              (com.google.cloud.security.privateca.v1.ListCertificateTemplatesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.security.privateca.v1.ListCertificateTemplatesResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_CERTIFICATE_TEMPLATE:
          serviceImpl.updateCertificateTemplate(
              (com.google.cloud.security.privateca.v1.UpdateCertificateTemplateRequest) request,
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

  private abstract static class CertificateAuthorityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CertificateAuthorityServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.security.privateca.v1.PrivateCaProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CertificateAuthorityService");
    }
  }

  private static final class CertificateAuthorityServiceFileDescriptorSupplier
      extends CertificateAuthorityServiceBaseDescriptorSupplier {
    CertificateAuthorityServiceFileDescriptorSupplier() {}
  }

  private static final class CertificateAuthorityServiceMethodDescriptorSupplier
      extends CertificateAuthorityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CertificateAuthorityServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CertificateAuthorityServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new CertificateAuthorityServiceFileDescriptorSupplier())
                      .addMethod(getCreateCertificateMethod())
                      .addMethod(getGetCertificateMethod())
                      .addMethod(getListCertificatesMethod())
                      .addMethod(getRevokeCertificateMethod())
                      .addMethod(getUpdateCertificateMethod())
                      .addMethod(getActivateCertificateAuthorityMethod())
                      .addMethod(getCreateCertificateAuthorityMethod())
                      .addMethod(getDisableCertificateAuthorityMethod())
                      .addMethod(getEnableCertificateAuthorityMethod())
                      .addMethod(getFetchCertificateAuthorityCsrMethod())
                      .addMethod(getGetCertificateAuthorityMethod())
                      .addMethod(getListCertificateAuthoritiesMethod())
                      .addMethod(getUndeleteCertificateAuthorityMethod())
                      .addMethod(getDeleteCertificateAuthorityMethod())
                      .addMethod(getUpdateCertificateAuthorityMethod())
                      .addMethod(getCreateCaPoolMethod())
                      .addMethod(getUpdateCaPoolMethod())
                      .addMethod(getGetCaPoolMethod())
                      .addMethod(getListCaPoolsMethod())
                      .addMethod(getDeleteCaPoolMethod())
                      .addMethod(getFetchCaCertsMethod())
                      .addMethod(getGetCertificateRevocationListMethod())
                      .addMethod(getListCertificateRevocationListsMethod())
                      .addMethod(getUpdateCertificateRevocationListMethod())
                      .addMethod(getCreateCertificateTemplateMethod())
                      .addMethod(getDeleteCertificateTemplateMethod())
                      .addMethod(getGetCertificateTemplateMethod())
                      .addMethod(getListCertificateTemplatesMethod())
                      .addMethod(getUpdateCertificateTemplateMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
