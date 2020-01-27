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
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/recommender/v1beta1/recommender_service.proto")
public final class RecommenderGrpc {

  private RecommenderGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.recommender.v1beta1.Recommender";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListRecommendationsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.recommender.v1beta1.ListRecommendationsRequest,
          com.google.cloud.recommender.v1beta1.ListRecommendationsResponse>
      METHOD_LIST_RECOMMENDATIONS = getListRecommendationsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.recommender.v1beta1.ListRecommendationsRequest,
          com.google.cloud.recommender.v1beta1.ListRecommendationsResponse>
      getListRecommendationsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.recommender.v1beta1.ListRecommendationsRequest,
          com.google.cloud.recommender.v1beta1.ListRecommendationsResponse>
      getListRecommendationsMethod() {
    return getListRecommendationsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.recommender.v1beta1.ListRecommendationsRequest,
          com.google.cloud.recommender.v1beta1.ListRecommendationsResponse>
      getListRecommendationsMethodHelper() {
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
                          generateFullMethodName(
                              "google.cloud.recommender.v1beta1.Recommender",
                              "ListRecommendations"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetRecommendationMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.recommender.v1beta1.GetRecommendationRequest,
          com.google.cloud.recommender.v1beta1.Recommendation>
      METHOD_GET_RECOMMENDATION = getGetRecommendationMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.recommender.v1beta1.GetRecommendationRequest,
          com.google.cloud.recommender.v1beta1.Recommendation>
      getGetRecommendationMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.recommender.v1beta1.GetRecommendationRequest,
          com.google.cloud.recommender.v1beta1.Recommendation>
      getGetRecommendationMethod() {
    return getGetRecommendationMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.recommender.v1beta1.GetRecommendationRequest,
          com.google.cloud.recommender.v1beta1.Recommendation>
      getGetRecommendationMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.recommender.v1beta1.Recommender", "GetRecommendation"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getMarkRecommendationClaimedMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.recommender.v1beta1.MarkRecommendationClaimedRequest,
          com.google.cloud.recommender.v1beta1.Recommendation>
      METHOD_MARK_RECOMMENDATION_CLAIMED = getMarkRecommendationClaimedMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.recommender.v1beta1.MarkRecommendationClaimedRequest,
          com.google.cloud.recommender.v1beta1.Recommendation>
      getMarkRecommendationClaimedMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.recommender.v1beta1.MarkRecommendationClaimedRequest,
          com.google.cloud.recommender.v1beta1.Recommendation>
      getMarkRecommendationClaimedMethod() {
    return getMarkRecommendationClaimedMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.recommender.v1beta1.MarkRecommendationClaimedRequest,
          com.google.cloud.recommender.v1beta1.Recommendation>
      getMarkRecommendationClaimedMethodHelper() {
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
                          generateFullMethodName(
                              "google.cloud.recommender.v1beta1.Recommender",
                              "MarkRecommendationClaimed"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getMarkRecommendationSucceededMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.recommender.v1beta1.MarkRecommendationSucceededRequest,
          com.google.cloud.recommender.v1beta1.Recommendation>
      METHOD_MARK_RECOMMENDATION_SUCCEEDED = getMarkRecommendationSucceededMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.recommender.v1beta1.MarkRecommendationSucceededRequest,
          com.google.cloud.recommender.v1beta1.Recommendation>
      getMarkRecommendationSucceededMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.recommender.v1beta1.MarkRecommendationSucceededRequest,
          com.google.cloud.recommender.v1beta1.Recommendation>
      getMarkRecommendationSucceededMethod() {
    return getMarkRecommendationSucceededMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.recommender.v1beta1.MarkRecommendationSucceededRequest,
          com.google.cloud.recommender.v1beta1.Recommendation>
      getMarkRecommendationSucceededMethodHelper() {
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
                          generateFullMethodName(
                              "google.cloud.recommender.v1beta1.Recommender",
                              "MarkRecommendationSucceeded"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getMarkRecommendationFailedMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.recommender.v1beta1.MarkRecommendationFailedRequest,
          com.google.cloud.recommender.v1beta1.Recommendation>
      METHOD_MARK_RECOMMENDATION_FAILED = getMarkRecommendationFailedMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.recommender.v1beta1.MarkRecommendationFailedRequest,
          com.google.cloud.recommender.v1beta1.Recommendation>
      getMarkRecommendationFailedMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.recommender.v1beta1.MarkRecommendationFailedRequest,
          com.google.cloud.recommender.v1beta1.Recommendation>
      getMarkRecommendationFailedMethod() {
    return getMarkRecommendationFailedMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.recommender.v1beta1.MarkRecommendationFailedRequest,
          com.google.cloud.recommender.v1beta1.Recommendation>
      getMarkRecommendationFailedMethodHelper() {
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
                          generateFullMethodName(
                              "google.cloud.recommender.v1beta1.Recommender",
                              "MarkRecommendationFailed"))
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
    return new RecommenderStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RecommenderBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new RecommenderBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static RecommenderFutureStub newFutureStub(io.grpc.Channel channel) {
    return new RecommenderFutureStub(channel);
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
     * Lists recommendations for a Cloud project. Requires the recommender.*.list
     * IAM permission for the specified recommender.
     * </pre>
     */
    public void listRecommendations(
        com.google.cloud.recommender.v1beta1.ListRecommendationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.recommender.v1beta1.ListRecommendationsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListRecommendationsMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getGetRecommendationMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getMarkRecommendationClaimedMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getMarkRecommendationSucceededMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getMarkRecommendationFailedMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListRecommendationsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.recommender.v1beta1.ListRecommendationsRequest,
                      com.google.cloud.recommender.v1beta1.ListRecommendationsResponse>(
                      this, METHODID_LIST_RECOMMENDATIONS)))
          .addMethod(
              getGetRecommendationMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.recommender.v1beta1.GetRecommendationRequest,
                      com.google.cloud.recommender.v1beta1.Recommendation>(
                      this, METHODID_GET_RECOMMENDATION)))
          .addMethod(
              getMarkRecommendationClaimedMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.recommender.v1beta1.MarkRecommendationClaimedRequest,
                      com.google.cloud.recommender.v1beta1.Recommendation>(
                      this, METHODID_MARK_RECOMMENDATION_CLAIMED)))
          .addMethod(
              getMarkRecommendationSucceededMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.recommender.v1beta1.MarkRecommendationSucceededRequest,
                      com.google.cloud.recommender.v1beta1.Recommendation>(
                      this, METHODID_MARK_RECOMMENDATION_SUCCEEDED)))
          .addMethod(
              getMarkRecommendationFailedMethodHelper(),
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
  public static final class RecommenderStub extends io.grpc.stub.AbstractStub<RecommenderStub> {
    private RecommenderStub(io.grpc.Channel channel) {
      super(channel);
    }

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
          getChannel().newCall(getListRecommendationsMethodHelper(), getCallOptions()),
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
          getChannel().newCall(getGetRecommendationMethodHelper(), getCallOptions()),
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
          getChannel().newCall(getMarkRecommendationClaimedMethodHelper(), getCallOptions()),
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
          getChannel().newCall(getMarkRecommendationSucceededMethodHelper(), getCallOptions()),
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
          getChannel().newCall(getMarkRecommendationFailedMethodHelper(), getCallOptions()),
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
      extends io.grpc.stub.AbstractStub<RecommenderBlockingStub> {
    private RecommenderBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

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
     * Lists recommendations for a Cloud project. Requires the recommender.*.list
     * IAM permission for the specified recommender.
     * </pre>
     */
    public com.google.cloud.recommender.v1beta1.ListRecommendationsResponse listRecommendations(
        com.google.cloud.recommender.v1beta1.ListRecommendationsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListRecommendationsMethodHelper(), getCallOptions(), request);
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
          getChannel(), getGetRecommendationMethodHelper(), getCallOptions(), request);
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
          getChannel(), getMarkRecommendationClaimedMethodHelper(), getCallOptions(), request);
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
          getChannel(), getMarkRecommendationSucceededMethodHelper(), getCallOptions(), request);
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
          getChannel(), getMarkRecommendationFailedMethodHelper(), getCallOptions(), request);
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
      extends io.grpc.stub.AbstractStub<RecommenderFutureStub> {
    private RecommenderFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

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
     * Lists recommendations for a Cloud project. Requires the recommender.*.list
     * IAM permission for the specified recommender.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.recommender.v1beta1.ListRecommendationsResponse>
        listRecommendations(
            com.google.cloud.recommender.v1beta1.ListRecommendationsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListRecommendationsMethodHelper(), getCallOptions()), request);
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
          getChannel().newCall(getGetRecommendationMethodHelper(), getCallOptions()), request);
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
          getChannel().newCall(getMarkRecommendationClaimedMethodHelper(), getCallOptions()),
          request);
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
          getChannel().newCall(getMarkRecommendationSucceededMethodHelper(), getCallOptions()),
          request);
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
          getChannel().newCall(getMarkRecommendationFailedMethodHelper(), getCallOptions()),
          request);
    }
  }

  private static final int METHODID_LIST_RECOMMENDATIONS = 0;
  private static final int METHODID_GET_RECOMMENDATION = 1;
  private static final int METHODID_MARK_RECOMMENDATION_CLAIMED = 2;
  private static final int METHODID_MARK_RECOMMENDATION_SUCCEEDED = 3;
  private static final int METHODID_MARK_RECOMMENDATION_FAILED = 4;

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
                      .addMethod(getListRecommendationsMethodHelper())
                      .addMethod(getGetRecommendationMethodHelper())
                      .addMethod(getMarkRecommendationClaimedMethodHelper())
                      .addMethod(getMarkRecommendationSucceededMethodHelper())
                      .addMethod(getMarkRecommendationFailedMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
