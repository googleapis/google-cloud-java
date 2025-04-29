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
package com.google.cloud.aiplatform.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * A service for managing and retrieving few-shot examples.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/aiplatform/v1beta1/example_store_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ExampleStoreServiceGrpc {

  private ExampleStoreServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.aiplatform.v1beta1.ExampleStoreService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateExampleStoreRequest,
          com.google.longrunning.Operation>
      getCreateExampleStoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateExampleStore",
      requestType = com.google.cloud.aiplatform.v1beta1.CreateExampleStoreRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateExampleStoreRequest,
          com.google.longrunning.Operation>
      getCreateExampleStoreMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.CreateExampleStoreRequest,
            com.google.longrunning.Operation>
        getCreateExampleStoreMethod;
    if ((getCreateExampleStoreMethod = ExampleStoreServiceGrpc.getCreateExampleStoreMethod)
        == null) {
      synchronized (ExampleStoreServiceGrpc.class) {
        if ((getCreateExampleStoreMethod = ExampleStoreServiceGrpc.getCreateExampleStoreMethod)
            == null) {
          ExampleStoreServiceGrpc.getCreateExampleStoreMethod =
              getCreateExampleStoreMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.CreateExampleStoreRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateExampleStore"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.CreateExampleStoreRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ExampleStoreServiceMethodDescriptorSupplier("CreateExampleStore"))
                      .build();
        }
      }
    }
    return getCreateExampleStoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetExampleStoreRequest,
          com.google.cloud.aiplatform.v1beta1.ExampleStore>
      getGetExampleStoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetExampleStore",
      requestType = com.google.cloud.aiplatform.v1beta1.GetExampleStoreRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ExampleStore.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetExampleStoreRequest,
          com.google.cloud.aiplatform.v1beta1.ExampleStore>
      getGetExampleStoreMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.GetExampleStoreRequest,
            com.google.cloud.aiplatform.v1beta1.ExampleStore>
        getGetExampleStoreMethod;
    if ((getGetExampleStoreMethod = ExampleStoreServiceGrpc.getGetExampleStoreMethod) == null) {
      synchronized (ExampleStoreServiceGrpc.class) {
        if ((getGetExampleStoreMethod = ExampleStoreServiceGrpc.getGetExampleStoreMethod) == null) {
          ExampleStoreServiceGrpc.getGetExampleStoreMethod =
              getGetExampleStoreMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.GetExampleStoreRequest,
                          com.google.cloud.aiplatform.v1beta1.ExampleStore>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetExampleStore"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.GetExampleStoreRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ExampleStore
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ExampleStoreServiceMethodDescriptorSupplier("GetExampleStore"))
                      .build();
        }
      }
    }
    return getGetExampleStoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpdateExampleStoreRequest,
          com.google.longrunning.Operation>
      getUpdateExampleStoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateExampleStore",
      requestType = com.google.cloud.aiplatform.v1beta1.UpdateExampleStoreRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpdateExampleStoreRequest,
          com.google.longrunning.Operation>
      getUpdateExampleStoreMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.UpdateExampleStoreRequest,
            com.google.longrunning.Operation>
        getUpdateExampleStoreMethod;
    if ((getUpdateExampleStoreMethod = ExampleStoreServiceGrpc.getUpdateExampleStoreMethod)
        == null) {
      synchronized (ExampleStoreServiceGrpc.class) {
        if ((getUpdateExampleStoreMethod = ExampleStoreServiceGrpc.getUpdateExampleStoreMethod)
            == null) {
          ExampleStoreServiceGrpc.getUpdateExampleStoreMethod =
              getUpdateExampleStoreMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.UpdateExampleStoreRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateExampleStore"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.UpdateExampleStoreRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ExampleStoreServiceMethodDescriptorSupplier("UpdateExampleStore"))
                      .build();
        }
      }
    }
    return getUpdateExampleStoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteExampleStoreRequest,
          com.google.longrunning.Operation>
      getDeleteExampleStoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteExampleStore",
      requestType = com.google.cloud.aiplatform.v1beta1.DeleteExampleStoreRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteExampleStoreRequest,
          com.google.longrunning.Operation>
      getDeleteExampleStoreMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.DeleteExampleStoreRequest,
            com.google.longrunning.Operation>
        getDeleteExampleStoreMethod;
    if ((getDeleteExampleStoreMethod = ExampleStoreServiceGrpc.getDeleteExampleStoreMethod)
        == null) {
      synchronized (ExampleStoreServiceGrpc.class) {
        if ((getDeleteExampleStoreMethod = ExampleStoreServiceGrpc.getDeleteExampleStoreMethod)
            == null) {
          ExampleStoreServiceGrpc.getDeleteExampleStoreMethod =
              getDeleteExampleStoreMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.DeleteExampleStoreRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteExampleStore"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.DeleteExampleStoreRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ExampleStoreServiceMethodDescriptorSupplier("DeleteExampleStore"))
                      .build();
        }
      }
    }
    return getDeleteExampleStoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListExampleStoresRequest,
          com.google.cloud.aiplatform.v1beta1.ListExampleStoresResponse>
      getListExampleStoresMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListExampleStores",
      requestType = com.google.cloud.aiplatform.v1beta1.ListExampleStoresRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ListExampleStoresResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListExampleStoresRequest,
          com.google.cloud.aiplatform.v1beta1.ListExampleStoresResponse>
      getListExampleStoresMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ListExampleStoresRequest,
            com.google.cloud.aiplatform.v1beta1.ListExampleStoresResponse>
        getListExampleStoresMethod;
    if ((getListExampleStoresMethod = ExampleStoreServiceGrpc.getListExampleStoresMethod) == null) {
      synchronized (ExampleStoreServiceGrpc.class) {
        if ((getListExampleStoresMethod = ExampleStoreServiceGrpc.getListExampleStoresMethod)
            == null) {
          ExampleStoreServiceGrpc.getListExampleStoresMethod =
              getListExampleStoresMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.ListExampleStoresRequest,
                          com.google.cloud.aiplatform.v1beta1.ListExampleStoresResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListExampleStores"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListExampleStoresRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListExampleStoresResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ExampleStoreServiceMethodDescriptorSupplier("ListExampleStores"))
                      .build();
        }
      }
    }
    return getListExampleStoresMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpsertExamplesRequest,
          com.google.cloud.aiplatform.v1beta1.UpsertExamplesResponse>
      getUpsertExamplesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpsertExamples",
      requestType = com.google.cloud.aiplatform.v1beta1.UpsertExamplesRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.UpsertExamplesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpsertExamplesRequest,
          com.google.cloud.aiplatform.v1beta1.UpsertExamplesResponse>
      getUpsertExamplesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.UpsertExamplesRequest,
            com.google.cloud.aiplatform.v1beta1.UpsertExamplesResponse>
        getUpsertExamplesMethod;
    if ((getUpsertExamplesMethod = ExampleStoreServiceGrpc.getUpsertExamplesMethod) == null) {
      synchronized (ExampleStoreServiceGrpc.class) {
        if ((getUpsertExamplesMethod = ExampleStoreServiceGrpc.getUpsertExamplesMethod) == null) {
          ExampleStoreServiceGrpc.getUpsertExamplesMethod =
              getUpsertExamplesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.UpsertExamplesRequest,
                          com.google.cloud.aiplatform.v1beta1.UpsertExamplesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpsertExamples"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.UpsertExamplesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.UpsertExamplesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ExampleStoreServiceMethodDescriptorSupplier("UpsertExamples"))
                      .build();
        }
      }
    }
    return getUpsertExamplesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.RemoveExamplesRequest,
          com.google.cloud.aiplatform.v1beta1.RemoveExamplesResponse>
      getRemoveExamplesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveExamples",
      requestType = com.google.cloud.aiplatform.v1beta1.RemoveExamplesRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.RemoveExamplesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.RemoveExamplesRequest,
          com.google.cloud.aiplatform.v1beta1.RemoveExamplesResponse>
      getRemoveExamplesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.RemoveExamplesRequest,
            com.google.cloud.aiplatform.v1beta1.RemoveExamplesResponse>
        getRemoveExamplesMethod;
    if ((getRemoveExamplesMethod = ExampleStoreServiceGrpc.getRemoveExamplesMethod) == null) {
      synchronized (ExampleStoreServiceGrpc.class) {
        if ((getRemoveExamplesMethod = ExampleStoreServiceGrpc.getRemoveExamplesMethod) == null) {
          ExampleStoreServiceGrpc.getRemoveExamplesMethod =
              getRemoveExamplesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.RemoveExamplesRequest,
                          com.google.cloud.aiplatform.v1beta1.RemoveExamplesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RemoveExamples"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.RemoveExamplesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.RemoveExamplesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ExampleStoreServiceMethodDescriptorSupplier("RemoveExamples"))
                      .build();
        }
      }
    }
    return getRemoveExamplesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.SearchExamplesRequest,
          com.google.cloud.aiplatform.v1beta1.SearchExamplesResponse>
      getSearchExamplesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchExamples",
      requestType = com.google.cloud.aiplatform.v1beta1.SearchExamplesRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.SearchExamplesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.SearchExamplesRequest,
          com.google.cloud.aiplatform.v1beta1.SearchExamplesResponse>
      getSearchExamplesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.SearchExamplesRequest,
            com.google.cloud.aiplatform.v1beta1.SearchExamplesResponse>
        getSearchExamplesMethod;
    if ((getSearchExamplesMethod = ExampleStoreServiceGrpc.getSearchExamplesMethod) == null) {
      synchronized (ExampleStoreServiceGrpc.class) {
        if ((getSearchExamplesMethod = ExampleStoreServiceGrpc.getSearchExamplesMethod) == null) {
          ExampleStoreServiceGrpc.getSearchExamplesMethod =
              getSearchExamplesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.SearchExamplesRequest,
                          com.google.cloud.aiplatform.v1beta1.SearchExamplesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchExamples"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.SearchExamplesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.SearchExamplesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ExampleStoreServiceMethodDescriptorSupplier("SearchExamples"))
                      .build();
        }
      }
    }
    return getSearchExamplesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.FetchExamplesRequest,
          com.google.cloud.aiplatform.v1beta1.FetchExamplesResponse>
      getFetchExamplesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchExamples",
      requestType = com.google.cloud.aiplatform.v1beta1.FetchExamplesRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.FetchExamplesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.FetchExamplesRequest,
          com.google.cloud.aiplatform.v1beta1.FetchExamplesResponse>
      getFetchExamplesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.FetchExamplesRequest,
            com.google.cloud.aiplatform.v1beta1.FetchExamplesResponse>
        getFetchExamplesMethod;
    if ((getFetchExamplesMethod = ExampleStoreServiceGrpc.getFetchExamplesMethod) == null) {
      synchronized (ExampleStoreServiceGrpc.class) {
        if ((getFetchExamplesMethod = ExampleStoreServiceGrpc.getFetchExamplesMethod) == null) {
          ExampleStoreServiceGrpc.getFetchExamplesMethod =
              getFetchExamplesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.FetchExamplesRequest,
                          com.google.cloud.aiplatform.v1beta1.FetchExamplesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FetchExamples"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.FetchExamplesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.FetchExamplesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ExampleStoreServiceMethodDescriptorSupplier("FetchExamples"))
                      .build();
        }
      }
    }
    return getFetchExamplesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ExampleStoreServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExampleStoreServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ExampleStoreServiceStub>() {
          @java.lang.Override
          public ExampleStoreServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ExampleStoreServiceStub(channel, callOptions);
          }
        };
    return ExampleStoreServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static ExampleStoreServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExampleStoreServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ExampleStoreServiceBlockingV2Stub>() {
          @java.lang.Override
          public ExampleStoreServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ExampleStoreServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return ExampleStoreServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ExampleStoreServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExampleStoreServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ExampleStoreServiceBlockingStub>() {
          @java.lang.Override
          public ExampleStoreServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ExampleStoreServiceBlockingStub(channel, callOptions);
          }
        };
    return ExampleStoreServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ExampleStoreServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExampleStoreServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ExampleStoreServiceFutureStub>() {
          @java.lang.Override
          public ExampleStoreServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ExampleStoreServiceFutureStub(channel, callOptions);
          }
        };
    return ExampleStoreServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * A service for managing and retrieving few-shot examples.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Create an ExampleStore.
     * </pre>
     */
    default void createExampleStore(
        com.google.cloud.aiplatform.v1beta1.CreateExampleStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateExampleStoreMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get an ExampleStore.
     * </pre>
     */
    default void getExampleStore(
        com.google.cloud.aiplatform.v1beta1.GetExampleStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ExampleStore>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetExampleStoreMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update an ExampleStore.
     * </pre>
     */
    default void updateExampleStore(
        com.google.cloud.aiplatform.v1beta1.UpdateExampleStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateExampleStoreMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete an ExampleStore.
     * </pre>
     */
    default void deleteExampleStore(
        com.google.cloud.aiplatform.v1beta1.DeleteExampleStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteExampleStoreMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List ExampleStores in a Location.
     * </pre>
     */
    default void listExampleStores(
        com.google.cloud.aiplatform.v1beta1.ListExampleStoresRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListExampleStoresResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListExampleStoresMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create or update Examples in the Example Store.
     * </pre>
     */
    default void upsertExamples(
        com.google.cloud.aiplatform.v1beta1.UpsertExamplesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.UpsertExamplesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpsertExamplesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Remove Examples from the Example Store.
     * </pre>
     */
    default void removeExamples(
        com.google.cloud.aiplatform.v1beta1.RemoveExamplesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.RemoveExamplesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRemoveExamplesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Search for similar Examples for given selection criteria.
     * </pre>
     */
    default void searchExamples(
        com.google.cloud.aiplatform.v1beta1.SearchExamplesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.SearchExamplesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchExamplesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get Examples from the Example Store.
     * </pre>
     */
    default void fetchExamples(
        com.google.cloud.aiplatform.v1beta1.FetchExamplesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.FetchExamplesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFetchExamplesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ExampleStoreService.
   *
   * <pre>
   * A service for managing and retrieving few-shot examples.
   * </pre>
   */
  public abstract static class ExampleStoreServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ExampleStoreServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ExampleStoreService.
   *
   * <pre>
   * A service for managing and retrieving few-shot examples.
   * </pre>
   */
  public static final class ExampleStoreServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ExampleStoreServiceStub> {
    private ExampleStoreServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExampleStoreServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExampleStoreServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create an ExampleStore.
     * </pre>
     */
    public void createExampleStore(
        com.google.cloud.aiplatform.v1beta1.CreateExampleStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateExampleStoreMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get an ExampleStore.
     * </pre>
     */
    public void getExampleStore(
        com.google.cloud.aiplatform.v1beta1.GetExampleStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ExampleStore>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetExampleStoreMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update an ExampleStore.
     * </pre>
     */
    public void updateExampleStore(
        com.google.cloud.aiplatform.v1beta1.UpdateExampleStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateExampleStoreMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete an ExampleStore.
     * </pre>
     */
    public void deleteExampleStore(
        com.google.cloud.aiplatform.v1beta1.DeleteExampleStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteExampleStoreMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List ExampleStores in a Location.
     * </pre>
     */
    public void listExampleStores(
        com.google.cloud.aiplatform.v1beta1.ListExampleStoresRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListExampleStoresResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListExampleStoresMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create or update Examples in the Example Store.
     * </pre>
     */
    public void upsertExamples(
        com.google.cloud.aiplatform.v1beta1.UpsertExamplesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.UpsertExamplesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpsertExamplesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Remove Examples from the Example Store.
     * </pre>
     */
    public void removeExamples(
        com.google.cloud.aiplatform.v1beta1.RemoveExamplesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.RemoveExamplesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRemoveExamplesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Search for similar Examples for given selection criteria.
     * </pre>
     */
    public void searchExamples(
        com.google.cloud.aiplatform.v1beta1.SearchExamplesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.SearchExamplesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchExamplesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get Examples from the Example Store.
     * </pre>
     */
    public void fetchExamples(
        com.google.cloud.aiplatform.v1beta1.FetchExamplesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.FetchExamplesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchExamplesMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ExampleStoreService.
   *
   * <pre>
   * A service for managing and retrieving few-shot examples.
   * </pre>
   */
  public static final class ExampleStoreServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<ExampleStoreServiceBlockingV2Stub> {
    private ExampleStoreServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExampleStoreServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExampleStoreServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create an ExampleStore.
     * </pre>
     */
    public com.google.longrunning.Operation createExampleStore(
        com.google.cloud.aiplatform.v1beta1.CreateExampleStoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateExampleStoreMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get an ExampleStore.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ExampleStore getExampleStore(
        com.google.cloud.aiplatform.v1beta1.GetExampleStoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetExampleStoreMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update an ExampleStore.
     * </pre>
     */
    public com.google.longrunning.Operation updateExampleStore(
        com.google.cloud.aiplatform.v1beta1.UpdateExampleStoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateExampleStoreMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete an ExampleStore.
     * </pre>
     */
    public com.google.longrunning.Operation deleteExampleStore(
        com.google.cloud.aiplatform.v1beta1.DeleteExampleStoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteExampleStoreMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List ExampleStores in a Location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListExampleStoresResponse listExampleStores(
        com.google.cloud.aiplatform.v1beta1.ListExampleStoresRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListExampleStoresMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create or update Examples in the Example Store.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.UpsertExamplesResponse upsertExamples(
        com.google.cloud.aiplatform.v1beta1.UpsertExamplesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpsertExamplesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Remove Examples from the Example Store.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.RemoveExamplesResponse removeExamples(
        com.google.cloud.aiplatform.v1beta1.RemoveExamplesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveExamplesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Search for similar Examples for given selection criteria.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.SearchExamplesResponse searchExamples(
        com.google.cloud.aiplatform.v1beta1.SearchExamplesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchExamplesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get Examples from the Example Store.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.FetchExamplesResponse fetchExamples(
        com.google.cloud.aiplatform.v1beta1.FetchExamplesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchExamplesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service ExampleStoreService.
   *
   * <pre>
   * A service for managing and retrieving few-shot examples.
   * </pre>
   */
  public static final class ExampleStoreServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ExampleStoreServiceBlockingStub> {
    private ExampleStoreServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExampleStoreServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExampleStoreServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create an ExampleStore.
     * </pre>
     */
    public com.google.longrunning.Operation createExampleStore(
        com.google.cloud.aiplatform.v1beta1.CreateExampleStoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateExampleStoreMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get an ExampleStore.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ExampleStore getExampleStore(
        com.google.cloud.aiplatform.v1beta1.GetExampleStoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetExampleStoreMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update an ExampleStore.
     * </pre>
     */
    public com.google.longrunning.Operation updateExampleStore(
        com.google.cloud.aiplatform.v1beta1.UpdateExampleStoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateExampleStoreMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete an ExampleStore.
     * </pre>
     */
    public com.google.longrunning.Operation deleteExampleStore(
        com.google.cloud.aiplatform.v1beta1.DeleteExampleStoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteExampleStoreMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List ExampleStores in a Location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListExampleStoresResponse listExampleStores(
        com.google.cloud.aiplatform.v1beta1.ListExampleStoresRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListExampleStoresMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create or update Examples in the Example Store.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.UpsertExamplesResponse upsertExamples(
        com.google.cloud.aiplatform.v1beta1.UpsertExamplesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpsertExamplesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Remove Examples from the Example Store.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.RemoveExamplesResponse removeExamples(
        com.google.cloud.aiplatform.v1beta1.RemoveExamplesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveExamplesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Search for similar Examples for given selection criteria.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.SearchExamplesResponse searchExamples(
        com.google.cloud.aiplatform.v1beta1.SearchExamplesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchExamplesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get Examples from the Example Store.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.FetchExamplesResponse fetchExamples(
        com.google.cloud.aiplatform.v1beta1.FetchExamplesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchExamplesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ExampleStoreService.
   *
   * <pre>
   * A service for managing and retrieving few-shot examples.
   * </pre>
   */
  public static final class ExampleStoreServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ExampleStoreServiceFutureStub> {
    private ExampleStoreServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExampleStoreServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExampleStoreServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create an ExampleStore.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createExampleStore(com.google.cloud.aiplatform.v1beta1.CreateExampleStoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateExampleStoreMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get an ExampleStore.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ExampleStore>
        getExampleStore(com.google.cloud.aiplatform.v1beta1.GetExampleStoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetExampleStoreMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update an ExampleStore.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateExampleStore(com.google.cloud.aiplatform.v1beta1.UpdateExampleStoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateExampleStoreMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete an ExampleStore.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteExampleStore(com.google.cloud.aiplatform.v1beta1.DeleteExampleStoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteExampleStoreMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List ExampleStores in a Location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ListExampleStoresResponse>
        listExampleStores(com.google.cloud.aiplatform.v1beta1.ListExampleStoresRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListExampleStoresMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create or update Examples in the Example Store.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.UpsertExamplesResponse>
        upsertExamples(com.google.cloud.aiplatform.v1beta1.UpsertExamplesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpsertExamplesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Remove Examples from the Example Store.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.RemoveExamplesResponse>
        removeExamples(com.google.cloud.aiplatform.v1beta1.RemoveExamplesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRemoveExamplesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Search for similar Examples for given selection criteria.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.SearchExamplesResponse>
        searchExamples(com.google.cloud.aiplatform.v1beta1.SearchExamplesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchExamplesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get Examples from the Example Store.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.FetchExamplesResponse>
        fetchExamples(com.google.cloud.aiplatform.v1beta1.FetchExamplesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchExamplesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_EXAMPLE_STORE = 0;
  private static final int METHODID_GET_EXAMPLE_STORE = 1;
  private static final int METHODID_UPDATE_EXAMPLE_STORE = 2;
  private static final int METHODID_DELETE_EXAMPLE_STORE = 3;
  private static final int METHODID_LIST_EXAMPLE_STORES = 4;
  private static final int METHODID_UPSERT_EXAMPLES = 5;
  private static final int METHODID_REMOVE_EXAMPLES = 6;
  private static final int METHODID_SEARCH_EXAMPLES = 7;
  private static final int METHODID_FETCH_EXAMPLES = 8;

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
        case METHODID_CREATE_EXAMPLE_STORE:
          serviceImpl.createExampleStore(
              (com.google.cloud.aiplatform.v1beta1.CreateExampleStoreRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_EXAMPLE_STORE:
          serviceImpl.getExampleStore(
              (com.google.cloud.aiplatform.v1beta1.GetExampleStoreRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ExampleStore>)
                  responseObserver);
          break;
        case METHODID_UPDATE_EXAMPLE_STORE:
          serviceImpl.updateExampleStore(
              (com.google.cloud.aiplatform.v1beta1.UpdateExampleStoreRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_EXAMPLE_STORE:
          serviceImpl.deleteExampleStore(
              (com.google.cloud.aiplatform.v1beta1.DeleteExampleStoreRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_EXAMPLE_STORES:
          serviceImpl.listExampleStores(
              (com.google.cloud.aiplatform.v1beta1.ListExampleStoresRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.ListExampleStoresResponse>)
                  responseObserver);
          break;
        case METHODID_UPSERT_EXAMPLES:
          serviceImpl.upsertExamples(
              (com.google.cloud.aiplatform.v1beta1.UpsertExamplesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.UpsertExamplesResponse>)
                  responseObserver);
          break;
        case METHODID_REMOVE_EXAMPLES:
          serviceImpl.removeExamples(
              (com.google.cloud.aiplatform.v1beta1.RemoveExamplesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.RemoveExamplesResponse>)
                  responseObserver);
          break;
        case METHODID_SEARCH_EXAMPLES:
          serviceImpl.searchExamples(
              (com.google.cloud.aiplatform.v1beta1.SearchExamplesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.SearchExamplesResponse>)
                  responseObserver);
          break;
        case METHODID_FETCH_EXAMPLES:
          serviceImpl.fetchExamples(
              (com.google.cloud.aiplatform.v1beta1.FetchExamplesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.FetchExamplesResponse>)
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
            getCreateExampleStoreMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.CreateExampleStoreRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_EXAMPLE_STORE)))
        .addMethod(
            getGetExampleStoreMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.GetExampleStoreRequest,
                    com.google.cloud.aiplatform.v1beta1.ExampleStore>(
                    service, METHODID_GET_EXAMPLE_STORE)))
        .addMethod(
            getUpdateExampleStoreMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.UpdateExampleStoreRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_EXAMPLE_STORE)))
        .addMethod(
            getDeleteExampleStoreMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.DeleteExampleStoreRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_EXAMPLE_STORE)))
        .addMethod(
            getListExampleStoresMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.ListExampleStoresRequest,
                    com.google.cloud.aiplatform.v1beta1.ListExampleStoresResponse>(
                    service, METHODID_LIST_EXAMPLE_STORES)))
        .addMethod(
            getUpsertExamplesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.UpsertExamplesRequest,
                    com.google.cloud.aiplatform.v1beta1.UpsertExamplesResponse>(
                    service, METHODID_UPSERT_EXAMPLES)))
        .addMethod(
            getRemoveExamplesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.RemoveExamplesRequest,
                    com.google.cloud.aiplatform.v1beta1.RemoveExamplesResponse>(
                    service, METHODID_REMOVE_EXAMPLES)))
        .addMethod(
            getSearchExamplesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.SearchExamplesRequest,
                    com.google.cloud.aiplatform.v1beta1.SearchExamplesResponse>(
                    service, METHODID_SEARCH_EXAMPLES)))
        .addMethod(
            getFetchExamplesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.FetchExamplesRequest,
                    com.google.cloud.aiplatform.v1beta1.FetchExamplesResponse>(
                    service, METHODID_FETCH_EXAMPLES)))
        .build();
  }

  private abstract static class ExampleStoreServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ExampleStoreServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1beta1.ExampleStoreServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ExampleStoreService");
    }
  }

  private static final class ExampleStoreServiceFileDescriptorSupplier
      extends ExampleStoreServiceBaseDescriptorSupplier {
    ExampleStoreServiceFileDescriptorSupplier() {}
  }

  private static final class ExampleStoreServiceMethodDescriptorSupplier
      extends ExampleStoreServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ExampleStoreServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ExampleStoreServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ExampleStoreServiceFileDescriptorSupplier())
                      .addMethod(getCreateExampleStoreMethod())
                      .addMethod(getGetExampleStoreMethod())
                      .addMethod(getUpdateExampleStoreMethod())
                      .addMethod(getDeleteExampleStoreMethod())
                      .addMethod(getListExampleStoresMethod())
                      .addMethod(getUpsertExamplesMethod())
                      .addMethod(getRemoveExamplesMethod())
                      .addMethod(getSearchExamplesMethod())
                      .addMethod(getFetchExamplesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
