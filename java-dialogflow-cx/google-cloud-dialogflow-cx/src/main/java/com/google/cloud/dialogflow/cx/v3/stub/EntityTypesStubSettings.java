/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.dialogflow.cx.v3.stub;

import static com.google.cloud.dialogflow.cx.v3.EntityTypesClient.ListEntityTypesPagedResponse;

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
import com.google.cloud.dialogflow.cx.v3.CreateEntityTypeRequest;
import com.google.cloud.dialogflow.cx.v3.DeleteEntityTypeRequest;
import com.google.cloud.dialogflow.cx.v3.EntityType;
import com.google.cloud.dialogflow.cx.v3.GetEntityTypeRequest;
import com.google.cloud.dialogflow.cx.v3.ListEntityTypesRequest;
import com.google.cloud.dialogflow.cx.v3.ListEntityTypesResponse;
import com.google.cloud.dialogflow.cx.v3.UpdateEntityTypeRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link EntityTypesStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dialogflow.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getEntityType to 30 seconds:
 *
 * <pre>{@code
 * EntityTypesStubSettings.Builder entityTypesSettingsBuilder =
 *     EntityTypesStubSettings.newBuilder();
 * entityTypesSettingsBuilder
 *     .getEntityTypeSettings()
 *     .setRetrySettings(
 *         entityTypesSettingsBuilder
 *             .getEntityTypeSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * EntityTypesStubSettings entityTypesSettings = entityTypesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class EntityTypesStubSettings extends StubSettings<EntityTypesStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/dialogflow")
          .build();

  private final PagedCallSettings<
          ListEntityTypesRequest, ListEntityTypesResponse, ListEntityTypesPagedResponse>
      listEntityTypesSettings;
  private final UnaryCallSettings<GetEntityTypeRequest, EntityType> getEntityTypeSettings;
  private final UnaryCallSettings<CreateEntityTypeRequest, EntityType> createEntityTypeSettings;
  private final UnaryCallSettings<UpdateEntityTypeRequest, EntityType> updateEntityTypeSettings;
  private final UnaryCallSettings<DeleteEntityTypeRequest, Empty> deleteEntityTypeSettings;

  private static final PagedListDescriptor<
          ListEntityTypesRequest, ListEntityTypesResponse, EntityType>
      LIST_ENTITY_TYPES_PAGE_STR_DESC =
          new PagedListDescriptor<ListEntityTypesRequest, ListEntityTypesResponse, EntityType>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEntityTypesRequest injectToken(
                ListEntityTypesRequest payload, String token) {
              return ListEntityTypesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListEntityTypesRequest injectPageSize(
                ListEntityTypesRequest payload, int pageSize) {
              return ListEntityTypesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListEntityTypesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEntityTypesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<EntityType> extractResources(ListEntityTypesResponse payload) {
              return payload.getEntityTypesList() == null
                  ? ImmutableList.<EntityType>of()
                  : payload.getEntityTypesList();
            }
          };

  private static final PagedListResponseFactory<
          ListEntityTypesRequest, ListEntityTypesResponse, ListEntityTypesPagedResponse>
      LIST_ENTITY_TYPES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEntityTypesRequest, ListEntityTypesResponse, ListEntityTypesPagedResponse>() {
            @Override
            public ApiFuture<ListEntityTypesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListEntityTypesRequest, ListEntityTypesResponse> callable,
                ListEntityTypesRequest request,
                ApiCallContext context,
                ApiFuture<ListEntityTypesResponse> futureResponse) {
              PageContext<ListEntityTypesRequest, ListEntityTypesResponse, EntityType> pageContext =
                  PageContext.create(callable, LIST_ENTITY_TYPES_PAGE_STR_DESC, request, context);
              return ListEntityTypesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listEntityTypes. */
  public PagedCallSettings<
          ListEntityTypesRequest, ListEntityTypesResponse, ListEntityTypesPagedResponse>
      listEntityTypesSettings() {
    return listEntityTypesSettings;
  }

  /** Returns the object with the settings used for calls to getEntityType. */
  public UnaryCallSettings<GetEntityTypeRequest, EntityType> getEntityTypeSettings() {
    return getEntityTypeSettings;
  }

  /** Returns the object with the settings used for calls to createEntityType. */
  public UnaryCallSettings<CreateEntityTypeRequest, EntityType> createEntityTypeSettings() {
    return createEntityTypeSettings;
  }

  /** Returns the object with the settings used for calls to updateEntityType. */
  public UnaryCallSettings<UpdateEntityTypeRequest, EntityType> updateEntityTypeSettings() {
    return updateEntityTypeSettings;
  }

  /** Returns the object with the settings used for calls to deleteEntityType. */
  public UnaryCallSettings<DeleteEntityTypeRequest, Empty> deleteEntityTypeSettings() {
    return deleteEntityTypeSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public EntityTypesStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcEntityTypesStub.create(this);
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
    return "dialogflow.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(EntityTypesStubSettings.class))
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

  protected EntityTypesStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listEntityTypesSettings = settingsBuilder.listEntityTypesSettings().build();
    getEntityTypeSettings = settingsBuilder.getEntityTypeSettings().build();
    createEntityTypeSettings = settingsBuilder.createEntityTypeSettings().build();
    updateEntityTypeSettings = settingsBuilder.updateEntityTypeSettings().build();
    deleteEntityTypeSettings = settingsBuilder.deleteEntityTypeSettings().build();
  }

  /** Builder for EntityTypesStubSettings. */
  public static class Builder extends StubSettings.Builder<EntityTypesStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListEntityTypesRequest, ListEntityTypesResponse, ListEntityTypesPagedResponse>
        listEntityTypesSettings;
    private final UnaryCallSettings.Builder<GetEntityTypeRequest, EntityType> getEntityTypeSettings;
    private final UnaryCallSettings.Builder<CreateEntityTypeRequest, EntityType>
        createEntityTypeSettings;
    private final UnaryCallSettings.Builder<UpdateEntityTypeRequest, EntityType>
        updateEntityTypeSettings;
    private final UnaryCallSettings.Builder<DeleteEntityTypeRequest, Empty>
        deleteEntityTypeSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
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
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listEntityTypesSettings = PagedCallSettings.newBuilder(LIST_ENTITY_TYPES_PAGE_STR_FACT);
      getEntityTypeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEntityTypeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateEntityTypeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteEntityTypeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listEntityTypesSettings,
              getEntityTypeSettings,
              createEntityTypeSettings,
              updateEntityTypeSettings,
              deleteEntityTypeSettings);
      initDefaults(this);
    }

    protected Builder(EntityTypesStubSettings settings) {
      super(settings);

      listEntityTypesSettings = settings.listEntityTypesSettings.toBuilder();
      getEntityTypeSettings = settings.getEntityTypeSettings.toBuilder();
      createEntityTypeSettings = settings.createEntityTypeSettings.toBuilder();
      updateEntityTypeSettings = settings.updateEntityTypeSettings.toBuilder();
      deleteEntityTypeSettings = settings.deleteEntityTypeSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listEntityTypesSettings,
              getEntityTypeSettings,
              createEntityTypeSettings,
              updateEntityTypeSettings,
              deleteEntityTypeSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .listEntityTypesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getEntityTypeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createEntityTypeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateEntityTypeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteEntityTypeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      return builder;
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
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

    /** Returns the builder for the settings used for calls to listEntityTypes. */
    public PagedCallSettings.Builder<
            ListEntityTypesRequest, ListEntityTypesResponse, ListEntityTypesPagedResponse>
        listEntityTypesSettings() {
      return listEntityTypesSettings;
    }

    /** Returns the builder for the settings used for calls to getEntityType. */
    public UnaryCallSettings.Builder<GetEntityTypeRequest, EntityType> getEntityTypeSettings() {
      return getEntityTypeSettings;
    }

    /** Returns the builder for the settings used for calls to createEntityType. */
    public UnaryCallSettings.Builder<CreateEntityTypeRequest, EntityType>
        createEntityTypeSettings() {
      return createEntityTypeSettings;
    }

    /** Returns the builder for the settings used for calls to updateEntityType. */
    public UnaryCallSettings.Builder<UpdateEntityTypeRequest, EntityType>
        updateEntityTypeSettings() {
      return updateEntityTypeSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEntityType. */
    public UnaryCallSettings.Builder<DeleteEntityTypeRequest, Empty> deleteEntityTypeSettings() {
      return deleteEntityTypeSettings;
    }

    @Override
    public EntityTypesStubSettings build() throws IOException {
      return new EntityTypesStubSettings(this);
    }
  }
}
