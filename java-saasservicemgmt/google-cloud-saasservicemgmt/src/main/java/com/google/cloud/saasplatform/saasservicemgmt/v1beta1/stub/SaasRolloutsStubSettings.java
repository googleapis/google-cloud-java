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

package com.google.cloud.saasplatform.saasservicemgmt.v1beta1.stub;

import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRolloutsClient.ListLocationsPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRolloutsClient.ListRolloutKindsPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRolloutsClient.ListRolloutsPagedResponse;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateRolloutKindRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.CreateRolloutRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteRolloutKindRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.DeleteRolloutRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetRolloutKindRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.GetRolloutRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutKindsRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutKindsResponse;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutsRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.ListRolloutsResponse;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.Rollout;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.RolloutKind;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateRolloutKindRequest;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.UpdateRolloutRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SaasRolloutsStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (saasservicemgmt.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getRollout:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SaasRolloutsStubSettings.Builder saasRolloutsSettingsBuilder =
 *     SaasRolloutsStubSettings.newBuilder();
 * saasRolloutsSettingsBuilder
 *     .getRolloutSettings()
 *     .setRetrySettings(
 *         saasRolloutsSettingsBuilder
 *             .getRolloutSettings()
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
 * SaasRolloutsStubSettings saasRolloutsSettings = saasRolloutsSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class SaasRolloutsStubSettings extends StubSettings<SaasRolloutsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListRolloutsRequest, ListRolloutsResponse, ListRolloutsPagedResponse>
      listRolloutsSettings;
  private final UnaryCallSettings<GetRolloutRequest, Rollout> getRolloutSettings;
  private final UnaryCallSettings<CreateRolloutRequest, Rollout> createRolloutSettings;
  private final UnaryCallSettings<UpdateRolloutRequest, Rollout> updateRolloutSettings;
  private final UnaryCallSettings<DeleteRolloutRequest, Empty> deleteRolloutSettings;
  private final PagedCallSettings<
          ListRolloutKindsRequest, ListRolloutKindsResponse, ListRolloutKindsPagedResponse>
      listRolloutKindsSettings;
  private final UnaryCallSettings<GetRolloutKindRequest, RolloutKind> getRolloutKindSettings;
  private final UnaryCallSettings<CreateRolloutKindRequest, RolloutKind> createRolloutKindSettings;
  private final UnaryCallSettings<UpdateRolloutKindRequest, RolloutKind> updateRolloutKindSettings;
  private final UnaryCallSettings<DeleteRolloutKindRequest, Empty> deleteRolloutKindSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<ListRolloutsRequest, ListRolloutsResponse, Rollout>
      LIST_ROLLOUTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListRolloutsRequest, ListRolloutsResponse, Rollout>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRolloutsRequest injectToken(ListRolloutsRequest payload, String token) {
              return ListRolloutsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRolloutsRequest injectPageSize(ListRolloutsRequest payload, int pageSize) {
              return ListRolloutsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListRolloutsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListRolloutsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Rollout> extractResources(ListRolloutsResponse payload) {
              return payload.getRolloutsList();
            }
          };

  private static final PagedListDescriptor<
          ListRolloutKindsRequest, ListRolloutKindsResponse, RolloutKind>
      LIST_ROLLOUT_KINDS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListRolloutKindsRequest, ListRolloutKindsResponse, RolloutKind>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRolloutKindsRequest injectToken(
                ListRolloutKindsRequest payload, String token) {
              return ListRolloutKindsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRolloutKindsRequest injectPageSize(
                ListRolloutKindsRequest payload, int pageSize) {
              return ListRolloutKindsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListRolloutKindsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListRolloutKindsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<RolloutKind> extractResources(ListRolloutKindsResponse payload) {
              return payload.getRolloutKindsList();
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
          ListRolloutsRequest, ListRolloutsResponse, ListRolloutsPagedResponse>
      LIST_ROLLOUTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRolloutsRequest, ListRolloutsResponse, ListRolloutsPagedResponse>() {
            @Override
            public ApiFuture<ListRolloutsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRolloutsRequest, ListRolloutsResponse> callable,
                ListRolloutsRequest request,
                ApiCallContext context,
                ApiFuture<ListRolloutsResponse> futureResponse) {
              PageContext<ListRolloutsRequest, ListRolloutsResponse, Rollout> pageContext =
                  PageContext.create(callable, LIST_ROLLOUTS_PAGE_STR_DESC, request, context);
              return ListRolloutsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListRolloutKindsRequest, ListRolloutKindsResponse, ListRolloutKindsPagedResponse>
      LIST_ROLLOUT_KINDS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRolloutKindsRequest, ListRolloutKindsResponse, ListRolloutKindsPagedResponse>() {
            @Override
            public ApiFuture<ListRolloutKindsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRolloutKindsRequest, ListRolloutKindsResponse> callable,
                ListRolloutKindsRequest request,
                ApiCallContext context,
                ApiFuture<ListRolloutKindsResponse> futureResponse) {
              PageContext<ListRolloutKindsRequest, ListRolloutKindsResponse, RolloutKind>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ROLLOUT_KINDS_PAGE_STR_DESC, request, context);
              return ListRolloutKindsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listRollouts. */
  public PagedCallSettings<ListRolloutsRequest, ListRolloutsResponse, ListRolloutsPagedResponse>
      listRolloutsSettings() {
    return listRolloutsSettings;
  }

  /** Returns the object with the settings used for calls to getRollout. */
  public UnaryCallSettings<GetRolloutRequest, Rollout> getRolloutSettings() {
    return getRolloutSettings;
  }

  /** Returns the object with the settings used for calls to createRollout. */
  public UnaryCallSettings<CreateRolloutRequest, Rollout> createRolloutSettings() {
    return createRolloutSettings;
  }

  /** Returns the object with the settings used for calls to updateRollout. */
  public UnaryCallSettings<UpdateRolloutRequest, Rollout> updateRolloutSettings() {
    return updateRolloutSettings;
  }

  /** Returns the object with the settings used for calls to deleteRollout. */
  public UnaryCallSettings<DeleteRolloutRequest, Empty> deleteRolloutSettings() {
    return deleteRolloutSettings;
  }

  /** Returns the object with the settings used for calls to listRolloutKinds. */
  public PagedCallSettings<
          ListRolloutKindsRequest, ListRolloutKindsResponse, ListRolloutKindsPagedResponse>
      listRolloutKindsSettings() {
    return listRolloutKindsSettings;
  }

  /** Returns the object with the settings used for calls to getRolloutKind. */
  public UnaryCallSettings<GetRolloutKindRequest, RolloutKind> getRolloutKindSettings() {
    return getRolloutKindSettings;
  }

  /** Returns the object with the settings used for calls to createRolloutKind. */
  public UnaryCallSettings<CreateRolloutKindRequest, RolloutKind> createRolloutKindSettings() {
    return createRolloutKindSettings;
  }

  /** Returns the object with the settings used for calls to updateRolloutKind. */
  public UnaryCallSettings<UpdateRolloutKindRequest, RolloutKind> updateRolloutKindSettings() {
    return updateRolloutKindSettings;
  }

  /** Returns the object with the settings used for calls to deleteRolloutKind. */
  public UnaryCallSettings<DeleteRolloutKindRequest, Empty> deleteRolloutKindSettings() {
    return deleteRolloutKindSettings;
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

  public SaasRolloutsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcSaasRolloutsStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonSaasRolloutsStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "saasservicemgmt";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "saasservicemgmt.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "saasservicemgmt.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(SaasRolloutsStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(SaasRolloutsStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SaasRolloutsStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected SaasRolloutsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listRolloutsSettings = settingsBuilder.listRolloutsSettings().build();
    getRolloutSettings = settingsBuilder.getRolloutSettings().build();
    createRolloutSettings = settingsBuilder.createRolloutSettings().build();
    updateRolloutSettings = settingsBuilder.updateRolloutSettings().build();
    deleteRolloutSettings = settingsBuilder.deleteRolloutSettings().build();
    listRolloutKindsSettings = settingsBuilder.listRolloutKindsSettings().build();
    getRolloutKindSettings = settingsBuilder.getRolloutKindSettings().build();
    createRolloutKindSettings = settingsBuilder.createRolloutKindSettings().build();
    updateRolloutKindSettings = settingsBuilder.updateRolloutKindSettings().build();
    deleteRolloutKindSettings = settingsBuilder.deleteRolloutKindSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for SaasRolloutsStubSettings. */
  public static class Builder extends StubSettings.Builder<SaasRolloutsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListRolloutsRequest, ListRolloutsResponse, ListRolloutsPagedResponse>
        listRolloutsSettings;
    private final UnaryCallSettings.Builder<GetRolloutRequest, Rollout> getRolloutSettings;
    private final UnaryCallSettings.Builder<CreateRolloutRequest, Rollout> createRolloutSettings;
    private final UnaryCallSettings.Builder<UpdateRolloutRequest, Rollout> updateRolloutSettings;
    private final UnaryCallSettings.Builder<DeleteRolloutRequest, Empty> deleteRolloutSettings;
    private final PagedCallSettings.Builder<
            ListRolloutKindsRequest, ListRolloutKindsResponse, ListRolloutKindsPagedResponse>
        listRolloutKindsSettings;
    private final UnaryCallSettings.Builder<GetRolloutKindRequest, RolloutKind>
        getRolloutKindSettings;
    private final UnaryCallSettings.Builder<CreateRolloutKindRequest, RolloutKind>
        createRolloutKindSettings;
    private final UnaryCallSettings.Builder<UpdateRolloutKindRequest, RolloutKind>
        updateRolloutKindSettings;
    private final UnaryCallSettings.Builder<DeleteRolloutKindRequest, Empty>
        deleteRolloutKindSettings;
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
          "retry_policy_2_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_6_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_3_codes",
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
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(10000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_2_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_6_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(10000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(540000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(540000L))
              .setTotalTimeoutDuration(Duration.ofMillis(540000L))
              .build();
      definitions.put("retry_policy_3_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listRolloutsSettings = PagedCallSettings.newBuilder(LIST_ROLLOUTS_PAGE_STR_FACT);
      getRolloutSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createRolloutSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateRolloutSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteRolloutSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listRolloutKindsSettings = PagedCallSettings.newBuilder(LIST_ROLLOUT_KINDS_PAGE_STR_FACT);
      getRolloutKindSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createRolloutKindSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateRolloutKindSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteRolloutKindSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listRolloutsSettings,
              getRolloutSettings,
              createRolloutSettings,
              updateRolloutSettings,
              deleteRolloutSettings,
              listRolloutKindsSettings,
              getRolloutKindSettings,
              createRolloutKindSettings,
              updateRolloutKindSettings,
              deleteRolloutKindSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(SaasRolloutsStubSettings settings) {
      super(settings);

      listRolloutsSettings = settings.listRolloutsSettings.toBuilder();
      getRolloutSettings = settings.getRolloutSettings.toBuilder();
      createRolloutSettings = settings.createRolloutSettings.toBuilder();
      updateRolloutSettings = settings.updateRolloutSettings.toBuilder();
      deleteRolloutSettings = settings.deleteRolloutSettings.toBuilder();
      listRolloutKindsSettings = settings.listRolloutKindsSettings.toBuilder();
      getRolloutKindSettings = settings.getRolloutKindSettings.toBuilder();
      createRolloutKindSettings = settings.createRolloutKindSettings.toBuilder();
      updateRolloutKindSettings = settings.updateRolloutKindSettings.toBuilder();
      deleteRolloutKindSettings = settings.deleteRolloutKindSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listRolloutsSettings,
              getRolloutSettings,
              createRolloutSettings,
              updateRolloutSettings,
              deleteRolloutSettings,
              listRolloutKindsSettings,
              getRolloutKindSettings,
              createRolloutKindSettings,
              updateRolloutKindSettings,
              deleteRolloutKindSettings,
              listLocationsSettings,
              getLocationSettings);
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
          .listRolloutsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .getRolloutSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .createRolloutSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_6_params"));

      builder
          .updateRolloutSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_6_params"));

      builder
          .deleteRolloutSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .listRolloutKindsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .getRolloutKindSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .createRolloutKindSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_6_params"));

      builder
          .updateRolloutKindSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_6_params"));

      builder
          .deleteRolloutKindSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

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

    /** Returns the builder for the settings used for calls to listRollouts. */
    public PagedCallSettings.Builder<
            ListRolloutsRequest, ListRolloutsResponse, ListRolloutsPagedResponse>
        listRolloutsSettings() {
      return listRolloutsSettings;
    }

    /** Returns the builder for the settings used for calls to getRollout. */
    public UnaryCallSettings.Builder<GetRolloutRequest, Rollout> getRolloutSettings() {
      return getRolloutSettings;
    }

    /** Returns the builder for the settings used for calls to createRollout. */
    public UnaryCallSettings.Builder<CreateRolloutRequest, Rollout> createRolloutSettings() {
      return createRolloutSettings;
    }

    /** Returns the builder for the settings used for calls to updateRollout. */
    public UnaryCallSettings.Builder<UpdateRolloutRequest, Rollout> updateRolloutSettings() {
      return updateRolloutSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRollout. */
    public UnaryCallSettings.Builder<DeleteRolloutRequest, Empty> deleteRolloutSettings() {
      return deleteRolloutSettings;
    }

    /** Returns the builder for the settings used for calls to listRolloutKinds. */
    public PagedCallSettings.Builder<
            ListRolloutKindsRequest, ListRolloutKindsResponse, ListRolloutKindsPagedResponse>
        listRolloutKindsSettings() {
      return listRolloutKindsSettings;
    }

    /** Returns the builder for the settings used for calls to getRolloutKind. */
    public UnaryCallSettings.Builder<GetRolloutKindRequest, RolloutKind> getRolloutKindSettings() {
      return getRolloutKindSettings;
    }

    /** Returns the builder for the settings used for calls to createRolloutKind. */
    public UnaryCallSettings.Builder<CreateRolloutKindRequest, RolloutKind>
        createRolloutKindSettings() {
      return createRolloutKindSettings;
    }

    /** Returns the builder for the settings used for calls to updateRolloutKind. */
    public UnaryCallSettings.Builder<UpdateRolloutKindRequest, RolloutKind>
        updateRolloutKindSettings() {
      return updateRolloutKindSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRolloutKind. */
    public UnaryCallSettings.Builder<DeleteRolloutKindRequest, Empty> deleteRolloutKindSettings() {
      return deleteRolloutKindSettings;
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
    public SaasRolloutsStubSettings build() throws IOException {
      return new SaasRolloutsStubSettings(this);
    }
  }
}
