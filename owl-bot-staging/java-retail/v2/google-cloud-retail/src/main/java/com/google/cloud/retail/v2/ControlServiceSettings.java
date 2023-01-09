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

package com.google.cloud.retail.v2;

import static com.google.cloud.retail.v2.ControlServiceClient.ListControlsPagedResponse;

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
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.retail.v2.stub.ControlServiceStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ControlServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (retail.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createControl to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ControlServiceSettings.Builder controlServiceSettingsBuilder =
 *     ControlServiceSettings.newBuilder();
 * controlServiceSettingsBuilder
 *     .createControlSettings()
 *     .setRetrySettings(
 *         controlServiceSettingsBuilder
 *             .createControlSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ControlServiceSettings controlServiceSettings = controlServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ControlServiceSettings extends ClientSettings<ControlServiceSettings> {

  /** Returns the object with the settings used for calls to createControl. */
  public UnaryCallSettings<CreateControlRequest, Control> createControlSettings() {
    return ((ControlServiceStubSettings) getStubSettings()).createControlSettings();
  }

  /** Returns the object with the settings used for calls to deleteControl. */
  public UnaryCallSettings<DeleteControlRequest, Empty> deleteControlSettings() {
    return ((ControlServiceStubSettings) getStubSettings()).deleteControlSettings();
  }

  /** Returns the object with the settings used for calls to updateControl. */
  public UnaryCallSettings<UpdateControlRequest, Control> updateControlSettings() {
    return ((ControlServiceStubSettings) getStubSettings()).updateControlSettings();
  }

  /** Returns the object with the settings used for calls to getControl. */
  public UnaryCallSettings<GetControlRequest, Control> getControlSettings() {
    return ((ControlServiceStubSettings) getStubSettings()).getControlSettings();
  }

  /** Returns the object with the settings used for calls to listControls. */
  public PagedCallSettings<ListControlsRequest, ListControlsResponse, ListControlsPagedResponse>
      listControlsSettings() {
    return ((ControlServiceStubSettings) getStubSettings()).listControlsSettings();
  }

  public static final ControlServiceSettings create(ControlServiceStubSettings stub)
      throws IOException {
    return new ControlServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ControlServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ControlServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ControlServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ControlServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ControlServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ControlServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ControlServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ControlServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ControlServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ControlServiceSettings. */
  public static class Builder extends ClientSettings.Builder<ControlServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ControlServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(ControlServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ControlServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ControlServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(ControlServiceStubSettings.newHttpJsonBuilder());
    }

    public ControlServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((ControlServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createControl. */
    public UnaryCallSettings.Builder<CreateControlRequest, Control> createControlSettings() {
      return getStubSettingsBuilder().createControlSettings();
    }

    /** Returns the builder for the settings used for calls to deleteControl. */
    public UnaryCallSettings.Builder<DeleteControlRequest, Empty> deleteControlSettings() {
      return getStubSettingsBuilder().deleteControlSettings();
    }

    /** Returns the builder for the settings used for calls to updateControl. */
    public UnaryCallSettings.Builder<UpdateControlRequest, Control> updateControlSettings() {
      return getStubSettingsBuilder().updateControlSettings();
    }

    /** Returns the builder for the settings used for calls to getControl. */
    public UnaryCallSettings.Builder<GetControlRequest, Control> getControlSettings() {
      return getStubSettingsBuilder().getControlSettings();
    }

    /** Returns the builder for the settings used for calls to listControls. */
    public PagedCallSettings.Builder<
            ListControlsRequest, ListControlsResponse, ListControlsPagedResponse>
        listControlsSettings() {
      return getStubSettingsBuilder().listControlsSettings();
    }

    @Override
    public ControlServiceSettings build() throws IOException {
      return new ControlServiceSettings(this);
    }
  }
}
