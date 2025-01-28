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

package com.google.cloud.parametermanager.v1;

import static com.google.cloud.parametermanager.v1.ParameterManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.parametermanager.v1.ParameterManagerClient.ListParameterVersionsPagedResponse;
import static com.google.cloud.parametermanager.v1.ParameterManagerClient.ListParametersPagedResponse;

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
import com.google.cloud.parametermanager.v1.stub.ParameterManagerStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ParameterManagerClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (parametermanager.googleapis.com) and default port (443) are
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
 * of getParameter:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ParameterManagerSettings.Builder parameterManagerSettingsBuilder =
 *     ParameterManagerSettings.newBuilder();
 * parameterManagerSettingsBuilder
 *     .getParameterSettings()
 *     .setRetrySettings(
 *         parameterManagerSettingsBuilder
 *             .getParameterSettings()
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
 * ParameterManagerSettings parameterManagerSettings = parameterManagerSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class ParameterManagerSettings extends ClientSettings<ParameterManagerSettings> {

  /** Returns the object with the settings used for calls to listParameters. */
  public PagedCallSettings<
          ListParametersRequest, ListParametersResponse, ListParametersPagedResponse>
      listParametersSettings() {
    return ((ParameterManagerStubSettings) getStubSettings()).listParametersSettings();
  }

  /** Returns the object with the settings used for calls to getParameter. */
  public UnaryCallSettings<GetParameterRequest, Parameter> getParameterSettings() {
    return ((ParameterManagerStubSettings) getStubSettings()).getParameterSettings();
  }

  /** Returns the object with the settings used for calls to createParameter. */
  public UnaryCallSettings<CreateParameterRequest, Parameter> createParameterSettings() {
    return ((ParameterManagerStubSettings) getStubSettings()).createParameterSettings();
  }

  /** Returns the object with the settings used for calls to updateParameter. */
  public UnaryCallSettings<UpdateParameterRequest, Parameter> updateParameterSettings() {
    return ((ParameterManagerStubSettings) getStubSettings()).updateParameterSettings();
  }

  /** Returns the object with the settings used for calls to deleteParameter. */
  public UnaryCallSettings<DeleteParameterRequest, Empty> deleteParameterSettings() {
    return ((ParameterManagerStubSettings) getStubSettings()).deleteParameterSettings();
  }

  /** Returns the object with the settings used for calls to listParameterVersions. */
  public PagedCallSettings<
          ListParameterVersionsRequest,
          ListParameterVersionsResponse,
          ListParameterVersionsPagedResponse>
      listParameterVersionsSettings() {
    return ((ParameterManagerStubSettings) getStubSettings()).listParameterVersionsSettings();
  }

  /** Returns the object with the settings used for calls to getParameterVersion. */
  public UnaryCallSettings<GetParameterVersionRequest, ParameterVersion>
      getParameterVersionSettings() {
    return ((ParameterManagerStubSettings) getStubSettings()).getParameterVersionSettings();
  }

  /** Returns the object with the settings used for calls to renderParameterVersion. */
  public UnaryCallSettings<RenderParameterVersionRequest, RenderParameterVersionResponse>
      renderParameterVersionSettings() {
    return ((ParameterManagerStubSettings) getStubSettings()).renderParameterVersionSettings();
  }

  /** Returns the object with the settings used for calls to createParameterVersion. */
  public UnaryCallSettings<CreateParameterVersionRequest, ParameterVersion>
      createParameterVersionSettings() {
    return ((ParameterManagerStubSettings) getStubSettings()).createParameterVersionSettings();
  }

  /** Returns the object with the settings used for calls to updateParameterVersion. */
  public UnaryCallSettings<UpdateParameterVersionRequest, ParameterVersion>
      updateParameterVersionSettings() {
    return ((ParameterManagerStubSettings) getStubSettings()).updateParameterVersionSettings();
  }

  /** Returns the object with the settings used for calls to deleteParameterVersion. */
  public UnaryCallSettings<DeleteParameterVersionRequest, Empty> deleteParameterVersionSettings() {
    return ((ParameterManagerStubSettings) getStubSettings()).deleteParameterVersionSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((ParameterManagerStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((ParameterManagerStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final ParameterManagerSettings create(ParameterManagerStubSettings stub)
      throws IOException {
    return new ParameterManagerSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ParameterManagerStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ParameterManagerStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ParameterManagerStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ParameterManagerStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ParameterManagerStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ParameterManagerStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ParameterManagerStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ParameterManagerStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ParameterManagerSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ParameterManagerSettings. */
  public static class Builder extends ClientSettings.Builder<ParameterManagerSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ParameterManagerStubSettings.newBuilder(clientContext));
    }

    protected Builder(ParameterManagerSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ParameterManagerStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ParameterManagerStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(ParameterManagerStubSettings.newHttpJsonBuilder());
    }

    public ParameterManagerStubSettings.Builder getStubSettingsBuilder() {
      return ((ParameterManagerStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listParameters. */
    public PagedCallSettings.Builder<
            ListParametersRequest, ListParametersResponse, ListParametersPagedResponse>
        listParametersSettings() {
      return getStubSettingsBuilder().listParametersSettings();
    }

    /** Returns the builder for the settings used for calls to getParameter. */
    public UnaryCallSettings.Builder<GetParameterRequest, Parameter> getParameterSettings() {
      return getStubSettingsBuilder().getParameterSettings();
    }

    /** Returns the builder for the settings used for calls to createParameter. */
    public UnaryCallSettings.Builder<CreateParameterRequest, Parameter> createParameterSettings() {
      return getStubSettingsBuilder().createParameterSettings();
    }

    /** Returns the builder for the settings used for calls to updateParameter. */
    public UnaryCallSettings.Builder<UpdateParameterRequest, Parameter> updateParameterSettings() {
      return getStubSettingsBuilder().updateParameterSettings();
    }

    /** Returns the builder for the settings used for calls to deleteParameter. */
    public UnaryCallSettings.Builder<DeleteParameterRequest, Empty> deleteParameterSettings() {
      return getStubSettingsBuilder().deleteParameterSettings();
    }

    /** Returns the builder for the settings used for calls to listParameterVersions. */
    public PagedCallSettings.Builder<
            ListParameterVersionsRequest,
            ListParameterVersionsResponse,
            ListParameterVersionsPagedResponse>
        listParameterVersionsSettings() {
      return getStubSettingsBuilder().listParameterVersionsSettings();
    }

    /** Returns the builder for the settings used for calls to getParameterVersion. */
    public UnaryCallSettings.Builder<GetParameterVersionRequest, ParameterVersion>
        getParameterVersionSettings() {
      return getStubSettingsBuilder().getParameterVersionSettings();
    }

    /** Returns the builder for the settings used for calls to renderParameterVersion. */
    public UnaryCallSettings.Builder<RenderParameterVersionRequest, RenderParameterVersionResponse>
        renderParameterVersionSettings() {
      return getStubSettingsBuilder().renderParameterVersionSettings();
    }

    /** Returns the builder for the settings used for calls to createParameterVersion. */
    public UnaryCallSettings.Builder<CreateParameterVersionRequest, ParameterVersion>
        createParameterVersionSettings() {
      return getStubSettingsBuilder().createParameterVersionSettings();
    }

    /** Returns the builder for the settings used for calls to updateParameterVersion. */
    public UnaryCallSettings.Builder<UpdateParameterVersionRequest, ParameterVersion>
        updateParameterVersionSettings() {
      return getStubSettingsBuilder().updateParameterVersionSettings();
    }

    /** Returns the builder for the settings used for calls to deleteParameterVersion. */
    public UnaryCallSettings.Builder<DeleteParameterVersionRequest, Empty>
        deleteParameterVersionSettings() {
      return getStubSettingsBuilder().deleteParameterVersionSettings();
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
    public ParameterManagerSettings build() throws IOException {
      return new ParameterManagerSettings(this);
    }
  }
}
