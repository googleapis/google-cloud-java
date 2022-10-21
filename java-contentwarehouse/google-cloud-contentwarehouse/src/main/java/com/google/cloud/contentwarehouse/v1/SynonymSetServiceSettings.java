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

package com.google.cloud.contentwarehouse.v1;

import static com.google.cloud.contentwarehouse.v1.SynonymSetServiceClient.ListSynonymSetsPagedResponse;

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
import com.google.cloud.contentwarehouse.v1.stub.SynonymSetServiceStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SynonymSetServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (contentwarehouse.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createSynonymSet to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SynonymSetServiceSettings.Builder synonymSetServiceSettingsBuilder =
 *     SynonymSetServiceSettings.newBuilder();
 * synonymSetServiceSettingsBuilder
 *     .createSynonymSetSettings()
 *     .setRetrySettings(
 *         synonymSetServiceSettingsBuilder
 *             .createSynonymSetSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * SynonymSetServiceSettings synonymSetServiceSettings = synonymSetServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class SynonymSetServiceSettings extends ClientSettings<SynonymSetServiceSettings> {

  /** Returns the object with the settings used for calls to createSynonymSet. */
  public UnaryCallSettings<CreateSynonymSetRequest, SynonymSet> createSynonymSetSettings() {
    return ((SynonymSetServiceStubSettings) getStubSettings()).createSynonymSetSettings();
  }

  /** Returns the object with the settings used for calls to getSynonymSet. */
  public UnaryCallSettings<GetSynonymSetRequest, SynonymSet> getSynonymSetSettings() {
    return ((SynonymSetServiceStubSettings) getStubSettings()).getSynonymSetSettings();
  }

  /** Returns the object with the settings used for calls to updateSynonymSet. */
  public UnaryCallSettings<UpdateSynonymSetRequest, SynonymSet> updateSynonymSetSettings() {
    return ((SynonymSetServiceStubSettings) getStubSettings()).updateSynonymSetSettings();
  }

  /** Returns the object with the settings used for calls to deleteSynonymSet. */
  public UnaryCallSettings<DeleteSynonymSetRequest, Empty> deleteSynonymSetSettings() {
    return ((SynonymSetServiceStubSettings) getStubSettings()).deleteSynonymSetSettings();
  }

  /** Returns the object with the settings used for calls to listSynonymSets. */
  public PagedCallSettings<
          ListSynonymSetsRequest, ListSynonymSetsResponse, ListSynonymSetsPagedResponse>
      listSynonymSetsSettings() {
    return ((SynonymSetServiceStubSettings) getStubSettings()).listSynonymSetsSettings();
  }

  public static final SynonymSetServiceSettings create(SynonymSetServiceStubSettings stub)
      throws IOException {
    return new SynonymSetServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return SynonymSetServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return SynonymSetServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return SynonymSetServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return SynonymSetServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return SynonymSetServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return SynonymSetServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return SynonymSetServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SynonymSetServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected SynonymSetServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for SynonymSetServiceSettings. */
  public static class Builder extends ClientSettings.Builder<SynonymSetServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(SynonymSetServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(SynonymSetServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(SynonymSetServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(SynonymSetServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(SynonymSetServiceStubSettings.newHttpJsonBuilder());
    }

    public SynonymSetServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((SynonymSetServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createSynonymSet. */
    public UnaryCallSettings.Builder<CreateSynonymSetRequest, SynonymSet>
        createSynonymSetSettings() {
      return getStubSettingsBuilder().createSynonymSetSettings();
    }

    /** Returns the builder for the settings used for calls to getSynonymSet. */
    public UnaryCallSettings.Builder<GetSynonymSetRequest, SynonymSet> getSynonymSetSettings() {
      return getStubSettingsBuilder().getSynonymSetSettings();
    }

    /** Returns the builder for the settings used for calls to updateSynonymSet. */
    public UnaryCallSettings.Builder<UpdateSynonymSetRequest, SynonymSet>
        updateSynonymSetSettings() {
      return getStubSettingsBuilder().updateSynonymSetSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSynonymSet. */
    public UnaryCallSettings.Builder<DeleteSynonymSetRequest, Empty> deleteSynonymSetSettings() {
      return getStubSettingsBuilder().deleteSynonymSetSettings();
    }

    /** Returns the builder for the settings used for calls to listSynonymSets. */
    public PagedCallSettings.Builder<
            ListSynonymSetsRequest, ListSynonymSetsResponse, ListSynonymSetsPagedResponse>
        listSynonymSetsSettings() {
      return getStubSettingsBuilder().listSynonymSetsSettings();
    }

    @Override
    public SynonymSetServiceSettings build() throws IOException {
      return new SynonymSetServiceSettings(this);
    }
  }
}
