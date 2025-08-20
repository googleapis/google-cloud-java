/*
 * Copyright 2025 Google LLC
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
package com.google.cloud.geminidataanalytics.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service to ask a natural language question with a provided project,
 * returns BigQuery tables that are relevant to the question within the project
 * scope that is accessible to the user, along with contextual data including
 * table schema information as well as sample values.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/geminidataanalytics/v1beta/context_retrieval_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ContextRetrievalServiceGrpc {

  private ContextRetrievalServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.geminidataanalytics.v1beta.ContextRetrievalService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextRequest,
          com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextResponse>
      getRetrieveBigQueryTableContextMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RetrieveBigQueryTableContext",
      requestType =
          com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextRequest.class,
      responseType =
          com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextRequest,
          com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextResponse>
      getRetrieveBigQueryTableContextMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextRequest,
            com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextResponse>
        getRetrieveBigQueryTableContextMethod;
    if ((getRetrieveBigQueryTableContextMethod =
            ContextRetrievalServiceGrpc.getRetrieveBigQueryTableContextMethod)
        == null) {
      synchronized (ContextRetrievalServiceGrpc.class) {
        if ((getRetrieveBigQueryTableContextMethod =
                ContextRetrievalServiceGrpc.getRetrieveBigQueryTableContextMethod)
            == null) {
          ContextRetrievalServiceGrpc.getRetrieveBigQueryTableContextMethod =
              getRetrieveBigQueryTableContextMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.geminidataanalytics.v1beta
                              .RetrieveBigQueryTableContextRequest,
                          com.google.cloud.geminidataanalytics.v1beta
                              .RetrieveBigQueryTableContextResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RetrieveBigQueryTableContext"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.geminidataanalytics.v1beta
                                  .RetrieveBigQueryTableContextRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.geminidataanalytics.v1beta
                                  .RetrieveBigQueryTableContextResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContextRetrievalServiceMethodDescriptorSupplier(
                              "RetrieveBigQueryTableContext"))
                      .build();
        }
      }
    }
    return getRetrieveBigQueryTableContextMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextsRequest,
          com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextsResponse>
      getRetrieveBigQueryTableContextsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RetrieveBigQueryTableContexts",
      requestType =
          com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextsRequest.class,
      responseType =
          com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextsRequest,
          com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextsResponse>
      getRetrieveBigQueryTableContextsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextsRequest,
            com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextsResponse>
        getRetrieveBigQueryTableContextsMethod;
    if ((getRetrieveBigQueryTableContextsMethod =
            ContextRetrievalServiceGrpc.getRetrieveBigQueryTableContextsMethod)
        == null) {
      synchronized (ContextRetrievalServiceGrpc.class) {
        if ((getRetrieveBigQueryTableContextsMethod =
                ContextRetrievalServiceGrpc.getRetrieveBigQueryTableContextsMethod)
            == null) {
          ContextRetrievalServiceGrpc.getRetrieveBigQueryTableContextsMethod =
              getRetrieveBigQueryTableContextsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.geminidataanalytics.v1beta
                              .RetrieveBigQueryTableContextsRequest,
                          com.google.cloud.geminidataanalytics.v1beta
                              .RetrieveBigQueryTableContextsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RetrieveBigQueryTableContexts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.geminidataanalytics.v1beta
                                  .RetrieveBigQueryTableContextsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.geminidataanalytics.v1beta
                                  .RetrieveBigQueryTableContextsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContextRetrievalServiceMethodDescriptorSupplier(
                              "RetrieveBigQueryTableContexts"))
                      .build();
        }
      }
    }
    return getRetrieveBigQueryTableContextsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta
              .RetrieveBigQueryTableContextsFromRecentTablesRequest,
          com.google.cloud.geminidataanalytics.v1beta
              .RetrieveBigQueryTableContextsFromRecentTablesResponse>
      getRetrieveBigQueryTableContextsFromRecentTablesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RetrieveBigQueryTableContextsFromRecentTables",
      requestType =
          com.google.cloud.geminidataanalytics.v1beta
              .RetrieveBigQueryTableContextsFromRecentTablesRequest.class,
      responseType =
          com.google.cloud.geminidataanalytics.v1beta
              .RetrieveBigQueryTableContextsFromRecentTablesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta
              .RetrieveBigQueryTableContextsFromRecentTablesRequest,
          com.google.cloud.geminidataanalytics.v1beta
              .RetrieveBigQueryTableContextsFromRecentTablesResponse>
      getRetrieveBigQueryTableContextsFromRecentTablesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.geminidataanalytics.v1beta
                .RetrieveBigQueryTableContextsFromRecentTablesRequest,
            com.google.cloud.geminidataanalytics.v1beta
                .RetrieveBigQueryTableContextsFromRecentTablesResponse>
        getRetrieveBigQueryTableContextsFromRecentTablesMethod;
    if ((getRetrieveBigQueryTableContextsFromRecentTablesMethod =
            ContextRetrievalServiceGrpc.getRetrieveBigQueryTableContextsFromRecentTablesMethod)
        == null) {
      synchronized (ContextRetrievalServiceGrpc.class) {
        if ((getRetrieveBigQueryTableContextsFromRecentTablesMethod =
                ContextRetrievalServiceGrpc.getRetrieveBigQueryTableContextsFromRecentTablesMethod)
            == null) {
          ContextRetrievalServiceGrpc.getRetrieveBigQueryTableContextsFromRecentTablesMethod =
              getRetrieveBigQueryTableContextsFromRecentTablesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.geminidataanalytics.v1beta
                              .RetrieveBigQueryTableContextsFromRecentTablesRequest,
                          com.google.cloud.geminidataanalytics.v1beta
                              .RetrieveBigQueryTableContextsFromRecentTablesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "RetrieveBigQueryTableContextsFromRecentTables"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.geminidataanalytics.v1beta
                                  .RetrieveBigQueryTableContextsFromRecentTablesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.geminidataanalytics.v1beta
                                  .RetrieveBigQueryTableContextsFromRecentTablesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContextRetrievalServiceMethodDescriptorSupplier(
                              "RetrieveBigQueryTableContextsFromRecentTables"))
                      .build();
        }
      }
    }
    return getRetrieveBigQueryTableContextsFromRecentTablesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta
              .RetrieveBigQueryTableSuggestedDescriptionsRequest,
          com.google.cloud.geminidataanalytics.v1beta
              .RetrieveBigQueryTableSuggestedDescriptionsResponse>
      getRetrieveBigQueryTableSuggestedDescriptionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RetrieveBigQueryTableSuggestedDescriptions",
      requestType =
          com.google.cloud.geminidataanalytics.v1beta
              .RetrieveBigQueryTableSuggestedDescriptionsRequest.class,
      responseType =
          com.google.cloud.geminidataanalytics.v1beta
              .RetrieveBigQueryTableSuggestedDescriptionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta
              .RetrieveBigQueryTableSuggestedDescriptionsRequest,
          com.google.cloud.geminidataanalytics.v1beta
              .RetrieveBigQueryTableSuggestedDescriptionsResponse>
      getRetrieveBigQueryTableSuggestedDescriptionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.geminidataanalytics.v1beta
                .RetrieveBigQueryTableSuggestedDescriptionsRequest,
            com.google.cloud.geminidataanalytics.v1beta
                .RetrieveBigQueryTableSuggestedDescriptionsResponse>
        getRetrieveBigQueryTableSuggestedDescriptionsMethod;
    if ((getRetrieveBigQueryTableSuggestedDescriptionsMethod =
            ContextRetrievalServiceGrpc.getRetrieveBigQueryTableSuggestedDescriptionsMethod)
        == null) {
      synchronized (ContextRetrievalServiceGrpc.class) {
        if ((getRetrieveBigQueryTableSuggestedDescriptionsMethod =
                ContextRetrievalServiceGrpc.getRetrieveBigQueryTableSuggestedDescriptionsMethod)
            == null) {
          ContextRetrievalServiceGrpc.getRetrieveBigQueryTableSuggestedDescriptionsMethod =
              getRetrieveBigQueryTableSuggestedDescriptionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.geminidataanalytics.v1beta
                              .RetrieveBigQueryTableSuggestedDescriptionsRequest,
                          com.google.cloud.geminidataanalytics.v1beta
                              .RetrieveBigQueryTableSuggestedDescriptionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "RetrieveBigQueryTableSuggestedDescriptions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.geminidataanalytics.v1beta
                                  .RetrieveBigQueryTableSuggestedDescriptionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.geminidataanalytics.v1beta
                                  .RetrieveBigQueryTableSuggestedDescriptionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContextRetrievalServiceMethodDescriptorSupplier(
                              "RetrieveBigQueryTableSuggestedDescriptions"))
                      .build();
        }
      }
    }
    return getRetrieveBigQueryTableSuggestedDescriptionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableSuggestedExamplesRequest,
          com.google.cloud.geminidataanalytics.v1beta
              .RetrieveBigQueryTableSuggestedExamplesResponse>
      getRetrieveBigQueryTableSuggestedExamplesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RetrieveBigQueryTableSuggestedExamples",
      requestType =
          com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableSuggestedExamplesRequest
              .class,
      responseType =
          com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableSuggestedExamplesResponse
              .class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableSuggestedExamplesRequest,
          com.google.cloud.geminidataanalytics.v1beta
              .RetrieveBigQueryTableSuggestedExamplesResponse>
      getRetrieveBigQueryTableSuggestedExamplesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.geminidataanalytics.v1beta
                .RetrieveBigQueryTableSuggestedExamplesRequest,
            com.google.cloud.geminidataanalytics.v1beta
                .RetrieveBigQueryTableSuggestedExamplesResponse>
        getRetrieveBigQueryTableSuggestedExamplesMethod;
    if ((getRetrieveBigQueryTableSuggestedExamplesMethod =
            ContextRetrievalServiceGrpc.getRetrieveBigQueryTableSuggestedExamplesMethod)
        == null) {
      synchronized (ContextRetrievalServiceGrpc.class) {
        if ((getRetrieveBigQueryTableSuggestedExamplesMethod =
                ContextRetrievalServiceGrpc.getRetrieveBigQueryTableSuggestedExamplesMethod)
            == null) {
          ContextRetrievalServiceGrpc.getRetrieveBigQueryTableSuggestedExamplesMethod =
              getRetrieveBigQueryTableSuggestedExamplesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.geminidataanalytics.v1beta
                              .RetrieveBigQueryTableSuggestedExamplesRequest,
                          com.google.cloud.geminidataanalytics.v1beta
                              .RetrieveBigQueryTableSuggestedExamplesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "RetrieveBigQueryTableSuggestedExamples"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.geminidataanalytics.v1beta
                                  .RetrieveBigQueryTableSuggestedExamplesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.geminidataanalytics.v1beta
                                  .RetrieveBigQueryTableSuggestedExamplesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContextRetrievalServiceMethodDescriptorSupplier(
                              "RetrieveBigQueryTableSuggestedExamples"))
                      .build();
        }
      }
    }
    return getRetrieveBigQueryTableSuggestedExamplesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryRecentRelevantTablesRequest,
          com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryRecentRelevantTablesResponse>
      getRetrieveBigQueryRecentRelevantTablesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RetrieveBigQueryRecentRelevantTables",
      requestType =
          com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryRecentRelevantTablesRequest
              .class,
      responseType =
          com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryRecentRelevantTablesResponse
              .class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryRecentRelevantTablesRequest,
          com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryRecentRelevantTablesResponse>
      getRetrieveBigQueryRecentRelevantTablesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryRecentRelevantTablesRequest,
            com.google.cloud.geminidataanalytics.v1beta
                .RetrieveBigQueryRecentRelevantTablesResponse>
        getRetrieveBigQueryRecentRelevantTablesMethod;
    if ((getRetrieveBigQueryRecentRelevantTablesMethod =
            ContextRetrievalServiceGrpc.getRetrieveBigQueryRecentRelevantTablesMethod)
        == null) {
      synchronized (ContextRetrievalServiceGrpc.class) {
        if ((getRetrieveBigQueryRecentRelevantTablesMethod =
                ContextRetrievalServiceGrpc.getRetrieveBigQueryRecentRelevantTablesMethod)
            == null) {
          ContextRetrievalServiceGrpc.getRetrieveBigQueryRecentRelevantTablesMethod =
              getRetrieveBigQueryRecentRelevantTablesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.geminidataanalytics.v1beta
                              .RetrieveBigQueryRecentRelevantTablesRequest,
                          com.google.cloud.geminidataanalytics.v1beta
                              .RetrieveBigQueryRecentRelevantTablesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "RetrieveBigQueryRecentRelevantTables"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.geminidataanalytics.v1beta
                                  .RetrieveBigQueryRecentRelevantTablesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.geminidataanalytics.v1beta
                                  .RetrieveBigQueryRecentRelevantTablesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContextRetrievalServiceMethodDescriptorSupplier(
                              "RetrieveBigQueryRecentRelevantTables"))
                      .build();
        }
      }
    }
    return getRetrieveBigQueryRecentRelevantTablesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ContextRetrievalServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ContextRetrievalServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ContextRetrievalServiceStub>() {
          @java.lang.Override
          public ContextRetrievalServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ContextRetrievalServiceStub(channel, callOptions);
          }
        };
    return ContextRetrievalServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static ContextRetrievalServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ContextRetrievalServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ContextRetrievalServiceBlockingV2Stub>() {
          @java.lang.Override
          public ContextRetrievalServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ContextRetrievalServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return ContextRetrievalServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ContextRetrievalServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ContextRetrievalServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ContextRetrievalServiceBlockingStub>() {
          @java.lang.Override
          public ContextRetrievalServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ContextRetrievalServiceBlockingStub(channel, callOptions);
          }
        };
    return ContextRetrievalServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ContextRetrievalServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ContextRetrievalServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ContextRetrievalServiceFutureStub>() {
          @java.lang.Override
          public ContextRetrievalServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ContextRetrievalServiceFutureStub(channel, callOptions);
          }
        };
    return ContextRetrievalServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to ask a natural language question with a provided project,
   * returns BigQuery tables that are relevant to the question within the project
   * scope that is accessible to the user, along with contextual data including
   * table schema information as well as sample values.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Retrieves BigQuery table contextual data for provided table references.
     * Contextual data includes table schema information as well as sample
     * values.
     * </pre>
     */
    default void retrieveBigQueryTableContext(
        com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRetrieveBigQueryTableContextMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves BigQuery table contextual data for provided table references.
     * Contextual data includes table schema information as well as sample
     * values.
     * </pre>
     */
    default void retrieveBigQueryTableContexts(
        com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRetrieveBigQueryTableContextsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves BigQuery table contextual data from recently accessed tables.
     * Contextual data includes table schema information as well as sample
     * values.
     * </pre>
     */
    default void retrieveBigQueryTableContextsFromRecentTables(
        com.google.cloud.geminidataanalytics.v1beta
                .RetrieveBigQueryTableContextsFromRecentTablesRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.geminidataanalytics.v1beta
                    .RetrieveBigQueryTableContextsFromRecentTablesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRetrieveBigQueryTableContextsFromRecentTablesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves BigQuery table schema with suggested table and column
     * descriptions.
     * </pre>
     */
    default void retrieveBigQueryTableSuggestedDescriptions(
        com.google.cloud.geminidataanalytics.v1beta
                .RetrieveBigQueryTableSuggestedDescriptionsRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.geminidataanalytics.v1beta
                    .RetrieveBigQueryTableSuggestedDescriptionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRetrieveBigQueryTableSuggestedDescriptionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves BigQuery table schema with suggested NL-SQL examples.
     * </pre>
     */
    default void retrieveBigQueryTableSuggestedExamples(
        com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableSuggestedExamplesRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.geminidataanalytics.v1beta
                    .RetrieveBigQueryTableSuggestedExamplesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRetrieveBigQueryTableSuggestedExamplesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves BigQuery table references from recently accessed tables.
     * </pre>
     */
    default void retrieveBigQueryRecentRelevantTables(
        com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryRecentRelevantTablesRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.geminidataanalytics.v1beta
                    .RetrieveBigQueryRecentRelevantTablesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRetrieveBigQueryRecentRelevantTablesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ContextRetrievalService.
   *
   * <pre>
   * Service to ask a natural language question with a provided project,
   * returns BigQuery tables that are relevant to the question within the project
   * scope that is accessible to the user, along with contextual data including
   * table schema information as well as sample values.
   * </pre>
   */
  public abstract static class ContextRetrievalServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ContextRetrievalServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ContextRetrievalService.
   *
   * <pre>
   * Service to ask a natural language question with a provided project,
   * returns BigQuery tables that are relevant to the question within the project
   * scope that is accessible to the user, along with contextual data including
   * table schema information as well as sample values.
   * </pre>
   */
  public static final class ContextRetrievalServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ContextRetrievalServiceStub> {
    private ContextRetrievalServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContextRetrievalServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ContextRetrievalServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves BigQuery table contextual data for provided table references.
     * Contextual data includes table schema information as well as sample
     * values.
     * </pre>
     */
    public void retrieveBigQueryTableContext(
        com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRetrieveBigQueryTableContextMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves BigQuery table contextual data for provided table references.
     * Contextual data includes table schema information as well as sample
     * values.
     * </pre>
     */
    public void retrieveBigQueryTableContexts(
        com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRetrieveBigQueryTableContextsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves BigQuery table contextual data from recently accessed tables.
     * Contextual data includes table schema information as well as sample
     * values.
     * </pre>
     */
    public void retrieveBigQueryTableContextsFromRecentTables(
        com.google.cloud.geminidataanalytics.v1beta
                .RetrieveBigQueryTableContextsFromRecentTablesRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.geminidataanalytics.v1beta
                    .RetrieveBigQueryTableContextsFromRecentTablesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel()
              .newCall(getRetrieveBigQueryTableContextsFromRecentTablesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves BigQuery table schema with suggested table and column
     * descriptions.
     * </pre>
     */
    public void retrieveBigQueryTableSuggestedDescriptions(
        com.google.cloud.geminidataanalytics.v1beta
                .RetrieveBigQueryTableSuggestedDescriptionsRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.geminidataanalytics.v1beta
                    .RetrieveBigQueryTableSuggestedDescriptionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel()
              .newCall(getRetrieveBigQueryTableSuggestedDescriptionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves BigQuery table schema with suggested NL-SQL examples.
     * </pre>
     */
    public void retrieveBigQueryTableSuggestedExamples(
        com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableSuggestedExamplesRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.geminidataanalytics.v1beta
                    .RetrieveBigQueryTableSuggestedExamplesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRetrieveBigQueryTableSuggestedExamplesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves BigQuery table references from recently accessed tables.
     * </pre>
     */
    public void retrieveBigQueryRecentRelevantTables(
        com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryRecentRelevantTablesRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.geminidataanalytics.v1beta
                    .RetrieveBigQueryRecentRelevantTablesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRetrieveBigQueryRecentRelevantTablesMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ContextRetrievalService.
   *
   * <pre>
   * Service to ask a natural language question with a provided project,
   * returns BigQuery tables that are relevant to the question within the project
   * scope that is accessible to the user, along with contextual data including
   * table schema information as well as sample values.
   * </pre>
   */
  public static final class ContextRetrievalServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<ContextRetrievalServiceBlockingV2Stub> {
    private ContextRetrievalServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContextRetrievalServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ContextRetrievalServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves BigQuery table contextual data for provided table references.
     * Contextual data includes table schema information as well as sample
     * values.
     * </pre>
     */
    public com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextResponse
        retrieveBigQueryTableContext(
            com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRetrieveBigQueryTableContextMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves BigQuery table contextual data for provided table references.
     * Contextual data includes table schema information as well as sample
     * values.
     * </pre>
     */
    public com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextsResponse
        retrieveBigQueryTableContexts(
            com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextsRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRetrieveBigQueryTableContextsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves BigQuery table contextual data from recently accessed tables.
     * Contextual data includes table schema information as well as sample
     * values.
     * </pre>
     */
    public com.google.cloud.geminidataanalytics.v1beta
            .RetrieveBigQueryTableContextsFromRecentTablesResponse
        retrieveBigQueryTableContextsFromRecentTables(
            com.google.cloud.geminidataanalytics.v1beta
                    .RetrieveBigQueryTableContextsFromRecentTablesRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getRetrieveBigQueryTableContextsFromRecentTablesMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves BigQuery table schema with suggested table and column
     * descriptions.
     * </pre>
     */
    public com.google.cloud.geminidataanalytics.v1beta
            .RetrieveBigQueryTableSuggestedDescriptionsResponse
        retrieveBigQueryTableSuggestedDescriptions(
            com.google.cloud.geminidataanalytics.v1beta
                    .RetrieveBigQueryTableSuggestedDescriptionsRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getRetrieveBigQueryTableSuggestedDescriptionsMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves BigQuery table schema with suggested NL-SQL examples.
     * </pre>
     */
    public com.google.cloud.geminidataanalytics.v1beta
            .RetrieveBigQueryTableSuggestedExamplesResponse
        retrieveBigQueryTableSuggestedExamples(
            com.google.cloud.geminidataanalytics.v1beta
                    .RetrieveBigQueryTableSuggestedExamplesRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getRetrieveBigQueryTableSuggestedExamplesMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves BigQuery table references from recently accessed tables.
     * </pre>
     */
    public com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryRecentRelevantTablesResponse
        retrieveBigQueryRecentRelevantTables(
            com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryRecentRelevantTablesRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRetrieveBigQueryRecentRelevantTablesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service ContextRetrievalService.
   *
   * <pre>
   * Service to ask a natural language question with a provided project,
   * returns BigQuery tables that are relevant to the question within the project
   * scope that is accessible to the user, along with contextual data including
   * table schema information as well as sample values.
   * </pre>
   */
  public static final class ContextRetrievalServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ContextRetrievalServiceBlockingStub> {
    private ContextRetrievalServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContextRetrievalServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ContextRetrievalServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves BigQuery table contextual data for provided table references.
     * Contextual data includes table schema information as well as sample
     * values.
     * </pre>
     */
    public com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextResponse
        retrieveBigQueryTableContext(
            com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRetrieveBigQueryTableContextMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves BigQuery table contextual data for provided table references.
     * Contextual data includes table schema information as well as sample
     * values.
     * </pre>
     */
    public com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextsResponse
        retrieveBigQueryTableContexts(
            com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextsRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRetrieveBigQueryTableContextsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves BigQuery table contextual data from recently accessed tables.
     * Contextual data includes table schema information as well as sample
     * values.
     * </pre>
     */
    public com.google.cloud.geminidataanalytics.v1beta
            .RetrieveBigQueryTableContextsFromRecentTablesResponse
        retrieveBigQueryTableContextsFromRecentTables(
            com.google.cloud.geminidataanalytics.v1beta
                    .RetrieveBigQueryTableContextsFromRecentTablesRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getRetrieveBigQueryTableContextsFromRecentTablesMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves BigQuery table schema with suggested table and column
     * descriptions.
     * </pre>
     */
    public com.google.cloud.geminidataanalytics.v1beta
            .RetrieveBigQueryTableSuggestedDescriptionsResponse
        retrieveBigQueryTableSuggestedDescriptions(
            com.google.cloud.geminidataanalytics.v1beta
                    .RetrieveBigQueryTableSuggestedDescriptionsRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getRetrieveBigQueryTableSuggestedDescriptionsMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves BigQuery table schema with suggested NL-SQL examples.
     * </pre>
     */
    public com.google.cloud.geminidataanalytics.v1beta
            .RetrieveBigQueryTableSuggestedExamplesResponse
        retrieveBigQueryTableSuggestedExamples(
            com.google.cloud.geminidataanalytics.v1beta
                    .RetrieveBigQueryTableSuggestedExamplesRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getRetrieveBigQueryTableSuggestedExamplesMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves BigQuery table references from recently accessed tables.
     * </pre>
     */
    public com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryRecentRelevantTablesResponse
        retrieveBigQueryRecentRelevantTables(
            com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryRecentRelevantTablesRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRetrieveBigQueryRecentRelevantTablesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * ContextRetrievalService.
   *
   * <pre>
   * Service to ask a natural language question with a provided project,
   * returns BigQuery tables that are relevant to the question within the project
   * scope that is accessible to the user, along with contextual data including
   * table schema information as well as sample values.
   * </pre>
   */
  public static final class ContextRetrievalServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ContextRetrievalServiceFutureStub> {
    private ContextRetrievalServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContextRetrievalServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ContextRetrievalServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves BigQuery table contextual data for provided table references.
     * Contextual data includes table schema information as well as sample
     * values.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextResponse>
        retrieveBigQueryTableContext(
            com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRetrieveBigQueryTableContextMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves BigQuery table contextual data for provided table references.
     * Contextual data includes table schema information as well as sample
     * values.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextsResponse>
        retrieveBigQueryTableContexts(
            com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextsRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRetrieveBigQueryTableContextsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves BigQuery table contextual data from recently accessed tables.
     * Contextual data includes table schema information as well as sample
     * values.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.geminidataanalytics.v1beta
                .RetrieveBigQueryTableContextsFromRecentTablesResponse>
        retrieveBigQueryTableContextsFromRecentTables(
            com.google.cloud.geminidataanalytics.v1beta
                    .RetrieveBigQueryTableContextsFromRecentTablesRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel()
              .newCall(getRetrieveBigQueryTableContextsFromRecentTablesMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves BigQuery table schema with suggested table and column
     * descriptions.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.geminidataanalytics.v1beta
                .RetrieveBigQueryTableSuggestedDescriptionsResponse>
        retrieveBigQueryTableSuggestedDescriptions(
            com.google.cloud.geminidataanalytics.v1beta
                    .RetrieveBigQueryTableSuggestedDescriptionsRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel()
              .newCall(getRetrieveBigQueryTableSuggestedDescriptionsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves BigQuery table schema with suggested NL-SQL examples.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.geminidataanalytics.v1beta
                .RetrieveBigQueryTableSuggestedExamplesResponse>
        retrieveBigQueryTableSuggestedExamples(
            com.google.cloud.geminidataanalytics.v1beta
                    .RetrieveBigQueryTableSuggestedExamplesRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRetrieveBigQueryTableSuggestedExamplesMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves BigQuery table references from recently accessed tables.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.geminidataanalytics.v1beta
                .RetrieveBigQueryRecentRelevantTablesResponse>
        retrieveBigQueryRecentRelevantTables(
            com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryRecentRelevantTablesRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRetrieveBigQueryRecentRelevantTablesMethod(), getCallOptions()),
          request);
    }
  }

  private static final int METHODID_RETRIEVE_BIG_QUERY_TABLE_CONTEXT = 0;
  private static final int METHODID_RETRIEVE_BIG_QUERY_TABLE_CONTEXTS = 1;
  private static final int METHODID_RETRIEVE_BIG_QUERY_TABLE_CONTEXTS_FROM_RECENT_TABLES = 2;
  private static final int METHODID_RETRIEVE_BIG_QUERY_TABLE_SUGGESTED_DESCRIPTIONS = 3;
  private static final int METHODID_RETRIEVE_BIG_QUERY_TABLE_SUGGESTED_EXAMPLES = 4;
  private static final int METHODID_RETRIEVE_BIG_QUERY_RECENT_RELEVANT_TABLES = 5;

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
        case METHODID_RETRIEVE_BIG_QUERY_TABLE_CONTEXT:
          serviceImpl.retrieveBigQueryTableContext(
              (com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.geminidataanalytics.v1beta
                          .RetrieveBigQueryTableContextResponse>)
                  responseObserver);
          break;
        case METHODID_RETRIEVE_BIG_QUERY_TABLE_CONTEXTS:
          serviceImpl.retrieveBigQueryTableContexts(
              (com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextsRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.geminidataanalytics.v1beta
                          .RetrieveBigQueryTableContextsResponse>)
                  responseObserver);
          break;
        case METHODID_RETRIEVE_BIG_QUERY_TABLE_CONTEXTS_FROM_RECENT_TABLES:
          serviceImpl.retrieveBigQueryTableContextsFromRecentTables(
              (com.google.cloud.geminidataanalytics.v1beta
                      .RetrieveBigQueryTableContextsFromRecentTablesRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.geminidataanalytics.v1beta
                          .RetrieveBigQueryTableContextsFromRecentTablesResponse>)
                  responseObserver);
          break;
        case METHODID_RETRIEVE_BIG_QUERY_TABLE_SUGGESTED_DESCRIPTIONS:
          serviceImpl.retrieveBigQueryTableSuggestedDescriptions(
              (com.google.cloud.geminidataanalytics.v1beta
                      .RetrieveBigQueryTableSuggestedDescriptionsRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.geminidataanalytics.v1beta
                          .RetrieveBigQueryTableSuggestedDescriptionsResponse>)
                  responseObserver);
          break;
        case METHODID_RETRIEVE_BIG_QUERY_TABLE_SUGGESTED_EXAMPLES:
          serviceImpl.retrieveBigQueryTableSuggestedExamples(
              (com.google.cloud.geminidataanalytics.v1beta
                      .RetrieveBigQueryTableSuggestedExamplesRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.geminidataanalytics.v1beta
                          .RetrieveBigQueryTableSuggestedExamplesResponse>)
                  responseObserver);
          break;
        case METHODID_RETRIEVE_BIG_QUERY_RECENT_RELEVANT_TABLES:
          serviceImpl.retrieveBigQueryRecentRelevantTables(
              (com.google.cloud.geminidataanalytics.v1beta
                      .RetrieveBigQueryRecentRelevantTablesRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.geminidataanalytics.v1beta
                          .RetrieveBigQueryRecentRelevantTablesResponse>)
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
            getRetrieveBigQueryTableContextMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextRequest,
                    com.google.cloud.geminidataanalytics.v1beta
                        .RetrieveBigQueryTableContextResponse>(
                    service, METHODID_RETRIEVE_BIG_QUERY_TABLE_CONTEXT)))
        .addMethod(
            getRetrieveBigQueryTableContextsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.geminidataanalytics.v1beta
                        .RetrieveBigQueryTableContextsRequest,
                    com.google.cloud.geminidataanalytics.v1beta
                        .RetrieveBigQueryTableContextsResponse>(
                    service, METHODID_RETRIEVE_BIG_QUERY_TABLE_CONTEXTS)))
        .addMethod(
            getRetrieveBigQueryTableContextsFromRecentTablesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.geminidataanalytics.v1beta
                        .RetrieveBigQueryTableContextsFromRecentTablesRequest,
                    com.google.cloud.geminidataanalytics.v1beta
                        .RetrieveBigQueryTableContextsFromRecentTablesResponse>(
                    service, METHODID_RETRIEVE_BIG_QUERY_TABLE_CONTEXTS_FROM_RECENT_TABLES)))
        .addMethod(
            getRetrieveBigQueryTableSuggestedDescriptionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.geminidataanalytics.v1beta
                        .RetrieveBigQueryTableSuggestedDescriptionsRequest,
                    com.google.cloud.geminidataanalytics.v1beta
                        .RetrieveBigQueryTableSuggestedDescriptionsResponse>(
                    service, METHODID_RETRIEVE_BIG_QUERY_TABLE_SUGGESTED_DESCRIPTIONS)))
        .addMethod(
            getRetrieveBigQueryTableSuggestedExamplesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.geminidataanalytics.v1beta
                        .RetrieveBigQueryTableSuggestedExamplesRequest,
                    com.google.cloud.geminidataanalytics.v1beta
                        .RetrieveBigQueryTableSuggestedExamplesResponse>(
                    service, METHODID_RETRIEVE_BIG_QUERY_TABLE_SUGGESTED_EXAMPLES)))
        .addMethod(
            getRetrieveBigQueryRecentRelevantTablesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.geminidataanalytics.v1beta
                        .RetrieveBigQueryRecentRelevantTablesRequest,
                    com.google.cloud.geminidataanalytics.v1beta
                        .RetrieveBigQueryRecentRelevantTablesResponse>(
                    service, METHODID_RETRIEVE_BIG_QUERY_RECENT_RELEVANT_TABLES)))
        .build();
  }

  private abstract static class ContextRetrievalServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ContextRetrievalServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.geminidataanalytics.v1beta.ContextRetrievalServiceProto
          .getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ContextRetrievalService");
    }
  }

  private static final class ContextRetrievalServiceFileDescriptorSupplier
      extends ContextRetrievalServiceBaseDescriptorSupplier {
    ContextRetrievalServiceFileDescriptorSupplier() {}
  }

  private static final class ContextRetrievalServiceMethodDescriptorSupplier
      extends ContextRetrievalServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ContextRetrievalServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ContextRetrievalServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ContextRetrievalServiceFileDescriptorSupplier())
                      .addMethod(getRetrieveBigQueryTableContextMethod())
                      .addMethod(getRetrieveBigQueryTableContextsMethod())
                      .addMethod(getRetrieveBigQueryTableContextsFromRecentTablesMethod())
                      .addMethod(getRetrieveBigQueryTableSuggestedDescriptionsMethod())
                      .addMethod(getRetrieveBigQueryTableSuggestedExamplesMethod())
                      .addMethod(getRetrieveBigQueryRecentRelevantTablesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
