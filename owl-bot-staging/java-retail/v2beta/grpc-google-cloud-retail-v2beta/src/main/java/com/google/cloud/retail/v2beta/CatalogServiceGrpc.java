package com.google.cloud.retail.v2beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Service for managing catalog configuration.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/retail/v2beta/catalog_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CatalogServiceGrpc {

  private CatalogServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.retail.v2beta.CatalogService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.retail.v2beta.ListCatalogsRequest,
      com.google.cloud.retail.v2beta.ListCatalogsResponse> getListCatalogsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCatalogs",
      requestType = com.google.cloud.retail.v2beta.ListCatalogsRequest.class,
      responseType = com.google.cloud.retail.v2beta.ListCatalogsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.retail.v2beta.ListCatalogsRequest,
      com.google.cloud.retail.v2beta.ListCatalogsResponse> getListCatalogsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.retail.v2beta.ListCatalogsRequest, com.google.cloud.retail.v2beta.ListCatalogsResponse> getListCatalogsMethod;
    if ((getListCatalogsMethod = CatalogServiceGrpc.getListCatalogsMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getListCatalogsMethod = CatalogServiceGrpc.getListCatalogsMethod) == null) {
          CatalogServiceGrpc.getListCatalogsMethod = getListCatalogsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.retail.v2beta.ListCatalogsRequest, com.google.cloud.retail.v2beta.ListCatalogsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCatalogs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.retail.v2beta.ListCatalogsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.retail.v2beta.ListCatalogsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("ListCatalogs"))
              .build();
        }
      }
    }
    return getListCatalogsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.retail.v2beta.UpdateCatalogRequest,
      com.google.cloud.retail.v2beta.Catalog> getUpdateCatalogMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCatalog",
      requestType = com.google.cloud.retail.v2beta.UpdateCatalogRequest.class,
      responseType = com.google.cloud.retail.v2beta.Catalog.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.retail.v2beta.UpdateCatalogRequest,
      com.google.cloud.retail.v2beta.Catalog> getUpdateCatalogMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.retail.v2beta.UpdateCatalogRequest, com.google.cloud.retail.v2beta.Catalog> getUpdateCatalogMethod;
    if ((getUpdateCatalogMethod = CatalogServiceGrpc.getUpdateCatalogMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getUpdateCatalogMethod = CatalogServiceGrpc.getUpdateCatalogMethod) == null) {
          CatalogServiceGrpc.getUpdateCatalogMethod = getUpdateCatalogMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.retail.v2beta.UpdateCatalogRequest, com.google.cloud.retail.v2beta.Catalog>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCatalog"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.retail.v2beta.UpdateCatalogRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.retail.v2beta.Catalog.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("UpdateCatalog"))
              .build();
        }
      }
    }
    return getUpdateCatalogMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.retail.v2beta.SetDefaultBranchRequest,
      com.google.protobuf.Empty> getSetDefaultBranchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetDefaultBranch",
      requestType = com.google.cloud.retail.v2beta.SetDefaultBranchRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.retail.v2beta.SetDefaultBranchRequest,
      com.google.protobuf.Empty> getSetDefaultBranchMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.retail.v2beta.SetDefaultBranchRequest, com.google.protobuf.Empty> getSetDefaultBranchMethod;
    if ((getSetDefaultBranchMethod = CatalogServiceGrpc.getSetDefaultBranchMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getSetDefaultBranchMethod = CatalogServiceGrpc.getSetDefaultBranchMethod) == null) {
          CatalogServiceGrpc.getSetDefaultBranchMethod = getSetDefaultBranchMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.retail.v2beta.SetDefaultBranchRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetDefaultBranch"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.retail.v2beta.SetDefaultBranchRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("SetDefaultBranch"))
              .build();
        }
      }
    }
    return getSetDefaultBranchMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.retail.v2beta.GetDefaultBranchRequest,
      com.google.cloud.retail.v2beta.GetDefaultBranchResponse> getGetDefaultBranchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDefaultBranch",
      requestType = com.google.cloud.retail.v2beta.GetDefaultBranchRequest.class,
      responseType = com.google.cloud.retail.v2beta.GetDefaultBranchResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.retail.v2beta.GetDefaultBranchRequest,
      com.google.cloud.retail.v2beta.GetDefaultBranchResponse> getGetDefaultBranchMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.retail.v2beta.GetDefaultBranchRequest, com.google.cloud.retail.v2beta.GetDefaultBranchResponse> getGetDefaultBranchMethod;
    if ((getGetDefaultBranchMethod = CatalogServiceGrpc.getGetDefaultBranchMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getGetDefaultBranchMethod = CatalogServiceGrpc.getGetDefaultBranchMethod) == null) {
          CatalogServiceGrpc.getGetDefaultBranchMethod = getGetDefaultBranchMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.retail.v2beta.GetDefaultBranchRequest, com.google.cloud.retail.v2beta.GetDefaultBranchResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDefaultBranch"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.retail.v2beta.GetDefaultBranchRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.retail.v2beta.GetDefaultBranchResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("GetDefaultBranch"))
              .build();
        }
      }
    }
    return getGetDefaultBranchMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.retail.v2beta.GetCompletionConfigRequest,
      com.google.cloud.retail.v2beta.CompletionConfig> getGetCompletionConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCompletionConfig",
      requestType = com.google.cloud.retail.v2beta.GetCompletionConfigRequest.class,
      responseType = com.google.cloud.retail.v2beta.CompletionConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.retail.v2beta.GetCompletionConfigRequest,
      com.google.cloud.retail.v2beta.CompletionConfig> getGetCompletionConfigMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.retail.v2beta.GetCompletionConfigRequest, com.google.cloud.retail.v2beta.CompletionConfig> getGetCompletionConfigMethod;
    if ((getGetCompletionConfigMethod = CatalogServiceGrpc.getGetCompletionConfigMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getGetCompletionConfigMethod = CatalogServiceGrpc.getGetCompletionConfigMethod) == null) {
          CatalogServiceGrpc.getGetCompletionConfigMethod = getGetCompletionConfigMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.retail.v2beta.GetCompletionConfigRequest, com.google.cloud.retail.v2beta.CompletionConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCompletionConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.retail.v2beta.GetCompletionConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.retail.v2beta.CompletionConfig.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("GetCompletionConfig"))
              .build();
        }
      }
    }
    return getGetCompletionConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.retail.v2beta.UpdateCompletionConfigRequest,
      com.google.cloud.retail.v2beta.CompletionConfig> getUpdateCompletionConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCompletionConfig",
      requestType = com.google.cloud.retail.v2beta.UpdateCompletionConfigRequest.class,
      responseType = com.google.cloud.retail.v2beta.CompletionConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.retail.v2beta.UpdateCompletionConfigRequest,
      com.google.cloud.retail.v2beta.CompletionConfig> getUpdateCompletionConfigMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.retail.v2beta.UpdateCompletionConfigRequest, com.google.cloud.retail.v2beta.CompletionConfig> getUpdateCompletionConfigMethod;
    if ((getUpdateCompletionConfigMethod = CatalogServiceGrpc.getUpdateCompletionConfigMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getUpdateCompletionConfigMethod = CatalogServiceGrpc.getUpdateCompletionConfigMethod) == null) {
          CatalogServiceGrpc.getUpdateCompletionConfigMethod = getUpdateCompletionConfigMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.retail.v2beta.UpdateCompletionConfigRequest, com.google.cloud.retail.v2beta.CompletionConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCompletionConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.retail.v2beta.UpdateCompletionConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.retail.v2beta.CompletionConfig.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("UpdateCompletionConfig"))
              .build();
        }
      }
    }
    return getUpdateCompletionConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.retail.v2beta.GetAttributesConfigRequest,
      com.google.cloud.retail.v2beta.AttributesConfig> getGetAttributesConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAttributesConfig",
      requestType = com.google.cloud.retail.v2beta.GetAttributesConfigRequest.class,
      responseType = com.google.cloud.retail.v2beta.AttributesConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.retail.v2beta.GetAttributesConfigRequest,
      com.google.cloud.retail.v2beta.AttributesConfig> getGetAttributesConfigMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.retail.v2beta.GetAttributesConfigRequest, com.google.cloud.retail.v2beta.AttributesConfig> getGetAttributesConfigMethod;
    if ((getGetAttributesConfigMethod = CatalogServiceGrpc.getGetAttributesConfigMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getGetAttributesConfigMethod = CatalogServiceGrpc.getGetAttributesConfigMethod) == null) {
          CatalogServiceGrpc.getGetAttributesConfigMethod = getGetAttributesConfigMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.retail.v2beta.GetAttributesConfigRequest, com.google.cloud.retail.v2beta.AttributesConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAttributesConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.retail.v2beta.GetAttributesConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.retail.v2beta.AttributesConfig.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("GetAttributesConfig"))
              .build();
        }
      }
    }
    return getGetAttributesConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.retail.v2beta.UpdateAttributesConfigRequest,
      com.google.cloud.retail.v2beta.AttributesConfig> getUpdateAttributesConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAttributesConfig",
      requestType = com.google.cloud.retail.v2beta.UpdateAttributesConfigRequest.class,
      responseType = com.google.cloud.retail.v2beta.AttributesConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.retail.v2beta.UpdateAttributesConfigRequest,
      com.google.cloud.retail.v2beta.AttributesConfig> getUpdateAttributesConfigMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.retail.v2beta.UpdateAttributesConfigRequest, com.google.cloud.retail.v2beta.AttributesConfig> getUpdateAttributesConfigMethod;
    if ((getUpdateAttributesConfigMethod = CatalogServiceGrpc.getUpdateAttributesConfigMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getUpdateAttributesConfigMethod = CatalogServiceGrpc.getUpdateAttributesConfigMethod) == null) {
          CatalogServiceGrpc.getUpdateAttributesConfigMethod = getUpdateAttributesConfigMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.retail.v2beta.UpdateAttributesConfigRequest, com.google.cloud.retail.v2beta.AttributesConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAttributesConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.retail.v2beta.UpdateAttributesConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.retail.v2beta.AttributesConfig.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("UpdateAttributesConfig"))
              .build();
        }
      }
    }
    return getUpdateAttributesConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.retail.v2beta.AddCatalogAttributeRequest,
      com.google.cloud.retail.v2beta.AttributesConfig> getAddCatalogAttributeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddCatalogAttribute",
      requestType = com.google.cloud.retail.v2beta.AddCatalogAttributeRequest.class,
      responseType = com.google.cloud.retail.v2beta.AttributesConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.retail.v2beta.AddCatalogAttributeRequest,
      com.google.cloud.retail.v2beta.AttributesConfig> getAddCatalogAttributeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.retail.v2beta.AddCatalogAttributeRequest, com.google.cloud.retail.v2beta.AttributesConfig> getAddCatalogAttributeMethod;
    if ((getAddCatalogAttributeMethod = CatalogServiceGrpc.getAddCatalogAttributeMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getAddCatalogAttributeMethod = CatalogServiceGrpc.getAddCatalogAttributeMethod) == null) {
          CatalogServiceGrpc.getAddCatalogAttributeMethod = getAddCatalogAttributeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.retail.v2beta.AddCatalogAttributeRequest, com.google.cloud.retail.v2beta.AttributesConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddCatalogAttribute"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.retail.v2beta.AddCatalogAttributeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.retail.v2beta.AttributesConfig.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("AddCatalogAttribute"))
              .build();
        }
      }
    }
    return getAddCatalogAttributeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest,
      com.google.cloud.retail.v2beta.AttributesConfig> getRemoveCatalogAttributeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveCatalogAttribute",
      requestType = com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest.class,
      responseType = com.google.cloud.retail.v2beta.AttributesConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest,
      com.google.cloud.retail.v2beta.AttributesConfig> getRemoveCatalogAttributeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest, com.google.cloud.retail.v2beta.AttributesConfig> getRemoveCatalogAttributeMethod;
    if ((getRemoveCatalogAttributeMethod = CatalogServiceGrpc.getRemoveCatalogAttributeMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getRemoveCatalogAttributeMethod = CatalogServiceGrpc.getRemoveCatalogAttributeMethod) == null) {
          CatalogServiceGrpc.getRemoveCatalogAttributeMethod = getRemoveCatalogAttributeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest, com.google.cloud.retail.v2beta.AttributesConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RemoveCatalogAttribute"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.retail.v2beta.AttributesConfig.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("RemoveCatalogAttribute"))
              .build();
        }
      }
    }
    return getRemoveCatalogAttributeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.retail.v2beta.BatchRemoveCatalogAttributesRequest,
      com.google.cloud.retail.v2beta.BatchRemoveCatalogAttributesResponse> getBatchRemoveCatalogAttributesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchRemoveCatalogAttributes",
      requestType = com.google.cloud.retail.v2beta.BatchRemoveCatalogAttributesRequest.class,
      responseType = com.google.cloud.retail.v2beta.BatchRemoveCatalogAttributesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.retail.v2beta.BatchRemoveCatalogAttributesRequest,
      com.google.cloud.retail.v2beta.BatchRemoveCatalogAttributesResponse> getBatchRemoveCatalogAttributesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.retail.v2beta.BatchRemoveCatalogAttributesRequest, com.google.cloud.retail.v2beta.BatchRemoveCatalogAttributesResponse> getBatchRemoveCatalogAttributesMethod;
    if ((getBatchRemoveCatalogAttributesMethod = CatalogServiceGrpc.getBatchRemoveCatalogAttributesMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getBatchRemoveCatalogAttributesMethod = CatalogServiceGrpc.getBatchRemoveCatalogAttributesMethod) == null) {
          CatalogServiceGrpc.getBatchRemoveCatalogAttributesMethod = getBatchRemoveCatalogAttributesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.retail.v2beta.BatchRemoveCatalogAttributesRequest, com.google.cloud.retail.v2beta.BatchRemoveCatalogAttributesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchRemoveCatalogAttributes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.retail.v2beta.BatchRemoveCatalogAttributesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.retail.v2beta.BatchRemoveCatalogAttributesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("BatchRemoveCatalogAttributes"))
              .build();
        }
      }
    }
    return getBatchRemoveCatalogAttributesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.retail.v2beta.ReplaceCatalogAttributeRequest,
      com.google.cloud.retail.v2beta.AttributesConfig> getReplaceCatalogAttributeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReplaceCatalogAttribute",
      requestType = com.google.cloud.retail.v2beta.ReplaceCatalogAttributeRequest.class,
      responseType = com.google.cloud.retail.v2beta.AttributesConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.retail.v2beta.ReplaceCatalogAttributeRequest,
      com.google.cloud.retail.v2beta.AttributesConfig> getReplaceCatalogAttributeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.retail.v2beta.ReplaceCatalogAttributeRequest, com.google.cloud.retail.v2beta.AttributesConfig> getReplaceCatalogAttributeMethod;
    if ((getReplaceCatalogAttributeMethod = CatalogServiceGrpc.getReplaceCatalogAttributeMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getReplaceCatalogAttributeMethod = CatalogServiceGrpc.getReplaceCatalogAttributeMethod) == null) {
          CatalogServiceGrpc.getReplaceCatalogAttributeMethod = getReplaceCatalogAttributeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.retail.v2beta.ReplaceCatalogAttributeRequest, com.google.cloud.retail.v2beta.AttributesConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReplaceCatalogAttribute"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.retail.v2beta.ReplaceCatalogAttributeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.retail.v2beta.AttributesConfig.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("ReplaceCatalogAttribute"))
              .build();
        }
      }
    }
    return getReplaceCatalogAttributeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CatalogServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CatalogServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CatalogServiceStub>() {
        @java.lang.Override
        public CatalogServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CatalogServiceStub(channel, callOptions);
        }
      };
    return CatalogServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CatalogServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CatalogServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CatalogServiceBlockingStub>() {
        @java.lang.Override
        public CatalogServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CatalogServiceBlockingStub(channel, callOptions);
        }
      };
    return CatalogServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CatalogServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CatalogServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CatalogServiceFutureStub>() {
        @java.lang.Override
        public CatalogServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CatalogServiceFutureStub(channel, callOptions);
        }
      };
    return CatalogServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Service for managing catalog configuration.
   * </pre>
   */
  public static abstract class CatalogServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists all the [Catalog][google.cloud.retail.v2beta.Catalog]s associated
     * with the project.
     * </pre>
     */
    public void listCatalogs(com.google.cloud.retail.v2beta.ListCatalogsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.ListCatalogsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListCatalogsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the [Catalog][google.cloud.retail.v2beta.Catalog]s.
     * </pre>
     */
    public void updateCatalog(com.google.cloud.retail.v2beta.UpdateCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.Catalog> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateCatalogMethod(), responseObserver);
    }

    /**
     * <pre>
     * Set a specified branch id as default branch. API methods such as
     * [SearchService.Search][google.cloud.retail.v2beta.SearchService.Search],
     * [ProductService.GetProduct][google.cloud.retail.v2beta.ProductService.GetProduct],
     * [ProductService.ListProducts][google.cloud.retail.v2beta.ProductService.ListProducts]
     * will treat requests using "default_branch" to the actual branch id set as
     * default.
     * For example, if `projects/&#42;&#47;locations/&#42;&#47;catalogs/&#42;&#47;branches/1` is set as
     * default, setting
     * [SearchRequest.branch][google.cloud.retail.v2beta.SearchRequest.branch] to
     * `projects/&#42;&#47;locations/&#42;&#47;catalogs/&#42;&#47;branches/default_branch` is equivalent
     * to setting
     * [SearchRequest.branch][google.cloud.retail.v2beta.SearchRequest.branch] to
     * `projects/&#42;&#47;locations/&#42;&#47;catalogs/&#42;&#47;branches/1`.
     * Using multiple branches can be useful when developers would like
     * to have a staging branch to test and verify for future usage. When it
     * becomes ready, developers switch on the staging branch using this API while
     * keeping using `projects/&#42;&#47;locations/&#42;&#47;catalogs/&#42;&#47;branches/default_branch`
     * as [SearchRequest.branch][google.cloud.retail.v2beta.SearchRequest.branch]
     * to route the traffic to this staging branch.
     * CAUTION: If you have live predict/search traffic, switching the default
     * branch could potentially cause outages if the ID space of the new branch is
     * very different from the old one.
     * More specifically:
     * * PredictionService will only return product IDs from branch {newBranch}.
     * * SearchService will only return product IDs from branch {newBranch}
     *   (if branch is not explicitly set).
     * * UserEventService will only join events with products from branch
     *   {newBranch}.
     * </pre>
     */
    public void setDefaultBranch(com.google.cloud.retail.v2beta.SetDefaultBranchRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetDefaultBranchMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get which branch is currently default branch set by
     * [CatalogService.SetDefaultBranch][google.cloud.retail.v2beta.CatalogService.SetDefaultBranch]
     * method under a specified parent catalog.
     * </pre>
     */
    public void getDefaultBranch(com.google.cloud.retail.v2beta.GetDefaultBranchRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.GetDefaultBranchResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetDefaultBranchMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a [CompletionConfig][google.cloud.retail.v2beta.CompletionConfig].
     * </pre>
     */
    public void getCompletionConfig(com.google.cloud.retail.v2beta.GetCompletionConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.CompletionConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCompletionConfigMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the
     * [CompletionConfig][google.cloud.retail.v2beta.CompletionConfig]s.
     * </pre>
     */
    public void updateCompletionConfig(com.google.cloud.retail.v2beta.UpdateCompletionConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.CompletionConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateCompletionConfigMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets an [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig].
     * </pre>
     */
    public void getAttributesConfig(com.google.cloud.retail.v2beta.GetAttributesConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.AttributesConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAttributesConfigMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the
     * [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig].
     * The catalog attributes in the request will be updated in the catalog, or
     * inserted if they do not exist. Existing catalog attributes not included in
     * the request will remain unchanged. Attributes that are assigned to
     * products, but do not exist at the catalog level, are always included in the
     * response. The product attribute is assigned default values for missing
     * catalog attribute fields, e.g., searchable and dynamic facetable options.
     * </pre>
     */
    public void updateAttributesConfig(com.google.cloud.retail.v2beta.UpdateAttributesConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.AttributesConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateAttributesConfigMethod(), responseObserver);
    }

    /**
     * <pre>
     * Adds the specified
     * [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] to the
     * [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig].
     * If the [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] to
     * add already exists, an ALREADY_EXISTS error is returned.
     * </pre>
     */
    public void addCatalogAttribute(com.google.cloud.retail.v2beta.AddCatalogAttributeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.AttributesConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddCatalogAttributeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Removes the specified
     * [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] from the
     * [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig].
     * If the [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] to
     * remove does not exist, a NOT_FOUND error is returned.
     * </pre>
     */
    public void removeCatalogAttribute(com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.AttributesConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRemoveCatalogAttributeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Removes all specified
     * [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute]s from the
     * [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig].
     * </pre>
     */
    public void batchRemoveCatalogAttributes(com.google.cloud.retail.v2beta.BatchRemoveCatalogAttributesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.BatchRemoveCatalogAttributesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBatchRemoveCatalogAttributesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Replaces the specified
     * [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] in the
     * [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig] by updating
     * the catalog attribute with the same
     * [CatalogAttribute.key][google.cloud.retail.v2beta.CatalogAttribute.key].
     * If the [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] to
     * replace does not exist, a NOT_FOUND error is returned.
     * </pre>
     */
    public void replaceCatalogAttribute(com.google.cloud.retail.v2beta.ReplaceCatalogAttributeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.AttributesConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReplaceCatalogAttributeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListCatalogsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.retail.v2beta.ListCatalogsRequest,
                com.google.cloud.retail.v2beta.ListCatalogsResponse>(
                  this, METHODID_LIST_CATALOGS)))
          .addMethod(
            getUpdateCatalogMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.retail.v2beta.UpdateCatalogRequest,
                com.google.cloud.retail.v2beta.Catalog>(
                  this, METHODID_UPDATE_CATALOG)))
          .addMethod(
            getSetDefaultBranchMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.retail.v2beta.SetDefaultBranchRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_SET_DEFAULT_BRANCH)))
          .addMethod(
            getGetDefaultBranchMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.retail.v2beta.GetDefaultBranchRequest,
                com.google.cloud.retail.v2beta.GetDefaultBranchResponse>(
                  this, METHODID_GET_DEFAULT_BRANCH)))
          .addMethod(
            getGetCompletionConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.retail.v2beta.GetCompletionConfigRequest,
                com.google.cloud.retail.v2beta.CompletionConfig>(
                  this, METHODID_GET_COMPLETION_CONFIG)))
          .addMethod(
            getUpdateCompletionConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.retail.v2beta.UpdateCompletionConfigRequest,
                com.google.cloud.retail.v2beta.CompletionConfig>(
                  this, METHODID_UPDATE_COMPLETION_CONFIG)))
          .addMethod(
            getGetAttributesConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.retail.v2beta.GetAttributesConfigRequest,
                com.google.cloud.retail.v2beta.AttributesConfig>(
                  this, METHODID_GET_ATTRIBUTES_CONFIG)))
          .addMethod(
            getUpdateAttributesConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.retail.v2beta.UpdateAttributesConfigRequest,
                com.google.cloud.retail.v2beta.AttributesConfig>(
                  this, METHODID_UPDATE_ATTRIBUTES_CONFIG)))
          .addMethod(
            getAddCatalogAttributeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.retail.v2beta.AddCatalogAttributeRequest,
                com.google.cloud.retail.v2beta.AttributesConfig>(
                  this, METHODID_ADD_CATALOG_ATTRIBUTE)))
          .addMethod(
            getRemoveCatalogAttributeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest,
                com.google.cloud.retail.v2beta.AttributesConfig>(
                  this, METHODID_REMOVE_CATALOG_ATTRIBUTE)))
          .addMethod(
            getBatchRemoveCatalogAttributesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.retail.v2beta.BatchRemoveCatalogAttributesRequest,
                com.google.cloud.retail.v2beta.BatchRemoveCatalogAttributesResponse>(
                  this, METHODID_BATCH_REMOVE_CATALOG_ATTRIBUTES)))
          .addMethod(
            getReplaceCatalogAttributeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.retail.v2beta.ReplaceCatalogAttributeRequest,
                com.google.cloud.retail.v2beta.AttributesConfig>(
                  this, METHODID_REPLACE_CATALOG_ATTRIBUTE)))
          .build();
    }
  }

  /**
   * <pre>
   * Service for managing catalog configuration.
   * </pre>
   */
  public static final class CatalogServiceStub extends io.grpc.stub.AbstractAsyncStub<CatalogServiceStub> {
    private CatalogServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CatalogServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CatalogServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists all the [Catalog][google.cloud.retail.v2beta.Catalog]s associated
     * with the project.
     * </pre>
     */
    public void listCatalogs(com.google.cloud.retail.v2beta.ListCatalogsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.ListCatalogsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCatalogsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the [Catalog][google.cloud.retail.v2beta.Catalog]s.
     * </pre>
     */
    public void updateCatalog(com.google.cloud.retail.v2beta.UpdateCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.Catalog> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCatalogMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Set a specified branch id as default branch. API methods such as
     * [SearchService.Search][google.cloud.retail.v2beta.SearchService.Search],
     * [ProductService.GetProduct][google.cloud.retail.v2beta.ProductService.GetProduct],
     * [ProductService.ListProducts][google.cloud.retail.v2beta.ProductService.ListProducts]
     * will treat requests using "default_branch" to the actual branch id set as
     * default.
     * For example, if `projects/&#42;&#47;locations/&#42;&#47;catalogs/&#42;&#47;branches/1` is set as
     * default, setting
     * [SearchRequest.branch][google.cloud.retail.v2beta.SearchRequest.branch] to
     * `projects/&#42;&#47;locations/&#42;&#47;catalogs/&#42;&#47;branches/default_branch` is equivalent
     * to setting
     * [SearchRequest.branch][google.cloud.retail.v2beta.SearchRequest.branch] to
     * `projects/&#42;&#47;locations/&#42;&#47;catalogs/&#42;&#47;branches/1`.
     * Using multiple branches can be useful when developers would like
     * to have a staging branch to test and verify for future usage. When it
     * becomes ready, developers switch on the staging branch using this API while
     * keeping using `projects/&#42;&#47;locations/&#42;&#47;catalogs/&#42;&#47;branches/default_branch`
     * as [SearchRequest.branch][google.cloud.retail.v2beta.SearchRequest.branch]
     * to route the traffic to this staging branch.
     * CAUTION: If you have live predict/search traffic, switching the default
     * branch could potentially cause outages if the ID space of the new branch is
     * very different from the old one.
     * More specifically:
     * * PredictionService will only return product IDs from branch {newBranch}.
     * * SearchService will only return product IDs from branch {newBranch}
     *   (if branch is not explicitly set).
     * * UserEventService will only join events with products from branch
     *   {newBranch}.
     * </pre>
     */
    public void setDefaultBranch(com.google.cloud.retail.v2beta.SetDefaultBranchRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetDefaultBranchMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get which branch is currently default branch set by
     * [CatalogService.SetDefaultBranch][google.cloud.retail.v2beta.CatalogService.SetDefaultBranch]
     * method under a specified parent catalog.
     * </pre>
     */
    public void getDefaultBranch(com.google.cloud.retail.v2beta.GetDefaultBranchRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.GetDefaultBranchResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDefaultBranchMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a [CompletionConfig][google.cloud.retail.v2beta.CompletionConfig].
     * </pre>
     */
    public void getCompletionConfig(com.google.cloud.retail.v2beta.GetCompletionConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.CompletionConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCompletionConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the
     * [CompletionConfig][google.cloud.retail.v2beta.CompletionConfig]s.
     * </pre>
     */
    public void updateCompletionConfig(com.google.cloud.retail.v2beta.UpdateCompletionConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.CompletionConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCompletionConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets an [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig].
     * </pre>
     */
    public void getAttributesConfig(com.google.cloud.retail.v2beta.GetAttributesConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.AttributesConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAttributesConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the
     * [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig].
     * The catalog attributes in the request will be updated in the catalog, or
     * inserted if they do not exist. Existing catalog attributes not included in
     * the request will remain unchanged. Attributes that are assigned to
     * products, but do not exist at the catalog level, are always included in the
     * response. The product attribute is assigned default values for missing
     * catalog attribute fields, e.g., searchable and dynamic facetable options.
     * </pre>
     */
    public void updateAttributesConfig(com.google.cloud.retail.v2beta.UpdateAttributesConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.AttributesConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAttributesConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Adds the specified
     * [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] to the
     * [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig].
     * If the [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] to
     * add already exists, an ALREADY_EXISTS error is returned.
     * </pre>
     */
    public void addCatalogAttribute(com.google.cloud.retail.v2beta.AddCatalogAttributeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.AttributesConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddCatalogAttributeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Removes the specified
     * [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] from the
     * [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig].
     * If the [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] to
     * remove does not exist, a NOT_FOUND error is returned.
     * </pre>
     */
    public void removeCatalogAttribute(com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.AttributesConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRemoveCatalogAttributeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Removes all specified
     * [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute]s from the
     * [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig].
     * </pre>
     */
    public void batchRemoveCatalogAttributes(com.google.cloud.retail.v2beta.BatchRemoveCatalogAttributesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.BatchRemoveCatalogAttributesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchRemoveCatalogAttributesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Replaces the specified
     * [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] in the
     * [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig] by updating
     * the catalog attribute with the same
     * [CatalogAttribute.key][google.cloud.retail.v2beta.CatalogAttribute.key].
     * If the [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] to
     * replace does not exist, a NOT_FOUND error is returned.
     * </pre>
     */
    public void replaceCatalogAttribute(com.google.cloud.retail.v2beta.ReplaceCatalogAttributeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.AttributesConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReplaceCatalogAttributeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service for managing catalog configuration.
   * </pre>
   */
  public static final class CatalogServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<CatalogServiceBlockingStub> {
    private CatalogServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CatalogServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CatalogServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists all the [Catalog][google.cloud.retail.v2beta.Catalog]s associated
     * with the project.
     * </pre>
     */
    public com.google.cloud.retail.v2beta.ListCatalogsResponse listCatalogs(com.google.cloud.retail.v2beta.ListCatalogsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCatalogsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the [Catalog][google.cloud.retail.v2beta.Catalog]s.
     * </pre>
     */
    public com.google.cloud.retail.v2beta.Catalog updateCatalog(com.google.cloud.retail.v2beta.UpdateCatalogRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCatalogMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Set a specified branch id as default branch. API methods such as
     * [SearchService.Search][google.cloud.retail.v2beta.SearchService.Search],
     * [ProductService.GetProduct][google.cloud.retail.v2beta.ProductService.GetProduct],
     * [ProductService.ListProducts][google.cloud.retail.v2beta.ProductService.ListProducts]
     * will treat requests using "default_branch" to the actual branch id set as
     * default.
     * For example, if `projects/&#42;&#47;locations/&#42;&#47;catalogs/&#42;&#47;branches/1` is set as
     * default, setting
     * [SearchRequest.branch][google.cloud.retail.v2beta.SearchRequest.branch] to
     * `projects/&#42;&#47;locations/&#42;&#47;catalogs/&#42;&#47;branches/default_branch` is equivalent
     * to setting
     * [SearchRequest.branch][google.cloud.retail.v2beta.SearchRequest.branch] to
     * `projects/&#42;&#47;locations/&#42;&#47;catalogs/&#42;&#47;branches/1`.
     * Using multiple branches can be useful when developers would like
     * to have a staging branch to test and verify for future usage. When it
     * becomes ready, developers switch on the staging branch using this API while
     * keeping using `projects/&#42;&#47;locations/&#42;&#47;catalogs/&#42;&#47;branches/default_branch`
     * as [SearchRequest.branch][google.cloud.retail.v2beta.SearchRequest.branch]
     * to route the traffic to this staging branch.
     * CAUTION: If you have live predict/search traffic, switching the default
     * branch could potentially cause outages if the ID space of the new branch is
     * very different from the old one.
     * More specifically:
     * * PredictionService will only return product IDs from branch {newBranch}.
     * * SearchService will only return product IDs from branch {newBranch}
     *   (if branch is not explicitly set).
     * * UserEventService will only join events with products from branch
     *   {newBranch}.
     * </pre>
     */
    public com.google.protobuf.Empty setDefaultBranch(com.google.cloud.retail.v2beta.SetDefaultBranchRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetDefaultBranchMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get which branch is currently default branch set by
     * [CatalogService.SetDefaultBranch][google.cloud.retail.v2beta.CatalogService.SetDefaultBranch]
     * method under a specified parent catalog.
     * </pre>
     */
    public com.google.cloud.retail.v2beta.GetDefaultBranchResponse getDefaultBranch(com.google.cloud.retail.v2beta.GetDefaultBranchRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDefaultBranchMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a [CompletionConfig][google.cloud.retail.v2beta.CompletionConfig].
     * </pre>
     */
    public com.google.cloud.retail.v2beta.CompletionConfig getCompletionConfig(com.google.cloud.retail.v2beta.GetCompletionConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCompletionConfigMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the
     * [CompletionConfig][google.cloud.retail.v2beta.CompletionConfig]s.
     * </pre>
     */
    public com.google.cloud.retail.v2beta.CompletionConfig updateCompletionConfig(com.google.cloud.retail.v2beta.UpdateCompletionConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCompletionConfigMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets an [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig].
     * </pre>
     */
    public com.google.cloud.retail.v2beta.AttributesConfig getAttributesConfig(com.google.cloud.retail.v2beta.GetAttributesConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAttributesConfigMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the
     * [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig].
     * The catalog attributes in the request will be updated in the catalog, or
     * inserted if they do not exist. Existing catalog attributes not included in
     * the request will remain unchanged. Attributes that are assigned to
     * products, but do not exist at the catalog level, are always included in the
     * response. The product attribute is assigned default values for missing
     * catalog attribute fields, e.g., searchable and dynamic facetable options.
     * </pre>
     */
    public com.google.cloud.retail.v2beta.AttributesConfig updateAttributesConfig(com.google.cloud.retail.v2beta.UpdateAttributesConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAttributesConfigMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Adds the specified
     * [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] to the
     * [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig].
     * If the [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] to
     * add already exists, an ALREADY_EXISTS error is returned.
     * </pre>
     */
    public com.google.cloud.retail.v2beta.AttributesConfig addCatalogAttribute(com.google.cloud.retail.v2beta.AddCatalogAttributeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddCatalogAttributeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Removes the specified
     * [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] from the
     * [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig].
     * If the [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] to
     * remove does not exist, a NOT_FOUND error is returned.
     * </pre>
     */
    public com.google.cloud.retail.v2beta.AttributesConfig removeCatalogAttribute(com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveCatalogAttributeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Removes all specified
     * [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute]s from the
     * [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig].
     * </pre>
     */
    public com.google.cloud.retail.v2beta.BatchRemoveCatalogAttributesResponse batchRemoveCatalogAttributes(com.google.cloud.retail.v2beta.BatchRemoveCatalogAttributesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchRemoveCatalogAttributesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Replaces the specified
     * [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] in the
     * [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig] by updating
     * the catalog attribute with the same
     * [CatalogAttribute.key][google.cloud.retail.v2beta.CatalogAttribute.key].
     * If the [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] to
     * replace does not exist, a NOT_FOUND error is returned.
     * </pre>
     */
    public com.google.cloud.retail.v2beta.AttributesConfig replaceCatalogAttribute(com.google.cloud.retail.v2beta.ReplaceCatalogAttributeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReplaceCatalogAttributeMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service for managing catalog configuration.
   * </pre>
   */
  public static final class CatalogServiceFutureStub extends io.grpc.stub.AbstractFutureStub<CatalogServiceFutureStub> {
    private CatalogServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CatalogServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CatalogServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists all the [Catalog][google.cloud.retail.v2beta.Catalog]s associated
     * with the project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.retail.v2beta.ListCatalogsResponse> listCatalogs(
        com.google.cloud.retail.v2beta.ListCatalogsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCatalogsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the [Catalog][google.cloud.retail.v2beta.Catalog]s.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.retail.v2beta.Catalog> updateCatalog(
        com.google.cloud.retail.v2beta.UpdateCatalogRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCatalogMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Set a specified branch id as default branch. API methods such as
     * [SearchService.Search][google.cloud.retail.v2beta.SearchService.Search],
     * [ProductService.GetProduct][google.cloud.retail.v2beta.ProductService.GetProduct],
     * [ProductService.ListProducts][google.cloud.retail.v2beta.ProductService.ListProducts]
     * will treat requests using "default_branch" to the actual branch id set as
     * default.
     * For example, if `projects/&#42;&#47;locations/&#42;&#47;catalogs/&#42;&#47;branches/1` is set as
     * default, setting
     * [SearchRequest.branch][google.cloud.retail.v2beta.SearchRequest.branch] to
     * `projects/&#42;&#47;locations/&#42;&#47;catalogs/&#42;&#47;branches/default_branch` is equivalent
     * to setting
     * [SearchRequest.branch][google.cloud.retail.v2beta.SearchRequest.branch] to
     * `projects/&#42;&#47;locations/&#42;&#47;catalogs/&#42;&#47;branches/1`.
     * Using multiple branches can be useful when developers would like
     * to have a staging branch to test and verify for future usage. When it
     * becomes ready, developers switch on the staging branch using this API while
     * keeping using `projects/&#42;&#47;locations/&#42;&#47;catalogs/&#42;&#47;branches/default_branch`
     * as [SearchRequest.branch][google.cloud.retail.v2beta.SearchRequest.branch]
     * to route the traffic to this staging branch.
     * CAUTION: If you have live predict/search traffic, switching the default
     * branch could potentially cause outages if the ID space of the new branch is
     * very different from the old one.
     * More specifically:
     * * PredictionService will only return product IDs from branch {newBranch}.
     * * SearchService will only return product IDs from branch {newBranch}
     *   (if branch is not explicitly set).
     * * UserEventService will only join events with products from branch
     *   {newBranch}.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> setDefaultBranch(
        com.google.cloud.retail.v2beta.SetDefaultBranchRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetDefaultBranchMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get which branch is currently default branch set by
     * [CatalogService.SetDefaultBranch][google.cloud.retail.v2beta.CatalogService.SetDefaultBranch]
     * method under a specified parent catalog.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.retail.v2beta.GetDefaultBranchResponse> getDefaultBranch(
        com.google.cloud.retail.v2beta.GetDefaultBranchRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDefaultBranchMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a [CompletionConfig][google.cloud.retail.v2beta.CompletionConfig].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.retail.v2beta.CompletionConfig> getCompletionConfig(
        com.google.cloud.retail.v2beta.GetCompletionConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCompletionConfigMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the
     * [CompletionConfig][google.cloud.retail.v2beta.CompletionConfig]s.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.retail.v2beta.CompletionConfig> updateCompletionConfig(
        com.google.cloud.retail.v2beta.UpdateCompletionConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCompletionConfigMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets an [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.retail.v2beta.AttributesConfig> getAttributesConfig(
        com.google.cloud.retail.v2beta.GetAttributesConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAttributesConfigMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the
     * [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig].
     * The catalog attributes in the request will be updated in the catalog, or
     * inserted if they do not exist. Existing catalog attributes not included in
     * the request will remain unchanged. Attributes that are assigned to
     * products, but do not exist at the catalog level, are always included in the
     * response. The product attribute is assigned default values for missing
     * catalog attribute fields, e.g., searchable and dynamic facetable options.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.retail.v2beta.AttributesConfig> updateAttributesConfig(
        com.google.cloud.retail.v2beta.UpdateAttributesConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAttributesConfigMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Adds the specified
     * [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] to the
     * [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig].
     * If the [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] to
     * add already exists, an ALREADY_EXISTS error is returned.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.retail.v2beta.AttributesConfig> addCatalogAttribute(
        com.google.cloud.retail.v2beta.AddCatalogAttributeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddCatalogAttributeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Removes the specified
     * [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] from the
     * [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig].
     * If the [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] to
     * remove does not exist, a NOT_FOUND error is returned.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.retail.v2beta.AttributesConfig> removeCatalogAttribute(
        com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRemoveCatalogAttributeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Removes all specified
     * [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute]s from the
     * [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.retail.v2beta.BatchRemoveCatalogAttributesResponse> batchRemoveCatalogAttributes(
        com.google.cloud.retail.v2beta.BatchRemoveCatalogAttributesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchRemoveCatalogAttributesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Replaces the specified
     * [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] in the
     * [AttributesConfig][google.cloud.retail.v2beta.AttributesConfig] by updating
     * the catalog attribute with the same
     * [CatalogAttribute.key][google.cloud.retail.v2beta.CatalogAttribute.key].
     * If the [CatalogAttribute][google.cloud.retail.v2beta.CatalogAttribute] to
     * replace does not exist, a NOT_FOUND error is returned.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.retail.v2beta.AttributesConfig> replaceCatalogAttribute(
        com.google.cloud.retail.v2beta.ReplaceCatalogAttributeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReplaceCatalogAttributeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_CATALOGS = 0;
  private static final int METHODID_UPDATE_CATALOG = 1;
  private static final int METHODID_SET_DEFAULT_BRANCH = 2;
  private static final int METHODID_GET_DEFAULT_BRANCH = 3;
  private static final int METHODID_GET_COMPLETION_CONFIG = 4;
  private static final int METHODID_UPDATE_COMPLETION_CONFIG = 5;
  private static final int METHODID_GET_ATTRIBUTES_CONFIG = 6;
  private static final int METHODID_UPDATE_ATTRIBUTES_CONFIG = 7;
  private static final int METHODID_ADD_CATALOG_ATTRIBUTE = 8;
  private static final int METHODID_REMOVE_CATALOG_ATTRIBUTE = 9;
  private static final int METHODID_BATCH_REMOVE_CATALOG_ATTRIBUTES = 10;
  private static final int METHODID_REPLACE_CATALOG_ATTRIBUTE = 11;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CatalogServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CatalogServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_CATALOGS:
          serviceImpl.listCatalogs((com.google.cloud.retail.v2beta.ListCatalogsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.ListCatalogsResponse>) responseObserver);
          break;
        case METHODID_UPDATE_CATALOG:
          serviceImpl.updateCatalog((com.google.cloud.retail.v2beta.UpdateCatalogRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.Catalog>) responseObserver);
          break;
        case METHODID_SET_DEFAULT_BRANCH:
          serviceImpl.setDefaultBranch((com.google.cloud.retail.v2beta.SetDefaultBranchRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_DEFAULT_BRANCH:
          serviceImpl.getDefaultBranch((com.google.cloud.retail.v2beta.GetDefaultBranchRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.GetDefaultBranchResponse>) responseObserver);
          break;
        case METHODID_GET_COMPLETION_CONFIG:
          serviceImpl.getCompletionConfig((com.google.cloud.retail.v2beta.GetCompletionConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.CompletionConfig>) responseObserver);
          break;
        case METHODID_UPDATE_COMPLETION_CONFIG:
          serviceImpl.updateCompletionConfig((com.google.cloud.retail.v2beta.UpdateCompletionConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.CompletionConfig>) responseObserver);
          break;
        case METHODID_GET_ATTRIBUTES_CONFIG:
          serviceImpl.getAttributesConfig((com.google.cloud.retail.v2beta.GetAttributesConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.AttributesConfig>) responseObserver);
          break;
        case METHODID_UPDATE_ATTRIBUTES_CONFIG:
          serviceImpl.updateAttributesConfig((com.google.cloud.retail.v2beta.UpdateAttributesConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.AttributesConfig>) responseObserver);
          break;
        case METHODID_ADD_CATALOG_ATTRIBUTE:
          serviceImpl.addCatalogAttribute((com.google.cloud.retail.v2beta.AddCatalogAttributeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.AttributesConfig>) responseObserver);
          break;
        case METHODID_REMOVE_CATALOG_ATTRIBUTE:
          serviceImpl.removeCatalogAttribute((com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.AttributesConfig>) responseObserver);
          break;
        case METHODID_BATCH_REMOVE_CATALOG_ATTRIBUTES:
          serviceImpl.batchRemoveCatalogAttributes((com.google.cloud.retail.v2beta.BatchRemoveCatalogAttributesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.BatchRemoveCatalogAttributesResponse>) responseObserver);
          break;
        case METHODID_REPLACE_CATALOG_ATTRIBUTE:
          serviceImpl.replaceCatalogAttribute((com.google.cloud.retail.v2beta.ReplaceCatalogAttributeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.retail.v2beta.AttributesConfig>) responseObserver);
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

  private static abstract class CatalogServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CatalogServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.retail.v2beta.CatalogServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CatalogService");
    }
  }

  private static final class CatalogServiceFileDescriptorSupplier
      extends CatalogServiceBaseDescriptorSupplier {
    CatalogServiceFileDescriptorSupplier() {}
  }

  private static final class CatalogServiceMethodDescriptorSupplier
      extends CatalogServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CatalogServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CatalogServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CatalogServiceFileDescriptorSupplier())
              .addMethod(getListCatalogsMethod())
              .addMethod(getUpdateCatalogMethod())
              .addMethod(getSetDefaultBranchMethod())
              .addMethod(getGetDefaultBranchMethod())
              .addMethod(getGetCompletionConfigMethod())
              .addMethod(getUpdateCompletionConfigMethod())
              .addMethod(getGetAttributesConfigMethod())
              .addMethod(getUpdateAttributesConfigMethod())
              .addMethod(getAddCatalogAttributeMethod())
              .addMethod(getRemoveCatalogAttributeMethod())
              .addMethod(getBatchRemoveCatalogAttributesMethod())
              .addMethod(getReplaceCatalogAttributeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
