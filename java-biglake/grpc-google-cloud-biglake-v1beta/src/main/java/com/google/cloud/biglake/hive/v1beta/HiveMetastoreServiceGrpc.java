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
package com.google.cloud.biglake.hive.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Hive Metastore Service is a biglake service that allows users to manage
 * their external Hive catalogs. Full API compatibility with OSS Hive Metastore
 * APIs is not supported. The methods match the Hive Metastore API spec mostly
 * except for a few exceptions.
 * These include listing resources with pattern,
 * environment context which are combined in a single List API, return of
 * ListResponse object instead of a list of resources, transactions, locks, etc.
 * The BigLake Hive Metastore API defines the following resources:
 * * A collection of Google Cloud projects: `/projects/&#42;`
 * * Each project has a collection of catalogs: `/catalogs/&#42;`
 * * Each catalog has a collection of databases: `/databases/&#42;`
 * * Each database has a collection of tables: `/tables/&#42;`
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class HiveMetastoreServiceGrpc {

  private HiveMetastoreServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.biglake.hive.v1beta.HiveMetastoreService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.hive.v1beta.CreateHiveCatalogRequest,
          com.google.cloud.biglake.hive.v1beta.HiveCatalog>
      getCreateHiveCatalogMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateHiveCatalog",
      requestType = com.google.cloud.biglake.hive.v1beta.CreateHiveCatalogRequest.class,
      responseType = com.google.cloud.biglake.hive.v1beta.HiveCatalog.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.hive.v1beta.CreateHiveCatalogRequest,
          com.google.cloud.biglake.hive.v1beta.HiveCatalog>
      getCreateHiveCatalogMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.hive.v1beta.CreateHiveCatalogRequest,
            com.google.cloud.biglake.hive.v1beta.HiveCatalog>
        getCreateHiveCatalogMethod;
    if ((getCreateHiveCatalogMethod = HiveMetastoreServiceGrpc.getCreateHiveCatalogMethod)
        == null) {
      synchronized (HiveMetastoreServiceGrpc.class) {
        if ((getCreateHiveCatalogMethod = HiveMetastoreServiceGrpc.getCreateHiveCatalogMethod)
            == null) {
          HiveMetastoreServiceGrpc.getCreateHiveCatalogMethod =
              getCreateHiveCatalogMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.hive.v1beta.CreateHiveCatalogRequest,
                          com.google.cloud.biglake.hive.v1beta.HiveCatalog>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateHiveCatalog"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.hive.v1beta.CreateHiveCatalogRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.hive.v1beta.HiveCatalog
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HiveMetastoreServiceMethodDescriptorSupplier("CreateHiveCatalog"))
                      .build();
        }
      }
    }
    return getCreateHiveCatalogMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.hive.v1beta.GetHiveCatalogRequest,
          com.google.cloud.biglake.hive.v1beta.HiveCatalog>
      getGetHiveCatalogMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetHiveCatalog",
      requestType = com.google.cloud.biglake.hive.v1beta.GetHiveCatalogRequest.class,
      responseType = com.google.cloud.biglake.hive.v1beta.HiveCatalog.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.hive.v1beta.GetHiveCatalogRequest,
          com.google.cloud.biglake.hive.v1beta.HiveCatalog>
      getGetHiveCatalogMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.hive.v1beta.GetHiveCatalogRequest,
            com.google.cloud.biglake.hive.v1beta.HiveCatalog>
        getGetHiveCatalogMethod;
    if ((getGetHiveCatalogMethod = HiveMetastoreServiceGrpc.getGetHiveCatalogMethod) == null) {
      synchronized (HiveMetastoreServiceGrpc.class) {
        if ((getGetHiveCatalogMethod = HiveMetastoreServiceGrpc.getGetHiveCatalogMethod) == null) {
          HiveMetastoreServiceGrpc.getGetHiveCatalogMethod =
              getGetHiveCatalogMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.hive.v1beta.GetHiveCatalogRequest,
                          com.google.cloud.biglake.hive.v1beta.HiveCatalog>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetHiveCatalog"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.hive.v1beta.GetHiveCatalogRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.hive.v1beta.HiveCatalog
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HiveMetastoreServiceMethodDescriptorSupplier("GetHiveCatalog"))
                      .build();
        }
      }
    }
    return getGetHiveCatalogMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.hive.v1beta.ListHiveCatalogsRequest,
          com.google.cloud.biglake.hive.v1beta.ListHiveCatalogsResponse>
      getListHiveCatalogsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListHiveCatalogs",
      requestType = com.google.cloud.biglake.hive.v1beta.ListHiveCatalogsRequest.class,
      responseType = com.google.cloud.biglake.hive.v1beta.ListHiveCatalogsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.hive.v1beta.ListHiveCatalogsRequest,
          com.google.cloud.biglake.hive.v1beta.ListHiveCatalogsResponse>
      getListHiveCatalogsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.hive.v1beta.ListHiveCatalogsRequest,
            com.google.cloud.biglake.hive.v1beta.ListHiveCatalogsResponse>
        getListHiveCatalogsMethod;
    if ((getListHiveCatalogsMethod = HiveMetastoreServiceGrpc.getListHiveCatalogsMethod) == null) {
      synchronized (HiveMetastoreServiceGrpc.class) {
        if ((getListHiveCatalogsMethod = HiveMetastoreServiceGrpc.getListHiveCatalogsMethod)
            == null) {
          HiveMetastoreServiceGrpc.getListHiveCatalogsMethod =
              getListHiveCatalogsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.hive.v1beta.ListHiveCatalogsRequest,
                          com.google.cloud.biglake.hive.v1beta.ListHiveCatalogsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListHiveCatalogs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.hive.v1beta.ListHiveCatalogsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.hive.v1beta.ListHiveCatalogsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HiveMetastoreServiceMethodDescriptorSupplier("ListHiveCatalogs"))
                      .build();
        }
      }
    }
    return getListHiveCatalogsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.hive.v1beta.UpdateHiveCatalogRequest,
          com.google.cloud.biglake.hive.v1beta.HiveCatalog>
      getUpdateHiveCatalogMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateHiveCatalog",
      requestType = com.google.cloud.biglake.hive.v1beta.UpdateHiveCatalogRequest.class,
      responseType = com.google.cloud.biglake.hive.v1beta.HiveCatalog.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.hive.v1beta.UpdateHiveCatalogRequest,
          com.google.cloud.biglake.hive.v1beta.HiveCatalog>
      getUpdateHiveCatalogMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.hive.v1beta.UpdateHiveCatalogRequest,
            com.google.cloud.biglake.hive.v1beta.HiveCatalog>
        getUpdateHiveCatalogMethod;
    if ((getUpdateHiveCatalogMethod = HiveMetastoreServiceGrpc.getUpdateHiveCatalogMethod)
        == null) {
      synchronized (HiveMetastoreServiceGrpc.class) {
        if ((getUpdateHiveCatalogMethod = HiveMetastoreServiceGrpc.getUpdateHiveCatalogMethod)
            == null) {
          HiveMetastoreServiceGrpc.getUpdateHiveCatalogMethod =
              getUpdateHiveCatalogMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.hive.v1beta.UpdateHiveCatalogRequest,
                          com.google.cloud.biglake.hive.v1beta.HiveCatalog>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateHiveCatalog"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.hive.v1beta.UpdateHiveCatalogRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.hive.v1beta.HiveCatalog
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HiveMetastoreServiceMethodDescriptorSupplier("UpdateHiveCatalog"))
                      .build();
        }
      }
    }
    return getUpdateHiveCatalogMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.hive.v1beta.DeleteHiveCatalogRequest, com.google.protobuf.Empty>
      getDeleteHiveCatalogMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteHiveCatalog",
      requestType = com.google.cloud.biglake.hive.v1beta.DeleteHiveCatalogRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.hive.v1beta.DeleteHiveCatalogRequest, com.google.protobuf.Empty>
      getDeleteHiveCatalogMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.hive.v1beta.DeleteHiveCatalogRequest,
            com.google.protobuf.Empty>
        getDeleteHiveCatalogMethod;
    if ((getDeleteHiveCatalogMethod = HiveMetastoreServiceGrpc.getDeleteHiveCatalogMethod)
        == null) {
      synchronized (HiveMetastoreServiceGrpc.class) {
        if ((getDeleteHiveCatalogMethod = HiveMetastoreServiceGrpc.getDeleteHiveCatalogMethod)
            == null) {
          HiveMetastoreServiceGrpc.getDeleteHiveCatalogMethod =
              getDeleteHiveCatalogMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.hive.v1beta.DeleteHiveCatalogRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteHiveCatalog"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.hive.v1beta.DeleteHiveCatalogRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HiveMetastoreServiceMethodDescriptorSupplier("DeleteHiveCatalog"))
                      .build();
        }
      }
    }
    return getDeleteHiveCatalogMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.hive.v1beta.CreateHiveDatabaseRequest,
          com.google.cloud.biglake.hive.v1beta.HiveDatabase>
      getCreateHiveDatabaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateHiveDatabase",
      requestType = com.google.cloud.biglake.hive.v1beta.CreateHiveDatabaseRequest.class,
      responseType = com.google.cloud.biglake.hive.v1beta.HiveDatabase.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.hive.v1beta.CreateHiveDatabaseRequest,
          com.google.cloud.biglake.hive.v1beta.HiveDatabase>
      getCreateHiveDatabaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.hive.v1beta.CreateHiveDatabaseRequest,
            com.google.cloud.biglake.hive.v1beta.HiveDatabase>
        getCreateHiveDatabaseMethod;
    if ((getCreateHiveDatabaseMethod = HiveMetastoreServiceGrpc.getCreateHiveDatabaseMethod)
        == null) {
      synchronized (HiveMetastoreServiceGrpc.class) {
        if ((getCreateHiveDatabaseMethod = HiveMetastoreServiceGrpc.getCreateHiveDatabaseMethod)
            == null) {
          HiveMetastoreServiceGrpc.getCreateHiveDatabaseMethod =
              getCreateHiveDatabaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.hive.v1beta.CreateHiveDatabaseRequest,
                          com.google.cloud.biglake.hive.v1beta.HiveDatabase>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateHiveDatabase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.hive.v1beta.CreateHiveDatabaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.hive.v1beta.HiveDatabase
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HiveMetastoreServiceMethodDescriptorSupplier("CreateHiveDatabase"))
                      .build();
        }
      }
    }
    return getCreateHiveDatabaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.hive.v1beta.GetHiveDatabaseRequest,
          com.google.cloud.biglake.hive.v1beta.HiveDatabase>
      getGetHiveDatabaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetHiveDatabase",
      requestType = com.google.cloud.biglake.hive.v1beta.GetHiveDatabaseRequest.class,
      responseType = com.google.cloud.biglake.hive.v1beta.HiveDatabase.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.hive.v1beta.GetHiveDatabaseRequest,
          com.google.cloud.biglake.hive.v1beta.HiveDatabase>
      getGetHiveDatabaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.hive.v1beta.GetHiveDatabaseRequest,
            com.google.cloud.biglake.hive.v1beta.HiveDatabase>
        getGetHiveDatabaseMethod;
    if ((getGetHiveDatabaseMethod = HiveMetastoreServiceGrpc.getGetHiveDatabaseMethod) == null) {
      synchronized (HiveMetastoreServiceGrpc.class) {
        if ((getGetHiveDatabaseMethod = HiveMetastoreServiceGrpc.getGetHiveDatabaseMethod)
            == null) {
          HiveMetastoreServiceGrpc.getGetHiveDatabaseMethod =
              getGetHiveDatabaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.hive.v1beta.GetHiveDatabaseRequest,
                          com.google.cloud.biglake.hive.v1beta.HiveDatabase>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetHiveDatabase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.hive.v1beta.GetHiveDatabaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.hive.v1beta.HiveDatabase
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HiveMetastoreServiceMethodDescriptorSupplier("GetHiveDatabase"))
                      .build();
        }
      }
    }
    return getGetHiveDatabaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.hive.v1beta.ListHiveDatabasesRequest,
          com.google.cloud.biglake.hive.v1beta.ListHiveDatabasesResponse>
      getListHiveDatabasesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListHiveDatabases",
      requestType = com.google.cloud.biglake.hive.v1beta.ListHiveDatabasesRequest.class,
      responseType = com.google.cloud.biglake.hive.v1beta.ListHiveDatabasesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.hive.v1beta.ListHiveDatabasesRequest,
          com.google.cloud.biglake.hive.v1beta.ListHiveDatabasesResponse>
      getListHiveDatabasesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.hive.v1beta.ListHiveDatabasesRequest,
            com.google.cloud.biglake.hive.v1beta.ListHiveDatabasesResponse>
        getListHiveDatabasesMethod;
    if ((getListHiveDatabasesMethod = HiveMetastoreServiceGrpc.getListHiveDatabasesMethod)
        == null) {
      synchronized (HiveMetastoreServiceGrpc.class) {
        if ((getListHiveDatabasesMethod = HiveMetastoreServiceGrpc.getListHiveDatabasesMethod)
            == null) {
          HiveMetastoreServiceGrpc.getListHiveDatabasesMethod =
              getListHiveDatabasesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.hive.v1beta.ListHiveDatabasesRequest,
                          com.google.cloud.biglake.hive.v1beta.ListHiveDatabasesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListHiveDatabases"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.hive.v1beta.ListHiveDatabasesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.hive.v1beta.ListHiveDatabasesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HiveMetastoreServiceMethodDescriptorSupplier("ListHiveDatabases"))
                      .build();
        }
      }
    }
    return getListHiveDatabasesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.hive.v1beta.UpdateHiveDatabaseRequest,
          com.google.cloud.biglake.hive.v1beta.HiveDatabase>
      getUpdateHiveDatabaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateHiveDatabase",
      requestType = com.google.cloud.biglake.hive.v1beta.UpdateHiveDatabaseRequest.class,
      responseType = com.google.cloud.biglake.hive.v1beta.HiveDatabase.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.hive.v1beta.UpdateHiveDatabaseRequest,
          com.google.cloud.biglake.hive.v1beta.HiveDatabase>
      getUpdateHiveDatabaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.hive.v1beta.UpdateHiveDatabaseRequest,
            com.google.cloud.biglake.hive.v1beta.HiveDatabase>
        getUpdateHiveDatabaseMethod;
    if ((getUpdateHiveDatabaseMethod = HiveMetastoreServiceGrpc.getUpdateHiveDatabaseMethod)
        == null) {
      synchronized (HiveMetastoreServiceGrpc.class) {
        if ((getUpdateHiveDatabaseMethod = HiveMetastoreServiceGrpc.getUpdateHiveDatabaseMethod)
            == null) {
          HiveMetastoreServiceGrpc.getUpdateHiveDatabaseMethod =
              getUpdateHiveDatabaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.hive.v1beta.UpdateHiveDatabaseRequest,
                          com.google.cloud.biglake.hive.v1beta.HiveDatabase>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateHiveDatabase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.hive.v1beta.UpdateHiveDatabaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.hive.v1beta.HiveDatabase
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HiveMetastoreServiceMethodDescriptorSupplier("UpdateHiveDatabase"))
                      .build();
        }
      }
    }
    return getUpdateHiveDatabaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.hive.v1beta.DeleteHiveDatabaseRequest, com.google.protobuf.Empty>
      getDeleteHiveDatabaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteHiveDatabase",
      requestType = com.google.cloud.biglake.hive.v1beta.DeleteHiveDatabaseRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.hive.v1beta.DeleteHiveDatabaseRequest, com.google.protobuf.Empty>
      getDeleteHiveDatabaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.hive.v1beta.DeleteHiveDatabaseRequest,
            com.google.protobuf.Empty>
        getDeleteHiveDatabaseMethod;
    if ((getDeleteHiveDatabaseMethod = HiveMetastoreServiceGrpc.getDeleteHiveDatabaseMethod)
        == null) {
      synchronized (HiveMetastoreServiceGrpc.class) {
        if ((getDeleteHiveDatabaseMethod = HiveMetastoreServiceGrpc.getDeleteHiveDatabaseMethod)
            == null) {
          HiveMetastoreServiceGrpc.getDeleteHiveDatabaseMethod =
              getDeleteHiveDatabaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.hive.v1beta.DeleteHiveDatabaseRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteHiveDatabase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.hive.v1beta.DeleteHiveDatabaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HiveMetastoreServiceMethodDescriptorSupplier("DeleteHiveDatabase"))
                      .build();
        }
      }
    }
    return getDeleteHiveDatabaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.hive.v1beta.CreateHiveTableRequest,
          com.google.cloud.biglake.hive.v1beta.HiveTable>
      getCreateHiveTableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateHiveTable",
      requestType = com.google.cloud.biglake.hive.v1beta.CreateHiveTableRequest.class,
      responseType = com.google.cloud.biglake.hive.v1beta.HiveTable.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.hive.v1beta.CreateHiveTableRequest,
          com.google.cloud.biglake.hive.v1beta.HiveTable>
      getCreateHiveTableMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.hive.v1beta.CreateHiveTableRequest,
            com.google.cloud.biglake.hive.v1beta.HiveTable>
        getCreateHiveTableMethod;
    if ((getCreateHiveTableMethod = HiveMetastoreServiceGrpc.getCreateHiveTableMethod) == null) {
      synchronized (HiveMetastoreServiceGrpc.class) {
        if ((getCreateHiveTableMethod = HiveMetastoreServiceGrpc.getCreateHiveTableMethod)
            == null) {
          HiveMetastoreServiceGrpc.getCreateHiveTableMethod =
              getCreateHiveTableMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.hive.v1beta.CreateHiveTableRequest,
                          com.google.cloud.biglake.hive.v1beta.HiveTable>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateHiveTable"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.hive.v1beta.CreateHiveTableRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.hive.v1beta.HiveTable.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HiveMetastoreServiceMethodDescriptorSupplier("CreateHiveTable"))
                      .build();
        }
      }
    }
    return getCreateHiveTableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.hive.v1beta.GetHiveTableRequest,
          com.google.cloud.biglake.hive.v1beta.HiveTable>
      getGetHiveTableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetHiveTable",
      requestType = com.google.cloud.biglake.hive.v1beta.GetHiveTableRequest.class,
      responseType = com.google.cloud.biglake.hive.v1beta.HiveTable.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.hive.v1beta.GetHiveTableRequest,
          com.google.cloud.biglake.hive.v1beta.HiveTable>
      getGetHiveTableMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.hive.v1beta.GetHiveTableRequest,
            com.google.cloud.biglake.hive.v1beta.HiveTable>
        getGetHiveTableMethod;
    if ((getGetHiveTableMethod = HiveMetastoreServiceGrpc.getGetHiveTableMethod) == null) {
      synchronized (HiveMetastoreServiceGrpc.class) {
        if ((getGetHiveTableMethod = HiveMetastoreServiceGrpc.getGetHiveTableMethod) == null) {
          HiveMetastoreServiceGrpc.getGetHiveTableMethod =
              getGetHiveTableMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.hive.v1beta.GetHiveTableRequest,
                          com.google.cloud.biglake.hive.v1beta.HiveTable>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetHiveTable"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.hive.v1beta.GetHiveTableRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.hive.v1beta.HiveTable.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HiveMetastoreServiceMethodDescriptorSupplier("GetHiveTable"))
                      .build();
        }
      }
    }
    return getGetHiveTableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.hive.v1beta.ListHiveTablesRequest,
          com.google.cloud.biglake.hive.v1beta.ListHiveTablesResponse>
      getListHiveTablesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListHiveTables",
      requestType = com.google.cloud.biglake.hive.v1beta.ListHiveTablesRequest.class,
      responseType = com.google.cloud.biglake.hive.v1beta.ListHiveTablesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.hive.v1beta.ListHiveTablesRequest,
          com.google.cloud.biglake.hive.v1beta.ListHiveTablesResponse>
      getListHiveTablesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.hive.v1beta.ListHiveTablesRequest,
            com.google.cloud.biglake.hive.v1beta.ListHiveTablesResponse>
        getListHiveTablesMethod;
    if ((getListHiveTablesMethod = HiveMetastoreServiceGrpc.getListHiveTablesMethod) == null) {
      synchronized (HiveMetastoreServiceGrpc.class) {
        if ((getListHiveTablesMethod = HiveMetastoreServiceGrpc.getListHiveTablesMethod) == null) {
          HiveMetastoreServiceGrpc.getListHiveTablesMethod =
              getListHiveTablesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.hive.v1beta.ListHiveTablesRequest,
                          com.google.cloud.biglake.hive.v1beta.ListHiveTablesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListHiveTables"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.hive.v1beta.ListHiveTablesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.hive.v1beta.ListHiveTablesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HiveMetastoreServiceMethodDescriptorSupplier("ListHiveTables"))
                      .build();
        }
      }
    }
    return getListHiveTablesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.hive.v1beta.UpdateHiveTableRequest,
          com.google.cloud.biglake.hive.v1beta.HiveTable>
      getUpdateHiveTableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateHiveTable",
      requestType = com.google.cloud.biglake.hive.v1beta.UpdateHiveTableRequest.class,
      responseType = com.google.cloud.biglake.hive.v1beta.HiveTable.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.hive.v1beta.UpdateHiveTableRequest,
          com.google.cloud.biglake.hive.v1beta.HiveTable>
      getUpdateHiveTableMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.hive.v1beta.UpdateHiveTableRequest,
            com.google.cloud.biglake.hive.v1beta.HiveTable>
        getUpdateHiveTableMethod;
    if ((getUpdateHiveTableMethod = HiveMetastoreServiceGrpc.getUpdateHiveTableMethod) == null) {
      synchronized (HiveMetastoreServiceGrpc.class) {
        if ((getUpdateHiveTableMethod = HiveMetastoreServiceGrpc.getUpdateHiveTableMethod)
            == null) {
          HiveMetastoreServiceGrpc.getUpdateHiveTableMethod =
              getUpdateHiveTableMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.hive.v1beta.UpdateHiveTableRequest,
                          com.google.cloud.biglake.hive.v1beta.HiveTable>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateHiveTable"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.hive.v1beta.UpdateHiveTableRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.hive.v1beta.HiveTable.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HiveMetastoreServiceMethodDescriptorSupplier("UpdateHiveTable"))
                      .build();
        }
      }
    }
    return getUpdateHiveTableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.hive.v1beta.DeleteHiveTableRequest, com.google.protobuf.Empty>
      getDeleteHiveTableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteHiveTable",
      requestType = com.google.cloud.biglake.hive.v1beta.DeleteHiveTableRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.hive.v1beta.DeleteHiveTableRequest, com.google.protobuf.Empty>
      getDeleteHiveTableMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.hive.v1beta.DeleteHiveTableRequest, com.google.protobuf.Empty>
        getDeleteHiveTableMethod;
    if ((getDeleteHiveTableMethod = HiveMetastoreServiceGrpc.getDeleteHiveTableMethod) == null) {
      synchronized (HiveMetastoreServiceGrpc.class) {
        if ((getDeleteHiveTableMethod = HiveMetastoreServiceGrpc.getDeleteHiveTableMethod)
            == null) {
          HiveMetastoreServiceGrpc.getDeleteHiveTableMethod =
              getDeleteHiveTableMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.hive.v1beta.DeleteHiveTableRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteHiveTable"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.hive.v1beta.DeleteHiveTableRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HiveMetastoreServiceMethodDescriptorSupplier("DeleteHiveTable"))
                      .build();
        }
      }
    }
    return getDeleteHiveTableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.hive.v1beta.BatchCreatePartitionsRequest,
          com.google.cloud.biglake.hive.v1beta.BatchCreatePartitionsResponse>
      getBatchCreatePartitionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchCreatePartitions",
      requestType = com.google.cloud.biglake.hive.v1beta.BatchCreatePartitionsRequest.class,
      responseType = com.google.cloud.biglake.hive.v1beta.BatchCreatePartitionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.hive.v1beta.BatchCreatePartitionsRequest,
          com.google.cloud.biglake.hive.v1beta.BatchCreatePartitionsResponse>
      getBatchCreatePartitionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.hive.v1beta.BatchCreatePartitionsRequest,
            com.google.cloud.biglake.hive.v1beta.BatchCreatePartitionsResponse>
        getBatchCreatePartitionsMethod;
    if ((getBatchCreatePartitionsMethod = HiveMetastoreServiceGrpc.getBatchCreatePartitionsMethod)
        == null) {
      synchronized (HiveMetastoreServiceGrpc.class) {
        if ((getBatchCreatePartitionsMethod =
                HiveMetastoreServiceGrpc.getBatchCreatePartitionsMethod)
            == null) {
          HiveMetastoreServiceGrpc.getBatchCreatePartitionsMethod =
              getBatchCreatePartitionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.hive.v1beta.BatchCreatePartitionsRequest,
                          com.google.cloud.biglake.hive.v1beta.BatchCreatePartitionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchCreatePartitions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.hive.v1beta.BatchCreatePartitionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.hive.v1beta.BatchCreatePartitionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HiveMetastoreServiceMethodDescriptorSupplier("BatchCreatePartitions"))
                      .build();
        }
      }
    }
    return getBatchCreatePartitionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.hive.v1beta.BatchDeletePartitionsRequest,
          com.google.protobuf.Empty>
      getBatchDeletePartitionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchDeletePartitions",
      requestType = com.google.cloud.biglake.hive.v1beta.BatchDeletePartitionsRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.hive.v1beta.BatchDeletePartitionsRequest,
          com.google.protobuf.Empty>
      getBatchDeletePartitionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.hive.v1beta.BatchDeletePartitionsRequest,
            com.google.protobuf.Empty>
        getBatchDeletePartitionsMethod;
    if ((getBatchDeletePartitionsMethod = HiveMetastoreServiceGrpc.getBatchDeletePartitionsMethod)
        == null) {
      synchronized (HiveMetastoreServiceGrpc.class) {
        if ((getBatchDeletePartitionsMethod =
                HiveMetastoreServiceGrpc.getBatchDeletePartitionsMethod)
            == null) {
          HiveMetastoreServiceGrpc.getBatchDeletePartitionsMethod =
              getBatchDeletePartitionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.hive.v1beta.BatchDeletePartitionsRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchDeletePartitions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.hive.v1beta.BatchDeletePartitionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HiveMetastoreServiceMethodDescriptorSupplier("BatchDeletePartitions"))
                      .build();
        }
      }
    }
    return getBatchDeletePartitionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.hive.v1beta.BatchUpdatePartitionsRequest,
          com.google.cloud.biglake.hive.v1beta.BatchUpdatePartitionsResponse>
      getBatchUpdatePartitionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchUpdatePartitions",
      requestType = com.google.cloud.biglake.hive.v1beta.BatchUpdatePartitionsRequest.class,
      responseType = com.google.cloud.biglake.hive.v1beta.BatchUpdatePartitionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.hive.v1beta.BatchUpdatePartitionsRequest,
          com.google.cloud.biglake.hive.v1beta.BatchUpdatePartitionsResponse>
      getBatchUpdatePartitionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.hive.v1beta.BatchUpdatePartitionsRequest,
            com.google.cloud.biglake.hive.v1beta.BatchUpdatePartitionsResponse>
        getBatchUpdatePartitionsMethod;
    if ((getBatchUpdatePartitionsMethod = HiveMetastoreServiceGrpc.getBatchUpdatePartitionsMethod)
        == null) {
      synchronized (HiveMetastoreServiceGrpc.class) {
        if ((getBatchUpdatePartitionsMethod =
                HiveMetastoreServiceGrpc.getBatchUpdatePartitionsMethod)
            == null) {
          HiveMetastoreServiceGrpc.getBatchUpdatePartitionsMethod =
              getBatchUpdatePartitionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.hive.v1beta.BatchUpdatePartitionsRequest,
                          com.google.cloud.biglake.hive.v1beta.BatchUpdatePartitionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchUpdatePartitions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.hive.v1beta.BatchUpdatePartitionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.hive.v1beta.BatchUpdatePartitionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HiveMetastoreServiceMethodDescriptorSupplier("BatchUpdatePartitions"))
                      .build();
        }
      }
    }
    return getBatchUpdatePartitionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.biglake.hive.v1beta.ListPartitionsRequest,
          com.google.cloud.biglake.hive.v1beta.ListPartitionsResponse>
      getListPartitionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPartitions",
      requestType = com.google.cloud.biglake.hive.v1beta.ListPartitionsRequest.class,
      responseType = com.google.cloud.biglake.hive.v1beta.ListPartitionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.biglake.hive.v1beta.ListPartitionsRequest,
          com.google.cloud.biglake.hive.v1beta.ListPartitionsResponse>
      getListPartitionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.biglake.hive.v1beta.ListPartitionsRequest,
            com.google.cloud.biglake.hive.v1beta.ListPartitionsResponse>
        getListPartitionsMethod;
    if ((getListPartitionsMethod = HiveMetastoreServiceGrpc.getListPartitionsMethod) == null) {
      synchronized (HiveMetastoreServiceGrpc.class) {
        if ((getListPartitionsMethod = HiveMetastoreServiceGrpc.getListPartitionsMethod) == null) {
          HiveMetastoreServiceGrpc.getListPartitionsMethod =
              getListPartitionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.biglake.hive.v1beta.ListPartitionsRequest,
                          com.google.cloud.biglake.hive.v1beta.ListPartitionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPartitions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.hive.v1beta.ListPartitionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.biglake.hive.v1beta.ListPartitionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HiveMetastoreServiceMethodDescriptorSupplier("ListPartitions"))
                      .build();
        }
      }
    }
    return getListPartitionsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static HiveMetastoreServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HiveMetastoreServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<HiveMetastoreServiceStub>() {
          @java.lang.Override
          public HiveMetastoreServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new HiveMetastoreServiceStub(channel, callOptions);
          }
        };
    return HiveMetastoreServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static HiveMetastoreServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HiveMetastoreServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<HiveMetastoreServiceBlockingV2Stub>() {
          @java.lang.Override
          public HiveMetastoreServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new HiveMetastoreServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return HiveMetastoreServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HiveMetastoreServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HiveMetastoreServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<HiveMetastoreServiceBlockingStub>() {
          @java.lang.Override
          public HiveMetastoreServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new HiveMetastoreServiceBlockingStub(channel, callOptions);
          }
        };
    return HiveMetastoreServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static HiveMetastoreServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HiveMetastoreServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<HiveMetastoreServiceFutureStub>() {
          @java.lang.Override
          public HiveMetastoreServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new HiveMetastoreServiceFutureStub(channel, callOptions);
          }
        };
    return HiveMetastoreServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Hive Metastore Service is a biglake service that allows users to manage
   * their external Hive catalogs. Full API compatibility with OSS Hive Metastore
   * APIs is not supported. The methods match the Hive Metastore API spec mostly
   * except for a few exceptions.
   * These include listing resources with pattern,
   * environment context which are combined in a single List API, return of
   * ListResponse object instead of a list of resources, transactions, locks, etc.
   * The BigLake Hive Metastore API defines the following resources:
   * * A collection of Google Cloud projects: `/projects/&#42;`
   * * Each project has a collection of catalogs: `/catalogs/&#42;`
   * * Each catalog has a collection of databases: `/databases/&#42;`
   * * Each database has a collection of tables: `/tables/&#42;`
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a new hive catalog.
     * </pre>
     */
    default void createHiveCatalog(
        com.google.cloud.biglake.hive.v1beta.CreateHiveCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.hive.v1beta.HiveCatalog>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateHiveCatalogMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the catalog specified by the resource name.
     * </pre>
     */
    default void getHiveCatalog(
        com.google.cloud.biglake.hive.v1beta.GetHiveCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.hive.v1beta.HiveCatalog>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetHiveCatalogMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all catalogs in a specified project.
     * </pre>
     */
    default void listHiveCatalogs(
        com.google.cloud.biglake.hive.v1beta.ListHiveCatalogsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.hive.v1beta.ListHiveCatalogsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListHiveCatalogsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing catalog.
     * </pre>
     */
    default void updateHiveCatalog(
        com.google.cloud.biglake.hive.v1beta.UpdateHiveCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.hive.v1beta.HiveCatalog>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateHiveCatalogMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing catalog specified by the catalog ID. Delete will fail
     * if the catalog is not empty.
     * </pre>
     */
    default void deleteHiveCatalog(
        com.google.cloud.biglake.hive.v1beta.DeleteHiveCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteHiveCatalogMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new database.
     * </pre>
     */
    default void createHiveDatabase(
        com.google.cloud.biglake.hive.v1beta.CreateHiveDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.hive.v1beta.HiveDatabase>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateHiveDatabaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the database specified by the resource name.
     * </pre>
     */
    default void getHiveDatabase(
        com.google.cloud.biglake.hive.v1beta.GetHiveDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.hive.v1beta.HiveDatabase>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetHiveDatabaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all databases in a specified catalog.
     * </pre>
     */
    default void listHiveDatabases(
        com.google.cloud.biglake.hive.v1beta.ListHiveDatabasesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.hive.v1beta.ListHiveDatabasesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListHiveDatabasesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing database specified by the database name.
     * </pre>
     */
    default void updateHiveDatabase(
        com.google.cloud.biglake.hive.v1beta.UpdateHiveDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.hive.v1beta.HiveDatabase>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateHiveDatabaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing database specified by the database name.
     * </pre>
     */
    default void deleteHiveDatabase(
        com.google.cloud.biglake.hive.v1beta.DeleteHiveDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteHiveDatabaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new hive table.
     * </pre>
     */
    default void createHiveTable(
        com.google.cloud.biglake.hive.v1beta.CreateHiveTableRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.hive.v1beta.HiveTable>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateHiveTableMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the table specified by the resource name.
     * </pre>
     */
    default void getHiveTable(
        com.google.cloud.biglake.hive.v1beta.GetHiveTableRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.hive.v1beta.HiveTable>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetHiveTableMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all hive tables in a specified project under the hive catalog and
     * database.
     * </pre>
     */
    default void listHiveTables(
        com.google.cloud.biglake.hive.v1beta.ListHiveTablesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.hive.v1beta.ListHiveTablesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListHiveTablesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing table specified by the table name.
     * </pre>
     */
    default void updateHiveTable(
        com.google.cloud.biglake.hive.v1beta.UpdateHiveTableRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.hive.v1beta.HiveTable>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateHiveTableMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing table specified by the table name.
     * </pre>
     */
    default void deleteHiveTable(
        com.google.cloud.biglake.hive.v1beta.DeleteHiveTableRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteHiveTableMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds partitions to a table.
     * </pre>
     */
    default void batchCreatePartitions(
        com.google.cloud.biglake.hive.v1beta.BatchCreatePartitionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.biglake.hive.v1beta.BatchCreatePartitionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchCreatePartitionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes partitions from a table.
     * </pre>
     */
    default void batchDeletePartitions(
        com.google.cloud.biglake.hive.v1beta.BatchDeletePartitionsRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchDeletePartitionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates partitions in a table.
     * </pre>
     */
    default void batchUpdatePartitions(
        com.google.cloud.biglake.hive.v1beta.BatchUpdatePartitionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.biglake.hive.v1beta.BatchUpdatePartitionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchUpdatePartitionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Streams list of partitions from a table.
     * </pre>
     */
    default void listPartitions(
        com.google.cloud.biglake.hive.v1beta.ListPartitionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.hive.v1beta.ListPartitionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPartitionsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service HiveMetastoreService.
   *
   * <pre>
   * Hive Metastore Service is a biglake service that allows users to manage
   * their external Hive catalogs. Full API compatibility with OSS Hive Metastore
   * APIs is not supported. The methods match the Hive Metastore API spec mostly
   * except for a few exceptions.
   * These include listing resources with pattern,
   * environment context which are combined in a single List API, return of
   * ListResponse object instead of a list of resources, transactions, locks, etc.
   * The BigLake Hive Metastore API defines the following resources:
   * * A collection of Google Cloud projects: `/projects/&#42;`
   * * Each project has a collection of catalogs: `/catalogs/&#42;`
   * * Each catalog has a collection of databases: `/databases/&#42;`
   * * Each database has a collection of tables: `/tables/&#42;`
   * </pre>
   */
  public abstract static class HiveMetastoreServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return HiveMetastoreServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service HiveMetastoreService.
   *
   * <pre>
   * Hive Metastore Service is a biglake service that allows users to manage
   * their external Hive catalogs. Full API compatibility with OSS Hive Metastore
   * APIs is not supported. The methods match the Hive Metastore API spec mostly
   * except for a few exceptions.
   * These include listing resources with pattern,
   * environment context which are combined in a single List API, return of
   * ListResponse object instead of a list of resources, transactions, locks, etc.
   * The BigLake Hive Metastore API defines the following resources:
   * * A collection of Google Cloud projects: `/projects/&#42;`
   * * Each project has a collection of catalogs: `/catalogs/&#42;`
   * * Each catalog has a collection of databases: `/databases/&#42;`
   * * Each database has a collection of tables: `/tables/&#42;`
   * </pre>
   */
  public static final class HiveMetastoreServiceStub
      extends io.grpc.stub.AbstractAsyncStub<HiveMetastoreServiceStub> {
    private HiveMetastoreServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HiveMetastoreServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HiveMetastoreServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new hive catalog.
     * </pre>
     */
    public void createHiveCatalog(
        com.google.cloud.biglake.hive.v1beta.CreateHiveCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.hive.v1beta.HiveCatalog>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateHiveCatalogMethod(), getCallOptions()),
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
    public void getHiveCatalog(
        com.google.cloud.biglake.hive.v1beta.GetHiveCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.hive.v1beta.HiveCatalog>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetHiveCatalogMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all catalogs in a specified project.
     * </pre>
     */
    public void listHiveCatalogs(
        com.google.cloud.biglake.hive.v1beta.ListHiveCatalogsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.hive.v1beta.ListHiveCatalogsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListHiveCatalogsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing catalog.
     * </pre>
     */
    public void updateHiveCatalog(
        com.google.cloud.biglake.hive.v1beta.UpdateHiveCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.hive.v1beta.HiveCatalog>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateHiveCatalogMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing catalog specified by the catalog ID. Delete will fail
     * if the catalog is not empty.
     * </pre>
     */
    public void deleteHiveCatalog(
        com.google.cloud.biglake.hive.v1beta.DeleteHiveCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteHiveCatalogMethod(), getCallOptions()),
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
    public void createHiveDatabase(
        com.google.cloud.biglake.hive.v1beta.CreateHiveDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.hive.v1beta.HiveDatabase>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateHiveDatabaseMethod(), getCallOptions()),
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
    public void getHiveDatabase(
        com.google.cloud.biglake.hive.v1beta.GetHiveDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.hive.v1beta.HiveDatabase>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetHiveDatabaseMethod(), getCallOptions()),
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
    public void listHiveDatabases(
        com.google.cloud.biglake.hive.v1beta.ListHiveDatabasesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.hive.v1beta.ListHiveDatabasesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListHiveDatabasesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing database specified by the database name.
     * </pre>
     */
    public void updateHiveDatabase(
        com.google.cloud.biglake.hive.v1beta.UpdateHiveDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.hive.v1beta.HiveDatabase>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateHiveDatabaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing database specified by the database name.
     * </pre>
     */
    public void deleteHiveDatabase(
        com.google.cloud.biglake.hive.v1beta.DeleteHiveDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteHiveDatabaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new hive table.
     * </pre>
     */
    public void createHiveTable(
        com.google.cloud.biglake.hive.v1beta.CreateHiveTableRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.hive.v1beta.HiveTable>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateHiveTableMethod(), getCallOptions()),
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
    public void getHiveTable(
        com.google.cloud.biglake.hive.v1beta.GetHiveTableRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.hive.v1beta.HiveTable>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetHiveTableMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all hive tables in a specified project under the hive catalog and
     * database.
     * </pre>
     */
    public void listHiveTables(
        com.google.cloud.biglake.hive.v1beta.ListHiveTablesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.hive.v1beta.ListHiveTablesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListHiveTablesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing table specified by the table name.
     * </pre>
     */
    public void updateHiveTable(
        com.google.cloud.biglake.hive.v1beta.UpdateHiveTableRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.hive.v1beta.HiveTable>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateHiveTableMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing table specified by the table name.
     * </pre>
     */
    public void deleteHiveTable(
        com.google.cloud.biglake.hive.v1beta.DeleteHiveTableRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteHiveTableMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds partitions to a table.
     * </pre>
     */
    public void batchCreatePartitions(
        com.google.cloud.biglake.hive.v1beta.BatchCreatePartitionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.biglake.hive.v1beta.BatchCreatePartitionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchCreatePartitionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes partitions from a table.
     * </pre>
     */
    public void batchDeletePartitions(
        com.google.cloud.biglake.hive.v1beta.BatchDeletePartitionsRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchDeletePartitionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates partitions in a table.
     * </pre>
     */
    public void batchUpdatePartitions(
        com.google.cloud.biglake.hive.v1beta.BatchUpdatePartitionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.biglake.hive.v1beta.BatchUpdatePartitionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchUpdatePartitionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Streams list of partitions from a table.
     * </pre>
     */
    public void listPartitions(
        com.google.cloud.biglake.hive.v1beta.ListPartitionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.biglake.hive.v1beta.ListPartitionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getListPartitionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service HiveMetastoreService.
   *
   * <pre>
   * Hive Metastore Service is a biglake service that allows users to manage
   * their external Hive catalogs. Full API compatibility with OSS Hive Metastore
   * APIs is not supported. The methods match the Hive Metastore API spec mostly
   * except for a few exceptions.
   * These include listing resources with pattern,
   * environment context which are combined in a single List API, return of
   * ListResponse object instead of a list of resources, transactions, locks, etc.
   * The BigLake Hive Metastore API defines the following resources:
   * * A collection of Google Cloud projects: `/projects/&#42;`
   * * Each project has a collection of catalogs: `/catalogs/&#42;`
   * * Each catalog has a collection of databases: `/databases/&#42;`
   * * Each database has a collection of tables: `/tables/&#42;`
   * </pre>
   */
  public static final class HiveMetastoreServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<HiveMetastoreServiceBlockingV2Stub> {
    private HiveMetastoreServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HiveMetastoreServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HiveMetastoreServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new hive catalog.
     * </pre>
     */
    public com.google.cloud.biglake.hive.v1beta.HiveCatalog createHiveCatalog(
        com.google.cloud.biglake.hive.v1beta.CreateHiveCatalogRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateHiveCatalogMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the catalog specified by the resource name.
     * </pre>
     */
    public com.google.cloud.biglake.hive.v1beta.HiveCatalog getHiveCatalog(
        com.google.cloud.biglake.hive.v1beta.GetHiveCatalogRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetHiveCatalogMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all catalogs in a specified project.
     * </pre>
     */
    public com.google.cloud.biglake.hive.v1beta.ListHiveCatalogsResponse listHiveCatalogs(
        com.google.cloud.biglake.hive.v1beta.ListHiveCatalogsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListHiveCatalogsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing catalog.
     * </pre>
     */
    public com.google.cloud.biglake.hive.v1beta.HiveCatalog updateHiveCatalog(
        com.google.cloud.biglake.hive.v1beta.UpdateHiveCatalogRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateHiveCatalogMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing catalog specified by the catalog ID. Delete will fail
     * if the catalog is not empty.
     * </pre>
     */
    public com.google.protobuf.Empty deleteHiveCatalog(
        com.google.cloud.biglake.hive.v1beta.DeleteHiveCatalogRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteHiveCatalogMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new database.
     * </pre>
     */
    public com.google.cloud.biglake.hive.v1beta.HiveDatabase createHiveDatabase(
        com.google.cloud.biglake.hive.v1beta.CreateHiveDatabaseRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateHiveDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the database specified by the resource name.
     * </pre>
     */
    public com.google.cloud.biglake.hive.v1beta.HiveDatabase getHiveDatabase(
        com.google.cloud.biglake.hive.v1beta.GetHiveDatabaseRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetHiveDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all databases in a specified catalog.
     * </pre>
     */
    public com.google.cloud.biglake.hive.v1beta.ListHiveDatabasesResponse listHiveDatabases(
        com.google.cloud.biglake.hive.v1beta.ListHiveDatabasesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListHiveDatabasesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing database specified by the database name.
     * </pre>
     */
    public com.google.cloud.biglake.hive.v1beta.HiveDatabase updateHiveDatabase(
        com.google.cloud.biglake.hive.v1beta.UpdateHiveDatabaseRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateHiveDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing database specified by the database name.
     * </pre>
     */
    public com.google.protobuf.Empty deleteHiveDatabase(
        com.google.cloud.biglake.hive.v1beta.DeleteHiveDatabaseRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteHiveDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new hive table.
     * </pre>
     */
    public com.google.cloud.biglake.hive.v1beta.HiveTable createHiveTable(
        com.google.cloud.biglake.hive.v1beta.CreateHiveTableRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateHiveTableMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the table specified by the resource name.
     * </pre>
     */
    public com.google.cloud.biglake.hive.v1beta.HiveTable getHiveTable(
        com.google.cloud.biglake.hive.v1beta.GetHiveTableRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetHiveTableMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all hive tables in a specified project under the hive catalog and
     * database.
     * </pre>
     */
    public com.google.cloud.biglake.hive.v1beta.ListHiveTablesResponse listHiveTables(
        com.google.cloud.biglake.hive.v1beta.ListHiveTablesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListHiveTablesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing table specified by the table name.
     * </pre>
     */
    public com.google.cloud.biglake.hive.v1beta.HiveTable updateHiveTable(
        com.google.cloud.biglake.hive.v1beta.UpdateHiveTableRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateHiveTableMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing table specified by the table name.
     * </pre>
     */
    public com.google.protobuf.Empty deleteHiveTable(
        com.google.cloud.biglake.hive.v1beta.DeleteHiveTableRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteHiveTableMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Adds partitions to a table.
     * </pre>
     */
    public com.google.cloud.biglake.hive.v1beta.BatchCreatePartitionsResponse batchCreatePartitions(
        com.google.cloud.biglake.hive.v1beta.BatchCreatePartitionsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getBatchCreatePartitionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes partitions from a table.
     * </pre>
     */
    public com.google.protobuf.Empty batchDeletePartitions(
        com.google.cloud.biglake.hive.v1beta.BatchDeletePartitionsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getBatchDeletePartitionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates partitions in a table.
     * </pre>
     */
    public com.google.cloud.biglake.hive.v1beta.BatchUpdatePartitionsResponse batchUpdatePartitions(
        com.google.cloud.biglake.hive.v1beta.BatchUpdatePartitionsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getBatchUpdatePartitionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Streams list of partitions from a table.
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<
            ?, com.google.cloud.biglake.hive.v1beta.ListPartitionsResponse>
        listPartitions(com.google.cloud.biglake.hive.v1beta.ListPartitionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingV2ServerStreamingCall(
          getChannel(), getListPartitionsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service HiveMetastoreService.
   *
   * <pre>
   * Hive Metastore Service is a biglake service that allows users to manage
   * their external Hive catalogs. Full API compatibility with OSS Hive Metastore
   * APIs is not supported. The methods match the Hive Metastore API spec mostly
   * except for a few exceptions.
   * These include listing resources with pattern,
   * environment context which are combined in a single List API, return of
   * ListResponse object instead of a list of resources, transactions, locks, etc.
   * The BigLake Hive Metastore API defines the following resources:
   * * A collection of Google Cloud projects: `/projects/&#42;`
   * * Each project has a collection of catalogs: `/catalogs/&#42;`
   * * Each catalog has a collection of databases: `/databases/&#42;`
   * * Each database has a collection of tables: `/tables/&#42;`
   * </pre>
   */
  public static final class HiveMetastoreServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<HiveMetastoreServiceBlockingStub> {
    private HiveMetastoreServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HiveMetastoreServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HiveMetastoreServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new hive catalog.
     * </pre>
     */
    public com.google.cloud.biglake.hive.v1beta.HiveCatalog createHiveCatalog(
        com.google.cloud.biglake.hive.v1beta.CreateHiveCatalogRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateHiveCatalogMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the catalog specified by the resource name.
     * </pre>
     */
    public com.google.cloud.biglake.hive.v1beta.HiveCatalog getHiveCatalog(
        com.google.cloud.biglake.hive.v1beta.GetHiveCatalogRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetHiveCatalogMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all catalogs in a specified project.
     * </pre>
     */
    public com.google.cloud.biglake.hive.v1beta.ListHiveCatalogsResponse listHiveCatalogs(
        com.google.cloud.biglake.hive.v1beta.ListHiveCatalogsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListHiveCatalogsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing catalog.
     * </pre>
     */
    public com.google.cloud.biglake.hive.v1beta.HiveCatalog updateHiveCatalog(
        com.google.cloud.biglake.hive.v1beta.UpdateHiveCatalogRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateHiveCatalogMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing catalog specified by the catalog ID. Delete will fail
     * if the catalog is not empty.
     * </pre>
     */
    public com.google.protobuf.Empty deleteHiveCatalog(
        com.google.cloud.biglake.hive.v1beta.DeleteHiveCatalogRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteHiveCatalogMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new database.
     * </pre>
     */
    public com.google.cloud.biglake.hive.v1beta.HiveDatabase createHiveDatabase(
        com.google.cloud.biglake.hive.v1beta.CreateHiveDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateHiveDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the database specified by the resource name.
     * </pre>
     */
    public com.google.cloud.biglake.hive.v1beta.HiveDatabase getHiveDatabase(
        com.google.cloud.biglake.hive.v1beta.GetHiveDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetHiveDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all databases in a specified catalog.
     * </pre>
     */
    public com.google.cloud.biglake.hive.v1beta.ListHiveDatabasesResponse listHiveDatabases(
        com.google.cloud.biglake.hive.v1beta.ListHiveDatabasesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListHiveDatabasesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing database specified by the database name.
     * </pre>
     */
    public com.google.cloud.biglake.hive.v1beta.HiveDatabase updateHiveDatabase(
        com.google.cloud.biglake.hive.v1beta.UpdateHiveDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateHiveDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing database specified by the database name.
     * </pre>
     */
    public com.google.protobuf.Empty deleteHiveDatabase(
        com.google.cloud.biglake.hive.v1beta.DeleteHiveDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteHiveDatabaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new hive table.
     * </pre>
     */
    public com.google.cloud.biglake.hive.v1beta.HiveTable createHiveTable(
        com.google.cloud.biglake.hive.v1beta.CreateHiveTableRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateHiveTableMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the table specified by the resource name.
     * </pre>
     */
    public com.google.cloud.biglake.hive.v1beta.HiveTable getHiveTable(
        com.google.cloud.biglake.hive.v1beta.GetHiveTableRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetHiveTableMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all hive tables in a specified project under the hive catalog and
     * database.
     * </pre>
     */
    public com.google.cloud.biglake.hive.v1beta.ListHiveTablesResponse listHiveTables(
        com.google.cloud.biglake.hive.v1beta.ListHiveTablesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListHiveTablesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing table specified by the table name.
     * </pre>
     */
    public com.google.cloud.biglake.hive.v1beta.HiveTable updateHiveTable(
        com.google.cloud.biglake.hive.v1beta.UpdateHiveTableRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateHiveTableMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing table specified by the table name.
     * </pre>
     */
    public com.google.protobuf.Empty deleteHiveTable(
        com.google.cloud.biglake.hive.v1beta.DeleteHiveTableRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteHiveTableMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Adds partitions to a table.
     * </pre>
     */
    public com.google.cloud.biglake.hive.v1beta.BatchCreatePartitionsResponse batchCreatePartitions(
        com.google.cloud.biglake.hive.v1beta.BatchCreatePartitionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchCreatePartitionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes partitions from a table.
     * </pre>
     */
    public com.google.protobuf.Empty batchDeletePartitions(
        com.google.cloud.biglake.hive.v1beta.BatchDeletePartitionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchDeletePartitionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates partitions in a table.
     * </pre>
     */
    public com.google.cloud.biglake.hive.v1beta.BatchUpdatePartitionsResponse batchUpdatePartitions(
        com.google.cloud.biglake.hive.v1beta.BatchUpdatePartitionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchUpdatePartitionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Streams list of partitions from a table.
     * </pre>
     */
    public java.util.Iterator<com.google.cloud.biglake.hive.v1beta.ListPartitionsResponse>
        listPartitions(com.google.cloud.biglake.hive.v1beta.ListPartitionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getListPartitionsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service HiveMetastoreService.
   *
   * <pre>
   * Hive Metastore Service is a biglake service that allows users to manage
   * their external Hive catalogs. Full API compatibility with OSS Hive Metastore
   * APIs is not supported. The methods match the Hive Metastore API spec mostly
   * except for a few exceptions.
   * These include listing resources with pattern,
   * environment context which are combined in a single List API, return of
   * ListResponse object instead of a list of resources, transactions, locks, etc.
   * The BigLake Hive Metastore API defines the following resources:
   * * A collection of Google Cloud projects: `/projects/&#42;`
   * * Each project has a collection of catalogs: `/catalogs/&#42;`
   * * Each catalog has a collection of databases: `/databases/&#42;`
   * * Each database has a collection of tables: `/tables/&#42;`
   * </pre>
   */
  public static final class HiveMetastoreServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<HiveMetastoreServiceFutureStub> {
    private HiveMetastoreServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HiveMetastoreServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HiveMetastoreServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new hive catalog.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.biglake.hive.v1beta.HiveCatalog>
        createHiveCatalog(com.google.cloud.biglake.hive.v1beta.CreateHiveCatalogRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateHiveCatalogMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the catalog specified by the resource name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.biglake.hive.v1beta.HiveCatalog>
        getHiveCatalog(com.google.cloud.biglake.hive.v1beta.GetHiveCatalogRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetHiveCatalogMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List all catalogs in a specified project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.biglake.hive.v1beta.ListHiveCatalogsResponse>
        listHiveCatalogs(com.google.cloud.biglake.hive.v1beta.ListHiveCatalogsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListHiveCatalogsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing catalog.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.biglake.hive.v1beta.HiveCatalog>
        updateHiveCatalog(com.google.cloud.biglake.hive.v1beta.UpdateHiveCatalogRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateHiveCatalogMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing catalog specified by the catalog ID. Delete will fail
     * if the catalog is not empty.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteHiveCatalog(com.google.cloud.biglake.hive.v1beta.DeleteHiveCatalogRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteHiveCatalogMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new database.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.biglake.hive.v1beta.HiveDatabase>
        createHiveDatabase(com.google.cloud.biglake.hive.v1beta.CreateHiveDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateHiveDatabaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the database specified by the resource name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.biglake.hive.v1beta.HiveDatabase>
        getHiveDatabase(com.google.cloud.biglake.hive.v1beta.GetHiveDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetHiveDatabaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List all databases in a specified catalog.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.biglake.hive.v1beta.ListHiveDatabasesResponse>
        listHiveDatabases(com.google.cloud.biglake.hive.v1beta.ListHiveDatabasesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListHiveDatabasesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing database specified by the database name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.biglake.hive.v1beta.HiveDatabase>
        updateHiveDatabase(com.google.cloud.biglake.hive.v1beta.UpdateHiveDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateHiveDatabaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing database specified by the database name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteHiveDatabase(com.google.cloud.biglake.hive.v1beta.DeleteHiveDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteHiveDatabaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new hive table.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.biglake.hive.v1beta.HiveTable>
        createHiveTable(com.google.cloud.biglake.hive.v1beta.CreateHiveTableRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateHiveTableMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the table specified by the resource name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.biglake.hive.v1beta.HiveTable>
        getHiveTable(com.google.cloud.biglake.hive.v1beta.GetHiveTableRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetHiveTableMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List all hive tables in a specified project under the hive catalog and
     * database.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.biglake.hive.v1beta.ListHiveTablesResponse>
        listHiveTables(com.google.cloud.biglake.hive.v1beta.ListHiveTablesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListHiveTablesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing table specified by the table name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.biglake.hive.v1beta.HiveTable>
        updateHiveTable(com.google.cloud.biglake.hive.v1beta.UpdateHiveTableRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateHiveTableMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an existing table specified by the table name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteHiveTable(com.google.cloud.biglake.hive.v1beta.DeleteHiveTableRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteHiveTableMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Adds partitions to a table.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.biglake.hive.v1beta.BatchCreatePartitionsResponse>
        batchCreatePartitions(
            com.google.cloud.biglake.hive.v1beta.BatchCreatePartitionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchCreatePartitionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes partitions from a table.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        batchDeletePartitions(
            com.google.cloud.biglake.hive.v1beta.BatchDeletePartitionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchDeletePartitionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates partitions in a table.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.biglake.hive.v1beta.BatchUpdatePartitionsResponse>
        batchUpdatePartitions(
            com.google.cloud.biglake.hive.v1beta.BatchUpdatePartitionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchUpdatePartitionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_HIVE_CATALOG = 0;
  private static final int METHODID_GET_HIVE_CATALOG = 1;
  private static final int METHODID_LIST_HIVE_CATALOGS = 2;
  private static final int METHODID_UPDATE_HIVE_CATALOG = 3;
  private static final int METHODID_DELETE_HIVE_CATALOG = 4;
  private static final int METHODID_CREATE_HIVE_DATABASE = 5;
  private static final int METHODID_GET_HIVE_DATABASE = 6;
  private static final int METHODID_LIST_HIVE_DATABASES = 7;
  private static final int METHODID_UPDATE_HIVE_DATABASE = 8;
  private static final int METHODID_DELETE_HIVE_DATABASE = 9;
  private static final int METHODID_CREATE_HIVE_TABLE = 10;
  private static final int METHODID_GET_HIVE_TABLE = 11;
  private static final int METHODID_LIST_HIVE_TABLES = 12;
  private static final int METHODID_UPDATE_HIVE_TABLE = 13;
  private static final int METHODID_DELETE_HIVE_TABLE = 14;
  private static final int METHODID_BATCH_CREATE_PARTITIONS = 15;
  private static final int METHODID_BATCH_DELETE_PARTITIONS = 16;
  private static final int METHODID_BATCH_UPDATE_PARTITIONS = 17;
  private static final int METHODID_LIST_PARTITIONS = 18;

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
        case METHODID_CREATE_HIVE_CATALOG:
          serviceImpl.createHiveCatalog(
              (com.google.cloud.biglake.hive.v1beta.CreateHiveCatalogRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.biglake.hive.v1beta.HiveCatalog>)
                  responseObserver);
          break;
        case METHODID_GET_HIVE_CATALOG:
          serviceImpl.getHiveCatalog(
              (com.google.cloud.biglake.hive.v1beta.GetHiveCatalogRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.biglake.hive.v1beta.HiveCatalog>)
                  responseObserver);
          break;
        case METHODID_LIST_HIVE_CATALOGS:
          serviceImpl.listHiveCatalogs(
              (com.google.cloud.biglake.hive.v1beta.ListHiveCatalogsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.biglake.hive.v1beta.ListHiveCatalogsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_HIVE_CATALOG:
          serviceImpl.updateHiveCatalog(
              (com.google.cloud.biglake.hive.v1beta.UpdateHiveCatalogRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.biglake.hive.v1beta.HiveCatalog>)
                  responseObserver);
          break;
        case METHODID_DELETE_HIVE_CATALOG:
          serviceImpl.deleteHiveCatalog(
              (com.google.cloud.biglake.hive.v1beta.DeleteHiveCatalogRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_HIVE_DATABASE:
          serviceImpl.createHiveDatabase(
              (com.google.cloud.biglake.hive.v1beta.CreateHiveDatabaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.biglake.hive.v1beta.HiveDatabase>)
                  responseObserver);
          break;
        case METHODID_GET_HIVE_DATABASE:
          serviceImpl.getHiveDatabase(
              (com.google.cloud.biglake.hive.v1beta.GetHiveDatabaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.biglake.hive.v1beta.HiveDatabase>)
                  responseObserver);
          break;
        case METHODID_LIST_HIVE_DATABASES:
          serviceImpl.listHiveDatabases(
              (com.google.cloud.biglake.hive.v1beta.ListHiveDatabasesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.biglake.hive.v1beta.ListHiveDatabasesResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_HIVE_DATABASE:
          serviceImpl.updateHiveDatabase(
              (com.google.cloud.biglake.hive.v1beta.UpdateHiveDatabaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.biglake.hive.v1beta.HiveDatabase>)
                  responseObserver);
          break;
        case METHODID_DELETE_HIVE_DATABASE:
          serviceImpl.deleteHiveDatabase(
              (com.google.cloud.biglake.hive.v1beta.DeleteHiveDatabaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_HIVE_TABLE:
          serviceImpl.createHiveTable(
              (com.google.cloud.biglake.hive.v1beta.CreateHiveTableRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.biglake.hive.v1beta.HiveTable>)
                  responseObserver);
          break;
        case METHODID_GET_HIVE_TABLE:
          serviceImpl.getHiveTable(
              (com.google.cloud.biglake.hive.v1beta.GetHiveTableRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.biglake.hive.v1beta.HiveTable>)
                  responseObserver);
          break;
        case METHODID_LIST_HIVE_TABLES:
          serviceImpl.listHiveTables(
              (com.google.cloud.biglake.hive.v1beta.ListHiveTablesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.biglake.hive.v1beta.ListHiveTablesResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_HIVE_TABLE:
          serviceImpl.updateHiveTable(
              (com.google.cloud.biglake.hive.v1beta.UpdateHiveTableRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.biglake.hive.v1beta.HiveTable>)
                  responseObserver);
          break;
        case METHODID_DELETE_HIVE_TABLE:
          serviceImpl.deleteHiveTable(
              (com.google.cloud.biglake.hive.v1beta.DeleteHiveTableRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_BATCH_CREATE_PARTITIONS:
          serviceImpl.batchCreatePartitions(
              (com.google.cloud.biglake.hive.v1beta.BatchCreatePartitionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.biglake.hive.v1beta.BatchCreatePartitionsResponse>)
                  responseObserver);
          break;
        case METHODID_BATCH_DELETE_PARTITIONS:
          serviceImpl.batchDeletePartitions(
              (com.google.cloud.biglake.hive.v1beta.BatchDeletePartitionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_BATCH_UPDATE_PARTITIONS:
          serviceImpl.batchUpdatePartitions(
              (com.google.cloud.biglake.hive.v1beta.BatchUpdatePartitionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.biglake.hive.v1beta.BatchUpdatePartitionsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_PARTITIONS:
          serviceImpl.listPartitions(
              (com.google.cloud.biglake.hive.v1beta.ListPartitionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.biglake.hive.v1beta.ListPartitionsResponse>)
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
            getCreateHiveCatalogMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.biglake.hive.v1beta.CreateHiveCatalogRequest,
                    com.google.cloud.biglake.hive.v1beta.HiveCatalog>(
                    service, METHODID_CREATE_HIVE_CATALOG)))
        .addMethod(
            getGetHiveCatalogMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.biglake.hive.v1beta.GetHiveCatalogRequest,
                    com.google.cloud.biglake.hive.v1beta.HiveCatalog>(
                    service, METHODID_GET_HIVE_CATALOG)))
        .addMethod(
            getListHiveCatalogsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.biglake.hive.v1beta.ListHiveCatalogsRequest,
                    com.google.cloud.biglake.hive.v1beta.ListHiveCatalogsResponse>(
                    service, METHODID_LIST_HIVE_CATALOGS)))
        .addMethod(
            getUpdateHiveCatalogMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.biglake.hive.v1beta.UpdateHiveCatalogRequest,
                    com.google.cloud.biglake.hive.v1beta.HiveCatalog>(
                    service, METHODID_UPDATE_HIVE_CATALOG)))
        .addMethod(
            getDeleteHiveCatalogMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.biglake.hive.v1beta.DeleteHiveCatalogRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_HIVE_CATALOG)))
        .addMethod(
            getCreateHiveDatabaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.biglake.hive.v1beta.CreateHiveDatabaseRequest,
                    com.google.cloud.biglake.hive.v1beta.HiveDatabase>(
                    service, METHODID_CREATE_HIVE_DATABASE)))
        .addMethod(
            getGetHiveDatabaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.biglake.hive.v1beta.GetHiveDatabaseRequest,
                    com.google.cloud.biglake.hive.v1beta.HiveDatabase>(
                    service, METHODID_GET_HIVE_DATABASE)))
        .addMethod(
            getListHiveDatabasesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.biglake.hive.v1beta.ListHiveDatabasesRequest,
                    com.google.cloud.biglake.hive.v1beta.ListHiveDatabasesResponse>(
                    service, METHODID_LIST_HIVE_DATABASES)))
        .addMethod(
            getUpdateHiveDatabaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.biglake.hive.v1beta.UpdateHiveDatabaseRequest,
                    com.google.cloud.biglake.hive.v1beta.HiveDatabase>(
                    service, METHODID_UPDATE_HIVE_DATABASE)))
        .addMethod(
            getDeleteHiveDatabaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.biglake.hive.v1beta.DeleteHiveDatabaseRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_HIVE_DATABASE)))
        .addMethod(
            getCreateHiveTableMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.biglake.hive.v1beta.CreateHiveTableRequest,
                    com.google.cloud.biglake.hive.v1beta.HiveTable>(
                    service, METHODID_CREATE_HIVE_TABLE)))
        .addMethod(
            getGetHiveTableMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.biglake.hive.v1beta.GetHiveTableRequest,
                    com.google.cloud.biglake.hive.v1beta.HiveTable>(
                    service, METHODID_GET_HIVE_TABLE)))
        .addMethod(
            getListHiveTablesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.biglake.hive.v1beta.ListHiveTablesRequest,
                    com.google.cloud.biglake.hive.v1beta.ListHiveTablesResponse>(
                    service, METHODID_LIST_HIVE_TABLES)))
        .addMethod(
            getUpdateHiveTableMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.biglake.hive.v1beta.UpdateHiveTableRequest,
                    com.google.cloud.biglake.hive.v1beta.HiveTable>(
                    service, METHODID_UPDATE_HIVE_TABLE)))
        .addMethod(
            getDeleteHiveTableMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.biglake.hive.v1beta.DeleteHiveTableRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_HIVE_TABLE)))
        .addMethod(
            getBatchCreatePartitionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.biglake.hive.v1beta.BatchCreatePartitionsRequest,
                    com.google.cloud.biglake.hive.v1beta.BatchCreatePartitionsResponse>(
                    service, METHODID_BATCH_CREATE_PARTITIONS)))
        .addMethod(
            getBatchDeletePartitionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.biglake.hive.v1beta.BatchDeletePartitionsRequest,
                    com.google.protobuf.Empty>(service, METHODID_BATCH_DELETE_PARTITIONS)))
        .addMethod(
            getBatchUpdatePartitionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.biglake.hive.v1beta.BatchUpdatePartitionsRequest,
                    com.google.cloud.biglake.hive.v1beta.BatchUpdatePartitionsResponse>(
                    service, METHODID_BATCH_UPDATE_PARTITIONS)))
        .addMethod(
            getListPartitionsMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
                new MethodHandlers<
                    com.google.cloud.biglake.hive.v1beta.ListPartitionsRequest,
                    com.google.cloud.biglake.hive.v1beta.ListPartitionsResponse>(
                    service, METHODID_LIST_PARTITIONS)))
        .build();
  }

  private abstract static class HiveMetastoreServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HiveMetastoreServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.biglake.hive.v1beta.HiveMetastoreProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HiveMetastoreService");
    }
  }

  private static final class HiveMetastoreServiceFileDescriptorSupplier
      extends HiveMetastoreServiceBaseDescriptorSupplier {
    HiveMetastoreServiceFileDescriptorSupplier() {}
  }

  private static final class HiveMetastoreServiceMethodDescriptorSupplier
      extends HiveMetastoreServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    HiveMetastoreServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (HiveMetastoreServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new HiveMetastoreServiceFileDescriptorSupplier())
                      .addMethod(getCreateHiveCatalogMethod())
                      .addMethod(getGetHiveCatalogMethod())
                      .addMethod(getListHiveCatalogsMethod())
                      .addMethod(getUpdateHiveCatalogMethod())
                      .addMethod(getDeleteHiveCatalogMethod())
                      .addMethod(getCreateHiveDatabaseMethod())
                      .addMethod(getGetHiveDatabaseMethod())
                      .addMethod(getListHiveDatabasesMethod())
                      .addMethod(getUpdateHiveDatabaseMethod())
                      .addMethod(getDeleteHiveDatabaseMethod())
                      .addMethod(getCreateHiveTableMethod())
                      .addMethod(getGetHiveTableMethod())
                      .addMethod(getListHiveTablesMethod())
                      .addMethod(getUpdateHiveTableMethod())
                      .addMethod(getDeleteHiveTableMethod())
                      .addMethod(getBatchCreatePartitionsMethod())
                      .addMethod(getBatchDeletePartitionsMethod())
                      .addMethod(getBatchUpdatePartitionsMethod())
                      .addMethod(getListPartitionsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
