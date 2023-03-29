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

package com.google.cloud.ids.v1;

import static com.google.cloud.ids.v1.IDSClient.ListEndpointsPagedResponse;

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
import com.google.cloud.ids.v1.stub.IDSStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link IDSClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (ids.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getEndpoint to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * IDSSettings.Builder iDSSettingsBuilder = IDSSettings.newBuilder();
 * iDSSettingsBuilder
 *     .getEndpointSettings()
 *     .setRetrySettings(
 *         iDSSettingsBuilder
 *             .getEndpointSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * IDSSettings iDSSettings = iDSSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class IDSSettings extends ClientSettings<IDSSettings> {

  /** Returns the object with the settings used for calls to listEndpoints. */
  public PagedCallSettings<ListEndpointsRequest, ListEndpointsResponse, ListEndpointsPagedResponse>
      listEndpointsSettings() {
    return ((IDSStubSettings) getStubSettings()).listEndpointsSettings();
  }

  /** Returns the object with the settings used for calls to getEndpoint. */
  public UnaryCallSettings<GetEndpointRequest, Endpoint> getEndpointSettings() {
    return ((IDSStubSettings) getStubSettings()).getEndpointSettings();
  }

  /** Returns the object with the settings used for calls to createEndpoint. */
  public UnaryCallSettings<CreateEndpointRequest, Operation> createEndpointSettings() {
    return ((IDSStubSettings) getStubSettings()).createEndpointSettings();
  }

  /** Returns the object with the settings used for calls to createEndpoint. */
  public OperationCallSettings<CreateEndpointRequest, Endpoint, OperationMetadata>
      createEndpointOperationSettings() {
    return ((IDSStubSettings) getStubSettings()).createEndpointOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteEndpoint. */
  public UnaryCallSettings<DeleteEndpointRequest, Operation> deleteEndpointSettings() {
    return ((IDSStubSettings) getStubSettings()).deleteEndpointSettings();
  }

  /** Returns the object with the settings used for calls to deleteEndpoint. */
  public OperationCallSettings<DeleteEndpointRequest, Empty, OperationMetadata>
      deleteEndpointOperationSettings() {
    return ((IDSStubSettings) getStubSettings()).deleteEndpointOperationSettings();
  }

  public static final IDSSettings create(IDSStubSettings stub) throws IOException {
    return new IDSSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return IDSStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return IDSStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return IDSStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return IDSStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return IDSStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return IDSStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return IDSStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return IDSStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  @BetaApi
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

  protected IDSSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for IDSSettings. */
  public static class Builder extends ClientSettings.Builder<IDSSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(IDSStubSettings.newBuilder(clientContext));
    }

    protected Builder(IDSSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(IDSStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(IDSStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(IDSStubSettings.newHttpJsonBuilder());
    }

    public IDSStubSettings.Builder getStubSettingsBuilder() {
      return ((IDSStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listEndpoints. */
    public PagedCallSettings.Builder<
            ListEndpointsRequest, ListEndpointsResponse, ListEndpointsPagedResponse>
        listEndpointsSettings() {
      return getStubSettingsBuilder().listEndpointsSettings();
    }

    /** Returns the builder for the settings used for calls to getEndpoint. */
    public UnaryCallSettings.Builder<GetEndpointRequest, Endpoint> getEndpointSettings() {
      return getStubSettingsBuilder().getEndpointSettings();
    }

    /** Returns the builder for the settings used for calls to createEndpoint. */
    public UnaryCallSettings.Builder<CreateEndpointRequest, Operation> createEndpointSettings() {
      return getStubSettingsBuilder().createEndpointSettings();
    }

    /** Returns the builder for the settings used for calls to createEndpoint. */
    public OperationCallSettings.Builder<CreateEndpointRequest, Endpoint, OperationMetadata>
        createEndpointOperationSettings() {
      return getStubSettingsBuilder().createEndpointOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteEndpoint. */
    public UnaryCallSettings.Builder<DeleteEndpointRequest, Operation> deleteEndpointSettings() {
      return getStubSettingsBuilder().deleteEndpointSettings();
    }

    /** Returns the builder for the settings used for calls to deleteEndpoint. */
    public OperationCallSettings.Builder<DeleteEndpointRequest, Empty, OperationMetadata>
        deleteEndpointOperationSettings() {
      return getStubSettingsBuilder().deleteEndpointOperationSettings();
    }

    @Override
    public IDSSettings build() throws IOException {
      return new IDSSettings(this);
    }
  }
}
