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

package com.google.cloud.aiplatform.v1beta1.stub;

import static com.google.cloud.aiplatform.v1beta1.ExtensionRegistryServiceClient.ListExtensionsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ExtensionRegistryServiceClient.ListLocationsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.DeleteExtensionRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.Extension;
import com.google.cloud.aiplatform.v1beta1.GetExtensionRequest;
import com.google.cloud.aiplatform.v1beta1.ImportExtensionOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.ImportExtensionRequest;
import com.google.cloud.aiplatform.v1beta1.ListExtensionsRequest;
import com.google.cloud.aiplatform.v1beta1.ListExtensionsResponse;
import com.google.cloud.aiplatform.v1beta1.UpdateExtensionRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ExtensionRegistryServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (aiplatform.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getExtension to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ExtensionRegistryServiceStubSettings.Builder extensionRegistryServiceSettingsBuilder =
 *     ExtensionRegistryServiceStubSettings.newBuilder();
 * extensionRegistryServiceSettingsBuilder
 *     .getExtensionSettings()
 *     .setRetrySettings(
 *         extensionRegistryServiceSettingsBuilder
 *             .getExtensionSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ExtensionRegistryServiceStubSettings extensionRegistryServiceSettings =
 *     extensionRegistryServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ExtensionRegistryServiceStubSettings
    extends StubSettings<ExtensionRegistryServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<ImportExtensionRequest, Operation> importExtensionSettings;
  private final OperationCallSettings<
          ImportExtensionRequest, Extension, ImportExtensionOperationMetadata>
      importExtensionOperationSettings;
  private final UnaryCallSettings<GetExtensionRequest, Extension> getExtensionSettings;
  private final PagedCallSettings<
          ListExtensionsRequest, ListExtensionsResponse, ListExtensionsPagedResponse>
      listExtensionsSettings;
  private final UnaryCallSettings<UpdateExtensionRequest, Extension> updateExtensionSettings;
  private final UnaryCallSettings<DeleteExtensionRequest, Operation> deleteExtensionSettings;
  private final OperationCallSettings<DeleteExtensionRequest, Empty, DeleteOperationMetadata>
      deleteExtensionOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<ListExtensionsRequest, ListExtensionsResponse, Extension>
      LIST_EXTENSIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListExtensionsRequest, ListExtensionsResponse, Extension>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListExtensionsRequest injectToken(ListExtensionsRequest payload, String token) {
              return ListExtensionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListExtensionsRequest injectPageSize(
                ListExtensionsRequest payload, int pageSize) {
              return ListExtensionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListExtensionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListExtensionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Extension> extractResources(ListExtensionsResponse payload) {
              return payload.getExtensionsList() == null
                  ? ImmutableList.<Extension>of()
                  : payload.getExtensionsList();
            }
          };

  private static final PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>
      LIST_LOCATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLocationsRequest injectToken(ListLocationsRequest payload, String token) {
              return ListLocationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLocationsRequest injectPageSize(ListLocationsRequest payload, int pageSize) {
              return ListLocationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLocationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLocationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Location> extractResources(ListLocationsResponse payload) {
              return payload.getLocationsList() == null
                  ? ImmutableList.<Location>of()
                  : payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListExtensionsRequest, ListExtensionsResponse, ListExtensionsPagedResponse>
      LIST_EXTENSIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListExtensionsRequest, ListExtensionsResponse, ListExtensionsPagedResponse>() {
            @Override
            public ApiFuture<ListExtensionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListExtensionsRequest, ListExtensionsResponse> callable,
                ListExtensionsRequest request,
                ApiCallContext context,
                ApiFuture<ListExtensionsResponse> futureResponse) {
              PageContext<ListExtensionsRequest, ListExtensionsResponse, Extension> pageContext =
                  PageContext.create(callable, LIST_EXTENSIONS_PAGE_STR_DESC, request, context);
              return ListExtensionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      LIST_LOCATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>() {
            @Override
            public ApiFuture<ListLocationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLocationsRequest, ListLocationsResponse> callable,
                ListLocationsRequest request,
                ApiCallContext context,
                ApiFuture<ListLocationsResponse> futureResponse) {
              PageContext<ListLocationsRequest, ListLocationsResponse, Location> pageContext =
                  PageContext.create(callable, LIST_LOCATIONS_PAGE_STR_DESC, request, context);
              return ListLocationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to importExtension. */
  public UnaryCallSettings<ImportExtensionRequest, Operation> importExtensionSettings() {
    return importExtensionSettings;
  }

  /** Returns the object with the settings used for calls to importExtension. */
  public OperationCallSettings<ImportExtensionRequest, Extension, ImportExtensionOperationMetadata>
      importExtensionOperationSettings() {
    return importExtensionOperationSettings;
  }

  /** Returns the object with the settings used for calls to getExtension. */
  public UnaryCallSettings<GetExtensionRequest, Extension> getExtensionSettings() {
    return getExtensionSettings;
  }

  /** Returns the object with the settings used for calls to listExtensions. */
  public PagedCallSettings<
          ListExtensionsRequest, ListExtensionsResponse, ListExtensionsPagedResponse>
      listExtensionsSettings() {
    return listExtensionsSettings;
  }

  /** Returns the object with the settings used for calls to updateExtension. */
  public UnaryCallSettings<UpdateExtensionRequest, Extension> updateExtensionSettings() {
    return updateExtensionSettings;
  }

  /** Returns the object with the settings used for calls to deleteExtension. */
  public UnaryCallSettings<DeleteExtensionRequest, Operation> deleteExtensionSettings() {
    return deleteExtensionSettings;
  }

  /** Returns the object with the settings used for calls to deleteExtension. */
  public OperationCallSettings<DeleteExtensionRequest, Empty, DeleteOperationMetadata>
      deleteExtensionOperationSettings() {
    return deleteExtensionOperationSettings;
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return listLocationsSettings;
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return getLocationSettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  public ExtensionRegistryServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcExtensionRegistryServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "aiplatform";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "aiplatform.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "aiplatform.mtls.googleapis.com:443";
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

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ExtensionRegistryServiceStubSettings.class))
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

  protected ExtensionRegistryServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    importExtensionSettings = settingsBuilder.importExtensionSettings().build();
    importExtensionOperationSettings = settingsBuilder.importExtensionOperationSettings().build();
    getExtensionSettings = settingsBuilder.getExtensionSettings().build();
    listExtensionsSettings = settingsBuilder.listExtensionsSettings().build();
    updateExtensionSettings = settingsBuilder.updateExtensionSettings().build();
    deleteExtensionSettings = settingsBuilder.deleteExtensionSettings().build();
    deleteExtensionOperationSettings = settingsBuilder.deleteExtensionOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for ExtensionRegistryServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<ExtensionRegistryServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<ImportExtensionRequest, Operation>
        importExtensionSettings;
    private final OperationCallSettings.Builder<
            ImportExtensionRequest, Extension, ImportExtensionOperationMetadata>
        importExtensionOperationSettings;
    private final UnaryCallSettings.Builder<GetExtensionRequest, Extension> getExtensionSettings;
    private final PagedCallSettings.Builder<
            ListExtensionsRequest, ListExtensionsResponse, ListExtensionsPagedResponse>
        listExtensionsSettings;
    private final UnaryCallSettings.Builder<UpdateExtensionRequest, Extension>
        updateExtensionSettings;
    private final UnaryCallSettings.Builder<DeleteExtensionRequest, Operation>
        deleteExtensionSettings;
    private final OperationCallSettings.Builder<
            DeleteExtensionRequest, Empty, DeleteOperationMetadata>
        deleteExtensionOperationSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
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

      importExtensionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importExtensionOperationSettings = OperationCallSettings.newBuilder();
      getExtensionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listExtensionsSettings = PagedCallSettings.newBuilder(LIST_EXTENSIONS_PAGE_STR_FACT);
      updateExtensionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteExtensionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteExtensionOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              importExtensionSettings,
              getExtensionSettings,
              listExtensionsSettings,
              updateExtensionSettings,
              deleteExtensionSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(ExtensionRegistryServiceStubSettings settings) {
      super(settings);

      importExtensionSettings = settings.importExtensionSettings.toBuilder();
      importExtensionOperationSettings = settings.importExtensionOperationSettings.toBuilder();
      getExtensionSettings = settings.getExtensionSettings.toBuilder();
      listExtensionsSettings = settings.listExtensionsSettings.toBuilder();
      updateExtensionSettings = settings.updateExtensionSettings.toBuilder();
      deleteExtensionSettings = settings.deleteExtensionSettings.toBuilder();
      deleteExtensionOperationSettings = settings.deleteExtensionOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              importExtensionSettings,
              getExtensionSettings,
              listExtensionsSettings,
              updateExtensionSettings,
              deleteExtensionSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
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
          .importExtensionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getExtensionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listExtensionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateExtensionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteExtensionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .importExtensionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ImportExtensionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Extension.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  ImportExtensionOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteExtensionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteExtensionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(DeleteOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

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

    /** Returns the builder for the settings used for calls to importExtension. */
    public UnaryCallSettings.Builder<ImportExtensionRequest, Operation> importExtensionSettings() {
      return importExtensionSettings;
    }

    /** Returns the builder for the settings used for calls to importExtension. */
    public OperationCallSettings.Builder<
            ImportExtensionRequest, Extension, ImportExtensionOperationMetadata>
        importExtensionOperationSettings() {
      return importExtensionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getExtension. */
    public UnaryCallSettings.Builder<GetExtensionRequest, Extension> getExtensionSettings() {
      return getExtensionSettings;
    }

    /** Returns the builder for the settings used for calls to listExtensions. */
    public PagedCallSettings.Builder<
            ListExtensionsRequest, ListExtensionsResponse, ListExtensionsPagedResponse>
        listExtensionsSettings() {
      return listExtensionsSettings;
    }

    /** Returns the builder for the settings used for calls to updateExtension. */
    public UnaryCallSettings.Builder<UpdateExtensionRequest, Extension> updateExtensionSettings() {
      return updateExtensionSettings;
    }

    /** Returns the builder for the settings used for calls to deleteExtension. */
    public UnaryCallSettings.Builder<DeleteExtensionRequest, Operation> deleteExtensionSettings() {
      return deleteExtensionSettings;
    }

    /** Returns the builder for the settings used for calls to deleteExtension. */
    public OperationCallSettings.Builder<DeleteExtensionRequest, Empty, DeleteOperationMetadata>
        deleteExtensionOperationSettings() {
      return deleteExtensionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return listLocationsSettings;
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getLocationSettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public ExtensionRegistryServiceStubSettings build() throws IOException {
      return new ExtensionRegistryServiceStubSettings(this);
    }
  }
}
