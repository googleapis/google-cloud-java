/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.iap.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * API to programmatically create, list and retrieve Identity Aware Proxy (IAP)
 * OAuth brands; and create, retrieve, delete and reset-secret of IAP OAuth
 * clients.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/iap/v1/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class IdentityAwareProxyOAuthServiceGrpc {

  private IdentityAwareProxyOAuthServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.iap.v1.IdentityAwareProxyOAuthService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.iap.v1.ListBrandsRequest, com.google.cloud.iap.v1.ListBrandsResponse>
      getListBrandsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBrands",
      requestType = com.google.cloud.iap.v1.ListBrandsRequest.class,
      responseType = com.google.cloud.iap.v1.ListBrandsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.iap.v1.ListBrandsRequest, com.google.cloud.iap.v1.ListBrandsResponse>
      getListBrandsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.iap.v1.ListBrandsRequest, com.google.cloud.iap.v1.ListBrandsResponse>
        getListBrandsMethod;
    if ((getListBrandsMethod = IdentityAwareProxyOAuthServiceGrpc.getListBrandsMethod) == null) {
      synchronized (IdentityAwareProxyOAuthServiceGrpc.class) {
        if ((getListBrandsMethod = IdentityAwareProxyOAuthServiceGrpc.getListBrandsMethod)
            == null) {
          IdentityAwareProxyOAuthServiceGrpc.getListBrandsMethod =
              getListBrandsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.iap.v1.ListBrandsRequest,
                          com.google.cloud.iap.v1.ListBrandsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListBrands"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iap.v1.ListBrandsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iap.v1.ListBrandsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IdentityAwareProxyOAuthServiceMethodDescriptorSupplier("ListBrands"))
                      .build();
        }
      }
    }
    return getListBrandsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.iap.v1.CreateBrandRequest, com.google.cloud.iap.v1.Brand>
      getCreateBrandMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBrand",
      requestType = com.google.cloud.iap.v1.CreateBrandRequest.class,
      responseType = com.google.cloud.iap.v1.Brand.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.iap.v1.CreateBrandRequest, com.google.cloud.iap.v1.Brand>
      getCreateBrandMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.iap.v1.CreateBrandRequest, com.google.cloud.iap.v1.Brand>
        getCreateBrandMethod;
    if ((getCreateBrandMethod = IdentityAwareProxyOAuthServiceGrpc.getCreateBrandMethod) == null) {
      synchronized (IdentityAwareProxyOAuthServiceGrpc.class) {
        if ((getCreateBrandMethod = IdentityAwareProxyOAuthServiceGrpc.getCreateBrandMethod)
            == null) {
          IdentityAwareProxyOAuthServiceGrpc.getCreateBrandMethod =
              getCreateBrandMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.iap.v1.CreateBrandRequest, com.google.cloud.iap.v1.Brand>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateBrand"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iap.v1.CreateBrandRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iap.v1.Brand.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IdentityAwareProxyOAuthServiceMethodDescriptorSupplier("CreateBrand"))
                      .build();
        }
      }
    }
    return getCreateBrandMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.iap.v1.GetBrandRequest, com.google.cloud.iap.v1.Brand>
      getGetBrandMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBrand",
      requestType = com.google.cloud.iap.v1.GetBrandRequest.class,
      responseType = com.google.cloud.iap.v1.Brand.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.iap.v1.GetBrandRequest, com.google.cloud.iap.v1.Brand>
      getGetBrandMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.iap.v1.GetBrandRequest, com.google.cloud.iap.v1.Brand>
        getGetBrandMethod;
    if ((getGetBrandMethod = IdentityAwareProxyOAuthServiceGrpc.getGetBrandMethod) == null) {
      synchronized (IdentityAwareProxyOAuthServiceGrpc.class) {
        if ((getGetBrandMethod = IdentityAwareProxyOAuthServiceGrpc.getGetBrandMethod) == null) {
          IdentityAwareProxyOAuthServiceGrpc.getGetBrandMethod =
              getGetBrandMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.iap.v1.GetBrandRequest, com.google.cloud.iap.v1.Brand>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBrand"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iap.v1.GetBrandRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iap.v1.Brand.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IdentityAwareProxyOAuthServiceMethodDescriptorSupplier("GetBrand"))
                      .build();
        }
      }
    }
    return getGetBrandMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.iap.v1.CreateIdentityAwareProxyClientRequest,
          com.google.cloud.iap.v1.IdentityAwareProxyClient>
      getCreateIdentityAwareProxyClientMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateIdentityAwareProxyClient",
      requestType = com.google.cloud.iap.v1.CreateIdentityAwareProxyClientRequest.class,
      responseType = com.google.cloud.iap.v1.IdentityAwareProxyClient.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.iap.v1.CreateIdentityAwareProxyClientRequest,
          com.google.cloud.iap.v1.IdentityAwareProxyClient>
      getCreateIdentityAwareProxyClientMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.iap.v1.CreateIdentityAwareProxyClientRequest,
            com.google.cloud.iap.v1.IdentityAwareProxyClient>
        getCreateIdentityAwareProxyClientMethod;
    if ((getCreateIdentityAwareProxyClientMethod =
            IdentityAwareProxyOAuthServiceGrpc.getCreateIdentityAwareProxyClientMethod)
        == null) {
      synchronized (IdentityAwareProxyOAuthServiceGrpc.class) {
        if ((getCreateIdentityAwareProxyClientMethod =
                IdentityAwareProxyOAuthServiceGrpc.getCreateIdentityAwareProxyClientMethod)
            == null) {
          IdentityAwareProxyOAuthServiceGrpc.getCreateIdentityAwareProxyClientMethod =
              getCreateIdentityAwareProxyClientMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.iap.v1.CreateIdentityAwareProxyClientRequest,
                          com.google.cloud.iap.v1.IdentityAwareProxyClient>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateIdentityAwareProxyClient"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iap.v1.CreateIdentityAwareProxyClientRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iap.v1.IdentityAwareProxyClient
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IdentityAwareProxyOAuthServiceMethodDescriptorSupplier(
                              "CreateIdentityAwareProxyClient"))
                      .build();
        }
      }
    }
    return getCreateIdentityAwareProxyClientMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.iap.v1.ListIdentityAwareProxyClientsRequest,
          com.google.cloud.iap.v1.ListIdentityAwareProxyClientsResponse>
      getListIdentityAwareProxyClientsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListIdentityAwareProxyClients",
      requestType = com.google.cloud.iap.v1.ListIdentityAwareProxyClientsRequest.class,
      responseType = com.google.cloud.iap.v1.ListIdentityAwareProxyClientsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.iap.v1.ListIdentityAwareProxyClientsRequest,
          com.google.cloud.iap.v1.ListIdentityAwareProxyClientsResponse>
      getListIdentityAwareProxyClientsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.iap.v1.ListIdentityAwareProxyClientsRequest,
            com.google.cloud.iap.v1.ListIdentityAwareProxyClientsResponse>
        getListIdentityAwareProxyClientsMethod;
    if ((getListIdentityAwareProxyClientsMethod =
            IdentityAwareProxyOAuthServiceGrpc.getListIdentityAwareProxyClientsMethod)
        == null) {
      synchronized (IdentityAwareProxyOAuthServiceGrpc.class) {
        if ((getListIdentityAwareProxyClientsMethod =
                IdentityAwareProxyOAuthServiceGrpc.getListIdentityAwareProxyClientsMethod)
            == null) {
          IdentityAwareProxyOAuthServiceGrpc.getListIdentityAwareProxyClientsMethod =
              getListIdentityAwareProxyClientsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.iap.v1.ListIdentityAwareProxyClientsRequest,
                          com.google.cloud.iap.v1.ListIdentityAwareProxyClientsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListIdentityAwareProxyClients"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iap.v1.ListIdentityAwareProxyClientsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iap.v1.ListIdentityAwareProxyClientsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IdentityAwareProxyOAuthServiceMethodDescriptorSupplier(
                              "ListIdentityAwareProxyClients"))
                      .build();
        }
      }
    }
    return getListIdentityAwareProxyClientsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.iap.v1.GetIdentityAwareProxyClientRequest,
          com.google.cloud.iap.v1.IdentityAwareProxyClient>
      getGetIdentityAwareProxyClientMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIdentityAwareProxyClient",
      requestType = com.google.cloud.iap.v1.GetIdentityAwareProxyClientRequest.class,
      responseType = com.google.cloud.iap.v1.IdentityAwareProxyClient.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.iap.v1.GetIdentityAwareProxyClientRequest,
          com.google.cloud.iap.v1.IdentityAwareProxyClient>
      getGetIdentityAwareProxyClientMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.iap.v1.GetIdentityAwareProxyClientRequest,
            com.google.cloud.iap.v1.IdentityAwareProxyClient>
        getGetIdentityAwareProxyClientMethod;
    if ((getGetIdentityAwareProxyClientMethod =
            IdentityAwareProxyOAuthServiceGrpc.getGetIdentityAwareProxyClientMethod)
        == null) {
      synchronized (IdentityAwareProxyOAuthServiceGrpc.class) {
        if ((getGetIdentityAwareProxyClientMethod =
                IdentityAwareProxyOAuthServiceGrpc.getGetIdentityAwareProxyClientMethod)
            == null) {
          IdentityAwareProxyOAuthServiceGrpc.getGetIdentityAwareProxyClientMethod =
              getGetIdentityAwareProxyClientMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.iap.v1.GetIdentityAwareProxyClientRequest,
                          com.google.cloud.iap.v1.IdentityAwareProxyClient>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetIdentityAwareProxyClient"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iap.v1.GetIdentityAwareProxyClientRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iap.v1.IdentityAwareProxyClient
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IdentityAwareProxyOAuthServiceMethodDescriptorSupplier(
                              "GetIdentityAwareProxyClient"))
                      .build();
        }
      }
    }
    return getGetIdentityAwareProxyClientMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.iap.v1.ResetIdentityAwareProxyClientSecretRequest,
          com.google.cloud.iap.v1.IdentityAwareProxyClient>
      getResetIdentityAwareProxyClientSecretMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResetIdentityAwareProxyClientSecret",
      requestType = com.google.cloud.iap.v1.ResetIdentityAwareProxyClientSecretRequest.class,
      responseType = com.google.cloud.iap.v1.IdentityAwareProxyClient.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.iap.v1.ResetIdentityAwareProxyClientSecretRequest,
          com.google.cloud.iap.v1.IdentityAwareProxyClient>
      getResetIdentityAwareProxyClientSecretMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.iap.v1.ResetIdentityAwareProxyClientSecretRequest,
            com.google.cloud.iap.v1.IdentityAwareProxyClient>
        getResetIdentityAwareProxyClientSecretMethod;
    if ((getResetIdentityAwareProxyClientSecretMethod =
            IdentityAwareProxyOAuthServiceGrpc.getResetIdentityAwareProxyClientSecretMethod)
        == null) {
      synchronized (IdentityAwareProxyOAuthServiceGrpc.class) {
        if ((getResetIdentityAwareProxyClientSecretMethod =
                IdentityAwareProxyOAuthServiceGrpc.getResetIdentityAwareProxyClientSecretMethod)
            == null) {
          IdentityAwareProxyOAuthServiceGrpc.getResetIdentityAwareProxyClientSecretMethod =
              getResetIdentityAwareProxyClientSecretMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.iap.v1.ResetIdentityAwareProxyClientSecretRequest,
                          com.google.cloud.iap.v1.IdentityAwareProxyClient>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "ResetIdentityAwareProxyClientSecret"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iap.v1.ResetIdentityAwareProxyClientSecretRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iap.v1.IdentityAwareProxyClient
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IdentityAwareProxyOAuthServiceMethodDescriptorSupplier(
                              "ResetIdentityAwareProxyClientSecret"))
                      .build();
        }
      }
    }
    return getResetIdentityAwareProxyClientSecretMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.iap.v1.DeleteIdentityAwareProxyClientRequest, com.google.protobuf.Empty>
      getDeleteIdentityAwareProxyClientMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteIdentityAwareProxyClient",
      requestType = com.google.cloud.iap.v1.DeleteIdentityAwareProxyClientRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.iap.v1.DeleteIdentityAwareProxyClientRequest, com.google.protobuf.Empty>
      getDeleteIdentityAwareProxyClientMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.iap.v1.DeleteIdentityAwareProxyClientRequest,
            com.google.protobuf.Empty>
        getDeleteIdentityAwareProxyClientMethod;
    if ((getDeleteIdentityAwareProxyClientMethod =
            IdentityAwareProxyOAuthServiceGrpc.getDeleteIdentityAwareProxyClientMethod)
        == null) {
      synchronized (IdentityAwareProxyOAuthServiceGrpc.class) {
        if ((getDeleteIdentityAwareProxyClientMethod =
                IdentityAwareProxyOAuthServiceGrpc.getDeleteIdentityAwareProxyClientMethod)
            == null) {
          IdentityAwareProxyOAuthServiceGrpc.getDeleteIdentityAwareProxyClientMethod =
              getDeleteIdentityAwareProxyClientMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.iap.v1.DeleteIdentityAwareProxyClientRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteIdentityAwareProxyClient"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.iap.v1.DeleteIdentityAwareProxyClientRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IdentityAwareProxyOAuthServiceMethodDescriptorSupplier(
                              "DeleteIdentityAwareProxyClient"))
                      .build();
        }
      }
    }
    return getDeleteIdentityAwareProxyClientMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static IdentityAwareProxyOAuthServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IdentityAwareProxyOAuthServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<IdentityAwareProxyOAuthServiceStub>() {
          @java.lang.Override
          public IdentityAwareProxyOAuthServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IdentityAwareProxyOAuthServiceStub(channel, callOptions);
          }
        };
    return IdentityAwareProxyOAuthServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static IdentityAwareProxyOAuthServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IdentityAwareProxyOAuthServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<IdentityAwareProxyOAuthServiceBlockingStub>() {
          @java.lang.Override
          public IdentityAwareProxyOAuthServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IdentityAwareProxyOAuthServiceBlockingStub(channel, callOptions);
          }
        };
    return IdentityAwareProxyOAuthServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static IdentityAwareProxyOAuthServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IdentityAwareProxyOAuthServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<IdentityAwareProxyOAuthServiceFutureStub>() {
          @java.lang.Override
          public IdentityAwareProxyOAuthServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IdentityAwareProxyOAuthServiceFutureStub(channel, callOptions);
          }
        };
    return IdentityAwareProxyOAuthServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * API to programmatically create, list and retrieve Identity Aware Proxy (IAP)
   * OAuth brands; and create, retrieve, delete and reset-secret of IAP OAuth
   * clients.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists the existing brands for the project.
     * </pre>
     */
    default void listBrands(
        com.google.cloud.iap.v1.ListBrandsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iap.v1.ListBrandsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListBrandsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Constructs a new OAuth brand for the project if one does not exist.
     * The created brand is "internal only", meaning that OAuth clients created
     * under it only accept requests from users who belong to the same Google
     * Workspace organization as the project. The brand is created in an
     * un-reviewed status. NOTE: The "internal only" status can be manually
     * changed in the Google Cloud Console. Requires that a brand does not already
     * exist for the project, and that the specified support email is owned by the
     * caller.
     * </pre>
     */
    default void createBrand(
        com.google.cloud.iap.v1.CreateBrandRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iap.v1.Brand> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateBrandMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the OAuth brand of the project.
     * </pre>
     */
    default void getBrand(
        com.google.cloud.iap.v1.GetBrandRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iap.v1.Brand> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBrandMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an Identity Aware Proxy (IAP) OAuth client. The client is owned
     * by IAP. Requires that the brand for the project exists and that it is
     * set for internal-only use.
     * </pre>
     */
    default void createIdentityAwareProxyClient(
        com.google.cloud.iap.v1.CreateIdentityAwareProxyClientRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iap.v1.IdentityAwareProxyClient>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateIdentityAwareProxyClientMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the existing clients for the brand.
     * </pre>
     */
    default void listIdentityAwareProxyClients(
        com.google.cloud.iap.v1.ListIdentityAwareProxyClientsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iap.v1.ListIdentityAwareProxyClientsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListIdentityAwareProxyClientsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves an Identity Aware Proxy (IAP) OAuth client.
     * Requires that the client is owned by IAP.
     * </pre>
     */
    default void getIdentityAwareProxyClient(
        com.google.cloud.iap.v1.GetIdentityAwareProxyClientRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iap.v1.IdentityAwareProxyClient>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetIdentityAwareProxyClientMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resets an Identity Aware Proxy (IAP) OAuth client secret. Useful if the
     * secret was compromised. Requires that the client is owned by IAP.
     * </pre>
     */
    default void resetIdentityAwareProxyClientSecret(
        com.google.cloud.iap.v1.ResetIdentityAwareProxyClientSecretRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iap.v1.IdentityAwareProxyClient>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getResetIdentityAwareProxyClientSecretMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an Identity Aware Proxy (IAP) OAuth client. Useful for removing
     * obsolete clients, managing the number of clients in a given project, and
     * cleaning up after tests. Requires that the client is owned by IAP.
     * </pre>
     */
    default void deleteIdentityAwareProxyClient(
        com.google.cloud.iap.v1.DeleteIdentityAwareProxyClientRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteIdentityAwareProxyClientMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service IdentityAwareProxyOAuthService.
   *
   * <pre>
   * API to programmatically create, list and retrieve Identity Aware Proxy (IAP)
   * OAuth brands; and create, retrieve, delete and reset-secret of IAP OAuth
   * clients.
   * </pre>
   */
  public abstract static class IdentityAwareProxyOAuthServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return IdentityAwareProxyOAuthServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service IdentityAwareProxyOAuthService.
   *
   * <pre>
   * API to programmatically create, list and retrieve Identity Aware Proxy (IAP)
   * OAuth brands; and create, retrieve, delete and reset-secret of IAP OAuth
   * clients.
   * </pre>
   */
  public static final class IdentityAwareProxyOAuthServiceStub
      extends io.grpc.stub.AbstractAsyncStub<IdentityAwareProxyOAuthServiceStub> {
    private IdentityAwareProxyOAuthServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IdentityAwareProxyOAuthServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IdentityAwareProxyOAuthServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists the existing brands for the project.
     * </pre>
     */
    public void listBrands(
        com.google.cloud.iap.v1.ListBrandsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iap.v1.ListBrandsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBrandsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Constructs a new OAuth brand for the project if one does not exist.
     * The created brand is "internal only", meaning that OAuth clients created
     * under it only accept requests from users who belong to the same Google
     * Workspace organization as the project. The brand is created in an
     * un-reviewed status. NOTE: The "internal only" status can be manually
     * changed in the Google Cloud Console. Requires that a brand does not already
     * exist for the project, and that the specified support email is owned by the
     * caller.
     * </pre>
     */
    public void createBrand(
        com.google.cloud.iap.v1.CreateBrandRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iap.v1.Brand> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateBrandMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the OAuth brand of the project.
     * </pre>
     */
    public void getBrand(
        com.google.cloud.iap.v1.GetBrandRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iap.v1.Brand> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBrandMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an Identity Aware Proxy (IAP) OAuth client. The client is owned
     * by IAP. Requires that the brand for the project exists and that it is
     * set for internal-only use.
     * </pre>
     */
    public void createIdentityAwareProxyClient(
        com.google.cloud.iap.v1.CreateIdentityAwareProxyClientRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iap.v1.IdentityAwareProxyClient>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateIdentityAwareProxyClientMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the existing clients for the brand.
     * </pre>
     */
    public void listIdentityAwareProxyClients(
        com.google.cloud.iap.v1.ListIdentityAwareProxyClientsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iap.v1.ListIdentityAwareProxyClientsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListIdentityAwareProxyClientsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves an Identity Aware Proxy (IAP) OAuth client.
     * Requires that the client is owned by IAP.
     * </pre>
     */
    public void getIdentityAwareProxyClient(
        com.google.cloud.iap.v1.GetIdentityAwareProxyClientRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iap.v1.IdentityAwareProxyClient>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIdentityAwareProxyClientMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resets an Identity Aware Proxy (IAP) OAuth client secret. Useful if the
     * secret was compromised. Requires that the client is owned by IAP.
     * </pre>
     */
    public void resetIdentityAwareProxyClientSecret(
        com.google.cloud.iap.v1.ResetIdentityAwareProxyClientSecretRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.iap.v1.IdentityAwareProxyClient>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResetIdentityAwareProxyClientSecretMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an Identity Aware Proxy (IAP) OAuth client. Useful for removing
     * obsolete clients, managing the number of clients in a given project, and
     * cleaning up after tests. Requires that the client is owned by IAP.
     * </pre>
     */
    public void deleteIdentityAwareProxyClient(
        com.google.cloud.iap.v1.DeleteIdentityAwareProxyClientRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteIdentityAwareProxyClientMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service IdentityAwareProxyOAuthService.
   *
   * <pre>
   * API to programmatically create, list and retrieve Identity Aware Proxy (IAP)
   * OAuth brands; and create, retrieve, delete and reset-secret of IAP OAuth
   * clients.
   * </pre>
   */
  public static final class IdentityAwareProxyOAuthServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<IdentityAwareProxyOAuthServiceBlockingStub> {
    private IdentityAwareProxyOAuthServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IdentityAwareProxyOAuthServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IdentityAwareProxyOAuthServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists the existing brands for the project.
     * </pre>
     */
    public com.google.cloud.iap.v1.ListBrandsResponse listBrands(
        com.google.cloud.iap.v1.ListBrandsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBrandsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Constructs a new OAuth brand for the project if one does not exist.
     * The created brand is "internal only", meaning that OAuth clients created
     * under it only accept requests from users who belong to the same Google
     * Workspace organization as the project. The brand is created in an
     * un-reviewed status. NOTE: The "internal only" status can be manually
     * changed in the Google Cloud Console. Requires that a brand does not already
     * exist for the project, and that the specified support email is owned by the
     * caller.
     * </pre>
     */
    public com.google.cloud.iap.v1.Brand createBrand(
        com.google.cloud.iap.v1.CreateBrandRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBrandMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the OAuth brand of the project.
     * </pre>
     */
    public com.google.cloud.iap.v1.Brand getBrand(com.google.cloud.iap.v1.GetBrandRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBrandMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an Identity Aware Proxy (IAP) OAuth client. The client is owned
     * by IAP. Requires that the brand for the project exists and that it is
     * set for internal-only use.
     * </pre>
     */
    public com.google.cloud.iap.v1.IdentityAwareProxyClient createIdentityAwareProxyClient(
        com.google.cloud.iap.v1.CreateIdentityAwareProxyClientRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateIdentityAwareProxyClientMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the existing clients for the brand.
     * </pre>
     */
    public com.google.cloud.iap.v1.ListIdentityAwareProxyClientsResponse
        listIdentityAwareProxyClients(
            com.google.cloud.iap.v1.ListIdentityAwareProxyClientsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListIdentityAwareProxyClientsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves an Identity Aware Proxy (IAP) OAuth client.
     * Requires that the client is owned by IAP.
     * </pre>
     */
    public com.google.cloud.iap.v1.IdentityAwareProxyClient getIdentityAwareProxyClient(
        com.google.cloud.iap.v1.GetIdentityAwareProxyClientRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIdentityAwareProxyClientMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Resets an Identity Aware Proxy (IAP) OAuth client secret. Useful if the
     * secret was compromised. Requires that the client is owned by IAP.
     * </pre>
     */
    public com.google.cloud.iap.v1.IdentityAwareProxyClient resetIdentityAwareProxyClientSecret(
        com.google.cloud.iap.v1.ResetIdentityAwareProxyClientSecretRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResetIdentityAwareProxyClientSecretMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an Identity Aware Proxy (IAP) OAuth client. Useful for removing
     * obsolete clients, managing the number of clients in a given project, and
     * cleaning up after tests. Requires that the client is owned by IAP.
     * </pre>
     */
    public com.google.protobuf.Empty deleteIdentityAwareProxyClient(
        com.google.cloud.iap.v1.DeleteIdentityAwareProxyClientRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteIdentityAwareProxyClientMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * IdentityAwareProxyOAuthService.
   *
   * <pre>
   * API to programmatically create, list and retrieve Identity Aware Proxy (IAP)
   * OAuth brands; and create, retrieve, delete and reset-secret of IAP OAuth
   * clients.
   * </pre>
   */
  public static final class IdentityAwareProxyOAuthServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<IdentityAwareProxyOAuthServiceFutureStub> {
    private IdentityAwareProxyOAuthServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IdentityAwareProxyOAuthServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IdentityAwareProxyOAuthServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists the existing brands for the project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.iap.v1.ListBrandsResponse>
        listBrands(com.google.cloud.iap.v1.ListBrandsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBrandsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Constructs a new OAuth brand for the project if one does not exist.
     * The created brand is "internal only", meaning that OAuth clients created
     * under it only accept requests from users who belong to the same Google
     * Workspace organization as the project. The brand is created in an
     * un-reviewed status. NOTE: The "internal only" status can be manually
     * changed in the Google Cloud Console. Requires that a brand does not already
     * exist for the project, and that the specified support email is owned by the
     * caller.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.iap.v1.Brand>
        createBrand(com.google.cloud.iap.v1.CreateBrandRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateBrandMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the OAuth brand of the project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.iap.v1.Brand>
        getBrand(com.google.cloud.iap.v1.GetBrandRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBrandMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an Identity Aware Proxy (IAP) OAuth client. The client is owned
     * by IAP. Requires that the brand for the project exists and that it is
     * set for internal-only use.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.iap.v1.IdentityAwareProxyClient>
        createIdentityAwareProxyClient(
            com.google.cloud.iap.v1.CreateIdentityAwareProxyClientRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateIdentityAwareProxyClientMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists the existing clients for the brand.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.iap.v1.ListIdentityAwareProxyClientsResponse>
        listIdentityAwareProxyClients(
            com.google.cloud.iap.v1.ListIdentityAwareProxyClientsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListIdentityAwareProxyClientsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves an Identity Aware Proxy (IAP) OAuth client.
     * Requires that the client is owned by IAP.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.iap.v1.IdentityAwareProxyClient>
        getIdentityAwareProxyClient(
            com.google.cloud.iap.v1.GetIdentityAwareProxyClientRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIdentityAwareProxyClientMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Resets an Identity Aware Proxy (IAP) OAuth client secret. Useful if the
     * secret was compromised. Requires that the client is owned by IAP.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.iap.v1.IdentityAwareProxyClient>
        resetIdentityAwareProxyClientSecret(
            com.google.cloud.iap.v1.ResetIdentityAwareProxyClientSecretRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResetIdentityAwareProxyClientSecretMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an Identity Aware Proxy (IAP) OAuth client. Useful for removing
     * obsolete clients, managing the number of clients in a given project, and
     * cleaning up after tests. Requires that the client is owned by IAP.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteIdentityAwareProxyClient(
            com.google.cloud.iap.v1.DeleteIdentityAwareProxyClientRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteIdentityAwareProxyClientMethod(), getCallOptions()),
          request);
    }
  }

  private static final int METHODID_LIST_BRANDS = 0;
  private static final int METHODID_CREATE_BRAND = 1;
  private static final int METHODID_GET_BRAND = 2;
  private static final int METHODID_CREATE_IDENTITY_AWARE_PROXY_CLIENT = 3;
  private static final int METHODID_LIST_IDENTITY_AWARE_PROXY_CLIENTS = 4;
  private static final int METHODID_GET_IDENTITY_AWARE_PROXY_CLIENT = 5;
  private static final int METHODID_RESET_IDENTITY_AWARE_PROXY_CLIENT_SECRET = 6;
  private static final int METHODID_DELETE_IDENTITY_AWARE_PROXY_CLIENT = 7;

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
        case METHODID_LIST_BRANDS:
          serviceImpl.listBrands(
              (com.google.cloud.iap.v1.ListBrandsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iap.v1.ListBrandsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_BRAND:
          serviceImpl.createBrand(
              (com.google.cloud.iap.v1.CreateBrandRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iap.v1.Brand>) responseObserver);
          break;
        case METHODID_GET_BRAND:
          serviceImpl.getBrand(
              (com.google.cloud.iap.v1.GetBrandRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iap.v1.Brand>) responseObserver);
          break;
        case METHODID_CREATE_IDENTITY_AWARE_PROXY_CLIENT:
          serviceImpl.createIdentityAwareProxyClient(
              (com.google.cloud.iap.v1.CreateIdentityAwareProxyClientRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iap.v1.IdentityAwareProxyClient>)
                  responseObserver);
          break;
        case METHODID_LIST_IDENTITY_AWARE_PROXY_CLIENTS:
          serviceImpl.listIdentityAwareProxyClients(
              (com.google.cloud.iap.v1.ListIdentityAwareProxyClientsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.iap.v1.ListIdentityAwareProxyClientsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_IDENTITY_AWARE_PROXY_CLIENT:
          serviceImpl.getIdentityAwareProxyClient(
              (com.google.cloud.iap.v1.GetIdentityAwareProxyClientRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iap.v1.IdentityAwareProxyClient>)
                  responseObserver);
          break;
        case METHODID_RESET_IDENTITY_AWARE_PROXY_CLIENT_SECRET:
          serviceImpl.resetIdentityAwareProxyClientSecret(
              (com.google.cloud.iap.v1.ResetIdentityAwareProxyClientSecretRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.iap.v1.IdentityAwareProxyClient>)
                  responseObserver);
          break;
        case METHODID_DELETE_IDENTITY_AWARE_PROXY_CLIENT:
          serviceImpl.deleteIdentityAwareProxyClient(
              (com.google.cloud.iap.v1.DeleteIdentityAwareProxyClientRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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
            getListBrandsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.iap.v1.ListBrandsRequest,
                    com.google.cloud.iap.v1.ListBrandsResponse>(service, METHODID_LIST_BRANDS)))
        .addMethod(
            getCreateBrandMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.iap.v1.CreateBrandRequest, com.google.cloud.iap.v1.Brand>(
                    service, METHODID_CREATE_BRAND)))
        .addMethod(
            getGetBrandMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.iap.v1.GetBrandRequest, com.google.cloud.iap.v1.Brand>(
                    service, METHODID_GET_BRAND)))
        .addMethod(
            getCreateIdentityAwareProxyClientMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.iap.v1.CreateIdentityAwareProxyClientRequest,
                    com.google.cloud.iap.v1.IdentityAwareProxyClient>(
                    service, METHODID_CREATE_IDENTITY_AWARE_PROXY_CLIENT)))
        .addMethod(
            getListIdentityAwareProxyClientsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.iap.v1.ListIdentityAwareProxyClientsRequest,
                    com.google.cloud.iap.v1.ListIdentityAwareProxyClientsResponse>(
                    service, METHODID_LIST_IDENTITY_AWARE_PROXY_CLIENTS)))
        .addMethod(
            getGetIdentityAwareProxyClientMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.iap.v1.GetIdentityAwareProxyClientRequest,
                    com.google.cloud.iap.v1.IdentityAwareProxyClient>(
                    service, METHODID_GET_IDENTITY_AWARE_PROXY_CLIENT)))
        .addMethod(
            getResetIdentityAwareProxyClientSecretMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.iap.v1.ResetIdentityAwareProxyClientSecretRequest,
                    com.google.cloud.iap.v1.IdentityAwareProxyClient>(
                    service, METHODID_RESET_IDENTITY_AWARE_PROXY_CLIENT_SECRET)))
        .addMethod(
            getDeleteIdentityAwareProxyClientMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.iap.v1.DeleteIdentityAwareProxyClientRequest,
                    com.google.protobuf.Empty>(
                    service, METHODID_DELETE_IDENTITY_AWARE_PROXY_CLIENT)))
        .build();
  }

  private abstract static class IdentityAwareProxyOAuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    IdentityAwareProxyOAuthServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.iap.v1.Service.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("IdentityAwareProxyOAuthService");
    }
  }

  private static final class IdentityAwareProxyOAuthServiceFileDescriptorSupplier
      extends IdentityAwareProxyOAuthServiceBaseDescriptorSupplier {
    IdentityAwareProxyOAuthServiceFileDescriptorSupplier() {}
  }

  private static final class IdentityAwareProxyOAuthServiceMethodDescriptorSupplier
      extends IdentityAwareProxyOAuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    IdentityAwareProxyOAuthServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (IdentityAwareProxyOAuthServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(
                          new IdentityAwareProxyOAuthServiceFileDescriptorSupplier())
                      .addMethod(getListBrandsMethod())
                      .addMethod(getCreateBrandMethod())
                      .addMethod(getGetBrandMethod())
                      .addMethod(getCreateIdentityAwareProxyClientMethod())
                      .addMethod(getListIdentityAwareProxyClientsMethod())
                      .addMethod(getGetIdentityAwareProxyClientMethod())
                      .addMethod(getResetIdentityAwareProxyClientSecretMethod())
                      .addMethod(getDeleteIdentityAwareProxyClientMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
