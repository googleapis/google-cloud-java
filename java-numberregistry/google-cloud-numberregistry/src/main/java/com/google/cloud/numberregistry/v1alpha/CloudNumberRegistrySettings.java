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

package com.google.cloud.numberregistry.v1alpha;

import static com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryClient.ListCustomRangesPagedResponse;
import static com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryClient.ListDiscoveredRangesPagedResponse;
import static com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryClient.ListIpamAdminScopesPagedResponse;
import static com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryClient.ListRealmsPagedResponse;
import static com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryClient.ListRegistryBooksPagedResponse;
import static com.google.cloud.numberregistry.v1alpha.CloudNumberRegistryClient.SearchIpResourcesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.numberregistry.v1alpha.stub.CloudNumberRegistryStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link CloudNumberRegistryClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudnumberregistry.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getIpamAdminScope:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CloudNumberRegistrySettings.Builder cloudNumberRegistrySettingsBuilder =
 *     CloudNumberRegistrySettings.newBuilder();
 * cloudNumberRegistrySettingsBuilder
 *     .getIpamAdminScopeSettings()
 *     .setRetrySettings(
 *         cloudNumberRegistrySettingsBuilder
 *             .getIpamAdminScopeSettings()
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
 * CloudNumberRegistrySettings cloudNumberRegistrySettings =
 *     cloudNumberRegistrySettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createIpamAdminScope:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CloudNumberRegistrySettings.Builder cloudNumberRegistrySettingsBuilder =
 *     CloudNumberRegistrySettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * cloudNumberRegistrySettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class CloudNumberRegistrySettings extends ClientSettings<CloudNumberRegistrySettings> {

  /** Returns the object with the settings used for calls to listIpamAdminScopes. */
  public PagedCallSettings<
          ListIpamAdminScopesRequest, ListIpamAdminScopesResponse, ListIpamAdminScopesPagedResponse>
      listIpamAdminScopesSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings()).listIpamAdminScopesSettings();
  }

  /** Returns the object with the settings used for calls to getIpamAdminScope. */
  public UnaryCallSettings<GetIpamAdminScopeRequest, IpamAdminScope> getIpamAdminScopeSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings()).getIpamAdminScopeSettings();
  }

  /** Returns the object with the settings used for calls to checkAvailabilityIpamAdminScopes. */
  public UnaryCallSettings<
          CheckAvailabilityIpamAdminScopesRequest, CheckAvailabilityIpamAdminScopesResponse>
      checkAvailabilityIpamAdminScopesSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings())
        .checkAvailabilityIpamAdminScopesSettings();
  }

  /** Returns the object with the settings used for calls to createIpamAdminScope. */
  public UnaryCallSettings<CreateIpamAdminScopeRequest, Operation> createIpamAdminScopeSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings()).createIpamAdminScopeSettings();
  }

  /** Returns the object with the settings used for calls to createIpamAdminScope. */
  public OperationCallSettings<CreateIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
      createIpamAdminScopeOperationSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings())
        .createIpamAdminScopeOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateIpamAdminScope. */
  public UnaryCallSettings<UpdateIpamAdminScopeRequest, Operation> updateIpamAdminScopeSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings()).updateIpamAdminScopeSettings();
  }

  /** Returns the object with the settings used for calls to updateIpamAdminScope. */
  public OperationCallSettings<UpdateIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
      updateIpamAdminScopeOperationSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings())
        .updateIpamAdminScopeOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteIpamAdminScope. */
  public UnaryCallSettings<DeleteIpamAdminScopeRequest, Operation> deleteIpamAdminScopeSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings()).deleteIpamAdminScopeSettings();
  }

  /** Returns the object with the settings used for calls to deleteIpamAdminScope. */
  public OperationCallSettings<DeleteIpamAdminScopeRequest, Empty, OperationMetadata>
      deleteIpamAdminScopeOperationSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings())
        .deleteIpamAdminScopeOperationSettings();
  }

  /** Returns the object with the settings used for calls to disableIpamAdminScope. */
  public UnaryCallSettings<DisableIpamAdminScopeRequest, Operation>
      disableIpamAdminScopeSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings()).disableIpamAdminScopeSettings();
  }

  /** Returns the object with the settings used for calls to disableIpamAdminScope. */
  public OperationCallSettings<DisableIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
      disableIpamAdminScopeOperationSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings())
        .disableIpamAdminScopeOperationSettings();
  }

  /** Returns the object with the settings used for calls to cleanupIpamAdminScope. */
  public UnaryCallSettings<CleanupIpamAdminScopeRequest, Operation>
      cleanupIpamAdminScopeSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings()).cleanupIpamAdminScopeSettings();
  }

  /** Returns the object with the settings used for calls to cleanupIpamAdminScope. */
  public OperationCallSettings<CleanupIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
      cleanupIpamAdminScopeOperationSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings())
        .cleanupIpamAdminScopeOperationSettings();
  }

  /** Returns the object with the settings used for calls to listRegistryBooks. */
  public PagedCallSettings<
          ListRegistryBooksRequest, ListRegistryBooksResponse, ListRegistryBooksPagedResponse>
      listRegistryBooksSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings()).listRegistryBooksSettings();
  }

  /** Returns the object with the settings used for calls to getRegistryBook. */
  public UnaryCallSettings<GetRegistryBookRequest, RegistryBook> getRegistryBookSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings()).getRegistryBookSettings();
  }

  /** Returns the object with the settings used for calls to searchIpResources. */
  public PagedCallSettings<
          SearchIpResourcesRequest, SearchIpResourcesResponse, SearchIpResourcesPagedResponse>
      searchIpResourcesSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings()).searchIpResourcesSettings();
  }

  /** Returns the object with the settings used for calls to createRegistryBook. */
  public UnaryCallSettings<CreateRegistryBookRequest, Operation> createRegistryBookSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings()).createRegistryBookSettings();
  }

  /** Returns the object with the settings used for calls to createRegistryBook. */
  public OperationCallSettings<CreateRegistryBookRequest, RegistryBook, OperationMetadata>
      createRegistryBookOperationSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings())
        .createRegistryBookOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateRegistryBook. */
  public UnaryCallSettings<UpdateRegistryBookRequest, Operation> updateRegistryBookSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings()).updateRegistryBookSettings();
  }

  /** Returns the object with the settings used for calls to updateRegistryBook. */
  public OperationCallSettings<UpdateRegistryBookRequest, RegistryBook, OperationMetadata>
      updateRegistryBookOperationSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings())
        .updateRegistryBookOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteRegistryBook. */
  public UnaryCallSettings<DeleteRegistryBookRequest, Operation> deleteRegistryBookSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings()).deleteRegistryBookSettings();
  }

  /** Returns the object with the settings used for calls to deleteRegistryBook. */
  public OperationCallSettings<DeleteRegistryBookRequest, Empty, OperationMetadata>
      deleteRegistryBookOperationSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings())
        .deleteRegistryBookOperationSettings();
  }

  /** Returns the object with the settings used for calls to listRealms. */
  public PagedCallSettings<ListRealmsRequest, ListRealmsResponse, ListRealmsPagedResponse>
      listRealmsSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings()).listRealmsSettings();
  }

  /** Returns the object with the settings used for calls to getRealm. */
  public UnaryCallSettings<GetRealmRequest, Realm> getRealmSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings()).getRealmSettings();
  }

  /** Returns the object with the settings used for calls to createRealm. */
  public UnaryCallSettings<CreateRealmRequest, Operation> createRealmSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings()).createRealmSettings();
  }

  /** Returns the object with the settings used for calls to createRealm. */
  public OperationCallSettings<CreateRealmRequest, Realm, OperationMetadata>
      createRealmOperationSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings()).createRealmOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateRealm. */
  public UnaryCallSettings<UpdateRealmRequest, Operation> updateRealmSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings()).updateRealmSettings();
  }

  /** Returns the object with the settings used for calls to updateRealm. */
  public OperationCallSettings<UpdateRealmRequest, Realm, OperationMetadata>
      updateRealmOperationSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings()).updateRealmOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteRealm. */
  public UnaryCallSettings<DeleteRealmRequest, Operation> deleteRealmSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings()).deleteRealmSettings();
  }

  /** Returns the object with the settings used for calls to deleteRealm. */
  public OperationCallSettings<DeleteRealmRequest, Empty, OperationMetadata>
      deleteRealmOperationSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings()).deleteRealmOperationSettings();
  }

  /** Returns the object with the settings used for calls to listDiscoveredRanges. */
  public PagedCallSettings<
          ListDiscoveredRangesRequest,
          ListDiscoveredRangesResponse,
          ListDiscoveredRangesPagedResponse>
      listDiscoveredRangesSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings()).listDiscoveredRangesSettings();
  }

  /** Returns the object with the settings used for calls to getDiscoveredRange. */
  public UnaryCallSettings<GetDiscoveredRangeRequest, DiscoveredRange>
      getDiscoveredRangeSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings()).getDiscoveredRangeSettings();
  }

  /** Returns the object with the settings used for calls to findDiscoveredRangeFreeIpRanges. */
  public UnaryCallSettings<
          FindDiscoveredRangeFreeIpRangesRequest, FindDiscoveredRangeFreeIpRangesResponse>
      findDiscoveredRangeFreeIpRangesSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings())
        .findDiscoveredRangeFreeIpRangesSettings();
  }

  /** Returns the object with the settings used for calls to listCustomRanges. */
  public PagedCallSettings<
          ListCustomRangesRequest, ListCustomRangesResponse, ListCustomRangesPagedResponse>
      listCustomRangesSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings()).listCustomRangesSettings();
  }

  /** Returns the object with the settings used for calls to getCustomRange. */
  public UnaryCallSettings<GetCustomRangeRequest, CustomRange> getCustomRangeSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings()).getCustomRangeSettings();
  }

  /** Returns the object with the settings used for calls to showCustomRangeUtilization. */
  public UnaryCallSettings<ShowCustomRangeUtilizationRequest, ShowCustomRangeUtilizationResponse>
      showCustomRangeUtilizationSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings())
        .showCustomRangeUtilizationSettings();
  }

  /** Returns the object with the settings used for calls to showDiscoveredRangeUtilization. */
  public UnaryCallSettings<
          ShowDiscoveredRangeUtilizationRequest, ShowDiscoveredRangeUtilizationResponse>
      showDiscoveredRangeUtilizationSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings())
        .showDiscoveredRangeUtilizationSettings();
  }

  /** Returns the object with the settings used for calls to findCustomRangeFreeIpRanges. */
  public UnaryCallSettings<FindCustomRangeFreeIpRangesRequest, FindCustomRangeFreeIpRangesResponse>
      findCustomRangeFreeIpRangesSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings())
        .findCustomRangeFreeIpRangesSettings();
  }

  /** Returns the object with the settings used for calls to createCustomRange. */
  public UnaryCallSettings<CreateCustomRangeRequest, Operation> createCustomRangeSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings()).createCustomRangeSettings();
  }

  /** Returns the object with the settings used for calls to createCustomRange. */
  public OperationCallSettings<CreateCustomRangeRequest, CustomRange, OperationMetadata>
      createCustomRangeOperationSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings())
        .createCustomRangeOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateCustomRange. */
  public UnaryCallSettings<UpdateCustomRangeRequest, Operation> updateCustomRangeSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings()).updateCustomRangeSettings();
  }

  /** Returns the object with the settings used for calls to updateCustomRange. */
  public OperationCallSettings<UpdateCustomRangeRequest, CustomRange, OperationMetadata>
      updateCustomRangeOperationSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings())
        .updateCustomRangeOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteCustomRange. */
  public UnaryCallSettings<DeleteCustomRangeRequest, Operation> deleteCustomRangeSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings()).deleteCustomRangeSettings();
  }

  /** Returns the object with the settings used for calls to deleteCustomRange. */
  public OperationCallSettings<DeleteCustomRangeRequest, Empty, OperationMetadata>
      deleteCustomRangeOperationSettings() {
    return ((CloudNumberRegistryStubSettings) getStubSettings())
        .deleteCustomRangeOperationSettings();
  }

  public static final CloudNumberRegistrySettings create(CloudNumberRegistryStubSettings stub)
      throws IOException {
    return new CloudNumberRegistrySettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return CloudNumberRegistryStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return CloudNumberRegistryStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return CloudNumberRegistryStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return CloudNumberRegistryStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return CloudNumberRegistryStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return CloudNumberRegistryStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return CloudNumberRegistryStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CloudNumberRegistryStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  public static Builder newHttpJsonBuilder() {
    return Builder.createHttpJsonDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected CloudNumberRegistrySettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for CloudNumberRegistrySettings. */
  public static class Builder extends ClientSettings.Builder<CloudNumberRegistrySettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(CloudNumberRegistryStubSettings.newBuilder(clientContext));
    }

    protected Builder(CloudNumberRegistrySettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(CloudNumberRegistryStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(CloudNumberRegistryStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(CloudNumberRegistryStubSettings.newHttpJsonBuilder());
    }

    public CloudNumberRegistryStubSettings.Builder getStubSettingsBuilder() {
      return ((CloudNumberRegistryStubSettings.Builder) getStubSettings());
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to listIpamAdminScopes. */
    public PagedCallSettings.Builder<
            ListIpamAdminScopesRequest,
            ListIpamAdminScopesResponse,
            ListIpamAdminScopesPagedResponse>
        listIpamAdminScopesSettings() {
      return getStubSettingsBuilder().listIpamAdminScopesSettings();
    }

    /** Returns the builder for the settings used for calls to getIpamAdminScope. */
    public UnaryCallSettings.Builder<GetIpamAdminScopeRequest, IpamAdminScope>
        getIpamAdminScopeSettings() {
      return getStubSettingsBuilder().getIpamAdminScopeSettings();
    }

    /** Returns the builder for the settings used for calls to checkAvailabilityIpamAdminScopes. */
    public UnaryCallSettings.Builder<
            CheckAvailabilityIpamAdminScopesRequest, CheckAvailabilityIpamAdminScopesResponse>
        checkAvailabilityIpamAdminScopesSettings() {
      return getStubSettingsBuilder().checkAvailabilityIpamAdminScopesSettings();
    }

    /** Returns the builder for the settings used for calls to createIpamAdminScope. */
    public UnaryCallSettings.Builder<CreateIpamAdminScopeRequest, Operation>
        createIpamAdminScopeSettings() {
      return getStubSettingsBuilder().createIpamAdminScopeSettings();
    }

    /** Returns the builder for the settings used for calls to createIpamAdminScope. */
    public OperationCallSettings.Builder<
            CreateIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
        createIpamAdminScopeOperationSettings() {
      return getStubSettingsBuilder().createIpamAdminScopeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateIpamAdminScope. */
    public UnaryCallSettings.Builder<UpdateIpamAdminScopeRequest, Operation>
        updateIpamAdminScopeSettings() {
      return getStubSettingsBuilder().updateIpamAdminScopeSettings();
    }

    /** Returns the builder for the settings used for calls to updateIpamAdminScope. */
    public OperationCallSettings.Builder<
            UpdateIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
        updateIpamAdminScopeOperationSettings() {
      return getStubSettingsBuilder().updateIpamAdminScopeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteIpamAdminScope. */
    public UnaryCallSettings.Builder<DeleteIpamAdminScopeRequest, Operation>
        deleteIpamAdminScopeSettings() {
      return getStubSettingsBuilder().deleteIpamAdminScopeSettings();
    }

    /** Returns the builder for the settings used for calls to deleteIpamAdminScope. */
    public OperationCallSettings.Builder<DeleteIpamAdminScopeRequest, Empty, OperationMetadata>
        deleteIpamAdminScopeOperationSettings() {
      return getStubSettingsBuilder().deleteIpamAdminScopeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to disableIpamAdminScope. */
    public UnaryCallSettings.Builder<DisableIpamAdminScopeRequest, Operation>
        disableIpamAdminScopeSettings() {
      return getStubSettingsBuilder().disableIpamAdminScopeSettings();
    }

    /** Returns the builder for the settings used for calls to disableIpamAdminScope. */
    public OperationCallSettings.Builder<
            DisableIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
        disableIpamAdminScopeOperationSettings() {
      return getStubSettingsBuilder().disableIpamAdminScopeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to cleanupIpamAdminScope. */
    public UnaryCallSettings.Builder<CleanupIpamAdminScopeRequest, Operation>
        cleanupIpamAdminScopeSettings() {
      return getStubSettingsBuilder().cleanupIpamAdminScopeSettings();
    }

    /** Returns the builder for the settings used for calls to cleanupIpamAdminScope. */
    public OperationCallSettings.Builder<
            CleanupIpamAdminScopeRequest, IpamAdminScope, OperationMetadata>
        cleanupIpamAdminScopeOperationSettings() {
      return getStubSettingsBuilder().cleanupIpamAdminScopeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listRegistryBooks. */
    public PagedCallSettings.Builder<
            ListRegistryBooksRequest, ListRegistryBooksResponse, ListRegistryBooksPagedResponse>
        listRegistryBooksSettings() {
      return getStubSettingsBuilder().listRegistryBooksSettings();
    }

    /** Returns the builder for the settings used for calls to getRegistryBook. */
    public UnaryCallSettings.Builder<GetRegistryBookRequest, RegistryBook>
        getRegistryBookSettings() {
      return getStubSettingsBuilder().getRegistryBookSettings();
    }

    /** Returns the builder for the settings used for calls to searchIpResources. */
    public PagedCallSettings.Builder<
            SearchIpResourcesRequest, SearchIpResourcesResponse, SearchIpResourcesPagedResponse>
        searchIpResourcesSettings() {
      return getStubSettingsBuilder().searchIpResourcesSettings();
    }

    /** Returns the builder for the settings used for calls to createRegistryBook. */
    public UnaryCallSettings.Builder<CreateRegistryBookRequest, Operation>
        createRegistryBookSettings() {
      return getStubSettingsBuilder().createRegistryBookSettings();
    }

    /** Returns the builder for the settings used for calls to createRegistryBook. */
    public OperationCallSettings.Builder<CreateRegistryBookRequest, RegistryBook, OperationMetadata>
        createRegistryBookOperationSettings() {
      return getStubSettingsBuilder().createRegistryBookOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateRegistryBook. */
    public UnaryCallSettings.Builder<UpdateRegistryBookRequest, Operation>
        updateRegistryBookSettings() {
      return getStubSettingsBuilder().updateRegistryBookSettings();
    }

    /** Returns the builder for the settings used for calls to updateRegistryBook. */
    public OperationCallSettings.Builder<UpdateRegistryBookRequest, RegistryBook, OperationMetadata>
        updateRegistryBookOperationSettings() {
      return getStubSettingsBuilder().updateRegistryBookOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRegistryBook. */
    public UnaryCallSettings.Builder<DeleteRegistryBookRequest, Operation>
        deleteRegistryBookSettings() {
      return getStubSettingsBuilder().deleteRegistryBookSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRegistryBook. */
    public OperationCallSettings.Builder<DeleteRegistryBookRequest, Empty, OperationMetadata>
        deleteRegistryBookOperationSettings() {
      return getStubSettingsBuilder().deleteRegistryBookOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listRealms. */
    public PagedCallSettings.Builder<ListRealmsRequest, ListRealmsResponse, ListRealmsPagedResponse>
        listRealmsSettings() {
      return getStubSettingsBuilder().listRealmsSettings();
    }

    /** Returns the builder for the settings used for calls to getRealm. */
    public UnaryCallSettings.Builder<GetRealmRequest, Realm> getRealmSettings() {
      return getStubSettingsBuilder().getRealmSettings();
    }

    /** Returns the builder for the settings used for calls to createRealm. */
    public UnaryCallSettings.Builder<CreateRealmRequest, Operation> createRealmSettings() {
      return getStubSettingsBuilder().createRealmSettings();
    }

    /** Returns the builder for the settings used for calls to createRealm. */
    public OperationCallSettings.Builder<CreateRealmRequest, Realm, OperationMetadata>
        createRealmOperationSettings() {
      return getStubSettingsBuilder().createRealmOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateRealm. */
    public UnaryCallSettings.Builder<UpdateRealmRequest, Operation> updateRealmSettings() {
      return getStubSettingsBuilder().updateRealmSettings();
    }

    /** Returns the builder for the settings used for calls to updateRealm. */
    public OperationCallSettings.Builder<UpdateRealmRequest, Realm, OperationMetadata>
        updateRealmOperationSettings() {
      return getStubSettingsBuilder().updateRealmOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRealm. */
    public UnaryCallSettings.Builder<DeleteRealmRequest, Operation> deleteRealmSettings() {
      return getStubSettingsBuilder().deleteRealmSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRealm. */
    public OperationCallSettings.Builder<DeleteRealmRequest, Empty, OperationMetadata>
        deleteRealmOperationSettings() {
      return getStubSettingsBuilder().deleteRealmOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listDiscoveredRanges. */
    public PagedCallSettings.Builder<
            ListDiscoveredRangesRequest,
            ListDiscoveredRangesResponse,
            ListDiscoveredRangesPagedResponse>
        listDiscoveredRangesSettings() {
      return getStubSettingsBuilder().listDiscoveredRangesSettings();
    }

    /** Returns the builder for the settings used for calls to getDiscoveredRange. */
    public UnaryCallSettings.Builder<GetDiscoveredRangeRequest, DiscoveredRange>
        getDiscoveredRangeSettings() {
      return getStubSettingsBuilder().getDiscoveredRangeSettings();
    }

    /** Returns the builder for the settings used for calls to findDiscoveredRangeFreeIpRanges. */
    public UnaryCallSettings.Builder<
            FindDiscoveredRangeFreeIpRangesRequest, FindDiscoveredRangeFreeIpRangesResponse>
        findDiscoveredRangeFreeIpRangesSettings() {
      return getStubSettingsBuilder().findDiscoveredRangeFreeIpRangesSettings();
    }

    /** Returns the builder for the settings used for calls to listCustomRanges. */
    public PagedCallSettings.Builder<
            ListCustomRangesRequest, ListCustomRangesResponse, ListCustomRangesPagedResponse>
        listCustomRangesSettings() {
      return getStubSettingsBuilder().listCustomRangesSettings();
    }

    /** Returns the builder for the settings used for calls to getCustomRange. */
    public UnaryCallSettings.Builder<GetCustomRangeRequest, CustomRange> getCustomRangeSettings() {
      return getStubSettingsBuilder().getCustomRangeSettings();
    }

    /** Returns the builder for the settings used for calls to showCustomRangeUtilization. */
    public UnaryCallSettings.Builder<
            ShowCustomRangeUtilizationRequest, ShowCustomRangeUtilizationResponse>
        showCustomRangeUtilizationSettings() {
      return getStubSettingsBuilder().showCustomRangeUtilizationSettings();
    }

    /** Returns the builder for the settings used for calls to showDiscoveredRangeUtilization. */
    public UnaryCallSettings.Builder<
            ShowDiscoveredRangeUtilizationRequest, ShowDiscoveredRangeUtilizationResponse>
        showDiscoveredRangeUtilizationSettings() {
      return getStubSettingsBuilder().showDiscoveredRangeUtilizationSettings();
    }

    /** Returns the builder for the settings used for calls to findCustomRangeFreeIpRanges. */
    public UnaryCallSettings.Builder<
            FindCustomRangeFreeIpRangesRequest, FindCustomRangeFreeIpRangesResponse>
        findCustomRangeFreeIpRangesSettings() {
      return getStubSettingsBuilder().findCustomRangeFreeIpRangesSettings();
    }

    /** Returns the builder for the settings used for calls to createCustomRange. */
    public UnaryCallSettings.Builder<CreateCustomRangeRequest, Operation>
        createCustomRangeSettings() {
      return getStubSettingsBuilder().createCustomRangeSettings();
    }

    /** Returns the builder for the settings used for calls to createCustomRange. */
    public OperationCallSettings.Builder<CreateCustomRangeRequest, CustomRange, OperationMetadata>
        createCustomRangeOperationSettings() {
      return getStubSettingsBuilder().createCustomRangeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateCustomRange. */
    public UnaryCallSettings.Builder<UpdateCustomRangeRequest, Operation>
        updateCustomRangeSettings() {
      return getStubSettingsBuilder().updateCustomRangeSettings();
    }

    /** Returns the builder for the settings used for calls to updateCustomRange. */
    public OperationCallSettings.Builder<UpdateCustomRangeRequest, CustomRange, OperationMetadata>
        updateCustomRangeOperationSettings() {
      return getStubSettingsBuilder().updateCustomRangeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCustomRange. */
    public UnaryCallSettings.Builder<DeleteCustomRangeRequest, Operation>
        deleteCustomRangeSettings() {
      return getStubSettingsBuilder().deleteCustomRangeSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCustomRange. */
    public OperationCallSettings.Builder<DeleteCustomRangeRequest, Empty, OperationMetadata>
        deleteCustomRangeOperationSettings() {
      return getStubSettingsBuilder().deleteCustomRangeOperationSettings();
    }

    @Override
    public CloudNumberRegistrySettings build() throws IOException {
      return new CloudNumberRegistrySettings(this);
    }
  }
}
