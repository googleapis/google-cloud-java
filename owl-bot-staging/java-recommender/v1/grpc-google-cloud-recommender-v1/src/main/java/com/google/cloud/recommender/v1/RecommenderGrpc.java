package com.google.cloud.recommender.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Provides insights and recommendations for cloud customers for various
 * categories like performance optimization, cost savings, reliability, feature
 * discovery, etc. Insights and recommendations are generated automatically
 * based on analysis of user resources, configuration and monitoring metrics.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/recommender/v1/recommender_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RecommenderGrpc {

  private RecommenderGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.recommender.v1.Recommender";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.recommender.v1.ListInsightsRequest,
      com.google.cloud.recommender.v1.ListInsightsResponse> getListInsightsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListInsights",
      requestType = com.google.cloud.recommender.v1.ListInsightsRequest.class,
      responseType = com.google.cloud.recommender.v1.ListInsightsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.recommender.v1.ListInsightsRequest,
      com.google.cloud.recommender.v1.ListInsightsResponse> getListInsightsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.recommender.v1.ListInsightsRequest, com.google.cloud.recommender.v1.ListInsightsResponse> getListInsightsMethod;
    if ((getListInsightsMethod = RecommenderGrpc.getListInsightsMethod) == null) {
      synchronized (RecommenderGrpc.class) {
        if ((getListInsightsMethod = RecommenderGrpc.getListInsightsMethod) == null) {
          RecommenderGrpc.getListInsightsMethod = getListInsightsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.recommender.v1.ListInsightsRequest, com.google.cloud.recommender.v1.ListInsightsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListInsights"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.recommender.v1.ListInsightsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.recommender.v1.ListInsightsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RecommenderMethodDescriptorSupplier("ListInsights"))
              .build();
        }
      }
    }
    return getListInsightsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.recommender.v1.GetInsightRequest,
      com.google.cloud.recommender.v1.Insight> getGetInsightMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInsight",
      requestType = com.google.cloud.recommender.v1.GetInsightRequest.class,
      responseType = com.google.cloud.recommender.v1.Insight.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.recommender.v1.GetInsightRequest,
      com.google.cloud.recommender.v1.Insight> getGetInsightMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.recommender.v1.GetInsightRequest, com.google.cloud.recommender.v1.Insight> getGetInsightMethod;
    if ((getGetInsightMethod = RecommenderGrpc.getGetInsightMethod) == null) {
      synchronized (RecommenderGrpc.class) {
        if ((getGetInsightMethod = RecommenderGrpc.getGetInsightMethod) == null) {
          RecommenderGrpc.getGetInsightMethod = getGetInsightMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.recommender.v1.GetInsightRequest, com.google.cloud.recommender.v1.Insight>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInsight"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.recommender.v1.GetInsightRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.recommender.v1.Insight.getDefaultInstance()))
              .setSchemaDescriptor(new RecommenderMethodDescriptorSupplier("GetInsight"))
              .build();
        }
      }
    }
    return getGetInsightMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.recommender.v1.MarkInsightAcceptedRequest,
      com.google.cloud.recommender.v1.Insight> getMarkInsightAcceptedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MarkInsightAccepted",
      requestType = com.google.cloud.recommender.v1.MarkInsightAcceptedRequest.class,
      responseType = com.google.cloud.recommender.v1.Insight.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.recommender.v1.MarkInsightAcceptedRequest,
      com.google.cloud.recommender.v1.Insight> getMarkInsightAcceptedMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.recommender.v1.MarkInsightAcceptedRequest, com.google.cloud.recommender.v1.Insight> getMarkInsightAcceptedMethod;
    if ((getMarkInsightAcceptedMethod = RecommenderGrpc.getMarkInsightAcceptedMethod) == null) {
      synchronized (RecommenderGrpc.class) {
        if ((getMarkInsightAcceptedMethod = RecommenderGrpc.getMarkInsightAcceptedMethod) == null) {
          RecommenderGrpc.getMarkInsightAcceptedMethod = getMarkInsightAcceptedMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.recommender.v1.MarkInsightAcceptedRequest, com.google.cloud.recommender.v1.Insight>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MarkInsightAccepted"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.recommender.v1.MarkInsightAcceptedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.recommender.v1.Insight.getDefaultInstance()))
              .setSchemaDescriptor(new RecommenderMethodDescriptorSupplier("MarkInsightAccepted"))
              .build();
        }
      }
    }
    return getMarkInsightAcceptedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.recommender.v1.ListRecommendationsRequest,
      com.google.cloud.recommender.v1.ListRecommendationsResponse> getListRecommendationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRecommendations",
      requestType = com.google.cloud.recommender.v1.ListRecommendationsRequest.class,
      responseType = com.google.cloud.recommender.v1.ListRecommendationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.recommender.v1.ListRecommendationsRequest,
      com.google.cloud.recommender.v1.ListRecommendationsResponse> getListRecommendationsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.recommender.v1.ListRecommendationsRequest, com.google.cloud.recommender.v1.ListRecommendationsResponse> getListRecommendationsMethod;
    if ((getListRecommendationsMethod = RecommenderGrpc.getListRecommendationsMethod) == null) {
      synchronized (RecommenderGrpc.class) {
        if ((getListRecommendationsMethod = RecommenderGrpc.getListRecommendationsMethod) == null) {
          RecommenderGrpc.getListRecommendationsMethod = getListRecommendationsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.recommender.v1.ListRecommendationsRequest, com.google.cloud.recommender.v1.ListRecommendationsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRecommendations"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.recommender.v1.ListRecommendationsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.recommender.v1.ListRecommendationsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RecommenderMethodDescriptorSupplier("ListRecommendations"))
              .build();
        }
      }
    }
    return getListRecommendationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.recommender.v1.GetRecommendationRequest,
      com.google.cloud.recommender.v1.Recommendation> getGetRecommendationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRecommendation",
      requestType = com.google.cloud.recommender.v1.GetRecommendationRequest.class,
      responseType = com.google.cloud.recommender.v1.Recommendation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.recommender.v1.GetRecommendationRequest,
      com.google.cloud.recommender.v1.Recommendation> getGetRecommendationMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.recommender.v1.GetRecommendationRequest, com.google.cloud.recommender.v1.Recommendation> getGetRecommendationMethod;
    if ((getGetRecommendationMethod = RecommenderGrpc.getGetRecommendationMethod) == null) {
      synchronized (RecommenderGrpc.class) {
        if ((getGetRecommendationMethod = RecommenderGrpc.getGetRecommendationMethod) == null) {
          RecommenderGrpc.getGetRecommendationMethod = getGetRecommendationMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.recommender.v1.GetRecommendationRequest, com.google.cloud.recommender.v1.Recommendation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRecommendation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.recommender.v1.GetRecommendationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.recommender.v1.Recommendation.getDefaultInstance()))
              .setSchemaDescriptor(new RecommenderMethodDescriptorSupplier("GetRecommendation"))
              .build();
        }
      }
    }
    return getGetRecommendationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.recommender.v1.MarkRecommendationClaimedRequest,
      com.google.cloud.recommender.v1.Recommendation> getMarkRecommendationClaimedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MarkRecommendationClaimed",
      requestType = com.google.cloud.recommender.v1.MarkRecommendationClaimedRequest.class,
      responseType = com.google.cloud.recommender.v1.Recommendation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.recommender.v1.MarkRecommendationClaimedRequest,
      com.google.cloud.recommender.v1.Recommendation> getMarkRecommendationClaimedMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.recommender.v1.MarkRecommendationClaimedRequest, com.google.cloud.recommender.v1.Recommendation> getMarkRecommendationClaimedMethod;
    if ((getMarkRecommendationClaimedMethod = RecommenderGrpc.getMarkRecommendationClaimedMethod) == null) {
      synchronized (RecommenderGrpc.class) {
        if ((getMarkRecommendationClaimedMethod = RecommenderGrpc.getMarkRecommendationClaimedMethod) == null) {
          RecommenderGrpc.getMarkRecommendationClaimedMethod = getMarkRecommendationClaimedMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.recommender.v1.MarkRecommendationClaimedRequest, com.google.cloud.recommender.v1.Recommendation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MarkRecommendationClaimed"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.recommender.v1.MarkRecommendationClaimedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.recommender.v1.Recommendation.getDefaultInstance()))
              .setSchemaDescriptor(new RecommenderMethodDescriptorSupplier("MarkRecommendationClaimed"))
              .build();
        }
      }
    }
    return getMarkRecommendationClaimedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.recommender.v1.MarkRecommendationSucceededRequest,
      com.google.cloud.recommender.v1.Recommendation> getMarkRecommendationSucceededMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MarkRecommendationSucceeded",
      requestType = com.google.cloud.recommender.v1.MarkRecommendationSucceededRequest.class,
      responseType = com.google.cloud.recommender.v1.Recommendation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.recommender.v1.MarkRecommendationSucceededRequest,
      com.google.cloud.recommender.v1.Recommendation> getMarkRecommendationSucceededMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.recommender.v1.MarkRecommendationSucceededRequest, com.google.cloud.recommender.v1.Recommendation> getMarkRecommendationSucceededMethod;
    if ((getMarkRecommendationSucceededMethod = RecommenderGrpc.getMarkRecommendationSucceededMethod) == null) {
      synchronized (RecommenderGrpc.class) {
        if ((getMarkRecommendationSucceededMethod = RecommenderGrpc.getMarkRecommendationSucceededMethod) == null) {
          RecommenderGrpc.getMarkRecommendationSucceededMethod = getMarkRecommendationSucceededMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.recommender.v1.MarkRecommendationSucceededRequest, com.google.cloud.recommender.v1.Recommendation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MarkRecommendationSucceeded"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.recommender.v1.MarkRecommendationSucceededRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.recommender.v1.Recommendation.getDefaultInstance()))
              .setSchemaDescriptor(new RecommenderMethodDescriptorSupplier("MarkRecommendationSucceeded"))
              .build();
        }
      }
    }
    return getMarkRecommendationSucceededMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.recommender.v1.MarkRecommendationFailedRequest,
      com.google.cloud.recommender.v1.Recommendation> getMarkRecommendationFailedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MarkRecommendationFailed",
      requestType = com.google.cloud.recommender.v1.MarkRecommendationFailedRequest.class,
      responseType = com.google.cloud.recommender.v1.Recommendation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.recommender.v1.MarkRecommendationFailedRequest,
      com.google.cloud.recommender.v1.Recommendation> getMarkRecommendationFailedMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.recommender.v1.MarkRecommendationFailedRequest, com.google.cloud.recommender.v1.Recommendation> getMarkRecommendationFailedMethod;
    if ((getMarkRecommendationFailedMethod = RecommenderGrpc.getMarkRecommendationFailedMethod) == null) {
      synchronized (RecommenderGrpc.class) {
        if ((getMarkRecommendationFailedMethod = RecommenderGrpc.getMarkRecommendationFailedMethod) == null) {
          RecommenderGrpc.getMarkRecommendationFailedMethod = getMarkRecommendationFailedMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.recommender.v1.MarkRecommendationFailedRequest, com.google.cloud.recommender.v1.Recommendation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MarkRecommendationFailed"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.recommender.v1.MarkRecommendationFailedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.recommender.v1.Recommendation.getDefaultInstance()))
              .setSchemaDescriptor(new RecommenderMethodDescriptorSupplier("MarkRecommendationFailed"))
              .build();
        }
      }
    }
    return getMarkRecommendationFailedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.recommender.v1.GetRecommenderConfigRequest,
      com.google.cloud.recommender.v1.RecommenderConfig> getGetRecommenderConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRecommenderConfig",
      requestType = com.google.cloud.recommender.v1.GetRecommenderConfigRequest.class,
      responseType = com.google.cloud.recommender.v1.RecommenderConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.recommender.v1.GetRecommenderConfigRequest,
      com.google.cloud.recommender.v1.RecommenderConfig> getGetRecommenderConfigMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.recommender.v1.GetRecommenderConfigRequest, com.google.cloud.recommender.v1.RecommenderConfig> getGetRecommenderConfigMethod;
    if ((getGetRecommenderConfigMethod = RecommenderGrpc.getGetRecommenderConfigMethod) == null) {
      synchronized (RecommenderGrpc.class) {
        if ((getGetRecommenderConfigMethod = RecommenderGrpc.getGetRecommenderConfigMethod) == null) {
          RecommenderGrpc.getGetRecommenderConfigMethod = getGetRecommenderConfigMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.recommender.v1.GetRecommenderConfigRequest, com.google.cloud.recommender.v1.RecommenderConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRecommenderConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.recommender.v1.GetRecommenderConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.recommender.v1.RecommenderConfig.getDefaultInstance()))
              .setSchemaDescriptor(new RecommenderMethodDescriptorSupplier("GetRecommenderConfig"))
              .build();
        }
      }
    }
    return getGetRecommenderConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.recommender.v1.UpdateRecommenderConfigRequest,
      com.google.cloud.recommender.v1.RecommenderConfig> getUpdateRecommenderConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateRecommenderConfig",
      requestType = com.google.cloud.recommender.v1.UpdateRecommenderConfigRequest.class,
      responseType = com.google.cloud.recommender.v1.RecommenderConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.recommender.v1.UpdateRecommenderConfigRequest,
      com.google.cloud.recommender.v1.RecommenderConfig> getUpdateRecommenderConfigMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.recommender.v1.UpdateRecommenderConfigRequest, com.google.cloud.recommender.v1.RecommenderConfig> getUpdateRecommenderConfigMethod;
    if ((getUpdateRecommenderConfigMethod = RecommenderGrpc.getUpdateRecommenderConfigMethod) == null) {
      synchronized (RecommenderGrpc.class) {
        if ((getUpdateRecommenderConfigMethod = RecommenderGrpc.getUpdateRecommenderConfigMethod) == null) {
          RecommenderGrpc.getUpdateRecommenderConfigMethod = getUpdateRecommenderConfigMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.recommender.v1.UpdateRecommenderConfigRequest, com.google.cloud.recommender.v1.RecommenderConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateRecommenderConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.recommender.v1.UpdateRecommenderConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.recommender.v1.RecommenderConfig.getDefaultInstance()))
              .setSchemaDescriptor(new RecommenderMethodDescriptorSupplier("UpdateRecommenderConfig"))
              .build();
        }
      }
    }
    return getUpdateRecommenderConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.recommender.v1.GetInsightTypeConfigRequest,
      com.google.cloud.recommender.v1.InsightTypeConfig> getGetInsightTypeConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInsightTypeConfig",
      requestType = com.google.cloud.recommender.v1.GetInsightTypeConfigRequest.class,
      responseType = com.google.cloud.recommender.v1.InsightTypeConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.recommender.v1.GetInsightTypeConfigRequest,
      com.google.cloud.recommender.v1.InsightTypeConfig> getGetInsightTypeConfigMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.recommender.v1.GetInsightTypeConfigRequest, com.google.cloud.recommender.v1.InsightTypeConfig> getGetInsightTypeConfigMethod;
    if ((getGetInsightTypeConfigMethod = RecommenderGrpc.getGetInsightTypeConfigMethod) == null) {
      synchronized (RecommenderGrpc.class) {
        if ((getGetInsightTypeConfigMethod = RecommenderGrpc.getGetInsightTypeConfigMethod) == null) {
          RecommenderGrpc.getGetInsightTypeConfigMethod = getGetInsightTypeConfigMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.recommender.v1.GetInsightTypeConfigRequest, com.google.cloud.recommender.v1.InsightTypeConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInsightTypeConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.recommender.v1.GetInsightTypeConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.recommender.v1.InsightTypeConfig.getDefaultInstance()))
              .setSchemaDescriptor(new RecommenderMethodDescriptorSupplier("GetInsightTypeConfig"))
              .build();
        }
      }
    }
    return getGetInsightTypeConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.recommender.v1.UpdateInsightTypeConfigRequest,
      com.google.cloud.recommender.v1.InsightTypeConfig> getUpdateInsightTypeConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateInsightTypeConfig",
      requestType = com.google.cloud.recommender.v1.UpdateInsightTypeConfigRequest.class,
      responseType = com.google.cloud.recommender.v1.InsightTypeConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.recommender.v1.UpdateInsightTypeConfigRequest,
      com.google.cloud.recommender.v1.InsightTypeConfig> getUpdateInsightTypeConfigMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.recommender.v1.UpdateInsightTypeConfigRequest, com.google.cloud.recommender.v1.InsightTypeConfig> getUpdateInsightTypeConfigMethod;
    if ((getUpdateInsightTypeConfigMethod = RecommenderGrpc.getUpdateInsightTypeConfigMethod) == null) {
      synchronized (RecommenderGrpc.class) {
        if ((getUpdateInsightTypeConfigMethod = RecommenderGrpc.getUpdateInsightTypeConfigMethod) == null) {
          RecommenderGrpc.getUpdateInsightTypeConfigMethod = getUpdateInsightTypeConfigMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.recommender.v1.UpdateInsightTypeConfigRequest, com.google.cloud.recommender.v1.InsightTypeConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateInsightTypeConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.recommender.v1.UpdateInsightTypeConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.recommender.v1.InsightTypeConfig.getDefaultInstance()))
              .setSchemaDescriptor(new RecommenderMethodDescriptorSupplier("UpdateInsightTypeConfig"))
              .build();
        }
      }
    }
    return getUpdateInsightTypeConfigMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RecommenderStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecommenderStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RecommenderStub>() {
        @java.lang.Override
        public RecommenderStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RecommenderStub(channel, callOptions);
        }
      };
    return RecommenderStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RecommenderBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecommenderBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RecommenderBlockingStub>() {
        @java.lang.Override
        public RecommenderBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RecommenderBlockingStub(channel, callOptions);
        }
      };
    return RecommenderBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RecommenderFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecommenderFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RecommenderFutureStub>() {
        @java.lang.Override
        public RecommenderFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RecommenderFutureStub(channel, callOptions);
        }
      };
    return RecommenderFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Provides insights and recommendations for cloud customers for various
   * categories like performance optimization, cost savings, reliability, feature
   * discovery, etc. Insights and recommendations are generated automatically
   * based on analysis of user resources, configuration and monitoring metrics.
   * </pre>
   */
  public static abstract class RecommenderImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists insights for the specified Cloud Resource. Requires the
     * recommender.*.list IAM permission for the specified insight type.
     * </pre>
     */
    public void listInsights(com.google.cloud.recommender.v1.ListInsightsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1.ListInsightsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListInsightsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the requested insight. Requires the recommender.*.get IAM permission
     * for the specified insight type.
     * </pre>
     */
    public void getInsight(com.google.cloud.recommender.v1.GetInsightRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1.Insight> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetInsightMethod(), responseObserver);
    }

    /**
     * <pre>
     * Marks the Insight State as Accepted. Users can use this method to
     * indicate to the Recommender API that they have applied some action based
     * on the insight. This stops the insight content from being updated.
     * MarkInsightAccepted can be applied to insights in ACTIVE state. Requires
     * the recommender.*.update IAM permission for the specified insight.
     * </pre>
     */
    public void markInsightAccepted(com.google.cloud.recommender.v1.MarkInsightAcceptedRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1.Insight> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMarkInsightAcceptedMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists recommendations for the specified Cloud Resource. Requires the
     * recommender.*.list IAM permission for the specified recommender.
     * </pre>
     */
    public void listRecommendations(com.google.cloud.recommender.v1.ListRecommendationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1.ListRecommendationsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListRecommendationsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the requested recommendation. Requires the recommender.*.get
     * IAM permission for the specified recommender.
     * </pre>
     */
    public void getRecommendation(com.google.cloud.recommender.v1.GetRecommendationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1.Recommendation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetRecommendationMethod(), responseObserver);
    }

    /**
     * <pre>
     * Marks the Recommendation State as Claimed. Users can use this method to
     * indicate to the Recommender API that they are starting to apply the
     * recommendation themselves. This stops the recommendation content from being
     * updated. Associated insights are frozen and placed in the ACCEPTED state.
     * MarkRecommendationClaimed can be applied to recommendations in CLAIMED,
     * SUCCEEDED, FAILED, or ACTIVE state.
     * Requires the recommender.*.update IAM permission for the specified
     * recommender.
     * </pre>
     */
    public void markRecommendationClaimed(com.google.cloud.recommender.v1.MarkRecommendationClaimedRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1.Recommendation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMarkRecommendationClaimedMethod(), responseObserver);
    }

    /**
     * <pre>
     * Marks the Recommendation State as Succeeded. Users can use this method to
     * indicate to the Recommender API that they have applied the recommendation
     * themselves, and the operation was successful. This stops the recommendation
     * content from being updated. Associated insights are frozen and placed in
     * the ACCEPTED state.
     * MarkRecommendationSucceeded can be applied to recommendations in ACTIVE,
     * CLAIMED, SUCCEEDED, or FAILED state.
     * Requires the recommender.*.update IAM permission for the specified
     * recommender.
     * </pre>
     */
    public void markRecommendationSucceeded(com.google.cloud.recommender.v1.MarkRecommendationSucceededRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1.Recommendation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMarkRecommendationSucceededMethod(), responseObserver);
    }

    /**
     * <pre>
     * Marks the Recommendation State as Failed. Users can use this method to
     * indicate to the Recommender API that they have applied the recommendation
     * themselves, and the operation failed. This stops the recommendation content
     * from being updated. Associated insights are frozen and placed in the
     * ACCEPTED state.
     * MarkRecommendationFailed can be applied to recommendations in ACTIVE,
     * CLAIMED, SUCCEEDED, or FAILED state.
     * Requires the recommender.*.update IAM permission for the specified
     * recommender.
     * </pre>
     */
    public void markRecommendationFailed(com.google.cloud.recommender.v1.MarkRecommendationFailedRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1.Recommendation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMarkRecommendationFailedMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the requested Recommender Config. There is only one instance of the
     * config for each Recommender.
     * </pre>
     */
    public void getRecommenderConfig(com.google.cloud.recommender.v1.GetRecommenderConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1.RecommenderConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetRecommenderConfigMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a Recommender Config. This will create a new revision of the
     * config.
     * </pre>
     */
    public void updateRecommenderConfig(com.google.cloud.recommender.v1.UpdateRecommenderConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1.RecommenderConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateRecommenderConfigMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the requested InsightTypeConfig. There is only one instance of the
     * config for each InsightType.
     * </pre>
     */
    public void getInsightTypeConfig(com.google.cloud.recommender.v1.GetInsightTypeConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1.InsightTypeConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetInsightTypeConfigMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates an InsightTypeConfig change. This will create a new revision of the
     * config.
     * </pre>
     */
    public void updateInsightTypeConfig(com.google.cloud.recommender.v1.UpdateInsightTypeConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1.InsightTypeConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateInsightTypeConfigMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListInsightsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.recommender.v1.ListInsightsRequest,
                com.google.cloud.recommender.v1.ListInsightsResponse>(
                  this, METHODID_LIST_INSIGHTS)))
          .addMethod(
            getGetInsightMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.recommender.v1.GetInsightRequest,
                com.google.cloud.recommender.v1.Insight>(
                  this, METHODID_GET_INSIGHT)))
          .addMethod(
            getMarkInsightAcceptedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.recommender.v1.MarkInsightAcceptedRequest,
                com.google.cloud.recommender.v1.Insight>(
                  this, METHODID_MARK_INSIGHT_ACCEPTED)))
          .addMethod(
            getListRecommendationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.recommender.v1.ListRecommendationsRequest,
                com.google.cloud.recommender.v1.ListRecommendationsResponse>(
                  this, METHODID_LIST_RECOMMENDATIONS)))
          .addMethod(
            getGetRecommendationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.recommender.v1.GetRecommendationRequest,
                com.google.cloud.recommender.v1.Recommendation>(
                  this, METHODID_GET_RECOMMENDATION)))
          .addMethod(
            getMarkRecommendationClaimedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.recommender.v1.MarkRecommendationClaimedRequest,
                com.google.cloud.recommender.v1.Recommendation>(
                  this, METHODID_MARK_RECOMMENDATION_CLAIMED)))
          .addMethod(
            getMarkRecommendationSucceededMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.recommender.v1.MarkRecommendationSucceededRequest,
                com.google.cloud.recommender.v1.Recommendation>(
                  this, METHODID_MARK_RECOMMENDATION_SUCCEEDED)))
          .addMethod(
            getMarkRecommendationFailedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.recommender.v1.MarkRecommendationFailedRequest,
                com.google.cloud.recommender.v1.Recommendation>(
                  this, METHODID_MARK_RECOMMENDATION_FAILED)))
          .addMethod(
            getGetRecommenderConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.recommender.v1.GetRecommenderConfigRequest,
                com.google.cloud.recommender.v1.RecommenderConfig>(
                  this, METHODID_GET_RECOMMENDER_CONFIG)))
          .addMethod(
            getUpdateRecommenderConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.recommender.v1.UpdateRecommenderConfigRequest,
                com.google.cloud.recommender.v1.RecommenderConfig>(
                  this, METHODID_UPDATE_RECOMMENDER_CONFIG)))
          .addMethod(
            getGetInsightTypeConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.recommender.v1.GetInsightTypeConfigRequest,
                com.google.cloud.recommender.v1.InsightTypeConfig>(
                  this, METHODID_GET_INSIGHT_TYPE_CONFIG)))
          .addMethod(
            getUpdateInsightTypeConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.recommender.v1.UpdateInsightTypeConfigRequest,
                com.google.cloud.recommender.v1.InsightTypeConfig>(
                  this, METHODID_UPDATE_INSIGHT_TYPE_CONFIG)))
          .build();
    }
  }

  /**
   * <pre>
   * Provides insights and recommendations for cloud customers for various
   * categories like performance optimization, cost savings, reliability, feature
   * discovery, etc. Insights and recommendations are generated automatically
   * based on analysis of user resources, configuration and monitoring metrics.
   * </pre>
   */
  public static final class RecommenderStub extends io.grpc.stub.AbstractAsyncStub<RecommenderStub> {
    private RecommenderStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecommenderStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecommenderStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists insights for the specified Cloud Resource. Requires the
     * recommender.*.list IAM permission for the specified insight type.
     * </pre>
     */
    public void listInsights(com.google.cloud.recommender.v1.ListInsightsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1.ListInsightsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListInsightsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the requested insight. Requires the recommender.*.get IAM permission
     * for the specified insight type.
     * </pre>
     */
    public void getInsight(com.google.cloud.recommender.v1.GetInsightRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1.Insight> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInsightMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Marks the Insight State as Accepted. Users can use this method to
     * indicate to the Recommender API that they have applied some action based
     * on the insight. This stops the insight content from being updated.
     * MarkInsightAccepted can be applied to insights in ACTIVE state. Requires
     * the recommender.*.update IAM permission for the specified insight.
     * </pre>
     */
    public void markInsightAccepted(com.google.cloud.recommender.v1.MarkInsightAcceptedRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1.Insight> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMarkInsightAcceptedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists recommendations for the specified Cloud Resource. Requires the
     * recommender.*.list IAM permission for the specified recommender.
     * </pre>
     */
    public void listRecommendations(com.google.cloud.recommender.v1.ListRecommendationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1.ListRecommendationsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRecommendationsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the requested recommendation. Requires the recommender.*.get
     * IAM permission for the specified recommender.
     * </pre>
     */
    public void getRecommendation(com.google.cloud.recommender.v1.GetRecommendationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1.Recommendation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRecommendationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Marks the Recommendation State as Claimed. Users can use this method to
     * indicate to the Recommender API that they are starting to apply the
     * recommendation themselves. This stops the recommendation content from being
     * updated. Associated insights are frozen and placed in the ACCEPTED state.
     * MarkRecommendationClaimed can be applied to recommendations in CLAIMED,
     * SUCCEEDED, FAILED, or ACTIVE state.
     * Requires the recommender.*.update IAM permission for the specified
     * recommender.
     * </pre>
     */
    public void markRecommendationClaimed(com.google.cloud.recommender.v1.MarkRecommendationClaimedRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1.Recommendation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMarkRecommendationClaimedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Marks the Recommendation State as Succeeded. Users can use this method to
     * indicate to the Recommender API that they have applied the recommendation
     * themselves, and the operation was successful. This stops the recommendation
     * content from being updated. Associated insights are frozen and placed in
     * the ACCEPTED state.
     * MarkRecommendationSucceeded can be applied to recommendations in ACTIVE,
     * CLAIMED, SUCCEEDED, or FAILED state.
     * Requires the recommender.*.update IAM permission for the specified
     * recommender.
     * </pre>
     */
    public void markRecommendationSucceeded(com.google.cloud.recommender.v1.MarkRecommendationSucceededRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1.Recommendation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMarkRecommendationSucceededMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Marks the Recommendation State as Failed. Users can use this method to
     * indicate to the Recommender API that they have applied the recommendation
     * themselves, and the operation failed. This stops the recommendation content
     * from being updated. Associated insights are frozen and placed in the
     * ACCEPTED state.
     * MarkRecommendationFailed can be applied to recommendations in ACTIVE,
     * CLAIMED, SUCCEEDED, or FAILED state.
     * Requires the recommender.*.update IAM permission for the specified
     * recommender.
     * </pre>
     */
    public void markRecommendationFailed(com.google.cloud.recommender.v1.MarkRecommendationFailedRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1.Recommendation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMarkRecommendationFailedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the requested Recommender Config. There is only one instance of the
     * config for each Recommender.
     * </pre>
     */
    public void getRecommenderConfig(com.google.cloud.recommender.v1.GetRecommenderConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1.RecommenderConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRecommenderConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a Recommender Config. This will create a new revision of the
     * config.
     * </pre>
     */
    public void updateRecommenderConfig(com.google.cloud.recommender.v1.UpdateRecommenderConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1.RecommenderConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateRecommenderConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the requested InsightTypeConfig. There is only one instance of the
     * config for each InsightType.
     * </pre>
     */
    public void getInsightTypeConfig(com.google.cloud.recommender.v1.GetInsightTypeConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1.InsightTypeConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInsightTypeConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates an InsightTypeConfig change. This will create a new revision of the
     * config.
     * </pre>
     */
    public void updateInsightTypeConfig(com.google.cloud.recommender.v1.UpdateInsightTypeConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1.InsightTypeConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateInsightTypeConfigMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Provides insights and recommendations for cloud customers for various
   * categories like performance optimization, cost savings, reliability, feature
   * discovery, etc. Insights and recommendations are generated automatically
   * based on analysis of user resources, configuration and monitoring metrics.
   * </pre>
   */
  public static final class RecommenderBlockingStub extends io.grpc.stub.AbstractBlockingStub<RecommenderBlockingStub> {
    private RecommenderBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecommenderBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecommenderBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists insights for the specified Cloud Resource. Requires the
     * recommender.*.list IAM permission for the specified insight type.
     * </pre>
     */
    public com.google.cloud.recommender.v1.ListInsightsResponse listInsights(com.google.cloud.recommender.v1.ListInsightsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListInsightsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the requested insight. Requires the recommender.*.get IAM permission
     * for the specified insight type.
     * </pre>
     */
    public com.google.cloud.recommender.v1.Insight getInsight(com.google.cloud.recommender.v1.GetInsightRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInsightMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Marks the Insight State as Accepted. Users can use this method to
     * indicate to the Recommender API that they have applied some action based
     * on the insight. This stops the insight content from being updated.
     * MarkInsightAccepted can be applied to insights in ACTIVE state. Requires
     * the recommender.*.update IAM permission for the specified insight.
     * </pre>
     */
    public com.google.cloud.recommender.v1.Insight markInsightAccepted(com.google.cloud.recommender.v1.MarkInsightAcceptedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMarkInsightAcceptedMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists recommendations for the specified Cloud Resource. Requires the
     * recommender.*.list IAM permission for the specified recommender.
     * </pre>
     */
    public com.google.cloud.recommender.v1.ListRecommendationsResponse listRecommendations(com.google.cloud.recommender.v1.ListRecommendationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRecommendationsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the requested recommendation. Requires the recommender.*.get
     * IAM permission for the specified recommender.
     * </pre>
     */
    public com.google.cloud.recommender.v1.Recommendation getRecommendation(com.google.cloud.recommender.v1.GetRecommendationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRecommendationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Marks the Recommendation State as Claimed. Users can use this method to
     * indicate to the Recommender API that they are starting to apply the
     * recommendation themselves. This stops the recommendation content from being
     * updated. Associated insights are frozen and placed in the ACCEPTED state.
     * MarkRecommendationClaimed can be applied to recommendations in CLAIMED,
     * SUCCEEDED, FAILED, or ACTIVE state.
     * Requires the recommender.*.update IAM permission for the specified
     * recommender.
     * </pre>
     */
    public com.google.cloud.recommender.v1.Recommendation markRecommendationClaimed(com.google.cloud.recommender.v1.MarkRecommendationClaimedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMarkRecommendationClaimedMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Marks the Recommendation State as Succeeded. Users can use this method to
     * indicate to the Recommender API that they have applied the recommendation
     * themselves, and the operation was successful. This stops the recommendation
     * content from being updated. Associated insights are frozen and placed in
     * the ACCEPTED state.
     * MarkRecommendationSucceeded can be applied to recommendations in ACTIVE,
     * CLAIMED, SUCCEEDED, or FAILED state.
     * Requires the recommender.*.update IAM permission for the specified
     * recommender.
     * </pre>
     */
    public com.google.cloud.recommender.v1.Recommendation markRecommendationSucceeded(com.google.cloud.recommender.v1.MarkRecommendationSucceededRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMarkRecommendationSucceededMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Marks the Recommendation State as Failed. Users can use this method to
     * indicate to the Recommender API that they have applied the recommendation
     * themselves, and the operation failed. This stops the recommendation content
     * from being updated. Associated insights are frozen and placed in the
     * ACCEPTED state.
     * MarkRecommendationFailed can be applied to recommendations in ACTIVE,
     * CLAIMED, SUCCEEDED, or FAILED state.
     * Requires the recommender.*.update IAM permission for the specified
     * recommender.
     * </pre>
     */
    public com.google.cloud.recommender.v1.Recommendation markRecommendationFailed(com.google.cloud.recommender.v1.MarkRecommendationFailedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMarkRecommendationFailedMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the requested Recommender Config. There is only one instance of the
     * config for each Recommender.
     * </pre>
     */
    public com.google.cloud.recommender.v1.RecommenderConfig getRecommenderConfig(com.google.cloud.recommender.v1.GetRecommenderConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRecommenderConfigMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a Recommender Config. This will create a new revision of the
     * config.
     * </pre>
     */
    public com.google.cloud.recommender.v1.RecommenderConfig updateRecommenderConfig(com.google.cloud.recommender.v1.UpdateRecommenderConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateRecommenderConfigMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the requested InsightTypeConfig. There is only one instance of the
     * config for each InsightType.
     * </pre>
     */
    public com.google.cloud.recommender.v1.InsightTypeConfig getInsightTypeConfig(com.google.cloud.recommender.v1.GetInsightTypeConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInsightTypeConfigMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates an InsightTypeConfig change. This will create a new revision of the
     * config.
     * </pre>
     */
    public com.google.cloud.recommender.v1.InsightTypeConfig updateInsightTypeConfig(com.google.cloud.recommender.v1.UpdateInsightTypeConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateInsightTypeConfigMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Provides insights and recommendations for cloud customers for various
   * categories like performance optimization, cost savings, reliability, feature
   * discovery, etc. Insights and recommendations are generated automatically
   * based on analysis of user resources, configuration and monitoring metrics.
   * </pre>
   */
  public static final class RecommenderFutureStub extends io.grpc.stub.AbstractFutureStub<RecommenderFutureStub> {
    private RecommenderFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecommenderFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecommenderFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists insights for the specified Cloud Resource. Requires the
     * recommender.*.list IAM permission for the specified insight type.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.recommender.v1.ListInsightsResponse> listInsights(
        com.google.cloud.recommender.v1.ListInsightsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListInsightsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the requested insight. Requires the recommender.*.get IAM permission
     * for the specified insight type.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.recommender.v1.Insight> getInsight(
        com.google.cloud.recommender.v1.GetInsightRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInsightMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Marks the Insight State as Accepted. Users can use this method to
     * indicate to the Recommender API that they have applied some action based
     * on the insight. This stops the insight content from being updated.
     * MarkInsightAccepted can be applied to insights in ACTIVE state. Requires
     * the recommender.*.update IAM permission for the specified insight.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.recommender.v1.Insight> markInsightAccepted(
        com.google.cloud.recommender.v1.MarkInsightAcceptedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMarkInsightAcceptedMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists recommendations for the specified Cloud Resource. Requires the
     * recommender.*.list IAM permission for the specified recommender.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.recommender.v1.ListRecommendationsResponse> listRecommendations(
        com.google.cloud.recommender.v1.ListRecommendationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRecommendationsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the requested recommendation. Requires the recommender.*.get
     * IAM permission for the specified recommender.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.recommender.v1.Recommendation> getRecommendation(
        com.google.cloud.recommender.v1.GetRecommendationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRecommendationMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Marks the Recommendation State as Claimed. Users can use this method to
     * indicate to the Recommender API that they are starting to apply the
     * recommendation themselves. This stops the recommendation content from being
     * updated. Associated insights are frozen and placed in the ACCEPTED state.
     * MarkRecommendationClaimed can be applied to recommendations in CLAIMED,
     * SUCCEEDED, FAILED, or ACTIVE state.
     * Requires the recommender.*.update IAM permission for the specified
     * recommender.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.recommender.v1.Recommendation> markRecommendationClaimed(
        com.google.cloud.recommender.v1.MarkRecommendationClaimedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMarkRecommendationClaimedMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Marks the Recommendation State as Succeeded. Users can use this method to
     * indicate to the Recommender API that they have applied the recommendation
     * themselves, and the operation was successful. This stops the recommendation
     * content from being updated. Associated insights are frozen and placed in
     * the ACCEPTED state.
     * MarkRecommendationSucceeded can be applied to recommendations in ACTIVE,
     * CLAIMED, SUCCEEDED, or FAILED state.
     * Requires the recommender.*.update IAM permission for the specified
     * recommender.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.recommender.v1.Recommendation> markRecommendationSucceeded(
        com.google.cloud.recommender.v1.MarkRecommendationSucceededRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMarkRecommendationSucceededMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Marks the Recommendation State as Failed. Users can use this method to
     * indicate to the Recommender API that they have applied the recommendation
     * themselves, and the operation failed. This stops the recommendation content
     * from being updated. Associated insights are frozen and placed in the
     * ACCEPTED state.
     * MarkRecommendationFailed can be applied to recommendations in ACTIVE,
     * CLAIMED, SUCCEEDED, or FAILED state.
     * Requires the recommender.*.update IAM permission for the specified
     * recommender.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.recommender.v1.Recommendation> markRecommendationFailed(
        com.google.cloud.recommender.v1.MarkRecommendationFailedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMarkRecommendationFailedMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the requested Recommender Config. There is only one instance of the
     * config for each Recommender.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.recommender.v1.RecommenderConfig> getRecommenderConfig(
        com.google.cloud.recommender.v1.GetRecommenderConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRecommenderConfigMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a Recommender Config. This will create a new revision of the
     * config.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.recommender.v1.RecommenderConfig> updateRecommenderConfig(
        com.google.cloud.recommender.v1.UpdateRecommenderConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateRecommenderConfigMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the requested InsightTypeConfig. There is only one instance of the
     * config for each InsightType.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.recommender.v1.InsightTypeConfig> getInsightTypeConfig(
        com.google.cloud.recommender.v1.GetInsightTypeConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInsightTypeConfigMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates an InsightTypeConfig change. This will create a new revision of the
     * config.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.recommender.v1.InsightTypeConfig> updateInsightTypeConfig(
        com.google.cloud.recommender.v1.UpdateInsightTypeConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateInsightTypeConfigMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_INSIGHTS = 0;
  private static final int METHODID_GET_INSIGHT = 1;
  private static final int METHODID_MARK_INSIGHT_ACCEPTED = 2;
  private static final int METHODID_LIST_RECOMMENDATIONS = 3;
  private static final int METHODID_GET_RECOMMENDATION = 4;
  private static final int METHODID_MARK_RECOMMENDATION_CLAIMED = 5;
  private static final int METHODID_MARK_RECOMMENDATION_SUCCEEDED = 6;
  private static final int METHODID_MARK_RECOMMENDATION_FAILED = 7;
  private static final int METHODID_GET_RECOMMENDER_CONFIG = 8;
  private static final int METHODID_UPDATE_RECOMMENDER_CONFIG = 9;
  private static final int METHODID_GET_INSIGHT_TYPE_CONFIG = 10;
  private static final int METHODID_UPDATE_INSIGHT_TYPE_CONFIG = 11;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RecommenderImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RecommenderImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_INSIGHTS:
          serviceImpl.listInsights((com.google.cloud.recommender.v1.ListInsightsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1.ListInsightsResponse>) responseObserver);
          break;
        case METHODID_GET_INSIGHT:
          serviceImpl.getInsight((com.google.cloud.recommender.v1.GetInsightRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1.Insight>) responseObserver);
          break;
        case METHODID_MARK_INSIGHT_ACCEPTED:
          serviceImpl.markInsightAccepted((com.google.cloud.recommender.v1.MarkInsightAcceptedRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1.Insight>) responseObserver);
          break;
        case METHODID_LIST_RECOMMENDATIONS:
          serviceImpl.listRecommendations((com.google.cloud.recommender.v1.ListRecommendationsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1.ListRecommendationsResponse>) responseObserver);
          break;
        case METHODID_GET_RECOMMENDATION:
          serviceImpl.getRecommendation((com.google.cloud.recommender.v1.GetRecommendationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1.Recommendation>) responseObserver);
          break;
        case METHODID_MARK_RECOMMENDATION_CLAIMED:
          serviceImpl.markRecommendationClaimed((com.google.cloud.recommender.v1.MarkRecommendationClaimedRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1.Recommendation>) responseObserver);
          break;
        case METHODID_MARK_RECOMMENDATION_SUCCEEDED:
          serviceImpl.markRecommendationSucceeded((com.google.cloud.recommender.v1.MarkRecommendationSucceededRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1.Recommendation>) responseObserver);
          break;
        case METHODID_MARK_RECOMMENDATION_FAILED:
          serviceImpl.markRecommendationFailed((com.google.cloud.recommender.v1.MarkRecommendationFailedRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1.Recommendation>) responseObserver);
          break;
        case METHODID_GET_RECOMMENDER_CONFIG:
          serviceImpl.getRecommenderConfig((com.google.cloud.recommender.v1.GetRecommenderConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1.RecommenderConfig>) responseObserver);
          break;
        case METHODID_UPDATE_RECOMMENDER_CONFIG:
          serviceImpl.updateRecommenderConfig((com.google.cloud.recommender.v1.UpdateRecommenderConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1.RecommenderConfig>) responseObserver);
          break;
        case METHODID_GET_INSIGHT_TYPE_CONFIG:
          serviceImpl.getInsightTypeConfig((com.google.cloud.recommender.v1.GetInsightTypeConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1.InsightTypeConfig>) responseObserver);
          break;
        case METHODID_UPDATE_INSIGHT_TYPE_CONFIG:
          serviceImpl.updateInsightTypeConfig((com.google.cloud.recommender.v1.UpdateInsightTypeConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1.InsightTypeConfig>) responseObserver);
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

  private static abstract class RecommenderBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RecommenderBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.recommender.v1.RecommenderProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Recommender");
    }
  }

  private static final class RecommenderFileDescriptorSupplier
      extends RecommenderBaseDescriptorSupplier {
    RecommenderFileDescriptorSupplier() {}
  }

  private static final class RecommenderMethodDescriptorSupplier
      extends RecommenderBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RecommenderMethodDescriptorSupplier(String methodName) {
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
      synchronized (RecommenderGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RecommenderFileDescriptorSupplier())
              .addMethod(getListInsightsMethod())
              .addMethod(getGetInsightMethod())
              .addMethod(getMarkInsightAcceptedMethod())
              .addMethod(getListRecommendationsMethod())
              .addMethod(getGetRecommendationMethod())
              .addMethod(getMarkRecommendationClaimedMethod())
              .addMethod(getMarkRecommendationSucceededMethod())
              .addMethod(getMarkRecommendationFailedMethod())
              .addMethod(getGetRecommenderConfigMethod())
              .addMethod(getUpdateRecommenderConfigMethod())
              .addMethod(getGetInsightTypeConfigMethod())
              .addMethod(getUpdateInsightTypeConfigMethod())
              .build();
        }
      }
    }
    return result;
  }
}
