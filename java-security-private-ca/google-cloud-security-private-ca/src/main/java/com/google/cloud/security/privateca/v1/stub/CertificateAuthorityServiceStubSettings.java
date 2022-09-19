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

package com.google.cloud.security.privateca.v1.stub;

import static com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient.ListCaPoolsPagedResponse;
import static com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient.ListCertificateAuthoritiesPagedResponse;
import static com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient.ListCertificateRevocationListsPagedResponse;
import static com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient.ListCertificateTemplatesPagedResponse;
import static com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient.ListCertificatesPagedResponse;
import static com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.security.privateca.v1.ActivateCertificateAuthorityRequest;
import com.google.cloud.security.privateca.v1.CaPool;
import com.google.cloud.security.privateca.v1.Certificate;
import com.google.cloud.security.privateca.v1.CertificateAuthority;
import com.google.cloud.security.privateca.v1.CertificateRevocationList;
import com.google.cloud.security.privateca.v1.CertificateTemplate;
import com.google.cloud.security.privateca.v1.CreateCaPoolRequest;
import com.google.cloud.security.privateca.v1.CreateCertificateAuthorityRequest;
import com.google.cloud.security.privateca.v1.CreateCertificateRequest;
import com.google.cloud.security.privateca.v1.CreateCertificateTemplateRequest;
import com.google.cloud.security.privateca.v1.DeleteCaPoolRequest;
import com.google.cloud.security.privateca.v1.DeleteCertificateAuthorityRequest;
import com.google.cloud.security.privateca.v1.DeleteCertificateTemplateRequest;
import com.google.cloud.security.privateca.v1.DisableCertificateAuthorityRequest;
import com.google.cloud.security.privateca.v1.EnableCertificateAuthorityRequest;
import com.google.cloud.security.privateca.v1.FetchCaCertsRequest;
import com.google.cloud.security.privateca.v1.FetchCaCertsResponse;
import com.google.cloud.security.privateca.v1.FetchCertificateAuthorityCsrRequest;
import com.google.cloud.security.privateca.v1.FetchCertificateAuthorityCsrResponse;
import com.google.cloud.security.privateca.v1.GetCaPoolRequest;
import com.google.cloud.security.privateca.v1.GetCertificateAuthorityRequest;
import com.google.cloud.security.privateca.v1.GetCertificateRequest;
import com.google.cloud.security.privateca.v1.GetCertificateRevocationListRequest;
import com.google.cloud.security.privateca.v1.GetCertificateTemplateRequest;
import com.google.cloud.security.privateca.v1.ListCaPoolsRequest;
import com.google.cloud.security.privateca.v1.ListCaPoolsResponse;
import com.google.cloud.security.privateca.v1.ListCertificateAuthoritiesRequest;
import com.google.cloud.security.privateca.v1.ListCertificateAuthoritiesResponse;
import com.google.cloud.security.privateca.v1.ListCertificateRevocationListsRequest;
import com.google.cloud.security.privateca.v1.ListCertificateRevocationListsResponse;
import com.google.cloud.security.privateca.v1.ListCertificateTemplatesRequest;
import com.google.cloud.security.privateca.v1.ListCertificateTemplatesResponse;
import com.google.cloud.security.privateca.v1.ListCertificatesRequest;
import com.google.cloud.security.privateca.v1.ListCertificatesResponse;
import com.google.cloud.security.privateca.v1.OperationMetadata;
import com.google.cloud.security.privateca.v1.RevokeCertificateRequest;
import com.google.cloud.security.privateca.v1.UndeleteCertificateAuthorityRequest;
import com.google.cloud.security.privateca.v1.UpdateCaPoolRequest;
import com.google.cloud.security.privateca.v1.UpdateCertificateAuthorityRequest;
import com.google.cloud.security.privateca.v1.UpdateCertificateRequest;
import com.google.cloud.security.privateca.v1.UpdateCertificateRevocationListRequest;
import com.google.cloud.security.privateca.v1.UpdateCertificateTemplateRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
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
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
  private final UnaryCallSettings<UndeleteCertificateAuthorityRequest, Operation>
      undeleteCertificateAuthoritySettings;
  private final OperationCallSettings<
          UndeleteCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      undeleteCertificateAuthorityOperationSettings;
  private final UnaryCallSettings<DeleteCertificateAuthorityRequest, Operation>
      deleteCertificateAuthoritySettings;
  private final OperationCallSettings<
          DeleteCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      deleteCertificateAuthorityOperationSettings;
  private final UnaryCallSettings<UpdateCertificateAuthorityRequest, Operation>
      updateCertificateAuthoritySettings;
  private final OperationCallSettings<
          UpdateCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      updateCertificateAuthorityOperationSettings;
  private final UnaryCallSettings<CreateCaPoolRequest, Operation> createCaPoolSettings;
  private final OperationCallSettings<CreateCaPoolRequest, CaPool, OperationMetadata>
      createCaPoolOperationSettings;
  private final UnaryCallSettings<UpdateCaPoolRequest, Operation> updateCaPoolSettings;
  private final OperationCallSettings<UpdateCaPoolRequest, CaPool, OperationMetadata>
      updateCaPoolOperationSettings;
  private final UnaryCallSettings<GetCaPoolRequest, CaPool> getCaPoolSettings;
  private final PagedCallSettings<ListCaPoolsRequest, ListCaPoolsResponse, ListCaPoolsPagedResponse>
      listCaPoolsSettings;
  private final UnaryCallSettings<DeleteCaPoolRequest, Operation> deleteCaPoolSettings;
  private final OperationCallSettings<DeleteCaPoolRequest, Empty, OperationMetadata>
      deleteCaPoolOperationSettings;
  private final UnaryCallSettings<FetchCaCertsRequest, FetchCaCertsResponse> fetchCaCertsSettings;
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
  private final UnaryCallSettings<CreateCertificateTemplateRequest, Operation>
      createCertificateTemplateSettings;
  private final OperationCallSettings<
          CreateCertificateTemplateRequest, CertificateTemplate, OperationMetadata>
      createCertificateTemplateOperationSettings;
  private final UnaryCallSettings<DeleteCertificateTemplateRequest, Operation>
      deleteCertificateTemplateSettings;
  private final OperationCallSettings<DeleteCertificateTemplateRequest, Empty, OperationMetadata>
      deleteCertificateTemplateOperationSettings;
  private final UnaryCallSettings<GetCertificateTemplateRequest, CertificateTemplate>
      getCertificateTemplateSettings;
  private final PagedCallSettings<
          ListCertificateTemplatesRequest,
          ListCertificateTemplatesResponse,
          ListCertificateTemplatesPagedResponse>
      listCertificateTemplatesSettings;
  private final UnaryCallSettings<UpdateCertificateTemplateRequest, Operation>
      updateCertificateTemplateSettings;
  private final OperationCallSettings<
          UpdateCertificateTemplateRequest, CertificateTemplate, OperationMetadata>
      updateCertificateTemplateOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

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

  private static final PagedListDescriptor<ListCaPoolsRequest, ListCaPoolsResponse, CaPool>
      LIST_CA_POOLS_PAGE_STR_DESC =
          new PagedListDescriptor<ListCaPoolsRequest, ListCaPoolsResponse, CaPool>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCaPoolsRequest injectToken(ListCaPoolsRequest payload, String token) {
              return ListCaPoolsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListCaPoolsRequest injectPageSize(ListCaPoolsRequest payload, int pageSize) {
              return ListCaPoolsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListCaPoolsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCaPoolsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<CaPool> extractResources(ListCaPoolsResponse payload) {
              return payload.getCaPoolsList() == null
                  ? ImmutableList.<CaPool>of()
                  : payload.getCaPoolsList();
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
          ListCertificateTemplatesRequest, ListCertificateTemplatesResponse, CertificateTemplate>
      LIST_CERTIFICATE_TEMPLATES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListCertificateTemplatesRequest,
              ListCertificateTemplatesResponse,
              CertificateTemplate>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCertificateTemplatesRequest injectToken(
                ListCertificateTemplatesRequest payload, String token) {
              return ListCertificateTemplatesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListCertificateTemplatesRequest injectPageSize(
                ListCertificateTemplatesRequest payload, int pageSize) {
              return ListCertificateTemplatesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListCertificateTemplatesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCertificateTemplatesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<CertificateTemplate> extractResources(
                ListCertificateTemplatesResponse payload) {
              return payload.getCertificateTemplatesList() == null
                  ? ImmutableList.<CertificateTemplate>of()
                  : payload.getCertificateTemplatesList();
            }
          };

  private static final PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>
      LIST_LOCATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLocationsRequest injectToken(ListLocationsRequest payload, String token) {
              return ListLocationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLocationsRequest injectPageSize(ListLocationsRequest payload, int pageSize) {
              return ListLocationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLocationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLocationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Location> extractResources(ListLocationsResponse payload) {
              return payload.getLocationsList() == null
                  ? ImmutableList.<Location>of()
                  : payload.getLocationsList();
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
          ListCaPoolsRequest, ListCaPoolsResponse, ListCaPoolsPagedResponse>
      LIST_CA_POOLS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCaPoolsRequest, ListCaPoolsResponse, ListCaPoolsPagedResponse>() {
            @Override
            public ApiFuture<ListCaPoolsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCaPoolsRequest, ListCaPoolsResponse> callable,
                ListCaPoolsRequest request,
                ApiCallContext context,
                ApiFuture<ListCaPoolsResponse> futureResponse) {
              PageContext<ListCaPoolsRequest, ListCaPoolsResponse, CaPool> pageContext =
                  PageContext.create(callable, LIST_CA_POOLS_PAGE_STR_DESC, request, context);
              return ListCaPoolsPagedResponse.createAsync(pageContext, futureResponse);
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
          ListCertificateTemplatesRequest,
          ListCertificateTemplatesResponse,
          ListCertificateTemplatesPagedResponse>
      LIST_CERTIFICATE_TEMPLATES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCertificateTemplatesRequest,
              ListCertificateTemplatesResponse,
              ListCertificateTemplatesPagedResponse>() {
            @Override
            public ApiFuture<ListCertificateTemplatesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCertificateTemplatesRequest, ListCertificateTemplatesResponse>
                    callable,
                ListCertificateTemplatesRequest request,
                ApiCallContext context,
                ApiFuture<ListCertificateTemplatesResponse> futureResponse) {
              PageContext<
                      ListCertificateTemplatesRequest,
                      ListCertificateTemplatesResponse,
                      CertificateTemplate>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CERTIFICATE_TEMPLATES_PAGE_STR_DESC, request, context);
              return ListCertificateTemplatesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      LIST_LOCATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>() {
            @Override
            public ApiFuture<ListLocationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLocationsRequest, ListLocationsResponse> callable,
                ListLocationsRequest request,
                ApiCallContext context,
                ApiFuture<ListLocationsResponse> futureResponse) {
              PageContext<ListLocationsRequest, ListLocationsResponse, Location> pageContext =
                  PageContext.create(callable, LIST_LOCATIONS_PAGE_STR_DESC, request, context);
              return ListLocationsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to undeleteCertificateAuthority. */
  public UnaryCallSettings<UndeleteCertificateAuthorityRequest, Operation>
      undeleteCertificateAuthoritySettings() {
    return undeleteCertificateAuthoritySettings;
  }

  /** Returns the object with the settings used for calls to undeleteCertificateAuthority. */
  public OperationCallSettings<
          UndeleteCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      undeleteCertificateAuthorityOperationSettings() {
    return undeleteCertificateAuthorityOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteCertificateAuthority. */
  public UnaryCallSettings<DeleteCertificateAuthorityRequest, Operation>
      deleteCertificateAuthoritySettings() {
    return deleteCertificateAuthoritySettings;
  }

  /** Returns the object with the settings used for calls to deleteCertificateAuthority. */
  public OperationCallSettings<
          DeleteCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      deleteCertificateAuthorityOperationSettings() {
    return deleteCertificateAuthorityOperationSettings;
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

  /** Returns the object with the settings used for calls to createCaPool. */
  public UnaryCallSettings<CreateCaPoolRequest, Operation> createCaPoolSettings() {
    return createCaPoolSettings;
  }

  /** Returns the object with the settings used for calls to createCaPool. */
  public OperationCallSettings<CreateCaPoolRequest, CaPool, OperationMetadata>
      createCaPoolOperationSettings() {
    return createCaPoolOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateCaPool. */
  public UnaryCallSettings<UpdateCaPoolRequest, Operation> updateCaPoolSettings() {
    return updateCaPoolSettings;
  }

  /** Returns the object with the settings used for calls to updateCaPool. */
  public OperationCallSettings<UpdateCaPoolRequest, CaPool, OperationMetadata>
      updateCaPoolOperationSettings() {
    return updateCaPoolOperationSettings;
  }

  /** Returns the object with the settings used for calls to getCaPool. */
  public UnaryCallSettings<GetCaPoolRequest, CaPool> getCaPoolSettings() {
    return getCaPoolSettings;
  }

  /** Returns the object with the settings used for calls to listCaPools. */
  public PagedCallSettings<ListCaPoolsRequest, ListCaPoolsResponse, ListCaPoolsPagedResponse>
      listCaPoolsSettings() {
    return listCaPoolsSettings;
  }

  /** Returns the object with the settings used for calls to deleteCaPool. */
  public UnaryCallSettings<DeleteCaPoolRequest, Operation> deleteCaPoolSettings() {
    return deleteCaPoolSettings;
  }

  /** Returns the object with the settings used for calls to deleteCaPool. */
  public OperationCallSettings<DeleteCaPoolRequest, Empty, OperationMetadata>
      deleteCaPoolOperationSettings() {
    return deleteCaPoolOperationSettings;
  }

  /** Returns the object with the settings used for calls to fetchCaCerts. */
  public UnaryCallSettings<FetchCaCertsRequest, FetchCaCertsResponse> fetchCaCertsSettings() {
    return fetchCaCertsSettings;
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

  /** Returns the object with the settings used for calls to createCertificateTemplate. */
  public UnaryCallSettings<CreateCertificateTemplateRequest, Operation>
      createCertificateTemplateSettings() {
    return createCertificateTemplateSettings;
  }

  /** Returns the object with the settings used for calls to createCertificateTemplate. */
  public OperationCallSettings<
          CreateCertificateTemplateRequest, CertificateTemplate, OperationMetadata>
      createCertificateTemplateOperationSettings() {
    return createCertificateTemplateOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteCertificateTemplate. */
  public UnaryCallSettings<DeleteCertificateTemplateRequest, Operation>
      deleteCertificateTemplateSettings() {
    return deleteCertificateTemplateSettings;
  }

  /** Returns the object with the settings used for calls to deleteCertificateTemplate. */
  public OperationCallSettings<DeleteCertificateTemplateRequest, Empty, OperationMetadata>
      deleteCertificateTemplateOperationSettings() {
    return deleteCertificateTemplateOperationSettings;
  }

  /** Returns the object with the settings used for calls to getCertificateTemplate. */
  public UnaryCallSettings<GetCertificateTemplateRequest, CertificateTemplate>
      getCertificateTemplateSettings() {
    return getCertificateTemplateSettings;
  }

  /** Returns the object with the settings used for calls to listCertificateTemplates. */
  public PagedCallSettings<
          ListCertificateTemplatesRequest,
          ListCertificateTemplatesResponse,
          ListCertificateTemplatesPagedResponse>
      listCertificateTemplatesSettings() {
    return listCertificateTemplatesSettings;
  }

  /** Returns the object with the settings used for calls to updateCertificateTemplate. */
  public UnaryCallSettings<UpdateCertificateTemplateRequest, Operation>
      updateCertificateTemplateSettings() {
    return updateCertificateTemplateSettings;
  }

  /** Returns the object with the settings used for calls to updateCertificateTemplate. */
  public OperationCallSettings<
          UpdateCertificateTemplateRequest, CertificateTemplate, OperationMetadata>
      updateCertificateTemplateOperationSettings() {
    return updateCertificateTemplateOperationSettings;
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return listLocationsSettings;
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return getLocationSettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  public CertificateAuthorityServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcCertificateAuthorityServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonCertificateAuthorityServiceStub.create(this);
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

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "privateca.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(CertificateAuthorityServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(CertificateAuthorityServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CertificateAuthorityServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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
    undeleteCertificateAuthoritySettings =
        settingsBuilder.undeleteCertificateAuthoritySettings().build();
    undeleteCertificateAuthorityOperationSettings =
        settingsBuilder.undeleteCertificateAuthorityOperationSettings().build();
    deleteCertificateAuthoritySettings =
        settingsBuilder.deleteCertificateAuthoritySettings().build();
    deleteCertificateAuthorityOperationSettings =
        settingsBuilder.deleteCertificateAuthorityOperationSettings().build();
    updateCertificateAuthoritySettings =
        settingsBuilder.updateCertificateAuthoritySettings().build();
    updateCertificateAuthorityOperationSettings =
        settingsBuilder.updateCertificateAuthorityOperationSettings().build();
    createCaPoolSettings = settingsBuilder.createCaPoolSettings().build();
    createCaPoolOperationSettings = settingsBuilder.createCaPoolOperationSettings().build();
    updateCaPoolSettings = settingsBuilder.updateCaPoolSettings().build();
    updateCaPoolOperationSettings = settingsBuilder.updateCaPoolOperationSettings().build();
    getCaPoolSettings = settingsBuilder.getCaPoolSettings().build();
    listCaPoolsSettings = settingsBuilder.listCaPoolsSettings().build();
    deleteCaPoolSettings = settingsBuilder.deleteCaPoolSettings().build();
    deleteCaPoolOperationSettings = settingsBuilder.deleteCaPoolOperationSettings().build();
    fetchCaCertsSettings = settingsBuilder.fetchCaCertsSettings().build();
    getCertificateRevocationListSettings =
        settingsBuilder.getCertificateRevocationListSettings().build();
    listCertificateRevocationListsSettings =
        settingsBuilder.listCertificateRevocationListsSettings().build();
    updateCertificateRevocationListSettings =
        settingsBuilder.updateCertificateRevocationListSettings().build();
    updateCertificateRevocationListOperationSettings =
        settingsBuilder.updateCertificateRevocationListOperationSettings().build();
    createCertificateTemplateSettings = settingsBuilder.createCertificateTemplateSettings().build();
    createCertificateTemplateOperationSettings =
        settingsBuilder.createCertificateTemplateOperationSettings().build();
    deleteCertificateTemplateSettings = settingsBuilder.deleteCertificateTemplateSettings().build();
    deleteCertificateTemplateOperationSettings =
        settingsBuilder.deleteCertificateTemplateOperationSettings().build();
    getCertificateTemplateSettings = settingsBuilder.getCertificateTemplateSettings().build();
    listCertificateTemplatesSettings = settingsBuilder.listCertificateTemplatesSettings().build();
    updateCertificateTemplateSettings = settingsBuilder.updateCertificateTemplateSettings().build();
    updateCertificateTemplateOperationSettings =
        settingsBuilder.updateCertificateTemplateOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
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
    private final UnaryCallSettings.Builder<UndeleteCertificateAuthorityRequest, Operation>
        undeleteCertificateAuthoritySettings;
    private final OperationCallSettings.Builder<
            UndeleteCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
        undeleteCertificateAuthorityOperationSettings;
    private final UnaryCallSettings.Builder<DeleteCertificateAuthorityRequest, Operation>
        deleteCertificateAuthoritySettings;
    private final OperationCallSettings.Builder<
            DeleteCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
        deleteCertificateAuthorityOperationSettings;
    private final UnaryCallSettings.Builder<UpdateCertificateAuthorityRequest, Operation>
        updateCertificateAuthoritySettings;
    private final OperationCallSettings.Builder<
            UpdateCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
        updateCertificateAuthorityOperationSettings;
    private final UnaryCallSettings.Builder<CreateCaPoolRequest, Operation> createCaPoolSettings;
    private final OperationCallSettings.Builder<CreateCaPoolRequest, CaPool, OperationMetadata>
        createCaPoolOperationSettings;
    private final UnaryCallSettings.Builder<UpdateCaPoolRequest, Operation> updateCaPoolSettings;
    private final OperationCallSettings.Builder<UpdateCaPoolRequest, CaPool, OperationMetadata>
        updateCaPoolOperationSettings;
    private final UnaryCallSettings.Builder<GetCaPoolRequest, CaPool> getCaPoolSettings;
    private final PagedCallSettings.Builder<
            ListCaPoolsRequest, ListCaPoolsResponse, ListCaPoolsPagedResponse>
        listCaPoolsSettings;
    private final UnaryCallSettings.Builder<DeleteCaPoolRequest, Operation> deleteCaPoolSettings;
    private final OperationCallSettings.Builder<DeleteCaPoolRequest, Empty, OperationMetadata>
        deleteCaPoolOperationSettings;
    private final UnaryCallSettings.Builder<FetchCaCertsRequest, FetchCaCertsResponse>
        fetchCaCertsSettings;
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
    private final UnaryCallSettings.Builder<CreateCertificateTemplateRequest, Operation>
        createCertificateTemplateSettings;
    private final OperationCallSettings.Builder<
            CreateCertificateTemplateRequest, CertificateTemplate, OperationMetadata>
        createCertificateTemplateOperationSettings;
    private final UnaryCallSettings.Builder<DeleteCertificateTemplateRequest, Operation>
        deleteCertificateTemplateSettings;
    private final OperationCallSettings.Builder<
            DeleteCertificateTemplateRequest, Empty, OperationMetadata>
        deleteCertificateTemplateOperationSettings;
    private final UnaryCallSettings.Builder<GetCertificateTemplateRequest, CertificateTemplate>
        getCertificateTemplateSettings;
    private final PagedCallSettings.Builder<
            ListCertificateTemplatesRequest,
            ListCertificateTemplatesResponse,
            ListCertificateTemplatesPagedResponse>
        listCertificateTemplatesSettings;
    private final UnaryCallSettings.Builder<UpdateCertificateTemplateRequest, Operation>
        updateCertificateTemplateSettings;
    private final OperationCallSettings.Builder<
            UpdateCertificateTemplateRequest, CertificateTemplate, OperationMetadata>
        updateCertificateTemplateOperationSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
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
      undeleteCertificateAuthoritySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      undeleteCertificateAuthorityOperationSettings = OperationCallSettings.newBuilder();
      deleteCertificateAuthoritySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteCertificateAuthorityOperationSettings = OperationCallSettings.newBuilder();
      updateCertificateAuthoritySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateCertificateAuthorityOperationSettings = OperationCallSettings.newBuilder();
      createCaPoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCaPoolOperationSettings = OperationCallSettings.newBuilder();
      updateCaPoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateCaPoolOperationSettings = OperationCallSettings.newBuilder();
      getCaPoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listCaPoolsSettings = PagedCallSettings.newBuilder(LIST_CA_POOLS_PAGE_STR_FACT);
      deleteCaPoolSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteCaPoolOperationSettings = OperationCallSettings.newBuilder();
      fetchCaCertsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getCertificateRevocationListSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listCertificateRevocationListsSettings =
          PagedCallSettings.newBuilder(LIST_CERTIFICATE_REVOCATION_LISTS_PAGE_STR_FACT);
      updateCertificateRevocationListSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateCertificateRevocationListOperationSettings = OperationCallSettings.newBuilder();
      createCertificateTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCertificateTemplateOperationSettings = OperationCallSettings.newBuilder();
      deleteCertificateTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteCertificateTemplateOperationSettings = OperationCallSettings.newBuilder();
      getCertificateTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listCertificateTemplatesSettings =
          PagedCallSettings.newBuilder(LIST_CERTIFICATE_TEMPLATES_PAGE_STR_FACT);
      updateCertificateTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateCertificateTemplateOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

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
              undeleteCertificateAuthoritySettings,
              deleteCertificateAuthoritySettings,
              updateCertificateAuthoritySettings,
              createCaPoolSettings,
              updateCaPoolSettings,
              getCaPoolSettings,
              listCaPoolsSettings,
              deleteCaPoolSettings,
              fetchCaCertsSettings,
              getCertificateRevocationListSettings,
              listCertificateRevocationListsSettings,
              updateCertificateRevocationListSettings,
              createCertificateTemplateSettings,
              deleteCertificateTemplateSettings,
              getCertificateTemplateSettings,
              listCertificateTemplatesSettings,
              updateCertificateTemplateSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
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
      undeleteCertificateAuthoritySettings =
          settings.undeleteCertificateAuthoritySettings.toBuilder();
      undeleteCertificateAuthorityOperationSettings =
          settings.undeleteCertificateAuthorityOperationSettings.toBuilder();
      deleteCertificateAuthoritySettings = settings.deleteCertificateAuthoritySettings.toBuilder();
      deleteCertificateAuthorityOperationSettings =
          settings.deleteCertificateAuthorityOperationSettings.toBuilder();
      updateCertificateAuthoritySettings = settings.updateCertificateAuthoritySettings.toBuilder();
      updateCertificateAuthorityOperationSettings =
          settings.updateCertificateAuthorityOperationSettings.toBuilder();
      createCaPoolSettings = settings.createCaPoolSettings.toBuilder();
      createCaPoolOperationSettings = settings.createCaPoolOperationSettings.toBuilder();
      updateCaPoolSettings = settings.updateCaPoolSettings.toBuilder();
      updateCaPoolOperationSettings = settings.updateCaPoolOperationSettings.toBuilder();
      getCaPoolSettings = settings.getCaPoolSettings.toBuilder();
      listCaPoolsSettings = settings.listCaPoolsSettings.toBuilder();
      deleteCaPoolSettings = settings.deleteCaPoolSettings.toBuilder();
      deleteCaPoolOperationSettings = settings.deleteCaPoolOperationSettings.toBuilder();
      fetchCaCertsSettings = settings.fetchCaCertsSettings.toBuilder();
      getCertificateRevocationListSettings =
          settings.getCertificateRevocationListSettings.toBuilder();
      listCertificateRevocationListsSettings =
          settings.listCertificateRevocationListsSettings.toBuilder();
      updateCertificateRevocationListSettings =
          settings.updateCertificateRevocationListSettings.toBuilder();
      updateCertificateRevocationListOperationSettings =
          settings.updateCertificateRevocationListOperationSettings.toBuilder();
      createCertificateTemplateSettings = settings.createCertificateTemplateSettings.toBuilder();
      createCertificateTemplateOperationSettings =
          settings.createCertificateTemplateOperationSettings.toBuilder();
      deleteCertificateTemplateSettings = settings.deleteCertificateTemplateSettings.toBuilder();
      deleteCertificateTemplateOperationSettings =
          settings.deleteCertificateTemplateOperationSettings.toBuilder();
      getCertificateTemplateSettings = settings.getCertificateTemplateSettings.toBuilder();
      listCertificateTemplatesSettings = settings.listCertificateTemplatesSettings.toBuilder();
      updateCertificateTemplateSettings = settings.updateCertificateTemplateSettings.toBuilder();
      updateCertificateTemplateOperationSettings =
          settings.updateCertificateTemplateOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

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
              undeleteCertificateAuthoritySettings,
              deleteCertificateAuthoritySettings,
              updateCertificateAuthoritySettings,
              createCaPoolSettings,
              updateCaPoolSettings,
              getCaPoolSettings,
              listCaPoolsSettings,
              deleteCaPoolSettings,
              fetchCaCertsSettings,
              getCertificateRevocationListSettings,
              listCertificateRevocationListsSettings,
              updateCertificateRevocationListSettings,
              createCertificateTemplateSettings,
              deleteCertificateTemplateSettings,
              getCertificateTemplateSettings,
              listCertificateTemplatesSettings,
              updateCertificateTemplateSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
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
          .undeleteCertificateAuthoritySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteCertificateAuthoritySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateCertificateAuthoritySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createCaPoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateCaPoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getCaPoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listCaPoolsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteCaPoolSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .fetchCaCertsSettings()
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
          .createCertificateTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteCertificateTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getCertificateTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listCertificateTemplatesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateCertificateTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .testIamPermissionsSettings()
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
          .undeleteCertificateAuthorityOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UndeleteCertificateAuthorityRequest, OperationSnapshot>
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
          .deleteCertificateAuthorityOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteCertificateAuthorityRequest, OperationSnapshot>
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
          .createCaPoolOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateCaPoolRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(CaPool.class))
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
          .updateCaPoolOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateCaPoolRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(CaPool.class))
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
          .deleteCaPoolOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteCaPoolRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
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

      builder
          .createCertificateTemplateOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateCertificateTemplateRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(CertificateTemplate.class))
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
          .deleteCertificateTemplateOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteCertificateTemplateRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
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
          .updateCertificateTemplateOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateCertificateTemplateRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(CertificateTemplate.class))
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

    /** Returns the builder for the settings used for calls to undeleteCertificateAuthority. */
    public UnaryCallSettings.Builder<UndeleteCertificateAuthorityRequest, Operation>
        undeleteCertificateAuthoritySettings() {
      return undeleteCertificateAuthoritySettings;
    }

    /** Returns the builder for the settings used for calls to undeleteCertificateAuthority. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            UndeleteCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
        undeleteCertificateAuthorityOperationSettings() {
      return undeleteCertificateAuthorityOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCertificateAuthority. */
    public UnaryCallSettings.Builder<DeleteCertificateAuthorityRequest, Operation>
        deleteCertificateAuthoritySettings() {
      return deleteCertificateAuthoritySettings;
    }

    /** Returns the builder for the settings used for calls to deleteCertificateAuthority. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            DeleteCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
        deleteCertificateAuthorityOperationSettings() {
      return deleteCertificateAuthorityOperationSettings;
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

    /** Returns the builder for the settings used for calls to createCaPool. */
    public UnaryCallSettings.Builder<CreateCaPoolRequest, Operation> createCaPoolSettings() {
      return createCaPoolSettings;
    }

    /** Returns the builder for the settings used for calls to createCaPool. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateCaPoolRequest, CaPool, OperationMetadata>
        createCaPoolOperationSettings() {
      return createCaPoolOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateCaPool. */
    public UnaryCallSettings.Builder<UpdateCaPoolRequest, Operation> updateCaPoolSettings() {
      return updateCaPoolSettings;
    }

    /** Returns the builder for the settings used for calls to updateCaPool. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateCaPoolRequest, CaPool, OperationMetadata>
        updateCaPoolOperationSettings() {
      return updateCaPoolOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getCaPool. */
    public UnaryCallSettings.Builder<GetCaPoolRequest, CaPool> getCaPoolSettings() {
      return getCaPoolSettings;
    }

    /** Returns the builder for the settings used for calls to listCaPools. */
    public PagedCallSettings.Builder<
            ListCaPoolsRequest, ListCaPoolsResponse, ListCaPoolsPagedResponse>
        listCaPoolsSettings() {
      return listCaPoolsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCaPool. */
    public UnaryCallSettings.Builder<DeleteCaPoolRequest, Operation> deleteCaPoolSettings() {
      return deleteCaPoolSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCaPool. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteCaPoolRequest, Empty, OperationMetadata>
        deleteCaPoolOperationSettings() {
      return deleteCaPoolOperationSettings;
    }

    /** Returns the builder for the settings used for calls to fetchCaCerts. */
    public UnaryCallSettings.Builder<FetchCaCertsRequest, FetchCaCertsResponse>
        fetchCaCertsSettings() {
      return fetchCaCertsSettings;
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

    /** Returns the builder for the settings used for calls to createCertificateTemplate. */
    public UnaryCallSettings.Builder<CreateCertificateTemplateRequest, Operation>
        createCertificateTemplateSettings() {
      return createCertificateTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to createCertificateTemplate. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateCertificateTemplateRequest, CertificateTemplate, OperationMetadata>
        createCertificateTemplateOperationSettings() {
      return createCertificateTemplateOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCertificateTemplate. */
    public UnaryCallSettings.Builder<DeleteCertificateTemplateRequest, Operation>
        deleteCertificateTemplateSettings() {
      return deleteCertificateTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCertificateTemplate. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteCertificateTemplateRequest, Empty, OperationMetadata>
        deleteCertificateTemplateOperationSettings() {
      return deleteCertificateTemplateOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getCertificateTemplate. */
    public UnaryCallSettings.Builder<GetCertificateTemplateRequest, CertificateTemplate>
        getCertificateTemplateSettings() {
      return getCertificateTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to listCertificateTemplates. */
    public PagedCallSettings.Builder<
            ListCertificateTemplatesRequest,
            ListCertificateTemplatesResponse,
            ListCertificateTemplatesPagedResponse>
        listCertificateTemplatesSettings() {
      return listCertificateTemplatesSettings;
    }

    /** Returns the builder for the settings used for calls to updateCertificateTemplate. */
    public UnaryCallSettings.Builder<UpdateCertificateTemplateRequest, Operation>
        updateCertificateTemplateSettings() {
      return updateCertificateTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to updateCertificateTemplate. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            UpdateCertificateTemplateRequest, CertificateTemplate, OperationMetadata>
        updateCertificateTemplateOperationSettings() {
      return updateCertificateTemplateOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return listLocationsSettings;
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getLocationSettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public CertificateAuthorityServiceStubSettings build() throws IOException {
      return new CertificateAuthorityServiceStubSettings(this);
    }
  }
}
