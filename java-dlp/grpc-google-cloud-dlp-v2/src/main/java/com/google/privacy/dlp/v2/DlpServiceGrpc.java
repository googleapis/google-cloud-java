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
package com.google.privacy.dlp.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Sensitive Data Protection provides access to a powerful sensitive data
 * inspection, classification, and de-identification platform that works
 * on text, images, and Google Cloud storage repositories.
 * To learn more about concepts and find how-to guides see
 * https://cloud.google.com/sensitive-data-protection/docs/.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/privacy/dlp/v2/dlp.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DlpServiceGrpc {

  private DlpServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.privacy.dlp.v2.DlpService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.InspectContentRequest,
          com.google.privacy.dlp.v2.InspectContentResponse>
      getInspectContentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InspectContent",
      requestType = com.google.privacy.dlp.v2.InspectContentRequest.class,
      responseType = com.google.privacy.dlp.v2.InspectContentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.InspectContentRequest,
          com.google.privacy.dlp.v2.InspectContentResponse>
      getInspectContentMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.InspectContentRequest,
            com.google.privacy.dlp.v2.InspectContentResponse>
        getInspectContentMethod;
    if ((getInspectContentMethod = DlpServiceGrpc.getInspectContentMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getInspectContentMethod = DlpServiceGrpc.getInspectContentMethod) == null) {
          DlpServiceGrpc.getInspectContentMethod =
              getInspectContentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.InspectContentRequest,
                          com.google.privacy.dlp.v2.InspectContentResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "InspectContent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.InspectContentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.InspectContentResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new DlpServiceMethodDescriptorSupplier("InspectContent"))
                      .build();
        }
      }
    }
    return getInspectContentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.RedactImageRequest,
          com.google.privacy.dlp.v2.RedactImageResponse>
      getRedactImageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RedactImage",
      requestType = com.google.privacy.dlp.v2.RedactImageRequest.class,
      responseType = com.google.privacy.dlp.v2.RedactImageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.RedactImageRequest,
          com.google.privacy.dlp.v2.RedactImageResponse>
      getRedactImageMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.RedactImageRequest,
            com.google.privacy.dlp.v2.RedactImageResponse>
        getRedactImageMethod;
    if ((getRedactImageMethod = DlpServiceGrpc.getRedactImageMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getRedactImageMethod = DlpServiceGrpc.getRedactImageMethod) == null) {
          DlpServiceGrpc.getRedactImageMethod =
              getRedactImageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.RedactImageRequest,
                          com.google.privacy.dlp.v2.RedactImageResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RedactImage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.RedactImageRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.RedactImageResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new DlpServiceMethodDescriptorSupplier("RedactImage"))
                      .build();
        }
      }
    }
    return getRedactImageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.DeidentifyContentRequest,
          com.google.privacy.dlp.v2.DeidentifyContentResponse>
      getDeidentifyContentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeidentifyContent",
      requestType = com.google.privacy.dlp.v2.DeidentifyContentRequest.class,
      responseType = com.google.privacy.dlp.v2.DeidentifyContentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.DeidentifyContentRequest,
          com.google.privacy.dlp.v2.DeidentifyContentResponse>
      getDeidentifyContentMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.DeidentifyContentRequest,
            com.google.privacy.dlp.v2.DeidentifyContentResponse>
        getDeidentifyContentMethod;
    if ((getDeidentifyContentMethod = DlpServiceGrpc.getDeidentifyContentMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getDeidentifyContentMethod = DlpServiceGrpc.getDeidentifyContentMethod) == null) {
          DlpServiceGrpc.getDeidentifyContentMethod =
              getDeidentifyContentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.DeidentifyContentRequest,
                          com.google.privacy.dlp.v2.DeidentifyContentResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeidentifyContent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.DeidentifyContentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.DeidentifyContentResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("DeidentifyContent"))
                      .build();
        }
      }
    }
    return getDeidentifyContentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.ReidentifyContentRequest,
          com.google.privacy.dlp.v2.ReidentifyContentResponse>
      getReidentifyContentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReidentifyContent",
      requestType = com.google.privacy.dlp.v2.ReidentifyContentRequest.class,
      responseType = com.google.privacy.dlp.v2.ReidentifyContentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.ReidentifyContentRequest,
          com.google.privacy.dlp.v2.ReidentifyContentResponse>
      getReidentifyContentMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.ReidentifyContentRequest,
            com.google.privacy.dlp.v2.ReidentifyContentResponse>
        getReidentifyContentMethod;
    if ((getReidentifyContentMethod = DlpServiceGrpc.getReidentifyContentMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getReidentifyContentMethod = DlpServiceGrpc.getReidentifyContentMethod) == null) {
          DlpServiceGrpc.getReidentifyContentMethod =
              getReidentifyContentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.ReidentifyContentRequest,
                          com.google.privacy.dlp.v2.ReidentifyContentResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReidentifyContent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.ReidentifyContentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.ReidentifyContentResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("ReidentifyContent"))
                      .build();
        }
      }
    }
    return getReidentifyContentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.ListInfoTypesRequest,
          com.google.privacy.dlp.v2.ListInfoTypesResponse>
      getListInfoTypesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListInfoTypes",
      requestType = com.google.privacy.dlp.v2.ListInfoTypesRequest.class,
      responseType = com.google.privacy.dlp.v2.ListInfoTypesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.ListInfoTypesRequest,
          com.google.privacy.dlp.v2.ListInfoTypesResponse>
      getListInfoTypesMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.ListInfoTypesRequest,
            com.google.privacy.dlp.v2.ListInfoTypesResponse>
        getListInfoTypesMethod;
    if ((getListInfoTypesMethod = DlpServiceGrpc.getListInfoTypesMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getListInfoTypesMethod = DlpServiceGrpc.getListInfoTypesMethod) == null) {
          DlpServiceGrpc.getListInfoTypesMethod =
              getListInfoTypesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.ListInfoTypesRequest,
                          com.google.privacy.dlp.v2.ListInfoTypesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListInfoTypes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.ListInfoTypesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.ListInfoTypesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new DlpServiceMethodDescriptorSupplier("ListInfoTypes"))
                      .build();
        }
      }
    }
    return getListInfoTypesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.CreateInspectTemplateRequest,
          com.google.privacy.dlp.v2.InspectTemplate>
      getCreateInspectTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateInspectTemplate",
      requestType = com.google.privacy.dlp.v2.CreateInspectTemplateRequest.class,
      responseType = com.google.privacy.dlp.v2.InspectTemplate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.CreateInspectTemplateRequest,
          com.google.privacy.dlp.v2.InspectTemplate>
      getCreateInspectTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.CreateInspectTemplateRequest,
            com.google.privacy.dlp.v2.InspectTemplate>
        getCreateInspectTemplateMethod;
    if ((getCreateInspectTemplateMethod = DlpServiceGrpc.getCreateInspectTemplateMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getCreateInspectTemplateMethod = DlpServiceGrpc.getCreateInspectTemplateMethod)
            == null) {
          DlpServiceGrpc.getCreateInspectTemplateMethod =
              getCreateInspectTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.CreateInspectTemplateRequest,
                          com.google.privacy.dlp.v2.InspectTemplate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateInspectTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.CreateInspectTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.InspectTemplate.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("CreateInspectTemplate"))
                      .build();
        }
      }
    }
    return getCreateInspectTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.UpdateInspectTemplateRequest,
          com.google.privacy.dlp.v2.InspectTemplate>
      getUpdateInspectTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateInspectTemplate",
      requestType = com.google.privacy.dlp.v2.UpdateInspectTemplateRequest.class,
      responseType = com.google.privacy.dlp.v2.InspectTemplate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.UpdateInspectTemplateRequest,
          com.google.privacy.dlp.v2.InspectTemplate>
      getUpdateInspectTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.UpdateInspectTemplateRequest,
            com.google.privacy.dlp.v2.InspectTemplate>
        getUpdateInspectTemplateMethod;
    if ((getUpdateInspectTemplateMethod = DlpServiceGrpc.getUpdateInspectTemplateMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getUpdateInspectTemplateMethod = DlpServiceGrpc.getUpdateInspectTemplateMethod)
            == null) {
          DlpServiceGrpc.getUpdateInspectTemplateMethod =
              getUpdateInspectTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.UpdateInspectTemplateRequest,
                          com.google.privacy.dlp.v2.InspectTemplate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateInspectTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.UpdateInspectTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.InspectTemplate.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("UpdateInspectTemplate"))
                      .build();
        }
      }
    }
    return getUpdateInspectTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.GetInspectTemplateRequest,
          com.google.privacy.dlp.v2.InspectTemplate>
      getGetInspectTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInspectTemplate",
      requestType = com.google.privacy.dlp.v2.GetInspectTemplateRequest.class,
      responseType = com.google.privacy.dlp.v2.InspectTemplate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.GetInspectTemplateRequest,
          com.google.privacy.dlp.v2.InspectTemplate>
      getGetInspectTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.GetInspectTemplateRequest,
            com.google.privacy.dlp.v2.InspectTemplate>
        getGetInspectTemplateMethod;
    if ((getGetInspectTemplateMethod = DlpServiceGrpc.getGetInspectTemplateMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getGetInspectTemplateMethod = DlpServiceGrpc.getGetInspectTemplateMethod) == null) {
          DlpServiceGrpc.getGetInspectTemplateMethod =
              getGetInspectTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.GetInspectTemplateRequest,
                          com.google.privacy.dlp.v2.InspectTemplate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInspectTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.GetInspectTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.InspectTemplate.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("GetInspectTemplate"))
                      .build();
        }
      }
    }
    return getGetInspectTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.ListInspectTemplatesRequest,
          com.google.privacy.dlp.v2.ListInspectTemplatesResponse>
      getListInspectTemplatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListInspectTemplates",
      requestType = com.google.privacy.dlp.v2.ListInspectTemplatesRequest.class,
      responseType = com.google.privacy.dlp.v2.ListInspectTemplatesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.ListInspectTemplatesRequest,
          com.google.privacy.dlp.v2.ListInspectTemplatesResponse>
      getListInspectTemplatesMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.ListInspectTemplatesRequest,
            com.google.privacy.dlp.v2.ListInspectTemplatesResponse>
        getListInspectTemplatesMethod;
    if ((getListInspectTemplatesMethod = DlpServiceGrpc.getListInspectTemplatesMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getListInspectTemplatesMethod = DlpServiceGrpc.getListInspectTemplatesMethod)
            == null) {
          DlpServiceGrpc.getListInspectTemplatesMethod =
              getListInspectTemplatesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.ListInspectTemplatesRequest,
                          com.google.privacy.dlp.v2.ListInspectTemplatesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListInspectTemplates"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.ListInspectTemplatesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.ListInspectTemplatesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("ListInspectTemplates"))
                      .build();
        }
      }
    }
    return getListInspectTemplatesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.DeleteInspectTemplateRequest, com.google.protobuf.Empty>
      getDeleteInspectTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteInspectTemplate",
      requestType = com.google.privacy.dlp.v2.DeleteInspectTemplateRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.DeleteInspectTemplateRequest, com.google.protobuf.Empty>
      getDeleteInspectTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.DeleteInspectTemplateRequest, com.google.protobuf.Empty>
        getDeleteInspectTemplateMethod;
    if ((getDeleteInspectTemplateMethod = DlpServiceGrpc.getDeleteInspectTemplateMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getDeleteInspectTemplateMethod = DlpServiceGrpc.getDeleteInspectTemplateMethod)
            == null) {
          DlpServiceGrpc.getDeleteInspectTemplateMethod =
              getDeleteInspectTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.DeleteInspectTemplateRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteInspectTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.DeleteInspectTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("DeleteInspectTemplate"))
                      .build();
        }
      }
    }
    return getDeleteInspectTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.CreateDeidentifyTemplateRequest,
          com.google.privacy.dlp.v2.DeidentifyTemplate>
      getCreateDeidentifyTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDeidentifyTemplate",
      requestType = com.google.privacy.dlp.v2.CreateDeidentifyTemplateRequest.class,
      responseType = com.google.privacy.dlp.v2.DeidentifyTemplate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.CreateDeidentifyTemplateRequest,
          com.google.privacy.dlp.v2.DeidentifyTemplate>
      getCreateDeidentifyTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.CreateDeidentifyTemplateRequest,
            com.google.privacy.dlp.v2.DeidentifyTemplate>
        getCreateDeidentifyTemplateMethod;
    if ((getCreateDeidentifyTemplateMethod = DlpServiceGrpc.getCreateDeidentifyTemplateMethod)
        == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getCreateDeidentifyTemplateMethod = DlpServiceGrpc.getCreateDeidentifyTemplateMethod)
            == null) {
          DlpServiceGrpc.getCreateDeidentifyTemplateMethod =
              getCreateDeidentifyTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.CreateDeidentifyTemplateRequest,
                          com.google.privacy.dlp.v2.DeidentifyTemplate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateDeidentifyTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.CreateDeidentifyTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.DeidentifyTemplate.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("CreateDeidentifyTemplate"))
                      .build();
        }
      }
    }
    return getCreateDeidentifyTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.UpdateDeidentifyTemplateRequest,
          com.google.privacy.dlp.v2.DeidentifyTemplate>
      getUpdateDeidentifyTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDeidentifyTemplate",
      requestType = com.google.privacy.dlp.v2.UpdateDeidentifyTemplateRequest.class,
      responseType = com.google.privacy.dlp.v2.DeidentifyTemplate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.UpdateDeidentifyTemplateRequest,
          com.google.privacy.dlp.v2.DeidentifyTemplate>
      getUpdateDeidentifyTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.UpdateDeidentifyTemplateRequest,
            com.google.privacy.dlp.v2.DeidentifyTemplate>
        getUpdateDeidentifyTemplateMethod;
    if ((getUpdateDeidentifyTemplateMethod = DlpServiceGrpc.getUpdateDeidentifyTemplateMethod)
        == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getUpdateDeidentifyTemplateMethod = DlpServiceGrpc.getUpdateDeidentifyTemplateMethod)
            == null) {
          DlpServiceGrpc.getUpdateDeidentifyTemplateMethod =
              getUpdateDeidentifyTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.UpdateDeidentifyTemplateRequest,
                          com.google.privacy.dlp.v2.DeidentifyTemplate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateDeidentifyTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.UpdateDeidentifyTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.DeidentifyTemplate.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("UpdateDeidentifyTemplate"))
                      .build();
        }
      }
    }
    return getUpdateDeidentifyTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.GetDeidentifyTemplateRequest,
          com.google.privacy.dlp.v2.DeidentifyTemplate>
      getGetDeidentifyTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDeidentifyTemplate",
      requestType = com.google.privacy.dlp.v2.GetDeidentifyTemplateRequest.class,
      responseType = com.google.privacy.dlp.v2.DeidentifyTemplate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.GetDeidentifyTemplateRequest,
          com.google.privacy.dlp.v2.DeidentifyTemplate>
      getGetDeidentifyTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.GetDeidentifyTemplateRequest,
            com.google.privacy.dlp.v2.DeidentifyTemplate>
        getGetDeidentifyTemplateMethod;
    if ((getGetDeidentifyTemplateMethod = DlpServiceGrpc.getGetDeidentifyTemplateMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getGetDeidentifyTemplateMethod = DlpServiceGrpc.getGetDeidentifyTemplateMethod)
            == null) {
          DlpServiceGrpc.getGetDeidentifyTemplateMethod =
              getGetDeidentifyTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.GetDeidentifyTemplateRequest,
                          com.google.privacy.dlp.v2.DeidentifyTemplate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetDeidentifyTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.GetDeidentifyTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.DeidentifyTemplate.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("GetDeidentifyTemplate"))
                      .build();
        }
      }
    }
    return getGetDeidentifyTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.ListDeidentifyTemplatesRequest,
          com.google.privacy.dlp.v2.ListDeidentifyTemplatesResponse>
      getListDeidentifyTemplatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDeidentifyTemplates",
      requestType = com.google.privacy.dlp.v2.ListDeidentifyTemplatesRequest.class,
      responseType = com.google.privacy.dlp.v2.ListDeidentifyTemplatesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.ListDeidentifyTemplatesRequest,
          com.google.privacy.dlp.v2.ListDeidentifyTemplatesResponse>
      getListDeidentifyTemplatesMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.ListDeidentifyTemplatesRequest,
            com.google.privacy.dlp.v2.ListDeidentifyTemplatesResponse>
        getListDeidentifyTemplatesMethod;
    if ((getListDeidentifyTemplatesMethod = DlpServiceGrpc.getListDeidentifyTemplatesMethod)
        == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getListDeidentifyTemplatesMethod = DlpServiceGrpc.getListDeidentifyTemplatesMethod)
            == null) {
          DlpServiceGrpc.getListDeidentifyTemplatesMethod =
              getListDeidentifyTemplatesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.ListDeidentifyTemplatesRequest,
                          com.google.privacy.dlp.v2.ListDeidentifyTemplatesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListDeidentifyTemplates"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.ListDeidentifyTemplatesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.ListDeidentifyTemplatesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("ListDeidentifyTemplates"))
                      .build();
        }
      }
    }
    return getListDeidentifyTemplatesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.DeleteDeidentifyTemplateRequest, com.google.protobuf.Empty>
      getDeleteDeidentifyTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDeidentifyTemplate",
      requestType = com.google.privacy.dlp.v2.DeleteDeidentifyTemplateRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.DeleteDeidentifyTemplateRequest, com.google.protobuf.Empty>
      getDeleteDeidentifyTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.DeleteDeidentifyTemplateRequest, com.google.protobuf.Empty>
        getDeleteDeidentifyTemplateMethod;
    if ((getDeleteDeidentifyTemplateMethod = DlpServiceGrpc.getDeleteDeidentifyTemplateMethod)
        == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getDeleteDeidentifyTemplateMethod = DlpServiceGrpc.getDeleteDeidentifyTemplateMethod)
            == null) {
          DlpServiceGrpc.getDeleteDeidentifyTemplateMethod =
              getDeleteDeidentifyTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.DeleteDeidentifyTemplateRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteDeidentifyTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.DeleteDeidentifyTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("DeleteDeidentifyTemplate"))
                      .build();
        }
      }
    }
    return getDeleteDeidentifyTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.CreateJobTriggerRequest, com.google.privacy.dlp.v2.JobTrigger>
      getCreateJobTriggerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateJobTrigger",
      requestType = com.google.privacy.dlp.v2.CreateJobTriggerRequest.class,
      responseType = com.google.privacy.dlp.v2.JobTrigger.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.CreateJobTriggerRequest, com.google.privacy.dlp.v2.JobTrigger>
      getCreateJobTriggerMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.CreateJobTriggerRequest, com.google.privacy.dlp.v2.JobTrigger>
        getCreateJobTriggerMethod;
    if ((getCreateJobTriggerMethod = DlpServiceGrpc.getCreateJobTriggerMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getCreateJobTriggerMethod = DlpServiceGrpc.getCreateJobTriggerMethod) == null) {
          DlpServiceGrpc.getCreateJobTriggerMethod =
              getCreateJobTriggerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.CreateJobTriggerRequest,
                          com.google.privacy.dlp.v2.JobTrigger>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateJobTrigger"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.CreateJobTriggerRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.JobTrigger.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("CreateJobTrigger"))
                      .build();
        }
      }
    }
    return getCreateJobTriggerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.UpdateJobTriggerRequest, com.google.privacy.dlp.v2.JobTrigger>
      getUpdateJobTriggerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateJobTrigger",
      requestType = com.google.privacy.dlp.v2.UpdateJobTriggerRequest.class,
      responseType = com.google.privacy.dlp.v2.JobTrigger.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.UpdateJobTriggerRequest, com.google.privacy.dlp.v2.JobTrigger>
      getUpdateJobTriggerMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.UpdateJobTriggerRequest, com.google.privacy.dlp.v2.JobTrigger>
        getUpdateJobTriggerMethod;
    if ((getUpdateJobTriggerMethod = DlpServiceGrpc.getUpdateJobTriggerMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getUpdateJobTriggerMethod = DlpServiceGrpc.getUpdateJobTriggerMethod) == null) {
          DlpServiceGrpc.getUpdateJobTriggerMethod =
              getUpdateJobTriggerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.UpdateJobTriggerRequest,
                          com.google.privacy.dlp.v2.JobTrigger>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateJobTrigger"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.UpdateJobTriggerRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.JobTrigger.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("UpdateJobTrigger"))
                      .build();
        }
      }
    }
    return getUpdateJobTriggerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.HybridInspectJobTriggerRequest,
          com.google.privacy.dlp.v2.HybridInspectResponse>
      getHybridInspectJobTriggerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "HybridInspectJobTrigger",
      requestType = com.google.privacy.dlp.v2.HybridInspectJobTriggerRequest.class,
      responseType = com.google.privacy.dlp.v2.HybridInspectResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.HybridInspectJobTriggerRequest,
          com.google.privacy.dlp.v2.HybridInspectResponse>
      getHybridInspectJobTriggerMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.HybridInspectJobTriggerRequest,
            com.google.privacy.dlp.v2.HybridInspectResponse>
        getHybridInspectJobTriggerMethod;
    if ((getHybridInspectJobTriggerMethod = DlpServiceGrpc.getHybridInspectJobTriggerMethod)
        == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getHybridInspectJobTriggerMethod = DlpServiceGrpc.getHybridInspectJobTriggerMethod)
            == null) {
          DlpServiceGrpc.getHybridInspectJobTriggerMethod =
              getHybridInspectJobTriggerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.HybridInspectJobTriggerRequest,
                          com.google.privacy.dlp.v2.HybridInspectResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "HybridInspectJobTrigger"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.HybridInspectJobTriggerRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.HybridInspectResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("HybridInspectJobTrigger"))
                      .build();
        }
      }
    }
    return getHybridInspectJobTriggerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.GetJobTriggerRequest, com.google.privacy.dlp.v2.JobTrigger>
      getGetJobTriggerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetJobTrigger",
      requestType = com.google.privacy.dlp.v2.GetJobTriggerRequest.class,
      responseType = com.google.privacy.dlp.v2.JobTrigger.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.GetJobTriggerRequest, com.google.privacy.dlp.v2.JobTrigger>
      getGetJobTriggerMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.GetJobTriggerRequest, com.google.privacy.dlp.v2.JobTrigger>
        getGetJobTriggerMethod;
    if ((getGetJobTriggerMethod = DlpServiceGrpc.getGetJobTriggerMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getGetJobTriggerMethod = DlpServiceGrpc.getGetJobTriggerMethod) == null) {
          DlpServiceGrpc.getGetJobTriggerMethod =
              getGetJobTriggerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.GetJobTriggerRequest,
                          com.google.privacy.dlp.v2.JobTrigger>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetJobTrigger"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.GetJobTriggerRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.JobTrigger.getDefaultInstance()))
                      .setSchemaDescriptor(new DlpServiceMethodDescriptorSupplier("GetJobTrigger"))
                      .build();
        }
      }
    }
    return getGetJobTriggerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.ListJobTriggersRequest,
          com.google.privacy.dlp.v2.ListJobTriggersResponse>
      getListJobTriggersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListJobTriggers",
      requestType = com.google.privacy.dlp.v2.ListJobTriggersRequest.class,
      responseType = com.google.privacy.dlp.v2.ListJobTriggersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.ListJobTriggersRequest,
          com.google.privacy.dlp.v2.ListJobTriggersResponse>
      getListJobTriggersMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.ListJobTriggersRequest,
            com.google.privacy.dlp.v2.ListJobTriggersResponse>
        getListJobTriggersMethod;
    if ((getListJobTriggersMethod = DlpServiceGrpc.getListJobTriggersMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getListJobTriggersMethod = DlpServiceGrpc.getListJobTriggersMethod) == null) {
          DlpServiceGrpc.getListJobTriggersMethod =
              getListJobTriggersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.ListJobTriggersRequest,
                          com.google.privacy.dlp.v2.ListJobTriggersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListJobTriggers"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.ListJobTriggersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.ListJobTriggersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("ListJobTriggers"))
                      .build();
        }
      }
    }
    return getListJobTriggersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.DeleteJobTriggerRequest, com.google.protobuf.Empty>
      getDeleteJobTriggerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteJobTrigger",
      requestType = com.google.privacy.dlp.v2.DeleteJobTriggerRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.DeleteJobTriggerRequest, com.google.protobuf.Empty>
      getDeleteJobTriggerMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.DeleteJobTriggerRequest, com.google.protobuf.Empty>
        getDeleteJobTriggerMethod;
    if ((getDeleteJobTriggerMethod = DlpServiceGrpc.getDeleteJobTriggerMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getDeleteJobTriggerMethod = DlpServiceGrpc.getDeleteJobTriggerMethod) == null) {
          DlpServiceGrpc.getDeleteJobTriggerMethod =
              getDeleteJobTriggerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.DeleteJobTriggerRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteJobTrigger"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.DeleteJobTriggerRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("DeleteJobTrigger"))
                      .build();
        }
      }
    }
    return getDeleteJobTriggerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.ActivateJobTriggerRequest, com.google.privacy.dlp.v2.DlpJob>
      getActivateJobTriggerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ActivateJobTrigger",
      requestType = com.google.privacy.dlp.v2.ActivateJobTriggerRequest.class,
      responseType = com.google.privacy.dlp.v2.DlpJob.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.ActivateJobTriggerRequest, com.google.privacy.dlp.v2.DlpJob>
      getActivateJobTriggerMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.ActivateJobTriggerRequest, com.google.privacy.dlp.v2.DlpJob>
        getActivateJobTriggerMethod;
    if ((getActivateJobTriggerMethod = DlpServiceGrpc.getActivateJobTriggerMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getActivateJobTriggerMethod = DlpServiceGrpc.getActivateJobTriggerMethod) == null) {
          DlpServiceGrpc.getActivateJobTriggerMethod =
              getActivateJobTriggerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.ActivateJobTriggerRequest,
                          com.google.privacy.dlp.v2.DlpJob>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ActivateJobTrigger"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.ActivateJobTriggerRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.DlpJob.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("ActivateJobTrigger"))
                      .build();
        }
      }
    }
    return getActivateJobTriggerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.CreateDiscoveryConfigRequest,
          com.google.privacy.dlp.v2.DiscoveryConfig>
      getCreateDiscoveryConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDiscoveryConfig",
      requestType = com.google.privacy.dlp.v2.CreateDiscoveryConfigRequest.class,
      responseType = com.google.privacy.dlp.v2.DiscoveryConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.CreateDiscoveryConfigRequest,
          com.google.privacy.dlp.v2.DiscoveryConfig>
      getCreateDiscoveryConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.CreateDiscoveryConfigRequest,
            com.google.privacy.dlp.v2.DiscoveryConfig>
        getCreateDiscoveryConfigMethod;
    if ((getCreateDiscoveryConfigMethod = DlpServiceGrpc.getCreateDiscoveryConfigMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getCreateDiscoveryConfigMethod = DlpServiceGrpc.getCreateDiscoveryConfigMethod)
            == null) {
          DlpServiceGrpc.getCreateDiscoveryConfigMethod =
              getCreateDiscoveryConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.CreateDiscoveryConfigRequest,
                          com.google.privacy.dlp.v2.DiscoveryConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateDiscoveryConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.CreateDiscoveryConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.DiscoveryConfig.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("CreateDiscoveryConfig"))
                      .build();
        }
      }
    }
    return getCreateDiscoveryConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.UpdateDiscoveryConfigRequest,
          com.google.privacy.dlp.v2.DiscoveryConfig>
      getUpdateDiscoveryConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDiscoveryConfig",
      requestType = com.google.privacy.dlp.v2.UpdateDiscoveryConfigRequest.class,
      responseType = com.google.privacy.dlp.v2.DiscoveryConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.UpdateDiscoveryConfigRequest,
          com.google.privacy.dlp.v2.DiscoveryConfig>
      getUpdateDiscoveryConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.UpdateDiscoveryConfigRequest,
            com.google.privacy.dlp.v2.DiscoveryConfig>
        getUpdateDiscoveryConfigMethod;
    if ((getUpdateDiscoveryConfigMethod = DlpServiceGrpc.getUpdateDiscoveryConfigMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getUpdateDiscoveryConfigMethod = DlpServiceGrpc.getUpdateDiscoveryConfigMethod)
            == null) {
          DlpServiceGrpc.getUpdateDiscoveryConfigMethod =
              getUpdateDiscoveryConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.UpdateDiscoveryConfigRequest,
                          com.google.privacy.dlp.v2.DiscoveryConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateDiscoveryConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.UpdateDiscoveryConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.DiscoveryConfig.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("UpdateDiscoveryConfig"))
                      .build();
        }
      }
    }
    return getUpdateDiscoveryConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.GetDiscoveryConfigRequest,
          com.google.privacy.dlp.v2.DiscoveryConfig>
      getGetDiscoveryConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDiscoveryConfig",
      requestType = com.google.privacy.dlp.v2.GetDiscoveryConfigRequest.class,
      responseType = com.google.privacy.dlp.v2.DiscoveryConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.GetDiscoveryConfigRequest,
          com.google.privacy.dlp.v2.DiscoveryConfig>
      getGetDiscoveryConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.GetDiscoveryConfigRequest,
            com.google.privacy.dlp.v2.DiscoveryConfig>
        getGetDiscoveryConfigMethod;
    if ((getGetDiscoveryConfigMethod = DlpServiceGrpc.getGetDiscoveryConfigMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getGetDiscoveryConfigMethod = DlpServiceGrpc.getGetDiscoveryConfigMethod) == null) {
          DlpServiceGrpc.getGetDiscoveryConfigMethod =
              getGetDiscoveryConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.GetDiscoveryConfigRequest,
                          com.google.privacy.dlp.v2.DiscoveryConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDiscoveryConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.GetDiscoveryConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.DiscoveryConfig.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("GetDiscoveryConfig"))
                      .build();
        }
      }
    }
    return getGetDiscoveryConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.ListDiscoveryConfigsRequest,
          com.google.privacy.dlp.v2.ListDiscoveryConfigsResponse>
      getListDiscoveryConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDiscoveryConfigs",
      requestType = com.google.privacy.dlp.v2.ListDiscoveryConfigsRequest.class,
      responseType = com.google.privacy.dlp.v2.ListDiscoveryConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.ListDiscoveryConfigsRequest,
          com.google.privacy.dlp.v2.ListDiscoveryConfigsResponse>
      getListDiscoveryConfigsMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.ListDiscoveryConfigsRequest,
            com.google.privacy.dlp.v2.ListDiscoveryConfigsResponse>
        getListDiscoveryConfigsMethod;
    if ((getListDiscoveryConfigsMethod = DlpServiceGrpc.getListDiscoveryConfigsMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getListDiscoveryConfigsMethod = DlpServiceGrpc.getListDiscoveryConfigsMethod)
            == null) {
          DlpServiceGrpc.getListDiscoveryConfigsMethod =
              getListDiscoveryConfigsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.ListDiscoveryConfigsRequest,
                          com.google.privacy.dlp.v2.ListDiscoveryConfigsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListDiscoveryConfigs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.ListDiscoveryConfigsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.ListDiscoveryConfigsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("ListDiscoveryConfigs"))
                      .build();
        }
      }
    }
    return getListDiscoveryConfigsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.DeleteDiscoveryConfigRequest, com.google.protobuf.Empty>
      getDeleteDiscoveryConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDiscoveryConfig",
      requestType = com.google.privacy.dlp.v2.DeleteDiscoveryConfigRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.DeleteDiscoveryConfigRequest, com.google.protobuf.Empty>
      getDeleteDiscoveryConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.DeleteDiscoveryConfigRequest, com.google.protobuf.Empty>
        getDeleteDiscoveryConfigMethod;
    if ((getDeleteDiscoveryConfigMethod = DlpServiceGrpc.getDeleteDiscoveryConfigMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getDeleteDiscoveryConfigMethod = DlpServiceGrpc.getDeleteDiscoveryConfigMethod)
            == null) {
          DlpServiceGrpc.getDeleteDiscoveryConfigMethod =
              getDeleteDiscoveryConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.DeleteDiscoveryConfigRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteDiscoveryConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.DeleteDiscoveryConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("DeleteDiscoveryConfig"))
                      .build();
        }
      }
    }
    return getDeleteDiscoveryConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.CreateDlpJobRequest, com.google.privacy.dlp.v2.DlpJob>
      getCreateDlpJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDlpJob",
      requestType = com.google.privacy.dlp.v2.CreateDlpJobRequest.class,
      responseType = com.google.privacy.dlp.v2.DlpJob.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.CreateDlpJobRequest, com.google.privacy.dlp.v2.DlpJob>
      getCreateDlpJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.CreateDlpJobRequest, com.google.privacy.dlp.v2.DlpJob>
        getCreateDlpJobMethod;
    if ((getCreateDlpJobMethod = DlpServiceGrpc.getCreateDlpJobMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getCreateDlpJobMethod = DlpServiceGrpc.getCreateDlpJobMethod) == null) {
          DlpServiceGrpc.getCreateDlpJobMethod =
              getCreateDlpJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.CreateDlpJobRequest,
                          com.google.privacy.dlp.v2.DlpJob>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDlpJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.CreateDlpJobRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.DlpJob.getDefaultInstance()))
                      .setSchemaDescriptor(new DlpServiceMethodDescriptorSupplier("CreateDlpJob"))
                      .build();
        }
      }
    }
    return getCreateDlpJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.ListDlpJobsRequest,
          com.google.privacy.dlp.v2.ListDlpJobsResponse>
      getListDlpJobsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDlpJobs",
      requestType = com.google.privacy.dlp.v2.ListDlpJobsRequest.class,
      responseType = com.google.privacy.dlp.v2.ListDlpJobsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.ListDlpJobsRequest,
          com.google.privacy.dlp.v2.ListDlpJobsResponse>
      getListDlpJobsMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.ListDlpJobsRequest,
            com.google.privacy.dlp.v2.ListDlpJobsResponse>
        getListDlpJobsMethod;
    if ((getListDlpJobsMethod = DlpServiceGrpc.getListDlpJobsMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getListDlpJobsMethod = DlpServiceGrpc.getListDlpJobsMethod) == null) {
          DlpServiceGrpc.getListDlpJobsMethod =
              getListDlpJobsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.ListDlpJobsRequest,
                          com.google.privacy.dlp.v2.ListDlpJobsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDlpJobs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.ListDlpJobsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.ListDlpJobsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new DlpServiceMethodDescriptorSupplier("ListDlpJobs"))
                      .build();
        }
      }
    }
    return getListDlpJobsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.GetDlpJobRequest, com.google.privacy.dlp.v2.DlpJob>
      getGetDlpJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDlpJob",
      requestType = com.google.privacy.dlp.v2.GetDlpJobRequest.class,
      responseType = com.google.privacy.dlp.v2.DlpJob.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.GetDlpJobRequest, com.google.privacy.dlp.v2.DlpJob>
      getGetDlpJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.GetDlpJobRequest, com.google.privacy.dlp.v2.DlpJob>
        getGetDlpJobMethod;
    if ((getGetDlpJobMethod = DlpServiceGrpc.getGetDlpJobMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getGetDlpJobMethod = DlpServiceGrpc.getGetDlpJobMethod) == null) {
          DlpServiceGrpc.getGetDlpJobMethod =
              getGetDlpJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.GetDlpJobRequest,
                          com.google.privacy.dlp.v2.DlpJob>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDlpJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.GetDlpJobRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.DlpJob.getDefaultInstance()))
                      .setSchemaDescriptor(new DlpServiceMethodDescriptorSupplier("GetDlpJob"))
                      .build();
        }
      }
    }
    return getGetDlpJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.DeleteDlpJobRequest, com.google.protobuf.Empty>
      getDeleteDlpJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDlpJob",
      requestType = com.google.privacy.dlp.v2.DeleteDlpJobRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.DeleteDlpJobRequest, com.google.protobuf.Empty>
      getDeleteDlpJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.DeleteDlpJobRequest, com.google.protobuf.Empty>
        getDeleteDlpJobMethod;
    if ((getDeleteDlpJobMethod = DlpServiceGrpc.getDeleteDlpJobMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getDeleteDlpJobMethod = DlpServiceGrpc.getDeleteDlpJobMethod) == null) {
          DlpServiceGrpc.getDeleteDlpJobMethod =
              getDeleteDlpJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.DeleteDlpJobRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDlpJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.DeleteDlpJobRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new DlpServiceMethodDescriptorSupplier("DeleteDlpJob"))
                      .build();
        }
      }
    }
    return getDeleteDlpJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.CancelDlpJobRequest, com.google.protobuf.Empty>
      getCancelDlpJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelDlpJob",
      requestType = com.google.privacy.dlp.v2.CancelDlpJobRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.CancelDlpJobRequest, com.google.protobuf.Empty>
      getCancelDlpJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.CancelDlpJobRequest, com.google.protobuf.Empty>
        getCancelDlpJobMethod;
    if ((getCancelDlpJobMethod = DlpServiceGrpc.getCancelDlpJobMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getCancelDlpJobMethod = DlpServiceGrpc.getCancelDlpJobMethod) == null) {
          DlpServiceGrpc.getCancelDlpJobMethod =
              getCancelDlpJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.CancelDlpJobRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CancelDlpJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.CancelDlpJobRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new DlpServiceMethodDescriptorSupplier("CancelDlpJob"))
                      .build();
        }
      }
    }
    return getCancelDlpJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.CreateStoredInfoTypeRequest,
          com.google.privacy.dlp.v2.StoredInfoType>
      getCreateStoredInfoTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateStoredInfoType",
      requestType = com.google.privacy.dlp.v2.CreateStoredInfoTypeRequest.class,
      responseType = com.google.privacy.dlp.v2.StoredInfoType.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.CreateStoredInfoTypeRequest,
          com.google.privacy.dlp.v2.StoredInfoType>
      getCreateStoredInfoTypeMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.CreateStoredInfoTypeRequest,
            com.google.privacy.dlp.v2.StoredInfoType>
        getCreateStoredInfoTypeMethod;
    if ((getCreateStoredInfoTypeMethod = DlpServiceGrpc.getCreateStoredInfoTypeMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getCreateStoredInfoTypeMethod = DlpServiceGrpc.getCreateStoredInfoTypeMethod)
            == null) {
          DlpServiceGrpc.getCreateStoredInfoTypeMethod =
              getCreateStoredInfoTypeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.CreateStoredInfoTypeRequest,
                          com.google.privacy.dlp.v2.StoredInfoType>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateStoredInfoType"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.CreateStoredInfoTypeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.StoredInfoType.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("CreateStoredInfoType"))
                      .build();
        }
      }
    }
    return getCreateStoredInfoTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.UpdateStoredInfoTypeRequest,
          com.google.privacy.dlp.v2.StoredInfoType>
      getUpdateStoredInfoTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateStoredInfoType",
      requestType = com.google.privacy.dlp.v2.UpdateStoredInfoTypeRequest.class,
      responseType = com.google.privacy.dlp.v2.StoredInfoType.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.UpdateStoredInfoTypeRequest,
          com.google.privacy.dlp.v2.StoredInfoType>
      getUpdateStoredInfoTypeMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.UpdateStoredInfoTypeRequest,
            com.google.privacy.dlp.v2.StoredInfoType>
        getUpdateStoredInfoTypeMethod;
    if ((getUpdateStoredInfoTypeMethod = DlpServiceGrpc.getUpdateStoredInfoTypeMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getUpdateStoredInfoTypeMethod = DlpServiceGrpc.getUpdateStoredInfoTypeMethod)
            == null) {
          DlpServiceGrpc.getUpdateStoredInfoTypeMethod =
              getUpdateStoredInfoTypeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.UpdateStoredInfoTypeRequest,
                          com.google.privacy.dlp.v2.StoredInfoType>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateStoredInfoType"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.UpdateStoredInfoTypeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.StoredInfoType.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("UpdateStoredInfoType"))
                      .build();
        }
      }
    }
    return getUpdateStoredInfoTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.GetStoredInfoTypeRequest,
          com.google.privacy.dlp.v2.StoredInfoType>
      getGetStoredInfoTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStoredInfoType",
      requestType = com.google.privacy.dlp.v2.GetStoredInfoTypeRequest.class,
      responseType = com.google.privacy.dlp.v2.StoredInfoType.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.GetStoredInfoTypeRequest,
          com.google.privacy.dlp.v2.StoredInfoType>
      getGetStoredInfoTypeMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.GetStoredInfoTypeRequest,
            com.google.privacy.dlp.v2.StoredInfoType>
        getGetStoredInfoTypeMethod;
    if ((getGetStoredInfoTypeMethod = DlpServiceGrpc.getGetStoredInfoTypeMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getGetStoredInfoTypeMethod = DlpServiceGrpc.getGetStoredInfoTypeMethod) == null) {
          DlpServiceGrpc.getGetStoredInfoTypeMethod =
              getGetStoredInfoTypeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.GetStoredInfoTypeRequest,
                          com.google.privacy.dlp.v2.StoredInfoType>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetStoredInfoType"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.GetStoredInfoTypeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.StoredInfoType.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("GetStoredInfoType"))
                      .build();
        }
      }
    }
    return getGetStoredInfoTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.ListStoredInfoTypesRequest,
          com.google.privacy.dlp.v2.ListStoredInfoTypesResponse>
      getListStoredInfoTypesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListStoredInfoTypes",
      requestType = com.google.privacy.dlp.v2.ListStoredInfoTypesRequest.class,
      responseType = com.google.privacy.dlp.v2.ListStoredInfoTypesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.ListStoredInfoTypesRequest,
          com.google.privacy.dlp.v2.ListStoredInfoTypesResponse>
      getListStoredInfoTypesMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.ListStoredInfoTypesRequest,
            com.google.privacy.dlp.v2.ListStoredInfoTypesResponse>
        getListStoredInfoTypesMethod;
    if ((getListStoredInfoTypesMethod = DlpServiceGrpc.getListStoredInfoTypesMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getListStoredInfoTypesMethod = DlpServiceGrpc.getListStoredInfoTypesMethod) == null) {
          DlpServiceGrpc.getListStoredInfoTypesMethod =
              getListStoredInfoTypesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.ListStoredInfoTypesRequest,
                          com.google.privacy.dlp.v2.ListStoredInfoTypesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListStoredInfoTypes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.ListStoredInfoTypesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.ListStoredInfoTypesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("ListStoredInfoTypes"))
                      .build();
        }
      }
    }
    return getListStoredInfoTypesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.DeleteStoredInfoTypeRequest, com.google.protobuf.Empty>
      getDeleteStoredInfoTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteStoredInfoType",
      requestType = com.google.privacy.dlp.v2.DeleteStoredInfoTypeRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.DeleteStoredInfoTypeRequest, com.google.protobuf.Empty>
      getDeleteStoredInfoTypeMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.DeleteStoredInfoTypeRequest, com.google.protobuf.Empty>
        getDeleteStoredInfoTypeMethod;
    if ((getDeleteStoredInfoTypeMethod = DlpServiceGrpc.getDeleteStoredInfoTypeMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getDeleteStoredInfoTypeMethod = DlpServiceGrpc.getDeleteStoredInfoTypeMethod)
            == null) {
          DlpServiceGrpc.getDeleteStoredInfoTypeMethod =
              getDeleteStoredInfoTypeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.DeleteStoredInfoTypeRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteStoredInfoType"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.DeleteStoredInfoTypeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("DeleteStoredInfoType"))
                      .build();
        }
      }
    }
    return getDeleteStoredInfoTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.ListProjectDataProfilesRequest,
          com.google.privacy.dlp.v2.ListProjectDataProfilesResponse>
      getListProjectDataProfilesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListProjectDataProfiles",
      requestType = com.google.privacy.dlp.v2.ListProjectDataProfilesRequest.class,
      responseType = com.google.privacy.dlp.v2.ListProjectDataProfilesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.ListProjectDataProfilesRequest,
          com.google.privacy.dlp.v2.ListProjectDataProfilesResponse>
      getListProjectDataProfilesMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.ListProjectDataProfilesRequest,
            com.google.privacy.dlp.v2.ListProjectDataProfilesResponse>
        getListProjectDataProfilesMethod;
    if ((getListProjectDataProfilesMethod = DlpServiceGrpc.getListProjectDataProfilesMethod)
        == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getListProjectDataProfilesMethod = DlpServiceGrpc.getListProjectDataProfilesMethod)
            == null) {
          DlpServiceGrpc.getListProjectDataProfilesMethod =
              getListProjectDataProfilesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.ListProjectDataProfilesRequest,
                          com.google.privacy.dlp.v2.ListProjectDataProfilesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListProjectDataProfiles"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.ListProjectDataProfilesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.ListProjectDataProfilesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("ListProjectDataProfiles"))
                      .build();
        }
      }
    }
    return getListProjectDataProfilesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.ListTableDataProfilesRequest,
          com.google.privacy.dlp.v2.ListTableDataProfilesResponse>
      getListTableDataProfilesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTableDataProfiles",
      requestType = com.google.privacy.dlp.v2.ListTableDataProfilesRequest.class,
      responseType = com.google.privacy.dlp.v2.ListTableDataProfilesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.ListTableDataProfilesRequest,
          com.google.privacy.dlp.v2.ListTableDataProfilesResponse>
      getListTableDataProfilesMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.ListTableDataProfilesRequest,
            com.google.privacy.dlp.v2.ListTableDataProfilesResponse>
        getListTableDataProfilesMethod;
    if ((getListTableDataProfilesMethod = DlpServiceGrpc.getListTableDataProfilesMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getListTableDataProfilesMethod = DlpServiceGrpc.getListTableDataProfilesMethod)
            == null) {
          DlpServiceGrpc.getListTableDataProfilesMethod =
              getListTableDataProfilesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.ListTableDataProfilesRequest,
                          com.google.privacy.dlp.v2.ListTableDataProfilesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListTableDataProfiles"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.ListTableDataProfilesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.ListTableDataProfilesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("ListTableDataProfiles"))
                      .build();
        }
      }
    }
    return getListTableDataProfilesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.ListColumnDataProfilesRequest,
          com.google.privacy.dlp.v2.ListColumnDataProfilesResponse>
      getListColumnDataProfilesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListColumnDataProfiles",
      requestType = com.google.privacy.dlp.v2.ListColumnDataProfilesRequest.class,
      responseType = com.google.privacy.dlp.v2.ListColumnDataProfilesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.ListColumnDataProfilesRequest,
          com.google.privacy.dlp.v2.ListColumnDataProfilesResponse>
      getListColumnDataProfilesMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.ListColumnDataProfilesRequest,
            com.google.privacy.dlp.v2.ListColumnDataProfilesResponse>
        getListColumnDataProfilesMethod;
    if ((getListColumnDataProfilesMethod = DlpServiceGrpc.getListColumnDataProfilesMethod)
        == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getListColumnDataProfilesMethod = DlpServiceGrpc.getListColumnDataProfilesMethod)
            == null) {
          DlpServiceGrpc.getListColumnDataProfilesMethod =
              getListColumnDataProfilesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.ListColumnDataProfilesRequest,
                          com.google.privacy.dlp.v2.ListColumnDataProfilesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListColumnDataProfiles"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.ListColumnDataProfilesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.ListColumnDataProfilesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("ListColumnDataProfiles"))
                      .build();
        }
      }
    }
    return getListColumnDataProfilesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.GetProjectDataProfileRequest,
          com.google.privacy.dlp.v2.ProjectDataProfile>
      getGetProjectDataProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProjectDataProfile",
      requestType = com.google.privacy.dlp.v2.GetProjectDataProfileRequest.class,
      responseType = com.google.privacy.dlp.v2.ProjectDataProfile.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.GetProjectDataProfileRequest,
          com.google.privacy.dlp.v2.ProjectDataProfile>
      getGetProjectDataProfileMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.GetProjectDataProfileRequest,
            com.google.privacy.dlp.v2.ProjectDataProfile>
        getGetProjectDataProfileMethod;
    if ((getGetProjectDataProfileMethod = DlpServiceGrpc.getGetProjectDataProfileMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getGetProjectDataProfileMethod = DlpServiceGrpc.getGetProjectDataProfileMethod)
            == null) {
          DlpServiceGrpc.getGetProjectDataProfileMethod =
              getGetProjectDataProfileMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.GetProjectDataProfileRequest,
                          com.google.privacy.dlp.v2.ProjectDataProfile>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetProjectDataProfile"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.GetProjectDataProfileRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.ProjectDataProfile.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("GetProjectDataProfile"))
                      .build();
        }
      }
    }
    return getGetProjectDataProfileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.ListFileStoreDataProfilesRequest,
          com.google.privacy.dlp.v2.ListFileStoreDataProfilesResponse>
      getListFileStoreDataProfilesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFileStoreDataProfiles",
      requestType = com.google.privacy.dlp.v2.ListFileStoreDataProfilesRequest.class,
      responseType = com.google.privacy.dlp.v2.ListFileStoreDataProfilesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.ListFileStoreDataProfilesRequest,
          com.google.privacy.dlp.v2.ListFileStoreDataProfilesResponse>
      getListFileStoreDataProfilesMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.ListFileStoreDataProfilesRequest,
            com.google.privacy.dlp.v2.ListFileStoreDataProfilesResponse>
        getListFileStoreDataProfilesMethod;
    if ((getListFileStoreDataProfilesMethod = DlpServiceGrpc.getListFileStoreDataProfilesMethod)
        == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getListFileStoreDataProfilesMethod = DlpServiceGrpc.getListFileStoreDataProfilesMethod)
            == null) {
          DlpServiceGrpc.getListFileStoreDataProfilesMethod =
              getListFileStoreDataProfilesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.ListFileStoreDataProfilesRequest,
                          com.google.privacy.dlp.v2.ListFileStoreDataProfilesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListFileStoreDataProfiles"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.ListFileStoreDataProfilesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.ListFileStoreDataProfilesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("ListFileStoreDataProfiles"))
                      .build();
        }
      }
    }
    return getListFileStoreDataProfilesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.GetFileStoreDataProfileRequest,
          com.google.privacy.dlp.v2.FileStoreDataProfile>
      getGetFileStoreDataProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFileStoreDataProfile",
      requestType = com.google.privacy.dlp.v2.GetFileStoreDataProfileRequest.class,
      responseType = com.google.privacy.dlp.v2.FileStoreDataProfile.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.GetFileStoreDataProfileRequest,
          com.google.privacy.dlp.v2.FileStoreDataProfile>
      getGetFileStoreDataProfileMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.GetFileStoreDataProfileRequest,
            com.google.privacy.dlp.v2.FileStoreDataProfile>
        getGetFileStoreDataProfileMethod;
    if ((getGetFileStoreDataProfileMethod = DlpServiceGrpc.getGetFileStoreDataProfileMethod)
        == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getGetFileStoreDataProfileMethod = DlpServiceGrpc.getGetFileStoreDataProfileMethod)
            == null) {
          DlpServiceGrpc.getGetFileStoreDataProfileMethod =
              getGetFileStoreDataProfileMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.GetFileStoreDataProfileRequest,
                          com.google.privacy.dlp.v2.FileStoreDataProfile>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetFileStoreDataProfile"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.GetFileStoreDataProfileRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.FileStoreDataProfile.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("GetFileStoreDataProfile"))
                      .build();
        }
      }
    }
    return getGetFileStoreDataProfileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.DeleteFileStoreDataProfileRequest, com.google.protobuf.Empty>
      getDeleteFileStoreDataProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteFileStoreDataProfile",
      requestType = com.google.privacy.dlp.v2.DeleteFileStoreDataProfileRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.DeleteFileStoreDataProfileRequest, com.google.protobuf.Empty>
      getDeleteFileStoreDataProfileMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.DeleteFileStoreDataProfileRequest, com.google.protobuf.Empty>
        getDeleteFileStoreDataProfileMethod;
    if ((getDeleteFileStoreDataProfileMethod = DlpServiceGrpc.getDeleteFileStoreDataProfileMethod)
        == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getDeleteFileStoreDataProfileMethod =
                DlpServiceGrpc.getDeleteFileStoreDataProfileMethod)
            == null) {
          DlpServiceGrpc.getDeleteFileStoreDataProfileMethod =
              getDeleteFileStoreDataProfileMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.DeleteFileStoreDataProfileRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteFileStoreDataProfile"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.DeleteFileStoreDataProfileRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("DeleteFileStoreDataProfile"))
                      .build();
        }
      }
    }
    return getDeleteFileStoreDataProfileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.GetTableDataProfileRequest,
          com.google.privacy.dlp.v2.TableDataProfile>
      getGetTableDataProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTableDataProfile",
      requestType = com.google.privacy.dlp.v2.GetTableDataProfileRequest.class,
      responseType = com.google.privacy.dlp.v2.TableDataProfile.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.GetTableDataProfileRequest,
          com.google.privacy.dlp.v2.TableDataProfile>
      getGetTableDataProfileMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.GetTableDataProfileRequest,
            com.google.privacy.dlp.v2.TableDataProfile>
        getGetTableDataProfileMethod;
    if ((getGetTableDataProfileMethod = DlpServiceGrpc.getGetTableDataProfileMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getGetTableDataProfileMethod = DlpServiceGrpc.getGetTableDataProfileMethod) == null) {
          DlpServiceGrpc.getGetTableDataProfileMethod =
              getGetTableDataProfileMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.GetTableDataProfileRequest,
                          com.google.privacy.dlp.v2.TableDataProfile>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetTableDataProfile"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.GetTableDataProfileRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.TableDataProfile.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("GetTableDataProfile"))
                      .build();
        }
      }
    }
    return getGetTableDataProfileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.GetColumnDataProfileRequest,
          com.google.privacy.dlp.v2.ColumnDataProfile>
      getGetColumnDataProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetColumnDataProfile",
      requestType = com.google.privacy.dlp.v2.GetColumnDataProfileRequest.class,
      responseType = com.google.privacy.dlp.v2.ColumnDataProfile.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.GetColumnDataProfileRequest,
          com.google.privacy.dlp.v2.ColumnDataProfile>
      getGetColumnDataProfileMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.GetColumnDataProfileRequest,
            com.google.privacy.dlp.v2.ColumnDataProfile>
        getGetColumnDataProfileMethod;
    if ((getGetColumnDataProfileMethod = DlpServiceGrpc.getGetColumnDataProfileMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getGetColumnDataProfileMethod = DlpServiceGrpc.getGetColumnDataProfileMethod)
            == null) {
          DlpServiceGrpc.getGetColumnDataProfileMethod =
              getGetColumnDataProfileMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.GetColumnDataProfileRequest,
                          com.google.privacy.dlp.v2.ColumnDataProfile>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetColumnDataProfile"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.GetColumnDataProfileRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.ColumnDataProfile.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("GetColumnDataProfile"))
                      .build();
        }
      }
    }
    return getGetColumnDataProfileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.DeleteTableDataProfileRequest, com.google.protobuf.Empty>
      getDeleteTableDataProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTableDataProfile",
      requestType = com.google.privacy.dlp.v2.DeleteTableDataProfileRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.DeleteTableDataProfileRequest, com.google.protobuf.Empty>
      getDeleteTableDataProfileMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.DeleteTableDataProfileRequest, com.google.protobuf.Empty>
        getDeleteTableDataProfileMethod;
    if ((getDeleteTableDataProfileMethod = DlpServiceGrpc.getDeleteTableDataProfileMethod)
        == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getDeleteTableDataProfileMethod = DlpServiceGrpc.getDeleteTableDataProfileMethod)
            == null) {
          DlpServiceGrpc.getDeleteTableDataProfileMethod =
              getDeleteTableDataProfileMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.DeleteTableDataProfileRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteTableDataProfile"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.DeleteTableDataProfileRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("DeleteTableDataProfile"))
                      .build();
        }
      }
    }
    return getDeleteTableDataProfileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.HybridInspectDlpJobRequest,
          com.google.privacy.dlp.v2.HybridInspectResponse>
      getHybridInspectDlpJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "HybridInspectDlpJob",
      requestType = com.google.privacy.dlp.v2.HybridInspectDlpJobRequest.class,
      responseType = com.google.privacy.dlp.v2.HybridInspectResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.HybridInspectDlpJobRequest,
          com.google.privacy.dlp.v2.HybridInspectResponse>
      getHybridInspectDlpJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.HybridInspectDlpJobRequest,
            com.google.privacy.dlp.v2.HybridInspectResponse>
        getHybridInspectDlpJobMethod;
    if ((getHybridInspectDlpJobMethod = DlpServiceGrpc.getHybridInspectDlpJobMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getHybridInspectDlpJobMethod = DlpServiceGrpc.getHybridInspectDlpJobMethod) == null) {
          DlpServiceGrpc.getHybridInspectDlpJobMethod =
              getHybridInspectDlpJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.HybridInspectDlpJobRequest,
                          com.google.privacy.dlp.v2.HybridInspectResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "HybridInspectDlpJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.HybridInspectDlpJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.HybridInspectResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("HybridInspectDlpJob"))
                      .build();
        }
      }
    }
    return getHybridInspectDlpJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.FinishDlpJobRequest, com.google.protobuf.Empty>
      getFinishDlpJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FinishDlpJob",
      requestType = com.google.privacy.dlp.v2.FinishDlpJobRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.FinishDlpJobRequest, com.google.protobuf.Empty>
      getFinishDlpJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.FinishDlpJobRequest, com.google.protobuf.Empty>
        getFinishDlpJobMethod;
    if ((getFinishDlpJobMethod = DlpServiceGrpc.getFinishDlpJobMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getFinishDlpJobMethod = DlpServiceGrpc.getFinishDlpJobMethod) == null) {
          DlpServiceGrpc.getFinishDlpJobMethod =
              getFinishDlpJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.FinishDlpJobRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FinishDlpJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.FinishDlpJobRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new DlpServiceMethodDescriptorSupplier("FinishDlpJob"))
                      .build();
        }
      }
    }
    return getFinishDlpJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.CreateConnectionRequest, com.google.privacy.dlp.v2.Connection>
      getCreateConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateConnection",
      requestType = com.google.privacy.dlp.v2.CreateConnectionRequest.class,
      responseType = com.google.privacy.dlp.v2.Connection.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.CreateConnectionRequest, com.google.privacy.dlp.v2.Connection>
      getCreateConnectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.CreateConnectionRequest, com.google.privacy.dlp.v2.Connection>
        getCreateConnectionMethod;
    if ((getCreateConnectionMethod = DlpServiceGrpc.getCreateConnectionMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getCreateConnectionMethod = DlpServiceGrpc.getCreateConnectionMethod) == null) {
          DlpServiceGrpc.getCreateConnectionMethod =
              getCreateConnectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.CreateConnectionRequest,
                          com.google.privacy.dlp.v2.Connection>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateConnection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.CreateConnectionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.Connection.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("CreateConnection"))
                      .build();
        }
      }
    }
    return getCreateConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.GetConnectionRequest, com.google.privacy.dlp.v2.Connection>
      getGetConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetConnection",
      requestType = com.google.privacy.dlp.v2.GetConnectionRequest.class,
      responseType = com.google.privacy.dlp.v2.Connection.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.GetConnectionRequest, com.google.privacy.dlp.v2.Connection>
      getGetConnectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.GetConnectionRequest, com.google.privacy.dlp.v2.Connection>
        getGetConnectionMethod;
    if ((getGetConnectionMethod = DlpServiceGrpc.getGetConnectionMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getGetConnectionMethod = DlpServiceGrpc.getGetConnectionMethod) == null) {
          DlpServiceGrpc.getGetConnectionMethod =
              getGetConnectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.GetConnectionRequest,
                          com.google.privacy.dlp.v2.Connection>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetConnection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.GetConnectionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.Connection.getDefaultInstance()))
                      .setSchemaDescriptor(new DlpServiceMethodDescriptorSupplier("GetConnection"))
                      .build();
        }
      }
    }
    return getGetConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.ListConnectionsRequest,
          com.google.privacy.dlp.v2.ListConnectionsResponse>
      getListConnectionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListConnections",
      requestType = com.google.privacy.dlp.v2.ListConnectionsRequest.class,
      responseType = com.google.privacy.dlp.v2.ListConnectionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.ListConnectionsRequest,
          com.google.privacy.dlp.v2.ListConnectionsResponse>
      getListConnectionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.ListConnectionsRequest,
            com.google.privacy.dlp.v2.ListConnectionsResponse>
        getListConnectionsMethod;
    if ((getListConnectionsMethod = DlpServiceGrpc.getListConnectionsMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getListConnectionsMethod = DlpServiceGrpc.getListConnectionsMethod) == null) {
          DlpServiceGrpc.getListConnectionsMethod =
              getListConnectionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.ListConnectionsRequest,
                          com.google.privacy.dlp.v2.ListConnectionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListConnections"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.ListConnectionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.ListConnectionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("ListConnections"))
                      .build();
        }
      }
    }
    return getListConnectionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.SearchConnectionsRequest,
          com.google.privacy.dlp.v2.SearchConnectionsResponse>
      getSearchConnectionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchConnections",
      requestType = com.google.privacy.dlp.v2.SearchConnectionsRequest.class,
      responseType = com.google.privacy.dlp.v2.SearchConnectionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.SearchConnectionsRequest,
          com.google.privacy.dlp.v2.SearchConnectionsResponse>
      getSearchConnectionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.SearchConnectionsRequest,
            com.google.privacy.dlp.v2.SearchConnectionsResponse>
        getSearchConnectionsMethod;
    if ((getSearchConnectionsMethod = DlpServiceGrpc.getSearchConnectionsMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getSearchConnectionsMethod = DlpServiceGrpc.getSearchConnectionsMethod) == null) {
          DlpServiceGrpc.getSearchConnectionsMethod =
              getSearchConnectionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.SearchConnectionsRequest,
                          com.google.privacy.dlp.v2.SearchConnectionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchConnections"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.SearchConnectionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.SearchConnectionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("SearchConnections"))
                      .build();
        }
      }
    }
    return getSearchConnectionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.DeleteConnectionRequest, com.google.protobuf.Empty>
      getDeleteConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteConnection",
      requestType = com.google.privacy.dlp.v2.DeleteConnectionRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.DeleteConnectionRequest, com.google.protobuf.Empty>
      getDeleteConnectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.DeleteConnectionRequest, com.google.protobuf.Empty>
        getDeleteConnectionMethod;
    if ((getDeleteConnectionMethod = DlpServiceGrpc.getDeleteConnectionMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getDeleteConnectionMethod = DlpServiceGrpc.getDeleteConnectionMethod) == null) {
          DlpServiceGrpc.getDeleteConnectionMethod =
              getDeleteConnectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.DeleteConnectionRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteConnection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.DeleteConnectionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("DeleteConnection"))
                      .build();
        }
      }
    }
    return getDeleteConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.UpdateConnectionRequest, com.google.privacy.dlp.v2.Connection>
      getUpdateConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateConnection",
      requestType = com.google.privacy.dlp.v2.UpdateConnectionRequest.class,
      responseType = com.google.privacy.dlp.v2.Connection.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.privacy.dlp.v2.UpdateConnectionRequest, com.google.privacy.dlp.v2.Connection>
      getUpdateConnectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.privacy.dlp.v2.UpdateConnectionRequest, com.google.privacy.dlp.v2.Connection>
        getUpdateConnectionMethod;
    if ((getUpdateConnectionMethod = DlpServiceGrpc.getUpdateConnectionMethod) == null) {
      synchronized (DlpServiceGrpc.class) {
        if ((getUpdateConnectionMethod = DlpServiceGrpc.getUpdateConnectionMethod) == null) {
          DlpServiceGrpc.getUpdateConnectionMethod =
              getUpdateConnectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.privacy.dlp.v2.UpdateConnectionRequest,
                          com.google.privacy.dlp.v2.Connection>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateConnection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.UpdateConnectionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.privacy.dlp.v2.Connection.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DlpServiceMethodDescriptorSupplier("UpdateConnection"))
                      .build();
        }
      }
    }
    return getUpdateConnectionMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DlpServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DlpServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DlpServiceStub>() {
          @java.lang.Override
          public DlpServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DlpServiceStub(channel, callOptions);
          }
        };
    return DlpServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DlpServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DlpServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DlpServiceBlockingStub>() {
          @java.lang.Override
          public DlpServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DlpServiceBlockingStub(channel, callOptions);
          }
        };
    return DlpServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DlpServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DlpServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DlpServiceFutureStub>() {
          @java.lang.Override
          public DlpServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DlpServiceFutureStub(channel, callOptions);
          }
        };
    return DlpServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Sensitive Data Protection provides access to a powerful sensitive data
   * inspection, classification, and de-identification platform that works
   * on text, images, and Google Cloud storage repositories.
   * To learn more about concepts and find how-to guides see
   * https://cloud.google.com/sensitive-data-protection/docs/.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Finds potentially sensitive info in content.
     * This method has limits on input size, processing time, and output size.
     * When no InfoTypes or CustomInfoTypes are specified in this request, the
     * system will automatically choose what detectors to run. By default this may
     * be all types, but may change over time as detectors are updated.
     * For how to guides, see
     * https://cloud.google.com/sensitive-data-protection/docs/inspecting-images
     * and
     * https://cloud.google.com/sensitive-data-protection/docs/inspecting-text,
     * </pre>
     */
    default void inspectContent(
        com.google.privacy.dlp.v2.InspectContentRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.InspectContentResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getInspectContentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Redacts potentially sensitive info from an image.
     * This method has limits on input size, processing time, and output size.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/redacting-sensitive-data-images
     * to learn more.
     * When no InfoTypes or CustomInfoTypes are specified in this request, the
     * system will automatically choose what detectors to run. By default this may
     * be all types, but may change over time as detectors are updated.
     * </pre>
     */
    default void redactImage(
        com.google.privacy.dlp.v2.RedactImageRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.RedactImageResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRedactImageMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * De-identifies potentially sensitive info from a ContentItem.
     * This method has limits on input size and output size.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/deidentify-sensitive-data
     * to learn more.
     * When no InfoTypes or CustomInfoTypes are specified in this request, the
     * system will automatically choose what detectors to run. By default this may
     * be all types, but may change over time as detectors are updated.
     * </pre>
     */
    default void deidentifyContent(
        com.google.privacy.dlp.v2.DeidentifyContentRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.DeidentifyContentResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeidentifyContentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Re-identifies content that has been de-identified.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/pseudonymization#re-identification_in_free_text_code_example
     * to learn more.
     * </pre>
     */
    default void reidentifyContent(
        com.google.privacy.dlp.v2.ReidentifyContentRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ReidentifyContentResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getReidentifyContentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of the sensitive information types that the DLP API
     * supports. See
     * https://cloud.google.com/sensitive-data-protection/docs/infotypes-reference
     * to learn more.
     * </pre>
     */
    default void listInfoTypes(
        com.google.privacy.dlp.v2.ListInfoTypesRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ListInfoTypesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListInfoTypesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an InspectTemplate for reusing frequently used configuration
     * for inspecting content, images, and storage.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates
     * to learn more.
     * </pre>
     */
    default void createInspectTemplate(
        com.google.privacy.dlp.v2.CreateInspectTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.InspectTemplate> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateInspectTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the InspectTemplate.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates
     * to learn more.
     * </pre>
     */
    default void updateInspectTemplate(
        com.google.privacy.dlp.v2.UpdateInspectTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.InspectTemplate> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateInspectTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an InspectTemplate.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates
     * to learn more.
     * </pre>
     */
    default void getInspectTemplate(
        com.google.privacy.dlp.v2.GetInspectTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.InspectTemplate> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetInspectTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists InspectTemplates.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates
     * to learn more.
     * </pre>
     */
    default void listInspectTemplates(
        com.google.privacy.dlp.v2.ListInspectTemplatesRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ListInspectTemplatesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListInspectTemplatesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an InspectTemplate.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates
     * to learn more.
     * </pre>
     */
    default void deleteInspectTemplate(
        com.google.privacy.dlp.v2.DeleteInspectTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteInspectTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a DeidentifyTemplate for reusing frequently used configuration
     * for de-identifying content, images, and storage.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid
     * to learn more.
     * </pre>
     */
    default void createDeidentifyTemplate(
        com.google.privacy.dlp.v2.CreateDeidentifyTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.DeidentifyTemplate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDeidentifyTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the DeidentifyTemplate.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid
     * to learn more.
     * </pre>
     */
    default void updateDeidentifyTemplate(
        com.google.privacy.dlp.v2.UpdateDeidentifyTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.DeidentifyTemplate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDeidentifyTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a DeidentifyTemplate.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid
     * to learn more.
     * </pre>
     */
    default void getDeidentifyTemplate(
        com.google.privacy.dlp.v2.GetDeidentifyTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.DeidentifyTemplate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDeidentifyTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists DeidentifyTemplates.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid
     * to learn more.
     * </pre>
     */
    default void listDeidentifyTemplates(
        com.google.privacy.dlp.v2.ListDeidentifyTemplatesRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ListDeidentifyTemplatesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDeidentifyTemplatesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a DeidentifyTemplate.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid
     * to learn more.
     * </pre>
     */
    default void deleteDeidentifyTemplate(
        com.google.privacy.dlp.v2.DeleteDeidentifyTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDeidentifyTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a job trigger to run DLP actions such as scanning storage for
     * sensitive information on a set schedule.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers
     * to learn more.
     * </pre>
     */
    default void createJobTrigger(
        com.google.privacy.dlp.v2.CreateJobTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.JobTrigger> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateJobTriggerMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a job trigger.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers
     * to learn more.
     * </pre>
     */
    default void updateJobTrigger(
        com.google.privacy.dlp.v2.UpdateJobTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.JobTrigger> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateJobTriggerMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Inspect hybrid content and store findings to a trigger. The inspection
     * will be processed asynchronously. To review the findings monitor the
     * jobs within the trigger.
     * </pre>
     */
    default void hybridInspectJobTrigger(
        com.google.privacy.dlp.v2.HybridInspectJobTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.HybridInspectResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getHybridInspectJobTriggerMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a job trigger.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers
     * to learn more.
     * </pre>
     */
    default void getJobTrigger(
        com.google.privacy.dlp.v2.GetJobTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.JobTrigger> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetJobTriggerMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists job triggers.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers
     * to learn more.
     * </pre>
     */
    default void listJobTriggers(
        com.google.privacy.dlp.v2.ListJobTriggersRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ListJobTriggersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListJobTriggersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a job trigger.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers
     * to learn more.
     * </pre>
     */
    default void deleteJobTrigger(
        com.google.privacy.dlp.v2.DeleteJobTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteJobTriggerMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Activate a job trigger. Causes the immediate execute of a trigger
     * instead of waiting on the trigger event to occur.
     * </pre>
     */
    default void activateJobTrigger(
        com.google.privacy.dlp.v2.ActivateJobTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.DlpJob> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getActivateJobTriggerMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a config for discovery to scan and profile storage.
     * </pre>
     */
    default void createDiscoveryConfig(
        com.google.privacy.dlp.v2.CreateDiscoveryConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.DiscoveryConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDiscoveryConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a discovery configuration.
     * </pre>
     */
    default void updateDiscoveryConfig(
        com.google.privacy.dlp.v2.UpdateDiscoveryConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.DiscoveryConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDiscoveryConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a discovery configuration.
     * </pre>
     */
    default void getDiscoveryConfig(
        com.google.privacy.dlp.v2.GetDiscoveryConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.DiscoveryConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDiscoveryConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists discovery configurations.
     * </pre>
     */
    default void listDiscoveryConfigs(
        com.google.privacy.dlp.v2.ListDiscoveryConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ListDiscoveryConfigsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDiscoveryConfigsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a discovery configuration.
     * </pre>
     */
    default void deleteDiscoveryConfig(
        com.google.privacy.dlp.v2.DeleteDiscoveryConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDiscoveryConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new job to inspect storage or calculate risk metrics.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage
     * and
     * https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis
     * to learn more.
     * When no InfoTypes or CustomInfoTypes are specified in inspect jobs, the
     * system will automatically choose what detectors to run. By default this may
     * be all types, but may change over time as detectors are updated.
     * </pre>
     */
    default void createDlpJob(
        com.google.privacy.dlp.v2.CreateDlpJobRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.DlpJob> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDlpJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists DlpJobs that match the specified filter in the request.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage
     * and
     * https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis
     * to learn more.
     * </pre>
     */
    default void listDlpJobs(
        com.google.privacy.dlp.v2.ListDlpJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ListDlpJobsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDlpJobsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the latest state of a long-running DlpJob.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage
     * and
     * https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis
     * to learn more.
     * </pre>
     */
    default void getDlpJob(
        com.google.privacy.dlp.v2.GetDlpJobRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.DlpJob> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetDlpJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a long-running DlpJob. This method indicates that the client is
     * no longer interested in the DlpJob result. The job will be canceled if
     * possible.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage
     * and
     * https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis
     * to learn more.
     * </pre>
     */
    default void deleteDlpJob(
        com.google.privacy.dlp.v2.DeleteDlpJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDlpJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts asynchronous cancellation on a long-running DlpJob. The server
     * makes a best effort to cancel the DlpJob, but success is not
     * guaranteed.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage
     * and
     * https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis
     * to learn more.
     * </pre>
     */
    default void cancelDlpJob(
        com.google.privacy.dlp.v2.CancelDlpJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCancelDlpJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a pre-built stored infoType to be used for inspection.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes
     * to learn more.
     * </pre>
     */
    default void createStoredInfoType(
        com.google.privacy.dlp.v2.CreateStoredInfoTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.StoredInfoType> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateStoredInfoTypeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the stored infoType by creating a new version. The existing version
     * will continue to be used until the new version is ready.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes
     * to learn more.
     * </pre>
     */
    default void updateStoredInfoType(
        com.google.privacy.dlp.v2.UpdateStoredInfoTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.StoredInfoType> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateStoredInfoTypeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a stored infoType.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes
     * to learn more.
     * </pre>
     */
    default void getStoredInfoType(
        com.google.privacy.dlp.v2.GetStoredInfoTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.StoredInfoType> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetStoredInfoTypeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists stored infoTypes.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes
     * to learn more.
     * </pre>
     */
    default void listStoredInfoTypes(
        com.google.privacy.dlp.v2.ListStoredInfoTypesRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ListStoredInfoTypesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListStoredInfoTypesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a stored infoType.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes
     * to learn more.
     * </pre>
     */
    default void deleteStoredInfoType(
        com.google.privacy.dlp.v2.DeleteStoredInfoTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteStoredInfoTypeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists project data profiles for an organization.
     * </pre>
     */
    default void listProjectDataProfiles(
        com.google.privacy.dlp.v2.ListProjectDataProfilesRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ListProjectDataProfilesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListProjectDataProfilesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists table data profiles for an organization.
     * </pre>
     */
    default void listTableDataProfiles(
        com.google.privacy.dlp.v2.ListTableDataProfilesRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ListTableDataProfilesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListTableDataProfilesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists column data profiles for an organization.
     * </pre>
     */
    default void listColumnDataProfiles(
        com.google.privacy.dlp.v2.ListColumnDataProfilesRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ListColumnDataProfilesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListColumnDataProfilesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a project data profile.
     * </pre>
     */
    default void getProjectDataProfile(
        com.google.privacy.dlp.v2.GetProjectDataProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ProjectDataProfile>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetProjectDataProfileMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists file store data profiles for an organization.
     * </pre>
     */
    default void listFileStoreDataProfiles(
        com.google.privacy.dlp.v2.ListFileStoreDataProfilesRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ListFileStoreDataProfilesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListFileStoreDataProfilesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a file store data profile.
     * </pre>
     */
    default void getFileStoreDataProfile(
        com.google.privacy.dlp.v2.GetFileStoreDataProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.FileStoreDataProfile>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetFileStoreDataProfileMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a FileStoreDataProfile. Will not prevent the profile from being
     * regenerated if the resource is still included in a discovery configuration.
     * </pre>
     */
    default void deleteFileStoreDataProfile(
        com.google.privacy.dlp.v2.DeleteFileStoreDataProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteFileStoreDataProfileMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a table data profile.
     * </pre>
     */
    default void getTableDataProfile(
        com.google.privacy.dlp.v2.GetTableDataProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.TableDataProfile> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetTableDataProfileMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a column data profile.
     * </pre>
     */
    default void getColumnDataProfile(
        com.google.privacy.dlp.v2.GetColumnDataProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ColumnDataProfile> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetColumnDataProfileMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a TableDataProfile. Will not prevent the profile from being
     * regenerated if the table is still included in a discovery configuration.
     * </pre>
     */
    default void deleteTableDataProfile(
        com.google.privacy.dlp.v2.DeleteTableDataProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteTableDataProfileMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Inspect hybrid content and store findings to a job.
     * To review the findings, inspect the job. Inspection will occur
     * asynchronously.
     * </pre>
     */
    default void hybridInspectDlpJob(
        com.google.privacy.dlp.v2.HybridInspectDlpJobRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.HybridInspectResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getHybridInspectDlpJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Finish a running hybrid DlpJob. Triggers the finalization steps and running
     * of any enabled actions that have not yet run.
     * </pre>
     */
    default void finishDlpJob(
        com.google.privacy.dlp.v2.FinishDlpJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFinishDlpJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a Connection to an external data source.
     * </pre>
     */
    default void createConnection(
        com.google.privacy.dlp.v2.CreateConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.Connection> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateConnectionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a Connection by name.
     * </pre>
     */
    default void getConnection(
        com.google.privacy.dlp.v2.GetConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.Connection> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetConnectionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Connections in a parent. Use SearchConnections to see all connections
     * within an organization.
     * </pre>
     */
    default void listConnections(
        com.google.privacy.dlp.v2.ListConnectionsRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ListConnectionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListConnectionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches for Connections in a parent.
     * </pre>
     */
    default void searchConnections(
        com.google.privacy.dlp.v2.SearchConnectionsRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.SearchConnectionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchConnectionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a Connection.
     * </pre>
     */
    default void deleteConnection(
        com.google.privacy.dlp.v2.DeleteConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteConnectionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a Connection.
     * </pre>
     */
    default void updateConnection(
        com.google.privacy.dlp.v2.UpdateConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.Connection> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateConnectionMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DlpService.
   *
   * <pre>
   * Sensitive Data Protection provides access to a powerful sensitive data
   * inspection, classification, and de-identification platform that works
   * on text, images, and Google Cloud storage repositories.
   * To learn more about concepts and find how-to guides see
   * https://cloud.google.com/sensitive-data-protection/docs/.
   * </pre>
   */
  public abstract static class DlpServiceImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return DlpServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DlpService.
   *
   * <pre>
   * Sensitive Data Protection provides access to a powerful sensitive data
   * inspection, classification, and de-identification platform that works
   * on text, images, and Google Cloud storage repositories.
   * To learn more about concepts and find how-to guides see
   * https://cloud.google.com/sensitive-data-protection/docs/.
   * </pre>
   */
  public static final class DlpServiceStub extends io.grpc.stub.AbstractAsyncStub<DlpServiceStub> {
    private DlpServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DlpServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DlpServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Finds potentially sensitive info in content.
     * This method has limits on input size, processing time, and output size.
     * When no InfoTypes or CustomInfoTypes are specified in this request, the
     * system will automatically choose what detectors to run. By default this may
     * be all types, but may change over time as detectors are updated.
     * For how to guides, see
     * https://cloud.google.com/sensitive-data-protection/docs/inspecting-images
     * and
     * https://cloud.google.com/sensitive-data-protection/docs/inspecting-text,
     * </pre>
     */
    public void inspectContent(
        com.google.privacy.dlp.v2.InspectContentRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.InspectContentResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInspectContentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Redacts potentially sensitive info from an image.
     * This method has limits on input size, processing time, and output size.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/redacting-sensitive-data-images
     * to learn more.
     * When no InfoTypes or CustomInfoTypes are specified in this request, the
     * system will automatically choose what detectors to run. By default this may
     * be all types, but may change over time as detectors are updated.
     * </pre>
     */
    public void redactImage(
        com.google.privacy.dlp.v2.RedactImageRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.RedactImageResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRedactImageMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * De-identifies potentially sensitive info from a ContentItem.
     * This method has limits on input size and output size.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/deidentify-sensitive-data
     * to learn more.
     * When no InfoTypes or CustomInfoTypes are specified in this request, the
     * system will automatically choose what detectors to run. By default this may
     * be all types, but may change over time as detectors are updated.
     * </pre>
     */
    public void deidentifyContent(
        com.google.privacy.dlp.v2.DeidentifyContentRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.DeidentifyContentResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeidentifyContentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Re-identifies content that has been de-identified.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/pseudonymization#re-identification_in_free_text_code_example
     * to learn more.
     * </pre>
     */
    public void reidentifyContent(
        com.google.privacy.dlp.v2.ReidentifyContentRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ReidentifyContentResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReidentifyContentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of the sensitive information types that the DLP API
     * supports. See
     * https://cloud.google.com/sensitive-data-protection/docs/infotypes-reference
     * to learn more.
     * </pre>
     */
    public void listInfoTypes(
        com.google.privacy.dlp.v2.ListInfoTypesRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ListInfoTypesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListInfoTypesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an InspectTemplate for reusing frequently used configuration
     * for inspecting content, images, and storage.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates
     * to learn more.
     * </pre>
     */
    public void createInspectTemplate(
        com.google.privacy.dlp.v2.CreateInspectTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.InspectTemplate> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateInspectTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the InspectTemplate.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates
     * to learn more.
     * </pre>
     */
    public void updateInspectTemplate(
        com.google.privacy.dlp.v2.UpdateInspectTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.InspectTemplate> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateInspectTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an InspectTemplate.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates
     * to learn more.
     * </pre>
     */
    public void getInspectTemplate(
        com.google.privacy.dlp.v2.GetInspectTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.InspectTemplate> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInspectTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists InspectTemplates.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates
     * to learn more.
     * </pre>
     */
    public void listInspectTemplates(
        com.google.privacy.dlp.v2.ListInspectTemplatesRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ListInspectTemplatesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListInspectTemplatesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an InspectTemplate.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates
     * to learn more.
     * </pre>
     */
    public void deleteInspectTemplate(
        com.google.privacy.dlp.v2.DeleteInspectTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteInspectTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a DeidentifyTemplate for reusing frequently used configuration
     * for de-identifying content, images, and storage.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid
     * to learn more.
     * </pre>
     */
    public void createDeidentifyTemplate(
        com.google.privacy.dlp.v2.CreateDeidentifyTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.DeidentifyTemplate>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDeidentifyTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the DeidentifyTemplate.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid
     * to learn more.
     * </pre>
     */
    public void updateDeidentifyTemplate(
        com.google.privacy.dlp.v2.UpdateDeidentifyTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.DeidentifyTemplate>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDeidentifyTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a DeidentifyTemplate.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid
     * to learn more.
     * </pre>
     */
    public void getDeidentifyTemplate(
        com.google.privacy.dlp.v2.GetDeidentifyTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.DeidentifyTemplate>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDeidentifyTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists DeidentifyTemplates.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid
     * to learn more.
     * </pre>
     */
    public void listDeidentifyTemplates(
        com.google.privacy.dlp.v2.ListDeidentifyTemplatesRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ListDeidentifyTemplatesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDeidentifyTemplatesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a DeidentifyTemplate.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid
     * to learn more.
     * </pre>
     */
    public void deleteDeidentifyTemplate(
        com.google.privacy.dlp.v2.DeleteDeidentifyTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDeidentifyTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a job trigger to run DLP actions such as scanning storage for
     * sensitive information on a set schedule.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers
     * to learn more.
     * </pre>
     */
    public void createJobTrigger(
        com.google.privacy.dlp.v2.CreateJobTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.JobTrigger> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateJobTriggerMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a job trigger.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers
     * to learn more.
     * </pre>
     */
    public void updateJobTrigger(
        com.google.privacy.dlp.v2.UpdateJobTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.JobTrigger> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateJobTriggerMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Inspect hybrid content and store findings to a trigger. The inspection
     * will be processed asynchronously. To review the findings monitor the
     * jobs within the trigger.
     * </pre>
     */
    public void hybridInspectJobTrigger(
        com.google.privacy.dlp.v2.HybridInspectJobTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.HybridInspectResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getHybridInspectJobTriggerMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a job trigger.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers
     * to learn more.
     * </pre>
     */
    public void getJobTrigger(
        com.google.privacy.dlp.v2.GetJobTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.JobTrigger> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetJobTriggerMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists job triggers.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers
     * to learn more.
     * </pre>
     */
    public void listJobTriggers(
        com.google.privacy.dlp.v2.ListJobTriggersRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ListJobTriggersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListJobTriggersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a job trigger.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers
     * to learn more.
     * </pre>
     */
    public void deleteJobTrigger(
        com.google.privacy.dlp.v2.DeleteJobTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteJobTriggerMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Activate a job trigger. Causes the immediate execute of a trigger
     * instead of waiting on the trigger event to occur.
     * </pre>
     */
    public void activateJobTrigger(
        com.google.privacy.dlp.v2.ActivateJobTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.DlpJob> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getActivateJobTriggerMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a config for discovery to scan and profile storage.
     * </pre>
     */
    public void createDiscoveryConfig(
        com.google.privacy.dlp.v2.CreateDiscoveryConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.DiscoveryConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDiscoveryConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a discovery configuration.
     * </pre>
     */
    public void updateDiscoveryConfig(
        com.google.privacy.dlp.v2.UpdateDiscoveryConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.DiscoveryConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDiscoveryConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a discovery configuration.
     * </pre>
     */
    public void getDiscoveryConfig(
        com.google.privacy.dlp.v2.GetDiscoveryConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.DiscoveryConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDiscoveryConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists discovery configurations.
     * </pre>
     */
    public void listDiscoveryConfigs(
        com.google.privacy.dlp.v2.ListDiscoveryConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ListDiscoveryConfigsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDiscoveryConfigsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a discovery configuration.
     * </pre>
     */
    public void deleteDiscoveryConfig(
        com.google.privacy.dlp.v2.DeleteDiscoveryConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDiscoveryConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new job to inspect storage or calculate risk metrics.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage
     * and
     * https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis
     * to learn more.
     * When no InfoTypes or CustomInfoTypes are specified in inspect jobs, the
     * system will automatically choose what detectors to run. By default this may
     * be all types, but may change over time as detectors are updated.
     * </pre>
     */
    public void createDlpJob(
        com.google.privacy.dlp.v2.CreateDlpJobRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.DlpJob> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDlpJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists DlpJobs that match the specified filter in the request.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage
     * and
     * https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis
     * to learn more.
     * </pre>
     */
    public void listDlpJobs(
        com.google.privacy.dlp.v2.ListDlpJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ListDlpJobsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDlpJobsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the latest state of a long-running DlpJob.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage
     * and
     * https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis
     * to learn more.
     * </pre>
     */
    public void getDlpJob(
        com.google.privacy.dlp.v2.GetDlpJobRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.DlpJob> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDlpJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a long-running DlpJob. This method indicates that the client is
     * no longer interested in the DlpJob result. The job will be canceled if
     * possible.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage
     * and
     * https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis
     * to learn more.
     * </pre>
     */
    public void deleteDlpJob(
        com.google.privacy.dlp.v2.DeleteDlpJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDlpJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts asynchronous cancellation on a long-running DlpJob. The server
     * makes a best effort to cancel the DlpJob, but success is not
     * guaranteed.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage
     * and
     * https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis
     * to learn more.
     * </pre>
     */
    public void cancelDlpJob(
        com.google.privacy.dlp.v2.CancelDlpJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCancelDlpJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a pre-built stored infoType to be used for inspection.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes
     * to learn more.
     * </pre>
     */
    public void createStoredInfoType(
        com.google.privacy.dlp.v2.CreateStoredInfoTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.StoredInfoType> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateStoredInfoTypeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the stored infoType by creating a new version. The existing version
     * will continue to be used until the new version is ready.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes
     * to learn more.
     * </pre>
     */
    public void updateStoredInfoType(
        com.google.privacy.dlp.v2.UpdateStoredInfoTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.StoredInfoType> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateStoredInfoTypeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a stored infoType.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes
     * to learn more.
     * </pre>
     */
    public void getStoredInfoType(
        com.google.privacy.dlp.v2.GetStoredInfoTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.StoredInfoType> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetStoredInfoTypeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists stored infoTypes.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes
     * to learn more.
     * </pre>
     */
    public void listStoredInfoTypes(
        com.google.privacy.dlp.v2.ListStoredInfoTypesRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ListStoredInfoTypesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListStoredInfoTypesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a stored infoType.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes
     * to learn more.
     * </pre>
     */
    public void deleteStoredInfoType(
        com.google.privacy.dlp.v2.DeleteStoredInfoTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteStoredInfoTypeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists project data profiles for an organization.
     * </pre>
     */
    public void listProjectDataProfiles(
        com.google.privacy.dlp.v2.ListProjectDataProfilesRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ListProjectDataProfilesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListProjectDataProfilesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists table data profiles for an organization.
     * </pre>
     */
    public void listTableDataProfiles(
        com.google.privacy.dlp.v2.ListTableDataProfilesRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ListTableDataProfilesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTableDataProfilesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists column data profiles for an organization.
     * </pre>
     */
    public void listColumnDataProfiles(
        com.google.privacy.dlp.v2.ListColumnDataProfilesRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ListColumnDataProfilesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListColumnDataProfilesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a project data profile.
     * </pre>
     */
    public void getProjectDataProfile(
        com.google.privacy.dlp.v2.GetProjectDataProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ProjectDataProfile>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetProjectDataProfileMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists file store data profiles for an organization.
     * </pre>
     */
    public void listFileStoreDataProfiles(
        com.google.privacy.dlp.v2.ListFileStoreDataProfilesRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ListFileStoreDataProfilesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFileStoreDataProfilesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a file store data profile.
     * </pre>
     */
    public void getFileStoreDataProfile(
        com.google.privacy.dlp.v2.GetFileStoreDataProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.FileStoreDataProfile>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFileStoreDataProfileMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a FileStoreDataProfile. Will not prevent the profile from being
     * regenerated if the resource is still included in a discovery configuration.
     * </pre>
     */
    public void deleteFileStoreDataProfile(
        com.google.privacy.dlp.v2.DeleteFileStoreDataProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteFileStoreDataProfileMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a table data profile.
     * </pre>
     */
    public void getTableDataProfile(
        com.google.privacy.dlp.v2.GetTableDataProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.TableDataProfile> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTableDataProfileMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a column data profile.
     * </pre>
     */
    public void getColumnDataProfile(
        com.google.privacy.dlp.v2.GetColumnDataProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ColumnDataProfile> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetColumnDataProfileMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a TableDataProfile. Will not prevent the profile from being
     * regenerated if the table is still included in a discovery configuration.
     * </pre>
     */
    public void deleteTableDataProfile(
        com.google.privacy.dlp.v2.DeleteTableDataProfileRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTableDataProfileMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Inspect hybrid content and store findings to a job.
     * To review the findings, inspect the job. Inspection will occur
     * asynchronously.
     * </pre>
     */
    public void hybridInspectDlpJob(
        com.google.privacy.dlp.v2.HybridInspectDlpJobRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.HybridInspectResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getHybridInspectDlpJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Finish a running hybrid DlpJob. Triggers the finalization steps and running
     * of any enabled actions that have not yet run.
     * </pre>
     */
    public void finishDlpJob(
        com.google.privacy.dlp.v2.FinishDlpJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFinishDlpJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a Connection to an external data source.
     * </pre>
     */
    public void createConnection(
        com.google.privacy.dlp.v2.CreateConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.Connection> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateConnectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a Connection by name.
     * </pre>
     */
    public void getConnection(
        com.google.privacy.dlp.v2.GetConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.Connection> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetConnectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Connections in a parent. Use SearchConnections to see all connections
     * within an organization.
     * </pre>
     */
    public void listConnections(
        com.google.privacy.dlp.v2.ListConnectionsRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ListConnectionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListConnectionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches for Connections in a parent.
     * </pre>
     */
    public void searchConnections(
        com.google.privacy.dlp.v2.SearchConnectionsRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.SearchConnectionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchConnectionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a Connection.
     * </pre>
     */
    public void deleteConnection(
        com.google.privacy.dlp.v2.DeleteConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteConnectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a Connection.
     * </pre>
     */
    public void updateConnection(
        com.google.privacy.dlp.v2.UpdateConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.Connection> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateConnectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DlpService.
   *
   * <pre>
   * Sensitive Data Protection provides access to a powerful sensitive data
   * inspection, classification, and de-identification platform that works
   * on text, images, and Google Cloud storage repositories.
   * To learn more about concepts and find how-to guides see
   * https://cloud.google.com/sensitive-data-protection/docs/.
   * </pre>
   */
  public static final class DlpServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DlpServiceBlockingStub> {
    private DlpServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DlpServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DlpServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Finds potentially sensitive info in content.
     * This method has limits on input size, processing time, and output size.
     * When no InfoTypes or CustomInfoTypes are specified in this request, the
     * system will automatically choose what detectors to run. By default this may
     * be all types, but may change over time as detectors are updated.
     * For how to guides, see
     * https://cloud.google.com/sensitive-data-protection/docs/inspecting-images
     * and
     * https://cloud.google.com/sensitive-data-protection/docs/inspecting-text,
     * </pre>
     */
    public com.google.privacy.dlp.v2.InspectContentResponse inspectContent(
        com.google.privacy.dlp.v2.InspectContentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInspectContentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Redacts potentially sensitive info from an image.
     * This method has limits on input size, processing time, and output size.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/redacting-sensitive-data-images
     * to learn more.
     * When no InfoTypes or CustomInfoTypes are specified in this request, the
     * system will automatically choose what detectors to run. By default this may
     * be all types, but may change over time as detectors are updated.
     * </pre>
     */
    public com.google.privacy.dlp.v2.RedactImageResponse redactImage(
        com.google.privacy.dlp.v2.RedactImageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRedactImageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * De-identifies potentially sensitive info from a ContentItem.
     * This method has limits on input size and output size.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/deidentify-sensitive-data
     * to learn more.
     * When no InfoTypes or CustomInfoTypes are specified in this request, the
     * system will automatically choose what detectors to run. By default this may
     * be all types, but may change over time as detectors are updated.
     * </pre>
     */
    public com.google.privacy.dlp.v2.DeidentifyContentResponse deidentifyContent(
        com.google.privacy.dlp.v2.DeidentifyContentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeidentifyContentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Re-identifies content that has been de-identified.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/pseudonymization#re-identification_in_free_text_code_example
     * to learn more.
     * </pre>
     */
    public com.google.privacy.dlp.v2.ReidentifyContentResponse reidentifyContent(
        com.google.privacy.dlp.v2.ReidentifyContentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReidentifyContentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of the sensitive information types that the DLP API
     * supports. See
     * https://cloud.google.com/sensitive-data-protection/docs/infotypes-reference
     * to learn more.
     * </pre>
     */
    public com.google.privacy.dlp.v2.ListInfoTypesResponse listInfoTypes(
        com.google.privacy.dlp.v2.ListInfoTypesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListInfoTypesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an InspectTemplate for reusing frequently used configuration
     * for inspecting content, images, and storage.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates
     * to learn more.
     * </pre>
     */
    public com.google.privacy.dlp.v2.InspectTemplate createInspectTemplate(
        com.google.privacy.dlp.v2.CreateInspectTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateInspectTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the InspectTemplate.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates
     * to learn more.
     * </pre>
     */
    public com.google.privacy.dlp.v2.InspectTemplate updateInspectTemplate(
        com.google.privacy.dlp.v2.UpdateInspectTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateInspectTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an InspectTemplate.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates
     * to learn more.
     * </pre>
     */
    public com.google.privacy.dlp.v2.InspectTemplate getInspectTemplate(
        com.google.privacy.dlp.v2.GetInspectTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInspectTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists InspectTemplates.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates
     * to learn more.
     * </pre>
     */
    public com.google.privacy.dlp.v2.ListInspectTemplatesResponse listInspectTemplates(
        com.google.privacy.dlp.v2.ListInspectTemplatesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListInspectTemplatesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an InspectTemplate.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates
     * to learn more.
     * </pre>
     */
    public com.google.protobuf.Empty deleteInspectTemplate(
        com.google.privacy.dlp.v2.DeleteInspectTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteInspectTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a DeidentifyTemplate for reusing frequently used configuration
     * for de-identifying content, images, and storage.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid
     * to learn more.
     * </pre>
     */
    public com.google.privacy.dlp.v2.DeidentifyTemplate createDeidentifyTemplate(
        com.google.privacy.dlp.v2.CreateDeidentifyTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDeidentifyTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the DeidentifyTemplate.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid
     * to learn more.
     * </pre>
     */
    public com.google.privacy.dlp.v2.DeidentifyTemplate updateDeidentifyTemplate(
        com.google.privacy.dlp.v2.UpdateDeidentifyTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDeidentifyTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a DeidentifyTemplate.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid
     * to learn more.
     * </pre>
     */
    public com.google.privacy.dlp.v2.DeidentifyTemplate getDeidentifyTemplate(
        com.google.privacy.dlp.v2.GetDeidentifyTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDeidentifyTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DeidentifyTemplates.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid
     * to learn more.
     * </pre>
     */
    public com.google.privacy.dlp.v2.ListDeidentifyTemplatesResponse listDeidentifyTemplates(
        com.google.privacy.dlp.v2.ListDeidentifyTemplatesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDeidentifyTemplatesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a DeidentifyTemplate.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid
     * to learn more.
     * </pre>
     */
    public com.google.protobuf.Empty deleteDeidentifyTemplate(
        com.google.privacy.dlp.v2.DeleteDeidentifyTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDeidentifyTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a job trigger to run DLP actions such as scanning storage for
     * sensitive information on a set schedule.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers
     * to learn more.
     * </pre>
     */
    public com.google.privacy.dlp.v2.JobTrigger createJobTrigger(
        com.google.privacy.dlp.v2.CreateJobTriggerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateJobTriggerMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a job trigger.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers
     * to learn more.
     * </pre>
     */
    public com.google.privacy.dlp.v2.JobTrigger updateJobTrigger(
        com.google.privacy.dlp.v2.UpdateJobTriggerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateJobTriggerMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Inspect hybrid content and store findings to a trigger. The inspection
     * will be processed asynchronously. To review the findings monitor the
     * jobs within the trigger.
     * </pre>
     */
    public com.google.privacy.dlp.v2.HybridInspectResponse hybridInspectJobTrigger(
        com.google.privacy.dlp.v2.HybridInspectJobTriggerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getHybridInspectJobTriggerMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a job trigger.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers
     * to learn more.
     * </pre>
     */
    public com.google.privacy.dlp.v2.JobTrigger getJobTrigger(
        com.google.privacy.dlp.v2.GetJobTriggerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetJobTriggerMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists job triggers.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers
     * to learn more.
     * </pre>
     */
    public com.google.privacy.dlp.v2.ListJobTriggersResponse listJobTriggers(
        com.google.privacy.dlp.v2.ListJobTriggersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListJobTriggersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a job trigger.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers
     * to learn more.
     * </pre>
     */
    public com.google.protobuf.Empty deleteJobTrigger(
        com.google.privacy.dlp.v2.DeleteJobTriggerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteJobTriggerMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Activate a job trigger. Causes the immediate execute of a trigger
     * instead of waiting on the trigger event to occur.
     * </pre>
     */
    public com.google.privacy.dlp.v2.DlpJob activateJobTrigger(
        com.google.privacy.dlp.v2.ActivateJobTriggerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getActivateJobTriggerMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a config for discovery to scan and profile storage.
     * </pre>
     */
    public com.google.privacy.dlp.v2.DiscoveryConfig createDiscoveryConfig(
        com.google.privacy.dlp.v2.CreateDiscoveryConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDiscoveryConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a discovery configuration.
     * </pre>
     */
    public com.google.privacy.dlp.v2.DiscoveryConfig updateDiscoveryConfig(
        com.google.privacy.dlp.v2.UpdateDiscoveryConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDiscoveryConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a discovery configuration.
     * </pre>
     */
    public com.google.privacy.dlp.v2.DiscoveryConfig getDiscoveryConfig(
        com.google.privacy.dlp.v2.GetDiscoveryConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDiscoveryConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists discovery configurations.
     * </pre>
     */
    public com.google.privacy.dlp.v2.ListDiscoveryConfigsResponse listDiscoveryConfigs(
        com.google.privacy.dlp.v2.ListDiscoveryConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDiscoveryConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a discovery configuration.
     * </pre>
     */
    public com.google.protobuf.Empty deleteDiscoveryConfig(
        com.google.privacy.dlp.v2.DeleteDiscoveryConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDiscoveryConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new job to inspect storage or calculate risk metrics.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage
     * and
     * https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis
     * to learn more.
     * When no InfoTypes or CustomInfoTypes are specified in inspect jobs, the
     * system will automatically choose what detectors to run. By default this may
     * be all types, but may change over time as detectors are updated.
     * </pre>
     */
    public com.google.privacy.dlp.v2.DlpJob createDlpJob(
        com.google.privacy.dlp.v2.CreateDlpJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDlpJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DlpJobs that match the specified filter in the request.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage
     * and
     * https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis
     * to learn more.
     * </pre>
     */
    public com.google.privacy.dlp.v2.ListDlpJobsResponse listDlpJobs(
        com.google.privacy.dlp.v2.ListDlpJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDlpJobsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the latest state of a long-running DlpJob.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage
     * and
     * https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis
     * to learn more.
     * </pre>
     */
    public com.google.privacy.dlp.v2.DlpJob getDlpJob(
        com.google.privacy.dlp.v2.GetDlpJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDlpJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a long-running DlpJob. This method indicates that the client is
     * no longer interested in the DlpJob result. The job will be canceled if
     * possible.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage
     * and
     * https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis
     * to learn more.
     * </pre>
     */
    public com.google.protobuf.Empty deleteDlpJob(
        com.google.privacy.dlp.v2.DeleteDlpJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDlpJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Starts asynchronous cancellation on a long-running DlpJob. The server
     * makes a best effort to cancel the DlpJob, but success is not
     * guaranteed.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage
     * and
     * https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis
     * to learn more.
     * </pre>
     */
    public com.google.protobuf.Empty cancelDlpJob(
        com.google.privacy.dlp.v2.CancelDlpJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelDlpJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a pre-built stored infoType to be used for inspection.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes
     * to learn more.
     * </pre>
     */
    public com.google.privacy.dlp.v2.StoredInfoType createStoredInfoType(
        com.google.privacy.dlp.v2.CreateStoredInfoTypeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateStoredInfoTypeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the stored infoType by creating a new version. The existing version
     * will continue to be used until the new version is ready.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes
     * to learn more.
     * </pre>
     */
    public com.google.privacy.dlp.v2.StoredInfoType updateStoredInfoType(
        com.google.privacy.dlp.v2.UpdateStoredInfoTypeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateStoredInfoTypeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a stored infoType.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes
     * to learn more.
     * </pre>
     */
    public com.google.privacy.dlp.v2.StoredInfoType getStoredInfoType(
        com.google.privacy.dlp.v2.GetStoredInfoTypeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetStoredInfoTypeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists stored infoTypes.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes
     * to learn more.
     * </pre>
     */
    public com.google.privacy.dlp.v2.ListStoredInfoTypesResponse listStoredInfoTypes(
        com.google.privacy.dlp.v2.ListStoredInfoTypesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListStoredInfoTypesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a stored infoType.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes
     * to learn more.
     * </pre>
     */
    public com.google.protobuf.Empty deleteStoredInfoType(
        com.google.privacy.dlp.v2.DeleteStoredInfoTypeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteStoredInfoTypeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists project data profiles for an organization.
     * </pre>
     */
    public com.google.privacy.dlp.v2.ListProjectDataProfilesResponse listProjectDataProfiles(
        com.google.privacy.dlp.v2.ListProjectDataProfilesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListProjectDataProfilesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists table data profiles for an organization.
     * </pre>
     */
    public com.google.privacy.dlp.v2.ListTableDataProfilesResponse listTableDataProfiles(
        com.google.privacy.dlp.v2.ListTableDataProfilesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTableDataProfilesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists column data profiles for an organization.
     * </pre>
     */
    public com.google.privacy.dlp.v2.ListColumnDataProfilesResponse listColumnDataProfiles(
        com.google.privacy.dlp.v2.ListColumnDataProfilesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListColumnDataProfilesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a project data profile.
     * </pre>
     */
    public com.google.privacy.dlp.v2.ProjectDataProfile getProjectDataProfile(
        com.google.privacy.dlp.v2.GetProjectDataProfileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetProjectDataProfileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists file store data profiles for an organization.
     * </pre>
     */
    public com.google.privacy.dlp.v2.ListFileStoreDataProfilesResponse listFileStoreDataProfiles(
        com.google.privacy.dlp.v2.ListFileStoreDataProfilesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFileStoreDataProfilesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a file store data profile.
     * </pre>
     */
    public com.google.privacy.dlp.v2.FileStoreDataProfile getFileStoreDataProfile(
        com.google.privacy.dlp.v2.GetFileStoreDataProfileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFileStoreDataProfileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a FileStoreDataProfile. Will not prevent the profile from being
     * regenerated if the resource is still included in a discovery configuration.
     * </pre>
     */
    public com.google.protobuf.Empty deleteFileStoreDataProfile(
        com.google.privacy.dlp.v2.DeleteFileStoreDataProfileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteFileStoreDataProfileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a table data profile.
     * </pre>
     */
    public com.google.privacy.dlp.v2.TableDataProfile getTableDataProfile(
        com.google.privacy.dlp.v2.GetTableDataProfileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTableDataProfileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a column data profile.
     * </pre>
     */
    public com.google.privacy.dlp.v2.ColumnDataProfile getColumnDataProfile(
        com.google.privacy.dlp.v2.GetColumnDataProfileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetColumnDataProfileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a TableDataProfile. Will not prevent the profile from being
     * regenerated if the table is still included in a discovery configuration.
     * </pre>
     */
    public com.google.protobuf.Empty deleteTableDataProfile(
        com.google.privacy.dlp.v2.DeleteTableDataProfileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTableDataProfileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Inspect hybrid content and store findings to a job.
     * To review the findings, inspect the job. Inspection will occur
     * asynchronously.
     * </pre>
     */
    public com.google.privacy.dlp.v2.HybridInspectResponse hybridInspectDlpJob(
        com.google.privacy.dlp.v2.HybridInspectDlpJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getHybridInspectDlpJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Finish a running hybrid DlpJob. Triggers the finalization steps and running
     * of any enabled actions that have not yet run.
     * </pre>
     */
    public com.google.protobuf.Empty finishDlpJob(
        com.google.privacy.dlp.v2.FinishDlpJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFinishDlpJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a Connection to an external data source.
     * </pre>
     */
    public com.google.privacy.dlp.v2.Connection createConnection(
        com.google.privacy.dlp.v2.CreateConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateConnectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get a Connection by name.
     * </pre>
     */
    public com.google.privacy.dlp.v2.Connection getConnection(
        com.google.privacy.dlp.v2.GetConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetConnectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Connections in a parent. Use SearchConnections to see all connections
     * within an organization.
     * </pre>
     */
    public com.google.privacy.dlp.v2.ListConnectionsResponse listConnections(
        com.google.privacy.dlp.v2.ListConnectionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListConnectionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Searches for Connections in a parent.
     * </pre>
     */
    public com.google.privacy.dlp.v2.SearchConnectionsResponse searchConnections(
        com.google.privacy.dlp.v2.SearchConnectionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchConnectionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a Connection.
     * </pre>
     */
    public com.google.protobuf.Empty deleteConnection(
        com.google.privacy.dlp.v2.DeleteConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteConnectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a Connection.
     * </pre>
     */
    public com.google.privacy.dlp.v2.Connection updateConnection(
        com.google.privacy.dlp.v2.UpdateConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateConnectionMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service DlpService.
   *
   * <pre>
   * Sensitive Data Protection provides access to a powerful sensitive data
   * inspection, classification, and de-identification platform that works
   * on text, images, and Google Cloud storage repositories.
   * To learn more about concepts and find how-to guides see
   * https://cloud.google.com/sensitive-data-protection/docs/.
   * </pre>
   */
  public static final class DlpServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DlpServiceFutureStub> {
    private DlpServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DlpServiceFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DlpServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Finds potentially sensitive info in content.
     * This method has limits on input size, processing time, and output size.
     * When no InfoTypes or CustomInfoTypes are specified in this request, the
     * system will automatically choose what detectors to run. By default this may
     * be all types, but may change over time as detectors are updated.
     * For how to guides, see
     * https://cloud.google.com/sensitive-data-protection/docs/inspecting-images
     * and
     * https://cloud.google.com/sensitive-data-protection/docs/inspecting-text,
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.privacy.dlp.v2.InspectContentResponse>
        inspectContent(com.google.privacy.dlp.v2.InspectContentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInspectContentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Redacts potentially sensitive info from an image.
     * This method has limits on input size, processing time, and output size.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/redacting-sensitive-data-images
     * to learn more.
     * When no InfoTypes or CustomInfoTypes are specified in this request, the
     * system will automatically choose what detectors to run. By default this may
     * be all types, but may change over time as detectors are updated.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.privacy.dlp.v2.RedactImageResponse>
        redactImage(com.google.privacy.dlp.v2.RedactImageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRedactImageMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * De-identifies potentially sensitive info from a ContentItem.
     * This method has limits on input size and output size.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/deidentify-sensitive-data
     * to learn more.
     * When no InfoTypes or CustomInfoTypes are specified in this request, the
     * system will automatically choose what detectors to run. By default this may
     * be all types, but may change over time as detectors are updated.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.privacy.dlp.v2.DeidentifyContentResponse>
        deidentifyContent(com.google.privacy.dlp.v2.DeidentifyContentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeidentifyContentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Re-identifies content that has been de-identified.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/pseudonymization#re-identification_in_free_text_code_example
     * to learn more.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.privacy.dlp.v2.ReidentifyContentResponse>
        reidentifyContent(com.google.privacy.dlp.v2.ReidentifyContentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReidentifyContentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of the sensitive information types that the DLP API
     * supports. See
     * https://cloud.google.com/sensitive-data-protection/docs/infotypes-reference
     * to learn more.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.privacy.dlp.v2.ListInfoTypesResponse>
        listInfoTypes(com.google.privacy.dlp.v2.ListInfoTypesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListInfoTypesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an InspectTemplate for reusing frequently used configuration
     * for inspecting content, images, and storage.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates
     * to learn more.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.privacy.dlp.v2.InspectTemplate>
        createInspectTemplate(com.google.privacy.dlp.v2.CreateInspectTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateInspectTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the InspectTemplate.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates
     * to learn more.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.privacy.dlp.v2.InspectTemplate>
        updateInspectTemplate(com.google.privacy.dlp.v2.UpdateInspectTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateInspectTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an InspectTemplate.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates
     * to learn more.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.privacy.dlp.v2.InspectTemplate>
        getInspectTemplate(com.google.privacy.dlp.v2.GetInspectTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInspectTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists InspectTemplates.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates
     * to learn more.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.privacy.dlp.v2.ListInspectTemplatesResponse>
        listInspectTemplates(com.google.privacy.dlp.v2.ListInspectTemplatesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListInspectTemplatesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an InspectTemplate.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates
     * to learn more.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteInspectTemplate(com.google.privacy.dlp.v2.DeleteInspectTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteInspectTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a DeidentifyTemplate for reusing frequently used configuration
     * for de-identifying content, images, and storage.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid
     * to learn more.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.privacy.dlp.v2.DeidentifyTemplate>
        createDeidentifyTemplate(
            com.google.privacy.dlp.v2.CreateDeidentifyTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDeidentifyTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the DeidentifyTemplate.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid
     * to learn more.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.privacy.dlp.v2.DeidentifyTemplate>
        updateDeidentifyTemplate(
            com.google.privacy.dlp.v2.UpdateDeidentifyTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDeidentifyTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a DeidentifyTemplate.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid
     * to learn more.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.privacy.dlp.v2.DeidentifyTemplate>
        getDeidentifyTemplate(com.google.privacy.dlp.v2.GetDeidentifyTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDeidentifyTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DeidentifyTemplates.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid
     * to learn more.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.privacy.dlp.v2.ListDeidentifyTemplatesResponse>
        listDeidentifyTemplates(com.google.privacy.dlp.v2.ListDeidentifyTemplatesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDeidentifyTemplatesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a DeidentifyTemplate.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-templates-deid
     * to learn more.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteDeidentifyTemplate(
            com.google.privacy.dlp.v2.DeleteDeidentifyTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDeidentifyTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a job trigger to run DLP actions such as scanning storage for
     * sensitive information on a set schedule.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers
     * to learn more.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.privacy.dlp.v2.JobTrigger>
        createJobTrigger(com.google.privacy.dlp.v2.CreateJobTriggerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateJobTriggerMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a job trigger.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers
     * to learn more.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.privacy.dlp.v2.JobTrigger>
        updateJobTrigger(com.google.privacy.dlp.v2.UpdateJobTriggerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateJobTriggerMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Inspect hybrid content and store findings to a trigger. The inspection
     * will be processed asynchronously. To review the findings monitor the
     * jobs within the trigger.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.privacy.dlp.v2.HybridInspectResponse>
        hybridInspectJobTrigger(com.google.privacy.dlp.v2.HybridInspectJobTriggerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getHybridInspectJobTriggerMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a job trigger.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers
     * to learn more.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.privacy.dlp.v2.JobTrigger>
        getJobTrigger(com.google.privacy.dlp.v2.GetJobTriggerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetJobTriggerMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists job triggers.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers
     * to learn more.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.privacy.dlp.v2.ListJobTriggersResponse>
        listJobTriggers(com.google.privacy.dlp.v2.ListJobTriggersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListJobTriggersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a job trigger.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-job-triggers
     * to learn more.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteJobTrigger(com.google.privacy.dlp.v2.DeleteJobTriggerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteJobTriggerMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Activate a job trigger. Causes the immediate execute of a trigger
     * instead of waiting on the trigger event to occur.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.privacy.dlp.v2.DlpJob>
        activateJobTrigger(com.google.privacy.dlp.v2.ActivateJobTriggerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getActivateJobTriggerMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a config for discovery to scan and profile storage.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.privacy.dlp.v2.DiscoveryConfig>
        createDiscoveryConfig(com.google.privacy.dlp.v2.CreateDiscoveryConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDiscoveryConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a discovery configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.privacy.dlp.v2.DiscoveryConfig>
        updateDiscoveryConfig(com.google.privacy.dlp.v2.UpdateDiscoveryConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDiscoveryConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a discovery configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.privacy.dlp.v2.DiscoveryConfig>
        getDiscoveryConfig(com.google.privacy.dlp.v2.GetDiscoveryConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDiscoveryConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists discovery configurations.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.privacy.dlp.v2.ListDiscoveryConfigsResponse>
        listDiscoveryConfigs(com.google.privacy.dlp.v2.ListDiscoveryConfigsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDiscoveryConfigsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a discovery configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteDiscoveryConfig(com.google.privacy.dlp.v2.DeleteDiscoveryConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDiscoveryConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new job to inspect storage or calculate risk metrics.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage
     * and
     * https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis
     * to learn more.
     * When no InfoTypes or CustomInfoTypes are specified in inspect jobs, the
     * system will automatically choose what detectors to run. By default this may
     * be all types, but may change over time as detectors are updated.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.privacy.dlp.v2.DlpJob>
        createDlpJob(com.google.privacy.dlp.v2.CreateDlpJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDlpJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DlpJobs that match the specified filter in the request.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage
     * and
     * https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis
     * to learn more.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.privacy.dlp.v2.ListDlpJobsResponse>
        listDlpJobs(com.google.privacy.dlp.v2.ListDlpJobsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDlpJobsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the latest state of a long-running DlpJob.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage
     * and
     * https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis
     * to learn more.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.privacy.dlp.v2.DlpJob>
        getDlpJob(com.google.privacy.dlp.v2.GetDlpJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDlpJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a long-running DlpJob. This method indicates that the client is
     * no longer interested in the DlpJob result. The job will be canceled if
     * possible.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage
     * and
     * https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis
     * to learn more.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteDlpJob(com.google.privacy.dlp.v2.DeleteDlpJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDlpJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Starts asynchronous cancellation on a long-running DlpJob. The server
     * makes a best effort to cancel the DlpJob, but success is not
     * guaranteed.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/inspecting-storage
     * and
     * https://cloud.google.com/sensitive-data-protection/docs/compute-risk-analysis
     * to learn more.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        cancelDlpJob(com.google.privacy.dlp.v2.CancelDlpJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCancelDlpJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a pre-built stored infoType to be used for inspection.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes
     * to learn more.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.privacy.dlp.v2.StoredInfoType>
        createStoredInfoType(com.google.privacy.dlp.v2.CreateStoredInfoTypeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateStoredInfoTypeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the stored infoType by creating a new version. The existing version
     * will continue to be used until the new version is ready.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes
     * to learn more.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.privacy.dlp.v2.StoredInfoType>
        updateStoredInfoType(com.google.privacy.dlp.v2.UpdateStoredInfoTypeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateStoredInfoTypeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a stored infoType.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes
     * to learn more.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.privacy.dlp.v2.StoredInfoType>
        getStoredInfoType(com.google.privacy.dlp.v2.GetStoredInfoTypeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetStoredInfoTypeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists stored infoTypes.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes
     * to learn more.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.privacy.dlp.v2.ListStoredInfoTypesResponse>
        listStoredInfoTypes(com.google.privacy.dlp.v2.ListStoredInfoTypesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListStoredInfoTypesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a stored infoType.
     * See
     * https://cloud.google.com/sensitive-data-protection/docs/creating-stored-infotypes
     * to learn more.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteStoredInfoType(com.google.privacy.dlp.v2.DeleteStoredInfoTypeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteStoredInfoTypeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists project data profiles for an organization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.privacy.dlp.v2.ListProjectDataProfilesResponse>
        listProjectDataProfiles(com.google.privacy.dlp.v2.ListProjectDataProfilesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListProjectDataProfilesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists table data profiles for an organization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.privacy.dlp.v2.ListTableDataProfilesResponse>
        listTableDataProfiles(com.google.privacy.dlp.v2.ListTableDataProfilesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTableDataProfilesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists column data profiles for an organization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.privacy.dlp.v2.ListColumnDataProfilesResponse>
        listColumnDataProfiles(com.google.privacy.dlp.v2.ListColumnDataProfilesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListColumnDataProfilesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a project data profile.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.privacy.dlp.v2.ProjectDataProfile>
        getProjectDataProfile(com.google.privacy.dlp.v2.GetProjectDataProfileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetProjectDataProfileMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists file store data profiles for an organization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.privacy.dlp.v2.ListFileStoreDataProfilesResponse>
        listFileStoreDataProfiles(
            com.google.privacy.dlp.v2.ListFileStoreDataProfilesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFileStoreDataProfilesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a file store data profile.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.privacy.dlp.v2.FileStoreDataProfile>
        getFileStoreDataProfile(com.google.privacy.dlp.v2.GetFileStoreDataProfileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFileStoreDataProfileMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a FileStoreDataProfile. Will not prevent the profile from being
     * regenerated if the resource is still included in a discovery configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteFileStoreDataProfile(
            com.google.privacy.dlp.v2.DeleteFileStoreDataProfileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteFileStoreDataProfileMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a table data profile.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.privacy.dlp.v2.TableDataProfile>
        getTableDataProfile(com.google.privacy.dlp.v2.GetTableDataProfileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTableDataProfileMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a column data profile.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.privacy.dlp.v2.ColumnDataProfile>
        getColumnDataProfile(com.google.privacy.dlp.v2.GetColumnDataProfileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetColumnDataProfileMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a TableDataProfile. Will not prevent the profile from being
     * regenerated if the table is still included in a discovery configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteTableDataProfile(com.google.privacy.dlp.v2.DeleteTableDataProfileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTableDataProfileMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Inspect hybrid content and store findings to a job.
     * To review the findings, inspect the job. Inspection will occur
     * asynchronously.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.privacy.dlp.v2.HybridInspectResponse>
        hybridInspectDlpJob(com.google.privacy.dlp.v2.HybridInspectDlpJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getHybridInspectDlpJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Finish a running hybrid DlpJob. Triggers the finalization steps and running
     * of any enabled actions that have not yet run.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        finishDlpJob(com.google.privacy.dlp.v2.FinishDlpJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFinishDlpJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a Connection to an external data source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.privacy.dlp.v2.Connection>
        createConnection(com.google.privacy.dlp.v2.CreateConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateConnectionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get a Connection by name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.privacy.dlp.v2.Connection>
        getConnection(com.google.privacy.dlp.v2.GetConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetConnectionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Connections in a parent. Use SearchConnections to see all connections
     * within an organization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.privacy.dlp.v2.ListConnectionsResponse>
        listConnections(com.google.privacy.dlp.v2.ListConnectionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListConnectionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Searches for Connections in a parent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.privacy.dlp.v2.SearchConnectionsResponse>
        searchConnections(com.google.privacy.dlp.v2.SearchConnectionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchConnectionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a Connection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteConnection(com.google.privacy.dlp.v2.DeleteConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteConnectionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a Connection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.privacy.dlp.v2.Connection>
        updateConnection(com.google.privacy.dlp.v2.UpdateConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateConnectionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_INSPECT_CONTENT = 0;
  private static final int METHODID_REDACT_IMAGE = 1;
  private static final int METHODID_DEIDENTIFY_CONTENT = 2;
  private static final int METHODID_REIDENTIFY_CONTENT = 3;
  private static final int METHODID_LIST_INFO_TYPES = 4;
  private static final int METHODID_CREATE_INSPECT_TEMPLATE = 5;
  private static final int METHODID_UPDATE_INSPECT_TEMPLATE = 6;
  private static final int METHODID_GET_INSPECT_TEMPLATE = 7;
  private static final int METHODID_LIST_INSPECT_TEMPLATES = 8;
  private static final int METHODID_DELETE_INSPECT_TEMPLATE = 9;
  private static final int METHODID_CREATE_DEIDENTIFY_TEMPLATE = 10;
  private static final int METHODID_UPDATE_DEIDENTIFY_TEMPLATE = 11;
  private static final int METHODID_GET_DEIDENTIFY_TEMPLATE = 12;
  private static final int METHODID_LIST_DEIDENTIFY_TEMPLATES = 13;
  private static final int METHODID_DELETE_DEIDENTIFY_TEMPLATE = 14;
  private static final int METHODID_CREATE_JOB_TRIGGER = 15;
  private static final int METHODID_UPDATE_JOB_TRIGGER = 16;
  private static final int METHODID_HYBRID_INSPECT_JOB_TRIGGER = 17;
  private static final int METHODID_GET_JOB_TRIGGER = 18;
  private static final int METHODID_LIST_JOB_TRIGGERS = 19;
  private static final int METHODID_DELETE_JOB_TRIGGER = 20;
  private static final int METHODID_ACTIVATE_JOB_TRIGGER = 21;
  private static final int METHODID_CREATE_DISCOVERY_CONFIG = 22;
  private static final int METHODID_UPDATE_DISCOVERY_CONFIG = 23;
  private static final int METHODID_GET_DISCOVERY_CONFIG = 24;
  private static final int METHODID_LIST_DISCOVERY_CONFIGS = 25;
  private static final int METHODID_DELETE_DISCOVERY_CONFIG = 26;
  private static final int METHODID_CREATE_DLP_JOB = 27;
  private static final int METHODID_LIST_DLP_JOBS = 28;
  private static final int METHODID_GET_DLP_JOB = 29;
  private static final int METHODID_DELETE_DLP_JOB = 30;
  private static final int METHODID_CANCEL_DLP_JOB = 31;
  private static final int METHODID_CREATE_STORED_INFO_TYPE = 32;
  private static final int METHODID_UPDATE_STORED_INFO_TYPE = 33;
  private static final int METHODID_GET_STORED_INFO_TYPE = 34;
  private static final int METHODID_LIST_STORED_INFO_TYPES = 35;
  private static final int METHODID_DELETE_STORED_INFO_TYPE = 36;
  private static final int METHODID_LIST_PROJECT_DATA_PROFILES = 37;
  private static final int METHODID_LIST_TABLE_DATA_PROFILES = 38;
  private static final int METHODID_LIST_COLUMN_DATA_PROFILES = 39;
  private static final int METHODID_GET_PROJECT_DATA_PROFILE = 40;
  private static final int METHODID_LIST_FILE_STORE_DATA_PROFILES = 41;
  private static final int METHODID_GET_FILE_STORE_DATA_PROFILE = 42;
  private static final int METHODID_DELETE_FILE_STORE_DATA_PROFILE = 43;
  private static final int METHODID_GET_TABLE_DATA_PROFILE = 44;
  private static final int METHODID_GET_COLUMN_DATA_PROFILE = 45;
  private static final int METHODID_DELETE_TABLE_DATA_PROFILE = 46;
  private static final int METHODID_HYBRID_INSPECT_DLP_JOB = 47;
  private static final int METHODID_FINISH_DLP_JOB = 48;
  private static final int METHODID_CREATE_CONNECTION = 49;
  private static final int METHODID_GET_CONNECTION = 50;
  private static final int METHODID_LIST_CONNECTIONS = 51;
  private static final int METHODID_SEARCH_CONNECTIONS = 52;
  private static final int METHODID_DELETE_CONNECTION = 53;
  private static final int METHODID_UPDATE_CONNECTION = 54;

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
        case METHODID_INSPECT_CONTENT:
          serviceImpl.inspectContent(
              (com.google.privacy.dlp.v2.InspectContentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.InspectContentResponse>)
                  responseObserver);
          break;
        case METHODID_REDACT_IMAGE:
          serviceImpl.redactImage(
              (com.google.privacy.dlp.v2.RedactImageRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.RedactImageResponse>)
                  responseObserver);
          break;
        case METHODID_DEIDENTIFY_CONTENT:
          serviceImpl.deidentifyContent(
              (com.google.privacy.dlp.v2.DeidentifyContentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.DeidentifyContentResponse>)
                  responseObserver);
          break;
        case METHODID_REIDENTIFY_CONTENT:
          serviceImpl.reidentifyContent(
              (com.google.privacy.dlp.v2.ReidentifyContentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ReidentifyContentResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_INFO_TYPES:
          serviceImpl.listInfoTypes(
              (com.google.privacy.dlp.v2.ListInfoTypesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ListInfoTypesResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_INSPECT_TEMPLATE:
          serviceImpl.createInspectTemplate(
              (com.google.privacy.dlp.v2.CreateInspectTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.InspectTemplate>)
                  responseObserver);
          break;
        case METHODID_UPDATE_INSPECT_TEMPLATE:
          serviceImpl.updateInspectTemplate(
              (com.google.privacy.dlp.v2.UpdateInspectTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.InspectTemplate>)
                  responseObserver);
          break;
        case METHODID_GET_INSPECT_TEMPLATE:
          serviceImpl.getInspectTemplate(
              (com.google.privacy.dlp.v2.GetInspectTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.InspectTemplate>)
                  responseObserver);
          break;
        case METHODID_LIST_INSPECT_TEMPLATES:
          serviceImpl.listInspectTemplates(
              (com.google.privacy.dlp.v2.ListInspectTemplatesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ListInspectTemplatesResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_INSPECT_TEMPLATE:
          serviceImpl.deleteInspectTemplate(
              (com.google.privacy.dlp.v2.DeleteInspectTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_DEIDENTIFY_TEMPLATE:
          serviceImpl.createDeidentifyTemplate(
              (com.google.privacy.dlp.v2.CreateDeidentifyTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.DeidentifyTemplate>)
                  responseObserver);
          break;
        case METHODID_UPDATE_DEIDENTIFY_TEMPLATE:
          serviceImpl.updateDeidentifyTemplate(
              (com.google.privacy.dlp.v2.UpdateDeidentifyTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.DeidentifyTemplate>)
                  responseObserver);
          break;
        case METHODID_GET_DEIDENTIFY_TEMPLATE:
          serviceImpl.getDeidentifyTemplate(
              (com.google.privacy.dlp.v2.GetDeidentifyTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.DeidentifyTemplate>)
                  responseObserver);
          break;
        case METHODID_LIST_DEIDENTIFY_TEMPLATES:
          serviceImpl.listDeidentifyTemplates(
              (com.google.privacy.dlp.v2.ListDeidentifyTemplatesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.privacy.dlp.v2.ListDeidentifyTemplatesResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_DEIDENTIFY_TEMPLATE:
          serviceImpl.deleteDeidentifyTemplate(
              (com.google.privacy.dlp.v2.DeleteDeidentifyTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_JOB_TRIGGER:
          serviceImpl.createJobTrigger(
              (com.google.privacy.dlp.v2.CreateJobTriggerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.JobTrigger>) responseObserver);
          break;
        case METHODID_UPDATE_JOB_TRIGGER:
          serviceImpl.updateJobTrigger(
              (com.google.privacy.dlp.v2.UpdateJobTriggerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.JobTrigger>) responseObserver);
          break;
        case METHODID_HYBRID_INSPECT_JOB_TRIGGER:
          serviceImpl.hybridInspectJobTrigger(
              (com.google.privacy.dlp.v2.HybridInspectJobTriggerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.HybridInspectResponse>)
                  responseObserver);
          break;
        case METHODID_GET_JOB_TRIGGER:
          serviceImpl.getJobTrigger(
              (com.google.privacy.dlp.v2.GetJobTriggerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.JobTrigger>) responseObserver);
          break;
        case METHODID_LIST_JOB_TRIGGERS:
          serviceImpl.listJobTriggers(
              (com.google.privacy.dlp.v2.ListJobTriggersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ListJobTriggersResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_JOB_TRIGGER:
          serviceImpl.deleteJobTrigger(
              (com.google.privacy.dlp.v2.DeleteJobTriggerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_ACTIVATE_JOB_TRIGGER:
          serviceImpl.activateJobTrigger(
              (com.google.privacy.dlp.v2.ActivateJobTriggerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.DlpJob>) responseObserver);
          break;
        case METHODID_CREATE_DISCOVERY_CONFIG:
          serviceImpl.createDiscoveryConfig(
              (com.google.privacy.dlp.v2.CreateDiscoveryConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.DiscoveryConfig>)
                  responseObserver);
          break;
        case METHODID_UPDATE_DISCOVERY_CONFIG:
          serviceImpl.updateDiscoveryConfig(
              (com.google.privacy.dlp.v2.UpdateDiscoveryConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.DiscoveryConfig>)
                  responseObserver);
          break;
        case METHODID_GET_DISCOVERY_CONFIG:
          serviceImpl.getDiscoveryConfig(
              (com.google.privacy.dlp.v2.GetDiscoveryConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.DiscoveryConfig>)
                  responseObserver);
          break;
        case METHODID_LIST_DISCOVERY_CONFIGS:
          serviceImpl.listDiscoveryConfigs(
              (com.google.privacy.dlp.v2.ListDiscoveryConfigsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ListDiscoveryConfigsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_DISCOVERY_CONFIG:
          serviceImpl.deleteDiscoveryConfig(
              (com.google.privacy.dlp.v2.DeleteDiscoveryConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_DLP_JOB:
          serviceImpl.createDlpJob(
              (com.google.privacy.dlp.v2.CreateDlpJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.DlpJob>) responseObserver);
          break;
        case METHODID_LIST_DLP_JOBS:
          serviceImpl.listDlpJobs(
              (com.google.privacy.dlp.v2.ListDlpJobsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ListDlpJobsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_DLP_JOB:
          serviceImpl.getDlpJob(
              (com.google.privacy.dlp.v2.GetDlpJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.DlpJob>) responseObserver);
          break;
        case METHODID_DELETE_DLP_JOB:
          serviceImpl.deleteDlpJob(
              (com.google.privacy.dlp.v2.DeleteDlpJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CANCEL_DLP_JOB:
          serviceImpl.cancelDlpJob(
              (com.google.privacy.dlp.v2.CancelDlpJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_STORED_INFO_TYPE:
          serviceImpl.createStoredInfoType(
              (com.google.privacy.dlp.v2.CreateStoredInfoTypeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.StoredInfoType>)
                  responseObserver);
          break;
        case METHODID_UPDATE_STORED_INFO_TYPE:
          serviceImpl.updateStoredInfoType(
              (com.google.privacy.dlp.v2.UpdateStoredInfoTypeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.StoredInfoType>)
                  responseObserver);
          break;
        case METHODID_GET_STORED_INFO_TYPE:
          serviceImpl.getStoredInfoType(
              (com.google.privacy.dlp.v2.GetStoredInfoTypeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.StoredInfoType>)
                  responseObserver);
          break;
        case METHODID_LIST_STORED_INFO_TYPES:
          serviceImpl.listStoredInfoTypes(
              (com.google.privacy.dlp.v2.ListStoredInfoTypesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ListStoredInfoTypesResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_STORED_INFO_TYPE:
          serviceImpl.deleteStoredInfoType(
              (com.google.privacy.dlp.v2.DeleteStoredInfoTypeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_PROJECT_DATA_PROFILES:
          serviceImpl.listProjectDataProfiles(
              (com.google.privacy.dlp.v2.ListProjectDataProfilesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.privacy.dlp.v2.ListProjectDataProfilesResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_TABLE_DATA_PROFILES:
          serviceImpl.listTableDataProfiles(
              (com.google.privacy.dlp.v2.ListTableDataProfilesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ListTableDataProfilesResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_COLUMN_DATA_PROFILES:
          serviceImpl.listColumnDataProfiles(
              (com.google.privacy.dlp.v2.ListColumnDataProfilesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.privacy.dlp.v2.ListColumnDataProfilesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_PROJECT_DATA_PROFILE:
          serviceImpl.getProjectDataProfile(
              (com.google.privacy.dlp.v2.GetProjectDataProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ProjectDataProfile>)
                  responseObserver);
          break;
        case METHODID_LIST_FILE_STORE_DATA_PROFILES:
          serviceImpl.listFileStoreDataProfiles(
              (com.google.privacy.dlp.v2.ListFileStoreDataProfilesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.privacy.dlp.v2.ListFileStoreDataProfilesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_FILE_STORE_DATA_PROFILE:
          serviceImpl.getFileStoreDataProfile(
              (com.google.privacy.dlp.v2.GetFileStoreDataProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.FileStoreDataProfile>)
                  responseObserver);
          break;
        case METHODID_DELETE_FILE_STORE_DATA_PROFILE:
          serviceImpl.deleteFileStoreDataProfile(
              (com.google.privacy.dlp.v2.DeleteFileStoreDataProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_TABLE_DATA_PROFILE:
          serviceImpl.getTableDataProfile(
              (com.google.privacy.dlp.v2.GetTableDataProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.TableDataProfile>)
                  responseObserver);
          break;
        case METHODID_GET_COLUMN_DATA_PROFILE:
          serviceImpl.getColumnDataProfile(
              (com.google.privacy.dlp.v2.GetColumnDataProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ColumnDataProfile>)
                  responseObserver);
          break;
        case METHODID_DELETE_TABLE_DATA_PROFILE:
          serviceImpl.deleteTableDataProfile(
              (com.google.privacy.dlp.v2.DeleteTableDataProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_HYBRID_INSPECT_DLP_JOB:
          serviceImpl.hybridInspectDlpJob(
              (com.google.privacy.dlp.v2.HybridInspectDlpJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.HybridInspectResponse>)
                  responseObserver);
          break;
        case METHODID_FINISH_DLP_JOB:
          serviceImpl.finishDlpJob(
              (com.google.privacy.dlp.v2.FinishDlpJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_CONNECTION:
          serviceImpl.createConnection(
              (com.google.privacy.dlp.v2.CreateConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.Connection>) responseObserver);
          break;
        case METHODID_GET_CONNECTION:
          serviceImpl.getConnection(
              (com.google.privacy.dlp.v2.GetConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.Connection>) responseObserver);
          break;
        case METHODID_LIST_CONNECTIONS:
          serviceImpl.listConnections(
              (com.google.privacy.dlp.v2.ListConnectionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.ListConnectionsResponse>)
                  responseObserver);
          break;
        case METHODID_SEARCH_CONNECTIONS:
          serviceImpl.searchConnections(
              (com.google.privacy.dlp.v2.SearchConnectionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.SearchConnectionsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_CONNECTION:
          serviceImpl.deleteConnection(
              (com.google.privacy.dlp.v2.DeleteConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_CONNECTION:
          serviceImpl.updateConnection(
              (com.google.privacy.dlp.v2.UpdateConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.privacy.dlp.v2.Connection>) responseObserver);
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
            getInspectContentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.InspectContentRequest,
                    com.google.privacy.dlp.v2.InspectContentResponse>(
                    service, METHODID_INSPECT_CONTENT)))
        .addMethod(
            getRedactImageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.RedactImageRequest,
                    com.google.privacy.dlp.v2.RedactImageResponse>(service, METHODID_REDACT_IMAGE)))
        .addMethod(
            getDeidentifyContentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.DeidentifyContentRequest,
                    com.google.privacy.dlp.v2.DeidentifyContentResponse>(
                    service, METHODID_DEIDENTIFY_CONTENT)))
        .addMethod(
            getReidentifyContentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.ReidentifyContentRequest,
                    com.google.privacy.dlp.v2.ReidentifyContentResponse>(
                    service, METHODID_REIDENTIFY_CONTENT)))
        .addMethod(
            getListInfoTypesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.ListInfoTypesRequest,
                    com.google.privacy.dlp.v2.ListInfoTypesResponse>(
                    service, METHODID_LIST_INFO_TYPES)))
        .addMethod(
            getCreateInspectTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.CreateInspectTemplateRequest,
                    com.google.privacy.dlp.v2.InspectTemplate>(
                    service, METHODID_CREATE_INSPECT_TEMPLATE)))
        .addMethod(
            getUpdateInspectTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.UpdateInspectTemplateRequest,
                    com.google.privacy.dlp.v2.InspectTemplate>(
                    service, METHODID_UPDATE_INSPECT_TEMPLATE)))
        .addMethod(
            getGetInspectTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.GetInspectTemplateRequest,
                    com.google.privacy.dlp.v2.InspectTemplate>(
                    service, METHODID_GET_INSPECT_TEMPLATE)))
        .addMethod(
            getListInspectTemplatesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.ListInspectTemplatesRequest,
                    com.google.privacy.dlp.v2.ListInspectTemplatesResponse>(
                    service, METHODID_LIST_INSPECT_TEMPLATES)))
        .addMethod(
            getDeleteInspectTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.DeleteInspectTemplateRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_INSPECT_TEMPLATE)))
        .addMethod(
            getCreateDeidentifyTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.CreateDeidentifyTemplateRequest,
                    com.google.privacy.dlp.v2.DeidentifyTemplate>(
                    service, METHODID_CREATE_DEIDENTIFY_TEMPLATE)))
        .addMethod(
            getUpdateDeidentifyTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.UpdateDeidentifyTemplateRequest,
                    com.google.privacy.dlp.v2.DeidentifyTemplate>(
                    service, METHODID_UPDATE_DEIDENTIFY_TEMPLATE)))
        .addMethod(
            getGetDeidentifyTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.GetDeidentifyTemplateRequest,
                    com.google.privacy.dlp.v2.DeidentifyTemplate>(
                    service, METHODID_GET_DEIDENTIFY_TEMPLATE)))
        .addMethod(
            getListDeidentifyTemplatesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.ListDeidentifyTemplatesRequest,
                    com.google.privacy.dlp.v2.ListDeidentifyTemplatesResponse>(
                    service, METHODID_LIST_DEIDENTIFY_TEMPLATES)))
        .addMethod(
            getDeleteDeidentifyTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.DeleteDeidentifyTemplateRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_DEIDENTIFY_TEMPLATE)))
        .addMethod(
            getCreateJobTriggerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.CreateJobTriggerRequest,
                    com.google.privacy.dlp.v2.JobTrigger>(service, METHODID_CREATE_JOB_TRIGGER)))
        .addMethod(
            getUpdateJobTriggerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.UpdateJobTriggerRequest,
                    com.google.privacy.dlp.v2.JobTrigger>(service, METHODID_UPDATE_JOB_TRIGGER)))
        .addMethod(
            getHybridInspectJobTriggerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.HybridInspectJobTriggerRequest,
                    com.google.privacy.dlp.v2.HybridInspectResponse>(
                    service, METHODID_HYBRID_INSPECT_JOB_TRIGGER)))
        .addMethod(
            getGetJobTriggerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.GetJobTriggerRequest,
                    com.google.privacy.dlp.v2.JobTrigger>(service, METHODID_GET_JOB_TRIGGER)))
        .addMethod(
            getListJobTriggersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.ListJobTriggersRequest,
                    com.google.privacy.dlp.v2.ListJobTriggersResponse>(
                    service, METHODID_LIST_JOB_TRIGGERS)))
        .addMethod(
            getDeleteJobTriggerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.DeleteJobTriggerRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_JOB_TRIGGER)))
        .addMethod(
            getActivateJobTriggerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.ActivateJobTriggerRequest,
                    com.google.privacy.dlp.v2.DlpJob>(service, METHODID_ACTIVATE_JOB_TRIGGER)))
        .addMethod(
            getCreateDiscoveryConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.CreateDiscoveryConfigRequest,
                    com.google.privacy.dlp.v2.DiscoveryConfig>(
                    service, METHODID_CREATE_DISCOVERY_CONFIG)))
        .addMethod(
            getUpdateDiscoveryConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.UpdateDiscoveryConfigRequest,
                    com.google.privacy.dlp.v2.DiscoveryConfig>(
                    service, METHODID_UPDATE_DISCOVERY_CONFIG)))
        .addMethod(
            getGetDiscoveryConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.GetDiscoveryConfigRequest,
                    com.google.privacy.dlp.v2.DiscoveryConfig>(
                    service, METHODID_GET_DISCOVERY_CONFIG)))
        .addMethod(
            getListDiscoveryConfigsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.ListDiscoveryConfigsRequest,
                    com.google.privacy.dlp.v2.ListDiscoveryConfigsResponse>(
                    service, METHODID_LIST_DISCOVERY_CONFIGS)))
        .addMethod(
            getDeleteDiscoveryConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.DeleteDiscoveryConfigRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_DISCOVERY_CONFIG)))
        .addMethod(
            getCreateDlpJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.CreateDlpJobRequest,
                    com.google.privacy.dlp.v2.DlpJob>(service, METHODID_CREATE_DLP_JOB)))
        .addMethod(
            getListDlpJobsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.ListDlpJobsRequest,
                    com.google.privacy.dlp.v2.ListDlpJobsResponse>(
                    service, METHODID_LIST_DLP_JOBS)))
        .addMethod(
            getGetDlpJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.GetDlpJobRequest, com.google.privacy.dlp.v2.DlpJob>(
                    service, METHODID_GET_DLP_JOB)))
        .addMethod(
            getDeleteDlpJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.DeleteDlpJobRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_DLP_JOB)))
        .addMethod(
            getCancelDlpJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.CancelDlpJobRequest, com.google.protobuf.Empty>(
                    service, METHODID_CANCEL_DLP_JOB)))
        .addMethod(
            getCreateStoredInfoTypeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.CreateStoredInfoTypeRequest,
                    com.google.privacy.dlp.v2.StoredInfoType>(
                    service, METHODID_CREATE_STORED_INFO_TYPE)))
        .addMethod(
            getUpdateStoredInfoTypeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.UpdateStoredInfoTypeRequest,
                    com.google.privacy.dlp.v2.StoredInfoType>(
                    service, METHODID_UPDATE_STORED_INFO_TYPE)))
        .addMethod(
            getGetStoredInfoTypeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.GetStoredInfoTypeRequest,
                    com.google.privacy.dlp.v2.StoredInfoType>(
                    service, METHODID_GET_STORED_INFO_TYPE)))
        .addMethod(
            getListStoredInfoTypesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.ListStoredInfoTypesRequest,
                    com.google.privacy.dlp.v2.ListStoredInfoTypesResponse>(
                    service, METHODID_LIST_STORED_INFO_TYPES)))
        .addMethod(
            getDeleteStoredInfoTypeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.DeleteStoredInfoTypeRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_STORED_INFO_TYPE)))
        .addMethod(
            getListProjectDataProfilesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.ListProjectDataProfilesRequest,
                    com.google.privacy.dlp.v2.ListProjectDataProfilesResponse>(
                    service, METHODID_LIST_PROJECT_DATA_PROFILES)))
        .addMethod(
            getListTableDataProfilesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.ListTableDataProfilesRequest,
                    com.google.privacy.dlp.v2.ListTableDataProfilesResponse>(
                    service, METHODID_LIST_TABLE_DATA_PROFILES)))
        .addMethod(
            getListColumnDataProfilesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.ListColumnDataProfilesRequest,
                    com.google.privacy.dlp.v2.ListColumnDataProfilesResponse>(
                    service, METHODID_LIST_COLUMN_DATA_PROFILES)))
        .addMethod(
            getGetProjectDataProfileMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.GetProjectDataProfileRequest,
                    com.google.privacy.dlp.v2.ProjectDataProfile>(
                    service, METHODID_GET_PROJECT_DATA_PROFILE)))
        .addMethod(
            getListFileStoreDataProfilesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.ListFileStoreDataProfilesRequest,
                    com.google.privacy.dlp.v2.ListFileStoreDataProfilesResponse>(
                    service, METHODID_LIST_FILE_STORE_DATA_PROFILES)))
        .addMethod(
            getGetFileStoreDataProfileMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.GetFileStoreDataProfileRequest,
                    com.google.privacy.dlp.v2.FileStoreDataProfile>(
                    service, METHODID_GET_FILE_STORE_DATA_PROFILE)))
        .addMethod(
            getDeleteFileStoreDataProfileMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.DeleteFileStoreDataProfileRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_FILE_STORE_DATA_PROFILE)))
        .addMethod(
            getGetTableDataProfileMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.GetTableDataProfileRequest,
                    com.google.privacy.dlp.v2.TableDataProfile>(
                    service, METHODID_GET_TABLE_DATA_PROFILE)))
        .addMethod(
            getGetColumnDataProfileMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.GetColumnDataProfileRequest,
                    com.google.privacy.dlp.v2.ColumnDataProfile>(
                    service, METHODID_GET_COLUMN_DATA_PROFILE)))
        .addMethod(
            getDeleteTableDataProfileMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.DeleteTableDataProfileRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_TABLE_DATA_PROFILE)))
        .addMethod(
            getHybridInspectDlpJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.HybridInspectDlpJobRequest,
                    com.google.privacy.dlp.v2.HybridInspectResponse>(
                    service, METHODID_HYBRID_INSPECT_DLP_JOB)))
        .addMethod(
            getFinishDlpJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.FinishDlpJobRequest, com.google.protobuf.Empty>(
                    service, METHODID_FINISH_DLP_JOB)))
        .addMethod(
            getCreateConnectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.CreateConnectionRequest,
                    com.google.privacy.dlp.v2.Connection>(service, METHODID_CREATE_CONNECTION)))
        .addMethod(
            getGetConnectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.GetConnectionRequest,
                    com.google.privacy.dlp.v2.Connection>(service, METHODID_GET_CONNECTION)))
        .addMethod(
            getListConnectionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.ListConnectionsRequest,
                    com.google.privacy.dlp.v2.ListConnectionsResponse>(
                    service, METHODID_LIST_CONNECTIONS)))
        .addMethod(
            getSearchConnectionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.SearchConnectionsRequest,
                    com.google.privacy.dlp.v2.SearchConnectionsResponse>(
                    service, METHODID_SEARCH_CONNECTIONS)))
        .addMethod(
            getDeleteConnectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.DeleteConnectionRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_CONNECTION)))
        .addMethod(
            getUpdateConnectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.privacy.dlp.v2.UpdateConnectionRequest,
                    com.google.privacy.dlp.v2.Connection>(service, METHODID_UPDATE_CONNECTION)))
        .build();
  }

  private abstract static class DlpServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DlpServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.privacy.dlp.v2.DlpProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DlpService");
    }
  }

  private static final class DlpServiceFileDescriptorSupplier
      extends DlpServiceBaseDescriptorSupplier {
    DlpServiceFileDescriptorSupplier() {}
  }

  private static final class DlpServiceMethodDescriptorSupplier
      extends DlpServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DlpServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DlpServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DlpServiceFileDescriptorSupplier())
                      .addMethod(getInspectContentMethod())
                      .addMethod(getRedactImageMethod())
                      .addMethod(getDeidentifyContentMethod())
                      .addMethod(getReidentifyContentMethod())
                      .addMethod(getListInfoTypesMethod())
                      .addMethod(getCreateInspectTemplateMethod())
                      .addMethod(getUpdateInspectTemplateMethod())
                      .addMethod(getGetInspectTemplateMethod())
                      .addMethod(getListInspectTemplatesMethod())
                      .addMethod(getDeleteInspectTemplateMethod())
                      .addMethod(getCreateDeidentifyTemplateMethod())
                      .addMethod(getUpdateDeidentifyTemplateMethod())
                      .addMethod(getGetDeidentifyTemplateMethod())
                      .addMethod(getListDeidentifyTemplatesMethod())
                      .addMethod(getDeleteDeidentifyTemplateMethod())
                      .addMethod(getCreateJobTriggerMethod())
                      .addMethod(getUpdateJobTriggerMethod())
                      .addMethod(getHybridInspectJobTriggerMethod())
                      .addMethod(getGetJobTriggerMethod())
                      .addMethod(getListJobTriggersMethod())
                      .addMethod(getDeleteJobTriggerMethod())
                      .addMethod(getActivateJobTriggerMethod())
                      .addMethod(getCreateDiscoveryConfigMethod())
                      .addMethod(getUpdateDiscoveryConfigMethod())
                      .addMethod(getGetDiscoveryConfigMethod())
                      .addMethod(getListDiscoveryConfigsMethod())
                      .addMethod(getDeleteDiscoveryConfigMethod())
                      .addMethod(getCreateDlpJobMethod())
                      .addMethod(getListDlpJobsMethod())
                      .addMethod(getGetDlpJobMethod())
                      .addMethod(getDeleteDlpJobMethod())
                      .addMethod(getCancelDlpJobMethod())
                      .addMethod(getCreateStoredInfoTypeMethod())
                      .addMethod(getUpdateStoredInfoTypeMethod())
                      .addMethod(getGetStoredInfoTypeMethod())
                      .addMethod(getListStoredInfoTypesMethod())
                      .addMethod(getDeleteStoredInfoTypeMethod())
                      .addMethod(getListProjectDataProfilesMethod())
                      .addMethod(getListTableDataProfilesMethod())
                      .addMethod(getListColumnDataProfilesMethod())
                      .addMethod(getGetProjectDataProfileMethod())
                      .addMethod(getListFileStoreDataProfilesMethod())
                      .addMethod(getGetFileStoreDataProfileMethod())
                      .addMethod(getDeleteFileStoreDataProfileMethod())
                      .addMethod(getGetTableDataProfileMethod())
                      .addMethod(getGetColumnDataProfileMethod())
                      .addMethod(getDeleteTableDataProfileMethod())
                      .addMethod(getHybridInspectDlpJobMethod())
                      .addMethod(getFinishDlpJobMethod())
                      .addMethod(getCreateConnectionMethod())
                      .addMethod(getGetConnectionMethod())
                      .addMethod(getListConnectionsMethod())
                      .addMethod(getSearchConnectionsMethod())
                      .addMethod(getDeleteConnectionMethod())
                      .addMethod(getUpdateConnectionMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
