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

import static com.google.cloud.compute.v1.AddressClient.AggregatedListAddressesPagedResponse;
import static com.google.cloud.compute.v1.AddressClient.ListAddressesPagedResponse;

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
import com.google.cloud.compute.v1.AddressAggregatedList;
import com.google.cloud.compute.v1.AddressList;
import com.google.cloud.compute.v1.AddressesScopedList;
import com.google.cloud.compute.v1.AggregatedListAddressesHttpRequest;
import com.google.cloud.compute.v1.DeleteAddressHttpRequest;
import com.google.cloud.compute.v1.GetAddressHttpRequest;
import com.google.cloud.compute.v1.InsertAddressHttpRequest;
import com.google.cloud.compute.v1.ListAddressesHttpRequest;
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
 * Settings class to configure an instance of {@link AddressStub}.
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
 * example, to set the total timeout of deleteAddress to 30 seconds:
 *
 * <pre>
 * <code>
 * AddressStubSettings.Builder addressSettingsBuilder =
 *     AddressStubSettings.newBuilder();
 * addressSettingsBuilder.deleteAddressSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * AddressStubSettings addressSettings = addressSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class AddressStubSettings extends StubSettings<AddressStubSettings> {
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

  private final PagedCallSettings<
          AggregatedListAddressesHttpRequest, AddressAggregatedList,
          AggregatedListAddressesPagedResponse>
      aggregatedListAddressesSettings;
  private final UnaryCallSettings<DeleteAddressHttpRequest, Operation> deleteAddressSettings;
  private final UnaryCallSettings<GetAddressHttpRequest, Address> getAddressSettings;
  private final UnaryCallSettings<InsertAddressHttpRequest, Operation> insertAddressSettings;
  private final PagedCallSettings<ListAddressesHttpRequest, AddressList, ListAddressesPagedResponse>
      listAddressesSettings;

  /** Returns the object with the settings used for calls to aggregatedListAddresses. */
  public PagedCallSettings<
          AggregatedListAddressesHttpRequest, AddressAggregatedList,
          AggregatedListAddressesPagedResponse>
      aggregatedListAddressesSettings() {
    return aggregatedListAddressesSettings;
  }

  /** Returns the object with the settings used for calls to deleteAddress. */
  public UnaryCallSettings<DeleteAddressHttpRequest, Operation> deleteAddressSettings() {
    return deleteAddressSettings;
  }

  /** Returns the object with the settings used for calls to getAddress. */
  public UnaryCallSettings<GetAddressHttpRequest, Address> getAddressSettings() {
    return getAddressSettings;
  }

  /** Returns the object with the settings used for calls to insertAddress. */
  public UnaryCallSettings<InsertAddressHttpRequest, Operation> insertAddressSettings() {
    return insertAddressSettings;
  }

  /** Returns the object with the settings used for calls to listAddresses. */
  public PagedCallSettings<ListAddressesHttpRequest, AddressList, ListAddressesPagedResponse>
      listAddressesSettings() {
    return listAddressesSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public AddressStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonAddressStub.create(this);
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(AddressStubSettings.class))
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

  protected AddressStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    aggregatedListAddressesSettings = settingsBuilder.aggregatedListAddressesSettings().build();
    deleteAddressSettings = settingsBuilder.deleteAddressSettings().build();
    getAddressSettings = settingsBuilder.getAddressSettings().build();
    insertAddressSettings = settingsBuilder.insertAddressSettings().build();
    listAddressesSettings = settingsBuilder.listAddressesSettings().build();
  }

  private static final PagedListDescriptor<
          AggregatedListAddressesHttpRequest, AddressAggregatedList, AddressesScopedList>
      AGGREGATED_LIST_ADDRESSES_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregatedListAddressesHttpRequest, AddressAggregatedList, AddressesScopedList>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregatedListAddressesHttpRequest injectToken(
                AggregatedListAddressesHttpRequest payload, String token) {
              return AggregatedListAddressesHttpRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public AggregatedListAddressesHttpRequest injectPageSize(
                AggregatedListAddressesHttpRequest payload, int pageSize) {
              return AggregatedListAddressesHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(AggregatedListAddressesHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(AddressAggregatedList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AddressesScopedList> extractResources(AddressAggregatedList payload) {
              return payload.getItemsMap() != null
                  ? payload.getItemsMap().values()
                  : ImmutableList.<AddressesScopedList>of();
            }
          };

  private static final PagedListDescriptor<ListAddressesHttpRequest, AddressList, Address>
      LIST_ADDRESSES_PAGE_STR_DESC =
          new PagedListDescriptor<ListAddressesHttpRequest, AddressList, Address>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAddressesHttpRequest injectToken(
                ListAddressesHttpRequest payload, String token) {
              return ListAddressesHttpRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAddressesHttpRequest injectPageSize(
                ListAddressesHttpRequest payload, int pageSize) {
              return ListAddressesHttpRequest.newBuilder(payload).setMaxResults(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAddressesHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(AddressList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Address> extractResources(AddressList payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<Address>of();
            }
          };

  private static final PagedListResponseFactory<
          AggregatedListAddressesHttpRequest, AddressAggregatedList,
          AggregatedListAddressesPagedResponse>
      AGGREGATED_LIST_ADDRESSES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregatedListAddressesHttpRequest, AddressAggregatedList,
              AggregatedListAddressesPagedResponse>() {
            @Override
            public ApiFuture<AggregatedListAddressesPagedResponse> getFuturePagedResponse(
                UnaryCallable<AggregatedListAddressesHttpRequest, AddressAggregatedList> callable,
                AggregatedListAddressesHttpRequest request,
                ApiCallContext context,
                ApiFuture<AddressAggregatedList> futureResponse) {
              PageContext<
                      AggregatedListAddressesHttpRequest, AddressAggregatedList,
                      AddressesScopedList>
                  pageContext =
                      PageContext.create(
                          callable, AGGREGATED_LIST_ADDRESSES_PAGE_STR_DESC, request, context);
              return AggregatedListAddressesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAddressesHttpRequest, AddressList, ListAddressesPagedResponse>
      LIST_ADDRESSES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAddressesHttpRequest, AddressList, ListAddressesPagedResponse>() {
            @Override
            public ApiFuture<ListAddressesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAddressesHttpRequest, AddressList> callable,
                ListAddressesHttpRequest request,
                ApiCallContext context,
                ApiFuture<AddressList> futureResponse) {
              PageContext<ListAddressesHttpRequest, AddressList, Address> pageContext =
                  PageContext.create(callable, LIST_ADDRESSES_PAGE_STR_DESC, request, context);
              return ListAddressesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for AddressStubSettings. */
  public static class Builder extends StubSettings.Builder<AddressStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final PagedCallSettings.Builder<
            AggregatedListAddressesHttpRequest, AddressAggregatedList,
            AggregatedListAddressesPagedResponse>
        aggregatedListAddressesSettings;
    private final UnaryCallSettings.Builder<DeleteAddressHttpRequest, Operation>
        deleteAddressSettings;
    private final UnaryCallSettings.Builder<GetAddressHttpRequest, Address> getAddressSettings;
    private final UnaryCallSettings.Builder<InsertAddressHttpRequest, Operation>
        insertAddressSettings;
    private final PagedCallSettings.Builder<
            ListAddressesHttpRequest, AddressList, ListAddressesPagedResponse>
        listAddressesSettings;

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

      aggregatedListAddressesSettings =
          PagedCallSettings.newBuilder(AGGREGATED_LIST_ADDRESSES_PAGE_STR_FACT);

      deleteAddressSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getAddressSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      insertAddressSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listAddressesSettings = PagedCallSettings.newBuilder(LIST_ADDRESSES_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListAddressesSettings,
              deleteAddressSettings,
              getAddressSettings,
              insertAddressSettings,
              listAddressesSettings);

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
          .aggregatedListAddressesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteAddressSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getAddressSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .insertAddressSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listAddressesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(AddressStubSettings settings) {
      super(settings);

      aggregatedListAddressesSettings = settings.aggregatedListAddressesSettings.toBuilder();
      deleteAddressSettings = settings.deleteAddressSettings.toBuilder();
      getAddressSettings = settings.getAddressSettings.toBuilder();
      insertAddressSettings = settings.insertAddressSettings.toBuilder();
      listAddressesSettings = settings.listAddressesSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListAddressesSettings,
              deleteAddressSettings,
              getAddressSettings,
              insertAddressSettings,
              listAddressesSettings);
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

    /** Returns the builder for the settings used for calls to aggregatedListAddresses. */
    public PagedCallSettings.Builder<
            AggregatedListAddressesHttpRequest, AddressAggregatedList,
            AggregatedListAddressesPagedResponse>
        aggregatedListAddressesSettings() {
      return aggregatedListAddressesSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAddress. */
    public UnaryCallSettings.Builder<DeleteAddressHttpRequest, Operation> deleteAddressSettings() {
      return deleteAddressSettings;
    }

    /** Returns the builder for the settings used for calls to getAddress. */
    public UnaryCallSettings.Builder<GetAddressHttpRequest, Address> getAddressSettings() {
      return getAddressSettings;
    }

    /** Returns the builder for the settings used for calls to insertAddress. */
    public UnaryCallSettings.Builder<InsertAddressHttpRequest, Operation> insertAddressSettings() {
      return insertAddressSettings;
    }

    /** Returns the builder for the settings used for calls to listAddresses. */
    public PagedCallSettings.Builder<
            ListAddressesHttpRequest, AddressList, ListAddressesPagedResponse>
        listAddressesSettings() {
      return listAddressesSettings;
    }

    @Override
    public AddressStubSettings build() throws IOException {
      return new AddressStubSettings(this);
    }
  }
}
