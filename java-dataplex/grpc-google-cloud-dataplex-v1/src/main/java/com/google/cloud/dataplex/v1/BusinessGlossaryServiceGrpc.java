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
package com.google.cloud.dataplex.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * BusinessGlossaryService provides APIs for managing business glossary
 * resources for enterprise customers.
 * The resources currently supported in Business Glossary are:
 * 1. Glossary
 * 2. GlossaryCategory
 * 3. GlossaryTerm
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dataplex/v1/business_glossary.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BusinessGlossaryServiceGrpc {

  private BusinessGlossaryServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.dataplex.v1.BusinessGlossaryService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.CreateGlossaryRequest, com.google.longrunning.Operation>
      getCreateGlossaryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateGlossary",
      requestType = com.google.cloud.dataplex.v1.CreateGlossaryRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.CreateGlossaryRequest, com.google.longrunning.Operation>
      getCreateGlossaryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.CreateGlossaryRequest, com.google.longrunning.Operation>
        getCreateGlossaryMethod;
    if ((getCreateGlossaryMethod = BusinessGlossaryServiceGrpc.getCreateGlossaryMethod) == null) {
      synchronized (BusinessGlossaryServiceGrpc.class) {
        if ((getCreateGlossaryMethod = BusinessGlossaryServiceGrpc.getCreateGlossaryMethod)
            == null) {
          BusinessGlossaryServiceGrpc.getCreateGlossaryMethod =
              getCreateGlossaryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.CreateGlossaryRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateGlossary"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.CreateGlossaryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BusinessGlossaryServiceMethodDescriptorSupplier("CreateGlossary"))
                      .build();
        }
      }
    }
    return getCreateGlossaryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.UpdateGlossaryRequest, com.google.longrunning.Operation>
      getUpdateGlossaryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateGlossary",
      requestType = com.google.cloud.dataplex.v1.UpdateGlossaryRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.UpdateGlossaryRequest, com.google.longrunning.Operation>
      getUpdateGlossaryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.UpdateGlossaryRequest, com.google.longrunning.Operation>
        getUpdateGlossaryMethod;
    if ((getUpdateGlossaryMethod = BusinessGlossaryServiceGrpc.getUpdateGlossaryMethod) == null) {
      synchronized (BusinessGlossaryServiceGrpc.class) {
        if ((getUpdateGlossaryMethod = BusinessGlossaryServiceGrpc.getUpdateGlossaryMethod)
            == null) {
          BusinessGlossaryServiceGrpc.getUpdateGlossaryMethod =
              getUpdateGlossaryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.UpdateGlossaryRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateGlossary"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.UpdateGlossaryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BusinessGlossaryServiceMethodDescriptorSupplier("UpdateGlossary"))
                      .build();
        }
      }
    }
    return getUpdateGlossaryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.DeleteGlossaryRequest, com.google.longrunning.Operation>
      getDeleteGlossaryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteGlossary",
      requestType = com.google.cloud.dataplex.v1.DeleteGlossaryRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.DeleteGlossaryRequest, com.google.longrunning.Operation>
      getDeleteGlossaryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.DeleteGlossaryRequest, com.google.longrunning.Operation>
        getDeleteGlossaryMethod;
    if ((getDeleteGlossaryMethod = BusinessGlossaryServiceGrpc.getDeleteGlossaryMethod) == null) {
      synchronized (BusinessGlossaryServiceGrpc.class) {
        if ((getDeleteGlossaryMethod = BusinessGlossaryServiceGrpc.getDeleteGlossaryMethod)
            == null) {
          BusinessGlossaryServiceGrpc.getDeleteGlossaryMethod =
              getDeleteGlossaryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.DeleteGlossaryRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteGlossary"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.DeleteGlossaryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BusinessGlossaryServiceMethodDescriptorSupplier("DeleteGlossary"))
                      .build();
        }
      }
    }
    return getDeleteGlossaryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.GetGlossaryRequest, com.google.cloud.dataplex.v1.Glossary>
      getGetGlossaryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetGlossary",
      requestType = com.google.cloud.dataplex.v1.GetGlossaryRequest.class,
      responseType = com.google.cloud.dataplex.v1.Glossary.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.GetGlossaryRequest, com.google.cloud.dataplex.v1.Glossary>
      getGetGlossaryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.GetGlossaryRequest, com.google.cloud.dataplex.v1.Glossary>
        getGetGlossaryMethod;
    if ((getGetGlossaryMethod = BusinessGlossaryServiceGrpc.getGetGlossaryMethod) == null) {
      synchronized (BusinessGlossaryServiceGrpc.class) {
        if ((getGetGlossaryMethod = BusinessGlossaryServiceGrpc.getGetGlossaryMethod) == null) {
          BusinessGlossaryServiceGrpc.getGetGlossaryMethod =
              getGetGlossaryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.GetGlossaryRequest,
                          com.google.cloud.dataplex.v1.Glossary>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetGlossary"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.GetGlossaryRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.Glossary.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BusinessGlossaryServiceMethodDescriptorSupplier("GetGlossary"))
                      .build();
        }
      }
    }
    return getGetGlossaryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.ListGlossariesRequest,
          com.google.cloud.dataplex.v1.ListGlossariesResponse>
      getListGlossariesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListGlossaries",
      requestType = com.google.cloud.dataplex.v1.ListGlossariesRequest.class,
      responseType = com.google.cloud.dataplex.v1.ListGlossariesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.ListGlossariesRequest,
          com.google.cloud.dataplex.v1.ListGlossariesResponse>
      getListGlossariesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.ListGlossariesRequest,
            com.google.cloud.dataplex.v1.ListGlossariesResponse>
        getListGlossariesMethod;
    if ((getListGlossariesMethod = BusinessGlossaryServiceGrpc.getListGlossariesMethod) == null) {
      synchronized (BusinessGlossaryServiceGrpc.class) {
        if ((getListGlossariesMethod = BusinessGlossaryServiceGrpc.getListGlossariesMethod)
            == null) {
          BusinessGlossaryServiceGrpc.getListGlossariesMethod =
              getListGlossariesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.ListGlossariesRequest,
                          com.google.cloud.dataplex.v1.ListGlossariesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListGlossaries"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.ListGlossariesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.ListGlossariesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BusinessGlossaryServiceMethodDescriptorSupplier("ListGlossaries"))
                      .build();
        }
      }
    }
    return getListGlossariesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.CreateGlossaryCategoryRequest,
          com.google.cloud.dataplex.v1.GlossaryCategory>
      getCreateGlossaryCategoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateGlossaryCategory",
      requestType = com.google.cloud.dataplex.v1.CreateGlossaryCategoryRequest.class,
      responseType = com.google.cloud.dataplex.v1.GlossaryCategory.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.CreateGlossaryCategoryRequest,
          com.google.cloud.dataplex.v1.GlossaryCategory>
      getCreateGlossaryCategoryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.CreateGlossaryCategoryRequest,
            com.google.cloud.dataplex.v1.GlossaryCategory>
        getCreateGlossaryCategoryMethod;
    if ((getCreateGlossaryCategoryMethod =
            BusinessGlossaryServiceGrpc.getCreateGlossaryCategoryMethod)
        == null) {
      synchronized (BusinessGlossaryServiceGrpc.class) {
        if ((getCreateGlossaryCategoryMethod =
                BusinessGlossaryServiceGrpc.getCreateGlossaryCategoryMethod)
            == null) {
          BusinessGlossaryServiceGrpc.getCreateGlossaryCategoryMethod =
              getCreateGlossaryCategoryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.CreateGlossaryCategoryRequest,
                          com.google.cloud.dataplex.v1.GlossaryCategory>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateGlossaryCategory"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.CreateGlossaryCategoryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.GlossaryCategory.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BusinessGlossaryServiceMethodDescriptorSupplier(
                              "CreateGlossaryCategory"))
                      .build();
        }
      }
    }
    return getCreateGlossaryCategoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.UpdateGlossaryCategoryRequest,
          com.google.cloud.dataplex.v1.GlossaryCategory>
      getUpdateGlossaryCategoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateGlossaryCategory",
      requestType = com.google.cloud.dataplex.v1.UpdateGlossaryCategoryRequest.class,
      responseType = com.google.cloud.dataplex.v1.GlossaryCategory.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.UpdateGlossaryCategoryRequest,
          com.google.cloud.dataplex.v1.GlossaryCategory>
      getUpdateGlossaryCategoryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.UpdateGlossaryCategoryRequest,
            com.google.cloud.dataplex.v1.GlossaryCategory>
        getUpdateGlossaryCategoryMethod;
    if ((getUpdateGlossaryCategoryMethod =
            BusinessGlossaryServiceGrpc.getUpdateGlossaryCategoryMethod)
        == null) {
      synchronized (BusinessGlossaryServiceGrpc.class) {
        if ((getUpdateGlossaryCategoryMethod =
                BusinessGlossaryServiceGrpc.getUpdateGlossaryCategoryMethod)
            == null) {
          BusinessGlossaryServiceGrpc.getUpdateGlossaryCategoryMethod =
              getUpdateGlossaryCategoryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.UpdateGlossaryCategoryRequest,
                          com.google.cloud.dataplex.v1.GlossaryCategory>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateGlossaryCategory"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.UpdateGlossaryCategoryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.GlossaryCategory.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BusinessGlossaryServiceMethodDescriptorSupplier(
                              "UpdateGlossaryCategory"))
                      .build();
        }
      }
    }
    return getUpdateGlossaryCategoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.DeleteGlossaryCategoryRequest, com.google.protobuf.Empty>
      getDeleteGlossaryCategoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteGlossaryCategory",
      requestType = com.google.cloud.dataplex.v1.DeleteGlossaryCategoryRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.DeleteGlossaryCategoryRequest, com.google.protobuf.Empty>
      getDeleteGlossaryCategoryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.DeleteGlossaryCategoryRequest, com.google.protobuf.Empty>
        getDeleteGlossaryCategoryMethod;
    if ((getDeleteGlossaryCategoryMethod =
            BusinessGlossaryServiceGrpc.getDeleteGlossaryCategoryMethod)
        == null) {
      synchronized (BusinessGlossaryServiceGrpc.class) {
        if ((getDeleteGlossaryCategoryMethod =
                BusinessGlossaryServiceGrpc.getDeleteGlossaryCategoryMethod)
            == null) {
          BusinessGlossaryServiceGrpc.getDeleteGlossaryCategoryMethod =
              getDeleteGlossaryCategoryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.DeleteGlossaryCategoryRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteGlossaryCategory"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.DeleteGlossaryCategoryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BusinessGlossaryServiceMethodDescriptorSupplier(
                              "DeleteGlossaryCategory"))
                      .build();
        }
      }
    }
    return getDeleteGlossaryCategoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.GetGlossaryCategoryRequest,
          com.google.cloud.dataplex.v1.GlossaryCategory>
      getGetGlossaryCategoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetGlossaryCategory",
      requestType = com.google.cloud.dataplex.v1.GetGlossaryCategoryRequest.class,
      responseType = com.google.cloud.dataplex.v1.GlossaryCategory.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.GetGlossaryCategoryRequest,
          com.google.cloud.dataplex.v1.GlossaryCategory>
      getGetGlossaryCategoryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.GetGlossaryCategoryRequest,
            com.google.cloud.dataplex.v1.GlossaryCategory>
        getGetGlossaryCategoryMethod;
    if ((getGetGlossaryCategoryMethod = BusinessGlossaryServiceGrpc.getGetGlossaryCategoryMethod)
        == null) {
      synchronized (BusinessGlossaryServiceGrpc.class) {
        if ((getGetGlossaryCategoryMethod =
                BusinessGlossaryServiceGrpc.getGetGlossaryCategoryMethod)
            == null) {
          BusinessGlossaryServiceGrpc.getGetGlossaryCategoryMethod =
              getGetGlossaryCategoryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.GetGlossaryCategoryRequest,
                          com.google.cloud.dataplex.v1.GlossaryCategory>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetGlossaryCategory"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.GetGlossaryCategoryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.GlossaryCategory.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BusinessGlossaryServiceMethodDescriptorSupplier(
                              "GetGlossaryCategory"))
                      .build();
        }
      }
    }
    return getGetGlossaryCategoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.ListGlossaryCategoriesRequest,
          com.google.cloud.dataplex.v1.ListGlossaryCategoriesResponse>
      getListGlossaryCategoriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListGlossaryCategories",
      requestType = com.google.cloud.dataplex.v1.ListGlossaryCategoriesRequest.class,
      responseType = com.google.cloud.dataplex.v1.ListGlossaryCategoriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.ListGlossaryCategoriesRequest,
          com.google.cloud.dataplex.v1.ListGlossaryCategoriesResponse>
      getListGlossaryCategoriesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.ListGlossaryCategoriesRequest,
            com.google.cloud.dataplex.v1.ListGlossaryCategoriesResponse>
        getListGlossaryCategoriesMethod;
    if ((getListGlossaryCategoriesMethod =
            BusinessGlossaryServiceGrpc.getListGlossaryCategoriesMethod)
        == null) {
      synchronized (BusinessGlossaryServiceGrpc.class) {
        if ((getListGlossaryCategoriesMethod =
                BusinessGlossaryServiceGrpc.getListGlossaryCategoriesMethod)
            == null) {
          BusinessGlossaryServiceGrpc.getListGlossaryCategoriesMethod =
              getListGlossaryCategoriesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.ListGlossaryCategoriesRequest,
                          com.google.cloud.dataplex.v1.ListGlossaryCategoriesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListGlossaryCategories"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.ListGlossaryCategoriesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.ListGlossaryCategoriesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BusinessGlossaryServiceMethodDescriptorSupplier(
                              "ListGlossaryCategories"))
                      .build();
        }
      }
    }
    return getListGlossaryCategoriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.CreateGlossaryTermRequest,
          com.google.cloud.dataplex.v1.GlossaryTerm>
      getCreateGlossaryTermMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateGlossaryTerm",
      requestType = com.google.cloud.dataplex.v1.CreateGlossaryTermRequest.class,
      responseType = com.google.cloud.dataplex.v1.GlossaryTerm.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.CreateGlossaryTermRequest,
          com.google.cloud.dataplex.v1.GlossaryTerm>
      getCreateGlossaryTermMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.CreateGlossaryTermRequest,
            com.google.cloud.dataplex.v1.GlossaryTerm>
        getCreateGlossaryTermMethod;
    if ((getCreateGlossaryTermMethod = BusinessGlossaryServiceGrpc.getCreateGlossaryTermMethod)
        == null) {
      synchronized (BusinessGlossaryServiceGrpc.class) {
        if ((getCreateGlossaryTermMethod = BusinessGlossaryServiceGrpc.getCreateGlossaryTermMethod)
            == null) {
          BusinessGlossaryServiceGrpc.getCreateGlossaryTermMethod =
              getCreateGlossaryTermMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.CreateGlossaryTermRequest,
                          com.google.cloud.dataplex.v1.GlossaryTerm>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateGlossaryTerm"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.CreateGlossaryTermRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.GlossaryTerm.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BusinessGlossaryServiceMethodDescriptorSupplier("CreateGlossaryTerm"))
                      .build();
        }
      }
    }
    return getCreateGlossaryTermMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.UpdateGlossaryTermRequest,
          com.google.cloud.dataplex.v1.GlossaryTerm>
      getUpdateGlossaryTermMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateGlossaryTerm",
      requestType = com.google.cloud.dataplex.v1.UpdateGlossaryTermRequest.class,
      responseType = com.google.cloud.dataplex.v1.GlossaryTerm.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.UpdateGlossaryTermRequest,
          com.google.cloud.dataplex.v1.GlossaryTerm>
      getUpdateGlossaryTermMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.UpdateGlossaryTermRequest,
            com.google.cloud.dataplex.v1.GlossaryTerm>
        getUpdateGlossaryTermMethod;
    if ((getUpdateGlossaryTermMethod = BusinessGlossaryServiceGrpc.getUpdateGlossaryTermMethod)
        == null) {
      synchronized (BusinessGlossaryServiceGrpc.class) {
        if ((getUpdateGlossaryTermMethod = BusinessGlossaryServiceGrpc.getUpdateGlossaryTermMethod)
            == null) {
          BusinessGlossaryServiceGrpc.getUpdateGlossaryTermMethod =
              getUpdateGlossaryTermMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.UpdateGlossaryTermRequest,
                          com.google.cloud.dataplex.v1.GlossaryTerm>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateGlossaryTerm"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.UpdateGlossaryTermRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.GlossaryTerm.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BusinessGlossaryServiceMethodDescriptorSupplier("UpdateGlossaryTerm"))
                      .build();
        }
      }
    }
    return getUpdateGlossaryTermMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.DeleteGlossaryTermRequest, com.google.protobuf.Empty>
      getDeleteGlossaryTermMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteGlossaryTerm",
      requestType = com.google.cloud.dataplex.v1.DeleteGlossaryTermRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.DeleteGlossaryTermRequest, com.google.protobuf.Empty>
      getDeleteGlossaryTermMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.DeleteGlossaryTermRequest, com.google.protobuf.Empty>
        getDeleteGlossaryTermMethod;
    if ((getDeleteGlossaryTermMethod = BusinessGlossaryServiceGrpc.getDeleteGlossaryTermMethod)
        == null) {
      synchronized (BusinessGlossaryServiceGrpc.class) {
        if ((getDeleteGlossaryTermMethod = BusinessGlossaryServiceGrpc.getDeleteGlossaryTermMethod)
            == null) {
          BusinessGlossaryServiceGrpc.getDeleteGlossaryTermMethod =
              getDeleteGlossaryTermMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.DeleteGlossaryTermRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteGlossaryTerm"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.DeleteGlossaryTermRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BusinessGlossaryServiceMethodDescriptorSupplier("DeleteGlossaryTerm"))
                      .build();
        }
      }
    }
    return getDeleteGlossaryTermMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.GetGlossaryTermRequest,
          com.google.cloud.dataplex.v1.GlossaryTerm>
      getGetGlossaryTermMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetGlossaryTerm",
      requestType = com.google.cloud.dataplex.v1.GetGlossaryTermRequest.class,
      responseType = com.google.cloud.dataplex.v1.GlossaryTerm.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.GetGlossaryTermRequest,
          com.google.cloud.dataplex.v1.GlossaryTerm>
      getGetGlossaryTermMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.GetGlossaryTermRequest,
            com.google.cloud.dataplex.v1.GlossaryTerm>
        getGetGlossaryTermMethod;
    if ((getGetGlossaryTermMethod = BusinessGlossaryServiceGrpc.getGetGlossaryTermMethod) == null) {
      synchronized (BusinessGlossaryServiceGrpc.class) {
        if ((getGetGlossaryTermMethod = BusinessGlossaryServiceGrpc.getGetGlossaryTermMethod)
            == null) {
          BusinessGlossaryServiceGrpc.getGetGlossaryTermMethod =
              getGetGlossaryTermMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.GetGlossaryTermRequest,
                          com.google.cloud.dataplex.v1.GlossaryTerm>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetGlossaryTerm"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.GetGlossaryTermRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.GlossaryTerm.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BusinessGlossaryServiceMethodDescriptorSupplier("GetGlossaryTerm"))
                      .build();
        }
      }
    }
    return getGetGlossaryTermMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.ListGlossaryTermsRequest,
          com.google.cloud.dataplex.v1.ListGlossaryTermsResponse>
      getListGlossaryTermsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListGlossaryTerms",
      requestType = com.google.cloud.dataplex.v1.ListGlossaryTermsRequest.class,
      responseType = com.google.cloud.dataplex.v1.ListGlossaryTermsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.ListGlossaryTermsRequest,
          com.google.cloud.dataplex.v1.ListGlossaryTermsResponse>
      getListGlossaryTermsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.ListGlossaryTermsRequest,
            com.google.cloud.dataplex.v1.ListGlossaryTermsResponse>
        getListGlossaryTermsMethod;
    if ((getListGlossaryTermsMethod = BusinessGlossaryServiceGrpc.getListGlossaryTermsMethod)
        == null) {
      synchronized (BusinessGlossaryServiceGrpc.class) {
        if ((getListGlossaryTermsMethod = BusinessGlossaryServiceGrpc.getListGlossaryTermsMethod)
            == null) {
          BusinessGlossaryServiceGrpc.getListGlossaryTermsMethod =
              getListGlossaryTermsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.ListGlossaryTermsRequest,
                          com.google.cloud.dataplex.v1.ListGlossaryTermsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListGlossaryTerms"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.ListGlossaryTermsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.ListGlossaryTermsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BusinessGlossaryServiceMethodDescriptorSupplier("ListGlossaryTerms"))
                      .build();
        }
      }
    }
    return getListGlossaryTermsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static BusinessGlossaryServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BusinessGlossaryServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BusinessGlossaryServiceStub>() {
          @java.lang.Override
          public BusinessGlossaryServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BusinessGlossaryServiceStub(channel, callOptions);
          }
        };
    return BusinessGlossaryServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static BusinessGlossaryServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BusinessGlossaryServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BusinessGlossaryServiceBlockingV2Stub>() {
          @java.lang.Override
          public BusinessGlossaryServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BusinessGlossaryServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return BusinessGlossaryServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BusinessGlossaryServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BusinessGlossaryServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BusinessGlossaryServiceBlockingStub>() {
          @java.lang.Override
          public BusinessGlossaryServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BusinessGlossaryServiceBlockingStub(channel, callOptions);
          }
        };
    return BusinessGlossaryServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static BusinessGlossaryServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BusinessGlossaryServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BusinessGlossaryServiceFutureStub>() {
          @java.lang.Override
          public BusinessGlossaryServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BusinessGlossaryServiceFutureStub(channel, callOptions);
          }
        };
    return BusinessGlossaryServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * BusinessGlossaryService provides APIs for managing business glossary
   * resources for enterprise customers.
   * The resources currently supported in Business Glossary are:
   * 1. Glossary
   * 2. GlossaryCategory
   * 3. GlossaryTerm
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a new Glossary resource.
     * </pre>
     */
    default void createGlossary(
        com.google.cloud.dataplex.v1.CreateGlossaryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateGlossaryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a Glossary resource.
     * </pre>
     */
    default void updateGlossary(
        com.google.cloud.dataplex.v1.UpdateGlossaryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateGlossaryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Glossary resource. All the categories and terms within the
     * Glossary must be deleted before the Glossary can be deleted.
     * </pre>
     */
    default void deleteGlossary(
        com.google.cloud.dataplex.v1.DeleteGlossaryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteGlossaryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a Glossary resource.
     * </pre>
     */
    default void getGlossary(
        com.google.cloud.dataplex.v1.GetGlossaryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Glossary> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetGlossaryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Glossary resources in a project and location.
     * </pre>
     */
    default void listGlossaries(
        com.google.cloud.dataplex.v1.ListGlossariesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListGlossariesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListGlossariesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new GlossaryCategory resource.
     * </pre>
     */
    default void createGlossaryCategory(
        com.google.cloud.dataplex.v1.CreateGlossaryCategoryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.GlossaryCategory>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateGlossaryCategoryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a GlossaryCategory resource.
     * </pre>
     */
    default void updateGlossaryCategory(
        com.google.cloud.dataplex.v1.UpdateGlossaryCategoryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.GlossaryCategory>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateGlossaryCategoryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a GlossaryCategory resource. All the GlossaryCategories and
     * GlossaryTerms nested directly under the specified GlossaryCategory will be
     * moved one level up to the parent in the hierarchy.
     * </pre>
     */
    default void deleteGlossaryCategory(
        com.google.cloud.dataplex.v1.DeleteGlossaryCategoryRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteGlossaryCategoryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a GlossaryCategory resource.
     * </pre>
     */
    default void getGlossaryCategory(
        com.google.cloud.dataplex.v1.GetGlossaryCategoryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.GlossaryCategory>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetGlossaryCategoryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists GlossaryCategory resources in a Glossary.
     * </pre>
     */
    default void listGlossaryCategories(
        com.google.cloud.dataplex.v1.ListGlossaryCategoriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListGlossaryCategoriesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListGlossaryCategoriesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new GlossaryTerm resource.
     * </pre>
     */
    default void createGlossaryTerm(
        com.google.cloud.dataplex.v1.CreateGlossaryTermRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.GlossaryTerm> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateGlossaryTermMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a GlossaryTerm resource.
     * </pre>
     */
    default void updateGlossaryTerm(
        com.google.cloud.dataplex.v1.UpdateGlossaryTermRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.GlossaryTerm> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateGlossaryTermMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a GlossaryTerm resource.
     * </pre>
     */
    default void deleteGlossaryTerm(
        com.google.cloud.dataplex.v1.DeleteGlossaryTermRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteGlossaryTermMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a GlossaryTerm resource.
     * </pre>
     */
    default void getGlossaryTerm(
        com.google.cloud.dataplex.v1.GetGlossaryTermRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.GlossaryTerm> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetGlossaryTermMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists GlossaryTerm resources in a Glossary.
     * </pre>
     */
    default void listGlossaryTerms(
        com.google.cloud.dataplex.v1.ListGlossaryTermsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListGlossaryTermsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListGlossaryTermsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service BusinessGlossaryService.
   *
   * <pre>
   * BusinessGlossaryService provides APIs for managing business glossary
   * resources for enterprise customers.
   * The resources currently supported in Business Glossary are:
   * 1. Glossary
   * 2. GlossaryCategory
   * 3. GlossaryTerm
   * </pre>
   */
  public abstract static class BusinessGlossaryServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return BusinessGlossaryServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service BusinessGlossaryService.
   *
   * <pre>
   * BusinessGlossaryService provides APIs for managing business glossary
   * resources for enterprise customers.
   * The resources currently supported in Business Glossary are:
   * 1. Glossary
   * 2. GlossaryCategory
   * 3. GlossaryTerm
   * </pre>
   */
  public static final class BusinessGlossaryServiceStub
      extends io.grpc.stub.AbstractAsyncStub<BusinessGlossaryServiceStub> {
    private BusinessGlossaryServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BusinessGlossaryServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BusinessGlossaryServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Glossary resource.
     * </pre>
     */
    public void createGlossary(
        com.google.cloud.dataplex.v1.CreateGlossaryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateGlossaryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a Glossary resource.
     * </pre>
     */
    public void updateGlossary(
        com.google.cloud.dataplex.v1.UpdateGlossaryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateGlossaryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Glossary resource. All the categories and terms within the
     * Glossary must be deleted before the Glossary can be deleted.
     * </pre>
     */
    public void deleteGlossary(
        com.google.cloud.dataplex.v1.DeleteGlossaryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteGlossaryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a Glossary resource.
     * </pre>
     */
    public void getGlossary(
        com.google.cloud.dataplex.v1.GetGlossaryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Glossary> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetGlossaryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Glossary resources in a project and location.
     * </pre>
     */
    public void listGlossaries(
        com.google.cloud.dataplex.v1.ListGlossariesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListGlossariesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListGlossariesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new GlossaryCategory resource.
     * </pre>
     */
    public void createGlossaryCategory(
        com.google.cloud.dataplex.v1.CreateGlossaryCategoryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.GlossaryCategory>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateGlossaryCategoryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a GlossaryCategory resource.
     * </pre>
     */
    public void updateGlossaryCategory(
        com.google.cloud.dataplex.v1.UpdateGlossaryCategoryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.GlossaryCategory>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateGlossaryCategoryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a GlossaryCategory resource. All the GlossaryCategories and
     * GlossaryTerms nested directly under the specified GlossaryCategory will be
     * moved one level up to the parent in the hierarchy.
     * </pre>
     */
    public void deleteGlossaryCategory(
        com.google.cloud.dataplex.v1.DeleteGlossaryCategoryRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteGlossaryCategoryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a GlossaryCategory resource.
     * </pre>
     */
    public void getGlossaryCategory(
        com.google.cloud.dataplex.v1.GetGlossaryCategoryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.GlossaryCategory>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetGlossaryCategoryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists GlossaryCategory resources in a Glossary.
     * </pre>
     */
    public void listGlossaryCategories(
        com.google.cloud.dataplex.v1.ListGlossaryCategoriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListGlossaryCategoriesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListGlossaryCategoriesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new GlossaryTerm resource.
     * </pre>
     */
    public void createGlossaryTerm(
        com.google.cloud.dataplex.v1.CreateGlossaryTermRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.GlossaryTerm> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateGlossaryTermMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a GlossaryTerm resource.
     * </pre>
     */
    public void updateGlossaryTerm(
        com.google.cloud.dataplex.v1.UpdateGlossaryTermRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.GlossaryTerm> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateGlossaryTermMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a GlossaryTerm resource.
     * </pre>
     */
    public void deleteGlossaryTerm(
        com.google.cloud.dataplex.v1.DeleteGlossaryTermRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteGlossaryTermMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a GlossaryTerm resource.
     * </pre>
     */
    public void getGlossaryTerm(
        com.google.cloud.dataplex.v1.GetGlossaryTermRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.GlossaryTerm> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetGlossaryTermMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists GlossaryTerm resources in a Glossary.
     * </pre>
     */
    public void listGlossaryTerms(
        com.google.cloud.dataplex.v1.ListGlossaryTermsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListGlossaryTermsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListGlossaryTermsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service BusinessGlossaryService.
   *
   * <pre>
   * BusinessGlossaryService provides APIs for managing business glossary
   * resources for enterprise customers.
   * The resources currently supported in Business Glossary are:
   * 1. Glossary
   * 2. GlossaryCategory
   * 3. GlossaryTerm
   * </pre>
   */
  public static final class BusinessGlossaryServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<BusinessGlossaryServiceBlockingV2Stub> {
    private BusinessGlossaryServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BusinessGlossaryServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BusinessGlossaryServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Glossary resource.
     * </pre>
     */
    public com.google.longrunning.Operation createGlossary(
        com.google.cloud.dataplex.v1.CreateGlossaryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateGlossaryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a Glossary resource.
     * </pre>
     */
    public com.google.longrunning.Operation updateGlossary(
        com.google.cloud.dataplex.v1.UpdateGlossaryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateGlossaryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Glossary resource. All the categories and terms within the
     * Glossary must be deleted before the Glossary can be deleted.
     * </pre>
     */
    public com.google.longrunning.Operation deleteGlossary(
        com.google.cloud.dataplex.v1.DeleteGlossaryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteGlossaryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a Glossary resource.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.Glossary getGlossary(
        com.google.cloud.dataplex.v1.GetGlossaryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetGlossaryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Glossary resources in a project and location.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.ListGlossariesResponse listGlossaries(
        com.google.cloud.dataplex.v1.ListGlossariesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListGlossariesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new GlossaryCategory resource.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.GlossaryCategory createGlossaryCategory(
        com.google.cloud.dataplex.v1.CreateGlossaryCategoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateGlossaryCategoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a GlossaryCategory resource.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.GlossaryCategory updateGlossaryCategory(
        com.google.cloud.dataplex.v1.UpdateGlossaryCategoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateGlossaryCategoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a GlossaryCategory resource. All the GlossaryCategories and
     * GlossaryTerms nested directly under the specified GlossaryCategory will be
     * moved one level up to the parent in the hierarchy.
     * </pre>
     */
    public com.google.protobuf.Empty deleteGlossaryCategory(
        com.google.cloud.dataplex.v1.DeleteGlossaryCategoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteGlossaryCategoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a GlossaryCategory resource.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.GlossaryCategory getGlossaryCategory(
        com.google.cloud.dataplex.v1.GetGlossaryCategoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetGlossaryCategoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists GlossaryCategory resources in a Glossary.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.ListGlossaryCategoriesResponse listGlossaryCategories(
        com.google.cloud.dataplex.v1.ListGlossaryCategoriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListGlossaryCategoriesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new GlossaryTerm resource.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.GlossaryTerm createGlossaryTerm(
        com.google.cloud.dataplex.v1.CreateGlossaryTermRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateGlossaryTermMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a GlossaryTerm resource.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.GlossaryTerm updateGlossaryTerm(
        com.google.cloud.dataplex.v1.UpdateGlossaryTermRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateGlossaryTermMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a GlossaryTerm resource.
     * </pre>
     */
    public com.google.protobuf.Empty deleteGlossaryTerm(
        com.google.cloud.dataplex.v1.DeleteGlossaryTermRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteGlossaryTermMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a GlossaryTerm resource.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.GlossaryTerm getGlossaryTerm(
        com.google.cloud.dataplex.v1.GetGlossaryTermRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetGlossaryTermMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists GlossaryTerm resources in a Glossary.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.ListGlossaryTermsResponse listGlossaryTerms(
        com.google.cloud.dataplex.v1.ListGlossaryTermsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListGlossaryTermsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service BusinessGlossaryService.
   *
   * <pre>
   * BusinessGlossaryService provides APIs for managing business glossary
   * resources for enterprise customers.
   * The resources currently supported in Business Glossary are:
   * 1. Glossary
   * 2. GlossaryCategory
   * 3. GlossaryTerm
   * </pre>
   */
  public static final class BusinessGlossaryServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<BusinessGlossaryServiceBlockingStub> {
    private BusinessGlossaryServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BusinessGlossaryServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BusinessGlossaryServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Glossary resource.
     * </pre>
     */
    public com.google.longrunning.Operation createGlossary(
        com.google.cloud.dataplex.v1.CreateGlossaryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateGlossaryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a Glossary resource.
     * </pre>
     */
    public com.google.longrunning.Operation updateGlossary(
        com.google.cloud.dataplex.v1.UpdateGlossaryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateGlossaryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Glossary resource. All the categories and terms within the
     * Glossary must be deleted before the Glossary can be deleted.
     * </pre>
     */
    public com.google.longrunning.Operation deleteGlossary(
        com.google.cloud.dataplex.v1.DeleteGlossaryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteGlossaryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a Glossary resource.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.Glossary getGlossary(
        com.google.cloud.dataplex.v1.GetGlossaryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetGlossaryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Glossary resources in a project and location.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.ListGlossariesResponse listGlossaries(
        com.google.cloud.dataplex.v1.ListGlossariesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListGlossariesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new GlossaryCategory resource.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.GlossaryCategory createGlossaryCategory(
        com.google.cloud.dataplex.v1.CreateGlossaryCategoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateGlossaryCategoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a GlossaryCategory resource.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.GlossaryCategory updateGlossaryCategory(
        com.google.cloud.dataplex.v1.UpdateGlossaryCategoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateGlossaryCategoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a GlossaryCategory resource. All the GlossaryCategories and
     * GlossaryTerms nested directly under the specified GlossaryCategory will be
     * moved one level up to the parent in the hierarchy.
     * </pre>
     */
    public com.google.protobuf.Empty deleteGlossaryCategory(
        com.google.cloud.dataplex.v1.DeleteGlossaryCategoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteGlossaryCategoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a GlossaryCategory resource.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.GlossaryCategory getGlossaryCategory(
        com.google.cloud.dataplex.v1.GetGlossaryCategoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetGlossaryCategoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists GlossaryCategory resources in a Glossary.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.ListGlossaryCategoriesResponse listGlossaryCategories(
        com.google.cloud.dataplex.v1.ListGlossaryCategoriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListGlossaryCategoriesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new GlossaryTerm resource.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.GlossaryTerm createGlossaryTerm(
        com.google.cloud.dataplex.v1.CreateGlossaryTermRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateGlossaryTermMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a GlossaryTerm resource.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.GlossaryTerm updateGlossaryTerm(
        com.google.cloud.dataplex.v1.UpdateGlossaryTermRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateGlossaryTermMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a GlossaryTerm resource.
     * </pre>
     */
    public com.google.protobuf.Empty deleteGlossaryTerm(
        com.google.cloud.dataplex.v1.DeleteGlossaryTermRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteGlossaryTermMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a GlossaryTerm resource.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.GlossaryTerm getGlossaryTerm(
        com.google.cloud.dataplex.v1.GetGlossaryTermRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetGlossaryTermMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists GlossaryTerm resources in a Glossary.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.ListGlossaryTermsResponse listGlossaryTerms(
        com.google.cloud.dataplex.v1.ListGlossaryTermsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListGlossaryTermsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * BusinessGlossaryService.
   *
   * <pre>
   * BusinessGlossaryService provides APIs for managing business glossary
   * resources for enterprise customers.
   * The resources currently supported in Business Glossary are:
   * 1. Glossary
   * 2. GlossaryCategory
   * 3. GlossaryTerm
   * </pre>
   */
  public static final class BusinessGlossaryServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<BusinessGlossaryServiceFutureStub> {
    private BusinessGlossaryServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BusinessGlossaryServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BusinessGlossaryServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Glossary resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createGlossary(com.google.cloud.dataplex.v1.CreateGlossaryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateGlossaryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a Glossary resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateGlossary(com.google.cloud.dataplex.v1.UpdateGlossaryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateGlossaryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Glossary resource. All the categories and terms within the
     * Glossary must be deleted before the Glossary can be deleted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteGlossary(com.google.cloud.dataplex.v1.DeleteGlossaryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteGlossaryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a Glossary resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.Glossary>
        getGlossary(com.google.cloud.dataplex.v1.GetGlossaryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetGlossaryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Glossary resources in a project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataplex.v1.ListGlossariesResponse>
        listGlossaries(com.google.cloud.dataplex.v1.ListGlossariesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListGlossariesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new GlossaryCategory resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataplex.v1.GlossaryCategory>
        createGlossaryCategory(com.google.cloud.dataplex.v1.CreateGlossaryCategoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateGlossaryCategoryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a GlossaryCategory resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataplex.v1.GlossaryCategory>
        updateGlossaryCategory(com.google.cloud.dataplex.v1.UpdateGlossaryCategoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateGlossaryCategoryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a GlossaryCategory resource. All the GlossaryCategories and
     * GlossaryTerms nested directly under the specified GlossaryCategory will be
     * moved one level up to the parent in the hierarchy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteGlossaryCategory(com.google.cloud.dataplex.v1.DeleteGlossaryCategoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteGlossaryCategoryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a GlossaryCategory resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataplex.v1.GlossaryCategory>
        getGlossaryCategory(com.google.cloud.dataplex.v1.GetGlossaryCategoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetGlossaryCategoryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists GlossaryCategory resources in a Glossary.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataplex.v1.ListGlossaryCategoriesResponse>
        listGlossaryCategories(com.google.cloud.dataplex.v1.ListGlossaryCategoriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListGlossaryCategoriesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new GlossaryTerm resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataplex.v1.GlossaryTerm>
        createGlossaryTerm(com.google.cloud.dataplex.v1.CreateGlossaryTermRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateGlossaryTermMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a GlossaryTerm resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataplex.v1.GlossaryTerm>
        updateGlossaryTerm(com.google.cloud.dataplex.v1.UpdateGlossaryTermRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateGlossaryTermMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a GlossaryTerm resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteGlossaryTerm(com.google.cloud.dataplex.v1.DeleteGlossaryTermRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteGlossaryTermMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a GlossaryTerm resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataplex.v1.GlossaryTerm>
        getGlossaryTerm(com.google.cloud.dataplex.v1.GetGlossaryTermRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetGlossaryTermMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists GlossaryTerm resources in a Glossary.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataplex.v1.ListGlossaryTermsResponse>
        listGlossaryTerms(com.google.cloud.dataplex.v1.ListGlossaryTermsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListGlossaryTermsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_GLOSSARY = 0;
  private static final int METHODID_UPDATE_GLOSSARY = 1;
  private static final int METHODID_DELETE_GLOSSARY = 2;
  private static final int METHODID_GET_GLOSSARY = 3;
  private static final int METHODID_LIST_GLOSSARIES = 4;
  private static final int METHODID_CREATE_GLOSSARY_CATEGORY = 5;
  private static final int METHODID_UPDATE_GLOSSARY_CATEGORY = 6;
  private static final int METHODID_DELETE_GLOSSARY_CATEGORY = 7;
  private static final int METHODID_GET_GLOSSARY_CATEGORY = 8;
  private static final int METHODID_LIST_GLOSSARY_CATEGORIES = 9;
  private static final int METHODID_CREATE_GLOSSARY_TERM = 10;
  private static final int METHODID_UPDATE_GLOSSARY_TERM = 11;
  private static final int METHODID_DELETE_GLOSSARY_TERM = 12;
  private static final int METHODID_GET_GLOSSARY_TERM = 13;
  private static final int METHODID_LIST_GLOSSARY_TERMS = 14;

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
        case METHODID_CREATE_GLOSSARY:
          serviceImpl.createGlossary(
              (com.google.cloud.dataplex.v1.CreateGlossaryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_GLOSSARY:
          serviceImpl.updateGlossary(
              (com.google.cloud.dataplex.v1.UpdateGlossaryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_GLOSSARY:
          serviceImpl.deleteGlossary(
              (com.google.cloud.dataplex.v1.DeleteGlossaryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_GLOSSARY:
          serviceImpl.getGlossary(
              (com.google.cloud.dataplex.v1.GetGlossaryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Glossary>)
                  responseObserver);
          break;
        case METHODID_LIST_GLOSSARIES:
          serviceImpl.listGlossaries(
              (com.google.cloud.dataplex.v1.ListGlossariesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListGlossariesResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_GLOSSARY_CATEGORY:
          serviceImpl.createGlossaryCategory(
              (com.google.cloud.dataplex.v1.CreateGlossaryCategoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.GlossaryCategory>)
                  responseObserver);
          break;
        case METHODID_UPDATE_GLOSSARY_CATEGORY:
          serviceImpl.updateGlossaryCategory(
              (com.google.cloud.dataplex.v1.UpdateGlossaryCategoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.GlossaryCategory>)
                  responseObserver);
          break;
        case METHODID_DELETE_GLOSSARY_CATEGORY:
          serviceImpl.deleteGlossaryCategory(
              (com.google.cloud.dataplex.v1.DeleteGlossaryCategoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_GLOSSARY_CATEGORY:
          serviceImpl.getGlossaryCategory(
              (com.google.cloud.dataplex.v1.GetGlossaryCategoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.GlossaryCategory>)
                  responseObserver);
          break;
        case METHODID_LIST_GLOSSARY_CATEGORIES:
          serviceImpl.listGlossaryCategories(
              (com.google.cloud.dataplex.v1.ListGlossaryCategoriesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dataplex.v1.ListGlossaryCategoriesResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_GLOSSARY_TERM:
          serviceImpl.createGlossaryTerm(
              (com.google.cloud.dataplex.v1.CreateGlossaryTermRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.GlossaryTerm>)
                  responseObserver);
          break;
        case METHODID_UPDATE_GLOSSARY_TERM:
          serviceImpl.updateGlossaryTerm(
              (com.google.cloud.dataplex.v1.UpdateGlossaryTermRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.GlossaryTerm>)
                  responseObserver);
          break;
        case METHODID_DELETE_GLOSSARY_TERM:
          serviceImpl.deleteGlossaryTerm(
              (com.google.cloud.dataplex.v1.DeleteGlossaryTermRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_GLOSSARY_TERM:
          serviceImpl.getGlossaryTerm(
              (com.google.cloud.dataplex.v1.GetGlossaryTermRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.GlossaryTerm>)
                  responseObserver);
          break;
        case METHODID_LIST_GLOSSARY_TERMS:
          serviceImpl.listGlossaryTerms(
              (com.google.cloud.dataplex.v1.ListGlossaryTermsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListGlossaryTermsResponse>)
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
            getCreateGlossaryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.CreateGlossaryRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_GLOSSARY)))
        .addMethod(
            getUpdateGlossaryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.UpdateGlossaryRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_GLOSSARY)))
        .addMethod(
            getDeleteGlossaryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.DeleteGlossaryRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_GLOSSARY)))
        .addMethod(
            getGetGlossaryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.GetGlossaryRequest,
                    com.google.cloud.dataplex.v1.Glossary>(service, METHODID_GET_GLOSSARY)))
        .addMethod(
            getListGlossariesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.ListGlossariesRequest,
                    com.google.cloud.dataplex.v1.ListGlossariesResponse>(
                    service, METHODID_LIST_GLOSSARIES)))
        .addMethod(
            getCreateGlossaryCategoryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.CreateGlossaryCategoryRequest,
                    com.google.cloud.dataplex.v1.GlossaryCategory>(
                    service, METHODID_CREATE_GLOSSARY_CATEGORY)))
        .addMethod(
            getUpdateGlossaryCategoryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.UpdateGlossaryCategoryRequest,
                    com.google.cloud.dataplex.v1.GlossaryCategory>(
                    service, METHODID_UPDATE_GLOSSARY_CATEGORY)))
        .addMethod(
            getDeleteGlossaryCategoryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.DeleteGlossaryCategoryRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_GLOSSARY_CATEGORY)))
        .addMethod(
            getGetGlossaryCategoryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.GetGlossaryCategoryRequest,
                    com.google.cloud.dataplex.v1.GlossaryCategory>(
                    service, METHODID_GET_GLOSSARY_CATEGORY)))
        .addMethod(
            getListGlossaryCategoriesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.ListGlossaryCategoriesRequest,
                    com.google.cloud.dataplex.v1.ListGlossaryCategoriesResponse>(
                    service, METHODID_LIST_GLOSSARY_CATEGORIES)))
        .addMethod(
            getCreateGlossaryTermMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.CreateGlossaryTermRequest,
                    com.google.cloud.dataplex.v1.GlossaryTerm>(
                    service, METHODID_CREATE_GLOSSARY_TERM)))
        .addMethod(
            getUpdateGlossaryTermMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.UpdateGlossaryTermRequest,
                    com.google.cloud.dataplex.v1.GlossaryTerm>(
                    service, METHODID_UPDATE_GLOSSARY_TERM)))
        .addMethod(
            getDeleteGlossaryTermMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.DeleteGlossaryTermRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_GLOSSARY_TERM)))
        .addMethod(
            getGetGlossaryTermMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.GetGlossaryTermRequest,
                    com.google.cloud.dataplex.v1.GlossaryTerm>(
                    service, METHODID_GET_GLOSSARY_TERM)))
        .addMethod(
            getListGlossaryTermsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.ListGlossaryTermsRequest,
                    com.google.cloud.dataplex.v1.ListGlossaryTermsResponse>(
                    service, METHODID_LIST_GLOSSARY_TERMS)))
        .build();
  }

  private abstract static class BusinessGlossaryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BusinessGlossaryServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dataplex.v1.BusinessGlossaryProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BusinessGlossaryService");
    }
  }

  private static final class BusinessGlossaryServiceFileDescriptorSupplier
      extends BusinessGlossaryServiceBaseDescriptorSupplier {
    BusinessGlossaryServiceFileDescriptorSupplier() {}
  }

  private static final class BusinessGlossaryServiceMethodDescriptorSupplier
      extends BusinessGlossaryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    BusinessGlossaryServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (BusinessGlossaryServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new BusinessGlossaryServiceFileDescriptorSupplier())
                      .addMethod(getCreateGlossaryMethod())
                      .addMethod(getUpdateGlossaryMethod())
                      .addMethod(getDeleteGlossaryMethod())
                      .addMethod(getGetGlossaryMethod())
                      .addMethod(getListGlossariesMethod())
                      .addMethod(getCreateGlossaryCategoryMethod())
                      .addMethod(getUpdateGlossaryCategoryMethod())
                      .addMethod(getDeleteGlossaryCategoryMethod())
                      .addMethod(getGetGlossaryCategoryMethod())
                      .addMethod(getListGlossaryCategoriesMethod())
                      .addMethod(getCreateGlossaryTermMethod())
                      .addMethod(getUpdateGlossaryTermMethod())
                      .addMethod(getDeleteGlossaryTermMethod())
                      .addMethod(getGetGlossaryTermMethod())
                      .addMethod(getListGlossaryTermsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
