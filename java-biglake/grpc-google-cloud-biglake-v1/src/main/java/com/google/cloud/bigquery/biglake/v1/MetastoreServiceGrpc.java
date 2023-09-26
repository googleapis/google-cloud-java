/*
 * Copyright 2023 Google LLC
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
package com.google.cloud.bigquery.biglake.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * BigLake Metastore is a serverless, highly available, multi-tenant runtime
 * metastore for Google Cloud Data Analytics products.
 * The BigLake Metastore API defines the following resource model:
 * * A collection of Google Cloud projects: `/projects/&#42;`
 * * Each project has a collection of available locations: `/locations/&#42;`
 * * Each location has a collection of catalogs: `/catalogs/&#42;`
 * * Each catalog has a collection of databases: `/databases/&#42;`
 * * Each database has a collection of tables: `/tables/&#42;`
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/bigquery/biglake/v1/metastore.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MetastoreServiceGrpc {

  private MetastoreServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.bigquery.biglake.v1.MetastoreService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.biglake.v1.CreateCatalogRequest,
          com.google.cloud.bigquery.biglake.v1.Catalog>
      getCreateCatalogMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCatalog",
      requestType = com.google.cloud.bigquery.biglake.v1.CreateCatalogRequest.class,
      responseType = com.google.cloud.bigquery.biglake.v1.Catalog.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.biglake.v1.CreateCatalogRequest,
          com.google.cloud.bigquery.biglake.v1.Catalog>
      getCreateCatalogMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.biglake.v1.CreateCatalogRequest,
            com.google.cloud.bigquery.biglake.v1.Catalog>
        getCreateCatalogMethod;
    if ((getCreateCatalogMethod = MetastoreServiceGrpc.getCreateCatalogMethod) == null) {
      synchronized (MetastoreServiceGrpc.class) {
        if ((getCreateCatalogMethod = MetastoreServiceGrpc.getCreateCatalogMethod) == null) {
          MetastoreServiceGrpc.getCreateCatalogMethod =
              getCreateCatalogMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.biglake.v1.CreateCatalogRequest,
                          com.google.cloud.bigquery.biglake.v1.Catalog>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCatalog"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.biglake.v1.CreateCatalogRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.biglake.v1.Catalog.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetastoreServiceMethodDescriptorSupplier("CreateCatalog"))
                      .build();
        }
      }
    }
    return getCreateCatalogMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.biglake.v1.DeleteCatalogRequest,
          com.google.cloud.bigquery.biglake.v1.Catalog>
      getDeleteCatalogMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCatalog",
      requestType = com.google.cloud.bigquery.biglake.v1.DeleteCatalogRequest.class,
      responseType = com.google.cloud.bigquery.biglake.v1.Catalog.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.biglake.v1.DeleteCatalogRequest,
          com.google.cloud.bigquery.biglake.v1.Catalog>
      getDeleteCatalogMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.biglake.v1.DeleteCatalogRequest,
            com.google.cloud.bigquery.biglake.v1.Catalog>
        getDeleteCatalogMethod;
    if ((getDeleteCatalogMethod = MetastoreServiceGrpc.getDeleteCatalogMethod) == null) {
      synchronized (MetastoreServiceGrpc.class) {
        if ((getDeleteCatalogMethod = MetastoreServiceGrpc.getDeleteCatalogMethod) == null) {
          MetastoreServiceGrpc.getDeleteCatalogMethod =
              getDeleteCatalogMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.biglake.v1.DeleteCatalogRequest,
                          com.google.cloud.bigquery.biglake.v1.Catalog>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCatalog"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.biglake.v1.DeleteCatalogRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.biglake.v1.Catalog.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetastoreServiceMethodDescriptorSupplier("DeleteCatalog"))
                      .build();
        }
      }
    }
    return getDeleteCatalogMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.biglake.v1.GetCatalogRequest,
          com.google.cloud.bigquery.biglake.v1.Catalog>
      getGetCatalogMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCatalog",
      requestType = com.google.cloud.bigquery.biglake.v1.GetCatalogRequest.class,
      responseType = com.google.cloud.bigquery.biglake.v1.Catalog.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.biglake.v1.GetCatalogRequest,
          com.google.cloud.bigquery.biglake.v1.Catalog>
      getGetCatalogMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.biglake.v1.GetCatalogRequest,
            com.google.cloud.bigquery.biglake.v1.Catalog>
        getGetCatalogMethod;
    if ((getGetCatalogMethod = MetastoreServiceGrpc.getGetCatalogMethod) == null) {
      synchronized (MetastoreServiceGrpc.class) {
        if ((getGetCatalogMethod = MetastoreServiceGrpc.getGetCatalogMethod) == null) {
          MetastoreServiceGrpc.getGetCatalogMethod =
              getGetCatalogMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.biglake.v1.GetCatalogRequest,
                          com.google.cloud.bigquery.biglake.v1.Catalog>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCatalog"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.biglake.v1.GetCatalogRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.biglake.v1.Catalog.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetastoreServiceMethodDescriptorSupplier("GetCatalog"))
                      .build();
        }
      }
    }
    return getGetCatalogMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.biglake.v1.ListCatalogsRequest,
          com.google.cloud.bigquery.biglake.v1.ListCatalogsResponse>
      getListCatalogsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCatalogs",
      requestType = com.google.cloud.bigquery.biglake.v1.ListCatalogsRequest.class,
      responseType = com.google.cloud.bigquery.biglake.v1.ListCatalogsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.biglake.v1.ListCatalogsRequest,
          com.google.cloud.bigquery.biglake.v1.ListCatalogsResponse>
      getListCatalogsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.biglake.v1.ListCatalogsRequest,
            com.google.cloud.bigquery.biglake.v1.ListCatalogsResponse>
        getListCatalogsMethod;
    if ((getListCatalogsMethod = MetastoreServiceGrpc.getListCatalogsMethod) == null) {
      synchronized (MetastoreServiceGrpc.class) {
        if ((getListCatalogsMethod = MetastoreServiceGrpc.getListCatalogsMethod) == null) {
          MetastoreServiceGrpc.getListCatalogsMethod =
              getListCatalogsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.biglake.v1.ListCatalogsRequest,
                          com.google.cloud.bigquery.biglake.v1.ListCatalogsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCatalogs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.biglake.v1.ListCatalogsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.biglake.v1.ListCatalogsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetastoreServiceMethodDescriptorSupplier("ListCatalogs"))
                      .build();
        }
      }
    }
    return getListCatalogsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.biglake.v1.CreateDatabaseRequest,
          com.google.cloud.bigquery.biglake.v1.Database>
      getCreateDatabaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDatabase",
      requestType = com.google.cloud.bigquery.biglake.v1.CreateDatabaseRequest.class,
      responseType = com.google.cloud.bigquery.biglake.v1.Database.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.biglake.v1.CreateDatabaseRequest,
          com.google.cloud.bigquery.biglake.v1.Database>
      getCreateDatabaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.biglake.v1.CreateDatabaseRequest,
            com.google.cloud.bigquery.biglake.v1.Database>
        getCreateDatabaseMethod;
    if ((getCreateDatabaseMethod = MetastoreServiceGrpc.getCreateDatabaseMethod) == null) {
      synchronized (MetastoreServiceGrpc.class) {
        if ((getCreateDatabaseMethod = MetastoreServiceGrpc.getCreateDatabaseMethod) == null) {
          MetastoreServiceGrpc.getCreateDatabaseMethod =
              getCreateDatabaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.biglake.v1.CreateDatabaseRequest,
                          com.google.cloud.bigquery.biglake.v1.Database>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDatabase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.biglake.v1.CreateDatabaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.biglake.v1.Database.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetastoreServiceMethodDescriptorSupplier("CreateDatabase"))
                      .build();
        }
      }
    }
    return getCreateDatabaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.biglake.v1.DeleteDatabaseRequest,
          com.google.cloud.bigquery.biglake.v1.Database>
      getDeleteDatabaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDatabase",
      requestType = com.google.cloud.bigquery.biglake.v1.DeleteDatabaseRequest.class,
      responseType = com.google.cloud.bigquery.biglake.v1.Database.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.biglake.v1.DeleteDatabaseRequest,
          com.google.cloud.bigquery.biglake.v1.Database>
      getDeleteDatabaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.biglake.v1.DeleteDatabaseRequest,
            com.google.cloud.bigquery.biglake.v1.Database>
        getDeleteDatabaseMethod;
    if ((getDeleteDatabaseMethod = MetastoreServiceGrpc.getDeleteDatabaseMethod) == null) {
      synchronized (MetastoreServiceGrpc.class) {
        if ((getDeleteDatabaseMethod = MetastoreServiceGrpc.getDeleteDatabaseMethod) == null) {
          MetastoreServiceGrpc.getDeleteDatabaseMethod =
              getDeleteDatabaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.biglake.v1.DeleteDatabaseRequest,
                          com.google.cloud.bigquery.biglake.v1.Database>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDatabase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.biglake.v1.DeleteDatabaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.biglake.v1.Database.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetastoreServiceMethodDescriptorSupplier("DeleteDatabase"))
                      .build();
        }
      }
    }
    return getDeleteDatabaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.biglake.v1.UpdateDatabaseRequest,
          com.google.cloud.bigquery.biglake.v1.Database>
      getUpdateDatabaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDatabase",
      requestType = com.google.cloud.bigquery.biglake.v1.UpdateDatabaseRequest.class,
      responseType = com.google.cloud.bigquery.biglake.v1.Database.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.biglake.v1.UpdateDatabaseRequest,
          com.google.cloud.bigquery.biglake.v1.Database>
      getUpdateDatabaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.biglake.v1.UpdateDatabaseRequest,
            com.google.cloud.bigquery.biglake.v1.Database>
        getUpdateDatabaseMethod;
    if ((getUpdateDatabaseMethod = MetastoreServiceGrpc.getUpdateDatabaseMethod) == null) {
      synchronized (MetastoreServiceGrpc.class) {
        if ((getUpdateDatabaseMethod = MetastoreServiceGrpc.getUpdateDatabaseMethod) == null) {
          MetastoreServiceGrpc.getUpdateDatabaseMethod =
              getUpdateDatabaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.biglake.v1.UpdateDatabaseRequest,
                          com.google.cloud.bigquery.biglake.v1.Database>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDatabase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.biglake.v1.UpdateDatabaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.biglake.v1.Database.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetastoreServiceMethodDescriptorSupplier("UpdateDatabase"))
                      .build();
        }
      }
    }
    return getUpdateDatabaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.biglake.v1.GetDatabaseRequest,
          com.google.cloud.bigquery.biglake.v1.Database>
      getGetDatabaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDatabase",
      requestType = com.google.cloud.bigquery.biglake.v1.GetDatabaseRequest.class,
      responseType = com.google.cloud.bigquery.biglake.v1.Database.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.biglake.v1.GetDatabaseRequest,
          com.google.cloud.bigquery.biglake.v1.Database>
      getGetDatabaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.biglake.v1.GetDatabaseRequest,
            com.google.cloud.bigquery.biglake.v1.Database>
        getGetDatabaseMethod;
    if ((getGetDatabaseMethod = MetastoreServiceGrpc.getGetDatabaseMethod) == null) {
      synchronized (MetastoreServiceGrpc.class) {
        if ((getGetDatabaseMethod = MetastoreServiceGrpc.getGetDatabaseMethod) == null) {
          MetastoreServiceGrpc.getGetDatabaseMethod =
              getGetDatabaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.biglake.v1.GetDatabaseRequest,
                          com.google.cloud.bigquery.biglake.v1.Database>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDatabase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.biglake.v1.GetDatabaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.biglake.v1.Database.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetastoreServiceMethodDescriptorSupplier("GetDatabase"))
                      .build();
        }
      }
    }
    return getGetDatabaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.biglake.v1.ListDatabasesRequest,
          com.google.cloud.bigquery.biglake.v1.ListDatabasesResponse>
      getListDatabasesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDatabases",
      requestType = com.google.cloud.bigquery.biglake.v1.ListDatabasesRequest.class,
      responseType = com.google.cloud.bigquery.biglake.v1.ListDatabasesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.biglake.v1.ListDatabasesRequest,
          com.google.cloud.bigquery.biglake.v1.ListDatabasesResponse>
      getListDatabasesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.biglake.v1.ListDatabasesRequest,
            com.google.cloud.bigquery.biglake.v1.ListDatabasesResponse>
        getListDatabasesMethod;
    if ((getListDatabasesMethod = MetastoreServiceGrpc.getListDatabasesMethod) == null) {
      synchronized (MetastoreServiceGrpc.class) {
        if ((getListDatabasesMethod = MetastoreServiceGrpc.getListDatabasesMethod) == null) {
          MetastoreServiceGrpc.getListDatabasesMethod =
              getListDatabasesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.biglake.v1.ListDatabasesRequest,
                          com.google.cloud.bigquery.biglake.v1.ListDatabasesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDatabases"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.biglake.v1.ListDatabasesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.biglake.v1.ListDatabasesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetastoreServiceMethodDescriptorSupplier("ListDatabases"))
                      .build();
        }
      }
    }
    return getListDatabasesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.biglake.v1.CreateTableRequest,
          com.google.cloud.bigquery.biglake.v1.Table>
      getCreateTableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTable",
      requestType = com.google.cloud.bigquery.biglake.v1.CreateTableRequest.class,
      responseType = com.google.cloud.bigquery.biglake.v1.Table.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.biglake.v1.CreateTableRequest,
          com.google.cloud.bigquery.biglake.v1.Table>
      getCreateTableMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.biglake.v1.CreateTableRequest,
            com.google.cloud.bigquery.biglake.v1.Table>
        getCreateTableMethod;
    if ((getCreateTableMethod = MetastoreServiceGrpc.getCreateTableMethod) == null) {
      synchronized (MetastoreServiceGrpc.class) {
        if ((getCreateTableMethod = MetastoreServiceGrpc.getCreateTableMethod) == null) {
          MetastoreServiceGrpc.getCreateTableMethod =
              getCreateTableMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.biglake.v1.CreateTableRequest,
                          com.google.cloud.bigquery.biglake.v1.Table>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTable"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.biglake.v1.CreateTableRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.biglake.v1.Table.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetastoreServiceMethodDescriptorSupplier("CreateTable"))
                      .build();
        }
      }
    }
    return getCreateTableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.biglake.v1.DeleteTableRequest,
          com.google.cloud.bigquery.biglake.v1.Table>
      getDeleteTableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTable",
      requestType = com.google.cloud.bigquery.biglake.v1.DeleteTableRequest.class,
      responseType = com.google.cloud.bigquery.biglake.v1.Table.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.biglake.v1.DeleteTableRequest,
          com.google.cloud.bigquery.biglake.v1.Table>
      getDeleteTableMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.biglake.v1.DeleteTableRequest,
            com.google.cloud.bigquery.biglake.v1.Table>
        getDeleteTableMethod;
    if ((getDeleteTableMethod = MetastoreServiceGrpc.getDeleteTableMethod) == null) {
      synchronized (MetastoreServiceGrpc.class) {
        if ((getDeleteTableMethod = MetastoreServiceGrpc.getDeleteTableMethod) == null) {
          MetastoreServiceGrpc.getDeleteTableMethod =
              getDeleteTableMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.biglake.v1.DeleteTableRequest,
                          com.google.cloud.bigquery.biglake.v1.Table>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTable"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.biglake.v1.DeleteTableRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.biglake.v1.Table.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetastoreServiceMethodDescriptorSupplier("DeleteTable"))
                      .build();
        }
      }
    }
    return getDeleteTableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.biglake.v1.UpdateTableRequest,
          com.google.cloud.bigquery.biglake.v1.Table>
      getUpdateTableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTable",
      requestType = com.google.cloud.bigquery.biglake.v1.UpdateTableRequest.class,
      responseType = com.google.cloud.bigquery.biglake.v1.Table.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.biglake.v1.UpdateTableRequest,
          com.google.cloud.bigquery.biglake.v1.Table>
      getUpdateTableMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.biglake.v1.UpdateTableRequest,
            com.google.cloud.bigquery.biglake.v1.Table>
        getUpdateTableMethod;
    if ((getUpdateTableMethod = MetastoreServiceGrpc.getUpdateTableMethod) == null) {
      synchronized (MetastoreServiceGrpc.class) {
        if ((getUpdateTableMethod = MetastoreServiceGrpc.getUpdateTableMethod) == null) {
          MetastoreServiceGrpc.getUpdateTableMethod =
              getUpdateTableMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.biglake.v1.UpdateTableRequest,
                          com.google.cloud.bigquery.biglake.v1.Table>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTable"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.biglake.v1.UpdateTableRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.biglake.v1.Table.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetastoreServiceMethodDescriptorSupplier("UpdateTable"))
                      .build();
        }
      }
    }
    return getUpdateTableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.biglake.v1.RenameTableRequest,
          com.google.cloud.bigquery.biglake.v1.Table>
      getRenameTableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RenameTable",
      requestType = com.google.cloud.bigquery.biglake.v1.RenameTableRequest.class,
      responseType = com.google.cloud.bigquery.biglake.v1.Table.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.biglake.v1.RenameTableRequest,
          com.google.cloud.bigquery.biglake.v1.Table>
      getRenameTableMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.biglake.v1.RenameTableRequest,
            com.google.cloud.bigquery.biglake.v1.Table>
        getRenameTableMethod;
    if ((getRenameTableMethod = MetastoreServiceGrpc.getRenameTableMethod) == null) {
      synchronized (MetastoreServiceGrpc.class) {
        if ((getRenameTableMethod = MetastoreServiceGrpc.getRenameTableMethod) == null) {
          MetastoreServiceGrpc.getRenameTableMethod =
              getRenameTableMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.biglake.v1.RenameTableRequest,
                          com.google.cloud.bigquery.biglake.v1.Table>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RenameTable"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.biglake.v1.RenameTableRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.biglake.v1.Table.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetastoreServiceMethodDescriptorSupplier("RenameTable"))
                      .build();
        }
      }
    }
    return getRenameTableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.biglake.v1.GetTableRequest,
          com.google.cloud.bigquery.biglake.v1.Table>
      getGetTableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTable",
      requestType = com.google.cloud.bigquery.biglake.v1.GetTableRequest.class,
      responseType = com.google.cloud.bigquery.biglake.v1.Table.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.biglake.v1.GetTableRequest,
          com.google.cloud.bigquery.biglake.v1.Table>
      getGetTableMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.biglake.v1.GetTableRequest,
            com.google.cloud.bigquery.biglake.v1.Table>
        getGetTableMethod;
    if ((getGetTableMethod = MetastoreServiceGrpc.getGetTableMethod) == null) {
      synchronized (MetastoreServiceGrpc.class) {
        if ((getGetTableMethod = MetastoreServiceGrpc.getGetTableMethod) == null) {
          MetastoreServiceGrpc.getGetTableMethod =
              getGetTableMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.biglake.v1.GetTableRequest,
                          com.google.cloud.bigquery.biglake.v1.Table>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTable"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.biglake.v1.GetTableRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.biglake.v1.Table.getDefaultInstance()))
                      .setSchemaDescriptor(new MetastoreServiceMethodDescriptorSupplier("GetTable"))
                      .build();
        }
      }
    }
    return getGetTableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.biglake.v1.ListTablesRequest,
          com.google.cloud.bigquery.biglake.v1.ListTablesResponse>
      getListTablesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTables",
      requestType = com.google.cloud.bigquery.biglake.v1.ListTablesRequest.class,
      responseType = com.google.cloud.bigquery.biglake.v1.ListTablesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.biglake.v1.ListTablesRequest,
          com.google.cloud.bigquery.biglake.v1.ListTablesResponse>
      getListTablesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.biglake.v1.ListTablesRequest,
            com.google.cloud.bigquery.biglake.v1.ListTablesResponse>
        getListTablesMethod;
    if ((getListTablesMethod = MetastoreServiceGrpc.getListTablesMethod) == null) {
      synchronized (MetastoreServiceGrpc.class) {
        if ((getListTablesMethod = MetastoreServiceGrpc.getListTablesMethod) == null) {
          MetastoreServiceGrpc.getListTablesMethod =
              getListTablesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.biglake.v1.ListTablesRequest,
                          com.google.cloud.bigquery.biglake.v1.ListTablesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTables"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.biglake.v1.ListTablesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.biglake.v1.ListTablesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MetastoreServiceMethodDescriptorSupplier("ListTables"))
                      .build();
        }
      }
    }
    return getListTablesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static MetastoreServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MetastoreServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MetastoreServiceStub>() {
          @java.lang.Override
          public MetastoreServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MetastoreServiceStub(channel, callOptions);
          }
        };
    return MetastoreServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MetastoreServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MetastoreServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MetastoreServiceBlockingStub>() {
          @java.lang.Override
          public MetastoreServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MetastoreServiceBlockingStub(channel, callOptions);
          }
        };
    return MetastoreServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static MetastoreServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MetastoreServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MetastoreServiceFutureStub>() {
          @java.lang.Override
          public MetastoreServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MetastoreServiceFutureStub(channel, callOptions);
          }
        };
    return MetastoreServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * BigLake Metastore is a serverless, highly available, multi-tenant runtime
   * metastore for Google Cloud Data Analytics products.
   * The BigLake Metastore API defines the following resource model:
   * * A collection of Google Cloud projects: `/projects/&#42;`
   * * Each project has a collection of available locations: `/locations/&#42;`
   * * Each location has a collection of catalogs: `/catalogs/&#42;`
   * * Each catalog has a collection of databases: `/databases/&#42;`
   * * Each database has a collection of tables: `/tables/&#42;`
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a new catalog.
     * </pre>
     */
    default void createCatalog(
        com.google.cloud.bigquery.biglake.v1.CreateCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.Catalog>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateCatalogMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing catalog specified by the catalog ID.
     * </pre>
     */
    default void deleteCatalog(
        com.google.cloud.bigquery.biglake.v1.DeleteCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.Catalog>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteCatalogMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the catalog specified by the resource name.
     * </pre>
     */
    default void getCatalog(
        com.google.cloud.bigquery.biglake.v1.GetCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.Catalog>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCatalogMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all catalogs in a specified project.
     * </pre>
     */
    default void listCatalogs(
        com.google.cloud.bigquery.biglake.v1.ListCatalogsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.ListCatalogsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCatalogsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new database.
     * </pre>
     */
    default void createDatabase(
        com.google.cloud.bigquery.biglake.v1.CreateDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.Database>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDatabaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing database specified by the database ID.
     * </pre>
     */
    default void deleteDatabase(
        com.google.cloud.bigquery.biglake.v1.DeleteDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.Database>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDatabaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing database specified by the database ID.
     * </pre>
     */
    default void updateDatabase(
        com.google.cloud.bigquery.biglake.v1.UpdateDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.Database>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDatabaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the database specified by the resource name.
     * </pre>
     */
    default void getDatabase(
        com.google.cloud.bigquery.biglake.v1.GetDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.Database>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDatabaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all databases in a specified catalog.
     * </pre>
     */
    default void listDatabases(
        com.google.cloud.bigquery.biglake.v1.ListDatabasesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.ListDatabasesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDatabasesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new table.
     * </pre>
     */
    default void createTable(
        com.google.cloud.bigquery.biglake.v1.CreateTableRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.Table> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateTableMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing table specified by the table ID.
     * </pre>
     */
    default void deleteTable(
        com.google.cloud.bigquery.biglake.v1.DeleteTableRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.Table> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteTableMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing table specified by the table ID.
     * </pre>
     */
    default void updateTable(
        com.google.cloud.bigquery.biglake.v1.UpdateTableRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.Table> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateTableMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Renames an existing table specified by the table ID.
     * </pre>
     */
    default void renameTable(
        com.google.cloud.bigquery.biglake.v1.RenameTableRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.Table> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRenameTableMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the table specified by the resource name.
     * </pre>
     */
    default void getTable(
        com.google.cloud.bigquery.biglake.v1.GetTableRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.Table> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTableMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all tables in a specified database.
     * </pre>
     */
    default void listTables(
        com.google.cloud.bigquery.biglake.v1.ListTablesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.ListTablesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListTablesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service MetastoreService.
   *
   * <pre>
   * BigLake Metastore is a serverless, highly available, multi-tenant runtime
   * metastore for Google Cloud Data Analytics products.
   * The BigLake Metastore API defines the following resource model:
   * * A collection of Google Cloud projects: `/projects/&#42;`
   * * Each project has a collection of available locations: `/locations/&#42;`
   * * Each location has a collection of catalogs: `/catalogs/&#42;`
   * * Each catalog has a collection of databases: `/databases/&#42;`
   * * Each database has a collection of tables: `/tables/&#42;`
   * </pre>
   */
  public abstract static class MetastoreServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return MetastoreServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service MetastoreService.
   *
   * <pre>
   * BigLake Metastore is a serverless, highly available, multi-tenant runtime
   * metastore for Google Cloud Data Analytics products.
   * The BigLake Metastore API defines the following resource model:
   * * A collection of Google Cloud projects: `/projects/&#42;`
   * * Each project has a collection of available locations: `/locations/&#42;`
   * * Each location has a collection of catalogs: `/catalogs/&#42;`
   * * Each catalog has a collection of databases: `/databases/&#42;`
   * * Each database has a collection of tables: `/tables/&#42;`
   * </pre>
   */
  public static final class MetastoreServiceStub
      extends io.grpc.stub.AbstractAsyncStub<MetastoreServiceStub> {
    private MetastoreServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MetastoreServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MetastoreServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new catalog.
     * </pre>
     */
    public void createCatalog(
        com.google.cloud.bigquery.biglake.v1.CreateCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.Catalog>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCatalogMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing catalog specified by the catalog ID.
     * </pre>
     */
    public void deleteCatalog(
        com.google.cloud.bigquery.biglake.v1.DeleteCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.Catalog>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCatalogMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the catalog specified by the resource name.
     * </pre>
     */
    public void getCatalog(
        com.google.cloud.bigquery.biglake.v1.GetCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.Catalog>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCatalogMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all catalogs in a specified project.
     * </pre>
     */
    public void listCatalogs(
        com.google.cloud.bigquery.biglake.v1.ListCatalogsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.ListCatalogsResponse>
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
     * Creates a new database.
     * </pre>
     */
    public void createDatabase(
        com.google.cloud.bigquery.biglake.v1.CreateDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.Database>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDatabaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing database specified by the database ID.
     * </pre>
     */
    public void deleteDatabase(
        com.google.cloud.bigquery.biglake.v1.DeleteDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.Database>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDatabaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing database specified by the database ID.
     * </pre>
     */
    public void updateDatabase(
        com.google.cloud.bigquery.biglake.v1.UpdateDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.Database>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDatabaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the database specified by the resource name.
     * </pre>
     */
    public void getDatabase(
        com.google.cloud.bigquery.biglake.v1.GetDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.Database>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDatabaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all databases in a specified catalog.
     * </pre>
     */
    public void listDatabases(
        com.google.cloud.bigquery.biglake.v1.ListDatabasesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.ListDatabasesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDatabasesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new table.
     * </pre>
     */
    public void createTable(
        com.google.cloud.bigquery.biglake.v1.CreateTableRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.Table> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTableMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing table specified by the table ID.
     * </pre>
     */
    public void deleteTable(
        com.google.cloud.bigquery.biglake.v1.DeleteTableRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.Table> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTableMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing table specified by the table ID.
     * </pre>
     */
    public void updateTable(
        com.google.cloud.bigquery.biglake.v1.UpdateTableRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.Table> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTableMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Renames an existing table specified by the table ID.
     * </pre>
     */
    public void renameTable(
        com.google.cloud.bigquery.biglake.v1.RenameTableRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.Table> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRenameTableMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the table specified by the resource name.
     * </pre>
     */
    public void getTable(
        com.google.cloud.bigquery.biglake.v1.GetTableRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.Table> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTableMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all tables in a specified database.
     * </pre>
     */
    public void listTables(
        com.google.cloud.bigquery.biglake.v1.ListTablesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.ListTablesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTablesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service MetastoreService.
   *
   * <pre>
   * BigLake Metastore is a serverless, highly available, multi-tenant runtime
   * metastore for Google Cloud Data Analytics products.
   * The BigLake Metastore API defines the following resource model:
   * * A collection of Google Cloud projects: `/projects/&#42;`
   * * Each project has a collection of available locations: `/locations/&#42;`
   * * Each location has a collection of catalogs: `/catalogs/&#42;`
   * * Each catalog has a collection of databases: `/databases/&#42;`
   * * Each database has a collection of tables: `/tables/&#42;`
   * </pre>
   */
  public static final class MetastoreServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MetastoreServiceBlockingStub> {
    private MetastoreServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MetastoreServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MetastoreServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new catalog.
     * </pre>
     */
    public com.google.cloud.bigquery.biglake.v1.Catalog createCatalog(
        com.google.cloud.bigquery.biglake.v1.CreateCatalogRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCatalogMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing catalog specified by the catalog ID.
     * </pre>
     */
    public com.google.cloud.bigquery.biglake.v1.Catalog deleteCatalog(
        com.google.cloud.bigquery.biglake.v1.DeleteCatalogRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCatalogMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the catalog specified by the resource name.
     * </pre>
     */
    public com.google.cloud.bigquery.biglake.v1.Catalog getCatalog(
        com.google.cloud.bigquery.biglake.v1.GetCatalogRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCatalogMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all catalogs in a specified project.
     * </pre>
     */
    public com.google.cloud.bigquery.biglake.v1.ListCatalogsResponse listCatalogs(
        com.google.cloud.bigquery.biglake.v1.ListCatalogsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCatalogsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new database.
     * </pre>
     */
    public com.google.cloud.bigquery.biglake.v1.Database createDatabase(
        com.google.cloud.bigquery.biglake.v1.CreateDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing database specified by the database ID.
     * </pre>
     */
    public com.google.cloud.bigquery.biglake.v1.Database deleteDatabase(
        com.google.cloud.bigquery.biglake.v1.DeleteDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing database specified by the database ID.
     * </pre>
     */
    public com.google.cloud.bigquery.biglake.v1.Database updateDatabase(
        com.google.cloud.bigquery.biglake.v1.UpdateDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the database specified by the resource name.
     * </pre>
     */
    public com.google.cloud.bigquery.biglake.v1.Database getDatabase(
        com.google.cloud.bigquery.biglake.v1.GetDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all databases in a specified catalog.
     * </pre>
     */
    public com.google.cloud.bigquery.biglake.v1.ListDatabasesResponse listDatabases(
        com.google.cloud.bigquery.biglake.v1.ListDatabasesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDatabasesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new table.
     * </pre>
     */
    public com.google.cloud.bigquery.biglake.v1.Table createTable(
        com.google.cloud.bigquery.biglake.v1.CreateTableRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTableMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing table specified by the table ID.
     * </pre>
     */
    public com.google.cloud.bigquery.biglake.v1.Table deleteTable(
        com.google.cloud.bigquery.biglake.v1.DeleteTableRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTableMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing table specified by the table ID.
     * </pre>
     */
    public com.google.cloud.bigquery.biglake.v1.Table updateTable(
        com.google.cloud.bigquery.biglake.v1.UpdateTableRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTableMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Renames an existing table specified by the table ID.
     * </pre>
     */
    public com.google.cloud.bigquery.biglake.v1.Table renameTable(
        com.google.cloud.bigquery.biglake.v1.RenameTableRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRenameTableMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the table specified by the resource name.
     * </pre>
     */
    public com.google.cloud.bigquery.biglake.v1.Table getTable(
        com.google.cloud.bigquery.biglake.v1.GetTableRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTableMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all tables in a specified database.
     * </pre>
     */
    public com.google.cloud.bigquery.biglake.v1.ListTablesResponse listTables(
        com.google.cloud.bigquery.biglake.v1.ListTablesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTablesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service MetastoreService.
   *
   * <pre>
   * BigLake Metastore is a serverless, highly available, multi-tenant runtime
   * metastore for Google Cloud Data Analytics products.
   * The BigLake Metastore API defines the following resource model:
   * * A collection of Google Cloud projects: `/projects/&#42;`
   * * Each project has a collection of available locations: `/locations/&#42;`
   * * Each location has a collection of catalogs: `/catalogs/&#42;`
   * * Each catalog has a collection of databases: `/databases/&#42;`
   * * Each database has a collection of tables: `/tables/&#42;`
   * </pre>
   */
  public static final class MetastoreServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<MetastoreServiceFutureStub> {
    private MetastoreServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MetastoreServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MetastoreServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new catalog.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.biglake.v1.Catalog>
        createCatalog(com.google.cloud.bigquery.biglake.v1.CreateCatalogRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCatalogMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing catalog specified by the catalog ID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.biglake.v1.Catalog>
        deleteCatalog(com.google.cloud.bigquery.biglake.v1.DeleteCatalogRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCatalogMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the catalog specified by the resource name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.biglake.v1.Catalog>
        getCatalog(com.google.cloud.bigquery.biglake.v1.GetCatalogRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCatalogMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List all catalogs in a specified project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.biglake.v1.ListCatalogsResponse>
        listCatalogs(com.google.cloud.bigquery.biglake.v1.ListCatalogsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCatalogsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new database.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.biglake.v1.Database>
        createDatabase(com.google.cloud.bigquery.biglake.v1.CreateDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDatabaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing database specified by the database ID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.biglake.v1.Database>
        deleteDatabase(com.google.cloud.bigquery.biglake.v1.DeleteDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDatabaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing database specified by the database ID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.biglake.v1.Database>
        updateDatabase(com.google.cloud.bigquery.biglake.v1.UpdateDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDatabaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the database specified by the resource name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.biglake.v1.Database>
        getDatabase(com.google.cloud.bigquery.biglake.v1.GetDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDatabaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List all databases in a specified catalog.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.biglake.v1.ListDatabasesResponse>
        listDatabases(com.google.cloud.bigquery.biglake.v1.ListDatabasesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDatabasesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new table.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.biglake.v1.Table>
        createTable(com.google.cloud.bigquery.biglake.v1.CreateTableRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTableMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing table specified by the table ID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.biglake.v1.Table>
        deleteTable(com.google.cloud.bigquery.biglake.v1.DeleteTableRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTableMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing table specified by the table ID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.biglake.v1.Table>
        updateTable(com.google.cloud.bigquery.biglake.v1.UpdateTableRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTableMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Renames an existing table specified by the table ID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.biglake.v1.Table>
        renameTable(com.google.cloud.bigquery.biglake.v1.RenameTableRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRenameTableMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the table specified by the resource name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.biglake.v1.Table>
        getTable(com.google.cloud.bigquery.biglake.v1.GetTableRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTableMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List all tables in a specified database.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.biglake.v1.ListTablesResponse>
        listTables(com.google.cloud.bigquery.biglake.v1.ListTablesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTablesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_CATALOG = 0;
  private static final int METHODID_DELETE_CATALOG = 1;
  private static final int METHODID_GET_CATALOG = 2;
  private static final int METHODID_LIST_CATALOGS = 3;
  private static final int METHODID_CREATE_DATABASE = 4;
  private static final int METHODID_DELETE_DATABASE = 5;
  private static final int METHODID_UPDATE_DATABASE = 6;
  private static final int METHODID_GET_DATABASE = 7;
  private static final int METHODID_LIST_DATABASES = 8;
  private static final int METHODID_CREATE_TABLE = 9;
  private static final int METHODID_DELETE_TABLE = 10;
  private static final int METHODID_UPDATE_TABLE = 11;
  private static final int METHODID_RENAME_TABLE = 12;
  private static final int METHODID_GET_TABLE = 13;
  private static final int METHODID_LIST_TABLES = 14;

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
        case METHODID_CREATE_CATALOG:
          serviceImpl.createCatalog(
              (com.google.cloud.bigquery.biglake.v1.CreateCatalogRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.Catalog>)
                  responseObserver);
          break;
        case METHODID_DELETE_CATALOG:
          serviceImpl.deleteCatalog(
              (com.google.cloud.bigquery.biglake.v1.DeleteCatalogRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.Catalog>)
                  responseObserver);
          break;
        case METHODID_GET_CATALOG:
          serviceImpl.getCatalog(
              (com.google.cloud.bigquery.biglake.v1.GetCatalogRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.Catalog>)
                  responseObserver);
          break;
        case METHODID_LIST_CATALOGS:
          serviceImpl.listCatalogs(
              (com.google.cloud.bigquery.biglake.v1.ListCatalogsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.biglake.v1.ListCatalogsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_DATABASE:
          serviceImpl.createDatabase(
              (com.google.cloud.bigquery.biglake.v1.CreateDatabaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.Database>)
                  responseObserver);
          break;
        case METHODID_DELETE_DATABASE:
          serviceImpl.deleteDatabase(
              (com.google.cloud.bigquery.biglake.v1.DeleteDatabaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.Database>)
                  responseObserver);
          break;
        case METHODID_UPDATE_DATABASE:
          serviceImpl.updateDatabase(
              (com.google.cloud.bigquery.biglake.v1.UpdateDatabaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.Database>)
                  responseObserver);
          break;
        case METHODID_GET_DATABASE:
          serviceImpl.getDatabase(
              (com.google.cloud.bigquery.biglake.v1.GetDatabaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.Database>)
                  responseObserver);
          break;
        case METHODID_LIST_DATABASES:
          serviceImpl.listDatabases(
              (com.google.cloud.bigquery.biglake.v1.ListDatabasesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.biglake.v1.ListDatabasesResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_TABLE:
          serviceImpl.createTable(
              (com.google.cloud.bigquery.biglake.v1.CreateTableRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.Table>)
                  responseObserver);
          break;
        case METHODID_DELETE_TABLE:
          serviceImpl.deleteTable(
              (com.google.cloud.bigquery.biglake.v1.DeleteTableRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.Table>)
                  responseObserver);
          break;
        case METHODID_UPDATE_TABLE:
          serviceImpl.updateTable(
              (com.google.cloud.bigquery.biglake.v1.UpdateTableRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.Table>)
                  responseObserver);
          break;
        case METHODID_RENAME_TABLE:
          serviceImpl.renameTable(
              (com.google.cloud.bigquery.biglake.v1.RenameTableRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.Table>)
                  responseObserver);
          break;
        case METHODID_GET_TABLE:
          serviceImpl.getTable(
              (com.google.cloud.bigquery.biglake.v1.GetTableRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.Table>)
                  responseObserver);
          break;
        case METHODID_LIST_TABLES:
          serviceImpl.listTables(
              (com.google.cloud.bigquery.biglake.v1.ListTablesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1.ListTablesResponse>)
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
            getCreateCatalogMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.biglake.v1.CreateCatalogRequest,
                    com.google.cloud.bigquery.biglake.v1.Catalog>(
                    service, METHODID_CREATE_CATALOG)))
        .addMethod(
            getDeleteCatalogMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.biglake.v1.DeleteCatalogRequest,
                    com.google.cloud.bigquery.biglake.v1.Catalog>(
                    service, METHODID_DELETE_CATALOG)))
        .addMethod(
            getGetCatalogMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.biglake.v1.GetCatalogRequest,
                    com.google.cloud.bigquery.biglake.v1.Catalog>(service, METHODID_GET_CATALOG)))
        .addMethod(
            getListCatalogsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.biglake.v1.ListCatalogsRequest,
                    com.google.cloud.bigquery.biglake.v1.ListCatalogsResponse>(
                    service, METHODID_LIST_CATALOGS)))
        .addMethod(
            getCreateDatabaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.biglake.v1.CreateDatabaseRequest,
                    com.google.cloud.bigquery.biglake.v1.Database>(
                    service, METHODID_CREATE_DATABASE)))
        .addMethod(
            getDeleteDatabaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.biglake.v1.DeleteDatabaseRequest,
                    com.google.cloud.bigquery.biglake.v1.Database>(
                    service, METHODID_DELETE_DATABASE)))
        .addMethod(
            getUpdateDatabaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.biglake.v1.UpdateDatabaseRequest,
                    com.google.cloud.bigquery.biglake.v1.Database>(
                    service, METHODID_UPDATE_DATABASE)))
        .addMethod(
            getGetDatabaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.biglake.v1.GetDatabaseRequest,
                    com.google.cloud.bigquery.biglake.v1.Database>(service, METHODID_GET_DATABASE)))
        .addMethod(
            getListDatabasesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.biglake.v1.ListDatabasesRequest,
                    com.google.cloud.bigquery.biglake.v1.ListDatabasesResponse>(
                    service, METHODID_LIST_DATABASES)))
        .addMethod(
            getCreateTableMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.biglake.v1.CreateTableRequest,
                    com.google.cloud.bigquery.biglake.v1.Table>(service, METHODID_CREATE_TABLE)))
        .addMethod(
            getDeleteTableMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.biglake.v1.DeleteTableRequest,
                    com.google.cloud.bigquery.biglake.v1.Table>(service, METHODID_DELETE_TABLE)))
        .addMethod(
            getUpdateTableMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.biglake.v1.UpdateTableRequest,
                    com.google.cloud.bigquery.biglake.v1.Table>(service, METHODID_UPDATE_TABLE)))
        .addMethod(
            getRenameTableMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.biglake.v1.RenameTableRequest,
                    com.google.cloud.bigquery.biglake.v1.Table>(service, METHODID_RENAME_TABLE)))
        .addMethod(
            getGetTableMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.biglake.v1.GetTableRequest,
                    com.google.cloud.bigquery.biglake.v1.Table>(service, METHODID_GET_TABLE)))
        .addMethod(
            getListTablesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.biglake.v1.ListTablesRequest,
                    com.google.cloud.bigquery.biglake.v1.ListTablesResponse>(
                    service, METHODID_LIST_TABLES)))
        .build();
  }

  private abstract static class MetastoreServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MetastoreServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.bigquery.biglake.v1.MetastoreProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MetastoreService");
    }
  }

  private static final class MetastoreServiceFileDescriptorSupplier
      extends MetastoreServiceBaseDescriptorSupplier {
    MetastoreServiceFileDescriptorSupplier() {}
  }

  private static final class MetastoreServiceMethodDescriptorSupplier
      extends MetastoreServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    MetastoreServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (MetastoreServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new MetastoreServiceFileDescriptorSupplier())
                      .addMethod(getCreateCatalogMethod())
                      .addMethod(getDeleteCatalogMethod())
                      .addMethod(getGetCatalogMethod())
                      .addMethod(getListCatalogsMethod())
                      .addMethod(getCreateDatabaseMethod())
                      .addMethod(getDeleteDatabaseMethod())
                      .addMethod(getUpdateDatabaseMethod())
                      .addMethod(getGetDatabaseMethod())
                      .addMethod(getListDatabasesMethod())
                      .addMethod(getCreateTableMethod())
                      .addMethod(getDeleteTableMethod())
                      .addMethod(getUpdateTableMethod())
                      .addMethod(getRenameTableMethod())
                      .addMethod(getGetTableMethod())
                      .addMethod(getListTablesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
