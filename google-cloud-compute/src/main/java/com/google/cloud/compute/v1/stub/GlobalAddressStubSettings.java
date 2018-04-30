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

import static com.google.cloud.compute.v1.GlobalAddressClient.ListGlobalAddressesPagedResponse;

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
import com.google.cloud.compute.v1.Address;
import com.google.cloud.compute.v1.AddressList;
import com.google.cloud.compute.v1.DeleteGlobalAddressHttpRequest;
import com.google.cloud.compute.v1.GetGlobalAddressHttpRequest;
import com.google.cloud.compute.v1.InsertGlobalAddressHttpRequest;
import com.google.cloud.compute.v1.ListGlobalAddressesHttpRequest;
import com.google.cloud.compute.v1.Operation;
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
 * Settings class to configure an instance of {@link GlobalAddressStub}.
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
 * example, to set the total timeout of deleteGlobalAddress to 30 seconds:
 *
 * <pre>
 * <code>
 * GlobalAddressStubSettings.Builder globalAddressSettingsBuilder =
 *     GlobalAddressStubSettings.newBuilder();
 * globalAddressSettingsBuilder.deleteGlobalAddressSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * GlobalAddressStubSettings globalAddressSettings = globalAddressSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class GlobalAddressStubSettings extends StubSettings<GlobalAddressStubSettings> {
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

  private final UnaryCallSettings<DeleteGlobalAddressHttpRequest, Operation>
      deleteGlobalAddressSettings;
  private final UnaryCallSettings<GetGlobalAddressHttpRequest, Address> getGlobalAddressSettings;
  private final UnaryCallSettings<InsertGlobalAddressHttpRequest, Operation>
      insertGlobalAddressSettings;
  private final PagedCallSettings<
          ListGlobalAddressesHttpRequest, AddressList, ListGlobalAddressesPagedResponse>
      listGlobalAddressesSettings;

  /** Returns the object with the settings used for calls to deleteGlobalAddress. */
  public UnaryCallSettings<DeleteGlobalAddressHttpRequest, Operation>
      deleteGlobalAddressSettings() {
    return deleteGlobalAddressSettings;
  }

  /** Returns the object with the settings used for calls to getGlobalAddress. */
  public UnaryCallSettings<GetGlobalAddressHttpRequest, Address> getGlobalAddressSettings() {
    return getGlobalAddressSettings;
  }

  /** Returns the object with the settings used for calls to insertGlobalAddress. */
  public UnaryCallSettings<InsertGlobalAddressHttpRequest, Operation>
      insertGlobalAddressSettings() {
    return insertGlobalAddressSettings;
  }

  /** Returns the object with the settings used for calls to listGlobalAddresses. */
  public PagedCallSettings<
          ListGlobalAddressesHttpRequest, AddressList, ListGlobalAddressesPagedResponse>
      listGlobalAddressesSettings() {
    return listGlobalAddressesSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public GlobalAddressStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonGlobalAddressStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(GlobalAddressStubSettings.class))
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

  protected GlobalAddressStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    deleteGlobalAddressSettings = settingsBuilder.deleteGlobalAddressSettings().build();
    getGlobalAddressSettings = settingsBuilder.getGlobalAddressSettings().build();
    insertGlobalAddressSettings = settingsBuilder.insertGlobalAddressSettings().build();
    listGlobalAddressesSettings = settingsBuilder.listGlobalAddressesSettings().build();
  }

  private static final PagedListDescriptor<ListGlobalAddressesHttpRequest, AddressList, Address>
      LIST_GLOBAL_ADDRESSES_PAGE_STR_DESC =
          new PagedListDescriptor<ListGlobalAddressesHttpRequest, AddressList, Address>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListGlobalAddressesHttpRequest injectToken(
                ListGlobalAddressesHttpRequest payload, String token) {
              return ListGlobalAddressesHttpRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListGlobalAddressesHttpRequest injectPageSize(
                ListGlobalAddressesHttpRequest payload, int pageSize) {
              return ListGlobalAddressesHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListGlobalAddressesHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(AddressList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Address> extractResources(AddressList payload) {
              return payload.getItemsList();
            }
          };

  private static final PagedListResponseFactory<
          ListGlobalAddressesHttpRequest, AddressList, ListGlobalAddressesPagedResponse>
      LIST_GLOBAL_ADDRESSES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListGlobalAddressesHttpRequest, AddressList, ListGlobalAddressesPagedResponse>() {
            @Override
            public ApiFuture<ListGlobalAddressesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListGlobalAddressesHttpRequest, AddressList> callable,
                ListGlobalAddressesHttpRequest request,
                ApiCallContext context,
                ApiFuture<AddressList> futureResponse) {
              PageContext<ListGlobalAddressesHttpRequest, AddressList, Address> pageContext =
                  PageContext.create(
                      callable, LIST_GLOBAL_ADDRESSES_PAGE_STR_DESC, request, context);
              return ListGlobalAddressesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for GlobalAddressStubSettings. */
  public static class Builder extends StubSettings.Builder<GlobalAddressStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<DeleteGlobalAddressHttpRequest, Operation>
        deleteGlobalAddressSettings;
    private final UnaryCallSettings.Builder<GetGlobalAddressHttpRequest, Address>
        getGlobalAddressSettings;
    private final UnaryCallSettings.Builder<InsertGlobalAddressHttpRequest, Operation>
        insertGlobalAddressSettings;
    private final PagedCallSettings.Builder<
            ListGlobalAddressesHttpRequest, AddressList, ListGlobalAddressesPagedResponse>
        listGlobalAddressesSettings;

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

      deleteGlobalAddressSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getGlobalAddressSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      insertGlobalAddressSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listGlobalAddressesSettings =
          PagedCallSettings.newBuilder(LIST_GLOBAL_ADDRESSES_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deleteGlobalAddressSettings,
              getGlobalAddressSettings,
              insertGlobalAddressSettings,
              listGlobalAddressesSettings);

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
          .deleteGlobalAddressSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getGlobalAddressSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .insertGlobalAddressSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listGlobalAddressesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(GlobalAddressStubSettings settings) {
      super(settings);

      deleteGlobalAddressSettings = settings.deleteGlobalAddressSettings.toBuilder();
      getGlobalAddressSettings = settings.getGlobalAddressSettings.toBuilder();
      insertGlobalAddressSettings = settings.insertGlobalAddressSettings.toBuilder();
      listGlobalAddressesSettings = settings.listGlobalAddressesSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deleteGlobalAddressSettings,
              getGlobalAddressSettings,
              insertGlobalAddressSettings,
              listGlobalAddressesSettings);
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

    /** Returns the builder for the settings used for calls to deleteGlobalAddress. */
    public UnaryCallSettings.Builder<DeleteGlobalAddressHttpRequest, Operation>
        deleteGlobalAddressSettings() {
      return deleteGlobalAddressSettings;
    }

    /** Returns the builder for the settings used for calls to getGlobalAddress. */
    public UnaryCallSettings.Builder<GetGlobalAddressHttpRequest, Address>
        getGlobalAddressSettings() {
      return getGlobalAddressSettings;
    }

    /** Returns the builder for the settings used for calls to insertGlobalAddress. */
    public UnaryCallSettings.Builder<InsertGlobalAddressHttpRequest, Operation>
        insertGlobalAddressSettings() {
      return insertGlobalAddressSettings;
    }

    /** Returns the builder for the settings used for calls to listGlobalAddresses. */
    public PagedCallSettings.Builder<
            ListGlobalAddressesHttpRequest, AddressList, ListGlobalAddressesPagedResponse>
        listGlobalAddressesSettings() {
      return listGlobalAddressesSettings;
    }

    @Override
    public GlobalAddressStubSettings build() throws IOException {
      return new GlobalAddressStubSettings(this);
    }
  }
}
