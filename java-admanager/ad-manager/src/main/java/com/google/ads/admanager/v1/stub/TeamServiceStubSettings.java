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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.TeamServiceClient.ListTeamsPagedResponse;

import com.google.ads.admanager.v1.BatchActivateTeamsRequest;
import com.google.ads.admanager.v1.BatchActivateTeamsResponse;
import com.google.ads.admanager.v1.BatchCreateTeamsRequest;
import com.google.ads.admanager.v1.BatchCreateTeamsResponse;
import com.google.ads.admanager.v1.BatchDeactivateTeamsRequest;
import com.google.ads.admanager.v1.BatchDeactivateTeamsResponse;
import com.google.ads.admanager.v1.BatchUpdateTeamsRequest;
import com.google.ads.admanager.v1.BatchUpdateTeamsResponse;
import com.google.ads.admanager.v1.CreateTeamRequest;
import com.google.ads.admanager.v1.GetTeamRequest;
import com.google.ads.admanager.v1.ListTeamsRequest;
import com.google.ads.admanager.v1.ListTeamsResponse;
import com.google.ads.admanager.v1.Team;
import com.google.ads.admanager.v1.UpdateTeamRequest;
import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link TeamServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (admanager.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getTeam:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TeamServiceStubSettings.Builder teamServiceSettingsBuilder =
 *     TeamServiceStubSettings.newBuilder();
 * teamServiceSettingsBuilder
 *     .getTeamSettings()
 *     .setRetrySettings(
 *         teamServiceSettingsBuilder
 *             .getTeamSettings()
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
 * TeamServiceStubSettings teamServiceSettings = teamServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class TeamServiceStubSettings extends StubSettings<TeamServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/admanager").build();

  private final UnaryCallSettings<GetTeamRequest, Team> getTeamSettings;
  private final PagedCallSettings<ListTeamsRequest, ListTeamsResponse, ListTeamsPagedResponse>
      listTeamsSettings;
  private final UnaryCallSettings<CreateTeamRequest, Team> createTeamSettings;
  private final UnaryCallSettings<BatchCreateTeamsRequest, BatchCreateTeamsResponse>
      batchCreateTeamsSettings;
  private final UnaryCallSettings<UpdateTeamRequest, Team> updateTeamSettings;
  private final UnaryCallSettings<BatchUpdateTeamsRequest, BatchUpdateTeamsResponse>
      batchUpdateTeamsSettings;
  private final UnaryCallSettings<BatchActivateTeamsRequest, BatchActivateTeamsResponse>
      batchActivateTeamsSettings;
  private final UnaryCallSettings<BatchDeactivateTeamsRequest, BatchDeactivateTeamsResponse>
      batchDeactivateTeamsSettings;

  private static final PagedListDescriptor<ListTeamsRequest, ListTeamsResponse, Team>
      LIST_TEAMS_PAGE_STR_DESC =
          new PagedListDescriptor<ListTeamsRequest, ListTeamsResponse, Team>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTeamsRequest injectToken(ListTeamsRequest payload, String token) {
              return ListTeamsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTeamsRequest injectPageSize(ListTeamsRequest payload, int pageSize) {
              return ListTeamsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTeamsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTeamsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Team> extractResources(ListTeamsResponse payload) {
              return payload.getTeamsList();
            }
          };

  private static final PagedListResponseFactory<
          ListTeamsRequest, ListTeamsResponse, ListTeamsPagedResponse>
      LIST_TEAMS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTeamsRequest, ListTeamsResponse, ListTeamsPagedResponse>() {
            @Override
            public ApiFuture<ListTeamsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTeamsRequest, ListTeamsResponse> callable,
                ListTeamsRequest request,
                ApiCallContext context,
                ApiFuture<ListTeamsResponse> futureResponse) {
              PageContext<ListTeamsRequest, ListTeamsResponse, Team> pageContext =
                  PageContext.create(callable, LIST_TEAMS_PAGE_STR_DESC, request, context);
              return ListTeamsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getTeam. */
  public UnaryCallSettings<GetTeamRequest, Team> getTeamSettings() {
    return getTeamSettings;
  }

  /** Returns the object with the settings used for calls to listTeams. */
  public PagedCallSettings<ListTeamsRequest, ListTeamsResponse, ListTeamsPagedResponse>
      listTeamsSettings() {
    return listTeamsSettings;
  }

  /** Returns the object with the settings used for calls to createTeam. */
  public UnaryCallSettings<CreateTeamRequest, Team> createTeamSettings() {
    return createTeamSettings;
  }

  /** Returns the object with the settings used for calls to batchCreateTeams. */
  public UnaryCallSettings<BatchCreateTeamsRequest, BatchCreateTeamsResponse>
      batchCreateTeamsSettings() {
    return batchCreateTeamsSettings;
  }

  /** Returns the object with the settings used for calls to updateTeam. */
  public UnaryCallSettings<UpdateTeamRequest, Team> updateTeamSettings() {
    return updateTeamSettings;
  }

  /** Returns the object with the settings used for calls to batchUpdateTeams. */
  public UnaryCallSettings<BatchUpdateTeamsRequest, BatchUpdateTeamsResponse>
      batchUpdateTeamsSettings() {
    return batchUpdateTeamsSettings;
  }

  /** Returns the object with the settings used for calls to batchActivateTeams. */
  public UnaryCallSettings<BatchActivateTeamsRequest, BatchActivateTeamsResponse>
      batchActivateTeamsSettings() {
    return batchActivateTeamsSettings;
  }

  /** Returns the object with the settings used for calls to batchDeactivateTeams. */
  public UnaryCallSettings<BatchDeactivateTeamsRequest, BatchDeactivateTeamsResponse>
      batchDeactivateTeamsSettings() {
    return batchDeactivateTeamsSettings;
  }

  public TeamServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonTeamServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "admanager";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "admanager.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "admanager.mtls.googleapis.com:443";
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

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultHttpJsonTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(TeamServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
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

  protected TeamServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getTeamSettings = settingsBuilder.getTeamSettings().build();
    listTeamsSettings = settingsBuilder.listTeamsSettings().build();
    createTeamSettings = settingsBuilder.createTeamSettings().build();
    batchCreateTeamsSettings = settingsBuilder.batchCreateTeamsSettings().build();
    updateTeamSettings = settingsBuilder.updateTeamSettings().build();
    batchUpdateTeamsSettings = settingsBuilder.batchUpdateTeamsSettings().build();
    batchActivateTeamsSettings = settingsBuilder.batchActivateTeamsSettings().build();
    batchDeactivateTeamsSettings = settingsBuilder.batchDeactivateTeamsSettings().build();
  }

  /** Builder for TeamServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<TeamServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetTeamRequest, Team> getTeamSettings;
    private final PagedCallSettings.Builder<
            ListTeamsRequest, ListTeamsResponse, ListTeamsPagedResponse>
        listTeamsSettings;
    private final UnaryCallSettings.Builder<CreateTeamRequest, Team> createTeamSettings;
    private final UnaryCallSettings.Builder<BatchCreateTeamsRequest, BatchCreateTeamsResponse>
        batchCreateTeamsSettings;
    private final UnaryCallSettings.Builder<UpdateTeamRequest, Team> updateTeamSettings;
    private final UnaryCallSettings.Builder<BatchUpdateTeamsRequest, BatchUpdateTeamsResponse>
        batchUpdateTeamsSettings;
    private final UnaryCallSettings.Builder<BatchActivateTeamsRequest, BatchActivateTeamsResponse>
        batchActivateTeamsSettings;
    private final UnaryCallSettings.Builder<
            BatchDeactivateTeamsRequest, BatchDeactivateTeamsResponse>
        batchDeactivateTeamsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      getTeamSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listTeamsSettings = PagedCallSettings.newBuilder(LIST_TEAMS_PAGE_STR_FACT);
      createTeamSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchCreateTeamsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateTeamSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchUpdateTeamsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchActivateTeamsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchDeactivateTeamsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getTeamSettings,
              listTeamsSettings,
              createTeamSettings,
              batchCreateTeamsSettings,
              updateTeamSettings,
              batchUpdateTeamsSettings,
              batchActivateTeamsSettings,
              batchDeactivateTeamsSettings);
      initDefaults(this);
    }

    protected Builder(TeamServiceStubSettings settings) {
      super(settings);

      getTeamSettings = settings.getTeamSettings.toBuilder();
      listTeamsSettings = settings.listTeamsSettings.toBuilder();
      createTeamSettings = settings.createTeamSettings.toBuilder();
      batchCreateTeamsSettings = settings.batchCreateTeamsSettings.toBuilder();
      updateTeamSettings = settings.updateTeamSettings.toBuilder();
      batchUpdateTeamsSettings = settings.batchUpdateTeamsSettings.toBuilder();
      batchActivateTeamsSettings = settings.batchActivateTeamsSettings.toBuilder();
      batchDeactivateTeamsSettings = settings.batchDeactivateTeamsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getTeamSettings,
              listTeamsSettings,
              createTeamSettings,
              batchCreateTeamsSettings,
              updateTeamSettings,
              batchUpdateTeamsSettings,
              batchActivateTeamsSettings,
              batchDeactivateTeamsSettings);
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

    private static Builder initDefaults(Builder builder) {
      builder
          .getTeamSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listTeamsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createTeamSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchCreateTeamsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateTeamSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchUpdateTeamsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchActivateTeamsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchDeactivateTeamsSettings()
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

    /** Returns the builder for the settings used for calls to getTeam. */
    public UnaryCallSettings.Builder<GetTeamRequest, Team> getTeamSettings() {
      return getTeamSettings;
    }

    /** Returns the builder for the settings used for calls to listTeams. */
    public PagedCallSettings.Builder<ListTeamsRequest, ListTeamsResponse, ListTeamsPagedResponse>
        listTeamsSettings() {
      return listTeamsSettings;
    }

    /** Returns the builder for the settings used for calls to createTeam. */
    public UnaryCallSettings.Builder<CreateTeamRequest, Team> createTeamSettings() {
      return createTeamSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreateTeams. */
    public UnaryCallSettings.Builder<BatchCreateTeamsRequest, BatchCreateTeamsResponse>
        batchCreateTeamsSettings() {
      return batchCreateTeamsSettings;
    }

    /** Returns the builder for the settings used for calls to updateTeam. */
    public UnaryCallSettings.Builder<UpdateTeamRequest, Team> updateTeamSettings() {
      return updateTeamSettings;
    }

    /** Returns the builder for the settings used for calls to batchUpdateTeams. */
    public UnaryCallSettings.Builder<BatchUpdateTeamsRequest, BatchUpdateTeamsResponse>
        batchUpdateTeamsSettings() {
      return batchUpdateTeamsSettings;
    }

    /** Returns the builder for the settings used for calls to batchActivateTeams. */
    public UnaryCallSettings.Builder<BatchActivateTeamsRequest, BatchActivateTeamsResponse>
        batchActivateTeamsSettings() {
      return batchActivateTeamsSettings;
    }

    /** Returns the builder for the settings used for calls to batchDeactivateTeams. */
    public UnaryCallSettings.Builder<BatchDeactivateTeamsRequest, BatchDeactivateTeamsResponse>
        batchDeactivateTeamsSettings() {
      return batchDeactivateTeamsSettings;
    }

    @Override
    public TeamServiceStubSettings build() throws IOException {
      return new TeamServiceStubSettings(this);
    }
  }
}
