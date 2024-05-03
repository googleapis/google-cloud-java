/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.aiplatform.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The interface for Vertex Notebook service (a.k.a. Colab on Workbench).
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/aiplatform/v1beta1/notebook_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class NotebookServiceGrpc {

  private NotebookServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.aiplatform.v1beta1.NotebookService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateNotebookRuntimeTemplateRequest,
          com.google.longrunning.Operation>
      getCreateNotebookRuntimeTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateNotebookRuntimeTemplate",
      requestType = com.google.cloud.aiplatform.v1beta1.CreateNotebookRuntimeTemplateRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateNotebookRuntimeTemplateRequest,
          com.google.longrunning.Operation>
      getCreateNotebookRuntimeTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.CreateNotebookRuntimeTemplateRequest,
            com.google.longrunning.Operation>
        getCreateNotebookRuntimeTemplateMethod;
    if ((getCreateNotebookRuntimeTemplateMethod =
            NotebookServiceGrpc.getCreateNotebookRuntimeTemplateMethod)
        == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getCreateNotebookRuntimeTemplateMethod =
                NotebookServiceGrpc.getCreateNotebookRuntimeTemplateMethod)
            == null) {
          NotebookServiceGrpc.getCreateNotebookRuntimeTemplateMethod =
              getCreateNotebookRuntimeTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.CreateNotebookRuntimeTemplateRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateNotebookRuntimeTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1
                                  .CreateNotebookRuntimeTemplateRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier(
                              "CreateNotebookRuntimeTemplate"))
                      .build();
        }
      }
    }
    return getCreateNotebookRuntimeTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetNotebookRuntimeTemplateRequest,
          com.google.cloud.aiplatform.v1beta1.NotebookRuntimeTemplate>
      getGetNotebookRuntimeTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNotebookRuntimeTemplate",
      requestType = com.google.cloud.aiplatform.v1beta1.GetNotebookRuntimeTemplateRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.NotebookRuntimeTemplate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetNotebookRuntimeTemplateRequest,
          com.google.cloud.aiplatform.v1beta1.NotebookRuntimeTemplate>
      getGetNotebookRuntimeTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.GetNotebookRuntimeTemplateRequest,
            com.google.cloud.aiplatform.v1beta1.NotebookRuntimeTemplate>
        getGetNotebookRuntimeTemplateMethod;
    if ((getGetNotebookRuntimeTemplateMethod =
            NotebookServiceGrpc.getGetNotebookRuntimeTemplateMethod)
        == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getGetNotebookRuntimeTemplateMethod =
                NotebookServiceGrpc.getGetNotebookRuntimeTemplateMethod)
            == null) {
          NotebookServiceGrpc.getGetNotebookRuntimeTemplateMethod =
              getGetNotebookRuntimeTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.GetNotebookRuntimeTemplateRequest,
                          com.google.cloud.aiplatform.v1beta1.NotebookRuntimeTemplate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetNotebookRuntimeTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.GetNotebookRuntimeTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.NotebookRuntimeTemplate
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("GetNotebookRuntimeTemplate"))
                      .build();
        }
      }
    }
    return getGetNotebookRuntimeTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimeTemplatesRequest,
          com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimeTemplatesResponse>
      getListNotebookRuntimeTemplatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListNotebookRuntimeTemplates",
      requestType = com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimeTemplatesRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimeTemplatesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimeTemplatesRequest,
          com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimeTemplatesResponse>
      getListNotebookRuntimeTemplatesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimeTemplatesRequest,
            com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimeTemplatesResponse>
        getListNotebookRuntimeTemplatesMethod;
    if ((getListNotebookRuntimeTemplatesMethod =
            NotebookServiceGrpc.getListNotebookRuntimeTemplatesMethod)
        == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getListNotebookRuntimeTemplatesMethod =
                NotebookServiceGrpc.getListNotebookRuntimeTemplatesMethod)
            == null) {
          NotebookServiceGrpc.getListNotebookRuntimeTemplatesMethod =
              getListNotebookRuntimeTemplatesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimeTemplatesRequest,
                          com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimeTemplatesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListNotebookRuntimeTemplates"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1
                                  .ListNotebookRuntimeTemplatesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1
                                  .ListNotebookRuntimeTemplatesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier(
                              "ListNotebookRuntimeTemplates"))
                      .build();
        }
      }
    }
    return getListNotebookRuntimeTemplatesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteNotebookRuntimeTemplateRequest,
          com.google.longrunning.Operation>
      getDeleteNotebookRuntimeTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteNotebookRuntimeTemplate",
      requestType = com.google.cloud.aiplatform.v1beta1.DeleteNotebookRuntimeTemplateRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteNotebookRuntimeTemplateRequest,
          com.google.longrunning.Operation>
      getDeleteNotebookRuntimeTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.DeleteNotebookRuntimeTemplateRequest,
            com.google.longrunning.Operation>
        getDeleteNotebookRuntimeTemplateMethod;
    if ((getDeleteNotebookRuntimeTemplateMethod =
            NotebookServiceGrpc.getDeleteNotebookRuntimeTemplateMethod)
        == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getDeleteNotebookRuntimeTemplateMethod =
                NotebookServiceGrpc.getDeleteNotebookRuntimeTemplateMethod)
            == null) {
          NotebookServiceGrpc.getDeleteNotebookRuntimeTemplateMethod =
              getDeleteNotebookRuntimeTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.DeleteNotebookRuntimeTemplateRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteNotebookRuntimeTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1
                                  .DeleteNotebookRuntimeTemplateRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier(
                              "DeleteNotebookRuntimeTemplate"))
                      .build();
        }
      }
    }
    return getDeleteNotebookRuntimeTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.AssignNotebookRuntimeRequest,
          com.google.longrunning.Operation>
      getAssignNotebookRuntimeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AssignNotebookRuntime",
      requestType = com.google.cloud.aiplatform.v1beta1.AssignNotebookRuntimeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.AssignNotebookRuntimeRequest,
          com.google.longrunning.Operation>
      getAssignNotebookRuntimeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.AssignNotebookRuntimeRequest,
            com.google.longrunning.Operation>
        getAssignNotebookRuntimeMethod;
    if ((getAssignNotebookRuntimeMethod = NotebookServiceGrpc.getAssignNotebookRuntimeMethod)
        == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getAssignNotebookRuntimeMethod = NotebookServiceGrpc.getAssignNotebookRuntimeMethod)
            == null) {
          NotebookServiceGrpc.getAssignNotebookRuntimeMethod =
              getAssignNotebookRuntimeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.AssignNotebookRuntimeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "AssignNotebookRuntime"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.AssignNotebookRuntimeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("AssignNotebookRuntime"))
                      .build();
        }
      }
    }
    return getAssignNotebookRuntimeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetNotebookRuntimeRequest,
          com.google.cloud.aiplatform.v1beta1.NotebookRuntime>
      getGetNotebookRuntimeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNotebookRuntime",
      requestType = com.google.cloud.aiplatform.v1beta1.GetNotebookRuntimeRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.NotebookRuntime.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetNotebookRuntimeRequest,
          com.google.cloud.aiplatform.v1beta1.NotebookRuntime>
      getGetNotebookRuntimeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.GetNotebookRuntimeRequest,
            com.google.cloud.aiplatform.v1beta1.NotebookRuntime>
        getGetNotebookRuntimeMethod;
    if ((getGetNotebookRuntimeMethod = NotebookServiceGrpc.getGetNotebookRuntimeMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getGetNotebookRuntimeMethod = NotebookServiceGrpc.getGetNotebookRuntimeMethod)
            == null) {
          NotebookServiceGrpc.getGetNotebookRuntimeMethod =
              getGetNotebookRuntimeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.GetNotebookRuntimeRequest,
                          com.google.cloud.aiplatform.v1beta1.NotebookRuntime>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetNotebookRuntime"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.GetNotebookRuntimeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.NotebookRuntime
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("GetNotebookRuntime"))
                      .build();
        }
      }
    }
    return getGetNotebookRuntimeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimesRequest,
          com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimesResponse>
      getListNotebookRuntimesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListNotebookRuntimes",
      requestType = com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimesRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimesRequest,
          com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimesResponse>
      getListNotebookRuntimesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimesRequest,
            com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimesResponse>
        getListNotebookRuntimesMethod;
    if ((getListNotebookRuntimesMethod = NotebookServiceGrpc.getListNotebookRuntimesMethod)
        == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getListNotebookRuntimesMethod = NotebookServiceGrpc.getListNotebookRuntimesMethod)
            == null) {
          NotebookServiceGrpc.getListNotebookRuntimesMethod =
              getListNotebookRuntimesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimesRequest,
                          com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListNotebookRuntimes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("ListNotebookRuntimes"))
                      .build();
        }
      }
    }
    return getListNotebookRuntimesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteNotebookRuntimeRequest,
          com.google.longrunning.Operation>
      getDeleteNotebookRuntimeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteNotebookRuntime",
      requestType = com.google.cloud.aiplatform.v1beta1.DeleteNotebookRuntimeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteNotebookRuntimeRequest,
          com.google.longrunning.Operation>
      getDeleteNotebookRuntimeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.DeleteNotebookRuntimeRequest,
            com.google.longrunning.Operation>
        getDeleteNotebookRuntimeMethod;
    if ((getDeleteNotebookRuntimeMethod = NotebookServiceGrpc.getDeleteNotebookRuntimeMethod)
        == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getDeleteNotebookRuntimeMethod = NotebookServiceGrpc.getDeleteNotebookRuntimeMethod)
            == null) {
          NotebookServiceGrpc.getDeleteNotebookRuntimeMethod =
              getDeleteNotebookRuntimeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.DeleteNotebookRuntimeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteNotebookRuntime"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.DeleteNotebookRuntimeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("DeleteNotebookRuntime"))
                      .build();
        }
      }
    }
    return getDeleteNotebookRuntimeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpgradeNotebookRuntimeRequest,
          com.google.longrunning.Operation>
      getUpgradeNotebookRuntimeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpgradeNotebookRuntime",
      requestType = com.google.cloud.aiplatform.v1beta1.UpgradeNotebookRuntimeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpgradeNotebookRuntimeRequest,
          com.google.longrunning.Operation>
      getUpgradeNotebookRuntimeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.UpgradeNotebookRuntimeRequest,
            com.google.longrunning.Operation>
        getUpgradeNotebookRuntimeMethod;
    if ((getUpgradeNotebookRuntimeMethod = NotebookServiceGrpc.getUpgradeNotebookRuntimeMethod)
        == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getUpgradeNotebookRuntimeMethod = NotebookServiceGrpc.getUpgradeNotebookRuntimeMethod)
            == null) {
          NotebookServiceGrpc.getUpgradeNotebookRuntimeMethod =
              getUpgradeNotebookRuntimeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.UpgradeNotebookRuntimeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpgradeNotebookRuntime"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.UpgradeNotebookRuntimeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("UpgradeNotebookRuntime"))
                      .build();
        }
      }
    }
    return getUpgradeNotebookRuntimeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.StartNotebookRuntimeRequest,
          com.google.longrunning.Operation>
      getStartNotebookRuntimeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartNotebookRuntime",
      requestType = com.google.cloud.aiplatform.v1beta1.StartNotebookRuntimeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.StartNotebookRuntimeRequest,
          com.google.longrunning.Operation>
      getStartNotebookRuntimeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.StartNotebookRuntimeRequest,
            com.google.longrunning.Operation>
        getStartNotebookRuntimeMethod;
    if ((getStartNotebookRuntimeMethod = NotebookServiceGrpc.getStartNotebookRuntimeMethod)
        == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getStartNotebookRuntimeMethod = NotebookServiceGrpc.getStartNotebookRuntimeMethod)
            == null) {
          NotebookServiceGrpc.getStartNotebookRuntimeMethod =
              getStartNotebookRuntimeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.StartNotebookRuntimeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "StartNotebookRuntime"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.StartNotebookRuntimeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("StartNotebookRuntime"))
                      .build();
        }
      }
    }
    return getStartNotebookRuntimeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetNotebookExecutionJobRequest,
          com.google.cloud.aiplatform.v1beta1.NotebookExecutionJob>
      getGetNotebookExecutionJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNotebookExecutionJob",
      requestType = com.google.cloud.aiplatform.v1beta1.GetNotebookExecutionJobRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.NotebookExecutionJob.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetNotebookExecutionJobRequest,
          com.google.cloud.aiplatform.v1beta1.NotebookExecutionJob>
      getGetNotebookExecutionJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.GetNotebookExecutionJobRequest,
            com.google.cloud.aiplatform.v1beta1.NotebookExecutionJob>
        getGetNotebookExecutionJobMethod;
    if ((getGetNotebookExecutionJobMethod = NotebookServiceGrpc.getGetNotebookExecutionJobMethod)
        == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getGetNotebookExecutionJobMethod =
                NotebookServiceGrpc.getGetNotebookExecutionJobMethod)
            == null) {
          NotebookServiceGrpc.getGetNotebookExecutionJobMethod =
              getGetNotebookExecutionJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.GetNotebookExecutionJobRequest,
                          com.google.cloud.aiplatform.v1beta1.NotebookExecutionJob>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetNotebookExecutionJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.GetNotebookExecutionJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.NotebookExecutionJob
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("GetNotebookExecutionJob"))
                      .build();
        }
      }
    }
    return getGetNotebookExecutionJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListNotebookExecutionJobsRequest,
          com.google.cloud.aiplatform.v1beta1.ListNotebookExecutionJobsResponse>
      getListNotebookExecutionJobsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListNotebookExecutionJobs",
      requestType = com.google.cloud.aiplatform.v1beta1.ListNotebookExecutionJobsRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ListNotebookExecutionJobsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListNotebookExecutionJobsRequest,
          com.google.cloud.aiplatform.v1beta1.ListNotebookExecutionJobsResponse>
      getListNotebookExecutionJobsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ListNotebookExecutionJobsRequest,
            com.google.cloud.aiplatform.v1beta1.ListNotebookExecutionJobsResponse>
        getListNotebookExecutionJobsMethod;
    if ((getListNotebookExecutionJobsMethod =
            NotebookServiceGrpc.getListNotebookExecutionJobsMethod)
        == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getListNotebookExecutionJobsMethod =
                NotebookServiceGrpc.getListNotebookExecutionJobsMethod)
            == null) {
          NotebookServiceGrpc.getListNotebookExecutionJobsMethod =
              getListNotebookExecutionJobsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.ListNotebookExecutionJobsRequest,
                          com.google.cloud.aiplatform.v1beta1.ListNotebookExecutionJobsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListNotebookExecutionJobs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListNotebookExecutionJobsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListNotebookExecutionJobsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("ListNotebookExecutionJobs"))
                      .build();
        }
      }
    }
    return getListNotebookExecutionJobsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteNotebookExecutionJobRequest,
          com.google.longrunning.Operation>
      getDeleteNotebookExecutionJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteNotebookExecutionJob",
      requestType = com.google.cloud.aiplatform.v1beta1.DeleteNotebookExecutionJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteNotebookExecutionJobRequest,
          com.google.longrunning.Operation>
      getDeleteNotebookExecutionJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.DeleteNotebookExecutionJobRequest,
            com.google.longrunning.Operation>
        getDeleteNotebookExecutionJobMethod;
    if ((getDeleteNotebookExecutionJobMethod =
            NotebookServiceGrpc.getDeleteNotebookExecutionJobMethod)
        == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getDeleteNotebookExecutionJobMethod =
                NotebookServiceGrpc.getDeleteNotebookExecutionJobMethod)
            == null) {
          NotebookServiceGrpc.getDeleteNotebookExecutionJobMethod =
              getDeleteNotebookExecutionJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.DeleteNotebookExecutionJobRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteNotebookExecutionJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.DeleteNotebookExecutionJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("DeleteNotebookExecutionJob"))
                      .build();
        }
      }
    }
    return getDeleteNotebookExecutionJobMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static NotebookServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NotebookServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<NotebookServiceStub>() {
          @java.lang.Override
          public NotebookServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new NotebookServiceStub(channel, callOptions);
          }
        };
    return NotebookServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static NotebookServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NotebookServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<NotebookServiceBlockingStub>() {
          @java.lang.Override
          public NotebookServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new NotebookServiceBlockingStub(channel, callOptions);
          }
        };
    return NotebookServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static NotebookServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NotebookServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<NotebookServiceFutureStub>() {
          @java.lang.Override
          public NotebookServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new NotebookServiceFutureStub(channel, callOptions);
          }
        };
    return NotebookServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The interface for Vertex Notebook service (a.k.a. Colab on Workbench).
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a NotebookRuntimeTemplate.
     * </pre>
     */
    default void createNotebookRuntimeTemplate(
        com.google.cloud.aiplatform.v1beta1.CreateNotebookRuntimeTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateNotebookRuntimeTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a NotebookRuntimeTemplate.
     * </pre>
     */
    default void getNotebookRuntimeTemplate(
        com.google.cloud.aiplatform.v1beta1.GetNotebookRuntimeTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.NotebookRuntimeTemplate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetNotebookRuntimeTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists NotebookRuntimeTemplates in a Location.
     * </pre>
     */
    default void listNotebookRuntimeTemplates(
        com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimeTemplatesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimeTemplatesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListNotebookRuntimeTemplatesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a NotebookRuntimeTemplate.
     * </pre>
     */
    default void deleteNotebookRuntimeTemplate(
        com.google.cloud.aiplatform.v1beta1.DeleteNotebookRuntimeTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteNotebookRuntimeTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Assigns a NotebookRuntime to a user for a particular Notebook file. This
     * method will either returns an existing assignment or generates a new one.
     * </pre>
     */
    default void assignNotebookRuntime(
        com.google.cloud.aiplatform.v1beta1.AssignNotebookRuntimeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAssignNotebookRuntimeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a NotebookRuntime.
     * </pre>
     */
    default void getNotebookRuntime(
        com.google.cloud.aiplatform.v1beta1.GetNotebookRuntimeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.NotebookRuntime>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetNotebookRuntimeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists NotebookRuntimes in a Location.
     * </pre>
     */
    default void listNotebookRuntimes(
        com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListNotebookRuntimesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a NotebookRuntime.
     * </pre>
     */
    default void deleteNotebookRuntime(
        com.google.cloud.aiplatform.v1beta1.DeleteNotebookRuntimeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteNotebookRuntimeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Upgrades a NotebookRuntime.
     * </pre>
     */
    default void upgradeNotebookRuntime(
        com.google.cloud.aiplatform.v1beta1.UpgradeNotebookRuntimeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpgradeNotebookRuntimeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts a NotebookRuntime.
     * </pre>
     */
    default void startNotebookRuntime(
        com.google.cloud.aiplatform.v1beta1.StartNotebookRuntimeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getStartNotebookRuntimeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a NotebookExecutionJob.
     * </pre>
     */
    default void getNotebookExecutionJob(
        com.google.cloud.aiplatform.v1beta1.GetNotebookExecutionJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.NotebookExecutionJob>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetNotebookExecutionJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists NotebookExecutionJobs in a Location.
     * </pre>
     */
    default void listNotebookExecutionJobs(
        com.google.cloud.aiplatform.v1beta1.ListNotebookExecutionJobsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.ListNotebookExecutionJobsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListNotebookExecutionJobsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a NotebookExecutionJob.
     * </pre>
     */
    default void deleteNotebookExecutionJob(
        com.google.cloud.aiplatform.v1beta1.DeleteNotebookExecutionJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteNotebookExecutionJobMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service NotebookService.
   *
   * <pre>
   * The interface for Vertex Notebook service (a.k.a. Colab on Workbench).
   * </pre>
   */
  public abstract static class NotebookServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return NotebookServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service NotebookService.
   *
   * <pre>
   * The interface for Vertex Notebook service (a.k.a. Colab on Workbench).
   * </pre>
   */
  public static final class NotebookServiceStub
      extends io.grpc.stub.AbstractAsyncStub<NotebookServiceStub> {
    private NotebookServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NotebookServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NotebookServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a NotebookRuntimeTemplate.
     * </pre>
     */
    public void createNotebookRuntimeTemplate(
        com.google.cloud.aiplatform.v1beta1.CreateNotebookRuntimeTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateNotebookRuntimeTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a NotebookRuntimeTemplate.
     * </pre>
     */
    public void getNotebookRuntimeTemplate(
        com.google.cloud.aiplatform.v1beta1.GetNotebookRuntimeTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.NotebookRuntimeTemplate>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetNotebookRuntimeTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists NotebookRuntimeTemplates in a Location.
     * </pre>
     */
    public void listNotebookRuntimeTemplates(
        com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimeTemplatesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimeTemplatesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListNotebookRuntimeTemplatesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a NotebookRuntimeTemplate.
     * </pre>
     */
    public void deleteNotebookRuntimeTemplate(
        com.google.cloud.aiplatform.v1beta1.DeleteNotebookRuntimeTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteNotebookRuntimeTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Assigns a NotebookRuntime to a user for a particular Notebook file. This
     * method will either returns an existing assignment or generates a new one.
     * </pre>
     */
    public void assignNotebookRuntime(
        com.google.cloud.aiplatform.v1beta1.AssignNotebookRuntimeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAssignNotebookRuntimeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a NotebookRuntime.
     * </pre>
     */
    public void getNotebookRuntime(
        com.google.cloud.aiplatform.v1beta1.GetNotebookRuntimeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.NotebookRuntime>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetNotebookRuntimeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists NotebookRuntimes in a Location.
     * </pre>
     */
    public void listNotebookRuntimes(
        com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListNotebookRuntimesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a NotebookRuntime.
     * </pre>
     */
    public void deleteNotebookRuntime(
        com.google.cloud.aiplatform.v1beta1.DeleteNotebookRuntimeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteNotebookRuntimeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Upgrades a NotebookRuntime.
     * </pre>
     */
    public void upgradeNotebookRuntime(
        com.google.cloud.aiplatform.v1beta1.UpgradeNotebookRuntimeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpgradeNotebookRuntimeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts a NotebookRuntime.
     * </pre>
     */
    public void startNotebookRuntime(
        com.google.cloud.aiplatform.v1beta1.StartNotebookRuntimeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartNotebookRuntimeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a NotebookExecutionJob.
     * </pre>
     */
    public void getNotebookExecutionJob(
        com.google.cloud.aiplatform.v1beta1.GetNotebookExecutionJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.NotebookExecutionJob>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetNotebookExecutionJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists NotebookExecutionJobs in a Location.
     * </pre>
     */
    public void listNotebookExecutionJobs(
        com.google.cloud.aiplatform.v1beta1.ListNotebookExecutionJobsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.ListNotebookExecutionJobsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListNotebookExecutionJobsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a NotebookExecutionJob.
     * </pre>
     */
    public void deleteNotebookExecutionJob(
        com.google.cloud.aiplatform.v1beta1.DeleteNotebookExecutionJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteNotebookExecutionJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service NotebookService.
   *
   * <pre>
   * The interface for Vertex Notebook service (a.k.a. Colab on Workbench).
   * </pre>
   */
  public static final class NotebookServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<NotebookServiceBlockingStub> {
    private NotebookServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NotebookServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NotebookServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a NotebookRuntimeTemplate.
     * </pre>
     */
    public com.google.longrunning.Operation createNotebookRuntimeTemplate(
        com.google.cloud.aiplatform.v1beta1.CreateNotebookRuntimeTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateNotebookRuntimeTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a NotebookRuntimeTemplate.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.NotebookRuntimeTemplate getNotebookRuntimeTemplate(
        com.google.cloud.aiplatform.v1beta1.GetNotebookRuntimeTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetNotebookRuntimeTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists NotebookRuntimeTemplates in a Location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimeTemplatesResponse
        listNotebookRuntimeTemplates(
            com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimeTemplatesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListNotebookRuntimeTemplatesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a NotebookRuntimeTemplate.
     * </pre>
     */
    public com.google.longrunning.Operation deleteNotebookRuntimeTemplate(
        com.google.cloud.aiplatform.v1beta1.DeleteNotebookRuntimeTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteNotebookRuntimeTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Assigns a NotebookRuntime to a user for a particular Notebook file. This
     * method will either returns an existing assignment or generates a new one.
     * </pre>
     */
    public com.google.longrunning.Operation assignNotebookRuntime(
        com.google.cloud.aiplatform.v1beta1.AssignNotebookRuntimeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAssignNotebookRuntimeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a NotebookRuntime.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.NotebookRuntime getNotebookRuntime(
        com.google.cloud.aiplatform.v1beta1.GetNotebookRuntimeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetNotebookRuntimeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists NotebookRuntimes in a Location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimesResponse listNotebookRuntimes(
        com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListNotebookRuntimesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a NotebookRuntime.
     * </pre>
     */
    public com.google.longrunning.Operation deleteNotebookRuntime(
        com.google.cloud.aiplatform.v1beta1.DeleteNotebookRuntimeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteNotebookRuntimeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Upgrades a NotebookRuntime.
     * </pre>
     */
    public com.google.longrunning.Operation upgradeNotebookRuntime(
        com.google.cloud.aiplatform.v1beta1.UpgradeNotebookRuntimeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpgradeNotebookRuntimeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Starts a NotebookRuntime.
     * </pre>
     */
    public com.google.longrunning.Operation startNotebookRuntime(
        com.google.cloud.aiplatform.v1beta1.StartNotebookRuntimeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartNotebookRuntimeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a NotebookExecutionJob.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.NotebookExecutionJob getNotebookExecutionJob(
        com.google.cloud.aiplatform.v1beta1.GetNotebookExecutionJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetNotebookExecutionJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists NotebookExecutionJobs in a Location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListNotebookExecutionJobsResponse
        listNotebookExecutionJobs(
            com.google.cloud.aiplatform.v1beta1.ListNotebookExecutionJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListNotebookExecutionJobsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a NotebookExecutionJob.
     * </pre>
     */
    public com.google.longrunning.Operation deleteNotebookExecutionJob(
        com.google.cloud.aiplatform.v1beta1.DeleteNotebookExecutionJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteNotebookExecutionJobMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service NotebookService.
   *
   * <pre>
   * The interface for Vertex Notebook service (a.k.a. Colab on Workbench).
   * </pre>
   */
  public static final class NotebookServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<NotebookServiceFutureStub> {
    private NotebookServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NotebookServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NotebookServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a NotebookRuntimeTemplate.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createNotebookRuntimeTemplate(
            com.google.cloud.aiplatform.v1beta1.CreateNotebookRuntimeTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateNotebookRuntimeTemplateMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets a NotebookRuntimeTemplate.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.NotebookRuntimeTemplate>
        getNotebookRuntimeTemplate(
            com.google.cloud.aiplatform.v1beta1.GetNotebookRuntimeTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetNotebookRuntimeTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists NotebookRuntimeTemplates in a Location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimeTemplatesResponse>
        listNotebookRuntimeTemplates(
            com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimeTemplatesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListNotebookRuntimeTemplatesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a NotebookRuntimeTemplate.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteNotebookRuntimeTemplate(
            com.google.cloud.aiplatform.v1beta1.DeleteNotebookRuntimeTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteNotebookRuntimeTemplateMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Assigns a NotebookRuntime to a user for a particular Notebook file. This
     * method will either returns an existing assignment or generates a new one.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        assignNotebookRuntime(
            com.google.cloud.aiplatform.v1beta1.AssignNotebookRuntimeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAssignNotebookRuntimeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a NotebookRuntime.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.NotebookRuntime>
        getNotebookRuntime(com.google.cloud.aiplatform.v1beta1.GetNotebookRuntimeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetNotebookRuntimeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists NotebookRuntimes in a Location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimesResponse>
        listNotebookRuntimes(
            com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListNotebookRuntimesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a NotebookRuntime.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteNotebookRuntime(
            com.google.cloud.aiplatform.v1beta1.DeleteNotebookRuntimeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteNotebookRuntimeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Upgrades a NotebookRuntime.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        upgradeNotebookRuntime(
            com.google.cloud.aiplatform.v1beta1.UpgradeNotebookRuntimeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpgradeNotebookRuntimeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Starts a NotebookRuntime.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        startNotebookRuntime(
            com.google.cloud.aiplatform.v1beta1.StartNotebookRuntimeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartNotebookRuntimeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a NotebookExecutionJob.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.NotebookExecutionJob>
        getNotebookExecutionJob(
            com.google.cloud.aiplatform.v1beta1.GetNotebookExecutionJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetNotebookExecutionJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists NotebookExecutionJobs in a Location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ListNotebookExecutionJobsResponse>
        listNotebookExecutionJobs(
            com.google.cloud.aiplatform.v1beta1.ListNotebookExecutionJobsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListNotebookExecutionJobsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a NotebookExecutionJob.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteNotebookExecutionJob(
            com.google.cloud.aiplatform.v1beta1.DeleteNotebookExecutionJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteNotebookExecutionJobMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_NOTEBOOK_RUNTIME_TEMPLATE = 0;
  private static final int METHODID_GET_NOTEBOOK_RUNTIME_TEMPLATE = 1;
  private static final int METHODID_LIST_NOTEBOOK_RUNTIME_TEMPLATES = 2;
  private static final int METHODID_DELETE_NOTEBOOK_RUNTIME_TEMPLATE = 3;
  private static final int METHODID_ASSIGN_NOTEBOOK_RUNTIME = 4;
  private static final int METHODID_GET_NOTEBOOK_RUNTIME = 5;
  private static final int METHODID_LIST_NOTEBOOK_RUNTIMES = 6;
  private static final int METHODID_DELETE_NOTEBOOK_RUNTIME = 7;
  private static final int METHODID_UPGRADE_NOTEBOOK_RUNTIME = 8;
  private static final int METHODID_START_NOTEBOOK_RUNTIME = 9;
  private static final int METHODID_GET_NOTEBOOK_EXECUTION_JOB = 10;
  private static final int METHODID_LIST_NOTEBOOK_EXECUTION_JOBS = 11;
  private static final int METHODID_DELETE_NOTEBOOK_EXECUTION_JOB = 12;

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
        case METHODID_CREATE_NOTEBOOK_RUNTIME_TEMPLATE:
          serviceImpl.createNotebookRuntimeTemplate(
              (com.google.cloud.aiplatform.v1beta1.CreateNotebookRuntimeTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_NOTEBOOK_RUNTIME_TEMPLATE:
          serviceImpl.getNotebookRuntimeTemplate(
              (com.google.cloud.aiplatform.v1beta1.GetNotebookRuntimeTemplateRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.NotebookRuntimeTemplate>)
                  responseObserver);
          break;
        case METHODID_LIST_NOTEBOOK_RUNTIME_TEMPLATES:
          serviceImpl.listNotebookRuntimeTemplates(
              (com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimeTemplatesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimeTemplatesResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_NOTEBOOK_RUNTIME_TEMPLATE:
          serviceImpl.deleteNotebookRuntimeTemplate(
              (com.google.cloud.aiplatform.v1beta1.DeleteNotebookRuntimeTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_ASSIGN_NOTEBOOK_RUNTIME:
          serviceImpl.assignNotebookRuntime(
              (com.google.cloud.aiplatform.v1beta1.AssignNotebookRuntimeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_NOTEBOOK_RUNTIME:
          serviceImpl.getNotebookRuntime(
              (com.google.cloud.aiplatform.v1beta1.GetNotebookRuntimeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.NotebookRuntime>)
                  responseObserver);
          break;
        case METHODID_LIST_NOTEBOOK_RUNTIMES:
          serviceImpl.listNotebookRuntimes(
              (com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimesResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_NOTEBOOK_RUNTIME:
          serviceImpl.deleteNotebookRuntime(
              (com.google.cloud.aiplatform.v1beta1.DeleteNotebookRuntimeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPGRADE_NOTEBOOK_RUNTIME:
          serviceImpl.upgradeNotebookRuntime(
              (com.google.cloud.aiplatform.v1beta1.UpgradeNotebookRuntimeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_START_NOTEBOOK_RUNTIME:
          serviceImpl.startNotebookRuntime(
              (com.google.cloud.aiplatform.v1beta1.StartNotebookRuntimeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_NOTEBOOK_EXECUTION_JOB:
          serviceImpl.getNotebookExecutionJob(
              (com.google.cloud.aiplatform.v1beta1.GetNotebookExecutionJobRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.NotebookExecutionJob>)
                  responseObserver);
          break;
        case METHODID_LIST_NOTEBOOK_EXECUTION_JOBS:
          serviceImpl.listNotebookExecutionJobs(
              (com.google.cloud.aiplatform.v1beta1.ListNotebookExecutionJobsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.ListNotebookExecutionJobsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_NOTEBOOK_EXECUTION_JOB:
          serviceImpl.deleteNotebookExecutionJob(
              (com.google.cloud.aiplatform.v1beta1.DeleteNotebookExecutionJobRequest) request,
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
            getCreateNotebookRuntimeTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.CreateNotebookRuntimeTemplateRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_NOTEBOOK_RUNTIME_TEMPLATE)))
        .addMethod(
            getGetNotebookRuntimeTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.GetNotebookRuntimeTemplateRequest,
                    com.google.cloud.aiplatform.v1beta1.NotebookRuntimeTemplate>(
                    service, METHODID_GET_NOTEBOOK_RUNTIME_TEMPLATE)))
        .addMethod(
            getListNotebookRuntimeTemplatesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimeTemplatesRequest,
                    com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimeTemplatesResponse>(
                    service, METHODID_LIST_NOTEBOOK_RUNTIME_TEMPLATES)))
        .addMethod(
            getDeleteNotebookRuntimeTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.DeleteNotebookRuntimeTemplateRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_NOTEBOOK_RUNTIME_TEMPLATE)))
        .addMethod(
            getAssignNotebookRuntimeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.AssignNotebookRuntimeRequest,
                    com.google.longrunning.Operation>(service, METHODID_ASSIGN_NOTEBOOK_RUNTIME)))
        .addMethod(
            getGetNotebookRuntimeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.GetNotebookRuntimeRequest,
                    com.google.cloud.aiplatform.v1beta1.NotebookRuntime>(
                    service, METHODID_GET_NOTEBOOK_RUNTIME)))
        .addMethod(
            getListNotebookRuntimesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimesRequest,
                    com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimesResponse>(
                    service, METHODID_LIST_NOTEBOOK_RUNTIMES)))
        .addMethod(
            getDeleteNotebookRuntimeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.DeleteNotebookRuntimeRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_NOTEBOOK_RUNTIME)))
        .addMethod(
            getUpgradeNotebookRuntimeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.UpgradeNotebookRuntimeRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPGRADE_NOTEBOOK_RUNTIME)))
        .addMethod(
            getStartNotebookRuntimeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.StartNotebookRuntimeRequest,
                    com.google.longrunning.Operation>(service, METHODID_START_NOTEBOOK_RUNTIME)))
        .addMethod(
            getGetNotebookExecutionJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.GetNotebookExecutionJobRequest,
                    com.google.cloud.aiplatform.v1beta1.NotebookExecutionJob>(
                    service, METHODID_GET_NOTEBOOK_EXECUTION_JOB)))
        .addMethod(
            getListNotebookExecutionJobsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.ListNotebookExecutionJobsRequest,
                    com.google.cloud.aiplatform.v1beta1.ListNotebookExecutionJobsResponse>(
                    service, METHODID_LIST_NOTEBOOK_EXECUTION_JOBS)))
        .addMethod(
            getDeleteNotebookExecutionJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.DeleteNotebookExecutionJobRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_NOTEBOOK_EXECUTION_JOB)))
        .build();
  }

  private abstract static class NotebookServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    NotebookServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1beta1.NotebookServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("NotebookService");
    }
  }

  private static final class NotebookServiceFileDescriptorSupplier
      extends NotebookServiceBaseDescriptorSupplier {
    NotebookServiceFileDescriptorSupplier() {}
  }

  private static final class NotebookServiceMethodDescriptorSupplier
      extends NotebookServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    NotebookServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (NotebookServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new NotebookServiceFileDescriptorSupplier())
                      .addMethod(getCreateNotebookRuntimeTemplateMethod())
                      .addMethod(getGetNotebookRuntimeTemplateMethod())
                      .addMethod(getListNotebookRuntimeTemplatesMethod())
                      .addMethod(getDeleteNotebookRuntimeTemplateMethod())
                      .addMethod(getAssignNotebookRuntimeMethod())
                      .addMethod(getGetNotebookRuntimeMethod())
                      .addMethod(getListNotebookRuntimesMethod())
                      .addMethod(getDeleteNotebookRuntimeMethod())
                      .addMethod(getUpgradeNotebookRuntimeMethod())
                      .addMethod(getStartNotebookRuntimeMethod())
                      .addMethod(getGetNotebookExecutionJobMethod())
                      .addMethod(getListNotebookExecutionJobsMethod())
                      .addMethod(getDeleteNotebookExecutionJobMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
