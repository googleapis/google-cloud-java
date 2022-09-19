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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.RegionOperationsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.DeleteRegionOperationRequest;
import com.google.cloud.compute.v1.DeleteRegionOperationResponse;
import com.google.cloud.compute.v1.GetRegionOperationRequest;
import com.google.cloud.compute.v1.ListRegionOperationsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.OperationList;
import com.google.cloud.compute.v1.WaitRegionOperationRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link RegionOperationsStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (compute.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of delete to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RegionOperationsStubSettings.Builder regionOperationsSettingsBuilder =
 *     RegionOperationsStubSettings.newBuilder();
 * regionOperationsSettingsBuilder
 *     .deleteSettings()
 *     .setRetrySettings(
 *         regionOperationsSettingsBuilder.deleteSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * RegionOperationsStubSettings regionOperationsSettings = regionOperationsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class RegionOperationsStubSettings extends StubSettings<RegionOperationsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final UnaryCallSettings<DeleteRegionOperationRequest, DeleteRegionOperationResponse>
      deleteSettings;
  private final UnaryCallSettings<GetRegionOperationRequest, Operation> getSettings;
  private final PagedCallSettings<ListRegionOperationsRequest, OperationList, ListPagedResponse>
      listSettings;
  private final UnaryCallSettings<WaitRegionOperationRequest, Operation> waitSettings;

  private static final PagedListDescriptor<ListRegionOperationsRequest, OperationList, Operation>
      LIST_PAGE_STR_DESC =
          new PagedListDescriptor<ListRegionOperationsRequest, OperationList, Operation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRegionOperationsRequest injectToken(
                ListRegionOperationsRequest payload, String token) {
              return ListRegionOperationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRegionOperationsRequest injectPageSize(
                ListRegionOperationsRequest payload, int pageSize) {
              return ListRegionOperationsRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListRegionOperationsRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(OperationList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Operation> extractResources(OperationList payload) {
              return payload.getItemsList() == null
                  ? ImmutableList.<Operation>of()
                  : payload.getItemsList();
            }
          };

  private static final PagedListResponseFactory<
          ListRegionOperationsRequest, OperationList, ListPagedResponse>
      LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRegionOperationsRequest, OperationList, ListPagedResponse>() {
            @Override
            public ApiFuture<ListPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRegionOperationsRequest, OperationList> callable,
                ListRegionOperationsRequest request,
                ApiCallContext context,
                ApiFuture<OperationList> futureResponse) {
              PageContext<ListRegionOperationsRequest, OperationList, Operation> pageContext =
                  PageContext.create(callable, LIST_PAGE_STR_DESC, request, context);
              return ListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteRegionOperationRequest, DeleteRegionOperationResponse>
      deleteSettings() {
    return deleteSettings;
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetRegionOperationRequest, Operation> getSettings() {
    return getSettings;
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListRegionOperationsRequest, OperationList, ListPagedResponse>
      listSettings() {
    return listSettings;
  }

  /** Returns the object with the settings used for calls to wait. */
  public UnaryCallSettings<WaitRegionOperationRequest, Operation> waitSettings() {
    return waitSettings;
  }

  public RegionOperationsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonRegionOperationsStub.create(this);
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
    return "compute.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "compute.mtls.googleapis.com:443";
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

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(RegionOperationsStubSettings.class))
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

  protected RegionOperationsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    deleteSettings = settingsBuilder.deleteSettings().build();
    getSettings = settingsBuilder.getSettings().build();
    listSettings = settingsBuilder.listSettings().build();
    waitSettings = settingsBuilder.waitSettings().build();
  }

  /** Builder for RegionOperationsStubSettings. */
  public static class Builder extends StubSettings.Builder<RegionOperationsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<
            DeleteRegionOperationRequest, DeleteRegionOperationResponse>
        deleteSettings;
    private final UnaryCallSettings.Builder<GetRegionOperationRequest, Operation> getSettings;
    private final PagedCallSettings.Builder<
            ListRegionOperationsRequest, OperationList, ListPagedResponse>
        listSettings;
    private final UnaryCallSettings.Builder<WaitRegionOperationRequest, Operation> waitSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      deleteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSettings = PagedCallSettings.newBuilder(LIST_PAGE_STR_FACT);
      waitSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deleteSettings, getSettings, listSettings, waitSettings);
      initDefaults(this);
    }

    protected Builder(RegionOperationsStubSettings settings) {
      super(settings);

      deleteSettings = settings.deleteSettings.toBuilder();
      getSettings = settings.getSettings.toBuilder();
      listSettings = settings.listSettings.toBuilder();
      waitSettings = settings.waitSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deleteSettings, getSettings, listSettings, waitSettings);
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

    private static Builder initDefaults(Builder builder) {
      builder
          .deleteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .waitSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

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

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteRegionOperationRequest, DeleteRegionOperationResponse>
        deleteSettings() {
      return deleteSettings;
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetRegionOperationRequest, Operation> getSettings() {
      return getSettings;
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<ListRegionOperationsRequest, OperationList, ListPagedResponse>
        listSettings() {
      return listSettings;
    }

    /** Returns the builder for the settings used for calls to wait. */
    public UnaryCallSettings.Builder<WaitRegionOperationRequest, Operation> waitSettings() {
      return waitSettings;
    }

    @Override
    public RegionOperationsStubSettings build() throws IOException {
      return new RegionOperationsStubSettings(this);
    }
  }
}
