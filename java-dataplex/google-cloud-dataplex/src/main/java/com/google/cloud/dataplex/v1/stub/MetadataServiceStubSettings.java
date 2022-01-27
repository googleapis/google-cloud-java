/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.dataplex.v1.stub;

import static com.google.cloud.dataplex.v1.MetadataServiceClient.ListEntitiesPagedResponse;
import static com.google.cloud.dataplex.v1.MetadataServiceClient.ListPartitionsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
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
import com.google.cloud.dataplex.v1.Entity;
import com.google.cloud.dataplex.v1.GetEntityRequest;
import com.google.cloud.dataplex.v1.GetPartitionRequest;
import com.google.cloud.dataplex.v1.ListEntitiesRequest;
import com.google.cloud.dataplex.v1.ListEntitiesResponse;
import com.google.cloud.dataplex.v1.ListPartitionsRequest;
import com.google.cloud.dataplex.v1.ListPartitionsResponse;
import com.google.cloud.dataplex.v1.Partition;
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
 * Settings class to configure an instance of {@link MetadataServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dataplex.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getEntity to 30 seconds:
 *
 * <pre>{@code
 * MetadataServiceStubSettings.Builder metadataServiceSettingsBuilder =
 *     MetadataServiceStubSettings.newBuilder();
 * metadataServiceSettingsBuilder
 *     .getEntitySettings()
 *     .setRetrySettings(
 *         metadataServiceSettingsBuilder
 *             .getEntitySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * MetadataServiceStubSettings metadataServiceSettings = metadataServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class MetadataServiceStubSettings extends StubSettings<MetadataServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<GetEntityRequest, Entity> getEntitySettings;
  private final PagedCallSettings<
          ListEntitiesRequest, ListEntitiesResponse, ListEntitiesPagedResponse>
      listEntitiesSettings;
  private final UnaryCallSettings<GetPartitionRequest, Partition> getPartitionSettings;
  private final PagedCallSettings<
          ListPartitionsRequest, ListPartitionsResponse, ListPartitionsPagedResponse>
      listPartitionsSettings;

  private static final PagedListDescriptor<ListEntitiesRequest, ListEntitiesResponse, Entity>
      LIST_ENTITIES_PAGE_STR_DESC =
          new PagedListDescriptor<ListEntitiesRequest, ListEntitiesResponse, Entity>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEntitiesRequest injectToken(ListEntitiesRequest payload, String token) {
              return ListEntitiesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListEntitiesRequest injectPageSize(ListEntitiesRequest payload, int pageSize) {
              return ListEntitiesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListEntitiesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEntitiesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Entity> extractResources(ListEntitiesResponse payload) {
              return payload.getEntitiesList() == null
                  ? ImmutableList.<Entity>of()
                  : payload.getEntitiesList();
            }
          };

  private static final PagedListDescriptor<ListPartitionsRequest, ListPartitionsResponse, Partition>
      LIST_PARTITIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListPartitionsRequest, ListPartitionsResponse, Partition>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPartitionsRequest injectToken(ListPartitionsRequest payload, String token) {
              return ListPartitionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPartitionsRequest injectPageSize(
                ListPartitionsRequest payload, int pageSize) {
              return ListPartitionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListPartitionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPartitionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Partition> extractResources(ListPartitionsResponse payload) {
              return payload.getPartitionsList() == null
                  ? ImmutableList.<Partition>of()
                  : payload.getPartitionsList();
            }
          };

  private static final PagedListResponseFactory<
          ListEntitiesRequest, ListEntitiesResponse, ListEntitiesPagedResponse>
      LIST_ENTITIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEntitiesRequest, ListEntitiesResponse, ListEntitiesPagedResponse>() {
            @Override
            public ApiFuture<ListEntitiesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListEntitiesRequest, ListEntitiesResponse> callable,
                ListEntitiesRequest request,
                ApiCallContext context,
                ApiFuture<ListEntitiesResponse> futureResponse) {
              PageContext<ListEntitiesRequest, ListEntitiesResponse, Entity> pageContext =
                  PageContext.create(callable, LIST_ENTITIES_PAGE_STR_DESC, request, context);
              return ListEntitiesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListPartitionsRequest, ListPartitionsResponse, ListPartitionsPagedResponse>
      LIST_PARTITIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPartitionsRequest, ListPartitionsResponse, ListPartitionsPagedResponse>() {
            @Override
            public ApiFuture<ListPartitionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPartitionsRequest, ListPartitionsResponse> callable,
                ListPartitionsRequest request,
                ApiCallContext context,
                ApiFuture<ListPartitionsResponse> futureResponse) {
              PageContext<ListPartitionsRequest, ListPartitionsResponse, Partition> pageContext =
                  PageContext.create(callable, LIST_PARTITIONS_PAGE_STR_DESC, request, context);
              return ListPartitionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getEntity. */
  public UnaryCallSettings<GetEntityRequest, Entity> getEntitySettings() {
    return getEntitySettings;
  }

  /** Returns the object with the settings used for calls to listEntities. */
  public PagedCallSettings<ListEntitiesRequest, ListEntitiesResponse, ListEntitiesPagedResponse>
      listEntitiesSettings() {
    return listEntitiesSettings;
  }

  /** Returns the object with the settings used for calls to getPartition. */
  public UnaryCallSettings<GetPartitionRequest, Partition> getPartitionSettings() {
    return getPartitionSettings;
  }

  /** Returns the object with the settings used for calls to listPartitions. */
  public PagedCallSettings<
          ListPartitionsRequest, ListPartitionsResponse, ListPartitionsPagedResponse>
      listPartitionsSettings() {
    return listPartitionsSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public MetadataServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcMetadataServiceStub.create(this);
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
    return "dataplex.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "dataplex.mtls.googleapis.com:443";
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
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(MetadataServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
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

  protected MetadataServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getEntitySettings = settingsBuilder.getEntitySettings().build();
    listEntitiesSettings = settingsBuilder.listEntitiesSettings().build();
    getPartitionSettings = settingsBuilder.getPartitionSettings().build();
    listPartitionsSettings = settingsBuilder.listPartitionsSettings().build();
  }

  /** Builder for MetadataServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<MetadataServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetEntityRequest, Entity> getEntitySettings;
    private final PagedCallSettings.Builder<
            ListEntitiesRequest, ListEntitiesResponse, ListEntitiesPagedResponse>
        listEntitiesSettings;
    private final UnaryCallSettings.Builder<GetPartitionRequest, Partition> getPartitionSettings;
    private final PagedCallSettings.Builder<
            ListPartitionsRequest, ListPartitionsResponse, ListPartitionsPagedResponse>
        listPartitionsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_2_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "retry_policy_3_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(10000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_2_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(10000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_3_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      getEntitySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listEntitiesSettings = PagedCallSettings.newBuilder(LIST_ENTITIES_PAGE_STR_FACT);
      getPartitionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listPartitionsSettings = PagedCallSettings.newBuilder(LIST_PARTITIONS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getEntitySettings,
              listEntitiesSettings,
              getPartitionSettings,
              listPartitionsSettings);
      initDefaults(this);
    }

    protected Builder(MetadataServiceStubSettings settings) {
      super(settings);

      getEntitySettings = settings.getEntitySettings.toBuilder();
      listEntitiesSettings = settings.listEntitiesSettings.toBuilder();
      getPartitionSettings = settings.getPartitionSettings.toBuilder();
      listPartitionsSettings = settings.listPartitionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getEntitySettings,
              listEntitiesSettings,
              getPartitionSettings,
              listPartitionsSettings);
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
          .getEntitySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .listEntitiesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .getPartitionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .listPartitionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

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

    /** Returns the builder for the settings used for calls to getEntity. */
    public UnaryCallSettings.Builder<GetEntityRequest, Entity> getEntitySettings() {
      return getEntitySettings;
    }

    /** Returns the builder for the settings used for calls to listEntities. */
    public PagedCallSettings.Builder<
            ListEntitiesRequest, ListEntitiesResponse, ListEntitiesPagedResponse>
        listEntitiesSettings() {
      return listEntitiesSettings;
    }

    /** Returns the builder for the settings used for calls to getPartition. */
    public UnaryCallSettings.Builder<GetPartitionRequest, Partition> getPartitionSettings() {
      return getPartitionSettings;
    }

    /** Returns the builder for the settings used for calls to listPartitions. */
    public PagedCallSettings.Builder<
            ListPartitionsRequest, ListPartitionsResponse, ListPartitionsPagedResponse>
        listPartitionsSettings() {
      return listPartitionsSettings;
    }

    @Override
    public MetadataServiceStubSettings build() throws IOException {
      return new MetadataServiceStubSettings(this);
    }
  }
}
