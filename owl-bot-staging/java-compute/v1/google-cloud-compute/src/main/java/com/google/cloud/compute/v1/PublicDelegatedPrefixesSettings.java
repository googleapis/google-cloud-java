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

package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.PublicDelegatedPrefixesClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.PublicDelegatedPrefixesClient.ListPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.compute.v1.stub.PublicDelegatedPrefixesStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link PublicDelegatedPrefixesClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (compute.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of get to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PublicDelegatedPrefixesSettings.Builder publicDelegatedPrefixesSettingsBuilder =
 *     PublicDelegatedPrefixesSettings.newBuilder();
 * publicDelegatedPrefixesSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         publicDelegatedPrefixesSettingsBuilder.getSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * PublicDelegatedPrefixesSettings publicDelegatedPrefixesSettings =
 *     publicDelegatedPrefixesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class PublicDelegatedPrefixesSettings
    extends ClientSettings<PublicDelegatedPrefixesSettings> {

  /** Returns the object with the settings used for calls to aggregatedList. */
  public PagedCallSettings<
          AggregatedListPublicDelegatedPrefixesRequest,
          PublicDelegatedPrefixAggregatedList,
          AggregatedListPagedResponse>
      aggregatedListSettings() {
    return ((PublicDelegatedPrefixesStubSettings) getStubSettings()).aggregatedListSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeletePublicDelegatedPrefixeRequest, Operation> deleteSettings() {
    return ((PublicDelegatedPrefixesStubSettings) getStubSettings()).deleteSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeletePublicDelegatedPrefixeRequest, Operation, Operation>
      deleteOperationSettings() {
    return ((PublicDelegatedPrefixesStubSettings) getStubSettings()).deleteOperationSettings();
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetPublicDelegatedPrefixeRequest, PublicDelegatedPrefix> getSettings() {
    return ((PublicDelegatedPrefixesStubSettings) getStubSettings()).getSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertPublicDelegatedPrefixeRequest, Operation> insertSettings() {
    return ((PublicDelegatedPrefixesStubSettings) getStubSettings()).insertSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertPublicDelegatedPrefixeRequest, Operation, Operation>
      insertOperationSettings() {
    return ((PublicDelegatedPrefixesStubSettings) getStubSettings()).insertOperationSettings();
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<
          ListPublicDelegatedPrefixesRequest, PublicDelegatedPrefixList, ListPagedResponse>
      listSettings() {
    return ((PublicDelegatedPrefixesStubSettings) getStubSettings()).listSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<PatchPublicDelegatedPrefixeRequest, Operation> patchSettings() {
    return ((PublicDelegatedPrefixesStubSettings) getStubSettings()).patchSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public OperationCallSettings<PatchPublicDelegatedPrefixeRequest, Operation, Operation>
      patchOperationSettings() {
    return ((PublicDelegatedPrefixesStubSettings) getStubSettings()).patchOperationSettings();
  }

  public static final PublicDelegatedPrefixesSettings create(
      PublicDelegatedPrefixesStubSettings stub) throws IOException {
    return new PublicDelegatedPrefixesSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return PublicDelegatedPrefixesStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return PublicDelegatedPrefixesStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return PublicDelegatedPrefixesStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return PublicDelegatedPrefixesStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return PublicDelegatedPrefixesStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return PublicDelegatedPrefixesStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return PublicDelegatedPrefixesStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected PublicDelegatedPrefixesSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for PublicDelegatedPrefixesSettings. */
  public static class Builder
      extends ClientSettings.Builder<PublicDelegatedPrefixesSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(PublicDelegatedPrefixesStubSettings.newBuilder(clientContext));
    }

    protected Builder(PublicDelegatedPrefixesSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(PublicDelegatedPrefixesStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(PublicDelegatedPrefixesStubSettings.newBuilder());
    }

    public PublicDelegatedPrefixesStubSettings.Builder getStubSettingsBuilder() {
      return ((PublicDelegatedPrefixesStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to aggregatedList. */
    public PagedCallSettings.Builder<
            AggregatedListPublicDelegatedPrefixesRequest,
            PublicDelegatedPrefixAggregatedList,
            AggregatedListPagedResponse>
        aggregatedListSettings() {
      return getStubSettingsBuilder().aggregatedListSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeletePublicDelegatedPrefixeRequest, Operation>
        deleteSettings() {
      return getStubSettingsBuilder().deleteSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<DeletePublicDelegatedPrefixeRequest, Operation, Operation>
        deleteOperationSettings() {
      return getStubSettingsBuilder().deleteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetPublicDelegatedPrefixeRequest, PublicDelegatedPrefix>
        getSettings() {
      return getStubSettingsBuilder().getSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertPublicDelegatedPrefixeRequest, Operation>
        insertSettings() {
      return getStubSettingsBuilder().insertSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<InsertPublicDelegatedPrefixeRequest, Operation, Operation>
        insertOperationSettings() {
      return getStubSettingsBuilder().insertOperationSettings();
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListPublicDelegatedPrefixesRequest, PublicDelegatedPrefixList, ListPagedResponse>
        listSettings() {
      return getStubSettingsBuilder().listSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<PatchPublicDelegatedPrefixeRequest, Operation>
        patchSettings() {
      return getStubSettingsBuilder().patchSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public OperationCallSettings.Builder<PatchPublicDelegatedPrefixeRequest, Operation, Operation>
        patchOperationSettings() {
      return getStubSettingsBuilder().patchOperationSettings();
    }

    @Override
    public PublicDelegatedPrefixesSettings build() throws IOException {
      return new PublicDelegatedPrefixesSettings(this);
    }
  }
}
