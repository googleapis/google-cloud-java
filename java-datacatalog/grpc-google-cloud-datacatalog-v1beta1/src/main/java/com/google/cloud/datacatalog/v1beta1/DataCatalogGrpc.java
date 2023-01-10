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
package com.google.cloud.datacatalog.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Data Catalog API service allows clients to discover, understand, and manage
 * their data.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/datacatalog/v1beta1/datacatalog.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DataCatalogGrpc {

  private DataCatalogGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.datacatalog.v1beta1.DataCatalog";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.SearchCatalogRequest,
          com.google.cloud.datacatalog.v1beta1.SearchCatalogResponse>
      getSearchCatalogMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchCatalog",
      requestType = com.google.cloud.datacatalog.v1beta1.SearchCatalogRequest.class,
      responseType = com.google.cloud.datacatalog.v1beta1.SearchCatalogResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.SearchCatalogRequest,
          com.google.cloud.datacatalog.v1beta1.SearchCatalogResponse>
      getSearchCatalogMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.v1beta1.SearchCatalogRequest,
            com.google.cloud.datacatalog.v1beta1.SearchCatalogResponse>
        getSearchCatalogMethod;
    if ((getSearchCatalogMethod = DataCatalogGrpc.getSearchCatalogMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getSearchCatalogMethod = DataCatalogGrpc.getSearchCatalogMethod) == null) {
          DataCatalogGrpc.getSearchCatalogMethod =
              getSearchCatalogMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.v1beta1.SearchCatalogRequest,
                          com.google.cloud.datacatalog.v1beta1.SearchCatalogResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchCatalog"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.SearchCatalogRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.SearchCatalogResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new DataCatalogMethodDescriptorSupplier("SearchCatalog"))
                      .build();
        }
      }
    }
    return getSearchCatalogMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.CreateEntryGroupRequest,
          com.google.cloud.datacatalog.v1beta1.EntryGroup>
      getCreateEntryGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEntryGroup",
      requestType = com.google.cloud.datacatalog.v1beta1.CreateEntryGroupRequest.class,
      responseType = com.google.cloud.datacatalog.v1beta1.EntryGroup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.CreateEntryGroupRequest,
          com.google.cloud.datacatalog.v1beta1.EntryGroup>
      getCreateEntryGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.v1beta1.CreateEntryGroupRequest,
            com.google.cloud.datacatalog.v1beta1.EntryGroup>
        getCreateEntryGroupMethod;
    if ((getCreateEntryGroupMethod = DataCatalogGrpc.getCreateEntryGroupMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getCreateEntryGroupMethod = DataCatalogGrpc.getCreateEntryGroupMethod) == null) {
          DataCatalogGrpc.getCreateEntryGroupMethod =
              getCreateEntryGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.v1beta1.CreateEntryGroupRequest,
                          com.google.cloud.datacatalog.v1beta1.EntryGroup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateEntryGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.CreateEntryGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.EntryGroup.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataCatalogMethodDescriptorSupplier("CreateEntryGroup"))
                      .build();
        }
      }
    }
    return getCreateEntryGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.UpdateEntryGroupRequest,
          com.google.cloud.datacatalog.v1beta1.EntryGroup>
      getUpdateEntryGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEntryGroup",
      requestType = com.google.cloud.datacatalog.v1beta1.UpdateEntryGroupRequest.class,
      responseType = com.google.cloud.datacatalog.v1beta1.EntryGroup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.UpdateEntryGroupRequest,
          com.google.cloud.datacatalog.v1beta1.EntryGroup>
      getUpdateEntryGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.v1beta1.UpdateEntryGroupRequest,
            com.google.cloud.datacatalog.v1beta1.EntryGroup>
        getUpdateEntryGroupMethod;
    if ((getUpdateEntryGroupMethod = DataCatalogGrpc.getUpdateEntryGroupMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getUpdateEntryGroupMethod = DataCatalogGrpc.getUpdateEntryGroupMethod) == null) {
          DataCatalogGrpc.getUpdateEntryGroupMethod =
              getUpdateEntryGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.v1beta1.UpdateEntryGroupRequest,
                          com.google.cloud.datacatalog.v1beta1.EntryGroup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateEntryGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.UpdateEntryGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.EntryGroup.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataCatalogMethodDescriptorSupplier("UpdateEntryGroup"))
                      .build();
        }
      }
    }
    return getUpdateEntryGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.GetEntryGroupRequest,
          com.google.cloud.datacatalog.v1beta1.EntryGroup>
      getGetEntryGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEntryGroup",
      requestType = com.google.cloud.datacatalog.v1beta1.GetEntryGroupRequest.class,
      responseType = com.google.cloud.datacatalog.v1beta1.EntryGroup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.GetEntryGroupRequest,
          com.google.cloud.datacatalog.v1beta1.EntryGroup>
      getGetEntryGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.v1beta1.GetEntryGroupRequest,
            com.google.cloud.datacatalog.v1beta1.EntryGroup>
        getGetEntryGroupMethod;
    if ((getGetEntryGroupMethod = DataCatalogGrpc.getGetEntryGroupMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getGetEntryGroupMethod = DataCatalogGrpc.getGetEntryGroupMethod) == null) {
          DataCatalogGrpc.getGetEntryGroupMethod =
              getGetEntryGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.v1beta1.GetEntryGroupRequest,
                          com.google.cloud.datacatalog.v1beta1.EntryGroup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEntryGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.GetEntryGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.EntryGroup.getDefaultInstance()))
                      .setSchemaDescriptor(new DataCatalogMethodDescriptorSupplier("GetEntryGroup"))
                      .build();
        }
      }
    }
    return getGetEntryGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.DeleteEntryGroupRequest, com.google.protobuf.Empty>
      getDeleteEntryGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEntryGroup",
      requestType = com.google.cloud.datacatalog.v1beta1.DeleteEntryGroupRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.DeleteEntryGroupRequest, com.google.protobuf.Empty>
      getDeleteEntryGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.v1beta1.DeleteEntryGroupRequest, com.google.protobuf.Empty>
        getDeleteEntryGroupMethod;
    if ((getDeleteEntryGroupMethod = DataCatalogGrpc.getDeleteEntryGroupMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getDeleteEntryGroupMethod = DataCatalogGrpc.getDeleteEntryGroupMethod) == null) {
          DataCatalogGrpc.getDeleteEntryGroupMethod =
              getDeleteEntryGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.v1beta1.DeleteEntryGroupRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteEntryGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.DeleteEntryGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataCatalogMethodDescriptorSupplier("DeleteEntryGroup"))
                      .build();
        }
      }
    }
    return getDeleteEntryGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.ListEntryGroupsRequest,
          com.google.cloud.datacatalog.v1beta1.ListEntryGroupsResponse>
      getListEntryGroupsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEntryGroups",
      requestType = com.google.cloud.datacatalog.v1beta1.ListEntryGroupsRequest.class,
      responseType = com.google.cloud.datacatalog.v1beta1.ListEntryGroupsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.ListEntryGroupsRequest,
          com.google.cloud.datacatalog.v1beta1.ListEntryGroupsResponse>
      getListEntryGroupsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.v1beta1.ListEntryGroupsRequest,
            com.google.cloud.datacatalog.v1beta1.ListEntryGroupsResponse>
        getListEntryGroupsMethod;
    if ((getListEntryGroupsMethod = DataCatalogGrpc.getListEntryGroupsMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getListEntryGroupsMethod = DataCatalogGrpc.getListEntryGroupsMethod) == null) {
          DataCatalogGrpc.getListEntryGroupsMethod =
              getListEntryGroupsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.v1beta1.ListEntryGroupsRequest,
                          com.google.cloud.datacatalog.v1beta1.ListEntryGroupsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEntryGroups"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.ListEntryGroupsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.ListEntryGroupsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataCatalogMethodDescriptorSupplier("ListEntryGroups"))
                      .build();
        }
      }
    }
    return getListEntryGroupsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.CreateEntryRequest,
          com.google.cloud.datacatalog.v1beta1.Entry>
      getCreateEntryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEntry",
      requestType = com.google.cloud.datacatalog.v1beta1.CreateEntryRequest.class,
      responseType = com.google.cloud.datacatalog.v1beta1.Entry.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.CreateEntryRequest,
          com.google.cloud.datacatalog.v1beta1.Entry>
      getCreateEntryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.v1beta1.CreateEntryRequest,
            com.google.cloud.datacatalog.v1beta1.Entry>
        getCreateEntryMethod;
    if ((getCreateEntryMethod = DataCatalogGrpc.getCreateEntryMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getCreateEntryMethod = DataCatalogGrpc.getCreateEntryMethod) == null) {
          DataCatalogGrpc.getCreateEntryMethod =
              getCreateEntryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.v1beta1.CreateEntryRequest,
                          com.google.cloud.datacatalog.v1beta1.Entry>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateEntry"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.CreateEntryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.Entry.getDefaultInstance()))
                      .setSchemaDescriptor(new DataCatalogMethodDescriptorSupplier("CreateEntry"))
                      .build();
        }
      }
    }
    return getCreateEntryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.UpdateEntryRequest,
          com.google.cloud.datacatalog.v1beta1.Entry>
      getUpdateEntryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEntry",
      requestType = com.google.cloud.datacatalog.v1beta1.UpdateEntryRequest.class,
      responseType = com.google.cloud.datacatalog.v1beta1.Entry.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.UpdateEntryRequest,
          com.google.cloud.datacatalog.v1beta1.Entry>
      getUpdateEntryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.v1beta1.UpdateEntryRequest,
            com.google.cloud.datacatalog.v1beta1.Entry>
        getUpdateEntryMethod;
    if ((getUpdateEntryMethod = DataCatalogGrpc.getUpdateEntryMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getUpdateEntryMethod = DataCatalogGrpc.getUpdateEntryMethod) == null) {
          DataCatalogGrpc.getUpdateEntryMethod =
              getUpdateEntryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.v1beta1.UpdateEntryRequest,
                          com.google.cloud.datacatalog.v1beta1.Entry>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateEntry"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.UpdateEntryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.Entry.getDefaultInstance()))
                      .setSchemaDescriptor(new DataCatalogMethodDescriptorSupplier("UpdateEntry"))
                      .build();
        }
      }
    }
    return getUpdateEntryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.DeleteEntryRequest, com.google.protobuf.Empty>
      getDeleteEntryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEntry",
      requestType = com.google.cloud.datacatalog.v1beta1.DeleteEntryRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.DeleteEntryRequest, com.google.protobuf.Empty>
      getDeleteEntryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.v1beta1.DeleteEntryRequest, com.google.protobuf.Empty>
        getDeleteEntryMethod;
    if ((getDeleteEntryMethod = DataCatalogGrpc.getDeleteEntryMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getDeleteEntryMethod = DataCatalogGrpc.getDeleteEntryMethod) == null) {
          DataCatalogGrpc.getDeleteEntryMethod =
              getDeleteEntryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.v1beta1.DeleteEntryRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteEntry"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.DeleteEntryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new DataCatalogMethodDescriptorSupplier("DeleteEntry"))
                      .build();
        }
      }
    }
    return getDeleteEntryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.GetEntryRequest,
          com.google.cloud.datacatalog.v1beta1.Entry>
      getGetEntryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEntry",
      requestType = com.google.cloud.datacatalog.v1beta1.GetEntryRequest.class,
      responseType = com.google.cloud.datacatalog.v1beta1.Entry.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.GetEntryRequest,
          com.google.cloud.datacatalog.v1beta1.Entry>
      getGetEntryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.v1beta1.GetEntryRequest,
            com.google.cloud.datacatalog.v1beta1.Entry>
        getGetEntryMethod;
    if ((getGetEntryMethod = DataCatalogGrpc.getGetEntryMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getGetEntryMethod = DataCatalogGrpc.getGetEntryMethod) == null) {
          DataCatalogGrpc.getGetEntryMethod =
              getGetEntryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.v1beta1.GetEntryRequest,
                          com.google.cloud.datacatalog.v1beta1.Entry>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEntry"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.GetEntryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.Entry.getDefaultInstance()))
                      .setSchemaDescriptor(new DataCatalogMethodDescriptorSupplier("GetEntry"))
                      .build();
        }
      }
    }
    return getGetEntryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.LookupEntryRequest,
          com.google.cloud.datacatalog.v1beta1.Entry>
      getLookupEntryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LookupEntry",
      requestType = com.google.cloud.datacatalog.v1beta1.LookupEntryRequest.class,
      responseType = com.google.cloud.datacatalog.v1beta1.Entry.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.LookupEntryRequest,
          com.google.cloud.datacatalog.v1beta1.Entry>
      getLookupEntryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.v1beta1.LookupEntryRequest,
            com.google.cloud.datacatalog.v1beta1.Entry>
        getLookupEntryMethod;
    if ((getLookupEntryMethod = DataCatalogGrpc.getLookupEntryMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getLookupEntryMethod = DataCatalogGrpc.getLookupEntryMethod) == null) {
          DataCatalogGrpc.getLookupEntryMethod =
              getLookupEntryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.v1beta1.LookupEntryRequest,
                          com.google.cloud.datacatalog.v1beta1.Entry>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LookupEntry"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.LookupEntryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.Entry.getDefaultInstance()))
                      .setSchemaDescriptor(new DataCatalogMethodDescriptorSupplier("LookupEntry"))
                      .build();
        }
      }
    }
    return getLookupEntryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.ListEntriesRequest,
          com.google.cloud.datacatalog.v1beta1.ListEntriesResponse>
      getListEntriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEntries",
      requestType = com.google.cloud.datacatalog.v1beta1.ListEntriesRequest.class,
      responseType = com.google.cloud.datacatalog.v1beta1.ListEntriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.ListEntriesRequest,
          com.google.cloud.datacatalog.v1beta1.ListEntriesResponse>
      getListEntriesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.v1beta1.ListEntriesRequest,
            com.google.cloud.datacatalog.v1beta1.ListEntriesResponse>
        getListEntriesMethod;
    if ((getListEntriesMethod = DataCatalogGrpc.getListEntriesMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getListEntriesMethod = DataCatalogGrpc.getListEntriesMethod) == null) {
          DataCatalogGrpc.getListEntriesMethod =
              getListEntriesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.v1beta1.ListEntriesRequest,
                          com.google.cloud.datacatalog.v1beta1.ListEntriesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEntries"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.ListEntriesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.ListEntriesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new DataCatalogMethodDescriptorSupplier("ListEntries"))
                      .build();
        }
      }
    }
    return getListEntriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.CreateTagTemplateRequest,
          com.google.cloud.datacatalog.v1beta1.TagTemplate>
      getCreateTagTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTagTemplate",
      requestType = com.google.cloud.datacatalog.v1beta1.CreateTagTemplateRequest.class,
      responseType = com.google.cloud.datacatalog.v1beta1.TagTemplate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.CreateTagTemplateRequest,
          com.google.cloud.datacatalog.v1beta1.TagTemplate>
      getCreateTagTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.v1beta1.CreateTagTemplateRequest,
            com.google.cloud.datacatalog.v1beta1.TagTemplate>
        getCreateTagTemplateMethod;
    if ((getCreateTagTemplateMethod = DataCatalogGrpc.getCreateTagTemplateMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getCreateTagTemplateMethod = DataCatalogGrpc.getCreateTagTemplateMethod) == null) {
          DataCatalogGrpc.getCreateTagTemplateMethod =
              getCreateTagTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.v1beta1.CreateTagTemplateRequest,
                          com.google.cloud.datacatalog.v1beta1.TagTemplate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTagTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.CreateTagTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.TagTemplate
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataCatalogMethodDescriptorSupplier("CreateTagTemplate"))
                      .build();
        }
      }
    }
    return getCreateTagTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.GetTagTemplateRequest,
          com.google.cloud.datacatalog.v1beta1.TagTemplate>
      getGetTagTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTagTemplate",
      requestType = com.google.cloud.datacatalog.v1beta1.GetTagTemplateRequest.class,
      responseType = com.google.cloud.datacatalog.v1beta1.TagTemplate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.GetTagTemplateRequest,
          com.google.cloud.datacatalog.v1beta1.TagTemplate>
      getGetTagTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.v1beta1.GetTagTemplateRequest,
            com.google.cloud.datacatalog.v1beta1.TagTemplate>
        getGetTagTemplateMethod;
    if ((getGetTagTemplateMethod = DataCatalogGrpc.getGetTagTemplateMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getGetTagTemplateMethod = DataCatalogGrpc.getGetTagTemplateMethod) == null) {
          DataCatalogGrpc.getGetTagTemplateMethod =
              getGetTagTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.v1beta1.GetTagTemplateRequest,
                          com.google.cloud.datacatalog.v1beta1.TagTemplate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTagTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.GetTagTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.TagTemplate
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataCatalogMethodDescriptorSupplier("GetTagTemplate"))
                      .build();
        }
      }
    }
    return getGetTagTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.UpdateTagTemplateRequest,
          com.google.cloud.datacatalog.v1beta1.TagTemplate>
      getUpdateTagTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTagTemplate",
      requestType = com.google.cloud.datacatalog.v1beta1.UpdateTagTemplateRequest.class,
      responseType = com.google.cloud.datacatalog.v1beta1.TagTemplate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.UpdateTagTemplateRequest,
          com.google.cloud.datacatalog.v1beta1.TagTemplate>
      getUpdateTagTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.v1beta1.UpdateTagTemplateRequest,
            com.google.cloud.datacatalog.v1beta1.TagTemplate>
        getUpdateTagTemplateMethod;
    if ((getUpdateTagTemplateMethod = DataCatalogGrpc.getUpdateTagTemplateMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getUpdateTagTemplateMethod = DataCatalogGrpc.getUpdateTagTemplateMethod) == null) {
          DataCatalogGrpc.getUpdateTagTemplateMethod =
              getUpdateTagTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.v1beta1.UpdateTagTemplateRequest,
                          com.google.cloud.datacatalog.v1beta1.TagTemplate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTagTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.UpdateTagTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.TagTemplate
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataCatalogMethodDescriptorSupplier("UpdateTagTemplate"))
                      .build();
        }
      }
    }
    return getUpdateTagTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.DeleteTagTemplateRequest, com.google.protobuf.Empty>
      getDeleteTagTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTagTemplate",
      requestType = com.google.cloud.datacatalog.v1beta1.DeleteTagTemplateRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.DeleteTagTemplateRequest, com.google.protobuf.Empty>
      getDeleteTagTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.v1beta1.DeleteTagTemplateRequest,
            com.google.protobuf.Empty>
        getDeleteTagTemplateMethod;
    if ((getDeleteTagTemplateMethod = DataCatalogGrpc.getDeleteTagTemplateMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getDeleteTagTemplateMethod = DataCatalogGrpc.getDeleteTagTemplateMethod) == null) {
          DataCatalogGrpc.getDeleteTagTemplateMethod =
              getDeleteTagTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.v1beta1.DeleteTagTemplateRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTagTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.DeleteTagTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataCatalogMethodDescriptorSupplier("DeleteTagTemplate"))
                      .build();
        }
      }
    }
    return getDeleteTagTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.CreateTagTemplateFieldRequest,
          com.google.cloud.datacatalog.v1beta1.TagTemplateField>
      getCreateTagTemplateFieldMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTagTemplateField",
      requestType = com.google.cloud.datacatalog.v1beta1.CreateTagTemplateFieldRequest.class,
      responseType = com.google.cloud.datacatalog.v1beta1.TagTemplateField.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.CreateTagTemplateFieldRequest,
          com.google.cloud.datacatalog.v1beta1.TagTemplateField>
      getCreateTagTemplateFieldMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.v1beta1.CreateTagTemplateFieldRequest,
            com.google.cloud.datacatalog.v1beta1.TagTemplateField>
        getCreateTagTemplateFieldMethod;
    if ((getCreateTagTemplateFieldMethod = DataCatalogGrpc.getCreateTagTemplateFieldMethod)
        == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getCreateTagTemplateFieldMethod = DataCatalogGrpc.getCreateTagTemplateFieldMethod)
            == null) {
          DataCatalogGrpc.getCreateTagTemplateFieldMethod =
              getCreateTagTemplateFieldMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.v1beta1.CreateTagTemplateFieldRequest,
                          com.google.cloud.datacatalog.v1beta1.TagTemplateField>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateTagTemplateField"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.CreateTagTemplateFieldRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.TagTemplateField
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataCatalogMethodDescriptorSupplier("CreateTagTemplateField"))
                      .build();
        }
      }
    }
    return getCreateTagTemplateFieldMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.UpdateTagTemplateFieldRequest,
          com.google.cloud.datacatalog.v1beta1.TagTemplateField>
      getUpdateTagTemplateFieldMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTagTemplateField",
      requestType = com.google.cloud.datacatalog.v1beta1.UpdateTagTemplateFieldRequest.class,
      responseType = com.google.cloud.datacatalog.v1beta1.TagTemplateField.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.UpdateTagTemplateFieldRequest,
          com.google.cloud.datacatalog.v1beta1.TagTemplateField>
      getUpdateTagTemplateFieldMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.v1beta1.UpdateTagTemplateFieldRequest,
            com.google.cloud.datacatalog.v1beta1.TagTemplateField>
        getUpdateTagTemplateFieldMethod;
    if ((getUpdateTagTemplateFieldMethod = DataCatalogGrpc.getUpdateTagTemplateFieldMethod)
        == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getUpdateTagTemplateFieldMethod = DataCatalogGrpc.getUpdateTagTemplateFieldMethod)
            == null) {
          DataCatalogGrpc.getUpdateTagTemplateFieldMethod =
              getUpdateTagTemplateFieldMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.v1beta1.UpdateTagTemplateFieldRequest,
                          com.google.cloud.datacatalog.v1beta1.TagTemplateField>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateTagTemplateField"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.UpdateTagTemplateFieldRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.TagTemplateField
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataCatalogMethodDescriptorSupplier("UpdateTagTemplateField"))
                      .build();
        }
      }
    }
    return getUpdateTagTemplateFieldMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.RenameTagTemplateFieldRequest,
          com.google.cloud.datacatalog.v1beta1.TagTemplateField>
      getRenameTagTemplateFieldMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RenameTagTemplateField",
      requestType = com.google.cloud.datacatalog.v1beta1.RenameTagTemplateFieldRequest.class,
      responseType = com.google.cloud.datacatalog.v1beta1.TagTemplateField.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.RenameTagTemplateFieldRequest,
          com.google.cloud.datacatalog.v1beta1.TagTemplateField>
      getRenameTagTemplateFieldMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.v1beta1.RenameTagTemplateFieldRequest,
            com.google.cloud.datacatalog.v1beta1.TagTemplateField>
        getRenameTagTemplateFieldMethod;
    if ((getRenameTagTemplateFieldMethod = DataCatalogGrpc.getRenameTagTemplateFieldMethod)
        == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getRenameTagTemplateFieldMethod = DataCatalogGrpc.getRenameTagTemplateFieldMethod)
            == null) {
          DataCatalogGrpc.getRenameTagTemplateFieldMethod =
              getRenameTagTemplateFieldMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.v1beta1.RenameTagTemplateFieldRequest,
                          com.google.cloud.datacatalog.v1beta1.TagTemplateField>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RenameTagTemplateField"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.RenameTagTemplateFieldRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.TagTemplateField
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataCatalogMethodDescriptorSupplier("RenameTagTemplateField"))
                      .build();
        }
      }
    }
    return getRenameTagTemplateFieldMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.DeleteTagTemplateFieldRequest,
          com.google.protobuf.Empty>
      getDeleteTagTemplateFieldMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTagTemplateField",
      requestType = com.google.cloud.datacatalog.v1beta1.DeleteTagTemplateFieldRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.DeleteTagTemplateFieldRequest,
          com.google.protobuf.Empty>
      getDeleteTagTemplateFieldMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.v1beta1.DeleteTagTemplateFieldRequest,
            com.google.protobuf.Empty>
        getDeleteTagTemplateFieldMethod;
    if ((getDeleteTagTemplateFieldMethod = DataCatalogGrpc.getDeleteTagTemplateFieldMethod)
        == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getDeleteTagTemplateFieldMethod = DataCatalogGrpc.getDeleteTagTemplateFieldMethod)
            == null) {
          DataCatalogGrpc.getDeleteTagTemplateFieldMethod =
              getDeleteTagTemplateFieldMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.v1beta1.DeleteTagTemplateFieldRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteTagTemplateField"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.DeleteTagTemplateFieldRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataCatalogMethodDescriptorSupplier("DeleteTagTemplateField"))
                      .build();
        }
      }
    }
    return getDeleteTagTemplateFieldMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.CreateTagRequest,
          com.google.cloud.datacatalog.v1beta1.Tag>
      getCreateTagMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTag",
      requestType = com.google.cloud.datacatalog.v1beta1.CreateTagRequest.class,
      responseType = com.google.cloud.datacatalog.v1beta1.Tag.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.CreateTagRequest,
          com.google.cloud.datacatalog.v1beta1.Tag>
      getCreateTagMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.v1beta1.CreateTagRequest,
            com.google.cloud.datacatalog.v1beta1.Tag>
        getCreateTagMethod;
    if ((getCreateTagMethod = DataCatalogGrpc.getCreateTagMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getCreateTagMethod = DataCatalogGrpc.getCreateTagMethod) == null) {
          DataCatalogGrpc.getCreateTagMethod =
              getCreateTagMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.v1beta1.CreateTagRequest,
                          com.google.cloud.datacatalog.v1beta1.Tag>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTag"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.CreateTagRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.Tag.getDefaultInstance()))
                      .setSchemaDescriptor(new DataCatalogMethodDescriptorSupplier("CreateTag"))
                      .build();
        }
      }
    }
    return getCreateTagMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.UpdateTagRequest,
          com.google.cloud.datacatalog.v1beta1.Tag>
      getUpdateTagMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTag",
      requestType = com.google.cloud.datacatalog.v1beta1.UpdateTagRequest.class,
      responseType = com.google.cloud.datacatalog.v1beta1.Tag.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.UpdateTagRequest,
          com.google.cloud.datacatalog.v1beta1.Tag>
      getUpdateTagMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.v1beta1.UpdateTagRequest,
            com.google.cloud.datacatalog.v1beta1.Tag>
        getUpdateTagMethod;
    if ((getUpdateTagMethod = DataCatalogGrpc.getUpdateTagMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getUpdateTagMethod = DataCatalogGrpc.getUpdateTagMethod) == null) {
          DataCatalogGrpc.getUpdateTagMethod =
              getUpdateTagMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.v1beta1.UpdateTagRequest,
                          com.google.cloud.datacatalog.v1beta1.Tag>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTag"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.UpdateTagRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.Tag.getDefaultInstance()))
                      .setSchemaDescriptor(new DataCatalogMethodDescriptorSupplier("UpdateTag"))
                      .build();
        }
      }
    }
    return getUpdateTagMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.DeleteTagRequest, com.google.protobuf.Empty>
      getDeleteTagMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTag",
      requestType = com.google.cloud.datacatalog.v1beta1.DeleteTagRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.DeleteTagRequest, com.google.protobuf.Empty>
      getDeleteTagMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.v1beta1.DeleteTagRequest, com.google.protobuf.Empty>
        getDeleteTagMethod;
    if ((getDeleteTagMethod = DataCatalogGrpc.getDeleteTagMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getDeleteTagMethod = DataCatalogGrpc.getDeleteTagMethod) == null) {
          DataCatalogGrpc.getDeleteTagMethod =
              getDeleteTagMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.v1beta1.DeleteTagRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTag"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.DeleteTagRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new DataCatalogMethodDescriptorSupplier("DeleteTag"))
                      .build();
        }
      }
    }
    return getDeleteTagMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.ListTagsRequest,
          com.google.cloud.datacatalog.v1beta1.ListTagsResponse>
      getListTagsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTags",
      requestType = com.google.cloud.datacatalog.v1beta1.ListTagsRequest.class,
      responseType = com.google.cloud.datacatalog.v1beta1.ListTagsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.ListTagsRequest,
          com.google.cloud.datacatalog.v1beta1.ListTagsResponse>
      getListTagsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.v1beta1.ListTagsRequest,
            com.google.cloud.datacatalog.v1beta1.ListTagsResponse>
        getListTagsMethod;
    if ((getListTagsMethod = DataCatalogGrpc.getListTagsMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getListTagsMethod = DataCatalogGrpc.getListTagsMethod) == null) {
          DataCatalogGrpc.getListTagsMethod =
              getListTagsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.v1beta1.ListTagsRequest,
                          com.google.cloud.datacatalog.v1beta1.ListTagsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTags"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.ListTagsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.ListTagsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new DataCatalogMethodDescriptorSupplier("ListTags"))
                      .build();
        }
      }
    }
    return getListTagsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetIamPolicy",
      requestType = com.google.iam.v1.SetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
        getSetIamPolicyMethod;
    if ((getSetIamPolicyMethod = DataCatalogGrpc.getSetIamPolicyMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getSetIamPolicyMethod = DataCatalogGrpc.getSetIamPolicyMethod) == null) {
          DataCatalogGrpc.getSetIamPolicyMethod =
              getSetIamPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetIamPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.SetIamPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(new DataCatalogMethodDescriptorSupplier("SetIamPolicy"))
                      .build();
        }
      }
    }
    return getSetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIamPolicy",
      requestType = com.google.iam.v1.GetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
        getGetIamPolicyMethod;
    if ((getGetIamPolicyMethod = DataCatalogGrpc.getGetIamPolicyMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getGetIamPolicyMethod = DataCatalogGrpc.getGetIamPolicyMethod) == null) {
          DataCatalogGrpc.getGetIamPolicyMethod =
              getGetIamPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIamPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.GetIamPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(new DataCatalogMethodDescriptorSupplier("GetIamPolicy"))
                      .build();
        }
      }
    }
    return getGetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TestIamPermissions",
      requestType = com.google.iam.v1.TestIamPermissionsRequest.class,
      responseType = com.google.iam.v1.TestIamPermissionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.iam.v1.TestIamPermissionsRequest,
            com.google.iam.v1.TestIamPermissionsResponse>
        getTestIamPermissionsMethod;
    if ((getTestIamPermissionsMethod = DataCatalogGrpc.getTestIamPermissionsMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getTestIamPermissionsMethod = DataCatalogGrpc.getTestIamPermissionsMethod) == null) {
          DataCatalogGrpc.getTestIamPermissionsMethod =
              getTestIamPermissionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.TestIamPermissionsRequest,
                          com.google.iam.v1.TestIamPermissionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TestIamPermissions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.TestIamPermissionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.TestIamPermissionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataCatalogMethodDescriptorSupplier("TestIamPermissions"))
                      .build();
        }
      }
    }
    return getTestIamPermissionsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DataCatalogStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataCatalogStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataCatalogStub>() {
          @java.lang.Override
          public DataCatalogStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataCatalogStub(channel, callOptions);
          }
        };
    return DataCatalogStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataCatalogBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataCatalogBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataCatalogBlockingStub>() {
          @java.lang.Override
          public DataCatalogBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataCatalogBlockingStub(channel, callOptions);
          }
        };
    return DataCatalogBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DataCatalogFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataCatalogFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataCatalogFutureStub>() {
          @java.lang.Override
          public DataCatalogFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataCatalogFutureStub(channel, callOptions);
          }
        };
    return DataCatalogFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Data Catalog API service allows clients to discover, understand, and manage
   * their data.
   * </pre>
   */
  public abstract static class DataCatalogImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Searches Data Catalog for multiple resources like entries, tags that
     * match a query.
     * This is a custom method
     * (https://cloud.google.com/apis/design/custom_methods) and does not return
     * the complete resource, only the resource identifier and high level
     * fields. Clients can subsequentally call `Get` methods.
     * Note that Data Catalog search queries do not guarantee full recall. Query
     * results that match your query may not be returned, even in subsequent
     * result pages. Also note that results returned (and not returned) can vary
     * across repeated search queries.
     * See [Data Catalog Search
     * Syntax](https://cloud.google.com/data-catalog/docs/how-to/search-reference)
     * for more information.
     * </pre>
     */
    public void searchCatalog(
        com.google.cloud.datacatalog.v1beta1.SearchCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.SearchCatalogResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchCatalogMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * A maximum of 10,000 entry groups may be created per organization across all
     * locations.
     * Users should enable the Data Catalog API in the project identified by
     * the `parent` parameter (see [Data Catalog Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * </pre>
     */
    public void createEntryGroup(
        com.google.cloud.datacatalog.v1beta1.CreateEntryGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.EntryGroup>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateEntryGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an EntryGroup. The user should enable the Data Catalog API in the
     * project identified by the `entry_group.name` parameter (see [Data Catalog
     * Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * </pre>
     */
    public void updateEntryGroup(
        com.google.cloud.datacatalog.v1beta1.UpdateEntryGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.EntryGroup>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateEntryGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an EntryGroup.
     * </pre>
     */
    public void getEntryGroup(
        com.google.cloud.datacatalog.v1beta1.GetEntryGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.EntryGroup>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetEntryGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an EntryGroup. Only entry groups that do not contain entries can be
     * deleted. Users should enable the Data Catalog API in the project
     * identified by the `name` parameter (see [Data Catalog Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * </pre>
     */
    public void deleteEntryGroup(
        com.google.cloud.datacatalog.v1beta1.DeleteEntryGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteEntryGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists entry groups.
     * </pre>
     */
    public void listEntryGroups(
        com.google.cloud.datacatalog.v1beta1.ListEntryGroupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.ListEntryGroupsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListEntryGroupsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an entry. Only entries of 'FILESET' type or user-specified type can
     * be created.
     * Users should enable the Data Catalog API in the project identified by
     * the `parent` parameter (see [Data Catalog Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * A maximum of 100,000 entries may be created per entry group.
     * </pre>
     */
    public void createEntry(
        com.google.cloud.datacatalog.v1beta1.CreateEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.Entry> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateEntryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing entry.
     * Users should enable the Data Catalog API in the project identified by
     * the `entry.name` parameter (see [Data Catalog Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * </pre>
     */
    public void updateEntry(
        com.google.cloud.datacatalog.v1beta1.UpdateEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.Entry> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateEntryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing entry. Only entries created through
     * [CreateEntry][google.cloud.datacatalog.v1beta1.DataCatalog.CreateEntry]
     * method can be deleted.
     * Users should enable the Data Catalog API in the project identified by
     * the `name` parameter (see [Data Catalog Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * </pre>
     */
    public void deleteEntry(
        com.google.cloud.datacatalog.v1beta1.DeleteEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteEntryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an entry.
     * </pre>
     */
    public void getEntry(
        com.google.cloud.datacatalog.v1beta1.GetEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.Entry> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetEntryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get an entry by target resource name. This method allows clients to use
     * the resource name from the source Google Cloud Platform service to get the
     * Data Catalog Entry.
     * </pre>
     */
    public void lookupEntry(
        com.google.cloud.datacatalog.v1beta1.LookupEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.Entry> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getLookupEntryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists entries.
     * </pre>
     */
    public void listEntries(
        com.google.cloud.datacatalog.v1beta1.ListEntriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.ListEntriesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListEntriesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a tag template. The user should enable the Data Catalog API in
     * the project identified by the `parent` parameter (see [Data Catalog
     * Resource
     * Project](https://cloud.google.com/data-catalog/docs/concepts/resource-project)
     * for more information).
     * </pre>
     */
    public void createTagTemplate(
        com.google.cloud.datacatalog.v1beta1.CreateTagTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.TagTemplate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateTagTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a tag template.
     * </pre>
     */
    public void getTagTemplate(
        com.google.cloud.datacatalog.v1beta1.GetTagTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.TagTemplate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetTagTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a tag template. This method cannot be used to update the fields of
     * a template. The tag template fields are represented as separate resources
     * and should be updated using their own create/update/delete methods.
     * Users should enable the Data Catalog API in the project identified by
     * the `tag_template.name` parameter (see [Data Catalog Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * </pre>
     */
    public void updateTagTemplate(
        com.google.cloud.datacatalog.v1beta1.UpdateTagTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.TagTemplate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateTagTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a tag template and all tags using the template.
     * Users should enable the Data Catalog API in the project identified by
     * the `name` parameter (see [Data Catalog Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * </pre>
     */
    public void deleteTagTemplate(
        com.google.cloud.datacatalog.v1beta1.DeleteTagTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteTagTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a field in a tag template. The user should enable the Data Catalog
     * API in the project identified by the `parent` parameter (see
     * [Data Catalog Resource
     * Project](https://cloud.google.com/data-catalog/docs/concepts/resource-project)
     * for more information).
     * </pre>
     */
    public void createTagTemplateField(
        com.google.cloud.datacatalog.v1beta1.CreateTagTemplateFieldRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.TagTemplateField>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateTagTemplateFieldMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a field in a tag template. This method cannot be used to update the
     * field type. Users should enable the Data Catalog API in the project
     * identified by the `name` parameter (see [Data Catalog Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * </pre>
     */
    public void updateTagTemplateField(
        com.google.cloud.datacatalog.v1beta1.UpdateTagTemplateFieldRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.TagTemplateField>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateTagTemplateFieldMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Renames a field in a tag template. The user should enable the Data Catalog
     * API in the project identified by the `name` parameter (see [Data Catalog
     * Resource
     * Project](https://cloud.google.com/data-catalog/docs/concepts/resource-project)
     * for more information).
     * </pre>
     */
    public void renameTagTemplateField(
        com.google.cloud.datacatalog.v1beta1.RenameTagTemplateFieldRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.TagTemplateField>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRenameTagTemplateFieldMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a field in a tag template and all uses of that field.
     * Users should enable the Data Catalog API in the project identified by
     * the `name` parameter (see [Data Catalog Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * </pre>
     */
    public void deleteTagTemplateField(
        com.google.cloud.datacatalog.v1beta1.DeleteTagTemplateFieldRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteTagTemplateFieldMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a tag on an [Entry][google.cloud.datacatalog.v1beta1.Entry].
     * Note: The project identified by the `parent` parameter for the
     * [tag](https://cloud.google.com/data-catalog/docs/reference/rest/v1beta1/projects.locations.entryGroups.entries.tags/create#path-parameters)
     * and the
     * [tag
     * template](https://cloud.google.com/data-catalog/docs/reference/rest/v1beta1/projects.locations.tagTemplates/create#path-parameters)
     * used to create the tag must be from the same organization.
     * </pre>
     */
    public void createTag(
        com.google.cloud.datacatalog.v1beta1.CreateTagRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.Tag> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateTagMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing tag.
     * </pre>
     */
    public void updateTag(
        com.google.cloud.datacatalog.v1beta1.UpdateTagRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.Tag> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateTagMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a tag.
     * </pre>
     */
    public void deleteTag(
        com.google.cloud.datacatalog.v1beta1.DeleteTagRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteTagMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the tags on an [Entry][google.cloud.datacatalog.v1beta1.Entry].
     * </pre>
     */
    public void listTags(
        com.google.cloud.datacatalog.v1beta1.ListTagsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.ListTagsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListTagsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy for a resource. Replaces any existing
     * policy.
     * Supported resources are:
     *   - Tag templates.
     *   - Entries.
     *   - Entry groups.
     * Note, this method cannot be used to manage policies for BigQuery, Pub/Sub
     * and any external Google Cloud Platform resources synced to Data Catalog.
     * Callers must have following Google IAM permission
     *   - `datacatalog.tagTemplates.setIamPolicy` to set policies on tag
     *     templates.
     *   - `datacatalog.entries.setIamPolicy` to set policies on entries.
     *   - `datacatalog.entryGroups.setIamPolicy` to set policies on entry groups.
     * </pre>
     */
    public void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for a resource. A `NOT_FOUND` error
     * is returned if the resource does not exist. An empty policy is returned
     * if the resource exists but does not have a policy set on it.
     * Supported resources are:
     *   - Tag templates.
     *   - Entries.
     *   - Entry groups.
     * Note, this method cannot be used to manage policies for BigQuery, Pub/Sub
     * and any external Google Cloud Platform resources synced to Data Catalog.
     * Callers must have following Google IAM permission
     *   - `datacatalog.tagTemplates.getIamPolicy` to get policies on tag
     *     templates.
     *   - `datacatalog.entries.getIamPolicy` to get policies on entries.
     *   - `datacatalog.entryGroups.getIamPolicy` to get policies on entry groups.
     * </pre>
     */
    public void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the caller's permissions on a resource.
     * If the resource does not exist, an empty set of permissions is returned
     * (We don't return a `NOT_FOUND` error).
     * Supported resources are:
     *   - Tag templates.
     *   - Entries.
     *   - Entry groups.
     * Note, this method cannot be used to manage policies for BigQuery, Pub/Sub
     * and any external Google Cloud Platform resources synced to Data Catalog.
     * A caller is not required to have Google IAM permission to make this
     * request.
     * </pre>
     */
    public void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getTestIamPermissionsMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getSearchCatalogMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.v1beta1.SearchCatalogRequest,
                      com.google.cloud.datacatalog.v1beta1.SearchCatalogResponse>(
                      this, METHODID_SEARCH_CATALOG)))
          .addMethod(
              getCreateEntryGroupMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.v1beta1.CreateEntryGroupRequest,
                      com.google.cloud.datacatalog.v1beta1.EntryGroup>(
                      this, METHODID_CREATE_ENTRY_GROUP)))
          .addMethod(
              getUpdateEntryGroupMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.v1beta1.UpdateEntryGroupRequest,
                      com.google.cloud.datacatalog.v1beta1.EntryGroup>(
                      this, METHODID_UPDATE_ENTRY_GROUP)))
          .addMethod(
              getGetEntryGroupMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.v1beta1.GetEntryGroupRequest,
                      com.google.cloud.datacatalog.v1beta1.EntryGroup>(
                      this, METHODID_GET_ENTRY_GROUP)))
          .addMethod(
              getDeleteEntryGroupMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.v1beta1.DeleteEntryGroupRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_ENTRY_GROUP)))
          .addMethod(
              getListEntryGroupsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.v1beta1.ListEntryGroupsRequest,
                      com.google.cloud.datacatalog.v1beta1.ListEntryGroupsResponse>(
                      this, METHODID_LIST_ENTRY_GROUPS)))
          .addMethod(
              getCreateEntryMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.v1beta1.CreateEntryRequest,
                      com.google.cloud.datacatalog.v1beta1.Entry>(this, METHODID_CREATE_ENTRY)))
          .addMethod(
              getUpdateEntryMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.v1beta1.UpdateEntryRequest,
                      com.google.cloud.datacatalog.v1beta1.Entry>(this, METHODID_UPDATE_ENTRY)))
          .addMethod(
              getDeleteEntryMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.v1beta1.DeleteEntryRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_ENTRY)))
          .addMethod(
              getGetEntryMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.v1beta1.GetEntryRequest,
                      com.google.cloud.datacatalog.v1beta1.Entry>(this, METHODID_GET_ENTRY)))
          .addMethod(
              getLookupEntryMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.v1beta1.LookupEntryRequest,
                      com.google.cloud.datacatalog.v1beta1.Entry>(this, METHODID_LOOKUP_ENTRY)))
          .addMethod(
              getListEntriesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.v1beta1.ListEntriesRequest,
                      com.google.cloud.datacatalog.v1beta1.ListEntriesResponse>(
                      this, METHODID_LIST_ENTRIES)))
          .addMethod(
              getCreateTagTemplateMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.v1beta1.CreateTagTemplateRequest,
                      com.google.cloud.datacatalog.v1beta1.TagTemplate>(
                      this, METHODID_CREATE_TAG_TEMPLATE)))
          .addMethod(
              getGetTagTemplateMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.v1beta1.GetTagTemplateRequest,
                      com.google.cloud.datacatalog.v1beta1.TagTemplate>(
                      this, METHODID_GET_TAG_TEMPLATE)))
          .addMethod(
              getUpdateTagTemplateMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.v1beta1.UpdateTagTemplateRequest,
                      com.google.cloud.datacatalog.v1beta1.TagTemplate>(
                      this, METHODID_UPDATE_TAG_TEMPLATE)))
          .addMethod(
              getDeleteTagTemplateMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.v1beta1.DeleteTagTemplateRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_TAG_TEMPLATE)))
          .addMethod(
              getCreateTagTemplateFieldMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.v1beta1.CreateTagTemplateFieldRequest,
                      com.google.cloud.datacatalog.v1beta1.TagTemplateField>(
                      this, METHODID_CREATE_TAG_TEMPLATE_FIELD)))
          .addMethod(
              getUpdateTagTemplateFieldMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.v1beta1.UpdateTagTemplateFieldRequest,
                      com.google.cloud.datacatalog.v1beta1.TagTemplateField>(
                      this, METHODID_UPDATE_TAG_TEMPLATE_FIELD)))
          .addMethod(
              getRenameTagTemplateFieldMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.v1beta1.RenameTagTemplateFieldRequest,
                      com.google.cloud.datacatalog.v1beta1.TagTemplateField>(
                      this, METHODID_RENAME_TAG_TEMPLATE_FIELD)))
          .addMethod(
              getDeleteTagTemplateFieldMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.v1beta1.DeleteTagTemplateFieldRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_TAG_TEMPLATE_FIELD)))
          .addMethod(
              getCreateTagMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.v1beta1.CreateTagRequest,
                      com.google.cloud.datacatalog.v1beta1.Tag>(this, METHODID_CREATE_TAG)))
          .addMethod(
              getUpdateTagMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.v1beta1.UpdateTagRequest,
                      com.google.cloud.datacatalog.v1beta1.Tag>(this, METHODID_UPDATE_TAG)))
          .addMethod(
              getDeleteTagMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.v1beta1.DeleteTagRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_TAG)))
          .addMethod(
              getListTagsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.v1beta1.ListTagsRequest,
                      com.google.cloud.datacatalog.v1beta1.ListTagsResponse>(
                      this, METHODID_LIST_TAGS)))
          .addMethod(
              getSetIamPolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>(
                      this, METHODID_SET_IAM_POLICY)))
          .addMethod(
              getGetIamPolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>(
                      this, METHODID_GET_IAM_POLICY)))
          .addMethod(
              getTestIamPermissionsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.TestIamPermissionsRequest,
                      com.google.iam.v1.TestIamPermissionsResponse>(
                      this, METHODID_TEST_IAM_PERMISSIONS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Data Catalog API service allows clients to discover, understand, and manage
   * their data.
   * </pre>
   */
  public static final class DataCatalogStub
      extends io.grpc.stub.AbstractAsyncStub<DataCatalogStub> {
    private DataCatalogStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataCatalogStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataCatalogStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Searches Data Catalog for multiple resources like entries, tags that
     * match a query.
     * This is a custom method
     * (https://cloud.google.com/apis/design/custom_methods) and does not return
     * the complete resource, only the resource identifier and high level
     * fields. Clients can subsequentally call `Get` methods.
     * Note that Data Catalog search queries do not guarantee full recall. Query
     * results that match your query may not be returned, even in subsequent
     * result pages. Also note that results returned (and not returned) can vary
     * across repeated search queries.
     * See [Data Catalog Search
     * Syntax](https://cloud.google.com/data-catalog/docs/how-to/search-reference)
     * for more information.
     * </pre>
     */
    public void searchCatalog(
        com.google.cloud.datacatalog.v1beta1.SearchCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.SearchCatalogResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchCatalogMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * A maximum of 10,000 entry groups may be created per organization across all
     * locations.
     * Users should enable the Data Catalog API in the project identified by
     * the `parent` parameter (see [Data Catalog Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * </pre>
     */
    public void createEntryGroup(
        com.google.cloud.datacatalog.v1beta1.CreateEntryGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.EntryGroup>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEntryGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an EntryGroup. The user should enable the Data Catalog API in the
     * project identified by the `entry_group.name` parameter (see [Data Catalog
     * Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * </pre>
     */
    public void updateEntryGroup(
        com.google.cloud.datacatalog.v1beta1.UpdateEntryGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.EntryGroup>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEntryGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an EntryGroup.
     * </pre>
     */
    public void getEntryGroup(
        com.google.cloud.datacatalog.v1beta1.GetEntryGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.EntryGroup>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEntryGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an EntryGroup. Only entry groups that do not contain entries can be
     * deleted. Users should enable the Data Catalog API in the project
     * identified by the `name` parameter (see [Data Catalog Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * </pre>
     */
    public void deleteEntryGroup(
        com.google.cloud.datacatalog.v1beta1.DeleteEntryGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEntryGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists entry groups.
     * </pre>
     */
    public void listEntryGroups(
        com.google.cloud.datacatalog.v1beta1.ListEntryGroupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.ListEntryGroupsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEntryGroupsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an entry. Only entries of 'FILESET' type or user-specified type can
     * be created.
     * Users should enable the Data Catalog API in the project identified by
     * the `parent` parameter (see [Data Catalog Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * A maximum of 100,000 entries may be created per entry group.
     * </pre>
     */
    public void createEntry(
        com.google.cloud.datacatalog.v1beta1.CreateEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.Entry> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEntryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing entry.
     * Users should enable the Data Catalog API in the project identified by
     * the `entry.name` parameter (see [Data Catalog Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * </pre>
     */
    public void updateEntry(
        com.google.cloud.datacatalog.v1beta1.UpdateEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.Entry> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEntryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing entry. Only entries created through
     * [CreateEntry][google.cloud.datacatalog.v1beta1.DataCatalog.CreateEntry]
     * method can be deleted.
     * Users should enable the Data Catalog API in the project identified by
     * the `name` parameter (see [Data Catalog Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * </pre>
     */
    public void deleteEntry(
        com.google.cloud.datacatalog.v1beta1.DeleteEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEntryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an entry.
     * </pre>
     */
    public void getEntry(
        com.google.cloud.datacatalog.v1beta1.GetEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.Entry> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEntryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get an entry by target resource name. This method allows clients to use
     * the resource name from the source Google Cloud Platform service to get the
     * Data Catalog Entry.
     * </pre>
     */
    public void lookupEntry(
        com.google.cloud.datacatalog.v1beta1.LookupEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.Entry> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLookupEntryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists entries.
     * </pre>
     */
    public void listEntries(
        com.google.cloud.datacatalog.v1beta1.ListEntriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.ListEntriesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEntriesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a tag template. The user should enable the Data Catalog API in
     * the project identified by the `parent` parameter (see [Data Catalog
     * Resource
     * Project](https://cloud.google.com/data-catalog/docs/concepts/resource-project)
     * for more information).
     * </pre>
     */
    public void createTagTemplate(
        com.google.cloud.datacatalog.v1beta1.CreateTagTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.TagTemplate>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTagTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a tag template.
     * </pre>
     */
    public void getTagTemplate(
        com.google.cloud.datacatalog.v1beta1.GetTagTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.TagTemplate>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTagTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a tag template. This method cannot be used to update the fields of
     * a template. The tag template fields are represented as separate resources
     * and should be updated using their own create/update/delete methods.
     * Users should enable the Data Catalog API in the project identified by
     * the `tag_template.name` parameter (see [Data Catalog Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * </pre>
     */
    public void updateTagTemplate(
        com.google.cloud.datacatalog.v1beta1.UpdateTagTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.TagTemplate>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTagTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a tag template and all tags using the template.
     * Users should enable the Data Catalog API in the project identified by
     * the `name` parameter (see [Data Catalog Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * </pre>
     */
    public void deleteTagTemplate(
        com.google.cloud.datacatalog.v1beta1.DeleteTagTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTagTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a field in a tag template. The user should enable the Data Catalog
     * API in the project identified by the `parent` parameter (see
     * [Data Catalog Resource
     * Project](https://cloud.google.com/data-catalog/docs/concepts/resource-project)
     * for more information).
     * </pre>
     */
    public void createTagTemplateField(
        com.google.cloud.datacatalog.v1beta1.CreateTagTemplateFieldRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.TagTemplateField>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTagTemplateFieldMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a field in a tag template. This method cannot be used to update the
     * field type. Users should enable the Data Catalog API in the project
     * identified by the `name` parameter (see [Data Catalog Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * </pre>
     */
    public void updateTagTemplateField(
        com.google.cloud.datacatalog.v1beta1.UpdateTagTemplateFieldRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.TagTemplateField>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTagTemplateFieldMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Renames a field in a tag template. The user should enable the Data Catalog
     * API in the project identified by the `name` parameter (see [Data Catalog
     * Resource
     * Project](https://cloud.google.com/data-catalog/docs/concepts/resource-project)
     * for more information).
     * </pre>
     */
    public void renameTagTemplateField(
        com.google.cloud.datacatalog.v1beta1.RenameTagTemplateFieldRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.TagTemplateField>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRenameTagTemplateFieldMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a field in a tag template and all uses of that field.
     * Users should enable the Data Catalog API in the project identified by
     * the `name` parameter (see [Data Catalog Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * </pre>
     */
    public void deleteTagTemplateField(
        com.google.cloud.datacatalog.v1beta1.DeleteTagTemplateFieldRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTagTemplateFieldMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a tag on an [Entry][google.cloud.datacatalog.v1beta1.Entry].
     * Note: The project identified by the `parent` parameter for the
     * [tag](https://cloud.google.com/data-catalog/docs/reference/rest/v1beta1/projects.locations.entryGroups.entries.tags/create#path-parameters)
     * and the
     * [tag
     * template](https://cloud.google.com/data-catalog/docs/reference/rest/v1beta1/projects.locations.tagTemplates/create#path-parameters)
     * used to create the tag must be from the same organization.
     * </pre>
     */
    public void createTag(
        com.google.cloud.datacatalog.v1beta1.CreateTagRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.Tag> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTagMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing tag.
     * </pre>
     */
    public void updateTag(
        com.google.cloud.datacatalog.v1beta1.UpdateTagRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.Tag> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTagMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a tag.
     * </pre>
     */
    public void deleteTag(
        com.google.cloud.datacatalog.v1beta1.DeleteTagRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTagMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the tags on an [Entry][google.cloud.datacatalog.v1beta1.Entry].
     * </pre>
     */
    public void listTags(
        com.google.cloud.datacatalog.v1beta1.ListTagsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.ListTagsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTagsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy for a resource. Replaces any existing
     * policy.
     * Supported resources are:
     *   - Tag templates.
     *   - Entries.
     *   - Entry groups.
     * Note, this method cannot be used to manage policies for BigQuery, Pub/Sub
     * and any external Google Cloud Platform resources synced to Data Catalog.
     * Callers must have following Google IAM permission
     *   - `datacatalog.tagTemplates.setIamPolicy` to set policies on tag
     *     templates.
     *   - `datacatalog.entries.setIamPolicy` to set policies on entries.
     *   - `datacatalog.entryGroups.setIamPolicy` to set policies on entry groups.
     * </pre>
     */
    public void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for a resource. A `NOT_FOUND` error
     * is returned if the resource does not exist. An empty policy is returned
     * if the resource exists but does not have a policy set on it.
     * Supported resources are:
     *   - Tag templates.
     *   - Entries.
     *   - Entry groups.
     * Note, this method cannot be used to manage policies for BigQuery, Pub/Sub
     * and any external Google Cloud Platform resources synced to Data Catalog.
     * Callers must have following Google IAM permission
     *   - `datacatalog.tagTemplates.getIamPolicy` to get policies on tag
     *     templates.
     *   - `datacatalog.entries.getIamPolicy` to get policies on entries.
     *   - `datacatalog.entryGroups.getIamPolicy` to get policies on entry groups.
     * </pre>
     */
    public void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the caller's permissions on a resource.
     * If the resource does not exist, an empty set of permissions is returned
     * (We don't return a `NOT_FOUND` error).
     * Supported resources are:
     *   - Tag templates.
     *   - Entries.
     *   - Entry groups.
     * Note, this method cannot be used to manage policies for BigQuery, Pub/Sub
     * and any external Google Cloud Platform resources synced to Data Catalog.
     * A caller is not required to have Google IAM permission to make this
     * request.
     * </pre>
     */
    public void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Data Catalog API service allows clients to discover, understand, and manage
   * their data.
   * </pre>
   */
  public static final class DataCatalogBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DataCatalogBlockingStub> {
    private DataCatalogBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataCatalogBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataCatalogBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Searches Data Catalog for multiple resources like entries, tags that
     * match a query.
     * This is a custom method
     * (https://cloud.google.com/apis/design/custom_methods) and does not return
     * the complete resource, only the resource identifier and high level
     * fields. Clients can subsequentally call `Get` methods.
     * Note that Data Catalog search queries do not guarantee full recall. Query
     * results that match your query may not be returned, even in subsequent
     * result pages. Also note that results returned (and not returned) can vary
     * across repeated search queries.
     * See [Data Catalog Search
     * Syntax](https://cloud.google.com/data-catalog/docs/how-to/search-reference)
     * for more information.
     * </pre>
     */
    public com.google.cloud.datacatalog.v1beta1.SearchCatalogResponse searchCatalog(
        com.google.cloud.datacatalog.v1beta1.SearchCatalogRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchCatalogMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * A maximum of 10,000 entry groups may be created per organization across all
     * locations.
     * Users should enable the Data Catalog API in the project identified by
     * the `parent` parameter (see [Data Catalog Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * </pre>
     */
    public com.google.cloud.datacatalog.v1beta1.EntryGroup createEntryGroup(
        com.google.cloud.datacatalog.v1beta1.CreateEntryGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEntryGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an EntryGroup. The user should enable the Data Catalog API in the
     * project identified by the `entry_group.name` parameter (see [Data Catalog
     * Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * </pre>
     */
    public com.google.cloud.datacatalog.v1beta1.EntryGroup updateEntryGroup(
        com.google.cloud.datacatalog.v1beta1.UpdateEntryGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEntryGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an EntryGroup.
     * </pre>
     */
    public com.google.cloud.datacatalog.v1beta1.EntryGroup getEntryGroup(
        com.google.cloud.datacatalog.v1beta1.GetEntryGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEntryGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an EntryGroup. Only entry groups that do not contain entries can be
     * deleted. Users should enable the Data Catalog API in the project
     * identified by the `name` parameter (see [Data Catalog Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * </pre>
     */
    public com.google.protobuf.Empty deleteEntryGroup(
        com.google.cloud.datacatalog.v1beta1.DeleteEntryGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEntryGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists entry groups.
     * </pre>
     */
    public com.google.cloud.datacatalog.v1beta1.ListEntryGroupsResponse listEntryGroups(
        com.google.cloud.datacatalog.v1beta1.ListEntryGroupsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEntryGroupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an entry. Only entries of 'FILESET' type or user-specified type can
     * be created.
     * Users should enable the Data Catalog API in the project identified by
     * the `parent` parameter (see [Data Catalog Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * A maximum of 100,000 entries may be created per entry group.
     * </pre>
     */
    public com.google.cloud.datacatalog.v1beta1.Entry createEntry(
        com.google.cloud.datacatalog.v1beta1.CreateEntryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEntryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing entry.
     * Users should enable the Data Catalog API in the project identified by
     * the `entry.name` parameter (see [Data Catalog Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * </pre>
     */
    public com.google.cloud.datacatalog.v1beta1.Entry updateEntry(
        com.google.cloud.datacatalog.v1beta1.UpdateEntryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEntryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing entry. Only entries created through
     * [CreateEntry][google.cloud.datacatalog.v1beta1.DataCatalog.CreateEntry]
     * method can be deleted.
     * Users should enable the Data Catalog API in the project identified by
     * the `name` parameter (see [Data Catalog Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * </pre>
     */
    public com.google.protobuf.Empty deleteEntry(
        com.google.cloud.datacatalog.v1beta1.DeleteEntryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEntryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an entry.
     * </pre>
     */
    public com.google.cloud.datacatalog.v1beta1.Entry getEntry(
        com.google.cloud.datacatalog.v1beta1.GetEntryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEntryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get an entry by target resource name. This method allows clients to use
     * the resource name from the source Google Cloud Platform service to get the
     * Data Catalog Entry.
     * </pre>
     */
    public com.google.cloud.datacatalog.v1beta1.Entry lookupEntry(
        com.google.cloud.datacatalog.v1beta1.LookupEntryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLookupEntryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists entries.
     * </pre>
     */
    public com.google.cloud.datacatalog.v1beta1.ListEntriesResponse listEntries(
        com.google.cloud.datacatalog.v1beta1.ListEntriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEntriesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a tag template. The user should enable the Data Catalog API in
     * the project identified by the `parent` parameter (see [Data Catalog
     * Resource
     * Project](https://cloud.google.com/data-catalog/docs/concepts/resource-project)
     * for more information).
     * </pre>
     */
    public com.google.cloud.datacatalog.v1beta1.TagTemplate createTagTemplate(
        com.google.cloud.datacatalog.v1beta1.CreateTagTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTagTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a tag template.
     * </pre>
     */
    public com.google.cloud.datacatalog.v1beta1.TagTemplate getTagTemplate(
        com.google.cloud.datacatalog.v1beta1.GetTagTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTagTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a tag template. This method cannot be used to update the fields of
     * a template. The tag template fields are represented as separate resources
     * and should be updated using their own create/update/delete methods.
     * Users should enable the Data Catalog API in the project identified by
     * the `tag_template.name` parameter (see [Data Catalog Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * </pre>
     */
    public com.google.cloud.datacatalog.v1beta1.TagTemplate updateTagTemplate(
        com.google.cloud.datacatalog.v1beta1.UpdateTagTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTagTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a tag template and all tags using the template.
     * Users should enable the Data Catalog API in the project identified by
     * the `name` parameter (see [Data Catalog Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * </pre>
     */
    public com.google.protobuf.Empty deleteTagTemplate(
        com.google.cloud.datacatalog.v1beta1.DeleteTagTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTagTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a field in a tag template. The user should enable the Data Catalog
     * API in the project identified by the `parent` parameter (see
     * [Data Catalog Resource
     * Project](https://cloud.google.com/data-catalog/docs/concepts/resource-project)
     * for more information).
     * </pre>
     */
    public com.google.cloud.datacatalog.v1beta1.TagTemplateField createTagTemplateField(
        com.google.cloud.datacatalog.v1beta1.CreateTagTemplateFieldRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTagTemplateFieldMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a field in a tag template. This method cannot be used to update the
     * field type. Users should enable the Data Catalog API in the project
     * identified by the `name` parameter (see [Data Catalog Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * </pre>
     */
    public com.google.cloud.datacatalog.v1beta1.TagTemplateField updateTagTemplateField(
        com.google.cloud.datacatalog.v1beta1.UpdateTagTemplateFieldRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTagTemplateFieldMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Renames a field in a tag template. The user should enable the Data Catalog
     * API in the project identified by the `name` parameter (see [Data Catalog
     * Resource
     * Project](https://cloud.google.com/data-catalog/docs/concepts/resource-project)
     * for more information).
     * </pre>
     */
    public com.google.cloud.datacatalog.v1beta1.TagTemplateField renameTagTemplateField(
        com.google.cloud.datacatalog.v1beta1.RenameTagTemplateFieldRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRenameTagTemplateFieldMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a field in a tag template and all uses of that field.
     * Users should enable the Data Catalog API in the project identified by
     * the `name` parameter (see [Data Catalog Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * </pre>
     */
    public com.google.protobuf.Empty deleteTagTemplateField(
        com.google.cloud.datacatalog.v1beta1.DeleteTagTemplateFieldRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTagTemplateFieldMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a tag on an [Entry][google.cloud.datacatalog.v1beta1.Entry].
     * Note: The project identified by the `parent` parameter for the
     * [tag](https://cloud.google.com/data-catalog/docs/reference/rest/v1beta1/projects.locations.entryGroups.entries.tags/create#path-parameters)
     * and the
     * [tag
     * template](https://cloud.google.com/data-catalog/docs/reference/rest/v1beta1/projects.locations.tagTemplates/create#path-parameters)
     * used to create the tag must be from the same organization.
     * </pre>
     */
    public com.google.cloud.datacatalog.v1beta1.Tag createTag(
        com.google.cloud.datacatalog.v1beta1.CreateTagRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTagMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing tag.
     * </pre>
     */
    public com.google.cloud.datacatalog.v1beta1.Tag updateTag(
        com.google.cloud.datacatalog.v1beta1.UpdateTagRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTagMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a tag.
     * </pre>
     */
    public com.google.protobuf.Empty deleteTag(
        com.google.cloud.datacatalog.v1beta1.DeleteTagRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTagMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the tags on an [Entry][google.cloud.datacatalog.v1beta1.Entry].
     * </pre>
     */
    public com.google.cloud.datacatalog.v1beta1.ListTagsResponse listTags(
        com.google.cloud.datacatalog.v1beta1.ListTagsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTagsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy for a resource. Replaces any existing
     * policy.
     * Supported resources are:
     *   - Tag templates.
     *   - Entries.
     *   - Entry groups.
     * Note, this method cannot be used to manage policies for BigQuery, Pub/Sub
     * and any external Google Cloud Platform resources synced to Data Catalog.
     * Callers must have following Google IAM permission
     *   - `datacatalog.tagTemplates.setIamPolicy` to set policies on tag
     *     templates.
     *   - `datacatalog.entries.setIamPolicy` to set policies on entries.
     *   - `datacatalog.entryGroups.setIamPolicy` to set policies on entry groups.
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for a resource. A `NOT_FOUND` error
     * is returned if the resource does not exist. An empty policy is returned
     * if the resource exists but does not have a policy set on it.
     * Supported resources are:
     *   - Tag templates.
     *   - Entries.
     *   - Entry groups.
     * Note, this method cannot be used to manage policies for BigQuery, Pub/Sub
     * and any external Google Cloud Platform resources synced to Data Catalog.
     * Callers must have following Google IAM permission
     *   - `datacatalog.tagTemplates.getIamPolicy` to get policies on tag
     *     templates.
     *   - `datacatalog.entries.getIamPolicy` to get policies on entries.
     *   - `datacatalog.entryGroups.getIamPolicy` to get policies on entry groups.
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the caller's permissions on a resource.
     * If the resource does not exist, an empty set of permissions is returned
     * (We don't return a `NOT_FOUND` error).
     * Supported resources are:
     *   - Tag templates.
     *   - Entries.
     *   - Entry groups.
     * Note, this method cannot be used to manage policies for BigQuery, Pub/Sub
     * and any external Google Cloud Platform resources synced to Data Catalog.
     * A caller is not required to have Google IAM permission to make this
     * request.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Data Catalog API service allows clients to discover, understand, and manage
   * their data.
   * </pre>
   */
  public static final class DataCatalogFutureStub
      extends io.grpc.stub.AbstractFutureStub<DataCatalogFutureStub> {
    private DataCatalogFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataCatalogFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataCatalogFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Searches Data Catalog for multiple resources like entries, tags that
     * match a query.
     * This is a custom method
     * (https://cloud.google.com/apis/design/custom_methods) and does not return
     * the complete resource, only the resource identifier and high level
     * fields. Clients can subsequentally call `Get` methods.
     * Note that Data Catalog search queries do not guarantee full recall. Query
     * results that match your query may not be returned, even in subsequent
     * result pages. Also note that results returned (and not returned) can vary
     * across repeated search queries.
     * See [Data Catalog Search
     * Syntax](https://cloud.google.com/data-catalog/docs/how-to/search-reference)
     * for more information.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.v1beta1.SearchCatalogResponse>
        searchCatalog(com.google.cloud.datacatalog.v1beta1.SearchCatalogRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchCatalogMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * A maximum of 10,000 entry groups may be created per organization across all
     * locations.
     * Users should enable the Data Catalog API in the project identified by
     * the `parent` parameter (see [Data Catalog Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.v1beta1.EntryGroup>
        createEntryGroup(com.google.cloud.datacatalog.v1beta1.CreateEntryGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEntryGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an EntryGroup. The user should enable the Data Catalog API in the
     * project identified by the `entry_group.name` parameter (see [Data Catalog
     * Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.v1beta1.EntryGroup>
        updateEntryGroup(com.google.cloud.datacatalog.v1beta1.UpdateEntryGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEntryGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an EntryGroup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.v1beta1.EntryGroup>
        getEntryGroup(com.google.cloud.datacatalog.v1beta1.GetEntryGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEntryGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an EntryGroup. Only entry groups that do not contain entries can be
     * deleted. Users should enable the Data Catalog API in the project
     * identified by the `name` parameter (see [Data Catalog Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteEntryGroup(com.google.cloud.datacatalog.v1beta1.DeleteEntryGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEntryGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists entry groups.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.v1beta1.ListEntryGroupsResponse>
        listEntryGroups(com.google.cloud.datacatalog.v1beta1.ListEntryGroupsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEntryGroupsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an entry. Only entries of 'FILESET' type or user-specified type can
     * be created.
     * Users should enable the Data Catalog API in the project identified by
     * the `parent` parameter (see [Data Catalog Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * A maximum of 100,000 entries may be created per entry group.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.v1beta1.Entry>
        createEntry(com.google.cloud.datacatalog.v1beta1.CreateEntryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEntryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing entry.
     * Users should enable the Data Catalog API in the project identified by
     * the `entry.name` parameter (see [Data Catalog Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.v1beta1.Entry>
        updateEntry(com.google.cloud.datacatalog.v1beta1.UpdateEntryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEntryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing entry. Only entries created through
     * [CreateEntry][google.cloud.datacatalog.v1beta1.DataCatalog.CreateEntry]
     * method can be deleted.
     * Users should enable the Data Catalog API in the project identified by
     * the `name` parameter (see [Data Catalog Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteEntry(com.google.cloud.datacatalog.v1beta1.DeleteEntryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEntryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an entry.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.v1beta1.Entry>
        getEntry(com.google.cloud.datacatalog.v1beta1.GetEntryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEntryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get an entry by target resource name. This method allows clients to use
     * the resource name from the source Google Cloud Platform service to get the
     * Data Catalog Entry.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.v1beta1.Entry>
        lookupEntry(com.google.cloud.datacatalog.v1beta1.LookupEntryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLookupEntryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists entries.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.v1beta1.ListEntriesResponse>
        listEntries(com.google.cloud.datacatalog.v1beta1.ListEntriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEntriesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a tag template. The user should enable the Data Catalog API in
     * the project identified by the `parent` parameter (see [Data Catalog
     * Resource
     * Project](https://cloud.google.com/data-catalog/docs/concepts/resource-project)
     * for more information).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.v1beta1.TagTemplate>
        createTagTemplate(com.google.cloud.datacatalog.v1beta1.CreateTagTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTagTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a tag template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.v1beta1.TagTemplate>
        getTagTemplate(com.google.cloud.datacatalog.v1beta1.GetTagTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTagTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a tag template. This method cannot be used to update the fields of
     * a template. The tag template fields are represented as separate resources
     * and should be updated using their own create/update/delete methods.
     * Users should enable the Data Catalog API in the project identified by
     * the `tag_template.name` parameter (see [Data Catalog Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.v1beta1.TagTemplate>
        updateTagTemplate(com.google.cloud.datacatalog.v1beta1.UpdateTagTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTagTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a tag template and all tags using the template.
     * Users should enable the Data Catalog API in the project identified by
     * the `name` parameter (see [Data Catalog Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteTagTemplate(com.google.cloud.datacatalog.v1beta1.DeleteTagTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTagTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a field in a tag template. The user should enable the Data Catalog
     * API in the project identified by the `parent` parameter (see
     * [Data Catalog Resource
     * Project](https://cloud.google.com/data-catalog/docs/concepts/resource-project)
     * for more information).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.v1beta1.TagTemplateField>
        createTagTemplateField(
            com.google.cloud.datacatalog.v1beta1.CreateTagTemplateFieldRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTagTemplateFieldMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a field in a tag template. This method cannot be used to update the
     * field type. Users should enable the Data Catalog API in the project
     * identified by the `name` parameter (see [Data Catalog Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.v1beta1.TagTemplateField>
        updateTagTemplateField(
            com.google.cloud.datacatalog.v1beta1.UpdateTagTemplateFieldRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTagTemplateFieldMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Renames a field in a tag template. The user should enable the Data Catalog
     * API in the project identified by the `name` parameter (see [Data Catalog
     * Resource
     * Project](https://cloud.google.com/data-catalog/docs/concepts/resource-project)
     * for more information).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.v1beta1.TagTemplateField>
        renameTagTemplateField(
            com.google.cloud.datacatalog.v1beta1.RenameTagTemplateFieldRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRenameTagTemplateFieldMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a field in a tag template and all uses of that field.
     * Users should enable the Data Catalog API in the project identified by
     * the `name` parameter (see [Data Catalog Resource Project]
     * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for
     * more information).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteTagTemplateField(
            com.google.cloud.datacatalog.v1beta1.DeleteTagTemplateFieldRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTagTemplateFieldMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a tag on an [Entry][google.cloud.datacatalog.v1beta1.Entry].
     * Note: The project identified by the `parent` parameter for the
     * [tag](https://cloud.google.com/data-catalog/docs/reference/rest/v1beta1/projects.locations.entryGroups.entries.tags/create#path-parameters)
     * and the
     * [tag
     * template](https://cloud.google.com/data-catalog/docs/reference/rest/v1beta1/projects.locations.tagTemplates/create#path-parameters)
     * used to create the tag must be from the same organization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.v1beta1.Tag>
        createTag(com.google.cloud.datacatalog.v1beta1.CreateTagRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTagMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing tag.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.v1beta1.Tag>
        updateTag(com.google.cloud.datacatalog.v1beta1.UpdateTagRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTagMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a tag.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteTag(
        com.google.cloud.datacatalog.v1beta1.DeleteTagRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTagMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the tags on an [Entry][google.cloud.datacatalog.v1beta1.Entry].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.v1beta1.ListTagsResponse>
        listTags(com.google.cloud.datacatalog.v1beta1.ListTagsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTagsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy for a resource. Replaces any existing
     * policy.
     * Supported resources are:
     *   - Tag templates.
     *   - Entries.
     *   - Entry groups.
     * Note, this method cannot be used to manage policies for BigQuery, Pub/Sub
     * and any external Google Cloud Platform resources synced to Data Catalog.
     * Callers must have following Google IAM permission
     *   - `datacatalog.tagTemplates.setIamPolicy` to set policies on tag
     *     templates.
     *   - `datacatalog.entries.setIamPolicy` to set policies on entries.
     *   - `datacatalog.entryGroups.setIamPolicy` to set policies on entry groups.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy for a resource. A `NOT_FOUND` error
     * is returned if the resource does not exist. An empty policy is returned
     * if the resource exists but does not have a policy set on it.
     * Supported resources are:
     *   - Tag templates.
     *   - Entries.
     *   - Entry groups.
     * Note, this method cannot be used to manage policies for BigQuery, Pub/Sub
     * and any external Google Cloud Platform resources synced to Data Catalog.
     * Callers must have following Google IAM permission
     *   - `datacatalog.tagTemplates.getIamPolicy` to get policies on tag
     *     templates.
     *   - `datacatalog.entries.getIamPolicy` to get policies on entries.
     *   - `datacatalog.entryGroups.getIamPolicy` to get policies on entry groups.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the caller's permissions on a resource.
     * If the resource does not exist, an empty set of permissions is returned
     * (We don't return a `NOT_FOUND` error).
     * Supported resources are:
     *   - Tag templates.
     *   - Entries.
     *   - Entry groups.
     * Note, this method cannot be used to manage policies for BigQuery, Pub/Sub
     * and any external Google Cloud Platform resources synced to Data Catalog.
     * A caller is not required to have Google IAM permission to make this
     * request.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.iam.v1.TestIamPermissionsResponse>
        testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEARCH_CATALOG = 0;
  private static final int METHODID_CREATE_ENTRY_GROUP = 1;
  private static final int METHODID_UPDATE_ENTRY_GROUP = 2;
  private static final int METHODID_GET_ENTRY_GROUP = 3;
  private static final int METHODID_DELETE_ENTRY_GROUP = 4;
  private static final int METHODID_LIST_ENTRY_GROUPS = 5;
  private static final int METHODID_CREATE_ENTRY = 6;
  private static final int METHODID_UPDATE_ENTRY = 7;
  private static final int METHODID_DELETE_ENTRY = 8;
  private static final int METHODID_GET_ENTRY = 9;
  private static final int METHODID_LOOKUP_ENTRY = 10;
  private static final int METHODID_LIST_ENTRIES = 11;
  private static final int METHODID_CREATE_TAG_TEMPLATE = 12;
  private static final int METHODID_GET_TAG_TEMPLATE = 13;
  private static final int METHODID_UPDATE_TAG_TEMPLATE = 14;
  private static final int METHODID_DELETE_TAG_TEMPLATE = 15;
  private static final int METHODID_CREATE_TAG_TEMPLATE_FIELD = 16;
  private static final int METHODID_UPDATE_TAG_TEMPLATE_FIELD = 17;
  private static final int METHODID_RENAME_TAG_TEMPLATE_FIELD = 18;
  private static final int METHODID_DELETE_TAG_TEMPLATE_FIELD = 19;
  private static final int METHODID_CREATE_TAG = 20;
  private static final int METHODID_UPDATE_TAG = 21;
  private static final int METHODID_DELETE_TAG = 22;
  private static final int METHODID_LIST_TAGS = 23;
  private static final int METHODID_SET_IAM_POLICY = 24;
  private static final int METHODID_GET_IAM_POLICY = 25;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 26;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DataCatalogImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DataCatalogImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEARCH_CATALOG:
          serviceImpl.searchCatalog(
              (com.google.cloud.datacatalog.v1beta1.SearchCatalogRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.datacatalog.v1beta1.SearchCatalogResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_ENTRY_GROUP:
          serviceImpl.createEntryGroup(
              (com.google.cloud.datacatalog.v1beta1.CreateEntryGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.EntryGroup>)
                  responseObserver);
          break;
        case METHODID_UPDATE_ENTRY_GROUP:
          serviceImpl.updateEntryGroup(
              (com.google.cloud.datacatalog.v1beta1.UpdateEntryGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.EntryGroup>)
                  responseObserver);
          break;
        case METHODID_GET_ENTRY_GROUP:
          serviceImpl.getEntryGroup(
              (com.google.cloud.datacatalog.v1beta1.GetEntryGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.EntryGroup>)
                  responseObserver);
          break;
        case METHODID_DELETE_ENTRY_GROUP:
          serviceImpl.deleteEntryGroup(
              (com.google.cloud.datacatalog.v1beta1.DeleteEntryGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_ENTRY_GROUPS:
          serviceImpl.listEntryGroups(
              (com.google.cloud.datacatalog.v1beta1.ListEntryGroupsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.datacatalog.v1beta1.ListEntryGroupsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_ENTRY:
          serviceImpl.createEntry(
              (com.google.cloud.datacatalog.v1beta1.CreateEntryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.Entry>)
                  responseObserver);
          break;
        case METHODID_UPDATE_ENTRY:
          serviceImpl.updateEntry(
              (com.google.cloud.datacatalog.v1beta1.UpdateEntryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.Entry>)
                  responseObserver);
          break;
        case METHODID_DELETE_ENTRY:
          serviceImpl.deleteEntry(
              (com.google.cloud.datacatalog.v1beta1.DeleteEntryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_ENTRY:
          serviceImpl.getEntry(
              (com.google.cloud.datacatalog.v1beta1.GetEntryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.Entry>)
                  responseObserver);
          break;
        case METHODID_LOOKUP_ENTRY:
          serviceImpl.lookupEntry(
              (com.google.cloud.datacatalog.v1beta1.LookupEntryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.Entry>)
                  responseObserver);
          break;
        case METHODID_LIST_ENTRIES:
          serviceImpl.listEntries(
              (com.google.cloud.datacatalog.v1beta1.ListEntriesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.datacatalog.v1beta1.ListEntriesResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_TAG_TEMPLATE:
          serviceImpl.createTagTemplate(
              (com.google.cloud.datacatalog.v1beta1.CreateTagTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.TagTemplate>)
                  responseObserver);
          break;
        case METHODID_GET_TAG_TEMPLATE:
          serviceImpl.getTagTemplate(
              (com.google.cloud.datacatalog.v1beta1.GetTagTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.TagTemplate>)
                  responseObserver);
          break;
        case METHODID_UPDATE_TAG_TEMPLATE:
          serviceImpl.updateTagTemplate(
              (com.google.cloud.datacatalog.v1beta1.UpdateTagTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.TagTemplate>)
                  responseObserver);
          break;
        case METHODID_DELETE_TAG_TEMPLATE:
          serviceImpl.deleteTagTemplate(
              (com.google.cloud.datacatalog.v1beta1.DeleteTagTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_TAG_TEMPLATE_FIELD:
          serviceImpl.createTagTemplateField(
              (com.google.cloud.datacatalog.v1beta1.CreateTagTemplateFieldRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.TagTemplateField>)
                  responseObserver);
          break;
        case METHODID_UPDATE_TAG_TEMPLATE_FIELD:
          serviceImpl.updateTagTemplateField(
              (com.google.cloud.datacatalog.v1beta1.UpdateTagTemplateFieldRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.TagTemplateField>)
                  responseObserver);
          break;
        case METHODID_RENAME_TAG_TEMPLATE_FIELD:
          serviceImpl.renameTagTemplateField(
              (com.google.cloud.datacatalog.v1beta1.RenameTagTemplateFieldRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.TagTemplateField>)
                  responseObserver);
          break;
        case METHODID_DELETE_TAG_TEMPLATE_FIELD:
          serviceImpl.deleteTagTemplateField(
              (com.google.cloud.datacatalog.v1beta1.DeleteTagTemplateFieldRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_TAG:
          serviceImpl.createTag(
              (com.google.cloud.datacatalog.v1beta1.CreateTagRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.Tag>)
                  responseObserver);
          break;
        case METHODID_UPDATE_TAG:
          serviceImpl.updateTag(
              (com.google.cloud.datacatalog.v1beta1.UpdateTagRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.Tag>)
                  responseObserver);
          break;
        case METHODID_DELETE_TAG:
          serviceImpl.deleteTag(
              (com.google.cloud.datacatalog.v1beta1.DeleteTagRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_TAGS:
          serviceImpl.listTags(
              (com.google.cloud.datacatalog.v1beta1.ListTagsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.ListTagsResponse>)
                  responseObserver);
          break;
        case METHODID_SET_IAM_POLICY:
          serviceImpl.setIamPolicy(
              (com.google.iam.v1.SetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_GET_IAM_POLICY:
          serviceImpl.getIamPolicy(
              (com.google.iam.v1.GetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_TEST_IAM_PERMISSIONS:
          serviceImpl.testIamPermissions(
              (com.google.iam.v1.TestIamPermissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>)
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

  private abstract static class DataCatalogBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataCatalogBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.datacatalog.v1beta1.Datacatalog.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataCatalog");
    }
  }

  private static final class DataCatalogFileDescriptorSupplier
      extends DataCatalogBaseDescriptorSupplier {
    DataCatalogFileDescriptorSupplier() {}
  }

  private static final class DataCatalogMethodDescriptorSupplier
      extends DataCatalogBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DataCatalogMethodDescriptorSupplier(String methodName) {
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
      synchronized (DataCatalogGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DataCatalogFileDescriptorSupplier())
                      .addMethod(getSearchCatalogMethod())
                      .addMethod(getCreateEntryGroupMethod())
                      .addMethod(getUpdateEntryGroupMethod())
                      .addMethod(getGetEntryGroupMethod())
                      .addMethod(getDeleteEntryGroupMethod())
                      .addMethod(getListEntryGroupsMethod())
                      .addMethod(getCreateEntryMethod())
                      .addMethod(getUpdateEntryMethod())
                      .addMethod(getDeleteEntryMethod())
                      .addMethod(getGetEntryMethod())
                      .addMethod(getLookupEntryMethod())
                      .addMethod(getListEntriesMethod())
                      .addMethod(getCreateTagTemplateMethod())
                      .addMethod(getGetTagTemplateMethod())
                      .addMethod(getUpdateTagTemplateMethod())
                      .addMethod(getDeleteTagTemplateMethod())
                      .addMethod(getCreateTagTemplateFieldMethod())
                      .addMethod(getUpdateTagTemplateFieldMethod())
                      .addMethod(getRenameTagTemplateFieldMethod())
                      .addMethod(getDeleteTagTemplateFieldMethod())
                      .addMethod(getCreateTagMethod())
                      .addMethod(getUpdateTagMethod())
                      .addMethod(getDeleteTagMethod())
                      .addMethod(getListTagsMethod())
                      .addMethod(getSetIamPolicyMethod())
                      .addMethod(getGetIamPolicyMethod())
                      .addMethod(getTestIamPermissionsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
