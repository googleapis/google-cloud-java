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
package com.google.cloud.discoveryengine.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for Auto-Completion.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/discoveryengine/v1/completion_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CompletionServiceGrpc {

  private CompletionServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.discoveryengine.v1.CompletionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.CompleteQueryRequest,
          com.google.cloud.discoveryengine.v1.CompleteQueryResponse>
      getCompleteQueryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CompleteQuery",
      requestType = com.google.cloud.discoveryengine.v1.CompleteQueryRequest.class,
      responseType = com.google.cloud.discoveryengine.v1.CompleteQueryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.CompleteQueryRequest,
          com.google.cloud.discoveryengine.v1.CompleteQueryResponse>
      getCompleteQueryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1.CompleteQueryRequest,
            com.google.cloud.discoveryengine.v1.CompleteQueryResponse>
        getCompleteQueryMethod;
    if ((getCompleteQueryMethod = CompletionServiceGrpc.getCompleteQueryMethod) == null) {
      synchronized (CompletionServiceGrpc.class) {
        if ((getCompleteQueryMethod = CompletionServiceGrpc.getCompleteQueryMethod) == null) {
          CompletionServiceGrpc.getCompleteQueryMethod =
              getCompleteQueryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1.CompleteQueryRequest,
                          com.google.cloud.discoveryengine.v1.CompleteQueryResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CompleteQuery"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.CompleteQueryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.CompleteQueryResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CompletionServiceMethodDescriptorSupplier("CompleteQuery"))
                      .build();
        }
      }
    }
    return getCompleteQueryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.ImportSuggestionDenyListEntriesRequest,
          com.google.longrunning.Operation>
      getImportSuggestionDenyListEntriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportSuggestionDenyListEntries",
      requestType =
          com.google.cloud.discoveryengine.v1.ImportSuggestionDenyListEntriesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.ImportSuggestionDenyListEntriesRequest,
          com.google.longrunning.Operation>
      getImportSuggestionDenyListEntriesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1.ImportSuggestionDenyListEntriesRequest,
            com.google.longrunning.Operation>
        getImportSuggestionDenyListEntriesMethod;
    if ((getImportSuggestionDenyListEntriesMethod =
            CompletionServiceGrpc.getImportSuggestionDenyListEntriesMethod)
        == null) {
      synchronized (CompletionServiceGrpc.class) {
        if ((getImportSuggestionDenyListEntriesMethod =
                CompletionServiceGrpc.getImportSuggestionDenyListEntriesMethod)
            == null) {
          CompletionServiceGrpc.getImportSuggestionDenyListEntriesMethod =
              getImportSuggestionDenyListEntriesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1.ImportSuggestionDenyListEntriesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ImportSuggestionDenyListEntries"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1
                                  .ImportSuggestionDenyListEntriesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CompletionServiceMethodDescriptorSupplier(
                              "ImportSuggestionDenyListEntries"))
                      .build();
        }
      }
    }
    return getImportSuggestionDenyListEntriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.PurgeSuggestionDenyListEntriesRequest,
          com.google.longrunning.Operation>
      getPurgeSuggestionDenyListEntriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PurgeSuggestionDenyListEntries",
      requestType = com.google.cloud.discoveryengine.v1.PurgeSuggestionDenyListEntriesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.PurgeSuggestionDenyListEntriesRequest,
          com.google.longrunning.Operation>
      getPurgeSuggestionDenyListEntriesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1.PurgeSuggestionDenyListEntriesRequest,
            com.google.longrunning.Operation>
        getPurgeSuggestionDenyListEntriesMethod;
    if ((getPurgeSuggestionDenyListEntriesMethod =
            CompletionServiceGrpc.getPurgeSuggestionDenyListEntriesMethod)
        == null) {
      synchronized (CompletionServiceGrpc.class) {
        if ((getPurgeSuggestionDenyListEntriesMethod =
                CompletionServiceGrpc.getPurgeSuggestionDenyListEntriesMethod)
            == null) {
          CompletionServiceGrpc.getPurgeSuggestionDenyListEntriesMethod =
              getPurgeSuggestionDenyListEntriesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1.PurgeSuggestionDenyListEntriesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "PurgeSuggestionDenyListEntries"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1
                                  .PurgeSuggestionDenyListEntriesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CompletionServiceMethodDescriptorSupplier(
                              "PurgeSuggestionDenyListEntries"))
                      .build();
        }
      }
    }
    return getPurgeSuggestionDenyListEntriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.ImportCompletionSuggestionsRequest,
          com.google.longrunning.Operation>
      getImportCompletionSuggestionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportCompletionSuggestions",
      requestType = com.google.cloud.discoveryengine.v1.ImportCompletionSuggestionsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.ImportCompletionSuggestionsRequest,
          com.google.longrunning.Operation>
      getImportCompletionSuggestionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1.ImportCompletionSuggestionsRequest,
            com.google.longrunning.Operation>
        getImportCompletionSuggestionsMethod;
    if ((getImportCompletionSuggestionsMethod =
            CompletionServiceGrpc.getImportCompletionSuggestionsMethod)
        == null) {
      synchronized (CompletionServiceGrpc.class) {
        if ((getImportCompletionSuggestionsMethod =
                CompletionServiceGrpc.getImportCompletionSuggestionsMethod)
            == null) {
          CompletionServiceGrpc.getImportCompletionSuggestionsMethod =
              getImportCompletionSuggestionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1.ImportCompletionSuggestionsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ImportCompletionSuggestions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.ImportCompletionSuggestionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CompletionServiceMethodDescriptorSupplier(
                              "ImportCompletionSuggestions"))
                      .build();
        }
      }
    }
    return getImportCompletionSuggestionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.PurgeCompletionSuggestionsRequest,
          com.google.longrunning.Operation>
      getPurgeCompletionSuggestionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PurgeCompletionSuggestions",
      requestType = com.google.cloud.discoveryengine.v1.PurgeCompletionSuggestionsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.PurgeCompletionSuggestionsRequest,
          com.google.longrunning.Operation>
      getPurgeCompletionSuggestionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1.PurgeCompletionSuggestionsRequest,
            com.google.longrunning.Operation>
        getPurgeCompletionSuggestionsMethod;
    if ((getPurgeCompletionSuggestionsMethod =
            CompletionServiceGrpc.getPurgeCompletionSuggestionsMethod)
        == null) {
      synchronized (CompletionServiceGrpc.class) {
        if ((getPurgeCompletionSuggestionsMethod =
                CompletionServiceGrpc.getPurgeCompletionSuggestionsMethod)
            == null) {
          CompletionServiceGrpc.getPurgeCompletionSuggestionsMethod =
              getPurgeCompletionSuggestionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1.PurgeCompletionSuggestionsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "PurgeCompletionSuggestions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.PurgeCompletionSuggestionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CompletionServiceMethodDescriptorSupplier(
                              "PurgeCompletionSuggestions"))
                      .build();
        }
      }
    }
    return getPurgeCompletionSuggestionsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static CompletionServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CompletionServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CompletionServiceStub>() {
          @java.lang.Override
          public CompletionServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CompletionServiceStub(channel, callOptions);
          }
        };
    return CompletionServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static CompletionServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CompletionServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CompletionServiceBlockingV2Stub>() {
          @java.lang.Override
          public CompletionServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CompletionServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return CompletionServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CompletionServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CompletionServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CompletionServiceBlockingStub>() {
          @java.lang.Override
          public CompletionServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CompletionServiceBlockingStub(channel, callOptions);
          }
        };
    return CompletionServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static CompletionServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CompletionServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CompletionServiceFutureStub>() {
          @java.lang.Override
          public CompletionServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CompletionServiceFutureStub(channel, callOptions);
          }
        };
    return CompletionServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for Auto-Completion.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Completes the specified user input with keyword suggestions.
     * </pre>
     */
    default void completeQuery(
        com.google.cloud.discoveryengine.v1.CompleteQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.CompleteQueryResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCompleteQueryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports all
     * [SuggestionDenyListEntry][google.cloud.discoveryengine.v1.SuggestionDenyListEntry]
     * for a DataStore.
     * </pre>
     */
    default void importSuggestionDenyListEntries(
        com.google.cloud.discoveryengine.v1.ImportSuggestionDenyListEntriesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getImportSuggestionDenyListEntriesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes all
     * [SuggestionDenyListEntry][google.cloud.discoveryengine.v1.SuggestionDenyListEntry]
     * for a DataStore.
     * </pre>
     */
    default void purgeSuggestionDenyListEntries(
        com.google.cloud.discoveryengine.v1.PurgeSuggestionDenyListEntriesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getPurgeSuggestionDenyListEntriesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports
     * [CompletionSuggestion][google.cloud.discoveryengine.v1.CompletionSuggestion]s
     * for a DataStore.
     * </pre>
     */
    default void importCompletionSuggestions(
        com.google.cloud.discoveryengine.v1.ImportCompletionSuggestionsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getImportCompletionSuggestionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes all
     * [CompletionSuggestion][google.cloud.discoveryengine.v1.CompletionSuggestion]s
     * for a DataStore.
     * </pre>
     */
    default void purgeCompletionSuggestions(
        com.google.cloud.discoveryengine.v1.PurgeCompletionSuggestionsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getPurgeCompletionSuggestionsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CompletionService.
   *
   * <pre>
   * Service for Auto-Completion.
   * </pre>
   */
  public abstract static class CompletionServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return CompletionServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CompletionService.
   *
   * <pre>
   * Service for Auto-Completion.
   * </pre>
   */
  public static final class CompletionServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CompletionServiceStub> {
    private CompletionServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CompletionServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CompletionServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Completes the specified user input with keyword suggestions.
     * </pre>
     */
    public void completeQuery(
        com.google.cloud.discoveryengine.v1.CompleteQueryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.CompleteQueryResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCompleteQueryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports all
     * [SuggestionDenyListEntry][google.cloud.discoveryengine.v1.SuggestionDenyListEntry]
     * for a DataStore.
     * </pre>
     */
    public void importSuggestionDenyListEntries(
        com.google.cloud.discoveryengine.v1.ImportSuggestionDenyListEntriesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportSuggestionDenyListEntriesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes all
     * [SuggestionDenyListEntry][google.cloud.discoveryengine.v1.SuggestionDenyListEntry]
     * for a DataStore.
     * </pre>
     */
    public void purgeSuggestionDenyListEntries(
        com.google.cloud.discoveryengine.v1.PurgeSuggestionDenyListEntriesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPurgeSuggestionDenyListEntriesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports
     * [CompletionSuggestion][google.cloud.discoveryengine.v1.CompletionSuggestion]s
     * for a DataStore.
     * </pre>
     */
    public void importCompletionSuggestions(
        com.google.cloud.discoveryengine.v1.ImportCompletionSuggestionsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportCompletionSuggestionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes all
     * [CompletionSuggestion][google.cloud.discoveryengine.v1.CompletionSuggestion]s
     * for a DataStore.
     * </pre>
     */
    public void purgeCompletionSuggestions(
        com.google.cloud.discoveryengine.v1.PurgeCompletionSuggestionsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPurgeCompletionSuggestionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CompletionService.
   *
   * <pre>
   * Service for Auto-Completion.
   * </pre>
   */
  public static final class CompletionServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<CompletionServiceBlockingV2Stub> {
    private CompletionServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CompletionServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CompletionServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Completes the specified user input with keyword suggestions.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1.CompleteQueryResponse completeQuery(
        com.google.cloud.discoveryengine.v1.CompleteQueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCompleteQueryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports all
     * [SuggestionDenyListEntry][google.cloud.discoveryengine.v1.SuggestionDenyListEntry]
     * for a DataStore.
     * </pre>
     */
    public com.google.longrunning.Operation importSuggestionDenyListEntries(
        com.google.cloud.discoveryengine.v1.ImportSuggestionDenyListEntriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportSuggestionDenyListEntriesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes all
     * [SuggestionDenyListEntry][google.cloud.discoveryengine.v1.SuggestionDenyListEntry]
     * for a DataStore.
     * </pre>
     */
    public com.google.longrunning.Operation purgeSuggestionDenyListEntries(
        com.google.cloud.discoveryengine.v1.PurgeSuggestionDenyListEntriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPurgeSuggestionDenyListEntriesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports
     * [CompletionSuggestion][google.cloud.discoveryengine.v1.CompletionSuggestion]s
     * for a DataStore.
     * </pre>
     */
    public com.google.longrunning.Operation importCompletionSuggestions(
        com.google.cloud.discoveryengine.v1.ImportCompletionSuggestionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportCompletionSuggestionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes all
     * [CompletionSuggestion][google.cloud.discoveryengine.v1.CompletionSuggestion]s
     * for a DataStore.
     * </pre>
     */
    public com.google.longrunning.Operation purgeCompletionSuggestions(
        com.google.cloud.discoveryengine.v1.PurgeCompletionSuggestionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPurgeCompletionSuggestionsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service CompletionService.
   *
   * <pre>
   * Service for Auto-Completion.
   * </pre>
   */
  public static final class CompletionServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CompletionServiceBlockingStub> {
    private CompletionServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CompletionServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CompletionServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Completes the specified user input with keyword suggestions.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1.CompleteQueryResponse completeQuery(
        com.google.cloud.discoveryengine.v1.CompleteQueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCompleteQueryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports all
     * [SuggestionDenyListEntry][google.cloud.discoveryengine.v1.SuggestionDenyListEntry]
     * for a DataStore.
     * </pre>
     */
    public com.google.longrunning.Operation importSuggestionDenyListEntries(
        com.google.cloud.discoveryengine.v1.ImportSuggestionDenyListEntriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportSuggestionDenyListEntriesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes all
     * [SuggestionDenyListEntry][google.cloud.discoveryengine.v1.SuggestionDenyListEntry]
     * for a DataStore.
     * </pre>
     */
    public com.google.longrunning.Operation purgeSuggestionDenyListEntries(
        com.google.cloud.discoveryengine.v1.PurgeSuggestionDenyListEntriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPurgeSuggestionDenyListEntriesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports
     * [CompletionSuggestion][google.cloud.discoveryengine.v1.CompletionSuggestion]s
     * for a DataStore.
     * </pre>
     */
    public com.google.longrunning.Operation importCompletionSuggestions(
        com.google.cloud.discoveryengine.v1.ImportCompletionSuggestionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportCompletionSuggestionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes all
     * [CompletionSuggestion][google.cloud.discoveryengine.v1.CompletionSuggestion]s
     * for a DataStore.
     * </pre>
     */
    public com.google.longrunning.Operation purgeCompletionSuggestions(
        com.google.cloud.discoveryengine.v1.PurgeCompletionSuggestionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPurgeCompletionSuggestionsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CompletionService.
   *
   * <pre>
   * Service for Auto-Completion.
   * </pre>
   */
  public static final class CompletionServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CompletionServiceFutureStub> {
    private CompletionServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CompletionServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CompletionServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Completes the specified user input with keyword suggestions.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1.CompleteQueryResponse>
        completeQuery(com.google.cloud.discoveryengine.v1.CompleteQueryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCompleteQueryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Imports all
     * [SuggestionDenyListEntry][google.cloud.discoveryengine.v1.SuggestionDenyListEntry]
     * for a DataStore.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        importSuggestionDenyListEntries(
            com.google.cloud.discoveryengine.v1.ImportSuggestionDenyListEntriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportSuggestionDenyListEntriesMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes all
     * [SuggestionDenyListEntry][google.cloud.discoveryengine.v1.SuggestionDenyListEntry]
     * for a DataStore.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        purgeSuggestionDenyListEntries(
            com.google.cloud.discoveryengine.v1.PurgeSuggestionDenyListEntriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPurgeSuggestionDenyListEntriesMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Imports
     * [CompletionSuggestion][google.cloud.discoveryengine.v1.CompletionSuggestion]s
     * for a DataStore.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        importCompletionSuggestions(
            com.google.cloud.discoveryengine.v1.ImportCompletionSuggestionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportCompletionSuggestionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Permanently deletes all
     * [CompletionSuggestion][google.cloud.discoveryengine.v1.CompletionSuggestion]s
     * for a DataStore.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        purgeCompletionSuggestions(
            com.google.cloud.discoveryengine.v1.PurgeCompletionSuggestionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPurgeCompletionSuggestionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_COMPLETE_QUERY = 0;
  private static final int METHODID_IMPORT_SUGGESTION_DENY_LIST_ENTRIES = 1;
  private static final int METHODID_PURGE_SUGGESTION_DENY_LIST_ENTRIES = 2;
  private static final int METHODID_IMPORT_COMPLETION_SUGGESTIONS = 3;
  private static final int METHODID_PURGE_COMPLETION_SUGGESTIONS = 4;

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
        case METHODID_COMPLETE_QUERY:
          serviceImpl.completeQuery(
              (com.google.cloud.discoveryengine.v1.CompleteQueryRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.discoveryengine.v1.CompleteQueryResponse>)
                  responseObserver);
          break;
        case METHODID_IMPORT_SUGGESTION_DENY_LIST_ENTRIES:
          serviceImpl.importSuggestionDenyListEntries(
              (com.google.cloud.discoveryengine.v1.ImportSuggestionDenyListEntriesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_PURGE_SUGGESTION_DENY_LIST_ENTRIES:
          serviceImpl.purgeSuggestionDenyListEntries(
              (com.google.cloud.discoveryengine.v1.PurgeSuggestionDenyListEntriesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_IMPORT_COMPLETION_SUGGESTIONS:
          serviceImpl.importCompletionSuggestions(
              (com.google.cloud.discoveryengine.v1.ImportCompletionSuggestionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_PURGE_COMPLETION_SUGGESTIONS:
          serviceImpl.purgeCompletionSuggestions(
              (com.google.cloud.discoveryengine.v1.PurgeCompletionSuggestionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
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
            getCompleteQueryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1.CompleteQueryRequest,
                    com.google.cloud.discoveryengine.v1.CompleteQueryResponse>(
                    service, METHODID_COMPLETE_QUERY)))
        .addMethod(
            getImportSuggestionDenyListEntriesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1.ImportSuggestionDenyListEntriesRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_IMPORT_SUGGESTION_DENY_LIST_ENTRIES)))
        .addMethod(
            getPurgeSuggestionDenyListEntriesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1.PurgeSuggestionDenyListEntriesRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_PURGE_SUGGESTION_DENY_LIST_ENTRIES)))
        .addMethod(
            getImportCompletionSuggestionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1.ImportCompletionSuggestionsRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_IMPORT_COMPLETION_SUGGESTIONS)))
        .addMethod(
            getPurgeCompletionSuggestionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1.PurgeCompletionSuggestionsRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_PURGE_COMPLETION_SUGGESTIONS)))
        .build();
  }

  private abstract static class CompletionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CompletionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.discoveryengine.v1.CompletionServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CompletionService");
    }
  }

  private static final class CompletionServiceFileDescriptorSupplier
      extends CompletionServiceBaseDescriptorSupplier {
    CompletionServiceFileDescriptorSupplier() {}
  }

  private static final class CompletionServiceMethodDescriptorSupplier
      extends CompletionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CompletionServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CompletionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new CompletionServiceFileDescriptorSupplier())
                      .addMethod(getCompleteQueryMethod())
                      .addMethod(getImportSuggestionDenyListEntriesMethod())
                      .addMethod(getPurgeSuggestionDenyListEntriesMethod())
                      .addMethod(getImportCompletionSuggestionsMethod())
                      .addMethod(getPurgeCompletionSuggestionsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
