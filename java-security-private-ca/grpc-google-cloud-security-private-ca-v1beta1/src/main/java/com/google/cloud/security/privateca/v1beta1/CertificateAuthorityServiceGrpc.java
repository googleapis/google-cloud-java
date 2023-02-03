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
package com.google.cloud.security.privateca.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * [Certificate Authority Service][google.cloud.security.privateca.v1beta1.CertificateAuthorityService] manages private
 * certificate authorities and issued certificates.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/security/privateca/v1beta1/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CertificateAuthorityServiceGrpc {

  private CertificateAuthorityServiceGrpc() {}

  public static final String SERVICE_NAME =
      "google.cloud.security.privateca.v1beta1.CertificateAuthorityService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1beta1.CreateCertificateRequest,
          com.google.cloud.security.privateca.v1beta1.Certificate>
      getCreateCertificateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCertificate",
      requestType = com.google.cloud.security.privateca.v1beta1.CreateCertificateRequest.class,
      responseType = com.google.cloud.security.privateca.v1beta1.Certificate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1beta1.CreateCertificateRequest,
          com.google.cloud.security.privateca.v1beta1.Certificate>
      getCreateCertificateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1beta1.CreateCertificateRequest,
            com.google.cloud.security.privateca.v1beta1.Certificate>
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
                      .<com.google.cloud.security.privateca.v1beta1.CreateCertificateRequest,
                          com.google.cloud.security.privateca.v1beta1.Certificate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCertificate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1beta1.CreateCertificateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1beta1.Certificate
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
          com.google.cloud.security.privateca.v1beta1.GetCertificateRequest,
          com.google.cloud.security.privateca.v1beta1.Certificate>
      getGetCertificateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCertificate",
      requestType = com.google.cloud.security.privateca.v1beta1.GetCertificateRequest.class,
      responseType = com.google.cloud.security.privateca.v1beta1.Certificate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1beta1.GetCertificateRequest,
          com.google.cloud.security.privateca.v1beta1.Certificate>
      getGetCertificateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1beta1.GetCertificateRequest,
            com.google.cloud.security.privateca.v1beta1.Certificate>
        getGetCertificateMethod;
    if ((getGetCertificateMethod = CertificateAuthorityServiceGrpc.getGetCertificateMethod)
        == null) {
      synchronized (CertificateAuthorityServiceGrpc.class) {
        if ((getGetCertificateMethod = CertificateAuthorityServiceGrpc.getGetCertificateMethod)
            == null) {
          CertificateAuthorityServiceGrpc.getGetCertificateMethod =
              getGetCertificateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.privateca.v1beta1.GetCertificateRequest,
                          com.google.cloud.security.privateca.v1beta1.Certificate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCertificate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1beta1.GetCertificateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1beta1.Certificate
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
          com.google.cloud.security.privateca.v1beta1.ListCertificatesRequest,
          com.google.cloud.security.privateca.v1beta1.ListCertificatesResponse>
      getListCertificatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCertificates",
      requestType = com.google.cloud.security.privateca.v1beta1.ListCertificatesRequest.class,
      responseType = com.google.cloud.security.privateca.v1beta1.ListCertificatesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1beta1.ListCertificatesRequest,
          com.google.cloud.security.privateca.v1beta1.ListCertificatesResponse>
      getListCertificatesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1beta1.ListCertificatesRequest,
            com.google.cloud.security.privateca.v1beta1.ListCertificatesResponse>
        getListCertificatesMethod;
    if ((getListCertificatesMethod = CertificateAuthorityServiceGrpc.getListCertificatesMethod)
        == null) {
      synchronized (CertificateAuthorityServiceGrpc.class) {
        if ((getListCertificatesMethod = CertificateAuthorityServiceGrpc.getListCertificatesMethod)
            == null) {
          CertificateAuthorityServiceGrpc.getListCertificatesMethod =
              getListCertificatesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.privateca.v1beta1.ListCertificatesRequest,
                          com.google.cloud.security.privateca.v1beta1.ListCertificatesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCertificates"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1beta1.ListCertificatesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1beta1.ListCertificatesResponse
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
          com.google.cloud.security.privateca.v1beta1.RevokeCertificateRequest,
          com.google.cloud.security.privateca.v1beta1.Certificate>
      getRevokeCertificateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RevokeCertificate",
      requestType = com.google.cloud.security.privateca.v1beta1.RevokeCertificateRequest.class,
      responseType = com.google.cloud.security.privateca.v1beta1.Certificate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1beta1.RevokeCertificateRequest,
          com.google.cloud.security.privateca.v1beta1.Certificate>
      getRevokeCertificateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1beta1.RevokeCertificateRequest,
            com.google.cloud.security.privateca.v1beta1.Certificate>
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
                      .<com.google.cloud.security.privateca.v1beta1.RevokeCertificateRequest,
                          com.google.cloud.security.privateca.v1beta1.Certificate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RevokeCertificate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1beta1.RevokeCertificateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1beta1.Certificate
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
          com.google.cloud.security.privateca.v1beta1.UpdateCertificateRequest,
          com.google.cloud.security.privateca.v1beta1.Certificate>
      getUpdateCertificateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCertificate",
      requestType = com.google.cloud.security.privateca.v1beta1.UpdateCertificateRequest.class,
      responseType = com.google.cloud.security.privateca.v1beta1.Certificate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1beta1.UpdateCertificateRequest,
          com.google.cloud.security.privateca.v1beta1.Certificate>
      getUpdateCertificateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1beta1.UpdateCertificateRequest,
            com.google.cloud.security.privateca.v1beta1.Certificate>
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
                      .<com.google.cloud.security.privateca.v1beta1.UpdateCertificateRequest,
                          com.google.cloud.security.privateca.v1beta1.Certificate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCertificate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1beta1.UpdateCertificateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1beta1.Certificate
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
          com.google.cloud.security.privateca.v1beta1.ActivateCertificateAuthorityRequest,
          com.google.longrunning.Operation>
      getActivateCertificateAuthorityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ActivateCertificateAuthority",
      requestType =
          com.google.cloud.security.privateca.v1beta1.ActivateCertificateAuthorityRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1beta1.ActivateCertificateAuthorityRequest,
          com.google.longrunning.Operation>
      getActivateCertificateAuthorityMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1beta1.ActivateCertificateAuthorityRequest,
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
                      .<com.google.cloud.security.privateca.v1beta1
                              .ActivateCertificateAuthorityRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ActivateCertificateAuthority"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1beta1
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
          com.google.cloud.security.privateca.v1beta1.CreateCertificateAuthorityRequest,
          com.google.longrunning.Operation>
      getCreateCertificateAuthorityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCertificateAuthority",
      requestType =
          com.google.cloud.security.privateca.v1beta1.CreateCertificateAuthorityRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1beta1.CreateCertificateAuthorityRequest,
          com.google.longrunning.Operation>
      getCreateCertificateAuthorityMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1beta1.CreateCertificateAuthorityRequest,
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
                      .<com.google.cloud.security.privateca.v1beta1
                              .CreateCertificateAuthorityRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateCertificateAuthority"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1beta1
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
          com.google.cloud.security.privateca.v1beta1.DisableCertificateAuthorityRequest,
          com.google.longrunning.Operation>
      getDisableCertificateAuthorityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DisableCertificateAuthority",
      requestType =
          com.google.cloud.security.privateca.v1beta1.DisableCertificateAuthorityRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1beta1.DisableCertificateAuthorityRequest,
          com.google.longrunning.Operation>
      getDisableCertificateAuthorityMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1beta1.DisableCertificateAuthorityRequest,
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
                      .<com.google.cloud.security.privateca.v1beta1
                              .DisableCertificateAuthorityRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DisableCertificateAuthority"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1beta1
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
          com.google.cloud.security.privateca.v1beta1.EnableCertificateAuthorityRequest,
          com.google.longrunning.Operation>
      getEnableCertificateAuthorityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EnableCertificateAuthority",
      requestType =
          com.google.cloud.security.privateca.v1beta1.EnableCertificateAuthorityRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1beta1.EnableCertificateAuthorityRequest,
          com.google.longrunning.Operation>
      getEnableCertificateAuthorityMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1beta1.EnableCertificateAuthorityRequest,
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
                      .<com.google.cloud.security.privateca.v1beta1
                              .EnableCertificateAuthorityRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "EnableCertificateAuthority"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1beta1
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
          com.google.cloud.security.privateca.v1beta1.FetchCertificateAuthorityCsrRequest,
          com.google.cloud.security.privateca.v1beta1.FetchCertificateAuthorityCsrResponse>
      getFetchCertificateAuthorityCsrMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchCertificateAuthorityCsr",
      requestType =
          com.google.cloud.security.privateca.v1beta1.FetchCertificateAuthorityCsrRequest.class,
      responseType =
          com.google.cloud.security.privateca.v1beta1.FetchCertificateAuthorityCsrResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1beta1.FetchCertificateAuthorityCsrRequest,
          com.google.cloud.security.privateca.v1beta1.FetchCertificateAuthorityCsrResponse>
      getFetchCertificateAuthorityCsrMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1beta1.FetchCertificateAuthorityCsrRequest,
            com.google.cloud.security.privateca.v1beta1.FetchCertificateAuthorityCsrResponse>
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
                      .<com.google.cloud.security.privateca.v1beta1
                              .FetchCertificateAuthorityCsrRequest,
                          com.google.cloud.security.privateca.v1beta1
                              .FetchCertificateAuthorityCsrResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "FetchCertificateAuthorityCsr"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1beta1
                                  .FetchCertificateAuthorityCsrRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1beta1
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
          com.google.cloud.security.privateca.v1beta1.GetCertificateAuthorityRequest,
          com.google.cloud.security.privateca.v1beta1.CertificateAuthority>
      getGetCertificateAuthorityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCertificateAuthority",
      requestType =
          com.google.cloud.security.privateca.v1beta1.GetCertificateAuthorityRequest.class,
      responseType = com.google.cloud.security.privateca.v1beta1.CertificateAuthority.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1beta1.GetCertificateAuthorityRequest,
          com.google.cloud.security.privateca.v1beta1.CertificateAuthority>
      getGetCertificateAuthorityMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1beta1.GetCertificateAuthorityRequest,
            com.google.cloud.security.privateca.v1beta1.CertificateAuthority>
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
                      .<com.google.cloud.security.privateca.v1beta1.GetCertificateAuthorityRequest,
                          com.google.cloud.security.privateca.v1beta1.CertificateAuthority>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetCertificateAuthority"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1beta1
                                  .GetCertificateAuthorityRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1beta1.CertificateAuthority
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
          com.google.cloud.security.privateca.v1beta1.ListCertificateAuthoritiesRequest,
          com.google.cloud.security.privateca.v1beta1.ListCertificateAuthoritiesResponse>
      getListCertificateAuthoritiesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCertificateAuthorities",
      requestType =
          com.google.cloud.security.privateca.v1beta1.ListCertificateAuthoritiesRequest.class,
      responseType =
          com.google.cloud.security.privateca.v1beta1.ListCertificateAuthoritiesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1beta1.ListCertificateAuthoritiesRequest,
          com.google.cloud.security.privateca.v1beta1.ListCertificateAuthoritiesResponse>
      getListCertificateAuthoritiesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1beta1.ListCertificateAuthoritiesRequest,
            com.google.cloud.security.privateca.v1beta1.ListCertificateAuthoritiesResponse>
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
                      .<com.google.cloud.security.privateca.v1beta1
                              .ListCertificateAuthoritiesRequest,
                          com.google.cloud.security.privateca.v1beta1
                              .ListCertificateAuthoritiesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListCertificateAuthorities"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1beta1
                                  .ListCertificateAuthoritiesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1beta1
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
          com.google.cloud.security.privateca.v1beta1.RestoreCertificateAuthorityRequest,
          com.google.longrunning.Operation>
      getRestoreCertificateAuthorityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RestoreCertificateAuthority",
      requestType =
          com.google.cloud.security.privateca.v1beta1.RestoreCertificateAuthorityRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1beta1.RestoreCertificateAuthorityRequest,
          com.google.longrunning.Operation>
      getRestoreCertificateAuthorityMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1beta1.RestoreCertificateAuthorityRequest,
            com.google.longrunning.Operation>
        getRestoreCertificateAuthorityMethod;
    if ((getRestoreCertificateAuthorityMethod =
            CertificateAuthorityServiceGrpc.getRestoreCertificateAuthorityMethod)
        == null) {
      synchronized (CertificateAuthorityServiceGrpc.class) {
        if ((getRestoreCertificateAuthorityMethod =
                CertificateAuthorityServiceGrpc.getRestoreCertificateAuthorityMethod)
            == null) {
          CertificateAuthorityServiceGrpc.getRestoreCertificateAuthorityMethod =
              getRestoreCertificateAuthorityMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.privateca.v1beta1
                              .RestoreCertificateAuthorityRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RestoreCertificateAuthority"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1beta1
                                  .RestoreCertificateAuthorityRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateAuthorityServiceMethodDescriptorSupplier(
                              "RestoreCertificateAuthority"))
                      .build();
        }
      }
    }
    return getRestoreCertificateAuthorityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1beta1.ScheduleDeleteCertificateAuthorityRequest,
          com.google.longrunning.Operation>
      getScheduleDeleteCertificateAuthorityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ScheduleDeleteCertificateAuthority",
      requestType =
          com.google.cloud.security.privateca.v1beta1.ScheduleDeleteCertificateAuthorityRequest
              .class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1beta1.ScheduleDeleteCertificateAuthorityRequest,
          com.google.longrunning.Operation>
      getScheduleDeleteCertificateAuthorityMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1beta1.ScheduleDeleteCertificateAuthorityRequest,
            com.google.longrunning.Operation>
        getScheduleDeleteCertificateAuthorityMethod;
    if ((getScheduleDeleteCertificateAuthorityMethod =
            CertificateAuthorityServiceGrpc.getScheduleDeleteCertificateAuthorityMethod)
        == null) {
      synchronized (CertificateAuthorityServiceGrpc.class) {
        if ((getScheduleDeleteCertificateAuthorityMethod =
                CertificateAuthorityServiceGrpc.getScheduleDeleteCertificateAuthorityMethod)
            == null) {
          CertificateAuthorityServiceGrpc.getScheduleDeleteCertificateAuthorityMethod =
              getScheduleDeleteCertificateAuthorityMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.privateca.v1beta1
                              .ScheduleDeleteCertificateAuthorityRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "ScheduleDeleteCertificateAuthority"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1beta1
                                  .ScheduleDeleteCertificateAuthorityRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateAuthorityServiceMethodDescriptorSupplier(
                              "ScheduleDeleteCertificateAuthority"))
                      .build();
        }
      }
    }
    return getScheduleDeleteCertificateAuthorityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1beta1.UpdateCertificateAuthorityRequest,
          com.google.longrunning.Operation>
      getUpdateCertificateAuthorityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCertificateAuthority",
      requestType =
          com.google.cloud.security.privateca.v1beta1.UpdateCertificateAuthorityRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1beta1.UpdateCertificateAuthorityRequest,
          com.google.longrunning.Operation>
      getUpdateCertificateAuthorityMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1beta1.UpdateCertificateAuthorityRequest,
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
                      .<com.google.cloud.security.privateca.v1beta1
                              .UpdateCertificateAuthorityRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateCertificateAuthority"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1beta1
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
          com.google.cloud.security.privateca.v1beta1.GetCertificateRevocationListRequest,
          com.google.cloud.security.privateca.v1beta1.CertificateRevocationList>
      getGetCertificateRevocationListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCertificateRevocationList",
      requestType =
          com.google.cloud.security.privateca.v1beta1.GetCertificateRevocationListRequest.class,
      responseType = com.google.cloud.security.privateca.v1beta1.CertificateRevocationList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1beta1.GetCertificateRevocationListRequest,
          com.google.cloud.security.privateca.v1beta1.CertificateRevocationList>
      getGetCertificateRevocationListMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1beta1.GetCertificateRevocationListRequest,
            com.google.cloud.security.privateca.v1beta1.CertificateRevocationList>
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
                      .<com.google.cloud.security.privateca.v1beta1
                              .GetCertificateRevocationListRequest,
                          com.google.cloud.security.privateca.v1beta1.CertificateRevocationList>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetCertificateRevocationList"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1beta1
                                  .GetCertificateRevocationListRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1beta1.CertificateRevocationList
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
          com.google.cloud.security.privateca.v1beta1.ListCertificateRevocationListsRequest,
          com.google.cloud.security.privateca.v1beta1.ListCertificateRevocationListsResponse>
      getListCertificateRevocationListsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCertificateRevocationLists",
      requestType =
          com.google.cloud.security.privateca.v1beta1.ListCertificateRevocationListsRequest.class,
      responseType =
          com.google.cloud.security.privateca.v1beta1.ListCertificateRevocationListsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1beta1.ListCertificateRevocationListsRequest,
          com.google.cloud.security.privateca.v1beta1.ListCertificateRevocationListsResponse>
      getListCertificateRevocationListsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1beta1.ListCertificateRevocationListsRequest,
            com.google.cloud.security.privateca.v1beta1.ListCertificateRevocationListsResponse>
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
                      .<com.google.cloud.security.privateca.v1beta1
                              .ListCertificateRevocationListsRequest,
                          com.google.cloud.security.privateca.v1beta1
                              .ListCertificateRevocationListsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListCertificateRevocationLists"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1beta1
                                  .ListCertificateRevocationListsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1beta1
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
          com.google.cloud.security.privateca.v1beta1.UpdateCertificateRevocationListRequest,
          com.google.longrunning.Operation>
      getUpdateCertificateRevocationListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCertificateRevocationList",
      requestType =
          com.google.cloud.security.privateca.v1beta1.UpdateCertificateRevocationListRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1beta1.UpdateCertificateRevocationListRequest,
          com.google.longrunning.Operation>
      getUpdateCertificateRevocationListMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1beta1.UpdateCertificateRevocationListRequest,
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
                      .<com.google.cloud.security.privateca.v1beta1
                              .UpdateCertificateRevocationListRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateCertificateRevocationList"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1beta1
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
          com.google.cloud.security.privateca.v1beta1.GetReusableConfigRequest,
          com.google.cloud.security.privateca.v1beta1.ReusableConfig>
      getGetReusableConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetReusableConfig",
      requestType = com.google.cloud.security.privateca.v1beta1.GetReusableConfigRequest.class,
      responseType = com.google.cloud.security.privateca.v1beta1.ReusableConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1beta1.GetReusableConfigRequest,
          com.google.cloud.security.privateca.v1beta1.ReusableConfig>
      getGetReusableConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1beta1.GetReusableConfigRequest,
            com.google.cloud.security.privateca.v1beta1.ReusableConfig>
        getGetReusableConfigMethod;
    if ((getGetReusableConfigMethod = CertificateAuthorityServiceGrpc.getGetReusableConfigMethod)
        == null) {
      synchronized (CertificateAuthorityServiceGrpc.class) {
        if ((getGetReusableConfigMethod =
                CertificateAuthorityServiceGrpc.getGetReusableConfigMethod)
            == null) {
          CertificateAuthorityServiceGrpc.getGetReusableConfigMethod =
              getGetReusableConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.privateca.v1beta1.GetReusableConfigRequest,
                          com.google.cloud.security.privateca.v1beta1.ReusableConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetReusableConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1beta1.GetReusableConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1beta1.ReusableConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateAuthorityServiceMethodDescriptorSupplier(
                              "GetReusableConfig"))
                      .build();
        }
      }
    }
    return getGetReusableConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1beta1.ListReusableConfigsRequest,
          com.google.cloud.security.privateca.v1beta1.ListReusableConfigsResponse>
      getListReusableConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListReusableConfigs",
      requestType = com.google.cloud.security.privateca.v1beta1.ListReusableConfigsRequest.class,
      responseType = com.google.cloud.security.privateca.v1beta1.ListReusableConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1beta1.ListReusableConfigsRequest,
          com.google.cloud.security.privateca.v1beta1.ListReusableConfigsResponse>
      getListReusableConfigsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1beta1.ListReusableConfigsRequest,
            com.google.cloud.security.privateca.v1beta1.ListReusableConfigsResponse>
        getListReusableConfigsMethod;
    if ((getListReusableConfigsMethod =
            CertificateAuthorityServiceGrpc.getListReusableConfigsMethod)
        == null) {
      synchronized (CertificateAuthorityServiceGrpc.class) {
        if ((getListReusableConfigsMethod =
                CertificateAuthorityServiceGrpc.getListReusableConfigsMethod)
            == null) {
          CertificateAuthorityServiceGrpc.getListReusableConfigsMethod =
              getListReusableConfigsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.privateca.v1beta1.ListReusableConfigsRequest,
                          com.google.cloud.security.privateca.v1beta1.ListReusableConfigsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListReusableConfigs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1beta1.ListReusableConfigsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1beta1
                                  .ListReusableConfigsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateAuthorityServiceMethodDescriptorSupplier(
                              "ListReusableConfigs"))
                      .build();
        }
      }
    }
    return getListReusableConfigsMethod;
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
   * [Certificate Authority Service][google.cloud.security.privateca.v1beta1.CertificateAuthorityService] manages private
   * certificate authorities and issued certificates.
   * </pre>
   */
  public abstract static class CertificateAuthorityServiceImplBase
      implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Create a new [Certificate][google.cloud.security.privateca.v1beta1.Certificate] in a given Project, Location from a particular
     * [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
     * </pre>
     */
    public void createCertificate(
        com.google.cloud.security.privateca.v1beta1.CreateCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1beta1.Certificate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateCertificateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a [Certificate][google.cloud.security.privateca.v1beta1.Certificate].
     * </pre>
     */
    public void getCertificate(
        com.google.cloud.security.privateca.v1beta1.GetCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1beta1.Certificate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCertificateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists [Certificates][google.cloud.security.privateca.v1beta1.Certificate].
     * </pre>
     */
    public void listCertificates(
        com.google.cloud.security.privateca.v1beta1.ListCertificatesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.security.privateca.v1beta1.ListCertificatesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCertificatesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Revoke a [Certificate][google.cloud.security.privateca.v1beta1.Certificate].
     * </pre>
     */
    public void revokeCertificate(
        com.google.cloud.security.privateca.v1beta1.RevokeCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1beta1.Certificate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRevokeCertificateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a [Certificate][google.cloud.security.privateca.v1beta1.Certificate]. Currently, the only field you can update is the
     * [labels][google.cloud.security.privateca.v1beta1.Certificate.labels] field.
     * </pre>
     */
    public void updateCertificate(
        com.google.cloud.security.privateca.v1beta1.UpdateCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1beta1.Certificate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateCertificateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Activate a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] that is in state
     * [PENDING_ACTIVATION][google.cloud.security.privateca.v1beta1.CertificateAuthority.State.PENDING_ACTIVATION] and is
     * of type [SUBORDINATE][google.cloud.security.privateca.v1beta1.CertificateAuthority.Type.SUBORDINATE]. After the
     * parent Certificate Authority signs a certificate signing request from
     * [FetchCertificateAuthorityCsr][google.cloud.security.privateca.v1beta1.CertificateAuthorityService.FetchCertificateAuthorityCsr], this method can complete the activation
     * process.
     * </pre>
     */
    public void activateCertificateAuthority(
        com.google.cloud.security.privateca.v1beta1.ActivateCertificateAuthorityRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getActivateCertificateAuthorityMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] in a given Project and Location.
     * </pre>
     */
    public void createCertificateAuthority(
        com.google.cloud.security.privateca.v1beta1.CreateCertificateAuthorityRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateCertificateAuthorityMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Disable a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
     * </pre>
     */
    public void disableCertificateAuthority(
        com.google.cloud.security.privateca.v1beta1.DisableCertificateAuthorityRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDisableCertificateAuthorityMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Enable a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
     * </pre>
     */
    public void enableCertificateAuthority(
        com.google.cloud.security.privateca.v1beta1.EnableCertificateAuthorityRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getEnableCertificateAuthorityMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetch a certificate signing request (CSR) from a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority]
     * that is in state
     * [PENDING_ACTIVATION][google.cloud.security.privateca.v1beta1.CertificateAuthority.State.PENDING_ACTIVATION] and is
     * of type [SUBORDINATE][google.cloud.security.privateca.v1beta1.CertificateAuthority.Type.SUBORDINATE]. The CSR must
     * then be signed by the desired parent Certificate Authority, which could be
     * another [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] resource, or could be an on-prem
     * certificate authority. See also [ActivateCertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthorityService.ActivateCertificateAuthority].
     * </pre>
     */
    public void fetchCertificateAuthorityCsr(
        com.google.cloud.security.privateca.v1beta1.FetchCertificateAuthorityCsrRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.security.privateca.v1beta1.FetchCertificateAuthorityCsrResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFetchCertificateAuthorityCsrMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
     * </pre>
     */
    public void getCertificateAuthority(
        com.google.cloud.security.privateca.v1beta1.GetCertificateAuthorityRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.security.privateca.v1beta1.CertificateAuthority>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCertificateAuthorityMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists [CertificateAuthorities][google.cloud.security.privateca.v1beta1.CertificateAuthority].
     * </pre>
     */
    public void listCertificateAuthorities(
        com.google.cloud.security.privateca.v1beta1.ListCertificateAuthoritiesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.security.privateca.v1beta1.ListCertificateAuthoritiesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCertificateAuthoritiesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Restore a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] that is scheduled for deletion.
     * </pre>
     */
    public void restoreCertificateAuthority(
        com.google.cloud.security.privateca.v1beta1.RestoreCertificateAuthorityRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRestoreCertificateAuthorityMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Schedule a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] for deletion.
     * </pre>
     */
    public void scheduleDeleteCertificateAuthority(
        com.google.cloud.security.privateca.v1beta1.ScheduleDeleteCertificateAuthorityRequest
            request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getScheduleDeleteCertificateAuthorityMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
     * </pre>
     */
    public void updateCertificateAuthority(
        com.google.cloud.security.privateca.v1beta1.UpdateCertificateAuthorityRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateCertificateAuthorityMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a [CertificateRevocationList][google.cloud.security.privateca.v1beta1.CertificateRevocationList].
     * </pre>
     */
    public void getCertificateRevocationList(
        com.google.cloud.security.privateca.v1beta1.GetCertificateRevocationListRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.security.privateca.v1beta1.CertificateRevocationList>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCertificateRevocationListMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists [CertificateRevocationLists][google.cloud.security.privateca.v1beta1.CertificateRevocationList].
     * </pre>
     */
    public void listCertificateRevocationLists(
        com.google.cloud.security.privateca.v1beta1.ListCertificateRevocationListsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.security.privateca.v1beta1.ListCertificateRevocationListsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCertificateRevocationListsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a [CertificateRevocationList][google.cloud.security.privateca.v1beta1.CertificateRevocationList].
     * </pre>
     */
    public void updateCertificateRevocationList(
        com.google.cloud.security.privateca.v1beta1.UpdateCertificateRevocationListRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateCertificateRevocationListMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a [ReusableConfig][google.cloud.security.privateca.v1beta1.ReusableConfig].
     * </pre>
     */
    public void getReusableConfig(
        com.google.cloud.security.privateca.v1beta1.GetReusableConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1beta1.ReusableConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetReusableConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists [ReusableConfigs][google.cloud.security.privateca.v1beta1.ReusableConfig].
     * </pre>
     */
    public void listReusableConfigs(
        com.google.cloud.security.privateca.v1beta1.ListReusableConfigsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.security.privateca.v1beta1.ListReusableConfigsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListReusableConfigsMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateCertificateMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1.CreateCertificateRequest,
                      com.google.cloud.security.privateca.v1beta1.Certificate>(
                      this, METHODID_CREATE_CERTIFICATE)))
          .addMethod(
              getGetCertificateMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1.GetCertificateRequest,
                      com.google.cloud.security.privateca.v1beta1.Certificate>(
                      this, METHODID_GET_CERTIFICATE)))
          .addMethod(
              getListCertificatesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1.ListCertificatesRequest,
                      com.google.cloud.security.privateca.v1beta1.ListCertificatesResponse>(
                      this, METHODID_LIST_CERTIFICATES)))
          .addMethod(
              getRevokeCertificateMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1.RevokeCertificateRequest,
                      com.google.cloud.security.privateca.v1beta1.Certificate>(
                      this, METHODID_REVOKE_CERTIFICATE)))
          .addMethod(
              getUpdateCertificateMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1.UpdateCertificateRequest,
                      com.google.cloud.security.privateca.v1beta1.Certificate>(
                      this, METHODID_UPDATE_CERTIFICATE)))
          .addMethod(
              getActivateCertificateAuthorityMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1
                          .ActivateCertificateAuthorityRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_ACTIVATE_CERTIFICATE_AUTHORITY)))
          .addMethod(
              getCreateCertificateAuthorityMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1.CreateCertificateAuthorityRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_CREATE_CERTIFICATE_AUTHORITY)))
          .addMethod(
              getDisableCertificateAuthorityMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1
                          .DisableCertificateAuthorityRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_DISABLE_CERTIFICATE_AUTHORITY)))
          .addMethod(
              getEnableCertificateAuthorityMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1.EnableCertificateAuthorityRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_ENABLE_CERTIFICATE_AUTHORITY)))
          .addMethod(
              getFetchCertificateAuthorityCsrMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1
                          .FetchCertificateAuthorityCsrRequest,
                      com.google.cloud.security.privateca.v1beta1
                          .FetchCertificateAuthorityCsrResponse>(
                      this, METHODID_FETCH_CERTIFICATE_AUTHORITY_CSR)))
          .addMethod(
              getGetCertificateAuthorityMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1.GetCertificateAuthorityRequest,
                      com.google.cloud.security.privateca.v1beta1.CertificateAuthority>(
                      this, METHODID_GET_CERTIFICATE_AUTHORITY)))
          .addMethod(
              getListCertificateAuthoritiesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1.ListCertificateAuthoritiesRequest,
                      com.google.cloud.security.privateca.v1beta1
                          .ListCertificateAuthoritiesResponse>(
                      this, METHODID_LIST_CERTIFICATE_AUTHORITIES)))
          .addMethod(
              getRestoreCertificateAuthorityMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1
                          .RestoreCertificateAuthorityRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_RESTORE_CERTIFICATE_AUTHORITY)))
          .addMethod(
              getScheduleDeleteCertificateAuthorityMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1
                          .ScheduleDeleteCertificateAuthorityRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_SCHEDULE_DELETE_CERTIFICATE_AUTHORITY)))
          .addMethod(
              getUpdateCertificateAuthorityMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1.UpdateCertificateAuthorityRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_UPDATE_CERTIFICATE_AUTHORITY)))
          .addMethod(
              getGetCertificateRevocationListMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1
                          .GetCertificateRevocationListRequest,
                      com.google.cloud.security.privateca.v1beta1.CertificateRevocationList>(
                      this, METHODID_GET_CERTIFICATE_REVOCATION_LIST)))
          .addMethod(
              getListCertificateRevocationListsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1
                          .ListCertificateRevocationListsRequest,
                      com.google.cloud.security.privateca.v1beta1
                          .ListCertificateRevocationListsResponse>(
                      this, METHODID_LIST_CERTIFICATE_REVOCATION_LISTS)))
          .addMethod(
              getUpdateCertificateRevocationListMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1
                          .UpdateCertificateRevocationListRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_UPDATE_CERTIFICATE_REVOCATION_LIST)))
          .addMethod(
              getGetReusableConfigMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1.GetReusableConfigRequest,
                      com.google.cloud.security.privateca.v1beta1.ReusableConfig>(
                      this, METHODID_GET_REUSABLE_CONFIG)))
          .addMethod(
              getListReusableConfigsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1.ListReusableConfigsRequest,
                      com.google.cloud.security.privateca.v1beta1.ListReusableConfigsResponse>(
                      this, METHODID_LIST_REUSABLE_CONFIGS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * [Certificate Authority Service][google.cloud.security.privateca.v1beta1.CertificateAuthorityService] manages private
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
     * Create a new [Certificate][google.cloud.security.privateca.v1beta1.Certificate] in a given Project, Location from a particular
     * [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
     * </pre>
     */
    public void createCertificate(
        com.google.cloud.security.privateca.v1beta1.CreateCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1beta1.Certificate>
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
     * Returns a [Certificate][google.cloud.security.privateca.v1beta1.Certificate].
     * </pre>
     */
    public void getCertificate(
        com.google.cloud.security.privateca.v1beta1.GetCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1beta1.Certificate>
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
     * Lists [Certificates][google.cloud.security.privateca.v1beta1.Certificate].
     * </pre>
     */
    public void listCertificates(
        com.google.cloud.security.privateca.v1beta1.ListCertificatesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.security.privateca.v1beta1.ListCertificatesResponse>
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
     * Revoke a [Certificate][google.cloud.security.privateca.v1beta1.Certificate].
     * </pre>
     */
    public void revokeCertificate(
        com.google.cloud.security.privateca.v1beta1.RevokeCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1beta1.Certificate>
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
     * Update a [Certificate][google.cloud.security.privateca.v1beta1.Certificate]. Currently, the only field you can update is the
     * [labels][google.cloud.security.privateca.v1beta1.Certificate.labels] field.
     * </pre>
     */
    public void updateCertificate(
        com.google.cloud.security.privateca.v1beta1.UpdateCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1beta1.Certificate>
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
     * Activate a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] that is in state
     * [PENDING_ACTIVATION][google.cloud.security.privateca.v1beta1.CertificateAuthority.State.PENDING_ACTIVATION] and is
     * of type [SUBORDINATE][google.cloud.security.privateca.v1beta1.CertificateAuthority.Type.SUBORDINATE]. After the
     * parent Certificate Authority signs a certificate signing request from
     * [FetchCertificateAuthorityCsr][google.cloud.security.privateca.v1beta1.CertificateAuthorityService.FetchCertificateAuthorityCsr], this method can complete the activation
     * process.
     * </pre>
     */
    public void activateCertificateAuthority(
        com.google.cloud.security.privateca.v1beta1.ActivateCertificateAuthorityRequest request,
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
     * Create a new [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] in a given Project and Location.
     * </pre>
     */
    public void createCertificateAuthority(
        com.google.cloud.security.privateca.v1beta1.CreateCertificateAuthorityRequest request,
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
     * Disable a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
     * </pre>
     */
    public void disableCertificateAuthority(
        com.google.cloud.security.privateca.v1beta1.DisableCertificateAuthorityRequest request,
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
     * Enable a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
     * </pre>
     */
    public void enableCertificateAuthority(
        com.google.cloud.security.privateca.v1beta1.EnableCertificateAuthorityRequest request,
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
     * Fetch a certificate signing request (CSR) from a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority]
     * that is in state
     * [PENDING_ACTIVATION][google.cloud.security.privateca.v1beta1.CertificateAuthority.State.PENDING_ACTIVATION] and is
     * of type [SUBORDINATE][google.cloud.security.privateca.v1beta1.CertificateAuthority.Type.SUBORDINATE]. The CSR must
     * then be signed by the desired parent Certificate Authority, which could be
     * another [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] resource, or could be an on-prem
     * certificate authority. See also [ActivateCertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthorityService.ActivateCertificateAuthority].
     * </pre>
     */
    public void fetchCertificateAuthorityCsr(
        com.google.cloud.security.privateca.v1beta1.FetchCertificateAuthorityCsrRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.security.privateca.v1beta1.FetchCertificateAuthorityCsrResponse>
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
     * Returns a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
     * </pre>
     */
    public void getCertificateAuthority(
        com.google.cloud.security.privateca.v1beta1.GetCertificateAuthorityRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.security.privateca.v1beta1.CertificateAuthority>
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
     * Lists [CertificateAuthorities][google.cloud.security.privateca.v1beta1.CertificateAuthority].
     * </pre>
     */
    public void listCertificateAuthorities(
        com.google.cloud.security.privateca.v1beta1.ListCertificateAuthoritiesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.security.privateca.v1beta1.ListCertificateAuthoritiesResponse>
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
     * Restore a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] that is scheduled for deletion.
     * </pre>
     */
    public void restoreCertificateAuthority(
        com.google.cloud.security.privateca.v1beta1.RestoreCertificateAuthorityRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRestoreCertificateAuthorityMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Schedule a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] for deletion.
     * </pre>
     */
    public void scheduleDeleteCertificateAuthority(
        com.google.cloud.security.privateca.v1beta1.ScheduleDeleteCertificateAuthorityRequest
            request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getScheduleDeleteCertificateAuthorityMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
     * </pre>
     */
    public void updateCertificateAuthority(
        com.google.cloud.security.privateca.v1beta1.UpdateCertificateAuthorityRequest request,
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
     * Returns a [CertificateRevocationList][google.cloud.security.privateca.v1beta1.CertificateRevocationList].
     * </pre>
     */
    public void getCertificateRevocationList(
        com.google.cloud.security.privateca.v1beta1.GetCertificateRevocationListRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.security.privateca.v1beta1.CertificateRevocationList>
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
     * Lists [CertificateRevocationLists][google.cloud.security.privateca.v1beta1.CertificateRevocationList].
     * </pre>
     */
    public void listCertificateRevocationLists(
        com.google.cloud.security.privateca.v1beta1.ListCertificateRevocationListsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.security.privateca.v1beta1.ListCertificateRevocationListsResponse>
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
     * Update a [CertificateRevocationList][google.cloud.security.privateca.v1beta1.CertificateRevocationList].
     * </pre>
     */
    public void updateCertificateRevocationList(
        com.google.cloud.security.privateca.v1beta1.UpdateCertificateRevocationListRequest request,
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
     * Returns a [ReusableConfig][google.cloud.security.privateca.v1beta1.ReusableConfig].
     * </pre>
     */
    public void getReusableConfig(
        com.google.cloud.security.privateca.v1beta1.GetReusableConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1beta1.ReusableConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetReusableConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists [ReusableConfigs][google.cloud.security.privateca.v1beta1.ReusableConfig].
     * </pre>
     */
    public void listReusableConfigs(
        com.google.cloud.security.privateca.v1beta1.ListReusableConfigsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.security.privateca.v1beta1.ListReusableConfigsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListReusableConfigsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * [Certificate Authority Service][google.cloud.security.privateca.v1beta1.CertificateAuthorityService] manages private
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
     * Create a new [Certificate][google.cloud.security.privateca.v1beta1.Certificate] in a given Project, Location from a particular
     * [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
     * </pre>
     */
    public com.google.cloud.security.privateca.v1beta1.Certificate createCertificate(
        com.google.cloud.security.privateca.v1beta1.CreateCertificateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCertificateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a [Certificate][google.cloud.security.privateca.v1beta1.Certificate].
     * </pre>
     */
    public com.google.cloud.security.privateca.v1beta1.Certificate getCertificate(
        com.google.cloud.security.privateca.v1beta1.GetCertificateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCertificateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists [Certificates][google.cloud.security.privateca.v1beta1.Certificate].
     * </pre>
     */
    public com.google.cloud.security.privateca.v1beta1.ListCertificatesResponse listCertificates(
        com.google.cloud.security.privateca.v1beta1.ListCertificatesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCertificatesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Revoke a [Certificate][google.cloud.security.privateca.v1beta1.Certificate].
     * </pre>
     */
    public com.google.cloud.security.privateca.v1beta1.Certificate revokeCertificate(
        com.google.cloud.security.privateca.v1beta1.RevokeCertificateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRevokeCertificateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a [Certificate][google.cloud.security.privateca.v1beta1.Certificate]. Currently, the only field you can update is the
     * [labels][google.cloud.security.privateca.v1beta1.Certificate.labels] field.
     * </pre>
     */
    public com.google.cloud.security.privateca.v1beta1.Certificate updateCertificate(
        com.google.cloud.security.privateca.v1beta1.UpdateCertificateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCertificateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Activate a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] that is in state
     * [PENDING_ACTIVATION][google.cloud.security.privateca.v1beta1.CertificateAuthority.State.PENDING_ACTIVATION] and is
     * of type [SUBORDINATE][google.cloud.security.privateca.v1beta1.CertificateAuthority.Type.SUBORDINATE]. After the
     * parent Certificate Authority signs a certificate signing request from
     * [FetchCertificateAuthorityCsr][google.cloud.security.privateca.v1beta1.CertificateAuthorityService.FetchCertificateAuthorityCsr], this method can complete the activation
     * process.
     * </pre>
     */
    public com.google.longrunning.Operation activateCertificateAuthority(
        com.google.cloud.security.privateca.v1beta1.ActivateCertificateAuthorityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getActivateCertificateAuthorityMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] in a given Project and Location.
     * </pre>
     */
    public com.google.longrunning.Operation createCertificateAuthority(
        com.google.cloud.security.privateca.v1beta1.CreateCertificateAuthorityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCertificateAuthorityMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Disable a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
     * </pre>
     */
    public com.google.longrunning.Operation disableCertificateAuthority(
        com.google.cloud.security.privateca.v1beta1.DisableCertificateAuthorityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDisableCertificateAuthorityMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Enable a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
     * </pre>
     */
    public com.google.longrunning.Operation enableCertificateAuthority(
        com.google.cloud.security.privateca.v1beta1.EnableCertificateAuthorityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEnableCertificateAuthorityMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetch a certificate signing request (CSR) from a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority]
     * that is in state
     * [PENDING_ACTIVATION][google.cloud.security.privateca.v1beta1.CertificateAuthority.State.PENDING_ACTIVATION] and is
     * of type [SUBORDINATE][google.cloud.security.privateca.v1beta1.CertificateAuthority.Type.SUBORDINATE]. The CSR must
     * then be signed by the desired parent Certificate Authority, which could be
     * another [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] resource, or could be an on-prem
     * certificate authority. See also [ActivateCertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthorityService.ActivateCertificateAuthority].
     * </pre>
     */
    public com.google.cloud.security.privateca.v1beta1.FetchCertificateAuthorityCsrResponse
        fetchCertificateAuthorityCsr(
            com.google.cloud.security.privateca.v1beta1.FetchCertificateAuthorityCsrRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchCertificateAuthorityCsrMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
     * </pre>
     */
    public com.google.cloud.security.privateca.v1beta1.CertificateAuthority getCertificateAuthority(
        com.google.cloud.security.privateca.v1beta1.GetCertificateAuthorityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCertificateAuthorityMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists [CertificateAuthorities][google.cloud.security.privateca.v1beta1.CertificateAuthority].
     * </pre>
     */
    public com.google.cloud.security.privateca.v1beta1.ListCertificateAuthoritiesResponse
        listCertificateAuthorities(
            com.google.cloud.security.privateca.v1beta1.ListCertificateAuthoritiesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCertificateAuthoritiesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Restore a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] that is scheduled for deletion.
     * </pre>
     */
    public com.google.longrunning.Operation restoreCertificateAuthority(
        com.google.cloud.security.privateca.v1beta1.RestoreCertificateAuthorityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestoreCertificateAuthorityMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Schedule a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] for deletion.
     * </pre>
     */
    public com.google.longrunning.Operation scheduleDeleteCertificateAuthority(
        com.google.cloud.security.privateca.v1beta1.ScheduleDeleteCertificateAuthorityRequest
            request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getScheduleDeleteCertificateAuthorityMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
     * </pre>
     */
    public com.google.longrunning.Operation updateCertificateAuthority(
        com.google.cloud.security.privateca.v1beta1.UpdateCertificateAuthorityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCertificateAuthorityMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a [CertificateRevocationList][google.cloud.security.privateca.v1beta1.CertificateRevocationList].
     * </pre>
     */
    public com.google.cloud.security.privateca.v1beta1.CertificateRevocationList
        getCertificateRevocationList(
            com.google.cloud.security.privateca.v1beta1.GetCertificateRevocationListRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCertificateRevocationListMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists [CertificateRevocationLists][google.cloud.security.privateca.v1beta1.CertificateRevocationList].
     * </pre>
     */
    public com.google.cloud.security.privateca.v1beta1.ListCertificateRevocationListsResponse
        listCertificateRevocationLists(
            com.google.cloud.security.privateca.v1beta1.ListCertificateRevocationListsRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCertificateRevocationListsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a [CertificateRevocationList][google.cloud.security.privateca.v1beta1.CertificateRevocationList].
     * </pre>
     */
    public com.google.longrunning.Operation updateCertificateRevocationList(
        com.google.cloud.security.privateca.v1beta1.UpdateCertificateRevocationListRequest
            request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCertificateRevocationListMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a [ReusableConfig][google.cloud.security.privateca.v1beta1.ReusableConfig].
     * </pre>
     */
    public com.google.cloud.security.privateca.v1beta1.ReusableConfig getReusableConfig(
        com.google.cloud.security.privateca.v1beta1.GetReusableConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetReusableConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists [ReusableConfigs][google.cloud.security.privateca.v1beta1.ReusableConfig].
     * </pre>
     */
    public com.google.cloud.security.privateca.v1beta1.ListReusableConfigsResponse
        listReusableConfigs(
            com.google.cloud.security.privateca.v1beta1.ListReusableConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListReusableConfigsMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * [Certificate Authority Service][google.cloud.security.privateca.v1beta1.CertificateAuthorityService] manages private
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
     * Create a new [Certificate][google.cloud.security.privateca.v1beta1.Certificate] in a given Project, Location from a particular
     * [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.security.privateca.v1beta1.Certificate>
        createCertificate(
            com.google.cloud.security.privateca.v1beta1.CreateCertificateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCertificateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a [Certificate][google.cloud.security.privateca.v1beta1.Certificate].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.security.privateca.v1beta1.Certificate>
        getCertificate(com.google.cloud.security.privateca.v1beta1.GetCertificateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCertificateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists [Certificates][google.cloud.security.privateca.v1beta1.Certificate].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.security.privateca.v1beta1.ListCertificatesResponse>
        listCertificates(
            com.google.cloud.security.privateca.v1beta1.ListCertificatesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCertificatesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Revoke a [Certificate][google.cloud.security.privateca.v1beta1.Certificate].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.security.privateca.v1beta1.Certificate>
        revokeCertificate(
            com.google.cloud.security.privateca.v1beta1.RevokeCertificateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRevokeCertificateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a [Certificate][google.cloud.security.privateca.v1beta1.Certificate]. Currently, the only field you can update is the
     * [labels][google.cloud.security.privateca.v1beta1.Certificate.labels] field.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.security.privateca.v1beta1.Certificate>
        updateCertificate(
            com.google.cloud.security.privateca.v1beta1.UpdateCertificateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCertificateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Activate a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] that is in state
     * [PENDING_ACTIVATION][google.cloud.security.privateca.v1beta1.CertificateAuthority.State.PENDING_ACTIVATION] and is
     * of type [SUBORDINATE][google.cloud.security.privateca.v1beta1.CertificateAuthority.Type.SUBORDINATE]. After the
     * parent Certificate Authority signs a certificate signing request from
     * [FetchCertificateAuthorityCsr][google.cloud.security.privateca.v1beta1.CertificateAuthorityService.FetchCertificateAuthorityCsr], this method can complete the activation
     * process.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        activateCertificateAuthority(
            com.google.cloud.security.privateca.v1beta1.ActivateCertificateAuthorityRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getActivateCertificateAuthorityMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] in a given Project and Location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createCertificateAuthority(
            com.google.cloud.security.privateca.v1beta1.CreateCertificateAuthorityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCertificateAuthorityMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Disable a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        disableCertificateAuthority(
            com.google.cloud.security.privateca.v1beta1.DisableCertificateAuthorityRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDisableCertificateAuthorityMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Enable a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        enableCertificateAuthority(
            com.google.cloud.security.privateca.v1beta1.EnableCertificateAuthorityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEnableCertificateAuthorityMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Fetch a certificate signing request (CSR) from a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority]
     * that is in state
     * [PENDING_ACTIVATION][google.cloud.security.privateca.v1beta1.CertificateAuthority.State.PENDING_ACTIVATION] and is
     * of type [SUBORDINATE][google.cloud.security.privateca.v1beta1.CertificateAuthority.Type.SUBORDINATE]. The CSR must
     * then be signed by the desired parent Certificate Authority, which could be
     * another [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] resource, or could be an on-prem
     * certificate authority. See also [ActivateCertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthorityService.ActivateCertificateAuthority].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.security.privateca.v1beta1.FetchCertificateAuthorityCsrResponse>
        fetchCertificateAuthorityCsr(
            com.google.cloud.security.privateca.v1beta1.FetchCertificateAuthorityCsrRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchCertificateAuthorityCsrMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.security.privateca.v1beta1.CertificateAuthority>
        getCertificateAuthority(
            com.google.cloud.security.privateca.v1beta1.GetCertificateAuthorityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCertificateAuthorityMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists [CertificateAuthorities][google.cloud.security.privateca.v1beta1.CertificateAuthority].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.security.privateca.v1beta1.ListCertificateAuthoritiesResponse>
        listCertificateAuthorities(
            com.google.cloud.security.privateca.v1beta1.ListCertificateAuthoritiesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCertificateAuthoritiesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Restore a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] that is scheduled for deletion.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        restoreCertificateAuthority(
            com.google.cloud.security.privateca.v1beta1.RestoreCertificateAuthorityRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRestoreCertificateAuthorityMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Schedule a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority] for deletion.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        scheduleDeleteCertificateAuthority(
            com.google.cloud.security.privateca.v1beta1.ScheduleDeleteCertificateAuthorityRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getScheduleDeleteCertificateAuthorityMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Update a [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateCertificateAuthority(
            com.google.cloud.security.privateca.v1beta1.UpdateCertificateAuthorityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCertificateAuthorityMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a [CertificateRevocationList][google.cloud.security.privateca.v1beta1.CertificateRevocationList].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.security.privateca.v1beta1.CertificateRevocationList>
        getCertificateRevocationList(
            com.google.cloud.security.privateca.v1beta1.GetCertificateRevocationListRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCertificateRevocationListMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists [CertificateRevocationLists][google.cloud.security.privateca.v1beta1.CertificateRevocationList].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.security.privateca.v1beta1.ListCertificateRevocationListsResponse>
        listCertificateRevocationLists(
            com.google.cloud.security.privateca.v1beta1.ListCertificateRevocationListsRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCertificateRevocationListsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Update a [CertificateRevocationList][google.cloud.security.privateca.v1beta1.CertificateRevocationList].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateCertificateRevocationList(
            com.google.cloud.security.privateca.v1beta1.UpdateCertificateRevocationListRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCertificateRevocationListMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Returns a [ReusableConfig][google.cloud.security.privateca.v1beta1.ReusableConfig].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.security.privateca.v1beta1.ReusableConfig>
        getReusableConfig(
            com.google.cloud.security.privateca.v1beta1.GetReusableConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetReusableConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists [ReusableConfigs][google.cloud.security.privateca.v1beta1.ReusableConfig].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.security.privateca.v1beta1.ListReusableConfigsResponse>
        listReusableConfigs(
            com.google.cloud.security.privateca.v1beta1.ListReusableConfigsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListReusableConfigsMethod(), getCallOptions()), request);
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
  private static final int METHODID_RESTORE_CERTIFICATE_AUTHORITY = 12;
  private static final int METHODID_SCHEDULE_DELETE_CERTIFICATE_AUTHORITY = 13;
  private static final int METHODID_UPDATE_CERTIFICATE_AUTHORITY = 14;
  private static final int METHODID_GET_CERTIFICATE_REVOCATION_LIST = 15;
  private static final int METHODID_LIST_CERTIFICATE_REVOCATION_LISTS = 16;
  private static final int METHODID_UPDATE_CERTIFICATE_REVOCATION_LIST = 17;
  private static final int METHODID_GET_REUSABLE_CONFIG = 18;
  private static final int METHODID_LIST_REUSABLE_CONFIGS = 19;

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
              (com.google.cloud.security.privateca.v1beta1.CreateCertificateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1beta1.Certificate>)
                  responseObserver);
          break;
        case METHODID_GET_CERTIFICATE:
          serviceImpl.getCertificate(
              (com.google.cloud.security.privateca.v1beta1.GetCertificateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1beta1.Certificate>)
                  responseObserver);
          break;
        case METHODID_LIST_CERTIFICATES:
          serviceImpl.listCertificates(
              (com.google.cloud.security.privateca.v1beta1.ListCertificatesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.security.privateca.v1beta1.ListCertificatesResponse>)
                  responseObserver);
          break;
        case METHODID_REVOKE_CERTIFICATE:
          serviceImpl.revokeCertificate(
              (com.google.cloud.security.privateca.v1beta1.RevokeCertificateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1beta1.Certificate>)
                  responseObserver);
          break;
        case METHODID_UPDATE_CERTIFICATE:
          serviceImpl.updateCertificate(
              (com.google.cloud.security.privateca.v1beta1.UpdateCertificateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1beta1.Certificate>)
                  responseObserver);
          break;
        case METHODID_ACTIVATE_CERTIFICATE_AUTHORITY:
          serviceImpl.activateCertificateAuthority(
              (com.google.cloud.security.privateca.v1beta1.ActivateCertificateAuthorityRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_CERTIFICATE_AUTHORITY:
          serviceImpl.createCertificateAuthority(
              (com.google.cloud.security.privateca.v1beta1.CreateCertificateAuthorityRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DISABLE_CERTIFICATE_AUTHORITY:
          serviceImpl.disableCertificateAuthority(
              (com.google.cloud.security.privateca.v1beta1.DisableCertificateAuthorityRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_ENABLE_CERTIFICATE_AUTHORITY:
          serviceImpl.enableCertificateAuthority(
              (com.google.cloud.security.privateca.v1beta1.EnableCertificateAuthorityRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_FETCH_CERTIFICATE_AUTHORITY_CSR:
          serviceImpl.fetchCertificateAuthorityCsr(
              (com.google.cloud.security.privateca.v1beta1.FetchCertificateAuthorityCsrRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.security.privateca.v1beta1
                          .FetchCertificateAuthorityCsrResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CERTIFICATE_AUTHORITY:
          serviceImpl.getCertificateAuthority(
              (com.google.cloud.security.privateca.v1beta1.GetCertificateAuthorityRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.security.privateca.v1beta1.CertificateAuthority>)
                  responseObserver);
          break;
        case METHODID_LIST_CERTIFICATE_AUTHORITIES:
          serviceImpl.listCertificateAuthorities(
              (com.google.cloud.security.privateca.v1beta1.ListCertificateAuthoritiesRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.security.privateca.v1beta1
                          .ListCertificateAuthoritiesResponse>)
                  responseObserver);
          break;
        case METHODID_RESTORE_CERTIFICATE_AUTHORITY:
          serviceImpl.restoreCertificateAuthority(
              (com.google.cloud.security.privateca.v1beta1.RestoreCertificateAuthorityRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_SCHEDULE_DELETE_CERTIFICATE_AUTHORITY:
          serviceImpl.scheduleDeleteCertificateAuthority(
              (com.google.cloud.security.privateca.v1beta1
                      .ScheduleDeleteCertificateAuthorityRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_CERTIFICATE_AUTHORITY:
          serviceImpl.updateCertificateAuthority(
              (com.google.cloud.security.privateca.v1beta1.UpdateCertificateAuthorityRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_CERTIFICATE_REVOCATION_LIST:
          serviceImpl.getCertificateRevocationList(
              (com.google.cloud.security.privateca.v1beta1.GetCertificateRevocationListRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.security.privateca.v1beta1.CertificateRevocationList>)
                  responseObserver);
          break;
        case METHODID_LIST_CERTIFICATE_REVOCATION_LISTS:
          serviceImpl.listCertificateRevocationLists(
              (com.google.cloud.security.privateca.v1beta1.ListCertificateRevocationListsRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.security.privateca.v1beta1
                          .ListCertificateRevocationListsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_CERTIFICATE_REVOCATION_LIST:
          serviceImpl.updateCertificateRevocationList(
              (com.google.cloud.security.privateca.v1beta1.UpdateCertificateRevocationListRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_REUSABLE_CONFIG:
          serviceImpl.getReusableConfig(
              (com.google.cloud.security.privateca.v1beta1.GetReusableConfigRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.security.privateca.v1beta1.ReusableConfig>)
                  responseObserver);
          break;
        case METHODID_LIST_REUSABLE_CONFIGS:
          serviceImpl.listReusableConfigs(
              (com.google.cloud.security.privateca.v1beta1.ListReusableConfigsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.security.privateca.v1beta1.ListReusableConfigsResponse>)
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

  private abstract static class CertificateAuthorityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CertificateAuthorityServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.security.privateca.v1beta1.PrivateCaProto.getDescriptor();
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
                      .addMethod(getRestoreCertificateAuthorityMethod())
                      .addMethod(getScheduleDeleteCertificateAuthorityMethod())
                      .addMethod(getUpdateCertificateAuthorityMethod())
                      .addMethod(getGetCertificateRevocationListMethod())
                      .addMethod(getListCertificateRevocationListsMethod())
                      .addMethod(getUpdateCertificateRevocationListMethod())
                      .addMethod(getGetReusableConfigMethod())
                      .addMethod(getListReusableConfigsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
