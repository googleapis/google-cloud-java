/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.RegionHealthCheckServiceClient.ListRegionHealthCheckServicesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
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
import com.google.cloud.compute.v1.DeleteRegionHealthCheckServiceHttpRequest;
import com.google.cloud.compute.v1.GetRegionHealthCheckServiceHttpRequest;
import com.google.cloud.compute.v1.HealthCheckService;
import com.google.cloud.compute.v1.HealthCheckServicesList;
import com.google.cloud.compute.v1.InsertRegionHealthCheckServiceHttpRequest;
import com.google.cloud.compute.v1.ListRegionHealthCheckServicesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchRegionHealthCheckServiceHttpRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link RegionHealthCheckServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (https://compute.googleapis.com/compute/v1/projects/) and
 *       default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of deleteRegionHealthCheckService to 30 seconds:
 *
 * <pre>
 * <code>
 * RegionHealthCheckServiceStubSettings.Builder regionHealthCheckServiceSettingsBuilder =
 *     RegionHealthCheckServiceStubSettings.newBuilder();
 * regionHealthCheckServiceSettingsBuilder
 *     .deleteRegionHealthCheckServiceSettings()
 *     .setRetrySettings(
 *         regionHealthCheckServiceSettingsBuilder.deleteRegionHealthCheckServiceSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * RegionHealthCheckServiceStubSettings regionHealthCheckServiceSettings = regionHealthCheckServiceSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionHealthCheckServiceStubSettings
    extends StubSettings<RegionHealthCheckServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/compute.readonly")
          .add("https://www.googleapis.com/auth/devstorage.full_control")
          .add("https://www.googleapis.com/auth/devstorage.read_only")
          .add("https://www.googleapis.com/auth/devstorage.read_write")
          .build();

  private final UnaryCallSettings<DeleteRegionHealthCheckServiceHttpRequest, Operation>
      deleteRegionHealthCheckServiceSettings;
  private final UnaryCallSettings<GetRegionHealthCheckServiceHttpRequest, HealthCheckService>
      getRegionHealthCheckServiceSettings;
  private final UnaryCallSettings<InsertRegionHealthCheckServiceHttpRequest, Operation>
      insertRegionHealthCheckServiceSettings;
  private final PagedCallSettings<
          ListRegionHealthCheckServicesHttpRequest,
          HealthCheckServicesList,
          ListRegionHealthCheckServicesPagedResponse>
      listRegionHealthCheckServicesSettings;
  private final UnaryCallSettings<PatchRegionHealthCheckServiceHttpRequest, Operation>
      patchRegionHealthCheckServiceSettings;

  /** Returns the object with the settings used for calls to deleteRegionHealthCheckService. */
  public UnaryCallSettings<DeleteRegionHealthCheckServiceHttpRequest, Operation>
      deleteRegionHealthCheckServiceSettings() {
    return deleteRegionHealthCheckServiceSettings;
  }

  /** Returns the object with the settings used for calls to getRegionHealthCheckService. */
  public UnaryCallSettings<GetRegionHealthCheckServiceHttpRequest, HealthCheckService>
      getRegionHealthCheckServiceSettings() {
    return getRegionHealthCheckServiceSettings;
  }

  /** Returns the object with the settings used for calls to insertRegionHealthCheckService. */
  public UnaryCallSettings<InsertRegionHealthCheckServiceHttpRequest, Operation>
      insertRegionHealthCheckServiceSettings() {
    return insertRegionHealthCheckServiceSettings;
  }

  /** Returns the object with the settings used for calls to listRegionHealthCheckServices. */
  public PagedCallSettings<
          ListRegionHealthCheckServicesHttpRequest,
          HealthCheckServicesList,
          ListRegionHealthCheckServicesPagedResponse>
      listRegionHealthCheckServicesSettings() {
    return listRegionHealthCheckServicesSettings;
  }

  /** Returns the object with the settings used for calls to patchRegionHealthCheckService. */
  public UnaryCallSettings<PatchRegionHealthCheckServiceHttpRequest, Operation>
      patchRegionHealthCheckServiceSettings() {
    return patchRegionHealthCheckServiceSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RegionHealthCheckServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonRegionHealthCheckServiceStub.create(this);
    } else {
      throw new UnsupportedOperationException(
          "Transport not supported: " + getTransportChannelProvider().getTransportName());
    }
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "https://compute.googleapis.com/compute/v1/projects/";
  }

  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return 443;
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
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultHttpJsonTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(RegionHealthCheckServiceStubSettings.class))
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

  protected RegionHealthCheckServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    deleteRegionHealthCheckServiceSettings =
        settingsBuilder.deleteRegionHealthCheckServiceSettings().build();
    getRegionHealthCheckServiceSettings =
        settingsBuilder.getRegionHealthCheckServiceSettings().build();
    insertRegionHealthCheckServiceSettings =
        settingsBuilder.insertRegionHealthCheckServiceSettings().build();
    listRegionHealthCheckServicesSettings =
        settingsBuilder.listRegionHealthCheckServicesSettings().build();
    patchRegionHealthCheckServiceSettings =
        settingsBuilder.patchRegionHealthCheckServiceSettings().build();
  }

  private static final PagedListDescriptor<
          ListRegionHealthCheckServicesHttpRequest, HealthCheckServicesList, HealthCheckService>
      LIST_REGION_HEALTH_CHECK_SERVICES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListRegionHealthCheckServicesHttpRequest,
              HealthCheckServicesList,
              HealthCheckService>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRegionHealthCheckServicesHttpRequest injectToken(
                ListRegionHealthCheckServicesHttpRequest payload, String token) {
              return ListRegionHealthCheckServicesHttpRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListRegionHealthCheckServicesHttpRequest injectPageSize(
                ListRegionHealthCheckServicesHttpRequest payload, int pageSize) {
              return ListRegionHealthCheckServicesHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListRegionHealthCheckServicesHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(HealthCheckServicesList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<HealthCheckService> extractResources(HealthCheckServicesList payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<HealthCheckService>of();
            }
          };

  private static final PagedListResponseFactory<
          ListRegionHealthCheckServicesHttpRequest,
          HealthCheckServicesList,
          ListRegionHealthCheckServicesPagedResponse>
      LIST_REGION_HEALTH_CHECK_SERVICES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRegionHealthCheckServicesHttpRequest,
              HealthCheckServicesList,
              ListRegionHealthCheckServicesPagedResponse>() {
            @Override
            public ApiFuture<ListRegionHealthCheckServicesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRegionHealthCheckServicesHttpRequest, HealthCheckServicesList>
                    callable,
                ListRegionHealthCheckServicesHttpRequest request,
                ApiCallContext context,
                ApiFuture<HealthCheckServicesList> futureResponse) {
              PageContext<
                      ListRegionHealthCheckServicesHttpRequest,
                      HealthCheckServicesList,
                      HealthCheckService>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_REGION_HEALTH_CHECK_SERVICES_PAGE_STR_DESC,
                          request,
                          context);
              return ListRegionHealthCheckServicesPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Builder for RegionHealthCheckServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<RegionHealthCheckServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<DeleteRegionHealthCheckServiceHttpRequest, Operation>
        deleteRegionHealthCheckServiceSettings;
    private final UnaryCallSettings.Builder<
            GetRegionHealthCheckServiceHttpRequest, HealthCheckService>
        getRegionHealthCheckServiceSettings;
    private final UnaryCallSettings.Builder<InsertRegionHealthCheckServiceHttpRequest, Operation>
        insertRegionHealthCheckServiceSettings;
    private final PagedCallSettings.Builder<
            ListRegionHealthCheckServicesHttpRequest,
            HealthCheckServicesList,
            ListRegionHealthCheckServicesPagedResponse>
        listRegionHealthCheckServicesSettings;
    private final UnaryCallSettings.Builder<PatchRegionHealthCheckServiceHttpRequest, Operation>
        patchRegionHealthCheckServiceSettings;

    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "idempotent",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put("non_idempotent", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
              .setInitialRpcTimeout(Duration.ofMillis(20000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(20000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("default", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      deleteRegionHealthCheckServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getRegionHealthCheckServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      insertRegionHealthCheckServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listRegionHealthCheckServicesSettings =
          PagedCallSettings.newBuilder(LIST_REGION_HEALTH_CHECK_SERVICES_PAGE_STR_FACT);

      patchRegionHealthCheckServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deleteRegionHealthCheckServiceSettings,
              getRegionHealthCheckServiceSettings,
              insertRegionHealthCheckServiceSettings,
              listRegionHealthCheckServicesSettings,
              patchRegionHealthCheckServiceSettings);

      initDefaults(this);
    }

    private static Builder createDefault() {
      Builder builder = new Builder((ClientContext) null);
      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {

      builder
          .deleteRegionHealthCheckServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getRegionHealthCheckServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .insertRegionHealthCheckServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listRegionHealthCheckServicesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .patchRegionHealthCheckServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(RegionHealthCheckServiceStubSettings settings) {
      super(settings);

      deleteRegionHealthCheckServiceSettings =
          settings.deleteRegionHealthCheckServiceSettings.toBuilder();
      getRegionHealthCheckServiceSettings =
          settings.getRegionHealthCheckServiceSettings.toBuilder();
      insertRegionHealthCheckServiceSettings =
          settings.insertRegionHealthCheckServiceSettings.toBuilder();
      listRegionHealthCheckServicesSettings =
          settings.listRegionHealthCheckServicesSettings.toBuilder();
      patchRegionHealthCheckServiceSettings =
          settings.patchRegionHealthCheckServiceSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deleteRegionHealthCheckServiceSettings,
              getRegionHealthCheckServiceSettings,
              insertRegionHealthCheckServiceSettings,
              listRegionHealthCheckServicesSettings,
              patchRegionHealthCheckServiceSettings);
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
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

    /** Returns the builder for the settings used for calls to deleteRegionHealthCheckService. */
    public UnaryCallSettings.Builder<DeleteRegionHealthCheckServiceHttpRequest, Operation>
        deleteRegionHealthCheckServiceSettings() {
      return deleteRegionHealthCheckServiceSettings;
    }

    /** Returns the builder for the settings used for calls to getRegionHealthCheckService. */
    public UnaryCallSettings.Builder<GetRegionHealthCheckServiceHttpRequest, HealthCheckService>
        getRegionHealthCheckServiceSettings() {
      return getRegionHealthCheckServiceSettings;
    }

    /** Returns the builder for the settings used for calls to insertRegionHealthCheckService. */
    public UnaryCallSettings.Builder<InsertRegionHealthCheckServiceHttpRequest, Operation>
        insertRegionHealthCheckServiceSettings() {
      return insertRegionHealthCheckServiceSettings;
    }

    /** Returns the builder for the settings used for calls to listRegionHealthCheckServices. */
    public PagedCallSettings.Builder<
            ListRegionHealthCheckServicesHttpRequest,
            HealthCheckServicesList,
            ListRegionHealthCheckServicesPagedResponse>
        listRegionHealthCheckServicesSettings() {
      return listRegionHealthCheckServicesSettings;
    }

    /** Returns the builder for the settings used for calls to patchRegionHealthCheckService. */
    public UnaryCallSettings.Builder<PatchRegionHealthCheckServiceHttpRequest, Operation>
        patchRegionHealthCheckServiceSettings() {
      return patchRegionHealthCheckServiceSettings;
    }

    @Override
    public RegionHealthCheckServiceStubSettings build() throws IOException {
      return new RegionHealthCheckServiceStubSettings(this);
    }
  }
}
