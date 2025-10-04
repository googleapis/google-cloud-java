/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.saasplatform.saasservicemgmt.v1beta1;

import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRolloutsClient.ListLocationsPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRolloutsClient.ListRolloutKindsPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasRolloutsClient.ListRolloutsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.stub.SaasRolloutsStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SaasRolloutsClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (saasservicemgmt.googleapis.com) and default port (443) are
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
 * of getRollout:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SaasRolloutsSettings.Builder saasRolloutsSettingsBuilder = SaasRolloutsSettings.newBuilder();
 * saasRolloutsSettingsBuilder
 *     .getRolloutSettings()
 *     .setRetrySettings(
 *         saasRolloutsSettingsBuilder
 *             .getRolloutSettings()
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
 * SaasRolloutsSettings saasRolloutsSettings = saasRolloutsSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class SaasRolloutsSettings extends ClientSettings<SaasRolloutsSettings> {

  /** Returns the object with the settings used for calls to listRollouts. */
  public PagedCallSettings<ListRolloutsRequest, ListRolloutsResponse, ListRolloutsPagedResponse>
      listRolloutsSettings() {
    return ((SaasRolloutsStubSettings) getStubSettings()).listRolloutsSettings();
  }

  /** Returns the object with the settings used for calls to getRollout. */
  public UnaryCallSettings<GetRolloutRequest, Rollout> getRolloutSettings() {
    return ((SaasRolloutsStubSettings) getStubSettings()).getRolloutSettings();
  }

  /** Returns the object with the settings used for calls to createRollout. */
  public UnaryCallSettings<CreateRolloutRequest, Rollout> createRolloutSettings() {
    return ((SaasRolloutsStubSettings) getStubSettings()).createRolloutSettings();
  }

  /** Returns the object with the settings used for calls to updateRollout. */
  public UnaryCallSettings<UpdateRolloutRequest, Rollout> updateRolloutSettings() {
    return ((SaasRolloutsStubSettings) getStubSettings()).updateRolloutSettings();
  }

  /** Returns the object with the settings used for calls to deleteRollout. */
  public UnaryCallSettings<DeleteRolloutRequest, Empty> deleteRolloutSettings() {
    return ((SaasRolloutsStubSettings) getStubSettings()).deleteRolloutSettings();
  }

  /** Returns the object with the settings used for calls to listRolloutKinds. */
  public PagedCallSettings<
          ListRolloutKindsRequest, ListRolloutKindsResponse, ListRolloutKindsPagedResponse>
      listRolloutKindsSettings() {
    return ((SaasRolloutsStubSettings) getStubSettings()).listRolloutKindsSettings();
  }

  /** Returns the object with the settings used for calls to getRolloutKind. */
  public UnaryCallSettings<GetRolloutKindRequest, RolloutKind> getRolloutKindSettings() {
    return ((SaasRolloutsStubSettings) getStubSettings()).getRolloutKindSettings();
  }

  /** Returns the object with the settings used for calls to createRolloutKind. */
  public UnaryCallSettings<CreateRolloutKindRequest, RolloutKind> createRolloutKindSettings() {
    return ((SaasRolloutsStubSettings) getStubSettings()).createRolloutKindSettings();
  }

  /** Returns the object with the settings used for calls to updateRolloutKind. */
  public UnaryCallSettings<UpdateRolloutKindRequest, RolloutKind> updateRolloutKindSettings() {
    return ((SaasRolloutsStubSettings) getStubSettings()).updateRolloutKindSettings();
  }

  /** Returns the object with the settings used for calls to deleteRolloutKind. */
  public UnaryCallSettings<DeleteRolloutKindRequest, Empty> deleteRolloutKindSettings() {
    return ((SaasRolloutsStubSettings) getStubSettings()).deleteRolloutKindSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((SaasRolloutsStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((SaasRolloutsStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final SaasRolloutsSettings create(SaasRolloutsStubSettings stub)
      throws IOException {
    return new SaasRolloutsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return SaasRolloutsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return SaasRolloutsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return SaasRolloutsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return SaasRolloutsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return SaasRolloutsStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return SaasRolloutsStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return SaasRolloutsStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SaasRolloutsStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected SaasRolloutsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for SaasRolloutsSettings. */
  public static class Builder extends ClientSettings.Builder<SaasRolloutsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(SaasRolloutsStubSettings.newBuilder(clientContext));
    }

    protected Builder(SaasRolloutsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(SaasRolloutsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(SaasRolloutsStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(SaasRolloutsStubSettings.newHttpJsonBuilder());
    }

    public SaasRolloutsStubSettings.Builder getStubSettingsBuilder() {
      return ((SaasRolloutsStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listRollouts. */
    public PagedCallSettings.Builder<
            ListRolloutsRequest, ListRolloutsResponse, ListRolloutsPagedResponse>
        listRolloutsSettings() {
      return getStubSettingsBuilder().listRolloutsSettings();
    }

    /** Returns the builder for the settings used for calls to getRollout. */
    public UnaryCallSettings.Builder<GetRolloutRequest, Rollout> getRolloutSettings() {
      return getStubSettingsBuilder().getRolloutSettings();
    }

    /** Returns the builder for the settings used for calls to createRollout. */
    public UnaryCallSettings.Builder<CreateRolloutRequest, Rollout> createRolloutSettings() {
      return getStubSettingsBuilder().createRolloutSettings();
    }

    /** Returns the builder for the settings used for calls to updateRollout. */
    public UnaryCallSettings.Builder<UpdateRolloutRequest, Rollout> updateRolloutSettings() {
      return getStubSettingsBuilder().updateRolloutSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRollout. */
    public UnaryCallSettings.Builder<DeleteRolloutRequest, Empty> deleteRolloutSettings() {
      return getStubSettingsBuilder().deleteRolloutSettings();
    }

    /** Returns the builder for the settings used for calls to listRolloutKinds. */
    public PagedCallSettings.Builder<
            ListRolloutKindsRequest, ListRolloutKindsResponse, ListRolloutKindsPagedResponse>
        listRolloutKindsSettings() {
      return getStubSettingsBuilder().listRolloutKindsSettings();
    }

    /** Returns the builder for the settings used for calls to getRolloutKind. */
    public UnaryCallSettings.Builder<GetRolloutKindRequest, RolloutKind> getRolloutKindSettings() {
      return getStubSettingsBuilder().getRolloutKindSettings();
    }

    /** Returns the builder for the settings used for calls to createRolloutKind. */
    public UnaryCallSettings.Builder<CreateRolloutKindRequest, RolloutKind>
        createRolloutKindSettings() {
      return getStubSettingsBuilder().createRolloutKindSettings();
    }

    /** Returns the builder for the settings used for calls to updateRolloutKind. */
    public UnaryCallSettings.Builder<UpdateRolloutKindRequest, RolloutKind>
        updateRolloutKindSettings() {
      return getStubSettingsBuilder().updateRolloutKindSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRolloutKind. */
    public UnaryCallSettings.Builder<DeleteRolloutKindRequest, Empty> deleteRolloutKindSettings() {
      return getStubSettingsBuilder().deleteRolloutKindSettings();
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return getStubSettingsBuilder().listLocationsSettings();
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getStubSettingsBuilder().getLocationSettings();
    }

    @Override
    public SaasRolloutsSettings build() throws IOException {
      return new SaasRolloutsSettings(this);
    }
  }
}
