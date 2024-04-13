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

package com.google.cloud.aiplatform.v1beta1;

import static com.google.cloud.aiplatform.v1beta1.ExtensionRegistryServiceClient.ListExtensionsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ExtensionRegistryServiceClient.ListLocationsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.aiplatform.v1beta1.stub.ExtensionRegistryServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ExtensionRegistryServiceClient}.
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
 * ExtensionRegistryServiceSettings.Builder extensionRegistryServiceSettingsBuilder =
 *     ExtensionRegistryServiceSettings.newBuilder();
 * extensionRegistryServiceSettingsBuilder
 *     .getExtensionSettings()
 *     .setRetrySettings(
 *         extensionRegistryServiceSettingsBuilder
 *             .getExtensionSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ExtensionRegistryServiceSettings extensionRegistryServiceSettings =
 *     extensionRegistryServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ExtensionRegistryServiceSettings
    extends ClientSettings<ExtensionRegistryServiceSettings> {

  /** Returns the object with the settings used for calls to importExtension. */
  public UnaryCallSettings<ImportExtensionRequest, Operation> importExtensionSettings() {
    return ((ExtensionRegistryServiceStubSettings) getStubSettings()).importExtensionSettings();
  }

  /** Returns the object with the settings used for calls to importExtension. */
  public OperationCallSettings<ImportExtensionRequest, Extension, ImportExtensionOperationMetadata>
      importExtensionOperationSettings() {
    return ((ExtensionRegistryServiceStubSettings) getStubSettings())
        .importExtensionOperationSettings();
  }

  /** Returns the object with the settings used for calls to getExtension. */
  public UnaryCallSettings<GetExtensionRequest, Extension> getExtensionSettings() {
    return ((ExtensionRegistryServiceStubSettings) getStubSettings()).getExtensionSettings();
  }

  /** Returns the object with the settings used for calls to listExtensions. */
  public PagedCallSettings<
          ListExtensionsRequest, ListExtensionsResponse, ListExtensionsPagedResponse>
      listExtensionsSettings() {
    return ((ExtensionRegistryServiceStubSettings) getStubSettings()).listExtensionsSettings();
  }

  /** Returns the object with the settings used for calls to updateExtension. */
  public UnaryCallSettings<UpdateExtensionRequest, Extension> updateExtensionSettings() {
    return ((ExtensionRegistryServiceStubSettings) getStubSettings()).updateExtensionSettings();
  }

  /** Returns the object with the settings used for calls to deleteExtension. */
  public UnaryCallSettings<DeleteExtensionRequest, Operation> deleteExtensionSettings() {
    return ((ExtensionRegistryServiceStubSettings) getStubSettings()).deleteExtensionSettings();
  }

  /** Returns the object with the settings used for calls to deleteExtension. */
  public OperationCallSettings<DeleteExtensionRequest, Empty, DeleteOperationMetadata>
      deleteExtensionOperationSettings() {
    return ((ExtensionRegistryServiceStubSettings) getStubSettings())
        .deleteExtensionOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((ExtensionRegistryServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((ExtensionRegistryServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((ExtensionRegistryServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((ExtensionRegistryServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((ExtensionRegistryServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final ExtensionRegistryServiceSettings create(
      ExtensionRegistryServiceStubSettings stub) throws IOException {
    return new ExtensionRegistryServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ExtensionRegistryServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ExtensionRegistryServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ExtensionRegistryServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ExtensionRegistryServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ExtensionRegistryServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ExtensionRegistryServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ExtensionRegistryServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ExtensionRegistryServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ExtensionRegistryServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<ExtensionRegistryServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ExtensionRegistryServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(ExtensionRegistryServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ExtensionRegistryServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ExtensionRegistryServiceStubSettings.newBuilder());
    }

    public ExtensionRegistryServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((ExtensionRegistryServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to importExtension. */
    public UnaryCallSettings.Builder<ImportExtensionRequest, Operation> importExtensionSettings() {
      return getStubSettingsBuilder().importExtensionSettings();
    }

    /** Returns the builder for the settings used for calls to importExtension. */
    public OperationCallSettings.Builder<
            ImportExtensionRequest, Extension, ImportExtensionOperationMetadata>
        importExtensionOperationSettings() {
      return getStubSettingsBuilder().importExtensionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getExtension. */
    public UnaryCallSettings.Builder<GetExtensionRequest, Extension> getExtensionSettings() {
      return getStubSettingsBuilder().getExtensionSettings();
    }

    /** Returns the builder for the settings used for calls to listExtensions. */
    public PagedCallSettings.Builder<
            ListExtensionsRequest, ListExtensionsResponse, ListExtensionsPagedResponse>
        listExtensionsSettings() {
      return getStubSettingsBuilder().listExtensionsSettings();
    }

    /** Returns the builder for the settings used for calls to updateExtension. */
    public UnaryCallSettings.Builder<UpdateExtensionRequest, Extension> updateExtensionSettings() {
      return getStubSettingsBuilder().updateExtensionSettings();
    }

    /** Returns the builder for the settings used for calls to deleteExtension. */
    public UnaryCallSettings.Builder<DeleteExtensionRequest, Operation> deleteExtensionSettings() {
      return getStubSettingsBuilder().deleteExtensionSettings();
    }

    /** Returns the builder for the settings used for calls to deleteExtension. */
    public OperationCallSettings.Builder<DeleteExtensionRequest, Empty, DeleteOperationMetadata>
        deleteExtensionOperationSettings() {
      return getStubSettingsBuilder().deleteExtensionOperationSettings();
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

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public ExtensionRegistryServiceSettings build() throws IOException {
      return new ExtensionRegistryServiceSettings(this);
    }
  }
}
