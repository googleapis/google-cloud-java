/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.managedidentities.v1.stub;

import static com.google.cloud.managedidentities.v1.ManagedIdentitiesServiceClient.ListDomainsPagedResponse;

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
import com.google.cloud.managedidentities.v1.AttachTrustRequest;
import com.google.cloud.managedidentities.v1.CreateMicrosoftAdDomainRequest;
import com.google.cloud.managedidentities.v1.DeleteDomainRequest;
import com.google.cloud.managedidentities.v1.DetachTrustRequest;
import com.google.cloud.managedidentities.v1.Domain;
import com.google.cloud.managedidentities.v1.GetDomainRequest;
import com.google.cloud.managedidentities.v1.ListDomainsRequest;
import com.google.cloud.managedidentities.v1.ListDomainsResponse;
import com.google.cloud.managedidentities.v1.OpMetadata;
import com.google.cloud.managedidentities.v1.ReconfigureTrustRequest;
import com.google.cloud.managedidentities.v1.ResetAdminPasswordRequest;
import com.google.cloud.managedidentities.v1.ResetAdminPasswordResponse;
import com.google.cloud.managedidentities.v1.UpdateDomainRequest;
import com.google.cloud.managedidentities.v1.ValidateTrustRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ManagedIdentitiesServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (managedidentities.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of resetAdminPassword to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ManagedIdentitiesServiceStubSettings.Builder managedIdentitiesServiceSettingsBuilder =
 *     ManagedIdentitiesServiceStubSettings.newBuilder();
 * managedIdentitiesServiceSettingsBuilder
 *     .resetAdminPasswordSettings()
 *     .setRetrySettings(
 *         managedIdentitiesServiceSettingsBuilder
 *             .resetAdminPasswordSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ManagedIdentitiesServiceStubSettings managedIdentitiesServiceSettings =
 *     managedIdentitiesServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ManagedIdentitiesServiceStubSettings
    extends StubSettings<ManagedIdentitiesServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateMicrosoftAdDomainRequest, Operation>
      createMicrosoftAdDomainSettings;
  private final OperationCallSettings<CreateMicrosoftAdDomainRequest, Domain, OpMetadata>
      createMicrosoftAdDomainOperationSettings;
  private final UnaryCallSettings<ResetAdminPasswordRequest, ResetAdminPasswordResponse>
      resetAdminPasswordSettings;
  private final PagedCallSettings<ListDomainsRequest, ListDomainsResponse, ListDomainsPagedResponse>
      listDomainsSettings;
  private final UnaryCallSettings<GetDomainRequest, Domain> getDomainSettings;
  private final UnaryCallSettings<UpdateDomainRequest, Operation> updateDomainSettings;
  private final OperationCallSettings<UpdateDomainRequest, Domain, OpMetadata>
      updateDomainOperationSettings;
  private final UnaryCallSettings<DeleteDomainRequest, Operation> deleteDomainSettings;
  private final OperationCallSettings<DeleteDomainRequest, Empty, OpMetadata>
      deleteDomainOperationSettings;
  private final UnaryCallSettings<AttachTrustRequest, Operation> attachTrustSettings;
  private final OperationCallSettings<AttachTrustRequest, Domain, OpMetadata>
      attachTrustOperationSettings;
  private final UnaryCallSettings<ReconfigureTrustRequest, Operation> reconfigureTrustSettings;
  private final OperationCallSettings<ReconfigureTrustRequest, Domain, OpMetadata>
      reconfigureTrustOperationSettings;
  private final UnaryCallSettings<DetachTrustRequest, Operation> detachTrustSettings;
  private final OperationCallSettings<DetachTrustRequest, Domain, OpMetadata>
      detachTrustOperationSettings;
  private final UnaryCallSettings<ValidateTrustRequest, Operation> validateTrustSettings;
  private final OperationCallSettings<ValidateTrustRequest, Domain, OpMetadata>
      validateTrustOperationSettings;

  private static final PagedListDescriptor<ListDomainsRequest, ListDomainsResponse, Domain>
      LIST_DOMAINS_PAGE_STR_DESC =
          new PagedListDescriptor<ListDomainsRequest, ListDomainsResponse, Domain>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDomainsRequest injectToken(ListDomainsRequest payload, String token) {
              return ListDomainsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDomainsRequest injectPageSize(ListDomainsRequest payload, int pageSize) {
              return ListDomainsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDomainsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDomainsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Domain> extractResources(ListDomainsResponse payload) {
              return payload.getDomainsList() == null
                  ? ImmutableList.<Domain>of()
                  : payload.getDomainsList();
            }
          };

  private static final PagedListResponseFactory<
          ListDomainsRequest, ListDomainsResponse, ListDomainsPagedResponse>
      LIST_DOMAINS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDomainsRequest, ListDomainsResponse, ListDomainsPagedResponse>() {
            @Override
            public ApiFuture<ListDomainsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDomainsRequest, ListDomainsResponse> callable,
                ListDomainsRequest request,
                ApiCallContext context,
                ApiFuture<ListDomainsResponse> futureResponse) {
              PageContext<ListDomainsRequest, ListDomainsResponse, Domain> pageContext =
                  PageContext.create(callable, LIST_DOMAINS_PAGE_STR_DESC, request, context);
              return ListDomainsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createMicrosoftAdDomain. */
  public UnaryCallSettings<CreateMicrosoftAdDomainRequest, Operation>
      createMicrosoftAdDomainSettings() {
    return createMicrosoftAdDomainSettings;
  }

  /** Returns the object with the settings used for calls to createMicrosoftAdDomain. */
  public OperationCallSettings<CreateMicrosoftAdDomainRequest, Domain, OpMetadata>
      createMicrosoftAdDomainOperationSettings() {
    return createMicrosoftAdDomainOperationSettings;
  }

  /** Returns the object with the settings used for calls to resetAdminPassword. */
  public UnaryCallSettings<ResetAdminPasswordRequest, ResetAdminPasswordResponse>
      resetAdminPasswordSettings() {
    return resetAdminPasswordSettings;
  }

  /** Returns the object with the settings used for calls to listDomains. */
  public PagedCallSettings<ListDomainsRequest, ListDomainsResponse, ListDomainsPagedResponse>
      listDomainsSettings() {
    return listDomainsSettings;
  }

  /** Returns the object with the settings used for calls to getDomain. */
  public UnaryCallSettings<GetDomainRequest, Domain> getDomainSettings() {
    return getDomainSettings;
  }

  /** Returns the object with the settings used for calls to updateDomain. */
  public UnaryCallSettings<UpdateDomainRequest, Operation> updateDomainSettings() {
    return updateDomainSettings;
  }

  /** Returns the object with the settings used for calls to updateDomain. */
  public OperationCallSettings<UpdateDomainRequest, Domain, OpMetadata>
      updateDomainOperationSettings() {
    return updateDomainOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteDomain. */
  public UnaryCallSettings<DeleteDomainRequest, Operation> deleteDomainSettings() {
    return deleteDomainSettings;
  }

  /** Returns the object with the settings used for calls to deleteDomain. */
  public OperationCallSettings<DeleteDomainRequest, Empty, OpMetadata>
      deleteDomainOperationSettings() {
    return deleteDomainOperationSettings;
  }

  /** Returns the object with the settings used for calls to attachTrust. */
  public UnaryCallSettings<AttachTrustRequest, Operation> attachTrustSettings() {
    return attachTrustSettings;
  }

  /** Returns the object with the settings used for calls to attachTrust. */
  public OperationCallSettings<AttachTrustRequest, Domain, OpMetadata>
      attachTrustOperationSettings() {
    return attachTrustOperationSettings;
  }

  /** Returns the object with the settings used for calls to reconfigureTrust. */
  public UnaryCallSettings<ReconfigureTrustRequest, Operation> reconfigureTrustSettings() {
    return reconfigureTrustSettings;
  }

  /** Returns the object with the settings used for calls to reconfigureTrust. */
  public OperationCallSettings<ReconfigureTrustRequest, Domain, OpMetadata>
      reconfigureTrustOperationSettings() {
    return reconfigureTrustOperationSettings;
  }

  /** Returns the object with the settings used for calls to detachTrust. */
  public UnaryCallSettings<DetachTrustRequest, Operation> detachTrustSettings() {
    return detachTrustSettings;
  }

  /** Returns the object with the settings used for calls to detachTrust. */
  public OperationCallSettings<DetachTrustRequest, Domain, OpMetadata>
      detachTrustOperationSettings() {
    return detachTrustOperationSettings;
  }

  /** Returns the object with the settings used for calls to validateTrust. */
  public UnaryCallSettings<ValidateTrustRequest, Operation> validateTrustSettings() {
    return validateTrustSettings;
  }

  /** Returns the object with the settings used for calls to validateTrust. */
  public OperationCallSettings<ValidateTrustRequest, Domain, OpMetadata>
      validateTrustOperationSettings() {
    return validateTrustOperationSettings;
  }

  public ManagedIdentitiesServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcManagedIdentitiesServiceStub.create(this);
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
    return "managedidentities.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "managedidentities.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(ManagedIdentitiesServiceStubSettings.class))
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

  protected ManagedIdentitiesServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createMicrosoftAdDomainSettings = settingsBuilder.createMicrosoftAdDomainSettings().build();
    createMicrosoftAdDomainOperationSettings =
        settingsBuilder.createMicrosoftAdDomainOperationSettings().build();
    resetAdminPasswordSettings = settingsBuilder.resetAdminPasswordSettings().build();
    listDomainsSettings = settingsBuilder.listDomainsSettings().build();
    getDomainSettings = settingsBuilder.getDomainSettings().build();
    updateDomainSettings = settingsBuilder.updateDomainSettings().build();
    updateDomainOperationSettings = settingsBuilder.updateDomainOperationSettings().build();
    deleteDomainSettings = settingsBuilder.deleteDomainSettings().build();
    deleteDomainOperationSettings = settingsBuilder.deleteDomainOperationSettings().build();
    attachTrustSettings = settingsBuilder.attachTrustSettings().build();
    attachTrustOperationSettings = settingsBuilder.attachTrustOperationSettings().build();
    reconfigureTrustSettings = settingsBuilder.reconfigureTrustSettings().build();
    reconfigureTrustOperationSettings = settingsBuilder.reconfigureTrustOperationSettings().build();
    detachTrustSettings = settingsBuilder.detachTrustSettings().build();
    detachTrustOperationSettings = settingsBuilder.detachTrustOperationSettings().build();
    validateTrustSettings = settingsBuilder.validateTrustSettings().build();
    validateTrustOperationSettings = settingsBuilder.validateTrustOperationSettings().build();
  }

  /** Builder for ManagedIdentitiesServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<ManagedIdentitiesServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateMicrosoftAdDomainRequest, Operation>
        createMicrosoftAdDomainSettings;
    private final OperationCallSettings.Builder<CreateMicrosoftAdDomainRequest, Domain, OpMetadata>
        createMicrosoftAdDomainOperationSettings;
    private final UnaryCallSettings.Builder<ResetAdminPasswordRequest, ResetAdminPasswordResponse>
        resetAdminPasswordSettings;
    private final PagedCallSettings.Builder<
            ListDomainsRequest, ListDomainsResponse, ListDomainsPagedResponse>
        listDomainsSettings;
    private final UnaryCallSettings.Builder<GetDomainRequest, Domain> getDomainSettings;
    private final UnaryCallSettings.Builder<UpdateDomainRequest, Operation> updateDomainSettings;
    private final OperationCallSettings.Builder<UpdateDomainRequest, Domain, OpMetadata>
        updateDomainOperationSettings;
    private final UnaryCallSettings.Builder<DeleteDomainRequest, Operation> deleteDomainSettings;
    private final OperationCallSettings.Builder<DeleteDomainRequest, Empty, OpMetadata>
        deleteDomainOperationSettings;
    private final UnaryCallSettings.Builder<AttachTrustRequest, Operation> attachTrustSettings;
    private final OperationCallSettings.Builder<AttachTrustRequest, Domain, OpMetadata>
        attachTrustOperationSettings;
    private final UnaryCallSettings.Builder<ReconfigureTrustRequest, Operation>
        reconfigureTrustSettings;
    private final OperationCallSettings.Builder<ReconfigureTrustRequest, Domain, OpMetadata>
        reconfigureTrustOperationSettings;
    private final UnaryCallSettings.Builder<DetachTrustRequest, Operation> detachTrustSettings;
    private final OperationCallSettings.Builder<DetachTrustRequest, Domain, OpMetadata>
        detachTrustOperationSettings;
    private final UnaryCallSettings.Builder<ValidateTrustRequest, Operation> validateTrustSettings;
    private final OperationCallSettings.Builder<ValidateTrustRequest, Domain, OpMetadata>
        validateTrustOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_0_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createMicrosoftAdDomainSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMicrosoftAdDomainOperationSettings = OperationCallSettings.newBuilder();
      resetAdminPasswordSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDomainsSettings = PagedCallSettings.newBuilder(LIST_DOMAINS_PAGE_STR_FACT);
      getDomainSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDomainSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDomainOperationSettings = OperationCallSettings.newBuilder();
      deleteDomainSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDomainOperationSettings = OperationCallSettings.newBuilder();
      attachTrustSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      attachTrustOperationSettings = OperationCallSettings.newBuilder();
      reconfigureTrustSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      reconfigureTrustOperationSettings = OperationCallSettings.newBuilder();
      detachTrustSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      detachTrustOperationSettings = OperationCallSettings.newBuilder();
      validateTrustSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      validateTrustOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createMicrosoftAdDomainSettings,
              resetAdminPasswordSettings,
              listDomainsSettings,
              getDomainSettings,
              updateDomainSettings,
              deleteDomainSettings,
              attachTrustSettings,
              reconfigureTrustSettings,
              detachTrustSettings,
              validateTrustSettings);
      initDefaults(this);
    }

    protected Builder(ManagedIdentitiesServiceStubSettings settings) {
      super(settings);

      createMicrosoftAdDomainSettings = settings.createMicrosoftAdDomainSettings.toBuilder();
      createMicrosoftAdDomainOperationSettings =
          settings.createMicrosoftAdDomainOperationSettings.toBuilder();
      resetAdminPasswordSettings = settings.resetAdminPasswordSettings.toBuilder();
      listDomainsSettings = settings.listDomainsSettings.toBuilder();
      getDomainSettings = settings.getDomainSettings.toBuilder();
      updateDomainSettings = settings.updateDomainSettings.toBuilder();
      updateDomainOperationSettings = settings.updateDomainOperationSettings.toBuilder();
      deleteDomainSettings = settings.deleteDomainSettings.toBuilder();
      deleteDomainOperationSettings = settings.deleteDomainOperationSettings.toBuilder();
      attachTrustSettings = settings.attachTrustSettings.toBuilder();
      attachTrustOperationSettings = settings.attachTrustOperationSettings.toBuilder();
      reconfigureTrustSettings = settings.reconfigureTrustSettings.toBuilder();
      reconfigureTrustOperationSettings = settings.reconfigureTrustOperationSettings.toBuilder();
      detachTrustSettings = settings.detachTrustSettings.toBuilder();
      detachTrustOperationSettings = settings.detachTrustOperationSettings.toBuilder();
      validateTrustSettings = settings.validateTrustSettings.toBuilder();
      validateTrustOperationSettings = settings.validateTrustOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createMicrosoftAdDomainSettings,
              resetAdminPasswordSettings,
              listDomainsSettings,
              getDomainSettings,
              updateDomainSettings,
              deleteDomainSettings,
              attachTrustSettings,
              reconfigureTrustSettings,
              detachTrustSettings,
              validateTrustSettings);
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
          .createMicrosoftAdDomainSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .resetAdminPasswordSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listDomainsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getDomainSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateDomainSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteDomainSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .attachTrustSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .reconfigureTrustSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .detachTrustSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .validateTrustSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createMicrosoftAdDomainOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateMicrosoftAdDomainRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Domain.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OpMetadata.class))
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
          .updateDomainOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateDomainRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Domain.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OpMetadata.class))
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
          .deleteDomainOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteDomainRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OpMetadata.class))
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
          .attachTrustOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<AttachTrustRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Domain.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OpMetadata.class))
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
          .reconfigureTrustOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ReconfigureTrustRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Domain.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OpMetadata.class))
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
          .detachTrustOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DetachTrustRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Domain.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OpMetadata.class))
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
          .validateTrustOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ValidateTrustRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Domain.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OpMetadata.class))
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

    /** Returns the builder for the settings used for calls to createMicrosoftAdDomain. */
    public UnaryCallSettings.Builder<CreateMicrosoftAdDomainRequest, Operation>
        createMicrosoftAdDomainSettings() {
      return createMicrosoftAdDomainSettings;
    }

    /** Returns the builder for the settings used for calls to createMicrosoftAdDomain. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateMicrosoftAdDomainRequest, Domain, OpMetadata>
        createMicrosoftAdDomainOperationSettings() {
      return createMicrosoftAdDomainOperationSettings;
    }

    /** Returns the builder for the settings used for calls to resetAdminPassword. */
    public UnaryCallSettings.Builder<ResetAdminPasswordRequest, ResetAdminPasswordResponse>
        resetAdminPasswordSettings() {
      return resetAdminPasswordSettings;
    }

    /** Returns the builder for the settings used for calls to listDomains. */
    public PagedCallSettings.Builder<
            ListDomainsRequest, ListDomainsResponse, ListDomainsPagedResponse>
        listDomainsSettings() {
      return listDomainsSettings;
    }

    /** Returns the builder for the settings used for calls to getDomain. */
    public UnaryCallSettings.Builder<GetDomainRequest, Domain> getDomainSettings() {
      return getDomainSettings;
    }

    /** Returns the builder for the settings used for calls to updateDomain. */
    public UnaryCallSettings.Builder<UpdateDomainRequest, Operation> updateDomainSettings() {
      return updateDomainSettings;
    }

    /** Returns the builder for the settings used for calls to updateDomain. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateDomainRequest, Domain, OpMetadata>
        updateDomainOperationSettings() {
      return updateDomainOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDomain. */
    public UnaryCallSettings.Builder<DeleteDomainRequest, Operation> deleteDomainSettings() {
      return deleteDomainSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDomain. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteDomainRequest, Empty, OpMetadata>
        deleteDomainOperationSettings() {
      return deleteDomainOperationSettings;
    }

    /** Returns the builder for the settings used for calls to attachTrust. */
    public UnaryCallSettings.Builder<AttachTrustRequest, Operation> attachTrustSettings() {
      return attachTrustSettings;
    }

    /** Returns the builder for the settings used for calls to attachTrust. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<AttachTrustRequest, Domain, OpMetadata>
        attachTrustOperationSettings() {
      return attachTrustOperationSettings;
    }

    /** Returns the builder for the settings used for calls to reconfigureTrust. */
    public UnaryCallSettings.Builder<ReconfigureTrustRequest, Operation>
        reconfigureTrustSettings() {
      return reconfigureTrustSettings;
    }

    /** Returns the builder for the settings used for calls to reconfigureTrust. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<ReconfigureTrustRequest, Domain, OpMetadata>
        reconfigureTrustOperationSettings() {
      return reconfigureTrustOperationSettings;
    }

    /** Returns the builder for the settings used for calls to detachTrust. */
    public UnaryCallSettings.Builder<DetachTrustRequest, Operation> detachTrustSettings() {
      return detachTrustSettings;
    }

    /** Returns the builder for the settings used for calls to detachTrust. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DetachTrustRequest, Domain, OpMetadata>
        detachTrustOperationSettings() {
      return detachTrustOperationSettings;
    }

    /** Returns the builder for the settings used for calls to validateTrust. */
    public UnaryCallSettings.Builder<ValidateTrustRequest, Operation> validateTrustSettings() {
      return validateTrustSettings;
    }

    /** Returns the builder for the settings used for calls to validateTrust. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<ValidateTrustRequest, Domain, OpMetadata>
        validateTrustOperationSettings() {
      return validateTrustOperationSettings;
    }

    @Override
    public ManagedIdentitiesServiceStubSettings build() throws IOException {
      return new ManagedIdentitiesServiceStubSettings(this);
    }
  }
}
