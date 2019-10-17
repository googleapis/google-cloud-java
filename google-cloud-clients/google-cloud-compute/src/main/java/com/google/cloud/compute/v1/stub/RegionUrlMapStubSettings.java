/*
 * Copyright 2019 Google LLC
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

import static com.google.cloud.compute.v1.RegionUrlMapClient.ListRegionUrlMapsPagedResponse;

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
import com.google.cloud.compute.v1.DeleteRegionUrlMapHttpRequest;
import com.google.cloud.compute.v1.GetRegionUrlMapHttpRequest;
import com.google.cloud.compute.v1.InsertRegionUrlMapHttpRequest;
import com.google.cloud.compute.v1.ListRegionUrlMapsHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchRegionUrlMapHttpRequest;
import com.google.cloud.compute.v1.UpdateRegionUrlMapHttpRequest;
import com.google.cloud.compute.v1.UrlMap;
import com.google.cloud.compute.v1.UrlMapList;
import com.google.cloud.compute.v1.UrlMapsValidateResponse;
import com.google.cloud.compute.v1.ValidateRegionUrlMapHttpRequest;
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
 * Settings class to configure an instance of {@link RegionUrlMapStub}.
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
 * <p>For example, to set the total timeout of deleteRegionUrlMap to 30 seconds:
 *
 * <pre>
 * <code>
 * RegionUrlMapStubSettings.Builder regionUrlMapSettingsBuilder =
 *     RegionUrlMapStubSettings.newBuilder();
 * regionUrlMapSettingsBuilder.deleteRegionUrlMapSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * RegionUrlMapStubSettings regionUrlMapSettings = regionUrlMapSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionUrlMapStubSettings extends StubSettings<RegionUrlMapStubSettings> {
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

  private final UnaryCallSettings<DeleteRegionUrlMapHttpRequest, Operation>
      deleteRegionUrlMapSettings;
  private final UnaryCallSettings<GetRegionUrlMapHttpRequest, UrlMap> getRegionUrlMapSettings;
  private final UnaryCallSettings<InsertRegionUrlMapHttpRequest, Operation>
      insertRegionUrlMapSettings;
  private final PagedCallSettings<
          ListRegionUrlMapsHttpRequest, UrlMapList, ListRegionUrlMapsPagedResponse>
      listRegionUrlMapsSettings;
  private final UnaryCallSettings<PatchRegionUrlMapHttpRequest, Operation>
      patchRegionUrlMapSettings;
  private final UnaryCallSettings<UpdateRegionUrlMapHttpRequest, Operation>
      updateRegionUrlMapSettings;
  private final UnaryCallSettings<ValidateRegionUrlMapHttpRequest, UrlMapsValidateResponse>
      validateRegionUrlMapSettings;

  /** Returns the object with the settings used for calls to deleteRegionUrlMap. */
  public UnaryCallSettings<DeleteRegionUrlMapHttpRequest, Operation> deleteRegionUrlMapSettings() {
    return deleteRegionUrlMapSettings;
  }

  /** Returns the object with the settings used for calls to getRegionUrlMap. */
  public UnaryCallSettings<GetRegionUrlMapHttpRequest, UrlMap> getRegionUrlMapSettings() {
    return getRegionUrlMapSettings;
  }

  /** Returns the object with the settings used for calls to insertRegionUrlMap. */
  public UnaryCallSettings<InsertRegionUrlMapHttpRequest, Operation> insertRegionUrlMapSettings() {
    return insertRegionUrlMapSettings;
  }

  /** Returns the object with the settings used for calls to listRegionUrlMaps. */
  public PagedCallSettings<ListRegionUrlMapsHttpRequest, UrlMapList, ListRegionUrlMapsPagedResponse>
      listRegionUrlMapsSettings() {
    return listRegionUrlMapsSettings;
  }

  /** Returns the object with the settings used for calls to patchRegionUrlMap. */
  public UnaryCallSettings<PatchRegionUrlMapHttpRequest, Operation> patchRegionUrlMapSettings() {
    return patchRegionUrlMapSettings;
  }

  /** Returns the object with the settings used for calls to updateRegionUrlMap. */
  public UnaryCallSettings<UpdateRegionUrlMapHttpRequest, Operation> updateRegionUrlMapSettings() {
    return updateRegionUrlMapSettings;
  }

  /** Returns the object with the settings used for calls to validateRegionUrlMap. */
  public UnaryCallSettings<ValidateRegionUrlMapHttpRequest, UrlMapsValidateResponse>
      validateRegionUrlMapSettings() {
    return validateRegionUrlMapSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RegionUrlMapStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonRegionUrlMapStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(RegionUrlMapStubSettings.class))
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

  protected RegionUrlMapStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    deleteRegionUrlMapSettings = settingsBuilder.deleteRegionUrlMapSettings().build();
    getRegionUrlMapSettings = settingsBuilder.getRegionUrlMapSettings().build();
    insertRegionUrlMapSettings = settingsBuilder.insertRegionUrlMapSettings().build();
    listRegionUrlMapsSettings = settingsBuilder.listRegionUrlMapsSettings().build();
    patchRegionUrlMapSettings = settingsBuilder.patchRegionUrlMapSettings().build();
    updateRegionUrlMapSettings = settingsBuilder.updateRegionUrlMapSettings().build();
    validateRegionUrlMapSettings = settingsBuilder.validateRegionUrlMapSettings().build();
  }

  private static final PagedListDescriptor<ListRegionUrlMapsHttpRequest, UrlMapList, UrlMap>
      LIST_REGION_URL_MAPS_PAGE_STR_DESC =
          new PagedListDescriptor<ListRegionUrlMapsHttpRequest, UrlMapList, UrlMap>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRegionUrlMapsHttpRequest injectToken(
                ListRegionUrlMapsHttpRequest payload, String token) {
              return ListRegionUrlMapsHttpRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRegionUrlMapsHttpRequest injectPageSize(
                ListRegionUrlMapsHttpRequest payload, int pageSize) {
              return ListRegionUrlMapsHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListRegionUrlMapsHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(UrlMapList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<UrlMap> extractResources(UrlMapList payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<UrlMap>of();
            }
          };

  private static final PagedListResponseFactory<
          ListRegionUrlMapsHttpRequest, UrlMapList, ListRegionUrlMapsPagedResponse>
      LIST_REGION_URL_MAPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRegionUrlMapsHttpRequest, UrlMapList, ListRegionUrlMapsPagedResponse>() {
            @Override
            public ApiFuture<ListRegionUrlMapsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRegionUrlMapsHttpRequest, UrlMapList> callable,
                ListRegionUrlMapsHttpRequest request,
                ApiCallContext context,
                ApiFuture<UrlMapList> futureResponse) {
              PageContext<ListRegionUrlMapsHttpRequest, UrlMapList, UrlMap> pageContext =
                  PageContext.create(
                      callable, LIST_REGION_URL_MAPS_PAGE_STR_DESC, request, context);
              return ListRegionUrlMapsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for RegionUrlMapStubSettings. */
  public static class Builder extends StubSettings.Builder<RegionUrlMapStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<DeleteRegionUrlMapHttpRequest, Operation>
        deleteRegionUrlMapSettings;
    private final UnaryCallSettings.Builder<GetRegionUrlMapHttpRequest, UrlMap>
        getRegionUrlMapSettings;
    private final UnaryCallSettings.Builder<InsertRegionUrlMapHttpRequest, Operation>
        insertRegionUrlMapSettings;
    private final PagedCallSettings.Builder<
            ListRegionUrlMapsHttpRequest, UrlMapList, ListRegionUrlMapsPagedResponse>
        listRegionUrlMapsSettings;
    private final UnaryCallSettings.Builder<PatchRegionUrlMapHttpRequest, Operation>
        patchRegionUrlMapSettings;
    private final UnaryCallSettings.Builder<UpdateRegionUrlMapHttpRequest, Operation>
        updateRegionUrlMapSettings;
    private final UnaryCallSettings.Builder<
            ValidateRegionUrlMapHttpRequest, UrlMapsValidateResponse>
        validateRegionUrlMapSettings;

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

      deleteRegionUrlMapSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getRegionUrlMapSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      insertRegionUrlMapSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listRegionUrlMapsSettings = PagedCallSettings.newBuilder(LIST_REGION_URL_MAPS_PAGE_STR_FACT);

      patchRegionUrlMapSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateRegionUrlMapSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      validateRegionUrlMapSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deleteRegionUrlMapSettings,
              getRegionUrlMapSettings,
              insertRegionUrlMapSettings,
              listRegionUrlMapsSettings,
              patchRegionUrlMapSettings,
              updateRegionUrlMapSettings,
              validateRegionUrlMapSettings);

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
          .deleteRegionUrlMapSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getRegionUrlMapSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .insertRegionUrlMapSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listRegionUrlMapsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .patchRegionUrlMapSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateRegionUrlMapSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .validateRegionUrlMapSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(RegionUrlMapStubSettings settings) {
      super(settings);

      deleteRegionUrlMapSettings = settings.deleteRegionUrlMapSettings.toBuilder();
      getRegionUrlMapSettings = settings.getRegionUrlMapSettings.toBuilder();
      insertRegionUrlMapSettings = settings.insertRegionUrlMapSettings.toBuilder();
      listRegionUrlMapsSettings = settings.listRegionUrlMapsSettings.toBuilder();
      patchRegionUrlMapSettings = settings.patchRegionUrlMapSettings.toBuilder();
      updateRegionUrlMapSettings = settings.updateRegionUrlMapSettings.toBuilder();
      validateRegionUrlMapSettings = settings.validateRegionUrlMapSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deleteRegionUrlMapSettings,
              getRegionUrlMapSettings,
              insertRegionUrlMapSettings,
              listRegionUrlMapsSettings,
              patchRegionUrlMapSettings,
              updateRegionUrlMapSettings,
              validateRegionUrlMapSettings);
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

    /** Returns the builder for the settings used for calls to deleteRegionUrlMap. */
    public UnaryCallSettings.Builder<DeleteRegionUrlMapHttpRequest, Operation>
        deleteRegionUrlMapSettings() {
      return deleteRegionUrlMapSettings;
    }

    /** Returns the builder for the settings used for calls to getRegionUrlMap. */
    public UnaryCallSettings.Builder<GetRegionUrlMapHttpRequest, UrlMap> getRegionUrlMapSettings() {
      return getRegionUrlMapSettings;
    }

    /** Returns the builder for the settings used for calls to insertRegionUrlMap. */
    public UnaryCallSettings.Builder<InsertRegionUrlMapHttpRequest, Operation>
        insertRegionUrlMapSettings() {
      return insertRegionUrlMapSettings;
    }

    /** Returns the builder for the settings used for calls to listRegionUrlMaps. */
    public PagedCallSettings.Builder<
            ListRegionUrlMapsHttpRequest, UrlMapList, ListRegionUrlMapsPagedResponse>
        listRegionUrlMapsSettings() {
      return listRegionUrlMapsSettings;
    }

    /** Returns the builder for the settings used for calls to patchRegionUrlMap. */
    public UnaryCallSettings.Builder<PatchRegionUrlMapHttpRequest, Operation>
        patchRegionUrlMapSettings() {
      return patchRegionUrlMapSettings;
    }

    /** Returns the builder for the settings used for calls to updateRegionUrlMap. */
    public UnaryCallSettings.Builder<UpdateRegionUrlMapHttpRequest, Operation>
        updateRegionUrlMapSettings() {
      return updateRegionUrlMapSettings;
    }

    /** Returns the builder for the settings used for calls to validateRegionUrlMap. */
    public UnaryCallSettings.Builder<ValidateRegionUrlMapHttpRequest, UrlMapsValidateResponse>
        validateRegionUrlMapSettings() {
      return validateRegionUrlMapSettings;
    }

    @Override
    public RegionUrlMapStubSettings build() throws IOException {
      return new RegionUrlMapStubSettings(this);
    }
  }
}
