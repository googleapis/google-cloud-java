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
          com.google.ads.marketingplatform.admin.v1alpha.ListOrganizationsRequest,
          com.google.ads.marketingplatform.admin.v1alpha.ListOrganizationsResponse>
      getListOrganizationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListOrganizations",
      requestType = com.google.ads.marketingplatform.admin.v1alpha.ListOrganizationsRequest.class,
      responseType = com.google.ads.marketingplatform.admin.v1alpha.ListOrganizationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.ads.marketingplatform.admin.v1alpha.ListOrganizationsRequest,
          com.google.ads.marketingplatform.admin.v1alpha.ListOrganizationsResponse>
      getListOrganizationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.ads.marketingplatform.admin.v1alpha.ListOrganizationsRequest,
            com.google.ads.marketingplatform.admin.v1alpha.ListOrganizationsResponse>
        getListOrganizationsMethod;
    if ((getListOrganizationsMethod = MarketingplatformAdminServiceGrpc.getListOrganizationsMethod)
        == null) {
      synchronized (MarketingplatformAdminServiceGrpc.class) {
        if ((getListOrganizationsMethod =
                MarketingplatformAdminServiceGrpc.getListOrganizationsMethod)
            == null) {
          MarketingplatformAdminServiceGrpc.getListOrganizationsMethod =
              getListOrganizationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.ads.marketingplatform.admin.v1alpha.ListOrganizationsRequest,
                          com.google.ads.marketingplatform.admin.v1alpha.ListOrganizationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListOrganizations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.marketingplatform.admin.v1alpha
                                  .ListOrganizationsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.marketingplatform.admin.v1alpha
                                  .ListOrganizationsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MarketingplatformAdminServiceMethodDescriptorSupplier(
                              "ListOrganizations"))
                      .build();
        }
      }
    }
    return getListOrganizationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.ads.marketingplatform.admin.v1alpha.FindSalesPartnerManagedClientsRequest,
          com.google.ads.marketingplatform.admin.v1alpha.FindSalesPartnerManagedClientsResponse>
      getFindSalesPartnerManagedClientsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindSalesPartnerManagedClients",
      requestType =
          com.google.ads.marketingplatform.admin.v1alpha.FindSalesPartnerManagedClientsRequest
              .class,
      responseType =
          com.google.ads.marketingplatform.admin.v1alpha.FindSalesPartnerManagedClientsResponse
              .class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.ads.marketingplatform.admin.v1alpha.FindSalesPartnerManagedClientsRequest,
          com.google.ads.marketingplatform.admin.v1alpha.FindSalesPartnerManagedClientsResponse>
      getFindSalesPartnerManagedClientsMethod() {
    io.grpc.MethodDescriptor<
            com.google.ads.marketingplatform.admin.v1alpha.FindSalesPartnerManagedClientsRequest,
            com.google.ads.marketingplatform.admin.v1alpha.FindSalesPartnerManagedClientsResponse>
        getFindSalesPartnerManagedClientsMethod;
    if ((getFindSalesPartnerManagedClientsMethod =
            MarketingplatformAdminServiceGrpc.getFindSalesPartnerManagedClientsMethod)
        == null) {
      synchronized (MarketingplatformAdminServiceGrpc.class) {
        if ((getFindSalesPartnerManagedClientsMethod =
                MarketingplatformAdminServiceGrpc.getFindSalesPartnerManagedClientsMethod)
            == null) {
          MarketingplatformAdminServiceGrpc.getFindSalesPartnerManagedClientsMethod =
              getFindSalesPartnerManagedClientsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.ads.marketingplatform.admin.v1alpha
                              .FindSalesPartnerManagedClientsRequest,
                          com.google.ads.marketingplatform.admin.v1alpha
                              .FindSalesPartnerManagedClientsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "FindSalesPartnerManagedClients"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.marketingplatform.admin.v1alpha
                                  .FindSalesPartnerManagedClientsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.marketingplatform.admin.v1alpha
                                  .FindSalesPartnerManagedClientsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MarketingplatformAdminServiceMethodDescriptorSupplier(
                              "FindSalesPartnerManagedClients"))
                      .build();
        }
      }
    }
    return getFindSalesPartnerManagedClientsMethod;
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.ads.marketingplatform.admin.v1alpha.ReportPropertyUsageRequest,
          com.google.ads.marketingplatform.admin.v1alpha.ReportPropertyUsageResponse>
      getReportPropertyUsageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReportPropertyUsage",
      requestType = com.google.ads.marketingplatform.admin.v1alpha.ReportPropertyUsageRequest.class,
      responseType =
          com.google.ads.marketingplatform.admin.v1alpha.ReportPropertyUsageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.ads.marketingplatform.admin.v1alpha.ReportPropertyUsageRequest,
          com.google.ads.marketingplatform.admin.v1alpha.ReportPropertyUsageResponse>
      getReportPropertyUsageMethod() {
    io.grpc.MethodDescriptor<
            com.google.ads.marketingplatform.admin.v1alpha.ReportPropertyUsageRequest,
            com.google.ads.marketingplatform.admin.v1alpha.ReportPropertyUsageResponse>
        getReportPropertyUsageMethod;
    if ((getReportPropertyUsageMethod =
            MarketingplatformAdminServiceGrpc.getReportPropertyUsageMethod)
        == null) {
      synchronized (MarketingplatformAdminServiceGrpc.class) {
        if ((getReportPropertyUsageMethod =
                MarketingplatformAdminServiceGrpc.getReportPropertyUsageMethod)
            == null) {
          MarketingplatformAdminServiceGrpc.getReportPropertyUsageMethod =
              getReportPropertyUsageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.ads.marketingplatform.admin.v1alpha.ReportPropertyUsageRequest,
                          com.google.ads.marketingplatform.admin.v1alpha
                              .ReportPropertyUsageResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ReportPropertyUsage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.marketingplatform.admin.v1alpha
                                  .ReportPropertyUsageRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.marketingplatform.admin.v1alpha
                                  .ReportPropertyUsageResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MarketingplatformAdminServiceMethodDescriptorSupplier(
                              "ReportPropertyUsage"))
                      .build();
        }
      }
    }
    return getReportPropertyUsageMethod;
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

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static MarketingplatformAdminServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MarketingplatformAdminServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MarketingplatformAdminServiceBlockingV2Stub>() {
          @java.lang.Override
          public MarketingplatformAdminServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MarketingplatformAdminServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return MarketingplatformAdminServiceBlockingV2Stub.newStub(factory, channel);
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
     * Returns a list of organizations that the user has access to.
     * </pre>
     */
    default void listOrganizations(
        com.google.ads.marketingplatform.admin.v1alpha.ListOrganizationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.ads.marketingplatform.admin.v1alpha.ListOrganizationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListOrganizationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of clients managed by the sales partner organization.
     * User needs to be an OrgAdmin/BillingAdmin on the sales partner organization
     * in order to view the end clients.
     * </pre>
     */
    default void findSalesPartnerManagedClients(
        com.google.ads.marketingplatform.admin.v1alpha.FindSalesPartnerManagedClientsRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.ads.marketingplatform.admin.v1alpha
                    .FindSalesPartnerManagedClientsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFindSalesPartnerManagedClientsMethod(), responseObserver);
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

    /**
     *
     *
     * <pre>
     * Get the usage and billing data for properties within the organization for
     * the specified month.
     * Per direct client org, user needs to be OrgAdmin/BillingAdmin on the
     * organization in order to view the billing and usage data.
     * Per sales partner client org, user needs to be OrgAdmin/BillingAdmin on
     * the sales partner org in order to view the billing and usage data, or
     * OrgAdmin/BillingAdmin on the sales partner client org in order to view the
     * usage data only.
     * </pre>
     */
    default void reportPropertyUsage(
        com.google.ads.marketingplatform.admin.v1alpha.ReportPropertyUsageRequest request,
        io.grpc.stub.StreamObserver<
                com.google.ads.marketingplatform.admin.v1alpha.ReportPropertyUsageResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getReportPropertyUsageMethod(), responseObserver);
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
     * Returns a list of organizations that the user has access to.
     * </pre>
     */
    public void listOrganizations(
        com.google.ads.marketingplatform.admin.v1alpha.ListOrganizationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.ads.marketingplatform.admin.v1alpha.ListOrganizationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListOrganizationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of clients managed by the sales partner organization.
     * User needs to be an OrgAdmin/BillingAdmin on the sales partner organization
     * in order to view the end clients.
     * </pre>
     */
    public void findSalesPartnerManagedClients(
        com.google.ads.marketingplatform.admin.v1alpha.FindSalesPartnerManagedClientsRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.ads.marketingplatform.admin.v1alpha
                    .FindSalesPartnerManagedClientsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindSalesPartnerManagedClientsMethod(), getCallOptions()),
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

    /**
     *
     *
     * <pre>
     * Get the usage and billing data for properties within the organization for
     * the specified month.
     * Per direct client org, user needs to be OrgAdmin/BillingAdmin on the
     * organization in order to view the billing and usage data.
     * Per sales partner client org, user needs to be OrgAdmin/BillingAdmin on
     * the sales partner org in order to view the billing and usage data, or
     * OrgAdmin/BillingAdmin on the sales partner client org in order to view the
     * usage data only.
     * </pre>
     */
    public void reportPropertyUsage(
        com.google.ads.marketingplatform.admin.v1alpha.ReportPropertyUsageRequest request,
        io.grpc.stub.StreamObserver<
                com.google.ads.marketingplatform.admin.v1alpha.ReportPropertyUsageResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReportPropertyUsageMethod(), getCallOptions()),
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
  public static final class MarketingplatformAdminServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<MarketingplatformAdminServiceBlockingV2Stub> {
    private MarketingplatformAdminServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MarketingplatformAdminServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MarketingplatformAdminServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lookup for a single organization.
     * </pre>
     */
    public com.google.ads.marketingplatform.admin.v1alpha.Organization getOrganization(
        com.google.ads.marketingplatform.admin.v1alpha.GetOrganizationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetOrganizationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of organizations that the user has access to.
     * </pre>
     */
    public com.google.ads.marketingplatform.admin.v1alpha.ListOrganizationsResponse
        listOrganizations(
            com.google.ads.marketingplatform.admin.v1alpha.ListOrganizationsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListOrganizationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of clients managed by the sales partner organization.
     * User needs to be an OrgAdmin/BillingAdmin on the sales partner organization
     * in order to view the end clients.
     * </pre>
     */
    public com.google.ads.marketingplatform.admin.v1alpha.FindSalesPartnerManagedClientsResponse
        findSalesPartnerManagedClients(
            com.google.ads.marketingplatform.admin.v1alpha.FindSalesPartnerManagedClientsRequest
                request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getFindSalesPartnerManagedClientsMethod(), getCallOptions(), request);
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
            com.google.ads.marketingplatform.admin.v1alpha.ListAnalyticsAccountLinksRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
                request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
        com.google.ads.marketingplatform.admin.v1alpha.DeleteAnalyticsAccountLinkRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
            com.google.ads.marketingplatform.admin.v1alpha.SetPropertyServiceLevelRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSetPropertyServiceLevelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get the usage and billing data for properties within the organization for
     * the specified month.
     * Per direct client org, user needs to be OrgAdmin/BillingAdmin on the
     * organization in order to view the billing and usage data.
     * Per sales partner client org, user needs to be OrgAdmin/BillingAdmin on
     * the sales partner org in order to view the billing and usage data, or
     * OrgAdmin/BillingAdmin on the sales partner client org in order to view the
     * usage data only.
     * </pre>
     */
    public com.google.ads.marketingplatform.admin.v1alpha.ReportPropertyUsageResponse
        reportPropertyUsage(
            com.google.ads.marketingplatform.admin.v1alpha.ReportPropertyUsageRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getReportPropertyUsageMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service
   * MarketingplatformAdminService.
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
     * Returns a list of organizations that the user has access to.
     * </pre>
     */
    public com.google.ads.marketingplatform.admin.v1alpha.ListOrganizationsResponse
        listOrganizations(
            com.google.ads.marketingplatform.admin.v1alpha.ListOrganizationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListOrganizationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of clients managed by the sales partner organization.
     * User needs to be an OrgAdmin/BillingAdmin on the sales partner organization
     * in order to view the end clients.
     * </pre>
     */
    public com.google.ads.marketingplatform.admin.v1alpha.FindSalesPartnerManagedClientsResponse
        findSalesPartnerManagedClients(
            com.google.ads.marketingplatform.admin.v1alpha.FindSalesPartnerManagedClientsRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindSalesPartnerManagedClientsMethod(), getCallOptions(), request);
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

    /**
     *
     *
     * <pre>
     * Get the usage and billing data for properties within the organization for
     * the specified month.
     * Per direct client org, user needs to be OrgAdmin/BillingAdmin on the
     * organization in order to view the billing and usage data.
     * Per sales partner client org, user needs to be OrgAdmin/BillingAdmin on
     * the sales partner org in order to view the billing and usage data, or
     * OrgAdmin/BillingAdmin on the sales partner client org in order to view the
     * usage data only.
     * </pre>
     */
    public com.google.ads.marketingplatform.admin.v1alpha.ReportPropertyUsageResponse
        reportPropertyUsage(
            com.google.ads.marketingplatform.admin.v1alpha.ReportPropertyUsageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReportPropertyUsageMethod(), getCallOptions(), request);
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
     * Returns a list of organizations that the user has access to.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.ads.marketingplatform.admin.v1alpha.ListOrganizationsResponse>
        listOrganizations(
            com.google.ads.marketingplatform.admin.v1alpha.ListOrganizationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListOrganizationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of clients managed by the sales partner organization.
     * User needs to be an OrgAdmin/BillingAdmin on the sales partner organization
     * in order to view the end clients.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.ads.marketingplatform.admin.v1alpha.FindSalesPartnerManagedClientsResponse>
        findSalesPartnerManagedClients(
            com.google.ads.marketingplatform.admin.v1alpha.FindSalesPartnerManagedClientsRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindSalesPartnerManagedClientsMethod(), getCallOptions()),
          request);
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

    /**
     *
     *
     * <pre>
     * Get the usage and billing data for properties within the organization for
     * the specified month.
     * Per direct client org, user needs to be OrgAdmin/BillingAdmin on the
     * organization in order to view the billing and usage data.
     * Per sales partner client org, user needs to be OrgAdmin/BillingAdmin on
     * the sales partner org in order to view the billing and usage data, or
     * OrgAdmin/BillingAdmin on the sales partner client org in order to view the
     * usage data only.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.ads.marketingplatform.admin.v1alpha.ReportPropertyUsageResponse>
        reportPropertyUsage(
            com.google.ads.marketingplatform.admin.v1alpha.ReportPropertyUsageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReportPropertyUsageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ORGANIZATION = 0;
  private static final int METHODID_LIST_ORGANIZATIONS = 1;
  private static final int METHODID_FIND_SALES_PARTNER_MANAGED_CLIENTS = 2;
  private static final int METHODID_LIST_ANALYTICS_ACCOUNT_LINKS = 3;
  private static final int METHODID_CREATE_ANALYTICS_ACCOUNT_LINK = 4;
  private static final int METHODID_DELETE_ANALYTICS_ACCOUNT_LINK = 5;
  private static final int METHODID_SET_PROPERTY_SERVICE_LEVEL = 6;
  private static final int METHODID_REPORT_PROPERTY_USAGE = 7;

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
        case METHODID_LIST_ORGANIZATIONS:
          serviceImpl.listOrganizations(
              (com.google.ads.marketingplatform.admin.v1alpha.ListOrganizationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.ads.marketingplatform.admin.v1alpha.ListOrganizationsResponse>)
                  responseObserver);
          break;
        case METHODID_FIND_SALES_PARTNER_MANAGED_CLIENTS:
          serviceImpl.findSalesPartnerManagedClients(
              (com.google.ads.marketingplatform.admin.v1alpha.FindSalesPartnerManagedClientsRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.ads.marketingplatform.admin.v1alpha
                          .FindSalesPartnerManagedClientsResponse>)
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
        case METHODID_REPORT_PROPERTY_USAGE:
          serviceImpl.reportPropertyUsage(
              (com.google.ads.marketingplatform.admin.v1alpha.ReportPropertyUsageRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.ads.marketingplatform.admin.v1alpha.ReportPropertyUsageResponse>)
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
            getListOrganizationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.ads.marketingplatform.admin.v1alpha.ListOrganizationsRequest,
                    com.google.ads.marketingplatform.admin.v1alpha.ListOrganizationsResponse>(
                    service, METHODID_LIST_ORGANIZATIONS)))
        .addMethod(
            getFindSalesPartnerManagedClientsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.ads.marketingplatform.admin.v1alpha
                        .FindSalesPartnerManagedClientsRequest,
                    com.google.ads.marketingplatform.admin.v1alpha
                        .FindSalesPartnerManagedClientsResponse>(
                    service, METHODID_FIND_SALES_PARTNER_MANAGED_CLIENTS)))
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
        .addMethod(
            getReportPropertyUsageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.ads.marketingplatform.admin.v1alpha.ReportPropertyUsageRequest,
                    com.google.ads.marketingplatform.admin.v1alpha.ReportPropertyUsageResponse>(
                    service, METHODID_REPORT_PROPERTY_USAGE)))
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
                      .addMethod(getListOrganizationsMethod())
                      .addMethod(getFindSalesPartnerManagedClientsMethod())
                      .addMethod(getListAnalyticsAccountLinksMethod())
                      .addMethod(getCreateAnalyticsAccountLinkMethod())
                      .addMethod(getDeleteAnalyticsAccountLinkMethod())
                      .addMethod(getSetPropertyServiceLevelMethod())
                      .addMethod(getReportPropertyUsageMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
