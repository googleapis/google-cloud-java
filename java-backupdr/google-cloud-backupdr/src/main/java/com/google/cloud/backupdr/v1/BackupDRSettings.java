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

package com.google.cloud.backupdr.v1;

import static com.google.cloud.backupdr.v1.BackupDRClient.ListLocationsPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListManagementServersPagedResponse;

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
import com.google.cloud.backupdr.v1.stub.BackupDRStubSettings;
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
 * Settings class to configure an instance of {@link BackupDRClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (backupdr.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getManagementServer to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * BackupDRSettings.Builder backupDRSettingsBuilder = BackupDRSettings.newBuilder();
 * backupDRSettingsBuilder
 *     .getManagementServerSettings()
 *     .setRetrySettings(
 *         backupDRSettingsBuilder
 *             .getManagementServerSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * BackupDRSettings backupDRSettings = backupDRSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class BackupDRSettings extends ClientSettings<BackupDRSettings> {

  /** Returns the object with the settings used for calls to listManagementServers. */
  public PagedCallSettings<
          ListManagementServersRequest,
          ListManagementServersResponse,
          ListManagementServersPagedResponse>
      listManagementServersSettings() {
    return ((BackupDRStubSettings) getStubSettings()).listManagementServersSettings();
  }

  /** Returns the object with the settings used for calls to getManagementServer. */
  public UnaryCallSettings<GetManagementServerRequest, ManagementServer>
      getManagementServerSettings() {
    return ((BackupDRStubSettings) getStubSettings()).getManagementServerSettings();
  }

  /** Returns the object with the settings used for calls to createManagementServer. */
  public UnaryCallSettings<CreateManagementServerRequest, Operation>
      createManagementServerSettings() {
    return ((BackupDRStubSettings) getStubSettings()).createManagementServerSettings();
  }

  /** Returns the object with the settings used for calls to createManagementServer. */
  public OperationCallSettings<CreateManagementServerRequest, ManagementServer, OperationMetadata>
      createManagementServerOperationSettings() {
    return ((BackupDRStubSettings) getStubSettings()).createManagementServerOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteManagementServer. */
  public UnaryCallSettings<DeleteManagementServerRequest, Operation>
      deleteManagementServerSettings() {
    return ((BackupDRStubSettings) getStubSettings()).deleteManagementServerSettings();
  }

  /** Returns the object with the settings used for calls to deleteManagementServer. */
  public OperationCallSettings<DeleteManagementServerRequest, Empty, OperationMetadata>
      deleteManagementServerOperationSettings() {
    return ((BackupDRStubSettings) getStubSettings()).deleteManagementServerOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((BackupDRStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((BackupDRStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((BackupDRStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((BackupDRStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((BackupDRStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final BackupDRSettings create(BackupDRStubSettings stub) throws IOException {
    return new BackupDRSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return BackupDRStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return BackupDRStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return BackupDRStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return BackupDRStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return BackupDRStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return BackupDRStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return BackupDRStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return BackupDRStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected BackupDRSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for BackupDRSettings. */
  public static class Builder extends ClientSettings.Builder<BackupDRSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(BackupDRStubSettings.newBuilder(clientContext));
    }

    protected Builder(BackupDRSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(BackupDRStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(BackupDRStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(BackupDRStubSettings.newHttpJsonBuilder());
    }

    public BackupDRStubSettings.Builder getStubSettingsBuilder() {
      return ((BackupDRStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listManagementServers. */
    public PagedCallSettings.Builder<
            ListManagementServersRequest,
            ListManagementServersResponse,
            ListManagementServersPagedResponse>
        listManagementServersSettings() {
      return getStubSettingsBuilder().listManagementServersSettings();
    }

    /** Returns the builder for the settings used for calls to getManagementServer. */
    public UnaryCallSettings.Builder<GetManagementServerRequest, ManagementServer>
        getManagementServerSettings() {
      return getStubSettingsBuilder().getManagementServerSettings();
    }

    /** Returns the builder for the settings used for calls to createManagementServer. */
    public UnaryCallSettings.Builder<CreateManagementServerRequest, Operation>
        createManagementServerSettings() {
      return getStubSettingsBuilder().createManagementServerSettings();
    }

    /** Returns the builder for the settings used for calls to createManagementServer. */
    public OperationCallSettings.Builder<
            CreateManagementServerRequest, ManagementServer, OperationMetadata>
        createManagementServerOperationSettings() {
      return getStubSettingsBuilder().createManagementServerOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteManagementServer. */
    public UnaryCallSettings.Builder<DeleteManagementServerRequest, Operation>
        deleteManagementServerSettings() {
      return getStubSettingsBuilder().deleteManagementServerSettings();
    }

    /** Returns the builder for the settings used for calls to deleteManagementServer. */
    public OperationCallSettings.Builder<DeleteManagementServerRequest, Empty, OperationMetadata>
        deleteManagementServerOperationSettings() {
      return getStubSettingsBuilder().deleteManagementServerOperationSettings();
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
    public BackupDRSettings build() throws IOException {
      return new BackupDRSettings(this);
    }
  }
}
