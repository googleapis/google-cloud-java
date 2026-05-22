/*
 * Copyright 2026 Google LLC
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

import static com.google.ads.admanager.v1.LinkedDeviceServiceClient.ListLinkedDevicesPagedResponse;

import com.google.ads.admanager.v1.GetLinkedDeviceRequest;
import com.google.ads.admanager.v1.LinkedDevice;
import com.google.ads.admanager.v1.ListLinkedDevicesRequest;
import com.google.ads.admanager.v1.ListLinkedDevicesResponse;
import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ObsoleteApi;
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
import com.google.api.gax.rpc.LibraryMetadata;
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
 * Settings class to configure an instance of {@link LinkedDeviceServiceStub}.
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
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getLinkedDevice:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LinkedDeviceServiceStubSettings.Builder linkedDeviceServiceSettingsBuilder =
 *     LinkedDeviceServiceStubSettings.newBuilder();
 * linkedDeviceServiceSettingsBuilder
 *     .getLinkedDeviceSettings()
 *     .setRetrySettings(
 *         linkedDeviceServiceSettingsBuilder
 *             .getLinkedDeviceSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * LinkedDeviceServiceStubSettings linkedDeviceServiceSettings =
 *     linkedDeviceServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class LinkedDeviceServiceStubSettings extends StubSettings<LinkedDeviceServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/admanager")
          .add("https://www.googleapis.com/auth/admanager.readonly")
          .build();

  private final UnaryCallSettings<GetLinkedDeviceRequest, LinkedDevice> getLinkedDeviceSettings;
  private final PagedCallSettings<
          ListLinkedDevicesRequest, ListLinkedDevicesResponse, ListLinkedDevicesPagedResponse>
      listLinkedDevicesSettings;

  private static final PagedListDescriptor<
          ListLinkedDevicesRequest, ListLinkedDevicesResponse, LinkedDevice>
      LIST_LINKED_DEVICES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListLinkedDevicesRequest, ListLinkedDevicesResponse, LinkedDevice>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLinkedDevicesRequest injectToken(
                ListLinkedDevicesRequest payload, String token) {
              return ListLinkedDevicesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLinkedDevicesRequest injectPageSize(
                ListLinkedDevicesRequest payload, int pageSize) {
              return ListLinkedDevicesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLinkedDevicesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLinkedDevicesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<LinkedDevice> extractResources(ListLinkedDevicesResponse payload) {
              return payload.getLinkedDevicesList();
            }
          };

  private static final PagedListResponseFactory<
          ListLinkedDevicesRequest, ListLinkedDevicesResponse, ListLinkedDevicesPagedResponse>
      LIST_LINKED_DEVICES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLinkedDevicesRequest,
              ListLinkedDevicesResponse,
              ListLinkedDevicesPagedResponse>() {
            @Override
            public ApiFuture<ListLinkedDevicesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLinkedDevicesRequest, ListLinkedDevicesResponse> callable,
                ListLinkedDevicesRequest request,
                ApiCallContext context,
                ApiFuture<ListLinkedDevicesResponse> futureResponse) {
              PageContext<ListLinkedDevicesRequest, ListLinkedDevicesResponse, LinkedDevice>
                  pageContext =
                      PageContext.create(
                          callable, LIST_LINKED_DEVICES_PAGE_STR_DESC, request, context);
              return ListLinkedDevicesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getLinkedDevice. */
  public UnaryCallSettings<GetLinkedDeviceRequest, LinkedDevice> getLinkedDeviceSettings() {
    return getLinkedDeviceSettings;
  }

  /** Returns the object with the settings used for calls to listLinkedDevices. */
  public PagedCallSettings<
          ListLinkedDevicesRequest, ListLinkedDevicesResponse, ListLinkedDevicesPagedResponse>
      listLinkedDevicesSettings() {
    return listLinkedDevicesSettings;
  }

  public LinkedDeviceServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonLinkedDeviceServiceStub.create(this);
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
  @ObsoleteApi("Use getEndpoint() instead")
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
            "gapic", GaxProperties.getLibraryVersion(LinkedDeviceServiceStubSettings.class))
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

  protected LinkedDeviceServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getLinkedDeviceSettings = settingsBuilder.getLinkedDeviceSettings().build();
    listLinkedDevicesSettings = settingsBuilder.listLinkedDevicesSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.api-ads:ad-manager")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for LinkedDeviceServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<LinkedDeviceServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetLinkedDeviceRequest, LinkedDevice>
        getLinkedDeviceSettings;
    private final PagedCallSettings.Builder<
            ListLinkedDevicesRequest, ListLinkedDevicesResponse, ListLinkedDevicesPagedResponse>
        listLinkedDevicesSettings;
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

      getLinkedDeviceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLinkedDevicesSettings = PagedCallSettings.newBuilder(LIST_LINKED_DEVICES_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getLinkedDeviceSettings, listLinkedDevicesSettings);
      initDefaults(this);
    }

    protected Builder(LinkedDeviceServiceStubSettings settings) {
      super(settings);

      getLinkedDeviceSettings = settings.getLinkedDeviceSettings.toBuilder();
      listLinkedDevicesSettings = settings.listLinkedDevicesSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getLinkedDeviceSettings, listLinkedDevicesSettings);
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
          .getLinkedDeviceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listLinkedDevicesSettings()
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

    /** Returns the builder for the settings used for calls to getLinkedDevice. */
    public UnaryCallSettings.Builder<GetLinkedDeviceRequest, LinkedDevice>
        getLinkedDeviceSettings() {
      return getLinkedDeviceSettings;
    }

    /** Returns the builder for the settings used for calls to listLinkedDevices. */
    public PagedCallSettings.Builder<
            ListLinkedDevicesRequest, ListLinkedDevicesResponse, ListLinkedDevicesPagedResponse>
        listLinkedDevicesSettings() {
      return listLinkedDevicesSettings;
    }

    @Override
    public LinkedDeviceServiceStubSettings build() throws IOException {
      return new LinkedDeviceServiceStubSettings(this);
    }
  }
}
