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
 * Service for managing Identity Mapping Stores.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/discoveryengine/v1/identity_mapping_store_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class IdentityMappingStoreServiceGrpc {

  private IdentityMappingStoreServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.discoveryengine.v1.IdentityMappingStoreService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.CreateIdentityMappingStoreRequest,
          com.google.cloud.discoveryengine.v1.IdentityMappingStore>
      getCreateIdentityMappingStoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateIdentityMappingStore",
      requestType = com.google.cloud.discoveryengine.v1.CreateIdentityMappingStoreRequest.class,
      responseType = com.google.cloud.discoveryengine.v1.IdentityMappingStore.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.CreateIdentityMappingStoreRequest,
          com.google.cloud.discoveryengine.v1.IdentityMappingStore>
      getCreateIdentityMappingStoreMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1.CreateIdentityMappingStoreRequest,
            com.google.cloud.discoveryengine.v1.IdentityMappingStore>
        getCreateIdentityMappingStoreMethod;
    if ((getCreateIdentityMappingStoreMethod =
            IdentityMappingStoreServiceGrpc.getCreateIdentityMappingStoreMethod)
        == null) {
      synchronized (IdentityMappingStoreServiceGrpc.class) {
        if ((getCreateIdentityMappingStoreMethod =
                IdentityMappingStoreServiceGrpc.getCreateIdentityMappingStoreMethod)
            == null) {
          IdentityMappingStoreServiceGrpc.getCreateIdentityMappingStoreMethod =
              getCreateIdentityMappingStoreMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1.CreateIdentityMappingStoreRequest,
                          com.google.cloud.discoveryengine.v1.IdentityMappingStore>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateIdentityMappingStore"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.CreateIdentityMappingStoreRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.IdentityMappingStore
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IdentityMappingStoreServiceMethodDescriptorSupplier(
                              "CreateIdentityMappingStore"))
                      .build();
        }
      }
    }
    return getCreateIdentityMappingStoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.GetIdentityMappingStoreRequest,
          com.google.cloud.discoveryengine.v1.IdentityMappingStore>
      getGetIdentityMappingStoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIdentityMappingStore",
      requestType = com.google.cloud.discoveryengine.v1.GetIdentityMappingStoreRequest.class,
      responseType = com.google.cloud.discoveryengine.v1.IdentityMappingStore.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.GetIdentityMappingStoreRequest,
          com.google.cloud.discoveryengine.v1.IdentityMappingStore>
      getGetIdentityMappingStoreMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1.GetIdentityMappingStoreRequest,
            com.google.cloud.discoveryengine.v1.IdentityMappingStore>
        getGetIdentityMappingStoreMethod;
    if ((getGetIdentityMappingStoreMethod =
            IdentityMappingStoreServiceGrpc.getGetIdentityMappingStoreMethod)
        == null) {
      synchronized (IdentityMappingStoreServiceGrpc.class) {
        if ((getGetIdentityMappingStoreMethod =
                IdentityMappingStoreServiceGrpc.getGetIdentityMappingStoreMethod)
            == null) {
          IdentityMappingStoreServiceGrpc.getGetIdentityMappingStoreMethod =
              getGetIdentityMappingStoreMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1.GetIdentityMappingStoreRequest,
                          com.google.cloud.discoveryengine.v1.IdentityMappingStore>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetIdentityMappingStore"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.GetIdentityMappingStoreRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.IdentityMappingStore
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IdentityMappingStoreServiceMethodDescriptorSupplier(
                              "GetIdentityMappingStore"))
                      .build();
        }
      }
    }
    return getGetIdentityMappingStoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.DeleteIdentityMappingStoreRequest,
          com.google.longrunning.Operation>
      getDeleteIdentityMappingStoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteIdentityMappingStore",
      requestType = com.google.cloud.discoveryengine.v1.DeleteIdentityMappingStoreRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.DeleteIdentityMappingStoreRequest,
          com.google.longrunning.Operation>
      getDeleteIdentityMappingStoreMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1.DeleteIdentityMappingStoreRequest,
            com.google.longrunning.Operation>
        getDeleteIdentityMappingStoreMethod;
    if ((getDeleteIdentityMappingStoreMethod =
            IdentityMappingStoreServiceGrpc.getDeleteIdentityMappingStoreMethod)
        == null) {
      synchronized (IdentityMappingStoreServiceGrpc.class) {
        if ((getDeleteIdentityMappingStoreMethod =
                IdentityMappingStoreServiceGrpc.getDeleteIdentityMappingStoreMethod)
            == null) {
          IdentityMappingStoreServiceGrpc.getDeleteIdentityMappingStoreMethod =
              getDeleteIdentityMappingStoreMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1.DeleteIdentityMappingStoreRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteIdentityMappingStore"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.DeleteIdentityMappingStoreRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IdentityMappingStoreServiceMethodDescriptorSupplier(
                              "DeleteIdentityMappingStore"))
                      .build();
        }
      }
    }
    return getDeleteIdentityMappingStoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.ImportIdentityMappingsRequest,
          com.google.longrunning.Operation>
      getImportIdentityMappingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportIdentityMappings",
      requestType = com.google.cloud.discoveryengine.v1.ImportIdentityMappingsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.ImportIdentityMappingsRequest,
          com.google.longrunning.Operation>
      getImportIdentityMappingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1.ImportIdentityMappingsRequest,
            com.google.longrunning.Operation>
        getImportIdentityMappingsMethod;
    if ((getImportIdentityMappingsMethod =
            IdentityMappingStoreServiceGrpc.getImportIdentityMappingsMethod)
        == null) {
      synchronized (IdentityMappingStoreServiceGrpc.class) {
        if ((getImportIdentityMappingsMethod =
                IdentityMappingStoreServiceGrpc.getImportIdentityMappingsMethod)
            == null) {
          IdentityMappingStoreServiceGrpc.getImportIdentityMappingsMethod =
              getImportIdentityMappingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1.ImportIdentityMappingsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ImportIdentityMappings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.ImportIdentityMappingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IdentityMappingStoreServiceMethodDescriptorSupplier(
                              "ImportIdentityMappings"))
                      .build();
        }
      }
    }
    return getImportIdentityMappingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.PurgeIdentityMappingsRequest,
          com.google.longrunning.Operation>
      getPurgeIdentityMappingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PurgeIdentityMappings",
      requestType = com.google.cloud.discoveryengine.v1.PurgeIdentityMappingsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.PurgeIdentityMappingsRequest,
          com.google.longrunning.Operation>
      getPurgeIdentityMappingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1.PurgeIdentityMappingsRequest,
            com.google.longrunning.Operation>
        getPurgeIdentityMappingsMethod;
    if ((getPurgeIdentityMappingsMethod =
            IdentityMappingStoreServiceGrpc.getPurgeIdentityMappingsMethod)
        == null) {
      synchronized (IdentityMappingStoreServiceGrpc.class) {
        if ((getPurgeIdentityMappingsMethod =
                IdentityMappingStoreServiceGrpc.getPurgeIdentityMappingsMethod)
            == null) {
          IdentityMappingStoreServiceGrpc.getPurgeIdentityMappingsMethod =
              getPurgeIdentityMappingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1.PurgeIdentityMappingsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "PurgeIdentityMappings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.PurgeIdentityMappingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IdentityMappingStoreServiceMethodDescriptorSupplier(
                              "PurgeIdentityMappings"))
                      .build();
        }
      }
    }
    return getPurgeIdentityMappingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.ListIdentityMappingsRequest,
          com.google.cloud.discoveryengine.v1.ListIdentityMappingsResponse>
      getListIdentityMappingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListIdentityMappings",
      requestType = com.google.cloud.discoveryengine.v1.ListIdentityMappingsRequest.class,
      responseType = com.google.cloud.discoveryengine.v1.ListIdentityMappingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.ListIdentityMappingsRequest,
          com.google.cloud.discoveryengine.v1.ListIdentityMappingsResponse>
      getListIdentityMappingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1.ListIdentityMappingsRequest,
            com.google.cloud.discoveryengine.v1.ListIdentityMappingsResponse>
        getListIdentityMappingsMethod;
    if ((getListIdentityMappingsMethod =
            IdentityMappingStoreServiceGrpc.getListIdentityMappingsMethod)
        == null) {
      synchronized (IdentityMappingStoreServiceGrpc.class) {
        if ((getListIdentityMappingsMethod =
                IdentityMappingStoreServiceGrpc.getListIdentityMappingsMethod)
            == null) {
          IdentityMappingStoreServiceGrpc.getListIdentityMappingsMethod =
              getListIdentityMappingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1.ListIdentityMappingsRequest,
                          com.google.cloud.discoveryengine.v1.ListIdentityMappingsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListIdentityMappings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.ListIdentityMappingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.ListIdentityMappingsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IdentityMappingStoreServiceMethodDescriptorSupplier(
                              "ListIdentityMappings"))
                      .build();
        }
      }
    }
    return getListIdentityMappingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.ListIdentityMappingStoresRequest,
          com.google.cloud.discoveryengine.v1.ListIdentityMappingStoresResponse>
      getListIdentityMappingStoresMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListIdentityMappingStores",
      requestType = com.google.cloud.discoveryengine.v1.ListIdentityMappingStoresRequest.class,
      responseType = com.google.cloud.discoveryengine.v1.ListIdentityMappingStoresResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.ListIdentityMappingStoresRequest,
          com.google.cloud.discoveryengine.v1.ListIdentityMappingStoresResponse>
      getListIdentityMappingStoresMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1.ListIdentityMappingStoresRequest,
            com.google.cloud.discoveryengine.v1.ListIdentityMappingStoresResponse>
        getListIdentityMappingStoresMethod;
    if ((getListIdentityMappingStoresMethod =
            IdentityMappingStoreServiceGrpc.getListIdentityMappingStoresMethod)
        == null) {
      synchronized (IdentityMappingStoreServiceGrpc.class) {
        if ((getListIdentityMappingStoresMethod =
                IdentityMappingStoreServiceGrpc.getListIdentityMappingStoresMethod)
            == null) {
          IdentityMappingStoreServiceGrpc.getListIdentityMappingStoresMethod =
              getListIdentityMappingStoresMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1.ListIdentityMappingStoresRequest,
                          com.google.cloud.discoveryengine.v1.ListIdentityMappingStoresResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListIdentityMappingStores"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.ListIdentityMappingStoresRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.ListIdentityMappingStoresResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IdentityMappingStoreServiceMethodDescriptorSupplier(
                              "ListIdentityMappingStores"))
                      .build();
        }
      }
    }
    return getListIdentityMappingStoresMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static IdentityMappingStoreServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IdentityMappingStoreServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<IdentityMappingStoreServiceStub>() {
          @java.lang.Override
          public IdentityMappingStoreServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IdentityMappingStoreServiceStub(channel, callOptions);
          }
        };
    return IdentityMappingStoreServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static IdentityMappingStoreServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IdentityMappingStoreServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<IdentityMappingStoreServiceBlockingV2Stub>() {
          @java.lang.Override
          public IdentityMappingStoreServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IdentityMappingStoreServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return IdentityMappingStoreServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static IdentityMappingStoreServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IdentityMappingStoreServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<IdentityMappingStoreServiceBlockingStub>() {
          @java.lang.Override
          public IdentityMappingStoreServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IdentityMappingStoreServiceBlockingStub(channel, callOptions);
          }
        };
    return IdentityMappingStoreServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static IdentityMappingStoreServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IdentityMappingStoreServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<IdentityMappingStoreServiceFutureStub>() {
          @java.lang.Override
          public IdentityMappingStoreServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IdentityMappingStoreServiceFutureStub(channel, callOptions);
          }
        };
    return IdentityMappingStoreServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing Identity Mapping Stores.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a new Identity Mapping Store.
     * </pre>
     */
    default void createIdentityMappingStore(
        com.google.cloud.discoveryengine.v1.CreateIdentityMappingStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.IdentityMappingStore>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateIdentityMappingStoreMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the Identity Mapping Store.
     * </pre>
     */
    default void getIdentityMappingStore(
        com.google.cloud.discoveryengine.v1.GetIdentityMappingStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.IdentityMappingStore>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetIdentityMappingStoreMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the Identity Mapping Store.
     * </pre>
     */
    default void deleteIdentityMappingStore(
        com.google.cloud.discoveryengine.v1.DeleteIdentityMappingStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteIdentityMappingStoreMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports a list of Identity Mapping Entries to an Identity Mapping Store.
     * </pre>
     */
    default void importIdentityMappings(
        com.google.cloud.discoveryengine.v1.ImportIdentityMappingsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getImportIdentityMappingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Purges specified or all Identity Mapping Entries from an Identity Mapping
     * Store.
     * </pre>
     */
    default void purgeIdentityMappings(
        com.google.cloud.discoveryengine.v1.PurgeIdentityMappingsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getPurgeIdentityMappingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Identity Mappings in an Identity Mapping Store.
     * </pre>
     */
    default void listIdentityMappings(
        com.google.cloud.discoveryengine.v1.ListIdentityMappingsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.discoveryengine.v1.ListIdentityMappingsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListIdentityMappingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all Identity Mapping Stores.
     * </pre>
     */
    default void listIdentityMappingStores(
        com.google.cloud.discoveryengine.v1.ListIdentityMappingStoresRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.discoveryengine.v1.ListIdentityMappingStoresResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListIdentityMappingStoresMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service IdentityMappingStoreService.
   *
   * <pre>
   * Service for managing Identity Mapping Stores.
   * </pre>
   */
  public abstract static class IdentityMappingStoreServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return IdentityMappingStoreServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service IdentityMappingStoreService.
   *
   * <pre>
   * Service for managing Identity Mapping Stores.
   * </pre>
   */
  public static final class IdentityMappingStoreServiceStub
      extends io.grpc.stub.AbstractAsyncStub<IdentityMappingStoreServiceStub> {
    private IdentityMappingStoreServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IdentityMappingStoreServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IdentityMappingStoreServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Identity Mapping Store.
     * </pre>
     */
    public void createIdentityMappingStore(
        com.google.cloud.discoveryengine.v1.CreateIdentityMappingStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.IdentityMappingStore>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateIdentityMappingStoreMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the Identity Mapping Store.
     * </pre>
     */
    public void getIdentityMappingStore(
        com.google.cloud.discoveryengine.v1.GetIdentityMappingStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.IdentityMappingStore>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIdentityMappingStoreMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the Identity Mapping Store.
     * </pre>
     */
    public void deleteIdentityMappingStore(
        com.google.cloud.discoveryengine.v1.DeleteIdentityMappingStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteIdentityMappingStoreMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports a list of Identity Mapping Entries to an Identity Mapping Store.
     * </pre>
     */
    public void importIdentityMappings(
        com.google.cloud.discoveryengine.v1.ImportIdentityMappingsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportIdentityMappingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Purges specified or all Identity Mapping Entries from an Identity Mapping
     * Store.
     * </pre>
     */
    public void purgeIdentityMappings(
        com.google.cloud.discoveryengine.v1.PurgeIdentityMappingsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPurgeIdentityMappingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Identity Mappings in an Identity Mapping Store.
     * </pre>
     */
    public void listIdentityMappings(
        com.google.cloud.discoveryengine.v1.ListIdentityMappingsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.discoveryengine.v1.ListIdentityMappingsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListIdentityMappingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all Identity Mapping Stores.
     * </pre>
     */
    public void listIdentityMappingStores(
        com.google.cloud.discoveryengine.v1.ListIdentityMappingStoresRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.discoveryengine.v1.ListIdentityMappingStoresResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListIdentityMappingStoresMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service IdentityMappingStoreService.
   *
   * <pre>
   * Service for managing Identity Mapping Stores.
   * </pre>
   */
  public static final class IdentityMappingStoreServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<IdentityMappingStoreServiceBlockingV2Stub> {
    private IdentityMappingStoreServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IdentityMappingStoreServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IdentityMappingStoreServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Identity Mapping Store.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1.IdentityMappingStore createIdentityMappingStore(
        com.google.cloud.discoveryengine.v1.CreateIdentityMappingStoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateIdentityMappingStoreMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the Identity Mapping Store.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1.IdentityMappingStore getIdentityMappingStore(
        com.google.cloud.discoveryengine.v1.GetIdentityMappingStoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIdentityMappingStoreMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the Identity Mapping Store.
     * </pre>
     */
    public com.google.longrunning.Operation deleteIdentityMappingStore(
        com.google.cloud.discoveryengine.v1.DeleteIdentityMappingStoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteIdentityMappingStoreMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports a list of Identity Mapping Entries to an Identity Mapping Store.
     * </pre>
     */
    public com.google.longrunning.Operation importIdentityMappings(
        com.google.cloud.discoveryengine.v1.ImportIdentityMappingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportIdentityMappingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Purges specified or all Identity Mapping Entries from an Identity Mapping
     * Store.
     * </pre>
     */
    public com.google.longrunning.Operation purgeIdentityMappings(
        com.google.cloud.discoveryengine.v1.PurgeIdentityMappingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPurgeIdentityMappingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Identity Mappings in an Identity Mapping Store.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1.ListIdentityMappingsResponse listIdentityMappings(
        com.google.cloud.discoveryengine.v1.ListIdentityMappingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListIdentityMappingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all Identity Mapping Stores.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1.ListIdentityMappingStoresResponse
        listIdentityMappingStores(
            com.google.cloud.discoveryengine.v1.ListIdentityMappingStoresRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListIdentityMappingStoresMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service
   * IdentityMappingStoreService.
   *
   * <pre>
   * Service for managing Identity Mapping Stores.
   * </pre>
   */
  public static final class IdentityMappingStoreServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<IdentityMappingStoreServiceBlockingStub> {
    private IdentityMappingStoreServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IdentityMappingStoreServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IdentityMappingStoreServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Identity Mapping Store.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1.IdentityMappingStore createIdentityMappingStore(
        com.google.cloud.discoveryengine.v1.CreateIdentityMappingStoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateIdentityMappingStoreMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the Identity Mapping Store.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1.IdentityMappingStore getIdentityMappingStore(
        com.google.cloud.discoveryengine.v1.GetIdentityMappingStoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIdentityMappingStoreMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the Identity Mapping Store.
     * </pre>
     */
    public com.google.longrunning.Operation deleteIdentityMappingStore(
        com.google.cloud.discoveryengine.v1.DeleteIdentityMappingStoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteIdentityMappingStoreMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports a list of Identity Mapping Entries to an Identity Mapping Store.
     * </pre>
     */
    public com.google.longrunning.Operation importIdentityMappings(
        com.google.cloud.discoveryengine.v1.ImportIdentityMappingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportIdentityMappingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Purges specified or all Identity Mapping Entries from an Identity Mapping
     * Store.
     * </pre>
     */
    public com.google.longrunning.Operation purgeIdentityMappings(
        com.google.cloud.discoveryengine.v1.PurgeIdentityMappingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPurgeIdentityMappingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Identity Mappings in an Identity Mapping Store.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1.ListIdentityMappingsResponse listIdentityMappings(
        com.google.cloud.discoveryengine.v1.ListIdentityMappingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListIdentityMappingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all Identity Mapping Stores.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1.ListIdentityMappingStoresResponse
        listIdentityMappingStores(
            com.google.cloud.discoveryengine.v1.ListIdentityMappingStoresRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListIdentityMappingStoresMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * IdentityMappingStoreService.
   *
   * <pre>
   * Service for managing Identity Mapping Stores.
   * </pre>
   */
  public static final class IdentityMappingStoreServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<IdentityMappingStoreServiceFutureStub> {
    private IdentityMappingStoreServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IdentityMappingStoreServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IdentityMappingStoreServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Identity Mapping Store.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1.IdentityMappingStore>
        createIdentityMappingStore(
            com.google.cloud.discoveryengine.v1.CreateIdentityMappingStoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateIdentityMappingStoreMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the Identity Mapping Store.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1.IdentityMappingStore>
        getIdentityMappingStore(
            com.google.cloud.discoveryengine.v1.GetIdentityMappingStoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIdentityMappingStoreMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the Identity Mapping Store.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteIdentityMappingStore(
            com.google.cloud.discoveryengine.v1.DeleteIdentityMappingStoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteIdentityMappingStoreMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Imports a list of Identity Mapping Entries to an Identity Mapping Store.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        importIdentityMappings(
            com.google.cloud.discoveryengine.v1.ImportIdentityMappingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportIdentityMappingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Purges specified or all Identity Mapping Entries from an Identity Mapping
     * Store.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        purgeIdentityMappings(
            com.google.cloud.discoveryengine.v1.PurgeIdentityMappingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPurgeIdentityMappingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Identity Mappings in an Identity Mapping Store.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1.ListIdentityMappingsResponse>
        listIdentityMappings(
            com.google.cloud.discoveryengine.v1.ListIdentityMappingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListIdentityMappingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all Identity Mapping Stores.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1.ListIdentityMappingStoresResponse>
        listIdentityMappingStores(
            com.google.cloud.discoveryengine.v1.ListIdentityMappingStoresRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListIdentityMappingStoresMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_IDENTITY_MAPPING_STORE = 0;
  private static final int METHODID_GET_IDENTITY_MAPPING_STORE = 1;
  private static final int METHODID_DELETE_IDENTITY_MAPPING_STORE = 2;
  private static final int METHODID_IMPORT_IDENTITY_MAPPINGS = 3;
  private static final int METHODID_PURGE_IDENTITY_MAPPINGS = 4;
  private static final int METHODID_LIST_IDENTITY_MAPPINGS = 5;
  private static final int METHODID_LIST_IDENTITY_MAPPING_STORES = 6;

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
        case METHODID_CREATE_IDENTITY_MAPPING_STORE:
          serviceImpl.createIdentityMappingStore(
              (com.google.cloud.discoveryengine.v1.CreateIdentityMappingStoreRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.discoveryengine.v1.IdentityMappingStore>)
                  responseObserver);
          break;
        case METHODID_GET_IDENTITY_MAPPING_STORE:
          serviceImpl.getIdentityMappingStore(
              (com.google.cloud.discoveryengine.v1.GetIdentityMappingStoreRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.discoveryengine.v1.IdentityMappingStore>)
                  responseObserver);
          break;
        case METHODID_DELETE_IDENTITY_MAPPING_STORE:
          serviceImpl.deleteIdentityMappingStore(
              (com.google.cloud.discoveryengine.v1.DeleteIdentityMappingStoreRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_IMPORT_IDENTITY_MAPPINGS:
          serviceImpl.importIdentityMappings(
              (com.google.cloud.discoveryengine.v1.ImportIdentityMappingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_PURGE_IDENTITY_MAPPINGS:
          serviceImpl.purgeIdentityMappings(
              (com.google.cloud.discoveryengine.v1.PurgeIdentityMappingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_IDENTITY_MAPPINGS:
          serviceImpl.listIdentityMappings(
              (com.google.cloud.discoveryengine.v1.ListIdentityMappingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.discoveryengine.v1.ListIdentityMappingsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_IDENTITY_MAPPING_STORES:
          serviceImpl.listIdentityMappingStores(
              (com.google.cloud.discoveryengine.v1.ListIdentityMappingStoresRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.discoveryengine.v1.ListIdentityMappingStoresResponse>)
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
            getCreateIdentityMappingStoreMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1.CreateIdentityMappingStoreRequest,
                    com.google.cloud.discoveryengine.v1.IdentityMappingStore>(
                    service, METHODID_CREATE_IDENTITY_MAPPING_STORE)))
        .addMethod(
            getGetIdentityMappingStoreMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1.GetIdentityMappingStoreRequest,
                    com.google.cloud.discoveryengine.v1.IdentityMappingStore>(
                    service, METHODID_GET_IDENTITY_MAPPING_STORE)))
        .addMethod(
            getDeleteIdentityMappingStoreMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1.DeleteIdentityMappingStoreRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_IDENTITY_MAPPING_STORE)))
        .addMethod(
            getImportIdentityMappingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1.ImportIdentityMappingsRequest,
                    com.google.longrunning.Operation>(service, METHODID_IMPORT_IDENTITY_MAPPINGS)))
        .addMethod(
            getPurgeIdentityMappingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1.PurgeIdentityMappingsRequest,
                    com.google.longrunning.Operation>(service, METHODID_PURGE_IDENTITY_MAPPINGS)))
        .addMethod(
            getListIdentityMappingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1.ListIdentityMappingsRequest,
                    com.google.cloud.discoveryengine.v1.ListIdentityMappingsResponse>(
                    service, METHODID_LIST_IDENTITY_MAPPINGS)))
        .addMethod(
            getListIdentityMappingStoresMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1.ListIdentityMappingStoresRequest,
                    com.google.cloud.discoveryengine.v1.ListIdentityMappingStoresResponse>(
                    service, METHODID_LIST_IDENTITY_MAPPING_STORES)))
        .build();
  }

  private abstract static class IdentityMappingStoreServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    IdentityMappingStoreServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.discoveryengine.v1.IdentityMappingStoreServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("IdentityMappingStoreService");
    }
  }

  private static final class IdentityMappingStoreServiceFileDescriptorSupplier
      extends IdentityMappingStoreServiceBaseDescriptorSupplier {
    IdentityMappingStoreServiceFileDescriptorSupplier() {}
  }

  private static final class IdentityMappingStoreServiceMethodDescriptorSupplier
      extends IdentityMappingStoreServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    IdentityMappingStoreServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (IdentityMappingStoreServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new IdentityMappingStoreServiceFileDescriptorSupplier())
                      .addMethod(getCreateIdentityMappingStoreMethod())
                      .addMethod(getGetIdentityMappingStoreMethod())
                      .addMethod(getDeleteIdentityMappingStoreMethod())
                      .addMethod(getImportIdentityMappingsMethod())
                      .addMethod(getPurgeIdentityMappingsMethod())
                      .addMethod(getListIdentityMappingsMethod())
                      .addMethod(getListIdentityMappingStoresMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
