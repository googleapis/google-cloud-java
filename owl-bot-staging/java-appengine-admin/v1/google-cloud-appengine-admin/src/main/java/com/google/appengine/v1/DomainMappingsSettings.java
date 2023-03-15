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

package com.google.appengine.v1;

import static com.google.appengine.v1.DomainMappingsClient.ListDomainMappingsPagedResponse;

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
import com.google.appengine.v1.stub.DomainMappingsStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DomainMappingsClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (appengine.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getDomainMapping to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DomainMappingsSettings.Builder domainMappingsSettingsBuilder =
 *     DomainMappingsSettings.newBuilder();
 * domainMappingsSettingsBuilder
 *     .getDomainMappingSettings()
 *     .setRetrySettings(
 *         domainMappingsSettingsBuilder
 *             .getDomainMappingSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DomainMappingsSettings domainMappingsSettings = domainMappingsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DomainMappingsSettings extends ClientSettings<DomainMappingsSettings> {

  /** Returns the object with the settings used for calls to listDomainMappings. */
  public PagedCallSettings<
          ListDomainMappingsRequest, ListDomainMappingsResponse, ListDomainMappingsPagedResponse>
      listDomainMappingsSettings() {
    return ((DomainMappingsStubSettings) getStubSettings()).listDomainMappingsSettings();
  }

  /** Returns the object with the settings used for calls to getDomainMapping. */
  public UnaryCallSettings<GetDomainMappingRequest, DomainMapping> getDomainMappingSettings() {
    return ((DomainMappingsStubSettings) getStubSettings()).getDomainMappingSettings();
  }

  /** Returns the object with the settings used for calls to createDomainMapping. */
  public UnaryCallSettings<CreateDomainMappingRequest, Operation> createDomainMappingSettings() {
    return ((DomainMappingsStubSettings) getStubSettings()).createDomainMappingSettings();
  }

  /** Returns the object with the settings used for calls to createDomainMapping. */
  public OperationCallSettings<CreateDomainMappingRequest, DomainMapping, OperationMetadataV1>
      createDomainMappingOperationSettings() {
    return ((DomainMappingsStubSettings) getStubSettings()).createDomainMappingOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateDomainMapping. */
  public UnaryCallSettings<UpdateDomainMappingRequest, Operation> updateDomainMappingSettings() {
    return ((DomainMappingsStubSettings) getStubSettings()).updateDomainMappingSettings();
  }

  /** Returns the object with the settings used for calls to updateDomainMapping. */
  public OperationCallSettings<UpdateDomainMappingRequest, DomainMapping, OperationMetadataV1>
      updateDomainMappingOperationSettings() {
    return ((DomainMappingsStubSettings) getStubSettings()).updateDomainMappingOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteDomainMapping. */
  public UnaryCallSettings<DeleteDomainMappingRequest, Operation> deleteDomainMappingSettings() {
    return ((DomainMappingsStubSettings) getStubSettings()).deleteDomainMappingSettings();
  }

  /** Returns the object with the settings used for calls to deleteDomainMapping. */
  public OperationCallSettings<DeleteDomainMappingRequest, Empty, OperationMetadataV1>
      deleteDomainMappingOperationSettings() {
    return ((DomainMappingsStubSettings) getStubSettings()).deleteDomainMappingOperationSettings();
  }

  public static final DomainMappingsSettings create(DomainMappingsStubSettings stub)
      throws IOException {
    return new DomainMappingsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DomainMappingsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DomainMappingsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DomainMappingsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DomainMappingsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DomainMappingsStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return DomainMappingsStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DomainMappingsStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DomainMappingsStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DomainMappingsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DomainMappingsSettings. */
  public static class Builder extends ClientSettings.Builder<DomainMappingsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DomainMappingsStubSettings.newBuilder(clientContext));
    }

    protected Builder(DomainMappingsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DomainMappingsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DomainMappingsStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(DomainMappingsStubSettings.newHttpJsonBuilder());
    }

    public DomainMappingsStubSettings.Builder getStubSettingsBuilder() {
      return ((DomainMappingsStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listDomainMappings. */
    public PagedCallSettings.Builder<
            ListDomainMappingsRequest, ListDomainMappingsResponse, ListDomainMappingsPagedResponse>
        listDomainMappingsSettings() {
      return getStubSettingsBuilder().listDomainMappingsSettings();
    }

    /** Returns the builder for the settings used for calls to getDomainMapping. */
    public UnaryCallSettings.Builder<GetDomainMappingRequest, DomainMapping>
        getDomainMappingSettings() {
      return getStubSettingsBuilder().getDomainMappingSettings();
    }

    /** Returns the builder for the settings used for calls to createDomainMapping. */
    public UnaryCallSettings.Builder<CreateDomainMappingRequest, Operation>
        createDomainMappingSettings() {
      return getStubSettingsBuilder().createDomainMappingSettings();
    }

    /** Returns the builder for the settings used for calls to createDomainMapping. */
    public OperationCallSettings.Builder<
            CreateDomainMappingRequest, DomainMapping, OperationMetadataV1>
        createDomainMappingOperationSettings() {
      return getStubSettingsBuilder().createDomainMappingOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateDomainMapping. */
    public UnaryCallSettings.Builder<UpdateDomainMappingRequest, Operation>
        updateDomainMappingSettings() {
      return getStubSettingsBuilder().updateDomainMappingSettings();
    }

    /** Returns the builder for the settings used for calls to updateDomainMapping. */
    public OperationCallSettings.Builder<
            UpdateDomainMappingRequest, DomainMapping, OperationMetadataV1>
        updateDomainMappingOperationSettings() {
      return getStubSettingsBuilder().updateDomainMappingOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDomainMapping. */
    public UnaryCallSettings.Builder<DeleteDomainMappingRequest, Operation>
        deleteDomainMappingSettings() {
      return getStubSettingsBuilder().deleteDomainMappingSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDomainMapping. */
    public OperationCallSettings.Builder<DeleteDomainMappingRequest, Empty, OperationMetadataV1>
        deleteDomainMappingOperationSettings() {
      return getStubSettingsBuilder().deleteDomainMappingOperationSettings();
    }

    @Override
    public DomainMappingsSettings build() throws IOException {
      return new DomainMappingsSettings(this);
    }
  }
}
