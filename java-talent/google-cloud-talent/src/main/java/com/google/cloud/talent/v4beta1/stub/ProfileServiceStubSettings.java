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

package com.google.cloud.talent.v4beta1.stub;

import static com.google.cloud.talent.v4beta1.ProfileServiceClient.ListProfilesPagedResponse;
import static com.google.cloud.talent.v4beta1.ProfileServiceClient.SearchProfilesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
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
import com.google.cloud.talent.v4beta1.CreateProfileRequest;
import com.google.cloud.talent.v4beta1.DeleteProfileRequest;
import com.google.cloud.talent.v4beta1.GetProfileRequest;
import com.google.cloud.talent.v4beta1.HistogramQueryResult;
import com.google.cloud.talent.v4beta1.ListProfilesRequest;
import com.google.cloud.talent.v4beta1.ListProfilesResponse;
import com.google.cloud.talent.v4beta1.Profile;
import com.google.cloud.talent.v4beta1.SearchProfilesRequest;
import com.google.cloud.talent.v4beta1.SearchProfilesResponse;
import com.google.cloud.talent.v4beta1.UpdateProfileRequest;
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
 * Settings class to configure an instance of {@link ProfileServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (jobs.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createProfile to 30 seconds:
 *
 * <pre>{@code
 * ProfileServiceStubSettings.Builder profileServiceSettingsBuilder =
 *     ProfileServiceStubSettings.newBuilder();
 * profileServiceSettingsBuilder
 *     .createProfileSettings()
 *     .setRetrySettings(
 *         profileServiceSettingsBuilder
 *             .createProfileSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ProfileServiceStubSettings profileServiceSettings = profileServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ProfileServiceStubSettings extends StubSettings<ProfileServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/jobs")
          .build();

  private final PagedCallSettings<
          ListProfilesRequest, ListProfilesResponse, ListProfilesPagedResponse>
      listProfilesSettings;
  private final UnaryCallSettings<CreateProfileRequest, Profile> createProfileSettings;
  private final UnaryCallSettings<GetProfileRequest, Profile> getProfileSettings;
  private final UnaryCallSettings<UpdateProfileRequest, Profile> updateProfileSettings;
  private final UnaryCallSettings<DeleteProfileRequest, Empty> deleteProfileSettings;
  private final PagedCallSettings<
          SearchProfilesRequest, SearchProfilesResponse, SearchProfilesPagedResponse>
      searchProfilesSettings;

  private static final PagedListDescriptor<ListProfilesRequest, ListProfilesResponse, Profile>
      LIST_PROFILES_PAGE_STR_DESC =
          new PagedListDescriptor<ListProfilesRequest, ListProfilesResponse, Profile>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListProfilesRequest injectToken(ListProfilesRequest payload, String token) {
              return ListProfilesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListProfilesRequest injectPageSize(ListProfilesRequest payload, int pageSize) {
              return ListProfilesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListProfilesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListProfilesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Profile> extractResources(ListProfilesResponse payload) {
              return payload.getProfilesList() == null
                  ? ImmutableList.<Profile>of()
                  : payload.getProfilesList();
            }
          };

  private static final PagedListDescriptor<
          SearchProfilesRequest, SearchProfilesResponse, HistogramQueryResult>
      SEARCH_PROFILES_PAGE_STR_DESC =
          new PagedListDescriptor<
              SearchProfilesRequest, SearchProfilesResponse, HistogramQueryResult>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchProfilesRequest injectToken(SearchProfilesRequest payload, String token) {
              return SearchProfilesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public SearchProfilesRequest injectPageSize(
                SearchProfilesRequest payload, int pageSize) {
              return SearchProfilesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(SearchProfilesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchProfilesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<HistogramQueryResult> extractResources(SearchProfilesResponse payload) {
              return payload.getHistogramQueryResultsList() == null
                  ? ImmutableList.<HistogramQueryResult>of()
                  : payload.getHistogramQueryResultsList();
            }
          };

  private static final PagedListResponseFactory<
          ListProfilesRequest, ListProfilesResponse, ListProfilesPagedResponse>
      LIST_PROFILES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListProfilesRequest, ListProfilesResponse, ListProfilesPagedResponse>() {
            @Override
            public ApiFuture<ListProfilesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListProfilesRequest, ListProfilesResponse> callable,
                ListProfilesRequest request,
                ApiCallContext context,
                ApiFuture<ListProfilesResponse> futureResponse) {
              PageContext<ListProfilesRequest, ListProfilesResponse, Profile> pageContext =
                  PageContext.create(callable, LIST_PROFILES_PAGE_STR_DESC, request, context);
              return ListProfilesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          SearchProfilesRequest, SearchProfilesResponse, SearchProfilesPagedResponse>
      SEARCH_PROFILES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchProfilesRequest, SearchProfilesResponse, SearchProfilesPagedResponse>() {
            @Override
            public ApiFuture<SearchProfilesPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchProfilesRequest, SearchProfilesResponse> callable,
                SearchProfilesRequest request,
                ApiCallContext context,
                ApiFuture<SearchProfilesResponse> futureResponse) {
              PageContext<SearchProfilesRequest, SearchProfilesResponse, HistogramQueryResult>
                  pageContext =
                      PageContext.create(callable, SEARCH_PROFILES_PAGE_STR_DESC, request, context);
              return SearchProfilesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listProfiles. */
  public PagedCallSettings<ListProfilesRequest, ListProfilesResponse, ListProfilesPagedResponse>
      listProfilesSettings() {
    return listProfilesSettings;
  }

  /** Returns the object with the settings used for calls to createProfile. */
  public UnaryCallSettings<CreateProfileRequest, Profile> createProfileSettings() {
    return createProfileSettings;
  }

  /** Returns the object with the settings used for calls to getProfile. */
  public UnaryCallSettings<GetProfileRequest, Profile> getProfileSettings() {
    return getProfileSettings;
  }

  /** Returns the object with the settings used for calls to updateProfile. */
  public UnaryCallSettings<UpdateProfileRequest, Profile> updateProfileSettings() {
    return updateProfileSettings;
  }

  /** Returns the object with the settings used for calls to deleteProfile. */
  public UnaryCallSettings<DeleteProfileRequest, Empty> deleteProfileSettings() {
    return deleteProfileSettings;
  }

  /** Returns the object with the settings used for calls to searchProfiles. */
  public PagedCallSettings<
          SearchProfilesRequest, SearchProfilesResponse, SearchProfilesPagedResponse>
      searchProfilesSettings() {
    return searchProfilesSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ProfileServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcProfileServiceStub.create(this);
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
    return "jobs.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(ProfileServiceStubSettings.class))
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

  protected ProfileServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listProfilesSettings = settingsBuilder.listProfilesSettings().build();
    createProfileSettings = settingsBuilder.createProfileSettings().build();
    getProfileSettings = settingsBuilder.getProfileSettings().build();
    updateProfileSettings = settingsBuilder.updateProfileSettings().build();
    deleteProfileSettings = settingsBuilder.deleteProfileSettings().build();
    searchProfilesSettings = settingsBuilder.searchProfilesSettings().build();
  }

  /** Builder for ProfileServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<ProfileServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListProfilesRequest, ListProfilesResponse, ListProfilesPagedResponse>
        listProfilesSettings;
    private final UnaryCallSettings.Builder<CreateProfileRequest, Profile> createProfileSettings;
    private final UnaryCallSettings.Builder<GetProfileRequest, Profile> getProfileSettings;
    private final UnaryCallSettings.Builder<UpdateProfileRequest, Profile> updateProfileSettings;
    private final UnaryCallSettings.Builder<DeleteProfileRequest, Empty> deleteProfileSettings;
    private final PagedCallSettings.Builder<
            SearchProfilesRequest, SearchProfilesResponse, SearchProfilesPagedResponse>
        searchProfilesSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_6_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_4_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
              .setInitialRpcTimeout(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(30000L))
              .setTotalTimeout(Duration.ofMillis(30000L))
              .build();
      definitions.put("retry_policy_6_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(30000L))
              .setTotalTimeout(Duration.ofMillis(30000L))
              .build();
      definitions.put("no_retry_4_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listProfilesSettings = PagedCallSettings.newBuilder(LIST_PROFILES_PAGE_STR_FACT);
      createProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      searchProfilesSettings = PagedCallSettings.newBuilder(SEARCH_PROFILES_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listProfilesSettings,
              createProfileSettings,
              getProfileSettings,
              updateProfileSettings,
              deleteProfileSettings,
              searchProfilesSettings);
      initDefaults(this);
    }

    protected Builder(ProfileServiceStubSettings settings) {
      super(settings);

      listProfilesSettings = settings.listProfilesSettings.toBuilder();
      createProfileSettings = settings.createProfileSettings.toBuilder();
      getProfileSettings = settings.getProfileSettings.toBuilder();
      updateProfileSettings = settings.updateProfileSettings.toBuilder();
      deleteProfileSettings = settings.deleteProfileSettings.toBuilder();
      searchProfilesSettings = settings.searchProfilesSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listProfilesSettings,
              createProfileSettings,
              getProfileSettings,
              updateProfileSettings,
              deleteProfileSettings,
              searchProfilesSettings);
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
          .listProfilesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_6_params"));

      builder
          .createProfileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_4_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_4_params"));

      builder
          .getProfileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_6_params"));

      builder
          .updateProfileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_4_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_4_params"));

      builder
          .deleteProfileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_6_params"));

      builder
          .searchProfilesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_4_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_4_params"));

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

    /** Returns the builder for the settings used for calls to listProfiles. */
    public PagedCallSettings.Builder<
            ListProfilesRequest, ListProfilesResponse, ListProfilesPagedResponse>
        listProfilesSettings() {
      return listProfilesSettings;
    }

    /** Returns the builder for the settings used for calls to createProfile. */
    public UnaryCallSettings.Builder<CreateProfileRequest, Profile> createProfileSettings() {
      return createProfileSettings;
    }

    /** Returns the builder for the settings used for calls to getProfile. */
    public UnaryCallSettings.Builder<GetProfileRequest, Profile> getProfileSettings() {
      return getProfileSettings;
    }

    /** Returns the builder for the settings used for calls to updateProfile. */
    public UnaryCallSettings.Builder<UpdateProfileRequest, Profile> updateProfileSettings() {
      return updateProfileSettings;
    }

    /** Returns the builder for the settings used for calls to deleteProfile. */
    public UnaryCallSettings.Builder<DeleteProfileRequest, Empty> deleteProfileSettings() {
      return deleteProfileSettings;
    }

    /** Returns the builder for the settings used for calls to searchProfiles. */
    public PagedCallSettings.Builder<
            SearchProfilesRequest, SearchProfilesResponse, SearchProfilesPagedResponse>
        searchProfilesSettings() {
      return searchProfilesSettings;
    }

    @Override
    public ProfileServiceStubSettings build() throws IOException {
      return new ProfileServiceStubSettings(this);
    }
  }
}
