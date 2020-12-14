/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.security.privateca.v1beta1.stub;

import static com.google.cloud.security.privateca.v1beta1.CertificateAuthorityServiceClient.ListCertificateAuthoritiesPagedResponse;
import static com.google.cloud.security.privateca.v1beta1.CertificateAuthorityServiceClient.ListCertificateRevocationListsPagedResponse;
import static com.google.cloud.security.privateca.v1beta1.CertificateAuthorityServiceClient.ListCertificatesPagedResponse;
import static com.google.cloud.security.privateca.v1beta1.CertificateAuthorityServiceClient.ListReusableConfigsPagedResponse;

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
import com.google.cloud.security.privateca.v1beta1.ActivateCertificateAuthorityRequest;
import com.google.cloud.security.privateca.v1beta1.Certificate;
import com.google.cloud.security.privateca.v1beta1.CertificateAuthority;
import com.google.cloud.security.privateca.v1beta1.CertificateRevocationList;
import com.google.cloud.security.privateca.v1beta1.CreateCertificateAuthorityRequest;
import com.google.cloud.security.privateca.v1beta1.CreateCertificateRequest;
import com.google.cloud.security.privateca.v1beta1.DisableCertificateAuthorityRequest;
import com.google.cloud.security.privateca.v1beta1.EnableCertificateAuthorityRequest;
import com.google.cloud.security.privateca.v1beta1.FetchCertificateAuthorityCsrRequest;
import com.google.cloud.security.privateca.v1beta1.FetchCertificateAuthorityCsrResponse;
import com.google.cloud.security.privateca.v1beta1.GetCertificateAuthorityRequest;
import com.google.cloud.security.privateca.v1beta1.GetCertificateRequest;
import com.google.cloud.security.privateca.v1beta1.GetCertificateRevocationListRequest;
import com.google.cloud.security.privateca.v1beta1.GetReusableConfigRequest;
import com.google.cloud.security.privateca.v1beta1.ListCertificateAuthoritiesRequest;
import com.google.cloud.security.privateca.v1beta1.ListCertificateAuthoritiesResponse;
import com.google.cloud.security.privateca.v1beta1.ListCertificateRevocationListsRequest;
import com.google.cloud.security.privateca.v1beta1.ListCertificateRevocationListsResponse;
import com.google.cloud.security.privateca.v1beta1.ListCertificatesRequest;
import com.google.cloud.security.privateca.v1beta1.ListCertificatesResponse;
import com.google.cloud.security.privateca.v1beta1.ListReusableConfigsRequest;
import com.google.cloud.security.privateca.v1beta1.ListReusableConfigsResponse;
import com.google.cloud.security.privateca.v1beta1.OperationMetadata;
import com.google.cloud.security.privateca.v1beta1.RestoreCertificateAuthorityRequest;
import com.google.cloud.security.privateca.v1beta1.ReusableConfig;
import com.google.cloud.security.privateca.v1beta1.RevokeCertificateRequest;
import com.google.cloud.security.privateca.v1beta1.ScheduleDeleteCertificateAuthorityRequest;
import com.google.cloud.security.privateca.v1beta1.UpdateCertificateAuthorityRequest;
import com.google.cloud.security.privateca.v1beta1.UpdateCertificateRequest;
import com.google.cloud.security.privateca.v1beta1.UpdateCertificateRevocationListRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link CertificateAuthorityServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (privateca.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createCertificate to 30 seconds:
 *
 * <pre>{@code
 * CertificateAuthorityServiceStubSettings.Builder certificateAuthorityServiceSettingsBuilder =
 *     CertificateAuthorityServiceStubSettings.newBuilder();
 * certificateAuthorityServiceSettingsBuilder
 *     .createCertificateSettings()
 *     .setRetrySettings(
 *         certificateAuthorityServiceSettingsBuilder
 *             .createCertificateSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * CertificateAuthorityServiceStubSettings certificateAuthorityServiceSettings =
 *     certificateAuthorityServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class CertificateAuthorityServiceStubSettings
    extends StubSettings<CertificateAuthorityServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateCertificateRequest, Certificate> createCertificateSettings;
  private final UnaryCallSettings<GetCertificateRequest, Certificate> getCertificateSettings;
  private final PagedCallSettings<
          ListCertificatesRequest, ListCertificatesResponse, ListCertificatesPagedResponse>
      listCertificatesSettings;
  private final UnaryCallSettings<RevokeCertificateRequest, Certificate> revokeCertificateSettings;
  private final UnaryCallSettings<UpdateCertificateRequest, Certificate> updateCertificateSettings;
  private final UnaryCallSettings<ActivateCertificateAuthorityRequest, Operation>
      activateCertificateAuthoritySettings;
  private final OperationCallSettings<
          ActivateCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      activateCertificateAuthorityOperationSettings;
  private final UnaryCallSettings<CreateCertificateAuthorityRequest, Operation>
      createCertificateAuthoritySettings;
  private final OperationCallSettings<
          CreateCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      createCertificateAuthorityOperationSettings;
  private final UnaryCallSettings<DisableCertificateAuthorityRequest, Operation>
      disableCertificateAuthoritySettings;
  private final OperationCallSettings<
          DisableCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      disableCertificateAuthorityOperationSettings;
  private final UnaryCallSettings<EnableCertificateAuthorityRequest, Operation>
      enableCertificateAuthoritySettings;
  private final OperationCallSettings<
          EnableCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      enableCertificateAuthorityOperationSettings;
  private final UnaryCallSettings<
          FetchCertificateAuthorityCsrRequest, FetchCertificateAuthorityCsrResponse>
      fetchCertificateAuthorityCsrSettings;
  private final UnaryCallSettings<GetCertificateAuthorityRequest, CertificateAuthority>
      getCertificateAuthoritySettings;
  private final PagedCallSettings<
          ListCertificateAuthoritiesRequest,
          ListCertificateAuthoritiesResponse,
          ListCertificateAuthoritiesPagedResponse>
      listCertificateAuthoritiesSettings;
  private final UnaryCallSettings<RestoreCertificateAuthorityRequest, Operation>
      restoreCertificateAuthoritySettings;
  private final OperationCallSettings<
          RestoreCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      restoreCertificateAuthorityOperationSettings;
  private final UnaryCallSettings<ScheduleDeleteCertificateAuthorityRequest, Operation>
      scheduleDeleteCertificateAuthoritySettings;
  private final OperationCallSettings<
          ScheduleDeleteCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      scheduleDeleteCertificateAuthorityOperationSettings;
  private final UnaryCallSettings<UpdateCertificateAuthorityRequest, Operation>
      updateCertificateAuthoritySettings;
  private final OperationCallSettings<
          UpdateCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      updateCertificateAuthorityOperationSettings;
  private final UnaryCallSettings<GetCertificateRevocationListRequest, CertificateRevocationList>
      getCertificateRevocationListSettings;
  private final PagedCallSettings<
          ListCertificateRevocationListsRequest,
          ListCertificateRevocationListsResponse,
          ListCertificateRevocationListsPagedResponse>
      listCertificateRevocationListsSettings;
  private final UnaryCallSettings<UpdateCertificateRevocationListRequest, Operation>
      updateCertificateRevocationListSettings;
  private final OperationCallSettings<
          UpdateCertificateRevocationListRequest, CertificateRevocationList, OperationMetadata>
      updateCertificateRevocationListOperationSettings;
  private final UnaryCallSettings<GetReusableConfigRequest, ReusableConfig>
      getReusableConfigSettings;
  private final PagedCallSettings<
          ListReusableConfigsRequest, ListReusableConfigsResponse, ListReusableConfigsPagedResponse>
      listReusableConfigsSettings;

  private static final PagedListDescriptor<
          ListCertificatesRequest, ListCertificatesResponse, Certificate>
      LIST_CERTIFICATES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListCertificatesRequest, ListCertificatesResponse, Certificate>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCertificatesRequest injectToken(
                ListCertificatesRequest payload, String token) {
              return ListCertificatesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListCertificatesRequest injectPageSize(
                ListCertificatesRequest payload, int pageSize) {
              return ListCertificatesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListCertificatesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCertificatesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Certificate> extractResources(ListCertificatesResponse payload) {
              return payload.getCertificatesList() == null
                  ? ImmutableList.<Certificate>of()
                  : payload.getCertificatesList();
            }
          };

  private static final PagedListDescriptor<
          ListCertificateAuthoritiesRequest,
          ListCertificateAuthoritiesResponse,
          CertificateAuthority>
      LIST_CERTIFICATE_AUTHORITIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListCertificateAuthoritiesRequest,
              ListCertificateAuthoritiesResponse,
              CertificateAuthority>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCertificateAuthoritiesRequest injectToken(
                ListCertificateAuthoritiesRequest payload, String token) {
              return ListCertificateAuthoritiesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListCertificateAuthoritiesRequest injectPageSize(
                ListCertificateAuthoritiesRequest payload, int pageSize) {
              return ListCertificateAuthoritiesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListCertificateAuthoritiesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCertificateAuthoritiesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<CertificateAuthority> extractResources(
                ListCertificateAuthoritiesResponse payload) {
              return payload.getCertificateAuthoritiesList() == null
                  ? ImmutableList.<CertificateAuthority>of()
                  : payload.getCertificateAuthoritiesList();
            }
          };

  private static final PagedListDescriptor<
          ListCertificateRevocationListsRequest,
          ListCertificateRevocationListsResponse,
          CertificateRevocationList>
      LIST_CERTIFICATE_REVOCATION_LISTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListCertificateRevocationListsRequest,
              ListCertificateRevocationListsResponse,
              CertificateRevocationList>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCertificateRevocationListsRequest injectToken(
                ListCertificateRevocationListsRequest payload, String token) {
              return ListCertificateRevocationListsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListCertificateRevocationListsRequest injectPageSize(
                ListCertificateRevocationListsRequest payload, int pageSize) {
              return ListCertificateRevocationListsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListCertificateRevocationListsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCertificateRevocationListsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<CertificateRevocationList> extractResources(
                ListCertificateRevocationListsResponse payload) {
              return payload.getCertificateRevocationListsList() == null
                  ? ImmutableList.<CertificateRevocationList>of()
                  : payload.getCertificateRevocationListsList();
            }
          };

  private static final PagedListDescriptor<
          ListReusableConfigsRequest, ListReusableConfigsResponse, ReusableConfig>
      LIST_REUSABLE_CONFIGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListReusableConfigsRequest, ListReusableConfigsResponse, ReusableConfig>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListReusableConfigsRequest injectToken(
                ListReusableConfigsRequest payload, String token) {
              return ListReusableConfigsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListReusableConfigsRequest injectPageSize(
                ListReusableConfigsRequest payload, int pageSize) {
              return ListReusableConfigsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListReusableConfigsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListReusableConfigsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ReusableConfig> extractResources(ListReusableConfigsResponse payload) {
              return payload.getReusableConfigsList() == null
                  ? ImmutableList.<ReusableConfig>of()
                  : payload.getReusableConfigsList();
            }
          };

  private static final PagedListResponseFactory<
          ListCertificatesRequest, ListCertificatesResponse, ListCertificatesPagedResponse>
      LIST_CERTIFICATES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCertificatesRequest, ListCertificatesResponse, ListCertificatesPagedResponse>() {
            @Override
            public ApiFuture<ListCertificatesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCertificatesRequest, ListCertificatesResponse> callable,
                ListCertificatesRequest request,
                ApiCallContext context,
                ApiFuture<ListCertificatesResponse> futureResponse) {
              PageContext<ListCertificatesRequest, ListCertificatesResponse, Certificate>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CERTIFICATES_PAGE_STR_DESC, request, context);
              return ListCertificatesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListCertificateAuthoritiesRequest,
          ListCertificateAuthoritiesResponse,
          ListCertificateAuthoritiesPagedResponse>
      LIST_CERTIFICATE_AUTHORITIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCertificateAuthoritiesRequest,
              ListCertificateAuthoritiesResponse,
              ListCertificateAuthoritiesPagedResponse>() {
            @Override
            public ApiFuture<ListCertificateAuthoritiesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCertificateAuthoritiesRequest, ListCertificateAuthoritiesResponse>
                    callable,
                ListCertificateAuthoritiesRequest request,
                ApiCallContext context,
                ApiFuture<ListCertificateAuthoritiesResponse> futureResponse) {
              PageContext<
                      ListCertificateAuthoritiesRequest,
                      ListCertificateAuthoritiesResponse,
                      CertificateAuthority>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CERTIFICATE_AUTHORITIES_PAGE_STR_DESC, request, context);
              return ListCertificateAuthoritiesPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListCertificateRevocationListsRequest,
          ListCertificateRevocationListsResponse,
          ListCertificateRevocationListsPagedResponse>
      LIST_CERTIFICATE_REVOCATION_LISTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCertificateRevocationListsRequest,
              ListCertificateRevocationListsResponse,
              ListCertificateRevocationListsPagedResponse>() {
            @Override
            public ApiFuture<ListCertificateRevocationListsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListCertificateRevocationListsRequest,
                        ListCertificateRevocationListsResponse>
                    callable,
                ListCertificateRevocationListsRequest request,
                ApiCallContext context,
                ApiFuture<ListCertificateRevocationListsResponse> futureResponse) {
              PageContext<
                      ListCertificateRevocationListsRequest,
                      ListCertificateRevocationListsResponse,
                      CertificateRevocationList>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_CERTIFICATE_REVOCATION_LISTS_PAGE_STR_DESC,
                          request,
                          context);
              return ListCertificateRevocationListsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListReusableConfigsRequest, ListReusableConfigsResponse, ListReusableConfigsPagedResponse>
      LIST_REUSABLE_CONFIGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListReusableConfigsRequest,
              ListReusableConfigsResponse,
              ListReusableConfigsPagedResponse>() {
            @Override
            public ApiFuture<ListReusableConfigsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListReusableConfigsRequest, ListReusableConfigsResponse> callable,
                ListReusableConfigsRequest request,
                ApiCallContext context,
                ApiFuture<ListReusableConfigsResponse> futureResponse) {
              PageContext<ListReusableConfigsRequest, ListReusableConfigsResponse, ReusableConfig>
                  pageContext =
                      PageContext.create(
                          callable, LIST_REUSABLE_CONFIGS_PAGE_STR_DESC, request, context);
              return ListReusableConfigsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createCertificate. */
  public UnaryCallSettings<CreateCertificateRequest, Certificate> createCertificateSettings() {
    return createCertificateSettings;
  }

  /** Returns the object with the settings used for calls to getCertificate. */
  public UnaryCallSettings<GetCertificateRequest, Certificate> getCertificateSettings() {
    return getCertificateSettings;
  }

  /** Returns the object with the settings used for calls to listCertificates. */
  public PagedCallSettings<
          ListCertificatesRequest, ListCertificatesResponse, ListCertificatesPagedResponse>
      listCertificatesSettings() {
    return listCertificatesSettings;
  }

  /** Returns the object with the settings used for calls to revokeCertificate. */
  public UnaryCallSettings<RevokeCertificateRequest, Certificate> revokeCertificateSettings() {
    return revokeCertificateSettings;
  }

  /** Returns the object with the settings used for calls to updateCertificate. */
  public UnaryCallSettings<UpdateCertificateRequest, Certificate> updateCertificateSettings() {
    return updateCertificateSettings;
  }

  /** Returns the object with the settings used for calls to activateCertificateAuthority. */
  public UnaryCallSettings<ActivateCertificateAuthorityRequest, Operation>
      activateCertificateAuthoritySettings() {
    return activateCertificateAuthoritySettings;
  }

  /** Returns the object with the settings used for calls to activateCertificateAuthority. */
  public OperationCallSettings<
          ActivateCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      activateCertificateAuthorityOperationSettings() {
    return activateCertificateAuthorityOperationSettings;
  }

  /** Returns the object with the settings used for calls to createCertificateAuthority. */
  public UnaryCallSettings<CreateCertificateAuthorityRequest, Operation>
      createCertificateAuthoritySettings() {
    return createCertificateAuthoritySettings;
  }

  /** Returns the object with the settings used for calls to createCertificateAuthority. */
  public OperationCallSettings<
          CreateCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      createCertificateAuthorityOperationSettings() {
    return createCertificateAuthorityOperationSettings;
  }

  /** Returns the object with the settings used for calls to disableCertificateAuthority. */
  public UnaryCallSettings<DisableCertificateAuthorityRequest, Operation>
      disableCertificateAuthoritySettings() {
    return disableCertificateAuthoritySettings;
  }

  /** Returns the object with the settings used for calls to disableCertificateAuthority. */
  public OperationCallSettings<
          DisableCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      disableCertificateAuthorityOperationSettings() {
    return disableCertificateAuthorityOperationSettings;
  }

  /** Returns the object with the settings used for calls to enableCertificateAuthority. */
  public UnaryCallSettings<EnableCertificateAuthorityRequest, Operation>
      enableCertificateAuthoritySettings() {
    return enableCertificateAuthoritySettings;
  }

  /** Returns the object with the settings used for calls to enableCertificateAuthority. */
  public OperationCallSettings<
          EnableCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      enableCertificateAuthorityOperationSettings() {
    return enableCertificateAuthorityOperationSettings;
  }

  /** Returns the object with the settings used for calls to fetchCertificateAuthorityCsr. */
  public UnaryCallSettings<
          FetchCertificateAuthorityCsrRequest, FetchCertificateAuthorityCsrResponse>
      fetchCertificateAuthorityCsrSettings() {
    return fetchCertificateAuthorityCsrSettings;
  }

  /** Returns the object with the settings used for calls to getCertificateAuthority. */
  public UnaryCallSettings<GetCertificateAuthorityRequest, CertificateAuthority>
      getCertificateAuthoritySettings() {
    return getCertificateAuthoritySettings;
  }

  /** Returns the object with the settings used for calls to listCertificateAuthorities. */
  public PagedCallSettings<
          ListCertificateAuthoritiesRequest,
          ListCertificateAuthoritiesResponse,
          ListCertificateAuthoritiesPagedResponse>
      listCertificateAuthoritiesSettings() {
    return listCertificateAuthoritiesSettings;
  }

  /** Returns the object with the settings used for calls to restoreCertificateAuthority. */
  public UnaryCallSettings<RestoreCertificateAuthorityRequest, Operation>
      restoreCertificateAuthoritySettings() {
    return restoreCertificateAuthoritySettings;
  }

  /** Returns the object with the settings used for calls to restoreCertificateAuthority. */
  public OperationCallSettings<
          RestoreCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      restoreCertificateAuthorityOperationSettings() {
    return restoreCertificateAuthorityOperationSettings;
  }

  /** Returns the object with the settings used for calls to scheduleDeleteCertificateAuthority. */
  public UnaryCallSettings<ScheduleDeleteCertificateAuthorityRequest, Operation>
      scheduleDeleteCertificateAuthoritySettings() {
    return scheduleDeleteCertificateAuthoritySettings;
  }

  /** Returns the object with the settings used for calls to scheduleDeleteCertificateAuthority. */
  public OperationCallSettings<
          ScheduleDeleteCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      scheduleDeleteCertificateAuthorityOperationSettings() {
    return scheduleDeleteCertificateAuthorityOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateCertificateAuthority. */
  public UnaryCallSettings<UpdateCertificateAuthorityRequest, Operation>
      updateCertificateAuthoritySettings() {
    return updateCertificateAuthoritySettings;
  }

  /** Returns the object with the settings used for calls to updateCertificateAuthority. */
  public OperationCallSettings<
          UpdateCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      updateCertificateAuthorityOperationSettings() {
    return updateCertificateAuthorityOperationSettings;
  }

  /** Returns the object with the settings used for calls to getCertificateRevocationList. */
  public UnaryCallSettings<GetCertificateRevocationListRequest, CertificateRevocationList>
      getCertificateRevocationListSettings() {
    return getCertificateRevocationListSettings;
  }

  /** Returns the object with the settings used for calls to listCertificateRevocationLists. */
  public PagedCallSettings<
          ListCertificateRevocationListsRequest,
          ListCertificateRevocationListsResponse,
          ListCertificateRevocationListsPagedResponse>
      listCertificateRevocationListsSettings() {
    return listCertificateRevocationListsSettings;
  }

  /** Returns the object with the settings used for calls to updateCertificateRevocationList. */
  public UnaryCallSettings<UpdateCertificateRevocationListRequest, Operation>
      updateCertificateRevocationListSettings() {
    return updateCertificateRevocationListSettings;
  }

  /** Returns the object with the settings used for calls to updateCertificateRevocationList. */
  public OperationCallSettings<
          UpdateCertificateRevocationListRequest, CertificateRevocationList, OperationMetadata>
      updateCertificateRevocationListOperationSettings() {
    return updateCertificateRevocationListOperationSettings;
  }

  /** Returns the object with the settings used for calls to getReusableConfig. */
  public UnaryCallSettings<GetReusableConfigRequest, ReusableConfig> getReusableConfigSettings() {
    return getReusableConfigSettings;
  }

  /** Returns the object with the settings used for calls to listReusableConfigs. */
  public PagedCallSettings<
          ListReusableConfigsRequest, ListReusableConfigsResponse, ListReusableConfigsPagedResponse>
      listReusableConfigsSettings() {
    return listReusableConfigsSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public CertificateAuthorityServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcCertificateAuthorityServiceStub.create(this);
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
    return "privateca.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder().setScopesToApply(DEFAULT_SERVICE_SCOPES);
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(CertificateAuthorityServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected CertificateAuthorityServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createCertificateSettings = settingsBuilder.createCertificateSettings().build();
    getCertificateSettings = settingsBuilder.getCertificateSettings().build();
    listCertificatesSettings = settingsBuilder.listCertificatesSettings().build();
    revokeCertificateSettings = settingsBuilder.revokeCertificateSettings().build();
    updateCertificateSettings = settingsBuilder.updateCertificateSettings().build();
    activateCertificateAuthoritySettings =
        settingsBuilder.activateCertificateAuthoritySettings().build();
    activateCertificateAuthorityOperationSettings =
        settingsBuilder.activateCertificateAuthorityOperationSettings().build();
    createCertificateAuthoritySettings =
        settingsBuilder.createCertificateAuthoritySettings().build();
    createCertificateAuthorityOperationSettings =
        settingsBuilder.createCertificateAuthorityOperationSettings().build();
    disableCertificateAuthoritySettings =
        settingsBuilder.disableCertificateAuthoritySettings().build();
    disableCertificateAuthorityOperationSettings =
        settingsBuilder.disableCertificateAuthorityOperationSettings().build();
    enableCertificateAuthoritySettings =
        settingsBuilder.enableCertificateAuthoritySettings().build();
    enableCertificateAuthorityOperationSettings =
        settingsBuilder.enableCertificateAuthorityOperationSettings().build();
    fetchCertificateAuthorityCsrSettings =
        settingsBuilder.fetchCertificateAuthorityCsrSettings().build();
    getCertificateAuthoritySettings = settingsBuilder.getCertificateAuthoritySettings().build();
    listCertificateAuthoritiesSettings =
        settingsBuilder.listCertificateAuthoritiesSettings().build();
    restoreCertificateAuthoritySettings =
        settingsBuilder.restoreCertificateAuthoritySettings().build();
    restoreCertificateAuthorityOperationSettings =
        settingsBuilder.restoreCertificateAuthorityOperationSettings().build();
    scheduleDeleteCertificateAuthoritySettings =
        settingsBuilder.scheduleDeleteCertificateAuthoritySettings().build();
    scheduleDeleteCertificateAuthorityOperationSettings =
        settingsBuilder.scheduleDeleteCertificateAuthorityOperationSettings().build();
    updateCertificateAuthoritySettings =
        settingsBuilder.updateCertificateAuthoritySettings().build();
    updateCertificateAuthorityOperationSettings =
        settingsBuilder.updateCertificateAuthorityOperationSettings().build();
    getCertificateRevocationListSettings =
        settingsBuilder.getCertificateRevocationListSettings().build();
    listCertificateRevocationListsSettings =
        settingsBuilder.listCertificateRevocationListsSettings().build();
    updateCertificateRevocationListSettings =
        settingsBuilder.updateCertificateRevocationListSettings().build();
    updateCertificateRevocationListOperationSettings =
        settingsBuilder.updateCertificateRevocationListOperationSettings().build();
    getReusableConfigSettings = settingsBuilder.getReusableConfigSettings().build();
    listReusableConfigsSettings = settingsBuilder.listReusableConfigsSettings().build();
  }

  /** Builder for CertificateAuthorityServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<CertificateAuthorityServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateCertificateRequest, Certificate>
        createCertificateSettings;
    private final UnaryCallSettings.Builder<GetCertificateRequest, Certificate>
        getCertificateSettings;
    private final PagedCallSettings.Builder<
            ListCertificatesRequest, ListCertificatesResponse, ListCertificatesPagedResponse>
        listCertificatesSettings;
    private final UnaryCallSettings.Builder<RevokeCertificateRequest, Certificate>
        revokeCertificateSettings;
    private final UnaryCallSettings.Builder<UpdateCertificateRequest, Certificate>
        updateCertificateSettings;
    private final UnaryCallSettings.Builder<ActivateCertificateAuthorityRequest, Operation>
        activateCertificateAuthoritySettings;
    private final OperationCallSettings.Builder<
            ActivateCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
        activateCertificateAuthorityOperationSettings;
    private final UnaryCallSettings.Builder<CreateCertificateAuthorityRequest, Operation>
        createCertificateAuthoritySettings;
    private final OperationCallSettings.Builder<
            CreateCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
        createCertificateAuthorityOperationSettings;
    private final UnaryCallSettings.Builder<DisableCertificateAuthorityRequest, Operation>
        disableCertificateAuthoritySettings;
    private final OperationCallSettings.Builder<
            DisableCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
        disableCertificateAuthorityOperationSettings;
    private final UnaryCallSettings.Builder<EnableCertificateAuthorityRequest, Operation>
        enableCertificateAuthoritySettings;
    private final OperationCallSettings.Builder<
            EnableCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
        enableCertificateAuthorityOperationSettings;
    private final UnaryCallSettings.Builder<
            FetchCertificateAuthorityCsrRequest, FetchCertificateAuthorityCsrResponse>
        fetchCertificateAuthorityCsrSettings;
    private final UnaryCallSettings.Builder<GetCertificateAuthorityRequest, CertificateAuthority>
        getCertificateAuthoritySettings;
    private final PagedCallSettings.Builder<
            ListCertificateAuthoritiesRequest,
            ListCertificateAuthoritiesResponse,
            ListCertificateAuthoritiesPagedResponse>
        listCertificateAuthoritiesSettings;
    private final UnaryCallSettings.Builder<RestoreCertificateAuthorityRequest, Operation>
        restoreCertificateAuthoritySettings;
    private final OperationCallSettings.Builder<
            RestoreCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
        restoreCertificateAuthorityOperationSettings;
    private final UnaryCallSettings.Builder<ScheduleDeleteCertificateAuthorityRequest, Operation>
        scheduleDeleteCertificateAuthoritySettings;
    private final OperationCallSettings.Builder<
            ScheduleDeleteCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
        scheduleDeleteCertificateAuthorityOperationSettings;
    private final UnaryCallSettings.Builder<UpdateCertificateAuthorityRequest, Operation>
        updateCertificateAuthoritySettings;
    private final OperationCallSettings.Builder<
            UpdateCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
        updateCertificateAuthorityOperationSettings;
    private final UnaryCallSettings.Builder<
            GetCertificateRevocationListRequest, CertificateRevocationList>
        getCertificateRevocationListSettings;
    private final PagedCallSettings.Builder<
            ListCertificateRevocationListsRequest,
            ListCertificateRevocationListsResponse,
            ListCertificateRevocationListsPagedResponse>
        listCertificateRevocationListsSettings;
    private final UnaryCallSettings.Builder<UpdateCertificateRevocationListRequest, Operation>
        updateCertificateRevocationListSettings;
    private final OperationCallSettings.Builder<
            UpdateCertificateRevocationListRequest, CertificateRevocationList, OperationMetadata>
        updateCertificateRevocationListOperationSettings;
    private final UnaryCallSettings.Builder<GetReusableConfigRequest, ReusableConfig>
        getReusableConfigSettings;
    private final PagedCallSettings.Builder<
            ListReusableConfigsRequest,
            ListReusableConfigsResponse,
            ListReusableConfigsPagedResponse>
        listReusableConfigsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNKNOWN,
                  StatusCode.Code.UNAVAILABLE,
                  StatusCode.Code.DEADLINE_EXCEEDED)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createCertificateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getCertificateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listCertificatesSettings = PagedCallSettings.newBuilder(LIST_CERTIFICATES_PAGE_STR_FACT);
      revokeCertificateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateCertificateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      activateCertificateAuthoritySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      activateCertificateAuthorityOperationSettings = OperationCallSettings.newBuilder();
      createCertificateAuthoritySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCertificateAuthorityOperationSettings = OperationCallSettings.newBuilder();
      disableCertificateAuthoritySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      disableCertificateAuthorityOperationSettings = OperationCallSettings.newBuilder();
      enableCertificateAuthoritySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      enableCertificateAuthorityOperationSettings = OperationCallSettings.newBuilder();
      fetchCertificateAuthorityCsrSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getCertificateAuthoritySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listCertificateAuthoritiesSettings =
          PagedCallSettings.newBuilder(LIST_CERTIFICATE_AUTHORITIES_PAGE_STR_FACT);
      restoreCertificateAuthoritySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      restoreCertificateAuthorityOperationSettings = OperationCallSettings.newBuilder();
      scheduleDeleteCertificateAuthoritySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      scheduleDeleteCertificateAuthorityOperationSettings = OperationCallSettings.newBuilder();
      updateCertificateAuthoritySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateCertificateAuthorityOperationSettings = OperationCallSettings.newBuilder();
      getCertificateRevocationListSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listCertificateRevocationListsSettings =
          PagedCallSettings.newBuilder(LIST_CERTIFICATE_REVOCATION_LISTS_PAGE_STR_FACT);
      updateCertificateRevocationListSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateCertificateRevocationListOperationSettings = OperationCallSettings.newBuilder();
      getReusableConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listReusableConfigsSettings =
          PagedCallSettings.newBuilder(LIST_REUSABLE_CONFIGS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createCertificateSettings,
              getCertificateSettings,
              listCertificatesSettings,
              revokeCertificateSettings,
              updateCertificateSettings,
              activateCertificateAuthoritySettings,
              createCertificateAuthoritySettings,
              disableCertificateAuthoritySettings,
              enableCertificateAuthoritySettings,
              fetchCertificateAuthorityCsrSettings,
              getCertificateAuthoritySettings,
              listCertificateAuthoritiesSettings,
              restoreCertificateAuthoritySettings,
              scheduleDeleteCertificateAuthoritySettings,
              updateCertificateAuthoritySettings,
              getCertificateRevocationListSettings,
              listCertificateRevocationListsSettings,
              updateCertificateRevocationListSettings,
              getReusableConfigSettings,
              listReusableConfigsSettings);
      initDefaults(this);
    }

    protected Builder(CertificateAuthorityServiceStubSettings settings) {
      super(settings);

      createCertificateSettings = settings.createCertificateSettings.toBuilder();
      getCertificateSettings = settings.getCertificateSettings.toBuilder();
      listCertificatesSettings = settings.listCertificatesSettings.toBuilder();
      revokeCertificateSettings = settings.revokeCertificateSettings.toBuilder();
      updateCertificateSettings = settings.updateCertificateSettings.toBuilder();
      activateCertificateAuthoritySettings =
          settings.activateCertificateAuthoritySettings.toBuilder();
      activateCertificateAuthorityOperationSettings =
          settings.activateCertificateAuthorityOperationSettings.toBuilder();
      createCertificateAuthoritySettings = settings.createCertificateAuthoritySettings.toBuilder();
      createCertificateAuthorityOperationSettings =
          settings.createCertificateAuthorityOperationSettings.toBuilder();
      disableCertificateAuthoritySettings =
          settings.disableCertificateAuthoritySettings.toBuilder();
      disableCertificateAuthorityOperationSettings =
          settings.disableCertificateAuthorityOperationSettings.toBuilder();
      enableCertificateAuthoritySettings = settings.enableCertificateAuthoritySettings.toBuilder();
      enableCertificateAuthorityOperationSettings =
          settings.enableCertificateAuthorityOperationSettings.toBuilder();
      fetchCertificateAuthorityCsrSettings =
          settings.fetchCertificateAuthorityCsrSettings.toBuilder();
      getCertificateAuthoritySettings = settings.getCertificateAuthoritySettings.toBuilder();
      listCertificateAuthoritiesSettings = settings.listCertificateAuthoritiesSettings.toBuilder();
      restoreCertificateAuthoritySettings =
          settings.restoreCertificateAuthoritySettings.toBuilder();
      restoreCertificateAuthorityOperationSettings =
          settings.restoreCertificateAuthorityOperationSettings.toBuilder();
      scheduleDeleteCertificateAuthoritySettings =
          settings.scheduleDeleteCertificateAuthoritySettings.toBuilder();
      scheduleDeleteCertificateAuthorityOperationSettings =
          settings.scheduleDeleteCertificateAuthorityOperationSettings.toBuilder();
      updateCertificateAuthoritySettings = settings.updateCertificateAuthoritySettings.toBuilder();
      updateCertificateAuthorityOperationSettings =
          settings.updateCertificateAuthorityOperationSettings.toBuilder();
      getCertificateRevocationListSettings =
          settings.getCertificateRevocationListSettings.toBuilder();
      listCertificateRevocationListsSettings =
          settings.listCertificateRevocationListsSettings.toBuilder();
      updateCertificateRevocationListSettings =
          settings.updateCertificateRevocationListSettings.toBuilder();
      updateCertificateRevocationListOperationSettings =
          settings.updateCertificateRevocationListOperationSettings.toBuilder();
      getReusableConfigSettings = settings.getReusableConfigSettings.toBuilder();
      listReusableConfigsSettings = settings.listReusableConfigsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createCertificateSettings,
              getCertificateSettings,
              listCertificatesSettings,
              revokeCertificateSettings,
              updateCertificateSettings,
              activateCertificateAuthoritySettings,
              createCertificateAuthoritySettings,
              disableCertificateAuthoritySettings,
              enableCertificateAuthoritySettings,
              fetchCertificateAuthorityCsrSettings,
              getCertificateAuthoritySettings,
              listCertificateAuthoritiesSettings,
              restoreCertificateAuthoritySettings,
              scheduleDeleteCertificateAuthoritySettings,
              updateCertificateAuthoritySettings,
              getCertificateRevocationListSettings,
              listCertificateRevocationListsSettings,
              updateCertificateRevocationListSettings,
              getReusableConfigSettings,
              listReusableConfigsSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .createCertificateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getCertificateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listCertificatesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .revokeCertificateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateCertificateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .activateCertificateAuthoritySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createCertificateAuthoritySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .disableCertificateAuthoritySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .enableCertificateAuthoritySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .fetchCertificateAuthorityCsrSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getCertificateAuthoritySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listCertificateAuthoritiesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .restoreCertificateAuthoritySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .scheduleDeleteCertificateAuthoritySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateCertificateAuthoritySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getCertificateRevocationListSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listCertificateRevocationListsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateCertificateRevocationListSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getReusableConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listReusableConfigsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .activateCertificateAuthorityOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ActivateCertificateAuthorityRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(CertificateAuthority.class))
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
          .createCertificateAuthorityOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateCertificateAuthorityRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(CertificateAuthority.class))
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
          .disableCertificateAuthorityOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DisableCertificateAuthorityRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(CertificateAuthority.class))
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
          .enableCertificateAuthorityOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<EnableCertificateAuthorityRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(CertificateAuthority.class))
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
          .restoreCertificateAuthorityOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RestoreCertificateAuthorityRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(CertificateAuthority.class))
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
          .scheduleDeleteCertificateAuthorityOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ScheduleDeleteCertificateAuthorityRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(CertificateAuthority.class))
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
          .updateCertificateAuthorityOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateCertificateAuthorityRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(CertificateAuthority.class))
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
          .updateCertificateRevocationListOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateCertificateRevocationListRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  CertificateRevocationList.class))
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

      return builder;
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to createCertificate. */
    public UnaryCallSettings.Builder<CreateCertificateRequest, Certificate>
        createCertificateSettings() {
      return createCertificateSettings;
    }

    /** Returns the builder for the settings used for calls to getCertificate. */
    public UnaryCallSettings.Builder<GetCertificateRequest, Certificate> getCertificateSettings() {
      return getCertificateSettings;
    }

    /** Returns the builder for the settings used for calls to listCertificates. */
    public PagedCallSettings.Builder<
            ListCertificatesRequest, ListCertificatesResponse, ListCertificatesPagedResponse>
        listCertificatesSettings() {
      return listCertificatesSettings;
    }

    /** Returns the builder for the settings used for calls to revokeCertificate. */
    public UnaryCallSettings.Builder<RevokeCertificateRequest, Certificate>
        revokeCertificateSettings() {
      return revokeCertificateSettings;
    }

    /** Returns the builder for the settings used for calls to updateCertificate. */
    public UnaryCallSettings.Builder<UpdateCertificateRequest, Certificate>
        updateCertificateSettings() {
      return updateCertificateSettings;
    }

    /** Returns the builder for the settings used for calls to activateCertificateAuthority. */
    public UnaryCallSettings.Builder<ActivateCertificateAuthorityRequest, Operation>
        activateCertificateAuthoritySettings() {
      return activateCertificateAuthoritySettings;
    }

    /** Returns the builder for the settings used for calls to activateCertificateAuthority. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            ActivateCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
        activateCertificateAuthorityOperationSettings() {
      return activateCertificateAuthorityOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createCertificateAuthority. */
    public UnaryCallSettings.Builder<CreateCertificateAuthorityRequest, Operation>
        createCertificateAuthoritySettings() {
      return createCertificateAuthoritySettings;
    }

    /** Returns the builder for the settings used for calls to createCertificateAuthority. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
        createCertificateAuthorityOperationSettings() {
      return createCertificateAuthorityOperationSettings;
    }

    /** Returns the builder for the settings used for calls to disableCertificateAuthority. */
    public UnaryCallSettings.Builder<DisableCertificateAuthorityRequest, Operation>
        disableCertificateAuthoritySettings() {
      return disableCertificateAuthoritySettings;
    }

    /** Returns the builder for the settings used for calls to disableCertificateAuthority. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            DisableCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
        disableCertificateAuthorityOperationSettings() {
      return disableCertificateAuthorityOperationSettings;
    }

    /** Returns the builder for the settings used for calls to enableCertificateAuthority. */
    public UnaryCallSettings.Builder<EnableCertificateAuthorityRequest, Operation>
        enableCertificateAuthoritySettings() {
      return enableCertificateAuthoritySettings;
    }

    /** Returns the builder for the settings used for calls to enableCertificateAuthority. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            EnableCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
        enableCertificateAuthorityOperationSettings() {
      return enableCertificateAuthorityOperationSettings;
    }

    /** Returns the builder for the settings used for calls to fetchCertificateAuthorityCsr. */
    public UnaryCallSettings.Builder<
            FetchCertificateAuthorityCsrRequest, FetchCertificateAuthorityCsrResponse>
        fetchCertificateAuthorityCsrSettings() {
      return fetchCertificateAuthorityCsrSettings;
    }

    /** Returns the builder for the settings used for calls to getCertificateAuthority. */
    public UnaryCallSettings.Builder<GetCertificateAuthorityRequest, CertificateAuthority>
        getCertificateAuthoritySettings() {
      return getCertificateAuthoritySettings;
    }

    /** Returns the builder for the settings used for calls to listCertificateAuthorities. */
    public PagedCallSettings.Builder<
            ListCertificateAuthoritiesRequest,
            ListCertificateAuthoritiesResponse,
            ListCertificateAuthoritiesPagedResponse>
        listCertificateAuthoritiesSettings() {
      return listCertificateAuthoritiesSettings;
    }

    /** Returns the builder for the settings used for calls to restoreCertificateAuthority. */
    public UnaryCallSettings.Builder<RestoreCertificateAuthorityRequest, Operation>
        restoreCertificateAuthoritySettings() {
      return restoreCertificateAuthoritySettings;
    }

    /** Returns the builder for the settings used for calls to restoreCertificateAuthority. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            RestoreCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
        restoreCertificateAuthorityOperationSettings() {
      return restoreCertificateAuthorityOperationSettings;
    }

    /**
     * Returns the builder for the settings used for calls to scheduleDeleteCertificateAuthority.
     */
    public UnaryCallSettings.Builder<ScheduleDeleteCertificateAuthorityRequest, Operation>
        scheduleDeleteCertificateAuthoritySettings() {
      return scheduleDeleteCertificateAuthoritySettings;
    }

    /**
     * Returns the builder for the settings used for calls to scheduleDeleteCertificateAuthority.
     */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            ScheduleDeleteCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
        scheduleDeleteCertificateAuthorityOperationSettings() {
      return scheduleDeleteCertificateAuthorityOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateCertificateAuthority. */
    public UnaryCallSettings.Builder<UpdateCertificateAuthorityRequest, Operation>
        updateCertificateAuthoritySettings() {
      return updateCertificateAuthoritySettings;
    }

    /** Returns the builder for the settings used for calls to updateCertificateAuthority. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            UpdateCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
        updateCertificateAuthorityOperationSettings() {
      return updateCertificateAuthorityOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getCertificateRevocationList. */
    public UnaryCallSettings.Builder<GetCertificateRevocationListRequest, CertificateRevocationList>
        getCertificateRevocationListSettings() {
      return getCertificateRevocationListSettings;
    }

    /** Returns the builder for the settings used for calls to listCertificateRevocationLists. */
    public PagedCallSettings.Builder<
            ListCertificateRevocationListsRequest,
            ListCertificateRevocationListsResponse,
            ListCertificateRevocationListsPagedResponse>
        listCertificateRevocationListsSettings() {
      return listCertificateRevocationListsSettings;
    }

    /** Returns the builder for the settings used for calls to updateCertificateRevocationList. */
    public UnaryCallSettings.Builder<UpdateCertificateRevocationListRequest, Operation>
        updateCertificateRevocationListSettings() {
      return updateCertificateRevocationListSettings;
    }

    /** Returns the builder for the settings used for calls to updateCertificateRevocationList. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            UpdateCertificateRevocationListRequest, CertificateRevocationList, OperationMetadata>
        updateCertificateRevocationListOperationSettings() {
      return updateCertificateRevocationListOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getReusableConfig. */
    public UnaryCallSettings.Builder<GetReusableConfigRequest, ReusableConfig>
        getReusableConfigSettings() {
      return getReusableConfigSettings;
    }

    /** Returns the builder for the settings used for calls to listReusableConfigs. */
    public PagedCallSettings.Builder<
            ListReusableConfigsRequest,
            ListReusableConfigsResponse,
            ListReusableConfigsPagedResponse>
        listReusableConfigsSettings() {
      return listReusableConfigsSettings;
    }

    @Override
    public CertificateAuthorityServiceStubSettings build() throws IOException {
      return new CertificateAuthorityServiceStubSettings(this);
    }
  }
}
