package com.google.cloud.bigquery.biglake.v1alpha1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
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
    comments = "Source: google/cloud/bigquery/biglake/v1alpha1/metastore.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MetastoreServiceGrpc {

  private MetastoreServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.bigquery.biglake.v1alpha1.MetastoreService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.CreateCatalogRequest,
      com.google.cloud.bigquery.biglake.v1alpha1.Catalog> getCreateCatalogMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCatalog",
      requestType = com.google.cloud.bigquery.biglake.v1alpha1.CreateCatalogRequest.class,
      responseType = com.google.cloud.bigquery.biglake.v1alpha1.Catalog.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.CreateCatalogRequest,
      com.google.cloud.bigquery.biglake.v1alpha1.Catalog> getCreateCatalogMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.CreateCatalogRequest, com.google.cloud.bigquery.biglake.v1alpha1.Catalog> getCreateCatalogMethod;
    if ((getCreateCatalogMethod = MetastoreServiceGrpc.getCreateCatalogMethod) == null) {
      synchronized (MetastoreServiceGrpc.class) {
        if ((getCreateCatalogMethod = MetastoreServiceGrpc.getCreateCatalogMethod) == null) {
          MetastoreServiceGrpc.getCreateCatalogMethod = getCreateCatalogMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.biglake.v1alpha1.CreateCatalogRequest, com.google.cloud.bigquery.biglake.v1alpha1.Catalog>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCatalog"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.biglake.v1alpha1.CreateCatalogRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.biglake.v1alpha1.Catalog.getDefaultInstance()))
              .setSchemaDescriptor(new MetastoreServiceMethodDescriptorSupplier("CreateCatalog"))
              .build();
        }
      }
    }
    return getCreateCatalogMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.DeleteCatalogRequest,
      com.google.cloud.bigquery.biglake.v1alpha1.Catalog> getDeleteCatalogMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCatalog",
      requestType = com.google.cloud.bigquery.biglake.v1alpha1.DeleteCatalogRequest.class,
      responseType = com.google.cloud.bigquery.biglake.v1alpha1.Catalog.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.DeleteCatalogRequest,
      com.google.cloud.bigquery.biglake.v1alpha1.Catalog> getDeleteCatalogMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.DeleteCatalogRequest, com.google.cloud.bigquery.biglake.v1alpha1.Catalog> getDeleteCatalogMethod;
    if ((getDeleteCatalogMethod = MetastoreServiceGrpc.getDeleteCatalogMethod) == null) {
      synchronized (MetastoreServiceGrpc.class) {
        if ((getDeleteCatalogMethod = MetastoreServiceGrpc.getDeleteCatalogMethod) == null) {
          MetastoreServiceGrpc.getDeleteCatalogMethod = getDeleteCatalogMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.biglake.v1alpha1.DeleteCatalogRequest, com.google.cloud.bigquery.biglake.v1alpha1.Catalog>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCatalog"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.biglake.v1alpha1.DeleteCatalogRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.biglake.v1alpha1.Catalog.getDefaultInstance()))
              .setSchemaDescriptor(new MetastoreServiceMethodDescriptorSupplier("DeleteCatalog"))
              .build();
        }
      }
    }
    return getDeleteCatalogMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.GetCatalogRequest,
      com.google.cloud.bigquery.biglake.v1alpha1.Catalog> getGetCatalogMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCatalog",
      requestType = com.google.cloud.bigquery.biglake.v1alpha1.GetCatalogRequest.class,
      responseType = com.google.cloud.bigquery.biglake.v1alpha1.Catalog.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.GetCatalogRequest,
      com.google.cloud.bigquery.biglake.v1alpha1.Catalog> getGetCatalogMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.GetCatalogRequest, com.google.cloud.bigquery.biglake.v1alpha1.Catalog> getGetCatalogMethod;
    if ((getGetCatalogMethod = MetastoreServiceGrpc.getGetCatalogMethod) == null) {
      synchronized (MetastoreServiceGrpc.class) {
        if ((getGetCatalogMethod = MetastoreServiceGrpc.getGetCatalogMethod) == null) {
          MetastoreServiceGrpc.getGetCatalogMethod = getGetCatalogMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.biglake.v1alpha1.GetCatalogRequest, com.google.cloud.bigquery.biglake.v1alpha1.Catalog>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCatalog"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.biglake.v1alpha1.GetCatalogRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.biglake.v1alpha1.Catalog.getDefaultInstance()))
              .setSchemaDescriptor(new MetastoreServiceMethodDescriptorSupplier("GetCatalog"))
              .build();
        }
      }
    }
    return getGetCatalogMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.ListCatalogsRequest,
      com.google.cloud.bigquery.biglake.v1alpha1.ListCatalogsResponse> getListCatalogsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCatalogs",
      requestType = com.google.cloud.bigquery.biglake.v1alpha1.ListCatalogsRequest.class,
      responseType = com.google.cloud.bigquery.biglake.v1alpha1.ListCatalogsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.ListCatalogsRequest,
      com.google.cloud.bigquery.biglake.v1alpha1.ListCatalogsResponse> getListCatalogsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.ListCatalogsRequest, com.google.cloud.bigquery.biglake.v1alpha1.ListCatalogsResponse> getListCatalogsMethod;
    if ((getListCatalogsMethod = MetastoreServiceGrpc.getListCatalogsMethod) == null) {
      synchronized (MetastoreServiceGrpc.class) {
        if ((getListCatalogsMethod = MetastoreServiceGrpc.getListCatalogsMethod) == null) {
          MetastoreServiceGrpc.getListCatalogsMethod = getListCatalogsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.biglake.v1alpha1.ListCatalogsRequest, com.google.cloud.bigquery.biglake.v1alpha1.ListCatalogsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCatalogs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.biglake.v1alpha1.ListCatalogsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.biglake.v1alpha1.ListCatalogsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MetastoreServiceMethodDescriptorSupplier("ListCatalogs"))
              .build();
        }
      }
    }
    return getListCatalogsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.CreateDatabaseRequest,
      com.google.cloud.bigquery.biglake.v1alpha1.Database> getCreateDatabaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDatabase",
      requestType = com.google.cloud.bigquery.biglake.v1alpha1.CreateDatabaseRequest.class,
      responseType = com.google.cloud.bigquery.biglake.v1alpha1.Database.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.CreateDatabaseRequest,
      com.google.cloud.bigquery.biglake.v1alpha1.Database> getCreateDatabaseMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.CreateDatabaseRequest, com.google.cloud.bigquery.biglake.v1alpha1.Database> getCreateDatabaseMethod;
    if ((getCreateDatabaseMethod = MetastoreServiceGrpc.getCreateDatabaseMethod) == null) {
      synchronized (MetastoreServiceGrpc.class) {
        if ((getCreateDatabaseMethod = MetastoreServiceGrpc.getCreateDatabaseMethod) == null) {
          MetastoreServiceGrpc.getCreateDatabaseMethod = getCreateDatabaseMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.biglake.v1alpha1.CreateDatabaseRequest, com.google.cloud.bigquery.biglake.v1alpha1.Database>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDatabase"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.biglake.v1alpha1.CreateDatabaseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.biglake.v1alpha1.Database.getDefaultInstance()))
              .setSchemaDescriptor(new MetastoreServiceMethodDescriptorSupplier("CreateDatabase"))
              .build();
        }
      }
    }
    return getCreateDatabaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.DeleteDatabaseRequest,
      com.google.cloud.bigquery.biglake.v1alpha1.Database> getDeleteDatabaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDatabase",
      requestType = com.google.cloud.bigquery.biglake.v1alpha1.DeleteDatabaseRequest.class,
      responseType = com.google.cloud.bigquery.biglake.v1alpha1.Database.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.DeleteDatabaseRequest,
      com.google.cloud.bigquery.biglake.v1alpha1.Database> getDeleteDatabaseMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.DeleteDatabaseRequest, com.google.cloud.bigquery.biglake.v1alpha1.Database> getDeleteDatabaseMethod;
    if ((getDeleteDatabaseMethod = MetastoreServiceGrpc.getDeleteDatabaseMethod) == null) {
      synchronized (MetastoreServiceGrpc.class) {
        if ((getDeleteDatabaseMethod = MetastoreServiceGrpc.getDeleteDatabaseMethod) == null) {
          MetastoreServiceGrpc.getDeleteDatabaseMethod = getDeleteDatabaseMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.biglake.v1alpha1.DeleteDatabaseRequest, com.google.cloud.bigquery.biglake.v1alpha1.Database>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDatabase"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.biglake.v1alpha1.DeleteDatabaseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.biglake.v1alpha1.Database.getDefaultInstance()))
              .setSchemaDescriptor(new MetastoreServiceMethodDescriptorSupplier("DeleteDatabase"))
              .build();
        }
      }
    }
    return getDeleteDatabaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.UpdateDatabaseRequest,
      com.google.cloud.bigquery.biglake.v1alpha1.Database> getUpdateDatabaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDatabase",
      requestType = com.google.cloud.bigquery.biglake.v1alpha1.UpdateDatabaseRequest.class,
      responseType = com.google.cloud.bigquery.biglake.v1alpha1.Database.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.UpdateDatabaseRequest,
      com.google.cloud.bigquery.biglake.v1alpha1.Database> getUpdateDatabaseMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.UpdateDatabaseRequest, com.google.cloud.bigquery.biglake.v1alpha1.Database> getUpdateDatabaseMethod;
    if ((getUpdateDatabaseMethod = MetastoreServiceGrpc.getUpdateDatabaseMethod) == null) {
      synchronized (MetastoreServiceGrpc.class) {
        if ((getUpdateDatabaseMethod = MetastoreServiceGrpc.getUpdateDatabaseMethod) == null) {
          MetastoreServiceGrpc.getUpdateDatabaseMethod = getUpdateDatabaseMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.biglake.v1alpha1.UpdateDatabaseRequest, com.google.cloud.bigquery.biglake.v1alpha1.Database>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDatabase"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.biglake.v1alpha1.UpdateDatabaseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.biglake.v1alpha1.Database.getDefaultInstance()))
              .setSchemaDescriptor(new MetastoreServiceMethodDescriptorSupplier("UpdateDatabase"))
              .build();
        }
      }
    }
    return getUpdateDatabaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.GetDatabaseRequest,
      com.google.cloud.bigquery.biglake.v1alpha1.Database> getGetDatabaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDatabase",
      requestType = com.google.cloud.bigquery.biglake.v1alpha1.GetDatabaseRequest.class,
      responseType = com.google.cloud.bigquery.biglake.v1alpha1.Database.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.GetDatabaseRequest,
      com.google.cloud.bigquery.biglake.v1alpha1.Database> getGetDatabaseMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.GetDatabaseRequest, com.google.cloud.bigquery.biglake.v1alpha1.Database> getGetDatabaseMethod;
    if ((getGetDatabaseMethod = MetastoreServiceGrpc.getGetDatabaseMethod) == null) {
      synchronized (MetastoreServiceGrpc.class) {
        if ((getGetDatabaseMethod = MetastoreServiceGrpc.getGetDatabaseMethod) == null) {
          MetastoreServiceGrpc.getGetDatabaseMethod = getGetDatabaseMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.biglake.v1alpha1.GetDatabaseRequest, com.google.cloud.bigquery.biglake.v1alpha1.Database>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDatabase"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.biglake.v1alpha1.GetDatabaseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.biglake.v1alpha1.Database.getDefaultInstance()))
              .setSchemaDescriptor(new MetastoreServiceMethodDescriptorSupplier("GetDatabase"))
              .build();
        }
      }
    }
    return getGetDatabaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.ListDatabasesRequest,
      com.google.cloud.bigquery.biglake.v1alpha1.ListDatabasesResponse> getListDatabasesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDatabases",
      requestType = com.google.cloud.bigquery.biglake.v1alpha1.ListDatabasesRequest.class,
      responseType = com.google.cloud.bigquery.biglake.v1alpha1.ListDatabasesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.ListDatabasesRequest,
      com.google.cloud.bigquery.biglake.v1alpha1.ListDatabasesResponse> getListDatabasesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.ListDatabasesRequest, com.google.cloud.bigquery.biglake.v1alpha1.ListDatabasesResponse> getListDatabasesMethod;
    if ((getListDatabasesMethod = MetastoreServiceGrpc.getListDatabasesMethod) == null) {
      synchronized (MetastoreServiceGrpc.class) {
        if ((getListDatabasesMethod = MetastoreServiceGrpc.getListDatabasesMethod) == null) {
          MetastoreServiceGrpc.getListDatabasesMethod = getListDatabasesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.biglake.v1alpha1.ListDatabasesRequest, com.google.cloud.bigquery.biglake.v1alpha1.ListDatabasesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDatabases"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.biglake.v1alpha1.ListDatabasesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.biglake.v1alpha1.ListDatabasesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MetastoreServiceMethodDescriptorSupplier("ListDatabases"))
              .build();
        }
      }
    }
    return getListDatabasesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.CreateTableRequest,
      com.google.cloud.bigquery.biglake.v1alpha1.Table> getCreateTableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTable",
      requestType = com.google.cloud.bigquery.biglake.v1alpha1.CreateTableRequest.class,
      responseType = com.google.cloud.bigquery.biglake.v1alpha1.Table.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.CreateTableRequest,
      com.google.cloud.bigquery.biglake.v1alpha1.Table> getCreateTableMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.CreateTableRequest, com.google.cloud.bigquery.biglake.v1alpha1.Table> getCreateTableMethod;
    if ((getCreateTableMethod = MetastoreServiceGrpc.getCreateTableMethod) == null) {
      synchronized (MetastoreServiceGrpc.class) {
        if ((getCreateTableMethod = MetastoreServiceGrpc.getCreateTableMethod) == null) {
          MetastoreServiceGrpc.getCreateTableMethod = getCreateTableMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.biglake.v1alpha1.CreateTableRequest, com.google.cloud.bigquery.biglake.v1alpha1.Table>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTable"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.biglake.v1alpha1.CreateTableRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.biglake.v1alpha1.Table.getDefaultInstance()))
              .setSchemaDescriptor(new MetastoreServiceMethodDescriptorSupplier("CreateTable"))
              .build();
        }
      }
    }
    return getCreateTableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.DeleteTableRequest,
      com.google.cloud.bigquery.biglake.v1alpha1.Table> getDeleteTableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTable",
      requestType = com.google.cloud.bigquery.biglake.v1alpha1.DeleteTableRequest.class,
      responseType = com.google.cloud.bigquery.biglake.v1alpha1.Table.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.DeleteTableRequest,
      com.google.cloud.bigquery.biglake.v1alpha1.Table> getDeleteTableMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.DeleteTableRequest, com.google.cloud.bigquery.biglake.v1alpha1.Table> getDeleteTableMethod;
    if ((getDeleteTableMethod = MetastoreServiceGrpc.getDeleteTableMethod) == null) {
      synchronized (MetastoreServiceGrpc.class) {
        if ((getDeleteTableMethod = MetastoreServiceGrpc.getDeleteTableMethod) == null) {
          MetastoreServiceGrpc.getDeleteTableMethod = getDeleteTableMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.biglake.v1alpha1.DeleteTableRequest, com.google.cloud.bigquery.biglake.v1alpha1.Table>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTable"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.biglake.v1alpha1.DeleteTableRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.biglake.v1alpha1.Table.getDefaultInstance()))
              .setSchemaDescriptor(new MetastoreServiceMethodDescriptorSupplier("DeleteTable"))
              .build();
        }
      }
    }
    return getDeleteTableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.UpdateTableRequest,
      com.google.cloud.bigquery.biglake.v1alpha1.Table> getUpdateTableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTable",
      requestType = com.google.cloud.bigquery.biglake.v1alpha1.UpdateTableRequest.class,
      responseType = com.google.cloud.bigquery.biglake.v1alpha1.Table.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.UpdateTableRequest,
      com.google.cloud.bigquery.biglake.v1alpha1.Table> getUpdateTableMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.UpdateTableRequest, com.google.cloud.bigquery.biglake.v1alpha1.Table> getUpdateTableMethod;
    if ((getUpdateTableMethod = MetastoreServiceGrpc.getUpdateTableMethod) == null) {
      synchronized (MetastoreServiceGrpc.class) {
        if ((getUpdateTableMethod = MetastoreServiceGrpc.getUpdateTableMethod) == null) {
          MetastoreServiceGrpc.getUpdateTableMethod = getUpdateTableMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.biglake.v1alpha1.UpdateTableRequest, com.google.cloud.bigquery.biglake.v1alpha1.Table>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTable"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.biglake.v1alpha1.UpdateTableRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.biglake.v1alpha1.Table.getDefaultInstance()))
              .setSchemaDescriptor(new MetastoreServiceMethodDescriptorSupplier("UpdateTable"))
              .build();
        }
      }
    }
    return getUpdateTableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.RenameTableRequest,
      com.google.cloud.bigquery.biglake.v1alpha1.Table> getRenameTableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RenameTable",
      requestType = com.google.cloud.bigquery.biglake.v1alpha1.RenameTableRequest.class,
      responseType = com.google.cloud.bigquery.biglake.v1alpha1.Table.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.RenameTableRequest,
      com.google.cloud.bigquery.biglake.v1alpha1.Table> getRenameTableMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.RenameTableRequest, com.google.cloud.bigquery.biglake.v1alpha1.Table> getRenameTableMethod;
    if ((getRenameTableMethod = MetastoreServiceGrpc.getRenameTableMethod) == null) {
      synchronized (MetastoreServiceGrpc.class) {
        if ((getRenameTableMethod = MetastoreServiceGrpc.getRenameTableMethod) == null) {
          MetastoreServiceGrpc.getRenameTableMethod = getRenameTableMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.biglake.v1alpha1.RenameTableRequest, com.google.cloud.bigquery.biglake.v1alpha1.Table>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RenameTable"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.biglake.v1alpha1.RenameTableRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.biglake.v1alpha1.Table.getDefaultInstance()))
              .setSchemaDescriptor(new MetastoreServiceMethodDescriptorSupplier("RenameTable"))
              .build();
        }
      }
    }
    return getRenameTableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.GetTableRequest,
      com.google.cloud.bigquery.biglake.v1alpha1.Table> getGetTableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTable",
      requestType = com.google.cloud.bigquery.biglake.v1alpha1.GetTableRequest.class,
      responseType = com.google.cloud.bigquery.biglake.v1alpha1.Table.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.GetTableRequest,
      com.google.cloud.bigquery.biglake.v1alpha1.Table> getGetTableMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.GetTableRequest, com.google.cloud.bigquery.biglake.v1alpha1.Table> getGetTableMethod;
    if ((getGetTableMethod = MetastoreServiceGrpc.getGetTableMethod) == null) {
      synchronized (MetastoreServiceGrpc.class) {
        if ((getGetTableMethod = MetastoreServiceGrpc.getGetTableMethod) == null) {
          MetastoreServiceGrpc.getGetTableMethod = getGetTableMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.biglake.v1alpha1.GetTableRequest, com.google.cloud.bigquery.biglake.v1alpha1.Table>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTable"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.biglake.v1alpha1.GetTableRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.biglake.v1alpha1.Table.getDefaultInstance()))
              .setSchemaDescriptor(new MetastoreServiceMethodDescriptorSupplier("GetTable"))
              .build();
        }
      }
    }
    return getGetTableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.ListTablesRequest,
      com.google.cloud.bigquery.biglake.v1alpha1.ListTablesResponse> getListTablesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTables",
      requestType = com.google.cloud.bigquery.biglake.v1alpha1.ListTablesRequest.class,
      responseType = com.google.cloud.bigquery.biglake.v1alpha1.ListTablesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.ListTablesRequest,
      com.google.cloud.bigquery.biglake.v1alpha1.ListTablesResponse> getListTablesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.ListTablesRequest, com.google.cloud.bigquery.biglake.v1alpha1.ListTablesResponse> getListTablesMethod;
    if ((getListTablesMethod = MetastoreServiceGrpc.getListTablesMethod) == null) {
      synchronized (MetastoreServiceGrpc.class) {
        if ((getListTablesMethod = MetastoreServiceGrpc.getListTablesMethod) == null) {
          MetastoreServiceGrpc.getListTablesMethod = getListTablesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.biglake.v1alpha1.ListTablesRequest, com.google.cloud.bigquery.biglake.v1alpha1.ListTablesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTables"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.biglake.v1alpha1.ListTablesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.biglake.v1alpha1.ListTablesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MetastoreServiceMethodDescriptorSupplier("ListTables"))
              .build();
        }
      }
    }
    return getListTablesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.CreateLockRequest,
      com.google.cloud.bigquery.biglake.v1alpha1.Lock> getCreateLockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateLock",
      requestType = com.google.cloud.bigquery.biglake.v1alpha1.CreateLockRequest.class,
      responseType = com.google.cloud.bigquery.biglake.v1alpha1.Lock.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.CreateLockRequest,
      com.google.cloud.bigquery.biglake.v1alpha1.Lock> getCreateLockMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.CreateLockRequest, com.google.cloud.bigquery.biglake.v1alpha1.Lock> getCreateLockMethod;
    if ((getCreateLockMethod = MetastoreServiceGrpc.getCreateLockMethod) == null) {
      synchronized (MetastoreServiceGrpc.class) {
        if ((getCreateLockMethod = MetastoreServiceGrpc.getCreateLockMethod) == null) {
          MetastoreServiceGrpc.getCreateLockMethod = getCreateLockMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.biglake.v1alpha1.CreateLockRequest, com.google.cloud.bigquery.biglake.v1alpha1.Lock>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateLock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.biglake.v1alpha1.CreateLockRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.biglake.v1alpha1.Lock.getDefaultInstance()))
              .setSchemaDescriptor(new MetastoreServiceMethodDescriptorSupplier("CreateLock"))
              .build();
        }
      }
    }
    return getCreateLockMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.DeleteLockRequest,
      com.google.protobuf.Empty> getDeleteLockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteLock",
      requestType = com.google.cloud.bigquery.biglake.v1alpha1.DeleteLockRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.DeleteLockRequest,
      com.google.protobuf.Empty> getDeleteLockMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.DeleteLockRequest, com.google.protobuf.Empty> getDeleteLockMethod;
    if ((getDeleteLockMethod = MetastoreServiceGrpc.getDeleteLockMethod) == null) {
      synchronized (MetastoreServiceGrpc.class) {
        if ((getDeleteLockMethod = MetastoreServiceGrpc.getDeleteLockMethod) == null) {
          MetastoreServiceGrpc.getDeleteLockMethod = getDeleteLockMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.biglake.v1alpha1.DeleteLockRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteLock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.biglake.v1alpha1.DeleteLockRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new MetastoreServiceMethodDescriptorSupplier("DeleteLock"))
              .build();
        }
      }
    }
    return getDeleteLockMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.CheckLockRequest,
      com.google.cloud.bigquery.biglake.v1alpha1.Lock> getCheckLockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckLock",
      requestType = com.google.cloud.bigquery.biglake.v1alpha1.CheckLockRequest.class,
      responseType = com.google.cloud.bigquery.biglake.v1alpha1.Lock.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.CheckLockRequest,
      com.google.cloud.bigquery.biglake.v1alpha1.Lock> getCheckLockMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.CheckLockRequest, com.google.cloud.bigquery.biglake.v1alpha1.Lock> getCheckLockMethod;
    if ((getCheckLockMethod = MetastoreServiceGrpc.getCheckLockMethod) == null) {
      synchronized (MetastoreServiceGrpc.class) {
        if ((getCheckLockMethod = MetastoreServiceGrpc.getCheckLockMethod) == null) {
          MetastoreServiceGrpc.getCheckLockMethod = getCheckLockMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.biglake.v1alpha1.CheckLockRequest, com.google.cloud.bigquery.biglake.v1alpha1.Lock>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CheckLock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.biglake.v1alpha1.CheckLockRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.biglake.v1alpha1.Lock.getDefaultInstance()))
              .setSchemaDescriptor(new MetastoreServiceMethodDescriptorSupplier("CheckLock"))
              .build();
        }
      }
    }
    return getCheckLockMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.ListLocksRequest,
      com.google.cloud.bigquery.biglake.v1alpha1.ListLocksResponse> getListLocksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListLocks",
      requestType = com.google.cloud.bigquery.biglake.v1alpha1.ListLocksRequest.class,
      responseType = com.google.cloud.bigquery.biglake.v1alpha1.ListLocksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.ListLocksRequest,
      com.google.cloud.bigquery.biglake.v1alpha1.ListLocksResponse> getListLocksMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.biglake.v1alpha1.ListLocksRequest, com.google.cloud.bigquery.biglake.v1alpha1.ListLocksResponse> getListLocksMethod;
    if ((getListLocksMethod = MetastoreServiceGrpc.getListLocksMethod) == null) {
      synchronized (MetastoreServiceGrpc.class) {
        if ((getListLocksMethod = MetastoreServiceGrpc.getListLocksMethod) == null) {
          MetastoreServiceGrpc.getListLocksMethod = getListLocksMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.biglake.v1alpha1.ListLocksRequest, com.google.cloud.bigquery.biglake.v1alpha1.ListLocksResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListLocks"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.biglake.v1alpha1.ListLocksRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.biglake.v1alpha1.ListLocksResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MetastoreServiceMethodDescriptorSupplier("ListLocks"))
              .build();
        }
      }
    }
    return getListLocksMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MetastoreServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MetastoreServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MetastoreServiceStub>() {
        @java.lang.Override
        public MetastoreServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MetastoreServiceStub(channel, callOptions);
        }
      };
    return MetastoreServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MetastoreServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MetastoreServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MetastoreServiceBlockingStub>() {
        @java.lang.Override
        public MetastoreServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MetastoreServiceBlockingStub(channel, callOptions);
        }
      };
    return MetastoreServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MetastoreServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MetastoreServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MetastoreServiceFutureStub>() {
        @java.lang.Override
        public MetastoreServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MetastoreServiceFutureStub(channel, callOptions);
        }
      };
    return MetastoreServiceFutureStub.newStub(factory, channel);
  }

  /**
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
     * <pre>
     * Creates a new catalog.
     * </pre>
     */
    default void createCatalog(com.google.cloud.bigquery.biglake.v1alpha1.CreateCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Catalog> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateCatalogMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes an existing catalog specified by the catalog ID.
     * </pre>
     */
    default void deleteCatalog(com.google.cloud.bigquery.biglake.v1alpha1.DeleteCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Catalog> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteCatalogMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the catalog specified by the resource name.
     * </pre>
     */
    default void getCatalog(com.google.cloud.bigquery.biglake.v1alpha1.GetCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Catalog> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCatalogMethod(), responseObserver);
    }

    /**
     * <pre>
     * List all catalogs in a specified project.
     * </pre>
     */
    default void listCatalogs(com.google.cloud.bigquery.biglake.v1alpha1.ListCatalogsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.ListCatalogsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListCatalogsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new database.
     * </pre>
     */
    default void createDatabase(com.google.cloud.bigquery.biglake.v1alpha1.CreateDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Database> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateDatabaseMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes an existing database specified by the database ID.
     * </pre>
     */
    default void deleteDatabase(com.google.cloud.bigquery.biglake.v1alpha1.DeleteDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Database> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteDatabaseMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates an existing database specified by the database ID.
     * </pre>
     */
    default void updateDatabase(com.google.cloud.bigquery.biglake.v1alpha1.UpdateDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Database> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateDatabaseMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the database specified by the resource name.
     * </pre>
     */
    default void getDatabase(com.google.cloud.bigquery.biglake.v1alpha1.GetDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Database> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetDatabaseMethod(), responseObserver);
    }

    /**
     * <pre>
     * List all databases in a specified catalog.
     * </pre>
     */
    default void listDatabases(com.google.cloud.bigquery.biglake.v1alpha1.ListDatabasesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.ListDatabasesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListDatabasesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new table.
     * </pre>
     */
    default void createTable(com.google.cloud.bigquery.biglake.v1alpha1.CreateTableRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Table> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateTableMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes an existing table specified by the table ID.
     * </pre>
     */
    default void deleteTable(com.google.cloud.bigquery.biglake.v1alpha1.DeleteTableRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Table> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteTableMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates an existing table specified by the table ID.
     * </pre>
     */
    default void updateTable(com.google.cloud.bigquery.biglake.v1alpha1.UpdateTableRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Table> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateTableMethod(), responseObserver);
    }

    /**
     * <pre>
     * Renames an existing table specified by the table ID.
     * </pre>
     */
    default void renameTable(com.google.cloud.bigquery.biglake.v1alpha1.RenameTableRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Table> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRenameTableMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the table specified by the resource name.
     * </pre>
     */
    default void getTable(com.google.cloud.bigquery.biglake.v1alpha1.GetTableRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Table> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTableMethod(), responseObserver);
    }

    /**
     * <pre>
     * List all tables in a specified database.
     * </pre>
     */
    default void listTables(com.google.cloud.bigquery.biglake.v1alpha1.ListTablesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.ListTablesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListTablesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new lock.
     * </pre>
     */
    default void createLock(com.google.cloud.bigquery.biglake.v1alpha1.CreateLockRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Lock> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateLockMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes an existing lock specified by the lock ID.
     * </pre>
     */
    default void deleteLock(com.google.cloud.bigquery.biglake.v1alpha1.DeleteLockRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteLockMethod(), responseObserver);
    }

    /**
     * <pre>
     * Checks the state of a lock specified by the lock ID.
     * </pre>
     */
    default void checkLock(com.google.cloud.bigquery.biglake.v1alpha1.CheckLockRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Lock> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCheckLockMethod(), responseObserver);
    }

    /**
     * <pre>
     * List all locks in a specified database.
     * </pre>
     */
    default void listLocks(com.google.cloud.bigquery.biglake.v1alpha1.ListLocksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.ListLocksResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListLocksMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service MetastoreService.
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
  public static abstract class MetastoreServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return MetastoreServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service MetastoreService.
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
    private MetastoreServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MetastoreServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MetastoreServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a new catalog.
     * </pre>
     */
    public void createCatalog(com.google.cloud.bigquery.biglake.v1alpha1.CreateCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Catalog> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCatalogMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes an existing catalog specified by the catalog ID.
     * </pre>
     */
    public void deleteCatalog(com.google.cloud.bigquery.biglake.v1alpha1.DeleteCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Catalog> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCatalogMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the catalog specified by the resource name.
     * </pre>
     */
    public void getCatalog(com.google.cloud.bigquery.biglake.v1alpha1.GetCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Catalog> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCatalogMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * List all catalogs in a specified project.
     * </pre>
     */
    public void listCatalogs(com.google.cloud.bigquery.biglake.v1alpha1.ListCatalogsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.ListCatalogsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCatalogsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new database.
     * </pre>
     */
    public void createDatabase(com.google.cloud.bigquery.biglake.v1alpha1.CreateDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Database> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDatabaseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes an existing database specified by the database ID.
     * </pre>
     */
    public void deleteDatabase(com.google.cloud.bigquery.biglake.v1alpha1.DeleteDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Database> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDatabaseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates an existing database specified by the database ID.
     * </pre>
     */
    public void updateDatabase(com.google.cloud.bigquery.biglake.v1alpha1.UpdateDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Database> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDatabaseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the database specified by the resource name.
     * </pre>
     */
    public void getDatabase(com.google.cloud.bigquery.biglake.v1alpha1.GetDatabaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Database> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDatabaseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * List all databases in a specified catalog.
     * </pre>
     */
    public void listDatabases(com.google.cloud.bigquery.biglake.v1alpha1.ListDatabasesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.ListDatabasesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDatabasesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new table.
     * </pre>
     */
    public void createTable(com.google.cloud.bigquery.biglake.v1alpha1.CreateTableRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Table> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTableMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes an existing table specified by the table ID.
     * </pre>
     */
    public void deleteTable(com.google.cloud.bigquery.biglake.v1alpha1.DeleteTableRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Table> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTableMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates an existing table specified by the table ID.
     * </pre>
     */
    public void updateTable(com.google.cloud.bigquery.biglake.v1alpha1.UpdateTableRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Table> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTableMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Renames an existing table specified by the table ID.
     * </pre>
     */
    public void renameTable(com.google.cloud.bigquery.biglake.v1alpha1.RenameTableRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Table> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRenameTableMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the table specified by the resource name.
     * </pre>
     */
    public void getTable(com.google.cloud.bigquery.biglake.v1alpha1.GetTableRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Table> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTableMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * List all tables in a specified database.
     * </pre>
     */
    public void listTables(com.google.cloud.bigquery.biglake.v1alpha1.ListTablesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.ListTablesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTablesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new lock.
     * </pre>
     */
    public void createLock(com.google.cloud.bigquery.biglake.v1alpha1.CreateLockRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Lock> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateLockMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes an existing lock specified by the lock ID.
     * </pre>
     */
    public void deleteLock(com.google.cloud.bigquery.biglake.v1alpha1.DeleteLockRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteLockMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Checks the state of a lock specified by the lock ID.
     * </pre>
     */
    public void checkLock(com.google.cloud.bigquery.biglake.v1alpha1.CheckLockRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Lock> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCheckLockMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * List all locks in a specified database.
     * </pre>
     */
    public void listLocks(com.google.cloud.bigquery.biglake.v1alpha1.ListLocksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.ListLocksResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListLocksMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service MetastoreService.
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
    private MetastoreServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MetastoreServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MetastoreServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a new catalog.
     * </pre>
     */
    public com.google.cloud.bigquery.biglake.v1alpha1.Catalog createCatalog(com.google.cloud.bigquery.biglake.v1alpha1.CreateCatalogRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCatalogMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes an existing catalog specified by the catalog ID.
     * </pre>
     */
    public com.google.cloud.bigquery.biglake.v1alpha1.Catalog deleteCatalog(com.google.cloud.bigquery.biglake.v1alpha1.DeleteCatalogRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCatalogMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the catalog specified by the resource name.
     * </pre>
     */
    public com.google.cloud.bigquery.biglake.v1alpha1.Catalog getCatalog(com.google.cloud.bigquery.biglake.v1alpha1.GetCatalogRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCatalogMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * List all catalogs in a specified project.
     * </pre>
     */
    public com.google.cloud.bigquery.biglake.v1alpha1.ListCatalogsResponse listCatalogs(com.google.cloud.bigquery.biglake.v1alpha1.ListCatalogsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCatalogsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new database.
     * </pre>
     */
    public com.google.cloud.bigquery.biglake.v1alpha1.Database createDatabase(com.google.cloud.bigquery.biglake.v1alpha1.CreateDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDatabaseMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes an existing database specified by the database ID.
     * </pre>
     */
    public com.google.cloud.bigquery.biglake.v1alpha1.Database deleteDatabase(com.google.cloud.bigquery.biglake.v1alpha1.DeleteDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDatabaseMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates an existing database specified by the database ID.
     * </pre>
     */
    public com.google.cloud.bigquery.biglake.v1alpha1.Database updateDatabase(com.google.cloud.bigquery.biglake.v1alpha1.UpdateDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDatabaseMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the database specified by the resource name.
     * </pre>
     */
    public com.google.cloud.bigquery.biglake.v1alpha1.Database getDatabase(com.google.cloud.bigquery.biglake.v1alpha1.GetDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDatabaseMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * List all databases in a specified catalog.
     * </pre>
     */
    public com.google.cloud.bigquery.biglake.v1alpha1.ListDatabasesResponse listDatabases(com.google.cloud.bigquery.biglake.v1alpha1.ListDatabasesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDatabasesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new table.
     * </pre>
     */
    public com.google.cloud.bigquery.biglake.v1alpha1.Table createTable(com.google.cloud.bigquery.biglake.v1alpha1.CreateTableRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTableMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes an existing table specified by the table ID.
     * </pre>
     */
    public com.google.cloud.bigquery.biglake.v1alpha1.Table deleteTable(com.google.cloud.bigquery.biglake.v1alpha1.DeleteTableRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTableMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates an existing table specified by the table ID.
     * </pre>
     */
    public com.google.cloud.bigquery.biglake.v1alpha1.Table updateTable(com.google.cloud.bigquery.biglake.v1alpha1.UpdateTableRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTableMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Renames an existing table specified by the table ID.
     * </pre>
     */
    public com.google.cloud.bigquery.biglake.v1alpha1.Table renameTable(com.google.cloud.bigquery.biglake.v1alpha1.RenameTableRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRenameTableMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the table specified by the resource name.
     * </pre>
     */
    public com.google.cloud.bigquery.biglake.v1alpha1.Table getTable(com.google.cloud.bigquery.biglake.v1alpha1.GetTableRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTableMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * List all tables in a specified database.
     * </pre>
     */
    public com.google.cloud.bigquery.biglake.v1alpha1.ListTablesResponse listTables(com.google.cloud.bigquery.biglake.v1alpha1.ListTablesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTablesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new lock.
     * </pre>
     */
    public com.google.cloud.bigquery.biglake.v1alpha1.Lock createLock(com.google.cloud.bigquery.biglake.v1alpha1.CreateLockRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateLockMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes an existing lock specified by the lock ID.
     * </pre>
     */
    public com.google.protobuf.Empty deleteLock(com.google.cloud.bigquery.biglake.v1alpha1.DeleteLockRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteLockMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Checks the state of a lock specified by the lock ID.
     * </pre>
     */
    public com.google.cloud.bigquery.biglake.v1alpha1.Lock checkLock(com.google.cloud.bigquery.biglake.v1alpha1.CheckLockRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckLockMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * List all locks in a specified database.
     * </pre>
     */
    public com.google.cloud.bigquery.biglake.v1alpha1.ListLocksResponse listLocks(com.google.cloud.bigquery.biglake.v1alpha1.ListLocksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListLocksMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service MetastoreService.
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
    private MetastoreServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MetastoreServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MetastoreServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a new catalog.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.biglake.v1alpha1.Catalog> createCatalog(
        com.google.cloud.bigquery.biglake.v1alpha1.CreateCatalogRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCatalogMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes an existing catalog specified by the catalog ID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.biglake.v1alpha1.Catalog> deleteCatalog(
        com.google.cloud.bigquery.biglake.v1alpha1.DeleteCatalogRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCatalogMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the catalog specified by the resource name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.biglake.v1alpha1.Catalog> getCatalog(
        com.google.cloud.bigquery.biglake.v1alpha1.GetCatalogRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCatalogMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * List all catalogs in a specified project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.biglake.v1alpha1.ListCatalogsResponse> listCatalogs(
        com.google.cloud.bigquery.biglake.v1alpha1.ListCatalogsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCatalogsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new database.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.biglake.v1alpha1.Database> createDatabase(
        com.google.cloud.bigquery.biglake.v1alpha1.CreateDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDatabaseMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes an existing database specified by the database ID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.biglake.v1alpha1.Database> deleteDatabase(
        com.google.cloud.bigquery.biglake.v1alpha1.DeleteDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDatabaseMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates an existing database specified by the database ID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.biglake.v1alpha1.Database> updateDatabase(
        com.google.cloud.bigquery.biglake.v1alpha1.UpdateDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDatabaseMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the database specified by the resource name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.biglake.v1alpha1.Database> getDatabase(
        com.google.cloud.bigquery.biglake.v1alpha1.GetDatabaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDatabaseMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * List all databases in a specified catalog.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.biglake.v1alpha1.ListDatabasesResponse> listDatabases(
        com.google.cloud.bigquery.biglake.v1alpha1.ListDatabasesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDatabasesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new table.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.biglake.v1alpha1.Table> createTable(
        com.google.cloud.bigquery.biglake.v1alpha1.CreateTableRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTableMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes an existing table specified by the table ID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.biglake.v1alpha1.Table> deleteTable(
        com.google.cloud.bigquery.biglake.v1alpha1.DeleteTableRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTableMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates an existing table specified by the table ID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.biglake.v1alpha1.Table> updateTable(
        com.google.cloud.bigquery.biglake.v1alpha1.UpdateTableRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTableMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Renames an existing table specified by the table ID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.biglake.v1alpha1.Table> renameTable(
        com.google.cloud.bigquery.biglake.v1alpha1.RenameTableRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRenameTableMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the table specified by the resource name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.biglake.v1alpha1.Table> getTable(
        com.google.cloud.bigquery.biglake.v1alpha1.GetTableRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTableMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * List all tables in a specified database.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.biglake.v1alpha1.ListTablesResponse> listTables(
        com.google.cloud.bigquery.biglake.v1alpha1.ListTablesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTablesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new lock.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.biglake.v1alpha1.Lock> createLock(
        com.google.cloud.bigquery.biglake.v1alpha1.CreateLockRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateLockMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes an existing lock specified by the lock ID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteLock(
        com.google.cloud.bigquery.biglake.v1alpha1.DeleteLockRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteLockMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Checks the state of a lock specified by the lock ID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.biglake.v1alpha1.Lock> checkLock(
        com.google.cloud.bigquery.biglake.v1alpha1.CheckLockRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCheckLockMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * List all locks in a specified database.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.biglake.v1alpha1.ListLocksResponse> listLocks(
        com.google.cloud.bigquery.biglake.v1alpha1.ListLocksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListLocksMethod(), getCallOptions()), request);
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
  private static final int METHODID_CREATE_LOCK = 15;
  private static final int METHODID_DELETE_LOCK = 16;
  private static final int METHODID_CHECK_LOCK = 17;
  private static final int METHODID_LIST_LOCKS = 18;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
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
          serviceImpl.createCatalog((com.google.cloud.bigquery.biglake.v1alpha1.CreateCatalogRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Catalog>) responseObserver);
          break;
        case METHODID_DELETE_CATALOG:
          serviceImpl.deleteCatalog((com.google.cloud.bigquery.biglake.v1alpha1.DeleteCatalogRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Catalog>) responseObserver);
          break;
        case METHODID_GET_CATALOG:
          serviceImpl.getCatalog((com.google.cloud.bigquery.biglake.v1alpha1.GetCatalogRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Catalog>) responseObserver);
          break;
        case METHODID_LIST_CATALOGS:
          serviceImpl.listCatalogs((com.google.cloud.bigquery.biglake.v1alpha1.ListCatalogsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.ListCatalogsResponse>) responseObserver);
          break;
        case METHODID_CREATE_DATABASE:
          serviceImpl.createDatabase((com.google.cloud.bigquery.biglake.v1alpha1.CreateDatabaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Database>) responseObserver);
          break;
        case METHODID_DELETE_DATABASE:
          serviceImpl.deleteDatabase((com.google.cloud.bigquery.biglake.v1alpha1.DeleteDatabaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Database>) responseObserver);
          break;
        case METHODID_UPDATE_DATABASE:
          serviceImpl.updateDatabase((com.google.cloud.bigquery.biglake.v1alpha1.UpdateDatabaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Database>) responseObserver);
          break;
        case METHODID_GET_DATABASE:
          serviceImpl.getDatabase((com.google.cloud.bigquery.biglake.v1alpha1.GetDatabaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Database>) responseObserver);
          break;
        case METHODID_LIST_DATABASES:
          serviceImpl.listDatabases((com.google.cloud.bigquery.biglake.v1alpha1.ListDatabasesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.ListDatabasesResponse>) responseObserver);
          break;
        case METHODID_CREATE_TABLE:
          serviceImpl.createTable((com.google.cloud.bigquery.biglake.v1alpha1.CreateTableRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Table>) responseObserver);
          break;
        case METHODID_DELETE_TABLE:
          serviceImpl.deleteTable((com.google.cloud.bigquery.biglake.v1alpha1.DeleteTableRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Table>) responseObserver);
          break;
        case METHODID_UPDATE_TABLE:
          serviceImpl.updateTable((com.google.cloud.bigquery.biglake.v1alpha1.UpdateTableRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Table>) responseObserver);
          break;
        case METHODID_RENAME_TABLE:
          serviceImpl.renameTable((com.google.cloud.bigquery.biglake.v1alpha1.RenameTableRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Table>) responseObserver);
          break;
        case METHODID_GET_TABLE:
          serviceImpl.getTable((com.google.cloud.bigquery.biglake.v1alpha1.GetTableRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Table>) responseObserver);
          break;
        case METHODID_LIST_TABLES:
          serviceImpl.listTables((com.google.cloud.bigquery.biglake.v1alpha1.ListTablesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.ListTablesResponse>) responseObserver);
          break;
        case METHODID_CREATE_LOCK:
          serviceImpl.createLock((com.google.cloud.bigquery.biglake.v1alpha1.CreateLockRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Lock>) responseObserver);
          break;
        case METHODID_DELETE_LOCK:
          serviceImpl.deleteLock((com.google.cloud.bigquery.biglake.v1alpha1.DeleteLockRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CHECK_LOCK:
          serviceImpl.checkLock((com.google.cloud.bigquery.biglake.v1alpha1.CheckLockRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.Lock>) responseObserver);
          break;
        case METHODID_LIST_LOCKS:
          serviceImpl.listLocks((com.google.cloud.bigquery.biglake.v1alpha1.ListLocksRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.biglake.v1alpha1.ListLocksResponse>) responseObserver);
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
              com.google.cloud.bigquery.biglake.v1alpha1.CreateCatalogRequest,
              com.google.cloud.bigquery.biglake.v1alpha1.Catalog>(
                service, METHODID_CREATE_CATALOG)))
        .addMethod(
          getDeleteCatalogMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.bigquery.biglake.v1alpha1.DeleteCatalogRequest,
              com.google.cloud.bigquery.biglake.v1alpha1.Catalog>(
                service, METHODID_DELETE_CATALOG)))
        .addMethod(
          getGetCatalogMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.bigquery.biglake.v1alpha1.GetCatalogRequest,
              com.google.cloud.bigquery.biglake.v1alpha1.Catalog>(
                service, METHODID_GET_CATALOG)))
        .addMethod(
          getListCatalogsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.bigquery.biglake.v1alpha1.ListCatalogsRequest,
              com.google.cloud.bigquery.biglake.v1alpha1.ListCatalogsResponse>(
                service, METHODID_LIST_CATALOGS)))
        .addMethod(
          getCreateDatabaseMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.bigquery.biglake.v1alpha1.CreateDatabaseRequest,
              com.google.cloud.bigquery.biglake.v1alpha1.Database>(
                service, METHODID_CREATE_DATABASE)))
        .addMethod(
          getDeleteDatabaseMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.bigquery.biglake.v1alpha1.DeleteDatabaseRequest,
              com.google.cloud.bigquery.biglake.v1alpha1.Database>(
                service, METHODID_DELETE_DATABASE)))
        .addMethod(
          getUpdateDatabaseMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.bigquery.biglake.v1alpha1.UpdateDatabaseRequest,
              com.google.cloud.bigquery.biglake.v1alpha1.Database>(
                service, METHODID_UPDATE_DATABASE)))
        .addMethod(
          getGetDatabaseMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.bigquery.biglake.v1alpha1.GetDatabaseRequest,
              com.google.cloud.bigquery.biglake.v1alpha1.Database>(
                service, METHODID_GET_DATABASE)))
        .addMethod(
          getListDatabasesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.bigquery.biglake.v1alpha1.ListDatabasesRequest,
              com.google.cloud.bigquery.biglake.v1alpha1.ListDatabasesResponse>(
                service, METHODID_LIST_DATABASES)))
        .addMethod(
          getCreateTableMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.bigquery.biglake.v1alpha1.CreateTableRequest,
              com.google.cloud.bigquery.biglake.v1alpha1.Table>(
                service, METHODID_CREATE_TABLE)))
        .addMethod(
          getDeleteTableMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.bigquery.biglake.v1alpha1.DeleteTableRequest,
              com.google.cloud.bigquery.biglake.v1alpha1.Table>(
                service, METHODID_DELETE_TABLE)))
        .addMethod(
          getUpdateTableMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.bigquery.biglake.v1alpha1.UpdateTableRequest,
              com.google.cloud.bigquery.biglake.v1alpha1.Table>(
                service, METHODID_UPDATE_TABLE)))
        .addMethod(
          getRenameTableMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.bigquery.biglake.v1alpha1.RenameTableRequest,
              com.google.cloud.bigquery.biglake.v1alpha1.Table>(
                service, METHODID_RENAME_TABLE)))
        .addMethod(
          getGetTableMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.bigquery.biglake.v1alpha1.GetTableRequest,
              com.google.cloud.bigquery.biglake.v1alpha1.Table>(
                service, METHODID_GET_TABLE)))
        .addMethod(
          getListTablesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.bigquery.biglake.v1alpha1.ListTablesRequest,
              com.google.cloud.bigquery.biglake.v1alpha1.ListTablesResponse>(
                service, METHODID_LIST_TABLES)))
        .addMethod(
          getCreateLockMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.bigquery.biglake.v1alpha1.CreateLockRequest,
              com.google.cloud.bigquery.biglake.v1alpha1.Lock>(
                service, METHODID_CREATE_LOCK)))
        .addMethod(
          getDeleteLockMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.bigquery.biglake.v1alpha1.DeleteLockRequest,
              com.google.protobuf.Empty>(
                service, METHODID_DELETE_LOCK)))
        .addMethod(
          getCheckLockMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.bigquery.biglake.v1alpha1.CheckLockRequest,
              com.google.cloud.bigquery.biglake.v1alpha1.Lock>(
                service, METHODID_CHECK_LOCK)))
        .addMethod(
          getListLocksMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.bigquery.biglake.v1alpha1.ListLocksRequest,
              com.google.cloud.bigquery.biglake.v1alpha1.ListLocksResponse>(
                service, METHODID_LIST_LOCKS)))
        .build();
  }

  private static abstract class MetastoreServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MetastoreServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.bigquery.biglake.v1alpha1.MetastoreProto.getDescriptor();
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
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
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
              .addMethod(getCreateLockMethod())
              .addMethod(getDeleteLockMethod())
              .addMethod(getCheckLockMethod())
              .addMethod(getListLocksMethod())
              .build();
        }
      }
    }
    return result;
  }
}
