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
package com.google.cloud.recommender.v1beta1;

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
 * Provides insights and recommendations for cloud customers for various
 * categories like performance optimization, cost savings, reliability, feature
 * discovery, etc. Insights and recommendations are generated automatically
 * based on analysis of user resources, configuration and monitoring metrics.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/recommender/v1beta1/recommender_service.proto")
public final class RecommenderGrpc {

  private RecommenderGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.recommender.v1beta1.Recommender";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.recommender.v1beta1.ListInsightsRequest,
          com.google.cloud.recommender.v1beta1.ListInsightsResponse>
      getListInsightsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListInsights",
      requestType = com.google.cloud.recommender.v1beta1.ListInsightsRequest.class,
      responseType = com.google.cloud.recommender.v1beta1.ListInsightsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.recommender.v1beta1.ListInsightsRequest,
          com.google.cloud.recommender.v1beta1.ListInsightsResponse>
      getListInsightsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.recommender.v1beta1.ListInsightsRequest,
            com.google.cloud.recommender.v1beta1.ListInsightsResponse>
        getListInsightsMethod;
    if ((getListInsightsMethod = RecommenderGrpc.getListInsightsMethod) == null) {
      synchronized (RecommenderGrpc.class) {
        if ((getListInsightsMethod = RecommenderGrpc.getListInsightsMethod) == null) {
          RecommenderGrpc.getListInsightsMethod =
              getListInsightsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.recommender.v1beta1.ListInsightsRequest,
                          com.google.cloud.recommender.v1beta1.ListInsightsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListInsights"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.recommender.v1beta1.ListInsightsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.recommender.v1beta1.ListInsightsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new RecommenderMethodDescriptorSupplier("ListInsights"))
                      .build();
        }
      }
    }
    return getListInsightsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.recommender.v1beta1.GetInsightRequest,
          com.google.cloud.recommender.v1beta1.Insight>
      getGetInsightMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInsight",
      requestType = com.google.cloud.recommender.v1beta1.GetInsightRequest.class,
      responseType = com.google.cloud.recommender.v1beta1.Insight.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.recommender.v1beta1.GetInsightRequest,
          com.google.cloud.recommender.v1beta1.Insight>
      getGetInsightMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.recommender.v1beta1.GetInsightRequest,
            com.google.cloud.recommender.v1beta1.Insight>
        getGetInsightMethod;
    if ((getGetInsightMethod = RecommenderGrpc.getGetInsightMethod) == null) {
      synchronized (RecommenderGrpc.class) {
        if ((getGetInsightMethod = RecommenderGrpc.getGetInsightMethod) == null) {
          RecommenderGrpc.getGetInsightMethod =
              getGetInsightMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.recommender.v1beta1.GetInsightRequest,
                          com.google.cloud.recommender.v1beta1.Insight>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInsight"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.recommender.v1beta1.GetInsightRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.recommender.v1beta1.Insight.getDefaultInstance()))
                      .setSchemaDescriptor(new RecommenderMethodDescriptorSupplier("GetInsight"))
                      .build();
        }
      }
    }
    return getGetInsightMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.recommender.v1beta1.MarkInsightAcceptedRequest,
          com.google.cloud.recommender.v1beta1.Insight>
      getMarkInsightAcceptedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MarkInsightAccepted",
      requestType = com.google.cloud.recommender.v1beta1.MarkInsightAcceptedRequest.class,
      responseType = com.google.cloud.recommender.v1beta1.Insight.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.recommender.v1beta1.MarkInsightAcceptedRequest,
          com.google.cloud.recommender.v1beta1.Insight>
      getMarkInsightAcceptedMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.recommender.v1beta1.MarkInsightAcceptedRequest,
            com.google.cloud.recommender.v1beta1.Insight>
        getMarkInsightAcceptedMethod;
    if ((getMarkInsightAcceptedMethod = RecommenderGrpc.getMarkInsightAcceptedMethod) == null) {
      synchronized (RecommenderGrpc.class) {
        if ((getMarkInsightAcceptedMethod = RecommenderGrpc.getMarkInsightAcceptedMethod) == null) {
          RecommenderGrpc.getMarkInsightAcceptedMethod =
              getMarkInsightAcceptedMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.recommender.v1beta1.MarkInsightAcceptedRequest,
                          com.google.cloud.recommender.v1beta1.Insight>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "MarkInsightAccepted"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.recommender.v1beta1.MarkInsightAcceptedRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.recommender.v1beta1.Insight.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecommenderMethodDescriptorSupplier("MarkInsightAccepted"))
                      .build();
        }
      }
    }
    return getMarkInsightAcceptedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.recommender.v1beta1.ListRecommendationsRequest,
          com.google.cloud.recommender.v1beta1.ListRecommendationsResponse>
      getListRecommendationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRecommendations",
      requestType = com.google.cloud.recommender.v1beta1.ListRecommendationsRequest.class,
      responseType = com.google.cloud.recommender.v1beta1.ListRecommendationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.recommender.v1beta1.ListRecommendationsRequest,
          com.google.cloud.recommender.v1beta1.ListRecommendationsResponse>
      getListRecommendationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.recommender.v1beta1.ListRecommendationsRequest,
            com.google.cloud.recommender.v1beta1.ListRecommendationsResponse>
        getListRecommendationsMethod;
    if ((getListRecommendationsMethod = RecommenderGrpc.getListRecommendationsMethod) == null) {
      synchronized (RecommenderGrpc.class) {
        if ((getListRecommendationsMethod = RecommenderGrpc.getListRecommendationsMethod) == null) {
          RecommenderGrpc.getListRecommendationsMethod =
              getListRecommendationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.recommender.v1beta1.ListRecommendationsRequest,
                          com.google.cloud.recommender.v1beta1.ListRecommendationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListRecommendations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.recommender.v1beta1.ListRecommendationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.recommender.v1beta1.ListRecommendationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecommenderMethodDescriptorSupplier("ListRecommendations"))
                      .build();
        }
      }
    }
    return getListRecommendationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.recommender.v1beta1.GetRecommendationRequest,
          com.google.cloud.recommender.v1beta1.Recommendation>
      getGetRecommendationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRecommendation",
      requestType = com.google.cloud.recommender.v1beta1.GetRecommendationRequest.class,
      responseType = com.google.cloud.recommender.v1beta1.Recommendation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.recommender.v1beta1.GetRecommendationRequest,
          com.google.cloud.recommender.v1beta1.Recommendation>
      getGetRecommendationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.recommender.v1beta1.GetRecommendationRequest,
            com.google.cloud.recommender.v1beta1.Recommendation>
        getGetRecommendationMethod;
    if ((getGetRecommendationMethod = RecommenderGrpc.getGetRecommendationMethod) == null) {
      synchronized (RecommenderGrpc.class) {
        if ((getGetRecommendationMethod = RecommenderGrpc.getGetRecommendationMethod) == null) {
          RecommenderGrpc.getGetRecommendationMethod =
              getGetRecommendationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.recommender.v1beta1.GetRecommendationRequest,
                          com.google.cloud.recommender.v1beta1.Recommendation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRecommendation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.recommender.v1beta1.GetRecommendationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.recommender.v1beta1.Recommendation
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecommenderMethodDescriptorSupplier("GetRecommendation"))
                      .build();
        }
      }
    }
    return getGetRecommendationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.recommender.v1beta1.MarkRecommendationClaimedRequest,
          com.google.cloud.recommender.v1beta1.Recommendation>
      getMarkRecommendationClaimedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MarkRecommendationClaimed",
      requestType = com.google.cloud.recommender.v1beta1.MarkRecommendationClaimedRequest.class,
      responseType = com.google.cloud.recommender.v1beta1.Recommendation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.recommender.v1beta1.MarkRecommendationClaimedRequest,
          com.google.cloud.recommender.v1beta1.Recommendation>
      getMarkRecommendationClaimedMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.recommender.v1beta1.MarkRecommendationClaimedRequest,
            com.google.cloud.recommender.v1beta1.Recommendation>
        getMarkRecommendationClaimedMethod;
    if ((getMarkRecommendationClaimedMethod = RecommenderGrpc.getMarkRecommendationClaimedMethod)
        == null) {
      synchronized (RecommenderGrpc.class) {
        if ((getMarkRecommendationClaimedMethod =
                RecommenderGrpc.getMarkRecommendationClaimedMethod)
            == null) {
          RecommenderGrpc.getMarkRecommendationClaimedMethod =
              getMarkRecommendationClaimedMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.recommender.v1beta1.MarkRecommendationClaimedRequest,
                          com.google.cloud.recommender.v1beta1.Recommendation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "MarkRecommendationClaimed"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.recommender.v1beta1.MarkRecommendationClaimedRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.recommender.v1beta1.Recommendation
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecommenderMethodDescriptorSupplier("MarkRecommendationClaimed"))
                      .build();
        }
      }
    }
    return getMarkRecommendationClaimedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.recommender.v1beta1.MarkRecommendationSucceededRequest,
          com.google.cloud.recommender.v1beta1.Recommendation>
      getMarkRecommendationSucceededMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MarkRecommendationSucceeded",
      requestType = com.google.cloud.recommender.v1beta1.MarkRecommendationSucceededRequest.class,
      responseType = com.google.cloud.recommender.v1beta1.Recommendation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.recommender.v1beta1.MarkRecommendationSucceededRequest,
          com.google.cloud.recommender.v1beta1.Recommendation>
      getMarkRecommendationSucceededMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.recommender.v1beta1.MarkRecommendationSucceededRequest,
            com.google.cloud.recommender.v1beta1.Recommendation>
        getMarkRecommendationSucceededMethod;
    if ((getMarkRecommendationSucceededMethod =
            RecommenderGrpc.getMarkRecommendationSucceededMethod)
        == null) {
      synchronized (RecommenderGrpc.class) {
        if ((getMarkRecommendationSucceededMethod =
                RecommenderGrpc.getMarkRecommendationSucceededMethod)
            == null) {
          RecommenderGrpc.getMarkRecommendationSucceededMethod =
              getMarkRecommendationSucceededMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.recommender.v1beta1.MarkRecommendationSucceededRequest,
                          com.google.cloud.recommender.v1beta1.Recommendation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "MarkRecommendationSucceeded"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.recommender.v1beta1
                                  .MarkRecommendationSucceededRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.recommender.v1beta1.Recommendation
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecommenderMethodDescriptorSupplier("MarkRecommendationSucceeded"))
                      .build();
        }
      }
    }
    return getMarkRecommendationSucceededMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.recommender.v1beta1.MarkRecommendationFailedRequest,
          com.google.cloud.recommender.v1beta1.Recommendation>
      getMarkRecommendationFailedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MarkRecommendationFailed",
      requestType = com.google.cloud.recommender.v1beta1.MarkRecommendationFailedRequest.class,
      responseType = com.google.cloud.recommender.v1beta1.Recommendation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.recommender.v1beta1.MarkRecommendationFailedRequest,
          com.google.cloud.recommender.v1beta1.Recommendation>
      getMarkRecommendationFailedMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.recommender.v1beta1.MarkRecommendationFailedRequest,
            com.google.cloud.recommender.v1beta1.Recommendation>
        getMarkRecommendationFailedMethod;
    if ((getMarkRecommendationFailedMethod = RecommenderGrpc.getMarkRecommendationFailedMethod)
        == null) {
      synchronized (RecommenderGrpc.class) {
        if ((getMarkRecommendationFailedMethod = RecommenderGrpc.getMarkRecommendationFailedMethod)
            == null) {
          RecommenderGrpc.getMarkRecommendationFailedMethod =
              getMarkRecommendationFailedMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.recommender.v1beta1.MarkRecommendationFailedRequest,
                          com.google.cloud.recommender.v1beta1.Recommendation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "MarkRecommendationFailed"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.recommender.v1beta1.MarkRecommendationFailedRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.recommender.v1beta1.Recommendation
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecommenderMethodDescriptorSupplier("MarkRecommendationFailed"))
                      .build();
        }
      }
    }
    return getMarkRecommendationFailedMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
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
  public static RecommenderBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecommenderBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RecommenderBlockingStub>() {
          @java.lang.Override
          public RecommenderBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RecommenderBlockingStub(channel, callOptions);
          }
        };
    return RecommenderBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static RecommenderFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecommenderFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RecommenderFutureStub>() {
          @java.lang.Override
          public RecommenderFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RecommenderFutureStub(channel, callOptions);
          }
        };
    return RecommenderFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Provides insights and recommendations for cloud customers for various
   * categories like performance optimization, cost savings, reliability, feature
   * discovery, etc. Insights and recommendations are generated automatically
   * based on analysis of user resources, configuration and monitoring metrics.
   * </pre>
   */
  public abstract static class RecommenderImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Lists insights for a Cloud project. Requires the recommender.*.list IAM
     * permission for the specified insight type.
     * </pre>
     */
    public void listInsights(
        com.google.cloud.recommender.v1beta1.ListInsightsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1beta1.ListInsightsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListInsightsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the requested insight. Requires the recommender.*.get IAM permission
     * for the specified insight type.
     * </pre>
     */
    public void getInsight(
        com.google.cloud.recommender.v1beta1.GetInsightRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1beta1.Insight>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGetInsightMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Marks the Insight State as Accepted. Users can use this method to
     * indicate to the Recommender API that they have applied some action based
     * on the insight. This stops the insight content from being updated.
     * MarkInsightAccepted can be applied to insights in ACTIVE state. Requires
     * the recommender.*.update IAM permission for the specified insight.
     * </pre>
     */
    public void markInsightAccepted(
        com.google.cloud.recommender.v1beta1.MarkInsightAcceptedRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1beta1.Insight>
            responseObserver) {
      asyncUnimplementedUnaryCall(getMarkInsightAcceptedMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists recommendations for a Cloud project. Requires the recommender.*.list
     * IAM permission for the specified recommender.
     * </pre>
     */
    public void listRecommendations(
        com.google.cloud.recommender.v1beta1.ListRecommendationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.recommender.v1beta1.ListRecommendationsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListRecommendationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the requested recommendation. Requires the recommender.*.get
     * IAM permission for the specified recommender.
     * </pre>
     */
    public void getRecommendation(
        com.google.cloud.recommender.v1beta1.GetRecommendationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1beta1.Recommendation>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGetRecommendationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Marks the Recommendation State as Claimed. Users can use this method to
     * indicate to the Recommender API that they are starting to apply the
     * recommendation themselves. This stops the recommendation content from being
     * updated. Associated insights are frozen and placed in the ACCEPTED state.
     * MarkRecommendationClaimed can be applied to recommendations in CLAIMED or
     * ACTIVE state.
     * Requires the recommender.*.update IAM permission for the specified
     * recommender.
     * </pre>
     */
    public void markRecommendationClaimed(
        com.google.cloud.recommender.v1beta1.MarkRecommendationClaimedRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1beta1.Recommendation>
            responseObserver) {
      asyncUnimplementedUnaryCall(getMarkRecommendationClaimedMethod(), responseObserver);
    }

    /**
     *
     *
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
    public void markRecommendationSucceeded(
        com.google.cloud.recommender.v1beta1.MarkRecommendationSucceededRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1beta1.Recommendation>
            responseObserver) {
      asyncUnimplementedUnaryCall(getMarkRecommendationSucceededMethod(), responseObserver);
    }

    /**
     *
     *
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
    public void markRecommendationFailed(
        com.google.cloud.recommender.v1beta1.MarkRecommendationFailedRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1beta1.Recommendation>
            responseObserver) {
      asyncUnimplementedUnaryCall(getMarkRecommendationFailedMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListInsightsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.recommender.v1beta1.ListInsightsRequest,
                      com.google.cloud.recommender.v1beta1.ListInsightsResponse>(
                      this, METHODID_LIST_INSIGHTS)))
          .addMethod(
              getGetInsightMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.recommender.v1beta1.GetInsightRequest,
                      com.google.cloud.recommender.v1beta1.Insight>(this, METHODID_GET_INSIGHT)))
          .addMethod(
              getMarkInsightAcceptedMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.recommender.v1beta1.MarkInsightAcceptedRequest,
                      com.google.cloud.recommender.v1beta1.Insight>(
                      this, METHODID_MARK_INSIGHT_ACCEPTED)))
          .addMethod(
              getListRecommendationsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.recommender.v1beta1.ListRecommendationsRequest,
                      com.google.cloud.recommender.v1beta1.ListRecommendationsResponse>(
                      this, METHODID_LIST_RECOMMENDATIONS)))
          .addMethod(
              getGetRecommendationMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.recommender.v1beta1.GetRecommendationRequest,
                      com.google.cloud.recommender.v1beta1.Recommendation>(
                      this, METHODID_GET_RECOMMENDATION)))
          .addMethod(
              getMarkRecommendationClaimedMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.recommender.v1beta1.MarkRecommendationClaimedRequest,
                      com.google.cloud.recommender.v1beta1.Recommendation>(
                      this, METHODID_MARK_RECOMMENDATION_CLAIMED)))
          .addMethod(
              getMarkRecommendationSucceededMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.recommender.v1beta1.MarkRecommendationSucceededRequest,
                      com.google.cloud.recommender.v1beta1.Recommendation>(
                      this, METHODID_MARK_RECOMMENDATION_SUCCEEDED)))
          .addMethod(
              getMarkRecommendationFailedMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.recommender.v1beta1.MarkRecommendationFailedRequest,
                      com.google.cloud.recommender.v1beta1.Recommendation>(
                      this, METHODID_MARK_RECOMMENDATION_FAILED)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Provides insights and recommendations for cloud customers for various
   * categories like performance optimization, cost savings, reliability, feature
   * discovery, etc. Insights and recommendations are generated automatically
   * based on analysis of user resources, configuration and monitoring metrics.
   * </pre>
   */
  public static final class RecommenderStub
      extends io.grpc.stub.AbstractAsyncStub<RecommenderStub> {
    private RecommenderStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecommenderStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecommenderStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists insights for a Cloud project. Requires the recommender.*.list IAM
     * permission for the specified insight type.
     * </pre>
     */
    public void listInsights(
        com.google.cloud.recommender.v1beta1.ListInsightsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1beta1.ListInsightsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListInsightsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the requested insight. Requires the recommender.*.get IAM permission
     * for the specified insight type.
     * </pre>
     */
    public void getInsight(
        com.google.cloud.recommender.v1beta1.GetInsightRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1beta1.Insight>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetInsightMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Marks the Insight State as Accepted. Users can use this method to
     * indicate to the Recommender API that they have applied some action based
     * on the insight. This stops the insight content from being updated.
     * MarkInsightAccepted can be applied to insights in ACTIVE state. Requires
     * the recommender.*.update IAM permission for the specified insight.
     * </pre>
     */
    public void markInsightAccepted(
        com.google.cloud.recommender.v1beta1.MarkInsightAcceptedRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1beta1.Insight>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getMarkInsightAcceptedMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists recommendations for a Cloud project. Requires the recommender.*.list
     * IAM permission for the specified recommender.
     * </pre>
     */
    public void listRecommendations(
        com.google.cloud.recommender.v1beta1.ListRecommendationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.recommender.v1beta1.ListRecommendationsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListRecommendationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the requested recommendation. Requires the recommender.*.get
     * IAM permission for the specified recommender.
     * </pre>
     */
    public void getRecommendation(
        com.google.cloud.recommender.v1beta1.GetRecommendationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1beta1.Recommendation>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetRecommendationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Marks the Recommendation State as Claimed. Users can use this method to
     * indicate to the Recommender API that they are starting to apply the
     * recommendation themselves. This stops the recommendation content from being
     * updated. Associated insights are frozen and placed in the ACCEPTED state.
     * MarkRecommendationClaimed can be applied to recommendations in CLAIMED or
     * ACTIVE state.
     * Requires the recommender.*.update IAM permission for the specified
     * recommender.
     * </pre>
     */
    public void markRecommendationClaimed(
        com.google.cloud.recommender.v1beta1.MarkRecommendationClaimedRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1beta1.Recommendation>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getMarkRecommendationClaimedMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
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
    public void markRecommendationSucceeded(
        com.google.cloud.recommender.v1beta1.MarkRecommendationSucceededRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1beta1.Recommendation>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getMarkRecommendationSucceededMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
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
    public void markRecommendationFailed(
        com.google.cloud.recommender.v1beta1.MarkRecommendationFailedRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1beta1.Recommendation>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getMarkRecommendationFailedMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Provides insights and recommendations for cloud customers for various
   * categories like performance optimization, cost savings, reliability, feature
   * discovery, etc. Insights and recommendations are generated automatically
   * based on analysis of user resources, configuration and monitoring metrics.
   * </pre>
   */
  public static final class RecommenderBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<RecommenderBlockingStub> {
    private RecommenderBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecommenderBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecommenderBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists insights for a Cloud project. Requires the recommender.*.list IAM
     * permission for the specified insight type.
     * </pre>
     */
    public com.google.cloud.recommender.v1beta1.ListInsightsResponse listInsights(
        com.google.cloud.recommender.v1beta1.ListInsightsRequest request) {
      return blockingUnaryCall(getChannel(), getListInsightsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the requested insight. Requires the recommender.*.get IAM permission
     * for the specified insight type.
     * </pre>
     */
    public com.google.cloud.recommender.v1beta1.Insight getInsight(
        com.google.cloud.recommender.v1beta1.GetInsightRequest request) {
      return blockingUnaryCall(getChannel(), getGetInsightMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Marks the Insight State as Accepted. Users can use this method to
     * indicate to the Recommender API that they have applied some action based
     * on the insight. This stops the insight content from being updated.
     * MarkInsightAccepted can be applied to insights in ACTIVE state. Requires
     * the recommender.*.update IAM permission for the specified insight.
     * </pre>
     */
    public com.google.cloud.recommender.v1beta1.Insight markInsightAccepted(
        com.google.cloud.recommender.v1beta1.MarkInsightAcceptedRequest request) {
      return blockingUnaryCall(
          getChannel(), getMarkInsightAcceptedMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists recommendations for a Cloud project. Requires the recommender.*.list
     * IAM permission for the specified recommender.
     * </pre>
     */
    public com.google.cloud.recommender.v1beta1.ListRecommendationsResponse listRecommendations(
        com.google.cloud.recommender.v1beta1.ListRecommendationsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListRecommendationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the requested recommendation. Requires the recommender.*.get
     * IAM permission for the specified recommender.
     * </pre>
     */
    public com.google.cloud.recommender.v1beta1.Recommendation getRecommendation(
        com.google.cloud.recommender.v1beta1.GetRecommendationRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetRecommendationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Marks the Recommendation State as Claimed. Users can use this method to
     * indicate to the Recommender API that they are starting to apply the
     * recommendation themselves. This stops the recommendation content from being
     * updated. Associated insights are frozen and placed in the ACCEPTED state.
     * MarkRecommendationClaimed can be applied to recommendations in CLAIMED or
     * ACTIVE state.
     * Requires the recommender.*.update IAM permission for the specified
     * recommender.
     * </pre>
     */
    public com.google.cloud.recommender.v1beta1.Recommendation markRecommendationClaimed(
        com.google.cloud.recommender.v1beta1.MarkRecommendationClaimedRequest request) {
      return blockingUnaryCall(
          getChannel(), getMarkRecommendationClaimedMethod(), getCallOptions(), request);
    }

    /**
     *
     *
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
    public com.google.cloud.recommender.v1beta1.Recommendation markRecommendationSucceeded(
        com.google.cloud.recommender.v1beta1.MarkRecommendationSucceededRequest request) {
      return blockingUnaryCall(
          getChannel(), getMarkRecommendationSucceededMethod(), getCallOptions(), request);
    }

    /**
     *
     *
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
    public com.google.cloud.recommender.v1beta1.Recommendation markRecommendationFailed(
        com.google.cloud.recommender.v1beta1.MarkRecommendationFailedRequest request) {
      return blockingUnaryCall(
          getChannel(), getMarkRecommendationFailedMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Provides insights and recommendations for cloud customers for various
   * categories like performance optimization, cost savings, reliability, feature
   * discovery, etc. Insights and recommendations are generated automatically
   * based on analysis of user resources, configuration and monitoring metrics.
   * </pre>
   */
  public static final class RecommenderFutureStub
      extends io.grpc.stub.AbstractFutureStub<RecommenderFutureStub> {
    private RecommenderFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecommenderFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecommenderFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists insights for a Cloud project. Requires the recommender.*.list IAM
     * permission for the specified insight type.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.recommender.v1beta1.ListInsightsResponse>
        listInsights(com.google.cloud.recommender.v1beta1.ListInsightsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListInsightsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the requested insight. Requires the recommender.*.get IAM permission
     * for the specified insight type.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.recommender.v1beta1.Insight>
        getInsight(com.google.cloud.recommender.v1beta1.GetInsightRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetInsightMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Marks the Insight State as Accepted. Users can use this method to
     * indicate to the Recommender API that they have applied some action based
     * on the insight. This stops the insight content from being updated.
     * MarkInsightAccepted can be applied to insights in ACTIVE state. Requires
     * the recommender.*.update IAM permission for the specified insight.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.recommender.v1beta1.Insight>
        markInsightAccepted(
            com.google.cloud.recommender.v1beta1.MarkInsightAcceptedRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getMarkInsightAcceptedMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists recommendations for a Cloud project. Requires the recommender.*.list
     * IAM permission for the specified recommender.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.recommender.v1beta1.ListRecommendationsResponse>
        listRecommendations(
            com.google.cloud.recommender.v1beta1.ListRecommendationsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListRecommendationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the requested recommendation. Requires the recommender.*.get
     * IAM permission for the specified recommender.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.recommender.v1beta1.Recommendation>
        getRecommendation(com.google.cloud.recommender.v1beta1.GetRecommendationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetRecommendationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Marks the Recommendation State as Claimed. Users can use this method to
     * indicate to the Recommender API that they are starting to apply the
     * recommendation themselves. This stops the recommendation content from being
     * updated. Associated insights are frozen and placed in the ACCEPTED state.
     * MarkRecommendationClaimed can be applied to recommendations in CLAIMED or
     * ACTIVE state.
     * Requires the recommender.*.update IAM permission for the specified
     * recommender.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.recommender.v1beta1.Recommendation>
        markRecommendationClaimed(
            com.google.cloud.recommender.v1beta1.MarkRecommendationClaimedRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getMarkRecommendationClaimedMethod(), getCallOptions()), request);
    }

    /**
     *
     *
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
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.recommender.v1beta1.Recommendation>
        markRecommendationSucceeded(
            com.google.cloud.recommender.v1beta1.MarkRecommendationSucceededRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getMarkRecommendationSucceededMethod(), getCallOptions()), request);
    }

    /**
     *
     *
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
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.recommender.v1beta1.Recommendation>
        markRecommendationFailed(
            com.google.cloud.recommender.v1beta1.MarkRecommendationFailedRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getMarkRecommendationFailedMethod(), getCallOptions()), request);
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

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
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
          serviceImpl.listInsights(
              (com.google.cloud.recommender.v1beta1.ListInsightsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.recommender.v1beta1.ListInsightsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_INSIGHT:
          serviceImpl.getInsight(
              (com.google.cloud.recommender.v1beta1.GetInsightRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1beta1.Insight>)
                  responseObserver);
          break;
        case METHODID_MARK_INSIGHT_ACCEPTED:
          serviceImpl.markInsightAccepted(
              (com.google.cloud.recommender.v1beta1.MarkInsightAcceptedRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1beta1.Insight>)
                  responseObserver);
          break;
        case METHODID_LIST_RECOMMENDATIONS:
          serviceImpl.listRecommendations(
              (com.google.cloud.recommender.v1beta1.ListRecommendationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.recommender.v1beta1.ListRecommendationsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_RECOMMENDATION:
          serviceImpl.getRecommendation(
              (com.google.cloud.recommender.v1beta1.GetRecommendationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1beta1.Recommendation>)
                  responseObserver);
          break;
        case METHODID_MARK_RECOMMENDATION_CLAIMED:
          serviceImpl.markRecommendationClaimed(
              (com.google.cloud.recommender.v1beta1.MarkRecommendationClaimedRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1beta1.Recommendation>)
                  responseObserver);
          break;
        case METHODID_MARK_RECOMMENDATION_SUCCEEDED:
          serviceImpl.markRecommendationSucceeded(
              (com.google.cloud.recommender.v1beta1.MarkRecommendationSucceededRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1beta1.Recommendation>)
                  responseObserver);
          break;
        case METHODID_MARK_RECOMMENDATION_FAILED:
          serviceImpl.markRecommendationFailed(
              (com.google.cloud.recommender.v1beta1.MarkRecommendationFailedRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.recommender.v1beta1.Recommendation>)
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

  private abstract static class RecommenderBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RecommenderBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.recommender.v1beta1.RecommenderProto.getDescriptor();
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
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new RecommenderFileDescriptorSupplier())
                      .addMethod(getListInsightsMethod())
                      .addMethod(getGetInsightMethod())
                      .addMethod(getMarkInsightAcceptedMethod())
                      .addMethod(getListRecommendationsMethod())
                      .addMethod(getGetRecommendationMethod())
                      .addMethod(getMarkRecommendationClaimedMethod())
                      .addMethod(getMarkRecommendationSucceededMethod())
                      .addMethod(getMarkRecommendationFailedMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
