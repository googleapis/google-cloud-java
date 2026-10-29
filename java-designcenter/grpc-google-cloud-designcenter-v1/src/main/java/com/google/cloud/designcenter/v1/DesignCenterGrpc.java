/*
 * Copyright 2026 Google LLC
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
package com.google.cloud.designcenter.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service describing handlers for resources
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class DesignCenterGrpc {

  private DesignCenterGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.designcenter.v1.DesignCenter";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GetSpaceRequest, com.google.cloud.designcenter.v1.Space>
      getGetSpaceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSpace",
      requestType = com.google.cloud.designcenter.v1.GetSpaceRequest.class,
      responseType = com.google.cloud.designcenter.v1.Space.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GetSpaceRequest, com.google.cloud.designcenter.v1.Space>
      getGetSpaceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.GetSpaceRequest,
            com.google.cloud.designcenter.v1.Space>
        getGetSpaceMethod;
    if ((getGetSpaceMethod = DesignCenterGrpc.getGetSpaceMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getGetSpaceMethod = DesignCenterGrpc.getGetSpaceMethod) == null) {
          DesignCenterGrpc.getGetSpaceMethod =
              getGetSpaceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.GetSpaceRequest,
                          com.google.cloud.designcenter.v1.Space>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSpace"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.GetSpaceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.Space.getDefaultInstance()))
                      .setSchemaDescriptor(new DesignCenterMethodDescriptorSupplier("GetSpace"))
                      .build();
        }
      }
    }
    return getGetSpaceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ListSpacesRequest,
          com.google.cloud.designcenter.v1.ListSpacesResponse>
      getListSpacesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSpaces",
      requestType = com.google.cloud.designcenter.v1.ListSpacesRequest.class,
      responseType = com.google.cloud.designcenter.v1.ListSpacesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ListSpacesRequest,
          com.google.cloud.designcenter.v1.ListSpacesResponse>
      getListSpacesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.ListSpacesRequest,
            com.google.cloud.designcenter.v1.ListSpacesResponse>
        getListSpacesMethod;
    if ((getListSpacesMethod = DesignCenterGrpc.getListSpacesMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getListSpacesMethod = DesignCenterGrpc.getListSpacesMethod) == null) {
          DesignCenterGrpc.getListSpacesMethod =
              getListSpacesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.ListSpacesRequest,
                          com.google.cloud.designcenter.v1.ListSpacesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSpaces"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.ListSpacesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.ListSpacesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new DesignCenterMethodDescriptorSupplier("ListSpaces"))
                      .build();
        }
      }
    }
    return getListSpacesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.CreateSpaceRequest,
          com.google.cloud.designcenter.v1.Space>
      getCreateSpaceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSpace",
      requestType = com.google.cloud.designcenter.v1.CreateSpaceRequest.class,
      responseType = com.google.cloud.designcenter.v1.Space.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.CreateSpaceRequest,
          com.google.cloud.designcenter.v1.Space>
      getCreateSpaceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.CreateSpaceRequest,
            com.google.cloud.designcenter.v1.Space>
        getCreateSpaceMethod;
    if ((getCreateSpaceMethod = DesignCenterGrpc.getCreateSpaceMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getCreateSpaceMethod = DesignCenterGrpc.getCreateSpaceMethod) == null) {
          DesignCenterGrpc.getCreateSpaceMethod =
              getCreateSpaceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.CreateSpaceRequest,
                          com.google.cloud.designcenter.v1.Space>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSpace"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.CreateSpaceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.Space.getDefaultInstance()))
                      .setSchemaDescriptor(new DesignCenterMethodDescriptorSupplier("CreateSpace"))
                      .build();
        }
      }
    }
    return getCreateSpaceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.UpdateSpaceRequest,
          com.google.cloud.designcenter.v1.Space>
      getUpdateSpaceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSpace",
      requestType = com.google.cloud.designcenter.v1.UpdateSpaceRequest.class,
      responseType = com.google.cloud.designcenter.v1.Space.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.UpdateSpaceRequest,
          com.google.cloud.designcenter.v1.Space>
      getUpdateSpaceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.UpdateSpaceRequest,
            com.google.cloud.designcenter.v1.Space>
        getUpdateSpaceMethod;
    if ((getUpdateSpaceMethod = DesignCenterGrpc.getUpdateSpaceMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getUpdateSpaceMethod = DesignCenterGrpc.getUpdateSpaceMethod) == null) {
          DesignCenterGrpc.getUpdateSpaceMethod =
              getUpdateSpaceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.UpdateSpaceRequest,
                          com.google.cloud.designcenter.v1.Space>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSpace"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.UpdateSpaceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.Space.getDefaultInstance()))
                      .setSchemaDescriptor(new DesignCenterMethodDescriptorSupplier("UpdateSpace"))
                      .build();
        }
      }
    }
    return getUpdateSpaceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.DeleteSpaceRequest, com.google.protobuf.Empty>
      getDeleteSpaceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSpace",
      requestType = com.google.cloud.designcenter.v1.DeleteSpaceRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.DeleteSpaceRequest, com.google.protobuf.Empty>
      getDeleteSpaceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.DeleteSpaceRequest, com.google.protobuf.Empty>
        getDeleteSpaceMethod;
    if ((getDeleteSpaceMethod = DesignCenterGrpc.getDeleteSpaceMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getDeleteSpaceMethod = DesignCenterGrpc.getDeleteSpaceMethod) == null) {
          DesignCenterGrpc.getDeleteSpaceMethod =
              getDeleteSpaceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.DeleteSpaceRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSpace"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.DeleteSpaceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new DesignCenterMethodDescriptorSupplier("DeleteSpace"))
                      .build();
        }
      }
    }
    return getDeleteSpaceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GetApplicationTemplateRequest,
          com.google.cloud.designcenter.v1.ApplicationTemplate>
      getGetApplicationTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetApplicationTemplate",
      requestType = com.google.cloud.designcenter.v1.GetApplicationTemplateRequest.class,
      responseType = com.google.cloud.designcenter.v1.ApplicationTemplate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GetApplicationTemplateRequest,
          com.google.cloud.designcenter.v1.ApplicationTemplate>
      getGetApplicationTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.GetApplicationTemplateRequest,
            com.google.cloud.designcenter.v1.ApplicationTemplate>
        getGetApplicationTemplateMethod;
    if ((getGetApplicationTemplateMethod = DesignCenterGrpc.getGetApplicationTemplateMethod)
        == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getGetApplicationTemplateMethod = DesignCenterGrpc.getGetApplicationTemplateMethod)
            == null) {
          DesignCenterGrpc.getGetApplicationTemplateMethod =
              getGetApplicationTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.GetApplicationTemplateRequest,
                          com.google.cloud.designcenter.v1.ApplicationTemplate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetApplicationTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.GetApplicationTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.ApplicationTemplate
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("GetApplicationTemplate"))
                      .build();
        }
      }
    }
    return getGetApplicationTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ListApplicationTemplatesRequest,
          com.google.cloud.designcenter.v1.ListApplicationTemplatesResponse>
      getListApplicationTemplatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListApplicationTemplates",
      requestType = com.google.cloud.designcenter.v1.ListApplicationTemplatesRequest.class,
      responseType = com.google.cloud.designcenter.v1.ListApplicationTemplatesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ListApplicationTemplatesRequest,
          com.google.cloud.designcenter.v1.ListApplicationTemplatesResponse>
      getListApplicationTemplatesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.ListApplicationTemplatesRequest,
            com.google.cloud.designcenter.v1.ListApplicationTemplatesResponse>
        getListApplicationTemplatesMethod;
    if ((getListApplicationTemplatesMethod = DesignCenterGrpc.getListApplicationTemplatesMethod)
        == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getListApplicationTemplatesMethod = DesignCenterGrpc.getListApplicationTemplatesMethod)
            == null) {
          DesignCenterGrpc.getListApplicationTemplatesMethod =
              getListApplicationTemplatesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.ListApplicationTemplatesRequest,
                          com.google.cloud.designcenter.v1.ListApplicationTemplatesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListApplicationTemplates"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.ListApplicationTemplatesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.ListApplicationTemplatesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("ListApplicationTemplates"))
                      .build();
        }
      }
    }
    return getListApplicationTemplatesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.CreateApplicationTemplateRequest,
          com.google.cloud.designcenter.v1.ApplicationTemplate>
      getCreateApplicationTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateApplicationTemplate",
      requestType = com.google.cloud.designcenter.v1.CreateApplicationTemplateRequest.class,
      responseType = com.google.cloud.designcenter.v1.ApplicationTemplate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.CreateApplicationTemplateRequest,
          com.google.cloud.designcenter.v1.ApplicationTemplate>
      getCreateApplicationTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.CreateApplicationTemplateRequest,
            com.google.cloud.designcenter.v1.ApplicationTemplate>
        getCreateApplicationTemplateMethod;
    if ((getCreateApplicationTemplateMethod = DesignCenterGrpc.getCreateApplicationTemplateMethod)
        == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getCreateApplicationTemplateMethod =
                DesignCenterGrpc.getCreateApplicationTemplateMethod)
            == null) {
          DesignCenterGrpc.getCreateApplicationTemplateMethod =
              getCreateApplicationTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.CreateApplicationTemplateRequest,
                          com.google.cloud.designcenter.v1.ApplicationTemplate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateApplicationTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.CreateApplicationTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.ApplicationTemplate
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("CreateApplicationTemplate"))
                      .build();
        }
      }
    }
    return getCreateApplicationTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.UpdateApplicationTemplateRequest,
          com.google.cloud.designcenter.v1.ApplicationTemplate>
      getUpdateApplicationTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateApplicationTemplate",
      requestType = com.google.cloud.designcenter.v1.UpdateApplicationTemplateRequest.class,
      responseType = com.google.cloud.designcenter.v1.ApplicationTemplate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.UpdateApplicationTemplateRequest,
          com.google.cloud.designcenter.v1.ApplicationTemplate>
      getUpdateApplicationTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.UpdateApplicationTemplateRequest,
            com.google.cloud.designcenter.v1.ApplicationTemplate>
        getUpdateApplicationTemplateMethod;
    if ((getUpdateApplicationTemplateMethod = DesignCenterGrpc.getUpdateApplicationTemplateMethod)
        == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getUpdateApplicationTemplateMethod =
                DesignCenterGrpc.getUpdateApplicationTemplateMethod)
            == null) {
          DesignCenterGrpc.getUpdateApplicationTemplateMethod =
              getUpdateApplicationTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.UpdateApplicationTemplateRequest,
                          com.google.cloud.designcenter.v1.ApplicationTemplate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateApplicationTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.UpdateApplicationTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.ApplicationTemplate
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("UpdateApplicationTemplate"))
                      .build();
        }
      }
    }
    return getUpdateApplicationTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ImportApplicationTemplateRequest,
          com.google.cloud.designcenter.v1.ApplicationTemplate>
      getImportApplicationTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportApplicationTemplate",
      requestType = com.google.cloud.designcenter.v1.ImportApplicationTemplateRequest.class,
      responseType = com.google.cloud.designcenter.v1.ApplicationTemplate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ImportApplicationTemplateRequest,
          com.google.cloud.designcenter.v1.ApplicationTemplate>
      getImportApplicationTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.ImportApplicationTemplateRequest,
            com.google.cloud.designcenter.v1.ApplicationTemplate>
        getImportApplicationTemplateMethod;
    if ((getImportApplicationTemplateMethod = DesignCenterGrpc.getImportApplicationTemplateMethod)
        == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getImportApplicationTemplateMethod =
                DesignCenterGrpc.getImportApplicationTemplateMethod)
            == null) {
          DesignCenterGrpc.getImportApplicationTemplateMethod =
              getImportApplicationTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.ImportApplicationTemplateRequest,
                          com.google.cloud.designcenter.v1.ApplicationTemplate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ImportApplicationTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.ImportApplicationTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.ApplicationTemplate
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("ImportApplicationTemplate"))
                      .build();
        }
      }
    }
    return getImportApplicationTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.DeleteApplicationTemplateRequest,
          com.google.protobuf.Empty>
      getDeleteApplicationTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteApplicationTemplate",
      requestType = com.google.cloud.designcenter.v1.DeleteApplicationTemplateRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.DeleteApplicationTemplateRequest,
          com.google.protobuf.Empty>
      getDeleteApplicationTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.DeleteApplicationTemplateRequest,
            com.google.protobuf.Empty>
        getDeleteApplicationTemplateMethod;
    if ((getDeleteApplicationTemplateMethod = DesignCenterGrpc.getDeleteApplicationTemplateMethod)
        == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getDeleteApplicationTemplateMethod =
                DesignCenterGrpc.getDeleteApplicationTemplateMethod)
            == null) {
          DesignCenterGrpc.getDeleteApplicationTemplateMethod =
              getDeleteApplicationTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.DeleteApplicationTemplateRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteApplicationTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.DeleteApplicationTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("DeleteApplicationTemplate"))
                      .build();
        }
      }
    }
    return getDeleteApplicationTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.CommitApplicationTemplateRequest,
          com.google.cloud.designcenter.v1.ApplicationTemplateRevision>
      getCommitApplicationTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CommitApplicationTemplate",
      requestType = com.google.cloud.designcenter.v1.CommitApplicationTemplateRequest.class,
      responseType = com.google.cloud.designcenter.v1.ApplicationTemplateRevision.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.CommitApplicationTemplateRequest,
          com.google.cloud.designcenter.v1.ApplicationTemplateRevision>
      getCommitApplicationTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.CommitApplicationTemplateRequest,
            com.google.cloud.designcenter.v1.ApplicationTemplateRevision>
        getCommitApplicationTemplateMethod;
    if ((getCommitApplicationTemplateMethod = DesignCenterGrpc.getCommitApplicationTemplateMethod)
        == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getCommitApplicationTemplateMethod =
                DesignCenterGrpc.getCommitApplicationTemplateMethod)
            == null) {
          DesignCenterGrpc.getCommitApplicationTemplateMethod =
              getCommitApplicationTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.CommitApplicationTemplateRequest,
                          com.google.cloud.designcenter.v1.ApplicationTemplateRevision>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CommitApplicationTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.CommitApplicationTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.ApplicationTemplateRevision
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("CommitApplicationTemplate"))
                      .build();
        }
      }
    }
    return getCommitApplicationTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.SnapshotApplicationTemplateRequest,
          com.google.longrunning.Operation>
      getSnapshotApplicationTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SnapshotApplicationTemplate",
      requestType = com.google.cloud.designcenter.v1.SnapshotApplicationTemplateRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.SnapshotApplicationTemplateRequest,
          com.google.longrunning.Operation>
      getSnapshotApplicationTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.SnapshotApplicationTemplateRequest,
            com.google.longrunning.Operation>
        getSnapshotApplicationTemplateMethod;
    if ((getSnapshotApplicationTemplateMethod =
            DesignCenterGrpc.getSnapshotApplicationTemplateMethod)
        == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getSnapshotApplicationTemplateMethod =
                DesignCenterGrpc.getSnapshotApplicationTemplateMethod)
            == null) {
          DesignCenterGrpc.getSnapshotApplicationTemplateMethod =
              getSnapshotApplicationTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.SnapshotApplicationTemplateRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SnapshotApplicationTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.SnapshotApplicationTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("SnapshotApplicationTemplate"))
                      .build();
        }
      }
    }
    return getSnapshotApplicationTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GenerateApplicationTemplateIaCRequest,
          com.google.cloud.designcenter.v1.GenerateApplicationTemplateIaCResponse>
      getGenerateApplicationTemplateIaCMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateApplicationTemplateIaC",
      requestType = com.google.cloud.designcenter.v1.GenerateApplicationTemplateIaCRequest.class,
      responseType = com.google.cloud.designcenter.v1.GenerateApplicationTemplateIaCResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GenerateApplicationTemplateIaCRequest,
          com.google.cloud.designcenter.v1.GenerateApplicationTemplateIaCResponse>
      getGenerateApplicationTemplateIaCMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.GenerateApplicationTemplateIaCRequest,
            com.google.cloud.designcenter.v1.GenerateApplicationTemplateIaCResponse>
        getGenerateApplicationTemplateIaCMethod;
    if ((getGenerateApplicationTemplateIaCMethod =
            DesignCenterGrpc.getGenerateApplicationTemplateIaCMethod)
        == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getGenerateApplicationTemplateIaCMethod =
                DesignCenterGrpc.getGenerateApplicationTemplateIaCMethod)
            == null) {
          DesignCenterGrpc.getGenerateApplicationTemplateIaCMethod =
              getGenerateApplicationTemplateIaCMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.GenerateApplicationTemplateIaCRequest,
                          com.google.cloud.designcenter.v1.GenerateApplicationTemplateIaCResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GenerateApplicationTemplateIaC"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.GenerateApplicationTemplateIaCRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1
                                  .GenerateApplicationTemplateIaCResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier(
                              "GenerateApplicationTemplateIaC"))
                      .build();
        }
      }
    }
    return getGenerateApplicationTemplateIaCMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ExportApplicationTemplateIaCRequest,
          com.google.longrunning.Operation>
      getExportApplicationTemplateIaCMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportApplicationTemplateIaC",
      requestType = com.google.cloud.designcenter.v1.ExportApplicationTemplateIaCRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ExportApplicationTemplateIaCRequest,
          com.google.longrunning.Operation>
      getExportApplicationTemplateIaCMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.ExportApplicationTemplateIaCRequest,
            com.google.longrunning.Operation>
        getExportApplicationTemplateIaCMethod;
    if ((getExportApplicationTemplateIaCMethod =
            DesignCenterGrpc.getExportApplicationTemplateIaCMethod)
        == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getExportApplicationTemplateIaCMethod =
                DesignCenterGrpc.getExportApplicationTemplateIaCMethod)
            == null) {
          DesignCenterGrpc.getExportApplicationTemplateIaCMethod =
              getExportApplicationTemplateIaCMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.ExportApplicationTemplateIaCRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ExportApplicationTemplateIaC"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.ExportApplicationTemplateIaCRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("ExportApplicationTemplateIaC"))
                      .build();
        }
      }
    }
    return getExportApplicationTemplateIaCMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GenerateApplicationTemplateRevisionIaCRequest,
          com.google.cloud.designcenter.v1.GenerateApplicationTemplateRevisionIaCResponse>
      getGenerateApplicationTemplateRevisionIaCMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateApplicationTemplateRevisionIaC",
      requestType =
          com.google.cloud.designcenter.v1.GenerateApplicationTemplateRevisionIaCRequest.class,
      responseType =
          com.google.cloud.designcenter.v1.GenerateApplicationTemplateRevisionIaCResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GenerateApplicationTemplateRevisionIaCRequest,
          com.google.cloud.designcenter.v1.GenerateApplicationTemplateRevisionIaCResponse>
      getGenerateApplicationTemplateRevisionIaCMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.GenerateApplicationTemplateRevisionIaCRequest,
            com.google.cloud.designcenter.v1.GenerateApplicationTemplateRevisionIaCResponse>
        getGenerateApplicationTemplateRevisionIaCMethod;
    if ((getGenerateApplicationTemplateRevisionIaCMethod =
            DesignCenterGrpc.getGenerateApplicationTemplateRevisionIaCMethod)
        == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getGenerateApplicationTemplateRevisionIaCMethod =
                DesignCenterGrpc.getGenerateApplicationTemplateRevisionIaCMethod)
            == null) {
          DesignCenterGrpc.getGenerateApplicationTemplateRevisionIaCMethod =
              getGenerateApplicationTemplateRevisionIaCMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1
                              .GenerateApplicationTemplateRevisionIaCRequest,
                          com.google.cloud.designcenter.v1
                              .GenerateApplicationTemplateRevisionIaCResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "GenerateApplicationTemplateRevisionIaC"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1
                                  .GenerateApplicationTemplateRevisionIaCRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1
                                  .GenerateApplicationTemplateRevisionIaCResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier(
                              "GenerateApplicationTemplateRevisionIaC"))
                      .build();
        }
      }
    }
    return getGenerateApplicationTemplateRevisionIaCMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ExportApplicationTemplateRevisionIaCRequest,
          com.google.longrunning.Operation>
      getExportApplicationTemplateRevisionIaCMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportApplicationTemplateRevisionIaC",
      requestType =
          com.google.cloud.designcenter.v1.ExportApplicationTemplateRevisionIaCRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ExportApplicationTemplateRevisionIaCRequest,
          com.google.longrunning.Operation>
      getExportApplicationTemplateRevisionIaCMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.ExportApplicationTemplateRevisionIaCRequest,
            com.google.longrunning.Operation>
        getExportApplicationTemplateRevisionIaCMethod;
    if ((getExportApplicationTemplateRevisionIaCMethod =
            DesignCenterGrpc.getExportApplicationTemplateRevisionIaCMethod)
        == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getExportApplicationTemplateRevisionIaCMethod =
                DesignCenterGrpc.getExportApplicationTemplateRevisionIaCMethod)
            == null) {
          DesignCenterGrpc.getExportApplicationTemplateRevisionIaCMethod =
              getExportApplicationTemplateRevisionIaCMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1
                              .ExportApplicationTemplateRevisionIaCRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "ExportApplicationTemplateRevisionIaC"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1
                                  .ExportApplicationTemplateRevisionIaCRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier(
                              "ExportApplicationTemplateRevisionIaC"))
                      .build();
        }
      }
    }
    return getExportApplicationTemplateRevisionIaCMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GetComponentRequest,
          com.google.cloud.designcenter.v1.Component>
      getGetComponentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetComponent",
      requestType = com.google.cloud.designcenter.v1.GetComponentRequest.class,
      responseType = com.google.cloud.designcenter.v1.Component.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GetComponentRequest,
          com.google.cloud.designcenter.v1.Component>
      getGetComponentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.GetComponentRequest,
            com.google.cloud.designcenter.v1.Component>
        getGetComponentMethod;
    if ((getGetComponentMethod = DesignCenterGrpc.getGetComponentMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getGetComponentMethod = DesignCenterGrpc.getGetComponentMethod) == null) {
          DesignCenterGrpc.getGetComponentMethod =
              getGetComponentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.GetComponentRequest,
                          com.google.cloud.designcenter.v1.Component>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetComponent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.GetComponentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.Component.getDefaultInstance()))
                      .setSchemaDescriptor(new DesignCenterMethodDescriptorSupplier("GetComponent"))
                      .build();
        }
      }
    }
    return getGetComponentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ListComponentsRequest,
          com.google.cloud.designcenter.v1.ListComponentsResponse>
      getListComponentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListComponents",
      requestType = com.google.cloud.designcenter.v1.ListComponentsRequest.class,
      responseType = com.google.cloud.designcenter.v1.ListComponentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ListComponentsRequest,
          com.google.cloud.designcenter.v1.ListComponentsResponse>
      getListComponentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.ListComponentsRequest,
            com.google.cloud.designcenter.v1.ListComponentsResponse>
        getListComponentsMethod;
    if ((getListComponentsMethod = DesignCenterGrpc.getListComponentsMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getListComponentsMethod = DesignCenterGrpc.getListComponentsMethod) == null) {
          DesignCenterGrpc.getListComponentsMethod =
              getListComponentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.ListComponentsRequest,
                          com.google.cloud.designcenter.v1.ListComponentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListComponents"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.ListComponentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.ListComponentsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("ListComponents"))
                      .build();
        }
      }
    }
    return getListComponentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.CreateComponentRequest,
          com.google.cloud.designcenter.v1.Component>
      getCreateComponentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateComponent",
      requestType = com.google.cloud.designcenter.v1.CreateComponentRequest.class,
      responseType = com.google.cloud.designcenter.v1.Component.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.CreateComponentRequest,
          com.google.cloud.designcenter.v1.Component>
      getCreateComponentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.CreateComponentRequest,
            com.google.cloud.designcenter.v1.Component>
        getCreateComponentMethod;
    if ((getCreateComponentMethod = DesignCenterGrpc.getCreateComponentMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getCreateComponentMethod = DesignCenterGrpc.getCreateComponentMethod) == null) {
          DesignCenterGrpc.getCreateComponentMethod =
              getCreateComponentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.CreateComponentRequest,
                          com.google.cloud.designcenter.v1.Component>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateComponent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.CreateComponentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.Component.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("CreateComponent"))
                      .build();
        }
      }
    }
    return getCreateComponentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.UpdateComponentRequest,
          com.google.cloud.designcenter.v1.Component>
      getUpdateComponentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateComponent",
      requestType = com.google.cloud.designcenter.v1.UpdateComponentRequest.class,
      responseType = com.google.cloud.designcenter.v1.Component.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.UpdateComponentRequest,
          com.google.cloud.designcenter.v1.Component>
      getUpdateComponentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.UpdateComponentRequest,
            com.google.cloud.designcenter.v1.Component>
        getUpdateComponentMethod;
    if ((getUpdateComponentMethod = DesignCenterGrpc.getUpdateComponentMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getUpdateComponentMethod = DesignCenterGrpc.getUpdateComponentMethod) == null) {
          DesignCenterGrpc.getUpdateComponentMethod =
              getUpdateComponentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.UpdateComponentRequest,
                          com.google.cloud.designcenter.v1.Component>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateComponent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.UpdateComponentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.Component.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("UpdateComponent"))
                      .build();
        }
      }
    }
    return getUpdateComponentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.DeleteComponentRequest, com.google.protobuf.Empty>
      getDeleteComponentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteComponent",
      requestType = com.google.cloud.designcenter.v1.DeleteComponentRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.DeleteComponentRequest, com.google.protobuf.Empty>
      getDeleteComponentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.DeleteComponentRequest, com.google.protobuf.Empty>
        getDeleteComponentMethod;
    if ((getDeleteComponentMethod = DesignCenterGrpc.getDeleteComponentMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getDeleteComponentMethod = DesignCenterGrpc.getDeleteComponentMethod) == null) {
          DesignCenterGrpc.getDeleteComponentMethod =
              getDeleteComponentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.DeleteComponentRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteComponent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.DeleteComponentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("DeleteComponent"))
                      .build();
        }
      }
    }
    return getDeleteComponentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GetConnectionRequest,
          com.google.cloud.designcenter.v1.Connection>
      getGetConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetConnection",
      requestType = com.google.cloud.designcenter.v1.GetConnectionRequest.class,
      responseType = com.google.cloud.designcenter.v1.Connection.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GetConnectionRequest,
          com.google.cloud.designcenter.v1.Connection>
      getGetConnectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.GetConnectionRequest,
            com.google.cloud.designcenter.v1.Connection>
        getGetConnectionMethod;
    if ((getGetConnectionMethod = DesignCenterGrpc.getGetConnectionMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getGetConnectionMethod = DesignCenterGrpc.getGetConnectionMethod) == null) {
          DesignCenterGrpc.getGetConnectionMethod =
              getGetConnectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.GetConnectionRequest,
                          com.google.cloud.designcenter.v1.Connection>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetConnection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.GetConnectionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.Connection.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("GetConnection"))
                      .build();
        }
      }
    }
    return getGetConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ListConnectionsRequest,
          com.google.cloud.designcenter.v1.ListConnectionsResponse>
      getListConnectionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListConnections",
      requestType = com.google.cloud.designcenter.v1.ListConnectionsRequest.class,
      responseType = com.google.cloud.designcenter.v1.ListConnectionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ListConnectionsRequest,
          com.google.cloud.designcenter.v1.ListConnectionsResponse>
      getListConnectionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.ListConnectionsRequest,
            com.google.cloud.designcenter.v1.ListConnectionsResponse>
        getListConnectionsMethod;
    if ((getListConnectionsMethod = DesignCenterGrpc.getListConnectionsMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getListConnectionsMethod = DesignCenterGrpc.getListConnectionsMethod) == null) {
          DesignCenterGrpc.getListConnectionsMethod =
              getListConnectionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.ListConnectionsRequest,
                          com.google.cloud.designcenter.v1.ListConnectionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListConnections"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.ListConnectionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.ListConnectionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("ListConnections"))
                      .build();
        }
      }
    }
    return getListConnectionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.CreateConnectionRequest,
          com.google.cloud.designcenter.v1.Connection>
      getCreateConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateConnection",
      requestType = com.google.cloud.designcenter.v1.CreateConnectionRequest.class,
      responseType = com.google.cloud.designcenter.v1.Connection.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.CreateConnectionRequest,
          com.google.cloud.designcenter.v1.Connection>
      getCreateConnectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.CreateConnectionRequest,
            com.google.cloud.designcenter.v1.Connection>
        getCreateConnectionMethod;
    if ((getCreateConnectionMethod = DesignCenterGrpc.getCreateConnectionMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getCreateConnectionMethod = DesignCenterGrpc.getCreateConnectionMethod) == null) {
          DesignCenterGrpc.getCreateConnectionMethod =
              getCreateConnectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.CreateConnectionRequest,
                          com.google.cloud.designcenter.v1.Connection>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateConnection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.CreateConnectionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.Connection.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("CreateConnection"))
                      .build();
        }
      }
    }
    return getCreateConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.UpdateConnectionRequest,
          com.google.cloud.designcenter.v1.Connection>
      getUpdateConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateConnection",
      requestType = com.google.cloud.designcenter.v1.UpdateConnectionRequest.class,
      responseType = com.google.cloud.designcenter.v1.Connection.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.UpdateConnectionRequest,
          com.google.cloud.designcenter.v1.Connection>
      getUpdateConnectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.UpdateConnectionRequest,
            com.google.cloud.designcenter.v1.Connection>
        getUpdateConnectionMethod;
    if ((getUpdateConnectionMethod = DesignCenterGrpc.getUpdateConnectionMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getUpdateConnectionMethod = DesignCenterGrpc.getUpdateConnectionMethod) == null) {
          DesignCenterGrpc.getUpdateConnectionMethod =
              getUpdateConnectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.UpdateConnectionRequest,
                          com.google.cloud.designcenter.v1.Connection>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateConnection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.UpdateConnectionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.Connection.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("UpdateConnection"))
                      .build();
        }
      }
    }
    return getUpdateConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.DeleteConnectionRequest, com.google.protobuf.Empty>
      getDeleteConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteConnection",
      requestType = com.google.cloud.designcenter.v1.DeleteConnectionRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.DeleteConnectionRequest, com.google.protobuf.Empty>
      getDeleteConnectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.DeleteConnectionRequest, com.google.protobuf.Empty>
        getDeleteConnectionMethod;
    if ((getDeleteConnectionMethod = DesignCenterGrpc.getDeleteConnectionMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getDeleteConnectionMethod = DesignCenterGrpc.getDeleteConnectionMethod) == null) {
          DesignCenterGrpc.getDeleteConnectionMethod =
              getDeleteConnectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.DeleteConnectionRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteConnection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.DeleteConnectionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("DeleteConnection"))
                      .build();
        }
      }
    }
    return getDeleteConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GetApplicationTemplateRevisionRequest,
          com.google.cloud.designcenter.v1.ApplicationTemplateRevision>
      getGetApplicationTemplateRevisionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetApplicationTemplateRevision",
      requestType = com.google.cloud.designcenter.v1.GetApplicationTemplateRevisionRequest.class,
      responseType = com.google.cloud.designcenter.v1.ApplicationTemplateRevision.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GetApplicationTemplateRevisionRequest,
          com.google.cloud.designcenter.v1.ApplicationTemplateRevision>
      getGetApplicationTemplateRevisionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.GetApplicationTemplateRevisionRequest,
            com.google.cloud.designcenter.v1.ApplicationTemplateRevision>
        getGetApplicationTemplateRevisionMethod;
    if ((getGetApplicationTemplateRevisionMethod =
            DesignCenterGrpc.getGetApplicationTemplateRevisionMethod)
        == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getGetApplicationTemplateRevisionMethod =
                DesignCenterGrpc.getGetApplicationTemplateRevisionMethod)
            == null) {
          DesignCenterGrpc.getGetApplicationTemplateRevisionMethod =
              getGetApplicationTemplateRevisionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.GetApplicationTemplateRevisionRequest,
                          com.google.cloud.designcenter.v1.ApplicationTemplateRevision>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetApplicationTemplateRevision"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.GetApplicationTemplateRevisionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.ApplicationTemplateRevision
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier(
                              "GetApplicationTemplateRevision"))
                      .build();
        }
      }
    }
    return getGetApplicationTemplateRevisionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ListApplicationTemplateRevisionsRequest,
          com.google.cloud.designcenter.v1.ListApplicationTemplateRevisionsResponse>
      getListApplicationTemplateRevisionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListApplicationTemplateRevisions",
      requestType = com.google.cloud.designcenter.v1.ListApplicationTemplateRevisionsRequest.class,
      responseType =
          com.google.cloud.designcenter.v1.ListApplicationTemplateRevisionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ListApplicationTemplateRevisionsRequest,
          com.google.cloud.designcenter.v1.ListApplicationTemplateRevisionsResponse>
      getListApplicationTemplateRevisionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.ListApplicationTemplateRevisionsRequest,
            com.google.cloud.designcenter.v1.ListApplicationTemplateRevisionsResponse>
        getListApplicationTemplateRevisionsMethod;
    if ((getListApplicationTemplateRevisionsMethod =
            DesignCenterGrpc.getListApplicationTemplateRevisionsMethod)
        == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getListApplicationTemplateRevisionsMethod =
                DesignCenterGrpc.getListApplicationTemplateRevisionsMethod)
            == null) {
          DesignCenterGrpc.getListApplicationTemplateRevisionsMethod =
              getListApplicationTemplateRevisionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.ListApplicationTemplateRevisionsRequest,
                          com.google.cloud.designcenter.v1.ListApplicationTemplateRevisionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListApplicationTemplateRevisions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1
                                  .ListApplicationTemplateRevisionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1
                                  .ListApplicationTemplateRevisionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier(
                              "ListApplicationTemplateRevisions"))
                      .build();
        }
      }
    }
    return getListApplicationTemplateRevisionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.DeleteApplicationTemplateRevisionRequest,
          com.google.protobuf.Empty>
      getDeleteApplicationTemplateRevisionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteApplicationTemplateRevision",
      requestType = com.google.cloud.designcenter.v1.DeleteApplicationTemplateRevisionRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.DeleteApplicationTemplateRevisionRequest,
          com.google.protobuf.Empty>
      getDeleteApplicationTemplateRevisionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.DeleteApplicationTemplateRevisionRequest,
            com.google.protobuf.Empty>
        getDeleteApplicationTemplateRevisionMethod;
    if ((getDeleteApplicationTemplateRevisionMethod =
            DesignCenterGrpc.getDeleteApplicationTemplateRevisionMethod)
        == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getDeleteApplicationTemplateRevisionMethod =
                DesignCenterGrpc.getDeleteApplicationTemplateRevisionMethod)
            == null) {
          DesignCenterGrpc.getDeleteApplicationTemplateRevisionMethod =
              getDeleteApplicationTemplateRevisionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.DeleteApplicationTemplateRevisionRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteApplicationTemplateRevision"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1
                                  .DeleteApplicationTemplateRevisionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier(
                              "DeleteApplicationTemplateRevision"))
                      .build();
        }
      }
    }
    return getDeleteApplicationTemplateRevisionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GetCatalogRequest,
          com.google.cloud.designcenter.v1.Catalog>
      getGetCatalogMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCatalog",
      requestType = com.google.cloud.designcenter.v1.GetCatalogRequest.class,
      responseType = com.google.cloud.designcenter.v1.Catalog.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GetCatalogRequest,
          com.google.cloud.designcenter.v1.Catalog>
      getGetCatalogMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.GetCatalogRequest,
            com.google.cloud.designcenter.v1.Catalog>
        getGetCatalogMethod;
    if ((getGetCatalogMethod = DesignCenterGrpc.getGetCatalogMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getGetCatalogMethod = DesignCenterGrpc.getGetCatalogMethod) == null) {
          DesignCenterGrpc.getGetCatalogMethod =
              getGetCatalogMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.GetCatalogRequest,
                          com.google.cloud.designcenter.v1.Catalog>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCatalog"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.GetCatalogRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.Catalog.getDefaultInstance()))
                      .setSchemaDescriptor(new DesignCenterMethodDescriptorSupplier("GetCatalog"))
                      .build();
        }
      }
    }
    return getGetCatalogMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ListCatalogsRequest,
          com.google.cloud.designcenter.v1.ListCatalogsResponse>
      getListCatalogsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCatalogs",
      requestType = com.google.cloud.designcenter.v1.ListCatalogsRequest.class,
      responseType = com.google.cloud.designcenter.v1.ListCatalogsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ListCatalogsRequest,
          com.google.cloud.designcenter.v1.ListCatalogsResponse>
      getListCatalogsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.ListCatalogsRequest,
            com.google.cloud.designcenter.v1.ListCatalogsResponse>
        getListCatalogsMethod;
    if ((getListCatalogsMethod = DesignCenterGrpc.getListCatalogsMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getListCatalogsMethod = DesignCenterGrpc.getListCatalogsMethod) == null) {
          DesignCenterGrpc.getListCatalogsMethod =
              getListCatalogsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.ListCatalogsRequest,
                          com.google.cloud.designcenter.v1.ListCatalogsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCatalogs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.ListCatalogsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.ListCatalogsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new DesignCenterMethodDescriptorSupplier("ListCatalogs"))
                      .build();
        }
      }
    }
    return getListCatalogsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.CreateCatalogRequest,
          com.google.cloud.designcenter.v1.Catalog>
      getCreateCatalogMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCatalog",
      requestType = com.google.cloud.designcenter.v1.CreateCatalogRequest.class,
      responseType = com.google.cloud.designcenter.v1.Catalog.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.CreateCatalogRequest,
          com.google.cloud.designcenter.v1.Catalog>
      getCreateCatalogMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.CreateCatalogRequest,
            com.google.cloud.designcenter.v1.Catalog>
        getCreateCatalogMethod;
    if ((getCreateCatalogMethod = DesignCenterGrpc.getCreateCatalogMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getCreateCatalogMethod = DesignCenterGrpc.getCreateCatalogMethod) == null) {
          DesignCenterGrpc.getCreateCatalogMethod =
              getCreateCatalogMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.CreateCatalogRequest,
                          com.google.cloud.designcenter.v1.Catalog>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCatalog"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.CreateCatalogRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.Catalog.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("CreateCatalog"))
                      .build();
        }
      }
    }
    return getCreateCatalogMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.UpdateCatalogRequest,
          com.google.cloud.designcenter.v1.Catalog>
      getUpdateCatalogMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCatalog",
      requestType = com.google.cloud.designcenter.v1.UpdateCatalogRequest.class,
      responseType = com.google.cloud.designcenter.v1.Catalog.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.UpdateCatalogRequest,
          com.google.cloud.designcenter.v1.Catalog>
      getUpdateCatalogMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.UpdateCatalogRequest,
            com.google.cloud.designcenter.v1.Catalog>
        getUpdateCatalogMethod;
    if ((getUpdateCatalogMethod = DesignCenterGrpc.getUpdateCatalogMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getUpdateCatalogMethod = DesignCenterGrpc.getUpdateCatalogMethod) == null) {
          DesignCenterGrpc.getUpdateCatalogMethod =
              getUpdateCatalogMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.UpdateCatalogRequest,
                          com.google.cloud.designcenter.v1.Catalog>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCatalog"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.UpdateCatalogRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.Catalog.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("UpdateCatalog"))
                      .build();
        }
      }
    }
    return getUpdateCatalogMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.DeleteCatalogRequest, com.google.longrunning.Operation>
      getDeleteCatalogMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCatalog",
      requestType = com.google.cloud.designcenter.v1.DeleteCatalogRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.DeleteCatalogRequest, com.google.longrunning.Operation>
      getDeleteCatalogMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.DeleteCatalogRequest, com.google.longrunning.Operation>
        getDeleteCatalogMethod;
    if ((getDeleteCatalogMethod = DesignCenterGrpc.getDeleteCatalogMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getDeleteCatalogMethod = DesignCenterGrpc.getDeleteCatalogMethod) == null) {
          DesignCenterGrpc.getDeleteCatalogMethod =
              getDeleteCatalogMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.DeleteCatalogRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCatalog"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.DeleteCatalogRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("DeleteCatalog"))
                      .build();
        }
      }
    }
    return getDeleteCatalogMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.CreateCatalogTemplateRequest,
          com.google.cloud.designcenter.v1.CatalogTemplate>
      getCreateCatalogTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCatalogTemplate",
      requestType = com.google.cloud.designcenter.v1.CreateCatalogTemplateRequest.class,
      responseType = com.google.cloud.designcenter.v1.CatalogTemplate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.CreateCatalogTemplateRequest,
          com.google.cloud.designcenter.v1.CatalogTemplate>
      getCreateCatalogTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.CreateCatalogTemplateRequest,
            com.google.cloud.designcenter.v1.CatalogTemplate>
        getCreateCatalogTemplateMethod;
    if ((getCreateCatalogTemplateMethod = DesignCenterGrpc.getCreateCatalogTemplateMethod)
        == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getCreateCatalogTemplateMethod = DesignCenterGrpc.getCreateCatalogTemplateMethod)
            == null) {
          DesignCenterGrpc.getCreateCatalogTemplateMethod =
              getCreateCatalogTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.CreateCatalogTemplateRequest,
                          com.google.cloud.designcenter.v1.CatalogTemplate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateCatalogTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.CreateCatalogTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.CatalogTemplate
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("CreateCatalogTemplate"))
                      .build();
        }
      }
    }
    return getCreateCatalogTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GetCatalogTemplateRequest,
          com.google.cloud.designcenter.v1.CatalogTemplate>
      getGetCatalogTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCatalogTemplate",
      requestType = com.google.cloud.designcenter.v1.GetCatalogTemplateRequest.class,
      responseType = com.google.cloud.designcenter.v1.CatalogTemplate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GetCatalogTemplateRequest,
          com.google.cloud.designcenter.v1.CatalogTemplate>
      getGetCatalogTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.GetCatalogTemplateRequest,
            com.google.cloud.designcenter.v1.CatalogTemplate>
        getGetCatalogTemplateMethod;
    if ((getGetCatalogTemplateMethod = DesignCenterGrpc.getGetCatalogTemplateMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getGetCatalogTemplateMethod = DesignCenterGrpc.getGetCatalogTemplateMethod) == null) {
          DesignCenterGrpc.getGetCatalogTemplateMethod =
              getGetCatalogTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.GetCatalogTemplateRequest,
                          com.google.cloud.designcenter.v1.CatalogTemplate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCatalogTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.GetCatalogTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.CatalogTemplate
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("GetCatalogTemplate"))
                      .build();
        }
      }
    }
    return getGetCatalogTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ListCatalogTemplatesRequest,
          com.google.cloud.designcenter.v1.ListCatalogTemplatesResponse>
      getListCatalogTemplatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCatalogTemplates",
      requestType = com.google.cloud.designcenter.v1.ListCatalogTemplatesRequest.class,
      responseType = com.google.cloud.designcenter.v1.ListCatalogTemplatesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ListCatalogTemplatesRequest,
          com.google.cloud.designcenter.v1.ListCatalogTemplatesResponse>
      getListCatalogTemplatesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.ListCatalogTemplatesRequest,
            com.google.cloud.designcenter.v1.ListCatalogTemplatesResponse>
        getListCatalogTemplatesMethod;
    if ((getListCatalogTemplatesMethod = DesignCenterGrpc.getListCatalogTemplatesMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getListCatalogTemplatesMethod = DesignCenterGrpc.getListCatalogTemplatesMethod)
            == null) {
          DesignCenterGrpc.getListCatalogTemplatesMethod =
              getListCatalogTemplatesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.ListCatalogTemplatesRequest,
                          com.google.cloud.designcenter.v1.ListCatalogTemplatesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListCatalogTemplates"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.ListCatalogTemplatesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.ListCatalogTemplatesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("ListCatalogTemplates"))
                      .build();
        }
      }
    }
    return getListCatalogTemplatesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.UpdateCatalogTemplateRequest,
          com.google.cloud.designcenter.v1.CatalogTemplate>
      getUpdateCatalogTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCatalogTemplate",
      requestType = com.google.cloud.designcenter.v1.UpdateCatalogTemplateRequest.class,
      responseType = com.google.cloud.designcenter.v1.CatalogTemplate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.UpdateCatalogTemplateRequest,
          com.google.cloud.designcenter.v1.CatalogTemplate>
      getUpdateCatalogTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.UpdateCatalogTemplateRequest,
            com.google.cloud.designcenter.v1.CatalogTemplate>
        getUpdateCatalogTemplateMethod;
    if ((getUpdateCatalogTemplateMethod = DesignCenterGrpc.getUpdateCatalogTemplateMethod)
        == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getUpdateCatalogTemplateMethod = DesignCenterGrpc.getUpdateCatalogTemplateMethod)
            == null) {
          DesignCenterGrpc.getUpdateCatalogTemplateMethod =
              getUpdateCatalogTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.UpdateCatalogTemplateRequest,
                          com.google.cloud.designcenter.v1.CatalogTemplate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateCatalogTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.UpdateCatalogTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.CatalogTemplate
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("UpdateCatalogTemplate"))
                      .build();
        }
      }
    }
    return getUpdateCatalogTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.DeleteCatalogTemplateRequest,
          com.google.longrunning.Operation>
      getDeleteCatalogTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCatalogTemplate",
      requestType = com.google.cloud.designcenter.v1.DeleteCatalogTemplateRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.DeleteCatalogTemplateRequest,
          com.google.longrunning.Operation>
      getDeleteCatalogTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.DeleteCatalogTemplateRequest,
            com.google.longrunning.Operation>
        getDeleteCatalogTemplateMethod;
    if ((getDeleteCatalogTemplateMethod = DesignCenterGrpc.getDeleteCatalogTemplateMethod)
        == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getDeleteCatalogTemplateMethod = DesignCenterGrpc.getDeleteCatalogTemplateMethod)
            == null) {
          DesignCenterGrpc.getDeleteCatalogTemplateMethod =
              getDeleteCatalogTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.DeleteCatalogTemplateRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteCatalogTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.DeleteCatalogTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("DeleteCatalogTemplate"))
                      .build();
        }
      }
    }
    return getDeleteCatalogTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.CreateShareRequest, com.google.longrunning.Operation>
      getCreateShareMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateShare",
      requestType = com.google.cloud.designcenter.v1.CreateShareRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.CreateShareRequest, com.google.longrunning.Operation>
      getCreateShareMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.CreateShareRequest, com.google.longrunning.Operation>
        getCreateShareMethod;
    if ((getCreateShareMethod = DesignCenterGrpc.getCreateShareMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getCreateShareMethod = DesignCenterGrpc.getCreateShareMethod) == null) {
          DesignCenterGrpc.getCreateShareMethod =
              getCreateShareMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.CreateShareRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateShare"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.CreateShareRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new DesignCenterMethodDescriptorSupplier("CreateShare"))
                      .build();
        }
      }
    }
    return getCreateShareMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ListSharesRequest,
          com.google.cloud.designcenter.v1.ListSharesResponse>
      getListSharesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListShares",
      requestType = com.google.cloud.designcenter.v1.ListSharesRequest.class,
      responseType = com.google.cloud.designcenter.v1.ListSharesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ListSharesRequest,
          com.google.cloud.designcenter.v1.ListSharesResponse>
      getListSharesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.ListSharesRequest,
            com.google.cloud.designcenter.v1.ListSharesResponse>
        getListSharesMethod;
    if ((getListSharesMethod = DesignCenterGrpc.getListSharesMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getListSharesMethod = DesignCenterGrpc.getListSharesMethod) == null) {
          DesignCenterGrpc.getListSharesMethod =
              getListSharesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.ListSharesRequest,
                          com.google.cloud.designcenter.v1.ListSharesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListShares"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.ListSharesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.ListSharesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new DesignCenterMethodDescriptorSupplier("ListShares"))
                      .build();
        }
      }
    }
    return getListSharesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GetShareRequest, com.google.cloud.designcenter.v1.Share>
      getGetShareMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetShare",
      requestType = com.google.cloud.designcenter.v1.GetShareRequest.class,
      responseType = com.google.cloud.designcenter.v1.Share.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GetShareRequest, com.google.cloud.designcenter.v1.Share>
      getGetShareMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.GetShareRequest,
            com.google.cloud.designcenter.v1.Share>
        getGetShareMethod;
    if ((getGetShareMethod = DesignCenterGrpc.getGetShareMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getGetShareMethod = DesignCenterGrpc.getGetShareMethod) == null) {
          DesignCenterGrpc.getGetShareMethod =
              getGetShareMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.GetShareRequest,
                          com.google.cloud.designcenter.v1.Share>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetShare"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.GetShareRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.Share.getDefaultInstance()))
                      .setSchemaDescriptor(new DesignCenterMethodDescriptorSupplier("GetShare"))
                      .build();
        }
      }
    }
    return getGetShareMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.DeleteShareRequest, com.google.longrunning.Operation>
      getDeleteShareMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteShare",
      requestType = com.google.cloud.designcenter.v1.DeleteShareRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.DeleteShareRequest, com.google.longrunning.Operation>
      getDeleteShareMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.DeleteShareRequest, com.google.longrunning.Operation>
        getDeleteShareMethod;
    if ((getDeleteShareMethod = DesignCenterGrpc.getDeleteShareMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getDeleteShareMethod = DesignCenterGrpc.getDeleteShareMethod) == null) {
          DesignCenterGrpc.getDeleteShareMethod =
              getDeleteShareMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.DeleteShareRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteShare"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.DeleteShareRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new DesignCenterMethodDescriptorSupplier("DeleteShare"))
                      .build();
        }
      }
    }
    return getDeleteShareMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.SyncShareRequest, com.google.longrunning.Operation>
      getSyncShareMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SyncShare",
      requestType = com.google.cloud.designcenter.v1.SyncShareRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.SyncShareRequest, com.google.longrunning.Operation>
      getSyncShareMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.SyncShareRequest, com.google.longrunning.Operation>
        getSyncShareMethod;
    if ((getSyncShareMethod = DesignCenterGrpc.getSyncShareMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getSyncShareMethod = DesignCenterGrpc.getSyncShareMethod) == null) {
          DesignCenterGrpc.getSyncShareMethod =
              getSyncShareMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.SyncShareRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SyncShare"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.SyncShareRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new DesignCenterMethodDescriptorSupplier("SyncShare"))
                      .build();
        }
      }
    }
    return getSyncShareMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GetSharedTemplateRequest,
          com.google.cloud.designcenter.v1.SharedTemplate>
      getGetSharedTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSharedTemplate",
      requestType = com.google.cloud.designcenter.v1.GetSharedTemplateRequest.class,
      responseType = com.google.cloud.designcenter.v1.SharedTemplate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GetSharedTemplateRequest,
          com.google.cloud.designcenter.v1.SharedTemplate>
      getGetSharedTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.GetSharedTemplateRequest,
            com.google.cloud.designcenter.v1.SharedTemplate>
        getGetSharedTemplateMethod;
    if ((getGetSharedTemplateMethod = DesignCenterGrpc.getGetSharedTemplateMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getGetSharedTemplateMethod = DesignCenterGrpc.getGetSharedTemplateMethod) == null) {
          DesignCenterGrpc.getGetSharedTemplateMethod =
              getGetSharedTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.GetSharedTemplateRequest,
                          com.google.cloud.designcenter.v1.SharedTemplate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSharedTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.GetSharedTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.SharedTemplate.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("GetSharedTemplate"))
                      .build();
        }
      }
    }
    return getGetSharedTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ListSharedTemplatesRequest,
          com.google.cloud.designcenter.v1.ListSharedTemplatesResponse>
      getListSharedTemplatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSharedTemplates",
      requestType = com.google.cloud.designcenter.v1.ListSharedTemplatesRequest.class,
      responseType = com.google.cloud.designcenter.v1.ListSharedTemplatesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ListSharedTemplatesRequest,
          com.google.cloud.designcenter.v1.ListSharedTemplatesResponse>
      getListSharedTemplatesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.ListSharedTemplatesRequest,
            com.google.cloud.designcenter.v1.ListSharedTemplatesResponse>
        getListSharedTemplatesMethod;
    if ((getListSharedTemplatesMethod = DesignCenterGrpc.getListSharedTemplatesMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getListSharedTemplatesMethod = DesignCenterGrpc.getListSharedTemplatesMethod)
            == null) {
          DesignCenterGrpc.getListSharedTemplatesMethod =
              getListSharedTemplatesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.ListSharedTemplatesRequest,
                          com.google.cloud.designcenter.v1.ListSharedTemplatesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListSharedTemplates"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.ListSharedTemplatesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.ListSharedTemplatesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("ListSharedTemplates"))
                      .build();
        }
      }
    }
    return getListSharedTemplatesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GetSharedTemplateRevisionRequest,
          com.google.cloud.designcenter.v1.SharedTemplateRevision>
      getGetSharedTemplateRevisionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSharedTemplateRevision",
      requestType = com.google.cloud.designcenter.v1.GetSharedTemplateRevisionRequest.class,
      responseType = com.google.cloud.designcenter.v1.SharedTemplateRevision.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GetSharedTemplateRevisionRequest,
          com.google.cloud.designcenter.v1.SharedTemplateRevision>
      getGetSharedTemplateRevisionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.GetSharedTemplateRevisionRequest,
            com.google.cloud.designcenter.v1.SharedTemplateRevision>
        getGetSharedTemplateRevisionMethod;
    if ((getGetSharedTemplateRevisionMethod = DesignCenterGrpc.getGetSharedTemplateRevisionMethod)
        == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getGetSharedTemplateRevisionMethod =
                DesignCenterGrpc.getGetSharedTemplateRevisionMethod)
            == null) {
          DesignCenterGrpc.getGetSharedTemplateRevisionMethod =
              getGetSharedTemplateRevisionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.GetSharedTemplateRevisionRequest,
                          com.google.cloud.designcenter.v1.SharedTemplateRevision>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetSharedTemplateRevision"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.GetSharedTemplateRevisionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.SharedTemplateRevision
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("GetSharedTemplateRevision"))
                      .build();
        }
      }
    }
    return getGetSharedTemplateRevisionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ListSharedTemplateRevisionsRequest,
          com.google.cloud.designcenter.v1.ListSharedTemplateRevisionsResponse>
      getListSharedTemplateRevisionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSharedTemplateRevisions",
      requestType = com.google.cloud.designcenter.v1.ListSharedTemplateRevisionsRequest.class,
      responseType = com.google.cloud.designcenter.v1.ListSharedTemplateRevisionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ListSharedTemplateRevisionsRequest,
          com.google.cloud.designcenter.v1.ListSharedTemplateRevisionsResponse>
      getListSharedTemplateRevisionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.ListSharedTemplateRevisionsRequest,
            com.google.cloud.designcenter.v1.ListSharedTemplateRevisionsResponse>
        getListSharedTemplateRevisionsMethod;
    if ((getListSharedTemplateRevisionsMethod =
            DesignCenterGrpc.getListSharedTemplateRevisionsMethod)
        == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getListSharedTemplateRevisionsMethod =
                DesignCenterGrpc.getListSharedTemplateRevisionsMethod)
            == null) {
          DesignCenterGrpc.getListSharedTemplateRevisionsMethod =
              getListSharedTemplateRevisionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.ListSharedTemplateRevisionsRequest,
                          com.google.cloud.designcenter.v1.ListSharedTemplateRevisionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListSharedTemplateRevisions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.ListSharedTemplateRevisionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.ListSharedTemplateRevisionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("ListSharedTemplateRevisions"))
                      .build();
        }
      }
    }
    return getListSharedTemplateRevisionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.CreateCatalogTemplateRevisionRequest,
          com.google.longrunning.Operation>
      getCreateCatalogTemplateRevisionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCatalogTemplateRevision",
      requestType = com.google.cloud.designcenter.v1.CreateCatalogTemplateRevisionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.CreateCatalogTemplateRevisionRequest,
          com.google.longrunning.Operation>
      getCreateCatalogTemplateRevisionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.CreateCatalogTemplateRevisionRequest,
            com.google.longrunning.Operation>
        getCreateCatalogTemplateRevisionMethod;
    if ((getCreateCatalogTemplateRevisionMethod =
            DesignCenterGrpc.getCreateCatalogTemplateRevisionMethod)
        == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getCreateCatalogTemplateRevisionMethod =
                DesignCenterGrpc.getCreateCatalogTemplateRevisionMethod)
            == null) {
          DesignCenterGrpc.getCreateCatalogTemplateRevisionMethod =
              getCreateCatalogTemplateRevisionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.CreateCatalogTemplateRevisionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateCatalogTemplateRevision"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.CreateCatalogTemplateRevisionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("CreateCatalogTemplateRevision"))
                      .build();
        }
      }
    }
    return getCreateCatalogTemplateRevisionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GetCatalogTemplateRevisionRequest,
          com.google.cloud.designcenter.v1.CatalogTemplateRevision>
      getGetCatalogTemplateRevisionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCatalogTemplateRevision",
      requestType = com.google.cloud.designcenter.v1.GetCatalogTemplateRevisionRequest.class,
      responseType = com.google.cloud.designcenter.v1.CatalogTemplateRevision.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GetCatalogTemplateRevisionRequest,
          com.google.cloud.designcenter.v1.CatalogTemplateRevision>
      getGetCatalogTemplateRevisionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.GetCatalogTemplateRevisionRequest,
            com.google.cloud.designcenter.v1.CatalogTemplateRevision>
        getGetCatalogTemplateRevisionMethod;
    if ((getGetCatalogTemplateRevisionMethod = DesignCenterGrpc.getGetCatalogTemplateRevisionMethod)
        == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getGetCatalogTemplateRevisionMethod =
                DesignCenterGrpc.getGetCatalogTemplateRevisionMethod)
            == null) {
          DesignCenterGrpc.getGetCatalogTemplateRevisionMethod =
              getGetCatalogTemplateRevisionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.GetCatalogTemplateRevisionRequest,
                          com.google.cloud.designcenter.v1.CatalogTemplateRevision>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetCatalogTemplateRevision"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.GetCatalogTemplateRevisionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.CatalogTemplateRevision
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("GetCatalogTemplateRevision"))
                      .build();
        }
      }
    }
    return getGetCatalogTemplateRevisionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ListCatalogTemplateRevisionsRequest,
          com.google.cloud.designcenter.v1.ListCatalogTemplateRevisionsResponse>
      getListCatalogTemplateRevisionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCatalogTemplateRevisions",
      requestType = com.google.cloud.designcenter.v1.ListCatalogTemplateRevisionsRequest.class,
      responseType = com.google.cloud.designcenter.v1.ListCatalogTemplateRevisionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ListCatalogTemplateRevisionsRequest,
          com.google.cloud.designcenter.v1.ListCatalogTemplateRevisionsResponse>
      getListCatalogTemplateRevisionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.ListCatalogTemplateRevisionsRequest,
            com.google.cloud.designcenter.v1.ListCatalogTemplateRevisionsResponse>
        getListCatalogTemplateRevisionsMethod;
    if ((getListCatalogTemplateRevisionsMethod =
            DesignCenterGrpc.getListCatalogTemplateRevisionsMethod)
        == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getListCatalogTemplateRevisionsMethod =
                DesignCenterGrpc.getListCatalogTemplateRevisionsMethod)
            == null) {
          DesignCenterGrpc.getListCatalogTemplateRevisionsMethod =
              getListCatalogTemplateRevisionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.ListCatalogTemplateRevisionsRequest,
                          com.google.cloud.designcenter.v1.ListCatalogTemplateRevisionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListCatalogTemplateRevisions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.ListCatalogTemplateRevisionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.ListCatalogTemplateRevisionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("ListCatalogTemplateRevisions"))
                      .build();
        }
      }
    }
    return getListCatalogTemplateRevisionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.DeleteCatalogTemplateRevisionRequest,
          com.google.longrunning.Operation>
      getDeleteCatalogTemplateRevisionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCatalogTemplateRevision",
      requestType = com.google.cloud.designcenter.v1.DeleteCatalogTemplateRevisionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.DeleteCatalogTemplateRevisionRequest,
          com.google.longrunning.Operation>
      getDeleteCatalogTemplateRevisionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.DeleteCatalogTemplateRevisionRequest,
            com.google.longrunning.Operation>
        getDeleteCatalogTemplateRevisionMethod;
    if ((getDeleteCatalogTemplateRevisionMethod =
            DesignCenterGrpc.getDeleteCatalogTemplateRevisionMethod)
        == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getDeleteCatalogTemplateRevisionMethod =
                DesignCenterGrpc.getDeleteCatalogTemplateRevisionMethod)
            == null) {
          DesignCenterGrpc.getDeleteCatalogTemplateRevisionMethod =
              getDeleteCatalogTemplateRevisionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.DeleteCatalogTemplateRevisionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteCatalogTemplateRevision"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.DeleteCatalogTemplateRevisionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("DeleteCatalogTemplateRevision"))
                      .build();
        }
      }
    }
    return getDeleteCatalogTemplateRevisionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.CreateApplicationRequest,
          com.google.cloud.designcenter.v1.Application>
      getCreateApplicationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateApplication",
      requestType = com.google.cloud.designcenter.v1.CreateApplicationRequest.class,
      responseType = com.google.cloud.designcenter.v1.Application.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.CreateApplicationRequest,
          com.google.cloud.designcenter.v1.Application>
      getCreateApplicationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.CreateApplicationRequest,
            com.google.cloud.designcenter.v1.Application>
        getCreateApplicationMethod;
    if ((getCreateApplicationMethod = DesignCenterGrpc.getCreateApplicationMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getCreateApplicationMethod = DesignCenterGrpc.getCreateApplicationMethod) == null) {
          DesignCenterGrpc.getCreateApplicationMethod =
              getCreateApplicationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.CreateApplicationRequest,
                          com.google.cloud.designcenter.v1.Application>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateApplication"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.CreateApplicationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.Application.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("CreateApplication"))
                      .build();
        }
      }
    }
    return getCreateApplicationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GetApplicationRequest,
          com.google.cloud.designcenter.v1.Application>
      getGetApplicationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetApplication",
      requestType = com.google.cloud.designcenter.v1.GetApplicationRequest.class,
      responseType = com.google.cloud.designcenter.v1.Application.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GetApplicationRequest,
          com.google.cloud.designcenter.v1.Application>
      getGetApplicationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.GetApplicationRequest,
            com.google.cloud.designcenter.v1.Application>
        getGetApplicationMethod;
    if ((getGetApplicationMethod = DesignCenterGrpc.getGetApplicationMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getGetApplicationMethod = DesignCenterGrpc.getGetApplicationMethod) == null) {
          DesignCenterGrpc.getGetApplicationMethod =
              getGetApplicationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.GetApplicationRequest,
                          com.google.cloud.designcenter.v1.Application>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetApplication"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.GetApplicationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.Application.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("GetApplication"))
                      .build();
        }
      }
    }
    return getGetApplicationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ListApplicationsRequest,
          com.google.cloud.designcenter.v1.ListApplicationsResponse>
      getListApplicationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListApplications",
      requestType = com.google.cloud.designcenter.v1.ListApplicationsRequest.class,
      responseType = com.google.cloud.designcenter.v1.ListApplicationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ListApplicationsRequest,
          com.google.cloud.designcenter.v1.ListApplicationsResponse>
      getListApplicationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.ListApplicationsRequest,
            com.google.cloud.designcenter.v1.ListApplicationsResponse>
        getListApplicationsMethod;
    if ((getListApplicationsMethod = DesignCenterGrpc.getListApplicationsMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getListApplicationsMethod = DesignCenterGrpc.getListApplicationsMethod) == null) {
          DesignCenterGrpc.getListApplicationsMethod =
              getListApplicationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.ListApplicationsRequest,
                          com.google.cloud.designcenter.v1.ListApplicationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListApplications"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.ListApplicationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.ListApplicationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("ListApplications"))
                      .build();
        }
      }
    }
    return getListApplicationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.UpdateApplicationRequest,
          com.google.cloud.designcenter.v1.Application>
      getUpdateApplicationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateApplication",
      requestType = com.google.cloud.designcenter.v1.UpdateApplicationRequest.class,
      responseType = com.google.cloud.designcenter.v1.Application.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.UpdateApplicationRequest,
          com.google.cloud.designcenter.v1.Application>
      getUpdateApplicationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.UpdateApplicationRequest,
            com.google.cloud.designcenter.v1.Application>
        getUpdateApplicationMethod;
    if ((getUpdateApplicationMethod = DesignCenterGrpc.getUpdateApplicationMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getUpdateApplicationMethod = DesignCenterGrpc.getUpdateApplicationMethod) == null) {
          DesignCenterGrpc.getUpdateApplicationMethod =
              getUpdateApplicationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.UpdateApplicationRequest,
                          com.google.cloud.designcenter.v1.Application>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateApplication"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.UpdateApplicationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.Application.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("UpdateApplication"))
                      .build();
        }
      }
    }
    return getUpdateApplicationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.DeleteApplicationRequest,
          com.google.longrunning.Operation>
      getDeleteApplicationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteApplication",
      requestType = com.google.cloud.designcenter.v1.DeleteApplicationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.DeleteApplicationRequest,
          com.google.longrunning.Operation>
      getDeleteApplicationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.DeleteApplicationRequest,
            com.google.longrunning.Operation>
        getDeleteApplicationMethod;
    if ((getDeleteApplicationMethod = DesignCenterGrpc.getDeleteApplicationMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getDeleteApplicationMethod = DesignCenterGrpc.getDeleteApplicationMethod) == null) {
          DesignCenterGrpc.getDeleteApplicationMethod =
              getDeleteApplicationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.DeleteApplicationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteApplication"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.DeleteApplicationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("DeleteApplication"))
                      .build();
        }
      }
    }
    return getDeleteApplicationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.DeployApplicationRequest,
          com.google.longrunning.Operation>
      getDeployApplicationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeployApplication",
      requestType = com.google.cloud.designcenter.v1.DeployApplicationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.DeployApplicationRequest,
          com.google.longrunning.Operation>
      getDeployApplicationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.DeployApplicationRequest,
            com.google.longrunning.Operation>
        getDeployApplicationMethod;
    if ((getDeployApplicationMethod = DesignCenterGrpc.getDeployApplicationMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getDeployApplicationMethod = DesignCenterGrpc.getDeployApplicationMethod) == null) {
          DesignCenterGrpc.getDeployApplicationMethod =
              getDeployApplicationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.DeployApplicationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeployApplication"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.DeployApplicationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("DeployApplication"))
                      .build();
        }
      }
    }
    return getDeployApplicationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.PreviewApplicationRequest,
          com.google.longrunning.Operation>
      getPreviewApplicationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PreviewApplication",
      requestType = com.google.cloud.designcenter.v1.PreviewApplicationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.PreviewApplicationRequest,
          com.google.longrunning.Operation>
      getPreviewApplicationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.PreviewApplicationRequest,
            com.google.longrunning.Operation>
        getPreviewApplicationMethod;
    if ((getPreviewApplicationMethod = DesignCenterGrpc.getPreviewApplicationMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getPreviewApplicationMethod = DesignCenterGrpc.getPreviewApplicationMethod) == null) {
          DesignCenterGrpc.getPreviewApplicationMethod =
              getPreviewApplicationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.PreviewApplicationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PreviewApplication"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.PreviewApplicationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("PreviewApplication"))
                      .build();
        }
      }
    }
    return getPreviewApplicationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.FetchApplicationAssessmentReportRequest,
          com.google.cloud.designcenter.v1.FetchApplicationAssessmentReportResponse>
      getFetchApplicationAssessmentReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchApplicationAssessmentReport",
      requestType = com.google.cloud.designcenter.v1.FetchApplicationAssessmentReportRequest.class,
      responseType =
          com.google.cloud.designcenter.v1.FetchApplicationAssessmentReportResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.FetchApplicationAssessmentReportRequest,
          com.google.cloud.designcenter.v1.FetchApplicationAssessmentReportResponse>
      getFetchApplicationAssessmentReportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.FetchApplicationAssessmentReportRequest,
            com.google.cloud.designcenter.v1.FetchApplicationAssessmentReportResponse>
        getFetchApplicationAssessmentReportMethod;
    if ((getFetchApplicationAssessmentReportMethod =
            DesignCenterGrpc.getFetchApplicationAssessmentReportMethod)
        == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getFetchApplicationAssessmentReportMethod =
                DesignCenterGrpc.getFetchApplicationAssessmentReportMethod)
            == null) {
          DesignCenterGrpc.getFetchApplicationAssessmentReportMethod =
              getFetchApplicationAssessmentReportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.FetchApplicationAssessmentReportRequest,
                          com.google.cloud.designcenter.v1.FetchApplicationAssessmentReportResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "FetchApplicationAssessmentReport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1
                                  .FetchApplicationAssessmentReportRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1
                                  .FetchApplicationAssessmentReportResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier(
                              "FetchApplicationAssessmentReport"))
                      .build();
        }
      }
    }
    return getFetchApplicationAssessmentReportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GenerateApplicationAssessmentReportRequest,
          com.google.longrunning.Operation>
      getGenerateApplicationAssessmentReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateApplicationAssessmentReport",
      requestType =
          com.google.cloud.designcenter.v1.GenerateApplicationAssessmentReportRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GenerateApplicationAssessmentReportRequest,
          com.google.longrunning.Operation>
      getGenerateApplicationAssessmentReportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.GenerateApplicationAssessmentReportRequest,
            com.google.longrunning.Operation>
        getGenerateApplicationAssessmentReportMethod;
    if ((getGenerateApplicationAssessmentReportMethod =
            DesignCenterGrpc.getGenerateApplicationAssessmentReportMethod)
        == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getGenerateApplicationAssessmentReportMethod =
                DesignCenterGrpc.getGenerateApplicationAssessmentReportMethod)
            == null) {
          DesignCenterGrpc.getGenerateApplicationAssessmentReportMethod =
              getGenerateApplicationAssessmentReportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.GenerateApplicationAssessmentReportRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "GenerateApplicationAssessmentReport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1
                                  .GenerateApplicationAssessmentReportRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier(
                              "GenerateApplicationAssessmentReport"))
                      .build();
        }
      }
    }
    return getGenerateApplicationAssessmentReportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GenerateApplicationTemplateAssessmentReportRequest,
          com.google.longrunning.Operation>
      getGenerateApplicationTemplateAssessmentReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateApplicationTemplateAssessmentReport",
      requestType =
          com.google.cloud.designcenter.v1.GenerateApplicationTemplateAssessmentReportRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GenerateApplicationTemplateAssessmentReportRequest,
          com.google.longrunning.Operation>
      getGenerateApplicationTemplateAssessmentReportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.GenerateApplicationTemplateAssessmentReportRequest,
            com.google.longrunning.Operation>
        getGenerateApplicationTemplateAssessmentReportMethod;
    if ((getGenerateApplicationTemplateAssessmentReportMethod =
            DesignCenterGrpc.getGenerateApplicationTemplateAssessmentReportMethod)
        == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getGenerateApplicationTemplateAssessmentReportMethod =
                DesignCenterGrpc.getGenerateApplicationTemplateAssessmentReportMethod)
            == null) {
          DesignCenterGrpc.getGenerateApplicationTemplateAssessmentReportMethod =
              getGenerateApplicationTemplateAssessmentReportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1
                              .GenerateApplicationTemplateAssessmentReportRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "GenerateApplicationTemplateAssessmentReport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1
                                  .GenerateApplicationTemplateAssessmentReportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier(
                              "GenerateApplicationTemplateAssessmentReport"))
                      .build();
        }
      }
    }
    return getGenerateApplicationTemplateAssessmentReportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GenerateAssessmentReportRequest,
          com.google.longrunning.Operation>
      getGenerateAssessmentReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateAssessmentReport",
      requestType = com.google.cloud.designcenter.v1.GenerateAssessmentReportRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GenerateAssessmentReportRequest,
          com.google.longrunning.Operation>
      getGenerateAssessmentReportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.GenerateAssessmentReportRequest,
            com.google.longrunning.Operation>
        getGenerateAssessmentReportMethod;
    if ((getGenerateAssessmentReportMethod = DesignCenterGrpc.getGenerateAssessmentReportMethod)
        == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getGenerateAssessmentReportMethod = DesignCenterGrpc.getGenerateAssessmentReportMethod)
            == null) {
          DesignCenterGrpc.getGenerateAssessmentReportMethod =
              getGenerateAssessmentReportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.GenerateAssessmentReportRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GenerateAssessmentReport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.GenerateAssessmentReportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("GenerateAssessmentReport"))
                      .build();
        }
      }
    }
    return getGenerateAssessmentReportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GenerateTerraformPlanAssessmentReportRequest,
          com.google.longrunning.Operation>
      getGenerateTerraformPlanAssessmentReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateTerraformPlanAssessmentReport",
      requestType =
          com.google.cloud.designcenter.v1.GenerateTerraformPlanAssessmentReportRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GenerateTerraformPlanAssessmentReportRequest,
          com.google.longrunning.Operation>
      getGenerateTerraformPlanAssessmentReportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.GenerateTerraformPlanAssessmentReportRequest,
            com.google.longrunning.Operation>
        getGenerateTerraformPlanAssessmentReportMethod;
    if ((getGenerateTerraformPlanAssessmentReportMethod =
            DesignCenterGrpc.getGenerateTerraformPlanAssessmentReportMethod)
        == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getGenerateTerraformPlanAssessmentReportMethod =
                DesignCenterGrpc.getGenerateTerraformPlanAssessmentReportMethod)
            == null) {
          DesignCenterGrpc.getGenerateTerraformPlanAssessmentReportMethod =
              getGenerateTerraformPlanAssessmentReportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1
                              .GenerateTerraformPlanAssessmentReportRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "GenerateTerraformPlanAssessmentReport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1
                                  .GenerateTerraformPlanAssessmentReportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier(
                              "GenerateTerraformPlanAssessmentReport"))
                      .build();
        }
      }
    }
    return getGenerateTerraformPlanAssessmentReportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GetPolicyRequest,
          com.google.cloud.designcenter.v1.Policy>
      getGetPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPolicy",
      requestType = com.google.cloud.designcenter.v1.GetPolicyRequest.class,
      responseType = com.google.cloud.designcenter.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GetPolicyRequest,
          com.google.cloud.designcenter.v1.Policy>
      getGetPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.GetPolicyRequest,
            com.google.cloud.designcenter.v1.Policy>
        getGetPolicyMethod;
    if ((getGetPolicyMethod = DesignCenterGrpc.getGetPolicyMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getGetPolicyMethod = DesignCenterGrpc.getGetPolicyMethod) == null) {
          DesignCenterGrpc.getGetPolicyMethod =
              getGetPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.GetPolicyRequest,
                          com.google.cloud.designcenter.v1.Policy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.GetPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(new DesignCenterMethodDescriptorSupplier("GetPolicy"))
                      .build();
        }
      }
    }
    return getGetPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ListPoliciesRequest,
          com.google.cloud.designcenter.v1.ListPoliciesResponse>
      getListPoliciesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPolicies",
      requestType = com.google.cloud.designcenter.v1.ListPoliciesRequest.class,
      responseType = com.google.cloud.designcenter.v1.ListPoliciesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ListPoliciesRequest,
          com.google.cloud.designcenter.v1.ListPoliciesResponse>
      getListPoliciesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.ListPoliciesRequest,
            com.google.cloud.designcenter.v1.ListPoliciesResponse>
        getListPoliciesMethod;
    if ((getListPoliciesMethod = DesignCenterGrpc.getListPoliciesMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getListPoliciesMethod = DesignCenterGrpc.getListPoliciesMethod) == null) {
          DesignCenterGrpc.getListPoliciesMethod =
              getListPoliciesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.ListPoliciesRequest,
                          com.google.cloud.designcenter.v1.ListPoliciesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPolicies"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.ListPoliciesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.ListPoliciesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new DesignCenterMethodDescriptorSupplier("ListPolicies"))
                      .build();
        }
      }
    }
    return getListPoliciesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.CreatePolicyRequest,
          com.google.cloud.designcenter.v1.Policy>
      getCreatePolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePolicy",
      requestType = com.google.cloud.designcenter.v1.CreatePolicyRequest.class,
      responseType = com.google.cloud.designcenter.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.CreatePolicyRequest,
          com.google.cloud.designcenter.v1.Policy>
      getCreatePolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.CreatePolicyRequest,
            com.google.cloud.designcenter.v1.Policy>
        getCreatePolicyMethod;
    if ((getCreatePolicyMethod = DesignCenterGrpc.getCreatePolicyMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getCreatePolicyMethod = DesignCenterGrpc.getCreatePolicyMethod) == null) {
          DesignCenterGrpc.getCreatePolicyMethod =
              getCreatePolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.CreatePolicyRequest,
                          com.google.cloud.designcenter.v1.Policy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreatePolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.CreatePolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(new DesignCenterMethodDescriptorSupplier("CreatePolicy"))
                      .build();
        }
      }
    }
    return getCreatePolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.UpdatePolicyRequest,
          com.google.cloud.designcenter.v1.Policy>
      getUpdatePolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePolicy",
      requestType = com.google.cloud.designcenter.v1.UpdatePolicyRequest.class,
      responseType = com.google.cloud.designcenter.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.UpdatePolicyRequest,
          com.google.cloud.designcenter.v1.Policy>
      getUpdatePolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.UpdatePolicyRequest,
            com.google.cloud.designcenter.v1.Policy>
        getUpdatePolicyMethod;
    if ((getUpdatePolicyMethod = DesignCenterGrpc.getUpdatePolicyMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getUpdatePolicyMethod = DesignCenterGrpc.getUpdatePolicyMethod) == null) {
          DesignCenterGrpc.getUpdatePolicyMethod =
              getUpdatePolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.UpdatePolicyRequest,
                          com.google.cloud.designcenter.v1.Policy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdatePolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.UpdatePolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(new DesignCenterMethodDescriptorSupplier("UpdatePolicy"))
                      .build();
        }
      }
    }
    return getUpdatePolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.DeletePolicyRequest, com.google.protobuf.Empty>
      getDeletePolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePolicy",
      requestType = com.google.cloud.designcenter.v1.DeletePolicyRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.DeletePolicyRequest, com.google.protobuf.Empty>
      getDeletePolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.DeletePolicyRequest, com.google.protobuf.Empty>
        getDeletePolicyMethod;
    if ((getDeletePolicyMethod = DesignCenterGrpc.getDeletePolicyMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getDeletePolicyMethod = DesignCenterGrpc.getDeletePolicyMethod) == null) {
          DesignCenterGrpc.getDeletePolicyMethod =
              getDeletePolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.DeletePolicyRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeletePolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.DeletePolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new DesignCenterMethodDescriptorSupplier("DeletePolicy"))
                      .build();
        }
      }
    }
    return getDeletePolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.FetchFrameworksRequest,
          com.google.cloud.designcenter.v1.FetchFrameworksResponse>
      getFetchFrameworksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchFrameworks",
      requestType = com.google.cloud.designcenter.v1.FetchFrameworksRequest.class,
      responseType = com.google.cloud.designcenter.v1.FetchFrameworksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.FetchFrameworksRequest,
          com.google.cloud.designcenter.v1.FetchFrameworksResponse>
      getFetchFrameworksMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.FetchFrameworksRequest,
            com.google.cloud.designcenter.v1.FetchFrameworksResponse>
        getFetchFrameworksMethod;
    if ((getFetchFrameworksMethod = DesignCenterGrpc.getFetchFrameworksMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getFetchFrameworksMethod = DesignCenterGrpc.getFetchFrameworksMethod) == null) {
          DesignCenterGrpc.getFetchFrameworksMethod =
              getFetchFrameworksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.FetchFrameworksRequest,
                          com.google.cloud.designcenter.v1.FetchFrameworksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FetchFrameworks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.FetchFrameworksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.FetchFrameworksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("FetchFrameworks"))
                      .build();
        }
      }
    }
    return getFetchFrameworksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GenerateApplicationIaCRequest,
          com.google.cloud.designcenter.v1.GenerateApplicationIaCResponse>
      getGenerateApplicationIaCMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateApplicationIaC",
      requestType = com.google.cloud.designcenter.v1.GenerateApplicationIaCRequest.class,
      responseType = com.google.cloud.designcenter.v1.GenerateApplicationIaCResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GenerateApplicationIaCRequest,
          com.google.cloud.designcenter.v1.GenerateApplicationIaCResponse>
      getGenerateApplicationIaCMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.GenerateApplicationIaCRequest,
            com.google.cloud.designcenter.v1.GenerateApplicationIaCResponse>
        getGenerateApplicationIaCMethod;
    if ((getGenerateApplicationIaCMethod = DesignCenterGrpc.getGenerateApplicationIaCMethod)
        == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getGenerateApplicationIaCMethod = DesignCenterGrpc.getGenerateApplicationIaCMethod)
            == null) {
          DesignCenterGrpc.getGenerateApplicationIaCMethod =
              getGenerateApplicationIaCMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.GenerateApplicationIaCRequest,
                          com.google.cloud.designcenter.v1.GenerateApplicationIaCResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GenerateApplicationIaC"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.GenerateApplicationIaCRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.GenerateApplicationIaCResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("GenerateApplicationIaC"))
                      .build();
        }
      }
    }
    return getGenerateApplicationIaCMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ExportApplicationIaCRequest,
          com.google.longrunning.Operation>
      getExportApplicationIaCMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportApplicationIaC",
      requestType = com.google.cloud.designcenter.v1.ExportApplicationIaCRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ExportApplicationIaCRequest,
          com.google.longrunning.Operation>
      getExportApplicationIaCMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.ExportApplicationIaCRequest,
            com.google.longrunning.Operation>
        getExportApplicationIaCMethod;
    if ((getExportApplicationIaCMethod = DesignCenterGrpc.getExportApplicationIaCMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getExportApplicationIaCMethod = DesignCenterGrpc.getExportApplicationIaCMethod)
            == null) {
          DesignCenterGrpc.getExportApplicationIaCMethod =
              getExportApplicationIaCMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.ExportApplicationIaCRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ExportApplicationIaC"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.ExportApplicationIaCRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("ExportApplicationIaC"))
                      .build();
        }
      }
    }
    return getExportApplicationIaCMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ImportApplicationTemplateIaCRequest,
          com.google.cloud.designcenter.v1.ImportApplicationTemplateIaCResponse>
      getImportApplicationTemplateIaCMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportApplicationTemplateIaC",
      requestType = com.google.cloud.designcenter.v1.ImportApplicationTemplateIaCRequest.class,
      responseType = com.google.cloud.designcenter.v1.ImportApplicationTemplateIaCResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ImportApplicationTemplateIaCRequest,
          com.google.cloud.designcenter.v1.ImportApplicationTemplateIaCResponse>
      getImportApplicationTemplateIaCMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.ImportApplicationTemplateIaCRequest,
            com.google.cloud.designcenter.v1.ImportApplicationTemplateIaCResponse>
        getImportApplicationTemplateIaCMethod;
    if ((getImportApplicationTemplateIaCMethod =
            DesignCenterGrpc.getImportApplicationTemplateIaCMethod)
        == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getImportApplicationTemplateIaCMethod =
                DesignCenterGrpc.getImportApplicationTemplateIaCMethod)
            == null) {
          DesignCenterGrpc.getImportApplicationTemplateIaCMethod =
              getImportApplicationTemplateIaCMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.ImportApplicationTemplateIaCRequest,
                          com.google.cloud.designcenter.v1.ImportApplicationTemplateIaCResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ImportApplicationTemplateIaC"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.ImportApplicationTemplateIaCRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.ImportApplicationTemplateIaCResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("ImportApplicationTemplateIaC"))
                      .build();
        }
      }
    }
    return getImportApplicationTemplateIaCMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.IngestApplicationTemplateIaCRequest,
          com.google.longrunning.Operation>
      getIngestApplicationTemplateIaCMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "IngestApplicationTemplateIaC",
      requestType = com.google.cloud.designcenter.v1.IngestApplicationTemplateIaCRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.IngestApplicationTemplateIaCRequest,
          com.google.longrunning.Operation>
      getIngestApplicationTemplateIaCMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.IngestApplicationTemplateIaCRequest,
            com.google.longrunning.Operation>
        getIngestApplicationTemplateIaCMethod;
    if ((getIngestApplicationTemplateIaCMethod =
            DesignCenterGrpc.getIngestApplicationTemplateIaCMethod)
        == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getIngestApplicationTemplateIaCMethod =
                DesignCenterGrpc.getIngestApplicationTemplateIaCMethod)
            == null) {
          DesignCenterGrpc.getIngestApplicationTemplateIaCMethod =
              getIngestApplicationTemplateIaCMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.IngestApplicationTemplateIaCRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "IngestApplicationTemplateIaC"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.IngestApplicationTemplateIaCRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("IngestApplicationTemplateIaC"))
                      .build();
        }
      }
    }
    return getIngestApplicationTemplateIaCMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ImportApplicationIaCRequest,
          com.google.cloud.designcenter.v1.ImportApplicationIaCResponse>
      getImportApplicationIaCMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportApplicationIaC",
      requestType = com.google.cloud.designcenter.v1.ImportApplicationIaCRequest.class,
      responseType = com.google.cloud.designcenter.v1.ImportApplicationIaCResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ImportApplicationIaCRequest,
          com.google.cloud.designcenter.v1.ImportApplicationIaCResponse>
      getImportApplicationIaCMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.ImportApplicationIaCRequest,
            com.google.cloud.designcenter.v1.ImportApplicationIaCResponse>
        getImportApplicationIaCMethod;
    if ((getImportApplicationIaCMethod = DesignCenterGrpc.getImportApplicationIaCMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getImportApplicationIaCMethod = DesignCenterGrpc.getImportApplicationIaCMethod)
            == null) {
          DesignCenterGrpc.getImportApplicationIaCMethod =
              getImportApplicationIaCMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.ImportApplicationIaCRequest,
                          com.google.cloud.designcenter.v1.ImportApplicationIaCResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ImportApplicationIaC"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.ImportApplicationIaCRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.ImportApplicationIaCResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("ImportApplicationIaC"))
                      .build();
        }
      }
    }
    return getImportApplicationIaCMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.RegisterAppHubApplicationResourcesRequest,
          com.google.longrunning.Operation>
      getRegisterAppHubApplicationResourcesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RegisterAppHubApplicationResources",
      requestType =
          com.google.cloud.designcenter.v1.RegisterAppHubApplicationResourcesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.RegisterAppHubApplicationResourcesRequest,
          com.google.longrunning.Operation>
      getRegisterAppHubApplicationResourcesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.RegisterAppHubApplicationResourcesRequest,
            com.google.longrunning.Operation>
        getRegisterAppHubApplicationResourcesMethod;
    if ((getRegisterAppHubApplicationResourcesMethod =
            DesignCenterGrpc.getRegisterAppHubApplicationResourcesMethod)
        == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getRegisterAppHubApplicationResourcesMethod =
                DesignCenterGrpc.getRegisterAppHubApplicationResourcesMethod)
            == null) {
          DesignCenterGrpc.getRegisterAppHubApplicationResourcesMethod =
              getRegisterAppHubApplicationResourcesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.RegisterAppHubApplicationResourcesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "RegisterAppHubApplicationResources"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1
                                  .RegisterAppHubApplicationResourcesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier(
                              "RegisterAppHubApplicationResources"))
                      .build();
        }
      }
    }
    return getRegisterAppHubApplicationResourcesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ListApplicationTemplateSystemRevisionsRequest,
          com.google.cloud.designcenter.v1.ListApplicationTemplateSystemRevisionsResponse>
      getListApplicationTemplateSystemRevisionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListApplicationTemplateSystemRevisions",
      requestType =
          com.google.cloud.designcenter.v1.ListApplicationTemplateSystemRevisionsRequest.class,
      responseType =
          com.google.cloud.designcenter.v1.ListApplicationTemplateSystemRevisionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.ListApplicationTemplateSystemRevisionsRequest,
          com.google.cloud.designcenter.v1.ListApplicationTemplateSystemRevisionsResponse>
      getListApplicationTemplateSystemRevisionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.ListApplicationTemplateSystemRevisionsRequest,
            com.google.cloud.designcenter.v1.ListApplicationTemplateSystemRevisionsResponse>
        getListApplicationTemplateSystemRevisionsMethod;
    if ((getListApplicationTemplateSystemRevisionsMethod =
            DesignCenterGrpc.getListApplicationTemplateSystemRevisionsMethod)
        == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getListApplicationTemplateSystemRevisionsMethod =
                DesignCenterGrpc.getListApplicationTemplateSystemRevisionsMethod)
            == null) {
          DesignCenterGrpc.getListApplicationTemplateSystemRevisionsMethod =
              getListApplicationTemplateSystemRevisionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1
                              .ListApplicationTemplateSystemRevisionsRequest,
                          com.google.cloud.designcenter.v1
                              .ListApplicationTemplateSystemRevisionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "ListApplicationTemplateSystemRevisions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1
                                  .ListApplicationTemplateSystemRevisionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1
                                  .ListApplicationTemplateSystemRevisionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier(
                              "ListApplicationTemplateSystemRevisions"))
                      .build();
        }
      }
    }
    return getListApplicationTemplateSystemRevisionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GetApplicationTemplateSystemRevisionRequest,
          com.google.cloud.designcenter.v1.ApplicationTemplateSystemRevision>
      getGetApplicationTemplateSystemRevisionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetApplicationTemplateSystemRevision",
      requestType =
          com.google.cloud.designcenter.v1.GetApplicationTemplateSystemRevisionRequest.class,
      responseType = com.google.cloud.designcenter.v1.ApplicationTemplateSystemRevision.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.GetApplicationTemplateSystemRevisionRequest,
          com.google.cloud.designcenter.v1.ApplicationTemplateSystemRevision>
      getGetApplicationTemplateSystemRevisionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.GetApplicationTemplateSystemRevisionRequest,
            com.google.cloud.designcenter.v1.ApplicationTemplateSystemRevision>
        getGetApplicationTemplateSystemRevisionMethod;
    if ((getGetApplicationTemplateSystemRevisionMethod =
            DesignCenterGrpc.getGetApplicationTemplateSystemRevisionMethod)
        == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getGetApplicationTemplateSystemRevisionMethod =
                DesignCenterGrpc.getGetApplicationTemplateSystemRevisionMethod)
            == null) {
          DesignCenterGrpc.getGetApplicationTemplateSystemRevisionMethod =
              getGetApplicationTemplateSystemRevisionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1
                              .GetApplicationTemplateSystemRevisionRequest,
                          com.google.cloud.designcenter.v1.ApplicationTemplateSystemRevision>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "GetApplicationTemplateSystemRevision"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1
                                  .GetApplicationTemplateSystemRevisionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.ApplicationTemplateSystemRevision
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier(
                              "GetApplicationTemplateSystemRevision"))
                      .build();
        }
      }
    }
    return getGetApplicationTemplateSystemRevisionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.RecommendIAMRolesRequest,
          com.google.longrunning.Operation>
      getRecommendIAMRolesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RecommendIAMRoles",
      requestType = com.google.cloud.designcenter.v1.RecommendIAMRolesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.designcenter.v1.RecommendIAMRolesRequest,
          com.google.longrunning.Operation>
      getRecommendIAMRolesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.designcenter.v1.RecommendIAMRolesRequest,
            com.google.longrunning.Operation>
        getRecommendIAMRolesMethod;
    if ((getRecommendIAMRolesMethod = DesignCenterGrpc.getRecommendIAMRolesMethod) == null) {
      synchronized (DesignCenterGrpc.class) {
        if ((getRecommendIAMRolesMethod = DesignCenterGrpc.getRecommendIAMRolesMethod) == null) {
          DesignCenterGrpc.getRecommendIAMRolesMethod =
              getRecommendIAMRolesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.designcenter.v1.RecommendIAMRolesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RecommendIAMRoles"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.designcenter.v1.RecommendIAMRolesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DesignCenterMethodDescriptorSupplier("RecommendIAMRoles"))
                      .build();
        }
      }
    }
    return getRecommendIAMRolesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DesignCenterStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DesignCenterStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DesignCenterStub>() {
          @java.lang.Override
          public DesignCenterStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DesignCenterStub(channel, callOptions);
          }
        };
    return DesignCenterStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static DesignCenterBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DesignCenterBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DesignCenterBlockingV2Stub>() {
          @java.lang.Override
          public DesignCenterBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DesignCenterBlockingV2Stub(channel, callOptions);
          }
        };
    return DesignCenterBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DesignCenterBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DesignCenterBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DesignCenterBlockingStub>() {
          @java.lang.Override
          public DesignCenterBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DesignCenterBlockingStub(channel, callOptions);
          }
        };
    return DesignCenterBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DesignCenterFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DesignCenterFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DesignCenterFutureStub>() {
          @java.lang.Override
          public DesignCenterFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DesignCenterFutureStub(channel, callOptions);
          }
        };
    return DesignCenterFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Gets details about a space.
     * </pre>
     */
    default void getSpace(
        com.google.cloud.designcenter.v1.GetSpaceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Space> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSpaceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists spaces in a given project and location.
     * </pre>
     */
    default void listSpaces(
        com.google.cloud.designcenter.v1.ListSpacesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ListSpacesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListSpacesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a space.
     * </pre>
     */
    default void createSpace(
        com.google.cloud.designcenter.v1.CreateSpaceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Space> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSpaceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a space.
     * </pre>
     */
    default void updateSpace(
        com.google.cloud.designcenter.v1.UpdateSpaceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Space> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSpaceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a space.
     * </pre>
     */
    default void deleteSpace(
        com.google.cloud.designcenter.v1.DeleteSpaceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSpaceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about an application template.
     * </pre>
     */
    default void getApplicationTemplate(
        com.google.cloud.designcenter.v1.GetApplicationTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ApplicationTemplate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetApplicationTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists application templates in a given space.
     * </pre>
     */
    default void listApplicationTemplates(
        com.google.cloud.designcenter.v1.ListApplicationTemplatesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.designcenter.v1.ListApplicationTemplatesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListApplicationTemplatesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an application template.
     * </pre>
     */
    default void createApplicationTemplate(
        com.google.cloud.designcenter.v1.CreateApplicationTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ApplicationTemplate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateApplicationTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an application template.
     * </pre>
     */
    default void updateApplicationTemplate(
        com.google.cloud.designcenter.v1.UpdateApplicationTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ApplicationTemplate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateApplicationTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports to an existing application template from a given shared template.
     * </pre>
     */
    default void importApplicationTemplate(
        com.google.cloud.designcenter.v1.ImportApplicationTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ApplicationTemplate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getImportApplicationTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an application template.
     * </pre>
     */
    default void deleteApplicationTemplate(
        com.google.cloud.designcenter.v1.DeleteApplicationTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteApplicationTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Commits an application template to create a new revision.
     * </pre>
     */
    default void commitApplicationTemplate(
        com.google.cloud.designcenter.v1.CommitApplicationTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ApplicationTemplateRevision>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCommitApplicationTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Snapshots an application template to create a new revision asynchronously.
     * </pre>
     */
    default void snapshotApplicationTemplate(
        com.google.cloud.designcenter.v1.SnapshotApplicationTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSnapshotApplicationTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates Terraform files for an application template.
     * This is a SYNCHRONOUS operation and returns the generated IaC
     * directly in the response. It
     * does NOT download external module sources; it only uses remote sources.
     * </pre>
     */
    default void generateApplicationTemplateIaC(
        com.google.cloud.designcenter.v1.GenerateApplicationTemplateIaCRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.designcenter.v1.GenerateApplicationTemplateIaCResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateApplicationTemplateIaCMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports Terraform files for an application template. The generated
     * modules can have remote sources or local sources downloaded from remote.
     * This is an ASYNCHRONOUS operation that returns a Long Running Operation.
     * </pre>
     */
    default void exportApplicationTemplateIaC(
        com.google.cloud.designcenter.v1.ExportApplicationTemplateIaCRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getExportApplicationTemplateIaCMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates Terraform files for an application template revision.
     * This is a SYNCHRONOUS operation and returns the generated IaC
     * directly in the response. It
     * does NOT download external module sources; it only uses remote sources.
     * </pre>
     */
    default void generateApplicationTemplateRevisionIaC(
        com.google.cloud.designcenter.v1.GenerateApplicationTemplateRevisionIaCRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.designcenter.v1.GenerateApplicationTemplateRevisionIaCResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateApplicationTemplateRevisionIaCMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports Terraform files for an application template revision. The generated
     * modules can have remote sources or local sources downloaded from remote.
     * This is an ASYNCHRONOUS operation that returns a Long Running Operation.
     * </pre>
     */
    default void exportApplicationTemplateRevisionIaC(
        com.google.cloud.designcenter.v1.ExportApplicationTemplateRevisionIaCRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getExportApplicationTemplateRevisionIaCMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a Component.
     * </pre>
     */
    default void getComponent(
        com.google.cloud.designcenter.v1.GetComponentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Component> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetComponentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists components in an application template.
     * </pre>
     */
    default void listComponents(
        com.google.cloud.designcenter.v1.ListComponentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ListComponentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListComponentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a component.
     * </pre>
     */
    default void createComponent(
        com.google.cloud.designcenter.v1.CreateComponentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Component> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateComponentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a component.
     * </pre>
     */
    default void updateComponent(
        com.google.cloud.designcenter.v1.UpdateComponentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Component> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateComponentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a component.
     * </pre>
     */
    default void deleteComponent(
        com.google.cloud.designcenter.v1.DeleteComponentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteComponentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a connection.
     * </pre>
     */
    default void getConnection(
        com.google.cloud.designcenter.v1.GetConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Connection> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetConnectionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists connections in an application template.
     * </pre>
     */
    default void listConnections(
        com.google.cloud.designcenter.v1.ListConnectionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ListConnectionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListConnectionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a connection.
     * </pre>
     */
    default void createConnection(
        com.google.cloud.designcenter.v1.CreateConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Connection> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateConnectionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a connection.
     * </pre>
     */
    default void updateConnection(
        com.google.cloud.designcenter.v1.UpdateConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Connection> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateConnectionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a connection.
     * </pre>
     */
    default void deleteConnection(
        com.google.cloud.designcenter.v1.DeleteConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteConnectionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about an application template revision.
     * </pre>
     */
    default void getApplicationTemplateRevision(
        com.google.cloud.designcenter.v1.GetApplicationTemplateRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ApplicationTemplateRevision>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetApplicationTemplateRevisionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists application template revisions in a given application template.
     * </pre>
     */
    default void listApplicationTemplateRevisions(
        com.google.cloud.designcenter.v1.ListApplicationTemplateRevisionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.designcenter.v1.ListApplicationTemplateRevisionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListApplicationTemplateRevisionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an application template revision.
     * </pre>
     */
    default void deleteApplicationTemplateRevision(
        com.google.cloud.designcenter.v1.DeleteApplicationTemplateRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteApplicationTemplateRevisionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a catalog.
     * </pre>
     */
    default void getCatalog(
        com.google.cloud.designcenter.v1.GetCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Catalog> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCatalogMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists catalogs in a given space.
     * </pre>
     */
    default void listCatalogs(
        com.google.cloud.designcenter.v1.ListCatalogsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ListCatalogsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCatalogsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a catalog.
     * </pre>
     */
    default void createCatalog(
        com.google.cloud.designcenter.v1.CreateCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Catalog> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateCatalogMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a catalog.
     * </pre>
     */
    default void updateCatalog(
        com.google.cloud.designcenter.v1.UpdateCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Catalog> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateCatalogMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a catalog.
     * </pre>
     */
    default void deleteCatalog(
        com.google.cloud.designcenter.v1.DeleteCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteCatalogMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds a template to a catalog.
     * </pre>
     */
    default void createCatalogTemplate(
        com.google.cloud.designcenter.v1.CreateCatalogTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.CatalogTemplate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateCatalogTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a catalog template.
     * </pre>
     */
    default void getCatalogTemplate(
        com.google.cloud.designcenter.v1.GetCatalogTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.CatalogTemplate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCatalogTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists catalog templates.
     * </pre>
     */
    default void listCatalogTemplates(
        com.google.cloud.designcenter.v1.ListCatalogTemplatesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ListCatalogTemplatesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCatalogTemplatesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a catalog template resource.
     * </pre>
     */
    default void updateCatalogTemplate(
        com.google.cloud.designcenter.v1.UpdateCatalogTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.CatalogTemplate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateCatalogTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a catalog template.
     * </pre>
     */
    default void deleteCatalogTemplate(
        com.google.cloud.designcenter.v1.DeleteCatalogTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteCatalogTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Shares a catalog from one space to another space.
     * </pre>
     */
    default void createShare(
        com.google.cloud.designcenter.v1.CreateShareRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateShareMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists catalog share objects for the space.
     * </pre>
     */
    default void listShares(
        com.google.cloud.designcenter.v1.ListSharesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ListSharesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListSharesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get catalog share object for the space.
     * </pre>
     */
    default void getShare(
        com.google.cloud.designcenter.v1.GetShareRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Share> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetShareMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a catalog share.
     * </pre>
     */
    default void deleteShare(
        com.google.cloud.designcenter.v1.DeleteShareRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteShareMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Synchronizes a share and updates the destination workspace to reflect.
     * reflect the most recent changes to the catalog.
     * </pre>
     */
    default void syncShare(
        com.google.cloud.designcenter.v1.SyncShareRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSyncShareMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a shared template.
     * </pre>
     */
    default void getSharedTemplate(
        com.google.cloud.designcenter.v1.GetSharedTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.SharedTemplate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSharedTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists shared templates in a given space.
     * </pre>
     */
    default void listSharedTemplates(
        com.google.cloud.designcenter.v1.ListSharedTemplatesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ListSharedTemplatesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSharedTemplatesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a shared template revision.
     * </pre>
     */
    default void getSharedTemplateRevision(
        com.google.cloud.designcenter.v1.GetSharedTemplateRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.SharedTemplateRevision>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSharedTemplateRevisionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists shared template revisions in a given space.
     * </pre>
     */
    default void listSharedTemplateRevisions(
        com.google.cloud.designcenter.v1.ListSharedTemplateRevisionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.designcenter.v1.ListSharedTemplateRevisionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSharedTemplateRevisionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a template revision.
     * </pre>
     */
    default void createCatalogTemplateRevision(
        com.google.cloud.designcenter.v1.CreateCatalogTemplateRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateCatalogTemplateRevisionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a template revision.
     * </pre>
     */
    default void getCatalogTemplateRevision(
        com.google.cloud.designcenter.v1.GetCatalogTemplateRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.CatalogTemplateRevision>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCatalogTemplateRevisionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists template revisions.
     * </pre>
     */
    default void listCatalogTemplateRevisions(
        com.google.cloud.designcenter.v1.ListCatalogTemplateRevisionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.designcenter.v1.ListCatalogTemplateRevisionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCatalogTemplateRevisionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a template revision.
     * </pre>
     */
    default void deleteCatalogTemplateRevision(
        com.google.cloud.designcenter.v1.DeleteCatalogTemplateRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteCatalogTemplateRevisionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an application.
     * </pre>
     */
    default void createApplication(
        com.google.cloud.designcenter.v1.CreateApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Application>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateApplicationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about an application.
     * </pre>
     */
    default void getApplication(
        com.google.cloud.designcenter.v1.GetApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Application>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetApplicationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists applications in a given space.
     * </pre>
     */
    default void listApplications(
        com.google.cloud.designcenter.v1.ListApplicationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ListApplicationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListApplicationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an application.
     * </pre>
     */
    default void updateApplication(
        com.google.cloud.designcenter.v1.UpdateApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Application>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateApplicationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an application.
     * </pre>
     */
    default void deleteApplication(
        com.google.cloud.designcenter.v1.DeleteApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteApplicationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deploys an application.
     * </pre>
     */
    default void deployApplication(
        com.google.cloud.designcenter.v1.DeployApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeployApplicationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Previews deployment of an application.
     * </pre>
     */
    default void previewApplication(
        com.google.cloud.designcenter.v1.PreviewApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getPreviewApplicationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches the assessment report of a deployed application if present.
     * </pre>
     */
    default void fetchApplicationAssessmentReport(
        com.google.cloud.designcenter.v1.FetchApplicationAssessmentReportRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.designcenter.v1.FetchApplicationAssessmentReportResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFetchApplicationAssessmentReportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generate Assessment Reports of an application.
     * </pre>
     */
    default void generateApplicationAssessmentReport(
        com.google.cloud.designcenter.v1.GenerateApplicationAssessmentReportRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateApplicationAssessmentReportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generate Assessment Reports of an application template.
     * </pre>
     */
    default void generateApplicationTemplateAssessmentReport(
        com.google.cloud.designcenter.v1.GenerateApplicationTemplateAssessmentReportRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateApplicationTemplateAssessmentReportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Use GenerateTerraformPlanAssessmentReport instead.
     * Generate a best practice report for a given Terraform plan.
     * </pre>
     */
    @java.lang.Deprecated
    default void generateAssessmentReport(
        com.google.cloud.designcenter.v1.GenerateAssessmentReportRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateAssessmentReportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generate a Terraform plan assessment report for a given Terraform plan.
     * </pre>
     */
    default void generateTerraformPlanAssessmentReport(
        com.google.cloud.designcenter.v1.GenerateTerraformPlanAssessmentReportRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateTerraformPlanAssessmentReportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Policy related APIs.
     * Get a policy for an application template.
     * </pre>
     */
    default void getPolicy(
        com.google.cloud.designcenter.v1.GetPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists policies for an application template.
     * </pre>
     */
    default void listPolicies(
        com.google.cloud.designcenter.v1.ListPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ListPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPoliciesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a policy for an application template.
     * </pre>
     */
    default void createPolicy(
        com.google.cloud.designcenter.v1.CreatePolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreatePolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a policy.
     * </pre>
     */
    default void updatePolicy(
        com.google.cloud.designcenter.v1.UpdatePolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdatePolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a policy.
     * </pre>
     */
    default void deletePolicy(
        com.google.cloud.designcenter.v1.DeletePolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeletePolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches all frameworks for assessment report.
     * </pre>
     */
    default void fetchFrameworks(
        com.google.cloud.designcenter.v1.FetchFrameworksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.FetchFrameworksResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFetchFrameworksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates Terraform files for an application.
     * </pre>
     */
    default void generateApplicationIaC(
        com.google.cloud.designcenter.v1.GenerateApplicationIaCRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.GenerateApplicationIaCResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateApplicationIaCMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports Terraform files for an application asynchronously.
     * </pre>
     */
    default void exportApplicationIaC(
        com.google.cloud.designcenter.v1.ExportApplicationIaCRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getExportApplicationIaCMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports IaC for an application template.
     * </pre>
     */
    default void importApplicationTemplateIaC(
        com.google.cloud.designcenter.v1.ImportApplicationTemplateIaCRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.designcenter.v1.ImportApplicationTemplateIaCResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getImportApplicationTemplateIaCMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Ingests IaC for an application template asynchronously.
     * </pre>
     */
    default void ingestApplicationTemplateIaC(
        com.google.cloud.designcenter.v1.IngestApplicationTemplateIaCRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getIngestApplicationTemplateIaCMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports IaC for an application resource.
     * </pre>
     */
    default void importApplicationIaC(
        com.google.cloud.designcenter.v1.ImportApplicationIaCRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ImportApplicationIaCResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getImportApplicationIaCMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Register deployed resources from terraform state file with App Hub
     * without needing a space.
     * </pre>
     */
    default void registerAppHubApplicationResources(
        com.google.cloud.designcenter.v1.RegisterAppHubApplicationResourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRegisterAppHubApplicationResourcesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists application template system revisions in a given application
     * template.
     * </pre>
     */
    default void listApplicationTemplateSystemRevisions(
        com.google.cloud.designcenter.v1.ListApplicationTemplateSystemRevisionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.designcenter.v1.ListApplicationTemplateSystemRevisionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListApplicationTemplateSystemRevisionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the given application template system revision.
     * </pre>
     */
    default void getApplicationTemplateSystemRevision(
        com.google.cloud.designcenter.v1.GetApplicationTemplateSystemRevisionRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.designcenter.v1.ApplicationTemplateSystemRevision>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetApplicationTemplateSystemRevisionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets recommended IAM roles for an application.
     * Evaluates the infrastructure resources defined by an application (including
     * its template configuration and parameters) to determine the set of IAM
     * roles and Google Cloud APIs that you must configure before you deploy
     * across target projects.
     * The operation is asynchronous and returns a `google.longrunning.Operation`.
     * Upon completion, the operation result contains a
     * `RecommendIAMRolesResponse` with project-level IAM role and API
     * recommendations.
     * </pre>
     */
    default void recommendIAMRoles(
        com.google.cloud.designcenter.v1.RecommendIAMRolesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRecommendIAMRolesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DesignCenter.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public abstract static class DesignCenterImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return DesignCenterGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DesignCenter.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class DesignCenterStub
      extends io.grpc.stub.AbstractAsyncStub<DesignCenterStub> {
    private DesignCenterStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DesignCenterStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DesignCenterStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a space.
     * </pre>
     */
    public void getSpace(
        com.google.cloud.designcenter.v1.GetSpaceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Space> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSpaceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists spaces in a given project and location.
     * </pre>
     */
    public void listSpaces(
        com.google.cloud.designcenter.v1.ListSpacesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ListSpacesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSpacesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a space.
     * </pre>
     */
    public void createSpace(
        com.google.cloud.designcenter.v1.CreateSpaceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Space> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSpaceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a space.
     * </pre>
     */
    public void updateSpace(
        com.google.cloud.designcenter.v1.UpdateSpaceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Space> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSpaceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a space.
     * </pre>
     */
    public void deleteSpace(
        com.google.cloud.designcenter.v1.DeleteSpaceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSpaceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about an application template.
     * </pre>
     */
    public void getApplicationTemplate(
        com.google.cloud.designcenter.v1.GetApplicationTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ApplicationTemplate>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetApplicationTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists application templates in a given space.
     * </pre>
     */
    public void listApplicationTemplates(
        com.google.cloud.designcenter.v1.ListApplicationTemplatesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.designcenter.v1.ListApplicationTemplatesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListApplicationTemplatesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an application template.
     * </pre>
     */
    public void createApplicationTemplate(
        com.google.cloud.designcenter.v1.CreateApplicationTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ApplicationTemplate>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateApplicationTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an application template.
     * </pre>
     */
    public void updateApplicationTemplate(
        com.google.cloud.designcenter.v1.UpdateApplicationTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ApplicationTemplate>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateApplicationTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports to an existing application template from a given shared template.
     * </pre>
     */
    public void importApplicationTemplate(
        com.google.cloud.designcenter.v1.ImportApplicationTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ApplicationTemplate>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportApplicationTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an application template.
     * </pre>
     */
    public void deleteApplicationTemplate(
        com.google.cloud.designcenter.v1.DeleteApplicationTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteApplicationTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Commits an application template to create a new revision.
     * </pre>
     */
    public void commitApplicationTemplate(
        com.google.cloud.designcenter.v1.CommitApplicationTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ApplicationTemplateRevision>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCommitApplicationTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Snapshots an application template to create a new revision asynchronously.
     * </pre>
     */
    public void snapshotApplicationTemplate(
        com.google.cloud.designcenter.v1.SnapshotApplicationTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSnapshotApplicationTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates Terraform files for an application template.
     * This is a SYNCHRONOUS operation and returns the generated IaC
     * directly in the response. It
     * does NOT download external module sources; it only uses remote sources.
     * </pre>
     */
    public void generateApplicationTemplateIaC(
        com.google.cloud.designcenter.v1.GenerateApplicationTemplateIaCRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.designcenter.v1.GenerateApplicationTemplateIaCResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateApplicationTemplateIaCMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports Terraform files for an application template. The generated
     * modules can have remote sources or local sources downloaded from remote.
     * This is an ASYNCHRONOUS operation that returns a Long Running Operation.
     * </pre>
     */
    public void exportApplicationTemplateIaC(
        com.google.cloud.designcenter.v1.ExportApplicationTemplateIaCRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportApplicationTemplateIaCMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates Terraform files for an application template revision.
     * This is a SYNCHRONOUS operation and returns the generated IaC
     * directly in the response. It
     * does NOT download external module sources; it only uses remote sources.
     * </pre>
     */
    public void generateApplicationTemplateRevisionIaC(
        com.google.cloud.designcenter.v1.GenerateApplicationTemplateRevisionIaCRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.designcenter.v1.GenerateApplicationTemplateRevisionIaCResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateApplicationTemplateRevisionIaCMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports Terraform files for an application template revision. The generated
     * modules can have remote sources or local sources downloaded from remote.
     * This is an ASYNCHRONOUS operation that returns a Long Running Operation.
     * </pre>
     */
    public void exportApplicationTemplateRevisionIaC(
        com.google.cloud.designcenter.v1.ExportApplicationTemplateRevisionIaCRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportApplicationTemplateRevisionIaCMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a Component.
     * </pre>
     */
    public void getComponent(
        com.google.cloud.designcenter.v1.GetComponentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Component> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetComponentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists components in an application template.
     * </pre>
     */
    public void listComponents(
        com.google.cloud.designcenter.v1.ListComponentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ListComponentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListComponentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a component.
     * </pre>
     */
    public void createComponent(
        com.google.cloud.designcenter.v1.CreateComponentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Component> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateComponentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a component.
     * </pre>
     */
    public void updateComponent(
        com.google.cloud.designcenter.v1.UpdateComponentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Component> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateComponentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a component.
     * </pre>
     */
    public void deleteComponent(
        com.google.cloud.designcenter.v1.DeleteComponentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteComponentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a connection.
     * </pre>
     */
    public void getConnection(
        com.google.cloud.designcenter.v1.GetConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Connection> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetConnectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists connections in an application template.
     * </pre>
     */
    public void listConnections(
        com.google.cloud.designcenter.v1.ListConnectionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ListConnectionsResponse>
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
     * Creates a connection.
     * </pre>
     */
    public void createConnection(
        com.google.cloud.designcenter.v1.CreateConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Connection> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateConnectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a connection.
     * </pre>
     */
    public void updateConnection(
        com.google.cloud.designcenter.v1.UpdateConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Connection> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateConnectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a connection.
     * </pre>
     */
    public void deleteConnection(
        com.google.cloud.designcenter.v1.DeleteConnectionRequest request,
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
     * Gets details about an application template revision.
     * </pre>
     */
    public void getApplicationTemplateRevision(
        com.google.cloud.designcenter.v1.GetApplicationTemplateRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ApplicationTemplateRevision>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetApplicationTemplateRevisionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists application template revisions in a given application template.
     * </pre>
     */
    public void listApplicationTemplateRevisions(
        com.google.cloud.designcenter.v1.ListApplicationTemplateRevisionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.designcenter.v1.ListApplicationTemplateRevisionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListApplicationTemplateRevisionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an application template revision.
     * </pre>
     */
    public void deleteApplicationTemplateRevision(
        com.google.cloud.designcenter.v1.DeleteApplicationTemplateRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteApplicationTemplateRevisionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a catalog.
     * </pre>
     */
    public void getCatalog(
        com.google.cloud.designcenter.v1.GetCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Catalog> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCatalogMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists catalogs in a given space.
     * </pre>
     */
    public void listCatalogs(
        com.google.cloud.designcenter.v1.ListCatalogsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ListCatalogsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCatalogsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a catalog.
     * </pre>
     */
    public void createCatalog(
        com.google.cloud.designcenter.v1.CreateCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Catalog> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCatalogMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a catalog.
     * </pre>
     */
    public void updateCatalog(
        com.google.cloud.designcenter.v1.UpdateCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Catalog> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCatalogMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a catalog.
     * </pre>
     */
    public void deleteCatalog(
        com.google.cloud.designcenter.v1.DeleteCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCatalogMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds a template to a catalog.
     * </pre>
     */
    public void createCatalogTemplate(
        com.google.cloud.designcenter.v1.CreateCatalogTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.CatalogTemplate>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCatalogTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a catalog template.
     * </pre>
     */
    public void getCatalogTemplate(
        com.google.cloud.designcenter.v1.GetCatalogTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.CatalogTemplate>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCatalogTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists catalog templates.
     * </pre>
     */
    public void listCatalogTemplates(
        com.google.cloud.designcenter.v1.ListCatalogTemplatesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ListCatalogTemplatesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCatalogTemplatesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a catalog template resource.
     * </pre>
     */
    public void updateCatalogTemplate(
        com.google.cloud.designcenter.v1.UpdateCatalogTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.CatalogTemplate>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCatalogTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a catalog template.
     * </pre>
     */
    public void deleteCatalogTemplate(
        com.google.cloud.designcenter.v1.DeleteCatalogTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCatalogTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Shares a catalog from one space to another space.
     * </pre>
     */
    public void createShare(
        com.google.cloud.designcenter.v1.CreateShareRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateShareMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists catalog share objects for the space.
     * </pre>
     */
    public void listShares(
        com.google.cloud.designcenter.v1.ListSharesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ListSharesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSharesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get catalog share object for the space.
     * </pre>
     */
    public void getShare(
        com.google.cloud.designcenter.v1.GetShareRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Share> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetShareMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a catalog share.
     * </pre>
     */
    public void deleteShare(
        com.google.cloud.designcenter.v1.DeleteShareRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteShareMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Synchronizes a share and updates the destination workspace to reflect.
     * reflect the most recent changes to the catalog.
     * </pre>
     */
    public void syncShare(
        com.google.cloud.designcenter.v1.SyncShareRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSyncShareMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a shared template.
     * </pre>
     */
    public void getSharedTemplate(
        com.google.cloud.designcenter.v1.GetSharedTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.SharedTemplate>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSharedTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists shared templates in a given space.
     * </pre>
     */
    public void listSharedTemplates(
        com.google.cloud.designcenter.v1.ListSharedTemplatesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ListSharedTemplatesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSharedTemplatesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a shared template revision.
     * </pre>
     */
    public void getSharedTemplateRevision(
        com.google.cloud.designcenter.v1.GetSharedTemplateRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.SharedTemplateRevision>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSharedTemplateRevisionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists shared template revisions in a given space.
     * </pre>
     */
    public void listSharedTemplateRevisions(
        com.google.cloud.designcenter.v1.ListSharedTemplateRevisionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.designcenter.v1.ListSharedTemplateRevisionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSharedTemplateRevisionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a template revision.
     * </pre>
     */
    public void createCatalogTemplateRevision(
        com.google.cloud.designcenter.v1.CreateCatalogTemplateRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCatalogTemplateRevisionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a template revision.
     * </pre>
     */
    public void getCatalogTemplateRevision(
        com.google.cloud.designcenter.v1.GetCatalogTemplateRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.CatalogTemplateRevision>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCatalogTemplateRevisionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists template revisions.
     * </pre>
     */
    public void listCatalogTemplateRevisions(
        com.google.cloud.designcenter.v1.ListCatalogTemplateRevisionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.designcenter.v1.ListCatalogTemplateRevisionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCatalogTemplateRevisionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a template revision.
     * </pre>
     */
    public void deleteCatalogTemplateRevision(
        com.google.cloud.designcenter.v1.DeleteCatalogTemplateRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCatalogTemplateRevisionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an application.
     * </pre>
     */
    public void createApplication(
        com.google.cloud.designcenter.v1.CreateApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Application>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateApplicationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about an application.
     * </pre>
     */
    public void getApplication(
        com.google.cloud.designcenter.v1.GetApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Application>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetApplicationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists applications in a given space.
     * </pre>
     */
    public void listApplications(
        com.google.cloud.designcenter.v1.ListApplicationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ListApplicationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListApplicationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an application.
     * </pre>
     */
    public void updateApplication(
        com.google.cloud.designcenter.v1.UpdateApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Application>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateApplicationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an application.
     * </pre>
     */
    public void deleteApplication(
        com.google.cloud.designcenter.v1.DeleteApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteApplicationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deploys an application.
     * </pre>
     */
    public void deployApplication(
        com.google.cloud.designcenter.v1.DeployApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeployApplicationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Previews deployment of an application.
     * </pre>
     */
    public void previewApplication(
        com.google.cloud.designcenter.v1.PreviewApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPreviewApplicationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches the assessment report of a deployed application if present.
     * </pre>
     */
    public void fetchApplicationAssessmentReport(
        com.google.cloud.designcenter.v1.FetchApplicationAssessmentReportRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.designcenter.v1.FetchApplicationAssessmentReportResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchApplicationAssessmentReportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generate Assessment Reports of an application.
     * </pre>
     */
    public void generateApplicationAssessmentReport(
        com.google.cloud.designcenter.v1.GenerateApplicationAssessmentReportRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateApplicationAssessmentReportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generate Assessment Reports of an application template.
     * </pre>
     */
    public void generateApplicationTemplateAssessmentReport(
        com.google.cloud.designcenter.v1.GenerateApplicationTemplateAssessmentReportRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel()
              .newCall(getGenerateApplicationTemplateAssessmentReportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Use GenerateTerraformPlanAssessmentReport instead.
     * Generate a best practice report for a given Terraform plan.
     * </pre>
     */
    @java.lang.Deprecated
    public void generateAssessmentReport(
        com.google.cloud.designcenter.v1.GenerateAssessmentReportRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateAssessmentReportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generate a Terraform plan assessment report for a given Terraform plan.
     * </pre>
     */
    public void generateTerraformPlanAssessmentReport(
        com.google.cloud.designcenter.v1.GenerateTerraformPlanAssessmentReportRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateTerraformPlanAssessmentReportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Policy related APIs.
     * Get a policy for an application template.
     * </pre>
     */
    public void getPolicy(
        com.google.cloud.designcenter.v1.GetPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists policies for an application template.
     * </pre>
     */
    public void listPolicies(
        com.google.cloud.designcenter.v1.ListPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ListPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPoliciesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a policy for an application template.
     * </pre>
     */
    public void createPolicy(
        com.google.cloud.designcenter.v1.CreatePolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a policy.
     * </pre>
     */
    public void updatePolicy(
        com.google.cloud.designcenter.v1.UpdatePolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a policy.
     * </pre>
     */
    public void deletePolicy(
        com.google.cloud.designcenter.v1.DeletePolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches all frameworks for assessment report.
     * </pre>
     */
    public void fetchFrameworks(
        com.google.cloud.designcenter.v1.FetchFrameworksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.FetchFrameworksResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchFrameworksMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates Terraform files for an application.
     * </pre>
     */
    public void generateApplicationIaC(
        com.google.cloud.designcenter.v1.GenerateApplicationIaCRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.GenerateApplicationIaCResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateApplicationIaCMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports Terraform files for an application asynchronously.
     * </pre>
     */
    public void exportApplicationIaC(
        com.google.cloud.designcenter.v1.ExportApplicationIaCRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportApplicationIaCMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports IaC for an application template.
     * </pre>
     */
    public void importApplicationTemplateIaC(
        com.google.cloud.designcenter.v1.ImportApplicationTemplateIaCRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.designcenter.v1.ImportApplicationTemplateIaCResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportApplicationTemplateIaCMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Ingests IaC for an application template asynchronously.
     * </pre>
     */
    public void ingestApplicationTemplateIaC(
        com.google.cloud.designcenter.v1.IngestApplicationTemplateIaCRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getIngestApplicationTemplateIaCMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports IaC for an application resource.
     * </pre>
     */
    public void importApplicationIaC(
        com.google.cloud.designcenter.v1.ImportApplicationIaCRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ImportApplicationIaCResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportApplicationIaCMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Register deployed resources from terraform state file with App Hub
     * without needing a space.
     * </pre>
     */
    public void registerAppHubApplicationResources(
        com.google.cloud.designcenter.v1.RegisterAppHubApplicationResourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRegisterAppHubApplicationResourcesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists application template system revisions in a given application
     * template.
     * </pre>
     */
    public void listApplicationTemplateSystemRevisions(
        com.google.cloud.designcenter.v1.ListApplicationTemplateSystemRevisionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.designcenter.v1.ListApplicationTemplateSystemRevisionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListApplicationTemplateSystemRevisionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the given application template system revision.
     * </pre>
     */
    public void getApplicationTemplateSystemRevision(
        com.google.cloud.designcenter.v1.GetApplicationTemplateSystemRevisionRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.designcenter.v1.ApplicationTemplateSystemRevision>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetApplicationTemplateSystemRevisionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets recommended IAM roles for an application.
     * Evaluates the infrastructure resources defined by an application (including
     * its template configuration and parameters) to determine the set of IAM
     * roles and Google Cloud APIs that you must configure before you deploy
     * across target projects.
     * The operation is asynchronous and returns a `google.longrunning.Operation`.
     * Upon completion, the operation result contains a
     * `RecommendIAMRolesResponse` with project-level IAM role and API
     * recommendations.
     * </pre>
     */
    public void recommendIAMRoles(
        com.google.cloud.designcenter.v1.RecommendIAMRolesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRecommendIAMRolesMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DesignCenter.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class DesignCenterBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<DesignCenterBlockingV2Stub> {
    private DesignCenterBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DesignCenterBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DesignCenterBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a space.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.Space getSpace(
        com.google.cloud.designcenter.v1.GetSpaceRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetSpaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists spaces in a given project and location.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ListSpacesResponse listSpaces(
        com.google.cloud.designcenter.v1.ListSpacesRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListSpacesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a space.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.Space createSpace(
        com.google.cloud.designcenter.v1.CreateSpaceRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateSpaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a space.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.Space updateSpace(
        com.google.cloud.designcenter.v1.UpdateSpaceRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateSpaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a space.
     * </pre>
     */
    public com.google.protobuf.Empty deleteSpace(
        com.google.cloud.designcenter.v1.DeleteSpaceRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteSpaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about an application template.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ApplicationTemplate getApplicationTemplate(
        com.google.cloud.designcenter.v1.GetApplicationTemplateRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetApplicationTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists application templates in a given space.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ListApplicationTemplatesResponse
        listApplicationTemplates(
            com.google.cloud.designcenter.v1.ListApplicationTemplatesRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListApplicationTemplatesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an application template.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ApplicationTemplate createApplicationTemplate(
        com.google.cloud.designcenter.v1.CreateApplicationTemplateRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateApplicationTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an application template.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ApplicationTemplate updateApplicationTemplate(
        com.google.cloud.designcenter.v1.UpdateApplicationTemplateRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateApplicationTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports to an existing application template from a given shared template.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ApplicationTemplate importApplicationTemplate(
        com.google.cloud.designcenter.v1.ImportApplicationTemplateRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getImportApplicationTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an application template.
     * </pre>
     */
    public com.google.protobuf.Empty deleteApplicationTemplate(
        com.google.cloud.designcenter.v1.DeleteApplicationTemplateRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteApplicationTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Commits an application template to create a new revision.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ApplicationTemplateRevision commitApplicationTemplate(
        com.google.cloud.designcenter.v1.CommitApplicationTemplateRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCommitApplicationTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Snapshots an application template to create a new revision asynchronously.
     * </pre>
     */
    public com.google.longrunning.Operation snapshotApplicationTemplate(
        com.google.cloud.designcenter.v1.SnapshotApplicationTemplateRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSnapshotApplicationTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generates Terraform files for an application template.
     * This is a SYNCHRONOUS operation and returns the generated IaC
     * directly in the response. It
     * does NOT download external module sources; it only uses remote sources.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.GenerateApplicationTemplateIaCResponse
        generateApplicationTemplateIaC(
            com.google.cloud.designcenter.v1.GenerateApplicationTemplateIaCRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGenerateApplicationTemplateIaCMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports Terraform files for an application template. The generated
     * modules can have remote sources or local sources downloaded from remote.
     * This is an ASYNCHRONOUS operation that returns a Long Running Operation.
     * </pre>
     */
    public com.google.longrunning.Operation exportApplicationTemplateIaC(
        com.google.cloud.designcenter.v1.ExportApplicationTemplateIaCRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getExportApplicationTemplateIaCMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generates Terraform files for an application template revision.
     * This is a SYNCHRONOUS operation and returns the generated IaC
     * directly in the response. It
     * does NOT download external module sources; it only uses remote sources.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.GenerateApplicationTemplateRevisionIaCResponse
        generateApplicationTemplateRevisionIaC(
            com.google.cloud.designcenter.v1.GenerateApplicationTemplateRevisionIaCRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(),
          getGenerateApplicationTemplateRevisionIaCMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Exports Terraform files for an application template revision. The generated
     * modules can have remote sources or local sources downloaded from remote.
     * This is an ASYNCHRONOUS operation that returns a Long Running Operation.
     * </pre>
     */
    public com.google.longrunning.Operation exportApplicationTemplateRevisionIaC(
        com.google.cloud.designcenter.v1.ExportApplicationTemplateRevisionIaCRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getExportApplicationTemplateRevisionIaCMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a Component.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.Component getComponent(
        com.google.cloud.designcenter.v1.GetComponentRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetComponentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists components in an application template.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ListComponentsResponse listComponents(
        com.google.cloud.designcenter.v1.ListComponentsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListComponentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a component.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.Component createComponent(
        com.google.cloud.designcenter.v1.CreateComponentRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateComponentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a component.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.Component updateComponent(
        com.google.cloud.designcenter.v1.UpdateComponentRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateComponentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a component.
     * </pre>
     */
    public com.google.protobuf.Empty deleteComponent(
        com.google.cloud.designcenter.v1.DeleteComponentRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteComponentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a connection.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.Connection getConnection(
        com.google.cloud.designcenter.v1.GetConnectionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetConnectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists connections in an application template.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ListConnectionsResponse listConnections(
        com.google.cloud.designcenter.v1.ListConnectionsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListConnectionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a connection.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.Connection createConnection(
        com.google.cloud.designcenter.v1.CreateConnectionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateConnectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a connection.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.Connection updateConnection(
        com.google.cloud.designcenter.v1.UpdateConnectionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateConnectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a connection.
     * </pre>
     */
    public com.google.protobuf.Empty deleteConnection(
        com.google.cloud.designcenter.v1.DeleteConnectionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteConnectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about an application template revision.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ApplicationTemplateRevision
        getApplicationTemplateRevision(
            com.google.cloud.designcenter.v1.GetApplicationTemplateRevisionRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetApplicationTemplateRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists application template revisions in a given application template.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ListApplicationTemplateRevisionsResponse
        listApplicationTemplateRevisions(
            com.google.cloud.designcenter.v1.ListApplicationTemplateRevisionsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListApplicationTemplateRevisionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an application template revision.
     * </pre>
     */
    public com.google.protobuf.Empty deleteApplicationTemplateRevision(
        com.google.cloud.designcenter.v1.DeleteApplicationTemplateRevisionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteApplicationTemplateRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a catalog.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.Catalog getCatalog(
        com.google.cloud.designcenter.v1.GetCatalogRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetCatalogMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists catalogs in a given space.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ListCatalogsResponse listCatalogs(
        com.google.cloud.designcenter.v1.ListCatalogsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListCatalogsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a catalog.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.Catalog createCatalog(
        com.google.cloud.designcenter.v1.CreateCatalogRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateCatalogMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a catalog.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.Catalog updateCatalog(
        com.google.cloud.designcenter.v1.UpdateCatalogRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateCatalogMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a catalog.
     * </pre>
     */
    public com.google.longrunning.Operation deleteCatalog(
        com.google.cloud.designcenter.v1.DeleteCatalogRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteCatalogMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Adds a template to a catalog.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.CatalogTemplate createCatalogTemplate(
        com.google.cloud.designcenter.v1.CreateCatalogTemplateRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateCatalogTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a catalog template.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.CatalogTemplate getCatalogTemplate(
        com.google.cloud.designcenter.v1.GetCatalogTemplateRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetCatalogTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists catalog templates.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ListCatalogTemplatesResponse listCatalogTemplates(
        com.google.cloud.designcenter.v1.ListCatalogTemplatesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListCatalogTemplatesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a catalog template resource.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.CatalogTemplate updateCatalogTemplate(
        com.google.cloud.designcenter.v1.UpdateCatalogTemplateRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateCatalogTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a catalog template.
     * </pre>
     */
    public com.google.longrunning.Operation deleteCatalogTemplate(
        com.google.cloud.designcenter.v1.DeleteCatalogTemplateRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteCatalogTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Shares a catalog from one space to another space.
     * </pre>
     */
    public com.google.longrunning.Operation createShare(
        com.google.cloud.designcenter.v1.CreateShareRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateShareMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists catalog share objects for the space.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ListSharesResponse listShares(
        com.google.cloud.designcenter.v1.ListSharesRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListSharesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get catalog share object for the space.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.Share getShare(
        com.google.cloud.designcenter.v1.GetShareRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetShareMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a catalog share.
     * </pre>
     */
    public com.google.longrunning.Operation deleteShare(
        com.google.cloud.designcenter.v1.DeleteShareRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteShareMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Synchronizes a share and updates the destination workspace to reflect.
     * reflect the most recent changes to the catalog.
     * </pre>
     */
    public com.google.longrunning.Operation syncShare(
        com.google.cloud.designcenter.v1.SyncShareRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSyncShareMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a shared template.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.SharedTemplate getSharedTemplate(
        com.google.cloud.designcenter.v1.GetSharedTemplateRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetSharedTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists shared templates in a given space.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ListSharedTemplatesResponse listSharedTemplates(
        com.google.cloud.designcenter.v1.ListSharedTemplatesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListSharedTemplatesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a shared template revision.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.SharedTemplateRevision getSharedTemplateRevision(
        com.google.cloud.designcenter.v1.GetSharedTemplateRevisionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetSharedTemplateRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists shared template revisions in a given space.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ListSharedTemplateRevisionsResponse
        listSharedTemplateRevisions(
            com.google.cloud.designcenter.v1.ListSharedTemplateRevisionsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListSharedTemplateRevisionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a template revision.
     * </pre>
     */
    public com.google.longrunning.Operation createCatalogTemplateRevision(
        com.google.cloud.designcenter.v1.CreateCatalogTemplateRevisionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateCatalogTemplateRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a template revision.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.CatalogTemplateRevision getCatalogTemplateRevision(
        com.google.cloud.designcenter.v1.GetCatalogTemplateRevisionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetCatalogTemplateRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists template revisions.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ListCatalogTemplateRevisionsResponse
        listCatalogTemplateRevisions(
            com.google.cloud.designcenter.v1.ListCatalogTemplateRevisionsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListCatalogTemplateRevisionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a template revision.
     * </pre>
     */
    public com.google.longrunning.Operation deleteCatalogTemplateRevision(
        com.google.cloud.designcenter.v1.DeleteCatalogTemplateRevisionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteCatalogTemplateRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an application.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.Application createApplication(
        com.google.cloud.designcenter.v1.CreateApplicationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateApplicationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about an application.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.Application getApplication(
        com.google.cloud.designcenter.v1.GetApplicationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetApplicationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists applications in a given space.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ListApplicationsResponse listApplications(
        com.google.cloud.designcenter.v1.ListApplicationsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListApplicationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an application.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.Application updateApplication(
        com.google.cloud.designcenter.v1.UpdateApplicationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateApplicationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an application.
     * </pre>
     */
    public com.google.longrunning.Operation deleteApplication(
        com.google.cloud.designcenter.v1.DeleteApplicationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteApplicationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deploys an application.
     * </pre>
     */
    public com.google.longrunning.Operation deployApplication(
        com.google.cloud.designcenter.v1.DeployApplicationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeployApplicationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Previews deployment of an application.
     * </pre>
     */
    public com.google.longrunning.Operation previewApplication(
        com.google.cloud.designcenter.v1.PreviewApplicationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getPreviewApplicationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches the assessment report of a deployed application if present.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.FetchApplicationAssessmentReportResponse
        fetchApplicationAssessmentReport(
            com.google.cloud.designcenter.v1.FetchApplicationAssessmentReportRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getFetchApplicationAssessmentReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generate Assessment Reports of an application.
     * </pre>
     */
    public com.google.longrunning.Operation generateApplicationAssessmentReport(
        com.google.cloud.designcenter.v1.GenerateApplicationAssessmentReportRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGenerateApplicationAssessmentReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generate Assessment Reports of an application template.
     * </pre>
     */
    public com.google.longrunning.Operation generateApplicationTemplateAssessmentReport(
        com.google.cloud.designcenter.v1.GenerateApplicationTemplateAssessmentReportRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(),
          getGenerateApplicationTemplateAssessmentReportMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Use GenerateTerraformPlanAssessmentReport instead.
     * Generate a best practice report for a given Terraform plan.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.longrunning.Operation generateAssessmentReport(
        com.google.cloud.designcenter.v1.GenerateAssessmentReportRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGenerateAssessmentReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generate a Terraform plan assessment report for a given Terraform plan.
     * </pre>
     */
    public com.google.longrunning.Operation generateTerraformPlanAssessmentReport(
        com.google.cloud.designcenter.v1.GenerateTerraformPlanAssessmentReportRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(),
          getGenerateTerraformPlanAssessmentReportMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Policy related APIs.
     * Get a policy for an application template.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.Policy getPolicy(
        com.google.cloud.designcenter.v1.GetPolicyRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists policies for an application template.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ListPoliciesResponse listPolicies(
        com.google.cloud.designcenter.v1.ListPoliciesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListPoliciesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a policy for an application template.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.Policy createPolicy(
        com.google.cloud.designcenter.v1.CreatePolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreatePolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a policy.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.Policy updatePolicy(
        com.google.cloud.designcenter.v1.UpdatePolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdatePolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a policy.
     * </pre>
     */
    public com.google.protobuf.Empty deletePolicy(
        com.google.cloud.designcenter.v1.DeletePolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeletePolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches all frameworks for assessment report.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.FetchFrameworksResponse fetchFrameworks(
        com.google.cloud.designcenter.v1.FetchFrameworksRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getFetchFrameworksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generates Terraform files for an application.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.GenerateApplicationIaCResponse generateApplicationIaC(
        com.google.cloud.designcenter.v1.GenerateApplicationIaCRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGenerateApplicationIaCMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports Terraform files for an application asynchronously.
     * </pre>
     */
    public com.google.longrunning.Operation exportApplicationIaC(
        com.google.cloud.designcenter.v1.ExportApplicationIaCRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getExportApplicationIaCMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports IaC for an application template.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ImportApplicationTemplateIaCResponse
        importApplicationTemplateIaC(
            com.google.cloud.designcenter.v1.ImportApplicationTemplateIaCRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getImportApplicationTemplateIaCMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Ingests IaC for an application template asynchronously.
     * </pre>
     */
    public com.google.longrunning.Operation ingestApplicationTemplateIaC(
        com.google.cloud.designcenter.v1.IngestApplicationTemplateIaCRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getIngestApplicationTemplateIaCMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports IaC for an application resource.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ImportApplicationIaCResponse importApplicationIaC(
        com.google.cloud.designcenter.v1.ImportApplicationIaCRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getImportApplicationIaCMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Register deployed resources from terraform state file with App Hub
     * without needing a space.
     * </pre>
     */
    public com.google.longrunning.Operation registerAppHubApplicationResources(
        com.google.cloud.designcenter.v1.RegisterAppHubApplicationResourcesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRegisterAppHubApplicationResourcesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists application template system revisions in a given application
     * template.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ListApplicationTemplateSystemRevisionsResponse
        listApplicationTemplateSystemRevisions(
            com.google.cloud.designcenter.v1.ListApplicationTemplateSystemRevisionsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(),
          getListApplicationTemplateSystemRevisionsMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets the given application template system revision.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ApplicationTemplateSystemRevision
        getApplicationTemplateSystemRevision(
            com.google.cloud.designcenter.v1.GetApplicationTemplateSystemRevisionRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetApplicationTemplateSystemRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets recommended IAM roles for an application.
     * Evaluates the infrastructure resources defined by an application (including
     * its template configuration and parameters) to determine the set of IAM
     * roles and Google Cloud APIs that you must configure before you deploy
     * across target projects.
     * The operation is asynchronous and returns a `google.longrunning.Operation`.
     * Upon completion, the operation result contains a
     * `RecommendIAMRolesResponse` with project-level IAM role and API
     * recommendations.
     * </pre>
     */
    public com.google.longrunning.Operation recommendIAMRoles(
        com.google.cloud.designcenter.v1.RecommendIAMRolesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRecommendIAMRolesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service DesignCenter.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class DesignCenterBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DesignCenterBlockingStub> {
    private DesignCenterBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DesignCenterBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DesignCenterBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a space.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.Space getSpace(
        com.google.cloud.designcenter.v1.GetSpaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSpaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists spaces in a given project and location.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ListSpacesResponse listSpaces(
        com.google.cloud.designcenter.v1.ListSpacesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSpacesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a space.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.Space createSpace(
        com.google.cloud.designcenter.v1.CreateSpaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSpaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a space.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.Space updateSpace(
        com.google.cloud.designcenter.v1.UpdateSpaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSpaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a space.
     * </pre>
     */
    public com.google.protobuf.Empty deleteSpace(
        com.google.cloud.designcenter.v1.DeleteSpaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSpaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about an application template.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ApplicationTemplate getApplicationTemplate(
        com.google.cloud.designcenter.v1.GetApplicationTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetApplicationTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists application templates in a given space.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ListApplicationTemplatesResponse
        listApplicationTemplates(
            com.google.cloud.designcenter.v1.ListApplicationTemplatesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListApplicationTemplatesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an application template.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ApplicationTemplate createApplicationTemplate(
        com.google.cloud.designcenter.v1.CreateApplicationTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateApplicationTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an application template.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ApplicationTemplate updateApplicationTemplate(
        com.google.cloud.designcenter.v1.UpdateApplicationTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateApplicationTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports to an existing application template from a given shared template.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ApplicationTemplate importApplicationTemplate(
        com.google.cloud.designcenter.v1.ImportApplicationTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportApplicationTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an application template.
     * </pre>
     */
    public com.google.protobuf.Empty deleteApplicationTemplate(
        com.google.cloud.designcenter.v1.DeleteApplicationTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteApplicationTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Commits an application template to create a new revision.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ApplicationTemplateRevision commitApplicationTemplate(
        com.google.cloud.designcenter.v1.CommitApplicationTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCommitApplicationTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Snapshots an application template to create a new revision asynchronously.
     * </pre>
     */
    public com.google.longrunning.Operation snapshotApplicationTemplate(
        com.google.cloud.designcenter.v1.SnapshotApplicationTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSnapshotApplicationTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generates Terraform files for an application template.
     * This is a SYNCHRONOUS operation and returns the generated IaC
     * directly in the response. It
     * does NOT download external module sources; it only uses remote sources.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.GenerateApplicationTemplateIaCResponse
        generateApplicationTemplateIaC(
            com.google.cloud.designcenter.v1.GenerateApplicationTemplateIaCRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateApplicationTemplateIaCMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports Terraform files for an application template. The generated
     * modules can have remote sources or local sources downloaded from remote.
     * This is an ASYNCHRONOUS operation that returns a Long Running Operation.
     * </pre>
     */
    public com.google.longrunning.Operation exportApplicationTemplateIaC(
        com.google.cloud.designcenter.v1.ExportApplicationTemplateIaCRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportApplicationTemplateIaCMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generates Terraform files for an application template revision.
     * This is a SYNCHRONOUS operation and returns the generated IaC
     * directly in the response. It
     * does NOT download external module sources; it only uses remote sources.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.GenerateApplicationTemplateRevisionIaCResponse
        generateApplicationTemplateRevisionIaC(
            com.google.cloud.designcenter.v1.GenerateApplicationTemplateRevisionIaCRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getGenerateApplicationTemplateRevisionIaCMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Exports Terraform files for an application template revision. The generated
     * modules can have remote sources or local sources downloaded from remote.
     * This is an ASYNCHRONOUS operation that returns a Long Running Operation.
     * </pre>
     */
    public com.google.longrunning.Operation exportApplicationTemplateRevisionIaC(
        com.google.cloud.designcenter.v1.ExportApplicationTemplateRevisionIaCRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportApplicationTemplateRevisionIaCMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a Component.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.Component getComponent(
        com.google.cloud.designcenter.v1.GetComponentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetComponentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists components in an application template.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ListComponentsResponse listComponents(
        com.google.cloud.designcenter.v1.ListComponentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListComponentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a component.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.Component createComponent(
        com.google.cloud.designcenter.v1.CreateComponentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateComponentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a component.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.Component updateComponent(
        com.google.cloud.designcenter.v1.UpdateComponentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateComponentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a component.
     * </pre>
     */
    public com.google.protobuf.Empty deleteComponent(
        com.google.cloud.designcenter.v1.DeleteComponentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteComponentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a connection.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.Connection getConnection(
        com.google.cloud.designcenter.v1.GetConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetConnectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists connections in an application template.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ListConnectionsResponse listConnections(
        com.google.cloud.designcenter.v1.ListConnectionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListConnectionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a connection.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.Connection createConnection(
        com.google.cloud.designcenter.v1.CreateConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateConnectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a connection.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.Connection updateConnection(
        com.google.cloud.designcenter.v1.UpdateConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateConnectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a connection.
     * </pre>
     */
    public com.google.protobuf.Empty deleteConnection(
        com.google.cloud.designcenter.v1.DeleteConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteConnectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about an application template revision.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ApplicationTemplateRevision
        getApplicationTemplateRevision(
            com.google.cloud.designcenter.v1.GetApplicationTemplateRevisionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetApplicationTemplateRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists application template revisions in a given application template.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ListApplicationTemplateRevisionsResponse
        listApplicationTemplateRevisions(
            com.google.cloud.designcenter.v1.ListApplicationTemplateRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListApplicationTemplateRevisionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an application template revision.
     * </pre>
     */
    public com.google.protobuf.Empty deleteApplicationTemplateRevision(
        com.google.cloud.designcenter.v1.DeleteApplicationTemplateRevisionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteApplicationTemplateRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a catalog.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.Catalog getCatalog(
        com.google.cloud.designcenter.v1.GetCatalogRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCatalogMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists catalogs in a given space.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ListCatalogsResponse listCatalogs(
        com.google.cloud.designcenter.v1.ListCatalogsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCatalogsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a catalog.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.Catalog createCatalog(
        com.google.cloud.designcenter.v1.CreateCatalogRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCatalogMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a catalog.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.Catalog updateCatalog(
        com.google.cloud.designcenter.v1.UpdateCatalogRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCatalogMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a catalog.
     * </pre>
     */
    public com.google.longrunning.Operation deleteCatalog(
        com.google.cloud.designcenter.v1.DeleteCatalogRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCatalogMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Adds a template to a catalog.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.CatalogTemplate createCatalogTemplate(
        com.google.cloud.designcenter.v1.CreateCatalogTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCatalogTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a catalog template.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.CatalogTemplate getCatalogTemplate(
        com.google.cloud.designcenter.v1.GetCatalogTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCatalogTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists catalog templates.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ListCatalogTemplatesResponse listCatalogTemplates(
        com.google.cloud.designcenter.v1.ListCatalogTemplatesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCatalogTemplatesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a catalog template resource.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.CatalogTemplate updateCatalogTemplate(
        com.google.cloud.designcenter.v1.UpdateCatalogTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCatalogTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a catalog template.
     * </pre>
     */
    public com.google.longrunning.Operation deleteCatalogTemplate(
        com.google.cloud.designcenter.v1.DeleteCatalogTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCatalogTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Shares a catalog from one space to another space.
     * </pre>
     */
    public com.google.longrunning.Operation createShare(
        com.google.cloud.designcenter.v1.CreateShareRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateShareMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists catalog share objects for the space.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ListSharesResponse listShares(
        com.google.cloud.designcenter.v1.ListSharesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSharesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get catalog share object for the space.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.Share getShare(
        com.google.cloud.designcenter.v1.GetShareRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetShareMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a catalog share.
     * </pre>
     */
    public com.google.longrunning.Operation deleteShare(
        com.google.cloud.designcenter.v1.DeleteShareRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteShareMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Synchronizes a share and updates the destination workspace to reflect.
     * reflect the most recent changes to the catalog.
     * </pre>
     */
    public com.google.longrunning.Operation syncShare(
        com.google.cloud.designcenter.v1.SyncShareRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSyncShareMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a shared template.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.SharedTemplate getSharedTemplate(
        com.google.cloud.designcenter.v1.GetSharedTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSharedTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists shared templates in a given space.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ListSharedTemplatesResponse listSharedTemplates(
        com.google.cloud.designcenter.v1.ListSharedTemplatesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSharedTemplatesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a shared template revision.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.SharedTemplateRevision getSharedTemplateRevision(
        com.google.cloud.designcenter.v1.GetSharedTemplateRevisionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSharedTemplateRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists shared template revisions in a given space.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ListSharedTemplateRevisionsResponse
        listSharedTemplateRevisions(
            com.google.cloud.designcenter.v1.ListSharedTemplateRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSharedTemplateRevisionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a template revision.
     * </pre>
     */
    public com.google.longrunning.Operation createCatalogTemplateRevision(
        com.google.cloud.designcenter.v1.CreateCatalogTemplateRevisionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCatalogTemplateRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a template revision.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.CatalogTemplateRevision getCatalogTemplateRevision(
        com.google.cloud.designcenter.v1.GetCatalogTemplateRevisionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCatalogTemplateRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists template revisions.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ListCatalogTemplateRevisionsResponse
        listCatalogTemplateRevisions(
            com.google.cloud.designcenter.v1.ListCatalogTemplateRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCatalogTemplateRevisionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a template revision.
     * </pre>
     */
    public com.google.longrunning.Operation deleteCatalogTemplateRevision(
        com.google.cloud.designcenter.v1.DeleteCatalogTemplateRevisionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCatalogTemplateRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an application.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.Application createApplication(
        com.google.cloud.designcenter.v1.CreateApplicationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateApplicationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about an application.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.Application getApplication(
        com.google.cloud.designcenter.v1.GetApplicationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetApplicationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists applications in a given space.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ListApplicationsResponse listApplications(
        com.google.cloud.designcenter.v1.ListApplicationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListApplicationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an application.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.Application updateApplication(
        com.google.cloud.designcenter.v1.UpdateApplicationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateApplicationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an application.
     * </pre>
     */
    public com.google.longrunning.Operation deleteApplication(
        com.google.cloud.designcenter.v1.DeleteApplicationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteApplicationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deploys an application.
     * </pre>
     */
    public com.google.longrunning.Operation deployApplication(
        com.google.cloud.designcenter.v1.DeployApplicationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeployApplicationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Previews deployment of an application.
     * </pre>
     */
    public com.google.longrunning.Operation previewApplication(
        com.google.cloud.designcenter.v1.PreviewApplicationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPreviewApplicationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches the assessment report of a deployed application if present.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.FetchApplicationAssessmentReportResponse
        fetchApplicationAssessmentReport(
            com.google.cloud.designcenter.v1.FetchApplicationAssessmentReportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchApplicationAssessmentReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generate Assessment Reports of an application.
     * </pre>
     */
    public com.google.longrunning.Operation generateApplicationAssessmentReport(
        com.google.cloud.designcenter.v1.GenerateApplicationAssessmentReportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateApplicationAssessmentReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generate Assessment Reports of an application template.
     * </pre>
     */
    public com.google.longrunning.Operation generateApplicationTemplateAssessmentReport(
        com.google.cloud.designcenter.v1.GenerateApplicationTemplateAssessmentReportRequest
            request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getGenerateApplicationTemplateAssessmentReportMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Use GenerateTerraformPlanAssessmentReport instead.
     * Generate a best practice report for a given Terraform plan.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.longrunning.Operation generateAssessmentReport(
        com.google.cloud.designcenter.v1.GenerateAssessmentReportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateAssessmentReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generate a Terraform plan assessment report for a given Terraform plan.
     * </pre>
     */
    public com.google.longrunning.Operation generateTerraformPlanAssessmentReport(
        com.google.cloud.designcenter.v1.GenerateTerraformPlanAssessmentReportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getGenerateTerraformPlanAssessmentReportMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Policy related APIs.
     * Get a policy for an application template.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.Policy getPolicy(
        com.google.cloud.designcenter.v1.GetPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists policies for an application template.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ListPoliciesResponse listPolicies(
        com.google.cloud.designcenter.v1.ListPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPoliciesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a policy for an application template.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.Policy createPolicy(
        com.google.cloud.designcenter.v1.CreatePolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a policy.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.Policy updatePolicy(
        com.google.cloud.designcenter.v1.UpdatePolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a policy.
     * </pre>
     */
    public com.google.protobuf.Empty deletePolicy(
        com.google.cloud.designcenter.v1.DeletePolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches all frameworks for assessment report.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.FetchFrameworksResponse fetchFrameworks(
        com.google.cloud.designcenter.v1.FetchFrameworksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchFrameworksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generates Terraform files for an application.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.GenerateApplicationIaCResponse generateApplicationIaC(
        com.google.cloud.designcenter.v1.GenerateApplicationIaCRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateApplicationIaCMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports Terraform files for an application asynchronously.
     * </pre>
     */
    public com.google.longrunning.Operation exportApplicationIaC(
        com.google.cloud.designcenter.v1.ExportApplicationIaCRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportApplicationIaCMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports IaC for an application template.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ImportApplicationTemplateIaCResponse
        importApplicationTemplateIaC(
            com.google.cloud.designcenter.v1.ImportApplicationTemplateIaCRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportApplicationTemplateIaCMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Ingests IaC for an application template asynchronously.
     * </pre>
     */
    public com.google.longrunning.Operation ingestApplicationTemplateIaC(
        com.google.cloud.designcenter.v1.IngestApplicationTemplateIaCRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getIngestApplicationTemplateIaCMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports IaC for an application resource.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ImportApplicationIaCResponse importApplicationIaC(
        com.google.cloud.designcenter.v1.ImportApplicationIaCRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportApplicationIaCMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Register deployed resources from terraform state file with App Hub
     * without needing a space.
     * </pre>
     */
    public com.google.longrunning.Operation registerAppHubApplicationResources(
        com.google.cloud.designcenter.v1.RegisterAppHubApplicationResourcesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRegisterAppHubApplicationResourcesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists application template system revisions in a given application
     * template.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ListApplicationTemplateSystemRevisionsResponse
        listApplicationTemplateSystemRevisions(
            com.google.cloud.designcenter.v1.ListApplicationTemplateSystemRevisionsRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getListApplicationTemplateSystemRevisionsMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets the given application template system revision.
     * </pre>
     */
    public com.google.cloud.designcenter.v1.ApplicationTemplateSystemRevision
        getApplicationTemplateSystemRevision(
            com.google.cloud.designcenter.v1.GetApplicationTemplateSystemRevisionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetApplicationTemplateSystemRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets recommended IAM roles for an application.
     * Evaluates the infrastructure resources defined by an application (including
     * its template configuration and parameters) to determine the set of IAM
     * roles and Google Cloud APIs that you must configure before you deploy
     * across target projects.
     * The operation is asynchronous and returns a `google.longrunning.Operation`.
     * Upon completion, the operation result contains a
     * `RecommendIAMRolesResponse` with project-level IAM role and API
     * recommendations.
     * </pre>
     */
    public com.google.longrunning.Operation recommendIAMRoles(
        com.google.cloud.designcenter.v1.RecommendIAMRolesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRecommendIAMRolesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service DesignCenter.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class DesignCenterFutureStub
      extends io.grpc.stub.AbstractFutureStub<DesignCenterFutureStub> {
    private DesignCenterFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DesignCenterFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DesignCenterFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a space.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.Space>
        getSpace(com.google.cloud.designcenter.v1.GetSpaceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSpaceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists spaces in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.ListSpacesResponse>
        listSpaces(com.google.cloud.designcenter.v1.ListSpacesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSpacesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a space.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.Space>
        createSpace(com.google.cloud.designcenter.v1.CreateSpaceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSpaceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a space.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.Space>
        updateSpace(com.google.cloud.designcenter.v1.UpdateSpaceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSpaceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a space.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteSpace(com.google.cloud.designcenter.v1.DeleteSpaceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSpaceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about an application template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.ApplicationTemplate>
        getApplicationTemplate(
            com.google.cloud.designcenter.v1.GetApplicationTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetApplicationTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists application templates in a given space.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.ListApplicationTemplatesResponse>
        listApplicationTemplates(
            com.google.cloud.designcenter.v1.ListApplicationTemplatesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListApplicationTemplatesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an application template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.ApplicationTemplate>
        createApplicationTemplate(
            com.google.cloud.designcenter.v1.CreateApplicationTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateApplicationTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an application template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.ApplicationTemplate>
        updateApplicationTemplate(
            com.google.cloud.designcenter.v1.UpdateApplicationTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateApplicationTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Imports to an existing application template from a given shared template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.ApplicationTemplate>
        importApplicationTemplate(
            com.google.cloud.designcenter.v1.ImportApplicationTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportApplicationTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an application template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteApplicationTemplate(
            com.google.cloud.designcenter.v1.DeleteApplicationTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteApplicationTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Commits an application template to create a new revision.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.ApplicationTemplateRevision>
        commitApplicationTemplate(
            com.google.cloud.designcenter.v1.CommitApplicationTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCommitApplicationTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Snapshots an application template to create a new revision asynchronously.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        snapshotApplicationTemplate(
            com.google.cloud.designcenter.v1.SnapshotApplicationTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSnapshotApplicationTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Generates Terraform files for an application template.
     * This is a SYNCHRONOUS operation and returns the generated IaC
     * directly in the response. It
     * does NOT download external module sources; it only uses remote sources.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.GenerateApplicationTemplateIaCResponse>
        generateApplicationTemplateIaC(
            com.google.cloud.designcenter.v1.GenerateApplicationTemplateIaCRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateApplicationTemplateIaCMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Exports Terraform files for an application template. The generated
     * modules can have remote sources or local sources downloaded from remote.
     * This is an ASYNCHRONOUS operation that returns a Long Running Operation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportApplicationTemplateIaC(
            com.google.cloud.designcenter.v1.ExportApplicationTemplateIaCRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportApplicationTemplateIaCMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Generates Terraform files for an application template revision.
     * This is a SYNCHRONOUS operation and returns the generated IaC
     * directly in the response. It
     * does NOT download external module sources; it only uses remote sources.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.GenerateApplicationTemplateRevisionIaCResponse>
        generateApplicationTemplateRevisionIaC(
            com.google.cloud.designcenter.v1.GenerateApplicationTemplateRevisionIaCRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateApplicationTemplateRevisionIaCMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Exports Terraform files for an application template revision. The generated
     * modules can have remote sources or local sources downloaded from remote.
     * This is an ASYNCHRONOUS operation that returns a Long Running Operation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportApplicationTemplateRevisionIaC(
            com.google.cloud.designcenter.v1.ExportApplicationTemplateRevisionIaCRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportApplicationTemplateRevisionIaCMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a Component.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.Component>
        getComponent(com.google.cloud.designcenter.v1.GetComponentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetComponentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists components in an application template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.ListComponentsResponse>
        listComponents(com.google.cloud.designcenter.v1.ListComponentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListComponentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a component.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.Component>
        createComponent(com.google.cloud.designcenter.v1.CreateComponentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateComponentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a component.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.Component>
        updateComponent(com.google.cloud.designcenter.v1.UpdateComponentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateComponentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a component.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteComponent(com.google.cloud.designcenter.v1.DeleteComponentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteComponentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a connection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.Connection>
        getConnection(com.google.cloud.designcenter.v1.GetConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetConnectionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists connections in an application template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.ListConnectionsResponse>
        listConnections(com.google.cloud.designcenter.v1.ListConnectionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListConnectionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a connection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.Connection>
        createConnection(com.google.cloud.designcenter.v1.CreateConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateConnectionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a connection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.Connection>
        updateConnection(com.google.cloud.designcenter.v1.UpdateConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateConnectionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a connection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteConnection(com.google.cloud.designcenter.v1.DeleteConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteConnectionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about an application template revision.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.ApplicationTemplateRevision>
        getApplicationTemplateRevision(
            com.google.cloud.designcenter.v1.GetApplicationTemplateRevisionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetApplicationTemplateRevisionMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists application template revisions in a given application template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.ListApplicationTemplateRevisionsResponse>
        listApplicationTemplateRevisions(
            com.google.cloud.designcenter.v1.ListApplicationTemplateRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListApplicationTemplateRevisionsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an application template revision.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteApplicationTemplateRevision(
            com.google.cloud.designcenter.v1.DeleteApplicationTemplateRevisionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteApplicationTemplateRevisionMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a catalog.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.Catalog>
        getCatalog(com.google.cloud.designcenter.v1.GetCatalogRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCatalogMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists catalogs in a given space.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.ListCatalogsResponse>
        listCatalogs(com.google.cloud.designcenter.v1.ListCatalogsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCatalogsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a catalog.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.Catalog>
        createCatalog(com.google.cloud.designcenter.v1.CreateCatalogRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCatalogMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a catalog.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.Catalog>
        updateCatalog(com.google.cloud.designcenter.v1.UpdateCatalogRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCatalogMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a catalog.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteCatalog(com.google.cloud.designcenter.v1.DeleteCatalogRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCatalogMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Adds a template to a catalog.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.CatalogTemplate>
        createCatalogTemplate(
            com.google.cloud.designcenter.v1.CreateCatalogTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCatalogTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a catalog template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.CatalogTemplate>
        getCatalogTemplate(com.google.cloud.designcenter.v1.GetCatalogTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCatalogTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists catalog templates.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.ListCatalogTemplatesResponse>
        listCatalogTemplates(com.google.cloud.designcenter.v1.ListCatalogTemplatesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCatalogTemplatesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a catalog template resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.CatalogTemplate>
        updateCatalogTemplate(
            com.google.cloud.designcenter.v1.UpdateCatalogTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCatalogTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a catalog template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteCatalogTemplate(
            com.google.cloud.designcenter.v1.DeleteCatalogTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCatalogTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Shares a catalog from one space to another space.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createShare(com.google.cloud.designcenter.v1.CreateShareRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateShareMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists catalog share objects for the space.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.ListSharesResponse>
        listShares(com.google.cloud.designcenter.v1.ListSharesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSharesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get catalog share object for the space.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.Share>
        getShare(com.google.cloud.designcenter.v1.GetShareRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetShareMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a catalog share.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteShare(com.google.cloud.designcenter.v1.DeleteShareRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteShareMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Synchronizes a share and updates the destination workspace to reflect.
     * reflect the most recent changes to the catalog.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        syncShare(com.google.cloud.designcenter.v1.SyncShareRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSyncShareMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a shared template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.SharedTemplate>
        getSharedTemplate(com.google.cloud.designcenter.v1.GetSharedTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSharedTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists shared templates in a given space.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.ListSharedTemplatesResponse>
        listSharedTemplates(com.google.cloud.designcenter.v1.ListSharedTemplatesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSharedTemplatesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a shared template revision.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.SharedTemplateRevision>
        getSharedTemplateRevision(
            com.google.cloud.designcenter.v1.GetSharedTemplateRevisionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSharedTemplateRevisionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists shared template revisions in a given space.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.ListSharedTemplateRevisionsResponse>
        listSharedTemplateRevisions(
            com.google.cloud.designcenter.v1.ListSharedTemplateRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSharedTemplateRevisionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a template revision.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createCatalogTemplateRevision(
            com.google.cloud.designcenter.v1.CreateCatalogTemplateRevisionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCatalogTemplateRevisionMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a template revision.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.CatalogTemplateRevision>
        getCatalogTemplateRevision(
            com.google.cloud.designcenter.v1.GetCatalogTemplateRevisionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCatalogTemplateRevisionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists template revisions.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.ListCatalogTemplateRevisionsResponse>
        listCatalogTemplateRevisions(
            com.google.cloud.designcenter.v1.ListCatalogTemplateRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCatalogTemplateRevisionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a template revision.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteCatalogTemplateRevision(
            com.google.cloud.designcenter.v1.DeleteCatalogTemplateRevisionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCatalogTemplateRevisionMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Creates an application.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.Application>
        createApplication(com.google.cloud.designcenter.v1.CreateApplicationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateApplicationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about an application.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.Application>
        getApplication(com.google.cloud.designcenter.v1.GetApplicationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetApplicationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists applications in a given space.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.ListApplicationsResponse>
        listApplications(com.google.cloud.designcenter.v1.ListApplicationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListApplicationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an application.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.Application>
        updateApplication(com.google.cloud.designcenter.v1.UpdateApplicationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateApplicationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an application.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteApplication(com.google.cloud.designcenter.v1.DeleteApplicationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteApplicationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deploys an application.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deployApplication(com.google.cloud.designcenter.v1.DeployApplicationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeployApplicationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Previews deployment of an application.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        previewApplication(com.google.cloud.designcenter.v1.PreviewApplicationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPreviewApplicationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches the assessment report of a deployed application if present.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.FetchApplicationAssessmentReportResponse>
        fetchApplicationAssessmentReport(
            com.google.cloud.designcenter.v1.FetchApplicationAssessmentReportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchApplicationAssessmentReportMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Generate Assessment Reports of an application.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        generateApplicationAssessmentReport(
            com.google.cloud.designcenter.v1.GenerateApplicationAssessmentReportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateApplicationAssessmentReportMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Generate Assessment Reports of an application template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        generateApplicationTemplateAssessmentReport(
            com.google.cloud.designcenter.v1.GenerateApplicationTemplateAssessmentReportRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel()
              .newCall(getGenerateApplicationTemplateAssessmentReportMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Use GenerateTerraformPlanAssessmentReport instead.
     * Generate a best practice report for a given Terraform plan.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        generateAssessmentReport(
            com.google.cloud.designcenter.v1.GenerateAssessmentReportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateAssessmentReportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Generate a Terraform plan assessment report for a given Terraform plan.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        generateTerraformPlanAssessmentReport(
            com.google.cloud.designcenter.v1.GenerateTerraformPlanAssessmentReportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateTerraformPlanAssessmentReportMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Policy related APIs.
     * Get a policy for an application template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.Policy>
        getPolicy(com.google.cloud.designcenter.v1.GetPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists policies for an application template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.ListPoliciesResponse>
        listPolicies(com.google.cloud.designcenter.v1.ListPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPoliciesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a policy for an application template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.Policy>
        createPolicy(com.google.cloud.designcenter.v1.CreatePolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.Policy>
        updatePolicy(com.google.cloud.designcenter.v1.UpdatePolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deletePolicy(com.google.cloud.designcenter.v1.DeletePolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches all frameworks for assessment report.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.FetchFrameworksResponse>
        fetchFrameworks(com.google.cloud.designcenter.v1.FetchFrameworksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchFrameworksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Generates Terraform files for an application.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.GenerateApplicationIaCResponse>
        generateApplicationIaC(
            com.google.cloud.designcenter.v1.GenerateApplicationIaCRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateApplicationIaCMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Exports Terraform files for an application asynchronously.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportApplicationIaC(com.google.cloud.designcenter.v1.ExportApplicationIaCRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportApplicationIaCMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Imports IaC for an application template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.ImportApplicationTemplateIaCResponse>
        importApplicationTemplateIaC(
            com.google.cloud.designcenter.v1.ImportApplicationTemplateIaCRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportApplicationTemplateIaCMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Ingests IaC for an application template asynchronously.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        ingestApplicationTemplateIaC(
            com.google.cloud.designcenter.v1.IngestApplicationTemplateIaCRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getIngestApplicationTemplateIaCMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Imports IaC for an application resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.ImportApplicationIaCResponse>
        importApplicationIaC(com.google.cloud.designcenter.v1.ImportApplicationIaCRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportApplicationIaCMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Register deployed resources from terraform state file with App Hub
     * without needing a space.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        registerAppHubApplicationResources(
            com.google.cloud.designcenter.v1.RegisterAppHubApplicationResourcesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRegisterAppHubApplicationResourcesMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists application template system revisions in a given application
     * template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.ListApplicationTemplateSystemRevisionsResponse>
        listApplicationTemplateSystemRevisions(
            com.google.cloud.designcenter.v1.ListApplicationTemplateSystemRevisionsRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListApplicationTemplateSystemRevisionsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets the given application template system revision.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.designcenter.v1.ApplicationTemplateSystemRevision>
        getApplicationTemplateSystemRevision(
            com.google.cloud.designcenter.v1.GetApplicationTemplateSystemRevisionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetApplicationTemplateSystemRevisionMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets recommended IAM roles for an application.
     * Evaluates the infrastructure resources defined by an application (including
     * its template configuration and parameters) to determine the set of IAM
     * roles and Google Cloud APIs that you must configure before you deploy
     * across target projects.
     * The operation is asynchronous and returns a `google.longrunning.Operation`.
     * Upon completion, the operation result contains a
     * `RecommendIAMRolesResponse` with project-level IAM role and API
     * recommendations.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        recommendIAMRoles(com.google.cloud.designcenter.v1.RecommendIAMRolesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRecommendIAMRolesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_SPACE = 0;
  private static final int METHODID_LIST_SPACES = 1;
  private static final int METHODID_CREATE_SPACE = 2;
  private static final int METHODID_UPDATE_SPACE = 3;
  private static final int METHODID_DELETE_SPACE = 4;
  private static final int METHODID_GET_APPLICATION_TEMPLATE = 5;
  private static final int METHODID_LIST_APPLICATION_TEMPLATES = 6;
  private static final int METHODID_CREATE_APPLICATION_TEMPLATE = 7;
  private static final int METHODID_UPDATE_APPLICATION_TEMPLATE = 8;
  private static final int METHODID_IMPORT_APPLICATION_TEMPLATE = 9;
  private static final int METHODID_DELETE_APPLICATION_TEMPLATE = 10;
  private static final int METHODID_COMMIT_APPLICATION_TEMPLATE = 11;
  private static final int METHODID_SNAPSHOT_APPLICATION_TEMPLATE = 12;
  private static final int METHODID_GENERATE_APPLICATION_TEMPLATE_IA_C = 13;
  private static final int METHODID_EXPORT_APPLICATION_TEMPLATE_IA_C = 14;
  private static final int METHODID_GENERATE_APPLICATION_TEMPLATE_REVISION_IA_C = 15;
  private static final int METHODID_EXPORT_APPLICATION_TEMPLATE_REVISION_IA_C = 16;
  private static final int METHODID_GET_COMPONENT = 17;
  private static final int METHODID_LIST_COMPONENTS = 18;
  private static final int METHODID_CREATE_COMPONENT = 19;
  private static final int METHODID_UPDATE_COMPONENT = 20;
  private static final int METHODID_DELETE_COMPONENT = 21;
  private static final int METHODID_GET_CONNECTION = 22;
  private static final int METHODID_LIST_CONNECTIONS = 23;
  private static final int METHODID_CREATE_CONNECTION = 24;
  private static final int METHODID_UPDATE_CONNECTION = 25;
  private static final int METHODID_DELETE_CONNECTION = 26;
  private static final int METHODID_GET_APPLICATION_TEMPLATE_REVISION = 27;
  private static final int METHODID_LIST_APPLICATION_TEMPLATE_REVISIONS = 28;
  private static final int METHODID_DELETE_APPLICATION_TEMPLATE_REVISION = 29;
  private static final int METHODID_GET_CATALOG = 30;
  private static final int METHODID_LIST_CATALOGS = 31;
  private static final int METHODID_CREATE_CATALOG = 32;
  private static final int METHODID_UPDATE_CATALOG = 33;
  private static final int METHODID_DELETE_CATALOG = 34;
  private static final int METHODID_CREATE_CATALOG_TEMPLATE = 35;
  private static final int METHODID_GET_CATALOG_TEMPLATE = 36;
  private static final int METHODID_LIST_CATALOG_TEMPLATES = 37;
  private static final int METHODID_UPDATE_CATALOG_TEMPLATE = 38;
  private static final int METHODID_DELETE_CATALOG_TEMPLATE = 39;
  private static final int METHODID_CREATE_SHARE = 40;
  private static final int METHODID_LIST_SHARES = 41;
  private static final int METHODID_GET_SHARE = 42;
  private static final int METHODID_DELETE_SHARE = 43;
  private static final int METHODID_SYNC_SHARE = 44;
  private static final int METHODID_GET_SHARED_TEMPLATE = 45;
  private static final int METHODID_LIST_SHARED_TEMPLATES = 46;
  private static final int METHODID_GET_SHARED_TEMPLATE_REVISION = 47;
  private static final int METHODID_LIST_SHARED_TEMPLATE_REVISIONS = 48;
  private static final int METHODID_CREATE_CATALOG_TEMPLATE_REVISION = 49;
  private static final int METHODID_GET_CATALOG_TEMPLATE_REVISION = 50;
  private static final int METHODID_LIST_CATALOG_TEMPLATE_REVISIONS = 51;
  private static final int METHODID_DELETE_CATALOG_TEMPLATE_REVISION = 52;
  private static final int METHODID_CREATE_APPLICATION = 53;
  private static final int METHODID_GET_APPLICATION = 54;
  private static final int METHODID_LIST_APPLICATIONS = 55;
  private static final int METHODID_UPDATE_APPLICATION = 56;
  private static final int METHODID_DELETE_APPLICATION = 57;
  private static final int METHODID_DEPLOY_APPLICATION = 58;
  private static final int METHODID_PREVIEW_APPLICATION = 59;
  private static final int METHODID_FETCH_APPLICATION_ASSESSMENT_REPORT = 60;
  private static final int METHODID_GENERATE_APPLICATION_ASSESSMENT_REPORT = 61;
  private static final int METHODID_GENERATE_APPLICATION_TEMPLATE_ASSESSMENT_REPORT = 62;
  private static final int METHODID_GENERATE_ASSESSMENT_REPORT = 63;
  private static final int METHODID_GENERATE_TERRAFORM_PLAN_ASSESSMENT_REPORT = 64;
  private static final int METHODID_GET_POLICY = 65;
  private static final int METHODID_LIST_POLICIES = 66;
  private static final int METHODID_CREATE_POLICY = 67;
  private static final int METHODID_UPDATE_POLICY = 68;
  private static final int METHODID_DELETE_POLICY = 69;
  private static final int METHODID_FETCH_FRAMEWORKS = 70;
  private static final int METHODID_GENERATE_APPLICATION_IA_C = 71;
  private static final int METHODID_EXPORT_APPLICATION_IA_C = 72;
  private static final int METHODID_IMPORT_APPLICATION_TEMPLATE_IA_C = 73;
  private static final int METHODID_INGEST_APPLICATION_TEMPLATE_IA_C = 74;
  private static final int METHODID_IMPORT_APPLICATION_IA_C = 75;
  private static final int METHODID_REGISTER_APP_HUB_APPLICATION_RESOURCES = 76;
  private static final int METHODID_LIST_APPLICATION_TEMPLATE_SYSTEM_REVISIONS = 77;
  private static final int METHODID_GET_APPLICATION_TEMPLATE_SYSTEM_REVISION = 78;
  private static final int METHODID_RECOMMEND_IAMROLES = 79;

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
        case METHODID_GET_SPACE:
          serviceImpl.getSpace(
              (com.google.cloud.designcenter.v1.GetSpaceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Space>)
                  responseObserver);
          break;
        case METHODID_LIST_SPACES:
          serviceImpl.listSpaces(
              (com.google.cloud.designcenter.v1.ListSpacesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ListSpacesResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_SPACE:
          serviceImpl.createSpace(
              (com.google.cloud.designcenter.v1.CreateSpaceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Space>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SPACE:
          serviceImpl.updateSpace(
              (com.google.cloud.designcenter.v1.UpdateSpaceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Space>)
                  responseObserver);
          break;
        case METHODID_DELETE_SPACE:
          serviceImpl.deleteSpace(
              (com.google.cloud.designcenter.v1.DeleteSpaceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_APPLICATION_TEMPLATE:
          serviceImpl.getApplicationTemplate(
              (com.google.cloud.designcenter.v1.GetApplicationTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ApplicationTemplate>)
                  responseObserver);
          break;
        case METHODID_LIST_APPLICATION_TEMPLATES:
          serviceImpl.listApplicationTemplates(
              (com.google.cloud.designcenter.v1.ListApplicationTemplatesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.designcenter.v1.ListApplicationTemplatesResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_APPLICATION_TEMPLATE:
          serviceImpl.createApplicationTemplate(
              (com.google.cloud.designcenter.v1.CreateApplicationTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ApplicationTemplate>)
                  responseObserver);
          break;
        case METHODID_UPDATE_APPLICATION_TEMPLATE:
          serviceImpl.updateApplicationTemplate(
              (com.google.cloud.designcenter.v1.UpdateApplicationTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ApplicationTemplate>)
                  responseObserver);
          break;
        case METHODID_IMPORT_APPLICATION_TEMPLATE:
          serviceImpl.importApplicationTemplate(
              (com.google.cloud.designcenter.v1.ImportApplicationTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ApplicationTemplate>)
                  responseObserver);
          break;
        case METHODID_DELETE_APPLICATION_TEMPLATE:
          serviceImpl.deleteApplicationTemplate(
              (com.google.cloud.designcenter.v1.DeleteApplicationTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_COMMIT_APPLICATION_TEMPLATE:
          serviceImpl.commitApplicationTemplate(
              (com.google.cloud.designcenter.v1.CommitApplicationTemplateRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.designcenter.v1.ApplicationTemplateRevision>)
                  responseObserver);
          break;
        case METHODID_SNAPSHOT_APPLICATION_TEMPLATE:
          serviceImpl.snapshotApplicationTemplate(
              (com.google.cloud.designcenter.v1.SnapshotApplicationTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GENERATE_APPLICATION_TEMPLATE_IA_C:
          serviceImpl.generateApplicationTemplateIaC(
              (com.google.cloud.designcenter.v1.GenerateApplicationTemplateIaCRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.designcenter.v1.GenerateApplicationTemplateIaCResponse>)
                  responseObserver);
          break;
        case METHODID_EXPORT_APPLICATION_TEMPLATE_IA_C:
          serviceImpl.exportApplicationTemplateIaC(
              (com.google.cloud.designcenter.v1.ExportApplicationTemplateIaCRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GENERATE_APPLICATION_TEMPLATE_REVISION_IA_C:
          serviceImpl.generateApplicationTemplateRevisionIaC(
              (com.google.cloud.designcenter.v1.GenerateApplicationTemplateRevisionIaCRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.designcenter.v1
                          .GenerateApplicationTemplateRevisionIaCResponse>)
                  responseObserver);
          break;
        case METHODID_EXPORT_APPLICATION_TEMPLATE_REVISION_IA_C:
          serviceImpl.exportApplicationTemplateRevisionIaC(
              (com.google.cloud.designcenter.v1.ExportApplicationTemplateRevisionIaCRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_COMPONENT:
          serviceImpl.getComponent(
              (com.google.cloud.designcenter.v1.GetComponentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Component>)
                  responseObserver);
          break;
        case METHODID_LIST_COMPONENTS:
          serviceImpl.listComponents(
              (com.google.cloud.designcenter.v1.ListComponentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ListComponentsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_COMPONENT:
          serviceImpl.createComponent(
              (com.google.cloud.designcenter.v1.CreateComponentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Component>)
                  responseObserver);
          break;
        case METHODID_UPDATE_COMPONENT:
          serviceImpl.updateComponent(
              (com.google.cloud.designcenter.v1.UpdateComponentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Component>)
                  responseObserver);
          break;
        case METHODID_DELETE_COMPONENT:
          serviceImpl.deleteComponent(
              (com.google.cloud.designcenter.v1.DeleteComponentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_CONNECTION:
          serviceImpl.getConnection(
              (com.google.cloud.designcenter.v1.GetConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Connection>)
                  responseObserver);
          break;
        case METHODID_LIST_CONNECTIONS:
          serviceImpl.listConnections(
              (com.google.cloud.designcenter.v1.ListConnectionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.designcenter.v1.ListConnectionsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_CONNECTION:
          serviceImpl.createConnection(
              (com.google.cloud.designcenter.v1.CreateConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Connection>)
                  responseObserver);
          break;
        case METHODID_UPDATE_CONNECTION:
          serviceImpl.updateConnection(
              (com.google.cloud.designcenter.v1.UpdateConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Connection>)
                  responseObserver);
          break;
        case METHODID_DELETE_CONNECTION:
          serviceImpl.deleteConnection(
              (com.google.cloud.designcenter.v1.DeleteConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_APPLICATION_TEMPLATE_REVISION:
          serviceImpl.getApplicationTemplateRevision(
              (com.google.cloud.designcenter.v1.GetApplicationTemplateRevisionRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.designcenter.v1.ApplicationTemplateRevision>)
                  responseObserver);
          break;
        case METHODID_LIST_APPLICATION_TEMPLATE_REVISIONS:
          serviceImpl.listApplicationTemplateRevisions(
              (com.google.cloud.designcenter.v1.ListApplicationTemplateRevisionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.designcenter.v1.ListApplicationTemplateRevisionsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_APPLICATION_TEMPLATE_REVISION:
          serviceImpl.deleteApplicationTemplateRevision(
              (com.google.cloud.designcenter.v1.DeleteApplicationTemplateRevisionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_CATALOG:
          serviceImpl.getCatalog(
              (com.google.cloud.designcenter.v1.GetCatalogRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Catalog>)
                  responseObserver);
          break;
        case METHODID_LIST_CATALOGS:
          serviceImpl.listCatalogs(
              (com.google.cloud.designcenter.v1.ListCatalogsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ListCatalogsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_CATALOG:
          serviceImpl.createCatalog(
              (com.google.cloud.designcenter.v1.CreateCatalogRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Catalog>)
                  responseObserver);
          break;
        case METHODID_UPDATE_CATALOG:
          serviceImpl.updateCatalog(
              (com.google.cloud.designcenter.v1.UpdateCatalogRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Catalog>)
                  responseObserver);
          break;
        case METHODID_DELETE_CATALOG:
          serviceImpl.deleteCatalog(
              (com.google.cloud.designcenter.v1.DeleteCatalogRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_CATALOG_TEMPLATE:
          serviceImpl.createCatalogTemplate(
              (com.google.cloud.designcenter.v1.CreateCatalogTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.CatalogTemplate>)
                  responseObserver);
          break;
        case METHODID_GET_CATALOG_TEMPLATE:
          serviceImpl.getCatalogTemplate(
              (com.google.cloud.designcenter.v1.GetCatalogTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.CatalogTemplate>)
                  responseObserver);
          break;
        case METHODID_LIST_CATALOG_TEMPLATES:
          serviceImpl.listCatalogTemplates(
              (com.google.cloud.designcenter.v1.ListCatalogTemplatesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.designcenter.v1.ListCatalogTemplatesResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_CATALOG_TEMPLATE:
          serviceImpl.updateCatalogTemplate(
              (com.google.cloud.designcenter.v1.UpdateCatalogTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.CatalogTemplate>)
                  responseObserver);
          break;
        case METHODID_DELETE_CATALOG_TEMPLATE:
          serviceImpl.deleteCatalogTemplate(
              (com.google.cloud.designcenter.v1.DeleteCatalogTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_SHARE:
          serviceImpl.createShare(
              (com.google.cloud.designcenter.v1.CreateShareRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_SHARES:
          serviceImpl.listShares(
              (com.google.cloud.designcenter.v1.ListSharesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ListSharesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SHARE:
          serviceImpl.getShare(
              (com.google.cloud.designcenter.v1.GetShareRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Share>)
                  responseObserver);
          break;
        case METHODID_DELETE_SHARE:
          serviceImpl.deleteShare(
              (com.google.cloud.designcenter.v1.DeleteShareRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_SYNC_SHARE:
          serviceImpl.syncShare(
              (com.google.cloud.designcenter.v1.SyncShareRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_SHARED_TEMPLATE:
          serviceImpl.getSharedTemplate(
              (com.google.cloud.designcenter.v1.GetSharedTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.SharedTemplate>)
                  responseObserver);
          break;
        case METHODID_LIST_SHARED_TEMPLATES:
          serviceImpl.listSharedTemplates(
              (com.google.cloud.designcenter.v1.ListSharedTemplatesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.designcenter.v1.ListSharedTemplatesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SHARED_TEMPLATE_REVISION:
          serviceImpl.getSharedTemplateRevision(
              (com.google.cloud.designcenter.v1.GetSharedTemplateRevisionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.SharedTemplateRevision>)
                  responseObserver);
          break;
        case METHODID_LIST_SHARED_TEMPLATE_REVISIONS:
          serviceImpl.listSharedTemplateRevisions(
              (com.google.cloud.designcenter.v1.ListSharedTemplateRevisionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.designcenter.v1.ListSharedTemplateRevisionsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_CATALOG_TEMPLATE_REVISION:
          serviceImpl.createCatalogTemplateRevision(
              (com.google.cloud.designcenter.v1.CreateCatalogTemplateRevisionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_CATALOG_TEMPLATE_REVISION:
          serviceImpl.getCatalogTemplateRevision(
              (com.google.cloud.designcenter.v1.GetCatalogTemplateRevisionRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.designcenter.v1.CatalogTemplateRevision>)
                  responseObserver);
          break;
        case METHODID_LIST_CATALOG_TEMPLATE_REVISIONS:
          serviceImpl.listCatalogTemplateRevisions(
              (com.google.cloud.designcenter.v1.ListCatalogTemplateRevisionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.designcenter.v1.ListCatalogTemplateRevisionsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_CATALOG_TEMPLATE_REVISION:
          serviceImpl.deleteCatalogTemplateRevision(
              (com.google.cloud.designcenter.v1.DeleteCatalogTemplateRevisionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_APPLICATION:
          serviceImpl.createApplication(
              (com.google.cloud.designcenter.v1.CreateApplicationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Application>)
                  responseObserver);
          break;
        case METHODID_GET_APPLICATION:
          serviceImpl.getApplication(
              (com.google.cloud.designcenter.v1.GetApplicationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Application>)
                  responseObserver);
          break;
        case METHODID_LIST_APPLICATIONS:
          serviceImpl.listApplications(
              (com.google.cloud.designcenter.v1.ListApplicationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.designcenter.v1.ListApplicationsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_APPLICATION:
          serviceImpl.updateApplication(
              (com.google.cloud.designcenter.v1.UpdateApplicationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Application>)
                  responseObserver);
          break;
        case METHODID_DELETE_APPLICATION:
          serviceImpl.deleteApplication(
              (com.google.cloud.designcenter.v1.DeleteApplicationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DEPLOY_APPLICATION:
          serviceImpl.deployApplication(
              (com.google.cloud.designcenter.v1.DeployApplicationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_PREVIEW_APPLICATION:
          serviceImpl.previewApplication(
              (com.google.cloud.designcenter.v1.PreviewApplicationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_FETCH_APPLICATION_ASSESSMENT_REPORT:
          serviceImpl.fetchApplicationAssessmentReport(
              (com.google.cloud.designcenter.v1.FetchApplicationAssessmentReportRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.designcenter.v1.FetchApplicationAssessmentReportResponse>)
                  responseObserver);
          break;
        case METHODID_GENERATE_APPLICATION_ASSESSMENT_REPORT:
          serviceImpl.generateApplicationAssessmentReport(
              (com.google.cloud.designcenter.v1.GenerateApplicationAssessmentReportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GENERATE_APPLICATION_TEMPLATE_ASSESSMENT_REPORT:
          serviceImpl.generateApplicationTemplateAssessmentReport(
              (com.google.cloud.designcenter.v1.GenerateApplicationTemplateAssessmentReportRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GENERATE_ASSESSMENT_REPORT:
          serviceImpl.generateAssessmentReport(
              (com.google.cloud.designcenter.v1.GenerateAssessmentReportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GENERATE_TERRAFORM_PLAN_ASSESSMENT_REPORT:
          serviceImpl.generateTerraformPlanAssessmentReport(
              (com.google.cloud.designcenter.v1.GenerateTerraformPlanAssessmentReportRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_POLICY:
          serviceImpl.getPolicy(
              (com.google.cloud.designcenter.v1.GetPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Policy>)
                  responseObserver);
          break;
        case METHODID_LIST_POLICIES:
          serviceImpl.listPolicies(
              (com.google.cloud.designcenter.v1.ListPoliciesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.ListPoliciesResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_POLICY:
          serviceImpl.createPolicy(
              (com.google.cloud.designcenter.v1.CreatePolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Policy>)
                  responseObserver);
          break;
        case METHODID_UPDATE_POLICY:
          serviceImpl.updatePolicy(
              (com.google.cloud.designcenter.v1.UpdatePolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.designcenter.v1.Policy>)
                  responseObserver);
          break;
        case METHODID_DELETE_POLICY:
          serviceImpl.deletePolicy(
              (com.google.cloud.designcenter.v1.DeletePolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_FETCH_FRAMEWORKS:
          serviceImpl.fetchFrameworks(
              (com.google.cloud.designcenter.v1.FetchFrameworksRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.designcenter.v1.FetchFrameworksResponse>)
                  responseObserver);
          break;
        case METHODID_GENERATE_APPLICATION_IA_C:
          serviceImpl.generateApplicationIaC(
              (com.google.cloud.designcenter.v1.GenerateApplicationIaCRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.designcenter.v1.GenerateApplicationIaCResponse>)
                  responseObserver);
          break;
        case METHODID_EXPORT_APPLICATION_IA_C:
          serviceImpl.exportApplicationIaC(
              (com.google.cloud.designcenter.v1.ExportApplicationIaCRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_IMPORT_APPLICATION_TEMPLATE_IA_C:
          serviceImpl.importApplicationTemplateIaC(
              (com.google.cloud.designcenter.v1.ImportApplicationTemplateIaCRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.designcenter.v1.ImportApplicationTemplateIaCResponse>)
                  responseObserver);
          break;
        case METHODID_INGEST_APPLICATION_TEMPLATE_IA_C:
          serviceImpl.ingestApplicationTemplateIaC(
              (com.google.cloud.designcenter.v1.IngestApplicationTemplateIaCRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_IMPORT_APPLICATION_IA_C:
          serviceImpl.importApplicationIaC(
              (com.google.cloud.designcenter.v1.ImportApplicationIaCRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.designcenter.v1.ImportApplicationIaCResponse>)
                  responseObserver);
          break;
        case METHODID_REGISTER_APP_HUB_APPLICATION_RESOURCES:
          serviceImpl.registerAppHubApplicationResources(
              (com.google.cloud.designcenter.v1.RegisterAppHubApplicationResourcesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_APPLICATION_TEMPLATE_SYSTEM_REVISIONS:
          serviceImpl.listApplicationTemplateSystemRevisions(
              (com.google.cloud.designcenter.v1.ListApplicationTemplateSystemRevisionsRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.designcenter.v1
                          .ListApplicationTemplateSystemRevisionsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_APPLICATION_TEMPLATE_SYSTEM_REVISION:
          serviceImpl.getApplicationTemplateSystemRevision(
              (com.google.cloud.designcenter.v1.GetApplicationTemplateSystemRevisionRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.designcenter.v1.ApplicationTemplateSystemRevision>)
                  responseObserver);
          break;
        case METHODID_RECOMMEND_IAMROLES:
          serviceImpl.recommendIAMRoles(
              (com.google.cloud.designcenter.v1.RecommendIAMRolesRequest) request,
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
            getGetSpaceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.GetSpaceRequest,
                    com.google.cloud.designcenter.v1.Space>(service, METHODID_GET_SPACE)))
        .addMethod(
            getListSpacesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.ListSpacesRequest,
                    com.google.cloud.designcenter.v1.ListSpacesResponse>(
                    service, METHODID_LIST_SPACES)))
        .addMethod(
            getCreateSpaceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.CreateSpaceRequest,
                    com.google.cloud.designcenter.v1.Space>(service, METHODID_CREATE_SPACE)))
        .addMethod(
            getUpdateSpaceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.UpdateSpaceRequest,
                    com.google.cloud.designcenter.v1.Space>(service, METHODID_UPDATE_SPACE)))
        .addMethod(
            getDeleteSpaceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.DeleteSpaceRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_SPACE)))
        .addMethod(
            getGetApplicationTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.GetApplicationTemplateRequest,
                    com.google.cloud.designcenter.v1.ApplicationTemplate>(
                    service, METHODID_GET_APPLICATION_TEMPLATE)))
        .addMethod(
            getListApplicationTemplatesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.ListApplicationTemplatesRequest,
                    com.google.cloud.designcenter.v1.ListApplicationTemplatesResponse>(
                    service, METHODID_LIST_APPLICATION_TEMPLATES)))
        .addMethod(
            getCreateApplicationTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.CreateApplicationTemplateRequest,
                    com.google.cloud.designcenter.v1.ApplicationTemplate>(
                    service, METHODID_CREATE_APPLICATION_TEMPLATE)))
        .addMethod(
            getUpdateApplicationTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.UpdateApplicationTemplateRequest,
                    com.google.cloud.designcenter.v1.ApplicationTemplate>(
                    service, METHODID_UPDATE_APPLICATION_TEMPLATE)))
        .addMethod(
            getImportApplicationTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.ImportApplicationTemplateRequest,
                    com.google.cloud.designcenter.v1.ApplicationTemplate>(
                    service, METHODID_IMPORT_APPLICATION_TEMPLATE)))
        .addMethod(
            getDeleteApplicationTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.DeleteApplicationTemplateRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_APPLICATION_TEMPLATE)))
        .addMethod(
            getCommitApplicationTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.CommitApplicationTemplateRequest,
                    com.google.cloud.designcenter.v1.ApplicationTemplateRevision>(
                    service, METHODID_COMMIT_APPLICATION_TEMPLATE)))
        .addMethod(
            getSnapshotApplicationTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.SnapshotApplicationTemplateRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_SNAPSHOT_APPLICATION_TEMPLATE)))
        .addMethod(
            getGenerateApplicationTemplateIaCMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.GenerateApplicationTemplateIaCRequest,
                    com.google.cloud.designcenter.v1.GenerateApplicationTemplateIaCResponse>(
                    service, METHODID_GENERATE_APPLICATION_TEMPLATE_IA_C)))
        .addMethod(
            getExportApplicationTemplateIaCMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.ExportApplicationTemplateIaCRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_EXPORT_APPLICATION_TEMPLATE_IA_C)))
        .addMethod(
            getGenerateApplicationTemplateRevisionIaCMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.GenerateApplicationTemplateRevisionIaCRequest,
                    com.google.cloud.designcenter.v1
                        .GenerateApplicationTemplateRevisionIaCResponse>(
                    service, METHODID_GENERATE_APPLICATION_TEMPLATE_REVISION_IA_C)))
        .addMethod(
            getExportApplicationTemplateRevisionIaCMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.ExportApplicationTemplateRevisionIaCRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_EXPORT_APPLICATION_TEMPLATE_REVISION_IA_C)))
        .addMethod(
            getGetComponentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.GetComponentRequest,
                    com.google.cloud.designcenter.v1.Component>(service, METHODID_GET_COMPONENT)))
        .addMethod(
            getListComponentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.ListComponentsRequest,
                    com.google.cloud.designcenter.v1.ListComponentsResponse>(
                    service, METHODID_LIST_COMPONENTS)))
        .addMethod(
            getCreateComponentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.CreateComponentRequest,
                    com.google.cloud.designcenter.v1.Component>(
                    service, METHODID_CREATE_COMPONENT)))
        .addMethod(
            getUpdateComponentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.UpdateComponentRequest,
                    com.google.cloud.designcenter.v1.Component>(
                    service, METHODID_UPDATE_COMPONENT)))
        .addMethod(
            getDeleteComponentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.DeleteComponentRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_COMPONENT)))
        .addMethod(
            getGetConnectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.GetConnectionRequest,
                    com.google.cloud.designcenter.v1.Connection>(service, METHODID_GET_CONNECTION)))
        .addMethod(
            getListConnectionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.ListConnectionsRequest,
                    com.google.cloud.designcenter.v1.ListConnectionsResponse>(
                    service, METHODID_LIST_CONNECTIONS)))
        .addMethod(
            getCreateConnectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.CreateConnectionRequest,
                    com.google.cloud.designcenter.v1.Connection>(
                    service, METHODID_CREATE_CONNECTION)))
        .addMethod(
            getUpdateConnectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.UpdateConnectionRequest,
                    com.google.cloud.designcenter.v1.Connection>(
                    service, METHODID_UPDATE_CONNECTION)))
        .addMethod(
            getDeleteConnectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.DeleteConnectionRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_CONNECTION)))
        .addMethod(
            getGetApplicationTemplateRevisionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.GetApplicationTemplateRevisionRequest,
                    com.google.cloud.designcenter.v1.ApplicationTemplateRevision>(
                    service, METHODID_GET_APPLICATION_TEMPLATE_REVISION)))
        .addMethod(
            getListApplicationTemplateRevisionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.ListApplicationTemplateRevisionsRequest,
                    com.google.cloud.designcenter.v1.ListApplicationTemplateRevisionsResponse>(
                    service, METHODID_LIST_APPLICATION_TEMPLATE_REVISIONS)))
        .addMethod(
            getDeleteApplicationTemplateRevisionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.DeleteApplicationTemplateRevisionRequest,
                    com.google.protobuf.Empty>(
                    service, METHODID_DELETE_APPLICATION_TEMPLATE_REVISION)))
        .addMethod(
            getGetCatalogMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.GetCatalogRequest,
                    com.google.cloud.designcenter.v1.Catalog>(service, METHODID_GET_CATALOG)))
        .addMethod(
            getListCatalogsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.ListCatalogsRequest,
                    com.google.cloud.designcenter.v1.ListCatalogsResponse>(
                    service, METHODID_LIST_CATALOGS)))
        .addMethod(
            getCreateCatalogMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.CreateCatalogRequest,
                    com.google.cloud.designcenter.v1.Catalog>(service, METHODID_CREATE_CATALOG)))
        .addMethod(
            getUpdateCatalogMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.UpdateCatalogRequest,
                    com.google.cloud.designcenter.v1.Catalog>(service, METHODID_UPDATE_CATALOG)))
        .addMethod(
            getDeleteCatalogMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.DeleteCatalogRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_CATALOG)))
        .addMethod(
            getCreateCatalogTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.CreateCatalogTemplateRequest,
                    com.google.cloud.designcenter.v1.CatalogTemplate>(
                    service, METHODID_CREATE_CATALOG_TEMPLATE)))
        .addMethod(
            getGetCatalogTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.GetCatalogTemplateRequest,
                    com.google.cloud.designcenter.v1.CatalogTemplate>(
                    service, METHODID_GET_CATALOG_TEMPLATE)))
        .addMethod(
            getListCatalogTemplatesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.ListCatalogTemplatesRequest,
                    com.google.cloud.designcenter.v1.ListCatalogTemplatesResponse>(
                    service, METHODID_LIST_CATALOG_TEMPLATES)))
        .addMethod(
            getUpdateCatalogTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.UpdateCatalogTemplateRequest,
                    com.google.cloud.designcenter.v1.CatalogTemplate>(
                    service, METHODID_UPDATE_CATALOG_TEMPLATE)))
        .addMethod(
            getDeleteCatalogTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.DeleteCatalogTemplateRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_CATALOG_TEMPLATE)))
        .addMethod(
            getCreateShareMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.CreateShareRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_SHARE)))
        .addMethod(
            getListSharesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.ListSharesRequest,
                    com.google.cloud.designcenter.v1.ListSharesResponse>(
                    service, METHODID_LIST_SHARES)))
        .addMethod(
            getGetShareMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.GetShareRequest,
                    com.google.cloud.designcenter.v1.Share>(service, METHODID_GET_SHARE)))
        .addMethod(
            getDeleteShareMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.DeleteShareRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_SHARE)))
        .addMethod(
            getSyncShareMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.SyncShareRequest,
                    com.google.longrunning.Operation>(service, METHODID_SYNC_SHARE)))
        .addMethod(
            getGetSharedTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.GetSharedTemplateRequest,
                    com.google.cloud.designcenter.v1.SharedTemplate>(
                    service, METHODID_GET_SHARED_TEMPLATE)))
        .addMethod(
            getListSharedTemplatesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.ListSharedTemplatesRequest,
                    com.google.cloud.designcenter.v1.ListSharedTemplatesResponse>(
                    service, METHODID_LIST_SHARED_TEMPLATES)))
        .addMethod(
            getGetSharedTemplateRevisionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.GetSharedTemplateRevisionRequest,
                    com.google.cloud.designcenter.v1.SharedTemplateRevision>(
                    service, METHODID_GET_SHARED_TEMPLATE_REVISION)))
        .addMethod(
            getListSharedTemplateRevisionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.ListSharedTemplateRevisionsRequest,
                    com.google.cloud.designcenter.v1.ListSharedTemplateRevisionsResponse>(
                    service, METHODID_LIST_SHARED_TEMPLATE_REVISIONS)))
        .addMethod(
            getCreateCatalogTemplateRevisionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.CreateCatalogTemplateRevisionRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_CATALOG_TEMPLATE_REVISION)))
        .addMethod(
            getGetCatalogTemplateRevisionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.GetCatalogTemplateRevisionRequest,
                    com.google.cloud.designcenter.v1.CatalogTemplateRevision>(
                    service, METHODID_GET_CATALOG_TEMPLATE_REVISION)))
        .addMethod(
            getListCatalogTemplateRevisionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.ListCatalogTemplateRevisionsRequest,
                    com.google.cloud.designcenter.v1.ListCatalogTemplateRevisionsResponse>(
                    service, METHODID_LIST_CATALOG_TEMPLATE_REVISIONS)))
        .addMethod(
            getDeleteCatalogTemplateRevisionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.DeleteCatalogTemplateRevisionRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_CATALOG_TEMPLATE_REVISION)))
        .addMethod(
            getCreateApplicationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.CreateApplicationRequest,
                    com.google.cloud.designcenter.v1.Application>(
                    service, METHODID_CREATE_APPLICATION)))
        .addMethod(
            getGetApplicationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.GetApplicationRequest,
                    com.google.cloud.designcenter.v1.Application>(
                    service, METHODID_GET_APPLICATION)))
        .addMethod(
            getListApplicationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.ListApplicationsRequest,
                    com.google.cloud.designcenter.v1.ListApplicationsResponse>(
                    service, METHODID_LIST_APPLICATIONS)))
        .addMethod(
            getUpdateApplicationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.UpdateApplicationRequest,
                    com.google.cloud.designcenter.v1.Application>(
                    service, METHODID_UPDATE_APPLICATION)))
        .addMethod(
            getDeleteApplicationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.DeleteApplicationRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_APPLICATION)))
        .addMethod(
            getDeployApplicationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.DeployApplicationRequest,
                    com.google.longrunning.Operation>(service, METHODID_DEPLOY_APPLICATION)))
        .addMethod(
            getPreviewApplicationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.PreviewApplicationRequest,
                    com.google.longrunning.Operation>(service, METHODID_PREVIEW_APPLICATION)))
        .addMethod(
            getFetchApplicationAssessmentReportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.FetchApplicationAssessmentReportRequest,
                    com.google.cloud.designcenter.v1.FetchApplicationAssessmentReportResponse>(
                    service, METHODID_FETCH_APPLICATION_ASSESSMENT_REPORT)))
        .addMethod(
            getGenerateApplicationAssessmentReportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.GenerateApplicationAssessmentReportRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_GENERATE_APPLICATION_ASSESSMENT_REPORT)))
        .addMethod(
            getGenerateApplicationTemplateAssessmentReportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1
                        .GenerateApplicationTemplateAssessmentReportRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_GENERATE_APPLICATION_TEMPLATE_ASSESSMENT_REPORT)))
        .addMethod(
            getGenerateAssessmentReportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.GenerateAssessmentReportRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_GENERATE_ASSESSMENT_REPORT)))
        .addMethod(
            getGenerateTerraformPlanAssessmentReportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.GenerateTerraformPlanAssessmentReportRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_GENERATE_TERRAFORM_PLAN_ASSESSMENT_REPORT)))
        .addMethod(
            getGetPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.GetPolicyRequest,
                    com.google.cloud.designcenter.v1.Policy>(service, METHODID_GET_POLICY)))
        .addMethod(
            getListPoliciesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.ListPoliciesRequest,
                    com.google.cloud.designcenter.v1.ListPoliciesResponse>(
                    service, METHODID_LIST_POLICIES)))
        .addMethod(
            getCreatePolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.CreatePolicyRequest,
                    com.google.cloud.designcenter.v1.Policy>(service, METHODID_CREATE_POLICY)))
        .addMethod(
            getUpdatePolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.UpdatePolicyRequest,
                    com.google.cloud.designcenter.v1.Policy>(service, METHODID_UPDATE_POLICY)))
        .addMethod(
            getDeletePolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.DeletePolicyRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_POLICY)))
        .addMethod(
            getFetchFrameworksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.FetchFrameworksRequest,
                    com.google.cloud.designcenter.v1.FetchFrameworksResponse>(
                    service, METHODID_FETCH_FRAMEWORKS)))
        .addMethod(
            getGenerateApplicationIaCMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.GenerateApplicationIaCRequest,
                    com.google.cloud.designcenter.v1.GenerateApplicationIaCResponse>(
                    service, METHODID_GENERATE_APPLICATION_IA_C)))
        .addMethod(
            getExportApplicationIaCMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.ExportApplicationIaCRequest,
                    com.google.longrunning.Operation>(service, METHODID_EXPORT_APPLICATION_IA_C)))
        .addMethod(
            getImportApplicationTemplateIaCMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.ImportApplicationTemplateIaCRequest,
                    com.google.cloud.designcenter.v1.ImportApplicationTemplateIaCResponse>(
                    service, METHODID_IMPORT_APPLICATION_TEMPLATE_IA_C)))
        .addMethod(
            getIngestApplicationTemplateIaCMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.IngestApplicationTemplateIaCRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_INGEST_APPLICATION_TEMPLATE_IA_C)))
        .addMethod(
            getImportApplicationIaCMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.ImportApplicationIaCRequest,
                    com.google.cloud.designcenter.v1.ImportApplicationIaCResponse>(
                    service, METHODID_IMPORT_APPLICATION_IA_C)))
        .addMethod(
            getRegisterAppHubApplicationResourcesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.RegisterAppHubApplicationResourcesRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_REGISTER_APP_HUB_APPLICATION_RESOURCES)))
        .addMethod(
            getListApplicationTemplateSystemRevisionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.ListApplicationTemplateSystemRevisionsRequest,
                    com.google.cloud.designcenter.v1
                        .ListApplicationTemplateSystemRevisionsResponse>(
                    service, METHODID_LIST_APPLICATION_TEMPLATE_SYSTEM_REVISIONS)))
        .addMethod(
            getGetApplicationTemplateSystemRevisionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.GetApplicationTemplateSystemRevisionRequest,
                    com.google.cloud.designcenter.v1.ApplicationTemplateSystemRevision>(
                    service, METHODID_GET_APPLICATION_TEMPLATE_SYSTEM_REVISION)))
        .addMethod(
            getRecommendIAMRolesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.designcenter.v1.RecommendIAMRolesRequest,
                    com.google.longrunning.Operation>(service, METHODID_RECOMMEND_IAMROLES)))
        .build();
  }

  private abstract static class DesignCenterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DesignCenterBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.designcenter.v1.DesigncenterProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DesignCenter");
    }
  }

  private static final class DesignCenterFileDescriptorSupplier
      extends DesignCenterBaseDescriptorSupplier {
    DesignCenterFileDescriptorSupplier() {}
  }

  private static final class DesignCenterMethodDescriptorSupplier
      extends DesignCenterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DesignCenterMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DesignCenterGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DesignCenterFileDescriptorSupplier())
                      .addMethod(getGetSpaceMethod())
                      .addMethod(getListSpacesMethod())
                      .addMethod(getCreateSpaceMethod())
                      .addMethod(getUpdateSpaceMethod())
                      .addMethod(getDeleteSpaceMethod())
                      .addMethod(getGetApplicationTemplateMethod())
                      .addMethod(getListApplicationTemplatesMethod())
                      .addMethod(getCreateApplicationTemplateMethod())
                      .addMethod(getUpdateApplicationTemplateMethod())
                      .addMethod(getImportApplicationTemplateMethod())
                      .addMethod(getDeleteApplicationTemplateMethod())
                      .addMethod(getCommitApplicationTemplateMethod())
                      .addMethod(getSnapshotApplicationTemplateMethod())
                      .addMethod(getGenerateApplicationTemplateIaCMethod())
                      .addMethod(getExportApplicationTemplateIaCMethod())
                      .addMethod(getGenerateApplicationTemplateRevisionIaCMethod())
                      .addMethod(getExportApplicationTemplateRevisionIaCMethod())
                      .addMethod(getGetComponentMethod())
                      .addMethod(getListComponentsMethod())
                      .addMethod(getCreateComponentMethod())
                      .addMethod(getUpdateComponentMethod())
                      .addMethod(getDeleteComponentMethod())
                      .addMethod(getGetConnectionMethod())
                      .addMethod(getListConnectionsMethod())
                      .addMethod(getCreateConnectionMethod())
                      .addMethod(getUpdateConnectionMethod())
                      .addMethod(getDeleteConnectionMethod())
                      .addMethod(getGetApplicationTemplateRevisionMethod())
                      .addMethod(getListApplicationTemplateRevisionsMethod())
                      .addMethod(getDeleteApplicationTemplateRevisionMethod())
                      .addMethod(getGetCatalogMethod())
                      .addMethod(getListCatalogsMethod())
                      .addMethod(getCreateCatalogMethod())
                      .addMethod(getUpdateCatalogMethod())
                      .addMethod(getDeleteCatalogMethod())
                      .addMethod(getCreateCatalogTemplateMethod())
                      .addMethod(getGetCatalogTemplateMethod())
                      .addMethod(getListCatalogTemplatesMethod())
                      .addMethod(getUpdateCatalogTemplateMethod())
                      .addMethod(getDeleteCatalogTemplateMethod())
                      .addMethod(getCreateShareMethod())
                      .addMethod(getListSharesMethod())
                      .addMethod(getGetShareMethod())
                      .addMethod(getDeleteShareMethod())
                      .addMethod(getSyncShareMethod())
                      .addMethod(getGetSharedTemplateMethod())
                      .addMethod(getListSharedTemplatesMethod())
                      .addMethod(getGetSharedTemplateRevisionMethod())
                      .addMethod(getListSharedTemplateRevisionsMethod())
                      .addMethod(getCreateCatalogTemplateRevisionMethod())
                      .addMethod(getGetCatalogTemplateRevisionMethod())
                      .addMethod(getListCatalogTemplateRevisionsMethod())
                      .addMethod(getDeleteCatalogTemplateRevisionMethod())
                      .addMethod(getCreateApplicationMethod())
                      .addMethod(getGetApplicationMethod())
                      .addMethod(getListApplicationsMethod())
                      .addMethod(getUpdateApplicationMethod())
                      .addMethod(getDeleteApplicationMethod())
                      .addMethod(getDeployApplicationMethod())
                      .addMethod(getPreviewApplicationMethod())
                      .addMethod(getFetchApplicationAssessmentReportMethod())
                      .addMethod(getGenerateApplicationAssessmentReportMethod())
                      .addMethod(getGenerateApplicationTemplateAssessmentReportMethod())
                      .addMethod(getGenerateAssessmentReportMethod())
                      .addMethod(getGenerateTerraformPlanAssessmentReportMethod())
                      .addMethod(getGetPolicyMethod())
                      .addMethod(getListPoliciesMethod())
                      .addMethod(getCreatePolicyMethod())
                      .addMethod(getUpdatePolicyMethod())
                      .addMethod(getDeletePolicyMethod())
                      .addMethod(getFetchFrameworksMethod())
                      .addMethod(getGenerateApplicationIaCMethod())
                      .addMethod(getExportApplicationIaCMethod())
                      .addMethod(getImportApplicationTemplateIaCMethod())
                      .addMethod(getIngestApplicationTemplateIaCMethod())
                      .addMethod(getImportApplicationIaCMethod())
                      .addMethod(getRegisterAppHubApplicationResourcesMethod())
                      .addMethod(getListApplicationTemplateSystemRevisionsMethod())
                      .addMethod(getGetApplicationTemplateSystemRevisionMethod())
                      .addMethod(getRecommendIAMRolesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
