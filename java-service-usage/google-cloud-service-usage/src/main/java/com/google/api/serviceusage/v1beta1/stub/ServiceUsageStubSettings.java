/*
 * Copyright 2022 Google LLC
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

package com.google.api.serviceusage.v1beta1.stub;

import static com.google.api.serviceusage.v1beta1.ServiceUsageClient.ListAdminOverridesPagedResponse;
import static com.google.api.serviceusage.v1beta1.ServiceUsageClient.ListConsumerOverridesPagedResponse;
import static com.google.api.serviceusage.v1beta1.ServiceUsageClient.ListConsumerQuotaMetricsPagedResponse;
import static com.google.api.serviceusage.v1beta1.ServiceUsageClient.ListServicesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.serviceusage.v1beta1.BatchEnableServicesRequest;
import com.google.api.serviceusage.v1beta1.ConsumerQuotaLimit;
import com.google.api.serviceusage.v1beta1.ConsumerQuotaMetric;
import com.google.api.serviceusage.v1beta1.CreateAdminOverrideRequest;
import com.google.api.serviceusage.v1beta1.CreateConsumerOverrideRequest;
import com.google.api.serviceusage.v1beta1.DeleteAdminOverrideRequest;
import com.google.api.serviceusage.v1beta1.DeleteConsumerOverrideRequest;
import com.google.api.serviceusage.v1beta1.DisableServiceRequest;
import com.google.api.serviceusage.v1beta1.EnableServiceRequest;
import com.google.api.serviceusage.v1beta1.GenerateServiceIdentityRequest;
import com.google.api.serviceusage.v1beta1.GetConsumerQuotaLimitRequest;
import com.google.api.serviceusage.v1beta1.GetConsumerQuotaMetricRequest;
import com.google.api.serviceusage.v1beta1.GetServiceRequest;
import com.google.api.serviceusage.v1beta1.ImportAdminOverridesMetadata;
import com.google.api.serviceusage.v1beta1.ImportAdminOverridesRequest;
import com.google.api.serviceusage.v1beta1.ImportAdminOverridesResponse;
import com.google.api.serviceusage.v1beta1.ImportConsumerOverridesMetadata;
import com.google.api.serviceusage.v1beta1.ImportConsumerOverridesRequest;
import com.google.api.serviceusage.v1beta1.ImportConsumerOverridesResponse;
import com.google.api.serviceusage.v1beta1.ListAdminOverridesRequest;
import com.google.api.serviceusage.v1beta1.ListAdminOverridesResponse;
import com.google.api.serviceusage.v1beta1.ListConsumerOverridesRequest;
import com.google.api.serviceusage.v1beta1.ListConsumerOverridesResponse;
import com.google.api.serviceusage.v1beta1.ListConsumerQuotaMetricsRequest;
import com.google.api.serviceusage.v1beta1.ListConsumerQuotaMetricsResponse;
import com.google.api.serviceusage.v1beta1.ListServicesRequest;
import com.google.api.serviceusage.v1beta1.ListServicesResponse;
import com.google.api.serviceusage.v1beta1.OperationMetadata;
import com.google.api.serviceusage.v1beta1.QuotaOverride;
import com.google.api.serviceusage.v1beta1.Service;
import com.google.api.serviceusage.v1beta1.ServiceIdentity;
import com.google.api.serviceusage.v1beta1.UpdateAdminOverrideRequest;
import com.google.api.serviceusage.v1beta1.UpdateConsumerOverrideRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ServiceUsageStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (serviceusage.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getService to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ServiceUsageStubSettings.Builder serviceUsageSettingsBuilder =
 *     ServiceUsageStubSettings.newBuilder();
 * serviceUsageSettingsBuilder
 *     .getServiceSettings()
 *     .setRetrySettings(
 *         serviceUsageSettingsBuilder
 *             .getServiceSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ServiceUsageStubSettings serviceUsageSettings = serviceUsageSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ServiceUsageStubSettings extends StubSettings<ServiceUsageStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/cloud-platform.read-only")
          .add("https://www.googleapis.com/auth/service.management")
          .build();

  private final UnaryCallSettings<EnableServiceRequest, Operation> enableServiceSettings;
  private final OperationCallSettings<EnableServiceRequest, Empty, OperationMetadata>
      enableServiceOperationSettings;
  private final UnaryCallSettings<DisableServiceRequest, Operation> disableServiceSettings;
  private final OperationCallSettings<DisableServiceRequest, Empty, OperationMetadata>
      disableServiceOperationSettings;
  private final UnaryCallSettings<GetServiceRequest, Service> getServiceSettings;
  private final PagedCallSettings<
          ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
      listServicesSettings;
  private final UnaryCallSettings<BatchEnableServicesRequest, Operation>
      batchEnableServicesSettings;
  private final OperationCallSettings<BatchEnableServicesRequest, Empty, OperationMetadata>
      batchEnableServicesOperationSettings;
  private final PagedCallSettings<
          ListConsumerQuotaMetricsRequest,
          ListConsumerQuotaMetricsResponse,
          ListConsumerQuotaMetricsPagedResponse>
      listConsumerQuotaMetricsSettings;
  private final UnaryCallSettings<GetConsumerQuotaMetricRequest, ConsumerQuotaMetric>
      getConsumerQuotaMetricSettings;
  private final UnaryCallSettings<GetConsumerQuotaLimitRequest, ConsumerQuotaLimit>
      getConsumerQuotaLimitSettings;
  private final UnaryCallSettings<CreateAdminOverrideRequest, Operation>
      createAdminOverrideSettings;
  private final OperationCallSettings<CreateAdminOverrideRequest, QuotaOverride, OperationMetadata>
      createAdminOverrideOperationSettings;
  private final UnaryCallSettings<UpdateAdminOverrideRequest, Operation>
      updateAdminOverrideSettings;
  private final OperationCallSettings<UpdateAdminOverrideRequest, QuotaOverride, OperationMetadata>
      updateAdminOverrideOperationSettings;
  private final UnaryCallSettings<DeleteAdminOverrideRequest, Operation>
      deleteAdminOverrideSettings;
  private final OperationCallSettings<DeleteAdminOverrideRequest, Empty, OperationMetadata>
      deleteAdminOverrideOperationSettings;
  private final PagedCallSettings<
          ListAdminOverridesRequest, ListAdminOverridesResponse, ListAdminOverridesPagedResponse>
      listAdminOverridesSettings;
  private final UnaryCallSettings<ImportAdminOverridesRequest, Operation>
      importAdminOverridesSettings;
  private final OperationCallSettings<
          ImportAdminOverridesRequest, ImportAdminOverridesResponse, ImportAdminOverridesMetadata>
      importAdminOverridesOperationSettings;
  private final UnaryCallSettings<CreateConsumerOverrideRequest, Operation>
      createConsumerOverrideSettings;
  private final OperationCallSettings<
          CreateConsumerOverrideRequest, QuotaOverride, OperationMetadata>
      createConsumerOverrideOperationSettings;
  private final UnaryCallSettings<UpdateConsumerOverrideRequest, Operation>
      updateConsumerOverrideSettings;
  private final OperationCallSettings<
          UpdateConsumerOverrideRequest, QuotaOverride, OperationMetadata>
      updateConsumerOverrideOperationSettings;
  private final UnaryCallSettings<DeleteConsumerOverrideRequest, Operation>
      deleteConsumerOverrideSettings;
  private final OperationCallSettings<DeleteConsumerOverrideRequest, Empty, OperationMetadata>
      deleteConsumerOverrideOperationSettings;
  private final PagedCallSettings<
          ListConsumerOverridesRequest,
          ListConsumerOverridesResponse,
          ListConsumerOverridesPagedResponse>
      listConsumerOverridesSettings;
  private final UnaryCallSettings<ImportConsumerOverridesRequest, Operation>
      importConsumerOverridesSettings;
  private final OperationCallSettings<
          ImportConsumerOverridesRequest,
          ImportConsumerOverridesResponse,
          ImportConsumerOverridesMetadata>
      importConsumerOverridesOperationSettings;
  private final UnaryCallSettings<GenerateServiceIdentityRequest, Operation>
      generateServiceIdentitySettings;
  private final OperationCallSettings<GenerateServiceIdentityRequest, ServiceIdentity, Empty>
      generateServiceIdentityOperationSettings;

  private static final PagedListDescriptor<ListServicesRequest, ListServicesResponse, Service>
      LIST_SERVICES_PAGE_STR_DESC =
          new PagedListDescriptor<ListServicesRequest, ListServicesResponse, Service>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListServicesRequest injectToken(ListServicesRequest payload, String token) {
              return ListServicesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListServicesRequest injectPageSize(ListServicesRequest payload, int pageSize) {
              return ListServicesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListServicesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListServicesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Service> extractResources(ListServicesResponse payload) {
              return payload.getServicesList() == null
                  ? ImmutableList.<Service>of()
                  : payload.getServicesList();
            }
          };

  private static final PagedListDescriptor<
          ListConsumerQuotaMetricsRequest, ListConsumerQuotaMetricsResponse, ConsumerQuotaMetric>
      LIST_CONSUMER_QUOTA_METRICS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListConsumerQuotaMetricsRequest,
              ListConsumerQuotaMetricsResponse,
              ConsumerQuotaMetric>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListConsumerQuotaMetricsRequest injectToken(
                ListConsumerQuotaMetricsRequest payload, String token) {
              return ListConsumerQuotaMetricsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListConsumerQuotaMetricsRequest injectPageSize(
                ListConsumerQuotaMetricsRequest payload, int pageSize) {
              return ListConsumerQuotaMetricsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListConsumerQuotaMetricsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListConsumerQuotaMetricsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ConsumerQuotaMetric> extractResources(
                ListConsumerQuotaMetricsResponse payload) {
              return payload.getMetricsList() == null
                  ? ImmutableList.<ConsumerQuotaMetric>of()
                  : payload.getMetricsList();
            }
          };

  private static final PagedListDescriptor<
          ListAdminOverridesRequest, ListAdminOverridesResponse, QuotaOverride>
      LIST_ADMIN_OVERRIDES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAdminOverridesRequest, ListAdminOverridesResponse, QuotaOverride>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAdminOverridesRequest injectToken(
                ListAdminOverridesRequest payload, String token) {
              return ListAdminOverridesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAdminOverridesRequest injectPageSize(
                ListAdminOverridesRequest payload, int pageSize) {
              return ListAdminOverridesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAdminOverridesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAdminOverridesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<QuotaOverride> extractResources(ListAdminOverridesResponse payload) {
              return payload.getOverridesList() == null
                  ? ImmutableList.<QuotaOverride>of()
                  : payload.getOverridesList();
            }
          };

  private static final PagedListDescriptor<
          ListConsumerOverridesRequest, ListConsumerOverridesResponse, QuotaOverride>
      LIST_CONSUMER_OVERRIDES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListConsumerOverridesRequest, ListConsumerOverridesResponse, QuotaOverride>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListConsumerOverridesRequest injectToken(
                ListConsumerOverridesRequest payload, String token) {
              return ListConsumerOverridesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListConsumerOverridesRequest injectPageSize(
                ListConsumerOverridesRequest payload, int pageSize) {
              return ListConsumerOverridesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListConsumerOverridesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListConsumerOverridesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<QuotaOverride> extractResources(ListConsumerOverridesResponse payload) {
              return payload.getOverridesList() == null
                  ? ImmutableList.<QuotaOverride>of()
                  : payload.getOverridesList();
            }
          };

  private static final PagedListResponseFactory<
          ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
      LIST_SERVICES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>() {
            @Override
            public ApiFuture<ListServicesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListServicesRequest, ListServicesResponse> callable,
                ListServicesRequest request,
                ApiCallContext context,
                ApiFuture<ListServicesResponse> futureResponse) {
              PageContext<ListServicesRequest, ListServicesResponse, Service> pageContext =
                  PageContext.create(callable, LIST_SERVICES_PAGE_STR_DESC, request, context);
              return ListServicesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListConsumerQuotaMetricsRequest,
          ListConsumerQuotaMetricsResponse,
          ListConsumerQuotaMetricsPagedResponse>
      LIST_CONSUMER_QUOTA_METRICS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListConsumerQuotaMetricsRequest,
              ListConsumerQuotaMetricsResponse,
              ListConsumerQuotaMetricsPagedResponse>() {
            @Override
            public ApiFuture<ListConsumerQuotaMetricsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListConsumerQuotaMetricsRequest, ListConsumerQuotaMetricsResponse>
                    callable,
                ListConsumerQuotaMetricsRequest request,
                ApiCallContext context,
                ApiFuture<ListConsumerQuotaMetricsResponse> futureResponse) {
              PageContext<
                      ListConsumerQuotaMetricsRequest,
                      ListConsumerQuotaMetricsResponse,
                      ConsumerQuotaMetric>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CONSUMER_QUOTA_METRICS_PAGE_STR_DESC, request, context);
              return ListConsumerQuotaMetricsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAdminOverridesRequest, ListAdminOverridesResponse, ListAdminOverridesPagedResponse>
      LIST_ADMIN_OVERRIDES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAdminOverridesRequest,
              ListAdminOverridesResponse,
              ListAdminOverridesPagedResponse>() {
            @Override
            public ApiFuture<ListAdminOverridesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAdminOverridesRequest, ListAdminOverridesResponse> callable,
                ListAdminOverridesRequest request,
                ApiCallContext context,
                ApiFuture<ListAdminOverridesResponse> futureResponse) {
              PageContext<ListAdminOverridesRequest, ListAdminOverridesResponse, QuotaOverride>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ADMIN_OVERRIDES_PAGE_STR_DESC, request, context);
              return ListAdminOverridesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListConsumerOverridesRequest,
          ListConsumerOverridesResponse,
          ListConsumerOverridesPagedResponse>
      LIST_CONSUMER_OVERRIDES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListConsumerOverridesRequest,
              ListConsumerOverridesResponse,
              ListConsumerOverridesPagedResponse>() {
            @Override
            public ApiFuture<ListConsumerOverridesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListConsumerOverridesRequest, ListConsumerOverridesResponse> callable,
                ListConsumerOverridesRequest request,
                ApiCallContext context,
                ApiFuture<ListConsumerOverridesResponse> futureResponse) {
              PageContext<
                      ListConsumerOverridesRequest, ListConsumerOverridesResponse, QuotaOverride>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CONSUMER_OVERRIDES_PAGE_STR_DESC, request, context);
              return ListConsumerOverridesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /**
   * Returns the object with the settings used for calls to enableService.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<EnableServiceRequest, Operation> enableServiceSettings() {
    return enableServiceSettings;
  }

  /** Returns the object with the settings used for calls to enableService. */
  public OperationCallSettings<EnableServiceRequest, Empty, OperationMetadata>
      enableServiceOperationSettings() {
    return enableServiceOperationSettings;
  }

  /**
   * Returns the object with the settings used for calls to disableService.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<DisableServiceRequest, Operation> disableServiceSettings() {
    return disableServiceSettings;
  }

  /** Returns the object with the settings used for calls to disableService. */
  public OperationCallSettings<DisableServiceRequest, Empty, OperationMetadata>
      disableServiceOperationSettings() {
    return disableServiceOperationSettings;
  }

  /**
   * Returns the object with the settings used for calls to getService.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<GetServiceRequest, Service> getServiceSettings() {
    return getServiceSettings;
  }

  /**
   * Returns the object with the settings used for calls to listServices.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public PagedCallSettings<ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
      listServicesSettings() {
    return listServicesSettings;
  }

  /**
   * Returns the object with the settings used for calls to batchEnableServices.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<BatchEnableServicesRequest, Operation> batchEnableServicesSettings() {
    return batchEnableServicesSettings;
  }

  /** Returns the object with the settings used for calls to batchEnableServices. */
  public OperationCallSettings<BatchEnableServicesRequest, Empty, OperationMetadata>
      batchEnableServicesOperationSettings() {
    return batchEnableServicesOperationSettings;
  }

  /** Returns the object with the settings used for calls to listConsumerQuotaMetrics. */
  public PagedCallSettings<
          ListConsumerQuotaMetricsRequest,
          ListConsumerQuotaMetricsResponse,
          ListConsumerQuotaMetricsPagedResponse>
      listConsumerQuotaMetricsSettings() {
    return listConsumerQuotaMetricsSettings;
  }

  /** Returns the object with the settings used for calls to getConsumerQuotaMetric. */
  public UnaryCallSettings<GetConsumerQuotaMetricRequest, ConsumerQuotaMetric>
      getConsumerQuotaMetricSettings() {
    return getConsumerQuotaMetricSettings;
  }

  /** Returns the object with the settings used for calls to getConsumerQuotaLimit. */
  public UnaryCallSettings<GetConsumerQuotaLimitRequest, ConsumerQuotaLimit>
      getConsumerQuotaLimitSettings() {
    return getConsumerQuotaLimitSettings;
  }

  /** Returns the object with the settings used for calls to createAdminOverride. */
  public UnaryCallSettings<CreateAdminOverrideRequest, Operation> createAdminOverrideSettings() {
    return createAdminOverrideSettings;
  }

  /** Returns the object with the settings used for calls to createAdminOverride. */
  public OperationCallSettings<CreateAdminOverrideRequest, QuotaOverride, OperationMetadata>
      createAdminOverrideOperationSettings() {
    return createAdminOverrideOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateAdminOverride. */
  public UnaryCallSettings<UpdateAdminOverrideRequest, Operation> updateAdminOverrideSettings() {
    return updateAdminOverrideSettings;
  }

  /** Returns the object with the settings used for calls to updateAdminOverride. */
  public OperationCallSettings<UpdateAdminOverrideRequest, QuotaOverride, OperationMetadata>
      updateAdminOverrideOperationSettings() {
    return updateAdminOverrideOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteAdminOverride. */
  public UnaryCallSettings<DeleteAdminOverrideRequest, Operation> deleteAdminOverrideSettings() {
    return deleteAdminOverrideSettings;
  }

  /** Returns the object with the settings used for calls to deleteAdminOverride. */
  public OperationCallSettings<DeleteAdminOverrideRequest, Empty, OperationMetadata>
      deleteAdminOverrideOperationSettings() {
    return deleteAdminOverrideOperationSettings;
  }

  /** Returns the object with the settings used for calls to listAdminOverrides. */
  public PagedCallSettings<
          ListAdminOverridesRequest, ListAdminOverridesResponse, ListAdminOverridesPagedResponse>
      listAdminOverridesSettings() {
    return listAdminOverridesSettings;
  }

  /** Returns the object with the settings used for calls to importAdminOverrides. */
  public UnaryCallSettings<ImportAdminOverridesRequest, Operation> importAdminOverridesSettings() {
    return importAdminOverridesSettings;
  }

  /** Returns the object with the settings used for calls to importAdminOverrides. */
  public OperationCallSettings<
          ImportAdminOverridesRequest, ImportAdminOverridesResponse, ImportAdminOverridesMetadata>
      importAdminOverridesOperationSettings() {
    return importAdminOverridesOperationSettings;
  }

  /** Returns the object with the settings used for calls to createConsumerOverride. */
  public UnaryCallSettings<CreateConsumerOverrideRequest, Operation>
      createConsumerOverrideSettings() {
    return createConsumerOverrideSettings;
  }

  /** Returns the object with the settings used for calls to createConsumerOverride. */
  public OperationCallSettings<CreateConsumerOverrideRequest, QuotaOverride, OperationMetadata>
      createConsumerOverrideOperationSettings() {
    return createConsumerOverrideOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateConsumerOverride. */
  public UnaryCallSettings<UpdateConsumerOverrideRequest, Operation>
      updateConsumerOverrideSettings() {
    return updateConsumerOverrideSettings;
  }

  /** Returns the object with the settings used for calls to updateConsumerOverride. */
  public OperationCallSettings<UpdateConsumerOverrideRequest, QuotaOverride, OperationMetadata>
      updateConsumerOverrideOperationSettings() {
    return updateConsumerOverrideOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteConsumerOverride. */
  public UnaryCallSettings<DeleteConsumerOverrideRequest, Operation>
      deleteConsumerOverrideSettings() {
    return deleteConsumerOverrideSettings;
  }

  /** Returns the object with the settings used for calls to deleteConsumerOverride. */
  public OperationCallSettings<DeleteConsumerOverrideRequest, Empty, OperationMetadata>
      deleteConsumerOverrideOperationSettings() {
    return deleteConsumerOverrideOperationSettings;
  }

  /** Returns the object with the settings used for calls to listConsumerOverrides. */
  public PagedCallSettings<
          ListConsumerOverridesRequest,
          ListConsumerOverridesResponse,
          ListConsumerOverridesPagedResponse>
      listConsumerOverridesSettings() {
    return listConsumerOverridesSettings;
  }

  /** Returns the object with the settings used for calls to importConsumerOverrides. */
  public UnaryCallSettings<ImportConsumerOverridesRequest, Operation>
      importConsumerOverridesSettings() {
    return importConsumerOverridesSettings;
  }

  /** Returns the object with the settings used for calls to importConsumerOverrides. */
  public OperationCallSettings<
          ImportConsumerOverridesRequest,
          ImportConsumerOverridesResponse,
          ImportConsumerOverridesMetadata>
      importConsumerOverridesOperationSettings() {
    return importConsumerOverridesOperationSettings;
  }

  /** Returns the object with the settings used for calls to generateServiceIdentity. */
  public UnaryCallSettings<GenerateServiceIdentityRequest, Operation>
      generateServiceIdentitySettings() {
    return generateServiceIdentitySettings;
  }

  /** Returns the object with the settings used for calls to generateServiceIdentity. */
  public OperationCallSettings<GenerateServiceIdentityRequest, ServiceIdentity, Empty>
      generateServiceIdentityOperationSettings() {
    return generateServiceIdentityOperationSettings;
  }

  public ServiceUsageStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcServiceUsageStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonServiceUsageStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "serviceusage.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "serviceusage.mtls.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder()
        .setScopesToApply(DEFAULT_SERVICE_SCOPES)
        .setUseJwtAccessWithScope(true);
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ServiceUsageStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ServiceUsageStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ServiceUsageStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  public static Builder newHttpJsonBuilder() {
    return Builder.createHttpJsonDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected ServiceUsageStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    enableServiceSettings = settingsBuilder.enableServiceSettings().build();
    enableServiceOperationSettings = settingsBuilder.enableServiceOperationSettings().build();
    disableServiceSettings = settingsBuilder.disableServiceSettings().build();
    disableServiceOperationSettings = settingsBuilder.disableServiceOperationSettings().build();
    getServiceSettings = settingsBuilder.getServiceSettings().build();
    listServicesSettings = settingsBuilder.listServicesSettings().build();
    batchEnableServicesSettings = settingsBuilder.batchEnableServicesSettings().build();
    batchEnableServicesOperationSettings =
        settingsBuilder.batchEnableServicesOperationSettings().build();
    listConsumerQuotaMetricsSettings = settingsBuilder.listConsumerQuotaMetricsSettings().build();
    getConsumerQuotaMetricSettings = settingsBuilder.getConsumerQuotaMetricSettings().build();
    getConsumerQuotaLimitSettings = settingsBuilder.getConsumerQuotaLimitSettings().build();
    createAdminOverrideSettings = settingsBuilder.createAdminOverrideSettings().build();
    createAdminOverrideOperationSettings =
        settingsBuilder.createAdminOverrideOperationSettings().build();
    updateAdminOverrideSettings = settingsBuilder.updateAdminOverrideSettings().build();
    updateAdminOverrideOperationSettings =
        settingsBuilder.updateAdminOverrideOperationSettings().build();
    deleteAdminOverrideSettings = settingsBuilder.deleteAdminOverrideSettings().build();
    deleteAdminOverrideOperationSettings =
        settingsBuilder.deleteAdminOverrideOperationSettings().build();
    listAdminOverridesSettings = settingsBuilder.listAdminOverridesSettings().build();
    importAdminOverridesSettings = settingsBuilder.importAdminOverridesSettings().build();
    importAdminOverridesOperationSettings =
        settingsBuilder.importAdminOverridesOperationSettings().build();
    createConsumerOverrideSettings = settingsBuilder.createConsumerOverrideSettings().build();
    createConsumerOverrideOperationSettings =
        settingsBuilder.createConsumerOverrideOperationSettings().build();
    updateConsumerOverrideSettings = settingsBuilder.updateConsumerOverrideSettings().build();
    updateConsumerOverrideOperationSettings =
        settingsBuilder.updateConsumerOverrideOperationSettings().build();
    deleteConsumerOverrideSettings = settingsBuilder.deleteConsumerOverrideSettings().build();
    deleteConsumerOverrideOperationSettings =
        settingsBuilder.deleteConsumerOverrideOperationSettings().build();
    listConsumerOverridesSettings = settingsBuilder.listConsumerOverridesSettings().build();
    importConsumerOverridesSettings = settingsBuilder.importConsumerOverridesSettings().build();
    importConsumerOverridesOperationSettings =
        settingsBuilder.importConsumerOverridesOperationSettings().build();
    generateServiceIdentitySettings = settingsBuilder.generateServiceIdentitySettings().build();
    generateServiceIdentityOperationSettings =
        settingsBuilder.generateServiceIdentityOperationSettings().build();
  }

  /** Builder for ServiceUsageStubSettings. */
  public static class Builder extends StubSettings.Builder<ServiceUsageStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<EnableServiceRequest, Operation> enableServiceSettings;
    private final OperationCallSettings.Builder<EnableServiceRequest, Empty, OperationMetadata>
        enableServiceOperationSettings;
    private final UnaryCallSettings.Builder<DisableServiceRequest, Operation>
        disableServiceSettings;
    private final OperationCallSettings.Builder<DisableServiceRequest, Empty, OperationMetadata>
        disableServiceOperationSettings;
    private final UnaryCallSettings.Builder<GetServiceRequest, Service> getServiceSettings;
    private final PagedCallSettings.Builder<
            ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
        listServicesSettings;
    private final UnaryCallSettings.Builder<BatchEnableServicesRequest, Operation>
        batchEnableServicesSettings;
    private final OperationCallSettings.Builder<
            BatchEnableServicesRequest, Empty, OperationMetadata>
        batchEnableServicesOperationSettings;
    private final PagedCallSettings.Builder<
            ListConsumerQuotaMetricsRequest,
            ListConsumerQuotaMetricsResponse,
            ListConsumerQuotaMetricsPagedResponse>
        listConsumerQuotaMetricsSettings;
    private final UnaryCallSettings.Builder<GetConsumerQuotaMetricRequest, ConsumerQuotaMetric>
        getConsumerQuotaMetricSettings;
    private final UnaryCallSettings.Builder<GetConsumerQuotaLimitRequest, ConsumerQuotaLimit>
        getConsumerQuotaLimitSettings;
    private final UnaryCallSettings.Builder<CreateAdminOverrideRequest, Operation>
        createAdminOverrideSettings;
    private final OperationCallSettings.Builder<
            CreateAdminOverrideRequest, QuotaOverride, OperationMetadata>
        createAdminOverrideOperationSettings;
    private final UnaryCallSettings.Builder<UpdateAdminOverrideRequest, Operation>
        updateAdminOverrideSettings;
    private final OperationCallSettings.Builder<
            UpdateAdminOverrideRequest, QuotaOverride, OperationMetadata>
        updateAdminOverrideOperationSettings;
    private final UnaryCallSettings.Builder<DeleteAdminOverrideRequest, Operation>
        deleteAdminOverrideSettings;
    private final OperationCallSettings.Builder<
            DeleteAdminOverrideRequest, Empty, OperationMetadata>
        deleteAdminOverrideOperationSettings;
    private final PagedCallSettings.Builder<
            ListAdminOverridesRequest, ListAdminOverridesResponse, ListAdminOverridesPagedResponse>
        listAdminOverridesSettings;
    private final UnaryCallSettings.Builder<ImportAdminOverridesRequest, Operation>
        importAdminOverridesSettings;
    private final OperationCallSettings.Builder<
            ImportAdminOverridesRequest, ImportAdminOverridesResponse, ImportAdminOverridesMetadata>
        importAdminOverridesOperationSettings;
    private final UnaryCallSettings.Builder<CreateConsumerOverrideRequest, Operation>
        createConsumerOverrideSettings;
    private final OperationCallSettings.Builder<
            CreateConsumerOverrideRequest, QuotaOverride, OperationMetadata>
        createConsumerOverrideOperationSettings;
    private final UnaryCallSettings.Builder<UpdateConsumerOverrideRequest, Operation>
        updateConsumerOverrideSettings;
    private final OperationCallSettings.Builder<
            UpdateConsumerOverrideRequest, QuotaOverride, OperationMetadata>
        updateConsumerOverrideOperationSettings;
    private final UnaryCallSettings.Builder<DeleteConsumerOverrideRequest, Operation>
        deleteConsumerOverrideSettings;
    private final OperationCallSettings.Builder<
            DeleteConsumerOverrideRequest, Empty, OperationMetadata>
        deleteConsumerOverrideOperationSettings;
    private final PagedCallSettings.Builder<
            ListConsumerOverridesRequest,
            ListConsumerOverridesResponse,
            ListConsumerOverridesPagedResponse>
        listConsumerOverridesSettings;
    private final UnaryCallSettings.Builder<ImportConsumerOverridesRequest, Operation>
        importConsumerOverridesSettings;
    private final OperationCallSettings.Builder<
            ImportConsumerOverridesRequest,
            ImportConsumerOverridesResponse,
            ImportConsumerOverridesMetadata>
        importConsumerOverridesOperationSettings;
    private final UnaryCallSettings.Builder<GenerateServiceIdentityRequest, Operation>
        generateServiceIdentitySettings;
    private final OperationCallSettings.Builder<
            GenerateServiceIdentityRequest, ServiceIdentity, Empty>
        generateServiceIdentityOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_0_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(5000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(5000L))
              .setTotalTimeout(Duration.ofMillis(5000L))
              .build();
      definitions.put("no_retry_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      enableServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      enableServiceOperationSettings = OperationCallSettings.newBuilder();
      disableServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      disableServiceOperationSettings = OperationCallSettings.newBuilder();
      getServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listServicesSettings = PagedCallSettings.newBuilder(LIST_SERVICES_PAGE_STR_FACT);
      batchEnableServicesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchEnableServicesOperationSettings = OperationCallSettings.newBuilder();
      listConsumerQuotaMetricsSettings =
          PagedCallSettings.newBuilder(LIST_CONSUMER_QUOTA_METRICS_PAGE_STR_FACT);
      getConsumerQuotaMetricSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getConsumerQuotaLimitSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAdminOverrideSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAdminOverrideOperationSettings = OperationCallSettings.newBuilder();
      updateAdminOverrideSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAdminOverrideOperationSettings = OperationCallSettings.newBuilder();
      deleteAdminOverrideSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAdminOverrideOperationSettings = OperationCallSettings.newBuilder();
      listAdminOverridesSettings = PagedCallSettings.newBuilder(LIST_ADMIN_OVERRIDES_PAGE_STR_FACT);
      importAdminOverridesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importAdminOverridesOperationSettings = OperationCallSettings.newBuilder();
      createConsumerOverrideSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createConsumerOverrideOperationSettings = OperationCallSettings.newBuilder();
      updateConsumerOverrideSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateConsumerOverrideOperationSettings = OperationCallSettings.newBuilder();
      deleteConsumerOverrideSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteConsumerOverrideOperationSettings = OperationCallSettings.newBuilder();
      listConsumerOverridesSettings =
          PagedCallSettings.newBuilder(LIST_CONSUMER_OVERRIDES_PAGE_STR_FACT);
      importConsumerOverridesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importConsumerOverridesOperationSettings = OperationCallSettings.newBuilder();
      generateServiceIdentitySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      generateServiceIdentityOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              enableServiceSettings,
              disableServiceSettings,
              getServiceSettings,
              listServicesSettings,
              batchEnableServicesSettings,
              listConsumerQuotaMetricsSettings,
              getConsumerQuotaMetricSettings,
              getConsumerQuotaLimitSettings,
              createAdminOverrideSettings,
              updateAdminOverrideSettings,
              deleteAdminOverrideSettings,
              listAdminOverridesSettings,
              importAdminOverridesSettings,
              createConsumerOverrideSettings,
              updateConsumerOverrideSettings,
              deleteConsumerOverrideSettings,
              listConsumerOverridesSettings,
              importConsumerOverridesSettings,
              generateServiceIdentitySettings);
      initDefaults(this);
    }

    protected Builder(ServiceUsageStubSettings settings) {
      super(settings);

      enableServiceSettings = settings.enableServiceSettings.toBuilder();
      enableServiceOperationSettings = settings.enableServiceOperationSettings.toBuilder();
      disableServiceSettings = settings.disableServiceSettings.toBuilder();
      disableServiceOperationSettings = settings.disableServiceOperationSettings.toBuilder();
      getServiceSettings = settings.getServiceSettings.toBuilder();
      listServicesSettings = settings.listServicesSettings.toBuilder();
      batchEnableServicesSettings = settings.batchEnableServicesSettings.toBuilder();
      batchEnableServicesOperationSettings =
          settings.batchEnableServicesOperationSettings.toBuilder();
      listConsumerQuotaMetricsSettings = settings.listConsumerQuotaMetricsSettings.toBuilder();
      getConsumerQuotaMetricSettings = settings.getConsumerQuotaMetricSettings.toBuilder();
      getConsumerQuotaLimitSettings = settings.getConsumerQuotaLimitSettings.toBuilder();
      createAdminOverrideSettings = settings.createAdminOverrideSettings.toBuilder();
      createAdminOverrideOperationSettings =
          settings.createAdminOverrideOperationSettings.toBuilder();
      updateAdminOverrideSettings = settings.updateAdminOverrideSettings.toBuilder();
      updateAdminOverrideOperationSettings =
          settings.updateAdminOverrideOperationSettings.toBuilder();
      deleteAdminOverrideSettings = settings.deleteAdminOverrideSettings.toBuilder();
      deleteAdminOverrideOperationSettings =
          settings.deleteAdminOverrideOperationSettings.toBuilder();
      listAdminOverridesSettings = settings.listAdminOverridesSettings.toBuilder();
      importAdminOverridesSettings = settings.importAdminOverridesSettings.toBuilder();
      importAdminOverridesOperationSettings =
          settings.importAdminOverridesOperationSettings.toBuilder();
      createConsumerOverrideSettings = settings.createConsumerOverrideSettings.toBuilder();
      createConsumerOverrideOperationSettings =
          settings.createConsumerOverrideOperationSettings.toBuilder();
      updateConsumerOverrideSettings = settings.updateConsumerOverrideSettings.toBuilder();
      updateConsumerOverrideOperationSettings =
          settings.updateConsumerOverrideOperationSettings.toBuilder();
      deleteConsumerOverrideSettings = settings.deleteConsumerOverrideSettings.toBuilder();
      deleteConsumerOverrideOperationSettings =
          settings.deleteConsumerOverrideOperationSettings.toBuilder();
      listConsumerOverridesSettings = settings.listConsumerOverridesSettings.toBuilder();
      importConsumerOverridesSettings = settings.importConsumerOverridesSettings.toBuilder();
      importConsumerOverridesOperationSettings =
          settings.importConsumerOverridesOperationSettings.toBuilder();
      generateServiceIdentitySettings = settings.generateServiceIdentitySettings.toBuilder();
      generateServiceIdentityOperationSettings =
          settings.generateServiceIdentityOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              enableServiceSettings,
              disableServiceSettings,
              getServiceSettings,
              listServicesSettings,
              batchEnableServicesSettings,
              listConsumerQuotaMetricsSettings,
              getConsumerQuotaMetricSettings,
              getConsumerQuotaLimitSettings,
              createAdminOverrideSettings,
              updateAdminOverrideSettings,
              deleteAdminOverrideSettings,
              listAdminOverridesSettings,
              importAdminOverridesSettings,
              createConsumerOverrideSettings,
              updateConsumerOverrideSettings,
              deleteConsumerOverrideSettings,
              listConsumerOverridesSettings,
              importConsumerOverridesSettings,
              generateServiceIdentitySettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .enableServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .disableServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listServicesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .batchEnableServicesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listConsumerQuotaMetricsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getConsumerQuotaMetricSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getConsumerQuotaLimitSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createAdminOverrideSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateAdminOverrideSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteAdminOverrideSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listAdminOverridesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .importAdminOverridesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createConsumerOverrideSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateConsumerOverrideSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteConsumerOverrideSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listConsumerOverridesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .importConsumerOverridesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .generateServiceIdentitySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .enableServiceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<EnableServiceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .disableServiceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DisableServiceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .batchEnableServicesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BatchEnableServicesRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createAdminOverrideOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateAdminOverrideRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(QuotaOverride.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateAdminOverrideOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateAdminOverrideRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(QuotaOverride.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteAdminOverrideOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteAdminOverrideRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .importAdminOverridesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ImportAdminOverridesRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  ImportAdminOverridesResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  ImportAdminOverridesMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createConsumerOverrideOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateConsumerOverrideRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(QuotaOverride.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateConsumerOverrideOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateConsumerOverrideRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(QuotaOverride.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteConsumerOverrideOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteConsumerOverrideRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .importConsumerOverridesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ImportConsumerOverridesRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  ImportConsumerOverridesResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  ImportConsumerOverridesMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .generateServiceIdentityOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<GenerateServiceIdentityRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ServiceIdentity.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Empty.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      return builder;
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /**
     * Returns the builder for the settings used for calls to enableService.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<EnableServiceRequest, Operation> enableServiceSettings() {
      return enableServiceSettings;
    }

    /** Returns the builder for the settings used for calls to enableService. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<EnableServiceRequest, Empty, OperationMetadata>
        enableServiceOperationSettings() {
      return enableServiceOperationSettings;
    }

    /**
     * Returns the builder for the settings used for calls to disableService.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<DisableServiceRequest, Operation> disableServiceSettings() {
      return disableServiceSettings;
    }

    /** Returns the builder for the settings used for calls to disableService. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DisableServiceRequest, Empty, OperationMetadata>
        disableServiceOperationSettings() {
      return disableServiceOperationSettings;
    }

    /**
     * Returns the builder for the settings used for calls to getService.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<GetServiceRequest, Service> getServiceSettings() {
      return getServiceSettings;
    }

    /**
     * Returns the builder for the settings used for calls to listServices.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public PagedCallSettings.Builder<
            ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
        listServicesSettings() {
      return listServicesSettings;
    }

    /**
     * Returns the builder for the settings used for calls to batchEnableServices.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<BatchEnableServicesRequest, Operation>
        batchEnableServicesSettings() {
      return batchEnableServicesSettings;
    }

    /** Returns the builder for the settings used for calls to batchEnableServices. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<BatchEnableServicesRequest, Empty, OperationMetadata>
        batchEnableServicesOperationSettings() {
      return batchEnableServicesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listConsumerQuotaMetrics. */
    public PagedCallSettings.Builder<
            ListConsumerQuotaMetricsRequest,
            ListConsumerQuotaMetricsResponse,
            ListConsumerQuotaMetricsPagedResponse>
        listConsumerQuotaMetricsSettings() {
      return listConsumerQuotaMetricsSettings;
    }

    /** Returns the builder for the settings used for calls to getConsumerQuotaMetric. */
    public UnaryCallSettings.Builder<GetConsumerQuotaMetricRequest, ConsumerQuotaMetric>
        getConsumerQuotaMetricSettings() {
      return getConsumerQuotaMetricSettings;
    }

    /** Returns the builder for the settings used for calls to getConsumerQuotaLimit. */
    public UnaryCallSettings.Builder<GetConsumerQuotaLimitRequest, ConsumerQuotaLimit>
        getConsumerQuotaLimitSettings() {
      return getConsumerQuotaLimitSettings;
    }

    /** Returns the builder for the settings used for calls to createAdminOverride. */
    public UnaryCallSettings.Builder<CreateAdminOverrideRequest, Operation>
        createAdminOverrideSettings() {
      return createAdminOverrideSettings;
    }

    /** Returns the builder for the settings used for calls to createAdminOverride. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateAdminOverrideRequest, QuotaOverride, OperationMetadata>
        createAdminOverrideOperationSettings() {
      return createAdminOverrideOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateAdminOverride. */
    public UnaryCallSettings.Builder<UpdateAdminOverrideRequest, Operation>
        updateAdminOverrideSettings() {
      return updateAdminOverrideSettings;
    }

    /** Returns the builder for the settings used for calls to updateAdminOverride. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            UpdateAdminOverrideRequest, QuotaOverride, OperationMetadata>
        updateAdminOverrideOperationSettings() {
      return updateAdminOverrideOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAdminOverride. */
    public UnaryCallSettings.Builder<DeleteAdminOverrideRequest, Operation>
        deleteAdminOverrideSettings() {
      return deleteAdminOverrideSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAdminOverride. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteAdminOverrideRequest, Empty, OperationMetadata>
        deleteAdminOverrideOperationSettings() {
      return deleteAdminOverrideOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listAdminOverrides. */
    public PagedCallSettings.Builder<
            ListAdminOverridesRequest, ListAdminOverridesResponse, ListAdminOverridesPagedResponse>
        listAdminOverridesSettings() {
      return listAdminOverridesSettings;
    }

    /** Returns the builder for the settings used for calls to importAdminOverrides. */
    public UnaryCallSettings.Builder<ImportAdminOverridesRequest, Operation>
        importAdminOverridesSettings() {
      return importAdminOverridesSettings;
    }

    /** Returns the builder for the settings used for calls to importAdminOverrides. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            ImportAdminOverridesRequest, ImportAdminOverridesResponse, ImportAdminOverridesMetadata>
        importAdminOverridesOperationSettings() {
      return importAdminOverridesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createConsumerOverride. */
    public UnaryCallSettings.Builder<CreateConsumerOverrideRequest, Operation>
        createConsumerOverrideSettings() {
      return createConsumerOverrideSettings;
    }

    /** Returns the builder for the settings used for calls to createConsumerOverride. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateConsumerOverrideRequest, QuotaOverride, OperationMetadata>
        createConsumerOverrideOperationSettings() {
      return createConsumerOverrideOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateConsumerOverride. */
    public UnaryCallSettings.Builder<UpdateConsumerOverrideRequest, Operation>
        updateConsumerOverrideSettings() {
      return updateConsumerOverrideSettings;
    }

    /** Returns the builder for the settings used for calls to updateConsumerOverride. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            UpdateConsumerOverrideRequest, QuotaOverride, OperationMetadata>
        updateConsumerOverrideOperationSettings() {
      return updateConsumerOverrideOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteConsumerOverride. */
    public UnaryCallSettings.Builder<DeleteConsumerOverrideRequest, Operation>
        deleteConsumerOverrideSettings() {
      return deleteConsumerOverrideSettings;
    }

    /** Returns the builder for the settings used for calls to deleteConsumerOverride. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteConsumerOverrideRequest, Empty, OperationMetadata>
        deleteConsumerOverrideOperationSettings() {
      return deleteConsumerOverrideOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listConsumerOverrides. */
    public PagedCallSettings.Builder<
            ListConsumerOverridesRequest,
            ListConsumerOverridesResponse,
            ListConsumerOverridesPagedResponse>
        listConsumerOverridesSettings() {
      return listConsumerOverridesSettings;
    }

    /** Returns the builder for the settings used for calls to importConsumerOverrides. */
    public UnaryCallSettings.Builder<ImportConsumerOverridesRequest, Operation>
        importConsumerOverridesSettings() {
      return importConsumerOverridesSettings;
    }

    /** Returns the builder for the settings used for calls to importConsumerOverrides. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            ImportConsumerOverridesRequest,
            ImportConsumerOverridesResponse,
            ImportConsumerOverridesMetadata>
        importConsumerOverridesOperationSettings() {
      return importConsumerOverridesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to generateServiceIdentity. */
    public UnaryCallSettings.Builder<GenerateServiceIdentityRequest, Operation>
        generateServiceIdentitySettings() {
      return generateServiceIdentitySettings;
    }

    /** Returns the builder for the settings used for calls to generateServiceIdentity. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<GenerateServiceIdentityRequest, ServiceIdentity, Empty>
        generateServiceIdentityOperationSettings() {
      return generateServiceIdentityOperationSettings;
    }

    @Override
    public ServiceUsageStubSettings build() throws IOException {
      return new ServiceUsageStubSettings(this);
    }
  }
}
