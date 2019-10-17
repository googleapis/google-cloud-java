package com.google.cloud.datacatalog;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 *
 *
 * <pre>
 * Data Catalog API service allows clients to discover, understand, and manage
 * their data.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/datacatalog/v1beta1/datacatalog.proto")
public final class DataCatalogGrpc {

  private DataCatalogGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.datacatalog.v1beta1.DataCatalog";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSearchCatalogMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.SearchCatalogRequest,
          com.google.cloud.datacatalog.SearchCatalogResponse>
      METHOD_SEARCH_CATALOG = getSearchCatalogMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.SearchCatalogRequest,
          com.google.cloud.datacatalog.SearchCatalogResponse>
      getSearchCatalogMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.SearchCatalogRequest,
          com.google.cloud.datacatalog.SearchCatalogResponse>
      getSearchCatalogMethod() {
    return getSearchCatalogMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.SearchCatalogRequest,
          com.google.cloud.datacatalog.SearchCatalogResponse>
      getSearchCatalogMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.SearchCatalogRequest,
            com.google.cloud.datacatalog.SearchCatalogResponse>
        getSearchCatalogMethod;
    if ((getSearchCatalogMethod = DataCatalogGrpc.getSearchCatalogMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getSearchCatalogMethod = DataCatalogGrpc.getSearchCatalogMethod) == null) {
          DataCatalogGrpc.getSearchCatalogMethod =
              getSearchCatalogMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.SearchCatalogRequest,
                          com.google.cloud.datacatalog.SearchCatalogResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.datacatalog.v1beta1.DataCatalog", "SearchCatalog"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.SearchCatalogRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.SearchCatalogResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new DataCatalogMethodDescriptorSupplier("SearchCatalog"))
                      .build();
        }
      }
    }
    return getSearchCatalogMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateEntryGroupMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.CreateEntryGroupRequest,
          com.google.cloud.datacatalog.EntryGroup>
      METHOD_CREATE_ENTRY_GROUP = getCreateEntryGroupMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.CreateEntryGroupRequest,
          com.google.cloud.datacatalog.EntryGroup>
      getCreateEntryGroupMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.CreateEntryGroupRequest,
          com.google.cloud.datacatalog.EntryGroup>
      getCreateEntryGroupMethod() {
    return getCreateEntryGroupMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.CreateEntryGroupRequest,
          com.google.cloud.datacatalog.EntryGroup>
      getCreateEntryGroupMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.CreateEntryGroupRequest,
            com.google.cloud.datacatalog.EntryGroup>
        getCreateEntryGroupMethod;
    if ((getCreateEntryGroupMethod = DataCatalogGrpc.getCreateEntryGroupMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getCreateEntryGroupMethod = DataCatalogGrpc.getCreateEntryGroupMethod) == null) {
          DataCatalogGrpc.getCreateEntryGroupMethod =
              getCreateEntryGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.CreateEntryGroupRequest,
                          com.google.cloud.datacatalog.EntryGroup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.datacatalog.v1beta1.DataCatalog", "CreateEntryGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.CreateEntryGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.EntryGroup.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataCatalogMethodDescriptorSupplier("CreateEntryGroup"))
                      .build();
        }
      }
    }
    return getCreateEntryGroupMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetEntryGroupMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.GetEntryGroupRequest,
          com.google.cloud.datacatalog.EntryGroup>
      METHOD_GET_ENTRY_GROUP = getGetEntryGroupMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.GetEntryGroupRequest,
          com.google.cloud.datacatalog.EntryGroup>
      getGetEntryGroupMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.GetEntryGroupRequest,
          com.google.cloud.datacatalog.EntryGroup>
      getGetEntryGroupMethod() {
    return getGetEntryGroupMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.GetEntryGroupRequest,
          com.google.cloud.datacatalog.EntryGroup>
      getGetEntryGroupMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.GetEntryGroupRequest,
            com.google.cloud.datacatalog.EntryGroup>
        getGetEntryGroupMethod;
    if ((getGetEntryGroupMethod = DataCatalogGrpc.getGetEntryGroupMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getGetEntryGroupMethod = DataCatalogGrpc.getGetEntryGroupMethod) == null) {
          DataCatalogGrpc.getGetEntryGroupMethod =
              getGetEntryGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.GetEntryGroupRequest,
                          com.google.cloud.datacatalog.EntryGroup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.datacatalog.v1beta1.DataCatalog", "GetEntryGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.GetEntryGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.EntryGroup.getDefaultInstance()))
                      .setSchemaDescriptor(new DataCatalogMethodDescriptorSupplier("GetEntryGroup"))
                      .build();
        }
      }
    }
    return getGetEntryGroupMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteEntryGroupMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.DeleteEntryGroupRequest, com.google.protobuf.Empty>
      METHOD_DELETE_ENTRY_GROUP = getDeleteEntryGroupMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.DeleteEntryGroupRequest, com.google.protobuf.Empty>
      getDeleteEntryGroupMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.DeleteEntryGroupRequest, com.google.protobuf.Empty>
      getDeleteEntryGroupMethod() {
    return getDeleteEntryGroupMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.DeleteEntryGroupRequest, com.google.protobuf.Empty>
      getDeleteEntryGroupMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.DeleteEntryGroupRequest, com.google.protobuf.Empty>
        getDeleteEntryGroupMethod;
    if ((getDeleteEntryGroupMethod = DataCatalogGrpc.getDeleteEntryGroupMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getDeleteEntryGroupMethod = DataCatalogGrpc.getDeleteEntryGroupMethod) == null) {
          DataCatalogGrpc.getDeleteEntryGroupMethod =
              getDeleteEntryGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.DeleteEntryGroupRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.datacatalog.v1beta1.DataCatalog", "DeleteEntryGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.DeleteEntryGroupRequest
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateEntryMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.CreateEntryRequest, com.google.cloud.datacatalog.Entry>
      METHOD_CREATE_ENTRY = getCreateEntryMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.CreateEntryRequest, com.google.cloud.datacatalog.Entry>
      getCreateEntryMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.CreateEntryRequest, com.google.cloud.datacatalog.Entry>
      getCreateEntryMethod() {
    return getCreateEntryMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.CreateEntryRequest, com.google.cloud.datacatalog.Entry>
      getCreateEntryMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.CreateEntryRequest, com.google.cloud.datacatalog.Entry>
        getCreateEntryMethod;
    if ((getCreateEntryMethod = DataCatalogGrpc.getCreateEntryMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getCreateEntryMethod = DataCatalogGrpc.getCreateEntryMethod) == null) {
          DataCatalogGrpc.getCreateEntryMethod =
              getCreateEntryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.CreateEntryRequest,
                          com.google.cloud.datacatalog.Entry>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.datacatalog.v1beta1.DataCatalog", "CreateEntry"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.CreateEntryRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.Entry.getDefaultInstance()))
                      .setSchemaDescriptor(new DataCatalogMethodDescriptorSupplier("CreateEntry"))
                      .build();
        }
      }
    }
    return getCreateEntryMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateEntryMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.UpdateEntryRequest, com.google.cloud.datacatalog.Entry>
      METHOD_UPDATE_ENTRY = getUpdateEntryMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.UpdateEntryRequest, com.google.cloud.datacatalog.Entry>
      getUpdateEntryMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.UpdateEntryRequest, com.google.cloud.datacatalog.Entry>
      getUpdateEntryMethod() {
    return getUpdateEntryMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.UpdateEntryRequest, com.google.cloud.datacatalog.Entry>
      getUpdateEntryMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.UpdateEntryRequest, com.google.cloud.datacatalog.Entry>
        getUpdateEntryMethod;
    if ((getUpdateEntryMethod = DataCatalogGrpc.getUpdateEntryMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getUpdateEntryMethod = DataCatalogGrpc.getUpdateEntryMethod) == null) {
          DataCatalogGrpc.getUpdateEntryMethod =
              getUpdateEntryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.UpdateEntryRequest,
                          com.google.cloud.datacatalog.Entry>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.datacatalog.v1beta1.DataCatalog", "UpdateEntry"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.UpdateEntryRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.Entry.getDefaultInstance()))
                      .setSchemaDescriptor(new DataCatalogMethodDescriptorSupplier("UpdateEntry"))
                      .build();
        }
      }
    }
    return getUpdateEntryMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteEntryMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.DeleteEntryRequest, com.google.protobuf.Empty>
      METHOD_DELETE_ENTRY = getDeleteEntryMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.DeleteEntryRequest, com.google.protobuf.Empty>
      getDeleteEntryMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.DeleteEntryRequest, com.google.protobuf.Empty>
      getDeleteEntryMethod() {
    return getDeleteEntryMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.DeleteEntryRequest, com.google.protobuf.Empty>
      getDeleteEntryMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.DeleteEntryRequest, com.google.protobuf.Empty>
        getDeleteEntryMethod;
    if ((getDeleteEntryMethod = DataCatalogGrpc.getDeleteEntryMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getDeleteEntryMethod = DataCatalogGrpc.getDeleteEntryMethod) == null) {
          DataCatalogGrpc.getDeleteEntryMethod =
              getDeleteEntryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.DeleteEntryRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.datacatalog.v1beta1.DataCatalog", "DeleteEntry"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.DeleteEntryRequest.getDefaultInstance()))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetEntryMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.GetEntryRequest, com.google.cloud.datacatalog.Entry>
      METHOD_GET_ENTRY = getGetEntryMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.GetEntryRequest, com.google.cloud.datacatalog.Entry>
      getGetEntryMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.GetEntryRequest, com.google.cloud.datacatalog.Entry>
      getGetEntryMethod() {
    return getGetEntryMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.GetEntryRequest, com.google.cloud.datacatalog.Entry>
      getGetEntryMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.GetEntryRequest, com.google.cloud.datacatalog.Entry>
        getGetEntryMethod;
    if ((getGetEntryMethod = DataCatalogGrpc.getGetEntryMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getGetEntryMethod = DataCatalogGrpc.getGetEntryMethod) == null) {
          DataCatalogGrpc.getGetEntryMethod =
              getGetEntryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.GetEntryRequest,
                          com.google.cloud.datacatalog.Entry>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.datacatalog.v1beta1.DataCatalog", "GetEntry"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.GetEntryRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.Entry.getDefaultInstance()))
                      .setSchemaDescriptor(new DataCatalogMethodDescriptorSupplier("GetEntry"))
                      .build();
        }
      }
    }
    return getGetEntryMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getLookupEntryMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.LookupEntryRequest, com.google.cloud.datacatalog.Entry>
      METHOD_LOOKUP_ENTRY = getLookupEntryMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.LookupEntryRequest, com.google.cloud.datacatalog.Entry>
      getLookupEntryMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.LookupEntryRequest, com.google.cloud.datacatalog.Entry>
      getLookupEntryMethod() {
    return getLookupEntryMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.LookupEntryRequest, com.google.cloud.datacatalog.Entry>
      getLookupEntryMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.LookupEntryRequest, com.google.cloud.datacatalog.Entry>
        getLookupEntryMethod;
    if ((getLookupEntryMethod = DataCatalogGrpc.getLookupEntryMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getLookupEntryMethod = DataCatalogGrpc.getLookupEntryMethod) == null) {
          DataCatalogGrpc.getLookupEntryMethod =
              getLookupEntryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.LookupEntryRequest,
                          com.google.cloud.datacatalog.Entry>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.datacatalog.v1beta1.DataCatalog", "LookupEntry"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.LookupEntryRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.Entry.getDefaultInstance()))
                      .setSchemaDescriptor(new DataCatalogMethodDescriptorSupplier("LookupEntry"))
                      .build();
        }
      }
    }
    return getLookupEntryMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateTagTemplateMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.CreateTagTemplateRequest,
          com.google.cloud.datacatalog.TagTemplate>
      METHOD_CREATE_TAG_TEMPLATE = getCreateTagTemplateMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.CreateTagTemplateRequest,
          com.google.cloud.datacatalog.TagTemplate>
      getCreateTagTemplateMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.CreateTagTemplateRequest,
          com.google.cloud.datacatalog.TagTemplate>
      getCreateTagTemplateMethod() {
    return getCreateTagTemplateMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.CreateTagTemplateRequest,
          com.google.cloud.datacatalog.TagTemplate>
      getCreateTagTemplateMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.CreateTagTemplateRequest,
            com.google.cloud.datacatalog.TagTemplate>
        getCreateTagTemplateMethod;
    if ((getCreateTagTemplateMethod = DataCatalogGrpc.getCreateTagTemplateMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getCreateTagTemplateMethod = DataCatalogGrpc.getCreateTagTemplateMethod) == null) {
          DataCatalogGrpc.getCreateTagTemplateMethod =
              getCreateTagTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.CreateTagTemplateRequest,
                          com.google.cloud.datacatalog.TagTemplate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.datacatalog.v1beta1.DataCatalog", "CreateTagTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.CreateTagTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.TagTemplate.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataCatalogMethodDescriptorSupplier("CreateTagTemplate"))
                      .build();
        }
      }
    }
    return getCreateTagTemplateMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetTagTemplateMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.GetTagTemplateRequest,
          com.google.cloud.datacatalog.TagTemplate>
      METHOD_GET_TAG_TEMPLATE = getGetTagTemplateMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.GetTagTemplateRequest,
          com.google.cloud.datacatalog.TagTemplate>
      getGetTagTemplateMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.GetTagTemplateRequest,
          com.google.cloud.datacatalog.TagTemplate>
      getGetTagTemplateMethod() {
    return getGetTagTemplateMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.GetTagTemplateRequest,
          com.google.cloud.datacatalog.TagTemplate>
      getGetTagTemplateMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.GetTagTemplateRequest,
            com.google.cloud.datacatalog.TagTemplate>
        getGetTagTemplateMethod;
    if ((getGetTagTemplateMethod = DataCatalogGrpc.getGetTagTemplateMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getGetTagTemplateMethod = DataCatalogGrpc.getGetTagTemplateMethod) == null) {
          DataCatalogGrpc.getGetTagTemplateMethod =
              getGetTagTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.GetTagTemplateRequest,
                          com.google.cloud.datacatalog.TagTemplate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.datacatalog.v1beta1.DataCatalog", "GetTagTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.GetTagTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.TagTemplate.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataCatalogMethodDescriptorSupplier("GetTagTemplate"))
                      .build();
        }
      }
    }
    return getGetTagTemplateMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateTagTemplateMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.UpdateTagTemplateRequest,
          com.google.cloud.datacatalog.TagTemplate>
      METHOD_UPDATE_TAG_TEMPLATE = getUpdateTagTemplateMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.UpdateTagTemplateRequest,
          com.google.cloud.datacatalog.TagTemplate>
      getUpdateTagTemplateMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.UpdateTagTemplateRequest,
          com.google.cloud.datacatalog.TagTemplate>
      getUpdateTagTemplateMethod() {
    return getUpdateTagTemplateMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.UpdateTagTemplateRequest,
          com.google.cloud.datacatalog.TagTemplate>
      getUpdateTagTemplateMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.UpdateTagTemplateRequest,
            com.google.cloud.datacatalog.TagTemplate>
        getUpdateTagTemplateMethod;
    if ((getUpdateTagTemplateMethod = DataCatalogGrpc.getUpdateTagTemplateMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getUpdateTagTemplateMethod = DataCatalogGrpc.getUpdateTagTemplateMethod) == null) {
          DataCatalogGrpc.getUpdateTagTemplateMethod =
              getUpdateTagTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.UpdateTagTemplateRequest,
                          com.google.cloud.datacatalog.TagTemplate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.datacatalog.v1beta1.DataCatalog", "UpdateTagTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.UpdateTagTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.TagTemplate.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataCatalogMethodDescriptorSupplier("UpdateTagTemplate"))
                      .build();
        }
      }
    }
    return getUpdateTagTemplateMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteTagTemplateMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.DeleteTagTemplateRequest, com.google.protobuf.Empty>
      METHOD_DELETE_TAG_TEMPLATE = getDeleteTagTemplateMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.DeleteTagTemplateRequest, com.google.protobuf.Empty>
      getDeleteTagTemplateMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.DeleteTagTemplateRequest, com.google.protobuf.Empty>
      getDeleteTagTemplateMethod() {
    return getDeleteTagTemplateMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.DeleteTagTemplateRequest, com.google.protobuf.Empty>
      getDeleteTagTemplateMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.DeleteTagTemplateRequest, com.google.protobuf.Empty>
        getDeleteTagTemplateMethod;
    if ((getDeleteTagTemplateMethod = DataCatalogGrpc.getDeleteTagTemplateMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getDeleteTagTemplateMethod = DataCatalogGrpc.getDeleteTagTemplateMethod) == null) {
          DataCatalogGrpc.getDeleteTagTemplateMethod =
              getDeleteTagTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.DeleteTagTemplateRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.datacatalog.v1beta1.DataCatalog", "DeleteTagTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.DeleteTagTemplateRequest
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateTagTemplateFieldMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.CreateTagTemplateFieldRequest,
          com.google.cloud.datacatalog.TagTemplateField>
      METHOD_CREATE_TAG_TEMPLATE_FIELD = getCreateTagTemplateFieldMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.CreateTagTemplateFieldRequest,
          com.google.cloud.datacatalog.TagTemplateField>
      getCreateTagTemplateFieldMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.CreateTagTemplateFieldRequest,
          com.google.cloud.datacatalog.TagTemplateField>
      getCreateTagTemplateFieldMethod() {
    return getCreateTagTemplateFieldMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.CreateTagTemplateFieldRequest,
          com.google.cloud.datacatalog.TagTemplateField>
      getCreateTagTemplateFieldMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.CreateTagTemplateFieldRequest,
            com.google.cloud.datacatalog.TagTemplateField>
        getCreateTagTemplateFieldMethod;
    if ((getCreateTagTemplateFieldMethod = DataCatalogGrpc.getCreateTagTemplateFieldMethod)
        == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getCreateTagTemplateFieldMethod = DataCatalogGrpc.getCreateTagTemplateFieldMethod)
            == null) {
          DataCatalogGrpc.getCreateTagTemplateFieldMethod =
              getCreateTagTemplateFieldMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.CreateTagTemplateFieldRequest,
                          com.google.cloud.datacatalog.TagTemplateField>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.datacatalog.v1beta1.DataCatalog",
                              "CreateTagTemplateField"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.CreateTagTemplateFieldRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.TagTemplateField.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataCatalogMethodDescriptorSupplier("CreateTagTemplateField"))
                      .build();
        }
      }
    }
    return getCreateTagTemplateFieldMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateTagTemplateFieldMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.UpdateTagTemplateFieldRequest,
          com.google.cloud.datacatalog.TagTemplateField>
      METHOD_UPDATE_TAG_TEMPLATE_FIELD = getUpdateTagTemplateFieldMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.UpdateTagTemplateFieldRequest,
          com.google.cloud.datacatalog.TagTemplateField>
      getUpdateTagTemplateFieldMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.UpdateTagTemplateFieldRequest,
          com.google.cloud.datacatalog.TagTemplateField>
      getUpdateTagTemplateFieldMethod() {
    return getUpdateTagTemplateFieldMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.UpdateTagTemplateFieldRequest,
          com.google.cloud.datacatalog.TagTemplateField>
      getUpdateTagTemplateFieldMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.UpdateTagTemplateFieldRequest,
            com.google.cloud.datacatalog.TagTemplateField>
        getUpdateTagTemplateFieldMethod;
    if ((getUpdateTagTemplateFieldMethod = DataCatalogGrpc.getUpdateTagTemplateFieldMethod)
        == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getUpdateTagTemplateFieldMethod = DataCatalogGrpc.getUpdateTagTemplateFieldMethod)
            == null) {
          DataCatalogGrpc.getUpdateTagTemplateFieldMethod =
              getUpdateTagTemplateFieldMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.UpdateTagTemplateFieldRequest,
                          com.google.cloud.datacatalog.TagTemplateField>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.datacatalog.v1beta1.DataCatalog",
                              "UpdateTagTemplateField"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.UpdateTagTemplateFieldRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.TagTemplateField.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataCatalogMethodDescriptorSupplier("UpdateTagTemplateField"))
                      .build();
        }
      }
    }
    return getUpdateTagTemplateFieldMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getRenameTagTemplateFieldMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.RenameTagTemplateFieldRequest,
          com.google.cloud.datacatalog.TagTemplateField>
      METHOD_RENAME_TAG_TEMPLATE_FIELD = getRenameTagTemplateFieldMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.RenameTagTemplateFieldRequest,
          com.google.cloud.datacatalog.TagTemplateField>
      getRenameTagTemplateFieldMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.RenameTagTemplateFieldRequest,
          com.google.cloud.datacatalog.TagTemplateField>
      getRenameTagTemplateFieldMethod() {
    return getRenameTagTemplateFieldMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.RenameTagTemplateFieldRequest,
          com.google.cloud.datacatalog.TagTemplateField>
      getRenameTagTemplateFieldMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.RenameTagTemplateFieldRequest,
            com.google.cloud.datacatalog.TagTemplateField>
        getRenameTagTemplateFieldMethod;
    if ((getRenameTagTemplateFieldMethod = DataCatalogGrpc.getRenameTagTemplateFieldMethod)
        == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getRenameTagTemplateFieldMethod = DataCatalogGrpc.getRenameTagTemplateFieldMethod)
            == null) {
          DataCatalogGrpc.getRenameTagTemplateFieldMethod =
              getRenameTagTemplateFieldMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.RenameTagTemplateFieldRequest,
                          com.google.cloud.datacatalog.TagTemplateField>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.datacatalog.v1beta1.DataCatalog",
                              "RenameTagTemplateField"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.RenameTagTemplateFieldRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.TagTemplateField.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataCatalogMethodDescriptorSupplier("RenameTagTemplateField"))
                      .build();
        }
      }
    }
    return getRenameTagTemplateFieldMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteTagTemplateFieldMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.DeleteTagTemplateFieldRequest, com.google.protobuf.Empty>
      METHOD_DELETE_TAG_TEMPLATE_FIELD = getDeleteTagTemplateFieldMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.DeleteTagTemplateFieldRequest, com.google.protobuf.Empty>
      getDeleteTagTemplateFieldMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.DeleteTagTemplateFieldRequest, com.google.protobuf.Empty>
      getDeleteTagTemplateFieldMethod() {
    return getDeleteTagTemplateFieldMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.DeleteTagTemplateFieldRequest, com.google.protobuf.Empty>
      getDeleteTagTemplateFieldMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.DeleteTagTemplateFieldRequest, com.google.protobuf.Empty>
        getDeleteTagTemplateFieldMethod;
    if ((getDeleteTagTemplateFieldMethod = DataCatalogGrpc.getDeleteTagTemplateFieldMethod)
        == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getDeleteTagTemplateFieldMethod = DataCatalogGrpc.getDeleteTagTemplateFieldMethod)
            == null) {
          DataCatalogGrpc.getDeleteTagTemplateFieldMethod =
              getDeleteTagTemplateFieldMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.DeleteTagTemplateFieldRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.datacatalog.v1beta1.DataCatalog",
                              "DeleteTagTemplateField"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.DeleteTagTemplateFieldRequest
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateTagMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.CreateTagRequest, com.google.cloud.datacatalog.Tag>
      METHOD_CREATE_TAG = getCreateTagMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.CreateTagRequest, com.google.cloud.datacatalog.Tag>
      getCreateTagMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.CreateTagRequest, com.google.cloud.datacatalog.Tag>
      getCreateTagMethod() {
    return getCreateTagMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.CreateTagRequest, com.google.cloud.datacatalog.Tag>
      getCreateTagMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.CreateTagRequest, com.google.cloud.datacatalog.Tag>
        getCreateTagMethod;
    if ((getCreateTagMethod = DataCatalogGrpc.getCreateTagMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getCreateTagMethod = DataCatalogGrpc.getCreateTagMethod) == null) {
          DataCatalogGrpc.getCreateTagMethod =
              getCreateTagMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.CreateTagRequest,
                          com.google.cloud.datacatalog.Tag>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.datacatalog.v1beta1.DataCatalog", "CreateTag"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.CreateTagRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.Tag.getDefaultInstance()))
                      .setSchemaDescriptor(new DataCatalogMethodDescriptorSupplier("CreateTag"))
                      .build();
        }
      }
    }
    return getCreateTagMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateTagMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.UpdateTagRequest, com.google.cloud.datacatalog.Tag>
      METHOD_UPDATE_TAG = getUpdateTagMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.UpdateTagRequest, com.google.cloud.datacatalog.Tag>
      getUpdateTagMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.UpdateTagRequest, com.google.cloud.datacatalog.Tag>
      getUpdateTagMethod() {
    return getUpdateTagMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.UpdateTagRequest, com.google.cloud.datacatalog.Tag>
      getUpdateTagMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.UpdateTagRequest, com.google.cloud.datacatalog.Tag>
        getUpdateTagMethod;
    if ((getUpdateTagMethod = DataCatalogGrpc.getUpdateTagMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getUpdateTagMethod = DataCatalogGrpc.getUpdateTagMethod) == null) {
          DataCatalogGrpc.getUpdateTagMethod =
              getUpdateTagMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.UpdateTagRequest,
                          com.google.cloud.datacatalog.Tag>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.datacatalog.v1beta1.DataCatalog", "UpdateTag"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.UpdateTagRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.Tag.getDefaultInstance()))
                      .setSchemaDescriptor(new DataCatalogMethodDescriptorSupplier("UpdateTag"))
                      .build();
        }
      }
    }
    return getUpdateTagMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteTagMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.DeleteTagRequest, com.google.protobuf.Empty>
      METHOD_DELETE_TAG = getDeleteTagMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.DeleteTagRequest, com.google.protobuf.Empty>
      getDeleteTagMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.DeleteTagRequest, com.google.protobuf.Empty>
      getDeleteTagMethod() {
    return getDeleteTagMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.DeleteTagRequest, com.google.protobuf.Empty>
      getDeleteTagMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.DeleteTagRequest, com.google.protobuf.Empty>
        getDeleteTagMethod;
    if ((getDeleteTagMethod = DataCatalogGrpc.getDeleteTagMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getDeleteTagMethod = DataCatalogGrpc.getDeleteTagMethod) == null) {
          DataCatalogGrpc.getDeleteTagMethod =
              getDeleteTagMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.DeleteTagRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.datacatalog.v1beta1.DataCatalog", "DeleteTag"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.DeleteTagRequest.getDefaultInstance()))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListTagsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.ListTagsRequest,
          com.google.cloud.datacatalog.ListTagsResponse>
      METHOD_LIST_TAGS = getListTagsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.ListTagsRequest,
          com.google.cloud.datacatalog.ListTagsResponse>
      getListTagsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.ListTagsRequest,
          com.google.cloud.datacatalog.ListTagsResponse>
      getListTagsMethod() {
    return getListTagsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.ListTagsRequest,
          com.google.cloud.datacatalog.ListTagsResponse>
      getListTagsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.ListTagsRequest,
            com.google.cloud.datacatalog.ListTagsResponse>
        getListTagsMethod;
    if ((getListTagsMethod = DataCatalogGrpc.getListTagsMethod) == null) {
      synchronized (DataCatalogGrpc.class) {
        if ((getListTagsMethod = DataCatalogGrpc.getListTagsMethod) == null) {
          DataCatalogGrpc.getListTagsMethod =
              getListTagsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.ListTagsRequest,
                          com.google.cloud.datacatalog.ListTagsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.datacatalog.v1beta1.DataCatalog", "ListTags"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.ListTagsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.ListTagsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new DataCatalogMethodDescriptorSupplier("ListTags"))
                      .build();
        }
      }
    }
    return getListTagsMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSetIamPolicyMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      METHOD_SET_IAM_POLICY = getSetIamPolicyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethod() {
    return getSetIamPolicyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.datacatalog.v1beta1.DataCatalog", "SetIamPolicy"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetIamPolicyMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      METHOD_GET_IAM_POLICY = getGetIamPolicyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethod() {
    return getGetIamPolicyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.datacatalog.v1beta1.DataCatalog", "GetIamPolicy"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getTestIamPermissionsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      METHOD_TEST_IAM_PERMISSIONS = getTestIamPermissionsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsMethod() {
    return getTestIamPermissionsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.datacatalog.v1beta1.DataCatalog", "TestIamPermissions"))
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
    return new DataCatalogStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataCatalogBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new DataCatalogBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DataCatalogFutureStub newFutureStub(io.grpc.Channel channel) {
    return new DataCatalogFutureStub(channel);
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
     * Note that searches do not have full recall. There may be results that match
     * your query but are not returned, even in subsequent pages of results. These
     * missing results may vary across repeated calls to search. Do not rely on
     * this method if you need to guarantee full recall.
     * See [Data Catalog Search
     * Syntax](/data-catalog/docs/how-to/search-reference) for more information.
     * </pre>
     */
    public void searchCatalog(
        com.google.cloud.datacatalog.SearchCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.SearchCatalogResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getSearchCatalogMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Alpha feature.
     * Creates an EntryGroup.
     * The user should enable the Data Catalog API in the project identified by
     * the `parent` parameter (see [Data Catalog Resource Project]
     * (/data-catalog/docs/concepts/resource-project) for more information).
     * </pre>
     */
    public void createEntryGroup(
        com.google.cloud.datacatalog.CreateEntryGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.EntryGroup> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateEntryGroupMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Alpha feature.
     * Gets an EntryGroup.
     * </pre>
     */
    public void getEntryGroup(
        com.google.cloud.datacatalog.GetEntryGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.EntryGroup> responseObserver) {
      asyncUnimplementedUnaryCall(getGetEntryGroupMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Alpha feature.
     * Deletes an EntryGroup. Only entry groups that do not contain entries can be
     * deleted. The user should enable the Data Catalog API in the project
     * identified by the `name` parameter (see [Data Catalog Resource Project]
     * (/data-catalog/docs/concepts/resource-project) for more information).
     * </pre>
     */
    public void deleteEntryGroup(
        com.google.cloud.datacatalog.DeleteEntryGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteEntryGroupMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Alpha feature.
     * Creates an entry. Currently only entries of 'FILESET' type can be created.
     * The user should enable the Data Catalog API in the project identified by
     * the `parent` parameter (see [Data Catalog Resource Project]
     * (/data-catalog/docs/concepts/resource-project) for more information).
     * </pre>
     */
    public void createEntry(
        com.google.cloud.datacatalog.CreateEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.Entry> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateEntryMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing entry.
     * The user should enable the Data Catalog API in the project identified by
     * the `entry.name` parameter (see [Data Catalog Resource Project]
     * (/data-catalog/docs/concepts/resource-project) for more information).
     * </pre>
     */
    public void updateEntry(
        com.google.cloud.datacatalog.UpdateEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.Entry> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateEntryMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Alpha feature.
     * Deletes an existing entry. Only entries created through
     * [CreateEntry][google.cloud.datacatalog.v1beta1.DataCatalog.CreateEntry]
     * method can be deleted.
     * The user should enable the Data Catalog API in the project identified by
     * the `name` parameter (see [Data Catalog Resource Project]
     * (/data-catalog/docs/concepts/resource-project) for more information).
     * </pre>
     */
    public void deleteEntry(
        com.google.cloud.datacatalog.DeleteEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteEntryMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an entry.
     * </pre>
     */
    public void getEntry(
        com.google.cloud.datacatalog.GetEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.Entry> responseObserver) {
      asyncUnimplementedUnaryCall(getGetEntryMethodHelper(), responseObserver);
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
        com.google.cloud.datacatalog.LookupEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.Entry> responseObserver) {
      asyncUnimplementedUnaryCall(getLookupEntryMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a tag template. The user should enable the Data Catalog API in
     * the project identified by the `parent` parameter (see [Data Catalog
     * Resource Project](/data-catalog/docs/concepts/resource-project) for more
     * information).
     * </pre>
     */
    public void createTagTemplate(
        com.google.cloud.datacatalog.CreateTagTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.TagTemplate> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateTagTemplateMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a tag template.
     * </pre>
     */
    public void getTagTemplate(
        com.google.cloud.datacatalog.GetTagTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.TagTemplate> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTagTemplateMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a tag template. This method cannot be used to update the fields of
     * a template. The tag template fields are represented as separate resources
     * and should be updated using their own create/update/delete methods.
     * The user should enable the Data Catalog API in the project identified by
     * the `tag_template.name` parameter (see [Data Catalog Resource Project]
     * (/data-catalog/docs/concepts/resource-project) for more information).
     * </pre>
     */
    public void updateTagTemplate(
        com.google.cloud.datacatalog.UpdateTagTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.TagTemplate> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateTagTemplateMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a tag template and all tags using the template.
     * The user should enable the Data Catalog API in the project identified by
     * the `name` parameter (see [Data Catalog Resource Project]
     * (/data-catalog/docs/concepts/resource-project) for more information).
     * </pre>
     */
    public void deleteTagTemplate(
        com.google.cloud.datacatalog.DeleteTagTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteTagTemplateMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a field in a tag template. The user should enable the Data Catalog
     * API in the project identified by the `parent` parameter (see
     * [Data Catalog Resource
     * Project](/data-catalog/docs/concepts/resource-project) for more
     * information).
     * </pre>
     */
    public void createTagTemplateField(
        com.google.cloud.datacatalog.CreateTagTemplateFieldRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.TagTemplateField>
            responseObserver) {
      asyncUnimplementedUnaryCall(getCreateTagTemplateFieldMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a field in a tag template. This method cannot be used to update the
     * field type. The user should enable the Data Catalog API in the project
     * identified by the `name` parameter (see [Data Catalog Resource Project]
     * (/data-catalog/docs/concepts/resource-project) for more information).
     * </pre>
     */
    public void updateTagTemplateField(
        com.google.cloud.datacatalog.UpdateTagTemplateFieldRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.TagTemplateField>
            responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateTagTemplateFieldMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Renames a field in a tag template. The user should enable the Data Catalog
     * API in the project identified by the `name` parameter (see [Data Catalog
     * Resource Project](/data-catalog/docs/concepts/resource-project) for more
     * information).
     * </pre>
     */
    public void renameTagTemplateField(
        com.google.cloud.datacatalog.RenameTagTemplateFieldRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.TagTemplateField>
            responseObserver) {
      asyncUnimplementedUnaryCall(getRenameTagTemplateFieldMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a field in a tag template and all uses of that field.
     * The user should enable the Data Catalog API in the project identified by
     * the `name` parameter (see [Data Catalog Resource Project]
     * (/data-catalog/docs/concepts/resource-project) for more information).
     * </pre>
     */
    public void deleteTagTemplateField(
        com.google.cloud.datacatalog.DeleteTagTemplateFieldRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteTagTemplateFieldMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a tag on an [Entry][google.cloud.datacatalog.v1beta1.Entry].
     * Note: The project identified by the `parent` parameter for the
     * [tag](/data-catalog/docs/reference/rest/v1beta1/projects.locations.entryGroups.entries.tags/create#path-parameters)
     * and the
     * [tag
     * template](/data-catalog/docs/reference/rest/v1beta1/projects.locations.tagTemplates/create#path-parameters)
     * used to create the tag must be from the same organization.
     * </pre>
     */
    public void createTag(
        com.google.cloud.datacatalog.CreateTagRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.Tag> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateTagMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing tag.
     * </pre>
     */
    public void updateTag(
        com.google.cloud.datacatalog.UpdateTagRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.Tag> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateTagMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a tag.
     * </pre>
     */
    public void deleteTag(
        com.google.cloud.datacatalog.DeleteTagRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteTagMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the tags on an [Entry][google.cloud.datacatalog.v1beta1.Entry].
     * </pre>
     */
    public void listTags(
        com.google.cloud.datacatalog.ListTagsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.ListTagsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListTagsMethodHelper(), responseObserver);
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
     * Note, this method cannot be used to manage policies for BigQuery, Cloud
     * Pub/Sub and any external Google Cloud Platform resources synced to Cloud
     * Data Catalog.
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
      asyncUnimplementedUnaryCall(getSetIamPolicyMethodHelper(), responseObserver);
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
     * Note, this method cannot be used to manage policies for BigQuery, Cloud
     * Pub/Sub and any external Google Cloud Platform resources synced to Cloud
     * Data Catalog.
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
      asyncUnimplementedUnaryCall(getGetIamPolicyMethodHelper(), responseObserver);
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
     * Note, this method cannot be used to manage policies for BigQuery, Cloud
     * Pub/Sub and any external Google Cloud Platform resources synced to Cloud
     * Data Catalog.
     * A caller is not required to have Google IAM permission to make this
     * request.
     * </pre>
     */
    public void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getTestIamPermissionsMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getSearchCatalogMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.SearchCatalogRequest,
                      com.google.cloud.datacatalog.SearchCatalogResponse>(
                      this, METHODID_SEARCH_CATALOG)))
          .addMethod(
              getCreateEntryGroupMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.CreateEntryGroupRequest,
                      com.google.cloud.datacatalog.EntryGroup>(this, METHODID_CREATE_ENTRY_GROUP)))
          .addMethod(
              getGetEntryGroupMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.GetEntryGroupRequest,
                      com.google.cloud.datacatalog.EntryGroup>(this, METHODID_GET_ENTRY_GROUP)))
          .addMethod(
              getDeleteEntryGroupMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.DeleteEntryGroupRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_ENTRY_GROUP)))
          .addMethod(
              getCreateEntryMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.CreateEntryRequest,
                      com.google.cloud.datacatalog.Entry>(this, METHODID_CREATE_ENTRY)))
          .addMethod(
              getUpdateEntryMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.UpdateEntryRequest,
                      com.google.cloud.datacatalog.Entry>(this, METHODID_UPDATE_ENTRY)))
          .addMethod(
              getDeleteEntryMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.DeleteEntryRequest, com.google.protobuf.Empty>(
                      this, METHODID_DELETE_ENTRY)))
          .addMethod(
              getGetEntryMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.GetEntryRequest,
                      com.google.cloud.datacatalog.Entry>(this, METHODID_GET_ENTRY)))
          .addMethod(
              getLookupEntryMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.LookupEntryRequest,
                      com.google.cloud.datacatalog.Entry>(this, METHODID_LOOKUP_ENTRY)))
          .addMethod(
              getCreateTagTemplateMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.CreateTagTemplateRequest,
                      com.google.cloud.datacatalog.TagTemplate>(
                      this, METHODID_CREATE_TAG_TEMPLATE)))
          .addMethod(
              getGetTagTemplateMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.GetTagTemplateRequest,
                      com.google.cloud.datacatalog.TagTemplate>(this, METHODID_GET_TAG_TEMPLATE)))
          .addMethod(
              getUpdateTagTemplateMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.UpdateTagTemplateRequest,
                      com.google.cloud.datacatalog.TagTemplate>(
                      this, METHODID_UPDATE_TAG_TEMPLATE)))
          .addMethod(
              getDeleteTagTemplateMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.DeleteTagTemplateRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_TAG_TEMPLATE)))
          .addMethod(
              getCreateTagTemplateFieldMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.CreateTagTemplateFieldRequest,
                      com.google.cloud.datacatalog.TagTemplateField>(
                      this, METHODID_CREATE_TAG_TEMPLATE_FIELD)))
          .addMethod(
              getUpdateTagTemplateFieldMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.UpdateTagTemplateFieldRequest,
                      com.google.cloud.datacatalog.TagTemplateField>(
                      this, METHODID_UPDATE_TAG_TEMPLATE_FIELD)))
          .addMethod(
              getRenameTagTemplateFieldMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.RenameTagTemplateFieldRequest,
                      com.google.cloud.datacatalog.TagTemplateField>(
                      this, METHODID_RENAME_TAG_TEMPLATE_FIELD)))
          .addMethod(
              getDeleteTagTemplateFieldMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.DeleteTagTemplateFieldRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_TAG_TEMPLATE_FIELD)))
          .addMethod(
              getCreateTagMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.CreateTagRequest,
                      com.google.cloud.datacatalog.Tag>(this, METHODID_CREATE_TAG)))
          .addMethod(
              getUpdateTagMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.UpdateTagRequest,
                      com.google.cloud.datacatalog.Tag>(this, METHODID_UPDATE_TAG)))
          .addMethod(
              getDeleteTagMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.DeleteTagRequest, com.google.protobuf.Empty>(
                      this, METHODID_DELETE_TAG)))
          .addMethod(
              getListTagsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.ListTagsRequest,
                      com.google.cloud.datacatalog.ListTagsResponse>(this, METHODID_LIST_TAGS)))
          .addMethod(
              getSetIamPolicyMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>(
                      this, METHODID_SET_IAM_POLICY)))
          .addMethod(
              getGetIamPolicyMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>(
                      this, METHODID_GET_IAM_POLICY)))
          .addMethod(
              getTestIamPermissionsMethodHelper(),
              asyncUnaryCall(
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
  public static final class DataCatalogStub extends io.grpc.stub.AbstractStub<DataCatalogStub> {
    private DataCatalogStub(io.grpc.Channel channel) {
      super(channel);
    }

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
     * Note that searches do not have full recall. There may be results that match
     * your query but are not returned, even in subsequent pages of results. These
     * missing results may vary across repeated calls to search. Do not rely on
     * this method if you need to guarantee full recall.
     * See [Data Catalog Search
     * Syntax](/data-catalog/docs/how-to/search-reference) for more information.
     * </pre>
     */
    public void searchCatalog(
        com.google.cloud.datacatalog.SearchCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.SearchCatalogResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSearchCatalogMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Alpha feature.
     * Creates an EntryGroup.
     * The user should enable the Data Catalog API in the project identified by
     * the `parent` parameter (see [Data Catalog Resource Project]
     * (/data-catalog/docs/concepts/resource-project) for more information).
     * </pre>
     */
    public void createEntryGroup(
        com.google.cloud.datacatalog.CreateEntryGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.EntryGroup> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateEntryGroupMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Alpha feature.
     * Gets an EntryGroup.
     * </pre>
     */
    public void getEntryGroup(
        com.google.cloud.datacatalog.GetEntryGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.EntryGroup> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetEntryGroupMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Alpha feature.
     * Deletes an EntryGroup. Only entry groups that do not contain entries can be
     * deleted. The user should enable the Data Catalog API in the project
     * identified by the `name` parameter (see [Data Catalog Resource Project]
     * (/data-catalog/docs/concepts/resource-project) for more information).
     * </pre>
     */
    public void deleteEntryGroup(
        com.google.cloud.datacatalog.DeleteEntryGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteEntryGroupMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Alpha feature.
     * Creates an entry. Currently only entries of 'FILESET' type can be created.
     * The user should enable the Data Catalog API in the project identified by
     * the `parent` parameter (see [Data Catalog Resource Project]
     * (/data-catalog/docs/concepts/resource-project) for more information).
     * </pre>
     */
    public void createEntry(
        com.google.cloud.datacatalog.CreateEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.Entry> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateEntryMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing entry.
     * The user should enable the Data Catalog API in the project identified by
     * the `entry.name` parameter (see [Data Catalog Resource Project]
     * (/data-catalog/docs/concepts/resource-project) for more information).
     * </pre>
     */
    public void updateEntry(
        com.google.cloud.datacatalog.UpdateEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.Entry> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateEntryMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Alpha feature.
     * Deletes an existing entry. Only entries created through
     * [CreateEntry][google.cloud.datacatalog.v1beta1.DataCatalog.CreateEntry]
     * method can be deleted.
     * The user should enable the Data Catalog API in the project identified by
     * the `name` parameter (see [Data Catalog Resource Project]
     * (/data-catalog/docs/concepts/resource-project) for more information).
     * </pre>
     */
    public void deleteEntry(
        com.google.cloud.datacatalog.DeleteEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteEntryMethodHelper(), getCallOptions()),
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
        com.google.cloud.datacatalog.GetEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.Entry> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetEntryMethodHelper(), getCallOptions()),
          request,
          responseObserver);
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
        com.google.cloud.datacatalog.LookupEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.Entry> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLookupEntryMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a tag template. The user should enable the Data Catalog API in
     * the project identified by the `parent` parameter (see [Data Catalog
     * Resource Project](/data-catalog/docs/concepts/resource-project) for more
     * information).
     * </pre>
     */
    public void createTagTemplate(
        com.google.cloud.datacatalog.CreateTagTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.TagTemplate> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateTagTemplateMethodHelper(), getCallOptions()),
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
        com.google.cloud.datacatalog.GetTagTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.TagTemplate> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTagTemplateMethodHelper(), getCallOptions()),
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
     * The user should enable the Data Catalog API in the project identified by
     * the `tag_template.name` parameter (see [Data Catalog Resource Project]
     * (/data-catalog/docs/concepts/resource-project) for more information).
     * </pre>
     */
    public void updateTagTemplate(
        com.google.cloud.datacatalog.UpdateTagTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.TagTemplate> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateTagTemplateMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a tag template and all tags using the template.
     * The user should enable the Data Catalog API in the project identified by
     * the `name` parameter (see [Data Catalog Resource Project]
     * (/data-catalog/docs/concepts/resource-project) for more information).
     * </pre>
     */
    public void deleteTagTemplate(
        com.google.cloud.datacatalog.DeleteTagTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteTagTemplateMethodHelper(), getCallOptions()),
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
     * Project](/data-catalog/docs/concepts/resource-project) for more
     * information).
     * </pre>
     */
    public void createTagTemplateField(
        com.google.cloud.datacatalog.CreateTagTemplateFieldRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.TagTemplateField>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateTagTemplateFieldMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a field in a tag template. This method cannot be used to update the
     * field type. The user should enable the Data Catalog API in the project
     * identified by the `name` parameter (see [Data Catalog Resource Project]
     * (/data-catalog/docs/concepts/resource-project) for more information).
     * </pre>
     */
    public void updateTagTemplateField(
        com.google.cloud.datacatalog.UpdateTagTemplateFieldRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.TagTemplateField>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateTagTemplateFieldMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Renames a field in a tag template. The user should enable the Data Catalog
     * API in the project identified by the `name` parameter (see [Data Catalog
     * Resource Project](/data-catalog/docs/concepts/resource-project) for more
     * information).
     * </pre>
     */
    public void renameTagTemplateField(
        com.google.cloud.datacatalog.RenameTagTemplateFieldRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.TagTemplateField>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRenameTagTemplateFieldMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a field in a tag template and all uses of that field.
     * The user should enable the Data Catalog API in the project identified by
     * the `name` parameter (see [Data Catalog Resource Project]
     * (/data-catalog/docs/concepts/resource-project) for more information).
     * </pre>
     */
    public void deleteTagTemplateField(
        com.google.cloud.datacatalog.DeleteTagTemplateFieldRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteTagTemplateFieldMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a tag on an [Entry][google.cloud.datacatalog.v1beta1.Entry].
     * Note: The project identified by the `parent` parameter for the
     * [tag](/data-catalog/docs/reference/rest/v1beta1/projects.locations.entryGroups.entries.tags/create#path-parameters)
     * and the
     * [tag
     * template](/data-catalog/docs/reference/rest/v1beta1/projects.locations.tagTemplates/create#path-parameters)
     * used to create the tag must be from the same organization.
     * </pre>
     */
    public void createTag(
        com.google.cloud.datacatalog.CreateTagRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.Tag> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateTagMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing tag.
     * </pre>
     */
    public void updateTag(
        com.google.cloud.datacatalog.UpdateTagRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.Tag> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateTagMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a tag.
     * </pre>
     */
    public void deleteTag(
        com.google.cloud.datacatalog.DeleteTagRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteTagMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the tags on an [Entry][google.cloud.datacatalog.v1beta1.Entry].
     * </pre>
     */
    public void listTags(
        com.google.cloud.datacatalog.ListTagsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.ListTagsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListTagsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
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
     * Note, this method cannot be used to manage policies for BigQuery, Cloud
     * Pub/Sub and any external Google Cloud Platform resources synced to Cloud
     * Data Catalog.
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
      asyncUnaryCall(
          getChannel().newCall(getSetIamPolicyMethodHelper(), getCallOptions()),
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
     * Note, this method cannot be used to manage policies for BigQuery, Cloud
     * Pub/Sub and any external Google Cloud Platform resources synced to Cloud
     * Data Catalog.
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
      asyncUnaryCall(
          getChannel().newCall(getGetIamPolicyMethodHelper(), getCallOptions()),
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
     * Note, this method cannot be used to manage policies for BigQuery, Cloud
     * Pub/Sub and any external Google Cloud Platform resources synced to Cloud
     * Data Catalog.
     * A caller is not required to have Google IAM permission to make this
     * request.
     * </pre>
     */
    public void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethodHelper(), getCallOptions()),
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
      extends io.grpc.stub.AbstractStub<DataCatalogBlockingStub> {
    private DataCatalogBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

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
     * Note that searches do not have full recall. There may be results that match
     * your query but are not returned, even in subsequent pages of results. These
     * missing results may vary across repeated calls to search. Do not rely on
     * this method if you need to guarantee full recall.
     * See [Data Catalog Search
     * Syntax](/data-catalog/docs/how-to/search-reference) for more information.
     * </pre>
     */
    public com.google.cloud.datacatalog.SearchCatalogResponse searchCatalog(
        com.google.cloud.datacatalog.SearchCatalogRequest request) {
      return blockingUnaryCall(
          getChannel(), getSearchCatalogMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Alpha feature.
     * Creates an EntryGroup.
     * The user should enable the Data Catalog API in the project identified by
     * the `parent` parameter (see [Data Catalog Resource Project]
     * (/data-catalog/docs/concepts/resource-project) for more information).
     * </pre>
     */
    public com.google.cloud.datacatalog.EntryGroup createEntryGroup(
        com.google.cloud.datacatalog.CreateEntryGroupRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateEntryGroupMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Alpha feature.
     * Gets an EntryGroup.
     * </pre>
     */
    public com.google.cloud.datacatalog.EntryGroup getEntryGroup(
        com.google.cloud.datacatalog.GetEntryGroupRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetEntryGroupMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Alpha feature.
     * Deletes an EntryGroup. Only entry groups that do not contain entries can be
     * deleted. The user should enable the Data Catalog API in the project
     * identified by the `name` parameter (see [Data Catalog Resource Project]
     * (/data-catalog/docs/concepts/resource-project) for more information).
     * </pre>
     */
    public com.google.protobuf.Empty deleteEntryGroup(
        com.google.cloud.datacatalog.DeleteEntryGroupRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteEntryGroupMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Alpha feature.
     * Creates an entry. Currently only entries of 'FILESET' type can be created.
     * The user should enable the Data Catalog API in the project identified by
     * the `parent` parameter (see [Data Catalog Resource Project]
     * (/data-catalog/docs/concepts/resource-project) for more information).
     * </pre>
     */
    public com.google.cloud.datacatalog.Entry createEntry(
        com.google.cloud.datacatalog.CreateEntryRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateEntryMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing entry.
     * The user should enable the Data Catalog API in the project identified by
     * the `entry.name` parameter (see [Data Catalog Resource Project]
     * (/data-catalog/docs/concepts/resource-project) for more information).
     * </pre>
     */
    public com.google.cloud.datacatalog.Entry updateEntry(
        com.google.cloud.datacatalog.UpdateEntryRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateEntryMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Alpha feature.
     * Deletes an existing entry. Only entries created through
     * [CreateEntry][google.cloud.datacatalog.v1beta1.DataCatalog.CreateEntry]
     * method can be deleted.
     * The user should enable the Data Catalog API in the project identified by
     * the `name` parameter (see [Data Catalog Resource Project]
     * (/data-catalog/docs/concepts/resource-project) for more information).
     * </pre>
     */
    public com.google.protobuf.Empty deleteEntry(
        com.google.cloud.datacatalog.DeleteEntryRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteEntryMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an entry.
     * </pre>
     */
    public com.google.cloud.datacatalog.Entry getEntry(
        com.google.cloud.datacatalog.GetEntryRequest request) {
      return blockingUnaryCall(getChannel(), getGetEntryMethodHelper(), getCallOptions(), request);
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
    public com.google.cloud.datacatalog.Entry lookupEntry(
        com.google.cloud.datacatalog.LookupEntryRequest request) {
      return blockingUnaryCall(
          getChannel(), getLookupEntryMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a tag template. The user should enable the Data Catalog API in
     * the project identified by the `parent` parameter (see [Data Catalog
     * Resource Project](/data-catalog/docs/concepts/resource-project) for more
     * information).
     * </pre>
     */
    public com.google.cloud.datacatalog.TagTemplate createTagTemplate(
        com.google.cloud.datacatalog.CreateTagTemplateRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateTagTemplateMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a tag template.
     * </pre>
     */
    public com.google.cloud.datacatalog.TagTemplate getTagTemplate(
        com.google.cloud.datacatalog.GetTagTemplateRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetTagTemplateMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a tag template. This method cannot be used to update the fields of
     * a template. The tag template fields are represented as separate resources
     * and should be updated using their own create/update/delete methods.
     * The user should enable the Data Catalog API in the project identified by
     * the `tag_template.name` parameter (see [Data Catalog Resource Project]
     * (/data-catalog/docs/concepts/resource-project) for more information).
     * </pre>
     */
    public com.google.cloud.datacatalog.TagTemplate updateTagTemplate(
        com.google.cloud.datacatalog.UpdateTagTemplateRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateTagTemplateMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a tag template and all tags using the template.
     * The user should enable the Data Catalog API in the project identified by
     * the `name` parameter (see [Data Catalog Resource Project]
     * (/data-catalog/docs/concepts/resource-project) for more information).
     * </pre>
     */
    public com.google.protobuf.Empty deleteTagTemplate(
        com.google.cloud.datacatalog.DeleteTagTemplateRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteTagTemplateMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a field in a tag template. The user should enable the Data Catalog
     * API in the project identified by the `parent` parameter (see
     * [Data Catalog Resource
     * Project](/data-catalog/docs/concepts/resource-project) for more
     * information).
     * </pre>
     */
    public com.google.cloud.datacatalog.TagTemplateField createTagTemplateField(
        com.google.cloud.datacatalog.CreateTagTemplateFieldRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateTagTemplateFieldMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a field in a tag template. This method cannot be used to update the
     * field type. The user should enable the Data Catalog API in the project
     * identified by the `name` parameter (see [Data Catalog Resource Project]
     * (/data-catalog/docs/concepts/resource-project) for more information).
     * </pre>
     */
    public com.google.cloud.datacatalog.TagTemplateField updateTagTemplateField(
        com.google.cloud.datacatalog.UpdateTagTemplateFieldRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateTagTemplateFieldMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Renames a field in a tag template. The user should enable the Data Catalog
     * API in the project identified by the `name` parameter (see [Data Catalog
     * Resource Project](/data-catalog/docs/concepts/resource-project) for more
     * information).
     * </pre>
     */
    public com.google.cloud.datacatalog.TagTemplateField renameTagTemplateField(
        com.google.cloud.datacatalog.RenameTagTemplateFieldRequest request) {
      return blockingUnaryCall(
          getChannel(), getRenameTagTemplateFieldMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a field in a tag template and all uses of that field.
     * The user should enable the Data Catalog API in the project identified by
     * the `name` parameter (see [Data Catalog Resource Project]
     * (/data-catalog/docs/concepts/resource-project) for more information).
     * </pre>
     */
    public com.google.protobuf.Empty deleteTagTemplateField(
        com.google.cloud.datacatalog.DeleteTagTemplateFieldRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteTagTemplateFieldMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a tag on an [Entry][google.cloud.datacatalog.v1beta1.Entry].
     * Note: The project identified by the `parent` parameter for the
     * [tag](/data-catalog/docs/reference/rest/v1beta1/projects.locations.entryGroups.entries.tags/create#path-parameters)
     * and the
     * [tag
     * template](/data-catalog/docs/reference/rest/v1beta1/projects.locations.tagTemplates/create#path-parameters)
     * used to create the tag must be from the same organization.
     * </pre>
     */
    public com.google.cloud.datacatalog.Tag createTag(
        com.google.cloud.datacatalog.CreateTagRequest request) {
      return blockingUnaryCall(getChannel(), getCreateTagMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing tag.
     * </pre>
     */
    public com.google.cloud.datacatalog.Tag updateTag(
        com.google.cloud.datacatalog.UpdateTagRequest request) {
      return blockingUnaryCall(getChannel(), getUpdateTagMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a tag.
     * </pre>
     */
    public com.google.protobuf.Empty deleteTag(
        com.google.cloud.datacatalog.DeleteTagRequest request) {
      return blockingUnaryCall(getChannel(), getDeleteTagMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the tags on an [Entry][google.cloud.datacatalog.v1beta1.Entry].
     * </pre>
     */
    public com.google.cloud.datacatalog.ListTagsResponse listTags(
        com.google.cloud.datacatalog.ListTagsRequest request) {
      return blockingUnaryCall(getChannel(), getListTagsMethodHelper(), getCallOptions(), request);
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
     * Note, this method cannot be used to manage policies for BigQuery, Cloud
     * Pub/Sub and any external Google Cloud Platform resources synced to Cloud
     * Data Catalog.
     * Callers must have following Google IAM permission
     *   - `datacatalog.tagTemplates.setIamPolicy` to set policies on tag
     *     templates.
     *   - `datacatalog.entries.setIamPolicy` to set policies on entries.
     *   - `datacatalog.entryGroups.setIamPolicy` to set policies on entry groups.
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetIamPolicyMethodHelper(), getCallOptions(), request);
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
     * Note, this method cannot be used to manage policies for BigQuery, Cloud
     * Pub/Sub and any external Google Cloud Platform resources synced to Cloud
     * Data Catalog.
     * Callers must have following Google IAM permission
     *   - `datacatalog.tagTemplates.getIamPolicy` to get policies on tag
     *     templates.
     *   - `datacatalog.entries.getIamPolicy` to get policies on entries.
     *   - `datacatalog.entryGroups.getIamPolicy` to get policies on entry groups.
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetIamPolicyMethodHelper(), getCallOptions(), request);
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
     * Note, this method cannot be used to manage policies for BigQuery, Cloud
     * Pub/Sub and any external Google Cloud Platform resources synced to Cloud
     * Data Catalog.
     * A caller is not required to have Google IAM permission to make this
     * request.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethodHelper(), getCallOptions(), request);
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
      extends io.grpc.stub.AbstractStub<DataCatalogFutureStub> {
    private DataCatalogFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

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
     * Note that searches do not have full recall. There may be results that match
     * your query but are not returned, even in subsequent pages of results. These
     * missing results may vary across repeated calls to search. Do not rely on
     * this method if you need to guarantee full recall.
     * See [Data Catalog Search
     * Syntax](/data-catalog/docs/how-to/search-reference) for more information.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.SearchCatalogResponse>
        searchCatalog(com.google.cloud.datacatalog.SearchCatalogRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSearchCatalogMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Alpha feature.
     * Creates an EntryGroup.
     * The user should enable the Data Catalog API in the project identified by
     * the `parent` parameter (see [Data Catalog Resource Project]
     * (/data-catalog/docs/concepts/resource-project) for more information).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.EntryGroup>
        createEntryGroup(com.google.cloud.datacatalog.CreateEntryGroupRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateEntryGroupMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Alpha feature.
     * Gets an EntryGroup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.EntryGroup>
        getEntryGroup(com.google.cloud.datacatalog.GetEntryGroupRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetEntryGroupMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Alpha feature.
     * Deletes an EntryGroup. Only entry groups that do not contain entries can be
     * deleted. The user should enable the Data Catalog API in the project
     * identified by the `name` parameter (see [Data Catalog Resource Project]
     * (/data-catalog/docs/concepts/resource-project) for more information).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteEntryGroup(com.google.cloud.datacatalog.DeleteEntryGroupRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteEntryGroupMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Alpha feature.
     * Creates an entry. Currently only entries of 'FILESET' type can be created.
     * The user should enable the Data Catalog API in the project identified by
     * the `parent` parameter (see [Data Catalog Resource Project]
     * (/data-catalog/docs/concepts/resource-project) for more information).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.datacatalog.Entry>
        createEntry(com.google.cloud.datacatalog.CreateEntryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateEntryMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing entry.
     * The user should enable the Data Catalog API in the project identified by
     * the `entry.name` parameter (see [Data Catalog Resource Project]
     * (/data-catalog/docs/concepts/resource-project) for more information).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.datacatalog.Entry>
        updateEntry(com.google.cloud.datacatalog.UpdateEntryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateEntryMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Alpha feature.
     * Deletes an existing entry. Only entries created through
     * [CreateEntry][google.cloud.datacatalog.v1beta1.DataCatalog.CreateEntry]
     * method can be deleted.
     * The user should enable the Data Catalog API in the project identified by
     * the `name` parameter (see [Data Catalog Resource Project]
     * (/data-catalog/docs/concepts/resource-project) for more information).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteEntry(com.google.cloud.datacatalog.DeleteEntryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteEntryMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an entry.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.datacatalog.Entry>
        getEntry(com.google.cloud.datacatalog.GetEntryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetEntryMethodHelper(), getCallOptions()), request);
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
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.datacatalog.Entry>
        lookupEntry(com.google.cloud.datacatalog.LookupEntryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLookupEntryMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a tag template. The user should enable the Data Catalog API in
     * the project identified by the `parent` parameter (see [Data Catalog
     * Resource Project](/data-catalog/docs/concepts/resource-project) for more
     * information).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.TagTemplate>
        createTagTemplate(com.google.cloud.datacatalog.CreateTagTemplateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateTagTemplateMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a tag template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.TagTemplate>
        getTagTemplate(com.google.cloud.datacatalog.GetTagTemplateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTagTemplateMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a tag template. This method cannot be used to update the fields of
     * a template. The tag template fields are represented as separate resources
     * and should be updated using their own create/update/delete methods.
     * The user should enable the Data Catalog API in the project identified by
     * the `tag_template.name` parameter (see [Data Catalog Resource Project]
     * (/data-catalog/docs/concepts/resource-project) for more information).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.TagTemplate>
        updateTagTemplate(com.google.cloud.datacatalog.UpdateTagTemplateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateTagTemplateMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a tag template and all tags using the template.
     * The user should enable the Data Catalog API in the project identified by
     * the `name` parameter (see [Data Catalog Resource Project]
     * (/data-catalog/docs/concepts/resource-project) for more information).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteTagTemplate(com.google.cloud.datacatalog.DeleteTagTemplateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteTagTemplateMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a field in a tag template. The user should enable the Data Catalog
     * API in the project identified by the `parent` parameter (see
     * [Data Catalog Resource
     * Project](/data-catalog/docs/concepts/resource-project) for more
     * information).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.TagTemplateField>
        createTagTemplateField(com.google.cloud.datacatalog.CreateTagTemplateFieldRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateTagTemplateFieldMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a field in a tag template. This method cannot be used to update the
     * field type. The user should enable the Data Catalog API in the project
     * identified by the `name` parameter (see [Data Catalog Resource Project]
     * (/data-catalog/docs/concepts/resource-project) for more information).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.TagTemplateField>
        updateTagTemplateField(com.google.cloud.datacatalog.UpdateTagTemplateFieldRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateTagTemplateFieldMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Renames a field in a tag template. The user should enable the Data Catalog
     * API in the project identified by the `name` parameter (see [Data Catalog
     * Resource Project](/data-catalog/docs/concepts/resource-project) for more
     * information).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.TagTemplateField>
        renameTagTemplateField(com.google.cloud.datacatalog.RenameTagTemplateFieldRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRenameTagTemplateFieldMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a field in a tag template and all uses of that field.
     * The user should enable the Data Catalog API in the project identified by
     * the `name` parameter (see [Data Catalog Resource Project]
     * (/data-catalog/docs/concepts/resource-project) for more information).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteTagTemplateField(com.google.cloud.datacatalog.DeleteTagTemplateFieldRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteTagTemplateFieldMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a tag on an [Entry][google.cloud.datacatalog.v1beta1.Entry].
     * Note: The project identified by the `parent` parameter for the
     * [tag](/data-catalog/docs/reference/rest/v1beta1/projects.locations.entryGroups.entries.tags/create#path-parameters)
     * and the
     * [tag
     * template](/data-catalog/docs/reference/rest/v1beta1/projects.locations.tagTemplates/create#path-parameters)
     * used to create the tag must be from the same organization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.datacatalog.Tag>
        createTag(com.google.cloud.datacatalog.CreateTagRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateTagMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing tag.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.datacatalog.Tag>
        updateTag(com.google.cloud.datacatalog.UpdateTagRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateTagMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a tag.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteTag(
        com.google.cloud.datacatalog.DeleteTagRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteTagMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the tags on an [Entry][google.cloud.datacatalog.v1beta1.Entry].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.ListTagsResponse>
        listTags(com.google.cloud.datacatalog.ListTagsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListTagsMethodHelper(), getCallOptions()), request);
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
     * Note, this method cannot be used to manage policies for BigQuery, Cloud
     * Pub/Sub and any external Google Cloud Platform resources synced to Cloud
     * Data Catalog.
     * Callers must have following Google IAM permission
     *   - `datacatalog.tagTemplates.setIamPolicy` to set policies on tag
     *     templates.
     *   - `datacatalog.entries.setIamPolicy` to set policies on entries.
     *   - `datacatalog.entryGroups.setIamPolicy` to set policies on entry groups.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetIamPolicyMethodHelper(), getCallOptions()), request);
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
     * Note, this method cannot be used to manage policies for BigQuery, Cloud
     * Pub/Sub and any external Google Cloud Platform resources synced to Cloud
     * Data Catalog.
     * Callers must have following Google IAM permission
     *   - `datacatalog.tagTemplates.getIamPolicy` to get policies on tag
     *     templates.
     *   - `datacatalog.entries.getIamPolicy` to get policies on entries.
     *   - `datacatalog.entryGroups.getIamPolicy` to get policies on entry groups.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetIamPolicyMethodHelper(), getCallOptions()), request);
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
     * Note, this method cannot be used to manage policies for BigQuery, Cloud
     * Pub/Sub and any external Google Cloud Platform resources synced to Cloud
     * Data Catalog.
     * A caller is not required to have Google IAM permission to make this
     * request.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.iam.v1.TestIamPermissionsResponse>
        testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEARCH_CATALOG = 0;
  private static final int METHODID_CREATE_ENTRY_GROUP = 1;
  private static final int METHODID_GET_ENTRY_GROUP = 2;
  private static final int METHODID_DELETE_ENTRY_GROUP = 3;
  private static final int METHODID_CREATE_ENTRY = 4;
  private static final int METHODID_UPDATE_ENTRY = 5;
  private static final int METHODID_DELETE_ENTRY = 6;
  private static final int METHODID_GET_ENTRY = 7;
  private static final int METHODID_LOOKUP_ENTRY = 8;
  private static final int METHODID_CREATE_TAG_TEMPLATE = 9;
  private static final int METHODID_GET_TAG_TEMPLATE = 10;
  private static final int METHODID_UPDATE_TAG_TEMPLATE = 11;
  private static final int METHODID_DELETE_TAG_TEMPLATE = 12;
  private static final int METHODID_CREATE_TAG_TEMPLATE_FIELD = 13;
  private static final int METHODID_UPDATE_TAG_TEMPLATE_FIELD = 14;
  private static final int METHODID_RENAME_TAG_TEMPLATE_FIELD = 15;
  private static final int METHODID_DELETE_TAG_TEMPLATE_FIELD = 16;
  private static final int METHODID_CREATE_TAG = 17;
  private static final int METHODID_UPDATE_TAG = 18;
  private static final int METHODID_DELETE_TAG = 19;
  private static final int METHODID_LIST_TAGS = 20;
  private static final int METHODID_SET_IAM_POLICY = 21;
  private static final int METHODID_GET_IAM_POLICY = 22;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 23;

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
              (com.google.cloud.datacatalog.SearchCatalogRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.SearchCatalogResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_ENTRY_GROUP:
          serviceImpl.createEntryGroup(
              (com.google.cloud.datacatalog.CreateEntryGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.EntryGroup>)
                  responseObserver);
          break;
        case METHODID_GET_ENTRY_GROUP:
          serviceImpl.getEntryGroup(
              (com.google.cloud.datacatalog.GetEntryGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.EntryGroup>)
                  responseObserver);
          break;
        case METHODID_DELETE_ENTRY_GROUP:
          serviceImpl.deleteEntryGroup(
              (com.google.cloud.datacatalog.DeleteEntryGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_ENTRY:
          serviceImpl.createEntry(
              (com.google.cloud.datacatalog.CreateEntryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.Entry>) responseObserver);
          break;
        case METHODID_UPDATE_ENTRY:
          serviceImpl.updateEntry(
              (com.google.cloud.datacatalog.UpdateEntryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.Entry>) responseObserver);
          break;
        case METHODID_DELETE_ENTRY:
          serviceImpl.deleteEntry(
              (com.google.cloud.datacatalog.DeleteEntryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_ENTRY:
          serviceImpl.getEntry(
              (com.google.cloud.datacatalog.GetEntryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.Entry>) responseObserver);
          break;
        case METHODID_LOOKUP_ENTRY:
          serviceImpl.lookupEntry(
              (com.google.cloud.datacatalog.LookupEntryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.Entry>) responseObserver);
          break;
        case METHODID_CREATE_TAG_TEMPLATE:
          serviceImpl.createTagTemplate(
              (com.google.cloud.datacatalog.CreateTagTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.TagTemplate>)
                  responseObserver);
          break;
        case METHODID_GET_TAG_TEMPLATE:
          serviceImpl.getTagTemplate(
              (com.google.cloud.datacatalog.GetTagTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.TagTemplate>)
                  responseObserver);
          break;
        case METHODID_UPDATE_TAG_TEMPLATE:
          serviceImpl.updateTagTemplate(
              (com.google.cloud.datacatalog.UpdateTagTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.TagTemplate>)
                  responseObserver);
          break;
        case METHODID_DELETE_TAG_TEMPLATE:
          serviceImpl.deleteTagTemplate(
              (com.google.cloud.datacatalog.DeleteTagTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_TAG_TEMPLATE_FIELD:
          serviceImpl.createTagTemplateField(
              (com.google.cloud.datacatalog.CreateTagTemplateFieldRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.TagTemplateField>)
                  responseObserver);
          break;
        case METHODID_UPDATE_TAG_TEMPLATE_FIELD:
          serviceImpl.updateTagTemplateField(
              (com.google.cloud.datacatalog.UpdateTagTemplateFieldRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.TagTemplateField>)
                  responseObserver);
          break;
        case METHODID_RENAME_TAG_TEMPLATE_FIELD:
          serviceImpl.renameTagTemplateField(
              (com.google.cloud.datacatalog.RenameTagTemplateFieldRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.TagTemplateField>)
                  responseObserver);
          break;
        case METHODID_DELETE_TAG_TEMPLATE_FIELD:
          serviceImpl.deleteTagTemplateField(
              (com.google.cloud.datacatalog.DeleteTagTemplateFieldRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_TAG:
          serviceImpl.createTag(
              (com.google.cloud.datacatalog.CreateTagRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.Tag>) responseObserver);
          break;
        case METHODID_UPDATE_TAG:
          serviceImpl.updateTag(
              (com.google.cloud.datacatalog.UpdateTagRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.Tag>) responseObserver);
          break;
        case METHODID_DELETE_TAG:
          serviceImpl.deleteTag(
              (com.google.cloud.datacatalog.DeleteTagRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_TAGS:
          serviceImpl.listTags(
              (com.google.cloud.datacatalog.ListTagsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.ListTagsResponse>)
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
      return com.google.cloud.datacatalog.Datacatalog.getDescriptor();
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
                      .addMethod(getSearchCatalogMethodHelper())
                      .addMethod(getCreateEntryGroupMethodHelper())
                      .addMethod(getGetEntryGroupMethodHelper())
                      .addMethod(getDeleteEntryGroupMethodHelper())
                      .addMethod(getCreateEntryMethodHelper())
                      .addMethod(getUpdateEntryMethodHelper())
                      .addMethod(getDeleteEntryMethodHelper())
                      .addMethod(getGetEntryMethodHelper())
                      .addMethod(getLookupEntryMethodHelper())
                      .addMethod(getCreateTagTemplateMethodHelper())
                      .addMethod(getGetTagTemplateMethodHelper())
                      .addMethod(getUpdateTagTemplateMethodHelper())
                      .addMethod(getDeleteTagTemplateMethodHelper())
                      .addMethod(getCreateTagTemplateFieldMethodHelper())
                      .addMethod(getUpdateTagTemplateFieldMethodHelper())
                      .addMethod(getRenameTagTemplateFieldMethodHelper())
                      .addMethod(getDeleteTagTemplateFieldMethodHelper())
                      .addMethod(getCreateTagMethodHelper())
                      .addMethod(getUpdateTagMethodHelper())
                      .addMethod(getDeleteTagMethodHelper())
                      .addMethod(getListTagsMethodHelper())
                      .addMethod(getSetIamPolicyMethodHelper())
                      .addMethod(getGetIamPolicyMethodHelper())
                      .addMethod(getTestIamPermissionsMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
