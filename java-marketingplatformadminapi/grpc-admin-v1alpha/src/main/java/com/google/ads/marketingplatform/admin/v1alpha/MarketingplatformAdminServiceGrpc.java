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
package com.google.ads.marketingplatform.admin.v1alpha;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service Interface for the Google Marketing Platform Admin API.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/marketingplatform/admin/v1alpha/marketingplatform_admin.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MarketingplatformAdminServiceGrpc {

  private MarketingplatformAdminServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.marketingplatform.admin.v1alpha.MarketingplatformAdminService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.ads.marketingplatform.admin.v1alpha.GetOrganizationRequest,
          com.google.ads.marketingplatform.admin.v1alpha.Organization>
      getGetOrganizationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetOrganization",
      requestType = com.google.ads.marketingplatform.admin.v1alpha.GetOrganizationRequest.class,
      responseType = com.google.ads.marketingplatform.admin.v1alpha.Organization.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.ads.marketingplatform.admin.v1alpha.GetOrganizationRequest,
          com.google.ads.marketingplatform.admin.v1alpha.Organization>
      getGetOrganizationMethod() {
    io.grpc.MethodDescriptor<
            com.google.ads.marketingplatform.admin.v1alpha.GetOrganizationRequest,
            com.google.ads.marketingplatform.admin.v1alpha.Organization>
        getGetOrganizationMethod;
    if ((getGetOrganizationMethod = MarketingplatformAdminServiceGrpc.getGetOrganizationMethod)
        == null) {
      synchronized (MarketingplatformAdminServiceGrpc.class) {
        if ((getGetOrganizationMethod = MarketingplatformAdminServiceGrpc.getGetOrganizationMethod)
            == null) {
          MarketingplatformAdminServiceGrpc.getGetOrganizationMethod =
              getGetOrganizationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.ads.marketingplatform.admin.v1alpha.GetOrganizationRequest,
                          com.google.ads.marketingplatform.admin.v1alpha.Organization>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetOrganization"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.marketingplatform.admin.v1alpha.GetOrganizationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.marketingplatform.admin.v1alpha.Organization
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MarketingplatformAdminServiceMethodDescriptorSupplier(
                              "GetOrganization"))
                      .build();
        }
      }
    }
    return getGetOrganizationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.ads.marketingplatform.admin.v1alpha.ListAnalyticsAccountLinksRequest,
          com.google.ads.marketingplatform.admin.v1alpha.ListAnalyticsAccountLinksResponse>
      getListAnalyticsAccountLinksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAnalyticsAccountLinks",
      requestType =
          com.google.ads.marketingplatform.admin.v1alpha.ListAnalyticsAccountLinksRequest.class,
      responseType =
          com.google.ads.marketingplatform.admin.v1alpha.ListAnalyticsAccountLinksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.ads.marketingplatform.admin.v1alpha.ListAnalyticsAccountLinksRequest,
          com.google.ads.marketingplatform.admin.v1alpha.ListAnalyticsAccountLinksResponse>
      getListAnalyticsAccountLinksMethod() {
    io.grpc.MethodDescriptor<
            com.google.ads.marketingplatform.admin.v1alpha.ListAnalyticsAccountLinksRequest,
            com.google.ads.marketingplatform.admin.v1alpha.ListAnalyticsAccountLinksResponse>
        getListAnalyticsAccountLinksMethod;
    if ((getListAnalyticsAccountLinksMethod =
            MarketingplatformAdminServiceGrpc.getListAnalyticsAccountLinksMethod)
        == null) {
      synchronized (MarketingplatformAdminServiceGrpc.class) {
        if ((getListAnalyticsAccountLinksMethod =
                MarketingplatformAdminServiceGrpc.getListAnalyticsAccountLinksMethod)
            == null) {
          MarketingplatformAdminServiceGrpc.getListAnalyticsAccountLinksMethod =
              getListAnalyticsAccountLinksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.ads.marketingplatform.admin.v1alpha
                              .ListAnalyticsAccountLinksRequest,
                          com.google.ads.marketingplatform.admin.v1alpha
                              .ListAnalyticsAccountLinksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAnalyticsAccountLinks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.marketingplatform.admin.v1alpha
                                  .ListAnalyticsAccountLinksRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.marketingplatform.admin.v1alpha
                                  .ListAnalyticsAccountLinksResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MarketingplatformAdminServiceMethodDescriptorSupplier(
                              "ListAnalyticsAccountLinks"))
                      .build();
        }
      }
    }
    return getListAnalyticsAccountLinksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.ads.marketingplatform.admin.v1alpha.CreateAnalyticsAccountLinkRequest,
          com.google.ads.marketingplatform.admin.v1alpha.AnalyticsAccountLink>
      getCreateAnalyticsAccountLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAnalyticsAccountLink",
      requestType =
          com.google.ads.marketingplatform.admin.v1alpha.CreateAnalyticsAccountLinkRequest.class,
      responseType = com.google.ads.marketingplatform.admin.v1alpha.AnalyticsAccountLink.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.ads.marketingplatform.admin.v1alpha.CreateAnalyticsAccountLinkRequest,
          com.google.ads.marketingplatform.admin.v1alpha.AnalyticsAccountLink>
      getCreateAnalyticsAccountLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.ads.marketingplatform.admin.v1alpha.CreateAnalyticsAccountLinkRequest,
            com.google.ads.marketingplatform.admin.v1alpha.AnalyticsAccountLink>
        getCreateAnalyticsAccountLinkMethod;
    if ((getCreateAnalyticsAccountLinkMethod =
            MarketingplatformAdminServiceGrpc.getCreateAnalyticsAccountLinkMethod)
        == null) {
      synchronized (MarketingplatformAdminServiceGrpc.class) {
        if ((getCreateAnalyticsAccountLinkMethod =
                MarketingplatformAdminServiceGrpc.getCreateAnalyticsAccountLinkMethod)
            == null) {
          MarketingplatformAdminServiceGrpc.getCreateAnalyticsAccountLinkMethod =
              getCreateAnalyticsAccountLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.ads.marketingplatform.admin.v1alpha
                              .CreateAnalyticsAccountLinkRequest,
                          com.google.ads.marketingplatform.admin.v1alpha.AnalyticsAccountLink>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateAnalyticsAccountLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.marketingplatform.admin.v1alpha
                                  .CreateAnalyticsAccountLinkRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.marketingplatform.admin.v1alpha.AnalyticsAccountLink
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MarketingplatformAdminServiceMethodDescriptorSupplier(
                              "CreateAnalyticsAccountLink"))
                      .build();
        }
      }
    }
    return getCreateAnalyticsAccountLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.ads.marketingplatform.admin.v1alpha.DeleteAnalyticsAccountLinkRequest,
          com.google.protobuf.Empty>
      getDeleteAnalyticsAccountLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAnalyticsAccountLink",
      requestType =
          com.google.ads.marketingplatform.admin.v1alpha.DeleteAnalyticsAccountLinkRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.ads.marketingplatform.admin.v1alpha.DeleteAnalyticsAccountLinkRequest,
          com.google.protobuf.Empty>
      getDeleteAnalyticsAccountLinkMethod() {
    io.grpc.MethodDescriptor<
            com.google.ads.marketingplatform.admin.v1alpha.DeleteAnalyticsAccountLinkRequest,
            com.google.protobuf.Empty>
        getDeleteAnalyticsAccountLinkMethod;
    if ((getDeleteAnalyticsAccountLinkMethod =
            MarketingplatformAdminServiceGrpc.getDeleteAnalyticsAccountLinkMethod)
        == null) {
      synchronized (MarketingplatformAdminServiceGrpc.class) {
        if ((getDeleteAnalyticsAccountLinkMethod =
                MarketingplatformAdminServiceGrpc.getDeleteAnalyticsAccountLinkMethod)
            == null) {
          MarketingplatformAdminServiceGrpc.getDeleteAnalyticsAccountLinkMethod =
              getDeleteAnalyticsAccountLinkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.ads.marketingplatform.admin.v1alpha
                              .DeleteAnalyticsAccountLinkRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteAnalyticsAccountLink"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.marketingplatform.admin.v1alpha
                                  .DeleteAnalyticsAccountLinkRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MarketingplatformAdminServiceMethodDescriptorSupplier(
                              "DeleteAnalyticsAccountLink"))
                      .build();
        }
      }
    }
    return getDeleteAnalyticsAccountLinkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.ads.marketingplatform.admin.v1alpha.SetPropertyServiceLevelRequest,
          com.google.ads.marketingplatform.admin.v1alpha.SetPropertyServiceLevelResponse>
      getSetPropertyServiceLevelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetPropertyServiceLevel",
      requestType =
          com.google.ads.marketingplatform.admin.v1alpha.SetPropertyServiceLevelRequest.class,
      responseType =
          com.google.ads.marketingplatform.admin.v1alpha.SetPropertyServiceLevelResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.ads.marketingplatform.admin.v1alpha.SetPropertyServiceLevelRequest,
          com.google.ads.marketingplatform.admin.v1alpha.SetPropertyServiceLevelResponse>
      getSetPropertyServiceLevelMethod() {
    io.grpc.MethodDescriptor<
            com.google.ads.marketingplatform.admin.v1alpha.SetPropertyServiceLevelRequest,
            com.google.ads.marketingplatform.admin.v1alpha.SetPropertyServiceLevelResponse>
        getSetPropertyServiceLevelMethod;
    if ((getSetPropertyServiceLevelMethod =
            MarketingplatformAdminServiceGrpc.getSetPropertyServiceLevelMethod)
        == null) {
      synchronized (MarketingplatformAdminServiceGrpc.class) {
        if ((getSetPropertyServiceLevelMethod =
                MarketingplatformAdminServiceGrpc.getSetPropertyServiceLevelMethod)
            == null) {
          MarketingplatformAdminServiceGrpc.getSetPropertyServiceLevelMethod =
              getSetPropertyServiceLevelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.ads.marketingplatform.admin.v1alpha
                              .SetPropertyServiceLevelRequest,
                          com.google.ads.marketingplatform.admin.v1alpha
                              .SetPropertyServiceLevelResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SetPropertyServiceLevel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.marketingplatform.admin.v1alpha
                                  .SetPropertyServiceLevelRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.marketingplatform.admin.v1alpha
                                  .SetPropertyServiceLevelResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MarketingplatformAdminServiceMethodDescriptorSupplier(
                              "SetPropertyServiceLevel"))
                      .build();
        }
      }
    }
    return getSetPropertyServiceLevelMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static MarketingplatformAdminServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MarketingplatformAdminServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MarketingplatformAdminServiceStub>() {
          @java.lang.Override
          public MarketingplatformAdminServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MarketingplatformAdminServiceStub(channel, callOptions);
          }
        };
    return MarketingplatformAdminServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MarketingplatformAdminServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MarketingplatformAdminServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MarketingplatformAdminServiceBlockingStub>() {
          @java.lang.Override
          public MarketingplatformAdminServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MarketingplatformAdminServiceBlockingStub(channel, callOptions);
          }
        };
    return MarketingplatformAdminServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static MarketingplatformAdminServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MarketingplatformAdminServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MarketingplatformAdminServiceFutureStub>() {
          @java.lang.Override
          public MarketingplatformAdminServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MarketingplatformAdminServiceFutureStub(channel, callOptions);
          }
        };
    return MarketingplatformAdminServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service Interface for the Google Marketing Platform Admin API.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lookup for a single organization.
     * </pre>
     */
    default void getOrganization(
        com.google.ads.marketingplatform.admin.v1alpha.GetOrganizationRequest request,
        io.grpc.stub.StreamObserver<com.google.ads.marketingplatform.admin.v1alpha.Organization>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetOrganizationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the Google Analytics accounts link to the specified Google Marketing
     * Platform organization.
     * </pre>
     */
    default void listAnalyticsAccountLinks(
        com.google.ads.marketingplatform.admin.v1alpha.ListAnalyticsAccountLinksRequest request,
        io.grpc.stub.StreamObserver<
                com.google.ads.marketingplatform.admin.v1alpha.ListAnalyticsAccountLinksResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAnalyticsAccountLinksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates the link between the Analytics account and the Google Marketing
     * Platform organization.
     * User needs to be an org user, and admin on the Analytics account to create
     * the link. If the account is already linked to an organization, user needs
     * to unlink the account from the current organization, then try link again.
     * </pre>
     */
    default void createAnalyticsAccountLink(
        com.google.ads.marketingplatform.admin.v1alpha.CreateAnalyticsAccountLinkRequest request,
        io.grpc.stub.StreamObserver<
                com.google.ads.marketingplatform.admin.v1alpha.AnalyticsAccountLink>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAnalyticsAccountLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the AnalyticsAccountLink, which detaches the Analytics account from
     * the Google Marketing Platform organization.
     * User needs to be an org user, and admin on the Analytics account in order
     * to delete the link.
     * </pre>
     */
    default void deleteAnalyticsAccountLink(
        com.google.ads.marketingplatform.admin.v1alpha.DeleteAnalyticsAccountLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAnalyticsAccountLinkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the service level for an Analytics property.
     * </pre>
     */
    default void setPropertyServiceLevel(
        com.google.ads.marketingplatform.admin.v1alpha.SetPropertyServiceLevelRequest request,
        io.grpc.stub.StreamObserver<
                com.google.ads.marketingplatform.admin.v1alpha.SetPropertyServiceLevelResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetPropertyServiceLevelMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service MarketingplatformAdminService.
   *
   * <pre>
   * Service Interface for the Google Marketing Platform Admin API.
   * </pre>
   */
  public abstract static class MarketingplatformAdminServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return MarketingplatformAdminServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service MarketingplatformAdminService.
   *
   * <pre>
   * Service Interface for the Google Marketing Platform Admin API.
   * </pre>
   */
  public static final class MarketingplatformAdminServiceStub
      extends io.grpc.stub.AbstractAsyncStub<MarketingplatformAdminServiceStub> {
    private MarketingplatformAdminServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MarketingplatformAdminServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MarketingplatformAdminServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single organization.
     * </pre>
     */
    public void getOrganization(
        com.google.ads.marketingplatform.admin.v1alpha.GetOrganizationRequest request,
        io.grpc.stub.StreamObserver<com.google.ads.marketingplatform.admin.v1alpha.Organization>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetOrganizationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the Google Analytics accounts link to the specified Google Marketing
     * Platform organization.
     * </pre>
     */
    public void listAnalyticsAccountLinks(
        com.google.ads.marketingplatform.admin.v1alpha.ListAnalyticsAccountLinksRequest request,
        io.grpc.stub.StreamObserver<
                com.google.ads.marketingplatform.admin.v1alpha.ListAnalyticsAccountLinksResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAnalyticsAccountLinksMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates the link between the Analytics account and the Google Marketing
     * Platform organization.
     * User needs to be an org user, and admin on the Analytics account to create
     * the link. If the account is already linked to an organization, user needs
     * to unlink the account from the current organization, then try link again.
     * </pre>
     */
    public void createAnalyticsAccountLink(
        com.google.ads.marketingplatform.admin.v1alpha.CreateAnalyticsAccountLinkRequest request,
        io.grpc.stub.StreamObserver<
                com.google.ads.marketingplatform.admin.v1alpha.AnalyticsAccountLink>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAnalyticsAccountLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the AnalyticsAccountLink, which detaches the Analytics account from
     * the Google Marketing Platform organization.
     * User needs to be an org user, and admin on the Analytics account in order
     * to delete the link.
     * </pre>
     */
    public void deleteAnalyticsAccountLink(
        com.google.ads.marketingplatform.admin.v1alpha.DeleteAnalyticsAccountLinkRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAnalyticsAccountLinkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the service level for an Analytics property.
     * </pre>
     */
    public void setPropertyServiceLevel(
        com.google.ads.marketingplatform.admin.v1alpha.SetPropertyServiceLevelRequest request,
        io.grpc.stub.StreamObserver<
                com.google.ads.marketingplatform.admin.v1alpha.SetPropertyServiceLevelResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetPropertyServiceLevelMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service MarketingplatformAdminService.
   *
   * <pre>
   * Service Interface for the Google Marketing Platform Admin API.
   * </pre>
   */
  public static final class MarketingplatformAdminServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MarketingplatformAdminServiceBlockingStub> {
    private MarketingplatformAdminServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MarketingplatformAdminServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MarketingplatformAdminServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single organization.
     * </pre>
     */
    public com.google.ads.marketingplatform.admin.v1alpha.Organization getOrganization(
        com.google.ads.marketingplatform.admin.v1alpha.GetOrganizationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOrganizationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the Google Analytics accounts link to the specified Google Marketing
     * Platform organization.
     * </pre>
     */
    public com.google.ads.marketingplatform.admin.v1alpha.ListAnalyticsAccountLinksResponse
        listAnalyticsAccountLinks(
            com.google.ads.marketingplatform.admin.v1alpha.ListAnalyticsAccountLinksRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAnalyticsAccountLinksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates the link between the Analytics account and the Google Marketing
     * Platform organization.
     * User needs to be an org user, and admin on the Analytics account to create
     * the link. If the account is already linked to an organization, user needs
     * to unlink the account from the current organization, then try link again.
     * </pre>
     */
    public com.google.ads.marketingplatform.admin.v1alpha.AnalyticsAccountLink
        createAnalyticsAccountLink(
            com.google.ads.marketingplatform.admin.v1alpha.CreateAnalyticsAccountLinkRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAnalyticsAccountLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the AnalyticsAccountLink, which detaches the Analytics account from
     * the Google Marketing Platform organization.
     * User needs to be an org user, and admin on the Analytics account in order
     * to delete the link.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAnalyticsAccountLink(
        com.google.ads.marketingplatform.admin.v1alpha.DeleteAnalyticsAccountLinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAnalyticsAccountLinkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the service level for an Analytics property.
     * </pre>
     */
    public com.google.ads.marketingplatform.admin.v1alpha.SetPropertyServiceLevelResponse
        setPropertyServiceLevel(
            com.google.ads.marketingplatform.admin.v1alpha.SetPropertyServiceLevelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetPropertyServiceLevelMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * MarketingplatformAdminService.
   *
   * <pre>
   * Service Interface for the Google Marketing Platform Admin API.
   * </pre>
   */
  public static final class MarketingplatformAdminServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<MarketingplatformAdminServiceFutureStub> {
    private MarketingplatformAdminServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MarketingplatformAdminServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MarketingplatformAdminServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single organization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.ads.marketingplatform.admin.v1alpha.Organization>
        getOrganization(
            com.google.ads.marketingplatform.admin.v1alpha.GetOrganizationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetOrganizationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the Google Analytics accounts link to the specified Google Marketing
     * Platform organization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.ads.marketingplatform.admin.v1alpha.ListAnalyticsAccountLinksResponse>
        listAnalyticsAccountLinks(
            com.google.ads.marketingplatform.admin.v1alpha.ListAnalyticsAccountLinksRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAnalyticsAccountLinksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates the link between the Analytics account and the Google Marketing
     * Platform organization.
     * User needs to be an org user, and admin on the Analytics account to create
     * the link. If the account is already linked to an organization, user needs
     * to unlink the account from the current organization, then try link again.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.ads.marketingplatform.admin.v1alpha.AnalyticsAccountLink>
        createAnalyticsAccountLink(
            com.google.ads.marketingplatform.admin.v1alpha.CreateAnalyticsAccountLinkRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAnalyticsAccountLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the AnalyticsAccountLink, which detaches the Analytics account from
     * the Google Marketing Platform organization.
     * User needs to be an org user, and admin on the Analytics account in order
     * to delete the link.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteAnalyticsAccountLink(
            com.google.ads.marketingplatform.admin.v1alpha.DeleteAnalyticsAccountLinkRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAnalyticsAccountLinkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the service level for an Analytics property.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.ads.marketingplatform.admin.v1alpha.SetPropertyServiceLevelResponse>
        setPropertyServiceLevel(
            com.google.ads.marketingplatform.admin.v1alpha.SetPropertyServiceLevelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetPropertyServiceLevelMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ORGANIZATION = 0;
  private static final int METHODID_LIST_ANALYTICS_ACCOUNT_LINKS = 1;
  private static final int METHODID_CREATE_ANALYTICS_ACCOUNT_LINK = 2;
  private static final int METHODID_DELETE_ANALYTICS_ACCOUNT_LINK = 3;
  private static final int METHODID_SET_PROPERTY_SERVICE_LEVEL = 4;

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
        case METHODID_GET_ORGANIZATION:
          serviceImpl.getOrganization(
              (com.google.ads.marketingplatform.admin.v1alpha.GetOrganizationRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.ads.marketingplatform.admin.v1alpha.Organization>)
                  responseObserver);
          break;
        case METHODID_LIST_ANALYTICS_ACCOUNT_LINKS:
          serviceImpl.listAnalyticsAccountLinks(
              (com.google.ads.marketingplatform.admin.v1alpha.ListAnalyticsAccountLinksRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.ads.marketingplatform.admin.v1alpha
                          .ListAnalyticsAccountLinksResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_ANALYTICS_ACCOUNT_LINK:
          serviceImpl.createAnalyticsAccountLink(
              (com.google.ads.marketingplatform.admin.v1alpha.CreateAnalyticsAccountLinkRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.ads.marketingplatform.admin.v1alpha.AnalyticsAccountLink>)
                  responseObserver);
          break;
        case METHODID_DELETE_ANALYTICS_ACCOUNT_LINK:
          serviceImpl.deleteAnalyticsAccountLink(
              (com.google.ads.marketingplatform.admin.v1alpha.DeleteAnalyticsAccountLinkRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_SET_PROPERTY_SERVICE_LEVEL:
          serviceImpl.setPropertyServiceLevel(
              (com.google.ads.marketingplatform.admin.v1alpha.SetPropertyServiceLevelRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.ads.marketingplatform.admin.v1alpha
                          .SetPropertyServiceLevelResponse>)
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
            getGetOrganizationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.ads.marketingplatform.admin.v1alpha.GetOrganizationRequest,
                    com.google.ads.marketingplatform.admin.v1alpha.Organization>(
                    service, METHODID_GET_ORGANIZATION)))
        .addMethod(
            getListAnalyticsAccountLinksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.ads.marketingplatform.admin.v1alpha.ListAnalyticsAccountLinksRequest,
                    com.google.ads.marketingplatform.admin.v1alpha
                        .ListAnalyticsAccountLinksResponse>(
                    service, METHODID_LIST_ANALYTICS_ACCOUNT_LINKS)))
        .addMethod(
            getCreateAnalyticsAccountLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.ads.marketingplatform.admin.v1alpha
                        .CreateAnalyticsAccountLinkRequest,
                    com.google.ads.marketingplatform.admin.v1alpha.AnalyticsAccountLink>(
                    service, METHODID_CREATE_ANALYTICS_ACCOUNT_LINK)))
        .addMethod(
            getDeleteAnalyticsAccountLinkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.ads.marketingplatform.admin.v1alpha
                        .DeleteAnalyticsAccountLinkRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_ANALYTICS_ACCOUNT_LINK)))
        .addMethod(
            getSetPropertyServiceLevelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.ads.marketingplatform.admin.v1alpha.SetPropertyServiceLevelRequest,
                    com.google.ads.marketingplatform.admin.v1alpha.SetPropertyServiceLevelResponse>(
                    service, METHODID_SET_PROPERTY_SERVICE_LEVEL)))
        .build();
  }

  private abstract static class MarketingplatformAdminServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MarketingplatformAdminServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.ads.marketingplatform.admin.v1alpha.MarketingplatformAdminProto
          .getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MarketingplatformAdminService");
    }
  }

  private static final class MarketingplatformAdminServiceFileDescriptorSupplier
      extends MarketingplatformAdminServiceBaseDescriptorSupplier {
    MarketingplatformAdminServiceFileDescriptorSupplier() {}
  }

  private static final class MarketingplatformAdminServiceMethodDescriptorSupplier
      extends MarketingplatformAdminServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    MarketingplatformAdminServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (MarketingplatformAdminServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(
                          new MarketingplatformAdminServiceFileDescriptorSupplier())
                      .addMethod(getGetOrganizationMethod())
                      .addMethod(getListAnalyticsAccountLinksMethod())
                      .addMethod(getCreateAnalyticsAccountLinkMethod())
                      .addMethod(getDeleteAnalyticsAccountLinkMethod())
                      .addMethod(getSetPropertyServiceLevelMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
