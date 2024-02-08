/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.dialogflow.cx.v3beta1;

import static com.google.cloud.dialogflow.cx.v3beta1.PlaybooksClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.PlaybooksClient.ListPlaybookVersionsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.PlaybooksClient.ListPlaybooksPagedResponse;

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
import com.google.cloud.dialogflow.cx.v3beta1.stub.PlaybooksStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link PlaybooksClient}.
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
 * <p>For example, to set the total timeout of createPlaybook to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PlaybooksSettings.Builder playbooksSettingsBuilder = PlaybooksSettings.newBuilder();
 * playbooksSettingsBuilder
 *     .createPlaybookSettings()
 *     .setRetrySettings(
 *         playbooksSettingsBuilder
 *             .createPlaybookSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * PlaybooksSettings playbooksSettings = playbooksSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class PlaybooksSettings extends ClientSettings<PlaybooksSettings> {

  /** Returns the object with the settings used for calls to createPlaybook. */
  public UnaryCallSettings<CreatePlaybookRequest, Playbook> createPlaybookSettings() {
    return ((PlaybooksStubSettings) getStubSettings()).createPlaybookSettings();
  }

  /** Returns the object with the settings used for calls to deletePlaybook. */
  public UnaryCallSettings<DeletePlaybookRequest, Empty> deletePlaybookSettings() {
    return ((PlaybooksStubSettings) getStubSettings()).deletePlaybookSettings();
  }

  /** Returns the object with the settings used for calls to listPlaybooks. */
  public PagedCallSettings<ListPlaybooksRequest, ListPlaybooksResponse, ListPlaybooksPagedResponse>
      listPlaybooksSettings() {
    return ((PlaybooksStubSettings) getStubSettings()).listPlaybooksSettings();
  }

  /** Returns the object with the settings used for calls to getPlaybook. */
  public UnaryCallSettings<GetPlaybookRequest, Playbook> getPlaybookSettings() {
    return ((PlaybooksStubSettings) getStubSettings()).getPlaybookSettings();
  }

  /** Returns the object with the settings used for calls to updatePlaybook. */
  public UnaryCallSettings<UpdatePlaybookRequest, Playbook> updatePlaybookSettings() {
    return ((PlaybooksStubSettings) getStubSettings()).updatePlaybookSettings();
  }

  /** Returns the object with the settings used for calls to createPlaybookVersion. */
  public UnaryCallSettings<CreatePlaybookVersionRequest, PlaybookVersion>
      createPlaybookVersionSettings() {
    return ((PlaybooksStubSettings) getStubSettings()).createPlaybookVersionSettings();
  }

  /** Returns the object with the settings used for calls to getPlaybookVersion. */
  public UnaryCallSettings<GetPlaybookVersionRequest, PlaybookVersion>
      getPlaybookVersionSettings() {
    return ((PlaybooksStubSettings) getStubSettings()).getPlaybookVersionSettings();
  }

  /** Returns the object with the settings used for calls to listPlaybookVersions. */
  public PagedCallSettings<
          ListPlaybookVersionsRequest,
          ListPlaybookVersionsResponse,
          ListPlaybookVersionsPagedResponse>
      listPlaybookVersionsSettings() {
    return ((PlaybooksStubSettings) getStubSettings()).listPlaybookVersionsSettings();
  }

  /** Returns the object with the settings used for calls to deletePlaybookVersion. */
  public UnaryCallSettings<DeletePlaybookVersionRequest, Empty> deletePlaybookVersionSettings() {
    return ((PlaybooksStubSettings) getStubSettings()).deletePlaybookVersionSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((PlaybooksStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((PlaybooksStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final PlaybooksSettings create(PlaybooksStubSettings stub) throws IOException {
    return new PlaybooksSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return PlaybooksStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return PlaybooksStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return PlaybooksStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return PlaybooksStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return PlaybooksStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return PlaybooksStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return PlaybooksStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return PlaybooksStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected PlaybooksSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for PlaybooksSettings. */
  public static class Builder extends ClientSettings.Builder<PlaybooksSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(PlaybooksStubSettings.newBuilder(clientContext));
    }

    protected Builder(PlaybooksSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(PlaybooksStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(PlaybooksStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(PlaybooksStubSettings.newHttpJsonBuilder());
    }

    public PlaybooksStubSettings.Builder getStubSettingsBuilder() {
      return ((PlaybooksStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createPlaybook. */
    public UnaryCallSettings.Builder<CreatePlaybookRequest, Playbook> createPlaybookSettings() {
      return getStubSettingsBuilder().createPlaybookSettings();
    }

    /** Returns the builder for the settings used for calls to deletePlaybook. */
    public UnaryCallSettings.Builder<DeletePlaybookRequest, Empty> deletePlaybookSettings() {
      return getStubSettingsBuilder().deletePlaybookSettings();
    }

    /** Returns the builder for the settings used for calls to listPlaybooks. */
    public PagedCallSettings.Builder<
            ListPlaybooksRequest, ListPlaybooksResponse, ListPlaybooksPagedResponse>
        listPlaybooksSettings() {
      return getStubSettingsBuilder().listPlaybooksSettings();
    }

    /** Returns the builder for the settings used for calls to getPlaybook. */
    public UnaryCallSettings.Builder<GetPlaybookRequest, Playbook> getPlaybookSettings() {
      return getStubSettingsBuilder().getPlaybookSettings();
    }

    /** Returns the builder for the settings used for calls to updatePlaybook. */
    public UnaryCallSettings.Builder<UpdatePlaybookRequest, Playbook> updatePlaybookSettings() {
      return getStubSettingsBuilder().updatePlaybookSettings();
    }

    /** Returns the builder for the settings used for calls to createPlaybookVersion. */
    public UnaryCallSettings.Builder<CreatePlaybookVersionRequest, PlaybookVersion>
        createPlaybookVersionSettings() {
      return getStubSettingsBuilder().createPlaybookVersionSettings();
    }

    /** Returns the builder for the settings used for calls to getPlaybookVersion. */
    public UnaryCallSettings.Builder<GetPlaybookVersionRequest, PlaybookVersion>
        getPlaybookVersionSettings() {
      return getStubSettingsBuilder().getPlaybookVersionSettings();
    }

    /** Returns the builder for the settings used for calls to listPlaybookVersions. */
    public PagedCallSettings.Builder<
            ListPlaybookVersionsRequest,
            ListPlaybookVersionsResponse,
            ListPlaybookVersionsPagedResponse>
        listPlaybookVersionsSettings() {
      return getStubSettingsBuilder().listPlaybookVersionsSettings();
    }

    /** Returns the builder for the settings used for calls to deletePlaybookVersion. */
    public UnaryCallSettings.Builder<DeletePlaybookVersionRequest, Empty>
        deletePlaybookVersionSettings() {
      return getStubSettingsBuilder().deletePlaybookVersionSettings();
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
    public PlaybooksSettings build() throws IOException {
      return new PlaybooksSettings(this);
    }
  }
}
