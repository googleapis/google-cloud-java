/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.cloudcontrolspartner.v1beta.stub;

import static com.google.cloud.cloudcontrolspartner.v1beta.CloudControlsPartnerCoreClient.ListAccessApprovalRequestsPagedResponse;
import static com.google.cloud.cloudcontrolspartner.v1beta.CloudControlsPartnerCoreClient.ListCustomersPagedResponse;
import static com.google.cloud.cloudcontrolspartner.v1beta.CloudControlsPartnerCoreClient.ListWorkloadsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.cloudcontrolspartner.v1beta.Customer;
import com.google.cloud.cloudcontrolspartner.v1beta.EkmConnections;
import com.google.cloud.cloudcontrolspartner.v1beta.GetCustomerRequest;
import com.google.cloud.cloudcontrolspartner.v1beta.GetEkmConnectionsRequest;
import com.google.cloud.cloudcontrolspartner.v1beta.GetPartnerPermissionsRequest;
import com.google.cloud.cloudcontrolspartner.v1beta.GetPartnerRequest;
import com.google.cloud.cloudcontrolspartner.v1beta.GetWorkloadRequest;
import com.google.cloud.cloudcontrolspartner.v1beta.ListAccessApprovalRequestsRequest;
import com.google.cloud.cloudcontrolspartner.v1beta.ListAccessApprovalRequestsResponse;
import com.google.cloud.cloudcontrolspartner.v1beta.ListCustomersRequest;
import com.google.cloud.cloudcontrolspartner.v1beta.ListCustomersResponse;
import com.google.cloud.cloudcontrolspartner.v1beta.ListWorkloadsRequest;
import com.google.cloud.cloudcontrolspartner.v1beta.ListWorkloadsResponse;
import com.google.cloud.cloudcontrolspartner.v1beta.Partner;
import com.google.cloud.cloudcontrolspartner.v1beta.PartnerPermissions;
import com.google.cloud.cloudcontrolspartner.v1beta.Workload;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the CloudControlsPartnerCore service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonCloudControlsPartnerCoreStub extends CloudControlsPartnerCoreStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetWorkloadRequest, Workload>
      getWorkloadMethodDescriptor =
          ApiMethodDescriptor.<GetWorkloadRequest, Workload>newBuilder()
              .setFullMethodName(
                  "google.cloud.cloudcontrolspartner.v1beta.CloudControlsPartnerCore/GetWorkload")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetWorkloadRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=organizations/*/locations/*/customers/*/workloads/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetWorkloadRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetWorkloadRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Workload>newBuilder()
                      .setDefaultInstance(Workload.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListWorkloadsRequest, ListWorkloadsResponse>
      listWorkloadsMethodDescriptor =
          ApiMethodDescriptor.<ListWorkloadsRequest, ListWorkloadsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.cloudcontrolspartner.v1beta.CloudControlsPartnerCore/ListWorkloads")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListWorkloadsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=organizations/*/locations/*/customers/*}/workloads",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListWorkloadsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListWorkloadsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListWorkloadsResponse>newBuilder()
                      .setDefaultInstance(ListWorkloadsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetCustomerRequest, Customer>
      getCustomerMethodDescriptor =
          ApiMethodDescriptor.<GetCustomerRequest, Customer>newBuilder()
              .setFullMethodName(
                  "google.cloud.cloudcontrolspartner.v1beta.CloudControlsPartnerCore/GetCustomer")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCustomerRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=organizations/*/locations/*/customers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCustomerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCustomerRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Customer>newBuilder()
                      .setDefaultInstance(Customer.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListCustomersRequest, ListCustomersResponse>
      listCustomersMethodDescriptor =
          ApiMethodDescriptor.<ListCustomersRequest, ListCustomersResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.cloudcontrolspartner.v1beta.CloudControlsPartnerCore/ListCustomers")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCustomersRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=organizations/*/locations/*}/customers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCustomersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCustomersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListCustomersResponse>newBuilder()
                      .setDefaultInstance(ListCustomersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetEkmConnectionsRequest, EkmConnections>
      getEkmConnectionsMethodDescriptor =
          ApiMethodDescriptor.<GetEkmConnectionsRequest, EkmConnections>newBuilder()
              .setFullMethodName(
                  "google.cloud.cloudcontrolspartner.v1beta.CloudControlsPartnerCore/GetEkmConnections")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetEkmConnectionsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=organizations/*/locations/*/customers/*/workloads/*/ekmConnections}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetEkmConnectionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetEkmConnectionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EkmConnections>newBuilder()
                      .setDefaultInstance(EkmConnections.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetPartnerPermissionsRequest, PartnerPermissions>
      getPartnerPermissionsMethodDescriptor =
          ApiMethodDescriptor.<GetPartnerPermissionsRequest, PartnerPermissions>newBuilder()
              .setFullMethodName(
                  "google.cloud.cloudcontrolspartner.v1beta.CloudControlsPartnerCore/GetPartnerPermissions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPartnerPermissionsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=organizations/*/locations/*/customers/*/workloads/*/partnerPermissions}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetPartnerPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetPartnerPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PartnerPermissions>newBuilder()
                      .setDefaultInstance(PartnerPermissions.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListAccessApprovalRequestsRequest, ListAccessApprovalRequestsResponse>
      listAccessApprovalRequestsMethodDescriptor =
          ApiMethodDescriptor
              .<ListAccessApprovalRequestsRequest, ListAccessApprovalRequestsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.cloudcontrolspartner.v1beta.CloudControlsPartnerCore/ListAccessApprovalRequests")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAccessApprovalRequestsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=organizations/*/locations/*/customers/*/workloads/*}/accessApprovalRequests",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAccessApprovalRequestsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAccessApprovalRequestsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAccessApprovalRequestsResponse>newBuilder()
                      .setDefaultInstance(ListAccessApprovalRequestsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetPartnerRequest, Partner> getPartnerMethodDescriptor =
      ApiMethodDescriptor.<GetPartnerRequest, Partner>newBuilder()
          .setFullMethodName(
              "google.cloud.cloudcontrolspartner.v1beta.CloudControlsPartnerCore/GetPartner")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetPartnerRequest>newBuilder()
                  .setPath(
                      "/v1beta/{name=organizations/*/locations/*/partner}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetPartnerRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetPartnerRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Partner>newBuilder()
                  .setDefaultInstance(Partner.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private final UnaryCallable<GetWorkloadRequest, Workload> getWorkloadCallable;
  private final UnaryCallable<ListWorkloadsRequest, ListWorkloadsResponse> listWorkloadsCallable;
  private final UnaryCallable<ListWorkloadsRequest, ListWorkloadsPagedResponse>
      listWorkloadsPagedCallable;
  private final UnaryCallable<GetCustomerRequest, Customer> getCustomerCallable;
  private final UnaryCallable<ListCustomersRequest, ListCustomersResponse> listCustomersCallable;
  private final UnaryCallable<ListCustomersRequest, ListCustomersPagedResponse>
      listCustomersPagedCallable;
  private final UnaryCallable<GetEkmConnectionsRequest, EkmConnections> getEkmConnectionsCallable;
  private final UnaryCallable<GetPartnerPermissionsRequest, PartnerPermissions>
      getPartnerPermissionsCallable;
  private final UnaryCallable<ListAccessApprovalRequestsRequest, ListAccessApprovalRequestsResponse>
      listAccessApprovalRequestsCallable;
  private final UnaryCallable<
          ListAccessApprovalRequestsRequest, ListAccessApprovalRequestsPagedResponse>
      listAccessApprovalRequestsPagedCallable;
  private final UnaryCallable<GetPartnerRequest, Partner> getPartnerCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCloudControlsPartnerCoreStub create(
      CloudControlsPartnerCoreStubSettings settings) throws IOException {
    return new HttpJsonCloudControlsPartnerCoreStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCloudControlsPartnerCoreStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCloudControlsPartnerCoreStub(
        CloudControlsPartnerCoreStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonCloudControlsPartnerCoreStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCloudControlsPartnerCoreStub(
        CloudControlsPartnerCoreStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCloudControlsPartnerCoreStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCloudControlsPartnerCoreStub(
      CloudControlsPartnerCoreStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonCloudControlsPartnerCoreCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCloudControlsPartnerCoreStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCloudControlsPartnerCoreStub(
      CloudControlsPartnerCoreStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetWorkloadRequest, Workload> getWorkloadTransportSettings =
        HttpJsonCallSettings.<GetWorkloadRequest, Workload>newBuilder()
            .setMethodDescriptor(getWorkloadMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListWorkloadsRequest, ListWorkloadsResponse>
        listWorkloadsTransportSettings =
            HttpJsonCallSettings.<ListWorkloadsRequest, ListWorkloadsResponse>newBuilder()
                .setMethodDescriptor(listWorkloadsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetCustomerRequest, Customer> getCustomerTransportSettings =
        HttpJsonCallSettings.<GetCustomerRequest, Customer>newBuilder()
            .setMethodDescriptor(getCustomerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListCustomersRequest, ListCustomersResponse>
        listCustomersTransportSettings =
            HttpJsonCallSettings.<ListCustomersRequest, ListCustomersResponse>newBuilder()
                .setMethodDescriptor(listCustomersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetEkmConnectionsRequest, EkmConnections>
        getEkmConnectionsTransportSettings =
            HttpJsonCallSettings.<GetEkmConnectionsRequest, EkmConnections>newBuilder()
                .setMethodDescriptor(getEkmConnectionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetPartnerPermissionsRequest, PartnerPermissions>
        getPartnerPermissionsTransportSettings =
            HttpJsonCallSettings.<GetPartnerPermissionsRequest, PartnerPermissions>newBuilder()
                .setMethodDescriptor(getPartnerPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListAccessApprovalRequestsRequest, ListAccessApprovalRequestsResponse>
        listAccessApprovalRequestsTransportSettings =
            HttpJsonCallSettings
                .<ListAccessApprovalRequestsRequest, ListAccessApprovalRequestsResponse>newBuilder()
                .setMethodDescriptor(listAccessApprovalRequestsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetPartnerRequest, Partner> getPartnerTransportSettings =
        HttpJsonCallSettings.<GetPartnerRequest, Partner>newBuilder()
            .setMethodDescriptor(getPartnerMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.getWorkloadCallable =
        callableFactory.createUnaryCallable(
            getWorkloadTransportSettings, settings.getWorkloadSettings(), clientContext);
    this.listWorkloadsCallable =
        callableFactory.createUnaryCallable(
            listWorkloadsTransportSettings, settings.listWorkloadsSettings(), clientContext);
    this.listWorkloadsPagedCallable =
        callableFactory.createPagedCallable(
            listWorkloadsTransportSettings, settings.listWorkloadsSettings(), clientContext);
    this.getCustomerCallable =
        callableFactory.createUnaryCallable(
            getCustomerTransportSettings, settings.getCustomerSettings(), clientContext);
    this.listCustomersCallable =
        callableFactory.createUnaryCallable(
            listCustomersTransportSettings, settings.listCustomersSettings(), clientContext);
    this.listCustomersPagedCallable =
        callableFactory.createPagedCallable(
            listCustomersTransportSettings, settings.listCustomersSettings(), clientContext);
    this.getEkmConnectionsCallable =
        callableFactory.createUnaryCallable(
            getEkmConnectionsTransportSettings,
            settings.getEkmConnectionsSettings(),
            clientContext);
    this.getPartnerPermissionsCallable =
        callableFactory.createUnaryCallable(
            getPartnerPermissionsTransportSettings,
            settings.getPartnerPermissionsSettings(),
            clientContext);
    this.listAccessApprovalRequestsCallable =
        callableFactory.createUnaryCallable(
            listAccessApprovalRequestsTransportSettings,
            settings.listAccessApprovalRequestsSettings(),
            clientContext);
    this.listAccessApprovalRequestsPagedCallable =
        callableFactory.createPagedCallable(
            listAccessApprovalRequestsTransportSettings,
            settings.listAccessApprovalRequestsSettings(),
            clientContext);
    this.getPartnerCallable =
        callableFactory.createUnaryCallable(
            getPartnerTransportSettings, settings.getPartnerSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getWorkloadMethodDescriptor);
    methodDescriptors.add(listWorkloadsMethodDescriptor);
    methodDescriptors.add(getCustomerMethodDescriptor);
    methodDescriptors.add(listCustomersMethodDescriptor);
    methodDescriptors.add(getEkmConnectionsMethodDescriptor);
    methodDescriptors.add(getPartnerPermissionsMethodDescriptor);
    methodDescriptors.add(listAccessApprovalRequestsMethodDescriptor);
    methodDescriptors.add(getPartnerMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetWorkloadRequest, Workload> getWorkloadCallable() {
    return getWorkloadCallable;
  }

  @Override
  public UnaryCallable<ListWorkloadsRequest, ListWorkloadsResponse> listWorkloadsCallable() {
    return listWorkloadsCallable;
  }

  @Override
  public UnaryCallable<ListWorkloadsRequest, ListWorkloadsPagedResponse>
      listWorkloadsPagedCallable() {
    return listWorkloadsPagedCallable;
  }

  @Override
  public UnaryCallable<GetCustomerRequest, Customer> getCustomerCallable() {
    return getCustomerCallable;
  }

  @Override
  public UnaryCallable<ListCustomersRequest, ListCustomersResponse> listCustomersCallable() {
    return listCustomersCallable;
  }

  @Override
  public UnaryCallable<ListCustomersRequest, ListCustomersPagedResponse>
      listCustomersPagedCallable() {
    return listCustomersPagedCallable;
  }

  @Override
  public UnaryCallable<GetEkmConnectionsRequest, EkmConnections> getEkmConnectionsCallable() {
    return getEkmConnectionsCallable;
  }

  @Override
  public UnaryCallable<GetPartnerPermissionsRequest, PartnerPermissions>
      getPartnerPermissionsCallable() {
    return getPartnerPermissionsCallable;
  }

  @Override
  public UnaryCallable<ListAccessApprovalRequestsRequest, ListAccessApprovalRequestsResponse>
      listAccessApprovalRequestsCallable() {
    return listAccessApprovalRequestsCallable;
  }

  @Override
  public UnaryCallable<ListAccessApprovalRequestsRequest, ListAccessApprovalRequestsPagedResponse>
      listAccessApprovalRequestsPagedCallable() {
    return listAccessApprovalRequestsPagedCallable;
  }

  @Override
  public UnaryCallable<GetPartnerRequest, Partner> getPartnerCallable() {
    return getPartnerCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
