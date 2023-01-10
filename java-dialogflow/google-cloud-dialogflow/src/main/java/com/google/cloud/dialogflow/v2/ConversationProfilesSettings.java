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

package com.google.cloud.dialogflow.v2;

import static com.google.cloud.dialogflow.v2.ConversationProfilesClient.ListConversationProfilesPagedResponse;
import static com.google.cloud.dialogflow.v2.ConversationProfilesClient.ListLocationsPagedResponse;

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
import com.google.cloud.dialogflow.v2.stub.ConversationProfilesStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ConversationProfilesClient}.
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
 * <p>For example, to set the total timeout of getConversationProfile to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ConversationProfilesSettings.Builder conversationProfilesSettingsBuilder =
 *     ConversationProfilesSettings.newBuilder();
 * conversationProfilesSettingsBuilder
 *     .getConversationProfileSettings()
 *     .setRetrySettings(
 *         conversationProfilesSettingsBuilder
 *             .getConversationProfileSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ConversationProfilesSettings conversationProfilesSettings =
 *     conversationProfilesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ConversationProfilesSettings extends ClientSettings<ConversationProfilesSettings> {

  /** Returns the object with the settings used for calls to listConversationProfiles. */
  public PagedCallSettings<
          ListConversationProfilesRequest,
          ListConversationProfilesResponse,
          ListConversationProfilesPagedResponse>
      listConversationProfilesSettings() {
    return ((ConversationProfilesStubSettings) getStubSettings())
        .listConversationProfilesSettings();
  }

  /** Returns the object with the settings used for calls to getConversationProfile. */
  public UnaryCallSettings<GetConversationProfileRequest, ConversationProfile>
      getConversationProfileSettings() {
    return ((ConversationProfilesStubSettings) getStubSettings()).getConversationProfileSettings();
  }

  /** Returns the object with the settings used for calls to createConversationProfile. */
  public UnaryCallSettings<CreateConversationProfileRequest, ConversationProfile>
      createConversationProfileSettings() {
    return ((ConversationProfilesStubSettings) getStubSettings())
        .createConversationProfileSettings();
  }

  /** Returns the object with the settings used for calls to updateConversationProfile. */
  public UnaryCallSettings<UpdateConversationProfileRequest, ConversationProfile>
      updateConversationProfileSettings() {
    return ((ConversationProfilesStubSettings) getStubSettings())
        .updateConversationProfileSettings();
  }

  /** Returns the object with the settings used for calls to deleteConversationProfile. */
  public UnaryCallSettings<DeleteConversationProfileRequest, Empty>
      deleteConversationProfileSettings() {
    return ((ConversationProfilesStubSettings) getStubSettings())
        .deleteConversationProfileSettings();
  }

  /** Returns the object with the settings used for calls to setSuggestionFeatureConfig. */
  public UnaryCallSettings<SetSuggestionFeatureConfigRequest, Operation>
      setSuggestionFeatureConfigSettings() {
    return ((ConversationProfilesStubSettings) getStubSettings())
        .setSuggestionFeatureConfigSettings();
  }

  /** Returns the object with the settings used for calls to setSuggestionFeatureConfig. */
  public OperationCallSettings<
          SetSuggestionFeatureConfigRequest,
          ConversationProfile,
          SetSuggestionFeatureConfigOperationMetadata>
      setSuggestionFeatureConfigOperationSettings() {
    return ((ConversationProfilesStubSettings) getStubSettings())
        .setSuggestionFeatureConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to clearSuggestionFeatureConfig. */
  public UnaryCallSettings<ClearSuggestionFeatureConfigRequest, Operation>
      clearSuggestionFeatureConfigSettings() {
    return ((ConversationProfilesStubSettings) getStubSettings())
        .clearSuggestionFeatureConfigSettings();
  }

  /** Returns the object with the settings used for calls to clearSuggestionFeatureConfig. */
  public OperationCallSettings<
          ClearSuggestionFeatureConfigRequest,
          ConversationProfile,
          ClearSuggestionFeatureConfigOperationMetadata>
      clearSuggestionFeatureConfigOperationSettings() {
    return ((ConversationProfilesStubSettings) getStubSettings())
        .clearSuggestionFeatureConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((ConversationProfilesStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((ConversationProfilesStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final ConversationProfilesSettings create(ConversationProfilesStubSettings stub)
      throws IOException {
    return new ConversationProfilesSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ConversationProfilesStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ConversationProfilesStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ConversationProfilesStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ConversationProfilesStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ConversationProfilesStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ConversationProfilesStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ConversationProfilesStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ConversationProfilesStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ConversationProfilesSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ConversationProfilesSettings. */
  public static class Builder
      extends ClientSettings.Builder<ConversationProfilesSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ConversationProfilesStubSettings.newBuilder(clientContext));
    }

    protected Builder(ConversationProfilesSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ConversationProfilesStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ConversationProfilesStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(ConversationProfilesStubSettings.newHttpJsonBuilder());
    }

    public ConversationProfilesStubSettings.Builder getStubSettingsBuilder() {
      return ((ConversationProfilesStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listConversationProfiles. */
    public PagedCallSettings.Builder<
            ListConversationProfilesRequest,
            ListConversationProfilesResponse,
            ListConversationProfilesPagedResponse>
        listConversationProfilesSettings() {
      return getStubSettingsBuilder().listConversationProfilesSettings();
    }

    /** Returns the builder for the settings used for calls to getConversationProfile. */
    public UnaryCallSettings.Builder<GetConversationProfileRequest, ConversationProfile>
        getConversationProfileSettings() {
      return getStubSettingsBuilder().getConversationProfileSettings();
    }

    /** Returns the builder for the settings used for calls to createConversationProfile. */
    public UnaryCallSettings.Builder<CreateConversationProfileRequest, ConversationProfile>
        createConversationProfileSettings() {
      return getStubSettingsBuilder().createConversationProfileSettings();
    }

    /** Returns the builder for the settings used for calls to updateConversationProfile. */
    public UnaryCallSettings.Builder<UpdateConversationProfileRequest, ConversationProfile>
        updateConversationProfileSettings() {
      return getStubSettingsBuilder().updateConversationProfileSettings();
    }

    /** Returns the builder for the settings used for calls to deleteConversationProfile. */
    public UnaryCallSettings.Builder<DeleteConversationProfileRequest, Empty>
        deleteConversationProfileSettings() {
      return getStubSettingsBuilder().deleteConversationProfileSettings();
    }

    /** Returns the builder for the settings used for calls to setSuggestionFeatureConfig. */
    public UnaryCallSettings.Builder<SetSuggestionFeatureConfigRequest, Operation>
        setSuggestionFeatureConfigSettings() {
      return getStubSettingsBuilder().setSuggestionFeatureConfigSettings();
    }

    /** Returns the builder for the settings used for calls to setSuggestionFeatureConfig. */
    public OperationCallSettings.Builder<
            SetSuggestionFeatureConfigRequest,
            ConversationProfile,
            SetSuggestionFeatureConfigOperationMetadata>
        setSuggestionFeatureConfigOperationSettings() {
      return getStubSettingsBuilder().setSuggestionFeatureConfigOperationSettings();
    }

    /** Returns the builder for the settings used for calls to clearSuggestionFeatureConfig. */
    public UnaryCallSettings.Builder<ClearSuggestionFeatureConfigRequest, Operation>
        clearSuggestionFeatureConfigSettings() {
      return getStubSettingsBuilder().clearSuggestionFeatureConfigSettings();
    }

    /** Returns the builder for the settings used for calls to clearSuggestionFeatureConfig. */
    public OperationCallSettings.Builder<
            ClearSuggestionFeatureConfigRequest,
            ConversationProfile,
            ClearSuggestionFeatureConfigOperationMetadata>
        clearSuggestionFeatureConfigOperationSettings() {
      return getStubSettingsBuilder().clearSuggestionFeatureConfigOperationSettings();
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
    public ConversationProfilesSettings build() throws IOException {
      return new ConversationProfilesSettings(this);
    }
  }
}
