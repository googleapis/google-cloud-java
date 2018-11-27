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

import static com.google.cloud.compute.v1.InterconnectLocationClient.ListInterconnectLocationsPagedResponse;

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
import com.google.cloud.compute.v1.GetInterconnectLocationHttpRequest;
import com.google.cloud.compute.v1.InterconnectLocation;
import com.google.cloud.compute.v1.InterconnectLocationList;
import com.google.cloud.compute.v1.ListInterconnectLocationsHttpRequest;
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
 * Settings class to configure an instance of {@link InterconnectLocationStub}.
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
 * example, to set the total timeout of getInterconnectLocation to 30 seconds:
 *
 * <pre>
 * <code>
 * InterconnectLocationStubSettings.Builder interconnectLocationSettingsBuilder =
 *     InterconnectLocationStubSettings.newBuilder();
 * interconnectLocationSettingsBuilder.getInterconnectLocationSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * InterconnectLocationStubSettings interconnectLocationSettings = interconnectLocationSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class InterconnectLocationStubSettings
    extends StubSettings<InterconnectLocationStubSettings> {
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

  private final UnaryCallSettings<GetInterconnectLocationHttpRequest, InterconnectLocation>
      getInterconnectLocationSettings;
  private final PagedCallSettings<
          ListInterconnectLocationsHttpRequest, InterconnectLocationList,
          ListInterconnectLocationsPagedResponse>
      listInterconnectLocationsSettings;

  /** Returns the object with the settings used for calls to getInterconnectLocation. */
  public UnaryCallSettings<GetInterconnectLocationHttpRequest, InterconnectLocation>
      getInterconnectLocationSettings() {
    return getInterconnectLocationSettings;
  }

  /** Returns the object with the settings used for calls to listInterconnectLocations. */
  public PagedCallSettings<
          ListInterconnectLocationsHttpRequest, InterconnectLocationList,
          ListInterconnectLocationsPagedResponse>
      listInterconnectLocationsSettings() {
    return listInterconnectLocationsSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public InterconnectLocationStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonInterconnectLocationStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(InterconnectLocationStubSettings.class))
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

  protected InterconnectLocationStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getInterconnectLocationSettings = settingsBuilder.getInterconnectLocationSettings().build();
    listInterconnectLocationsSettings = settingsBuilder.listInterconnectLocationsSettings().build();
  }

  private static final PagedListDescriptor<
          ListInterconnectLocationsHttpRequest, InterconnectLocationList, InterconnectLocation>
      LIST_INTERCONNECT_LOCATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListInterconnectLocationsHttpRequest, InterconnectLocationList,
              InterconnectLocation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListInterconnectLocationsHttpRequest injectToken(
                ListInterconnectLocationsHttpRequest payload, String token) {
              return ListInterconnectLocationsHttpRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListInterconnectLocationsHttpRequest injectPageSize(
                ListInterconnectLocationsHttpRequest payload, int pageSize) {
              return ListInterconnectLocationsHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListInterconnectLocationsHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(InterconnectLocationList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<InterconnectLocation> extractResources(
                InterconnectLocationList payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<InterconnectLocation>of();
            }
          };

  private static final PagedListResponseFactory<
          ListInterconnectLocationsHttpRequest, InterconnectLocationList,
          ListInterconnectLocationsPagedResponse>
      LIST_INTERCONNECT_LOCATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListInterconnectLocationsHttpRequest, InterconnectLocationList,
              ListInterconnectLocationsPagedResponse>() {
            @Override
            public ApiFuture<ListInterconnectLocationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListInterconnectLocationsHttpRequest, InterconnectLocationList>
                    callable,
                ListInterconnectLocationsHttpRequest request,
                ApiCallContext context,
                ApiFuture<InterconnectLocationList> futureResponse) {
              PageContext<
                      ListInterconnectLocationsHttpRequest, InterconnectLocationList,
                      InterconnectLocation>
                  pageContext =
                      PageContext.create(
                          callable, LIST_INTERCONNECT_LOCATIONS_PAGE_STR_DESC, request, context);
              return ListInterconnectLocationsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Builder for InterconnectLocationStubSettings. */
  public static class Builder
      extends StubSettings.Builder<InterconnectLocationStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<
            GetInterconnectLocationHttpRequest, InterconnectLocation>
        getInterconnectLocationSettings;
    private final PagedCallSettings.Builder<
            ListInterconnectLocationsHttpRequest, InterconnectLocationList,
            ListInterconnectLocationsPagedResponse>
        listInterconnectLocationsSettings;

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

      getInterconnectLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listInterconnectLocationsSettings =
          PagedCallSettings.newBuilder(LIST_INTERCONNECT_LOCATIONS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getInterconnectLocationSettings, listInterconnectLocationsSettings);

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
          .getInterconnectLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listInterconnectLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(InterconnectLocationStubSettings settings) {
      super(settings);

      getInterconnectLocationSettings = settings.getInterconnectLocationSettings.toBuilder();
      listInterconnectLocationsSettings = settings.listInterconnectLocationsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getInterconnectLocationSettings, listInterconnectLocationsSettings);
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

    /** Returns the builder for the settings used for calls to getInterconnectLocation. */
    public UnaryCallSettings.Builder<GetInterconnectLocationHttpRequest, InterconnectLocation>
        getInterconnectLocationSettings() {
      return getInterconnectLocationSettings;
    }

    /** Returns the builder for the settings used for calls to listInterconnectLocations. */
    public PagedCallSettings.Builder<
            ListInterconnectLocationsHttpRequest, InterconnectLocationList,
            ListInterconnectLocationsPagedResponse>
        listInterconnectLocationsSettings() {
      return listInterconnectLocationsSettings;
    }

    @Override
    public InterconnectLocationStubSettings build() throws IOException {
      return new InterconnectLocationStubSettings(this);
    }
  }
}
