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

import static com.google.cloud.compute.v1.HealthCheckClient.ListHealthChecksPagedResponse;

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
import com.google.cloud.compute.v1.DeleteHealthCheckHttpRequest;
import com.google.cloud.compute.v1.GetHealthCheckHttpRequest;
import com.google.cloud.compute.v1.HealthCheck;
import com.google.cloud.compute.v1.HealthCheckList;
import com.google.cloud.compute.v1.InsertHealthCheckHttpRequest;
import com.google.cloud.compute.v1.ListHealthChecksHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchHealthCheckHttpRequest;
import com.google.cloud.compute.v1.UpdateHealthCheckHttpRequest;
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
 * Settings class to configure an instance of {@link HealthCheckStub}.
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
 * <p>For example, to set the total timeout of deleteHealthCheck to 30 seconds:
 *
 * <pre>
 * <code>
 * HealthCheckStubSettings.Builder healthCheckSettingsBuilder =
 *     HealthCheckStubSettings.newBuilder();
 * healthCheckSettingsBuilder.deleteHealthCheckSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * HealthCheckStubSettings healthCheckSettings = healthCheckSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class HealthCheckStubSettings extends StubSettings<HealthCheckStubSettings> {
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

  private final UnaryCallSettings<DeleteHealthCheckHttpRequest, Operation>
      deleteHealthCheckSettings;
  private final UnaryCallSettings<GetHealthCheckHttpRequest, HealthCheck> getHealthCheckSettings;
  private final UnaryCallSettings<InsertHealthCheckHttpRequest, Operation>
      insertHealthCheckSettings;
  private final PagedCallSettings<
          ListHealthChecksHttpRequest, HealthCheckList, ListHealthChecksPagedResponse>
      listHealthChecksSettings;
  private final UnaryCallSettings<PatchHealthCheckHttpRequest, Operation> patchHealthCheckSettings;
  private final UnaryCallSettings<UpdateHealthCheckHttpRequest, Operation>
      updateHealthCheckSettings;

  /** Returns the object with the settings used for calls to deleteHealthCheck. */
  public UnaryCallSettings<DeleteHealthCheckHttpRequest, Operation> deleteHealthCheckSettings() {
    return deleteHealthCheckSettings;
  }

  /** Returns the object with the settings used for calls to getHealthCheck. */
  public UnaryCallSettings<GetHealthCheckHttpRequest, HealthCheck> getHealthCheckSettings() {
    return getHealthCheckSettings;
  }

  /** Returns the object with the settings used for calls to insertHealthCheck. */
  public UnaryCallSettings<InsertHealthCheckHttpRequest, Operation> insertHealthCheckSettings() {
    return insertHealthCheckSettings;
  }

  /** Returns the object with the settings used for calls to listHealthChecks. */
  public PagedCallSettings<
          ListHealthChecksHttpRequest, HealthCheckList, ListHealthChecksPagedResponse>
      listHealthChecksSettings() {
    return listHealthChecksSettings;
  }

  /** Returns the object with the settings used for calls to patchHealthCheck. */
  public UnaryCallSettings<PatchHealthCheckHttpRequest, Operation> patchHealthCheckSettings() {
    return patchHealthCheckSettings;
  }

  /** Returns the object with the settings used for calls to updateHealthCheck. */
  public UnaryCallSettings<UpdateHealthCheckHttpRequest, Operation> updateHealthCheckSettings() {
    return updateHealthCheckSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public HealthCheckStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonHealthCheckStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(HealthCheckStubSettings.class))
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

  protected HealthCheckStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    deleteHealthCheckSettings = settingsBuilder.deleteHealthCheckSettings().build();
    getHealthCheckSettings = settingsBuilder.getHealthCheckSettings().build();
    insertHealthCheckSettings = settingsBuilder.insertHealthCheckSettings().build();
    listHealthChecksSettings = settingsBuilder.listHealthChecksSettings().build();
    patchHealthCheckSettings = settingsBuilder.patchHealthCheckSettings().build();
    updateHealthCheckSettings = settingsBuilder.updateHealthCheckSettings().build();
  }

  private static final PagedListDescriptor<
          ListHealthChecksHttpRequest, HealthCheckList, HealthCheck>
      LIST_HEALTH_CHECKS_PAGE_STR_DESC =
          new PagedListDescriptor<ListHealthChecksHttpRequest, HealthCheckList, HealthCheck>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListHealthChecksHttpRequest injectToken(
                ListHealthChecksHttpRequest payload, String token) {
              return ListHealthChecksHttpRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListHealthChecksHttpRequest injectPageSize(
                ListHealthChecksHttpRequest payload, int pageSize) {
              return ListHealthChecksHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListHealthChecksHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(HealthCheckList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<HealthCheck> extractResources(HealthCheckList payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<HealthCheck>of();
            }
          };

  private static final PagedListResponseFactory<
          ListHealthChecksHttpRequest, HealthCheckList, ListHealthChecksPagedResponse>
      LIST_HEALTH_CHECKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListHealthChecksHttpRequest, HealthCheckList, ListHealthChecksPagedResponse>() {
            @Override
            public ApiFuture<ListHealthChecksPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListHealthChecksHttpRequest, HealthCheckList> callable,
                ListHealthChecksHttpRequest request,
                ApiCallContext context,
                ApiFuture<HealthCheckList> futureResponse) {
              PageContext<ListHealthChecksHttpRequest, HealthCheckList, HealthCheck> pageContext =
                  PageContext.create(callable, LIST_HEALTH_CHECKS_PAGE_STR_DESC, request, context);
              return ListHealthChecksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for HealthCheckStubSettings. */
  public static class Builder extends StubSettings.Builder<HealthCheckStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<DeleteHealthCheckHttpRequest, Operation>
        deleteHealthCheckSettings;
    private final UnaryCallSettings.Builder<GetHealthCheckHttpRequest, HealthCheck>
        getHealthCheckSettings;
    private final UnaryCallSettings.Builder<InsertHealthCheckHttpRequest, Operation>
        insertHealthCheckSettings;
    private final PagedCallSettings.Builder<
            ListHealthChecksHttpRequest, HealthCheckList, ListHealthChecksPagedResponse>
        listHealthChecksSettings;
    private final UnaryCallSettings.Builder<PatchHealthCheckHttpRequest, Operation>
        patchHealthCheckSettings;
    private final UnaryCallSettings.Builder<UpdateHealthCheckHttpRequest, Operation>
        updateHealthCheckSettings;

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

      deleteHealthCheckSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getHealthCheckSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      insertHealthCheckSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listHealthChecksSettings = PagedCallSettings.newBuilder(LIST_HEALTH_CHECKS_PAGE_STR_FACT);

      patchHealthCheckSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateHealthCheckSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deleteHealthCheckSettings,
              getHealthCheckSettings,
              insertHealthCheckSettings,
              listHealthChecksSettings,
              patchHealthCheckSettings,
              updateHealthCheckSettings);

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
          .deleteHealthCheckSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getHealthCheckSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .insertHealthCheckSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listHealthChecksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .patchHealthCheckSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateHealthCheckSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(HealthCheckStubSettings settings) {
      super(settings);

      deleteHealthCheckSettings = settings.deleteHealthCheckSettings.toBuilder();
      getHealthCheckSettings = settings.getHealthCheckSettings.toBuilder();
      insertHealthCheckSettings = settings.insertHealthCheckSettings.toBuilder();
      listHealthChecksSettings = settings.listHealthChecksSettings.toBuilder();
      patchHealthCheckSettings = settings.patchHealthCheckSettings.toBuilder();
      updateHealthCheckSettings = settings.updateHealthCheckSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deleteHealthCheckSettings,
              getHealthCheckSettings,
              insertHealthCheckSettings,
              listHealthChecksSettings,
              patchHealthCheckSettings,
              updateHealthCheckSettings);
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

    /** Returns the builder for the settings used for calls to deleteHealthCheck. */
    public UnaryCallSettings.Builder<DeleteHealthCheckHttpRequest, Operation>
        deleteHealthCheckSettings() {
      return deleteHealthCheckSettings;
    }

    /** Returns the builder for the settings used for calls to getHealthCheck. */
    public UnaryCallSettings.Builder<GetHealthCheckHttpRequest, HealthCheck>
        getHealthCheckSettings() {
      return getHealthCheckSettings;
    }

    /** Returns the builder for the settings used for calls to insertHealthCheck. */
    public UnaryCallSettings.Builder<InsertHealthCheckHttpRequest, Operation>
        insertHealthCheckSettings() {
      return insertHealthCheckSettings;
    }

    /** Returns the builder for the settings used for calls to listHealthChecks. */
    public PagedCallSettings.Builder<
            ListHealthChecksHttpRequest, HealthCheckList, ListHealthChecksPagedResponse>
        listHealthChecksSettings() {
      return listHealthChecksSettings;
    }

    /** Returns the builder for the settings used for calls to patchHealthCheck. */
    public UnaryCallSettings.Builder<PatchHealthCheckHttpRequest, Operation>
        patchHealthCheckSettings() {
      return patchHealthCheckSettings;
    }

    /** Returns the builder for the settings used for calls to updateHealthCheck. */
    public UnaryCallSettings.Builder<UpdateHealthCheckHttpRequest, Operation>
        updateHealthCheckSettings() {
      return updateHealthCheckSettings;
    }

    @Override
    public HealthCheckStubSettings build() throws IOException {
      return new HealthCheckStubSettings(this);
    }
  }
}
