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

import static com.google.ads.admanager.v1.AdPartnerServiceClient.ListAdPartnersPagedResponse;

import com.google.ads.admanager.v1.AdPartner;
import com.google.ads.admanager.v1.GetAdPartnerRequest;
import com.google.ads.admanager.v1.ListAdPartnersRequest;
import com.google.ads.admanager.v1.ListAdPartnersResponse;
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
 * Settings class to configure an instance of {@link AdPartnerServiceStub}.
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
 * <p>For example, to set the total timeout of getAdPartner to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AdPartnerServiceStubSettings.Builder adPartnerServiceSettingsBuilder =
 *     AdPartnerServiceStubSettings.newBuilder();
 * adPartnerServiceSettingsBuilder
 *     .getAdPartnerSettings()
 *     .setRetrySettings(
 *         adPartnerServiceSettingsBuilder
 *             .getAdPartnerSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AdPartnerServiceStubSettings adPartnerServiceSettings = adPartnerServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AdPartnerServiceStubSettings extends StubSettings<AdPartnerServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().build();

  private final UnaryCallSettings<GetAdPartnerRequest, AdPartner> getAdPartnerSettings;
  private final PagedCallSettings<
          ListAdPartnersRequest, ListAdPartnersResponse, ListAdPartnersPagedResponse>
      listAdPartnersSettings;

  private static final PagedListDescriptor<ListAdPartnersRequest, ListAdPartnersResponse, AdPartner>
      LIST_AD_PARTNERS_PAGE_STR_DESC =
          new PagedListDescriptor<ListAdPartnersRequest, ListAdPartnersResponse, AdPartner>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAdPartnersRequest injectToken(ListAdPartnersRequest payload, String token) {
              return ListAdPartnersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAdPartnersRequest injectPageSize(
                ListAdPartnersRequest payload, int pageSize) {
              return ListAdPartnersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAdPartnersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAdPartnersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AdPartner> extractResources(ListAdPartnersResponse payload) {
              return payload.getAdPartnersList() == null
                  ? ImmutableList.<AdPartner>of()
                  : payload.getAdPartnersList();
            }
          };

  private static final PagedListResponseFactory<
          ListAdPartnersRequest, ListAdPartnersResponse, ListAdPartnersPagedResponse>
      LIST_AD_PARTNERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAdPartnersRequest, ListAdPartnersResponse, ListAdPartnersPagedResponse>() {
            @Override
            public ApiFuture<ListAdPartnersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAdPartnersRequest, ListAdPartnersResponse> callable,
                ListAdPartnersRequest request,
                ApiCallContext context,
                ApiFuture<ListAdPartnersResponse> futureResponse) {
              PageContext<ListAdPartnersRequest, ListAdPartnersResponse, AdPartner> pageContext =
                  PageContext.create(callable, LIST_AD_PARTNERS_PAGE_STR_DESC, request, context);
              return ListAdPartnersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getAdPartner. */
  public UnaryCallSettings<GetAdPartnerRequest, AdPartner> getAdPartnerSettings() {
    return getAdPartnerSettings;
  }

  /** Returns the object with the settings used for calls to listAdPartners. */
  public PagedCallSettings<
          ListAdPartnersRequest, ListAdPartnersResponse, ListAdPartnersPagedResponse>
      listAdPartnersSettings() {
    return listAdPartnersSettings;
  }

  public AdPartnerServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonAdPartnerServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(AdPartnerServiceStubSettings.class))
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

  protected AdPartnerServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getAdPartnerSettings = settingsBuilder.getAdPartnerSettings().build();
    listAdPartnersSettings = settingsBuilder.listAdPartnersSettings().build();
  }

  /** Builder for AdPartnerServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<AdPartnerServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetAdPartnerRequest, AdPartner> getAdPartnerSettings;
    private final PagedCallSettings.Builder<
            ListAdPartnersRequest, ListAdPartnersResponse, ListAdPartnersPagedResponse>
        listAdPartnersSettings;
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

      getAdPartnerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAdPartnersSettings = PagedCallSettings.newBuilder(LIST_AD_PARTNERS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getAdPartnerSettings, listAdPartnersSettings);
      initDefaults(this);
    }

    protected Builder(AdPartnerServiceStubSettings settings) {
      super(settings);

      getAdPartnerSettings = settings.getAdPartnerSettings.toBuilder();
      listAdPartnersSettings = settings.listAdPartnersSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getAdPartnerSettings, listAdPartnersSettings);
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
          .getAdPartnerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listAdPartnersSettings()
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

    /** Returns the builder for the settings used for calls to getAdPartner. */
    public UnaryCallSettings.Builder<GetAdPartnerRequest, AdPartner> getAdPartnerSettings() {
      return getAdPartnerSettings;
    }

    /** Returns the builder for the settings used for calls to listAdPartners. */
    public PagedCallSettings.Builder<
            ListAdPartnersRequest, ListAdPartnersResponse, ListAdPartnersPagedResponse>
        listAdPartnersSettings() {
      return listAdPartnersSettings;
    }

    @Override
    public AdPartnerServiceStubSettings build() throws IOException {
      return new AdPartnerServiceStubSettings(this);
    }
  }
}
