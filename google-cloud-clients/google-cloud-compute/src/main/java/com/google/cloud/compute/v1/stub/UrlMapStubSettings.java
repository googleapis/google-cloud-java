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

import static com.google.cloud.compute.v1.UrlMapClient.ListUrlMapsPagedResponse;

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
import com.google.cloud.compute.v1.DeleteUrlMapHttpRequest;
import com.google.cloud.compute.v1.GetUrlMapHttpRequest;
import com.google.cloud.compute.v1.InsertUrlMapHttpRequest;
import com.google.cloud.compute.v1.InvalidateCacheUrlMapHttpRequest;
import com.google.cloud.compute.v1.ListUrlMapsHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchUrlMapHttpRequest;
import com.google.cloud.compute.v1.UpdateUrlMapHttpRequest;
import com.google.cloud.compute.v1.UrlMap;
import com.google.cloud.compute.v1.UrlMapList;
import com.google.cloud.compute.v1.UrlMapsValidateResponse;
import com.google.cloud.compute.v1.ValidateUrlMapHttpRequest;
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
 * Settings class to configure an instance of {@link UrlMapStub}.
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
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of deleteUrlMap to 30 seconds:
 *
 * <pre>
 * <code>
 * UrlMapStubSettings.Builder urlMapSettingsBuilder =
 *     UrlMapStubSettings.newBuilder();
 * urlMapSettingsBuilder.deleteUrlMapSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * UrlMapStubSettings urlMapSettings = urlMapSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class UrlMapStubSettings extends StubSettings<UrlMapStubSettings> {
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

  private final UnaryCallSettings<DeleteUrlMapHttpRequest, Operation> deleteUrlMapSettings;
  private final UnaryCallSettings<GetUrlMapHttpRequest, UrlMap> getUrlMapSettings;
  private final UnaryCallSettings<InsertUrlMapHttpRequest, Operation> insertUrlMapSettings;
  private final UnaryCallSettings<InvalidateCacheUrlMapHttpRequest, Operation>
      invalidateCacheUrlMapSettings;
  private final PagedCallSettings<ListUrlMapsHttpRequest, UrlMapList, ListUrlMapsPagedResponse>
      listUrlMapsSettings;
  private final UnaryCallSettings<PatchUrlMapHttpRequest, Operation> patchUrlMapSettings;
  private final UnaryCallSettings<UpdateUrlMapHttpRequest, Operation> updateUrlMapSettings;
  private final UnaryCallSettings<ValidateUrlMapHttpRequest, UrlMapsValidateResponse>
      validateUrlMapSettings;

  /** Returns the object with the settings used for calls to deleteUrlMap. */
  public UnaryCallSettings<DeleteUrlMapHttpRequest, Operation> deleteUrlMapSettings() {
    return deleteUrlMapSettings;
  }

  /** Returns the object with the settings used for calls to getUrlMap. */
  public UnaryCallSettings<GetUrlMapHttpRequest, UrlMap> getUrlMapSettings() {
    return getUrlMapSettings;
  }

  /** Returns the object with the settings used for calls to insertUrlMap. */
  public UnaryCallSettings<InsertUrlMapHttpRequest, Operation> insertUrlMapSettings() {
    return insertUrlMapSettings;
  }

  /** Returns the object with the settings used for calls to invalidateCacheUrlMap. */
  public UnaryCallSettings<InvalidateCacheUrlMapHttpRequest, Operation>
      invalidateCacheUrlMapSettings() {
    return invalidateCacheUrlMapSettings;
  }

  /** Returns the object with the settings used for calls to listUrlMaps. */
  public PagedCallSettings<ListUrlMapsHttpRequest, UrlMapList, ListUrlMapsPagedResponse>
      listUrlMapsSettings() {
    return listUrlMapsSettings;
  }

  /** Returns the object with the settings used for calls to patchUrlMap. */
  public UnaryCallSettings<PatchUrlMapHttpRequest, Operation> patchUrlMapSettings() {
    return patchUrlMapSettings;
  }

  /** Returns the object with the settings used for calls to updateUrlMap. */
  public UnaryCallSettings<UpdateUrlMapHttpRequest, Operation> updateUrlMapSettings() {
    return updateUrlMapSettings;
  }

  /** Returns the object with the settings used for calls to validateUrlMap. */
  public UnaryCallSettings<ValidateUrlMapHttpRequest, UrlMapsValidateResponse>
      validateUrlMapSettings() {
    return validateUrlMapSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public UrlMapStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonUrlMapStub.create(this);
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(UrlMapStubSettings.class))
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

  protected UrlMapStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    deleteUrlMapSettings = settingsBuilder.deleteUrlMapSettings().build();
    getUrlMapSettings = settingsBuilder.getUrlMapSettings().build();
    insertUrlMapSettings = settingsBuilder.insertUrlMapSettings().build();
    invalidateCacheUrlMapSettings = settingsBuilder.invalidateCacheUrlMapSettings().build();
    listUrlMapsSettings = settingsBuilder.listUrlMapsSettings().build();
    patchUrlMapSettings = settingsBuilder.patchUrlMapSettings().build();
    updateUrlMapSettings = settingsBuilder.updateUrlMapSettings().build();
    validateUrlMapSettings = settingsBuilder.validateUrlMapSettings().build();
  }

  private static final PagedListDescriptor<ListUrlMapsHttpRequest, UrlMapList, UrlMap>
      LIST_URL_MAPS_PAGE_STR_DESC =
          new PagedListDescriptor<ListUrlMapsHttpRequest, UrlMapList, UrlMap>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListUrlMapsHttpRequest injectToken(
                ListUrlMapsHttpRequest payload, String token) {
              return ListUrlMapsHttpRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListUrlMapsHttpRequest injectPageSize(
                ListUrlMapsHttpRequest payload, int pageSize) {
              return ListUrlMapsHttpRequest.newBuilder(payload).setMaxResults(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListUrlMapsHttpRequest payload) {
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
          ListUrlMapsHttpRequest, UrlMapList, ListUrlMapsPagedResponse>
      LIST_URL_MAPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListUrlMapsHttpRequest, UrlMapList, ListUrlMapsPagedResponse>() {
            @Override
            public ApiFuture<ListUrlMapsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListUrlMapsHttpRequest, UrlMapList> callable,
                ListUrlMapsHttpRequest request,
                ApiCallContext context,
                ApiFuture<UrlMapList> futureResponse) {
              PageContext<ListUrlMapsHttpRequest, UrlMapList, UrlMap> pageContext =
                  PageContext.create(callable, LIST_URL_MAPS_PAGE_STR_DESC, request, context);
              return ListUrlMapsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for UrlMapStubSettings. */
  public static class Builder extends StubSettings.Builder<UrlMapStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<DeleteUrlMapHttpRequest, Operation>
        deleteUrlMapSettings;
    private final UnaryCallSettings.Builder<GetUrlMapHttpRequest, UrlMap> getUrlMapSettings;
    private final UnaryCallSettings.Builder<InsertUrlMapHttpRequest, Operation>
        insertUrlMapSettings;
    private final UnaryCallSettings.Builder<InvalidateCacheUrlMapHttpRequest, Operation>
        invalidateCacheUrlMapSettings;
    private final PagedCallSettings.Builder<
            ListUrlMapsHttpRequest, UrlMapList, ListUrlMapsPagedResponse>
        listUrlMapsSettings;
    private final UnaryCallSettings.Builder<PatchUrlMapHttpRequest, Operation> patchUrlMapSettings;
    private final UnaryCallSettings.Builder<UpdateUrlMapHttpRequest, Operation>
        updateUrlMapSettings;
    private final UnaryCallSettings.Builder<ValidateUrlMapHttpRequest, UrlMapsValidateResponse>
        validateUrlMapSettings;

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

      deleteUrlMapSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getUrlMapSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      insertUrlMapSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      invalidateCacheUrlMapSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listUrlMapsSettings = PagedCallSettings.newBuilder(LIST_URL_MAPS_PAGE_STR_FACT);

      patchUrlMapSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateUrlMapSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      validateUrlMapSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deleteUrlMapSettings,
              getUrlMapSettings,
              insertUrlMapSettings,
              invalidateCacheUrlMapSettings,
              listUrlMapsSettings,
              patchUrlMapSettings,
              updateUrlMapSettings,
              validateUrlMapSettings);

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
          .deleteUrlMapSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getUrlMapSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .insertUrlMapSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .invalidateCacheUrlMapSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listUrlMapsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .patchUrlMapSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateUrlMapSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .validateUrlMapSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(UrlMapStubSettings settings) {
      super(settings);

      deleteUrlMapSettings = settings.deleteUrlMapSettings.toBuilder();
      getUrlMapSettings = settings.getUrlMapSettings.toBuilder();
      insertUrlMapSettings = settings.insertUrlMapSettings.toBuilder();
      invalidateCacheUrlMapSettings = settings.invalidateCacheUrlMapSettings.toBuilder();
      listUrlMapsSettings = settings.listUrlMapsSettings.toBuilder();
      patchUrlMapSettings = settings.patchUrlMapSettings.toBuilder();
      updateUrlMapSettings = settings.updateUrlMapSettings.toBuilder();
      validateUrlMapSettings = settings.validateUrlMapSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deleteUrlMapSettings,
              getUrlMapSettings,
              insertUrlMapSettings,
              invalidateCacheUrlMapSettings,
              listUrlMapsSettings,
              patchUrlMapSettings,
              updateUrlMapSettings,
              validateUrlMapSettings);
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

    /** Returns the builder for the settings used for calls to deleteUrlMap. */
    public UnaryCallSettings.Builder<DeleteUrlMapHttpRequest, Operation> deleteUrlMapSettings() {
      return deleteUrlMapSettings;
    }

    /** Returns the builder for the settings used for calls to getUrlMap. */
    public UnaryCallSettings.Builder<GetUrlMapHttpRequest, UrlMap> getUrlMapSettings() {
      return getUrlMapSettings;
    }

    /** Returns the builder for the settings used for calls to insertUrlMap. */
    public UnaryCallSettings.Builder<InsertUrlMapHttpRequest, Operation> insertUrlMapSettings() {
      return insertUrlMapSettings;
    }

    /** Returns the builder for the settings used for calls to invalidateCacheUrlMap. */
    public UnaryCallSettings.Builder<InvalidateCacheUrlMapHttpRequest, Operation>
        invalidateCacheUrlMapSettings() {
      return invalidateCacheUrlMapSettings;
    }

    /** Returns the builder for the settings used for calls to listUrlMaps. */
    public PagedCallSettings.Builder<ListUrlMapsHttpRequest, UrlMapList, ListUrlMapsPagedResponse>
        listUrlMapsSettings() {
      return listUrlMapsSettings;
    }

    /** Returns the builder for the settings used for calls to patchUrlMap. */
    public UnaryCallSettings.Builder<PatchUrlMapHttpRequest, Operation> patchUrlMapSettings() {
      return patchUrlMapSettings;
    }

    /** Returns the builder for the settings used for calls to updateUrlMap. */
    public UnaryCallSettings.Builder<UpdateUrlMapHttpRequest, Operation> updateUrlMapSettings() {
      return updateUrlMapSettings;
    }

    /** Returns the builder for the settings used for calls to validateUrlMap. */
    public UnaryCallSettings.Builder<ValidateUrlMapHttpRequest, UrlMapsValidateResponse>
        validateUrlMapSettings() {
      return validateUrlMapSettings;
    }

    @Override
    public UrlMapStubSettings build() throws IOException {
      return new UrlMapStubSettings(this);
    }
  }
}
