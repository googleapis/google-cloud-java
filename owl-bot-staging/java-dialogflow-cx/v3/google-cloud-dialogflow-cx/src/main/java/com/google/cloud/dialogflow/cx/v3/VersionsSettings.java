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

package com.google.cloud.dialogflow.cx.v3;

import static com.google.cloud.dialogflow.cx.v3.VersionsClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3.VersionsClient.ListVersionsPagedResponse;

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
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.dialogflow.cx.v3.stub.VersionsStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.Struct;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link VersionsClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dialogflow.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getVersion to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * VersionsSettings.Builder versionsSettingsBuilder = VersionsSettings.newBuilder();
 * versionsSettingsBuilder
 *     .getVersionSettings()
 *     .setRetrySettings(
 *         versionsSettingsBuilder.getVersionSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * VersionsSettings versionsSettings = versionsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class VersionsSettings extends ClientSettings<VersionsSettings> {

  /** Returns the object with the settings used for calls to listVersions. */
  public PagedCallSettings<ListVersionsRequest, ListVersionsResponse, ListVersionsPagedResponse>
      listVersionsSettings() {
    return ((VersionsStubSettings) getStubSettings()).listVersionsSettings();
  }

  /** Returns the object with the settings used for calls to getVersion. */
  public UnaryCallSettings<GetVersionRequest, Version> getVersionSettings() {
    return ((VersionsStubSettings) getStubSettings()).getVersionSettings();
  }

  /** Returns the object with the settings used for calls to createVersion. */
  public UnaryCallSettings<CreateVersionRequest, Operation> createVersionSettings() {
    return ((VersionsStubSettings) getStubSettings()).createVersionSettings();
  }

  /** Returns the object with the settings used for calls to createVersion. */
  public OperationCallSettings<CreateVersionRequest, Version, CreateVersionOperationMetadata>
      createVersionOperationSettings() {
    return ((VersionsStubSettings) getStubSettings()).createVersionOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateVersion. */
  public UnaryCallSettings<UpdateVersionRequest, Version> updateVersionSettings() {
    return ((VersionsStubSettings) getStubSettings()).updateVersionSettings();
  }

  /** Returns the object with the settings used for calls to deleteVersion. */
  public UnaryCallSettings<DeleteVersionRequest, Empty> deleteVersionSettings() {
    return ((VersionsStubSettings) getStubSettings()).deleteVersionSettings();
  }

  /** Returns the object with the settings used for calls to loadVersion. */
  public UnaryCallSettings<LoadVersionRequest, Operation> loadVersionSettings() {
    return ((VersionsStubSettings) getStubSettings()).loadVersionSettings();
  }

  /** Returns the object with the settings used for calls to loadVersion. */
  public OperationCallSettings<LoadVersionRequest, Empty, Struct> loadVersionOperationSettings() {
    return ((VersionsStubSettings) getStubSettings()).loadVersionOperationSettings();
  }

  /** Returns the object with the settings used for calls to compareVersions. */
  public UnaryCallSettings<CompareVersionsRequest, CompareVersionsResponse>
      compareVersionsSettings() {
    return ((VersionsStubSettings) getStubSettings()).compareVersionsSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((VersionsStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((VersionsStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final VersionsSettings create(VersionsStubSettings stub) throws IOException {
    return new VersionsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return VersionsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return VersionsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return VersionsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return VersionsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return VersionsStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return VersionsStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return VersionsStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return VersionsStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected VersionsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for VersionsSettings. */
  public static class Builder extends ClientSettings.Builder<VersionsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(VersionsStubSettings.newBuilder(clientContext));
    }

    protected Builder(VersionsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(VersionsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(VersionsStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(VersionsStubSettings.newHttpJsonBuilder());
    }

    public VersionsStubSettings.Builder getStubSettingsBuilder() {
      return ((VersionsStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listVersions. */
    public PagedCallSettings.Builder<
            ListVersionsRequest, ListVersionsResponse, ListVersionsPagedResponse>
        listVersionsSettings() {
      return getStubSettingsBuilder().listVersionsSettings();
    }

    /** Returns the builder for the settings used for calls to getVersion. */
    public UnaryCallSettings.Builder<GetVersionRequest, Version> getVersionSettings() {
      return getStubSettingsBuilder().getVersionSettings();
    }

    /** Returns the builder for the settings used for calls to createVersion. */
    public UnaryCallSettings.Builder<CreateVersionRequest, Operation> createVersionSettings() {
      return getStubSettingsBuilder().createVersionSettings();
    }

    /** Returns the builder for the settings used for calls to createVersion. */
    public OperationCallSettings.Builder<
            CreateVersionRequest, Version, CreateVersionOperationMetadata>
        createVersionOperationSettings() {
      return getStubSettingsBuilder().createVersionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateVersion. */
    public UnaryCallSettings.Builder<UpdateVersionRequest, Version> updateVersionSettings() {
      return getStubSettingsBuilder().updateVersionSettings();
    }

    /** Returns the builder for the settings used for calls to deleteVersion. */
    public UnaryCallSettings.Builder<DeleteVersionRequest, Empty> deleteVersionSettings() {
      return getStubSettingsBuilder().deleteVersionSettings();
    }

    /** Returns the builder for the settings used for calls to loadVersion. */
    public UnaryCallSettings.Builder<LoadVersionRequest, Operation> loadVersionSettings() {
      return getStubSettingsBuilder().loadVersionSettings();
    }

    /** Returns the builder for the settings used for calls to loadVersion. */
    public OperationCallSettings.Builder<LoadVersionRequest, Empty, Struct>
        loadVersionOperationSettings() {
      return getStubSettingsBuilder().loadVersionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to compareVersions. */
    public UnaryCallSettings.Builder<CompareVersionsRequest, CompareVersionsResponse>
        compareVersionsSettings() {
      return getStubSettingsBuilder().compareVersionsSettings();
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
    public VersionsSettings build() throws IOException {
      return new VersionsSettings(this);
    }
  }
}
