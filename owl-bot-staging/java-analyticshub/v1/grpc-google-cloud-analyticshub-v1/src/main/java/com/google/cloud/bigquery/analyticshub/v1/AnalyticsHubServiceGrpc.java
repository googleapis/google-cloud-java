package com.google.cloud.bigquery.analyticshub.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * The `AnalyticsHubService` API facilitates data sharing within and across
 * organizations. It allows data providers to publish listings that reference
 * shared datasets. With Analytics Hub, users can discover and search for
 * listings that they have access to. Subscribers can view and subscribe to
 * listings. When you subscribe to a listing, Analytics Hub creates a linked
 * dataset in your project.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/bigquery/analyticshub/v1/analyticshub.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AnalyticsHubServiceGrpc {

  private AnalyticsHubServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.bigquery.analyticshub.v1.AnalyticsHubService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesRequest,
      com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesResponse> getListDataExchangesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDataExchanges",
      requestType = com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesRequest.class,
      responseType = com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesRequest,
      com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesResponse> getListDataExchangesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesRequest, com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesResponse> getListDataExchangesMethod;
    if ((getListDataExchangesMethod = AnalyticsHubServiceGrpc.getListDataExchangesMethod) == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getListDataExchangesMethod = AnalyticsHubServiceGrpc.getListDataExchangesMethod) == null) {
          AnalyticsHubServiceGrpc.getListDataExchangesMethod = getListDataExchangesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesRequest, com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDataExchanges"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AnalyticsHubServiceMethodDescriptorSupplier("ListDataExchanges"))
              .build();
        }
      }
    }
    return getListDataExchangesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesRequest,
      com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesResponse> getListOrgDataExchangesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListOrgDataExchanges",
      requestType = com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesRequest.class,
      responseType = com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesRequest,
      com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesResponse> getListOrgDataExchangesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesRequest, com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesResponse> getListOrgDataExchangesMethod;
    if ((getListOrgDataExchangesMethod = AnalyticsHubServiceGrpc.getListOrgDataExchangesMethod) == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getListOrgDataExchangesMethod = AnalyticsHubServiceGrpc.getListOrgDataExchangesMethod) == null) {
          AnalyticsHubServiceGrpc.getListOrgDataExchangesMethod = getListOrgDataExchangesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesRequest, com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListOrgDataExchanges"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AnalyticsHubServiceMethodDescriptorSupplier("ListOrgDataExchanges"))
              .build();
        }
      }
    }
    return getListOrgDataExchangesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.analyticshub.v1.GetDataExchangeRequest,
      com.google.cloud.bigquery.analyticshub.v1.DataExchange> getGetDataExchangeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataExchange",
      requestType = com.google.cloud.bigquery.analyticshub.v1.GetDataExchangeRequest.class,
      responseType = com.google.cloud.bigquery.analyticshub.v1.DataExchange.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.analyticshub.v1.GetDataExchangeRequest,
      com.google.cloud.bigquery.analyticshub.v1.DataExchange> getGetDataExchangeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.analyticshub.v1.GetDataExchangeRequest, com.google.cloud.bigquery.analyticshub.v1.DataExchange> getGetDataExchangeMethod;
    if ((getGetDataExchangeMethod = AnalyticsHubServiceGrpc.getGetDataExchangeMethod) == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getGetDataExchangeMethod = AnalyticsHubServiceGrpc.getGetDataExchangeMethod) == null) {
          AnalyticsHubServiceGrpc.getGetDataExchangeMethod = getGetDataExchangeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.analyticshub.v1.GetDataExchangeRequest, com.google.cloud.bigquery.analyticshub.v1.DataExchange>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDataExchange"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.analyticshub.v1.GetDataExchangeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.analyticshub.v1.DataExchange.getDefaultInstance()))
              .setSchemaDescriptor(new AnalyticsHubServiceMethodDescriptorSupplier("GetDataExchange"))
              .build();
        }
      }
    }
    return getGetDataExchangeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.analyticshub.v1.CreateDataExchangeRequest,
      com.google.cloud.bigquery.analyticshub.v1.DataExchange> getCreateDataExchangeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDataExchange",
      requestType = com.google.cloud.bigquery.analyticshub.v1.CreateDataExchangeRequest.class,
      responseType = com.google.cloud.bigquery.analyticshub.v1.DataExchange.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.analyticshub.v1.CreateDataExchangeRequest,
      com.google.cloud.bigquery.analyticshub.v1.DataExchange> getCreateDataExchangeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.analyticshub.v1.CreateDataExchangeRequest, com.google.cloud.bigquery.analyticshub.v1.DataExchange> getCreateDataExchangeMethod;
    if ((getCreateDataExchangeMethod = AnalyticsHubServiceGrpc.getCreateDataExchangeMethod) == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getCreateDataExchangeMethod = AnalyticsHubServiceGrpc.getCreateDataExchangeMethod) == null) {
          AnalyticsHubServiceGrpc.getCreateDataExchangeMethod = getCreateDataExchangeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.analyticshub.v1.CreateDataExchangeRequest, com.google.cloud.bigquery.analyticshub.v1.DataExchange>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDataExchange"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.analyticshub.v1.CreateDataExchangeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.analyticshub.v1.DataExchange.getDefaultInstance()))
              .setSchemaDescriptor(new AnalyticsHubServiceMethodDescriptorSupplier("CreateDataExchange"))
              .build();
        }
      }
    }
    return getCreateDataExchangeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.analyticshub.v1.UpdateDataExchangeRequest,
      com.google.cloud.bigquery.analyticshub.v1.DataExchange> getUpdateDataExchangeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDataExchange",
      requestType = com.google.cloud.bigquery.analyticshub.v1.UpdateDataExchangeRequest.class,
      responseType = com.google.cloud.bigquery.analyticshub.v1.DataExchange.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.analyticshub.v1.UpdateDataExchangeRequest,
      com.google.cloud.bigquery.analyticshub.v1.DataExchange> getUpdateDataExchangeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.analyticshub.v1.UpdateDataExchangeRequest, com.google.cloud.bigquery.analyticshub.v1.DataExchange> getUpdateDataExchangeMethod;
    if ((getUpdateDataExchangeMethod = AnalyticsHubServiceGrpc.getUpdateDataExchangeMethod) == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getUpdateDataExchangeMethod = AnalyticsHubServiceGrpc.getUpdateDataExchangeMethod) == null) {
          AnalyticsHubServiceGrpc.getUpdateDataExchangeMethod = getUpdateDataExchangeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.analyticshub.v1.UpdateDataExchangeRequest, com.google.cloud.bigquery.analyticshub.v1.DataExchange>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDataExchange"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.analyticshub.v1.UpdateDataExchangeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.analyticshub.v1.DataExchange.getDefaultInstance()))
              .setSchemaDescriptor(new AnalyticsHubServiceMethodDescriptorSupplier("UpdateDataExchange"))
              .build();
        }
      }
    }
    return getUpdateDataExchangeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.analyticshub.v1.DeleteDataExchangeRequest,
      com.google.protobuf.Empty> getDeleteDataExchangeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDataExchange",
      requestType = com.google.cloud.bigquery.analyticshub.v1.DeleteDataExchangeRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.analyticshub.v1.DeleteDataExchangeRequest,
      com.google.protobuf.Empty> getDeleteDataExchangeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.analyticshub.v1.DeleteDataExchangeRequest, com.google.protobuf.Empty> getDeleteDataExchangeMethod;
    if ((getDeleteDataExchangeMethod = AnalyticsHubServiceGrpc.getDeleteDataExchangeMethod) == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getDeleteDataExchangeMethod = AnalyticsHubServiceGrpc.getDeleteDataExchangeMethod) == null) {
          AnalyticsHubServiceGrpc.getDeleteDataExchangeMethod = getDeleteDataExchangeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.analyticshub.v1.DeleteDataExchangeRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDataExchange"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.analyticshub.v1.DeleteDataExchangeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new AnalyticsHubServiceMethodDescriptorSupplier("DeleteDataExchange"))
              .build();
        }
      }
    }
    return getDeleteDataExchangeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.analyticshub.v1.ListListingsRequest,
      com.google.cloud.bigquery.analyticshub.v1.ListListingsResponse> getListListingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListListings",
      requestType = com.google.cloud.bigquery.analyticshub.v1.ListListingsRequest.class,
      responseType = com.google.cloud.bigquery.analyticshub.v1.ListListingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.analyticshub.v1.ListListingsRequest,
      com.google.cloud.bigquery.analyticshub.v1.ListListingsResponse> getListListingsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.analyticshub.v1.ListListingsRequest, com.google.cloud.bigquery.analyticshub.v1.ListListingsResponse> getListListingsMethod;
    if ((getListListingsMethod = AnalyticsHubServiceGrpc.getListListingsMethod) == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getListListingsMethod = AnalyticsHubServiceGrpc.getListListingsMethod) == null) {
          AnalyticsHubServiceGrpc.getListListingsMethod = getListListingsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.analyticshub.v1.ListListingsRequest, com.google.cloud.bigquery.analyticshub.v1.ListListingsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListListings"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.analyticshub.v1.ListListingsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.analyticshub.v1.ListListingsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AnalyticsHubServiceMethodDescriptorSupplier("ListListings"))
              .build();
        }
      }
    }
    return getListListingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.analyticshub.v1.GetListingRequest,
      com.google.cloud.bigquery.analyticshub.v1.Listing> getGetListingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetListing",
      requestType = com.google.cloud.bigquery.analyticshub.v1.GetListingRequest.class,
      responseType = com.google.cloud.bigquery.analyticshub.v1.Listing.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.analyticshub.v1.GetListingRequest,
      com.google.cloud.bigquery.analyticshub.v1.Listing> getGetListingMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.analyticshub.v1.GetListingRequest, com.google.cloud.bigquery.analyticshub.v1.Listing> getGetListingMethod;
    if ((getGetListingMethod = AnalyticsHubServiceGrpc.getGetListingMethod) == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getGetListingMethod = AnalyticsHubServiceGrpc.getGetListingMethod) == null) {
          AnalyticsHubServiceGrpc.getGetListingMethod = getGetListingMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.analyticshub.v1.GetListingRequest, com.google.cloud.bigquery.analyticshub.v1.Listing>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetListing"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.analyticshub.v1.GetListingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.analyticshub.v1.Listing.getDefaultInstance()))
              .setSchemaDescriptor(new AnalyticsHubServiceMethodDescriptorSupplier("GetListing"))
              .build();
        }
      }
    }
    return getGetListingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.analyticshub.v1.CreateListingRequest,
      com.google.cloud.bigquery.analyticshub.v1.Listing> getCreateListingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateListing",
      requestType = com.google.cloud.bigquery.analyticshub.v1.CreateListingRequest.class,
      responseType = com.google.cloud.bigquery.analyticshub.v1.Listing.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.analyticshub.v1.CreateListingRequest,
      com.google.cloud.bigquery.analyticshub.v1.Listing> getCreateListingMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.analyticshub.v1.CreateListingRequest, com.google.cloud.bigquery.analyticshub.v1.Listing> getCreateListingMethod;
    if ((getCreateListingMethod = AnalyticsHubServiceGrpc.getCreateListingMethod) == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getCreateListingMethod = AnalyticsHubServiceGrpc.getCreateListingMethod) == null) {
          AnalyticsHubServiceGrpc.getCreateListingMethod = getCreateListingMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.analyticshub.v1.CreateListingRequest, com.google.cloud.bigquery.analyticshub.v1.Listing>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateListing"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.analyticshub.v1.CreateListingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.analyticshub.v1.Listing.getDefaultInstance()))
              .setSchemaDescriptor(new AnalyticsHubServiceMethodDescriptorSupplier("CreateListing"))
              .build();
        }
      }
    }
    return getCreateListingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.analyticshub.v1.UpdateListingRequest,
      com.google.cloud.bigquery.analyticshub.v1.Listing> getUpdateListingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateListing",
      requestType = com.google.cloud.bigquery.analyticshub.v1.UpdateListingRequest.class,
      responseType = com.google.cloud.bigquery.analyticshub.v1.Listing.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.analyticshub.v1.UpdateListingRequest,
      com.google.cloud.bigquery.analyticshub.v1.Listing> getUpdateListingMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.analyticshub.v1.UpdateListingRequest, com.google.cloud.bigquery.analyticshub.v1.Listing> getUpdateListingMethod;
    if ((getUpdateListingMethod = AnalyticsHubServiceGrpc.getUpdateListingMethod) == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getUpdateListingMethod = AnalyticsHubServiceGrpc.getUpdateListingMethod) == null) {
          AnalyticsHubServiceGrpc.getUpdateListingMethod = getUpdateListingMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.analyticshub.v1.UpdateListingRequest, com.google.cloud.bigquery.analyticshub.v1.Listing>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateListing"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.analyticshub.v1.UpdateListingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.analyticshub.v1.Listing.getDefaultInstance()))
              .setSchemaDescriptor(new AnalyticsHubServiceMethodDescriptorSupplier("UpdateListing"))
              .build();
        }
      }
    }
    return getUpdateListingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.analyticshub.v1.DeleteListingRequest,
      com.google.protobuf.Empty> getDeleteListingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteListing",
      requestType = com.google.cloud.bigquery.analyticshub.v1.DeleteListingRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.analyticshub.v1.DeleteListingRequest,
      com.google.protobuf.Empty> getDeleteListingMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.analyticshub.v1.DeleteListingRequest, com.google.protobuf.Empty> getDeleteListingMethod;
    if ((getDeleteListingMethod = AnalyticsHubServiceGrpc.getDeleteListingMethod) == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getDeleteListingMethod = AnalyticsHubServiceGrpc.getDeleteListingMethod) == null) {
          AnalyticsHubServiceGrpc.getDeleteListingMethod = getDeleteListingMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.analyticshub.v1.DeleteListingRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteListing"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.analyticshub.v1.DeleteListingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new AnalyticsHubServiceMethodDescriptorSupplier("DeleteListing"))
              .build();
        }
      }
    }
    return getDeleteListingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.bigquery.analyticshub.v1.SubscribeListingRequest,
      com.google.cloud.bigquery.analyticshub.v1.SubscribeListingResponse> getSubscribeListingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SubscribeListing",
      requestType = com.google.cloud.bigquery.analyticshub.v1.SubscribeListingRequest.class,
      responseType = com.google.cloud.bigquery.analyticshub.v1.SubscribeListingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.bigquery.analyticshub.v1.SubscribeListingRequest,
      com.google.cloud.bigquery.analyticshub.v1.SubscribeListingResponse> getSubscribeListingMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.bigquery.analyticshub.v1.SubscribeListingRequest, com.google.cloud.bigquery.analyticshub.v1.SubscribeListingResponse> getSubscribeListingMethod;
    if ((getSubscribeListingMethod = AnalyticsHubServiceGrpc.getSubscribeListingMethod) == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getSubscribeListingMethod = AnalyticsHubServiceGrpc.getSubscribeListingMethod) == null) {
          AnalyticsHubServiceGrpc.getSubscribeListingMethod = getSubscribeListingMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.bigquery.analyticshub.v1.SubscribeListingRequest, com.google.cloud.bigquery.analyticshub.v1.SubscribeListingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SubscribeListing"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.analyticshub.v1.SubscribeListingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.bigquery.analyticshub.v1.SubscribeListingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AnalyticsHubServiceMethodDescriptorSupplier("SubscribeListing"))
              .build();
        }
      }
    }
    return getSubscribeListingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest,
      com.google.iam.v1.Policy> getGetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIamPolicy",
      requestType = com.google.iam.v1.GetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest,
      com.google.iam.v1.Policy> getGetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy> getGetIamPolicyMethod;
    if ((getGetIamPolicyMethod = AnalyticsHubServiceGrpc.getGetIamPolicyMethod) == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getGetIamPolicyMethod = AnalyticsHubServiceGrpc.getGetIamPolicyMethod) == null) {
          AnalyticsHubServiceGrpc.getGetIamPolicyMethod = getGetIamPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIamPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.GetIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.Policy.getDefaultInstance()))
              .setSchemaDescriptor(new AnalyticsHubServiceMethodDescriptorSupplier("GetIamPolicy"))
              .build();
        }
      }
    }
    return getGetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest,
      com.google.iam.v1.Policy> getSetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetIamPolicy",
      requestType = com.google.iam.v1.SetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest,
      com.google.iam.v1.Policy> getSetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy> getSetIamPolicyMethod;
    if ((getSetIamPolicyMethod = AnalyticsHubServiceGrpc.getSetIamPolicyMethod) == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getSetIamPolicyMethod = AnalyticsHubServiceGrpc.getSetIamPolicyMethod) == null) {
          AnalyticsHubServiceGrpc.getSetIamPolicyMethod = getSetIamPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetIamPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.SetIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.Policy.getDefaultInstance()))
              .setSchemaDescriptor(new AnalyticsHubServiceMethodDescriptorSupplier("SetIamPolicy"))
              .build();
        }
      }
    }
    return getSetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest,
      com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TestIamPermissions",
      requestType = com.google.iam.v1.TestIamPermissionsRequest.class,
      responseType = com.google.iam.v1.TestIamPermissionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest,
      com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethod;
    if ((getTestIamPermissionsMethod = AnalyticsHubServiceGrpc.getTestIamPermissionsMethod) == null) {
      synchronized (AnalyticsHubServiceGrpc.class) {
        if ((getTestIamPermissionsMethod = AnalyticsHubServiceGrpc.getTestIamPermissionsMethod) == null) {
          AnalyticsHubServiceGrpc.getTestIamPermissionsMethod = getTestIamPermissionsMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TestIamPermissions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.TestIamPermissionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AnalyticsHubServiceMethodDescriptorSupplier("TestIamPermissions"))
              .build();
        }
      }
    }
    return getTestIamPermissionsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AnalyticsHubServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AnalyticsHubServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AnalyticsHubServiceStub>() {
        @java.lang.Override
        public AnalyticsHubServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AnalyticsHubServiceStub(channel, callOptions);
        }
      };
    return AnalyticsHubServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AnalyticsHubServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AnalyticsHubServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AnalyticsHubServiceBlockingStub>() {
        @java.lang.Override
        public AnalyticsHubServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AnalyticsHubServiceBlockingStub(channel, callOptions);
        }
      };
    return AnalyticsHubServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AnalyticsHubServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AnalyticsHubServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AnalyticsHubServiceFutureStub>() {
        @java.lang.Override
        public AnalyticsHubServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AnalyticsHubServiceFutureStub(channel, callOptions);
        }
      };
    return AnalyticsHubServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The `AnalyticsHubService` API facilitates data sharing within and across
   * organizations. It allows data providers to publish listings that reference
   * shared datasets. With Analytics Hub, users can discover and search for
   * listings that they have access to. Subscribers can view and subscribe to
   * listings. When you subscribe to a listing, Analytics Hub creates a linked
   * dataset in your project.
   * </pre>
   */
  public static abstract class AnalyticsHubServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists all data exchanges in a given project and location.
     * </pre>
     */
    public void listDataExchanges(com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListDataExchangesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists all data exchanges from projects in a given organization and
     * location.
     * </pre>
     */
    public void listOrgDataExchanges(com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListOrgDataExchangesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the details of a data exchange.
     * </pre>
     */
    public void getDataExchange(com.google.cloud.bigquery.analyticshub.v1.GetDataExchangeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.DataExchange> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetDataExchangeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new data exchange.
     * </pre>
     */
    public void createDataExchange(com.google.cloud.bigquery.analyticshub.v1.CreateDataExchangeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.DataExchange> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateDataExchangeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates an existing data exchange.
     * </pre>
     */
    public void updateDataExchange(com.google.cloud.bigquery.analyticshub.v1.UpdateDataExchangeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.DataExchange> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateDataExchangeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes an existing data exchange.
     * </pre>
     */
    public void deleteDataExchange(com.google.cloud.bigquery.analyticshub.v1.DeleteDataExchangeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteDataExchangeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists all listings in a given project and location.
     * </pre>
     */
    public void listListings(com.google.cloud.bigquery.analyticshub.v1.ListListingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.ListListingsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListListingsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the details of a listing.
     * </pre>
     */
    public void getListing(com.google.cloud.bigquery.analyticshub.v1.GetListingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.Listing> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetListingMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new listing.
     * </pre>
     */
    public void createListing(com.google.cloud.bigquery.analyticshub.v1.CreateListingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.Listing> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateListingMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates an existing listing.
     * </pre>
     */
    public void updateListing(com.google.cloud.bigquery.analyticshub.v1.UpdateListingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.Listing> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateListingMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a listing.
     * </pre>
     */
    public void deleteListing(com.google.cloud.bigquery.analyticshub.v1.DeleteListingRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteListingMethod(), responseObserver);
    }

    /**
     * <pre>
     * Subscribes to a listing.
     * Currently, with Analytics Hub, you can create listings that
     * reference only BigQuery datasets.
     * Upon subscription to a listing for a BigQuery dataset, Analytics Hub
     * creates a linked dataset in the subscriber's project.
     * </pre>
     */
    public void subscribeListing(com.google.cloud.bigquery.analyticshub.v1.SubscribeListingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.SubscribeListingResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSubscribeListingMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the IAM policy.
     * </pre>
     */
    public void getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetIamPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Sets the IAM policy.
     * </pre>
     */
    public void setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetIamPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns the permissions that a caller has.
     * </pre>
     */
    public void testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTestIamPermissionsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListDataExchangesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesRequest,
                com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesResponse>(
                  this, METHODID_LIST_DATA_EXCHANGES)))
          .addMethod(
            getListOrgDataExchangesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesRequest,
                com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesResponse>(
                  this, METHODID_LIST_ORG_DATA_EXCHANGES)))
          .addMethod(
            getGetDataExchangeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.analyticshub.v1.GetDataExchangeRequest,
                com.google.cloud.bigquery.analyticshub.v1.DataExchange>(
                  this, METHODID_GET_DATA_EXCHANGE)))
          .addMethod(
            getCreateDataExchangeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.analyticshub.v1.CreateDataExchangeRequest,
                com.google.cloud.bigquery.analyticshub.v1.DataExchange>(
                  this, METHODID_CREATE_DATA_EXCHANGE)))
          .addMethod(
            getUpdateDataExchangeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.analyticshub.v1.UpdateDataExchangeRequest,
                com.google.cloud.bigquery.analyticshub.v1.DataExchange>(
                  this, METHODID_UPDATE_DATA_EXCHANGE)))
          .addMethod(
            getDeleteDataExchangeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.analyticshub.v1.DeleteDataExchangeRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_DATA_EXCHANGE)))
          .addMethod(
            getListListingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.analyticshub.v1.ListListingsRequest,
                com.google.cloud.bigquery.analyticshub.v1.ListListingsResponse>(
                  this, METHODID_LIST_LISTINGS)))
          .addMethod(
            getGetListingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.analyticshub.v1.GetListingRequest,
                com.google.cloud.bigquery.analyticshub.v1.Listing>(
                  this, METHODID_GET_LISTING)))
          .addMethod(
            getCreateListingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.analyticshub.v1.CreateListingRequest,
                com.google.cloud.bigquery.analyticshub.v1.Listing>(
                  this, METHODID_CREATE_LISTING)))
          .addMethod(
            getUpdateListingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.analyticshub.v1.UpdateListingRequest,
                com.google.cloud.bigquery.analyticshub.v1.Listing>(
                  this, METHODID_UPDATE_LISTING)))
          .addMethod(
            getDeleteListingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.analyticshub.v1.DeleteListingRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_LISTING)))
          .addMethod(
            getSubscribeListingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.bigquery.analyticshub.v1.SubscribeListingRequest,
                com.google.cloud.bigquery.analyticshub.v1.SubscribeListingResponse>(
                  this, METHODID_SUBSCRIBE_LISTING)))
          .addMethod(
            getGetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.GetIamPolicyRequest,
                com.google.iam.v1.Policy>(
                  this, METHODID_GET_IAM_POLICY)))
          .addMethod(
            getSetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.SetIamPolicyRequest,
                com.google.iam.v1.Policy>(
                  this, METHODID_SET_IAM_POLICY)))
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
   * <pre>
   * The `AnalyticsHubService` API facilitates data sharing within and across
   * organizations. It allows data providers to publish listings that reference
   * shared datasets. With Analytics Hub, users can discover and search for
   * listings that they have access to. Subscribers can view and subscribe to
   * listings. When you subscribe to a listing, Analytics Hub creates a linked
   * dataset in your project.
   * </pre>
   */
  public static final class AnalyticsHubServiceStub extends io.grpc.stub.AbstractAsyncStub<AnalyticsHubServiceStub> {
    private AnalyticsHubServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AnalyticsHubServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AnalyticsHubServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists all data exchanges in a given project and location.
     * </pre>
     */
    public void listDataExchanges(com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDataExchangesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists all data exchanges from projects in a given organization and
     * location.
     * </pre>
     */
    public void listOrgDataExchanges(com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListOrgDataExchangesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the details of a data exchange.
     * </pre>
     */
    public void getDataExchange(com.google.cloud.bigquery.analyticshub.v1.GetDataExchangeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.DataExchange> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDataExchangeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new data exchange.
     * </pre>
     */
    public void createDataExchange(com.google.cloud.bigquery.analyticshub.v1.CreateDataExchangeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.DataExchange> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDataExchangeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates an existing data exchange.
     * </pre>
     */
    public void updateDataExchange(com.google.cloud.bigquery.analyticshub.v1.UpdateDataExchangeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.DataExchange> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDataExchangeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes an existing data exchange.
     * </pre>
     */
    public void deleteDataExchange(com.google.cloud.bigquery.analyticshub.v1.DeleteDataExchangeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDataExchangeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists all listings in a given project and location.
     * </pre>
     */
    public void listListings(com.google.cloud.bigquery.analyticshub.v1.ListListingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.ListListingsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListListingsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the details of a listing.
     * </pre>
     */
    public void getListing(com.google.cloud.bigquery.analyticshub.v1.GetListingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.Listing> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetListingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new listing.
     * </pre>
     */
    public void createListing(com.google.cloud.bigquery.analyticshub.v1.CreateListingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.Listing> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateListingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates an existing listing.
     * </pre>
     */
    public void updateListing(com.google.cloud.bigquery.analyticshub.v1.UpdateListingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.Listing> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateListingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a listing.
     * </pre>
     */
    public void deleteListing(com.google.cloud.bigquery.analyticshub.v1.DeleteListingRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteListingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Subscribes to a listing.
     * Currently, with Analytics Hub, you can create listings that
     * reference only BigQuery datasets.
     * Upon subscription to a listing for a BigQuery dataset, Analytics Hub
     * creates a linked dataset in the subscriber's project.
     * </pre>
     */
    public void subscribeListing(com.google.cloud.bigquery.analyticshub.v1.SubscribeListingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.SubscribeListingResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSubscribeListingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the IAM policy.
     * </pre>
     */
    public void getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Sets the IAM policy.
     * </pre>
     */
    public void setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns the permissions that a caller has.
     * </pre>
     */
    public void testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The `AnalyticsHubService` API facilitates data sharing within and across
   * organizations. It allows data providers to publish listings that reference
   * shared datasets. With Analytics Hub, users can discover and search for
   * listings that they have access to. Subscribers can view and subscribe to
   * listings. When you subscribe to a listing, Analytics Hub creates a linked
   * dataset in your project.
   * </pre>
   */
  public static final class AnalyticsHubServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<AnalyticsHubServiceBlockingStub> {
    private AnalyticsHubServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AnalyticsHubServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AnalyticsHubServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists all data exchanges in a given project and location.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesResponse listDataExchanges(com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDataExchangesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists all data exchanges from projects in a given organization and
     * location.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesResponse listOrgDataExchanges(com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListOrgDataExchangesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the details of a data exchange.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.DataExchange getDataExchange(com.google.cloud.bigquery.analyticshub.v1.GetDataExchangeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDataExchangeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new data exchange.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.DataExchange createDataExchange(com.google.cloud.bigquery.analyticshub.v1.CreateDataExchangeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDataExchangeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates an existing data exchange.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.DataExchange updateDataExchange(com.google.cloud.bigquery.analyticshub.v1.UpdateDataExchangeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDataExchangeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes an existing data exchange.
     * </pre>
     */
    public com.google.protobuf.Empty deleteDataExchange(com.google.cloud.bigquery.analyticshub.v1.DeleteDataExchangeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDataExchangeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists all listings in a given project and location.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.ListListingsResponse listListings(com.google.cloud.bigquery.analyticshub.v1.ListListingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListListingsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the details of a listing.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.Listing getListing(com.google.cloud.bigquery.analyticshub.v1.GetListingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetListingMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new listing.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.Listing createListing(com.google.cloud.bigquery.analyticshub.v1.CreateListingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateListingMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates an existing listing.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.Listing updateListing(com.google.cloud.bigquery.analyticshub.v1.UpdateListingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateListingMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a listing.
     * </pre>
     */
    public com.google.protobuf.Empty deleteListing(com.google.cloud.bigquery.analyticshub.v1.DeleteListingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteListingMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Subscribes to a listing.
     * Currently, with Analytics Hub, you can create listings that
     * reference only BigQuery datasets.
     * Upon subscription to a listing for a BigQuery dataset, Analytics Hub
     * creates a linked dataset in the subscriber's project.
     * </pre>
     */
    public com.google.cloud.bigquery.analyticshub.v1.SubscribeListingResponse subscribeListing(com.google.cloud.bigquery.analyticshub.v1.SubscribeListingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSubscribeListingMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the IAM policy.
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Sets the IAM policy.
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns the permissions that a caller has.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The `AnalyticsHubService` API facilitates data sharing within and across
   * organizations. It allows data providers to publish listings that reference
   * shared datasets. With Analytics Hub, users can discover and search for
   * listings that they have access to. Subscribers can view and subscribe to
   * listings. When you subscribe to a listing, Analytics Hub creates a linked
   * dataset in your project.
   * </pre>
   */
  public static final class AnalyticsHubServiceFutureStub extends io.grpc.stub.AbstractFutureStub<AnalyticsHubServiceFutureStub> {
    private AnalyticsHubServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AnalyticsHubServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AnalyticsHubServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists all data exchanges in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesResponse> listDataExchanges(
        com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDataExchangesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists all data exchanges from projects in a given organization and
     * location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesResponse> listOrgDataExchanges(
        com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListOrgDataExchangesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the details of a data exchange.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.analyticshub.v1.DataExchange> getDataExchange(
        com.google.cloud.bigquery.analyticshub.v1.GetDataExchangeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDataExchangeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new data exchange.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.analyticshub.v1.DataExchange> createDataExchange(
        com.google.cloud.bigquery.analyticshub.v1.CreateDataExchangeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDataExchangeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates an existing data exchange.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.analyticshub.v1.DataExchange> updateDataExchange(
        com.google.cloud.bigquery.analyticshub.v1.UpdateDataExchangeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDataExchangeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes an existing data exchange.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteDataExchange(
        com.google.cloud.bigquery.analyticshub.v1.DeleteDataExchangeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDataExchangeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists all listings in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.analyticshub.v1.ListListingsResponse> listListings(
        com.google.cloud.bigquery.analyticshub.v1.ListListingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListListingsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the details of a listing.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.analyticshub.v1.Listing> getListing(
        com.google.cloud.bigquery.analyticshub.v1.GetListingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetListingMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new listing.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.analyticshub.v1.Listing> createListing(
        com.google.cloud.bigquery.analyticshub.v1.CreateListingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateListingMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates an existing listing.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.analyticshub.v1.Listing> updateListing(
        com.google.cloud.bigquery.analyticshub.v1.UpdateListingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateListingMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a listing.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteListing(
        com.google.cloud.bigquery.analyticshub.v1.DeleteListingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteListingMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Subscribes to a listing.
     * Currently, with Analytics Hub, you can create listings that
     * reference only BigQuery datasets.
     * Upon subscription to a listing for a BigQuery dataset, Analytics Hub
     * creates a linked dataset in the subscriber's project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.bigquery.analyticshub.v1.SubscribeListingResponse> subscribeListing(
        com.google.cloud.bigquery.analyticshub.v1.SubscribeListingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSubscribeListingMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the IAM policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy> getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Sets the IAM policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy> setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns the permissions that a caller has.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.TestIamPermissionsResponse> testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_DATA_EXCHANGES = 0;
  private static final int METHODID_LIST_ORG_DATA_EXCHANGES = 1;
  private static final int METHODID_GET_DATA_EXCHANGE = 2;
  private static final int METHODID_CREATE_DATA_EXCHANGE = 3;
  private static final int METHODID_UPDATE_DATA_EXCHANGE = 4;
  private static final int METHODID_DELETE_DATA_EXCHANGE = 5;
  private static final int METHODID_LIST_LISTINGS = 6;
  private static final int METHODID_GET_LISTING = 7;
  private static final int METHODID_CREATE_LISTING = 8;
  private static final int METHODID_UPDATE_LISTING = 9;
  private static final int METHODID_DELETE_LISTING = 10;
  private static final int METHODID_SUBSCRIBE_LISTING = 11;
  private static final int METHODID_GET_IAM_POLICY = 12;
  private static final int METHODID_SET_IAM_POLICY = 13;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 14;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AnalyticsHubServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AnalyticsHubServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_DATA_EXCHANGES:
          serviceImpl.listDataExchanges((com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesResponse>) responseObserver);
          break;
        case METHODID_LIST_ORG_DATA_EXCHANGES:
          serviceImpl.listOrgDataExchanges((com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesResponse>) responseObserver);
          break;
        case METHODID_GET_DATA_EXCHANGE:
          serviceImpl.getDataExchange((com.google.cloud.bigquery.analyticshub.v1.GetDataExchangeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.DataExchange>) responseObserver);
          break;
        case METHODID_CREATE_DATA_EXCHANGE:
          serviceImpl.createDataExchange((com.google.cloud.bigquery.analyticshub.v1.CreateDataExchangeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.DataExchange>) responseObserver);
          break;
        case METHODID_UPDATE_DATA_EXCHANGE:
          serviceImpl.updateDataExchange((com.google.cloud.bigquery.analyticshub.v1.UpdateDataExchangeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.DataExchange>) responseObserver);
          break;
        case METHODID_DELETE_DATA_EXCHANGE:
          serviceImpl.deleteDataExchange((com.google.cloud.bigquery.analyticshub.v1.DeleteDataExchangeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_LISTINGS:
          serviceImpl.listListings((com.google.cloud.bigquery.analyticshub.v1.ListListingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.ListListingsResponse>) responseObserver);
          break;
        case METHODID_GET_LISTING:
          serviceImpl.getListing((com.google.cloud.bigquery.analyticshub.v1.GetListingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.Listing>) responseObserver);
          break;
        case METHODID_CREATE_LISTING:
          serviceImpl.createListing((com.google.cloud.bigquery.analyticshub.v1.CreateListingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.Listing>) responseObserver);
          break;
        case METHODID_UPDATE_LISTING:
          serviceImpl.updateListing((com.google.cloud.bigquery.analyticshub.v1.UpdateListingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.Listing>) responseObserver);
          break;
        case METHODID_DELETE_LISTING:
          serviceImpl.deleteListing((com.google.cloud.bigquery.analyticshub.v1.DeleteListingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_SUBSCRIBE_LISTING:
          serviceImpl.subscribeListing((com.google.cloud.bigquery.analyticshub.v1.SubscribeListingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.bigquery.analyticshub.v1.SubscribeListingResponse>) responseObserver);
          break;
        case METHODID_GET_IAM_POLICY:
          serviceImpl.getIamPolicy((com.google.iam.v1.GetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_SET_IAM_POLICY:
          serviceImpl.setIamPolicy((com.google.iam.v1.SetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_TEST_IAM_PERMISSIONS:
          serviceImpl.testIamPermissions((com.google.iam.v1.TestIamPermissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>) responseObserver);
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

  private static abstract class AnalyticsHubServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AnalyticsHubServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.bigquery.analyticshub.v1.AnalyticsHubProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AnalyticsHubService");
    }
  }

  private static final class AnalyticsHubServiceFileDescriptorSupplier
      extends AnalyticsHubServiceBaseDescriptorSupplier {
    AnalyticsHubServiceFileDescriptorSupplier() {}
  }

  private static final class AnalyticsHubServiceMethodDescriptorSupplier
      extends AnalyticsHubServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AnalyticsHubServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AnalyticsHubServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AnalyticsHubServiceFileDescriptorSupplier())
              .addMethod(getListDataExchangesMethod())
              .addMethod(getListOrgDataExchangesMethod())
              .addMethod(getGetDataExchangeMethod())
              .addMethod(getCreateDataExchangeMethod())
              .addMethod(getUpdateDataExchangeMethod())
              .addMethod(getDeleteDataExchangeMethod())
              .addMethod(getListListingsMethod())
              .addMethod(getGetListingMethod())
              .addMethod(getCreateListingMethod())
              .addMethod(getUpdateListingMethod())
              .addMethod(getDeleteListingMethod())
              .addMethod(getSubscribeListingMethod())
              .addMethod(getGetIamPolicyMethod())
              .addMethod(getSetIamPolicyMethod())
              .addMethod(getTestIamPermissionsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
