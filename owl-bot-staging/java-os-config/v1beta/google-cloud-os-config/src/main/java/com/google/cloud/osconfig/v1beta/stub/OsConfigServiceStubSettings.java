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

package com.google.cloud.osconfig.v1beta.stub;

import static com.google.cloud.osconfig.v1beta.OsConfigServiceClient.ListGuestPoliciesPagedResponse;
import static com.google.cloud.osconfig.v1beta.OsConfigServiceClient.ListPatchDeploymentsPagedResponse;
import static com.google.cloud.osconfig.v1beta.OsConfigServiceClient.ListPatchJobInstanceDetailsPagedResponse;
import static com.google.cloud.osconfig.v1beta.OsConfigServiceClient.ListPatchJobsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
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
import com.google.cloud.osconfig.v1beta.GuestPolicies;
import com.google.cloud.osconfig.v1beta.PatchDeployments;
import com.google.cloud.osconfig.v1beta.PatchJobs;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link OsConfigServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (osconfig.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of executePatchJob to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * OsConfigServiceStubSettings.Builder osConfigServiceSettingsBuilder =
 *     OsConfigServiceStubSettings.newBuilder();
 * osConfigServiceSettingsBuilder
 *     .executePatchJobSettings()
 *     .setRetrySettings(
 *         osConfigServiceSettingsBuilder
 *             .executePatchJobSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * OsConfigServiceStubSettings osConfigServiceSettings = osConfigServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class OsConfigServiceStubSettings extends StubSettings<OsConfigServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<PatchJobs.ExecutePatchJobRequest, PatchJobs.PatchJob>
      executePatchJobSettings;
  private final UnaryCallSettings<PatchJobs.GetPatchJobRequest, PatchJobs.PatchJob>
      getPatchJobSettings;
  private final UnaryCallSettings<PatchJobs.CancelPatchJobRequest, PatchJobs.PatchJob>
      cancelPatchJobSettings;
  private final PagedCallSettings<
          PatchJobs.ListPatchJobsRequest,
          PatchJobs.ListPatchJobsResponse,
          ListPatchJobsPagedResponse>
      listPatchJobsSettings;
  private final PagedCallSettings<
          PatchJobs.ListPatchJobInstanceDetailsRequest,
          PatchJobs.ListPatchJobInstanceDetailsResponse,
          ListPatchJobInstanceDetailsPagedResponse>
      listPatchJobInstanceDetailsSettings;
  private final UnaryCallSettings<
          PatchDeployments.CreatePatchDeploymentRequest, PatchDeployments.PatchDeployment>
      createPatchDeploymentSettings;
  private final UnaryCallSettings<
          PatchDeployments.GetPatchDeploymentRequest, PatchDeployments.PatchDeployment>
      getPatchDeploymentSettings;
  private final PagedCallSettings<
          PatchDeployments.ListPatchDeploymentsRequest,
          PatchDeployments.ListPatchDeploymentsResponse,
          ListPatchDeploymentsPagedResponse>
      listPatchDeploymentsSettings;
  private final UnaryCallSettings<PatchDeployments.DeletePatchDeploymentRequest, Empty>
      deletePatchDeploymentSettings;
  private final UnaryCallSettings<
          PatchDeployments.UpdatePatchDeploymentRequest, PatchDeployments.PatchDeployment>
      updatePatchDeploymentSettings;
  private final UnaryCallSettings<
          PatchDeployments.PausePatchDeploymentRequest, PatchDeployments.PatchDeployment>
      pausePatchDeploymentSettings;
  private final UnaryCallSettings<
          PatchDeployments.ResumePatchDeploymentRequest, PatchDeployments.PatchDeployment>
      resumePatchDeploymentSettings;
  private final UnaryCallSettings<GuestPolicies.CreateGuestPolicyRequest, GuestPolicies.GuestPolicy>
      createGuestPolicySettings;
  private final UnaryCallSettings<GuestPolicies.GetGuestPolicyRequest, GuestPolicies.GuestPolicy>
      getGuestPolicySettings;
  private final PagedCallSettings<
          GuestPolicies.ListGuestPoliciesRequest,
          GuestPolicies.ListGuestPoliciesResponse,
          ListGuestPoliciesPagedResponse>
      listGuestPoliciesSettings;
  private final UnaryCallSettings<GuestPolicies.UpdateGuestPolicyRequest, GuestPolicies.GuestPolicy>
      updateGuestPolicySettings;
  private final UnaryCallSettings<GuestPolicies.DeleteGuestPolicyRequest, Empty>
      deleteGuestPolicySettings;
  private final UnaryCallSettings<
          GuestPolicies.LookupEffectiveGuestPolicyRequest, GuestPolicies.EffectiveGuestPolicy>
      lookupEffectiveGuestPolicySettings;

  private static final PagedListDescriptor<
          PatchJobs.ListPatchJobsRequest, PatchJobs.ListPatchJobsResponse, PatchJobs.PatchJob>
      LIST_PATCH_JOBS_PAGE_STR_DESC =
          new PagedListDescriptor<
              PatchJobs.ListPatchJobsRequest,
              PatchJobs.ListPatchJobsResponse,
              PatchJobs.PatchJob>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public PatchJobs.ListPatchJobsRequest injectToken(
                PatchJobs.ListPatchJobsRequest payload, String token) {
              return PatchJobs.ListPatchJobsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public PatchJobs.ListPatchJobsRequest injectPageSize(
                PatchJobs.ListPatchJobsRequest payload, int pageSize) {
              return PatchJobs.ListPatchJobsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(PatchJobs.ListPatchJobsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(PatchJobs.ListPatchJobsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<PatchJobs.PatchJob> extractResources(
                PatchJobs.ListPatchJobsResponse payload) {
              return payload.getPatchJobsList() == null
                  ? ImmutableList.<PatchJobs.PatchJob>of()
                  : payload.getPatchJobsList();
            }
          };

  private static final PagedListDescriptor<
          PatchJobs.ListPatchJobInstanceDetailsRequest,
          PatchJobs.ListPatchJobInstanceDetailsResponse,
          PatchJobs.PatchJobInstanceDetails>
      LIST_PATCH_JOB_INSTANCE_DETAILS_PAGE_STR_DESC =
          new PagedListDescriptor<
              PatchJobs.ListPatchJobInstanceDetailsRequest,
              PatchJobs.ListPatchJobInstanceDetailsResponse,
              PatchJobs.PatchJobInstanceDetails>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public PatchJobs.ListPatchJobInstanceDetailsRequest injectToken(
                PatchJobs.ListPatchJobInstanceDetailsRequest payload, String token) {
              return PatchJobs.ListPatchJobInstanceDetailsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public PatchJobs.ListPatchJobInstanceDetailsRequest injectPageSize(
                PatchJobs.ListPatchJobInstanceDetailsRequest payload, int pageSize) {
              return PatchJobs.ListPatchJobInstanceDetailsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(PatchJobs.ListPatchJobInstanceDetailsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(PatchJobs.ListPatchJobInstanceDetailsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<PatchJobs.PatchJobInstanceDetails> extractResources(
                PatchJobs.ListPatchJobInstanceDetailsResponse payload) {
              return payload.getPatchJobInstanceDetailsList() == null
                  ? ImmutableList.<PatchJobs.PatchJobInstanceDetails>of()
                  : payload.getPatchJobInstanceDetailsList();
            }
          };

  private static final PagedListDescriptor<
          PatchDeployments.ListPatchDeploymentsRequest,
          PatchDeployments.ListPatchDeploymentsResponse,
          PatchDeployments.PatchDeployment>
      LIST_PATCH_DEPLOYMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              PatchDeployments.ListPatchDeploymentsRequest,
              PatchDeployments.ListPatchDeploymentsResponse,
              PatchDeployments.PatchDeployment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public PatchDeployments.ListPatchDeploymentsRequest injectToken(
                PatchDeployments.ListPatchDeploymentsRequest payload, String token) {
              return PatchDeployments.ListPatchDeploymentsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public PatchDeployments.ListPatchDeploymentsRequest injectPageSize(
                PatchDeployments.ListPatchDeploymentsRequest payload, int pageSize) {
              return PatchDeployments.ListPatchDeploymentsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(PatchDeployments.ListPatchDeploymentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(PatchDeployments.ListPatchDeploymentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<PatchDeployments.PatchDeployment> extractResources(
                PatchDeployments.ListPatchDeploymentsResponse payload) {
              return payload.getPatchDeploymentsList() == null
                  ? ImmutableList.<PatchDeployments.PatchDeployment>of()
                  : payload.getPatchDeploymentsList();
            }
          };

  private static final PagedListDescriptor<
          GuestPolicies.ListGuestPoliciesRequest,
          GuestPolicies.ListGuestPoliciesResponse,
          GuestPolicies.GuestPolicy>
      LIST_GUEST_POLICIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              GuestPolicies.ListGuestPoliciesRequest,
              GuestPolicies.ListGuestPoliciesResponse,
              GuestPolicies.GuestPolicy>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public GuestPolicies.ListGuestPoliciesRequest injectToken(
                GuestPolicies.ListGuestPoliciesRequest payload, String token) {
              return GuestPolicies.ListGuestPoliciesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public GuestPolicies.ListGuestPoliciesRequest injectPageSize(
                GuestPolicies.ListGuestPoliciesRequest payload, int pageSize) {
              return GuestPolicies.ListGuestPoliciesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(GuestPolicies.ListGuestPoliciesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(GuestPolicies.ListGuestPoliciesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<GuestPolicies.GuestPolicy> extractResources(
                GuestPolicies.ListGuestPoliciesResponse payload) {
              return payload.getGuestPoliciesList() == null
                  ? ImmutableList.<GuestPolicies.GuestPolicy>of()
                  : payload.getGuestPoliciesList();
            }
          };

  private static final PagedListResponseFactory<
          PatchJobs.ListPatchJobsRequest,
          PatchJobs.ListPatchJobsResponse,
          ListPatchJobsPagedResponse>
      LIST_PATCH_JOBS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              PatchJobs.ListPatchJobsRequest,
              PatchJobs.ListPatchJobsResponse,
              ListPatchJobsPagedResponse>() {
            @Override
            public ApiFuture<ListPatchJobsPagedResponse> getFuturePagedResponse(
                UnaryCallable<PatchJobs.ListPatchJobsRequest, PatchJobs.ListPatchJobsResponse>
                    callable,
                PatchJobs.ListPatchJobsRequest request,
                ApiCallContext context,
                ApiFuture<PatchJobs.ListPatchJobsResponse> futureResponse) {
              PageContext<
                      PatchJobs.ListPatchJobsRequest,
                      PatchJobs.ListPatchJobsResponse,
                      PatchJobs.PatchJob>
                  pageContext =
                      PageContext.create(callable, LIST_PATCH_JOBS_PAGE_STR_DESC, request, context);
              return ListPatchJobsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          PatchJobs.ListPatchJobInstanceDetailsRequest,
          PatchJobs.ListPatchJobInstanceDetailsResponse,
          ListPatchJobInstanceDetailsPagedResponse>
      LIST_PATCH_JOB_INSTANCE_DETAILS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              PatchJobs.ListPatchJobInstanceDetailsRequest,
              PatchJobs.ListPatchJobInstanceDetailsResponse,
              ListPatchJobInstanceDetailsPagedResponse>() {
            @Override
            public ApiFuture<ListPatchJobInstanceDetailsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        PatchJobs.ListPatchJobInstanceDetailsRequest,
                        PatchJobs.ListPatchJobInstanceDetailsResponse>
                    callable,
                PatchJobs.ListPatchJobInstanceDetailsRequest request,
                ApiCallContext context,
                ApiFuture<PatchJobs.ListPatchJobInstanceDetailsResponse> futureResponse) {
              PageContext<
                      PatchJobs.ListPatchJobInstanceDetailsRequest,
                      PatchJobs.ListPatchJobInstanceDetailsResponse,
                      PatchJobs.PatchJobInstanceDetails>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_PATCH_JOB_INSTANCE_DETAILS_PAGE_STR_DESC,
                          request,
                          context);
              return ListPatchJobInstanceDetailsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          PatchDeployments.ListPatchDeploymentsRequest,
          PatchDeployments.ListPatchDeploymentsResponse,
          ListPatchDeploymentsPagedResponse>
      LIST_PATCH_DEPLOYMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              PatchDeployments.ListPatchDeploymentsRequest,
              PatchDeployments.ListPatchDeploymentsResponse,
              ListPatchDeploymentsPagedResponse>() {
            @Override
            public ApiFuture<ListPatchDeploymentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        PatchDeployments.ListPatchDeploymentsRequest,
                        PatchDeployments.ListPatchDeploymentsResponse>
                    callable,
                PatchDeployments.ListPatchDeploymentsRequest request,
                ApiCallContext context,
                ApiFuture<PatchDeployments.ListPatchDeploymentsResponse> futureResponse) {
              PageContext<
                      PatchDeployments.ListPatchDeploymentsRequest,
                      PatchDeployments.ListPatchDeploymentsResponse,
                      PatchDeployments.PatchDeployment>
                  pageContext =
                      PageContext.create(
                          callable, LIST_PATCH_DEPLOYMENTS_PAGE_STR_DESC, request, context);
              return ListPatchDeploymentsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          GuestPolicies.ListGuestPoliciesRequest,
          GuestPolicies.ListGuestPoliciesResponse,
          ListGuestPoliciesPagedResponse>
      LIST_GUEST_POLICIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              GuestPolicies.ListGuestPoliciesRequest,
              GuestPolicies.ListGuestPoliciesResponse,
              ListGuestPoliciesPagedResponse>() {
            @Override
            public ApiFuture<ListGuestPoliciesPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        GuestPolicies.ListGuestPoliciesRequest,
                        GuestPolicies.ListGuestPoliciesResponse>
                    callable,
                GuestPolicies.ListGuestPoliciesRequest request,
                ApiCallContext context,
                ApiFuture<GuestPolicies.ListGuestPoliciesResponse> futureResponse) {
              PageContext<
                      GuestPolicies.ListGuestPoliciesRequest,
                      GuestPolicies.ListGuestPoliciesResponse,
                      GuestPolicies.GuestPolicy>
                  pageContext =
                      PageContext.create(
                          callable, LIST_GUEST_POLICIES_PAGE_STR_DESC, request, context);
              return ListGuestPoliciesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to executePatchJob. */
  public UnaryCallSettings<PatchJobs.ExecutePatchJobRequest, PatchJobs.PatchJob>
      executePatchJobSettings() {
    return executePatchJobSettings;
  }

  /** Returns the object with the settings used for calls to getPatchJob. */
  public UnaryCallSettings<PatchJobs.GetPatchJobRequest, PatchJobs.PatchJob> getPatchJobSettings() {
    return getPatchJobSettings;
  }

  /** Returns the object with the settings used for calls to cancelPatchJob. */
  public UnaryCallSettings<PatchJobs.CancelPatchJobRequest, PatchJobs.PatchJob>
      cancelPatchJobSettings() {
    return cancelPatchJobSettings;
  }

  /** Returns the object with the settings used for calls to listPatchJobs. */
  public PagedCallSettings<
          PatchJobs.ListPatchJobsRequest,
          PatchJobs.ListPatchJobsResponse,
          ListPatchJobsPagedResponse>
      listPatchJobsSettings() {
    return listPatchJobsSettings;
  }

  /** Returns the object with the settings used for calls to listPatchJobInstanceDetails. */
  public PagedCallSettings<
          PatchJobs.ListPatchJobInstanceDetailsRequest,
          PatchJobs.ListPatchJobInstanceDetailsResponse,
          ListPatchJobInstanceDetailsPagedResponse>
      listPatchJobInstanceDetailsSettings() {
    return listPatchJobInstanceDetailsSettings;
  }

  /** Returns the object with the settings used for calls to createPatchDeployment. */
  public UnaryCallSettings<
          PatchDeployments.CreatePatchDeploymentRequest, PatchDeployments.PatchDeployment>
      createPatchDeploymentSettings() {
    return createPatchDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to getPatchDeployment. */
  public UnaryCallSettings<
          PatchDeployments.GetPatchDeploymentRequest, PatchDeployments.PatchDeployment>
      getPatchDeploymentSettings() {
    return getPatchDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to listPatchDeployments. */
  public PagedCallSettings<
          PatchDeployments.ListPatchDeploymentsRequest,
          PatchDeployments.ListPatchDeploymentsResponse,
          ListPatchDeploymentsPagedResponse>
      listPatchDeploymentsSettings() {
    return listPatchDeploymentsSettings;
  }

  /** Returns the object with the settings used for calls to deletePatchDeployment. */
  public UnaryCallSettings<PatchDeployments.DeletePatchDeploymentRequest, Empty>
      deletePatchDeploymentSettings() {
    return deletePatchDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to updatePatchDeployment. */
  public UnaryCallSettings<
          PatchDeployments.UpdatePatchDeploymentRequest, PatchDeployments.PatchDeployment>
      updatePatchDeploymentSettings() {
    return updatePatchDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to pausePatchDeployment. */
  public UnaryCallSettings<
          PatchDeployments.PausePatchDeploymentRequest, PatchDeployments.PatchDeployment>
      pausePatchDeploymentSettings() {
    return pausePatchDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to resumePatchDeployment. */
  public UnaryCallSettings<
          PatchDeployments.ResumePatchDeploymentRequest, PatchDeployments.PatchDeployment>
      resumePatchDeploymentSettings() {
    return resumePatchDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to createGuestPolicy. */
  public UnaryCallSettings<GuestPolicies.CreateGuestPolicyRequest, GuestPolicies.GuestPolicy>
      createGuestPolicySettings() {
    return createGuestPolicySettings;
  }

  /** Returns the object with the settings used for calls to getGuestPolicy. */
  public UnaryCallSettings<GuestPolicies.GetGuestPolicyRequest, GuestPolicies.GuestPolicy>
      getGuestPolicySettings() {
    return getGuestPolicySettings;
  }

  /** Returns the object with the settings used for calls to listGuestPolicies. */
  public PagedCallSettings<
          GuestPolicies.ListGuestPoliciesRequest,
          GuestPolicies.ListGuestPoliciesResponse,
          ListGuestPoliciesPagedResponse>
      listGuestPoliciesSettings() {
    return listGuestPoliciesSettings;
  }

  /** Returns the object with the settings used for calls to updateGuestPolicy. */
  public UnaryCallSettings<GuestPolicies.UpdateGuestPolicyRequest, GuestPolicies.GuestPolicy>
      updateGuestPolicySettings() {
    return updateGuestPolicySettings;
  }

  /** Returns the object with the settings used for calls to deleteGuestPolicy. */
  public UnaryCallSettings<GuestPolicies.DeleteGuestPolicyRequest, Empty>
      deleteGuestPolicySettings() {
    return deleteGuestPolicySettings;
  }

  /** Returns the object with the settings used for calls to lookupEffectiveGuestPolicy. */
  public UnaryCallSettings<
          GuestPolicies.LookupEffectiveGuestPolicyRequest, GuestPolicies.EffectiveGuestPolicy>
      lookupEffectiveGuestPolicySettings() {
    return lookupEffectiveGuestPolicySettings;
  }

  public OsConfigServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcOsConfigServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonOsConfigServiceStub.create(this);
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
    return "osconfig.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "osconfig.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(OsConfigServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(OsConfigServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return OsConfigServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected OsConfigServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    executePatchJobSettings = settingsBuilder.executePatchJobSettings().build();
    getPatchJobSettings = settingsBuilder.getPatchJobSettings().build();
    cancelPatchJobSettings = settingsBuilder.cancelPatchJobSettings().build();
    listPatchJobsSettings = settingsBuilder.listPatchJobsSettings().build();
    listPatchJobInstanceDetailsSettings =
        settingsBuilder.listPatchJobInstanceDetailsSettings().build();
    createPatchDeploymentSettings = settingsBuilder.createPatchDeploymentSettings().build();
    getPatchDeploymentSettings = settingsBuilder.getPatchDeploymentSettings().build();
    listPatchDeploymentsSettings = settingsBuilder.listPatchDeploymentsSettings().build();
    deletePatchDeploymentSettings = settingsBuilder.deletePatchDeploymentSettings().build();
    updatePatchDeploymentSettings = settingsBuilder.updatePatchDeploymentSettings().build();
    pausePatchDeploymentSettings = settingsBuilder.pausePatchDeploymentSettings().build();
    resumePatchDeploymentSettings = settingsBuilder.resumePatchDeploymentSettings().build();
    createGuestPolicySettings = settingsBuilder.createGuestPolicySettings().build();
    getGuestPolicySettings = settingsBuilder.getGuestPolicySettings().build();
    listGuestPoliciesSettings = settingsBuilder.listGuestPoliciesSettings().build();
    updateGuestPolicySettings = settingsBuilder.updateGuestPolicySettings().build();
    deleteGuestPolicySettings = settingsBuilder.deleteGuestPolicySettings().build();
    lookupEffectiveGuestPolicySettings =
        settingsBuilder.lookupEffectiveGuestPolicySettings().build();
  }

  /** Builder for OsConfigServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<OsConfigServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<PatchJobs.ExecutePatchJobRequest, PatchJobs.PatchJob>
        executePatchJobSettings;
    private final UnaryCallSettings.Builder<PatchJobs.GetPatchJobRequest, PatchJobs.PatchJob>
        getPatchJobSettings;
    private final UnaryCallSettings.Builder<PatchJobs.CancelPatchJobRequest, PatchJobs.PatchJob>
        cancelPatchJobSettings;
    private final PagedCallSettings.Builder<
            PatchJobs.ListPatchJobsRequest,
            PatchJobs.ListPatchJobsResponse,
            ListPatchJobsPagedResponse>
        listPatchJobsSettings;
    private final PagedCallSettings.Builder<
            PatchJobs.ListPatchJobInstanceDetailsRequest,
            PatchJobs.ListPatchJobInstanceDetailsResponse,
            ListPatchJobInstanceDetailsPagedResponse>
        listPatchJobInstanceDetailsSettings;
    private final UnaryCallSettings.Builder<
            PatchDeployments.CreatePatchDeploymentRequest, PatchDeployments.PatchDeployment>
        createPatchDeploymentSettings;
    private final UnaryCallSettings.Builder<
            PatchDeployments.GetPatchDeploymentRequest, PatchDeployments.PatchDeployment>
        getPatchDeploymentSettings;
    private final PagedCallSettings.Builder<
            PatchDeployments.ListPatchDeploymentsRequest,
            PatchDeployments.ListPatchDeploymentsResponse,
            ListPatchDeploymentsPagedResponse>
        listPatchDeploymentsSettings;
    private final UnaryCallSettings.Builder<PatchDeployments.DeletePatchDeploymentRequest, Empty>
        deletePatchDeploymentSettings;
    private final UnaryCallSettings.Builder<
            PatchDeployments.UpdatePatchDeploymentRequest, PatchDeployments.PatchDeployment>
        updatePatchDeploymentSettings;
    private final UnaryCallSettings.Builder<
            PatchDeployments.PausePatchDeploymentRequest, PatchDeployments.PatchDeployment>
        pausePatchDeploymentSettings;
    private final UnaryCallSettings.Builder<
            PatchDeployments.ResumePatchDeploymentRequest, PatchDeployments.PatchDeployment>
        resumePatchDeploymentSettings;
    private final UnaryCallSettings.Builder<
            GuestPolicies.CreateGuestPolicyRequest, GuestPolicies.GuestPolicy>
        createGuestPolicySettings;
    private final UnaryCallSettings.Builder<
            GuestPolicies.GetGuestPolicyRequest, GuestPolicies.GuestPolicy>
        getGuestPolicySettings;
    private final PagedCallSettings.Builder<
            GuestPolicies.ListGuestPoliciesRequest,
            GuestPolicies.ListGuestPoliciesResponse,
            ListGuestPoliciesPagedResponse>
        listGuestPoliciesSettings;
    private final UnaryCallSettings.Builder<
            GuestPolicies.UpdateGuestPolicyRequest, GuestPolicies.GuestPolicy>
        updateGuestPolicySettings;
    private final UnaryCallSettings.Builder<GuestPolicies.DeleteGuestPolicyRequest, Empty>
        deleteGuestPolicySettings;
    private final UnaryCallSettings.Builder<
            GuestPolicies.LookupEffectiveGuestPolicyRequest, GuestPolicies.EffectiveGuestPolicy>
        lookupEffectiveGuestPolicySettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
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

      executePatchJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getPatchJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      cancelPatchJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listPatchJobsSettings = PagedCallSettings.newBuilder(LIST_PATCH_JOBS_PAGE_STR_FACT);
      listPatchJobInstanceDetailsSettings =
          PagedCallSettings.newBuilder(LIST_PATCH_JOB_INSTANCE_DETAILS_PAGE_STR_FACT);
      createPatchDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getPatchDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listPatchDeploymentsSettings =
          PagedCallSettings.newBuilder(LIST_PATCH_DEPLOYMENTS_PAGE_STR_FACT);
      deletePatchDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updatePatchDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      pausePatchDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      resumePatchDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createGuestPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getGuestPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listGuestPoliciesSettings = PagedCallSettings.newBuilder(LIST_GUEST_POLICIES_PAGE_STR_FACT);
      updateGuestPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteGuestPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      lookupEffectiveGuestPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              executePatchJobSettings,
              getPatchJobSettings,
              cancelPatchJobSettings,
              listPatchJobsSettings,
              listPatchJobInstanceDetailsSettings,
              createPatchDeploymentSettings,
              getPatchDeploymentSettings,
              listPatchDeploymentsSettings,
              deletePatchDeploymentSettings,
              updatePatchDeploymentSettings,
              pausePatchDeploymentSettings,
              resumePatchDeploymentSettings,
              createGuestPolicySettings,
              getGuestPolicySettings,
              listGuestPoliciesSettings,
              updateGuestPolicySettings,
              deleteGuestPolicySettings,
              lookupEffectiveGuestPolicySettings);
      initDefaults(this);
    }

    protected Builder(OsConfigServiceStubSettings settings) {
      super(settings);

      executePatchJobSettings = settings.executePatchJobSettings.toBuilder();
      getPatchJobSettings = settings.getPatchJobSettings.toBuilder();
      cancelPatchJobSettings = settings.cancelPatchJobSettings.toBuilder();
      listPatchJobsSettings = settings.listPatchJobsSettings.toBuilder();
      listPatchJobInstanceDetailsSettings =
          settings.listPatchJobInstanceDetailsSettings.toBuilder();
      createPatchDeploymentSettings = settings.createPatchDeploymentSettings.toBuilder();
      getPatchDeploymentSettings = settings.getPatchDeploymentSettings.toBuilder();
      listPatchDeploymentsSettings = settings.listPatchDeploymentsSettings.toBuilder();
      deletePatchDeploymentSettings = settings.deletePatchDeploymentSettings.toBuilder();
      updatePatchDeploymentSettings = settings.updatePatchDeploymentSettings.toBuilder();
      pausePatchDeploymentSettings = settings.pausePatchDeploymentSettings.toBuilder();
      resumePatchDeploymentSettings = settings.resumePatchDeploymentSettings.toBuilder();
      createGuestPolicySettings = settings.createGuestPolicySettings.toBuilder();
      getGuestPolicySettings = settings.getGuestPolicySettings.toBuilder();
      listGuestPoliciesSettings = settings.listGuestPoliciesSettings.toBuilder();
      updateGuestPolicySettings = settings.updateGuestPolicySettings.toBuilder();
      deleteGuestPolicySettings = settings.deleteGuestPolicySettings.toBuilder();
      lookupEffectiveGuestPolicySettings = settings.lookupEffectiveGuestPolicySettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              executePatchJobSettings,
              getPatchJobSettings,
              cancelPatchJobSettings,
              listPatchJobsSettings,
              listPatchJobInstanceDetailsSettings,
              createPatchDeploymentSettings,
              getPatchDeploymentSettings,
              listPatchDeploymentsSettings,
              deletePatchDeploymentSettings,
              updatePatchDeploymentSettings,
              pausePatchDeploymentSettings,
              resumePatchDeploymentSettings,
              createGuestPolicySettings,
              getGuestPolicySettings,
              listGuestPoliciesSettings,
              updateGuestPolicySettings,
              deleteGuestPolicySettings,
              lookupEffectiveGuestPolicySettings);
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
          .executePatchJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getPatchJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .cancelPatchJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listPatchJobsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listPatchJobInstanceDetailsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createPatchDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getPatchDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listPatchDeploymentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deletePatchDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updatePatchDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .pausePatchDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .resumePatchDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createGuestPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getGuestPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listGuestPoliciesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateGuestPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteGuestPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .lookupEffectiveGuestPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

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

    /** Returns the builder for the settings used for calls to executePatchJob. */
    public UnaryCallSettings.Builder<PatchJobs.ExecutePatchJobRequest, PatchJobs.PatchJob>
        executePatchJobSettings() {
      return executePatchJobSettings;
    }

    /** Returns the builder for the settings used for calls to getPatchJob. */
    public UnaryCallSettings.Builder<PatchJobs.GetPatchJobRequest, PatchJobs.PatchJob>
        getPatchJobSettings() {
      return getPatchJobSettings;
    }

    /** Returns the builder for the settings used for calls to cancelPatchJob. */
    public UnaryCallSettings.Builder<PatchJobs.CancelPatchJobRequest, PatchJobs.PatchJob>
        cancelPatchJobSettings() {
      return cancelPatchJobSettings;
    }

    /** Returns the builder for the settings used for calls to listPatchJobs. */
    public PagedCallSettings.Builder<
            PatchJobs.ListPatchJobsRequest,
            PatchJobs.ListPatchJobsResponse,
            ListPatchJobsPagedResponse>
        listPatchJobsSettings() {
      return listPatchJobsSettings;
    }

    /** Returns the builder for the settings used for calls to listPatchJobInstanceDetails. */
    public PagedCallSettings.Builder<
            PatchJobs.ListPatchJobInstanceDetailsRequest,
            PatchJobs.ListPatchJobInstanceDetailsResponse,
            ListPatchJobInstanceDetailsPagedResponse>
        listPatchJobInstanceDetailsSettings() {
      return listPatchJobInstanceDetailsSettings;
    }

    /** Returns the builder for the settings used for calls to createPatchDeployment. */
    public UnaryCallSettings.Builder<
            PatchDeployments.CreatePatchDeploymentRequest, PatchDeployments.PatchDeployment>
        createPatchDeploymentSettings() {
      return createPatchDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to getPatchDeployment. */
    public UnaryCallSettings.Builder<
            PatchDeployments.GetPatchDeploymentRequest, PatchDeployments.PatchDeployment>
        getPatchDeploymentSettings() {
      return getPatchDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to listPatchDeployments. */
    public PagedCallSettings.Builder<
            PatchDeployments.ListPatchDeploymentsRequest,
            PatchDeployments.ListPatchDeploymentsResponse,
            ListPatchDeploymentsPagedResponse>
        listPatchDeploymentsSettings() {
      return listPatchDeploymentsSettings;
    }

    /** Returns the builder for the settings used for calls to deletePatchDeployment. */
    public UnaryCallSettings.Builder<PatchDeployments.DeletePatchDeploymentRequest, Empty>
        deletePatchDeploymentSettings() {
      return deletePatchDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to updatePatchDeployment. */
    public UnaryCallSettings.Builder<
            PatchDeployments.UpdatePatchDeploymentRequest, PatchDeployments.PatchDeployment>
        updatePatchDeploymentSettings() {
      return updatePatchDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to pausePatchDeployment. */
    public UnaryCallSettings.Builder<
            PatchDeployments.PausePatchDeploymentRequest, PatchDeployments.PatchDeployment>
        pausePatchDeploymentSettings() {
      return pausePatchDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to resumePatchDeployment. */
    public UnaryCallSettings.Builder<
            PatchDeployments.ResumePatchDeploymentRequest, PatchDeployments.PatchDeployment>
        resumePatchDeploymentSettings() {
      return resumePatchDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to createGuestPolicy. */
    public UnaryCallSettings.Builder<
            GuestPolicies.CreateGuestPolicyRequest, GuestPolicies.GuestPolicy>
        createGuestPolicySettings() {
      return createGuestPolicySettings;
    }

    /** Returns the builder for the settings used for calls to getGuestPolicy. */
    public UnaryCallSettings.Builder<GuestPolicies.GetGuestPolicyRequest, GuestPolicies.GuestPolicy>
        getGuestPolicySettings() {
      return getGuestPolicySettings;
    }

    /** Returns the builder for the settings used for calls to listGuestPolicies. */
    public PagedCallSettings.Builder<
            GuestPolicies.ListGuestPoliciesRequest,
            GuestPolicies.ListGuestPoliciesResponse,
            ListGuestPoliciesPagedResponse>
        listGuestPoliciesSettings() {
      return listGuestPoliciesSettings;
    }

    /** Returns the builder for the settings used for calls to updateGuestPolicy. */
    public UnaryCallSettings.Builder<
            GuestPolicies.UpdateGuestPolicyRequest, GuestPolicies.GuestPolicy>
        updateGuestPolicySettings() {
      return updateGuestPolicySettings;
    }

    /** Returns the builder for the settings used for calls to deleteGuestPolicy. */
    public UnaryCallSettings.Builder<GuestPolicies.DeleteGuestPolicyRequest, Empty>
        deleteGuestPolicySettings() {
      return deleteGuestPolicySettings;
    }

    /** Returns the builder for the settings used for calls to lookupEffectiveGuestPolicy. */
    public UnaryCallSettings.Builder<
            GuestPolicies.LookupEffectiveGuestPolicyRequest, GuestPolicies.EffectiveGuestPolicy>
        lookupEffectiveGuestPolicySettings() {
      return lookupEffectiveGuestPolicySettings;
    }

    @Override
    public OsConfigServiceStubSettings build() throws IOException {
      return new OsConfigServiceStubSettings(this);
    }
  }
}
