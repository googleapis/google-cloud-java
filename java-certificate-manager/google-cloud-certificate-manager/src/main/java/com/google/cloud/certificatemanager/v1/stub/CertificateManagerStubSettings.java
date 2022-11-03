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

package com.google.cloud.certificatemanager.v1.stub;

import static com.google.cloud.certificatemanager.v1.CertificateManagerClient.ListCertificateIssuanceConfigsPagedResponse;
import static com.google.cloud.certificatemanager.v1.CertificateManagerClient.ListCertificateMapEntriesPagedResponse;
import static com.google.cloud.certificatemanager.v1.CertificateManagerClient.ListCertificateMapsPagedResponse;
import static com.google.cloud.certificatemanager.v1.CertificateManagerClient.ListCertificatesPagedResponse;
import static com.google.cloud.certificatemanager.v1.CertificateManagerClient.ListDnsAuthorizationsPagedResponse;
import static com.google.cloud.certificatemanager.v1.CertificateManagerClient.ListLocationsPagedResponse;

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
import com.google.cloud.certificatemanager.v1.Certificate;
import com.google.cloud.certificatemanager.v1.CertificateIssuanceConfig;
import com.google.cloud.certificatemanager.v1.CertificateMap;
import com.google.cloud.certificatemanager.v1.CertificateMapEntry;
import com.google.cloud.certificatemanager.v1.CreateCertificateIssuanceConfigRequest;
import com.google.cloud.certificatemanager.v1.CreateCertificateMapEntryRequest;
import com.google.cloud.certificatemanager.v1.CreateCertificateMapRequest;
import com.google.cloud.certificatemanager.v1.CreateCertificateRequest;
import com.google.cloud.certificatemanager.v1.CreateDnsAuthorizationRequest;
import com.google.cloud.certificatemanager.v1.DeleteCertificateIssuanceConfigRequest;
import com.google.cloud.certificatemanager.v1.DeleteCertificateMapEntryRequest;
import com.google.cloud.certificatemanager.v1.DeleteCertificateMapRequest;
import com.google.cloud.certificatemanager.v1.DeleteCertificateRequest;
import com.google.cloud.certificatemanager.v1.DeleteDnsAuthorizationRequest;
import com.google.cloud.certificatemanager.v1.DnsAuthorization;
import com.google.cloud.certificatemanager.v1.GetCertificateIssuanceConfigRequest;
import com.google.cloud.certificatemanager.v1.GetCertificateMapEntryRequest;
import com.google.cloud.certificatemanager.v1.GetCertificateMapRequest;
import com.google.cloud.certificatemanager.v1.GetCertificateRequest;
import com.google.cloud.certificatemanager.v1.GetDnsAuthorizationRequest;
import com.google.cloud.certificatemanager.v1.ListCertificateIssuanceConfigsRequest;
import com.google.cloud.certificatemanager.v1.ListCertificateIssuanceConfigsResponse;
import com.google.cloud.certificatemanager.v1.ListCertificateMapEntriesRequest;
import com.google.cloud.certificatemanager.v1.ListCertificateMapEntriesResponse;
import com.google.cloud.certificatemanager.v1.ListCertificateMapsRequest;
import com.google.cloud.certificatemanager.v1.ListCertificateMapsResponse;
import com.google.cloud.certificatemanager.v1.ListCertificatesRequest;
import com.google.cloud.certificatemanager.v1.ListCertificatesResponse;
import com.google.cloud.certificatemanager.v1.ListDnsAuthorizationsRequest;
import com.google.cloud.certificatemanager.v1.ListDnsAuthorizationsResponse;
import com.google.cloud.certificatemanager.v1.OperationMetadata;
import com.google.cloud.certificatemanager.v1.UpdateCertificateMapEntryRequest;
import com.google.cloud.certificatemanager.v1.UpdateCertificateMapRequest;
import com.google.cloud.certificatemanager.v1.UpdateCertificateRequest;
import com.google.cloud.certificatemanager.v1.UpdateDnsAuthorizationRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * Settings class to configure an instance of {@link CertificateManagerStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (certificatemanager.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getCertificate to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CertificateManagerStubSettings.Builder certificateManagerSettingsBuilder =
 *     CertificateManagerStubSettings.newBuilder();
 * certificateManagerSettingsBuilder
 *     .getCertificateSettings()
 *     .setRetrySettings(
 *         certificateManagerSettingsBuilder
 *             .getCertificateSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * CertificateManagerStubSettings certificateManagerSettings =
 *     certificateManagerSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class CertificateManagerStubSettings extends StubSettings<CertificateManagerStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListCertificatesRequest, ListCertificatesResponse, ListCertificatesPagedResponse>
      listCertificatesSettings;
  private final UnaryCallSettings<GetCertificateRequest, Certificate> getCertificateSettings;
  private final UnaryCallSettings<CreateCertificateRequest, Operation> createCertificateSettings;
  private final OperationCallSettings<CreateCertificateRequest, Certificate, OperationMetadata>
      createCertificateOperationSettings;
  private final UnaryCallSettings<UpdateCertificateRequest, Operation> updateCertificateSettings;
  private final OperationCallSettings<UpdateCertificateRequest, Certificate, OperationMetadata>
      updateCertificateOperationSettings;
  private final UnaryCallSettings<DeleteCertificateRequest, Operation> deleteCertificateSettings;
  private final OperationCallSettings<DeleteCertificateRequest, Empty, OperationMetadata>
      deleteCertificateOperationSettings;
  private final PagedCallSettings<
          ListCertificateMapsRequest, ListCertificateMapsResponse, ListCertificateMapsPagedResponse>
      listCertificateMapsSettings;
  private final UnaryCallSettings<GetCertificateMapRequest, CertificateMap>
      getCertificateMapSettings;
  private final UnaryCallSettings<CreateCertificateMapRequest, Operation>
      createCertificateMapSettings;
  private final OperationCallSettings<
          CreateCertificateMapRequest, CertificateMap, OperationMetadata>
      createCertificateMapOperationSettings;
  private final UnaryCallSettings<UpdateCertificateMapRequest, Operation>
      updateCertificateMapSettings;
  private final OperationCallSettings<
          UpdateCertificateMapRequest, CertificateMap, OperationMetadata>
      updateCertificateMapOperationSettings;
  private final UnaryCallSettings<DeleteCertificateMapRequest, Operation>
      deleteCertificateMapSettings;
  private final OperationCallSettings<DeleteCertificateMapRequest, Empty, OperationMetadata>
      deleteCertificateMapOperationSettings;
  private final PagedCallSettings<
          ListCertificateMapEntriesRequest,
          ListCertificateMapEntriesResponse,
          ListCertificateMapEntriesPagedResponse>
      listCertificateMapEntriesSettings;
  private final UnaryCallSettings<GetCertificateMapEntryRequest, CertificateMapEntry>
      getCertificateMapEntrySettings;
  private final UnaryCallSettings<CreateCertificateMapEntryRequest, Operation>
      createCertificateMapEntrySettings;
  private final OperationCallSettings<
          CreateCertificateMapEntryRequest, CertificateMapEntry, OperationMetadata>
      createCertificateMapEntryOperationSettings;
  private final UnaryCallSettings<UpdateCertificateMapEntryRequest, Operation>
      updateCertificateMapEntrySettings;
  private final OperationCallSettings<
          UpdateCertificateMapEntryRequest, CertificateMapEntry, OperationMetadata>
      updateCertificateMapEntryOperationSettings;
  private final UnaryCallSettings<DeleteCertificateMapEntryRequest, Operation>
      deleteCertificateMapEntrySettings;
  private final OperationCallSettings<DeleteCertificateMapEntryRequest, Empty, OperationMetadata>
      deleteCertificateMapEntryOperationSettings;
  private final PagedCallSettings<
          ListDnsAuthorizationsRequest,
          ListDnsAuthorizationsResponse,
          ListDnsAuthorizationsPagedResponse>
      listDnsAuthorizationsSettings;
  private final UnaryCallSettings<GetDnsAuthorizationRequest, DnsAuthorization>
      getDnsAuthorizationSettings;
  private final UnaryCallSettings<CreateDnsAuthorizationRequest, Operation>
      createDnsAuthorizationSettings;
  private final OperationCallSettings<
          CreateDnsAuthorizationRequest, DnsAuthorization, OperationMetadata>
      createDnsAuthorizationOperationSettings;
  private final UnaryCallSettings<UpdateDnsAuthorizationRequest, Operation>
      updateDnsAuthorizationSettings;
  private final OperationCallSettings<
          UpdateDnsAuthorizationRequest, DnsAuthorization, OperationMetadata>
      updateDnsAuthorizationOperationSettings;
  private final UnaryCallSettings<DeleteDnsAuthorizationRequest, Operation>
      deleteDnsAuthorizationSettings;
  private final OperationCallSettings<DeleteDnsAuthorizationRequest, Empty, OperationMetadata>
      deleteDnsAuthorizationOperationSettings;
  private final PagedCallSettings<
          ListCertificateIssuanceConfigsRequest,
          ListCertificateIssuanceConfigsResponse,
          ListCertificateIssuanceConfigsPagedResponse>
      listCertificateIssuanceConfigsSettings;
  private final UnaryCallSettings<GetCertificateIssuanceConfigRequest, CertificateIssuanceConfig>
      getCertificateIssuanceConfigSettings;
  private final UnaryCallSettings<CreateCertificateIssuanceConfigRequest, Operation>
      createCertificateIssuanceConfigSettings;
  private final OperationCallSettings<
          CreateCertificateIssuanceConfigRequest, CertificateIssuanceConfig, OperationMetadata>
      createCertificateIssuanceConfigOperationSettings;
  private final UnaryCallSettings<DeleteCertificateIssuanceConfigRequest, Operation>
      deleteCertificateIssuanceConfigSettings;
  private final OperationCallSettings<
          DeleteCertificateIssuanceConfigRequest, Empty, OperationMetadata>
      deleteCertificateIssuanceConfigOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

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
          ListCertificateMapsRequest, ListCertificateMapsResponse, CertificateMap>
      LIST_CERTIFICATE_MAPS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListCertificateMapsRequest, ListCertificateMapsResponse, CertificateMap>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCertificateMapsRequest injectToken(
                ListCertificateMapsRequest payload, String token) {
              return ListCertificateMapsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListCertificateMapsRequest injectPageSize(
                ListCertificateMapsRequest payload, int pageSize) {
              return ListCertificateMapsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListCertificateMapsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCertificateMapsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<CertificateMap> extractResources(ListCertificateMapsResponse payload) {
              return payload.getCertificateMapsList() == null
                  ? ImmutableList.<CertificateMap>of()
                  : payload.getCertificateMapsList();
            }
          };

  private static final PagedListDescriptor<
          ListCertificateMapEntriesRequest, ListCertificateMapEntriesResponse, CertificateMapEntry>
      LIST_CERTIFICATE_MAP_ENTRIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListCertificateMapEntriesRequest,
              ListCertificateMapEntriesResponse,
              CertificateMapEntry>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCertificateMapEntriesRequest injectToken(
                ListCertificateMapEntriesRequest payload, String token) {
              return ListCertificateMapEntriesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListCertificateMapEntriesRequest injectPageSize(
                ListCertificateMapEntriesRequest payload, int pageSize) {
              return ListCertificateMapEntriesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListCertificateMapEntriesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCertificateMapEntriesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<CertificateMapEntry> extractResources(
                ListCertificateMapEntriesResponse payload) {
              return payload.getCertificateMapEntriesList() == null
                  ? ImmutableList.<CertificateMapEntry>of()
                  : payload.getCertificateMapEntriesList();
            }
          };

  private static final PagedListDescriptor<
          ListDnsAuthorizationsRequest, ListDnsAuthorizationsResponse, DnsAuthorization>
      LIST_DNS_AUTHORIZATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDnsAuthorizationsRequest, ListDnsAuthorizationsResponse, DnsAuthorization>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDnsAuthorizationsRequest injectToken(
                ListDnsAuthorizationsRequest payload, String token) {
              return ListDnsAuthorizationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDnsAuthorizationsRequest injectPageSize(
                ListDnsAuthorizationsRequest payload, int pageSize) {
              return ListDnsAuthorizationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDnsAuthorizationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDnsAuthorizationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DnsAuthorization> extractResources(
                ListDnsAuthorizationsResponse payload) {
              return payload.getDnsAuthorizationsList() == null
                  ? ImmutableList.<DnsAuthorization>of()
                  : payload.getDnsAuthorizationsList();
            }
          };

  private static final PagedListDescriptor<
          ListCertificateIssuanceConfigsRequest,
          ListCertificateIssuanceConfigsResponse,
          CertificateIssuanceConfig>
      LIST_CERTIFICATE_ISSUANCE_CONFIGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListCertificateIssuanceConfigsRequest,
              ListCertificateIssuanceConfigsResponse,
              CertificateIssuanceConfig>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCertificateIssuanceConfigsRequest injectToken(
                ListCertificateIssuanceConfigsRequest payload, String token) {
              return ListCertificateIssuanceConfigsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListCertificateIssuanceConfigsRequest injectPageSize(
                ListCertificateIssuanceConfigsRequest payload, int pageSize) {
              return ListCertificateIssuanceConfigsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListCertificateIssuanceConfigsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCertificateIssuanceConfigsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<CertificateIssuanceConfig> extractResources(
                ListCertificateIssuanceConfigsResponse payload) {
              return payload.getCertificateIssuanceConfigsList() == null
                  ? ImmutableList.<CertificateIssuanceConfig>of()
                  : payload.getCertificateIssuanceConfigsList();
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
          ListCertificateMapsRequest, ListCertificateMapsResponse, ListCertificateMapsPagedResponse>
      LIST_CERTIFICATE_MAPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCertificateMapsRequest,
              ListCertificateMapsResponse,
              ListCertificateMapsPagedResponse>() {
            @Override
            public ApiFuture<ListCertificateMapsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCertificateMapsRequest, ListCertificateMapsResponse> callable,
                ListCertificateMapsRequest request,
                ApiCallContext context,
                ApiFuture<ListCertificateMapsResponse> futureResponse) {
              PageContext<ListCertificateMapsRequest, ListCertificateMapsResponse, CertificateMap>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CERTIFICATE_MAPS_PAGE_STR_DESC, request, context);
              return ListCertificateMapsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListCertificateMapEntriesRequest,
          ListCertificateMapEntriesResponse,
          ListCertificateMapEntriesPagedResponse>
      LIST_CERTIFICATE_MAP_ENTRIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCertificateMapEntriesRequest,
              ListCertificateMapEntriesResponse,
              ListCertificateMapEntriesPagedResponse>() {
            @Override
            public ApiFuture<ListCertificateMapEntriesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCertificateMapEntriesRequest, ListCertificateMapEntriesResponse>
                    callable,
                ListCertificateMapEntriesRequest request,
                ApiCallContext context,
                ApiFuture<ListCertificateMapEntriesResponse> futureResponse) {
              PageContext<
                      ListCertificateMapEntriesRequest,
                      ListCertificateMapEntriesResponse,
                      CertificateMapEntry>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CERTIFICATE_MAP_ENTRIES_PAGE_STR_DESC, request, context);
              return ListCertificateMapEntriesPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDnsAuthorizationsRequest,
          ListDnsAuthorizationsResponse,
          ListDnsAuthorizationsPagedResponse>
      LIST_DNS_AUTHORIZATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDnsAuthorizationsRequest,
              ListDnsAuthorizationsResponse,
              ListDnsAuthorizationsPagedResponse>() {
            @Override
            public ApiFuture<ListDnsAuthorizationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDnsAuthorizationsRequest, ListDnsAuthorizationsResponse> callable,
                ListDnsAuthorizationsRequest request,
                ApiCallContext context,
                ApiFuture<ListDnsAuthorizationsResponse> futureResponse) {
              PageContext<
                      ListDnsAuthorizationsRequest, ListDnsAuthorizationsResponse, DnsAuthorization>
                  pageContext =
                      PageContext.create(
                          callable, LIST_DNS_AUTHORIZATIONS_PAGE_STR_DESC, request, context);
              return ListDnsAuthorizationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListCertificateIssuanceConfigsRequest,
          ListCertificateIssuanceConfigsResponse,
          ListCertificateIssuanceConfigsPagedResponse>
      LIST_CERTIFICATE_ISSUANCE_CONFIGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCertificateIssuanceConfigsRequest,
              ListCertificateIssuanceConfigsResponse,
              ListCertificateIssuanceConfigsPagedResponse>() {
            @Override
            public ApiFuture<ListCertificateIssuanceConfigsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListCertificateIssuanceConfigsRequest,
                        ListCertificateIssuanceConfigsResponse>
                    callable,
                ListCertificateIssuanceConfigsRequest request,
                ApiCallContext context,
                ApiFuture<ListCertificateIssuanceConfigsResponse> futureResponse) {
              PageContext<
                      ListCertificateIssuanceConfigsRequest,
                      ListCertificateIssuanceConfigsResponse,
                      CertificateIssuanceConfig>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_CERTIFICATE_ISSUANCE_CONFIGS_PAGE_STR_DESC,
                          request,
                          context);
              return ListCertificateIssuanceConfigsPagedResponse.createAsync(
                  pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listCertificates. */
  public PagedCallSettings<
          ListCertificatesRequest, ListCertificatesResponse, ListCertificatesPagedResponse>
      listCertificatesSettings() {
    return listCertificatesSettings;
  }

  /** Returns the object with the settings used for calls to getCertificate. */
  public UnaryCallSettings<GetCertificateRequest, Certificate> getCertificateSettings() {
    return getCertificateSettings;
  }

  /** Returns the object with the settings used for calls to createCertificate. */
  public UnaryCallSettings<CreateCertificateRequest, Operation> createCertificateSettings() {
    return createCertificateSettings;
  }

  /** Returns the object with the settings used for calls to createCertificate. */
  public OperationCallSettings<CreateCertificateRequest, Certificate, OperationMetadata>
      createCertificateOperationSettings() {
    return createCertificateOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateCertificate. */
  public UnaryCallSettings<UpdateCertificateRequest, Operation> updateCertificateSettings() {
    return updateCertificateSettings;
  }

  /** Returns the object with the settings used for calls to updateCertificate. */
  public OperationCallSettings<UpdateCertificateRequest, Certificate, OperationMetadata>
      updateCertificateOperationSettings() {
    return updateCertificateOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteCertificate. */
  public UnaryCallSettings<DeleteCertificateRequest, Operation> deleteCertificateSettings() {
    return deleteCertificateSettings;
  }

  /** Returns the object with the settings used for calls to deleteCertificate. */
  public OperationCallSettings<DeleteCertificateRequest, Empty, OperationMetadata>
      deleteCertificateOperationSettings() {
    return deleteCertificateOperationSettings;
  }

  /** Returns the object with the settings used for calls to listCertificateMaps. */
  public PagedCallSettings<
          ListCertificateMapsRequest, ListCertificateMapsResponse, ListCertificateMapsPagedResponse>
      listCertificateMapsSettings() {
    return listCertificateMapsSettings;
  }

  /** Returns the object with the settings used for calls to getCertificateMap. */
  public UnaryCallSettings<GetCertificateMapRequest, CertificateMap> getCertificateMapSettings() {
    return getCertificateMapSettings;
  }

  /** Returns the object with the settings used for calls to createCertificateMap. */
  public UnaryCallSettings<CreateCertificateMapRequest, Operation> createCertificateMapSettings() {
    return createCertificateMapSettings;
  }

  /** Returns the object with the settings used for calls to createCertificateMap. */
  public OperationCallSettings<CreateCertificateMapRequest, CertificateMap, OperationMetadata>
      createCertificateMapOperationSettings() {
    return createCertificateMapOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateCertificateMap. */
  public UnaryCallSettings<UpdateCertificateMapRequest, Operation> updateCertificateMapSettings() {
    return updateCertificateMapSettings;
  }

  /** Returns the object with the settings used for calls to updateCertificateMap. */
  public OperationCallSettings<UpdateCertificateMapRequest, CertificateMap, OperationMetadata>
      updateCertificateMapOperationSettings() {
    return updateCertificateMapOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteCertificateMap. */
  public UnaryCallSettings<DeleteCertificateMapRequest, Operation> deleteCertificateMapSettings() {
    return deleteCertificateMapSettings;
  }

  /** Returns the object with the settings used for calls to deleteCertificateMap. */
  public OperationCallSettings<DeleteCertificateMapRequest, Empty, OperationMetadata>
      deleteCertificateMapOperationSettings() {
    return deleteCertificateMapOperationSettings;
  }

  /** Returns the object with the settings used for calls to listCertificateMapEntries. */
  public PagedCallSettings<
          ListCertificateMapEntriesRequest,
          ListCertificateMapEntriesResponse,
          ListCertificateMapEntriesPagedResponse>
      listCertificateMapEntriesSettings() {
    return listCertificateMapEntriesSettings;
  }

  /** Returns the object with the settings used for calls to getCertificateMapEntry. */
  public UnaryCallSettings<GetCertificateMapEntryRequest, CertificateMapEntry>
      getCertificateMapEntrySettings() {
    return getCertificateMapEntrySettings;
  }

  /** Returns the object with the settings used for calls to createCertificateMapEntry. */
  public UnaryCallSettings<CreateCertificateMapEntryRequest, Operation>
      createCertificateMapEntrySettings() {
    return createCertificateMapEntrySettings;
  }

  /** Returns the object with the settings used for calls to createCertificateMapEntry. */
  public OperationCallSettings<
          CreateCertificateMapEntryRequest, CertificateMapEntry, OperationMetadata>
      createCertificateMapEntryOperationSettings() {
    return createCertificateMapEntryOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateCertificateMapEntry. */
  public UnaryCallSettings<UpdateCertificateMapEntryRequest, Operation>
      updateCertificateMapEntrySettings() {
    return updateCertificateMapEntrySettings;
  }

  /** Returns the object with the settings used for calls to updateCertificateMapEntry. */
  public OperationCallSettings<
          UpdateCertificateMapEntryRequest, CertificateMapEntry, OperationMetadata>
      updateCertificateMapEntryOperationSettings() {
    return updateCertificateMapEntryOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteCertificateMapEntry. */
  public UnaryCallSettings<DeleteCertificateMapEntryRequest, Operation>
      deleteCertificateMapEntrySettings() {
    return deleteCertificateMapEntrySettings;
  }

  /** Returns the object with the settings used for calls to deleteCertificateMapEntry. */
  public OperationCallSettings<DeleteCertificateMapEntryRequest, Empty, OperationMetadata>
      deleteCertificateMapEntryOperationSettings() {
    return deleteCertificateMapEntryOperationSettings;
  }

  /** Returns the object with the settings used for calls to listDnsAuthorizations. */
  public PagedCallSettings<
          ListDnsAuthorizationsRequest,
          ListDnsAuthorizationsResponse,
          ListDnsAuthorizationsPagedResponse>
      listDnsAuthorizationsSettings() {
    return listDnsAuthorizationsSettings;
  }

  /** Returns the object with the settings used for calls to getDnsAuthorization. */
  public UnaryCallSettings<GetDnsAuthorizationRequest, DnsAuthorization>
      getDnsAuthorizationSettings() {
    return getDnsAuthorizationSettings;
  }

  /** Returns the object with the settings used for calls to createDnsAuthorization. */
  public UnaryCallSettings<CreateDnsAuthorizationRequest, Operation>
      createDnsAuthorizationSettings() {
    return createDnsAuthorizationSettings;
  }

  /** Returns the object with the settings used for calls to createDnsAuthorization. */
  public OperationCallSettings<CreateDnsAuthorizationRequest, DnsAuthorization, OperationMetadata>
      createDnsAuthorizationOperationSettings() {
    return createDnsAuthorizationOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateDnsAuthorization. */
  public UnaryCallSettings<UpdateDnsAuthorizationRequest, Operation>
      updateDnsAuthorizationSettings() {
    return updateDnsAuthorizationSettings;
  }

  /** Returns the object with the settings used for calls to updateDnsAuthorization. */
  public OperationCallSettings<UpdateDnsAuthorizationRequest, DnsAuthorization, OperationMetadata>
      updateDnsAuthorizationOperationSettings() {
    return updateDnsAuthorizationOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteDnsAuthorization. */
  public UnaryCallSettings<DeleteDnsAuthorizationRequest, Operation>
      deleteDnsAuthorizationSettings() {
    return deleteDnsAuthorizationSettings;
  }

  /** Returns the object with the settings used for calls to deleteDnsAuthorization. */
  public OperationCallSettings<DeleteDnsAuthorizationRequest, Empty, OperationMetadata>
      deleteDnsAuthorizationOperationSettings() {
    return deleteDnsAuthorizationOperationSettings;
  }

  /** Returns the object with the settings used for calls to listCertificateIssuanceConfigs. */
  public PagedCallSettings<
          ListCertificateIssuanceConfigsRequest,
          ListCertificateIssuanceConfigsResponse,
          ListCertificateIssuanceConfigsPagedResponse>
      listCertificateIssuanceConfigsSettings() {
    return listCertificateIssuanceConfigsSettings;
  }

  /** Returns the object with the settings used for calls to getCertificateIssuanceConfig. */
  public UnaryCallSettings<GetCertificateIssuanceConfigRequest, CertificateIssuanceConfig>
      getCertificateIssuanceConfigSettings() {
    return getCertificateIssuanceConfigSettings;
  }

  /** Returns the object with the settings used for calls to createCertificateIssuanceConfig. */
  public UnaryCallSettings<CreateCertificateIssuanceConfigRequest, Operation>
      createCertificateIssuanceConfigSettings() {
    return createCertificateIssuanceConfigSettings;
  }

  /** Returns the object with the settings used for calls to createCertificateIssuanceConfig. */
  public OperationCallSettings<
          CreateCertificateIssuanceConfigRequest, CertificateIssuanceConfig, OperationMetadata>
      createCertificateIssuanceConfigOperationSettings() {
    return createCertificateIssuanceConfigOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteCertificateIssuanceConfig. */
  public UnaryCallSettings<DeleteCertificateIssuanceConfigRequest, Operation>
      deleteCertificateIssuanceConfigSettings() {
    return deleteCertificateIssuanceConfigSettings;
  }

  /** Returns the object with the settings used for calls to deleteCertificateIssuanceConfig. */
  public OperationCallSettings<DeleteCertificateIssuanceConfigRequest, Empty, OperationMetadata>
      deleteCertificateIssuanceConfigOperationSettings() {
    return deleteCertificateIssuanceConfigOperationSettings;
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

  public CertificateManagerStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcCertificateManagerStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonCertificateManagerStub.create(this);
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
    return "certificatemanager.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "certificatemanager.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(CertificateManagerStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(CertificateManagerStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CertificateManagerStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected CertificateManagerStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listCertificatesSettings = settingsBuilder.listCertificatesSettings().build();
    getCertificateSettings = settingsBuilder.getCertificateSettings().build();
    createCertificateSettings = settingsBuilder.createCertificateSettings().build();
    createCertificateOperationSettings =
        settingsBuilder.createCertificateOperationSettings().build();
    updateCertificateSettings = settingsBuilder.updateCertificateSettings().build();
    updateCertificateOperationSettings =
        settingsBuilder.updateCertificateOperationSettings().build();
    deleteCertificateSettings = settingsBuilder.deleteCertificateSettings().build();
    deleteCertificateOperationSettings =
        settingsBuilder.deleteCertificateOperationSettings().build();
    listCertificateMapsSettings = settingsBuilder.listCertificateMapsSettings().build();
    getCertificateMapSettings = settingsBuilder.getCertificateMapSettings().build();
    createCertificateMapSettings = settingsBuilder.createCertificateMapSettings().build();
    createCertificateMapOperationSettings =
        settingsBuilder.createCertificateMapOperationSettings().build();
    updateCertificateMapSettings = settingsBuilder.updateCertificateMapSettings().build();
    updateCertificateMapOperationSettings =
        settingsBuilder.updateCertificateMapOperationSettings().build();
    deleteCertificateMapSettings = settingsBuilder.deleteCertificateMapSettings().build();
    deleteCertificateMapOperationSettings =
        settingsBuilder.deleteCertificateMapOperationSettings().build();
    listCertificateMapEntriesSettings = settingsBuilder.listCertificateMapEntriesSettings().build();
    getCertificateMapEntrySettings = settingsBuilder.getCertificateMapEntrySettings().build();
    createCertificateMapEntrySettings = settingsBuilder.createCertificateMapEntrySettings().build();
    createCertificateMapEntryOperationSettings =
        settingsBuilder.createCertificateMapEntryOperationSettings().build();
    updateCertificateMapEntrySettings = settingsBuilder.updateCertificateMapEntrySettings().build();
    updateCertificateMapEntryOperationSettings =
        settingsBuilder.updateCertificateMapEntryOperationSettings().build();
    deleteCertificateMapEntrySettings = settingsBuilder.deleteCertificateMapEntrySettings().build();
    deleteCertificateMapEntryOperationSettings =
        settingsBuilder.deleteCertificateMapEntryOperationSettings().build();
    listDnsAuthorizationsSettings = settingsBuilder.listDnsAuthorizationsSettings().build();
    getDnsAuthorizationSettings = settingsBuilder.getDnsAuthorizationSettings().build();
    createDnsAuthorizationSettings = settingsBuilder.createDnsAuthorizationSettings().build();
    createDnsAuthorizationOperationSettings =
        settingsBuilder.createDnsAuthorizationOperationSettings().build();
    updateDnsAuthorizationSettings = settingsBuilder.updateDnsAuthorizationSettings().build();
    updateDnsAuthorizationOperationSettings =
        settingsBuilder.updateDnsAuthorizationOperationSettings().build();
    deleteDnsAuthorizationSettings = settingsBuilder.deleteDnsAuthorizationSettings().build();
    deleteDnsAuthorizationOperationSettings =
        settingsBuilder.deleteDnsAuthorizationOperationSettings().build();
    listCertificateIssuanceConfigsSettings =
        settingsBuilder.listCertificateIssuanceConfigsSettings().build();
    getCertificateIssuanceConfigSettings =
        settingsBuilder.getCertificateIssuanceConfigSettings().build();
    createCertificateIssuanceConfigSettings =
        settingsBuilder.createCertificateIssuanceConfigSettings().build();
    createCertificateIssuanceConfigOperationSettings =
        settingsBuilder.createCertificateIssuanceConfigOperationSettings().build();
    deleteCertificateIssuanceConfigSettings =
        settingsBuilder.deleteCertificateIssuanceConfigSettings().build();
    deleteCertificateIssuanceConfigOperationSettings =
        settingsBuilder.deleteCertificateIssuanceConfigOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for CertificateManagerStubSettings. */
  public static class Builder
      extends StubSettings.Builder<CertificateManagerStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListCertificatesRequest, ListCertificatesResponse, ListCertificatesPagedResponse>
        listCertificatesSettings;
    private final UnaryCallSettings.Builder<GetCertificateRequest, Certificate>
        getCertificateSettings;
    private final UnaryCallSettings.Builder<CreateCertificateRequest, Operation>
        createCertificateSettings;
    private final OperationCallSettings.Builder<
            CreateCertificateRequest, Certificate, OperationMetadata>
        createCertificateOperationSettings;
    private final UnaryCallSettings.Builder<UpdateCertificateRequest, Operation>
        updateCertificateSettings;
    private final OperationCallSettings.Builder<
            UpdateCertificateRequest, Certificate, OperationMetadata>
        updateCertificateOperationSettings;
    private final UnaryCallSettings.Builder<DeleteCertificateRequest, Operation>
        deleteCertificateSettings;
    private final OperationCallSettings.Builder<DeleteCertificateRequest, Empty, OperationMetadata>
        deleteCertificateOperationSettings;
    private final PagedCallSettings.Builder<
            ListCertificateMapsRequest,
            ListCertificateMapsResponse,
            ListCertificateMapsPagedResponse>
        listCertificateMapsSettings;
    private final UnaryCallSettings.Builder<GetCertificateMapRequest, CertificateMap>
        getCertificateMapSettings;
    private final UnaryCallSettings.Builder<CreateCertificateMapRequest, Operation>
        createCertificateMapSettings;
    private final OperationCallSettings.Builder<
            CreateCertificateMapRequest, CertificateMap, OperationMetadata>
        createCertificateMapOperationSettings;
    private final UnaryCallSettings.Builder<UpdateCertificateMapRequest, Operation>
        updateCertificateMapSettings;
    private final OperationCallSettings.Builder<
            UpdateCertificateMapRequest, CertificateMap, OperationMetadata>
        updateCertificateMapOperationSettings;
    private final UnaryCallSettings.Builder<DeleteCertificateMapRequest, Operation>
        deleteCertificateMapSettings;
    private final OperationCallSettings.Builder<
            DeleteCertificateMapRequest, Empty, OperationMetadata>
        deleteCertificateMapOperationSettings;
    private final PagedCallSettings.Builder<
            ListCertificateMapEntriesRequest,
            ListCertificateMapEntriesResponse,
            ListCertificateMapEntriesPagedResponse>
        listCertificateMapEntriesSettings;
    private final UnaryCallSettings.Builder<GetCertificateMapEntryRequest, CertificateMapEntry>
        getCertificateMapEntrySettings;
    private final UnaryCallSettings.Builder<CreateCertificateMapEntryRequest, Operation>
        createCertificateMapEntrySettings;
    private final OperationCallSettings.Builder<
            CreateCertificateMapEntryRequest, CertificateMapEntry, OperationMetadata>
        createCertificateMapEntryOperationSettings;
    private final UnaryCallSettings.Builder<UpdateCertificateMapEntryRequest, Operation>
        updateCertificateMapEntrySettings;
    private final OperationCallSettings.Builder<
            UpdateCertificateMapEntryRequest, CertificateMapEntry, OperationMetadata>
        updateCertificateMapEntryOperationSettings;
    private final UnaryCallSettings.Builder<DeleteCertificateMapEntryRequest, Operation>
        deleteCertificateMapEntrySettings;
    private final OperationCallSettings.Builder<
            DeleteCertificateMapEntryRequest, Empty, OperationMetadata>
        deleteCertificateMapEntryOperationSettings;
    private final PagedCallSettings.Builder<
            ListDnsAuthorizationsRequest,
            ListDnsAuthorizationsResponse,
            ListDnsAuthorizationsPagedResponse>
        listDnsAuthorizationsSettings;
    private final UnaryCallSettings.Builder<GetDnsAuthorizationRequest, DnsAuthorization>
        getDnsAuthorizationSettings;
    private final UnaryCallSettings.Builder<CreateDnsAuthorizationRequest, Operation>
        createDnsAuthorizationSettings;
    private final OperationCallSettings.Builder<
            CreateDnsAuthorizationRequest, DnsAuthorization, OperationMetadata>
        createDnsAuthorizationOperationSettings;
    private final UnaryCallSettings.Builder<UpdateDnsAuthorizationRequest, Operation>
        updateDnsAuthorizationSettings;
    private final OperationCallSettings.Builder<
            UpdateDnsAuthorizationRequest, DnsAuthorization, OperationMetadata>
        updateDnsAuthorizationOperationSettings;
    private final UnaryCallSettings.Builder<DeleteDnsAuthorizationRequest, Operation>
        deleteDnsAuthorizationSettings;
    private final OperationCallSettings.Builder<
            DeleteDnsAuthorizationRequest, Empty, OperationMetadata>
        deleteDnsAuthorizationOperationSettings;
    private final PagedCallSettings.Builder<
            ListCertificateIssuanceConfigsRequest,
            ListCertificateIssuanceConfigsResponse,
            ListCertificateIssuanceConfigsPagedResponse>
        listCertificateIssuanceConfigsSettings;
    private final UnaryCallSettings.Builder<
            GetCertificateIssuanceConfigRequest, CertificateIssuanceConfig>
        getCertificateIssuanceConfigSettings;
    private final UnaryCallSettings.Builder<CreateCertificateIssuanceConfigRequest, Operation>
        createCertificateIssuanceConfigSettings;
    private final OperationCallSettings.Builder<
            CreateCertificateIssuanceConfigRequest, CertificateIssuanceConfig, OperationMetadata>
        createCertificateIssuanceConfigOperationSettings;
    private final UnaryCallSettings.Builder<DeleteCertificateIssuanceConfigRequest, Operation>
        deleteCertificateIssuanceConfigSettings;
    private final OperationCallSettings.Builder<
            DeleteCertificateIssuanceConfigRequest, Empty, OperationMetadata>
        deleteCertificateIssuanceConfigOperationSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(10000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listCertificatesSettings = PagedCallSettings.newBuilder(LIST_CERTIFICATES_PAGE_STR_FACT);
      getCertificateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCertificateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCertificateOperationSettings = OperationCallSettings.newBuilder();
      updateCertificateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateCertificateOperationSettings = OperationCallSettings.newBuilder();
      deleteCertificateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteCertificateOperationSettings = OperationCallSettings.newBuilder();
      listCertificateMapsSettings =
          PagedCallSettings.newBuilder(LIST_CERTIFICATE_MAPS_PAGE_STR_FACT);
      getCertificateMapSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCertificateMapSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCertificateMapOperationSettings = OperationCallSettings.newBuilder();
      updateCertificateMapSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateCertificateMapOperationSettings = OperationCallSettings.newBuilder();
      deleteCertificateMapSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteCertificateMapOperationSettings = OperationCallSettings.newBuilder();
      listCertificateMapEntriesSettings =
          PagedCallSettings.newBuilder(LIST_CERTIFICATE_MAP_ENTRIES_PAGE_STR_FACT);
      getCertificateMapEntrySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCertificateMapEntrySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCertificateMapEntryOperationSettings = OperationCallSettings.newBuilder();
      updateCertificateMapEntrySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateCertificateMapEntryOperationSettings = OperationCallSettings.newBuilder();
      deleteCertificateMapEntrySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteCertificateMapEntryOperationSettings = OperationCallSettings.newBuilder();
      listDnsAuthorizationsSettings =
          PagedCallSettings.newBuilder(LIST_DNS_AUTHORIZATIONS_PAGE_STR_FACT);
      getDnsAuthorizationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDnsAuthorizationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDnsAuthorizationOperationSettings = OperationCallSettings.newBuilder();
      updateDnsAuthorizationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDnsAuthorizationOperationSettings = OperationCallSettings.newBuilder();
      deleteDnsAuthorizationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDnsAuthorizationOperationSettings = OperationCallSettings.newBuilder();
      listCertificateIssuanceConfigsSettings =
          PagedCallSettings.newBuilder(LIST_CERTIFICATE_ISSUANCE_CONFIGS_PAGE_STR_FACT);
      getCertificateIssuanceConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCertificateIssuanceConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCertificateIssuanceConfigOperationSettings = OperationCallSettings.newBuilder();
      deleteCertificateIssuanceConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteCertificateIssuanceConfigOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listCertificatesSettings,
              getCertificateSettings,
              createCertificateSettings,
              updateCertificateSettings,
              deleteCertificateSettings,
              listCertificateMapsSettings,
              getCertificateMapSettings,
              createCertificateMapSettings,
              updateCertificateMapSettings,
              deleteCertificateMapSettings,
              listCertificateMapEntriesSettings,
              getCertificateMapEntrySettings,
              createCertificateMapEntrySettings,
              updateCertificateMapEntrySettings,
              deleteCertificateMapEntrySettings,
              listDnsAuthorizationsSettings,
              getDnsAuthorizationSettings,
              createDnsAuthorizationSettings,
              updateDnsAuthorizationSettings,
              deleteDnsAuthorizationSettings,
              listCertificateIssuanceConfigsSettings,
              getCertificateIssuanceConfigSettings,
              createCertificateIssuanceConfigSettings,
              deleteCertificateIssuanceConfigSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(CertificateManagerStubSettings settings) {
      super(settings);

      listCertificatesSettings = settings.listCertificatesSettings.toBuilder();
      getCertificateSettings = settings.getCertificateSettings.toBuilder();
      createCertificateSettings = settings.createCertificateSettings.toBuilder();
      createCertificateOperationSettings = settings.createCertificateOperationSettings.toBuilder();
      updateCertificateSettings = settings.updateCertificateSettings.toBuilder();
      updateCertificateOperationSettings = settings.updateCertificateOperationSettings.toBuilder();
      deleteCertificateSettings = settings.deleteCertificateSettings.toBuilder();
      deleteCertificateOperationSettings = settings.deleteCertificateOperationSettings.toBuilder();
      listCertificateMapsSettings = settings.listCertificateMapsSettings.toBuilder();
      getCertificateMapSettings = settings.getCertificateMapSettings.toBuilder();
      createCertificateMapSettings = settings.createCertificateMapSettings.toBuilder();
      createCertificateMapOperationSettings =
          settings.createCertificateMapOperationSettings.toBuilder();
      updateCertificateMapSettings = settings.updateCertificateMapSettings.toBuilder();
      updateCertificateMapOperationSettings =
          settings.updateCertificateMapOperationSettings.toBuilder();
      deleteCertificateMapSettings = settings.deleteCertificateMapSettings.toBuilder();
      deleteCertificateMapOperationSettings =
          settings.deleteCertificateMapOperationSettings.toBuilder();
      listCertificateMapEntriesSettings = settings.listCertificateMapEntriesSettings.toBuilder();
      getCertificateMapEntrySettings = settings.getCertificateMapEntrySettings.toBuilder();
      createCertificateMapEntrySettings = settings.createCertificateMapEntrySettings.toBuilder();
      createCertificateMapEntryOperationSettings =
          settings.createCertificateMapEntryOperationSettings.toBuilder();
      updateCertificateMapEntrySettings = settings.updateCertificateMapEntrySettings.toBuilder();
      updateCertificateMapEntryOperationSettings =
          settings.updateCertificateMapEntryOperationSettings.toBuilder();
      deleteCertificateMapEntrySettings = settings.deleteCertificateMapEntrySettings.toBuilder();
      deleteCertificateMapEntryOperationSettings =
          settings.deleteCertificateMapEntryOperationSettings.toBuilder();
      listDnsAuthorizationsSettings = settings.listDnsAuthorizationsSettings.toBuilder();
      getDnsAuthorizationSettings = settings.getDnsAuthorizationSettings.toBuilder();
      createDnsAuthorizationSettings = settings.createDnsAuthorizationSettings.toBuilder();
      createDnsAuthorizationOperationSettings =
          settings.createDnsAuthorizationOperationSettings.toBuilder();
      updateDnsAuthorizationSettings = settings.updateDnsAuthorizationSettings.toBuilder();
      updateDnsAuthorizationOperationSettings =
          settings.updateDnsAuthorizationOperationSettings.toBuilder();
      deleteDnsAuthorizationSettings = settings.deleteDnsAuthorizationSettings.toBuilder();
      deleteDnsAuthorizationOperationSettings =
          settings.deleteDnsAuthorizationOperationSettings.toBuilder();
      listCertificateIssuanceConfigsSettings =
          settings.listCertificateIssuanceConfigsSettings.toBuilder();
      getCertificateIssuanceConfigSettings =
          settings.getCertificateIssuanceConfigSettings.toBuilder();
      createCertificateIssuanceConfigSettings =
          settings.createCertificateIssuanceConfigSettings.toBuilder();
      createCertificateIssuanceConfigOperationSettings =
          settings.createCertificateIssuanceConfigOperationSettings.toBuilder();
      deleteCertificateIssuanceConfigSettings =
          settings.deleteCertificateIssuanceConfigSettings.toBuilder();
      deleteCertificateIssuanceConfigOperationSettings =
          settings.deleteCertificateIssuanceConfigOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listCertificatesSettings,
              getCertificateSettings,
              createCertificateSettings,
              updateCertificateSettings,
              deleteCertificateSettings,
              listCertificateMapsSettings,
              getCertificateMapSettings,
              createCertificateMapSettings,
              updateCertificateMapSettings,
              deleteCertificateMapSettings,
              listCertificateMapEntriesSettings,
              getCertificateMapEntrySettings,
              createCertificateMapEntrySettings,
              updateCertificateMapEntrySettings,
              deleteCertificateMapEntrySettings,
              listDnsAuthorizationsSettings,
              getDnsAuthorizationSettings,
              createDnsAuthorizationSettings,
              updateDnsAuthorizationSettings,
              deleteDnsAuthorizationSettings,
              listCertificateIssuanceConfigsSettings,
              getCertificateIssuanceConfigSettings,
              createCertificateIssuanceConfigSettings,
              deleteCertificateIssuanceConfigSettings,
              listLocationsSettings,
              getLocationSettings);
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
          .listCertificatesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getCertificateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createCertificateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateCertificateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteCertificateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listCertificateMapsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getCertificateMapSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createCertificateMapSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateCertificateMapSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteCertificateMapSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listCertificateMapEntriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getCertificateMapEntrySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createCertificateMapEntrySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateCertificateMapEntrySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteCertificateMapEntrySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listDnsAuthorizationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getDnsAuthorizationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createDnsAuthorizationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateDnsAuthorizationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteDnsAuthorizationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listCertificateIssuanceConfigsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getCertificateIssuanceConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createCertificateIssuanceConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteCertificateIssuanceConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createCertificateOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateCertificateRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Certificate.class))
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
          .updateCertificateOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateCertificateRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Certificate.class))
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
          .deleteCertificateOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteCertificateRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .createCertificateMapOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateCertificateMapRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(CertificateMap.class))
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
          .updateCertificateMapOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateCertificateMapRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(CertificateMap.class))
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
          .deleteCertificateMapOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteCertificateMapRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .createCertificateMapEntryOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateCertificateMapEntryRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(CertificateMapEntry.class))
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
          .updateCertificateMapEntryOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateCertificateMapEntryRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(CertificateMapEntry.class))
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
          .deleteCertificateMapEntryOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteCertificateMapEntryRequest, OperationSnapshot>
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
          .createDnsAuthorizationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateDnsAuthorizationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DnsAuthorization.class))
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
          .updateDnsAuthorizationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateDnsAuthorizationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DnsAuthorization.class))
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
          .deleteDnsAuthorizationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteDnsAuthorizationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .createCertificateIssuanceConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateCertificateIssuanceConfigRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  CertificateIssuanceConfig.class))
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
          .deleteCertificateIssuanceConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteCertificateIssuanceConfigRequest, OperationSnapshot>
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

    /** Returns the builder for the settings used for calls to listCertificates. */
    public PagedCallSettings.Builder<
            ListCertificatesRequest, ListCertificatesResponse, ListCertificatesPagedResponse>
        listCertificatesSettings() {
      return listCertificatesSettings;
    }

    /** Returns the builder for the settings used for calls to getCertificate. */
    public UnaryCallSettings.Builder<GetCertificateRequest, Certificate> getCertificateSettings() {
      return getCertificateSettings;
    }

    /** Returns the builder for the settings used for calls to createCertificate. */
    public UnaryCallSettings.Builder<CreateCertificateRequest, Operation>
        createCertificateSettings() {
      return createCertificateSettings;
    }

    /** Returns the builder for the settings used for calls to createCertificate. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateCertificateRequest, Certificate, OperationMetadata>
        createCertificateOperationSettings() {
      return createCertificateOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateCertificate. */
    public UnaryCallSettings.Builder<UpdateCertificateRequest, Operation>
        updateCertificateSettings() {
      return updateCertificateSettings;
    }

    /** Returns the builder for the settings used for calls to updateCertificate. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateCertificateRequest, Certificate, OperationMetadata>
        updateCertificateOperationSettings() {
      return updateCertificateOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCertificate. */
    public UnaryCallSettings.Builder<DeleteCertificateRequest, Operation>
        deleteCertificateSettings() {
      return deleteCertificateSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCertificate. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteCertificateRequest, Empty, OperationMetadata>
        deleteCertificateOperationSettings() {
      return deleteCertificateOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listCertificateMaps. */
    public PagedCallSettings.Builder<
            ListCertificateMapsRequest,
            ListCertificateMapsResponse,
            ListCertificateMapsPagedResponse>
        listCertificateMapsSettings() {
      return listCertificateMapsSettings;
    }

    /** Returns the builder for the settings used for calls to getCertificateMap. */
    public UnaryCallSettings.Builder<GetCertificateMapRequest, CertificateMap>
        getCertificateMapSettings() {
      return getCertificateMapSettings;
    }

    /** Returns the builder for the settings used for calls to createCertificateMap. */
    public UnaryCallSettings.Builder<CreateCertificateMapRequest, Operation>
        createCertificateMapSettings() {
      return createCertificateMapSettings;
    }

    /** Returns the builder for the settings used for calls to createCertificateMap. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateCertificateMapRequest, CertificateMap, OperationMetadata>
        createCertificateMapOperationSettings() {
      return createCertificateMapOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateCertificateMap. */
    public UnaryCallSettings.Builder<UpdateCertificateMapRequest, Operation>
        updateCertificateMapSettings() {
      return updateCertificateMapSettings;
    }

    /** Returns the builder for the settings used for calls to updateCertificateMap. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            UpdateCertificateMapRequest, CertificateMap, OperationMetadata>
        updateCertificateMapOperationSettings() {
      return updateCertificateMapOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCertificateMap. */
    public UnaryCallSettings.Builder<DeleteCertificateMapRequest, Operation>
        deleteCertificateMapSettings() {
      return deleteCertificateMapSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCertificateMap. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteCertificateMapRequest, Empty, OperationMetadata>
        deleteCertificateMapOperationSettings() {
      return deleteCertificateMapOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listCertificateMapEntries. */
    public PagedCallSettings.Builder<
            ListCertificateMapEntriesRequest,
            ListCertificateMapEntriesResponse,
            ListCertificateMapEntriesPagedResponse>
        listCertificateMapEntriesSettings() {
      return listCertificateMapEntriesSettings;
    }

    /** Returns the builder for the settings used for calls to getCertificateMapEntry. */
    public UnaryCallSettings.Builder<GetCertificateMapEntryRequest, CertificateMapEntry>
        getCertificateMapEntrySettings() {
      return getCertificateMapEntrySettings;
    }

    /** Returns the builder for the settings used for calls to createCertificateMapEntry. */
    public UnaryCallSettings.Builder<CreateCertificateMapEntryRequest, Operation>
        createCertificateMapEntrySettings() {
      return createCertificateMapEntrySettings;
    }

    /** Returns the builder for the settings used for calls to createCertificateMapEntry. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateCertificateMapEntryRequest, CertificateMapEntry, OperationMetadata>
        createCertificateMapEntryOperationSettings() {
      return createCertificateMapEntryOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateCertificateMapEntry. */
    public UnaryCallSettings.Builder<UpdateCertificateMapEntryRequest, Operation>
        updateCertificateMapEntrySettings() {
      return updateCertificateMapEntrySettings;
    }

    /** Returns the builder for the settings used for calls to updateCertificateMapEntry. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            UpdateCertificateMapEntryRequest, CertificateMapEntry, OperationMetadata>
        updateCertificateMapEntryOperationSettings() {
      return updateCertificateMapEntryOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCertificateMapEntry. */
    public UnaryCallSettings.Builder<DeleteCertificateMapEntryRequest, Operation>
        deleteCertificateMapEntrySettings() {
      return deleteCertificateMapEntrySettings;
    }

    /** Returns the builder for the settings used for calls to deleteCertificateMapEntry. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteCertificateMapEntryRequest, Empty, OperationMetadata>
        deleteCertificateMapEntryOperationSettings() {
      return deleteCertificateMapEntryOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listDnsAuthorizations. */
    public PagedCallSettings.Builder<
            ListDnsAuthorizationsRequest,
            ListDnsAuthorizationsResponse,
            ListDnsAuthorizationsPagedResponse>
        listDnsAuthorizationsSettings() {
      return listDnsAuthorizationsSettings;
    }

    /** Returns the builder for the settings used for calls to getDnsAuthorization. */
    public UnaryCallSettings.Builder<GetDnsAuthorizationRequest, DnsAuthorization>
        getDnsAuthorizationSettings() {
      return getDnsAuthorizationSettings;
    }

    /** Returns the builder for the settings used for calls to createDnsAuthorization. */
    public UnaryCallSettings.Builder<CreateDnsAuthorizationRequest, Operation>
        createDnsAuthorizationSettings() {
      return createDnsAuthorizationSettings;
    }

    /** Returns the builder for the settings used for calls to createDnsAuthorization. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateDnsAuthorizationRequest, DnsAuthorization, OperationMetadata>
        createDnsAuthorizationOperationSettings() {
      return createDnsAuthorizationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateDnsAuthorization. */
    public UnaryCallSettings.Builder<UpdateDnsAuthorizationRequest, Operation>
        updateDnsAuthorizationSettings() {
      return updateDnsAuthorizationSettings;
    }

    /** Returns the builder for the settings used for calls to updateDnsAuthorization. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            UpdateDnsAuthorizationRequest, DnsAuthorization, OperationMetadata>
        updateDnsAuthorizationOperationSettings() {
      return updateDnsAuthorizationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDnsAuthorization. */
    public UnaryCallSettings.Builder<DeleteDnsAuthorizationRequest, Operation>
        deleteDnsAuthorizationSettings() {
      return deleteDnsAuthorizationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDnsAuthorization. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteDnsAuthorizationRequest, Empty, OperationMetadata>
        deleteDnsAuthorizationOperationSettings() {
      return deleteDnsAuthorizationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listCertificateIssuanceConfigs. */
    public PagedCallSettings.Builder<
            ListCertificateIssuanceConfigsRequest,
            ListCertificateIssuanceConfigsResponse,
            ListCertificateIssuanceConfigsPagedResponse>
        listCertificateIssuanceConfigsSettings() {
      return listCertificateIssuanceConfigsSettings;
    }

    /** Returns the builder for the settings used for calls to getCertificateIssuanceConfig. */
    public UnaryCallSettings.Builder<GetCertificateIssuanceConfigRequest, CertificateIssuanceConfig>
        getCertificateIssuanceConfigSettings() {
      return getCertificateIssuanceConfigSettings;
    }

    /** Returns the builder for the settings used for calls to createCertificateIssuanceConfig. */
    public UnaryCallSettings.Builder<CreateCertificateIssuanceConfigRequest, Operation>
        createCertificateIssuanceConfigSettings() {
      return createCertificateIssuanceConfigSettings;
    }

    /** Returns the builder for the settings used for calls to createCertificateIssuanceConfig. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateCertificateIssuanceConfigRequest, CertificateIssuanceConfig, OperationMetadata>
        createCertificateIssuanceConfigOperationSettings() {
      return createCertificateIssuanceConfigOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCertificateIssuanceConfig. */
    public UnaryCallSettings.Builder<DeleteCertificateIssuanceConfigRequest, Operation>
        deleteCertificateIssuanceConfigSettings() {
      return deleteCertificateIssuanceConfigSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCertificateIssuanceConfig. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            DeleteCertificateIssuanceConfigRequest, Empty, OperationMetadata>
        deleteCertificateIssuanceConfigOperationSettings() {
      return deleteCertificateIssuanceConfigOperationSettings;
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

    @Override
    public CertificateManagerStubSettings build() throws IOException {
      return new CertificateManagerStubSettings(this);
    }
  }
}
