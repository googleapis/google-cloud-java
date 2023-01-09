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

package com.google.protos.google.cloud.binaryauthorization.v1;

import static com.google.protos.google.cloud.binaryauthorization.v1.BinauthzManagementServiceV1Client.ListAttestorsPagedResponse;

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
import com.google.protobuf.Empty;
import com.google.protos.google.cloud.binaryauthorization.v1.stub.BinauthzManagementServiceV1StubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link BinauthzManagementServiceV1Client}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (binaryauthorization.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getPolicy to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * BinauthzManagementServiceV1Settings.Builder binauthzManagementServiceV1SettingsBuilder =
 *     BinauthzManagementServiceV1Settings.newBuilder();
 * binauthzManagementServiceV1SettingsBuilder
 *     .getPolicySettings()
 *     .setRetrySettings(
 *         binauthzManagementServiceV1SettingsBuilder
 *             .getPolicySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * BinauthzManagementServiceV1Settings binauthzManagementServiceV1Settings =
 *     binauthzManagementServiceV1SettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class BinauthzManagementServiceV1Settings
    extends ClientSettings<BinauthzManagementServiceV1Settings> {

  /** Returns the object with the settings used for calls to getPolicy. */
  public UnaryCallSettings<Service.GetPolicyRequest, Resources.Policy> getPolicySettings() {
    return ((BinauthzManagementServiceV1StubSettings) getStubSettings()).getPolicySettings();
  }

  /** Returns the object with the settings used for calls to updatePolicy. */
  public UnaryCallSettings<Service.UpdatePolicyRequest, Resources.Policy> updatePolicySettings() {
    return ((BinauthzManagementServiceV1StubSettings) getStubSettings()).updatePolicySettings();
  }

  /** Returns the object with the settings used for calls to createAttestor. */
  public UnaryCallSettings<Service.CreateAttestorRequest, Resources.Attestor>
      createAttestorSettings() {
    return ((BinauthzManagementServiceV1StubSettings) getStubSettings()).createAttestorSettings();
  }

  /** Returns the object with the settings used for calls to getAttestor. */
  public UnaryCallSettings<Service.GetAttestorRequest, Resources.Attestor> getAttestorSettings() {
    return ((BinauthzManagementServiceV1StubSettings) getStubSettings()).getAttestorSettings();
  }

  /** Returns the object with the settings used for calls to updateAttestor. */
  public UnaryCallSettings<Service.UpdateAttestorRequest, Resources.Attestor>
      updateAttestorSettings() {
    return ((BinauthzManagementServiceV1StubSettings) getStubSettings()).updateAttestorSettings();
  }

  /** Returns the object with the settings used for calls to listAttestors. */
  public PagedCallSettings<
          Service.ListAttestorsRequest, Service.ListAttestorsResponse, ListAttestorsPagedResponse>
      listAttestorsSettings() {
    return ((BinauthzManagementServiceV1StubSettings) getStubSettings()).listAttestorsSettings();
  }

  /** Returns the object with the settings used for calls to deleteAttestor. */
  public UnaryCallSettings<Service.DeleteAttestorRequest, Empty> deleteAttestorSettings() {
    return ((BinauthzManagementServiceV1StubSettings) getStubSettings()).deleteAttestorSettings();
  }

  public static final BinauthzManagementServiceV1Settings create(
      BinauthzManagementServiceV1StubSettings stub) throws IOException {
    return new BinauthzManagementServiceV1Settings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return BinauthzManagementServiceV1StubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return BinauthzManagementServiceV1StubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return BinauthzManagementServiceV1StubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return BinauthzManagementServiceV1StubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return BinauthzManagementServiceV1StubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return BinauthzManagementServiceV1StubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return BinauthzManagementServiceV1StubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return BinauthzManagementServiceV1StubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected BinauthzManagementServiceV1Settings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for BinauthzManagementServiceV1Settings. */
  public static class Builder
      extends ClientSettings.Builder<BinauthzManagementServiceV1Settings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(BinauthzManagementServiceV1StubSettings.newBuilder(clientContext));
    }

    protected Builder(BinauthzManagementServiceV1Settings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(BinauthzManagementServiceV1StubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(BinauthzManagementServiceV1StubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(BinauthzManagementServiceV1StubSettings.newHttpJsonBuilder());
    }

    public BinauthzManagementServiceV1StubSettings.Builder getStubSettingsBuilder() {
      return ((BinauthzManagementServiceV1StubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getPolicy. */
    public UnaryCallSettings.Builder<Service.GetPolicyRequest, Resources.Policy>
        getPolicySettings() {
      return getStubSettingsBuilder().getPolicySettings();
    }

    /** Returns the builder for the settings used for calls to updatePolicy. */
    public UnaryCallSettings.Builder<Service.UpdatePolicyRequest, Resources.Policy>
        updatePolicySettings() {
      return getStubSettingsBuilder().updatePolicySettings();
    }

    /** Returns the builder for the settings used for calls to createAttestor. */
    public UnaryCallSettings.Builder<Service.CreateAttestorRequest, Resources.Attestor>
        createAttestorSettings() {
      return getStubSettingsBuilder().createAttestorSettings();
    }

    /** Returns the builder for the settings used for calls to getAttestor. */
    public UnaryCallSettings.Builder<Service.GetAttestorRequest, Resources.Attestor>
        getAttestorSettings() {
      return getStubSettingsBuilder().getAttestorSettings();
    }

    /** Returns the builder for the settings used for calls to updateAttestor. */
    public UnaryCallSettings.Builder<Service.UpdateAttestorRequest, Resources.Attestor>
        updateAttestorSettings() {
      return getStubSettingsBuilder().updateAttestorSettings();
    }

    /** Returns the builder for the settings used for calls to listAttestors. */
    public PagedCallSettings.Builder<
            Service.ListAttestorsRequest, Service.ListAttestorsResponse, ListAttestorsPagedResponse>
        listAttestorsSettings() {
      return getStubSettingsBuilder().listAttestorsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAttestor. */
    public UnaryCallSettings.Builder<Service.DeleteAttestorRequest, Empty>
        deleteAttestorSettings() {
      return getStubSettingsBuilder().deleteAttestorSettings();
    }

    @Override
    public BinauthzManagementServiceV1Settings build() throws IOException {
      return new BinauthzManagementServiceV1Settings(this);
    }
  }
}
