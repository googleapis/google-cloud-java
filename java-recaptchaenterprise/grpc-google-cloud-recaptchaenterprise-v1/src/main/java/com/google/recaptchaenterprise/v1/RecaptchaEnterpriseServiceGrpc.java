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
package com.google.recaptchaenterprise.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service to determine the likelihood an event is legitimate.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/recaptchaenterprise/v1/recaptchaenterprise.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RecaptchaEnterpriseServiceGrpc {

  private RecaptchaEnterpriseServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.CreateAssessmentRequest,
          com.google.recaptchaenterprise.v1.Assessment>
      getCreateAssessmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAssessment",
      requestType = com.google.recaptchaenterprise.v1.CreateAssessmentRequest.class,
      responseType = com.google.recaptchaenterprise.v1.Assessment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.CreateAssessmentRequest,
          com.google.recaptchaenterprise.v1.Assessment>
      getCreateAssessmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.recaptchaenterprise.v1.CreateAssessmentRequest,
            com.google.recaptchaenterprise.v1.Assessment>
        getCreateAssessmentMethod;
    if ((getCreateAssessmentMethod = RecaptchaEnterpriseServiceGrpc.getCreateAssessmentMethod)
        == null) {
      synchronized (RecaptchaEnterpriseServiceGrpc.class) {
        if ((getCreateAssessmentMethod = RecaptchaEnterpriseServiceGrpc.getCreateAssessmentMethod)
            == null) {
          RecaptchaEnterpriseServiceGrpc.getCreateAssessmentMethod =
              getCreateAssessmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.recaptchaenterprise.v1.CreateAssessmentRequest,
                          com.google.recaptchaenterprise.v1.Assessment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAssessment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.CreateAssessmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.Assessment.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceMethodDescriptorSupplier(
                              "CreateAssessment"))
                      .build();
        }
      }
    }
    return getCreateAssessmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.AnnotateAssessmentRequest,
          com.google.recaptchaenterprise.v1.AnnotateAssessmentResponse>
      getAnnotateAssessmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AnnotateAssessment",
      requestType = com.google.recaptchaenterprise.v1.AnnotateAssessmentRequest.class,
      responseType = com.google.recaptchaenterprise.v1.AnnotateAssessmentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.AnnotateAssessmentRequest,
          com.google.recaptchaenterprise.v1.AnnotateAssessmentResponse>
      getAnnotateAssessmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.recaptchaenterprise.v1.AnnotateAssessmentRequest,
            com.google.recaptchaenterprise.v1.AnnotateAssessmentResponse>
        getAnnotateAssessmentMethod;
    if ((getAnnotateAssessmentMethod = RecaptchaEnterpriseServiceGrpc.getAnnotateAssessmentMethod)
        == null) {
      synchronized (RecaptchaEnterpriseServiceGrpc.class) {
        if ((getAnnotateAssessmentMethod =
                RecaptchaEnterpriseServiceGrpc.getAnnotateAssessmentMethod)
            == null) {
          RecaptchaEnterpriseServiceGrpc.getAnnotateAssessmentMethod =
              getAnnotateAssessmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.recaptchaenterprise.v1.AnnotateAssessmentRequest,
                          com.google.recaptchaenterprise.v1.AnnotateAssessmentResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AnnotateAssessment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.AnnotateAssessmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.AnnotateAssessmentResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceMethodDescriptorSupplier(
                              "AnnotateAssessment"))
                      .build();
        }
      }
    }
    return getAnnotateAssessmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.CreateKeyRequest, com.google.recaptchaenterprise.v1.Key>
      getCreateKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateKey",
      requestType = com.google.recaptchaenterprise.v1.CreateKeyRequest.class,
      responseType = com.google.recaptchaenterprise.v1.Key.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.CreateKeyRequest, com.google.recaptchaenterprise.v1.Key>
      getCreateKeyMethod() {
    io.grpc.MethodDescriptor<
            com.google.recaptchaenterprise.v1.CreateKeyRequest,
            com.google.recaptchaenterprise.v1.Key>
        getCreateKeyMethod;
    if ((getCreateKeyMethod = RecaptchaEnterpriseServiceGrpc.getCreateKeyMethod) == null) {
      synchronized (RecaptchaEnterpriseServiceGrpc.class) {
        if ((getCreateKeyMethod = RecaptchaEnterpriseServiceGrpc.getCreateKeyMethod) == null) {
          RecaptchaEnterpriseServiceGrpc.getCreateKeyMethod =
              getCreateKeyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.recaptchaenterprise.v1.CreateKeyRequest,
                          com.google.recaptchaenterprise.v1.Key>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateKey"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.CreateKeyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.Key.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceMethodDescriptorSupplier("CreateKey"))
                      .build();
        }
      }
    }
    return getCreateKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.ListKeysRequest,
          com.google.recaptchaenterprise.v1.ListKeysResponse>
      getListKeysMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListKeys",
      requestType = com.google.recaptchaenterprise.v1.ListKeysRequest.class,
      responseType = com.google.recaptchaenterprise.v1.ListKeysResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.ListKeysRequest,
          com.google.recaptchaenterprise.v1.ListKeysResponse>
      getListKeysMethod() {
    io.grpc.MethodDescriptor<
            com.google.recaptchaenterprise.v1.ListKeysRequest,
            com.google.recaptchaenterprise.v1.ListKeysResponse>
        getListKeysMethod;
    if ((getListKeysMethod = RecaptchaEnterpriseServiceGrpc.getListKeysMethod) == null) {
      synchronized (RecaptchaEnterpriseServiceGrpc.class) {
        if ((getListKeysMethod = RecaptchaEnterpriseServiceGrpc.getListKeysMethod) == null) {
          RecaptchaEnterpriseServiceGrpc.getListKeysMethod =
              getListKeysMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.recaptchaenterprise.v1.ListKeysRequest,
                          com.google.recaptchaenterprise.v1.ListKeysResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListKeys"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.ListKeysRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.ListKeysResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceMethodDescriptorSupplier("ListKeys"))
                      .build();
        }
      }
    }
    return getListKeysMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.RetrieveLegacySecretKeyRequest,
          com.google.recaptchaenterprise.v1.RetrieveLegacySecretKeyResponse>
      getRetrieveLegacySecretKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RetrieveLegacySecretKey",
      requestType = com.google.recaptchaenterprise.v1.RetrieveLegacySecretKeyRequest.class,
      responseType = com.google.recaptchaenterprise.v1.RetrieveLegacySecretKeyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.RetrieveLegacySecretKeyRequest,
          com.google.recaptchaenterprise.v1.RetrieveLegacySecretKeyResponse>
      getRetrieveLegacySecretKeyMethod() {
    io.grpc.MethodDescriptor<
            com.google.recaptchaenterprise.v1.RetrieveLegacySecretKeyRequest,
            com.google.recaptchaenterprise.v1.RetrieveLegacySecretKeyResponse>
        getRetrieveLegacySecretKeyMethod;
    if ((getRetrieveLegacySecretKeyMethod =
            RecaptchaEnterpriseServiceGrpc.getRetrieveLegacySecretKeyMethod)
        == null) {
      synchronized (RecaptchaEnterpriseServiceGrpc.class) {
        if ((getRetrieveLegacySecretKeyMethod =
                RecaptchaEnterpriseServiceGrpc.getRetrieveLegacySecretKeyMethod)
            == null) {
          RecaptchaEnterpriseServiceGrpc.getRetrieveLegacySecretKeyMethod =
              getRetrieveLegacySecretKeyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.recaptchaenterprise.v1.RetrieveLegacySecretKeyRequest,
                          com.google.recaptchaenterprise.v1.RetrieveLegacySecretKeyResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RetrieveLegacySecretKey"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.RetrieveLegacySecretKeyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.RetrieveLegacySecretKeyResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceMethodDescriptorSupplier(
                              "RetrieveLegacySecretKey"))
                      .build();
        }
      }
    }
    return getRetrieveLegacySecretKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.GetKeyRequest, com.google.recaptchaenterprise.v1.Key>
      getGetKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetKey",
      requestType = com.google.recaptchaenterprise.v1.GetKeyRequest.class,
      responseType = com.google.recaptchaenterprise.v1.Key.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.GetKeyRequest, com.google.recaptchaenterprise.v1.Key>
      getGetKeyMethod() {
    io.grpc.MethodDescriptor<
            com.google.recaptchaenterprise.v1.GetKeyRequest, com.google.recaptchaenterprise.v1.Key>
        getGetKeyMethod;
    if ((getGetKeyMethod = RecaptchaEnterpriseServiceGrpc.getGetKeyMethod) == null) {
      synchronized (RecaptchaEnterpriseServiceGrpc.class) {
        if ((getGetKeyMethod = RecaptchaEnterpriseServiceGrpc.getGetKeyMethod) == null) {
          RecaptchaEnterpriseServiceGrpc.getGetKeyMethod =
              getGetKeyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.recaptchaenterprise.v1.GetKeyRequest,
                          com.google.recaptchaenterprise.v1.Key>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetKey"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.GetKeyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.Key.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceMethodDescriptorSupplier("GetKey"))
                      .build();
        }
      }
    }
    return getGetKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.UpdateKeyRequest, com.google.recaptchaenterprise.v1.Key>
      getUpdateKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateKey",
      requestType = com.google.recaptchaenterprise.v1.UpdateKeyRequest.class,
      responseType = com.google.recaptchaenterprise.v1.Key.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.UpdateKeyRequest, com.google.recaptchaenterprise.v1.Key>
      getUpdateKeyMethod() {
    io.grpc.MethodDescriptor<
            com.google.recaptchaenterprise.v1.UpdateKeyRequest,
            com.google.recaptchaenterprise.v1.Key>
        getUpdateKeyMethod;
    if ((getUpdateKeyMethod = RecaptchaEnterpriseServiceGrpc.getUpdateKeyMethod) == null) {
      synchronized (RecaptchaEnterpriseServiceGrpc.class) {
        if ((getUpdateKeyMethod = RecaptchaEnterpriseServiceGrpc.getUpdateKeyMethod) == null) {
          RecaptchaEnterpriseServiceGrpc.getUpdateKeyMethod =
              getUpdateKeyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.recaptchaenterprise.v1.UpdateKeyRequest,
                          com.google.recaptchaenterprise.v1.Key>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateKey"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.UpdateKeyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.Key.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceMethodDescriptorSupplier("UpdateKey"))
                      .build();
        }
      }
    }
    return getUpdateKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.DeleteKeyRequest, com.google.protobuf.Empty>
      getDeleteKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteKey",
      requestType = com.google.recaptchaenterprise.v1.DeleteKeyRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.DeleteKeyRequest, com.google.protobuf.Empty>
      getDeleteKeyMethod() {
    io.grpc.MethodDescriptor<
            com.google.recaptchaenterprise.v1.DeleteKeyRequest, com.google.protobuf.Empty>
        getDeleteKeyMethod;
    if ((getDeleteKeyMethod = RecaptchaEnterpriseServiceGrpc.getDeleteKeyMethod) == null) {
      synchronized (RecaptchaEnterpriseServiceGrpc.class) {
        if ((getDeleteKeyMethod = RecaptchaEnterpriseServiceGrpc.getDeleteKeyMethod) == null) {
          RecaptchaEnterpriseServiceGrpc.getDeleteKeyMethod =
              getDeleteKeyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.recaptchaenterprise.v1.DeleteKeyRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteKey"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.DeleteKeyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceMethodDescriptorSupplier("DeleteKey"))
                      .build();
        }
      }
    }
    return getDeleteKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.MigrateKeyRequest,
          com.google.recaptchaenterprise.v1.Key>
      getMigrateKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MigrateKey",
      requestType = com.google.recaptchaenterprise.v1.MigrateKeyRequest.class,
      responseType = com.google.recaptchaenterprise.v1.Key.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.MigrateKeyRequest,
          com.google.recaptchaenterprise.v1.Key>
      getMigrateKeyMethod() {
    io.grpc.MethodDescriptor<
            com.google.recaptchaenterprise.v1.MigrateKeyRequest,
            com.google.recaptchaenterprise.v1.Key>
        getMigrateKeyMethod;
    if ((getMigrateKeyMethod = RecaptchaEnterpriseServiceGrpc.getMigrateKeyMethod) == null) {
      synchronized (RecaptchaEnterpriseServiceGrpc.class) {
        if ((getMigrateKeyMethod = RecaptchaEnterpriseServiceGrpc.getMigrateKeyMethod) == null) {
          RecaptchaEnterpriseServiceGrpc.getMigrateKeyMethod =
              getMigrateKeyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.recaptchaenterprise.v1.MigrateKeyRequest,
                          com.google.recaptchaenterprise.v1.Key>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MigrateKey"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.MigrateKeyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.Key.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceMethodDescriptorSupplier("MigrateKey"))
                      .build();
        }
      }
    }
    return getMigrateKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.AddIpOverrideRequest,
          com.google.recaptchaenterprise.v1.AddIpOverrideResponse>
      getAddIpOverrideMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddIpOverride",
      requestType = com.google.recaptchaenterprise.v1.AddIpOverrideRequest.class,
      responseType = com.google.recaptchaenterprise.v1.AddIpOverrideResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.AddIpOverrideRequest,
          com.google.recaptchaenterprise.v1.AddIpOverrideResponse>
      getAddIpOverrideMethod() {
    io.grpc.MethodDescriptor<
            com.google.recaptchaenterprise.v1.AddIpOverrideRequest,
            com.google.recaptchaenterprise.v1.AddIpOverrideResponse>
        getAddIpOverrideMethod;
    if ((getAddIpOverrideMethod = RecaptchaEnterpriseServiceGrpc.getAddIpOverrideMethod) == null) {
      synchronized (RecaptchaEnterpriseServiceGrpc.class) {
        if ((getAddIpOverrideMethod = RecaptchaEnterpriseServiceGrpc.getAddIpOverrideMethod)
            == null) {
          RecaptchaEnterpriseServiceGrpc.getAddIpOverrideMethod =
              getAddIpOverrideMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.recaptchaenterprise.v1.AddIpOverrideRequest,
                          com.google.recaptchaenterprise.v1.AddIpOverrideResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddIpOverride"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.AddIpOverrideRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.AddIpOverrideResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceMethodDescriptorSupplier("AddIpOverride"))
                      .build();
        }
      }
    }
    return getAddIpOverrideMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.RemoveIpOverrideRequest,
          com.google.recaptchaenterprise.v1.RemoveIpOverrideResponse>
      getRemoveIpOverrideMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveIpOverride",
      requestType = com.google.recaptchaenterprise.v1.RemoveIpOverrideRequest.class,
      responseType = com.google.recaptchaenterprise.v1.RemoveIpOverrideResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.RemoveIpOverrideRequest,
          com.google.recaptchaenterprise.v1.RemoveIpOverrideResponse>
      getRemoveIpOverrideMethod() {
    io.grpc.MethodDescriptor<
            com.google.recaptchaenterprise.v1.RemoveIpOverrideRequest,
            com.google.recaptchaenterprise.v1.RemoveIpOverrideResponse>
        getRemoveIpOverrideMethod;
    if ((getRemoveIpOverrideMethod = RecaptchaEnterpriseServiceGrpc.getRemoveIpOverrideMethod)
        == null) {
      synchronized (RecaptchaEnterpriseServiceGrpc.class) {
        if ((getRemoveIpOverrideMethod = RecaptchaEnterpriseServiceGrpc.getRemoveIpOverrideMethod)
            == null) {
          RecaptchaEnterpriseServiceGrpc.getRemoveIpOverrideMethod =
              getRemoveIpOverrideMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.recaptchaenterprise.v1.RemoveIpOverrideRequest,
                          com.google.recaptchaenterprise.v1.RemoveIpOverrideResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RemoveIpOverride"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.RemoveIpOverrideRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.RemoveIpOverrideResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceMethodDescriptorSupplier(
                              "RemoveIpOverride"))
                      .build();
        }
      }
    }
    return getRemoveIpOverrideMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.ListIpOverridesRequest,
          com.google.recaptchaenterprise.v1.ListIpOverridesResponse>
      getListIpOverridesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListIpOverrides",
      requestType = com.google.recaptchaenterprise.v1.ListIpOverridesRequest.class,
      responseType = com.google.recaptchaenterprise.v1.ListIpOverridesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.ListIpOverridesRequest,
          com.google.recaptchaenterprise.v1.ListIpOverridesResponse>
      getListIpOverridesMethod() {
    io.grpc.MethodDescriptor<
            com.google.recaptchaenterprise.v1.ListIpOverridesRequest,
            com.google.recaptchaenterprise.v1.ListIpOverridesResponse>
        getListIpOverridesMethod;
    if ((getListIpOverridesMethod = RecaptchaEnterpriseServiceGrpc.getListIpOverridesMethod)
        == null) {
      synchronized (RecaptchaEnterpriseServiceGrpc.class) {
        if ((getListIpOverridesMethod = RecaptchaEnterpriseServiceGrpc.getListIpOverridesMethod)
            == null) {
          RecaptchaEnterpriseServiceGrpc.getListIpOverridesMethod =
              getListIpOverridesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.recaptchaenterprise.v1.ListIpOverridesRequest,
                          com.google.recaptchaenterprise.v1.ListIpOverridesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListIpOverrides"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.ListIpOverridesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.ListIpOverridesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceMethodDescriptorSupplier("ListIpOverrides"))
                      .build();
        }
      }
    }
    return getListIpOverridesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.GetMetricsRequest,
          com.google.recaptchaenterprise.v1.Metrics>
      getGetMetricsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMetrics",
      requestType = com.google.recaptchaenterprise.v1.GetMetricsRequest.class,
      responseType = com.google.recaptchaenterprise.v1.Metrics.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.GetMetricsRequest,
          com.google.recaptchaenterprise.v1.Metrics>
      getGetMetricsMethod() {
    io.grpc.MethodDescriptor<
            com.google.recaptchaenterprise.v1.GetMetricsRequest,
            com.google.recaptchaenterprise.v1.Metrics>
        getGetMetricsMethod;
    if ((getGetMetricsMethod = RecaptchaEnterpriseServiceGrpc.getGetMetricsMethod) == null) {
      synchronized (RecaptchaEnterpriseServiceGrpc.class) {
        if ((getGetMetricsMethod = RecaptchaEnterpriseServiceGrpc.getGetMetricsMethod) == null) {
          RecaptchaEnterpriseServiceGrpc.getGetMetricsMethod =
              getGetMetricsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.recaptchaenterprise.v1.GetMetricsRequest,
                          com.google.recaptchaenterprise.v1.Metrics>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMetrics"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.GetMetricsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.Metrics.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceMethodDescriptorSupplier("GetMetrics"))
                      .build();
        }
      }
    }
    return getGetMetricsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.CreateFirewallPolicyRequest,
          com.google.recaptchaenterprise.v1.FirewallPolicy>
      getCreateFirewallPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFirewallPolicy",
      requestType = com.google.recaptchaenterprise.v1.CreateFirewallPolicyRequest.class,
      responseType = com.google.recaptchaenterprise.v1.FirewallPolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.CreateFirewallPolicyRequest,
          com.google.recaptchaenterprise.v1.FirewallPolicy>
      getCreateFirewallPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.recaptchaenterprise.v1.CreateFirewallPolicyRequest,
            com.google.recaptchaenterprise.v1.FirewallPolicy>
        getCreateFirewallPolicyMethod;
    if ((getCreateFirewallPolicyMethod =
            RecaptchaEnterpriseServiceGrpc.getCreateFirewallPolicyMethod)
        == null) {
      synchronized (RecaptchaEnterpriseServiceGrpc.class) {
        if ((getCreateFirewallPolicyMethod =
                RecaptchaEnterpriseServiceGrpc.getCreateFirewallPolicyMethod)
            == null) {
          RecaptchaEnterpriseServiceGrpc.getCreateFirewallPolicyMethod =
              getCreateFirewallPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.recaptchaenterprise.v1.CreateFirewallPolicyRequest,
                          com.google.recaptchaenterprise.v1.FirewallPolicy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateFirewallPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.CreateFirewallPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.FirewallPolicy
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceMethodDescriptorSupplier(
                              "CreateFirewallPolicy"))
                      .build();
        }
      }
    }
    return getCreateFirewallPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.ListFirewallPoliciesRequest,
          com.google.recaptchaenterprise.v1.ListFirewallPoliciesResponse>
      getListFirewallPoliciesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFirewallPolicies",
      requestType = com.google.recaptchaenterprise.v1.ListFirewallPoliciesRequest.class,
      responseType = com.google.recaptchaenterprise.v1.ListFirewallPoliciesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.ListFirewallPoliciesRequest,
          com.google.recaptchaenterprise.v1.ListFirewallPoliciesResponse>
      getListFirewallPoliciesMethod() {
    io.grpc.MethodDescriptor<
            com.google.recaptchaenterprise.v1.ListFirewallPoliciesRequest,
            com.google.recaptchaenterprise.v1.ListFirewallPoliciesResponse>
        getListFirewallPoliciesMethod;
    if ((getListFirewallPoliciesMethod =
            RecaptchaEnterpriseServiceGrpc.getListFirewallPoliciesMethod)
        == null) {
      synchronized (RecaptchaEnterpriseServiceGrpc.class) {
        if ((getListFirewallPoliciesMethod =
                RecaptchaEnterpriseServiceGrpc.getListFirewallPoliciesMethod)
            == null) {
          RecaptchaEnterpriseServiceGrpc.getListFirewallPoliciesMethod =
              getListFirewallPoliciesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.recaptchaenterprise.v1.ListFirewallPoliciesRequest,
                          com.google.recaptchaenterprise.v1.ListFirewallPoliciesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListFirewallPolicies"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.ListFirewallPoliciesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.ListFirewallPoliciesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceMethodDescriptorSupplier(
                              "ListFirewallPolicies"))
                      .build();
        }
      }
    }
    return getListFirewallPoliciesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.GetFirewallPolicyRequest,
          com.google.recaptchaenterprise.v1.FirewallPolicy>
      getGetFirewallPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFirewallPolicy",
      requestType = com.google.recaptchaenterprise.v1.GetFirewallPolicyRequest.class,
      responseType = com.google.recaptchaenterprise.v1.FirewallPolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.GetFirewallPolicyRequest,
          com.google.recaptchaenterprise.v1.FirewallPolicy>
      getGetFirewallPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.recaptchaenterprise.v1.GetFirewallPolicyRequest,
            com.google.recaptchaenterprise.v1.FirewallPolicy>
        getGetFirewallPolicyMethod;
    if ((getGetFirewallPolicyMethod = RecaptchaEnterpriseServiceGrpc.getGetFirewallPolicyMethod)
        == null) {
      synchronized (RecaptchaEnterpriseServiceGrpc.class) {
        if ((getGetFirewallPolicyMethod = RecaptchaEnterpriseServiceGrpc.getGetFirewallPolicyMethod)
            == null) {
          RecaptchaEnterpriseServiceGrpc.getGetFirewallPolicyMethod =
              getGetFirewallPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.recaptchaenterprise.v1.GetFirewallPolicyRequest,
                          com.google.recaptchaenterprise.v1.FirewallPolicy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFirewallPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.GetFirewallPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.FirewallPolicy
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceMethodDescriptorSupplier(
                              "GetFirewallPolicy"))
                      .build();
        }
      }
    }
    return getGetFirewallPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.UpdateFirewallPolicyRequest,
          com.google.recaptchaenterprise.v1.FirewallPolicy>
      getUpdateFirewallPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateFirewallPolicy",
      requestType = com.google.recaptchaenterprise.v1.UpdateFirewallPolicyRequest.class,
      responseType = com.google.recaptchaenterprise.v1.FirewallPolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.UpdateFirewallPolicyRequest,
          com.google.recaptchaenterprise.v1.FirewallPolicy>
      getUpdateFirewallPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.recaptchaenterprise.v1.UpdateFirewallPolicyRequest,
            com.google.recaptchaenterprise.v1.FirewallPolicy>
        getUpdateFirewallPolicyMethod;
    if ((getUpdateFirewallPolicyMethod =
            RecaptchaEnterpriseServiceGrpc.getUpdateFirewallPolicyMethod)
        == null) {
      synchronized (RecaptchaEnterpriseServiceGrpc.class) {
        if ((getUpdateFirewallPolicyMethod =
                RecaptchaEnterpriseServiceGrpc.getUpdateFirewallPolicyMethod)
            == null) {
          RecaptchaEnterpriseServiceGrpc.getUpdateFirewallPolicyMethod =
              getUpdateFirewallPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.recaptchaenterprise.v1.UpdateFirewallPolicyRequest,
                          com.google.recaptchaenterprise.v1.FirewallPolicy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateFirewallPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.UpdateFirewallPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.FirewallPolicy
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceMethodDescriptorSupplier(
                              "UpdateFirewallPolicy"))
                      .build();
        }
      }
    }
    return getUpdateFirewallPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.DeleteFirewallPolicyRequest, com.google.protobuf.Empty>
      getDeleteFirewallPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteFirewallPolicy",
      requestType = com.google.recaptchaenterprise.v1.DeleteFirewallPolicyRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.DeleteFirewallPolicyRequest, com.google.protobuf.Empty>
      getDeleteFirewallPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.recaptchaenterprise.v1.DeleteFirewallPolicyRequest,
            com.google.protobuf.Empty>
        getDeleteFirewallPolicyMethod;
    if ((getDeleteFirewallPolicyMethod =
            RecaptchaEnterpriseServiceGrpc.getDeleteFirewallPolicyMethod)
        == null) {
      synchronized (RecaptchaEnterpriseServiceGrpc.class) {
        if ((getDeleteFirewallPolicyMethod =
                RecaptchaEnterpriseServiceGrpc.getDeleteFirewallPolicyMethod)
            == null) {
          RecaptchaEnterpriseServiceGrpc.getDeleteFirewallPolicyMethod =
              getDeleteFirewallPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.recaptchaenterprise.v1.DeleteFirewallPolicyRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteFirewallPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.DeleteFirewallPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceMethodDescriptorSupplier(
                              "DeleteFirewallPolicy"))
                      .build();
        }
      }
    }
    return getDeleteFirewallPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.ReorderFirewallPoliciesRequest,
          com.google.recaptchaenterprise.v1.ReorderFirewallPoliciesResponse>
      getReorderFirewallPoliciesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReorderFirewallPolicies",
      requestType = com.google.recaptchaenterprise.v1.ReorderFirewallPoliciesRequest.class,
      responseType = com.google.recaptchaenterprise.v1.ReorderFirewallPoliciesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.ReorderFirewallPoliciesRequest,
          com.google.recaptchaenterprise.v1.ReorderFirewallPoliciesResponse>
      getReorderFirewallPoliciesMethod() {
    io.grpc.MethodDescriptor<
            com.google.recaptchaenterprise.v1.ReorderFirewallPoliciesRequest,
            com.google.recaptchaenterprise.v1.ReorderFirewallPoliciesResponse>
        getReorderFirewallPoliciesMethod;
    if ((getReorderFirewallPoliciesMethod =
            RecaptchaEnterpriseServiceGrpc.getReorderFirewallPoliciesMethod)
        == null) {
      synchronized (RecaptchaEnterpriseServiceGrpc.class) {
        if ((getReorderFirewallPoliciesMethod =
                RecaptchaEnterpriseServiceGrpc.getReorderFirewallPoliciesMethod)
            == null) {
          RecaptchaEnterpriseServiceGrpc.getReorderFirewallPoliciesMethod =
              getReorderFirewallPoliciesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.recaptchaenterprise.v1.ReorderFirewallPoliciesRequest,
                          com.google.recaptchaenterprise.v1.ReorderFirewallPoliciesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ReorderFirewallPolicies"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.ReorderFirewallPoliciesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.ReorderFirewallPoliciesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceMethodDescriptorSupplier(
                              "ReorderFirewallPolicies"))
                      .build();
        }
      }
    }
    return getReorderFirewallPoliciesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.ListRelatedAccountGroupsRequest,
          com.google.recaptchaenterprise.v1.ListRelatedAccountGroupsResponse>
      getListRelatedAccountGroupsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRelatedAccountGroups",
      requestType = com.google.recaptchaenterprise.v1.ListRelatedAccountGroupsRequest.class,
      responseType = com.google.recaptchaenterprise.v1.ListRelatedAccountGroupsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.ListRelatedAccountGroupsRequest,
          com.google.recaptchaenterprise.v1.ListRelatedAccountGroupsResponse>
      getListRelatedAccountGroupsMethod() {
    io.grpc.MethodDescriptor<
            com.google.recaptchaenterprise.v1.ListRelatedAccountGroupsRequest,
            com.google.recaptchaenterprise.v1.ListRelatedAccountGroupsResponse>
        getListRelatedAccountGroupsMethod;
    if ((getListRelatedAccountGroupsMethod =
            RecaptchaEnterpriseServiceGrpc.getListRelatedAccountGroupsMethod)
        == null) {
      synchronized (RecaptchaEnterpriseServiceGrpc.class) {
        if ((getListRelatedAccountGroupsMethod =
                RecaptchaEnterpriseServiceGrpc.getListRelatedAccountGroupsMethod)
            == null) {
          RecaptchaEnterpriseServiceGrpc.getListRelatedAccountGroupsMethod =
              getListRelatedAccountGroupsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.recaptchaenterprise.v1.ListRelatedAccountGroupsRequest,
                          com.google.recaptchaenterprise.v1.ListRelatedAccountGroupsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListRelatedAccountGroups"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.ListRelatedAccountGroupsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.ListRelatedAccountGroupsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceMethodDescriptorSupplier(
                              "ListRelatedAccountGroups"))
                      .build();
        }
      }
    }
    return getListRelatedAccountGroupsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.ListRelatedAccountGroupMembershipsRequest,
          com.google.recaptchaenterprise.v1.ListRelatedAccountGroupMembershipsResponse>
      getListRelatedAccountGroupMembershipsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRelatedAccountGroupMemberships",
      requestType =
          com.google.recaptchaenterprise.v1.ListRelatedAccountGroupMembershipsRequest.class,
      responseType =
          com.google.recaptchaenterprise.v1.ListRelatedAccountGroupMembershipsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.ListRelatedAccountGroupMembershipsRequest,
          com.google.recaptchaenterprise.v1.ListRelatedAccountGroupMembershipsResponse>
      getListRelatedAccountGroupMembershipsMethod() {
    io.grpc.MethodDescriptor<
            com.google.recaptchaenterprise.v1.ListRelatedAccountGroupMembershipsRequest,
            com.google.recaptchaenterprise.v1.ListRelatedAccountGroupMembershipsResponse>
        getListRelatedAccountGroupMembershipsMethod;
    if ((getListRelatedAccountGroupMembershipsMethod =
            RecaptchaEnterpriseServiceGrpc.getListRelatedAccountGroupMembershipsMethod)
        == null) {
      synchronized (RecaptchaEnterpriseServiceGrpc.class) {
        if ((getListRelatedAccountGroupMembershipsMethod =
                RecaptchaEnterpriseServiceGrpc.getListRelatedAccountGroupMembershipsMethod)
            == null) {
          RecaptchaEnterpriseServiceGrpc.getListRelatedAccountGroupMembershipsMethod =
              getListRelatedAccountGroupMembershipsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.recaptchaenterprise.v1.ListRelatedAccountGroupMembershipsRequest,
                          com.google.recaptchaenterprise.v1
                              .ListRelatedAccountGroupMembershipsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "ListRelatedAccountGroupMemberships"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1
                                  .ListRelatedAccountGroupMembershipsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1
                                  .ListRelatedAccountGroupMembershipsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceMethodDescriptorSupplier(
                              "ListRelatedAccountGroupMemberships"))
                      .build();
        }
      }
    }
    return getListRelatedAccountGroupMembershipsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.SearchRelatedAccountGroupMembershipsRequest,
          com.google.recaptchaenterprise.v1.SearchRelatedAccountGroupMembershipsResponse>
      getSearchRelatedAccountGroupMembershipsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchRelatedAccountGroupMemberships",
      requestType =
          com.google.recaptchaenterprise.v1.SearchRelatedAccountGroupMembershipsRequest.class,
      responseType =
          com.google.recaptchaenterprise.v1.SearchRelatedAccountGroupMembershipsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.SearchRelatedAccountGroupMembershipsRequest,
          com.google.recaptchaenterprise.v1.SearchRelatedAccountGroupMembershipsResponse>
      getSearchRelatedAccountGroupMembershipsMethod() {
    io.grpc.MethodDescriptor<
            com.google.recaptchaenterprise.v1.SearchRelatedAccountGroupMembershipsRequest,
            com.google.recaptchaenterprise.v1.SearchRelatedAccountGroupMembershipsResponse>
        getSearchRelatedAccountGroupMembershipsMethod;
    if ((getSearchRelatedAccountGroupMembershipsMethod =
            RecaptchaEnterpriseServiceGrpc.getSearchRelatedAccountGroupMembershipsMethod)
        == null) {
      synchronized (RecaptchaEnterpriseServiceGrpc.class) {
        if ((getSearchRelatedAccountGroupMembershipsMethod =
                RecaptchaEnterpriseServiceGrpc.getSearchRelatedAccountGroupMembershipsMethod)
            == null) {
          RecaptchaEnterpriseServiceGrpc.getSearchRelatedAccountGroupMembershipsMethod =
              getSearchRelatedAccountGroupMembershipsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.recaptchaenterprise.v1
                              .SearchRelatedAccountGroupMembershipsRequest,
                          com.google.recaptchaenterprise.v1
                              .SearchRelatedAccountGroupMembershipsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "SearchRelatedAccountGroupMemberships"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1
                                  .SearchRelatedAccountGroupMembershipsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1
                                  .SearchRelatedAccountGroupMembershipsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceMethodDescriptorSupplier(
                              "SearchRelatedAccountGroupMemberships"))
                      .build();
        }
      }
    }
    return getSearchRelatedAccountGroupMembershipsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static RecaptchaEnterpriseServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecaptchaEnterpriseServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RecaptchaEnterpriseServiceStub>() {
          @java.lang.Override
          public RecaptchaEnterpriseServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RecaptchaEnterpriseServiceStub(channel, callOptions);
          }
        };
    return RecaptchaEnterpriseServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RecaptchaEnterpriseServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecaptchaEnterpriseServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RecaptchaEnterpriseServiceBlockingStub>() {
          @java.lang.Override
          public RecaptchaEnterpriseServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RecaptchaEnterpriseServiceBlockingStub(channel, callOptions);
          }
        };
    return RecaptchaEnterpriseServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static RecaptchaEnterpriseServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecaptchaEnterpriseServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RecaptchaEnterpriseServiceFutureStub>() {
          @java.lang.Override
          public RecaptchaEnterpriseServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RecaptchaEnterpriseServiceFutureStub(channel, callOptions);
          }
        };
    return RecaptchaEnterpriseServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to determine the likelihood an event is legitimate.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates an Assessment of the likelihood an event is legitimate.
     * </pre>
     */
    default void createAssessment(
        com.google.recaptchaenterprise.v1.CreateAssessmentRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.Assessment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAssessmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Annotates a previously created Assessment to provide additional information
     * on whether the event turned out to be authentic or fraudulent.
     * </pre>
     */
    default void annotateAssessment(
        com.google.recaptchaenterprise.v1.AnnotateAssessmentRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.AnnotateAssessmentResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAnnotateAssessmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new reCAPTCHA Enterprise key.
     * </pre>
     */
    default void createKey(
        com.google.recaptchaenterprise.v1.CreateKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.Key> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateKeyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all keys that belong to a project.
     * </pre>
     */
    default void listKeys(
        com.google.recaptchaenterprise.v1.ListKeysRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.ListKeysResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListKeysMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the secret key related to the specified public key.
     * You must use the legacy secret key only in a 3rd party integration with
     * legacy reCAPTCHA.
     * </pre>
     */
    default void retrieveLegacySecretKey(
        com.google.recaptchaenterprise.v1.RetrieveLegacySecretKeyRequest request,
        io.grpc.stub.StreamObserver<
                com.google.recaptchaenterprise.v1.RetrieveLegacySecretKeyResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRetrieveLegacySecretKeyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified key.
     * </pre>
     */
    default void getKey(
        com.google.recaptchaenterprise.v1.GetKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.Key> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetKeyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified key.
     * </pre>
     */
    default void updateKey(
        com.google.recaptchaenterprise.v1.UpdateKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.Key> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateKeyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified key.
     * </pre>
     */
    default void deleteKey(
        com.google.recaptchaenterprise.v1.DeleteKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteKeyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Migrates an existing key from reCAPTCHA to reCAPTCHA Enterprise.
     * Once a key is migrated, it can be used from either product. SiteVerify
     * requests are billed as CreateAssessment calls. You must be
     * authenticated as one of the current owners of the reCAPTCHA Key, and
     * your user must have the reCAPTCHA Enterprise Admin IAM role in the
     * destination project.
     * </pre>
     */
    default void migrateKey(
        com.google.recaptchaenterprise.v1.MigrateKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.Key> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMigrateKeyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds an IP override to a key. The following restrictions hold:
     * * The maximum number of IP overrides per key is 100.
     * * For any conflict (such as IP already exists or IP part of an existing
     *   IP range), an error is returned.
     * </pre>
     */
    default void addIpOverride(
        com.google.recaptchaenterprise.v1.AddIpOverrideRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.AddIpOverrideResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAddIpOverrideMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes an IP override from a key. The following restrictions hold:
     * * If the IP isn't found in an existing IP override, a `NOT_FOUND` error
     * is returned.
     * * If the IP is found in an existing IP override, but the
     * override type does not match, a `NOT_FOUND` error is returned.
     * </pre>
     */
    default void removeIpOverride(
        com.google.recaptchaenterprise.v1.RemoveIpOverrideRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.RemoveIpOverrideResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRemoveIpOverrideMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all IP overrides for a key.
     * </pre>
     */
    default void listIpOverrides(
        com.google.recaptchaenterprise.v1.ListIpOverridesRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.ListIpOverridesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListIpOverridesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get some aggregated metrics for a Key. This data can be used to build
     * dashboards.
     * </pre>
     */
    default void getMetrics(
        com.google.recaptchaenterprise.v1.GetMetricsRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.Metrics> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMetricsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new FirewallPolicy, specifying conditions at which reCAPTCHA
     * Enterprise actions can be executed.
     * A project may have a maximum of 1000 policies.
     * </pre>
     */
    default void createFirewallPolicy(
        com.google.recaptchaenterprise.v1.CreateFirewallPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.FirewallPolicy>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateFirewallPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all firewall policies that belong to a project.
     * </pre>
     */
    default void listFirewallPolicies(
        com.google.recaptchaenterprise.v1.ListFirewallPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.ListFirewallPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListFirewallPoliciesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified firewall policy.
     * </pre>
     */
    default void getFirewallPolicy(
        com.google.recaptchaenterprise.v1.GetFirewallPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.FirewallPolicy>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetFirewallPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified firewall policy.
     * </pre>
     */
    default void updateFirewallPolicy(
        com.google.recaptchaenterprise.v1.UpdateFirewallPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.FirewallPolicy>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateFirewallPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified firewall policy.
     * </pre>
     */
    default void deleteFirewallPolicy(
        com.google.recaptchaenterprise.v1.DeleteFirewallPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteFirewallPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reorders all firewall policies.
     * </pre>
     */
    default void reorderFirewallPolicies(
        com.google.recaptchaenterprise.v1.ReorderFirewallPoliciesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.recaptchaenterprise.v1.ReorderFirewallPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getReorderFirewallPoliciesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List groups of related accounts.
     * </pre>
     */
    default void listRelatedAccountGroups(
        com.google.recaptchaenterprise.v1.ListRelatedAccountGroupsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.recaptchaenterprise.v1.ListRelatedAccountGroupsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListRelatedAccountGroupsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get memberships in a group of related accounts.
     * </pre>
     */
    default void listRelatedAccountGroupMemberships(
        com.google.recaptchaenterprise.v1.ListRelatedAccountGroupMembershipsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.recaptchaenterprise.v1.ListRelatedAccountGroupMembershipsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListRelatedAccountGroupMembershipsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Search group memberships related to a given account.
     * </pre>
     */
    default void searchRelatedAccountGroupMemberships(
        com.google.recaptchaenterprise.v1.SearchRelatedAccountGroupMembershipsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.recaptchaenterprise.v1.SearchRelatedAccountGroupMembershipsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchRelatedAccountGroupMembershipsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service RecaptchaEnterpriseService.
   *
   * <pre>
   * Service to determine the likelihood an event is legitimate.
   * </pre>
   */
  public abstract static class RecaptchaEnterpriseServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return RecaptchaEnterpriseServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service RecaptchaEnterpriseService.
   *
   * <pre>
   * Service to determine the likelihood an event is legitimate.
   * </pre>
   */
  public static final class RecaptchaEnterpriseServiceStub
      extends io.grpc.stub.AbstractAsyncStub<RecaptchaEnterpriseServiceStub> {
    private RecaptchaEnterpriseServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecaptchaEnterpriseServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecaptchaEnterpriseServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an Assessment of the likelihood an event is legitimate.
     * </pre>
     */
    public void createAssessment(
        com.google.recaptchaenterprise.v1.CreateAssessmentRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.Assessment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAssessmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Annotates a previously created Assessment to provide additional information
     * on whether the event turned out to be authentic or fraudulent.
     * </pre>
     */
    public void annotateAssessment(
        com.google.recaptchaenterprise.v1.AnnotateAssessmentRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.AnnotateAssessmentResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAnnotateAssessmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new reCAPTCHA Enterprise key.
     * </pre>
     */
    public void createKey(
        com.google.recaptchaenterprise.v1.CreateKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.Key> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateKeyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all keys that belong to a project.
     * </pre>
     */
    public void listKeys(
        com.google.recaptchaenterprise.v1.ListKeysRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.ListKeysResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListKeysMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the secret key related to the specified public key.
     * You must use the legacy secret key only in a 3rd party integration with
     * legacy reCAPTCHA.
     * </pre>
     */
    public void retrieveLegacySecretKey(
        com.google.recaptchaenterprise.v1.RetrieveLegacySecretKeyRequest request,
        io.grpc.stub.StreamObserver<
                com.google.recaptchaenterprise.v1.RetrieveLegacySecretKeyResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRetrieveLegacySecretKeyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified key.
     * </pre>
     */
    public void getKey(
        com.google.recaptchaenterprise.v1.GetKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.Key> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetKeyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified key.
     * </pre>
     */
    public void updateKey(
        com.google.recaptchaenterprise.v1.UpdateKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.Key> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateKeyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified key.
     * </pre>
     */
    public void deleteKey(
        com.google.recaptchaenterprise.v1.DeleteKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteKeyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Migrates an existing key from reCAPTCHA to reCAPTCHA Enterprise.
     * Once a key is migrated, it can be used from either product. SiteVerify
     * requests are billed as CreateAssessment calls. You must be
     * authenticated as one of the current owners of the reCAPTCHA Key, and
     * your user must have the reCAPTCHA Enterprise Admin IAM role in the
     * destination project.
     * </pre>
     */
    public void migrateKey(
        com.google.recaptchaenterprise.v1.MigrateKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.Key> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMigrateKeyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds an IP override to a key. The following restrictions hold:
     * * The maximum number of IP overrides per key is 100.
     * * For any conflict (such as IP already exists or IP part of an existing
     *   IP range), an error is returned.
     * </pre>
     */
    public void addIpOverride(
        com.google.recaptchaenterprise.v1.AddIpOverrideRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.AddIpOverrideResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddIpOverrideMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Removes an IP override from a key. The following restrictions hold:
     * * If the IP isn't found in an existing IP override, a `NOT_FOUND` error
     * is returned.
     * * If the IP is found in an existing IP override, but the
     * override type does not match, a `NOT_FOUND` error is returned.
     * </pre>
     */
    public void removeIpOverride(
        com.google.recaptchaenterprise.v1.RemoveIpOverrideRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.RemoveIpOverrideResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRemoveIpOverrideMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all IP overrides for a key.
     * </pre>
     */
    public void listIpOverrides(
        com.google.recaptchaenterprise.v1.ListIpOverridesRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.ListIpOverridesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListIpOverridesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get some aggregated metrics for a Key. This data can be used to build
     * dashboards.
     * </pre>
     */
    public void getMetrics(
        com.google.recaptchaenterprise.v1.GetMetricsRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.Metrics> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMetricsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new FirewallPolicy, specifying conditions at which reCAPTCHA
     * Enterprise actions can be executed.
     * A project may have a maximum of 1000 policies.
     * </pre>
     */
    public void createFirewallPolicy(
        com.google.recaptchaenterprise.v1.CreateFirewallPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.FirewallPolicy>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateFirewallPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all firewall policies that belong to a project.
     * </pre>
     */
    public void listFirewallPolicies(
        com.google.recaptchaenterprise.v1.ListFirewallPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.ListFirewallPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFirewallPoliciesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified firewall policy.
     * </pre>
     */
    public void getFirewallPolicy(
        com.google.recaptchaenterprise.v1.GetFirewallPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.FirewallPolicy>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFirewallPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified firewall policy.
     * </pre>
     */
    public void updateFirewallPolicy(
        com.google.recaptchaenterprise.v1.UpdateFirewallPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.FirewallPolicy>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateFirewallPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified firewall policy.
     * </pre>
     */
    public void deleteFirewallPolicy(
        com.google.recaptchaenterprise.v1.DeleteFirewallPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteFirewallPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reorders all firewall policies.
     * </pre>
     */
    public void reorderFirewallPolicies(
        com.google.recaptchaenterprise.v1.ReorderFirewallPoliciesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.recaptchaenterprise.v1.ReorderFirewallPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReorderFirewallPoliciesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List groups of related accounts.
     * </pre>
     */
    public void listRelatedAccountGroups(
        com.google.recaptchaenterprise.v1.ListRelatedAccountGroupsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.recaptchaenterprise.v1.ListRelatedAccountGroupsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRelatedAccountGroupsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get memberships in a group of related accounts.
     * </pre>
     */
    public void listRelatedAccountGroupMemberships(
        com.google.recaptchaenterprise.v1.ListRelatedAccountGroupMembershipsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.recaptchaenterprise.v1.ListRelatedAccountGroupMembershipsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRelatedAccountGroupMembershipsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Search group memberships related to a given account.
     * </pre>
     */
    public void searchRelatedAccountGroupMemberships(
        com.google.recaptchaenterprise.v1.SearchRelatedAccountGroupMembershipsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.recaptchaenterprise.v1.SearchRelatedAccountGroupMembershipsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchRelatedAccountGroupMembershipsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service RecaptchaEnterpriseService.
   *
   * <pre>
   * Service to determine the likelihood an event is legitimate.
   * </pre>
   */
  public static final class RecaptchaEnterpriseServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<RecaptchaEnterpriseServiceBlockingStub> {
    private RecaptchaEnterpriseServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecaptchaEnterpriseServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecaptchaEnterpriseServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an Assessment of the likelihood an event is legitimate.
     * </pre>
     */
    public com.google.recaptchaenterprise.v1.Assessment createAssessment(
        com.google.recaptchaenterprise.v1.CreateAssessmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAssessmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Annotates a previously created Assessment to provide additional information
     * on whether the event turned out to be authentic or fraudulent.
     * </pre>
     */
    public com.google.recaptchaenterprise.v1.AnnotateAssessmentResponse annotateAssessment(
        com.google.recaptchaenterprise.v1.AnnotateAssessmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAnnotateAssessmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new reCAPTCHA Enterprise key.
     * </pre>
     */
    public com.google.recaptchaenterprise.v1.Key createKey(
        com.google.recaptchaenterprise.v1.CreateKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateKeyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all keys that belong to a project.
     * </pre>
     */
    public com.google.recaptchaenterprise.v1.ListKeysResponse listKeys(
        com.google.recaptchaenterprise.v1.ListKeysRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListKeysMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the secret key related to the specified public key.
     * You must use the legacy secret key only in a 3rd party integration with
     * legacy reCAPTCHA.
     * </pre>
     */
    public com.google.recaptchaenterprise.v1.RetrieveLegacySecretKeyResponse
        retrieveLegacySecretKey(
            com.google.recaptchaenterprise.v1.RetrieveLegacySecretKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRetrieveLegacySecretKeyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified key.
     * </pre>
     */
    public com.google.recaptchaenterprise.v1.Key getKey(
        com.google.recaptchaenterprise.v1.GetKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetKeyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified key.
     * </pre>
     */
    public com.google.recaptchaenterprise.v1.Key updateKey(
        com.google.recaptchaenterprise.v1.UpdateKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateKeyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified key.
     * </pre>
     */
    public com.google.protobuf.Empty deleteKey(
        com.google.recaptchaenterprise.v1.DeleteKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteKeyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Migrates an existing key from reCAPTCHA to reCAPTCHA Enterprise.
     * Once a key is migrated, it can be used from either product. SiteVerify
     * requests are billed as CreateAssessment calls. You must be
     * authenticated as one of the current owners of the reCAPTCHA Key, and
     * your user must have the reCAPTCHA Enterprise Admin IAM role in the
     * destination project.
     * </pre>
     */
    public com.google.recaptchaenterprise.v1.Key migrateKey(
        com.google.recaptchaenterprise.v1.MigrateKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMigrateKeyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Adds an IP override to a key. The following restrictions hold:
     * * The maximum number of IP overrides per key is 100.
     * * For any conflict (such as IP already exists or IP part of an existing
     *   IP range), an error is returned.
     * </pre>
     */
    public com.google.recaptchaenterprise.v1.AddIpOverrideResponse addIpOverride(
        com.google.recaptchaenterprise.v1.AddIpOverrideRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddIpOverrideMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Removes an IP override from a key. The following restrictions hold:
     * * If the IP isn't found in an existing IP override, a `NOT_FOUND` error
     * is returned.
     * * If the IP is found in an existing IP override, but the
     * override type does not match, a `NOT_FOUND` error is returned.
     * </pre>
     */
    public com.google.recaptchaenterprise.v1.RemoveIpOverrideResponse removeIpOverride(
        com.google.recaptchaenterprise.v1.RemoveIpOverrideRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveIpOverrideMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all IP overrides for a key.
     * </pre>
     */
    public com.google.recaptchaenterprise.v1.ListIpOverridesResponse listIpOverrides(
        com.google.recaptchaenterprise.v1.ListIpOverridesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListIpOverridesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get some aggregated metrics for a Key. This data can be used to build
     * dashboards.
     * </pre>
     */
    public com.google.recaptchaenterprise.v1.Metrics getMetrics(
        com.google.recaptchaenterprise.v1.GetMetricsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMetricsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new FirewallPolicy, specifying conditions at which reCAPTCHA
     * Enterprise actions can be executed.
     * A project may have a maximum of 1000 policies.
     * </pre>
     */
    public com.google.recaptchaenterprise.v1.FirewallPolicy createFirewallPolicy(
        com.google.recaptchaenterprise.v1.CreateFirewallPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFirewallPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all firewall policies that belong to a project.
     * </pre>
     */
    public com.google.recaptchaenterprise.v1.ListFirewallPoliciesResponse listFirewallPolicies(
        com.google.recaptchaenterprise.v1.ListFirewallPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFirewallPoliciesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified firewall policy.
     * </pre>
     */
    public com.google.recaptchaenterprise.v1.FirewallPolicy getFirewallPolicy(
        com.google.recaptchaenterprise.v1.GetFirewallPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFirewallPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified firewall policy.
     * </pre>
     */
    public com.google.recaptchaenterprise.v1.FirewallPolicy updateFirewallPolicy(
        com.google.recaptchaenterprise.v1.UpdateFirewallPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateFirewallPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified firewall policy.
     * </pre>
     */
    public com.google.protobuf.Empty deleteFirewallPolicy(
        com.google.recaptchaenterprise.v1.DeleteFirewallPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteFirewallPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Reorders all firewall policies.
     * </pre>
     */
    public com.google.recaptchaenterprise.v1.ReorderFirewallPoliciesResponse
        reorderFirewallPolicies(
            com.google.recaptchaenterprise.v1.ReorderFirewallPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReorderFirewallPoliciesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List groups of related accounts.
     * </pre>
     */
    public com.google.recaptchaenterprise.v1.ListRelatedAccountGroupsResponse
        listRelatedAccountGroups(
            com.google.recaptchaenterprise.v1.ListRelatedAccountGroupsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRelatedAccountGroupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get memberships in a group of related accounts.
     * </pre>
     */
    public com.google.recaptchaenterprise.v1.ListRelatedAccountGroupMembershipsResponse
        listRelatedAccountGroupMemberships(
            com.google.recaptchaenterprise.v1.ListRelatedAccountGroupMembershipsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRelatedAccountGroupMembershipsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Search group memberships related to a given account.
     * </pre>
     */
    public com.google.recaptchaenterprise.v1.SearchRelatedAccountGroupMembershipsResponse
        searchRelatedAccountGroupMemberships(
            com.google.recaptchaenterprise.v1.SearchRelatedAccountGroupMembershipsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchRelatedAccountGroupMembershipsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * RecaptchaEnterpriseService.
   *
   * <pre>
   * Service to determine the likelihood an event is legitimate.
   * </pre>
   */
  public static final class RecaptchaEnterpriseServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<RecaptchaEnterpriseServiceFutureStub> {
    private RecaptchaEnterpriseServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecaptchaEnterpriseServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecaptchaEnterpriseServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an Assessment of the likelihood an event is legitimate.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.recaptchaenterprise.v1.Assessment>
        createAssessment(com.google.recaptchaenterprise.v1.CreateAssessmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAssessmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Annotates a previously created Assessment to provide additional information
     * on whether the event turned out to be authentic or fraudulent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.recaptchaenterprise.v1.AnnotateAssessmentResponse>
        annotateAssessment(com.google.recaptchaenterprise.v1.AnnotateAssessmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAnnotateAssessmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new reCAPTCHA Enterprise key.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.recaptchaenterprise.v1.Key>
        createKey(com.google.recaptchaenterprise.v1.CreateKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateKeyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all keys that belong to a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.recaptchaenterprise.v1.ListKeysResponse>
        listKeys(com.google.recaptchaenterprise.v1.ListKeysRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListKeysMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the secret key related to the specified public key.
     * You must use the legacy secret key only in a 3rd party integration with
     * legacy reCAPTCHA.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.recaptchaenterprise.v1.RetrieveLegacySecretKeyResponse>
        retrieveLegacySecretKey(
            com.google.recaptchaenterprise.v1.RetrieveLegacySecretKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRetrieveLegacySecretKeyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified key.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.recaptchaenterprise.v1.Key>
        getKey(com.google.recaptchaenterprise.v1.GetKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetKeyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified key.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.recaptchaenterprise.v1.Key>
        updateKey(com.google.recaptchaenterprise.v1.UpdateKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateKeyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified key.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteKey(
        com.google.recaptchaenterprise.v1.DeleteKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteKeyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Migrates an existing key from reCAPTCHA to reCAPTCHA Enterprise.
     * Once a key is migrated, it can be used from either product. SiteVerify
     * requests are billed as CreateAssessment calls. You must be
     * authenticated as one of the current owners of the reCAPTCHA Key, and
     * your user must have the reCAPTCHA Enterprise Admin IAM role in the
     * destination project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.recaptchaenterprise.v1.Key>
        migrateKey(com.google.recaptchaenterprise.v1.MigrateKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMigrateKeyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Adds an IP override to a key. The following restrictions hold:
     * * The maximum number of IP overrides per key is 100.
     * * For any conflict (such as IP already exists or IP part of an existing
     *   IP range), an error is returned.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.recaptchaenterprise.v1.AddIpOverrideResponse>
        addIpOverride(com.google.recaptchaenterprise.v1.AddIpOverrideRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddIpOverrideMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Removes an IP override from a key. The following restrictions hold:
     * * If the IP isn't found in an existing IP override, a `NOT_FOUND` error
     * is returned.
     * * If the IP is found in an existing IP override, but the
     * override type does not match, a `NOT_FOUND` error is returned.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.recaptchaenterprise.v1.RemoveIpOverrideResponse>
        removeIpOverride(com.google.recaptchaenterprise.v1.RemoveIpOverrideRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRemoveIpOverrideMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all IP overrides for a key.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.recaptchaenterprise.v1.ListIpOverridesResponse>
        listIpOverrides(com.google.recaptchaenterprise.v1.ListIpOverridesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListIpOverridesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get some aggregated metrics for a Key. This data can be used to build
     * dashboards.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.recaptchaenterprise.v1.Metrics>
        getMetrics(com.google.recaptchaenterprise.v1.GetMetricsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMetricsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new FirewallPolicy, specifying conditions at which reCAPTCHA
     * Enterprise actions can be executed.
     * A project may have a maximum of 1000 policies.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.recaptchaenterprise.v1.FirewallPolicy>
        createFirewallPolicy(
            com.google.recaptchaenterprise.v1.CreateFirewallPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateFirewallPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all firewall policies that belong to a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.recaptchaenterprise.v1.ListFirewallPoliciesResponse>
        listFirewallPolicies(
            com.google.recaptchaenterprise.v1.ListFirewallPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFirewallPoliciesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified firewall policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.recaptchaenterprise.v1.FirewallPolicy>
        getFirewallPolicy(com.google.recaptchaenterprise.v1.GetFirewallPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFirewallPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified firewall policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.recaptchaenterprise.v1.FirewallPolicy>
        updateFirewallPolicy(
            com.google.recaptchaenterprise.v1.UpdateFirewallPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateFirewallPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified firewall policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteFirewallPolicy(
            com.google.recaptchaenterprise.v1.DeleteFirewallPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteFirewallPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Reorders all firewall policies.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.recaptchaenterprise.v1.ReorderFirewallPoliciesResponse>
        reorderFirewallPolicies(
            com.google.recaptchaenterprise.v1.ReorderFirewallPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReorderFirewallPoliciesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List groups of related accounts.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.recaptchaenterprise.v1.ListRelatedAccountGroupsResponse>
        listRelatedAccountGroups(
            com.google.recaptchaenterprise.v1.ListRelatedAccountGroupsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRelatedAccountGroupsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get memberships in a group of related accounts.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.recaptchaenterprise.v1.ListRelatedAccountGroupMembershipsResponse>
        listRelatedAccountGroupMemberships(
            com.google.recaptchaenterprise.v1.ListRelatedAccountGroupMembershipsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRelatedAccountGroupMembershipsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Search group memberships related to a given account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.recaptchaenterprise.v1.SearchRelatedAccountGroupMembershipsResponse>
        searchRelatedAccountGroupMemberships(
            com.google.recaptchaenterprise.v1.SearchRelatedAccountGroupMembershipsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchRelatedAccountGroupMembershipsMethod(), getCallOptions()),
          request);
    }
  }

  private static final int METHODID_CREATE_ASSESSMENT = 0;
  private static final int METHODID_ANNOTATE_ASSESSMENT = 1;
  private static final int METHODID_CREATE_KEY = 2;
  private static final int METHODID_LIST_KEYS = 3;
  private static final int METHODID_RETRIEVE_LEGACY_SECRET_KEY = 4;
  private static final int METHODID_GET_KEY = 5;
  private static final int METHODID_UPDATE_KEY = 6;
  private static final int METHODID_DELETE_KEY = 7;
  private static final int METHODID_MIGRATE_KEY = 8;
  private static final int METHODID_ADD_IP_OVERRIDE = 9;
  private static final int METHODID_REMOVE_IP_OVERRIDE = 10;
  private static final int METHODID_LIST_IP_OVERRIDES = 11;
  private static final int METHODID_GET_METRICS = 12;
  private static final int METHODID_CREATE_FIREWALL_POLICY = 13;
  private static final int METHODID_LIST_FIREWALL_POLICIES = 14;
  private static final int METHODID_GET_FIREWALL_POLICY = 15;
  private static final int METHODID_UPDATE_FIREWALL_POLICY = 16;
  private static final int METHODID_DELETE_FIREWALL_POLICY = 17;
  private static final int METHODID_REORDER_FIREWALL_POLICIES = 18;
  private static final int METHODID_LIST_RELATED_ACCOUNT_GROUPS = 19;
  private static final int METHODID_LIST_RELATED_ACCOUNT_GROUP_MEMBERSHIPS = 20;
  private static final int METHODID_SEARCH_RELATED_ACCOUNT_GROUP_MEMBERSHIPS = 21;

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
        case METHODID_CREATE_ASSESSMENT:
          serviceImpl.createAssessment(
              (com.google.recaptchaenterprise.v1.CreateAssessmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.Assessment>)
                  responseObserver);
          break;
        case METHODID_ANNOTATE_ASSESSMENT:
          serviceImpl.annotateAssessment(
              (com.google.recaptchaenterprise.v1.AnnotateAssessmentRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.recaptchaenterprise.v1.AnnotateAssessmentResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_KEY:
          serviceImpl.createKey(
              (com.google.recaptchaenterprise.v1.CreateKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.Key>)
                  responseObserver);
          break;
        case METHODID_LIST_KEYS:
          serviceImpl.listKeys(
              (com.google.recaptchaenterprise.v1.ListKeysRequest) request,
              (io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.ListKeysResponse>)
                  responseObserver);
          break;
        case METHODID_RETRIEVE_LEGACY_SECRET_KEY:
          serviceImpl.retrieveLegacySecretKey(
              (com.google.recaptchaenterprise.v1.RetrieveLegacySecretKeyRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.recaptchaenterprise.v1.RetrieveLegacySecretKeyResponse>)
                  responseObserver);
          break;
        case METHODID_GET_KEY:
          serviceImpl.getKey(
              (com.google.recaptchaenterprise.v1.GetKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.Key>)
                  responseObserver);
          break;
        case METHODID_UPDATE_KEY:
          serviceImpl.updateKey(
              (com.google.recaptchaenterprise.v1.UpdateKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.Key>)
                  responseObserver);
          break;
        case METHODID_DELETE_KEY:
          serviceImpl.deleteKey(
              (com.google.recaptchaenterprise.v1.DeleteKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_MIGRATE_KEY:
          serviceImpl.migrateKey(
              (com.google.recaptchaenterprise.v1.MigrateKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.Key>)
                  responseObserver);
          break;
        case METHODID_ADD_IP_OVERRIDE:
          serviceImpl.addIpOverride(
              (com.google.recaptchaenterprise.v1.AddIpOverrideRequest) request,
              (io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.AddIpOverrideResponse>)
                  responseObserver);
          break;
        case METHODID_REMOVE_IP_OVERRIDE:
          serviceImpl.removeIpOverride(
              (com.google.recaptchaenterprise.v1.RemoveIpOverrideRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.recaptchaenterprise.v1.RemoveIpOverrideResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_IP_OVERRIDES:
          serviceImpl.listIpOverrides(
              (com.google.recaptchaenterprise.v1.ListIpOverridesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.recaptchaenterprise.v1.ListIpOverridesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_METRICS:
          serviceImpl.getMetrics(
              (com.google.recaptchaenterprise.v1.GetMetricsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.Metrics>)
                  responseObserver);
          break;
        case METHODID_CREATE_FIREWALL_POLICY:
          serviceImpl.createFirewallPolicy(
              (com.google.recaptchaenterprise.v1.CreateFirewallPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.FirewallPolicy>)
                  responseObserver);
          break;
        case METHODID_LIST_FIREWALL_POLICIES:
          serviceImpl.listFirewallPolicies(
              (com.google.recaptchaenterprise.v1.ListFirewallPoliciesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.recaptchaenterprise.v1.ListFirewallPoliciesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_FIREWALL_POLICY:
          serviceImpl.getFirewallPolicy(
              (com.google.recaptchaenterprise.v1.GetFirewallPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.FirewallPolicy>)
                  responseObserver);
          break;
        case METHODID_UPDATE_FIREWALL_POLICY:
          serviceImpl.updateFirewallPolicy(
              (com.google.recaptchaenterprise.v1.UpdateFirewallPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.FirewallPolicy>)
                  responseObserver);
          break;
        case METHODID_DELETE_FIREWALL_POLICY:
          serviceImpl.deleteFirewallPolicy(
              (com.google.recaptchaenterprise.v1.DeleteFirewallPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_REORDER_FIREWALL_POLICIES:
          serviceImpl.reorderFirewallPolicies(
              (com.google.recaptchaenterprise.v1.ReorderFirewallPoliciesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.recaptchaenterprise.v1.ReorderFirewallPoliciesResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_RELATED_ACCOUNT_GROUPS:
          serviceImpl.listRelatedAccountGroups(
              (com.google.recaptchaenterprise.v1.ListRelatedAccountGroupsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.recaptchaenterprise.v1.ListRelatedAccountGroupsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_RELATED_ACCOUNT_GROUP_MEMBERSHIPS:
          serviceImpl.listRelatedAccountGroupMemberships(
              (com.google.recaptchaenterprise.v1.ListRelatedAccountGroupMembershipsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.recaptchaenterprise.v1.ListRelatedAccountGroupMembershipsResponse>)
                  responseObserver);
          break;
        case METHODID_SEARCH_RELATED_ACCOUNT_GROUP_MEMBERSHIPS:
          serviceImpl.searchRelatedAccountGroupMemberships(
              (com.google.recaptchaenterprise.v1.SearchRelatedAccountGroupMembershipsRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.recaptchaenterprise.v1
                          .SearchRelatedAccountGroupMembershipsResponse>)
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getCreateAssessmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.recaptchaenterprise.v1.CreateAssessmentRequest,
                    com.google.recaptchaenterprise.v1.Assessment>(
                    service, METHODID_CREATE_ASSESSMENT)))
        .addMethod(
            getAnnotateAssessmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.recaptchaenterprise.v1.AnnotateAssessmentRequest,
                    com.google.recaptchaenterprise.v1.AnnotateAssessmentResponse>(
                    service, METHODID_ANNOTATE_ASSESSMENT)))
        .addMethod(
            getCreateKeyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.recaptchaenterprise.v1.CreateKeyRequest,
                    com.google.recaptchaenterprise.v1.Key>(service, METHODID_CREATE_KEY)))
        .addMethod(
            getListKeysMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.recaptchaenterprise.v1.ListKeysRequest,
                    com.google.recaptchaenterprise.v1.ListKeysResponse>(
                    service, METHODID_LIST_KEYS)))
        .addMethod(
            getRetrieveLegacySecretKeyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.recaptchaenterprise.v1.RetrieveLegacySecretKeyRequest,
                    com.google.recaptchaenterprise.v1.RetrieveLegacySecretKeyResponse>(
                    service, METHODID_RETRIEVE_LEGACY_SECRET_KEY)))
        .addMethod(
            getGetKeyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.recaptchaenterprise.v1.GetKeyRequest,
                    com.google.recaptchaenterprise.v1.Key>(service, METHODID_GET_KEY)))
        .addMethod(
            getUpdateKeyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.recaptchaenterprise.v1.UpdateKeyRequest,
                    com.google.recaptchaenterprise.v1.Key>(service, METHODID_UPDATE_KEY)))
        .addMethod(
            getDeleteKeyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.recaptchaenterprise.v1.DeleteKeyRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_KEY)))
        .addMethod(
            getMigrateKeyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.recaptchaenterprise.v1.MigrateKeyRequest,
                    com.google.recaptchaenterprise.v1.Key>(service, METHODID_MIGRATE_KEY)))
        .addMethod(
            getAddIpOverrideMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.recaptchaenterprise.v1.AddIpOverrideRequest,
                    com.google.recaptchaenterprise.v1.AddIpOverrideResponse>(
                    service, METHODID_ADD_IP_OVERRIDE)))
        .addMethod(
            getRemoveIpOverrideMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.recaptchaenterprise.v1.RemoveIpOverrideRequest,
                    com.google.recaptchaenterprise.v1.RemoveIpOverrideResponse>(
                    service, METHODID_REMOVE_IP_OVERRIDE)))
        .addMethod(
            getListIpOverridesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.recaptchaenterprise.v1.ListIpOverridesRequest,
                    com.google.recaptchaenterprise.v1.ListIpOverridesResponse>(
                    service, METHODID_LIST_IP_OVERRIDES)))
        .addMethod(
            getGetMetricsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.recaptchaenterprise.v1.GetMetricsRequest,
                    com.google.recaptchaenterprise.v1.Metrics>(service, METHODID_GET_METRICS)))
        .addMethod(
            getCreateFirewallPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.recaptchaenterprise.v1.CreateFirewallPolicyRequest,
                    com.google.recaptchaenterprise.v1.FirewallPolicy>(
                    service, METHODID_CREATE_FIREWALL_POLICY)))
        .addMethod(
            getListFirewallPoliciesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.recaptchaenterprise.v1.ListFirewallPoliciesRequest,
                    com.google.recaptchaenterprise.v1.ListFirewallPoliciesResponse>(
                    service, METHODID_LIST_FIREWALL_POLICIES)))
        .addMethod(
            getGetFirewallPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.recaptchaenterprise.v1.GetFirewallPolicyRequest,
                    com.google.recaptchaenterprise.v1.FirewallPolicy>(
                    service, METHODID_GET_FIREWALL_POLICY)))
        .addMethod(
            getUpdateFirewallPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.recaptchaenterprise.v1.UpdateFirewallPolicyRequest,
                    com.google.recaptchaenterprise.v1.FirewallPolicy>(
                    service, METHODID_UPDATE_FIREWALL_POLICY)))
        .addMethod(
            getDeleteFirewallPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.recaptchaenterprise.v1.DeleteFirewallPolicyRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_FIREWALL_POLICY)))
        .addMethod(
            getReorderFirewallPoliciesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.recaptchaenterprise.v1.ReorderFirewallPoliciesRequest,
                    com.google.recaptchaenterprise.v1.ReorderFirewallPoliciesResponse>(
                    service, METHODID_REORDER_FIREWALL_POLICIES)))
        .addMethod(
            getListRelatedAccountGroupsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.recaptchaenterprise.v1.ListRelatedAccountGroupsRequest,
                    com.google.recaptchaenterprise.v1.ListRelatedAccountGroupsResponse>(
                    service, METHODID_LIST_RELATED_ACCOUNT_GROUPS)))
        .addMethod(
            getListRelatedAccountGroupMembershipsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.recaptchaenterprise.v1.ListRelatedAccountGroupMembershipsRequest,
                    com.google.recaptchaenterprise.v1.ListRelatedAccountGroupMembershipsResponse>(
                    service, METHODID_LIST_RELATED_ACCOUNT_GROUP_MEMBERSHIPS)))
        .addMethod(
            getSearchRelatedAccountGroupMembershipsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.recaptchaenterprise.v1.SearchRelatedAccountGroupMembershipsRequest,
                    com.google.recaptchaenterprise.v1.SearchRelatedAccountGroupMembershipsResponse>(
                    service, METHODID_SEARCH_RELATED_ACCOUNT_GROUP_MEMBERSHIPS)))
        .build();
  }

  private abstract static class RecaptchaEnterpriseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RecaptchaEnterpriseServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.recaptchaenterprise.v1.RecaptchaEnterpriseProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RecaptchaEnterpriseService");
    }
  }

  private static final class RecaptchaEnterpriseServiceFileDescriptorSupplier
      extends RecaptchaEnterpriseServiceBaseDescriptorSupplier {
    RecaptchaEnterpriseServiceFileDescriptorSupplier() {}
  }

  private static final class RecaptchaEnterpriseServiceMethodDescriptorSupplier
      extends RecaptchaEnterpriseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    RecaptchaEnterpriseServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (RecaptchaEnterpriseServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new RecaptchaEnterpriseServiceFileDescriptorSupplier())
                      .addMethod(getCreateAssessmentMethod())
                      .addMethod(getAnnotateAssessmentMethod())
                      .addMethod(getCreateKeyMethod())
                      .addMethod(getListKeysMethod())
                      .addMethod(getRetrieveLegacySecretKeyMethod())
                      .addMethod(getGetKeyMethod())
                      .addMethod(getUpdateKeyMethod())
                      .addMethod(getDeleteKeyMethod())
                      .addMethod(getMigrateKeyMethod())
                      .addMethod(getAddIpOverrideMethod())
                      .addMethod(getRemoveIpOverrideMethod())
                      .addMethod(getListIpOverridesMethod())
                      .addMethod(getGetMetricsMethod())
                      .addMethod(getCreateFirewallPolicyMethod())
                      .addMethod(getListFirewallPoliciesMethod())
                      .addMethod(getGetFirewallPolicyMethod())
                      .addMethod(getUpdateFirewallPolicyMethod())
                      .addMethod(getDeleteFirewallPolicyMethod())
                      .addMethod(getReorderFirewallPoliciesMethod())
                      .addMethod(getListRelatedAccountGroupsMethod())
                      .addMethod(getListRelatedAccountGroupMembershipsMethod())
                      .addMethod(getSearchRelatedAccountGroupMembershipsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
