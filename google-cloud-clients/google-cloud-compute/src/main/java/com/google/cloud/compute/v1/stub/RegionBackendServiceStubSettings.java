/*
 * Copyright 2018 Google LLC
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

import static com.google.cloud.compute.v1.RegionBackendServiceClient.ListRegionBackendServicesPagedResponse;

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
import com.google.cloud.compute.v1.BackendService;
import com.google.cloud.compute.v1.BackendServiceGroupHealth;
import com.google.cloud.compute.v1.BackendServiceList;
import com.google.cloud.compute.v1.DeleteRegionBackendServiceHttpRequest;
import com.google.cloud.compute.v1.GetHealthRegionBackendServiceHttpRequest;
import com.google.cloud.compute.v1.GetRegionBackendServiceHttpRequest;
import com.google.cloud.compute.v1.InsertRegionBackendServiceHttpRequest;
import com.google.cloud.compute.v1.ListRegionBackendServicesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchRegionBackendServiceHttpRequest;
import com.google.cloud.compute.v1.UpdateRegionBackendServiceHttpRequest;
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
 * Settings class to configure an instance of {@link RegionBackendServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (https://www.googleapis.com/compute/v1/projects/) and default
 *       port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of deleteRegionBackendService to 30 seconds:
 *
 * <pre>
 * <code>
 * RegionBackendServiceStubSettings.Builder regionBackendServiceSettingsBuilder =
 *     RegionBackendServiceStubSettings.newBuilder();
 * regionBackendServiceSettingsBuilder.deleteRegionBackendServiceSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * RegionBackendServiceStubSettings regionBackendServiceSettings = regionBackendServiceSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionBackendServiceStubSettings
    extends StubSettings<RegionBackendServiceStubSettings> {
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

  private final UnaryCallSettings<DeleteRegionBackendServiceHttpRequest, Operation>
      deleteRegionBackendServiceSettings;
  private final UnaryCallSettings<GetRegionBackendServiceHttpRequest, BackendService>
      getRegionBackendServiceSettings;
  private final UnaryCallSettings<
          GetHealthRegionBackendServiceHttpRequest, BackendServiceGroupHealth>
      getHealthRegionBackendServiceSettings;
  private final UnaryCallSettings<InsertRegionBackendServiceHttpRequest, Operation>
      insertRegionBackendServiceSettings;
  private final PagedCallSettings<
          ListRegionBackendServicesHttpRequest,
          BackendServiceList,
          ListRegionBackendServicesPagedResponse>
      listRegionBackendServicesSettings;
  private final UnaryCallSettings<PatchRegionBackendServiceHttpRequest, Operation>
      patchRegionBackendServiceSettings;
  private final UnaryCallSettings<UpdateRegionBackendServiceHttpRequest, Operation>
      updateRegionBackendServiceSettings;

  /** Returns the object with the settings used for calls to deleteRegionBackendService. */
  public UnaryCallSettings<DeleteRegionBackendServiceHttpRequest, Operation>
      deleteRegionBackendServiceSettings() {
    return deleteRegionBackendServiceSettings;
  }

  /** Returns the object with the settings used for calls to getRegionBackendService. */
  public UnaryCallSettings<GetRegionBackendServiceHttpRequest, BackendService>
      getRegionBackendServiceSettings() {
    return getRegionBackendServiceSettings;
  }

  /** Returns the object with the settings used for calls to getHealthRegionBackendService. */
  public UnaryCallSettings<GetHealthRegionBackendServiceHttpRequest, BackendServiceGroupHealth>
      getHealthRegionBackendServiceSettings() {
    return getHealthRegionBackendServiceSettings;
  }

  /** Returns the object with the settings used for calls to insertRegionBackendService. */
  public UnaryCallSettings<InsertRegionBackendServiceHttpRequest, Operation>
      insertRegionBackendServiceSettings() {
    return insertRegionBackendServiceSettings;
  }

  /** Returns the object with the settings used for calls to listRegionBackendServices. */
  public PagedCallSettings<
          ListRegionBackendServicesHttpRequest,
          BackendServiceList,
          ListRegionBackendServicesPagedResponse>
      listRegionBackendServicesSettings() {
    return listRegionBackendServicesSettings;
  }

  /** Returns the object with the settings used for calls to patchRegionBackendService. */
  public UnaryCallSettings<PatchRegionBackendServiceHttpRequest, Operation>
      patchRegionBackendServiceSettings() {
    return patchRegionBackendServiceSettings;
  }

  /** Returns the object with the settings used for calls to updateRegionBackendService. */
  public UnaryCallSettings<UpdateRegionBackendServiceHttpRequest, Operation>
      updateRegionBackendServiceSettings() {
    return updateRegionBackendServiceSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RegionBackendServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonRegionBackendServiceStub.create(this);
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
    return "https://www.googleapis.com/compute/v1/projects/";
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
            "gapic", GaxProperties.getLibraryVersion(RegionBackendServiceStubSettings.class))
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

  protected RegionBackendServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    deleteRegionBackendServiceSettings =
        settingsBuilder.deleteRegionBackendServiceSettings().build();
    getRegionBackendServiceSettings = settingsBuilder.getRegionBackendServiceSettings().build();
    getHealthRegionBackendServiceSettings =
        settingsBuilder.getHealthRegionBackendServiceSettings().build();
    insertRegionBackendServiceSettings =
        settingsBuilder.insertRegionBackendServiceSettings().build();
    listRegionBackendServicesSettings = settingsBuilder.listRegionBackendServicesSettings().build();
    patchRegionBackendServiceSettings = settingsBuilder.patchRegionBackendServiceSettings().build();
    updateRegionBackendServiceSettings =
        settingsBuilder.updateRegionBackendServiceSettings().build();
  }

  private static final PagedListDescriptor<
          ListRegionBackendServicesHttpRequest, BackendServiceList, BackendService>
      LIST_REGION_BACKEND_SERVICES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListRegionBackendServicesHttpRequest, BackendServiceList, BackendService>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRegionBackendServicesHttpRequest injectToken(
                ListRegionBackendServicesHttpRequest payload, String token) {
              return ListRegionBackendServicesHttpRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListRegionBackendServicesHttpRequest injectPageSize(
                ListRegionBackendServicesHttpRequest payload, int pageSize) {
              return ListRegionBackendServicesHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListRegionBackendServicesHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(BackendServiceList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<BackendService> extractResources(BackendServiceList payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<BackendService>of();
            }
          };

  private static final PagedListResponseFactory<
          ListRegionBackendServicesHttpRequest,
          BackendServiceList,
          ListRegionBackendServicesPagedResponse>
      LIST_REGION_BACKEND_SERVICES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRegionBackendServicesHttpRequest,
              BackendServiceList,
              ListRegionBackendServicesPagedResponse>() {
            @Override
            public ApiFuture<ListRegionBackendServicesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRegionBackendServicesHttpRequest, BackendServiceList> callable,
                ListRegionBackendServicesHttpRequest request,
                ApiCallContext context,
                ApiFuture<BackendServiceList> futureResponse) {
              PageContext<ListRegionBackendServicesHttpRequest, BackendServiceList, BackendService>
                  pageContext =
                      PageContext.create(
                          callable, LIST_REGION_BACKEND_SERVICES_PAGE_STR_DESC, request, context);
              return ListRegionBackendServicesPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Builder for RegionBackendServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<RegionBackendServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<DeleteRegionBackendServiceHttpRequest, Operation>
        deleteRegionBackendServiceSettings;
    private final UnaryCallSettings.Builder<GetRegionBackendServiceHttpRequest, BackendService>
        getRegionBackendServiceSettings;
    private final UnaryCallSettings.Builder<
            GetHealthRegionBackendServiceHttpRequest, BackendServiceGroupHealth>
        getHealthRegionBackendServiceSettings;
    private final UnaryCallSettings.Builder<InsertRegionBackendServiceHttpRequest, Operation>
        insertRegionBackendServiceSettings;
    private final PagedCallSettings.Builder<
            ListRegionBackendServicesHttpRequest,
            BackendServiceList,
            ListRegionBackendServicesPagedResponse>
        listRegionBackendServicesSettings;
    private final UnaryCallSettings.Builder<PatchRegionBackendServiceHttpRequest, Operation>
        patchRegionBackendServiceSettings;
    private final UnaryCallSettings.Builder<UpdateRegionBackendServiceHttpRequest, Operation>
        updateRegionBackendServiceSettings;

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

      deleteRegionBackendServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getRegionBackendServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getHealthRegionBackendServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      insertRegionBackendServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listRegionBackendServicesSettings =
          PagedCallSettings.newBuilder(LIST_REGION_BACKEND_SERVICES_PAGE_STR_FACT);

      patchRegionBackendServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateRegionBackendServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deleteRegionBackendServiceSettings,
              getRegionBackendServiceSettings,
              getHealthRegionBackendServiceSettings,
              insertRegionBackendServiceSettings,
              listRegionBackendServicesSettings,
              patchRegionBackendServiceSettings,
              updateRegionBackendServiceSettings);

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
          .deleteRegionBackendServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getRegionBackendServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getHealthRegionBackendServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .insertRegionBackendServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listRegionBackendServicesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .patchRegionBackendServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateRegionBackendServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(RegionBackendServiceStubSettings settings) {
      super(settings);

      deleteRegionBackendServiceSettings = settings.deleteRegionBackendServiceSettings.toBuilder();
      getRegionBackendServiceSettings = settings.getRegionBackendServiceSettings.toBuilder();
      getHealthRegionBackendServiceSettings =
          settings.getHealthRegionBackendServiceSettings.toBuilder();
      insertRegionBackendServiceSettings = settings.insertRegionBackendServiceSettings.toBuilder();
      listRegionBackendServicesSettings = settings.listRegionBackendServicesSettings.toBuilder();
      patchRegionBackendServiceSettings = settings.patchRegionBackendServiceSettings.toBuilder();
      updateRegionBackendServiceSettings = settings.updateRegionBackendServiceSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deleteRegionBackendServiceSettings,
              getRegionBackendServiceSettings,
              getHealthRegionBackendServiceSettings,
              insertRegionBackendServiceSettings,
              listRegionBackendServicesSettings,
              patchRegionBackendServiceSettings,
              updateRegionBackendServiceSettings);
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

    /** Returns the builder for the settings used for calls to deleteRegionBackendService. */
    public UnaryCallSettings.Builder<DeleteRegionBackendServiceHttpRequest, Operation>
        deleteRegionBackendServiceSettings() {
      return deleteRegionBackendServiceSettings;
    }

    /** Returns the builder for the settings used for calls to getRegionBackendService. */
    public UnaryCallSettings.Builder<GetRegionBackendServiceHttpRequest, BackendService>
        getRegionBackendServiceSettings() {
      return getRegionBackendServiceSettings;
    }

    /** Returns the builder for the settings used for calls to getHealthRegionBackendService. */
    public UnaryCallSettings.Builder<
            GetHealthRegionBackendServiceHttpRequest, BackendServiceGroupHealth>
        getHealthRegionBackendServiceSettings() {
      return getHealthRegionBackendServiceSettings;
    }

    /** Returns the builder for the settings used for calls to insertRegionBackendService. */
    public UnaryCallSettings.Builder<InsertRegionBackendServiceHttpRequest, Operation>
        insertRegionBackendServiceSettings() {
      return insertRegionBackendServiceSettings;
    }

    /** Returns the builder for the settings used for calls to listRegionBackendServices. */
    public PagedCallSettings.Builder<
            ListRegionBackendServicesHttpRequest,
            BackendServiceList,
            ListRegionBackendServicesPagedResponse>
        listRegionBackendServicesSettings() {
      return listRegionBackendServicesSettings;
    }

    /** Returns the builder for the settings used for calls to patchRegionBackendService. */
    public UnaryCallSettings.Builder<PatchRegionBackendServiceHttpRequest, Operation>
        patchRegionBackendServiceSettings() {
      return patchRegionBackendServiceSettings;
    }

    /** Returns the builder for the settings used for calls to updateRegionBackendService. */
    public UnaryCallSettings.Builder<UpdateRegionBackendServiceHttpRequest, Operation>
        updateRegionBackendServiceSettings() {
      return updateRegionBackendServiceSettings;
    }

    @Override
    public RegionBackendServiceStubSettings build() throws IOException {
      return new RegionBackendServiceStubSettings(this);
    }
  }
}
