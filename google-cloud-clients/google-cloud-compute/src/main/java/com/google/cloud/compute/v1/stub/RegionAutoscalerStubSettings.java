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

import static com.google.cloud.compute.v1.RegionAutoscalerClient.ListRegionAutoscalersPagedResponse;

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
import com.google.cloud.compute.v1.Autoscaler;
import com.google.cloud.compute.v1.DeleteRegionAutoscalerHttpRequest;
import com.google.cloud.compute.v1.GetRegionAutoscalerHttpRequest;
import com.google.cloud.compute.v1.InsertRegionAutoscalerHttpRequest;
import com.google.cloud.compute.v1.ListRegionAutoscalersHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchRegionAutoscalerHttpRequest;
import com.google.cloud.compute.v1.RegionAutoscalerList;
import com.google.cloud.compute.v1.UpdateRegionAutoscalerHttpRequest;
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
 * Settings class to configure an instance of {@link RegionAutoscalerStub}.
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
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of deleteRegionAutoscaler to 30 seconds:
 *
 * <pre>
 * <code>
 * RegionAutoscalerStubSettings.Builder regionAutoscalerSettingsBuilder =
 *     RegionAutoscalerStubSettings.newBuilder();
 * regionAutoscalerSettingsBuilder.deleteRegionAutoscalerSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * RegionAutoscalerStubSettings regionAutoscalerSettings = regionAutoscalerSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionAutoscalerStubSettings extends StubSettings<RegionAutoscalerStubSettings> {
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

  private final UnaryCallSettings<DeleteRegionAutoscalerHttpRequest, Operation>
      deleteRegionAutoscalerSettings;
  private final UnaryCallSettings<GetRegionAutoscalerHttpRequest, Autoscaler>
      getRegionAutoscalerSettings;
  private final UnaryCallSettings<InsertRegionAutoscalerHttpRequest, Operation>
      insertRegionAutoscalerSettings;
  private final PagedCallSettings<
          ListRegionAutoscalersHttpRequest,
          RegionAutoscalerList,
          ListRegionAutoscalersPagedResponse>
      listRegionAutoscalersSettings;
  private final UnaryCallSettings<PatchRegionAutoscalerHttpRequest, Operation>
      patchRegionAutoscalerSettings;
  private final UnaryCallSettings<UpdateRegionAutoscalerHttpRequest, Operation>
      updateRegionAutoscalerSettings;

  /** Returns the object with the settings used for calls to deleteRegionAutoscaler. */
  public UnaryCallSettings<DeleteRegionAutoscalerHttpRequest, Operation>
      deleteRegionAutoscalerSettings() {
    return deleteRegionAutoscalerSettings;
  }

  /** Returns the object with the settings used for calls to getRegionAutoscaler. */
  public UnaryCallSettings<GetRegionAutoscalerHttpRequest, Autoscaler>
      getRegionAutoscalerSettings() {
    return getRegionAutoscalerSettings;
  }

  /** Returns the object with the settings used for calls to insertRegionAutoscaler. */
  public UnaryCallSettings<InsertRegionAutoscalerHttpRequest, Operation>
      insertRegionAutoscalerSettings() {
    return insertRegionAutoscalerSettings;
  }

  /** Returns the object with the settings used for calls to listRegionAutoscalers. */
  public PagedCallSettings<
          ListRegionAutoscalersHttpRequest,
          RegionAutoscalerList,
          ListRegionAutoscalersPagedResponse>
      listRegionAutoscalersSettings() {
    return listRegionAutoscalersSettings;
  }

  /** Returns the object with the settings used for calls to patchRegionAutoscaler. */
  public UnaryCallSettings<PatchRegionAutoscalerHttpRequest, Operation>
      patchRegionAutoscalerSettings() {
    return patchRegionAutoscalerSettings;
  }

  /** Returns the object with the settings used for calls to updateRegionAutoscaler. */
  public UnaryCallSettings<UpdateRegionAutoscalerHttpRequest, Operation>
      updateRegionAutoscalerSettings() {
    return updateRegionAutoscalerSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public RegionAutoscalerStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonRegionAutoscalerStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(RegionAutoscalerStubSettings.class))
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

  protected RegionAutoscalerStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    deleteRegionAutoscalerSettings = settingsBuilder.deleteRegionAutoscalerSettings().build();
    getRegionAutoscalerSettings = settingsBuilder.getRegionAutoscalerSettings().build();
    insertRegionAutoscalerSettings = settingsBuilder.insertRegionAutoscalerSettings().build();
    listRegionAutoscalersSettings = settingsBuilder.listRegionAutoscalersSettings().build();
    patchRegionAutoscalerSettings = settingsBuilder.patchRegionAutoscalerSettings().build();
    updateRegionAutoscalerSettings = settingsBuilder.updateRegionAutoscalerSettings().build();
  }

  private static final PagedListDescriptor<
          ListRegionAutoscalersHttpRequest, RegionAutoscalerList, Autoscaler>
      LIST_REGION_AUTOSCALERS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListRegionAutoscalersHttpRequest, RegionAutoscalerList, Autoscaler>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRegionAutoscalersHttpRequest injectToken(
                ListRegionAutoscalersHttpRequest payload, String token) {
              return ListRegionAutoscalersHttpRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListRegionAutoscalersHttpRequest injectPageSize(
                ListRegionAutoscalersHttpRequest payload, int pageSize) {
              return ListRegionAutoscalersHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListRegionAutoscalersHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(RegionAutoscalerList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Autoscaler> extractResources(RegionAutoscalerList payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<Autoscaler>of();
            }
          };

  private static final PagedListResponseFactory<
          ListRegionAutoscalersHttpRequest,
          RegionAutoscalerList,
          ListRegionAutoscalersPagedResponse>
      LIST_REGION_AUTOSCALERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRegionAutoscalersHttpRequest,
              RegionAutoscalerList,
              ListRegionAutoscalersPagedResponse>() {
            @Override
            public ApiFuture<ListRegionAutoscalersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRegionAutoscalersHttpRequest, RegionAutoscalerList> callable,
                ListRegionAutoscalersHttpRequest request,
                ApiCallContext context,
                ApiFuture<RegionAutoscalerList> futureResponse) {
              PageContext<ListRegionAutoscalersHttpRequest, RegionAutoscalerList, Autoscaler>
                  pageContext =
                      PageContext.create(
                          callable, LIST_REGION_AUTOSCALERS_PAGE_STR_DESC, request, context);
              return ListRegionAutoscalersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for RegionAutoscalerStubSettings. */
  public static class Builder extends StubSettings.Builder<RegionAutoscalerStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<DeleteRegionAutoscalerHttpRequest, Operation>
        deleteRegionAutoscalerSettings;
    private final UnaryCallSettings.Builder<GetRegionAutoscalerHttpRequest, Autoscaler>
        getRegionAutoscalerSettings;
    private final UnaryCallSettings.Builder<InsertRegionAutoscalerHttpRequest, Operation>
        insertRegionAutoscalerSettings;
    private final PagedCallSettings.Builder<
            ListRegionAutoscalersHttpRequest,
            RegionAutoscalerList,
            ListRegionAutoscalersPagedResponse>
        listRegionAutoscalersSettings;
    private final UnaryCallSettings.Builder<PatchRegionAutoscalerHttpRequest, Operation>
        patchRegionAutoscalerSettings;
    private final UnaryCallSettings.Builder<UpdateRegionAutoscalerHttpRequest, Operation>
        updateRegionAutoscalerSettings;

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

      deleteRegionAutoscalerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getRegionAutoscalerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      insertRegionAutoscalerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listRegionAutoscalersSettings =
          PagedCallSettings.newBuilder(LIST_REGION_AUTOSCALERS_PAGE_STR_FACT);

      patchRegionAutoscalerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateRegionAutoscalerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deleteRegionAutoscalerSettings,
              getRegionAutoscalerSettings,
              insertRegionAutoscalerSettings,
              listRegionAutoscalersSettings,
              patchRegionAutoscalerSettings,
              updateRegionAutoscalerSettings);

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
          .deleteRegionAutoscalerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getRegionAutoscalerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .insertRegionAutoscalerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listRegionAutoscalersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .patchRegionAutoscalerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateRegionAutoscalerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(RegionAutoscalerStubSettings settings) {
      super(settings);

      deleteRegionAutoscalerSettings = settings.deleteRegionAutoscalerSettings.toBuilder();
      getRegionAutoscalerSettings = settings.getRegionAutoscalerSettings.toBuilder();
      insertRegionAutoscalerSettings = settings.insertRegionAutoscalerSettings.toBuilder();
      listRegionAutoscalersSettings = settings.listRegionAutoscalersSettings.toBuilder();
      patchRegionAutoscalerSettings = settings.patchRegionAutoscalerSettings.toBuilder();
      updateRegionAutoscalerSettings = settings.updateRegionAutoscalerSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deleteRegionAutoscalerSettings,
              getRegionAutoscalerSettings,
              insertRegionAutoscalerSettings,
              listRegionAutoscalersSettings,
              patchRegionAutoscalerSettings,
              updateRegionAutoscalerSettings);
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

    /** Returns the builder for the settings used for calls to deleteRegionAutoscaler. */
    public UnaryCallSettings.Builder<DeleteRegionAutoscalerHttpRequest, Operation>
        deleteRegionAutoscalerSettings() {
      return deleteRegionAutoscalerSettings;
    }

    /** Returns the builder for the settings used for calls to getRegionAutoscaler. */
    public UnaryCallSettings.Builder<GetRegionAutoscalerHttpRequest, Autoscaler>
        getRegionAutoscalerSettings() {
      return getRegionAutoscalerSettings;
    }

    /** Returns the builder for the settings used for calls to insertRegionAutoscaler. */
    public UnaryCallSettings.Builder<InsertRegionAutoscalerHttpRequest, Operation>
        insertRegionAutoscalerSettings() {
      return insertRegionAutoscalerSettings;
    }

    /** Returns the builder for the settings used for calls to listRegionAutoscalers. */
    public PagedCallSettings.Builder<
            ListRegionAutoscalersHttpRequest,
            RegionAutoscalerList,
            ListRegionAutoscalersPagedResponse>
        listRegionAutoscalersSettings() {
      return listRegionAutoscalersSettings;
    }

    /** Returns the builder for the settings used for calls to patchRegionAutoscaler. */
    public UnaryCallSettings.Builder<PatchRegionAutoscalerHttpRequest, Operation>
        patchRegionAutoscalerSettings() {
      return patchRegionAutoscalerSettings;
    }

    /** Returns the builder for the settings used for calls to updateRegionAutoscaler. */
    public UnaryCallSettings.Builder<UpdateRegionAutoscalerHttpRequest, Operation>
        updateRegionAutoscalerSettings() {
      return updateRegionAutoscalerSettings;
    }

    @Override
    public RegionAutoscalerStubSettings build() throws IOException {
      return new RegionAutoscalerStubSettings(this);
    }
  }
}
