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
package com.google.cloud.retail.v2;

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
 * Service for managing catalog configuration.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/retail/v2/catalog_service.proto")
public final class CatalogServiceGrpc {

  private CatalogServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.retail.v2.CatalogService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2.ListCatalogsRequest,
          com.google.cloud.retail.v2.ListCatalogsResponse>
      getListCatalogsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCatalogs",
      requestType = com.google.cloud.retail.v2.ListCatalogsRequest.class,
      responseType = com.google.cloud.retail.v2.ListCatalogsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2.ListCatalogsRequest,
          com.google.cloud.retail.v2.ListCatalogsResponse>
      getListCatalogsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2.ListCatalogsRequest,
            com.google.cloud.retail.v2.ListCatalogsResponse>
        getListCatalogsMethod;
    if ((getListCatalogsMethod = CatalogServiceGrpc.getListCatalogsMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getListCatalogsMethod = CatalogServiceGrpc.getListCatalogsMethod) == null) {
          CatalogServiceGrpc.getListCatalogsMethod =
              getListCatalogsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2.ListCatalogsRequest,
                          com.google.cloud.retail.v2.ListCatalogsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCatalogs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2.ListCatalogsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2.ListCatalogsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CatalogServiceMethodDescriptorSupplier("ListCatalogs"))
                      .build();
        }
      }
    }
    return getListCatalogsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2.UpdateCatalogRequest, com.google.cloud.retail.v2.Catalog>
      getUpdateCatalogMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCatalog",
      requestType = com.google.cloud.retail.v2.UpdateCatalogRequest.class,
      responseType = com.google.cloud.retail.v2.Catalog.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2.UpdateCatalogRequest, com.google.cloud.retail.v2.Catalog>
      getUpdateCatalogMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2.UpdateCatalogRequest, com.google.cloud.retail.v2.Catalog>
        getUpdateCatalogMethod;
    if ((getUpdateCatalogMethod = CatalogServiceGrpc.getUpdateCatalogMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getUpdateCatalogMethod = CatalogServiceGrpc.getUpdateCatalogMethod) == null) {
          CatalogServiceGrpc.getUpdateCatalogMethod =
              getUpdateCatalogMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2.UpdateCatalogRequest,
                          com.google.cloud.retail.v2.Catalog>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCatalog"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2.UpdateCatalogRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2.Catalog.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CatalogServiceMethodDescriptorSupplier("UpdateCatalog"))
                      .build();
        }
      }
    }
    return getUpdateCatalogMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static CatalogServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CatalogServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CatalogServiceStub>() {
          @java.lang.Override
          public CatalogServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CatalogServiceStub(channel, callOptions);
          }
        };
    return CatalogServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CatalogServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CatalogServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CatalogServiceBlockingStub>() {
          @java.lang.Override
          public CatalogServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CatalogServiceBlockingStub(channel, callOptions);
          }
        };
    return CatalogServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static CatalogServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CatalogServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CatalogServiceFutureStub>() {
          @java.lang.Override
          public CatalogServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CatalogServiceFutureStub(channel, callOptions);
          }
        };
    return CatalogServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing catalog configuration.
   * </pre>
   */
  public abstract static class CatalogServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Lists all the [Catalog][google.cloud.retail.v2.Catalog]s associated with
     * the project.
     * </pre>
     */
    public void listCatalogs(
        com.google.cloud.retail.v2.ListCatalogsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2.ListCatalogsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListCatalogsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the [Catalog][google.cloud.retail.v2.Catalog]s.
     * </pre>
     */
    public void updateCatalog(
        com.google.cloud.retail.v2.UpdateCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2.Catalog> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateCatalogMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListCatalogsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.retail.v2.ListCatalogsRequest,
                      com.google.cloud.retail.v2.ListCatalogsResponse>(
                      this, METHODID_LIST_CATALOGS)))
          .addMethod(
              getUpdateCatalogMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.retail.v2.UpdateCatalogRequest,
                      com.google.cloud.retail.v2.Catalog>(this, METHODID_UPDATE_CATALOG)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing catalog configuration.
   * </pre>
   */
  public static final class CatalogServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CatalogServiceStub> {
    private CatalogServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CatalogServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CatalogServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all the [Catalog][google.cloud.retail.v2.Catalog]s associated with
     * the project.
     * </pre>
     */
    public void listCatalogs(
        com.google.cloud.retail.v2.ListCatalogsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2.ListCatalogsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListCatalogsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the [Catalog][google.cloud.retail.v2.Catalog]s.
     * </pre>
     */
    public void updateCatalog(
        com.google.cloud.retail.v2.UpdateCatalogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2.Catalog> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateCatalogMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing catalog configuration.
   * </pre>
   */
  public static final class CatalogServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CatalogServiceBlockingStub> {
    private CatalogServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CatalogServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CatalogServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all the [Catalog][google.cloud.retail.v2.Catalog]s associated with
     * the project.
     * </pre>
     */
    public com.google.cloud.retail.v2.ListCatalogsResponse listCatalogs(
        com.google.cloud.retail.v2.ListCatalogsRequest request) {
      return blockingUnaryCall(getChannel(), getListCatalogsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the [Catalog][google.cloud.retail.v2.Catalog]s.
     * </pre>
     */
    public com.google.cloud.retail.v2.Catalog updateCatalog(
        com.google.cloud.retail.v2.UpdateCatalogRequest request) {
      return blockingUnaryCall(getChannel(), getUpdateCatalogMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing catalog configuration.
   * </pre>
   */
  public static final class CatalogServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CatalogServiceFutureStub> {
    private CatalogServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CatalogServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CatalogServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all the [Catalog][google.cloud.retail.v2.Catalog]s associated with
     * the project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.retail.v2.ListCatalogsResponse>
        listCatalogs(com.google.cloud.retail.v2.ListCatalogsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListCatalogsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the [Catalog][google.cloud.retail.v2.Catalog]s.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.retail.v2.Catalog>
        updateCatalog(com.google.cloud.retail.v2.UpdateCatalogRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateCatalogMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_CATALOGS = 0;
  private static final int METHODID_UPDATE_CATALOG = 1;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CatalogServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CatalogServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_CATALOGS:
          serviceImpl.listCatalogs(
              (com.google.cloud.retail.v2.ListCatalogsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.retail.v2.ListCatalogsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_CATALOG:
          serviceImpl.updateCatalog(
              (com.google.cloud.retail.v2.UpdateCatalogRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.retail.v2.Catalog>) responseObserver);
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

  private abstract static class CatalogServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CatalogServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.retail.v2.CatalogServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CatalogService");
    }
  }

  private static final class CatalogServiceFileDescriptorSupplier
      extends CatalogServiceBaseDescriptorSupplier {
    CatalogServiceFileDescriptorSupplier() {}
  }

  private static final class CatalogServiceMethodDescriptorSupplier
      extends CatalogServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CatalogServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CatalogServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new CatalogServiceFileDescriptorSupplier())
                      .addMethod(getListCatalogsMethod())
                      .addMethod(getUpdateCatalogMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
