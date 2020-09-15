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
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

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
          com.google.cloud.security.privateca.v1beta1.CreateCertificateRevocationListRequest,
          com.google.longrunning.Operation>
      getCreateCertificateRevocationListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCertificateRevocationList",
      requestType =
          com.google.cloud.security.privateca.v1beta1.CreateCertificateRevocationListRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1beta1.CreateCertificateRevocationListRequest,
          com.google.longrunning.Operation>
      getCreateCertificateRevocationListMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1beta1.CreateCertificateRevocationListRequest,
            com.google.longrunning.Operation>
        getCreateCertificateRevocationListMethod;
    if ((getCreateCertificateRevocationListMethod =
            CertificateAuthorityServiceGrpc.getCreateCertificateRevocationListMethod)
        == null) {
      synchronized (CertificateAuthorityServiceGrpc.class) {
        if ((getCreateCertificateRevocationListMethod =
                CertificateAuthorityServiceGrpc.getCreateCertificateRevocationListMethod)
            == null) {
          CertificateAuthorityServiceGrpc.getCreateCertificateRevocationListMethod =
              getCreateCertificateRevocationListMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.privateca.v1beta1
                              .CreateCertificateRevocationListRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateCertificateRevocationList"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1beta1
                                  .CreateCertificateRevocationListRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateAuthorityServiceMethodDescriptorSupplier(
                              "CreateCertificateRevocationList"))
                      .build();
        }
      }
    }
    return getCreateCertificateRevocationListMethod;
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
          com.google.cloud.security.privateca.v1beta1.CreateReusableConfigRequest,
          com.google.longrunning.Operation>
      getCreateReusableConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateReusableConfig",
      requestType = com.google.cloud.security.privateca.v1beta1.CreateReusableConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1beta1.CreateReusableConfigRequest,
          com.google.longrunning.Operation>
      getCreateReusableConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1beta1.CreateReusableConfigRequest,
            com.google.longrunning.Operation>
        getCreateReusableConfigMethod;
    if ((getCreateReusableConfigMethod =
            CertificateAuthorityServiceGrpc.getCreateReusableConfigMethod)
        == null) {
      synchronized (CertificateAuthorityServiceGrpc.class) {
        if ((getCreateReusableConfigMethod =
                CertificateAuthorityServiceGrpc.getCreateReusableConfigMethod)
            == null) {
          CertificateAuthorityServiceGrpc.getCreateReusableConfigMethod =
              getCreateReusableConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.privateca.v1beta1.CreateReusableConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateReusableConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1beta1
                                  .CreateReusableConfigRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateAuthorityServiceMethodDescriptorSupplier(
                              "CreateReusableConfig"))
                      .build();
        }
      }
    }
    return getCreateReusableConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1beta1.DeleteReusableConfigRequest,
          com.google.longrunning.Operation>
      getDeleteReusableConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteReusableConfig",
      requestType = com.google.cloud.security.privateca.v1beta1.DeleteReusableConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1beta1.DeleteReusableConfigRequest,
          com.google.longrunning.Operation>
      getDeleteReusableConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1beta1.DeleteReusableConfigRequest,
            com.google.longrunning.Operation>
        getDeleteReusableConfigMethod;
    if ((getDeleteReusableConfigMethod =
            CertificateAuthorityServiceGrpc.getDeleteReusableConfigMethod)
        == null) {
      synchronized (CertificateAuthorityServiceGrpc.class) {
        if ((getDeleteReusableConfigMethod =
                CertificateAuthorityServiceGrpc.getDeleteReusableConfigMethod)
            == null) {
          CertificateAuthorityServiceGrpc.getDeleteReusableConfigMethod =
              getDeleteReusableConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.privateca.v1beta1.DeleteReusableConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteReusableConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1beta1
                                  .DeleteReusableConfigRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateAuthorityServiceMethodDescriptorSupplier(
                              "DeleteReusableConfig"))
                      .build();
        }
      }
    }
    return getDeleteReusableConfigMethod;
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1beta1.UpdateReusableConfigRequest,
          com.google.longrunning.Operation>
      getUpdateReusableConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateReusableConfig",
      requestType = com.google.cloud.security.privateca.v1beta1.UpdateReusableConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.privateca.v1beta1.UpdateReusableConfigRequest,
          com.google.longrunning.Operation>
      getUpdateReusableConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.privateca.v1beta1.UpdateReusableConfigRequest,
            com.google.longrunning.Operation>
        getUpdateReusableConfigMethod;
    if ((getUpdateReusableConfigMethod =
            CertificateAuthorityServiceGrpc.getUpdateReusableConfigMethod)
        == null) {
      synchronized (CertificateAuthorityServiceGrpc.class) {
        if ((getUpdateReusableConfigMethod =
                CertificateAuthorityServiceGrpc.getUpdateReusableConfigMethod)
            == null) {
          CertificateAuthorityServiceGrpc.getUpdateReusableConfigMethod =
              getUpdateReusableConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.privateca.v1beta1.UpdateReusableConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateReusableConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.privateca.v1beta1
                                  .UpdateReusableConfigRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CertificateAuthorityServiceMethodDescriptorSupplier(
                              "UpdateReusableConfig"))
                      .build();
        }
      }
    }
    return getUpdateReusableConfigMethod;
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
      asyncUnimplementedUnaryCall(getCreateCertificateMethod(), responseObserver);
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
      asyncUnimplementedUnaryCall(getGetCertificateMethod(), responseObserver);
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
      asyncUnimplementedUnaryCall(getListCertificatesMethod(), responseObserver);
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
      asyncUnimplementedUnaryCall(getRevokeCertificateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a [Certificate][google.cloud.security.privateca.v1beta1.Certificate].
     * </pre>
     */
    public void updateCertificate(
        com.google.cloud.security.privateca.v1beta1.UpdateCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1beta1.Certificate>
            responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateCertificateMethod(), responseObserver);
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
      asyncUnimplementedUnaryCall(getActivateCertificateAuthorityMethod(), responseObserver);
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
      asyncUnimplementedUnaryCall(getCreateCertificateAuthorityMethod(), responseObserver);
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
      asyncUnimplementedUnaryCall(getDisableCertificateAuthorityMethod(), responseObserver);
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
      asyncUnimplementedUnaryCall(getEnableCertificateAuthorityMethod(), responseObserver);
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
      asyncUnimplementedUnaryCall(getFetchCertificateAuthorityCsrMethod(), responseObserver);
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
      asyncUnimplementedUnaryCall(getGetCertificateAuthorityMethod(), responseObserver);
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
      asyncUnimplementedUnaryCall(getListCertificateAuthoritiesMethod(), responseObserver);
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
      asyncUnimplementedUnaryCall(getRestoreCertificateAuthorityMethod(), responseObserver);
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
      asyncUnimplementedUnaryCall(getScheduleDeleteCertificateAuthorityMethod(), responseObserver);
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
      asyncUnimplementedUnaryCall(getUpdateCertificateAuthorityMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new [CertificateRevocationList][google.cloud.security.privateca.v1beta1.CertificateRevocationList] in a given Project, Location
     * for a particular [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
     * </pre>
     */
    public void createCertificateRevocationList(
        com.google.cloud.security.privateca.v1beta1.CreateCertificateRevocationListRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateCertificateRevocationListMethod(), responseObserver);
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
      asyncUnimplementedUnaryCall(getGetCertificateRevocationListMethod(), responseObserver);
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
      asyncUnimplementedUnaryCall(getListCertificateRevocationListsMethod(), responseObserver);
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
      asyncUnimplementedUnaryCall(getUpdateCertificateRevocationListMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new [ReusableConfig][google.cloud.security.privateca.v1beta1.ReusableConfig] in a given Project and Location.
     * </pre>
     */
    public void createReusableConfig(
        com.google.cloud.security.privateca.v1beta1.CreateReusableConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateReusableConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * DeleteReusableConfig deletes a [ReusableConfig][google.cloud.security.privateca.v1beta1.ReusableConfig].
     * </pre>
     */
    public void deleteReusableConfig(
        com.google.cloud.security.privateca.v1beta1.DeleteReusableConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteReusableConfigMethod(), responseObserver);
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
      asyncUnimplementedUnaryCall(getGetReusableConfigMethod(), responseObserver);
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
      asyncUnimplementedUnaryCall(getListReusableConfigsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a [ReusableConfig][google.cloud.security.privateca.v1beta1.ReusableConfig].
     * </pre>
     */
    public void updateReusableConfig(
        com.google.cloud.security.privateca.v1beta1.UpdateReusableConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateReusableConfigMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateCertificateMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1.CreateCertificateRequest,
                      com.google.cloud.security.privateca.v1beta1.Certificate>(
                      this, METHODID_CREATE_CERTIFICATE)))
          .addMethod(
              getGetCertificateMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1.GetCertificateRequest,
                      com.google.cloud.security.privateca.v1beta1.Certificate>(
                      this, METHODID_GET_CERTIFICATE)))
          .addMethod(
              getListCertificatesMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1.ListCertificatesRequest,
                      com.google.cloud.security.privateca.v1beta1.ListCertificatesResponse>(
                      this, METHODID_LIST_CERTIFICATES)))
          .addMethod(
              getRevokeCertificateMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1.RevokeCertificateRequest,
                      com.google.cloud.security.privateca.v1beta1.Certificate>(
                      this, METHODID_REVOKE_CERTIFICATE)))
          .addMethod(
              getUpdateCertificateMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1.UpdateCertificateRequest,
                      com.google.cloud.security.privateca.v1beta1.Certificate>(
                      this, METHODID_UPDATE_CERTIFICATE)))
          .addMethod(
              getActivateCertificateAuthorityMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1
                          .ActivateCertificateAuthorityRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_ACTIVATE_CERTIFICATE_AUTHORITY)))
          .addMethod(
              getCreateCertificateAuthorityMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1.CreateCertificateAuthorityRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_CREATE_CERTIFICATE_AUTHORITY)))
          .addMethod(
              getDisableCertificateAuthorityMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1
                          .DisableCertificateAuthorityRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_DISABLE_CERTIFICATE_AUTHORITY)))
          .addMethod(
              getEnableCertificateAuthorityMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1.EnableCertificateAuthorityRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_ENABLE_CERTIFICATE_AUTHORITY)))
          .addMethod(
              getFetchCertificateAuthorityCsrMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1
                          .FetchCertificateAuthorityCsrRequest,
                      com.google.cloud.security.privateca.v1beta1
                          .FetchCertificateAuthorityCsrResponse>(
                      this, METHODID_FETCH_CERTIFICATE_AUTHORITY_CSR)))
          .addMethod(
              getGetCertificateAuthorityMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1.GetCertificateAuthorityRequest,
                      com.google.cloud.security.privateca.v1beta1.CertificateAuthority>(
                      this, METHODID_GET_CERTIFICATE_AUTHORITY)))
          .addMethod(
              getListCertificateAuthoritiesMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1.ListCertificateAuthoritiesRequest,
                      com.google.cloud.security.privateca.v1beta1
                          .ListCertificateAuthoritiesResponse>(
                      this, METHODID_LIST_CERTIFICATE_AUTHORITIES)))
          .addMethod(
              getRestoreCertificateAuthorityMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1
                          .RestoreCertificateAuthorityRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_RESTORE_CERTIFICATE_AUTHORITY)))
          .addMethod(
              getScheduleDeleteCertificateAuthorityMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1
                          .ScheduleDeleteCertificateAuthorityRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_SCHEDULE_DELETE_CERTIFICATE_AUTHORITY)))
          .addMethod(
              getUpdateCertificateAuthorityMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1.UpdateCertificateAuthorityRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_UPDATE_CERTIFICATE_AUTHORITY)))
          .addMethod(
              getCreateCertificateRevocationListMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1
                          .CreateCertificateRevocationListRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_CREATE_CERTIFICATE_REVOCATION_LIST)))
          .addMethod(
              getGetCertificateRevocationListMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1
                          .GetCertificateRevocationListRequest,
                      com.google.cloud.security.privateca.v1beta1.CertificateRevocationList>(
                      this, METHODID_GET_CERTIFICATE_REVOCATION_LIST)))
          .addMethod(
              getListCertificateRevocationListsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1
                          .ListCertificateRevocationListsRequest,
                      com.google.cloud.security.privateca.v1beta1
                          .ListCertificateRevocationListsResponse>(
                      this, METHODID_LIST_CERTIFICATE_REVOCATION_LISTS)))
          .addMethod(
              getUpdateCertificateRevocationListMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1
                          .UpdateCertificateRevocationListRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_UPDATE_CERTIFICATE_REVOCATION_LIST)))
          .addMethod(
              getCreateReusableConfigMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1.CreateReusableConfigRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_REUSABLE_CONFIG)))
          .addMethod(
              getDeleteReusableConfigMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1.DeleteReusableConfigRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_REUSABLE_CONFIG)))
          .addMethod(
              getGetReusableConfigMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1.GetReusableConfigRequest,
                      com.google.cloud.security.privateca.v1beta1.ReusableConfig>(
                      this, METHODID_GET_REUSABLE_CONFIG)))
          .addMethod(
              getListReusableConfigsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1.ListReusableConfigsRequest,
                      com.google.cloud.security.privateca.v1beta1.ListReusableConfigsResponse>(
                      this, METHODID_LIST_REUSABLE_CONFIGS)))
          .addMethod(
              getUpdateReusableConfigMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.privateca.v1beta1.UpdateReusableConfigRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_REUSABLE_CONFIG)))
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
      asyncUnaryCall(
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
      asyncUnaryCall(
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
      asyncUnaryCall(
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
      asyncUnaryCall(
          getChannel().newCall(getRevokeCertificateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a [Certificate][google.cloud.security.privateca.v1beta1.Certificate].
     * </pre>
     */
    public void updateCertificate(
        com.google.cloud.security.privateca.v1beta1.UpdateCertificateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.security.privateca.v1beta1.Certificate>
            responseObserver) {
      asyncUnaryCall(
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
      asyncUnaryCall(
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
      asyncUnaryCall(
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
      asyncUnaryCall(
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
      asyncUnaryCall(
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
      asyncUnaryCall(
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
      asyncUnaryCall(
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
      asyncUnaryCall(
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
      asyncUnaryCall(
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
      asyncUnaryCall(
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
      asyncUnaryCall(
          getChannel().newCall(getUpdateCertificateAuthorityMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new [CertificateRevocationList][google.cloud.security.privateca.v1beta1.CertificateRevocationList] in a given Project, Location
     * for a particular [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
     * </pre>
     */
    public void createCertificateRevocationList(
        com.google.cloud.security.privateca.v1beta1.CreateCertificateRevocationListRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateCertificateRevocationListMethod(), getCallOptions()),
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
      asyncUnaryCall(
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
      asyncUnaryCall(
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
      asyncUnaryCall(
          getChannel().newCall(getUpdateCertificateRevocationListMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new [ReusableConfig][google.cloud.security.privateca.v1beta1.ReusableConfig] in a given Project and Location.
     * </pre>
     */
    public void createReusableConfig(
        com.google.cloud.security.privateca.v1beta1.CreateReusableConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateReusableConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * DeleteReusableConfig deletes a [ReusableConfig][google.cloud.security.privateca.v1beta1.ReusableConfig].
     * </pre>
     */
    public void deleteReusableConfig(
        com.google.cloud.security.privateca.v1beta1.DeleteReusableConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteReusableConfigMethod(), getCallOptions()),
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
      asyncUnaryCall(
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
      asyncUnaryCall(
          getChannel().newCall(getListReusableConfigsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a [ReusableConfig][google.cloud.security.privateca.v1beta1.ReusableConfig].
     * </pre>
     */
    public void updateReusableConfig(
        com.google.cloud.security.privateca.v1beta1.UpdateReusableConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateReusableConfigMethod(), getCallOptions()),
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
      return blockingUnaryCall(
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
      return blockingUnaryCall(getChannel(), getGetCertificateMethod(), getCallOptions(), request);
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
      return blockingUnaryCall(
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
      return blockingUnaryCall(
          getChannel(), getRevokeCertificateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a [Certificate][google.cloud.security.privateca.v1beta1.Certificate].
     * </pre>
     */
    public com.google.cloud.security.privateca.v1beta1.Certificate updateCertificate(
        com.google.cloud.security.privateca.v1beta1.UpdateCertificateRequest request) {
      return blockingUnaryCall(
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
      return blockingUnaryCall(
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
      return blockingUnaryCall(
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
      return blockingUnaryCall(
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
      return blockingUnaryCall(
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
      return blockingUnaryCall(
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
      return blockingUnaryCall(
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
      return blockingUnaryCall(
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
      return blockingUnaryCall(
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
      return blockingUnaryCall(
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
      return blockingUnaryCall(
          getChannel(), getUpdateCertificateAuthorityMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new [CertificateRevocationList][google.cloud.security.privateca.v1beta1.CertificateRevocationList] in a given Project, Location
     * for a particular [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
     * </pre>
     */
    public com.google.longrunning.Operation createCertificateRevocationList(
        com.google.cloud.security.privateca.v1beta1.CreateCertificateRevocationListRequest
            request) {
      return blockingUnaryCall(
          getChannel(), getCreateCertificateRevocationListMethod(), getCallOptions(), request);
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
      return blockingUnaryCall(
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
      return blockingUnaryCall(
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
      return blockingUnaryCall(
          getChannel(), getUpdateCertificateRevocationListMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new [ReusableConfig][google.cloud.security.privateca.v1beta1.ReusableConfig] in a given Project and Location.
     * </pre>
     */
    public com.google.longrunning.Operation createReusableConfig(
        com.google.cloud.security.privateca.v1beta1.CreateReusableConfigRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateReusableConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * DeleteReusableConfig deletes a [ReusableConfig][google.cloud.security.privateca.v1beta1.ReusableConfig].
     * </pre>
     */
    public com.google.longrunning.Operation deleteReusableConfig(
        com.google.cloud.security.privateca.v1beta1.DeleteReusableConfigRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteReusableConfigMethod(), getCallOptions(), request);
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
      return blockingUnaryCall(
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
      return blockingUnaryCall(
          getChannel(), getListReusableConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a [ReusableConfig][google.cloud.security.privateca.v1beta1.ReusableConfig].
     * </pre>
     */
    public com.google.longrunning.Operation updateReusableConfig(
        com.google.cloud.security.privateca.v1beta1.UpdateReusableConfigRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateReusableConfigMethod(), getCallOptions(), request);
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
      return futureUnaryCall(
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
      return futureUnaryCall(
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
      return futureUnaryCall(
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
      return futureUnaryCall(
          getChannel().newCall(getRevokeCertificateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a [Certificate][google.cloud.security.privateca.v1beta1.Certificate].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.security.privateca.v1beta1.Certificate>
        updateCertificate(
            com.google.cloud.security.privateca.v1beta1.UpdateCertificateRequest request) {
      return futureUnaryCall(
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
      return futureUnaryCall(
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
      return futureUnaryCall(
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
      return futureUnaryCall(
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
      return futureUnaryCall(
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
      return futureUnaryCall(
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
      return futureUnaryCall(
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
      return futureUnaryCall(
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
      return futureUnaryCall(
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
      return futureUnaryCall(
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
      return futureUnaryCall(
          getChannel().newCall(getUpdateCertificateAuthorityMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new [CertificateRevocationList][google.cloud.security.privateca.v1beta1.CertificateRevocationList] in a given Project, Location
     * for a particular [CertificateAuthority][google.cloud.security.privateca.v1beta1.CertificateAuthority].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createCertificateRevocationList(
            com.google.cloud.security.privateca.v1beta1.CreateCertificateRevocationListRequest
                request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateCertificateRevocationListMethod(), getCallOptions()),
          request);
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
      return futureUnaryCall(
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
      return futureUnaryCall(
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
      return futureUnaryCall(
          getChannel().newCall(getUpdateCertificateRevocationListMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Create a new [ReusableConfig][google.cloud.security.privateca.v1beta1.ReusableConfig] in a given Project and Location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createReusableConfig(
            com.google.cloud.security.privateca.v1beta1.CreateReusableConfigRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateReusableConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * DeleteReusableConfig deletes a [ReusableConfig][google.cloud.security.privateca.v1beta1.ReusableConfig].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteReusableConfig(
            com.google.cloud.security.privateca.v1beta1.DeleteReusableConfigRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteReusableConfigMethod(), getCallOptions()), request);
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
      return futureUnaryCall(
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
      return futureUnaryCall(
          getChannel().newCall(getListReusableConfigsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a [ReusableConfig][google.cloud.security.privateca.v1beta1.ReusableConfig].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateReusableConfig(
            com.google.cloud.security.privateca.v1beta1.UpdateReusableConfigRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateReusableConfigMethod(), getCallOptions()), request);
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
  private static final int METHODID_CREATE_CERTIFICATE_REVOCATION_LIST = 15;
  private static final int METHODID_GET_CERTIFICATE_REVOCATION_LIST = 16;
  private static final int METHODID_LIST_CERTIFICATE_REVOCATION_LISTS = 17;
  private static final int METHODID_UPDATE_CERTIFICATE_REVOCATION_LIST = 18;
  private static final int METHODID_CREATE_REUSABLE_CONFIG = 19;
  private static final int METHODID_DELETE_REUSABLE_CONFIG = 20;
  private static final int METHODID_GET_REUSABLE_CONFIG = 21;
  private static final int METHODID_LIST_REUSABLE_CONFIGS = 22;
  private static final int METHODID_UPDATE_REUSABLE_CONFIG = 23;

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
        case METHODID_CREATE_CERTIFICATE_REVOCATION_LIST:
          serviceImpl.createCertificateRevocationList(
              (com.google.cloud.security.privateca.v1beta1.CreateCertificateRevocationListRequest)
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
        case METHODID_CREATE_REUSABLE_CONFIG:
          serviceImpl.createReusableConfig(
              (com.google.cloud.security.privateca.v1beta1.CreateReusableConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_REUSABLE_CONFIG:
          serviceImpl.deleteReusableConfig(
              (com.google.cloud.security.privateca.v1beta1.DeleteReusableConfigRequest) request,
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
        case METHODID_UPDATE_REUSABLE_CONFIG:
          serviceImpl.updateReusableConfig(
              (com.google.cloud.security.privateca.v1beta1.UpdateReusableConfigRequest) request,
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
                      .addMethod(getCreateCertificateRevocationListMethod())
                      .addMethod(getGetCertificateRevocationListMethod())
                      .addMethod(getListCertificateRevocationListsMethod())
                      .addMethod(getUpdateCertificateRevocationListMethod())
                      .addMethod(getCreateReusableConfigMethod())
                      .addMethod(getDeleteReusableConfigMethod())
                      .addMethod(getGetReusableConfigMethod())
                      .addMethod(getListReusableConfigsMethod())
                      .addMethod(getUpdateReusableConfigMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
