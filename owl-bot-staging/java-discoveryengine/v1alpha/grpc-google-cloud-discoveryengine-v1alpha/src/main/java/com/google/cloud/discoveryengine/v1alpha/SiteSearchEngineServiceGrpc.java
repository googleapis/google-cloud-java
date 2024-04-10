package com.google.cloud.discoveryengine.v1alpha;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Service for managing site search related resources.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/discoveryengine/v1alpha/site_search_engine_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SiteSearchEngineServiceGrpc {

  private SiteSearchEngineServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.discoveryengine.v1alpha.SiteSearchEngineService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.GetSiteSearchEngineRequest,
      com.google.cloud.discoveryengine.v1alpha.SiteSearchEngine> getGetSiteSearchEngineMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSiteSearchEngine",
      requestType = com.google.cloud.discoveryengine.v1alpha.GetSiteSearchEngineRequest.class,
      responseType = com.google.cloud.discoveryengine.v1alpha.SiteSearchEngine.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.GetSiteSearchEngineRequest,
      com.google.cloud.discoveryengine.v1alpha.SiteSearchEngine> getGetSiteSearchEngineMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.GetSiteSearchEngineRequest, com.google.cloud.discoveryengine.v1alpha.SiteSearchEngine> getGetSiteSearchEngineMethod;
    if ((getGetSiteSearchEngineMethod = SiteSearchEngineServiceGrpc.getGetSiteSearchEngineMethod) == null) {
      synchronized (SiteSearchEngineServiceGrpc.class) {
        if ((getGetSiteSearchEngineMethod = SiteSearchEngineServiceGrpc.getGetSiteSearchEngineMethod) == null) {
          SiteSearchEngineServiceGrpc.getGetSiteSearchEngineMethod = getGetSiteSearchEngineMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.discoveryengine.v1alpha.GetSiteSearchEngineRequest, com.google.cloud.discoveryengine.v1alpha.SiteSearchEngine>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSiteSearchEngine"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.discoveryengine.v1alpha.GetSiteSearchEngineRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.discoveryengine.v1alpha.SiteSearchEngine.getDefaultInstance()))
              .setSchemaDescriptor(new SiteSearchEngineServiceMethodDescriptorSupplier("GetSiteSearchEngine"))
              .build();
        }
      }
    }
    return getGetSiteSearchEngineMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.CreateTargetSiteRequest,
      com.google.longrunning.Operation> getCreateTargetSiteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTargetSite",
      requestType = com.google.cloud.discoveryengine.v1alpha.CreateTargetSiteRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.CreateTargetSiteRequest,
      com.google.longrunning.Operation> getCreateTargetSiteMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.CreateTargetSiteRequest, com.google.longrunning.Operation> getCreateTargetSiteMethod;
    if ((getCreateTargetSiteMethod = SiteSearchEngineServiceGrpc.getCreateTargetSiteMethod) == null) {
      synchronized (SiteSearchEngineServiceGrpc.class) {
        if ((getCreateTargetSiteMethod = SiteSearchEngineServiceGrpc.getCreateTargetSiteMethod) == null) {
          SiteSearchEngineServiceGrpc.getCreateTargetSiteMethod = getCreateTargetSiteMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.discoveryengine.v1alpha.CreateTargetSiteRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTargetSite"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.discoveryengine.v1alpha.CreateTargetSiteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new SiteSearchEngineServiceMethodDescriptorSupplier("CreateTargetSite"))
              .build();
        }
      }
    }
    return getCreateTargetSiteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.BatchCreateTargetSitesRequest,
      com.google.longrunning.Operation> getBatchCreateTargetSitesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchCreateTargetSites",
      requestType = com.google.cloud.discoveryengine.v1alpha.BatchCreateTargetSitesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.BatchCreateTargetSitesRequest,
      com.google.longrunning.Operation> getBatchCreateTargetSitesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.BatchCreateTargetSitesRequest, com.google.longrunning.Operation> getBatchCreateTargetSitesMethod;
    if ((getBatchCreateTargetSitesMethod = SiteSearchEngineServiceGrpc.getBatchCreateTargetSitesMethod) == null) {
      synchronized (SiteSearchEngineServiceGrpc.class) {
        if ((getBatchCreateTargetSitesMethod = SiteSearchEngineServiceGrpc.getBatchCreateTargetSitesMethod) == null) {
          SiteSearchEngineServiceGrpc.getBatchCreateTargetSitesMethod = getBatchCreateTargetSitesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.discoveryengine.v1alpha.BatchCreateTargetSitesRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchCreateTargetSites"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.discoveryengine.v1alpha.BatchCreateTargetSitesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new SiteSearchEngineServiceMethodDescriptorSupplier("BatchCreateTargetSites"))
              .build();
        }
      }
    }
    return getBatchCreateTargetSitesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.GetTargetSiteRequest,
      com.google.cloud.discoveryengine.v1alpha.TargetSite> getGetTargetSiteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTargetSite",
      requestType = com.google.cloud.discoveryengine.v1alpha.GetTargetSiteRequest.class,
      responseType = com.google.cloud.discoveryengine.v1alpha.TargetSite.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.GetTargetSiteRequest,
      com.google.cloud.discoveryengine.v1alpha.TargetSite> getGetTargetSiteMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.GetTargetSiteRequest, com.google.cloud.discoveryengine.v1alpha.TargetSite> getGetTargetSiteMethod;
    if ((getGetTargetSiteMethod = SiteSearchEngineServiceGrpc.getGetTargetSiteMethod) == null) {
      synchronized (SiteSearchEngineServiceGrpc.class) {
        if ((getGetTargetSiteMethod = SiteSearchEngineServiceGrpc.getGetTargetSiteMethod) == null) {
          SiteSearchEngineServiceGrpc.getGetTargetSiteMethod = getGetTargetSiteMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.discoveryengine.v1alpha.GetTargetSiteRequest, com.google.cloud.discoveryengine.v1alpha.TargetSite>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTargetSite"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.discoveryengine.v1alpha.GetTargetSiteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.discoveryengine.v1alpha.TargetSite.getDefaultInstance()))
              .setSchemaDescriptor(new SiteSearchEngineServiceMethodDescriptorSupplier("GetTargetSite"))
              .build();
        }
      }
    }
    return getGetTargetSiteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.UpdateTargetSiteRequest,
      com.google.longrunning.Operation> getUpdateTargetSiteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTargetSite",
      requestType = com.google.cloud.discoveryengine.v1alpha.UpdateTargetSiteRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.UpdateTargetSiteRequest,
      com.google.longrunning.Operation> getUpdateTargetSiteMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.UpdateTargetSiteRequest, com.google.longrunning.Operation> getUpdateTargetSiteMethod;
    if ((getUpdateTargetSiteMethod = SiteSearchEngineServiceGrpc.getUpdateTargetSiteMethod) == null) {
      synchronized (SiteSearchEngineServiceGrpc.class) {
        if ((getUpdateTargetSiteMethod = SiteSearchEngineServiceGrpc.getUpdateTargetSiteMethod) == null) {
          SiteSearchEngineServiceGrpc.getUpdateTargetSiteMethod = getUpdateTargetSiteMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.discoveryengine.v1alpha.UpdateTargetSiteRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTargetSite"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.discoveryengine.v1alpha.UpdateTargetSiteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new SiteSearchEngineServiceMethodDescriptorSupplier("UpdateTargetSite"))
              .build();
        }
      }
    }
    return getUpdateTargetSiteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.DeleteTargetSiteRequest,
      com.google.longrunning.Operation> getDeleteTargetSiteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTargetSite",
      requestType = com.google.cloud.discoveryengine.v1alpha.DeleteTargetSiteRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.DeleteTargetSiteRequest,
      com.google.longrunning.Operation> getDeleteTargetSiteMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.DeleteTargetSiteRequest, com.google.longrunning.Operation> getDeleteTargetSiteMethod;
    if ((getDeleteTargetSiteMethod = SiteSearchEngineServiceGrpc.getDeleteTargetSiteMethod) == null) {
      synchronized (SiteSearchEngineServiceGrpc.class) {
        if ((getDeleteTargetSiteMethod = SiteSearchEngineServiceGrpc.getDeleteTargetSiteMethod) == null) {
          SiteSearchEngineServiceGrpc.getDeleteTargetSiteMethod = getDeleteTargetSiteMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.discoveryengine.v1alpha.DeleteTargetSiteRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTargetSite"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.discoveryengine.v1alpha.DeleteTargetSiteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new SiteSearchEngineServiceMethodDescriptorSupplier("DeleteTargetSite"))
              .build();
        }
      }
    }
    return getDeleteTargetSiteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.ListTargetSitesRequest,
      com.google.cloud.discoveryengine.v1alpha.ListTargetSitesResponse> getListTargetSitesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTargetSites",
      requestType = com.google.cloud.discoveryengine.v1alpha.ListTargetSitesRequest.class,
      responseType = com.google.cloud.discoveryengine.v1alpha.ListTargetSitesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.ListTargetSitesRequest,
      com.google.cloud.discoveryengine.v1alpha.ListTargetSitesResponse> getListTargetSitesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.ListTargetSitesRequest, com.google.cloud.discoveryengine.v1alpha.ListTargetSitesResponse> getListTargetSitesMethod;
    if ((getListTargetSitesMethod = SiteSearchEngineServiceGrpc.getListTargetSitesMethod) == null) {
      synchronized (SiteSearchEngineServiceGrpc.class) {
        if ((getListTargetSitesMethod = SiteSearchEngineServiceGrpc.getListTargetSitesMethod) == null) {
          SiteSearchEngineServiceGrpc.getListTargetSitesMethod = getListTargetSitesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.discoveryengine.v1alpha.ListTargetSitesRequest, com.google.cloud.discoveryengine.v1alpha.ListTargetSitesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTargetSites"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.discoveryengine.v1alpha.ListTargetSitesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.discoveryengine.v1alpha.ListTargetSitesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SiteSearchEngineServiceMethodDescriptorSupplier("ListTargetSites"))
              .build();
        }
      }
    }
    return getListTargetSitesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.EnableAdvancedSiteSearchRequest,
      com.google.longrunning.Operation> getEnableAdvancedSiteSearchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EnableAdvancedSiteSearch",
      requestType = com.google.cloud.discoveryengine.v1alpha.EnableAdvancedSiteSearchRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.EnableAdvancedSiteSearchRequest,
      com.google.longrunning.Operation> getEnableAdvancedSiteSearchMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.EnableAdvancedSiteSearchRequest, com.google.longrunning.Operation> getEnableAdvancedSiteSearchMethod;
    if ((getEnableAdvancedSiteSearchMethod = SiteSearchEngineServiceGrpc.getEnableAdvancedSiteSearchMethod) == null) {
      synchronized (SiteSearchEngineServiceGrpc.class) {
        if ((getEnableAdvancedSiteSearchMethod = SiteSearchEngineServiceGrpc.getEnableAdvancedSiteSearchMethod) == null) {
          SiteSearchEngineServiceGrpc.getEnableAdvancedSiteSearchMethod = getEnableAdvancedSiteSearchMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.discoveryengine.v1alpha.EnableAdvancedSiteSearchRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EnableAdvancedSiteSearch"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.discoveryengine.v1alpha.EnableAdvancedSiteSearchRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new SiteSearchEngineServiceMethodDescriptorSupplier("EnableAdvancedSiteSearch"))
              .build();
        }
      }
    }
    return getEnableAdvancedSiteSearchMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.DisableAdvancedSiteSearchRequest,
      com.google.longrunning.Operation> getDisableAdvancedSiteSearchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DisableAdvancedSiteSearch",
      requestType = com.google.cloud.discoveryengine.v1alpha.DisableAdvancedSiteSearchRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.DisableAdvancedSiteSearchRequest,
      com.google.longrunning.Operation> getDisableAdvancedSiteSearchMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.DisableAdvancedSiteSearchRequest, com.google.longrunning.Operation> getDisableAdvancedSiteSearchMethod;
    if ((getDisableAdvancedSiteSearchMethod = SiteSearchEngineServiceGrpc.getDisableAdvancedSiteSearchMethod) == null) {
      synchronized (SiteSearchEngineServiceGrpc.class) {
        if ((getDisableAdvancedSiteSearchMethod = SiteSearchEngineServiceGrpc.getDisableAdvancedSiteSearchMethod) == null) {
          SiteSearchEngineServiceGrpc.getDisableAdvancedSiteSearchMethod = getDisableAdvancedSiteSearchMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.discoveryengine.v1alpha.DisableAdvancedSiteSearchRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DisableAdvancedSiteSearch"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.discoveryengine.v1alpha.DisableAdvancedSiteSearchRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new SiteSearchEngineServiceMethodDescriptorSupplier("DisableAdvancedSiteSearch"))
              .build();
        }
      }
    }
    return getDisableAdvancedSiteSearchMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.RecrawlUrisRequest,
      com.google.longrunning.Operation> getRecrawlUrisMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RecrawlUris",
      requestType = com.google.cloud.discoveryengine.v1alpha.RecrawlUrisRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.RecrawlUrisRequest,
      com.google.longrunning.Operation> getRecrawlUrisMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.RecrawlUrisRequest, com.google.longrunning.Operation> getRecrawlUrisMethod;
    if ((getRecrawlUrisMethod = SiteSearchEngineServiceGrpc.getRecrawlUrisMethod) == null) {
      synchronized (SiteSearchEngineServiceGrpc.class) {
        if ((getRecrawlUrisMethod = SiteSearchEngineServiceGrpc.getRecrawlUrisMethod) == null) {
          SiteSearchEngineServiceGrpc.getRecrawlUrisMethod = getRecrawlUrisMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.discoveryengine.v1alpha.RecrawlUrisRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RecrawlUris"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.discoveryengine.v1alpha.RecrawlUrisRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new SiteSearchEngineServiceMethodDescriptorSupplier("RecrawlUris"))
              .build();
        }
      }
    }
    return getRecrawlUrisMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.BatchVerifyTargetSitesRequest,
      com.google.longrunning.Operation> getBatchVerifyTargetSitesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchVerifyTargetSites",
      requestType = com.google.cloud.discoveryengine.v1alpha.BatchVerifyTargetSitesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.BatchVerifyTargetSitesRequest,
      com.google.longrunning.Operation> getBatchVerifyTargetSitesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.BatchVerifyTargetSitesRequest, com.google.longrunning.Operation> getBatchVerifyTargetSitesMethod;
    if ((getBatchVerifyTargetSitesMethod = SiteSearchEngineServiceGrpc.getBatchVerifyTargetSitesMethod) == null) {
      synchronized (SiteSearchEngineServiceGrpc.class) {
        if ((getBatchVerifyTargetSitesMethod = SiteSearchEngineServiceGrpc.getBatchVerifyTargetSitesMethod) == null) {
          SiteSearchEngineServiceGrpc.getBatchVerifyTargetSitesMethod = getBatchVerifyTargetSitesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.discoveryengine.v1alpha.BatchVerifyTargetSitesRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchVerifyTargetSites"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.discoveryengine.v1alpha.BatchVerifyTargetSitesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new SiteSearchEngineServiceMethodDescriptorSupplier("BatchVerifyTargetSites"))
              .build();
        }
      }
    }
    return getBatchVerifyTargetSitesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.FetchDomainVerificationStatusRequest,
      com.google.cloud.discoveryengine.v1alpha.FetchDomainVerificationStatusResponse> getFetchDomainVerificationStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchDomainVerificationStatus",
      requestType = com.google.cloud.discoveryengine.v1alpha.FetchDomainVerificationStatusRequest.class,
      responseType = com.google.cloud.discoveryengine.v1alpha.FetchDomainVerificationStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.FetchDomainVerificationStatusRequest,
      com.google.cloud.discoveryengine.v1alpha.FetchDomainVerificationStatusResponse> getFetchDomainVerificationStatusMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.discoveryengine.v1alpha.FetchDomainVerificationStatusRequest, com.google.cloud.discoveryengine.v1alpha.FetchDomainVerificationStatusResponse> getFetchDomainVerificationStatusMethod;
    if ((getFetchDomainVerificationStatusMethod = SiteSearchEngineServiceGrpc.getFetchDomainVerificationStatusMethod) == null) {
      synchronized (SiteSearchEngineServiceGrpc.class) {
        if ((getFetchDomainVerificationStatusMethod = SiteSearchEngineServiceGrpc.getFetchDomainVerificationStatusMethod) == null) {
          SiteSearchEngineServiceGrpc.getFetchDomainVerificationStatusMethod = getFetchDomainVerificationStatusMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.discoveryengine.v1alpha.FetchDomainVerificationStatusRequest, com.google.cloud.discoveryengine.v1alpha.FetchDomainVerificationStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FetchDomainVerificationStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.discoveryengine.v1alpha.FetchDomainVerificationStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.discoveryengine.v1alpha.FetchDomainVerificationStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SiteSearchEngineServiceMethodDescriptorSupplier("FetchDomainVerificationStatus"))
              .build();
        }
      }
    }
    return getFetchDomainVerificationStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SiteSearchEngineServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SiteSearchEngineServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SiteSearchEngineServiceStub>() {
        @java.lang.Override
        public SiteSearchEngineServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SiteSearchEngineServiceStub(channel, callOptions);
        }
      };
    return SiteSearchEngineServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SiteSearchEngineServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SiteSearchEngineServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SiteSearchEngineServiceBlockingStub>() {
        @java.lang.Override
        public SiteSearchEngineServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SiteSearchEngineServiceBlockingStub(channel, callOptions);
        }
      };
    return SiteSearchEngineServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SiteSearchEngineServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SiteSearchEngineServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SiteSearchEngineServiceFutureStub>() {
        @java.lang.Override
        public SiteSearchEngineServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SiteSearchEngineServiceFutureStub(channel, callOptions);
        }
      };
    return SiteSearchEngineServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Service for managing site search related resources.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Gets the
     * [SiteSearchEngine][google.cloud.discoveryengine.v1alpha.SiteSearchEngine].
     * </pre>
     */
    default void getSiteSearchEngine(com.google.cloud.discoveryengine.v1alpha.GetSiteSearchEngineRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.SiteSearchEngine> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSiteSearchEngineMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a [TargetSite][google.cloud.discoveryengine.v1alpha.TargetSite].
     * </pre>
     */
    default void createTargetSite(com.google.cloud.discoveryengine.v1alpha.CreateTargetSiteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateTargetSiteMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates [TargetSite][google.cloud.discoveryengine.v1alpha.TargetSite] in a
     * batch.
     * </pre>
     */
    default void batchCreateTargetSites(com.google.cloud.discoveryengine.v1alpha.BatchCreateTargetSitesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBatchCreateTargetSitesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a [TargetSite][google.cloud.discoveryengine.v1alpha.TargetSite].
     * </pre>
     */
    default void getTargetSite(com.google.cloud.discoveryengine.v1alpha.GetTargetSiteRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.TargetSite> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTargetSiteMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a [TargetSite][google.cloud.discoveryengine.v1alpha.TargetSite].
     * </pre>
     */
    default void updateTargetSite(com.google.cloud.discoveryengine.v1alpha.UpdateTargetSiteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateTargetSiteMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a [TargetSite][google.cloud.discoveryengine.v1alpha.TargetSite].
     * </pre>
     */
    default void deleteTargetSite(com.google.cloud.discoveryengine.v1alpha.DeleteTargetSiteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteTargetSiteMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a list of
     * [TargetSite][google.cloud.discoveryengine.v1alpha.TargetSite]s.
     * </pre>
     */
    default void listTargetSites(com.google.cloud.discoveryengine.v1alpha.ListTargetSitesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.ListTargetSitesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListTargetSitesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Upgrade from basic site search to advanced site search.
     * </pre>
     */
    default void enableAdvancedSiteSearch(com.google.cloud.discoveryengine.v1alpha.EnableAdvancedSiteSearchRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEnableAdvancedSiteSearchMethod(), responseObserver);
    }

    /**
     * <pre>
     * Downgrade from advanced site search to basic site search.
     * </pre>
     */
    default void disableAdvancedSiteSearch(com.google.cloud.discoveryengine.v1alpha.DisableAdvancedSiteSearchRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDisableAdvancedSiteSearchMethod(), responseObserver);
    }

    /**
     * <pre>
     * Request on-demand recrawl for a list of URIs.
     * </pre>
     */
    default void recrawlUris(com.google.cloud.discoveryengine.v1alpha.RecrawlUrisRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRecrawlUrisMethod(), responseObserver);
    }

    /**
     * <pre>
     * Verify target sites' ownership and validity.
     * This API sends all the target sites under site search engine for
     * verification.
     * </pre>
     */
    default void batchVerifyTargetSites(com.google.cloud.discoveryengine.v1alpha.BatchVerifyTargetSitesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBatchVerifyTargetSitesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns list of target sites with its domain verification status.
     * This method can only be called under data store with BASIC_SITE_SEARCH
     * state at the moment.
     * </pre>
     */
    default void fetchDomainVerificationStatus(com.google.cloud.discoveryengine.v1alpha.FetchDomainVerificationStatusRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.FetchDomainVerificationStatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFetchDomainVerificationStatusMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SiteSearchEngineService.
   * <pre>
   * Service for managing site search related resources.
   * </pre>
   */
  public static abstract class SiteSearchEngineServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return SiteSearchEngineServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SiteSearchEngineService.
   * <pre>
   * Service for managing site search related resources.
   * </pre>
   */
  public static final class SiteSearchEngineServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SiteSearchEngineServiceStub> {
    private SiteSearchEngineServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SiteSearchEngineServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SiteSearchEngineServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Gets the
     * [SiteSearchEngine][google.cloud.discoveryengine.v1alpha.SiteSearchEngine].
     * </pre>
     */
    public void getSiteSearchEngine(com.google.cloud.discoveryengine.v1alpha.GetSiteSearchEngineRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.SiteSearchEngine> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSiteSearchEngineMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a [TargetSite][google.cloud.discoveryengine.v1alpha.TargetSite].
     * </pre>
     */
    public void createTargetSite(com.google.cloud.discoveryengine.v1alpha.CreateTargetSiteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTargetSiteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates [TargetSite][google.cloud.discoveryengine.v1alpha.TargetSite] in a
     * batch.
     * </pre>
     */
    public void batchCreateTargetSites(com.google.cloud.discoveryengine.v1alpha.BatchCreateTargetSitesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchCreateTargetSitesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a [TargetSite][google.cloud.discoveryengine.v1alpha.TargetSite].
     * </pre>
     */
    public void getTargetSite(com.google.cloud.discoveryengine.v1alpha.GetTargetSiteRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.TargetSite> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTargetSiteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a [TargetSite][google.cloud.discoveryengine.v1alpha.TargetSite].
     * </pre>
     */
    public void updateTargetSite(com.google.cloud.discoveryengine.v1alpha.UpdateTargetSiteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTargetSiteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a [TargetSite][google.cloud.discoveryengine.v1alpha.TargetSite].
     * </pre>
     */
    public void deleteTargetSite(com.google.cloud.discoveryengine.v1alpha.DeleteTargetSiteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTargetSiteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a list of
     * [TargetSite][google.cloud.discoveryengine.v1alpha.TargetSite]s.
     * </pre>
     */
    public void listTargetSites(com.google.cloud.discoveryengine.v1alpha.ListTargetSitesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.ListTargetSitesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTargetSitesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Upgrade from basic site search to advanced site search.
     * </pre>
     */
    public void enableAdvancedSiteSearch(com.google.cloud.discoveryengine.v1alpha.EnableAdvancedSiteSearchRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEnableAdvancedSiteSearchMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Downgrade from advanced site search to basic site search.
     * </pre>
     */
    public void disableAdvancedSiteSearch(com.google.cloud.discoveryengine.v1alpha.DisableAdvancedSiteSearchRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDisableAdvancedSiteSearchMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Request on-demand recrawl for a list of URIs.
     * </pre>
     */
    public void recrawlUris(com.google.cloud.discoveryengine.v1alpha.RecrawlUrisRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRecrawlUrisMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Verify target sites' ownership and validity.
     * This API sends all the target sites under site search engine for
     * verification.
     * </pre>
     */
    public void batchVerifyTargetSites(com.google.cloud.discoveryengine.v1alpha.BatchVerifyTargetSitesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchVerifyTargetSitesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns list of target sites with its domain verification status.
     * This method can only be called under data store with BASIC_SITE_SEARCH
     * state at the moment.
     * </pre>
     */
    public void fetchDomainVerificationStatus(com.google.cloud.discoveryengine.v1alpha.FetchDomainVerificationStatusRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.FetchDomainVerificationStatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchDomainVerificationStatusMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SiteSearchEngineService.
   * <pre>
   * Service for managing site search related resources.
   * </pre>
   */
  public static final class SiteSearchEngineServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SiteSearchEngineServiceBlockingStub> {
    private SiteSearchEngineServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SiteSearchEngineServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SiteSearchEngineServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Gets the
     * [SiteSearchEngine][google.cloud.discoveryengine.v1alpha.SiteSearchEngine].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1alpha.SiteSearchEngine getSiteSearchEngine(com.google.cloud.discoveryengine.v1alpha.GetSiteSearchEngineRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSiteSearchEngineMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a [TargetSite][google.cloud.discoveryengine.v1alpha.TargetSite].
     * </pre>
     */
    public com.google.longrunning.Operation createTargetSite(com.google.cloud.discoveryengine.v1alpha.CreateTargetSiteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTargetSiteMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates [TargetSite][google.cloud.discoveryengine.v1alpha.TargetSite] in a
     * batch.
     * </pre>
     */
    public com.google.longrunning.Operation batchCreateTargetSites(com.google.cloud.discoveryengine.v1alpha.BatchCreateTargetSitesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchCreateTargetSitesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a [TargetSite][google.cloud.discoveryengine.v1alpha.TargetSite].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1alpha.TargetSite getTargetSite(com.google.cloud.discoveryengine.v1alpha.GetTargetSiteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTargetSiteMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a [TargetSite][google.cloud.discoveryengine.v1alpha.TargetSite].
     * </pre>
     */
    public com.google.longrunning.Operation updateTargetSite(com.google.cloud.discoveryengine.v1alpha.UpdateTargetSiteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTargetSiteMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a [TargetSite][google.cloud.discoveryengine.v1alpha.TargetSite].
     * </pre>
     */
    public com.google.longrunning.Operation deleteTargetSite(com.google.cloud.discoveryengine.v1alpha.DeleteTargetSiteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTargetSiteMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a list of
     * [TargetSite][google.cloud.discoveryengine.v1alpha.TargetSite]s.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1alpha.ListTargetSitesResponse listTargetSites(com.google.cloud.discoveryengine.v1alpha.ListTargetSitesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTargetSitesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Upgrade from basic site search to advanced site search.
     * </pre>
     */
    public com.google.longrunning.Operation enableAdvancedSiteSearch(com.google.cloud.discoveryengine.v1alpha.EnableAdvancedSiteSearchRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEnableAdvancedSiteSearchMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Downgrade from advanced site search to basic site search.
     * </pre>
     */
    public com.google.longrunning.Operation disableAdvancedSiteSearch(com.google.cloud.discoveryengine.v1alpha.DisableAdvancedSiteSearchRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDisableAdvancedSiteSearchMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Request on-demand recrawl for a list of URIs.
     * </pre>
     */
    public com.google.longrunning.Operation recrawlUris(com.google.cloud.discoveryengine.v1alpha.RecrawlUrisRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRecrawlUrisMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Verify target sites' ownership and validity.
     * This API sends all the target sites under site search engine for
     * verification.
     * </pre>
     */
    public com.google.longrunning.Operation batchVerifyTargetSites(com.google.cloud.discoveryengine.v1alpha.BatchVerifyTargetSitesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchVerifyTargetSitesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns list of target sites with its domain verification status.
     * This method can only be called under data store with BASIC_SITE_SEARCH
     * state at the moment.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1alpha.FetchDomainVerificationStatusResponse fetchDomainVerificationStatus(com.google.cloud.discoveryengine.v1alpha.FetchDomainVerificationStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchDomainVerificationStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SiteSearchEngineService.
   * <pre>
   * Service for managing site search related resources.
   * </pre>
   */
  public static final class SiteSearchEngineServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SiteSearchEngineServiceFutureStub> {
    private SiteSearchEngineServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SiteSearchEngineServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SiteSearchEngineServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Gets the
     * [SiteSearchEngine][google.cloud.discoveryengine.v1alpha.SiteSearchEngine].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.discoveryengine.v1alpha.SiteSearchEngine> getSiteSearchEngine(
        com.google.cloud.discoveryengine.v1alpha.GetSiteSearchEngineRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSiteSearchEngineMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a [TargetSite][google.cloud.discoveryengine.v1alpha.TargetSite].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createTargetSite(
        com.google.cloud.discoveryengine.v1alpha.CreateTargetSiteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTargetSiteMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates [TargetSite][google.cloud.discoveryengine.v1alpha.TargetSite] in a
     * batch.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> batchCreateTargetSites(
        com.google.cloud.discoveryengine.v1alpha.BatchCreateTargetSitesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchCreateTargetSitesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a [TargetSite][google.cloud.discoveryengine.v1alpha.TargetSite].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.discoveryengine.v1alpha.TargetSite> getTargetSite(
        com.google.cloud.discoveryengine.v1alpha.GetTargetSiteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTargetSiteMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a [TargetSite][google.cloud.discoveryengine.v1alpha.TargetSite].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateTargetSite(
        com.google.cloud.discoveryengine.v1alpha.UpdateTargetSiteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTargetSiteMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a [TargetSite][google.cloud.discoveryengine.v1alpha.TargetSite].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteTargetSite(
        com.google.cloud.discoveryengine.v1alpha.DeleteTargetSiteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTargetSiteMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a list of
     * [TargetSite][google.cloud.discoveryengine.v1alpha.TargetSite]s.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.discoveryengine.v1alpha.ListTargetSitesResponse> listTargetSites(
        com.google.cloud.discoveryengine.v1alpha.ListTargetSitesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTargetSitesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Upgrade from basic site search to advanced site search.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> enableAdvancedSiteSearch(
        com.google.cloud.discoveryengine.v1alpha.EnableAdvancedSiteSearchRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEnableAdvancedSiteSearchMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Downgrade from advanced site search to basic site search.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> disableAdvancedSiteSearch(
        com.google.cloud.discoveryengine.v1alpha.DisableAdvancedSiteSearchRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDisableAdvancedSiteSearchMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Request on-demand recrawl for a list of URIs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> recrawlUris(
        com.google.cloud.discoveryengine.v1alpha.RecrawlUrisRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRecrawlUrisMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Verify target sites' ownership and validity.
     * This API sends all the target sites under site search engine for
     * verification.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> batchVerifyTargetSites(
        com.google.cloud.discoveryengine.v1alpha.BatchVerifyTargetSitesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchVerifyTargetSitesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns list of target sites with its domain verification status.
     * This method can only be called under data store with BASIC_SITE_SEARCH
     * state at the moment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.discoveryengine.v1alpha.FetchDomainVerificationStatusResponse> fetchDomainVerificationStatus(
        com.google.cloud.discoveryengine.v1alpha.FetchDomainVerificationStatusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchDomainVerificationStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_SITE_SEARCH_ENGINE = 0;
  private static final int METHODID_CREATE_TARGET_SITE = 1;
  private static final int METHODID_BATCH_CREATE_TARGET_SITES = 2;
  private static final int METHODID_GET_TARGET_SITE = 3;
  private static final int METHODID_UPDATE_TARGET_SITE = 4;
  private static final int METHODID_DELETE_TARGET_SITE = 5;
  private static final int METHODID_LIST_TARGET_SITES = 6;
  private static final int METHODID_ENABLE_ADVANCED_SITE_SEARCH = 7;
  private static final int METHODID_DISABLE_ADVANCED_SITE_SEARCH = 8;
  private static final int METHODID_RECRAWL_URIS = 9;
  private static final int METHODID_BATCH_VERIFY_TARGET_SITES = 10;
  private static final int METHODID_FETCH_DOMAIN_VERIFICATION_STATUS = 11;

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
        case METHODID_GET_SITE_SEARCH_ENGINE:
          serviceImpl.getSiteSearchEngine((com.google.cloud.discoveryengine.v1alpha.GetSiteSearchEngineRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.SiteSearchEngine>) responseObserver);
          break;
        case METHODID_CREATE_TARGET_SITE:
          serviceImpl.createTargetSite((com.google.cloud.discoveryengine.v1alpha.CreateTargetSiteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_BATCH_CREATE_TARGET_SITES:
          serviceImpl.batchCreateTargetSites((com.google.cloud.discoveryengine.v1alpha.BatchCreateTargetSitesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_TARGET_SITE:
          serviceImpl.getTargetSite((com.google.cloud.discoveryengine.v1alpha.GetTargetSiteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.TargetSite>) responseObserver);
          break;
        case METHODID_UPDATE_TARGET_SITE:
          serviceImpl.updateTargetSite((com.google.cloud.discoveryengine.v1alpha.UpdateTargetSiteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_TARGET_SITE:
          serviceImpl.deleteTargetSite((com.google.cloud.discoveryengine.v1alpha.DeleteTargetSiteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_TARGET_SITES:
          serviceImpl.listTargetSites((com.google.cloud.discoveryengine.v1alpha.ListTargetSitesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.ListTargetSitesResponse>) responseObserver);
          break;
        case METHODID_ENABLE_ADVANCED_SITE_SEARCH:
          serviceImpl.enableAdvancedSiteSearch((com.google.cloud.discoveryengine.v1alpha.EnableAdvancedSiteSearchRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DISABLE_ADVANCED_SITE_SEARCH:
          serviceImpl.disableAdvancedSiteSearch((com.google.cloud.discoveryengine.v1alpha.DisableAdvancedSiteSearchRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RECRAWL_URIS:
          serviceImpl.recrawlUris((com.google.cloud.discoveryengine.v1alpha.RecrawlUrisRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_BATCH_VERIFY_TARGET_SITES:
          serviceImpl.batchVerifyTargetSites((com.google.cloud.discoveryengine.v1alpha.BatchVerifyTargetSitesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_FETCH_DOMAIN_VERIFICATION_STATUS:
          serviceImpl.fetchDomainVerificationStatus((com.google.cloud.discoveryengine.v1alpha.FetchDomainVerificationStatusRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.FetchDomainVerificationStatusResponse>) responseObserver);
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
          getGetSiteSearchEngineMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.discoveryengine.v1alpha.GetSiteSearchEngineRequest,
              com.google.cloud.discoveryengine.v1alpha.SiteSearchEngine>(
                service, METHODID_GET_SITE_SEARCH_ENGINE)))
        .addMethod(
          getCreateTargetSiteMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.discoveryengine.v1alpha.CreateTargetSiteRequest,
              com.google.longrunning.Operation>(
                service, METHODID_CREATE_TARGET_SITE)))
        .addMethod(
          getBatchCreateTargetSitesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.discoveryengine.v1alpha.BatchCreateTargetSitesRequest,
              com.google.longrunning.Operation>(
                service, METHODID_BATCH_CREATE_TARGET_SITES)))
        .addMethod(
          getGetTargetSiteMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.discoveryengine.v1alpha.GetTargetSiteRequest,
              com.google.cloud.discoveryengine.v1alpha.TargetSite>(
                service, METHODID_GET_TARGET_SITE)))
        .addMethod(
          getUpdateTargetSiteMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.discoveryengine.v1alpha.UpdateTargetSiteRequest,
              com.google.longrunning.Operation>(
                service, METHODID_UPDATE_TARGET_SITE)))
        .addMethod(
          getDeleteTargetSiteMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.discoveryengine.v1alpha.DeleteTargetSiteRequest,
              com.google.longrunning.Operation>(
                service, METHODID_DELETE_TARGET_SITE)))
        .addMethod(
          getListTargetSitesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.discoveryengine.v1alpha.ListTargetSitesRequest,
              com.google.cloud.discoveryengine.v1alpha.ListTargetSitesResponse>(
                service, METHODID_LIST_TARGET_SITES)))
        .addMethod(
          getEnableAdvancedSiteSearchMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.discoveryengine.v1alpha.EnableAdvancedSiteSearchRequest,
              com.google.longrunning.Operation>(
                service, METHODID_ENABLE_ADVANCED_SITE_SEARCH)))
        .addMethod(
          getDisableAdvancedSiteSearchMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.discoveryengine.v1alpha.DisableAdvancedSiteSearchRequest,
              com.google.longrunning.Operation>(
                service, METHODID_DISABLE_ADVANCED_SITE_SEARCH)))
        .addMethod(
          getRecrawlUrisMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.discoveryengine.v1alpha.RecrawlUrisRequest,
              com.google.longrunning.Operation>(
                service, METHODID_RECRAWL_URIS)))
        .addMethod(
          getBatchVerifyTargetSitesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.discoveryengine.v1alpha.BatchVerifyTargetSitesRequest,
              com.google.longrunning.Operation>(
                service, METHODID_BATCH_VERIFY_TARGET_SITES)))
        .addMethod(
          getFetchDomainVerificationStatusMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.discoveryengine.v1alpha.FetchDomainVerificationStatusRequest,
              com.google.cloud.discoveryengine.v1alpha.FetchDomainVerificationStatusResponse>(
                service, METHODID_FETCH_DOMAIN_VERIFICATION_STATUS)))
        .build();
  }

  private static abstract class SiteSearchEngineServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SiteSearchEngineServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.discoveryengine.v1alpha.SiteSearchEngineServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SiteSearchEngineService");
    }
  }

  private static final class SiteSearchEngineServiceFileDescriptorSupplier
      extends SiteSearchEngineServiceBaseDescriptorSupplier {
    SiteSearchEngineServiceFileDescriptorSupplier() {}
  }

  private static final class SiteSearchEngineServiceMethodDescriptorSupplier
      extends SiteSearchEngineServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SiteSearchEngineServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SiteSearchEngineServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SiteSearchEngineServiceFileDescriptorSupplier())
              .addMethod(getGetSiteSearchEngineMethod())
              .addMethod(getCreateTargetSiteMethod())
              .addMethod(getBatchCreateTargetSitesMethod())
              .addMethod(getGetTargetSiteMethod())
              .addMethod(getUpdateTargetSiteMethod())
              .addMethod(getDeleteTargetSiteMethod())
              .addMethod(getListTargetSitesMethod())
              .addMethod(getEnableAdvancedSiteSearchMethod())
              .addMethod(getDisableAdvancedSiteSearchMethod())
              .addMethod(getRecrawlUrisMethod())
              .addMethod(getBatchVerifyTargetSitesMethod())
              .addMethod(getFetchDomainVerificationStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
