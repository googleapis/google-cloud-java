/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.kms.v1.stub;

import static com.google.cloud.kms.v1.KeyManagementServiceClient.ListCryptoKeyVersionsPagedResponse;
import static com.google.cloud.kms.v1.KeyManagementServiceClient.ListCryptoKeysPagedResponse;
import static com.google.cloud.kms.v1.KeyManagementServiceClient.ListImportJobsPagedResponse;
import static com.google.cloud.kms.v1.KeyManagementServiceClient.ListKeyRingsPagedResponse;
import static com.google.cloud.kms.v1.KeyManagementServiceClient.ListLocationsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.kms.v1.AsymmetricDecryptRequest;
import com.google.cloud.kms.v1.AsymmetricDecryptResponse;
import com.google.cloud.kms.v1.AsymmetricSignRequest;
import com.google.cloud.kms.v1.AsymmetricSignResponse;
import com.google.cloud.kms.v1.CreateCryptoKeyRequest;
import com.google.cloud.kms.v1.CreateCryptoKeyVersionRequest;
import com.google.cloud.kms.v1.CreateImportJobRequest;
import com.google.cloud.kms.v1.CreateKeyRingRequest;
import com.google.cloud.kms.v1.CryptoKey;
import com.google.cloud.kms.v1.CryptoKeyVersion;
import com.google.cloud.kms.v1.DecapsulateRequest;
import com.google.cloud.kms.v1.DecapsulateResponse;
import com.google.cloud.kms.v1.DecryptRequest;
import com.google.cloud.kms.v1.DecryptResponse;
import com.google.cloud.kms.v1.DestroyCryptoKeyVersionRequest;
import com.google.cloud.kms.v1.EncryptRequest;
import com.google.cloud.kms.v1.EncryptResponse;
import com.google.cloud.kms.v1.GenerateRandomBytesRequest;
import com.google.cloud.kms.v1.GenerateRandomBytesResponse;
import com.google.cloud.kms.v1.GetCryptoKeyRequest;
import com.google.cloud.kms.v1.GetCryptoKeyVersionRequest;
import com.google.cloud.kms.v1.GetImportJobRequest;
import com.google.cloud.kms.v1.GetKeyRingRequest;
import com.google.cloud.kms.v1.GetPublicKeyRequest;
import com.google.cloud.kms.v1.ImportCryptoKeyVersionRequest;
import com.google.cloud.kms.v1.ImportJob;
import com.google.cloud.kms.v1.KeyRing;
import com.google.cloud.kms.v1.ListCryptoKeyVersionsRequest;
import com.google.cloud.kms.v1.ListCryptoKeyVersionsResponse;
import com.google.cloud.kms.v1.ListCryptoKeysRequest;
import com.google.cloud.kms.v1.ListCryptoKeysResponse;
import com.google.cloud.kms.v1.ListImportJobsRequest;
import com.google.cloud.kms.v1.ListImportJobsResponse;
import com.google.cloud.kms.v1.ListKeyRingsRequest;
import com.google.cloud.kms.v1.ListKeyRingsResponse;
import com.google.cloud.kms.v1.MacSignRequest;
import com.google.cloud.kms.v1.MacSignResponse;
import com.google.cloud.kms.v1.MacVerifyRequest;
import com.google.cloud.kms.v1.MacVerifyResponse;
import com.google.cloud.kms.v1.PublicKey;
import com.google.cloud.kms.v1.RawDecryptRequest;
import com.google.cloud.kms.v1.RawDecryptResponse;
import com.google.cloud.kms.v1.RawEncryptRequest;
import com.google.cloud.kms.v1.RawEncryptResponse;
import com.google.cloud.kms.v1.RestoreCryptoKeyVersionRequest;
import com.google.cloud.kms.v1.UpdateCryptoKeyPrimaryVersionRequest;
import com.google.cloud.kms.v1.UpdateCryptoKeyRequest;
import com.google.cloud.kms.v1.UpdateCryptoKeyVersionRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link KeyManagementServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudkms.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getKeyRing:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * KeyManagementServiceStubSettings.Builder keyManagementServiceSettingsBuilder =
 *     KeyManagementServiceStubSettings.newBuilder();
 * keyManagementServiceSettingsBuilder
 *     .getKeyRingSettings()
 *     .setRetrySettings(
 *         keyManagementServiceSettingsBuilder
 *             .getKeyRingSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * KeyManagementServiceStubSettings keyManagementServiceSettings =
 *     keyManagementServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class KeyManagementServiceStubSettings
    extends StubSettings<KeyManagementServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/cloudkms")
          .build();

  private final PagedCallSettings<
          ListKeyRingsRequest, ListKeyRingsResponse, ListKeyRingsPagedResponse>
      listKeyRingsSettings;
  private final PagedCallSettings<
          ListCryptoKeysRequest, ListCryptoKeysResponse, ListCryptoKeysPagedResponse>
      listCryptoKeysSettings;
  private final PagedCallSettings<
          ListCryptoKeyVersionsRequest,
          ListCryptoKeyVersionsResponse,
          ListCryptoKeyVersionsPagedResponse>
      listCryptoKeyVersionsSettings;
  private final PagedCallSettings<
          ListImportJobsRequest, ListImportJobsResponse, ListImportJobsPagedResponse>
      listImportJobsSettings;
  private final UnaryCallSettings<GetKeyRingRequest, KeyRing> getKeyRingSettings;
  private final UnaryCallSettings<GetCryptoKeyRequest, CryptoKey> getCryptoKeySettings;
  private final UnaryCallSettings<GetCryptoKeyVersionRequest, CryptoKeyVersion>
      getCryptoKeyVersionSettings;
  private final UnaryCallSettings<GetPublicKeyRequest, PublicKey> getPublicKeySettings;
  private final UnaryCallSettings<GetImportJobRequest, ImportJob> getImportJobSettings;
  private final UnaryCallSettings<CreateKeyRingRequest, KeyRing> createKeyRingSettings;
  private final UnaryCallSettings<CreateCryptoKeyRequest, CryptoKey> createCryptoKeySettings;
  private final UnaryCallSettings<CreateCryptoKeyVersionRequest, CryptoKeyVersion>
      createCryptoKeyVersionSettings;
  private final UnaryCallSettings<ImportCryptoKeyVersionRequest, CryptoKeyVersion>
      importCryptoKeyVersionSettings;
  private final UnaryCallSettings<CreateImportJobRequest, ImportJob> createImportJobSettings;
  private final UnaryCallSettings<UpdateCryptoKeyRequest, CryptoKey> updateCryptoKeySettings;
  private final UnaryCallSettings<UpdateCryptoKeyVersionRequest, CryptoKeyVersion>
      updateCryptoKeyVersionSettings;
  private final UnaryCallSettings<UpdateCryptoKeyPrimaryVersionRequest, CryptoKey>
      updateCryptoKeyPrimaryVersionSettings;
  private final UnaryCallSettings<DestroyCryptoKeyVersionRequest, CryptoKeyVersion>
      destroyCryptoKeyVersionSettings;
  private final UnaryCallSettings<RestoreCryptoKeyVersionRequest, CryptoKeyVersion>
      restoreCryptoKeyVersionSettings;
  private final UnaryCallSettings<EncryptRequest, EncryptResponse> encryptSettings;
  private final UnaryCallSettings<DecryptRequest, DecryptResponse> decryptSettings;
  private final UnaryCallSettings<RawEncryptRequest, RawEncryptResponse> rawEncryptSettings;
  private final UnaryCallSettings<RawDecryptRequest, RawDecryptResponse> rawDecryptSettings;
  private final UnaryCallSettings<AsymmetricSignRequest, AsymmetricSignResponse>
      asymmetricSignSettings;
  private final UnaryCallSettings<AsymmetricDecryptRequest, AsymmetricDecryptResponse>
      asymmetricDecryptSettings;
  private final UnaryCallSettings<MacSignRequest, MacSignResponse> macSignSettings;
  private final UnaryCallSettings<MacVerifyRequest, MacVerifyResponse> macVerifySettings;
  private final UnaryCallSettings<DecapsulateRequest, DecapsulateResponse> decapsulateSettings;
  private final UnaryCallSettings<GenerateRandomBytesRequest, GenerateRandomBytesResponse>
      generateRandomBytesSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<ListKeyRingsRequest, ListKeyRingsResponse, KeyRing>
      LIST_KEY_RINGS_PAGE_STR_DESC =
          new PagedListDescriptor<ListKeyRingsRequest, ListKeyRingsResponse, KeyRing>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListKeyRingsRequest injectToken(ListKeyRingsRequest payload, String token) {
              return ListKeyRingsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListKeyRingsRequest injectPageSize(ListKeyRingsRequest payload, int pageSize) {
              return ListKeyRingsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListKeyRingsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListKeyRingsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<KeyRing> extractResources(ListKeyRingsResponse payload) {
              return payload.getKeyRingsList();
            }
          };

  private static final PagedListDescriptor<ListCryptoKeysRequest, ListCryptoKeysResponse, CryptoKey>
      LIST_CRYPTO_KEYS_PAGE_STR_DESC =
          new PagedListDescriptor<ListCryptoKeysRequest, ListCryptoKeysResponse, CryptoKey>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCryptoKeysRequest injectToken(ListCryptoKeysRequest payload, String token) {
              return ListCryptoKeysRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListCryptoKeysRequest injectPageSize(
                ListCryptoKeysRequest payload, int pageSize) {
              return ListCryptoKeysRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListCryptoKeysRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCryptoKeysResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<CryptoKey> extractResources(ListCryptoKeysResponse payload) {
              return payload.getCryptoKeysList();
            }
          };

  private static final PagedListDescriptor<
          ListCryptoKeyVersionsRequest, ListCryptoKeyVersionsResponse, CryptoKeyVersion>
      LIST_CRYPTO_KEY_VERSIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListCryptoKeyVersionsRequest, ListCryptoKeyVersionsResponse, CryptoKeyVersion>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCryptoKeyVersionsRequest injectToken(
                ListCryptoKeyVersionsRequest payload, String token) {
              return ListCryptoKeyVersionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListCryptoKeyVersionsRequest injectPageSize(
                ListCryptoKeyVersionsRequest payload, int pageSize) {
              return ListCryptoKeyVersionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListCryptoKeyVersionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCryptoKeyVersionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<CryptoKeyVersion> extractResources(
                ListCryptoKeyVersionsResponse payload) {
              return payload.getCryptoKeyVersionsList();
            }
          };

  private static final PagedListDescriptor<ListImportJobsRequest, ListImportJobsResponse, ImportJob>
      LIST_IMPORT_JOBS_PAGE_STR_DESC =
          new PagedListDescriptor<ListImportJobsRequest, ListImportJobsResponse, ImportJob>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListImportJobsRequest injectToken(ListImportJobsRequest payload, String token) {
              return ListImportJobsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListImportJobsRequest injectPageSize(
                ListImportJobsRequest payload, int pageSize) {
              return ListImportJobsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListImportJobsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListImportJobsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ImportJob> extractResources(ListImportJobsResponse payload) {
              return payload.getImportJobsList();
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
              return payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListKeyRingsRequest, ListKeyRingsResponse, ListKeyRingsPagedResponse>
      LIST_KEY_RINGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListKeyRingsRequest, ListKeyRingsResponse, ListKeyRingsPagedResponse>() {
            @Override
            public ApiFuture<ListKeyRingsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListKeyRingsRequest, ListKeyRingsResponse> callable,
                ListKeyRingsRequest request,
                ApiCallContext context,
                ApiFuture<ListKeyRingsResponse> futureResponse) {
              PageContext<ListKeyRingsRequest, ListKeyRingsResponse, KeyRing> pageContext =
                  PageContext.create(callable, LIST_KEY_RINGS_PAGE_STR_DESC, request, context);
              return ListKeyRingsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListCryptoKeysRequest, ListCryptoKeysResponse, ListCryptoKeysPagedResponse>
      LIST_CRYPTO_KEYS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCryptoKeysRequest, ListCryptoKeysResponse, ListCryptoKeysPagedResponse>() {
            @Override
            public ApiFuture<ListCryptoKeysPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCryptoKeysRequest, ListCryptoKeysResponse> callable,
                ListCryptoKeysRequest request,
                ApiCallContext context,
                ApiFuture<ListCryptoKeysResponse> futureResponse) {
              PageContext<ListCryptoKeysRequest, ListCryptoKeysResponse, CryptoKey> pageContext =
                  PageContext.create(callable, LIST_CRYPTO_KEYS_PAGE_STR_DESC, request, context);
              return ListCryptoKeysPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListCryptoKeyVersionsRequest,
          ListCryptoKeyVersionsResponse,
          ListCryptoKeyVersionsPagedResponse>
      LIST_CRYPTO_KEY_VERSIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCryptoKeyVersionsRequest,
              ListCryptoKeyVersionsResponse,
              ListCryptoKeyVersionsPagedResponse>() {
            @Override
            public ApiFuture<ListCryptoKeyVersionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCryptoKeyVersionsRequest, ListCryptoKeyVersionsResponse> callable,
                ListCryptoKeyVersionsRequest request,
                ApiCallContext context,
                ApiFuture<ListCryptoKeyVersionsResponse> futureResponse) {
              PageContext<
                      ListCryptoKeyVersionsRequest, ListCryptoKeyVersionsResponse, CryptoKeyVersion>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CRYPTO_KEY_VERSIONS_PAGE_STR_DESC, request, context);
              return ListCryptoKeyVersionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListImportJobsRequest, ListImportJobsResponse, ListImportJobsPagedResponse>
      LIST_IMPORT_JOBS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListImportJobsRequest, ListImportJobsResponse, ListImportJobsPagedResponse>() {
            @Override
            public ApiFuture<ListImportJobsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListImportJobsRequest, ListImportJobsResponse> callable,
                ListImportJobsRequest request,
                ApiCallContext context,
                ApiFuture<ListImportJobsResponse> futureResponse) {
              PageContext<ListImportJobsRequest, ListImportJobsResponse, ImportJob> pageContext =
                  PageContext.create(callable, LIST_IMPORT_JOBS_PAGE_STR_DESC, request, context);
              return ListImportJobsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listKeyRings. */
  public PagedCallSettings<ListKeyRingsRequest, ListKeyRingsResponse, ListKeyRingsPagedResponse>
      listKeyRingsSettings() {
    return listKeyRingsSettings;
  }

  /** Returns the object with the settings used for calls to listCryptoKeys. */
  public PagedCallSettings<
          ListCryptoKeysRequest, ListCryptoKeysResponse, ListCryptoKeysPagedResponse>
      listCryptoKeysSettings() {
    return listCryptoKeysSettings;
  }

  /** Returns the object with the settings used for calls to listCryptoKeyVersions. */
  public PagedCallSettings<
          ListCryptoKeyVersionsRequest,
          ListCryptoKeyVersionsResponse,
          ListCryptoKeyVersionsPagedResponse>
      listCryptoKeyVersionsSettings() {
    return listCryptoKeyVersionsSettings;
  }

  /** Returns the object with the settings used for calls to listImportJobs. */
  public PagedCallSettings<
          ListImportJobsRequest, ListImportJobsResponse, ListImportJobsPagedResponse>
      listImportJobsSettings() {
    return listImportJobsSettings;
  }

  /** Returns the object with the settings used for calls to getKeyRing. */
  public UnaryCallSettings<GetKeyRingRequest, KeyRing> getKeyRingSettings() {
    return getKeyRingSettings;
  }

  /** Returns the object with the settings used for calls to getCryptoKey. */
  public UnaryCallSettings<GetCryptoKeyRequest, CryptoKey> getCryptoKeySettings() {
    return getCryptoKeySettings;
  }

  /** Returns the object with the settings used for calls to getCryptoKeyVersion. */
  public UnaryCallSettings<GetCryptoKeyVersionRequest, CryptoKeyVersion>
      getCryptoKeyVersionSettings() {
    return getCryptoKeyVersionSettings;
  }

  /** Returns the object with the settings used for calls to getPublicKey. */
  public UnaryCallSettings<GetPublicKeyRequest, PublicKey> getPublicKeySettings() {
    return getPublicKeySettings;
  }

  /** Returns the object with the settings used for calls to getImportJob. */
  public UnaryCallSettings<GetImportJobRequest, ImportJob> getImportJobSettings() {
    return getImportJobSettings;
  }

  /** Returns the object with the settings used for calls to createKeyRing. */
  public UnaryCallSettings<CreateKeyRingRequest, KeyRing> createKeyRingSettings() {
    return createKeyRingSettings;
  }

  /** Returns the object with the settings used for calls to createCryptoKey. */
  public UnaryCallSettings<CreateCryptoKeyRequest, CryptoKey> createCryptoKeySettings() {
    return createCryptoKeySettings;
  }

  /** Returns the object with the settings used for calls to createCryptoKeyVersion. */
  public UnaryCallSettings<CreateCryptoKeyVersionRequest, CryptoKeyVersion>
      createCryptoKeyVersionSettings() {
    return createCryptoKeyVersionSettings;
  }

  /** Returns the object with the settings used for calls to importCryptoKeyVersion. */
  public UnaryCallSettings<ImportCryptoKeyVersionRequest, CryptoKeyVersion>
      importCryptoKeyVersionSettings() {
    return importCryptoKeyVersionSettings;
  }

  /** Returns the object with the settings used for calls to createImportJob. */
  public UnaryCallSettings<CreateImportJobRequest, ImportJob> createImportJobSettings() {
    return createImportJobSettings;
  }

  /** Returns the object with the settings used for calls to updateCryptoKey. */
  public UnaryCallSettings<UpdateCryptoKeyRequest, CryptoKey> updateCryptoKeySettings() {
    return updateCryptoKeySettings;
  }

  /** Returns the object with the settings used for calls to updateCryptoKeyVersion. */
  public UnaryCallSettings<UpdateCryptoKeyVersionRequest, CryptoKeyVersion>
      updateCryptoKeyVersionSettings() {
    return updateCryptoKeyVersionSettings;
  }

  /** Returns the object with the settings used for calls to updateCryptoKeyPrimaryVersion. */
  public UnaryCallSettings<UpdateCryptoKeyPrimaryVersionRequest, CryptoKey>
      updateCryptoKeyPrimaryVersionSettings() {
    return updateCryptoKeyPrimaryVersionSettings;
  }

  /** Returns the object with the settings used for calls to destroyCryptoKeyVersion. */
  public UnaryCallSettings<DestroyCryptoKeyVersionRequest, CryptoKeyVersion>
      destroyCryptoKeyVersionSettings() {
    return destroyCryptoKeyVersionSettings;
  }

  /** Returns the object with the settings used for calls to restoreCryptoKeyVersion. */
  public UnaryCallSettings<RestoreCryptoKeyVersionRequest, CryptoKeyVersion>
      restoreCryptoKeyVersionSettings() {
    return restoreCryptoKeyVersionSettings;
  }

  /** Returns the object with the settings used for calls to encrypt. */
  public UnaryCallSettings<EncryptRequest, EncryptResponse> encryptSettings() {
    return encryptSettings;
  }

  /** Returns the object with the settings used for calls to decrypt. */
  public UnaryCallSettings<DecryptRequest, DecryptResponse> decryptSettings() {
    return decryptSettings;
  }

  /** Returns the object with the settings used for calls to rawEncrypt. */
  public UnaryCallSettings<RawEncryptRequest, RawEncryptResponse> rawEncryptSettings() {
    return rawEncryptSettings;
  }

  /** Returns the object with the settings used for calls to rawDecrypt. */
  public UnaryCallSettings<RawDecryptRequest, RawDecryptResponse> rawDecryptSettings() {
    return rawDecryptSettings;
  }

  /** Returns the object with the settings used for calls to asymmetricSign. */
  public UnaryCallSettings<AsymmetricSignRequest, AsymmetricSignResponse> asymmetricSignSettings() {
    return asymmetricSignSettings;
  }

  /** Returns the object with the settings used for calls to asymmetricDecrypt. */
  public UnaryCallSettings<AsymmetricDecryptRequest, AsymmetricDecryptResponse>
      asymmetricDecryptSettings() {
    return asymmetricDecryptSettings;
  }

  /** Returns the object with the settings used for calls to macSign. */
  public UnaryCallSettings<MacSignRequest, MacSignResponse> macSignSettings() {
    return macSignSettings;
  }

  /** Returns the object with the settings used for calls to macVerify. */
  public UnaryCallSettings<MacVerifyRequest, MacVerifyResponse> macVerifySettings() {
    return macVerifySettings;
  }

  /** Returns the object with the settings used for calls to decapsulate. */
  public UnaryCallSettings<DecapsulateRequest, DecapsulateResponse> decapsulateSettings() {
    return decapsulateSettings;
  }

  /** Returns the object with the settings used for calls to generateRandomBytes. */
  public UnaryCallSettings<GenerateRandomBytesRequest, GenerateRandomBytesResponse>
      generateRandomBytesSettings() {
    return generateRandomBytesSettings;
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

  public KeyManagementServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcKeyManagementServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonKeyManagementServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "cloudkms";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "cloudkms.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "cloudkms.mtls.googleapis.com:443";
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

  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(KeyManagementServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(KeyManagementServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return KeyManagementServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected KeyManagementServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listKeyRingsSettings = settingsBuilder.listKeyRingsSettings().build();
    listCryptoKeysSettings = settingsBuilder.listCryptoKeysSettings().build();
    listCryptoKeyVersionsSettings = settingsBuilder.listCryptoKeyVersionsSettings().build();
    listImportJobsSettings = settingsBuilder.listImportJobsSettings().build();
    getKeyRingSettings = settingsBuilder.getKeyRingSettings().build();
    getCryptoKeySettings = settingsBuilder.getCryptoKeySettings().build();
    getCryptoKeyVersionSettings = settingsBuilder.getCryptoKeyVersionSettings().build();
    getPublicKeySettings = settingsBuilder.getPublicKeySettings().build();
    getImportJobSettings = settingsBuilder.getImportJobSettings().build();
    createKeyRingSettings = settingsBuilder.createKeyRingSettings().build();
    createCryptoKeySettings = settingsBuilder.createCryptoKeySettings().build();
    createCryptoKeyVersionSettings = settingsBuilder.createCryptoKeyVersionSettings().build();
    importCryptoKeyVersionSettings = settingsBuilder.importCryptoKeyVersionSettings().build();
    createImportJobSettings = settingsBuilder.createImportJobSettings().build();
    updateCryptoKeySettings = settingsBuilder.updateCryptoKeySettings().build();
    updateCryptoKeyVersionSettings = settingsBuilder.updateCryptoKeyVersionSettings().build();
    updateCryptoKeyPrimaryVersionSettings =
        settingsBuilder.updateCryptoKeyPrimaryVersionSettings().build();
    destroyCryptoKeyVersionSettings = settingsBuilder.destroyCryptoKeyVersionSettings().build();
    restoreCryptoKeyVersionSettings = settingsBuilder.restoreCryptoKeyVersionSettings().build();
    encryptSettings = settingsBuilder.encryptSettings().build();
    decryptSettings = settingsBuilder.decryptSettings().build();
    rawEncryptSettings = settingsBuilder.rawEncryptSettings().build();
    rawDecryptSettings = settingsBuilder.rawDecryptSettings().build();
    asymmetricSignSettings = settingsBuilder.asymmetricSignSettings().build();
    asymmetricDecryptSettings = settingsBuilder.asymmetricDecryptSettings().build();
    macSignSettings = settingsBuilder.macSignSettings().build();
    macVerifySettings = settingsBuilder.macVerifySettings().build();
    decapsulateSettings = settingsBuilder.decapsulateSettings().build();
    generateRandomBytesSettings = settingsBuilder.generateRandomBytesSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for KeyManagementServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<KeyManagementServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListKeyRingsRequest, ListKeyRingsResponse, ListKeyRingsPagedResponse>
        listKeyRingsSettings;
    private final PagedCallSettings.Builder<
            ListCryptoKeysRequest, ListCryptoKeysResponse, ListCryptoKeysPagedResponse>
        listCryptoKeysSettings;
    private final PagedCallSettings.Builder<
            ListCryptoKeyVersionsRequest,
            ListCryptoKeyVersionsResponse,
            ListCryptoKeyVersionsPagedResponse>
        listCryptoKeyVersionsSettings;
    private final PagedCallSettings.Builder<
            ListImportJobsRequest, ListImportJobsResponse, ListImportJobsPagedResponse>
        listImportJobsSettings;
    private final UnaryCallSettings.Builder<GetKeyRingRequest, KeyRing> getKeyRingSettings;
    private final UnaryCallSettings.Builder<GetCryptoKeyRequest, CryptoKey> getCryptoKeySettings;
    private final UnaryCallSettings.Builder<GetCryptoKeyVersionRequest, CryptoKeyVersion>
        getCryptoKeyVersionSettings;
    private final UnaryCallSettings.Builder<GetPublicKeyRequest, PublicKey> getPublicKeySettings;
    private final UnaryCallSettings.Builder<GetImportJobRequest, ImportJob> getImportJobSettings;
    private final UnaryCallSettings.Builder<CreateKeyRingRequest, KeyRing> createKeyRingSettings;
    private final UnaryCallSettings.Builder<CreateCryptoKeyRequest, CryptoKey>
        createCryptoKeySettings;
    private final UnaryCallSettings.Builder<CreateCryptoKeyVersionRequest, CryptoKeyVersion>
        createCryptoKeyVersionSettings;
    private final UnaryCallSettings.Builder<ImportCryptoKeyVersionRequest, CryptoKeyVersion>
        importCryptoKeyVersionSettings;
    private final UnaryCallSettings.Builder<CreateImportJobRequest, ImportJob>
        createImportJobSettings;
    private final UnaryCallSettings.Builder<UpdateCryptoKeyRequest, CryptoKey>
        updateCryptoKeySettings;
    private final UnaryCallSettings.Builder<UpdateCryptoKeyVersionRequest, CryptoKeyVersion>
        updateCryptoKeyVersionSettings;
    private final UnaryCallSettings.Builder<UpdateCryptoKeyPrimaryVersionRequest, CryptoKey>
        updateCryptoKeyPrimaryVersionSettings;
    private final UnaryCallSettings.Builder<DestroyCryptoKeyVersionRequest, CryptoKeyVersion>
        destroyCryptoKeyVersionSettings;
    private final UnaryCallSettings.Builder<RestoreCryptoKeyVersionRequest, CryptoKeyVersion>
        restoreCryptoKeyVersionSettings;
    private final UnaryCallSettings.Builder<EncryptRequest, EncryptResponse> encryptSettings;
    private final UnaryCallSettings.Builder<DecryptRequest, DecryptResponse> decryptSettings;
    private final UnaryCallSettings.Builder<RawEncryptRequest, RawEncryptResponse>
        rawEncryptSettings;
    private final UnaryCallSettings.Builder<RawDecryptRequest, RawDecryptResponse>
        rawDecryptSettings;
    private final UnaryCallSettings.Builder<AsymmetricSignRequest, AsymmetricSignResponse>
        asymmetricSignSettings;
    private final UnaryCallSettings.Builder<AsymmetricDecryptRequest, AsymmetricDecryptResponse>
        asymmetricDecryptSettings;
    private final UnaryCallSettings.Builder<MacSignRequest, MacSignResponse> macSignSettings;
    private final UnaryCallSettings.Builder<MacVerifyRequest, MacVerifyResponse> macVerifySettings;
    private final UnaryCallSettings.Builder<DecapsulateRequest, DecapsulateResponse>
        decapsulateSettings;
    private final UnaryCallSettings.Builder<GenerateRandomBytesRequest, GenerateRandomBytesResponse>
        generateRandomBytesSettings;
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
          "retry_policy_1_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNAVAILABLE, StatusCode.Code.DEADLINE_EXCEEDED)));
      definitions.put(
          "no_retry_0_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(60000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_1_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_0_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listKeyRingsSettings = PagedCallSettings.newBuilder(LIST_KEY_RINGS_PAGE_STR_FACT);
      listCryptoKeysSettings = PagedCallSettings.newBuilder(LIST_CRYPTO_KEYS_PAGE_STR_FACT);
      listCryptoKeyVersionsSettings =
          PagedCallSettings.newBuilder(LIST_CRYPTO_KEY_VERSIONS_PAGE_STR_FACT);
      listImportJobsSettings = PagedCallSettings.newBuilder(LIST_IMPORT_JOBS_PAGE_STR_FACT);
      getKeyRingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getCryptoKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getCryptoKeyVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getPublicKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getImportJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createKeyRingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCryptoKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCryptoKeyVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importCryptoKeyVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createImportJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateCryptoKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateCryptoKeyVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateCryptoKeyPrimaryVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      destroyCryptoKeyVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      restoreCryptoKeyVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      encryptSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      decryptSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      rawEncryptSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      rawDecryptSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      asymmetricSignSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      asymmetricDecryptSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      macSignSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      macVerifySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      decapsulateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      generateRandomBytesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listKeyRingsSettings,
              listCryptoKeysSettings,
              listCryptoKeyVersionsSettings,
              listImportJobsSettings,
              getKeyRingSettings,
              getCryptoKeySettings,
              getCryptoKeyVersionSettings,
              getPublicKeySettings,
              getImportJobSettings,
              createKeyRingSettings,
              createCryptoKeySettings,
              createCryptoKeyVersionSettings,
              importCryptoKeyVersionSettings,
              createImportJobSettings,
              updateCryptoKeySettings,
              updateCryptoKeyVersionSettings,
              updateCryptoKeyPrimaryVersionSettings,
              destroyCryptoKeyVersionSettings,
              restoreCryptoKeyVersionSettings,
              encryptSettings,
              decryptSettings,
              rawEncryptSettings,
              rawDecryptSettings,
              asymmetricSignSettings,
              asymmetricDecryptSettings,
              macSignSettings,
              macVerifySettings,
              decapsulateSettings,
              generateRandomBytesSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(KeyManagementServiceStubSettings settings) {
      super(settings);

      listKeyRingsSettings = settings.listKeyRingsSettings.toBuilder();
      listCryptoKeysSettings = settings.listCryptoKeysSettings.toBuilder();
      listCryptoKeyVersionsSettings = settings.listCryptoKeyVersionsSettings.toBuilder();
      listImportJobsSettings = settings.listImportJobsSettings.toBuilder();
      getKeyRingSettings = settings.getKeyRingSettings.toBuilder();
      getCryptoKeySettings = settings.getCryptoKeySettings.toBuilder();
      getCryptoKeyVersionSettings = settings.getCryptoKeyVersionSettings.toBuilder();
      getPublicKeySettings = settings.getPublicKeySettings.toBuilder();
      getImportJobSettings = settings.getImportJobSettings.toBuilder();
      createKeyRingSettings = settings.createKeyRingSettings.toBuilder();
      createCryptoKeySettings = settings.createCryptoKeySettings.toBuilder();
      createCryptoKeyVersionSettings = settings.createCryptoKeyVersionSettings.toBuilder();
      importCryptoKeyVersionSettings = settings.importCryptoKeyVersionSettings.toBuilder();
      createImportJobSettings = settings.createImportJobSettings.toBuilder();
      updateCryptoKeySettings = settings.updateCryptoKeySettings.toBuilder();
      updateCryptoKeyVersionSettings = settings.updateCryptoKeyVersionSettings.toBuilder();
      updateCryptoKeyPrimaryVersionSettings =
          settings.updateCryptoKeyPrimaryVersionSettings.toBuilder();
      destroyCryptoKeyVersionSettings = settings.destroyCryptoKeyVersionSettings.toBuilder();
      restoreCryptoKeyVersionSettings = settings.restoreCryptoKeyVersionSettings.toBuilder();
      encryptSettings = settings.encryptSettings.toBuilder();
      decryptSettings = settings.decryptSettings.toBuilder();
      rawEncryptSettings = settings.rawEncryptSettings.toBuilder();
      rawDecryptSettings = settings.rawDecryptSettings.toBuilder();
      asymmetricSignSettings = settings.asymmetricSignSettings.toBuilder();
      asymmetricDecryptSettings = settings.asymmetricDecryptSettings.toBuilder();
      macSignSettings = settings.macSignSettings.toBuilder();
      macVerifySettings = settings.macVerifySettings.toBuilder();
      decapsulateSettings = settings.decapsulateSettings.toBuilder();
      generateRandomBytesSettings = settings.generateRandomBytesSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listKeyRingsSettings,
              listCryptoKeysSettings,
              listCryptoKeyVersionsSettings,
              listImportJobsSettings,
              getKeyRingSettings,
              getCryptoKeySettings,
              getCryptoKeyVersionSettings,
              getPublicKeySettings,
              getImportJobSettings,
              createKeyRingSettings,
              createCryptoKeySettings,
              createCryptoKeyVersionSettings,
              importCryptoKeyVersionSettings,
              createImportJobSettings,
              updateCryptoKeySettings,
              updateCryptoKeyVersionSettings,
              updateCryptoKeyPrimaryVersionSettings,
              destroyCryptoKeyVersionSettings,
              restoreCryptoKeyVersionSettings,
              encryptSettings,
              decryptSettings,
              rawEncryptSettings,
              rawDecryptSettings,
              asymmetricSignSettings,
              asymmetricDecryptSettings,
              macSignSettings,
              macVerifySettings,
              decapsulateSettings,
              generateRandomBytesSettings,
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
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .listKeyRingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listCryptoKeysSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listCryptoKeyVersionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listImportJobsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getKeyRingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getCryptoKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getCryptoKeyVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getPublicKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getImportJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .createKeyRingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .createCryptoKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .createCryptoKeyVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .importCryptoKeyVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createImportJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .updateCryptoKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .updateCryptoKeyVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .updateCryptoKeyPrimaryVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .destroyCryptoKeyVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .restoreCryptoKeyVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .encryptSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .decryptSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .rawEncryptSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .rawDecryptSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .asymmetricSignSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .asymmetricDecryptSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .macSignSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .macVerifySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .decapsulateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .generateRandomBytesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

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

    /** Returns the builder for the settings used for calls to listKeyRings. */
    public PagedCallSettings.Builder<
            ListKeyRingsRequest, ListKeyRingsResponse, ListKeyRingsPagedResponse>
        listKeyRingsSettings() {
      return listKeyRingsSettings;
    }

    /** Returns the builder for the settings used for calls to listCryptoKeys. */
    public PagedCallSettings.Builder<
            ListCryptoKeysRequest, ListCryptoKeysResponse, ListCryptoKeysPagedResponse>
        listCryptoKeysSettings() {
      return listCryptoKeysSettings;
    }

    /** Returns the builder for the settings used for calls to listCryptoKeyVersions. */
    public PagedCallSettings.Builder<
            ListCryptoKeyVersionsRequest,
            ListCryptoKeyVersionsResponse,
            ListCryptoKeyVersionsPagedResponse>
        listCryptoKeyVersionsSettings() {
      return listCryptoKeyVersionsSettings;
    }

    /** Returns the builder for the settings used for calls to listImportJobs. */
    public PagedCallSettings.Builder<
            ListImportJobsRequest, ListImportJobsResponse, ListImportJobsPagedResponse>
        listImportJobsSettings() {
      return listImportJobsSettings;
    }

    /** Returns the builder for the settings used for calls to getKeyRing. */
    public UnaryCallSettings.Builder<GetKeyRingRequest, KeyRing> getKeyRingSettings() {
      return getKeyRingSettings;
    }

    /** Returns the builder for the settings used for calls to getCryptoKey. */
    public UnaryCallSettings.Builder<GetCryptoKeyRequest, CryptoKey> getCryptoKeySettings() {
      return getCryptoKeySettings;
    }

    /** Returns the builder for the settings used for calls to getCryptoKeyVersion. */
    public UnaryCallSettings.Builder<GetCryptoKeyVersionRequest, CryptoKeyVersion>
        getCryptoKeyVersionSettings() {
      return getCryptoKeyVersionSettings;
    }

    /** Returns the builder for the settings used for calls to getPublicKey. */
    public UnaryCallSettings.Builder<GetPublicKeyRequest, PublicKey> getPublicKeySettings() {
      return getPublicKeySettings;
    }

    /** Returns the builder for the settings used for calls to getImportJob. */
    public UnaryCallSettings.Builder<GetImportJobRequest, ImportJob> getImportJobSettings() {
      return getImportJobSettings;
    }

    /** Returns the builder for the settings used for calls to createKeyRing. */
    public UnaryCallSettings.Builder<CreateKeyRingRequest, KeyRing> createKeyRingSettings() {
      return createKeyRingSettings;
    }

    /** Returns the builder for the settings used for calls to createCryptoKey. */
    public UnaryCallSettings.Builder<CreateCryptoKeyRequest, CryptoKey> createCryptoKeySettings() {
      return createCryptoKeySettings;
    }

    /** Returns the builder for the settings used for calls to createCryptoKeyVersion. */
    public UnaryCallSettings.Builder<CreateCryptoKeyVersionRequest, CryptoKeyVersion>
        createCryptoKeyVersionSettings() {
      return createCryptoKeyVersionSettings;
    }

    /** Returns the builder for the settings used for calls to importCryptoKeyVersion. */
    public UnaryCallSettings.Builder<ImportCryptoKeyVersionRequest, CryptoKeyVersion>
        importCryptoKeyVersionSettings() {
      return importCryptoKeyVersionSettings;
    }

    /** Returns the builder for the settings used for calls to createImportJob. */
    public UnaryCallSettings.Builder<CreateImportJobRequest, ImportJob> createImportJobSettings() {
      return createImportJobSettings;
    }

    /** Returns the builder for the settings used for calls to updateCryptoKey. */
    public UnaryCallSettings.Builder<UpdateCryptoKeyRequest, CryptoKey> updateCryptoKeySettings() {
      return updateCryptoKeySettings;
    }

    /** Returns the builder for the settings used for calls to updateCryptoKeyVersion. */
    public UnaryCallSettings.Builder<UpdateCryptoKeyVersionRequest, CryptoKeyVersion>
        updateCryptoKeyVersionSettings() {
      return updateCryptoKeyVersionSettings;
    }

    /** Returns the builder for the settings used for calls to updateCryptoKeyPrimaryVersion. */
    public UnaryCallSettings.Builder<UpdateCryptoKeyPrimaryVersionRequest, CryptoKey>
        updateCryptoKeyPrimaryVersionSettings() {
      return updateCryptoKeyPrimaryVersionSettings;
    }

    /** Returns the builder for the settings used for calls to destroyCryptoKeyVersion. */
    public UnaryCallSettings.Builder<DestroyCryptoKeyVersionRequest, CryptoKeyVersion>
        destroyCryptoKeyVersionSettings() {
      return destroyCryptoKeyVersionSettings;
    }

    /** Returns the builder for the settings used for calls to restoreCryptoKeyVersion. */
    public UnaryCallSettings.Builder<RestoreCryptoKeyVersionRequest, CryptoKeyVersion>
        restoreCryptoKeyVersionSettings() {
      return restoreCryptoKeyVersionSettings;
    }

    /** Returns the builder for the settings used for calls to encrypt. */
    public UnaryCallSettings.Builder<EncryptRequest, EncryptResponse> encryptSettings() {
      return encryptSettings;
    }

    /** Returns the builder for the settings used for calls to decrypt. */
    public UnaryCallSettings.Builder<DecryptRequest, DecryptResponse> decryptSettings() {
      return decryptSettings;
    }

    /** Returns the builder for the settings used for calls to rawEncrypt. */
    public UnaryCallSettings.Builder<RawEncryptRequest, RawEncryptResponse> rawEncryptSettings() {
      return rawEncryptSettings;
    }

    /** Returns the builder for the settings used for calls to rawDecrypt. */
    public UnaryCallSettings.Builder<RawDecryptRequest, RawDecryptResponse> rawDecryptSettings() {
      return rawDecryptSettings;
    }

    /** Returns the builder for the settings used for calls to asymmetricSign. */
    public UnaryCallSettings.Builder<AsymmetricSignRequest, AsymmetricSignResponse>
        asymmetricSignSettings() {
      return asymmetricSignSettings;
    }

    /** Returns the builder for the settings used for calls to asymmetricDecrypt. */
    public UnaryCallSettings.Builder<AsymmetricDecryptRequest, AsymmetricDecryptResponse>
        asymmetricDecryptSettings() {
      return asymmetricDecryptSettings;
    }

    /** Returns the builder for the settings used for calls to macSign. */
    public UnaryCallSettings.Builder<MacSignRequest, MacSignResponse> macSignSettings() {
      return macSignSettings;
    }

    /** Returns the builder for the settings used for calls to macVerify. */
    public UnaryCallSettings.Builder<MacVerifyRequest, MacVerifyResponse> macVerifySettings() {
      return macVerifySettings;
    }

    /** Returns the builder for the settings used for calls to decapsulate. */
    public UnaryCallSettings.Builder<DecapsulateRequest, DecapsulateResponse>
        decapsulateSettings() {
      return decapsulateSettings;
    }

    /** Returns the builder for the settings used for calls to generateRandomBytes. */
    public UnaryCallSettings.Builder<GenerateRandomBytesRequest, GenerateRandomBytesResponse>
        generateRandomBytesSettings() {
      return generateRandomBytesSettings;
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
    public KeyManagementServiceStubSettings build() throws IOException {
      return new KeyManagementServiceStubSettings(this);
    }
  }
}
