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
package com.google.cloud.aiplatform.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for reading and writing metadata entries.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/aiplatform/v1beta1/metadata_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MetadataServiceGrpc {

  private MetadataServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.aiplatform.v1beta1.MetadataService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateMetadataStoreRequest,
          com.google.longrunning.Operation>
      getCreateMetadataStoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateMetadataStore",
      requestType = com.google.cloud.aiplatform.v1beta1.CreateMetadataStoreRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateMetadataStoreRequest,
          com.google.longrunning.Operation>
      getCreateMetadataStoreMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.CreateMetadataStoreRequest,
            com.google.longrunning.Operation>
        getCreateMetadataStoreMethod;
    if ((getCreateMetadataStoreMethod = MetadataServiceGrpc.getCreateMetadataStoreMethod) == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getCreateMetadataStoreMethod = MetadataServiceGrpc.getCreateMetadataStoreMethod)
            == null) {
          MetadataServiceGrpc.getCreateMetadataStoreMethod =
              getCreateMetadataStoreMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.CreateMetadataStoreRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateMetadataStore"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.CreateMetadataStoreRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier("CreateMetadataStore"))
                      .build();
        }
      }
    }
    return getCreateMetadataStoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetMetadataStoreRequest,
          com.google.cloud.aiplatform.v1beta1.MetadataStore>
      getGetMetadataStoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMetadataStore",
      requestType = com.google.cloud.aiplatform.v1beta1.GetMetadataStoreRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.MetadataStore.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetMetadataStoreRequest,
          com.google.cloud.aiplatform.v1beta1.MetadataStore>
      getGetMetadataStoreMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.GetMetadataStoreRequest,
            com.google.cloud.aiplatform.v1beta1.MetadataStore>
        getGetMetadataStoreMethod;
    if ((getGetMetadataStoreMethod = MetadataServiceGrpc.getGetMetadataStoreMethod) == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getGetMetadataStoreMethod = MetadataServiceGrpc.getGetMetadataStoreMethod) == null) {
          MetadataServiceGrpc.getGetMetadataStoreMethod =
              getGetMetadataStoreMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.GetMetadataStoreRequest,
                          com.google.cloud.aiplatform.v1beta1.MetadataStore>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMetadataStore"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.GetMetadataStoreRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.MetadataStore
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier("GetMetadataStore"))
                      .build();
        }
      }
    }
    return getGetMetadataStoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListMetadataStoresRequest,
          com.google.cloud.aiplatform.v1beta1.ListMetadataStoresResponse>
      getListMetadataStoresMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMetadataStores",
      requestType = com.google.cloud.aiplatform.v1beta1.ListMetadataStoresRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ListMetadataStoresResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListMetadataStoresRequest,
          com.google.cloud.aiplatform.v1beta1.ListMetadataStoresResponse>
      getListMetadataStoresMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ListMetadataStoresRequest,
            com.google.cloud.aiplatform.v1beta1.ListMetadataStoresResponse>
        getListMetadataStoresMethod;
    if ((getListMetadataStoresMethod = MetadataServiceGrpc.getListMetadataStoresMethod) == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getListMetadataStoresMethod = MetadataServiceGrpc.getListMetadataStoresMethod)
            == null) {
          MetadataServiceGrpc.getListMetadataStoresMethod =
              getListMetadataStoresMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.ListMetadataStoresRequest,
                          com.google.cloud.aiplatform.v1beta1.ListMetadataStoresResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListMetadataStores"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListMetadataStoresRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListMetadataStoresResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier("ListMetadataStores"))
                      .build();
        }
      }
    }
    return getListMetadataStoresMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteMetadataStoreRequest,
          com.google.longrunning.Operation>
      getDeleteMetadataStoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteMetadataStore",
      requestType = com.google.cloud.aiplatform.v1beta1.DeleteMetadataStoreRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteMetadataStoreRequest,
          com.google.longrunning.Operation>
      getDeleteMetadataStoreMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.DeleteMetadataStoreRequest,
            com.google.longrunning.Operation>
        getDeleteMetadataStoreMethod;
    if ((getDeleteMetadataStoreMethod = MetadataServiceGrpc.getDeleteMetadataStoreMethod) == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getDeleteMetadataStoreMethod = MetadataServiceGrpc.getDeleteMetadataStoreMethod)
            == null) {
          MetadataServiceGrpc.getDeleteMetadataStoreMethod =
              getDeleteMetadataStoreMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.DeleteMetadataStoreRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteMetadataStore"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.DeleteMetadataStoreRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier("DeleteMetadataStore"))
                      .build();
        }
      }
    }
    return getDeleteMetadataStoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateArtifactRequest,
          com.google.cloud.aiplatform.v1beta1.Artifact>
      getCreateArtifactMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateArtifact",
      requestType = com.google.cloud.aiplatform.v1beta1.CreateArtifactRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.Artifact.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateArtifactRequest,
          com.google.cloud.aiplatform.v1beta1.Artifact>
      getCreateArtifactMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.CreateArtifactRequest,
            com.google.cloud.aiplatform.v1beta1.Artifact>
        getCreateArtifactMethod;
    if ((getCreateArtifactMethod = MetadataServiceGrpc.getCreateArtifactMethod) == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getCreateArtifactMethod = MetadataServiceGrpc.getCreateArtifactMethod) == null) {
          MetadataServiceGrpc.getCreateArtifactMethod =
              getCreateArtifactMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.CreateArtifactRequest,
                          com.google.cloud.aiplatform.v1beta1.Artifact>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateArtifact"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.CreateArtifactRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.Artifact.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier("CreateArtifact"))
                      .build();
        }
      }
    }
    return getCreateArtifactMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetArtifactRequest,
          com.google.cloud.aiplatform.v1beta1.Artifact>
      getGetArtifactMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetArtifact",
      requestType = com.google.cloud.aiplatform.v1beta1.GetArtifactRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.Artifact.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetArtifactRequest,
          com.google.cloud.aiplatform.v1beta1.Artifact>
      getGetArtifactMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.GetArtifactRequest,
            com.google.cloud.aiplatform.v1beta1.Artifact>
        getGetArtifactMethod;
    if ((getGetArtifactMethod = MetadataServiceGrpc.getGetArtifactMethod) == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getGetArtifactMethod = MetadataServiceGrpc.getGetArtifactMethod) == null) {
          MetadataServiceGrpc.getGetArtifactMethod =
              getGetArtifactMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.GetArtifactRequest,
                          com.google.cloud.aiplatform.v1beta1.Artifact>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetArtifact"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.GetArtifactRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.Artifact.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier("GetArtifact"))
                      .build();
        }
      }
    }
    return getGetArtifactMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListArtifactsRequest,
          com.google.cloud.aiplatform.v1beta1.ListArtifactsResponse>
      getListArtifactsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListArtifacts",
      requestType = com.google.cloud.aiplatform.v1beta1.ListArtifactsRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ListArtifactsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListArtifactsRequest,
          com.google.cloud.aiplatform.v1beta1.ListArtifactsResponse>
      getListArtifactsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ListArtifactsRequest,
            com.google.cloud.aiplatform.v1beta1.ListArtifactsResponse>
        getListArtifactsMethod;
    if ((getListArtifactsMethod = MetadataServiceGrpc.getListArtifactsMethod) == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getListArtifactsMethod = MetadataServiceGrpc.getListArtifactsMethod) == null) {
          MetadataServiceGrpc.getListArtifactsMethod =
              getListArtifactsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.ListArtifactsRequest,
                          com.google.cloud.aiplatform.v1beta1.ListArtifactsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListArtifacts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListArtifactsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListArtifactsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier("ListArtifacts"))
                      .build();
        }
      }
    }
    return getListArtifactsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpdateArtifactRequest,
          com.google.cloud.aiplatform.v1beta1.Artifact>
      getUpdateArtifactMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateArtifact",
      requestType = com.google.cloud.aiplatform.v1beta1.UpdateArtifactRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.Artifact.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpdateArtifactRequest,
          com.google.cloud.aiplatform.v1beta1.Artifact>
      getUpdateArtifactMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.UpdateArtifactRequest,
            com.google.cloud.aiplatform.v1beta1.Artifact>
        getUpdateArtifactMethod;
    if ((getUpdateArtifactMethod = MetadataServiceGrpc.getUpdateArtifactMethod) == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getUpdateArtifactMethod = MetadataServiceGrpc.getUpdateArtifactMethod) == null) {
          MetadataServiceGrpc.getUpdateArtifactMethod =
              getUpdateArtifactMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.UpdateArtifactRequest,
                          com.google.cloud.aiplatform.v1beta1.Artifact>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateArtifact"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.UpdateArtifactRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.Artifact.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier("UpdateArtifact"))
                      .build();
        }
      }
    }
    return getUpdateArtifactMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteArtifactRequest,
          com.google.longrunning.Operation>
      getDeleteArtifactMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteArtifact",
      requestType = com.google.cloud.aiplatform.v1beta1.DeleteArtifactRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteArtifactRequest,
          com.google.longrunning.Operation>
      getDeleteArtifactMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.DeleteArtifactRequest,
            com.google.longrunning.Operation>
        getDeleteArtifactMethod;
    if ((getDeleteArtifactMethod = MetadataServiceGrpc.getDeleteArtifactMethod) == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getDeleteArtifactMethod = MetadataServiceGrpc.getDeleteArtifactMethod) == null) {
          MetadataServiceGrpc.getDeleteArtifactMethod =
              getDeleteArtifactMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.DeleteArtifactRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteArtifact"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.DeleteArtifactRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier("DeleteArtifact"))
                      .build();
        }
      }
    }
    return getDeleteArtifactMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.PurgeArtifactsRequest,
          com.google.longrunning.Operation>
      getPurgeArtifactsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PurgeArtifacts",
      requestType = com.google.cloud.aiplatform.v1beta1.PurgeArtifactsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.PurgeArtifactsRequest,
          com.google.longrunning.Operation>
      getPurgeArtifactsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.PurgeArtifactsRequest,
            com.google.longrunning.Operation>
        getPurgeArtifactsMethod;
    if ((getPurgeArtifactsMethod = MetadataServiceGrpc.getPurgeArtifactsMethod) == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getPurgeArtifactsMethod = MetadataServiceGrpc.getPurgeArtifactsMethod) == null) {
          MetadataServiceGrpc.getPurgeArtifactsMethod =
              getPurgeArtifactsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.PurgeArtifactsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PurgeArtifacts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.PurgeArtifactsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier("PurgeArtifacts"))
                      .build();
        }
      }
    }
    return getPurgeArtifactsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateContextRequest,
          com.google.cloud.aiplatform.v1beta1.Context>
      getCreateContextMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateContext",
      requestType = com.google.cloud.aiplatform.v1beta1.CreateContextRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.Context.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateContextRequest,
          com.google.cloud.aiplatform.v1beta1.Context>
      getCreateContextMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.CreateContextRequest,
            com.google.cloud.aiplatform.v1beta1.Context>
        getCreateContextMethod;
    if ((getCreateContextMethod = MetadataServiceGrpc.getCreateContextMethod) == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getCreateContextMethod = MetadataServiceGrpc.getCreateContextMethod) == null) {
          MetadataServiceGrpc.getCreateContextMethod =
              getCreateContextMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.CreateContextRequest,
                          com.google.cloud.aiplatform.v1beta1.Context>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateContext"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.CreateContextRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.Context.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier("CreateContext"))
                      .build();
        }
      }
    }
    return getCreateContextMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetContextRequest,
          com.google.cloud.aiplatform.v1beta1.Context>
      getGetContextMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetContext",
      requestType = com.google.cloud.aiplatform.v1beta1.GetContextRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.Context.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetContextRequest,
          com.google.cloud.aiplatform.v1beta1.Context>
      getGetContextMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.GetContextRequest,
            com.google.cloud.aiplatform.v1beta1.Context>
        getGetContextMethod;
    if ((getGetContextMethod = MetadataServiceGrpc.getGetContextMethod) == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getGetContextMethod = MetadataServiceGrpc.getGetContextMethod) == null) {
          MetadataServiceGrpc.getGetContextMethod =
              getGetContextMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.GetContextRequest,
                          com.google.cloud.aiplatform.v1beta1.Context>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetContext"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.GetContextRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.Context.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier("GetContext"))
                      .build();
        }
      }
    }
    return getGetContextMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListContextsRequest,
          com.google.cloud.aiplatform.v1beta1.ListContextsResponse>
      getListContextsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListContexts",
      requestType = com.google.cloud.aiplatform.v1beta1.ListContextsRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ListContextsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListContextsRequest,
          com.google.cloud.aiplatform.v1beta1.ListContextsResponse>
      getListContextsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ListContextsRequest,
            com.google.cloud.aiplatform.v1beta1.ListContextsResponse>
        getListContextsMethod;
    if ((getListContextsMethod = MetadataServiceGrpc.getListContextsMethod) == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getListContextsMethod = MetadataServiceGrpc.getListContextsMethod) == null) {
          MetadataServiceGrpc.getListContextsMethod =
              getListContextsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.ListContextsRequest,
                          com.google.cloud.aiplatform.v1beta1.ListContextsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListContexts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListContextsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListContextsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier("ListContexts"))
                      .build();
        }
      }
    }
    return getListContextsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpdateContextRequest,
          com.google.cloud.aiplatform.v1beta1.Context>
      getUpdateContextMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateContext",
      requestType = com.google.cloud.aiplatform.v1beta1.UpdateContextRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.Context.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpdateContextRequest,
          com.google.cloud.aiplatform.v1beta1.Context>
      getUpdateContextMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.UpdateContextRequest,
            com.google.cloud.aiplatform.v1beta1.Context>
        getUpdateContextMethod;
    if ((getUpdateContextMethod = MetadataServiceGrpc.getUpdateContextMethod) == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getUpdateContextMethod = MetadataServiceGrpc.getUpdateContextMethod) == null) {
          MetadataServiceGrpc.getUpdateContextMethod =
              getUpdateContextMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.UpdateContextRequest,
                          com.google.cloud.aiplatform.v1beta1.Context>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateContext"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.UpdateContextRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.Context.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier("UpdateContext"))
                      .build();
        }
      }
    }
    return getUpdateContextMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteContextRequest,
          com.google.longrunning.Operation>
      getDeleteContextMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteContext",
      requestType = com.google.cloud.aiplatform.v1beta1.DeleteContextRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteContextRequest,
          com.google.longrunning.Operation>
      getDeleteContextMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.DeleteContextRequest,
            com.google.longrunning.Operation>
        getDeleteContextMethod;
    if ((getDeleteContextMethod = MetadataServiceGrpc.getDeleteContextMethod) == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getDeleteContextMethod = MetadataServiceGrpc.getDeleteContextMethod) == null) {
          MetadataServiceGrpc.getDeleteContextMethod =
              getDeleteContextMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.DeleteContextRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteContext"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.DeleteContextRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier("DeleteContext"))
                      .build();
        }
      }
    }
    return getDeleteContextMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.PurgeContextsRequest,
          com.google.longrunning.Operation>
      getPurgeContextsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PurgeContexts",
      requestType = com.google.cloud.aiplatform.v1beta1.PurgeContextsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.PurgeContextsRequest,
          com.google.longrunning.Operation>
      getPurgeContextsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.PurgeContextsRequest,
            com.google.longrunning.Operation>
        getPurgeContextsMethod;
    if ((getPurgeContextsMethod = MetadataServiceGrpc.getPurgeContextsMethod) == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getPurgeContextsMethod = MetadataServiceGrpc.getPurgeContextsMethod) == null) {
          MetadataServiceGrpc.getPurgeContextsMethod =
              getPurgeContextsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.PurgeContextsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PurgeContexts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.PurgeContextsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier("PurgeContexts"))
                      .build();
        }
      }
    }
    return getPurgeContextsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.AddContextArtifactsAndExecutionsRequest,
          com.google.cloud.aiplatform.v1beta1.AddContextArtifactsAndExecutionsResponse>
      getAddContextArtifactsAndExecutionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddContextArtifactsAndExecutions",
      requestType =
          com.google.cloud.aiplatform.v1beta1.AddContextArtifactsAndExecutionsRequest.class,
      responseType =
          com.google.cloud.aiplatform.v1beta1.AddContextArtifactsAndExecutionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.AddContextArtifactsAndExecutionsRequest,
          com.google.cloud.aiplatform.v1beta1.AddContextArtifactsAndExecutionsResponse>
      getAddContextArtifactsAndExecutionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.AddContextArtifactsAndExecutionsRequest,
            com.google.cloud.aiplatform.v1beta1.AddContextArtifactsAndExecutionsResponse>
        getAddContextArtifactsAndExecutionsMethod;
    if ((getAddContextArtifactsAndExecutionsMethod =
            MetadataServiceGrpc.getAddContextArtifactsAndExecutionsMethod)
        == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getAddContextArtifactsAndExecutionsMethod =
                MetadataServiceGrpc.getAddContextArtifactsAndExecutionsMethod)
            == null) {
          MetadataServiceGrpc.getAddContextArtifactsAndExecutionsMethod =
              getAddContextArtifactsAndExecutionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.AddContextArtifactsAndExecutionsRequest,
                          com.google.cloud.aiplatform.v1beta1
                              .AddContextArtifactsAndExecutionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "AddContextArtifactsAndExecutions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1
                                  .AddContextArtifactsAndExecutionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1
                                  .AddContextArtifactsAndExecutionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier(
                              "AddContextArtifactsAndExecutions"))
                      .build();
        }
      }
    }
    return getAddContextArtifactsAndExecutionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.AddContextChildrenRequest,
          com.google.cloud.aiplatform.v1beta1.AddContextChildrenResponse>
      getAddContextChildrenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddContextChildren",
      requestType = com.google.cloud.aiplatform.v1beta1.AddContextChildrenRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.AddContextChildrenResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.AddContextChildrenRequest,
          com.google.cloud.aiplatform.v1beta1.AddContextChildrenResponse>
      getAddContextChildrenMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.AddContextChildrenRequest,
            com.google.cloud.aiplatform.v1beta1.AddContextChildrenResponse>
        getAddContextChildrenMethod;
    if ((getAddContextChildrenMethod = MetadataServiceGrpc.getAddContextChildrenMethod) == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getAddContextChildrenMethod = MetadataServiceGrpc.getAddContextChildrenMethod)
            == null) {
          MetadataServiceGrpc.getAddContextChildrenMethod =
              getAddContextChildrenMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.AddContextChildrenRequest,
                          com.google.cloud.aiplatform.v1beta1.AddContextChildrenResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddContextChildren"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.AddContextChildrenRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.AddContextChildrenResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier("AddContextChildren"))
                      .build();
        }
      }
    }
    return getAddContextChildrenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.RemoveContextChildrenRequest,
          com.google.cloud.aiplatform.v1beta1.RemoveContextChildrenResponse>
      getRemoveContextChildrenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveContextChildren",
      requestType = com.google.cloud.aiplatform.v1beta1.RemoveContextChildrenRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.RemoveContextChildrenResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.RemoveContextChildrenRequest,
          com.google.cloud.aiplatform.v1beta1.RemoveContextChildrenResponse>
      getRemoveContextChildrenMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.RemoveContextChildrenRequest,
            com.google.cloud.aiplatform.v1beta1.RemoveContextChildrenResponse>
        getRemoveContextChildrenMethod;
    if ((getRemoveContextChildrenMethod = MetadataServiceGrpc.getRemoveContextChildrenMethod)
        == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getRemoveContextChildrenMethod = MetadataServiceGrpc.getRemoveContextChildrenMethod)
            == null) {
          MetadataServiceGrpc.getRemoveContextChildrenMethod =
              getRemoveContextChildrenMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.RemoveContextChildrenRequest,
                          com.google.cloud.aiplatform.v1beta1.RemoveContextChildrenResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RemoveContextChildren"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.RemoveContextChildrenRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.RemoveContextChildrenResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier("RemoveContextChildren"))
                      .build();
        }
      }
    }
    return getRemoveContextChildrenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.QueryContextLineageSubgraphRequest,
          com.google.cloud.aiplatform.v1beta1.LineageSubgraph>
      getQueryContextLineageSubgraphMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QueryContextLineageSubgraph",
      requestType = com.google.cloud.aiplatform.v1beta1.QueryContextLineageSubgraphRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.LineageSubgraph.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.QueryContextLineageSubgraphRequest,
          com.google.cloud.aiplatform.v1beta1.LineageSubgraph>
      getQueryContextLineageSubgraphMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.QueryContextLineageSubgraphRequest,
            com.google.cloud.aiplatform.v1beta1.LineageSubgraph>
        getQueryContextLineageSubgraphMethod;
    if ((getQueryContextLineageSubgraphMethod =
            MetadataServiceGrpc.getQueryContextLineageSubgraphMethod)
        == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getQueryContextLineageSubgraphMethod =
                MetadataServiceGrpc.getQueryContextLineageSubgraphMethod)
            == null) {
          MetadataServiceGrpc.getQueryContextLineageSubgraphMethod =
              getQueryContextLineageSubgraphMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.QueryContextLineageSubgraphRequest,
                          com.google.cloud.aiplatform.v1beta1.LineageSubgraph>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "QueryContextLineageSubgraph"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.QueryContextLineageSubgraphRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.LineageSubgraph
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier(
                              "QueryContextLineageSubgraph"))
                      .build();
        }
      }
    }
    return getQueryContextLineageSubgraphMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateExecutionRequest,
          com.google.cloud.aiplatform.v1beta1.Execution>
      getCreateExecutionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateExecution",
      requestType = com.google.cloud.aiplatform.v1beta1.CreateExecutionRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.Execution.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateExecutionRequest,
          com.google.cloud.aiplatform.v1beta1.Execution>
      getCreateExecutionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.CreateExecutionRequest,
            com.google.cloud.aiplatform.v1beta1.Execution>
        getCreateExecutionMethod;
    if ((getCreateExecutionMethod = MetadataServiceGrpc.getCreateExecutionMethod) == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getCreateExecutionMethod = MetadataServiceGrpc.getCreateExecutionMethod) == null) {
          MetadataServiceGrpc.getCreateExecutionMethod =
              getCreateExecutionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.CreateExecutionRequest,
                          com.google.cloud.aiplatform.v1beta1.Execution>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateExecution"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.CreateExecutionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.Execution.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier("CreateExecution"))
                      .build();
        }
      }
    }
    return getCreateExecutionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetExecutionRequest,
          com.google.cloud.aiplatform.v1beta1.Execution>
      getGetExecutionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetExecution",
      requestType = com.google.cloud.aiplatform.v1beta1.GetExecutionRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.Execution.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetExecutionRequest,
          com.google.cloud.aiplatform.v1beta1.Execution>
      getGetExecutionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.GetExecutionRequest,
            com.google.cloud.aiplatform.v1beta1.Execution>
        getGetExecutionMethod;
    if ((getGetExecutionMethod = MetadataServiceGrpc.getGetExecutionMethod) == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getGetExecutionMethod = MetadataServiceGrpc.getGetExecutionMethod) == null) {
          MetadataServiceGrpc.getGetExecutionMethod =
              getGetExecutionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.GetExecutionRequest,
                          com.google.cloud.aiplatform.v1beta1.Execution>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetExecution"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.GetExecutionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.Execution.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier("GetExecution"))
                      .build();
        }
      }
    }
    return getGetExecutionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListExecutionsRequest,
          com.google.cloud.aiplatform.v1beta1.ListExecutionsResponse>
      getListExecutionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListExecutions",
      requestType = com.google.cloud.aiplatform.v1beta1.ListExecutionsRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ListExecutionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListExecutionsRequest,
          com.google.cloud.aiplatform.v1beta1.ListExecutionsResponse>
      getListExecutionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ListExecutionsRequest,
            com.google.cloud.aiplatform.v1beta1.ListExecutionsResponse>
        getListExecutionsMethod;
    if ((getListExecutionsMethod = MetadataServiceGrpc.getListExecutionsMethod) == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getListExecutionsMethod = MetadataServiceGrpc.getListExecutionsMethod) == null) {
          MetadataServiceGrpc.getListExecutionsMethod =
              getListExecutionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.ListExecutionsRequest,
                          com.google.cloud.aiplatform.v1beta1.ListExecutionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListExecutions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListExecutionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListExecutionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier("ListExecutions"))
                      .build();
        }
      }
    }
    return getListExecutionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpdateExecutionRequest,
          com.google.cloud.aiplatform.v1beta1.Execution>
      getUpdateExecutionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateExecution",
      requestType = com.google.cloud.aiplatform.v1beta1.UpdateExecutionRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.Execution.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpdateExecutionRequest,
          com.google.cloud.aiplatform.v1beta1.Execution>
      getUpdateExecutionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.UpdateExecutionRequest,
            com.google.cloud.aiplatform.v1beta1.Execution>
        getUpdateExecutionMethod;
    if ((getUpdateExecutionMethod = MetadataServiceGrpc.getUpdateExecutionMethod) == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getUpdateExecutionMethod = MetadataServiceGrpc.getUpdateExecutionMethod) == null) {
          MetadataServiceGrpc.getUpdateExecutionMethod =
              getUpdateExecutionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.UpdateExecutionRequest,
                          com.google.cloud.aiplatform.v1beta1.Execution>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateExecution"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.UpdateExecutionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.Execution.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier("UpdateExecution"))
                      .build();
        }
      }
    }
    return getUpdateExecutionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteExecutionRequest,
          com.google.longrunning.Operation>
      getDeleteExecutionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteExecution",
      requestType = com.google.cloud.aiplatform.v1beta1.DeleteExecutionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteExecutionRequest,
          com.google.longrunning.Operation>
      getDeleteExecutionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.DeleteExecutionRequest,
            com.google.longrunning.Operation>
        getDeleteExecutionMethod;
    if ((getDeleteExecutionMethod = MetadataServiceGrpc.getDeleteExecutionMethod) == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getDeleteExecutionMethod = MetadataServiceGrpc.getDeleteExecutionMethod) == null) {
          MetadataServiceGrpc.getDeleteExecutionMethod =
              getDeleteExecutionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.DeleteExecutionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteExecution"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.DeleteExecutionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier("DeleteExecution"))
                      .build();
        }
      }
    }
    return getDeleteExecutionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.PurgeExecutionsRequest,
          com.google.longrunning.Operation>
      getPurgeExecutionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PurgeExecutions",
      requestType = com.google.cloud.aiplatform.v1beta1.PurgeExecutionsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.PurgeExecutionsRequest,
          com.google.longrunning.Operation>
      getPurgeExecutionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.PurgeExecutionsRequest,
            com.google.longrunning.Operation>
        getPurgeExecutionsMethod;
    if ((getPurgeExecutionsMethod = MetadataServiceGrpc.getPurgeExecutionsMethod) == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getPurgeExecutionsMethod = MetadataServiceGrpc.getPurgeExecutionsMethod) == null) {
          MetadataServiceGrpc.getPurgeExecutionsMethod =
              getPurgeExecutionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.PurgeExecutionsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PurgeExecutions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.PurgeExecutionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier("PurgeExecutions"))
                      .build();
        }
      }
    }
    return getPurgeExecutionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.AddExecutionEventsRequest,
          com.google.cloud.aiplatform.v1beta1.AddExecutionEventsResponse>
      getAddExecutionEventsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddExecutionEvents",
      requestType = com.google.cloud.aiplatform.v1beta1.AddExecutionEventsRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.AddExecutionEventsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.AddExecutionEventsRequest,
          com.google.cloud.aiplatform.v1beta1.AddExecutionEventsResponse>
      getAddExecutionEventsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.AddExecutionEventsRequest,
            com.google.cloud.aiplatform.v1beta1.AddExecutionEventsResponse>
        getAddExecutionEventsMethod;
    if ((getAddExecutionEventsMethod = MetadataServiceGrpc.getAddExecutionEventsMethod) == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getAddExecutionEventsMethod = MetadataServiceGrpc.getAddExecutionEventsMethod)
            == null) {
          MetadataServiceGrpc.getAddExecutionEventsMethod =
              getAddExecutionEventsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.AddExecutionEventsRequest,
                          com.google.cloud.aiplatform.v1beta1.AddExecutionEventsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddExecutionEvents"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.AddExecutionEventsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.AddExecutionEventsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier("AddExecutionEvents"))
                      .build();
        }
      }
    }
    return getAddExecutionEventsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.QueryExecutionInputsAndOutputsRequest,
          com.google.cloud.aiplatform.v1beta1.LineageSubgraph>
      getQueryExecutionInputsAndOutputsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QueryExecutionInputsAndOutputs",
      requestType = com.google.cloud.aiplatform.v1beta1.QueryExecutionInputsAndOutputsRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.LineageSubgraph.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.QueryExecutionInputsAndOutputsRequest,
          com.google.cloud.aiplatform.v1beta1.LineageSubgraph>
      getQueryExecutionInputsAndOutputsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.QueryExecutionInputsAndOutputsRequest,
            com.google.cloud.aiplatform.v1beta1.LineageSubgraph>
        getQueryExecutionInputsAndOutputsMethod;
    if ((getQueryExecutionInputsAndOutputsMethod =
            MetadataServiceGrpc.getQueryExecutionInputsAndOutputsMethod)
        == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getQueryExecutionInputsAndOutputsMethod =
                MetadataServiceGrpc.getQueryExecutionInputsAndOutputsMethod)
            == null) {
          MetadataServiceGrpc.getQueryExecutionInputsAndOutputsMethod =
              getQueryExecutionInputsAndOutputsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.QueryExecutionInputsAndOutputsRequest,
                          com.google.cloud.aiplatform.v1beta1.LineageSubgraph>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "QueryExecutionInputsAndOutputs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1
                                  .QueryExecutionInputsAndOutputsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.LineageSubgraph
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier(
                              "QueryExecutionInputsAndOutputs"))
                      .build();
        }
      }
    }
    return getQueryExecutionInputsAndOutputsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateMetadataSchemaRequest,
          com.google.cloud.aiplatform.v1beta1.MetadataSchema>
      getCreateMetadataSchemaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateMetadataSchema",
      requestType = com.google.cloud.aiplatform.v1beta1.CreateMetadataSchemaRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.MetadataSchema.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateMetadataSchemaRequest,
          com.google.cloud.aiplatform.v1beta1.MetadataSchema>
      getCreateMetadataSchemaMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.CreateMetadataSchemaRequest,
            com.google.cloud.aiplatform.v1beta1.MetadataSchema>
        getCreateMetadataSchemaMethod;
    if ((getCreateMetadataSchemaMethod = MetadataServiceGrpc.getCreateMetadataSchemaMethod)
        == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getCreateMetadataSchemaMethod = MetadataServiceGrpc.getCreateMetadataSchemaMethod)
            == null) {
          MetadataServiceGrpc.getCreateMetadataSchemaMethod =
              getCreateMetadataSchemaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.CreateMetadataSchemaRequest,
                          com.google.cloud.aiplatform.v1beta1.MetadataSchema>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateMetadataSchema"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.CreateMetadataSchemaRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.MetadataSchema
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier("CreateMetadataSchema"))
                      .build();
        }
      }
    }
    return getCreateMetadataSchemaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetMetadataSchemaRequest,
          com.google.cloud.aiplatform.v1beta1.MetadataSchema>
      getGetMetadataSchemaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMetadataSchema",
      requestType = com.google.cloud.aiplatform.v1beta1.GetMetadataSchemaRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.MetadataSchema.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetMetadataSchemaRequest,
          com.google.cloud.aiplatform.v1beta1.MetadataSchema>
      getGetMetadataSchemaMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.GetMetadataSchemaRequest,
            com.google.cloud.aiplatform.v1beta1.MetadataSchema>
        getGetMetadataSchemaMethod;
    if ((getGetMetadataSchemaMethod = MetadataServiceGrpc.getGetMetadataSchemaMethod) == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getGetMetadataSchemaMethod = MetadataServiceGrpc.getGetMetadataSchemaMethod) == null) {
          MetadataServiceGrpc.getGetMetadataSchemaMethod =
              getGetMetadataSchemaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.GetMetadataSchemaRequest,
                          com.google.cloud.aiplatform.v1beta1.MetadataSchema>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMetadataSchema"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.GetMetadataSchemaRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.MetadataSchema
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier("GetMetadataSchema"))
                      .build();
        }
      }
    }
    return getGetMetadataSchemaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListMetadataSchemasRequest,
          com.google.cloud.aiplatform.v1beta1.ListMetadataSchemasResponse>
      getListMetadataSchemasMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMetadataSchemas",
      requestType = com.google.cloud.aiplatform.v1beta1.ListMetadataSchemasRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ListMetadataSchemasResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListMetadataSchemasRequest,
          com.google.cloud.aiplatform.v1beta1.ListMetadataSchemasResponse>
      getListMetadataSchemasMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ListMetadataSchemasRequest,
            com.google.cloud.aiplatform.v1beta1.ListMetadataSchemasResponse>
        getListMetadataSchemasMethod;
    if ((getListMetadataSchemasMethod = MetadataServiceGrpc.getListMetadataSchemasMethod) == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getListMetadataSchemasMethod = MetadataServiceGrpc.getListMetadataSchemasMethod)
            == null) {
          MetadataServiceGrpc.getListMetadataSchemasMethod =
              getListMetadataSchemasMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.ListMetadataSchemasRequest,
                          com.google.cloud.aiplatform.v1beta1.ListMetadataSchemasResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListMetadataSchemas"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListMetadataSchemasRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListMetadataSchemasResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier("ListMetadataSchemas"))
                      .build();
        }
      }
    }
    return getListMetadataSchemasMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.QueryArtifactLineageSubgraphRequest,
          com.google.cloud.aiplatform.v1beta1.LineageSubgraph>
      getQueryArtifactLineageSubgraphMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QueryArtifactLineageSubgraph",
      requestType = com.google.cloud.aiplatform.v1beta1.QueryArtifactLineageSubgraphRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.LineageSubgraph.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.QueryArtifactLineageSubgraphRequest,
          com.google.cloud.aiplatform.v1beta1.LineageSubgraph>
      getQueryArtifactLineageSubgraphMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.QueryArtifactLineageSubgraphRequest,
            com.google.cloud.aiplatform.v1beta1.LineageSubgraph>
        getQueryArtifactLineageSubgraphMethod;
    if ((getQueryArtifactLineageSubgraphMethod =
            MetadataServiceGrpc.getQueryArtifactLineageSubgraphMethod)
        == null) {
      synchronized (MetadataServiceGrpc.class) {
        if ((getQueryArtifactLineageSubgraphMethod =
                MetadataServiceGrpc.getQueryArtifactLineageSubgraphMethod)
            == null) {
          MetadataServiceGrpc.getQueryArtifactLineageSubgraphMethod =
              getQueryArtifactLineageSubgraphMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.QueryArtifactLineageSubgraphRequest,
                          com.google.cloud.aiplatform.v1beta1.LineageSubgraph>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "QueryArtifactLineageSubgraph"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1
                                  .QueryArtifactLineageSubgraphRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.LineageSubgraph
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetadataServiceMethodDescriptorSupplier(
                              "QueryArtifactLineageSubgraph"))
                      .build();
        }
      }
    }
    return getQueryArtifactLineageSubgraphMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static MetadataServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MetadataServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MetadataServiceStub>() {
          @java.lang.Override
          public MetadataServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MetadataServiceStub(channel, callOptions);
          }
        };
    return MetadataServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MetadataServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MetadataServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MetadataServiceBlockingStub>() {
          @java.lang.Override
          public MetadataServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MetadataServiceBlockingStub(channel, callOptions);
          }
        };
    return MetadataServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static MetadataServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MetadataServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MetadataServiceFutureStub>() {
          @java.lang.Override
          public MetadataServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MetadataServiceFutureStub(channel, callOptions);
          }
        };
    return MetadataServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for reading and writing metadata entries.
   * </pre>
   */
  public abstract static class MetadataServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Initializes a MetadataStore, including allocation of resources.
     * </pre>
     */
    public void createMetadataStore(
        com.google.cloud.aiplatform.v1beta1.CreateMetadataStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateMetadataStoreMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a specific MetadataStore.
     * </pre>
     */
    public void getMetadataStore(
        com.google.cloud.aiplatform.v1beta1.GetMetadataStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.MetadataStore>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetMetadataStoreMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists MetadataStores for a Location.
     * </pre>
     */
    public void listMetadataStores(
        com.google.cloud.aiplatform.v1beta1.ListMetadataStoresRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListMetadataStoresResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMetadataStoresMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single MetadataStore and all its child resources (Artifacts,
     * Executions, and Contexts).
     * </pre>
     */
    public void deleteMetadataStore(
        com.google.cloud.aiplatform.v1beta1.DeleteMetadataStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteMetadataStoreMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an Artifact associated with a MetadataStore.
     * </pre>
     */
    public void createArtifact(
        com.google.cloud.aiplatform.v1beta1.CreateArtifactRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Artifact>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateArtifactMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a specific Artifact.
     * </pre>
     */
    public void getArtifact(
        com.google.cloud.aiplatform.v1beta1.GetArtifactRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Artifact>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetArtifactMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Artifacts in the MetadataStore.
     * </pre>
     */
    public void listArtifacts(
        com.google.cloud.aiplatform.v1beta1.ListArtifactsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListArtifactsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListArtifactsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a stored Artifact.
     * </pre>
     */
    public void updateArtifact(
        com.google.cloud.aiplatform.v1beta1.UpdateArtifactRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Artifact>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateArtifactMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an Artifact.
     * </pre>
     */
    public void deleteArtifact(
        com.google.cloud.aiplatform.v1beta1.DeleteArtifactRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteArtifactMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Purges Artifacts.
     * </pre>
     */
    public void purgeArtifacts(
        com.google.cloud.aiplatform.v1beta1.PurgeArtifactsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getPurgeArtifactsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a Context associated with a MetadataStore.
     * </pre>
     */
    public void createContext(
        com.google.cloud.aiplatform.v1beta1.CreateContextRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Context> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateContextMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a specific Context.
     * </pre>
     */
    public void getContext(
        com.google.cloud.aiplatform.v1beta1.GetContextRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Context> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetContextMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Contexts on the MetadataStore.
     * </pre>
     */
    public void listContexts(
        com.google.cloud.aiplatform.v1beta1.ListContextsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListContextsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListContextsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a stored Context.
     * </pre>
     */
    public void updateContext(
        com.google.cloud.aiplatform.v1beta1.UpdateContextRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Context> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateContextMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a stored Context.
     * </pre>
     */
    public void deleteContext(
        com.google.cloud.aiplatform.v1beta1.DeleteContextRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteContextMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Purges Contexts.
     * </pre>
     */
    public void purgeContexts(
        com.google.cloud.aiplatform.v1beta1.PurgeContextsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getPurgeContextsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds a set of Artifacts and Executions to a Context. If any of the
     * Artifacts or Executions have already been added to a Context, they are
     * simply skipped.
     * </pre>
     */
    public void addContextArtifactsAndExecutions(
        com.google.cloud.aiplatform.v1beta1.AddContextArtifactsAndExecutionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.AddContextArtifactsAndExecutionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAddContextArtifactsAndExecutionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds a set of Contexts as children to a parent Context. If any of the
     * child Contexts have already been added to the parent Context, they are
     * simply skipped. If this call would create a cycle or cause any Context to
     * have more than 10 parents, the request will fail with an INVALID_ARGUMENT
     * error.
     * </pre>
     */
    public void addContextChildren(
        com.google.cloud.aiplatform.v1beta1.AddContextChildrenRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.AddContextChildrenResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAddContextChildrenMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Remove a set of children contexts from a parent Context. If any of the
     * child Contexts were NOT added to the parent Context, they are
     * simply skipped.
     * </pre>
     */
    public void removeContextChildren(
        com.google.cloud.aiplatform.v1beta1.RemoveContextChildrenRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.RemoveContextChildrenResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRemoveContextChildrenMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves Artifacts and Executions within the specified Context, connected
     * by Event edges and returned as a LineageSubgraph.
     * </pre>
     */
    public void queryContextLineageSubgraph(
        com.google.cloud.aiplatform.v1beta1.QueryContextLineageSubgraphRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.LineageSubgraph>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getQueryContextLineageSubgraphMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an Execution associated with a MetadataStore.
     * </pre>
     */
    public void createExecution(
        com.google.cloud.aiplatform.v1beta1.CreateExecutionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Execution>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateExecutionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a specific Execution.
     * </pre>
     */
    public void getExecution(
        com.google.cloud.aiplatform.v1beta1.GetExecutionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Execution>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetExecutionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Executions in the MetadataStore.
     * </pre>
     */
    public void listExecutions(
        com.google.cloud.aiplatform.v1beta1.ListExecutionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListExecutionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListExecutionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a stored Execution.
     * </pre>
     */
    public void updateExecution(
        com.google.cloud.aiplatform.v1beta1.UpdateExecutionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Execution>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateExecutionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an Execution.
     * </pre>
     */
    public void deleteExecution(
        com.google.cloud.aiplatform.v1beta1.DeleteExecutionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteExecutionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Purges Executions.
     * </pre>
     */
    public void purgeExecutions(
        com.google.cloud.aiplatform.v1beta1.PurgeExecutionsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getPurgeExecutionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds Events to the specified Execution. An Event indicates whether an
     * Artifact was used as an input or output for an Execution. If an Event
     * already exists between the Execution and the Artifact, the Event is
     * skipped.
     * </pre>
     */
    public void addExecutionEvents(
        com.google.cloud.aiplatform.v1beta1.AddExecutionEventsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.AddExecutionEventsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAddExecutionEventsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Obtains the set of input and output Artifacts for this Execution, in the
     * form of LineageSubgraph that also contains the Execution and connecting
     * Events.
     * </pre>
     */
    public void queryExecutionInputsAndOutputs(
        com.google.cloud.aiplatform.v1beta1.QueryExecutionInputsAndOutputsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.LineageSubgraph>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getQueryExecutionInputsAndOutputsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a MetadataSchema.
     * </pre>
     */
    public void createMetadataSchema(
        com.google.cloud.aiplatform.v1beta1.CreateMetadataSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.MetadataSchema>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateMetadataSchemaMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a specific MetadataSchema.
     * </pre>
     */
    public void getMetadataSchema(
        com.google.cloud.aiplatform.v1beta1.GetMetadataSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.MetadataSchema>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetMetadataSchemaMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists MetadataSchemas.
     * </pre>
     */
    public void listMetadataSchemas(
        com.google.cloud.aiplatform.v1beta1.ListMetadataSchemasRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListMetadataSchemasResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMetadataSchemasMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves lineage of an Artifact represented through Artifacts and
     * Executions connected by Event edges and returned as a LineageSubgraph.
     * </pre>
     */
    public void queryArtifactLineageSubgraph(
        com.google.cloud.aiplatform.v1beta1.QueryArtifactLineageSubgraphRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.LineageSubgraph>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getQueryArtifactLineageSubgraphMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateMetadataStoreMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.CreateMetadataStoreRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_METADATA_STORE)))
          .addMethod(
              getGetMetadataStoreMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.GetMetadataStoreRequest,
                      com.google.cloud.aiplatform.v1beta1.MetadataStore>(
                      this, METHODID_GET_METADATA_STORE)))
          .addMethod(
              getListMetadataStoresMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.ListMetadataStoresRequest,
                      com.google.cloud.aiplatform.v1beta1.ListMetadataStoresResponse>(
                      this, METHODID_LIST_METADATA_STORES)))
          .addMethod(
              getDeleteMetadataStoreMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.DeleteMetadataStoreRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_METADATA_STORE)))
          .addMethod(
              getCreateArtifactMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.CreateArtifactRequest,
                      com.google.cloud.aiplatform.v1beta1.Artifact>(
                      this, METHODID_CREATE_ARTIFACT)))
          .addMethod(
              getGetArtifactMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.GetArtifactRequest,
                      com.google.cloud.aiplatform.v1beta1.Artifact>(this, METHODID_GET_ARTIFACT)))
          .addMethod(
              getListArtifactsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.ListArtifactsRequest,
                      com.google.cloud.aiplatform.v1beta1.ListArtifactsResponse>(
                      this, METHODID_LIST_ARTIFACTS)))
          .addMethod(
              getUpdateArtifactMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.UpdateArtifactRequest,
                      com.google.cloud.aiplatform.v1beta1.Artifact>(
                      this, METHODID_UPDATE_ARTIFACT)))
          .addMethod(
              getDeleteArtifactMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.DeleteArtifactRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_ARTIFACT)))
          .addMethod(
              getPurgeArtifactsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.PurgeArtifactsRequest,
                      com.google.longrunning.Operation>(this, METHODID_PURGE_ARTIFACTS)))
          .addMethod(
              getCreateContextMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.CreateContextRequest,
                      com.google.cloud.aiplatform.v1beta1.Context>(this, METHODID_CREATE_CONTEXT)))
          .addMethod(
              getGetContextMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.GetContextRequest,
                      com.google.cloud.aiplatform.v1beta1.Context>(this, METHODID_GET_CONTEXT)))
          .addMethod(
              getListContextsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.ListContextsRequest,
                      com.google.cloud.aiplatform.v1beta1.ListContextsResponse>(
                      this, METHODID_LIST_CONTEXTS)))
          .addMethod(
              getUpdateContextMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.UpdateContextRequest,
                      com.google.cloud.aiplatform.v1beta1.Context>(this, METHODID_UPDATE_CONTEXT)))
          .addMethod(
              getDeleteContextMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.DeleteContextRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_CONTEXT)))
          .addMethod(
              getPurgeContextsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.PurgeContextsRequest,
                      com.google.longrunning.Operation>(this, METHODID_PURGE_CONTEXTS)))
          .addMethod(
              getAddContextArtifactsAndExecutionsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.AddContextArtifactsAndExecutionsRequest,
                      com.google.cloud.aiplatform.v1beta1.AddContextArtifactsAndExecutionsResponse>(
                      this, METHODID_ADD_CONTEXT_ARTIFACTS_AND_EXECUTIONS)))
          .addMethod(
              getAddContextChildrenMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.AddContextChildrenRequest,
                      com.google.cloud.aiplatform.v1beta1.AddContextChildrenResponse>(
                      this, METHODID_ADD_CONTEXT_CHILDREN)))
          .addMethod(
              getRemoveContextChildrenMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.RemoveContextChildrenRequest,
                      com.google.cloud.aiplatform.v1beta1.RemoveContextChildrenResponse>(
                      this, METHODID_REMOVE_CONTEXT_CHILDREN)))
          .addMethod(
              getQueryContextLineageSubgraphMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.QueryContextLineageSubgraphRequest,
                      com.google.cloud.aiplatform.v1beta1.LineageSubgraph>(
                      this, METHODID_QUERY_CONTEXT_LINEAGE_SUBGRAPH)))
          .addMethod(
              getCreateExecutionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.CreateExecutionRequest,
                      com.google.cloud.aiplatform.v1beta1.Execution>(
                      this, METHODID_CREATE_EXECUTION)))
          .addMethod(
              getGetExecutionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.GetExecutionRequest,
                      com.google.cloud.aiplatform.v1beta1.Execution>(this, METHODID_GET_EXECUTION)))
          .addMethod(
              getListExecutionsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.ListExecutionsRequest,
                      com.google.cloud.aiplatform.v1beta1.ListExecutionsResponse>(
                      this, METHODID_LIST_EXECUTIONS)))
          .addMethod(
              getUpdateExecutionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.UpdateExecutionRequest,
                      com.google.cloud.aiplatform.v1beta1.Execution>(
                      this, METHODID_UPDATE_EXECUTION)))
          .addMethod(
              getDeleteExecutionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.DeleteExecutionRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_EXECUTION)))
          .addMethod(
              getPurgeExecutionsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.PurgeExecutionsRequest,
                      com.google.longrunning.Operation>(this, METHODID_PURGE_EXECUTIONS)))
          .addMethod(
              getAddExecutionEventsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.AddExecutionEventsRequest,
                      com.google.cloud.aiplatform.v1beta1.AddExecutionEventsResponse>(
                      this, METHODID_ADD_EXECUTION_EVENTS)))
          .addMethod(
              getQueryExecutionInputsAndOutputsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.QueryExecutionInputsAndOutputsRequest,
                      com.google.cloud.aiplatform.v1beta1.LineageSubgraph>(
                      this, METHODID_QUERY_EXECUTION_INPUTS_AND_OUTPUTS)))
          .addMethod(
              getCreateMetadataSchemaMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.CreateMetadataSchemaRequest,
                      com.google.cloud.aiplatform.v1beta1.MetadataSchema>(
                      this, METHODID_CREATE_METADATA_SCHEMA)))
          .addMethod(
              getGetMetadataSchemaMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.GetMetadataSchemaRequest,
                      com.google.cloud.aiplatform.v1beta1.MetadataSchema>(
                      this, METHODID_GET_METADATA_SCHEMA)))
          .addMethod(
              getListMetadataSchemasMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.ListMetadataSchemasRequest,
                      com.google.cloud.aiplatform.v1beta1.ListMetadataSchemasResponse>(
                      this, METHODID_LIST_METADATA_SCHEMAS)))
          .addMethod(
              getQueryArtifactLineageSubgraphMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1beta1.QueryArtifactLineageSubgraphRequest,
                      com.google.cloud.aiplatform.v1beta1.LineageSubgraph>(
                      this, METHODID_QUERY_ARTIFACT_LINEAGE_SUBGRAPH)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service for reading and writing metadata entries.
   * </pre>
   */
  public static final class MetadataServiceStub
      extends io.grpc.stub.AbstractAsyncStub<MetadataServiceStub> {
    private MetadataServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MetadataServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MetadataServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Initializes a MetadataStore, including allocation of resources.
     * </pre>
     */
    public void createMetadataStore(
        com.google.cloud.aiplatform.v1beta1.CreateMetadataStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMetadataStoreMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a specific MetadataStore.
     * </pre>
     */
    public void getMetadataStore(
        com.google.cloud.aiplatform.v1beta1.GetMetadataStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.MetadataStore>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMetadataStoreMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists MetadataStores for a Location.
     * </pre>
     */
    public void listMetadataStores(
        com.google.cloud.aiplatform.v1beta1.ListMetadataStoresRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListMetadataStoresResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMetadataStoresMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single MetadataStore and all its child resources (Artifacts,
     * Executions, and Contexts).
     * </pre>
     */
    public void deleteMetadataStore(
        com.google.cloud.aiplatform.v1beta1.DeleteMetadataStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMetadataStoreMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an Artifact associated with a MetadataStore.
     * </pre>
     */
    public void createArtifact(
        com.google.cloud.aiplatform.v1beta1.CreateArtifactRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Artifact>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateArtifactMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a specific Artifact.
     * </pre>
     */
    public void getArtifact(
        com.google.cloud.aiplatform.v1beta1.GetArtifactRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Artifact>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetArtifactMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Artifacts in the MetadataStore.
     * </pre>
     */
    public void listArtifacts(
        com.google.cloud.aiplatform.v1beta1.ListArtifactsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListArtifactsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListArtifactsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a stored Artifact.
     * </pre>
     */
    public void updateArtifact(
        com.google.cloud.aiplatform.v1beta1.UpdateArtifactRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Artifact>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateArtifactMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an Artifact.
     * </pre>
     */
    public void deleteArtifact(
        com.google.cloud.aiplatform.v1beta1.DeleteArtifactRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteArtifactMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Purges Artifacts.
     * </pre>
     */
    public void purgeArtifacts(
        com.google.cloud.aiplatform.v1beta1.PurgeArtifactsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPurgeArtifactsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a Context associated with a MetadataStore.
     * </pre>
     */
    public void createContext(
        com.google.cloud.aiplatform.v1beta1.CreateContextRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Context> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateContextMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a specific Context.
     * </pre>
     */
    public void getContext(
        com.google.cloud.aiplatform.v1beta1.GetContextRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Context> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetContextMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Contexts on the MetadataStore.
     * </pre>
     */
    public void listContexts(
        com.google.cloud.aiplatform.v1beta1.ListContextsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListContextsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListContextsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a stored Context.
     * </pre>
     */
    public void updateContext(
        com.google.cloud.aiplatform.v1beta1.UpdateContextRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Context> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateContextMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a stored Context.
     * </pre>
     */
    public void deleteContext(
        com.google.cloud.aiplatform.v1beta1.DeleteContextRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteContextMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Purges Contexts.
     * </pre>
     */
    public void purgeContexts(
        com.google.cloud.aiplatform.v1beta1.PurgeContextsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPurgeContextsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds a set of Artifacts and Executions to a Context. If any of the
     * Artifacts or Executions have already been added to a Context, they are
     * simply skipped.
     * </pre>
     */
    public void addContextArtifactsAndExecutions(
        com.google.cloud.aiplatform.v1beta1.AddContextArtifactsAndExecutionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.AddContextArtifactsAndExecutionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddContextArtifactsAndExecutionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds a set of Contexts as children to a parent Context. If any of the
     * child Contexts have already been added to the parent Context, they are
     * simply skipped. If this call would create a cycle or cause any Context to
     * have more than 10 parents, the request will fail with an INVALID_ARGUMENT
     * error.
     * </pre>
     */
    public void addContextChildren(
        com.google.cloud.aiplatform.v1beta1.AddContextChildrenRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.AddContextChildrenResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddContextChildrenMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Remove a set of children contexts from a parent Context. If any of the
     * child Contexts were NOT added to the parent Context, they are
     * simply skipped.
     * </pre>
     */
    public void removeContextChildren(
        com.google.cloud.aiplatform.v1beta1.RemoveContextChildrenRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.RemoveContextChildrenResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRemoveContextChildrenMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves Artifacts and Executions within the specified Context, connected
     * by Event edges and returned as a LineageSubgraph.
     * </pre>
     */
    public void queryContextLineageSubgraph(
        com.google.cloud.aiplatform.v1beta1.QueryContextLineageSubgraphRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.LineageSubgraph>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getQueryContextLineageSubgraphMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an Execution associated with a MetadataStore.
     * </pre>
     */
    public void createExecution(
        com.google.cloud.aiplatform.v1beta1.CreateExecutionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Execution>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateExecutionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a specific Execution.
     * </pre>
     */
    public void getExecution(
        com.google.cloud.aiplatform.v1beta1.GetExecutionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Execution>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetExecutionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Executions in the MetadataStore.
     * </pre>
     */
    public void listExecutions(
        com.google.cloud.aiplatform.v1beta1.ListExecutionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListExecutionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListExecutionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a stored Execution.
     * </pre>
     */
    public void updateExecution(
        com.google.cloud.aiplatform.v1beta1.UpdateExecutionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Execution>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateExecutionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an Execution.
     * </pre>
     */
    public void deleteExecution(
        com.google.cloud.aiplatform.v1beta1.DeleteExecutionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteExecutionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Purges Executions.
     * </pre>
     */
    public void purgeExecutions(
        com.google.cloud.aiplatform.v1beta1.PurgeExecutionsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPurgeExecutionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds Events to the specified Execution. An Event indicates whether an
     * Artifact was used as an input or output for an Execution. If an Event
     * already exists between the Execution and the Artifact, the Event is
     * skipped.
     * </pre>
     */
    public void addExecutionEvents(
        com.google.cloud.aiplatform.v1beta1.AddExecutionEventsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.AddExecutionEventsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddExecutionEventsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Obtains the set of input and output Artifacts for this Execution, in the
     * form of LineageSubgraph that also contains the Execution and connecting
     * Events.
     * </pre>
     */
    public void queryExecutionInputsAndOutputs(
        com.google.cloud.aiplatform.v1beta1.QueryExecutionInputsAndOutputsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.LineageSubgraph>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getQueryExecutionInputsAndOutputsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a MetadataSchema.
     * </pre>
     */
    public void createMetadataSchema(
        com.google.cloud.aiplatform.v1beta1.CreateMetadataSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.MetadataSchema>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMetadataSchemaMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a specific MetadataSchema.
     * </pre>
     */
    public void getMetadataSchema(
        com.google.cloud.aiplatform.v1beta1.GetMetadataSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.MetadataSchema>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMetadataSchemaMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists MetadataSchemas.
     * </pre>
     */
    public void listMetadataSchemas(
        com.google.cloud.aiplatform.v1beta1.ListMetadataSchemasRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListMetadataSchemasResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMetadataSchemasMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves lineage of an Artifact represented through Artifacts and
     * Executions connected by Event edges and returned as a LineageSubgraph.
     * </pre>
     */
    public void queryArtifactLineageSubgraph(
        com.google.cloud.aiplatform.v1beta1.QueryArtifactLineageSubgraphRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.LineageSubgraph>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getQueryArtifactLineageSubgraphMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for reading and writing metadata entries.
   * </pre>
   */
  public static final class MetadataServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MetadataServiceBlockingStub> {
    private MetadataServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MetadataServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MetadataServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Initializes a MetadataStore, including allocation of resources.
     * </pre>
     */
    public com.google.longrunning.Operation createMetadataStore(
        com.google.cloud.aiplatform.v1beta1.CreateMetadataStoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMetadataStoreMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a specific MetadataStore.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.MetadataStore getMetadataStore(
        com.google.cloud.aiplatform.v1beta1.GetMetadataStoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMetadataStoreMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists MetadataStores for a Location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListMetadataStoresResponse listMetadataStores(
        com.google.cloud.aiplatform.v1beta1.ListMetadataStoresRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMetadataStoresMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single MetadataStore and all its child resources (Artifacts,
     * Executions, and Contexts).
     * </pre>
     */
    public com.google.longrunning.Operation deleteMetadataStore(
        com.google.cloud.aiplatform.v1beta1.DeleteMetadataStoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMetadataStoreMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an Artifact associated with a MetadataStore.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.Artifact createArtifact(
        com.google.cloud.aiplatform.v1beta1.CreateArtifactRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateArtifactMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a specific Artifact.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.Artifact getArtifact(
        com.google.cloud.aiplatform.v1beta1.GetArtifactRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetArtifactMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Artifacts in the MetadataStore.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListArtifactsResponse listArtifacts(
        com.google.cloud.aiplatform.v1beta1.ListArtifactsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListArtifactsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a stored Artifact.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.Artifact updateArtifact(
        com.google.cloud.aiplatform.v1beta1.UpdateArtifactRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateArtifactMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an Artifact.
     * </pre>
     */
    public com.google.longrunning.Operation deleteArtifact(
        com.google.cloud.aiplatform.v1beta1.DeleteArtifactRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteArtifactMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Purges Artifacts.
     * </pre>
     */
    public com.google.longrunning.Operation purgeArtifacts(
        com.google.cloud.aiplatform.v1beta1.PurgeArtifactsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPurgeArtifactsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Context associated with a MetadataStore.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.Context createContext(
        com.google.cloud.aiplatform.v1beta1.CreateContextRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateContextMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a specific Context.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.Context getContext(
        com.google.cloud.aiplatform.v1beta1.GetContextRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetContextMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Contexts on the MetadataStore.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListContextsResponse listContexts(
        com.google.cloud.aiplatform.v1beta1.ListContextsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListContextsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a stored Context.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.Context updateContext(
        com.google.cloud.aiplatform.v1beta1.UpdateContextRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateContextMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a stored Context.
     * </pre>
     */
    public com.google.longrunning.Operation deleteContext(
        com.google.cloud.aiplatform.v1beta1.DeleteContextRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteContextMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Purges Contexts.
     * </pre>
     */
    public com.google.longrunning.Operation purgeContexts(
        com.google.cloud.aiplatform.v1beta1.PurgeContextsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPurgeContextsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Adds a set of Artifacts and Executions to a Context. If any of the
     * Artifacts or Executions have already been added to a Context, they are
     * simply skipped.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.AddContextArtifactsAndExecutionsResponse
        addContextArtifactsAndExecutions(
            com.google.cloud.aiplatform.v1beta1.AddContextArtifactsAndExecutionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddContextArtifactsAndExecutionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Adds a set of Contexts as children to a parent Context. If any of the
     * child Contexts have already been added to the parent Context, they are
     * simply skipped. If this call would create a cycle or cause any Context to
     * have more than 10 parents, the request will fail with an INVALID_ARGUMENT
     * error.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.AddContextChildrenResponse addContextChildren(
        com.google.cloud.aiplatform.v1beta1.AddContextChildrenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddContextChildrenMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Remove a set of children contexts from a parent Context. If any of the
     * child Contexts were NOT added to the parent Context, they are
     * simply skipped.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.RemoveContextChildrenResponse removeContextChildren(
        com.google.cloud.aiplatform.v1beta1.RemoveContextChildrenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveContextChildrenMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves Artifacts and Executions within the specified Context, connected
     * by Event edges and returned as a LineageSubgraph.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.LineageSubgraph queryContextLineageSubgraph(
        com.google.cloud.aiplatform.v1beta1.QueryContextLineageSubgraphRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQueryContextLineageSubgraphMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an Execution associated with a MetadataStore.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.Execution createExecution(
        com.google.cloud.aiplatform.v1beta1.CreateExecutionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateExecutionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a specific Execution.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.Execution getExecution(
        com.google.cloud.aiplatform.v1beta1.GetExecutionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetExecutionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Executions in the MetadataStore.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListExecutionsResponse listExecutions(
        com.google.cloud.aiplatform.v1beta1.ListExecutionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListExecutionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a stored Execution.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.Execution updateExecution(
        com.google.cloud.aiplatform.v1beta1.UpdateExecutionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateExecutionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an Execution.
     * </pre>
     */
    public com.google.longrunning.Operation deleteExecution(
        com.google.cloud.aiplatform.v1beta1.DeleteExecutionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteExecutionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Purges Executions.
     * </pre>
     */
    public com.google.longrunning.Operation purgeExecutions(
        com.google.cloud.aiplatform.v1beta1.PurgeExecutionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPurgeExecutionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Adds Events to the specified Execution. An Event indicates whether an
     * Artifact was used as an input or output for an Execution. If an Event
     * already exists between the Execution and the Artifact, the Event is
     * skipped.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.AddExecutionEventsResponse addExecutionEvents(
        com.google.cloud.aiplatform.v1beta1.AddExecutionEventsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddExecutionEventsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Obtains the set of input and output Artifacts for this Execution, in the
     * form of LineageSubgraph that also contains the Execution and connecting
     * Events.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.LineageSubgraph queryExecutionInputsAndOutputs(
        com.google.cloud.aiplatform.v1beta1.QueryExecutionInputsAndOutputsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQueryExecutionInputsAndOutputsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a MetadataSchema.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.MetadataSchema createMetadataSchema(
        com.google.cloud.aiplatform.v1beta1.CreateMetadataSchemaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMetadataSchemaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a specific MetadataSchema.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.MetadataSchema getMetadataSchema(
        com.google.cloud.aiplatform.v1beta1.GetMetadataSchemaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMetadataSchemaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists MetadataSchemas.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListMetadataSchemasResponse listMetadataSchemas(
        com.google.cloud.aiplatform.v1beta1.ListMetadataSchemasRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMetadataSchemasMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves lineage of an Artifact represented through Artifacts and
     * Executions connected by Event edges and returned as a LineageSubgraph.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.LineageSubgraph queryArtifactLineageSubgraph(
        com.google.cloud.aiplatform.v1beta1.QueryArtifactLineageSubgraphRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQueryArtifactLineageSubgraphMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for reading and writing metadata entries.
   * </pre>
   */
  public static final class MetadataServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<MetadataServiceFutureStub> {
    private MetadataServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MetadataServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MetadataServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Initializes a MetadataStore, including allocation of resources.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createMetadataStore(
            com.google.cloud.aiplatform.v1beta1.CreateMetadataStoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMetadataStoreMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a specific MetadataStore.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.MetadataStore>
        getMetadataStore(com.google.cloud.aiplatform.v1beta1.GetMetadataStoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMetadataStoreMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists MetadataStores for a Location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ListMetadataStoresResponse>
        listMetadataStores(com.google.cloud.aiplatform.v1beta1.ListMetadataStoresRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMetadataStoresMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single MetadataStore and all its child resources (Artifacts,
     * Executions, and Contexts).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteMetadataStore(
            com.google.cloud.aiplatform.v1beta1.DeleteMetadataStoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMetadataStoreMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an Artifact associated with a MetadataStore.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.Artifact>
        createArtifact(com.google.cloud.aiplatform.v1beta1.CreateArtifactRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateArtifactMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a specific Artifact.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.Artifact>
        getArtifact(com.google.cloud.aiplatform.v1beta1.GetArtifactRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetArtifactMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Artifacts in the MetadataStore.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ListArtifactsResponse>
        listArtifacts(com.google.cloud.aiplatform.v1beta1.ListArtifactsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListArtifactsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a stored Artifact.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.Artifact>
        updateArtifact(com.google.cloud.aiplatform.v1beta1.UpdateArtifactRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateArtifactMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an Artifact.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteArtifact(com.google.cloud.aiplatform.v1beta1.DeleteArtifactRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteArtifactMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Purges Artifacts.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        purgeArtifacts(com.google.cloud.aiplatform.v1beta1.PurgeArtifactsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPurgeArtifactsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Context associated with a MetadataStore.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.Context>
        createContext(com.google.cloud.aiplatform.v1beta1.CreateContextRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateContextMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a specific Context.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.Context>
        getContext(com.google.cloud.aiplatform.v1beta1.GetContextRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetContextMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Contexts on the MetadataStore.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ListContextsResponse>
        listContexts(com.google.cloud.aiplatform.v1beta1.ListContextsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListContextsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a stored Context.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.Context>
        updateContext(com.google.cloud.aiplatform.v1beta1.UpdateContextRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateContextMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a stored Context.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteContext(com.google.cloud.aiplatform.v1beta1.DeleteContextRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteContextMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Purges Contexts.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        purgeContexts(com.google.cloud.aiplatform.v1beta1.PurgeContextsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPurgeContextsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Adds a set of Artifacts and Executions to a Context. If any of the
     * Artifacts or Executions have already been added to a Context, they are
     * simply skipped.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.AddContextArtifactsAndExecutionsResponse>
        addContextArtifactsAndExecutions(
            com.google.cloud.aiplatform.v1beta1.AddContextArtifactsAndExecutionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddContextArtifactsAndExecutionsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Adds a set of Contexts as children to a parent Context. If any of the
     * child Contexts have already been added to the parent Context, they are
     * simply skipped. If this call would create a cycle or cause any Context to
     * have more than 10 parents, the request will fail with an INVALID_ARGUMENT
     * error.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.AddContextChildrenResponse>
        addContextChildren(com.google.cloud.aiplatform.v1beta1.AddContextChildrenRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddContextChildrenMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Remove a set of children contexts from a parent Context. If any of the
     * child Contexts were NOT added to the parent Context, they are
     * simply skipped.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.RemoveContextChildrenResponse>
        removeContextChildren(
            com.google.cloud.aiplatform.v1beta1.RemoveContextChildrenRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRemoveContextChildrenMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves Artifacts and Executions within the specified Context, connected
     * by Event edges and returned as a LineageSubgraph.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.LineageSubgraph>
        queryContextLineageSubgraph(
            com.google.cloud.aiplatform.v1beta1.QueryContextLineageSubgraphRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getQueryContextLineageSubgraphMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an Execution associated with a MetadataStore.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.Execution>
        createExecution(com.google.cloud.aiplatform.v1beta1.CreateExecutionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateExecutionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a specific Execution.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.Execution>
        getExecution(com.google.cloud.aiplatform.v1beta1.GetExecutionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetExecutionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Executions in the MetadataStore.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ListExecutionsResponse>
        listExecutions(com.google.cloud.aiplatform.v1beta1.ListExecutionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListExecutionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a stored Execution.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.Execution>
        updateExecution(com.google.cloud.aiplatform.v1beta1.UpdateExecutionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateExecutionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an Execution.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteExecution(com.google.cloud.aiplatform.v1beta1.DeleteExecutionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteExecutionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Purges Executions.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        purgeExecutions(com.google.cloud.aiplatform.v1beta1.PurgeExecutionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPurgeExecutionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Adds Events to the specified Execution. An Event indicates whether an
     * Artifact was used as an input or output for an Execution. If an Event
     * already exists between the Execution and the Artifact, the Event is
     * skipped.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.AddExecutionEventsResponse>
        addExecutionEvents(com.google.cloud.aiplatform.v1beta1.AddExecutionEventsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddExecutionEventsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Obtains the set of input and output Artifacts for this Execution, in the
     * form of LineageSubgraph that also contains the Execution and connecting
     * Events.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.LineageSubgraph>
        queryExecutionInputsAndOutputs(
            com.google.cloud.aiplatform.v1beta1.QueryExecutionInputsAndOutputsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getQueryExecutionInputsAndOutputsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Creates a MetadataSchema.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.MetadataSchema>
        createMetadataSchema(
            com.google.cloud.aiplatform.v1beta1.CreateMetadataSchemaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMetadataSchemaMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a specific MetadataSchema.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.MetadataSchema>
        getMetadataSchema(com.google.cloud.aiplatform.v1beta1.GetMetadataSchemaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMetadataSchemaMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists MetadataSchemas.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ListMetadataSchemasResponse>
        listMetadataSchemas(
            com.google.cloud.aiplatform.v1beta1.ListMetadataSchemasRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMetadataSchemasMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves lineage of an Artifact represented through Artifacts and
     * Executions connected by Event edges and returned as a LineageSubgraph.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.LineageSubgraph>
        queryArtifactLineageSubgraph(
            com.google.cloud.aiplatform.v1beta1.QueryArtifactLineageSubgraphRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getQueryArtifactLineageSubgraphMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_METADATA_STORE = 0;
  private static final int METHODID_GET_METADATA_STORE = 1;
  private static final int METHODID_LIST_METADATA_STORES = 2;
  private static final int METHODID_DELETE_METADATA_STORE = 3;
  private static final int METHODID_CREATE_ARTIFACT = 4;
  private static final int METHODID_GET_ARTIFACT = 5;
  private static final int METHODID_LIST_ARTIFACTS = 6;
  private static final int METHODID_UPDATE_ARTIFACT = 7;
  private static final int METHODID_DELETE_ARTIFACT = 8;
  private static final int METHODID_PURGE_ARTIFACTS = 9;
  private static final int METHODID_CREATE_CONTEXT = 10;
  private static final int METHODID_GET_CONTEXT = 11;
  private static final int METHODID_LIST_CONTEXTS = 12;
  private static final int METHODID_UPDATE_CONTEXT = 13;
  private static final int METHODID_DELETE_CONTEXT = 14;
  private static final int METHODID_PURGE_CONTEXTS = 15;
  private static final int METHODID_ADD_CONTEXT_ARTIFACTS_AND_EXECUTIONS = 16;
  private static final int METHODID_ADD_CONTEXT_CHILDREN = 17;
  private static final int METHODID_REMOVE_CONTEXT_CHILDREN = 18;
  private static final int METHODID_QUERY_CONTEXT_LINEAGE_SUBGRAPH = 19;
  private static final int METHODID_CREATE_EXECUTION = 20;
  private static final int METHODID_GET_EXECUTION = 21;
  private static final int METHODID_LIST_EXECUTIONS = 22;
  private static final int METHODID_UPDATE_EXECUTION = 23;
  private static final int METHODID_DELETE_EXECUTION = 24;
  private static final int METHODID_PURGE_EXECUTIONS = 25;
  private static final int METHODID_ADD_EXECUTION_EVENTS = 26;
  private static final int METHODID_QUERY_EXECUTION_INPUTS_AND_OUTPUTS = 27;
  private static final int METHODID_CREATE_METADATA_SCHEMA = 28;
  private static final int METHODID_GET_METADATA_SCHEMA = 29;
  private static final int METHODID_LIST_METADATA_SCHEMAS = 30;
  private static final int METHODID_QUERY_ARTIFACT_LINEAGE_SUBGRAPH = 31;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MetadataServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MetadataServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_METADATA_STORE:
          serviceImpl.createMetadataStore(
              (com.google.cloud.aiplatform.v1beta1.CreateMetadataStoreRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_METADATA_STORE:
          serviceImpl.getMetadataStore(
              (com.google.cloud.aiplatform.v1beta1.GetMetadataStoreRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.MetadataStore>)
                  responseObserver);
          break;
        case METHODID_LIST_METADATA_STORES:
          serviceImpl.listMetadataStores(
              (com.google.cloud.aiplatform.v1beta1.ListMetadataStoresRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.ListMetadataStoresResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_METADATA_STORE:
          serviceImpl.deleteMetadataStore(
              (com.google.cloud.aiplatform.v1beta1.DeleteMetadataStoreRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_ARTIFACT:
          serviceImpl.createArtifact(
              (com.google.cloud.aiplatform.v1beta1.CreateArtifactRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Artifact>)
                  responseObserver);
          break;
        case METHODID_GET_ARTIFACT:
          serviceImpl.getArtifact(
              (com.google.cloud.aiplatform.v1beta1.GetArtifactRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Artifact>)
                  responseObserver);
          break;
        case METHODID_LIST_ARTIFACTS:
          serviceImpl.listArtifacts(
              (com.google.cloud.aiplatform.v1beta1.ListArtifactsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.ListArtifactsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_ARTIFACT:
          serviceImpl.updateArtifact(
              (com.google.cloud.aiplatform.v1beta1.UpdateArtifactRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Artifact>)
                  responseObserver);
          break;
        case METHODID_DELETE_ARTIFACT:
          serviceImpl.deleteArtifact(
              (com.google.cloud.aiplatform.v1beta1.DeleteArtifactRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_PURGE_ARTIFACTS:
          serviceImpl.purgeArtifacts(
              (com.google.cloud.aiplatform.v1beta1.PurgeArtifactsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_CONTEXT:
          serviceImpl.createContext(
              (com.google.cloud.aiplatform.v1beta1.CreateContextRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Context>)
                  responseObserver);
          break;
        case METHODID_GET_CONTEXT:
          serviceImpl.getContext(
              (com.google.cloud.aiplatform.v1beta1.GetContextRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Context>)
                  responseObserver);
          break;
        case METHODID_LIST_CONTEXTS:
          serviceImpl.listContexts(
              (com.google.cloud.aiplatform.v1beta1.ListContextsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.ListContextsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_CONTEXT:
          serviceImpl.updateContext(
              (com.google.cloud.aiplatform.v1beta1.UpdateContextRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Context>)
                  responseObserver);
          break;
        case METHODID_DELETE_CONTEXT:
          serviceImpl.deleteContext(
              (com.google.cloud.aiplatform.v1beta1.DeleteContextRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_PURGE_CONTEXTS:
          serviceImpl.purgeContexts(
              (com.google.cloud.aiplatform.v1beta1.PurgeContextsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_ADD_CONTEXT_ARTIFACTS_AND_EXECUTIONS:
          serviceImpl.addContextArtifactsAndExecutions(
              (com.google.cloud.aiplatform.v1beta1.AddContextArtifactsAndExecutionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.AddContextArtifactsAndExecutionsResponse>)
                  responseObserver);
          break;
        case METHODID_ADD_CONTEXT_CHILDREN:
          serviceImpl.addContextChildren(
              (com.google.cloud.aiplatform.v1beta1.AddContextChildrenRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.AddContextChildrenResponse>)
                  responseObserver);
          break;
        case METHODID_REMOVE_CONTEXT_CHILDREN:
          serviceImpl.removeContextChildren(
              (com.google.cloud.aiplatform.v1beta1.RemoveContextChildrenRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.RemoveContextChildrenResponse>)
                  responseObserver);
          break;
        case METHODID_QUERY_CONTEXT_LINEAGE_SUBGRAPH:
          serviceImpl.queryContextLineageSubgraph(
              (com.google.cloud.aiplatform.v1beta1.QueryContextLineageSubgraphRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.LineageSubgraph>)
                  responseObserver);
          break;
        case METHODID_CREATE_EXECUTION:
          serviceImpl.createExecution(
              (com.google.cloud.aiplatform.v1beta1.CreateExecutionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Execution>)
                  responseObserver);
          break;
        case METHODID_GET_EXECUTION:
          serviceImpl.getExecution(
              (com.google.cloud.aiplatform.v1beta1.GetExecutionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Execution>)
                  responseObserver);
          break;
        case METHODID_LIST_EXECUTIONS:
          serviceImpl.listExecutions(
              (com.google.cloud.aiplatform.v1beta1.ListExecutionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.ListExecutionsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_EXECUTION:
          serviceImpl.updateExecution(
              (com.google.cloud.aiplatform.v1beta1.UpdateExecutionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Execution>)
                  responseObserver);
          break;
        case METHODID_DELETE_EXECUTION:
          serviceImpl.deleteExecution(
              (com.google.cloud.aiplatform.v1beta1.DeleteExecutionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_PURGE_EXECUTIONS:
          serviceImpl.purgeExecutions(
              (com.google.cloud.aiplatform.v1beta1.PurgeExecutionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_ADD_EXECUTION_EVENTS:
          serviceImpl.addExecutionEvents(
              (com.google.cloud.aiplatform.v1beta1.AddExecutionEventsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.AddExecutionEventsResponse>)
                  responseObserver);
          break;
        case METHODID_QUERY_EXECUTION_INPUTS_AND_OUTPUTS:
          serviceImpl.queryExecutionInputsAndOutputs(
              (com.google.cloud.aiplatform.v1beta1.QueryExecutionInputsAndOutputsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.LineageSubgraph>)
                  responseObserver);
          break;
        case METHODID_CREATE_METADATA_SCHEMA:
          serviceImpl.createMetadataSchema(
              (com.google.cloud.aiplatform.v1beta1.CreateMetadataSchemaRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.MetadataSchema>)
                  responseObserver);
          break;
        case METHODID_GET_METADATA_SCHEMA:
          serviceImpl.getMetadataSchema(
              (com.google.cloud.aiplatform.v1beta1.GetMetadataSchemaRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.MetadataSchema>)
                  responseObserver);
          break;
        case METHODID_LIST_METADATA_SCHEMAS:
          serviceImpl.listMetadataSchemas(
              (com.google.cloud.aiplatform.v1beta1.ListMetadataSchemasRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.ListMetadataSchemasResponse>)
                  responseObserver);
          break;
        case METHODID_QUERY_ARTIFACT_LINEAGE_SUBGRAPH:
          serviceImpl.queryArtifactLineageSubgraph(
              (com.google.cloud.aiplatform.v1beta1.QueryArtifactLineageSubgraphRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.LineageSubgraph>)
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

  private abstract static class MetadataServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MetadataServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1beta1.MetadataServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MetadataService");
    }
  }

  private static final class MetadataServiceFileDescriptorSupplier
      extends MetadataServiceBaseDescriptorSupplier {
    MetadataServiceFileDescriptorSupplier() {}
  }

  private static final class MetadataServiceMethodDescriptorSupplier
      extends MetadataServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MetadataServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (MetadataServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new MetadataServiceFileDescriptorSupplier())
                      .addMethod(getCreateMetadataStoreMethod())
                      .addMethod(getGetMetadataStoreMethod())
                      .addMethod(getListMetadataStoresMethod())
                      .addMethod(getDeleteMetadataStoreMethod())
                      .addMethod(getCreateArtifactMethod())
                      .addMethod(getGetArtifactMethod())
                      .addMethod(getListArtifactsMethod())
                      .addMethod(getUpdateArtifactMethod())
                      .addMethod(getDeleteArtifactMethod())
                      .addMethod(getPurgeArtifactsMethod())
                      .addMethod(getCreateContextMethod())
                      .addMethod(getGetContextMethod())
                      .addMethod(getListContextsMethod())
                      .addMethod(getUpdateContextMethod())
                      .addMethod(getDeleteContextMethod())
                      .addMethod(getPurgeContextsMethod())
                      .addMethod(getAddContextArtifactsAndExecutionsMethod())
                      .addMethod(getAddContextChildrenMethod())
                      .addMethod(getRemoveContextChildrenMethod())
                      .addMethod(getQueryContextLineageSubgraphMethod())
                      .addMethod(getCreateExecutionMethod())
                      .addMethod(getGetExecutionMethod())
                      .addMethod(getListExecutionsMethod())
                      .addMethod(getUpdateExecutionMethod())
                      .addMethod(getDeleteExecutionMethod())
                      .addMethod(getPurgeExecutionsMethod())
                      .addMethod(getAddExecutionEventsMethod())
                      .addMethod(getQueryExecutionInputsAndOutputsMethod())
                      .addMethod(getCreateMetadataSchemaMethod())
                      .addMethod(getGetMetadataSchemaMethod())
                      .addMethod(getListMetadataSchemasMethod())
                      .addMethod(getQueryArtifactLineageSubgraphMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
