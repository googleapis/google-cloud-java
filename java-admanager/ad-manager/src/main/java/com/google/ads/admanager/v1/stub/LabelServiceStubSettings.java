/*
 * Copyright 2024 Google LLC
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

import static com.google.ads.admanager.v1.LabelServiceClient.ListLabelsPagedResponse;

import com.google.ads.admanager.v1.GetLabelRequest;
import com.google.ads.admanager.v1.Label;
import com.google.ads.admanager.v1.ListLabelsRequest;
import com.google.ads.admanager.v1.ListLabelsResponse;
import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
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
 * Settings class to configure an instance of {@link LabelServiceStub}.
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
 * <p>For example, to set the total timeout of getLabel to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LabelServiceStubSettings.Builder labelServiceSettingsBuilder =
 *     LabelServiceStubSettings.newBuilder();
 * labelServiceSettingsBuilder
 *     .getLabelSettings()
 *     .setRetrySettings(
 *         labelServiceSettingsBuilder
 *             .getLabelSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * LabelServiceStubSettings labelServiceSettings = labelServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class LabelServiceStubSettings extends StubSettings<LabelServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().build();

  private final UnaryCallSettings<GetLabelRequest, Label> getLabelSettings;
  private final PagedCallSettings<ListLabelsRequest, ListLabelsResponse, ListLabelsPagedResponse>
      listLabelsSettings;

  private static final PagedListDescriptor<ListLabelsRequest, ListLabelsResponse, Label>
      LIST_LABELS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLabelsRequest, ListLabelsResponse, Label>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLabelsRequest injectToken(ListLabelsRequest payload, String token) {
              return ListLabelsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLabelsRequest injectPageSize(ListLabelsRequest payload, int pageSize) {
              return ListLabelsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLabelsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLabelsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Label> extractResources(ListLabelsResponse payload) {
              return payload.getLabelsList() == null
                  ? ImmutableList.<Label>of()
                  : payload.getLabelsList();
            }
          };

  private static final PagedListResponseFactory<
          ListLabelsRequest, ListLabelsResponse, ListLabelsPagedResponse>
      LIST_LABELS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLabelsRequest, ListLabelsResponse, ListLabelsPagedResponse>() {
            @Override
            public ApiFuture<ListLabelsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLabelsRequest, ListLabelsResponse> callable,
                ListLabelsRequest request,
                ApiCallContext context,
                ApiFuture<ListLabelsResponse> futureResponse) {
              PageContext<ListLabelsRequest, ListLabelsResponse, Label> pageContext =
                  PageContext.create(callable, LIST_LABELS_PAGE_STR_DESC, request, context);
              return ListLabelsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getLabel. */
  public UnaryCallSettings<GetLabelRequest, Label> getLabelSettings() {
    return getLabelSettings;
  }

  /** Returns the object with the settings used for calls to listLabels. */
  public PagedCallSettings<ListLabelsRequest, ListLabelsResponse, ListLabelsPagedResponse>
      listLabelsSettings() {
    return listLabelsSettings;
  }

  public LabelServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonLabelServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(LabelServiceStubSettings.class))
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

  protected LabelServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getLabelSettings = settingsBuilder.getLabelSettings().build();
    listLabelsSettings = settingsBuilder.listLabelsSettings().build();
  }

  /** Builder for LabelServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<LabelServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetLabelRequest, Label> getLabelSettings;
    private final PagedCallSettings.Builder<
            ListLabelsRequest, ListLabelsResponse, ListLabelsPagedResponse>
        listLabelsSettings;
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

      getLabelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLabelsSettings = PagedCallSettings.newBuilder(LIST_LABELS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(getLabelSettings, listLabelsSettings);
      initDefaults(this);
    }

    protected Builder(LabelServiceStubSettings settings) {
      super(settings);

      getLabelSettings = settings.getLabelSettings.toBuilder();
      listLabelsSettings = settings.listLabelsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(getLabelSettings, listLabelsSettings);
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
          .getLabelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listLabelsSettings()
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

    /** Returns the builder for the settings used for calls to getLabel. */
    public UnaryCallSettings.Builder<GetLabelRequest, Label> getLabelSettings() {
      return getLabelSettings;
    }

    /** Returns the builder for the settings used for calls to listLabels. */
    public PagedCallSettings.Builder<ListLabelsRequest, ListLabelsResponse, ListLabelsPagedResponse>
        listLabelsSettings() {
      return listLabelsSettings;
    }

    @Override
    public LabelServiceStubSettings build() throws IOException {
      return new LabelServiceStubSettings(this);
    }
  }
}
