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
package com.google.cloud.aiplatform.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The service that handles CRUD and List for resources for Featurestore.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/aiplatform/v1/featurestore_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FeaturestoreServiceGrpc {

  private FeaturestoreServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.aiplatform.v1.FeaturestoreService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.CreateFeaturestoreRequest,
          com.google.longrunning.Operation>
      getCreateFeaturestoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFeaturestore",
      requestType = com.google.cloud.aiplatform.v1.CreateFeaturestoreRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.CreateFeaturestoreRequest,
          com.google.longrunning.Operation>
      getCreateFeaturestoreMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.CreateFeaturestoreRequest,
            com.google.longrunning.Operation>
        getCreateFeaturestoreMethod;
    if ((getCreateFeaturestoreMethod = FeaturestoreServiceGrpc.getCreateFeaturestoreMethod)
        == null) {
      synchronized (FeaturestoreServiceGrpc.class) {
        if ((getCreateFeaturestoreMethod = FeaturestoreServiceGrpc.getCreateFeaturestoreMethod)
            == null) {
          FeaturestoreServiceGrpc.getCreateFeaturestoreMethod =
              getCreateFeaturestoreMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.CreateFeaturestoreRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateFeaturestore"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.CreateFeaturestoreRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeaturestoreServiceMethodDescriptorSupplier("CreateFeaturestore"))
                      .build();
        }
      }
    }
    return getCreateFeaturestoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.GetFeaturestoreRequest,
          com.google.cloud.aiplatform.v1.Featurestore>
      getGetFeaturestoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFeaturestore",
      requestType = com.google.cloud.aiplatform.v1.GetFeaturestoreRequest.class,
      responseType = com.google.cloud.aiplatform.v1.Featurestore.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.GetFeaturestoreRequest,
          com.google.cloud.aiplatform.v1.Featurestore>
      getGetFeaturestoreMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.GetFeaturestoreRequest,
            com.google.cloud.aiplatform.v1.Featurestore>
        getGetFeaturestoreMethod;
    if ((getGetFeaturestoreMethod = FeaturestoreServiceGrpc.getGetFeaturestoreMethod) == null) {
      synchronized (FeaturestoreServiceGrpc.class) {
        if ((getGetFeaturestoreMethod = FeaturestoreServiceGrpc.getGetFeaturestoreMethod) == null) {
          FeaturestoreServiceGrpc.getGetFeaturestoreMethod =
              getGetFeaturestoreMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.GetFeaturestoreRequest,
                          com.google.cloud.aiplatform.v1.Featurestore>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFeaturestore"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.GetFeaturestoreRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.Featurestore.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeaturestoreServiceMethodDescriptorSupplier("GetFeaturestore"))
                      .build();
        }
      }
    }
    return getGetFeaturestoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListFeaturestoresRequest,
          com.google.cloud.aiplatform.v1.ListFeaturestoresResponse>
      getListFeaturestoresMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFeaturestores",
      requestType = com.google.cloud.aiplatform.v1.ListFeaturestoresRequest.class,
      responseType = com.google.cloud.aiplatform.v1.ListFeaturestoresResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListFeaturestoresRequest,
          com.google.cloud.aiplatform.v1.ListFeaturestoresResponse>
      getListFeaturestoresMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.ListFeaturestoresRequest,
            com.google.cloud.aiplatform.v1.ListFeaturestoresResponse>
        getListFeaturestoresMethod;
    if ((getListFeaturestoresMethod = FeaturestoreServiceGrpc.getListFeaturestoresMethod) == null) {
      synchronized (FeaturestoreServiceGrpc.class) {
        if ((getListFeaturestoresMethod = FeaturestoreServiceGrpc.getListFeaturestoresMethod)
            == null) {
          FeaturestoreServiceGrpc.getListFeaturestoresMethod =
              getListFeaturestoresMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.ListFeaturestoresRequest,
                          com.google.cloud.aiplatform.v1.ListFeaturestoresResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListFeaturestores"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListFeaturestoresRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListFeaturestoresResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeaturestoreServiceMethodDescriptorSupplier("ListFeaturestores"))
                      .build();
        }
      }
    }
    return getListFeaturestoresMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.UpdateFeaturestoreRequest,
          com.google.longrunning.Operation>
      getUpdateFeaturestoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateFeaturestore",
      requestType = com.google.cloud.aiplatform.v1.UpdateFeaturestoreRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.UpdateFeaturestoreRequest,
          com.google.longrunning.Operation>
      getUpdateFeaturestoreMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.UpdateFeaturestoreRequest,
            com.google.longrunning.Operation>
        getUpdateFeaturestoreMethod;
    if ((getUpdateFeaturestoreMethod = FeaturestoreServiceGrpc.getUpdateFeaturestoreMethod)
        == null) {
      synchronized (FeaturestoreServiceGrpc.class) {
        if ((getUpdateFeaturestoreMethod = FeaturestoreServiceGrpc.getUpdateFeaturestoreMethod)
            == null) {
          FeaturestoreServiceGrpc.getUpdateFeaturestoreMethod =
              getUpdateFeaturestoreMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.UpdateFeaturestoreRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateFeaturestore"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.UpdateFeaturestoreRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeaturestoreServiceMethodDescriptorSupplier("UpdateFeaturestore"))
                      .build();
        }
      }
    }
    return getUpdateFeaturestoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.DeleteFeaturestoreRequest,
          com.google.longrunning.Operation>
      getDeleteFeaturestoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteFeaturestore",
      requestType = com.google.cloud.aiplatform.v1.DeleteFeaturestoreRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.DeleteFeaturestoreRequest,
          com.google.longrunning.Operation>
      getDeleteFeaturestoreMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.DeleteFeaturestoreRequest,
            com.google.longrunning.Operation>
        getDeleteFeaturestoreMethod;
    if ((getDeleteFeaturestoreMethod = FeaturestoreServiceGrpc.getDeleteFeaturestoreMethod)
        == null) {
      synchronized (FeaturestoreServiceGrpc.class) {
        if ((getDeleteFeaturestoreMethod = FeaturestoreServiceGrpc.getDeleteFeaturestoreMethod)
            == null) {
          FeaturestoreServiceGrpc.getDeleteFeaturestoreMethod =
              getDeleteFeaturestoreMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.DeleteFeaturestoreRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteFeaturestore"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.DeleteFeaturestoreRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeaturestoreServiceMethodDescriptorSupplier("DeleteFeaturestore"))
                      .build();
        }
      }
    }
    return getDeleteFeaturestoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.CreateEntityTypeRequest, com.google.longrunning.Operation>
      getCreateEntityTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEntityType",
      requestType = com.google.cloud.aiplatform.v1.CreateEntityTypeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.CreateEntityTypeRequest, com.google.longrunning.Operation>
      getCreateEntityTypeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.CreateEntityTypeRequest,
            com.google.longrunning.Operation>
        getCreateEntityTypeMethod;
    if ((getCreateEntityTypeMethod = FeaturestoreServiceGrpc.getCreateEntityTypeMethod) == null) {
      synchronized (FeaturestoreServiceGrpc.class) {
        if ((getCreateEntityTypeMethod = FeaturestoreServiceGrpc.getCreateEntityTypeMethod)
            == null) {
          FeaturestoreServiceGrpc.getCreateEntityTypeMethod =
              getCreateEntityTypeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.CreateEntityTypeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateEntityType"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.CreateEntityTypeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeaturestoreServiceMethodDescriptorSupplier("CreateEntityType"))
                      .build();
        }
      }
    }
    return getCreateEntityTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.GetEntityTypeRequest,
          com.google.cloud.aiplatform.v1.EntityType>
      getGetEntityTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEntityType",
      requestType = com.google.cloud.aiplatform.v1.GetEntityTypeRequest.class,
      responseType = com.google.cloud.aiplatform.v1.EntityType.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.GetEntityTypeRequest,
          com.google.cloud.aiplatform.v1.EntityType>
      getGetEntityTypeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.GetEntityTypeRequest,
            com.google.cloud.aiplatform.v1.EntityType>
        getGetEntityTypeMethod;
    if ((getGetEntityTypeMethod = FeaturestoreServiceGrpc.getGetEntityTypeMethod) == null) {
      synchronized (FeaturestoreServiceGrpc.class) {
        if ((getGetEntityTypeMethod = FeaturestoreServiceGrpc.getGetEntityTypeMethod) == null) {
          FeaturestoreServiceGrpc.getGetEntityTypeMethod =
              getGetEntityTypeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.GetEntityTypeRequest,
                          com.google.cloud.aiplatform.v1.EntityType>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEntityType"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.GetEntityTypeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.EntityType.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeaturestoreServiceMethodDescriptorSupplier("GetEntityType"))
                      .build();
        }
      }
    }
    return getGetEntityTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListEntityTypesRequest,
          com.google.cloud.aiplatform.v1.ListEntityTypesResponse>
      getListEntityTypesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEntityTypes",
      requestType = com.google.cloud.aiplatform.v1.ListEntityTypesRequest.class,
      responseType = com.google.cloud.aiplatform.v1.ListEntityTypesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListEntityTypesRequest,
          com.google.cloud.aiplatform.v1.ListEntityTypesResponse>
      getListEntityTypesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.ListEntityTypesRequest,
            com.google.cloud.aiplatform.v1.ListEntityTypesResponse>
        getListEntityTypesMethod;
    if ((getListEntityTypesMethod = FeaturestoreServiceGrpc.getListEntityTypesMethod) == null) {
      synchronized (FeaturestoreServiceGrpc.class) {
        if ((getListEntityTypesMethod = FeaturestoreServiceGrpc.getListEntityTypesMethod) == null) {
          FeaturestoreServiceGrpc.getListEntityTypesMethod =
              getListEntityTypesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.ListEntityTypesRequest,
                          com.google.cloud.aiplatform.v1.ListEntityTypesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEntityTypes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListEntityTypesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListEntityTypesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeaturestoreServiceMethodDescriptorSupplier("ListEntityTypes"))
                      .build();
        }
      }
    }
    return getListEntityTypesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.UpdateEntityTypeRequest,
          com.google.cloud.aiplatform.v1.EntityType>
      getUpdateEntityTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEntityType",
      requestType = com.google.cloud.aiplatform.v1.UpdateEntityTypeRequest.class,
      responseType = com.google.cloud.aiplatform.v1.EntityType.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.UpdateEntityTypeRequest,
          com.google.cloud.aiplatform.v1.EntityType>
      getUpdateEntityTypeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.UpdateEntityTypeRequest,
            com.google.cloud.aiplatform.v1.EntityType>
        getUpdateEntityTypeMethod;
    if ((getUpdateEntityTypeMethod = FeaturestoreServiceGrpc.getUpdateEntityTypeMethod) == null) {
      synchronized (FeaturestoreServiceGrpc.class) {
        if ((getUpdateEntityTypeMethod = FeaturestoreServiceGrpc.getUpdateEntityTypeMethod)
            == null) {
          FeaturestoreServiceGrpc.getUpdateEntityTypeMethod =
              getUpdateEntityTypeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.UpdateEntityTypeRequest,
                          com.google.cloud.aiplatform.v1.EntityType>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateEntityType"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.UpdateEntityTypeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.EntityType.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeaturestoreServiceMethodDescriptorSupplier("UpdateEntityType"))
                      .build();
        }
      }
    }
    return getUpdateEntityTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.DeleteEntityTypeRequest, com.google.longrunning.Operation>
      getDeleteEntityTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEntityType",
      requestType = com.google.cloud.aiplatform.v1.DeleteEntityTypeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.DeleteEntityTypeRequest, com.google.longrunning.Operation>
      getDeleteEntityTypeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.DeleteEntityTypeRequest,
            com.google.longrunning.Operation>
        getDeleteEntityTypeMethod;
    if ((getDeleteEntityTypeMethod = FeaturestoreServiceGrpc.getDeleteEntityTypeMethod) == null) {
      synchronized (FeaturestoreServiceGrpc.class) {
        if ((getDeleteEntityTypeMethod = FeaturestoreServiceGrpc.getDeleteEntityTypeMethod)
            == null) {
          FeaturestoreServiceGrpc.getDeleteEntityTypeMethod =
              getDeleteEntityTypeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.DeleteEntityTypeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteEntityType"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.DeleteEntityTypeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeaturestoreServiceMethodDescriptorSupplier("DeleteEntityType"))
                      .build();
        }
      }
    }
    return getDeleteEntityTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.CreateFeatureRequest, com.google.longrunning.Operation>
      getCreateFeatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFeature",
      requestType = com.google.cloud.aiplatform.v1.CreateFeatureRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.CreateFeatureRequest, com.google.longrunning.Operation>
      getCreateFeatureMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.CreateFeatureRequest, com.google.longrunning.Operation>
        getCreateFeatureMethod;
    if ((getCreateFeatureMethod = FeaturestoreServiceGrpc.getCreateFeatureMethod) == null) {
      synchronized (FeaturestoreServiceGrpc.class) {
        if ((getCreateFeatureMethod = FeaturestoreServiceGrpc.getCreateFeatureMethod) == null) {
          FeaturestoreServiceGrpc.getCreateFeatureMethod =
              getCreateFeatureMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.CreateFeatureRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateFeature"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.CreateFeatureRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeaturestoreServiceMethodDescriptorSupplier("CreateFeature"))
                      .build();
        }
      }
    }
    return getCreateFeatureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.BatchCreateFeaturesRequest,
          com.google.longrunning.Operation>
      getBatchCreateFeaturesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchCreateFeatures",
      requestType = com.google.cloud.aiplatform.v1.BatchCreateFeaturesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.BatchCreateFeaturesRequest,
          com.google.longrunning.Operation>
      getBatchCreateFeaturesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.BatchCreateFeaturesRequest,
            com.google.longrunning.Operation>
        getBatchCreateFeaturesMethod;
    if ((getBatchCreateFeaturesMethod = FeaturestoreServiceGrpc.getBatchCreateFeaturesMethod)
        == null) {
      synchronized (FeaturestoreServiceGrpc.class) {
        if ((getBatchCreateFeaturesMethod = FeaturestoreServiceGrpc.getBatchCreateFeaturesMethod)
            == null) {
          FeaturestoreServiceGrpc.getBatchCreateFeaturesMethod =
              getBatchCreateFeaturesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.BatchCreateFeaturesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchCreateFeatures"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.BatchCreateFeaturesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeaturestoreServiceMethodDescriptorSupplier("BatchCreateFeatures"))
                      .build();
        }
      }
    }
    return getBatchCreateFeaturesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.GetFeatureRequest, com.google.cloud.aiplatform.v1.Feature>
      getGetFeatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFeature",
      requestType = com.google.cloud.aiplatform.v1.GetFeatureRequest.class,
      responseType = com.google.cloud.aiplatform.v1.Feature.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.GetFeatureRequest, com.google.cloud.aiplatform.v1.Feature>
      getGetFeatureMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.GetFeatureRequest,
            com.google.cloud.aiplatform.v1.Feature>
        getGetFeatureMethod;
    if ((getGetFeatureMethod = FeaturestoreServiceGrpc.getGetFeatureMethod) == null) {
      synchronized (FeaturestoreServiceGrpc.class) {
        if ((getGetFeatureMethod = FeaturestoreServiceGrpc.getGetFeatureMethod) == null) {
          FeaturestoreServiceGrpc.getGetFeatureMethod =
              getGetFeatureMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.GetFeatureRequest,
                          com.google.cloud.aiplatform.v1.Feature>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFeature"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.GetFeatureRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.Feature.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeaturestoreServiceMethodDescriptorSupplier("GetFeature"))
                      .build();
        }
      }
    }
    return getGetFeatureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListFeaturesRequest,
          com.google.cloud.aiplatform.v1.ListFeaturesResponse>
      getListFeaturesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFeatures",
      requestType = com.google.cloud.aiplatform.v1.ListFeaturesRequest.class,
      responseType = com.google.cloud.aiplatform.v1.ListFeaturesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListFeaturesRequest,
          com.google.cloud.aiplatform.v1.ListFeaturesResponse>
      getListFeaturesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.ListFeaturesRequest,
            com.google.cloud.aiplatform.v1.ListFeaturesResponse>
        getListFeaturesMethod;
    if ((getListFeaturesMethod = FeaturestoreServiceGrpc.getListFeaturesMethod) == null) {
      synchronized (FeaturestoreServiceGrpc.class) {
        if ((getListFeaturesMethod = FeaturestoreServiceGrpc.getListFeaturesMethod) == null) {
          FeaturestoreServiceGrpc.getListFeaturesMethod =
              getListFeaturesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.ListFeaturesRequest,
                          com.google.cloud.aiplatform.v1.ListFeaturesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListFeatures"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListFeaturesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListFeaturesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeaturestoreServiceMethodDescriptorSupplier("ListFeatures"))
                      .build();
        }
      }
    }
    return getListFeaturesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.UpdateFeatureRequest,
          com.google.cloud.aiplatform.v1.Feature>
      getUpdateFeatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateFeature",
      requestType = com.google.cloud.aiplatform.v1.UpdateFeatureRequest.class,
      responseType = com.google.cloud.aiplatform.v1.Feature.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.UpdateFeatureRequest,
          com.google.cloud.aiplatform.v1.Feature>
      getUpdateFeatureMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.UpdateFeatureRequest,
            com.google.cloud.aiplatform.v1.Feature>
        getUpdateFeatureMethod;
    if ((getUpdateFeatureMethod = FeaturestoreServiceGrpc.getUpdateFeatureMethod) == null) {
      synchronized (FeaturestoreServiceGrpc.class) {
        if ((getUpdateFeatureMethod = FeaturestoreServiceGrpc.getUpdateFeatureMethod) == null) {
          FeaturestoreServiceGrpc.getUpdateFeatureMethod =
              getUpdateFeatureMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.UpdateFeatureRequest,
                          com.google.cloud.aiplatform.v1.Feature>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateFeature"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.UpdateFeatureRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.Feature.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeaturestoreServiceMethodDescriptorSupplier("UpdateFeature"))
                      .build();
        }
      }
    }
    return getUpdateFeatureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.DeleteFeatureRequest, com.google.longrunning.Operation>
      getDeleteFeatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteFeature",
      requestType = com.google.cloud.aiplatform.v1.DeleteFeatureRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.DeleteFeatureRequest, com.google.longrunning.Operation>
      getDeleteFeatureMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.DeleteFeatureRequest, com.google.longrunning.Operation>
        getDeleteFeatureMethod;
    if ((getDeleteFeatureMethod = FeaturestoreServiceGrpc.getDeleteFeatureMethod) == null) {
      synchronized (FeaturestoreServiceGrpc.class) {
        if ((getDeleteFeatureMethod = FeaturestoreServiceGrpc.getDeleteFeatureMethod) == null) {
          FeaturestoreServiceGrpc.getDeleteFeatureMethod =
              getDeleteFeatureMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.DeleteFeatureRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteFeature"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.DeleteFeatureRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeaturestoreServiceMethodDescriptorSupplier("DeleteFeature"))
                      .build();
        }
      }
    }
    return getDeleteFeatureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ImportFeatureValuesRequest,
          com.google.longrunning.Operation>
      getImportFeatureValuesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportFeatureValues",
      requestType = com.google.cloud.aiplatform.v1.ImportFeatureValuesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ImportFeatureValuesRequest,
          com.google.longrunning.Operation>
      getImportFeatureValuesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.ImportFeatureValuesRequest,
            com.google.longrunning.Operation>
        getImportFeatureValuesMethod;
    if ((getImportFeatureValuesMethod = FeaturestoreServiceGrpc.getImportFeatureValuesMethod)
        == null) {
      synchronized (FeaturestoreServiceGrpc.class) {
        if ((getImportFeatureValuesMethod = FeaturestoreServiceGrpc.getImportFeatureValuesMethod)
            == null) {
          FeaturestoreServiceGrpc.getImportFeatureValuesMethod =
              getImportFeatureValuesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.ImportFeatureValuesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ImportFeatureValues"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ImportFeatureValuesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeaturestoreServiceMethodDescriptorSupplier("ImportFeatureValues"))
                      .build();
        }
      }
    }
    return getImportFeatureValuesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.BatchReadFeatureValuesRequest,
          com.google.longrunning.Operation>
      getBatchReadFeatureValuesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchReadFeatureValues",
      requestType = com.google.cloud.aiplatform.v1.BatchReadFeatureValuesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.BatchReadFeatureValuesRequest,
          com.google.longrunning.Operation>
      getBatchReadFeatureValuesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.BatchReadFeatureValuesRequest,
            com.google.longrunning.Operation>
        getBatchReadFeatureValuesMethod;
    if ((getBatchReadFeatureValuesMethod = FeaturestoreServiceGrpc.getBatchReadFeatureValuesMethod)
        == null) {
      synchronized (FeaturestoreServiceGrpc.class) {
        if ((getBatchReadFeatureValuesMethod =
                FeaturestoreServiceGrpc.getBatchReadFeatureValuesMethod)
            == null) {
          FeaturestoreServiceGrpc.getBatchReadFeatureValuesMethod =
              getBatchReadFeatureValuesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.BatchReadFeatureValuesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchReadFeatureValues"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.BatchReadFeatureValuesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeaturestoreServiceMethodDescriptorSupplier("BatchReadFeatureValues"))
                      .build();
        }
      }
    }
    return getBatchReadFeatureValuesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ExportFeatureValuesRequest,
          com.google.longrunning.Operation>
      getExportFeatureValuesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportFeatureValues",
      requestType = com.google.cloud.aiplatform.v1.ExportFeatureValuesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ExportFeatureValuesRequest,
          com.google.longrunning.Operation>
      getExportFeatureValuesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.ExportFeatureValuesRequest,
            com.google.longrunning.Operation>
        getExportFeatureValuesMethod;
    if ((getExportFeatureValuesMethod = FeaturestoreServiceGrpc.getExportFeatureValuesMethod)
        == null) {
      synchronized (FeaturestoreServiceGrpc.class) {
        if ((getExportFeatureValuesMethod = FeaturestoreServiceGrpc.getExportFeatureValuesMethod)
            == null) {
          FeaturestoreServiceGrpc.getExportFeatureValuesMethod =
              getExportFeatureValuesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.ExportFeatureValuesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ExportFeatureValues"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ExportFeatureValuesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeaturestoreServiceMethodDescriptorSupplier("ExportFeatureValues"))
                      .build();
        }
      }
    }
    return getExportFeatureValuesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.SearchFeaturesRequest,
          com.google.cloud.aiplatform.v1.SearchFeaturesResponse>
      getSearchFeaturesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchFeatures",
      requestType = com.google.cloud.aiplatform.v1.SearchFeaturesRequest.class,
      responseType = com.google.cloud.aiplatform.v1.SearchFeaturesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.SearchFeaturesRequest,
          com.google.cloud.aiplatform.v1.SearchFeaturesResponse>
      getSearchFeaturesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.SearchFeaturesRequest,
            com.google.cloud.aiplatform.v1.SearchFeaturesResponse>
        getSearchFeaturesMethod;
    if ((getSearchFeaturesMethod = FeaturestoreServiceGrpc.getSearchFeaturesMethod) == null) {
      synchronized (FeaturestoreServiceGrpc.class) {
        if ((getSearchFeaturesMethod = FeaturestoreServiceGrpc.getSearchFeaturesMethod) == null) {
          FeaturestoreServiceGrpc.getSearchFeaturesMethod =
              getSearchFeaturesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.SearchFeaturesRequest,
                          com.google.cloud.aiplatform.v1.SearchFeaturesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchFeatures"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.SearchFeaturesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.SearchFeaturesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeaturestoreServiceMethodDescriptorSupplier("SearchFeatures"))
                      .build();
        }
      }
    }
    return getSearchFeaturesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static FeaturestoreServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FeaturestoreServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FeaturestoreServiceStub>() {
          @java.lang.Override
          public FeaturestoreServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FeaturestoreServiceStub(channel, callOptions);
          }
        };
    return FeaturestoreServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FeaturestoreServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FeaturestoreServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FeaturestoreServiceBlockingStub>() {
          @java.lang.Override
          public FeaturestoreServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FeaturestoreServiceBlockingStub(channel, callOptions);
          }
        };
    return FeaturestoreServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static FeaturestoreServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FeaturestoreServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FeaturestoreServiceFutureStub>() {
          @java.lang.Override
          public FeaturestoreServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FeaturestoreServiceFutureStub(channel, callOptions);
          }
        };
    return FeaturestoreServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The service that handles CRUD and List for resources for Featurestore.
   * </pre>
   */
  public abstract static class FeaturestoreServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a new Featurestore in a given project and location.
     * </pre>
     */
    public void createFeaturestore(
        com.google.cloud.aiplatform.v1.CreateFeaturestoreRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateFeaturestoreMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Featurestore.
     * </pre>
     */
    public void getFeaturestore(
        com.google.cloud.aiplatform.v1.GetFeaturestoreRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Featurestore> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetFeaturestoreMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Featurestores in a given project and location.
     * </pre>
     */
    public void listFeaturestores(
        com.google.cloud.aiplatform.v1.ListFeaturestoresRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListFeaturestoresResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListFeaturestoresMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Featurestore.
     * </pre>
     */
    public void updateFeaturestore(
        com.google.cloud.aiplatform.v1.UpdateFeaturestoreRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateFeaturestoreMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Featurestore. The Featurestore must not contain any
     * EntityTypes or `force` must be set to true for the request to succeed.
     * </pre>
     */
    public void deleteFeaturestore(
        com.google.cloud.aiplatform.v1.DeleteFeaturestoreRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteFeaturestoreMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new EntityType in a given Featurestore.
     * </pre>
     */
    public void createEntityType(
        com.google.cloud.aiplatform.v1.CreateEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateEntityTypeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single EntityType.
     * </pre>
     */
    public void getEntityType(
        com.google.cloud.aiplatform.v1.GetEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.EntityType> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetEntityTypeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists EntityTypes in a given Featurestore.
     * </pre>
     */
    public void listEntityTypes(
        com.google.cloud.aiplatform.v1.ListEntityTypesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListEntityTypesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListEntityTypesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single EntityType.
     * </pre>
     */
    public void updateEntityType(
        com.google.cloud.aiplatform.v1.UpdateEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.EntityType> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateEntityTypeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single EntityType. The EntityType must not have any Features
     * or `force` must be set to true for the request to succeed.
     * </pre>
     */
    public void deleteEntityType(
        com.google.cloud.aiplatform.v1.DeleteEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteEntityTypeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Feature in a given EntityType.
     * </pre>
     */
    public void createFeature(
        com.google.cloud.aiplatform.v1.CreateFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateFeatureMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a batch of Features in a given EntityType.
     * </pre>
     */
    public void batchCreateFeatures(
        com.google.cloud.aiplatform.v1.BatchCreateFeaturesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchCreateFeaturesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Feature.
     * </pre>
     */
    public void getFeature(
        com.google.cloud.aiplatform.v1.GetFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Feature> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFeatureMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Features in a given EntityType.
     * </pre>
     */
    public void listFeatures(
        com.google.cloud.aiplatform.v1.ListFeaturesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListFeaturesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListFeaturesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Feature.
     * </pre>
     */
    public void updateFeature(
        com.google.cloud.aiplatform.v1.UpdateFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Feature> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateFeatureMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Feature.
     * </pre>
     */
    public void deleteFeature(
        com.google.cloud.aiplatform.v1.DeleteFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteFeatureMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports Feature values into the Featurestore from a source storage.
     * The progress of the import is tracked by the returned operation. The
     * imported features are guaranteed to be visible to subsequent read
     * operations after the operation is marked as successfully done.
     * If an import operation fails, the Feature values returned from
     * reads and exports may be inconsistent. If consistency is
     * required, the caller must retry the same import request again and wait till
     * the new operation returned is marked as successfully done.
     * There are also scenarios where the caller can cause inconsistency.
     *  - Source data for import contains multiple distinct Feature values for
     *    the same entity ID and timestamp.
     *  - Source is modified during an import. This includes adding, updating, or
     *  removing source data and/or metadata. Examples of updating metadata
     *  include but are not limited to changing storage location, storage class,
     *  or retention policy.
     *  - Online serving cluster is under-provisioned.
     * </pre>
     */
    public void importFeatureValues(
        com.google.cloud.aiplatform.v1.ImportFeatureValuesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getImportFeatureValuesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Batch reads Feature values from a Featurestore.
     * This API enables batch reading Feature values, where each read
     * instance in the batch may read Feature values of entities from one or
     * more EntityTypes. Point-in-time correctness is guaranteed for Feature
     * values of each read instance as of each instance's read timestamp.
     * </pre>
     */
    public void batchReadFeatureValues(
        com.google.cloud.aiplatform.v1.BatchReadFeatureValuesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchReadFeatureValuesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports Feature values from all the entities of a target EntityType.
     * </pre>
     */
    public void exportFeatureValues(
        com.google.cloud.aiplatform.v1.ExportFeatureValuesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getExportFeatureValuesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches Features matching a query in a given project.
     * </pre>
     */
    public void searchFeatures(
        com.google.cloud.aiplatform.v1.SearchFeaturesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.SearchFeaturesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchFeaturesMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateFeaturestoreMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.CreateFeaturestoreRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_FEATURESTORE)))
          .addMethod(
              getGetFeaturestoreMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.GetFeaturestoreRequest,
                      com.google.cloud.aiplatform.v1.Featurestore>(
                      this, METHODID_GET_FEATURESTORE)))
          .addMethod(
              getListFeaturestoresMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.ListFeaturestoresRequest,
                      com.google.cloud.aiplatform.v1.ListFeaturestoresResponse>(
                      this, METHODID_LIST_FEATURESTORES)))
          .addMethod(
              getUpdateFeaturestoreMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.UpdateFeaturestoreRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_FEATURESTORE)))
          .addMethod(
              getDeleteFeaturestoreMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.DeleteFeaturestoreRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_FEATURESTORE)))
          .addMethod(
              getCreateEntityTypeMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.CreateEntityTypeRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_ENTITY_TYPE)))
          .addMethod(
              getGetEntityTypeMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.GetEntityTypeRequest,
                      com.google.cloud.aiplatform.v1.EntityType>(this, METHODID_GET_ENTITY_TYPE)))
          .addMethod(
              getListEntityTypesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.ListEntityTypesRequest,
                      com.google.cloud.aiplatform.v1.ListEntityTypesResponse>(
                      this, METHODID_LIST_ENTITY_TYPES)))
          .addMethod(
              getUpdateEntityTypeMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.UpdateEntityTypeRequest,
                      com.google.cloud.aiplatform.v1.EntityType>(
                      this, METHODID_UPDATE_ENTITY_TYPE)))
          .addMethod(
              getDeleteEntityTypeMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.DeleteEntityTypeRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_ENTITY_TYPE)))
          .addMethod(
              getCreateFeatureMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.CreateFeatureRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_FEATURE)))
          .addMethod(
              getBatchCreateFeaturesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.BatchCreateFeaturesRequest,
                      com.google.longrunning.Operation>(this, METHODID_BATCH_CREATE_FEATURES)))
          .addMethod(
              getGetFeatureMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.GetFeatureRequest,
                      com.google.cloud.aiplatform.v1.Feature>(this, METHODID_GET_FEATURE)))
          .addMethod(
              getListFeaturesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.ListFeaturesRequest,
                      com.google.cloud.aiplatform.v1.ListFeaturesResponse>(
                      this, METHODID_LIST_FEATURES)))
          .addMethod(
              getUpdateFeatureMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.UpdateFeatureRequest,
                      com.google.cloud.aiplatform.v1.Feature>(this, METHODID_UPDATE_FEATURE)))
          .addMethod(
              getDeleteFeatureMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.DeleteFeatureRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_FEATURE)))
          .addMethod(
              getImportFeatureValuesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.ImportFeatureValuesRequest,
                      com.google.longrunning.Operation>(this, METHODID_IMPORT_FEATURE_VALUES)))
          .addMethod(
              getBatchReadFeatureValuesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.BatchReadFeatureValuesRequest,
                      com.google.longrunning.Operation>(this, METHODID_BATCH_READ_FEATURE_VALUES)))
          .addMethod(
              getExportFeatureValuesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.ExportFeatureValuesRequest,
                      com.google.longrunning.Operation>(this, METHODID_EXPORT_FEATURE_VALUES)))
          .addMethod(
              getSearchFeaturesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.SearchFeaturesRequest,
                      com.google.cloud.aiplatform.v1.SearchFeaturesResponse>(
                      this, METHODID_SEARCH_FEATURES)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * The service that handles CRUD and List for resources for Featurestore.
   * </pre>
   */
  public static final class FeaturestoreServiceStub
      extends io.grpc.stub.AbstractAsyncStub<FeaturestoreServiceStub> {
    private FeaturestoreServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FeaturestoreServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FeaturestoreServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Featurestore in a given project and location.
     * </pre>
     */
    public void createFeaturestore(
        com.google.cloud.aiplatform.v1.CreateFeaturestoreRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateFeaturestoreMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Featurestore.
     * </pre>
     */
    public void getFeaturestore(
        com.google.cloud.aiplatform.v1.GetFeaturestoreRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Featurestore> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFeaturestoreMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Featurestores in a given project and location.
     * </pre>
     */
    public void listFeaturestores(
        com.google.cloud.aiplatform.v1.ListFeaturestoresRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListFeaturestoresResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFeaturestoresMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Featurestore.
     * </pre>
     */
    public void updateFeaturestore(
        com.google.cloud.aiplatform.v1.UpdateFeaturestoreRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateFeaturestoreMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Featurestore. The Featurestore must not contain any
     * EntityTypes or `force` must be set to true for the request to succeed.
     * </pre>
     */
    public void deleteFeaturestore(
        com.google.cloud.aiplatform.v1.DeleteFeaturestoreRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteFeaturestoreMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new EntityType in a given Featurestore.
     * </pre>
     */
    public void createEntityType(
        com.google.cloud.aiplatform.v1.CreateEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEntityTypeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single EntityType.
     * </pre>
     */
    public void getEntityType(
        com.google.cloud.aiplatform.v1.GetEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.EntityType> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEntityTypeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists EntityTypes in a given Featurestore.
     * </pre>
     */
    public void listEntityTypes(
        com.google.cloud.aiplatform.v1.ListEntityTypesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListEntityTypesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEntityTypesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single EntityType.
     * </pre>
     */
    public void updateEntityType(
        com.google.cloud.aiplatform.v1.UpdateEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.EntityType> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEntityTypeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single EntityType. The EntityType must not have any Features
     * or `force` must be set to true for the request to succeed.
     * </pre>
     */
    public void deleteEntityType(
        com.google.cloud.aiplatform.v1.DeleteEntityTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEntityTypeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Feature in a given EntityType.
     * </pre>
     */
    public void createFeature(
        com.google.cloud.aiplatform.v1.CreateFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateFeatureMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a batch of Features in a given EntityType.
     * </pre>
     */
    public void batchCreateFeatures(
        com.google.cloud.aiplatform.v1.BatchCreateFeaturesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchCreateFeaturesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Feature.
     * </pre>
     */
    public void getFeature(
        com.google.cloud.aiplatform.v1.GetFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Feature> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFeatureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Features in a given EntityType.
     * </pre>
     */
    public void listFeatures(
        com.google.cloud.aiplatform.v1.ListFeaturesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListFeaturesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFeaturesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Feature.
     * </pre>
     */
    public void updateFeature(
        com.google.cloud.aiplatform.v1.UpdateFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Feature> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateFeatureMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Feature.
     * </pre>
     */
    public void deleteFeature(
        com.google.cloud.aiplatform.v1.DeleteFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteFeatureMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports Feature values into the Featurestore from a source storage.
     * The progress of the import is tracked by the returned operation. The
     * imported features are guaranteed to be visible to subsequent read
     * operations after the operation is marked as successfully done.
     * If an import operation fails, the Feature values returned from
     * reads and exports may be inconsistent. If consistency is
     * required, the caller must retry the same import request again and wait till
     * the new operation returned is marked as successfully done.
     * There are also scenarios where the caller can cause inconsistency.
     *  - Source data for import contains multiple distinct Feature values for
     *    the same entity ID and timestamp.
     *  - Source is modified during an import. This includes adding, updating, or
     *  removing source data and/or metadata. Examples of updating metadata
     *  include but are not limited to changing storage location, storage class,
     *  or retention policy.
     *  - Online serving cluster is under-provisioned.
     * </pre>
     */
    public void importFeatureValues(
        com.google.cloud.aiplatform.v1.ImportFeatureValuesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportFeatureValuesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Batch reads Feature values from a Featurestore.
     * This API enables batch reading Feature values, where each read
     * instance in the batch may read Feature values of entities from one or
     * more EntityTypes. Point-in-time correctness is guaranteed for Feature
     * values of each read instance as of each instance's read timestamp.
     * </pre>
     */
    public void batchReadFeatureValues(
        com.google.cloud.aiplatform.v1.BatchReadFeatureValuesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchReadFeatureValuesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports Feature values from all the entities of a target EntityType.
     * </pre>
     */
    public void exportFeatureValues(
        com.google.cloud.aiplatform.v1.ExportFeatureValuesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportFeatureValuesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Searches Features matching a query in a given project.
     * </pre>
     */
    public void searchFeatures(
        com.google.cloud.aiplatform.v1.SearchFeaturesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.SearchFeaturesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchFeaturesMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * The service that handles CRUD and List for resources for Featurestore.
   * </pre>
   */
  public static final class FeaturestoreServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<FeaturestoreServiceBlockingStub> {
    private FeaturestoreServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FeaturestoreServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FeaturestoreServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Featurestore in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createFeaturestore(
        com.google.cloud.aiplatform.v1.CreateFeaturestoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFeaturestoreMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Featurestore.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.Featurestore getFeaturestore(
        com.google.cloud.aiplatform.v1.GetFeaturestoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFeaturestoreMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Featurestores in a given project and location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.ListFeaturestoresResponse listFeaturestores(
        com.google.cloud.aiplatform.v1.ListFeaturestoresRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFeaturestoresMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Featurestore.
     * </pre>
     */
    public com.google.longrunning.Operation updateFeaturestore(
        com.google.cloud.aiplatform.v1.UpdateFeaturestoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateFeaturestoreMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Featurestore. The Featurestore must not contain any
     * EntityTypes or `force` must be set to true for the request to succeed.
     * </pre>
     */
    public com.google.longrunning.Operation deleteFeaturestore(
        com.google.cloud.aiplatform.v1.DeleteFeaturestoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteFeaturestoreMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new EntityType in a given Featurestore.
     * </pre>
     */
    public com.google.longrunning.Operation createEntityType(
        com.google.cloud.aiplatform.v1.CreateEntityTypeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEntityTypeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single EntityType.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.EntityType getEntityType(
        com.google.cloud.aiplatform.v1.GetEntityTypeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEntityTypeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists EntityTypes in a given Featurestore.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.ListEntityTypesResponse listEntityTypes(
        com.google.cloud.aiplatform.v1.ListEntityTypesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEntityTypesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single EntityType.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.EntityType updateEntityType(
        com.google.cloud.aiplatform.v1.UpdateEntityTypeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEntityTypeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single EntityType. The EntityType must not have any Features
     * or `force` must be set to true for the request to succeed.
     * </pre>
     */
    public com.google.longrunning.Operation deleteEntityType(
        com.google.cloud.aiplatform.v1.DeleteEntityTypeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEntityTypeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Feature in a given EntityType.
     * </pre>
     */
    public com.google.longrunning.Operation createFeature(
        com.google.cloud.aiplatform.v1.CreateFeatureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFeatureMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a batch of Features in a given EntityType.
     * </pre>
     */
    public com.google.longrunning.Operation batchCreateFeatures(
        com.google.cloud.aiplatform.v1.BatchCreateFeaturesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchCreateFeaturesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Feature.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.Feature getFeature(
        com.google.cloud.aiplatform.v1.GetFeatureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFeatureMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Features in a given EntityType.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.ListFeaturesResponse listFeatures(
        com.google.cloud.aiplatform.v1.ListFeaturesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFeaturesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Feature.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.Feature updateFeature(
        com.google.cloud.aiplatform.v1.UpdateFeatureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateFeatureMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Feature.
     * </pre>
     */
    public com.google.longrunning.Operation deleteFeature(
        com.google.cloud.aiplatform.v1.DeleteFeatureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteFeatureMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports Feature values into the Featurestore from a source storage.
     * The progress of the import is tracked by the returned operation. The
     * imported features are guaranteed to be visible to subsequent read
     * operations after the operation is marked as successfully done.
     * If an import operation fails, the Feature values returned from
     * reads and exports may be inconsistent. If consistency is
     * required, the caller must retry the same import request again and wait till
     * the new operation returned is marked as successfully done.
     * There are also scenarios where the caller can cause inconsistency.
     *  - Source data for import contains multiple distinct Feature values for
     *    the same entity ID and timestamp.
     *  - Source is modified during an import. This includes adding, updating, or
     *  removing source data and/or metadata. Examples of updating metadata
     *  include but are not limited to changing storage location, storage class,
     *  or retention policy.
     *  - Online serving cluster is under-provisioned.
     * </pre>
     */
    public com.google.longrunning.Operation importFeatureValues(
        com.google.cloud.aiplatform.v1.ImportFeatureValuesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportFeatureValuesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Batch reads Feature values from a Featurestore.
     * This API enables batch reading Feature values, where each read
     * instance in the batch may read Feature values of entities from one or
     * more EntityTypes. Point-in-time correctness is guaranteed for Feature
     * values of each read instance as of each instance's read timestamp.
     * </pre>
     */
    public com.google.longrunning.Operation batchReadFeatureValues(
        com.google.cloud.aiplatform.v1.BatchReadFeatureValuesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchReadFeatureValuesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports Feature values from all the entities of a target EntityType.
     * </pre>
     */
    public com.google.longrunning.Operation exportFeatureValues(
        com.google.cloud.aiplatform.v1.ExportFeatureValuesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportFeatureValuesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Searches Features matching a query in a given project.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.SearchFeaturesResponse searchFeatures(
        com.google.cloud.aiplatform.v1.SearchFeaturesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchFeaturesMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * The service that handles CRUD and List for resources for Featurestore.
   * </pre>
   */
  public static final class FeaturestoreServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<FeaturestoreServiceFutureStub> {
    private FeaturestoreServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FeaturestoreServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FeaturestoreServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Featurestore in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createFeaturestore(com.google.cloud.aiplatform.v1.CreateFeaturestoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateFeaturestoreMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Featurestore.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.Featurestore>
        getFeaturestore(com.google.cloud.aiplatform.v1.GetFeaturestoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFeaturestoreMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Featurestores in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.ListFeaturestoresResponse>
        listFeaturestores(com.google.cloud.aiplatform.v1.ListFeaturestoresRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFeaturestoresMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Featurestore.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateFeaturestore(com.google.cloud.aiplatform.v1.UpdateFeaturestoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateFeaturestoreMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Featurestore. The Featurestore must not contain any
     * EntityTypes or `force` must be set to true for the request to succeed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteFeaturestore(com.google.cloud.aiplatform.v1.DeleteFeaturestoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteFeaturestoreMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new EntityType in a given Featurestore.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createEntityType(com.google.cloud.aiplatform.v1.CreateEntityTypeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEntityTypeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single EntityType.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.EntityType>
        getEntityType(com.google.cloud.aiplatform.v1.GetEntityTypeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEntityTypeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists EntityTypes in a given Featurestore.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.ListEntityTypesResponse>
        listEntityTypes(com.google.cloud.aiplatform.v1.ListEntityTypesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEntityTypesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single EntityType.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.EntityType>
        updateEntityType(com.google.cloud.aiplatform.v1.UpdateEntityTypeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEntityTypeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single EntityType. The EntityType must not have any Features
     * or `force` must be set to true for the request to succeed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteEntityType(com.google.cloud.aiplatform.v1.DeleteEntityTypeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEntityTypeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Feature in a given EntityType.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createFeature(com.google.cloud.aiplatform.v1.CreateFeatureRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateFeatureMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a batch of Features in a given EntityType.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        batchCreateFeatures(com.google.cloud.aiplatform.v1.BatchCreateFeaturesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchCreateFeaturesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Feature.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.Feature>
        getFeature(com.google.cloud.aiplatform.v1.GetFeatureRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFeatureMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Features in a given EntityType.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.ListFeaturesResponse>
        listFeatures(com.google.cloud.aiplatform.v1.ListFeaturesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFeaturesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Feature.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.Feature>
        updateFeature(com.google.cloud.aiplatform.v1.UpdateFeatureRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateFeatureMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Feature.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteFeature(com.google.cloud.aiplatform.v1.DeleteFeatureRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteFeatureMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Imports Feature values into the Featurestore from a source storage.
     * The progress of the import is tracked by the returned operation. The
     * imported features are guaranteed to be visible to subsequent read
     * operations after the operation is marked as successfully done.
     * If an import operation fails, the Feature values returned from
     * reads and exports may be inconsistent. If consistency is
     * required, the caller must retry the same import request again and wait till
     * the new operation returned is marked as successfully done.
     * There are also scenarios where the caller can cause inconsistency.
     *  - Source data for import contains multiple distinct Feature values for
     *    the same entity ID and timestamp.
     *  - Source is modified during an import. This includes adding, updating, or
     *  removing source data and/or metadata. Examples of updating metadata
     *  include but are not limited to changing storage location, storage class,
     *  or retention policy.
     *  - Online serving cluster is under-provisioned.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        importFeatureValues(com.google.cloud.aiplatform.v1.ImportFeatureValuesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportFeatureValuesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Batch reads Feature values from a Featurestore.
     * This API enables batch reading Feature values, where each read
     * instance in the batch may read Feature values of entities from one or
     * more EntityTypes. Point-in-time correctness is guaranteed for Feature
     * values of each read instance as of each instance's read timestamp.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        batchReadFeatureValues(
            com.google.cloud.aiplatform.v1.BatchReadFeatureValuesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchReadFeatureValuesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Exports Feature values from all the entities of a target EntityType.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportFeatureValues(com.google.cloud.aiplatform.v1.ExportFeatureValuesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportFeatureValuesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Searches Features matching a query in a given project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.SearchFeaturesResponse>
        searchFeatures(com.google.cloud.aiplatform.v1.SearchFeaturesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchFeaturesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_FEATURESTORE = 0;
  private static final int METHODID_GET_FEATURESTORE = 1;
  private static final int METHODID_LIST_FEATURESTORES = 2;
  private static final int METHODID_UPDATE_FEATURESTORE = 3;
  private static final int METHODID_DELETE_FEATURESTORE = 4;
  private static final int METHODID_CREATE_ENTITY_TYPE = 5;
  private static final int METHODID_GET_ENTITY_TYPE = 6;
  private static final int METHODID_LIST_ENTITY_TYPES = 7;
  private static final int METHODID_UPDATE_ENTITY_TYPE = 8;
  private static final int METHODID_DELETE_ENTITY_TYPE = 9;
  private static final int METHODID_CREATE_FEATURE = 10;
  private static final int METHODID_BATCH_CREATE_FEATURES = 11;
  private static final int METHODID_GET_FEATURE = 12;
  private static final int METHODID_LIST_FEATURES = 13;
  private static final int METHODID_UPDATE_FEATURE = 14;
  private static final int METHODID_DELETE_FEATURE = 15;
  private static final int METHODID_IMPORT_FEATURE_VALUES = 16;
  private static final int METHODID_BATCH_READ_FEATURE_VALUES = 17;
  private static final int METHODID_EXPORT_FEATURE_VALUES = 18;
  private static final int METHODID_SEARCH_FEATURES = 19;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FeaturestoreServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FeaturestoreServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_FEATURESTORE:
          serviceImpl.createFeaturestore(
              (com.google.cloud.aiplatform.v1.CreateFeaturestoreRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_FEATURESTORE:
          serviceImpl.getFeaturestore(
              (com.google.cloud.aiplatform.v1.GetFeaturestoreRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Featurestore>)
                  responseObserver);
          break;
        case METHODID_LIST_FEATURESTORES:
          serviceImpl.listFeaturestores(
              (com.google.cloud.aiplatform.v1.ListFeaturestoresRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1.ListFeaturestoresResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_FEATURESTORE:
          serviceImpl.updateFeaturestore(
              (com.google.cloud.aiplatform.v1.UpdateFeaturestoreRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_FEATURESTORE:
          serviceImpl.deleteFeaturestore(
              (com.google.cloud.aiplatform.v1.DeleteFeaturestoreRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_ENTITY_TYPE:
          serviceImpl.createEntityType(
              (com.google.cloud.aiplatform.v1.CreateEntityTypeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_ENTITY_TYPE:
          serviceImpl.getEntityType(
              (com.google.cloud.aiplatform.v1.GetEntityTypeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.EntityType>)
                  responseObserver);
          break;
        case METHODID_LIST_ENTITY_TYPES:
          serviceImpl.listEntityTypes(
              (com.google.cloud.aiplatform.v1.ListEntityTypesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListEntityTypesResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_ENTITY_TYPE:
          serviceImpl.updateEntityType(
              (com.google.cloud.aiplatform.v1.UpdateEntityTypeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.EntityType>)
                  responseObserver);
          break;
        case METHODID_DELETE_ENTITY_TYPE:
          serviceImpl.deleteEntityType(
              (com.google.cloud.aiplatform.v1.DeleteEntityTypeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_FEATURE:
          serviceImpl.createFeature(
              (com.google.cloud.aiplatform.v1.CreateFeatureRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_BATCH_CREATE_FEATURES:
          serviceImpl.batchCreateFeatures(
              (com.google.cloud.aiplatform.v1.BatchCreateFeaturesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_FEATURE:
          serviceImpl.getFeature(
              (com.google.cloud.aiplatform.v1.GetFeatureRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Feature>)
                  responseObserver);
          break;
        case METHODID_LIST_FEATURES:
          serviceImpl.listFeatures(
              (com.google.cloud.aiplatform.v1.ListFeaturesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListFeaturesResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_FEATURE:
          serviceImpl.updateFeature(
              (com.google.cloud.aiplatform.v1.UpdateFeatureRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Feature>)
                  responseObserver);
          break;
        case METHODID_DELETE_FEATURE:
          serviceImpl.deleteFeature(
              (com.google.cloud.aiplatform.v1.DeleteFeatureRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_IMPORT_FEATURE_VALUES:
          serviceImpl.importFeatureValues(
              (com.google.cloud.aiplatform.v1.ImportFeatureValuesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_BATCH_READ_FEATURE_VALUES:
          serviceImpl.batchReadFeatureValues(
              (com.google.cloud.aiplatform.v1.BatchReadFeatureValuesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_EXPORT_FEATURE_VALUES:
          serviceImpl.exportFeatureValues(
              (com.google.cloud.aiplatform.v1.ExportFeatureValuesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_SEARCH_FEATURES:
          serviceImpl.searchFeatures(
              (com.google.cloud.aiplatform.v1.SearchFeaturesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.SearchFeaturesResponse>)
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

  private abstract static class FeaturestoreServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FeaturestoreServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1.FeaturestoreServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FeaturestoreService");
    }
  }

  private static final class FeaturestoreServiceFileDescriptorSupplier
      extends FeaturestoreServiceBaseDescriptorSupplier {
    FeaturestoreServiceFileDescriptorSupplier() {}
  }

  private static final class FeaturestoreServiceMethodDescriptorSupplier
      extends FeaturestoreServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FeaturestoreServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (FeaturestoreServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new FeaturestoreServiceFileDescriptorSupplier())
                      .addMethod(getCreateFeaturestoreMethod())
                      .addMethod(getGetFeaturestoreMethod())
                      .addMethod(getListFeaturestoresMethod())
                      .addMethod(getUpdateFeaturestoreMethod())
                      .addMethod(getDeleteFeaturestoreMethod())
                      .addMethod(getCreateEntityTypeMethod())
                      .addMethod(getGetEntityTypeMethod())
                      .addMethod(getListEntityTypesMethod())
                      .addMethod(getUpdateEntityTypeMethod())
                      .addMethod(getDeleteEntityTypeMethod())
                      .addMethod(getCreateFeatureMethod())
                      .addMethod(getBatchCreateFeaturesMethod())
                      .addMethod(getGetFeatureMethod())
                      .addMethod(getListFeaturesMethod())
                      .addMethod(getUpdateFeatureMethod())
                      .addMethod(getDeleteFeatureMethod())
                      .addMethod(getImportFeatureValuesMethod())
                      .addMethod(getBatchReadFeatureValuesMethod())
                      .addMethod(getExportFeatureValuesMethod())
                      .addMethod(getSearchFeaturesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
