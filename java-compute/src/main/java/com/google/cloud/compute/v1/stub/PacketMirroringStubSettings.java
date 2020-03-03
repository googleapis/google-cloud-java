/*
 * Copyright 2020 Google LLC
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

import static com.google.cloud.compute.v1.PacketMirroringClient.AggregatedListPacketMirroringsPagedResponse;
import static com.google.cloud.compute.v1.PacketMirroringClient.ListPacketMirroringsPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListPacketMirroringsHttpRequest;
import com.google.cloud.compute.v1.DeletePacketMirroringHttpRequest;
import com.google.cloud.compute.v1.GetPacketMirroringHttpRequest;
import com.google.cloud.compute.v1.InsertPacketMirroringHttpRequest;
import com.google.cloud.compute.v1.ListPacketMirroringsHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PacketMirroring;
import com.google.cloud.compute.v1.PacketMirroringAggregatedList;
import com.google.cloud.compute.v1.PacketMirroringList;
import com.google.cloud.compute.v1.PacketMirroringsScopedList;
import com.google.cloud.compute.v1.PatchPacketMirroringHttpRequest;
import com.google.cloud.compute.v1.TestIamPermissionsPacketMirroringHttpRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
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
 * Settings class to configure an instance of {@link PacketMirroringStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (https://compute.googleapis.com/compute/v1/projects/) and
 *       default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of deletePacketMirroring to 30 seconds:
 *
 * <pre>
 * <code>
 * PacketMirroringStubSettings.Builder packetMirroringSettingsBuilder =
 *     PacketMirroringStubSettings.newBuilder();
 * packetMirroringSettingsBuilder.deletePacketMirroringSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * PacketMirroringStubSettings packetMirroringSettings = packetMirroringSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class PacketMirroringStubSettings extends StubSettings<PacketMirroringStubSettings> {
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
          AggregatedListPacketMirroringsHttpRequest,
          PacketMirroringAggregatedList,
          AggregatedListPacketMirroringsPagedResponse>
      aggregatedListPacketMirroringsSettings;
  private final UnaryCallSettings<DeletePacketMirroringHttpRequest, Operation>
      deletePacketMirroringSettings;
  private final UnaryCallSettings<GetPacketMirroringHttpRequest, PacketMirroring>
      getPacketMirroringSettings;
  private final UnaryCallSettings<InsertPacketMirroringHttpRequest, Operation>
      insertPacketMirroringSettings;
  private final PagedCallSettings<
          ListPacketMirroringsHttpRequest, PacketMirroringList, ListPacketMirroringsPagedResponse>
      listPacketMirroringsSettings;
  private final UnaryCallSettings<PatchPacketMirroringHttpRequest, Operation>
      patchPacketMirroringSettings;
  private final UnaryCallSettings<
          TestIamPermissionsPacketMirroringHttpRequest, TestPermissionsResponse>
      testIamPermissionsPacketMirroringSettings;

  /** Returns the object with the settings used for calls to aggregatedListPacketMirrorings. */
  public PagedCallSettings<
          AggregatedListPacketMirroringsHttpRequest,
          PacketMirroringAggregatedList,
          AggregatedListPacketMirroringsPagedResponse>
      aggregatedListPacketMirroringsSettings() {
    return aggregatedListPacketMirroringsSettings;
  }

  /** Returns the object with the settings used for calls to deletePacketMirroring. */
  public UnaryCallSettings<DeletePacketMirroringHttpRequest, Operation>
      deletePacketMirroringSettings() {
    return deletePacketMirroringSettings;
  }

  /** Returns the object with the settings used for calls to getPacketMirroring. */
  public UnaryCallSettings<GetPacketMirroringHttpRequest, PacketMirroring>
      getPacketMirroringSettings() {
    return getPacketMirroringSettings;
  }

  /** Returns the object with the settings used for calls to insertPacketMirroring. */
  public UnaryCallSettings<InsertPacketMirroringHttpRequest, Operation>
      insertPacketMirroringSettings() {
    return insertPacketMirroringSettings;
  }

  /** Returns the object with the settings used for calls to listPacketMirrorings. */
  public PagedCallSettings<
          ListPacketMirroringsHttpRequest, PacketMirroringList, ListPacketMirroringsPagedResponse>
      listPacketMirroringsSettings() {
    return listPacketMirroringsSettings;
  }

  /** Returns the object with the settings used for calls to patchPacketMirroring. */
  public UnaryCallSettings<PatchPacketMirroringHttpRequest, Operation>
      patchPacketMirroringSettings() {
    return patchPacketMirroringSettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissionsPacketMirroring. */
  public UnaryCallSettings<TestIamPermissionsPacketMirroringHttpRequest, TestPermissionsResponse>
      testIamPermissionsPacketMirroringSettings() {
    return testIamPermissionsPacketMirroringSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public PacketMirroringStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonPacketMirroringStub.create(this);
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
    return "https://compute.googleapis.com/compute/v1/projects/";
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
            "gapic", GaxProperties.getLibraryVersion(PacketMirroringStubSettings.class))
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

  protected PacketMirroringStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    aggregatedListPacketMirroringsSettings =
        settingsBuilder.aggregatedListPacketMirroringsSettings().build();
    deletePacketMirroringSettings = settingsBuilder.deletePacketMirroringSettings().build();
    getPacketMirroringSettings = settingsBuilder.getPacketMirroringSettings().build();
    insertPacketMirroringSettings = settingsBuilder.insertPacketMirroringSettings().build();
    listPacketMirroringsSettings = settingsBuilder.listPacketMirroringsSettings().build();
    patchPacketMirroringSettings = settingsBuilder.patchPacketMirroringSettings().build();
    testIamPermissionsPacketMirroringSettings =
        settingsBuilder.testIamPermissionsPacketMirroringSettings().build();
  }

  private static final PagedListDescriptor<
          AggregatedListPacketMirroringsHttpRequest,
          PacketMirroringAggregatedList,
          PacketMirroringsScopedList>
      AGGREGATED_LIST_PACKET_MIRRORINGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregatedListPacketMirroringsHttpRequest,
              PacketMirroringAggregatedList,
              PacketMirroringsScopedList>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregatedListPacketMirroringsHttpRequest injectToken(
                AggregatedListPacketMirroringsHttpRequest payload, String token) {
              return AggregatedListPacketMirroringsHttpRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public AggregatedListPacketMirroringsHttpRequest injectPageSize(
                AggregatedListPacketMirroringsHttpRequest payload, int pageSize) {
              return AggregatedListPacketMirroringsHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(AggregatedListPacketMirroringsHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(PacketMirroringAggregatedList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<PacketMirroringsScopedList> extractResources(
                PacketMirroringAggregatedList payload) {
              return payload.getItemsMap() != null
                  ? payload.getItemsMap().values()
                  : ImmutableList.<PacketMirroringsScopedList>of();
            }
          };

  private static final PagedListDescriptor<
          ListPacketMirroringsHttpRequest, PacketMirroringList, PacketMirroring>
      LIST_PACKET_MIRRORINGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListPacketMirroringsHttpRequest, PacketMirroringList, PacketMirroring>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPacketMirroringsHttpRequest injectToken(
                ListPacketMirroringsHttpRequest payload, String token) {
              return ListPacketMirroringsHttpRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListPacketMirroringsHttpRequest injectPageSize(
                ListPacketMirroringsHttpRequest payload, int pageSize) {
              return ListPacketMirroringsHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListPacketMirroringsHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(PacketMirroringList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<PacketMirroring> extractResources(PacketMirroringList payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<PacketMirroring>of();
            }
          };

  private static final PagedListResponseFactory<
          AggregatedListPacketMirroringsHttpRequest,
          PacketMirroringAggregatedList,
          AggregatedListPacketMirroringsPagedResponse>
      AGGREGATED_LIST_PACKET_MIRRORINGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregatedListPacketMirroringsHttpRequest,
              PacketMirroringAggregatedList,
              AggregatedListPacketMirroringsPagedResponse>() {
            @Override
            public ApiFuture<AggregatedListPacketMirroringsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        AggregatedListPacketMirroringsHttpRequest, PacketMirroringAggregatedList>
                    callable,
                AggregatedListPacketMirroringsHttpRequest request,
                ApiCallContext context,
                ApiFuture<PacketMirroringAggregatedList> futureResponse) {
              PageContext<
                      AggregatedListPacketMirroringsHttpRequest,
                      PacketMirroringAggregatedList,
                      PacketMirroringsScopedList>
                  pageContext =
                      PageContext.create(
                          callable,
                          AGGREGATED_LIST_PACKET_MIRRORINGS_PAGE_STR_DESC,
                          request,
                          context);
              return AggregatedListPacketMirroringsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListPacketMirroringsHttpRequest, PacketMirroringList, ListPacketMirroringsPagedResponse>
      LIST_PACKET_MIRRORINGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPacketMirroringsHttpRequest,
              PacketMirroringList,
              ListPacketMirroringsPagedResponse>() {
            @Override
            public ApiFuture<ListPacketMirroringsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPacketMirroringsHttpRequest, PacketMirroringList> callable,
                ListPacketMirroringsHttpRequest request,
                ApiCallContext context,
                ApiFuture<PacketMirroringList> futureResponse) {
              PageContext<ListPacketMirroringsHttpRequest, PacketMirroringList, PacketMirroring>
                  pageContext =
                      PageContext.create(
                          callable, LIST_PACKET_MIRRORINGS_PAGE_STR_DESC, request, context);
              return ListPacketMirroringsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for PacketMirroringStubSettings. */
  public static class Builder extends StubSettings.Builder<PacketMirroringStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final PagedCallSettings.Builder<
            AggregatedListPacketMirroringsHttpRequest,
            PacketMirroringAggregatedList,
            AggregatedListPacketMirroringsPagedResponse>
        aggregatedListPacketMirroringsSettings;
    private final UnaryCallSettings.Builder<DeletePacketMirroringHttpRequest, Operation>
        deletePacketMirroringSettings;
    private final UnaryCallSettings.Builder<GetPacketMirroringHttpRequest, PacketMirroring>
        getPacketMirroringSettings;
    private final UnaryCallSettings.Builder<InsertPacketMirroringHttpRequest, Operation>
        insertPacketMirroringSettings;
    private final PagedCallSettings.Builder<
            ListPacketMirroringsHttpRequest, PacketMirroringList, ListPacketMirroringsPagedResponse>
        listPacketMirroringsSettings;
    private final UnaryCallSettings.Builder<PatchPacketMirroringHttpRequest, Operation>
        patchPacketMirroringSettings;
    private final UnaryCallSettings.Builder<
            TestIamPermissionsPacketMirroringHttpRequest, TestPermissionsResponse>
        testIamPermissionsPacketMirroringSettings;

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

      aggregatedListPacketMirroringsSettings =
          PagedCallSettings.newBuilder(AGGREGATED_LIST_PACKET_MIRRORINGS_PAGE_STR_FACT);

      deletePacketMirroringSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getPacketMirroringSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      insertPacketMirroringSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listPacketMirroringsSettings =
          PagedCallSettings.newBuilder(LIST_PACKET_MIRRORINGS_PAGE_STR_FACT);

      patchPacketMirroringSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      testIamPermissionsPacketMirroringSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListPacketMirroringsSettings,
              deletePacketMirroringSettings,
              getPacketMirroringSettings,
              insertPacketMirroringSettings,
              listPacketMirroringsSettings,
              patchPacketMirroringSettings,
              testIamPermissionsPacketMirroringSettings);

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
          .aggregatedListPacketMirroringsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deletePacketMirroringSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getPacketMirroringSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .insertPacketMirroringSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listPacketMirroringsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .patchPacketMirroringSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .testIamPermissionsPacketMirroringSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(PacketMirroringStubSettings settings) {
      super(settings);

      aggregatedListPacketMirroringsSettings =
          settings.aggregatedListPacketMirroringsSettings.toBuilder();
      deletePacketMirroringSettings = settings.deletePacketMirroringSettings.toBuilder();
      getPacketMirroringSettings = settings.getPacketMirroringSettings.toBuilder();
      insertPacketMirroringSettings = settings.insertPacketMirroringSettings.toBuilder();
      listPacketMirroringsSettings = settings.listPacketMirroringsSettings.toBuilder();
      patchPacketMirroringSettings = settings.patchPacketMirroringSettings.toBuilder();
      testIamPermissionsPacketMirroringSettings =
          settings.testIamPermissionsPacketMirroringSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListPacketMirroringsSettings,
              deletePacketMirroringSettings,
              getPacketMirroringSettings,
              insertPacketMirroringSettings,
              listPacketMirroringsSettings,
              patchPacketMirroringSettings,
              testIamPermissionsPacketMirroringSettings);
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

    /** Returns the builder for the settings used for calls to aggregatedListPacketMirrorings. */
    public PagedCallSettings.Builder<
            AggregatedListPacketMirroringsHttpRequest,
            PacketMirroringAggregatedList,
            AggregatedListPacketMirroringsPagedResponse>
        aggregatedListPacketMirroringsSettings() {
      return aggregatedListPacketMirroringsSettings;
    }

    /** Returns the builder for the settings used for calls to deletePacketMirroring. */
    public UnaryCallSettings.Builder<DeletePacketMirroringHttpRequest, Operation>
        deletePacketMirroringSettings() {
      return deletePacketMirroringSettings;
    }

    /** Returns the builder for the settings used for calls to getPacketMirroring. */
    public UnaryCallSettings.Builder<GetPacketMirroringHttpRequest, PacketMirroring>
        getPacketMirroringSettings() {
      return getPacketMirroringSettings;
    }

    /** Returns the builder for the settings used for calls to insertPacketMirroring. */
    public UnaryCallSettings.Builder<InsertPacketMirroringHttpRequest, Operation>
        insertPacketMirroringSettings() {
      return insertPacketMirroringSettings;
    }

    /** Returns the builder for the settings used for calls to listPacketMirrorings. */
    public PagedCallSettings.Builder<
            ListPacketMirroringsHttpRequest, PacketMirroringList, ListPacketMirroringsPagedResponse>
        listPacketMirroringsSettings() {
      return listPacketMirroringsSettings;
    }

    /** Returns the builder for the settings used for calls to patchPacketMirroring. */
    public UnaryCallSettings.Builder<PatchPacketMirroringHttpRequest, Operation>
        patchPacketMirroringSettings() {
      return patchPacketMirroringSettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissionsPacketMirroring. */
    public UnaryCallSettings.Builder<
            TestIamPermissionsPacketMirroringHttpRequest, TestPermissionsResponse>
        testIamPermissionsPacketMirroringSettings() {
      return testIamPermissionsPacketMirroringSettings;
    }

    @Override
    public PacketMirroringStubSettings build() throws IOException {
      return new PacketMirroringStubSettings(this);
    }
  }
}
