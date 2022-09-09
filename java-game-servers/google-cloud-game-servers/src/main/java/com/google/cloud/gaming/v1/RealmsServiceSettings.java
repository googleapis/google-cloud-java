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

package com.google.cloud.gaming.v1;

import static com.google.cloud.gaming.v1.RealmsServiceClient.ListRealmsPagedResponse;

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
import com.google.cloud.gaming.v1.stub.RealmsServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link RealmsServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (gameservices.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getRealm to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RealmsServiceSettings.Builder realmsServiceSettingsBuilder = RealmsServiceSettings.newBuilder();
 * realmsServiceSettingsBuilder
 *     .getRealmSettings()
 *     .setRetrySettings(
 *         realmsServiceSettingsBuilder.getRealmSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * RealmsServiceSettings realmsServiceSettings = realmsServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class RealmsServiceSettings extends ClientSettings<RealmsServiceSettings> {

  /** Returns the object with the settings used for calls to listRealms. */
  public PagedCallSettings<ListRealmsRequest, ListRealmsResponse, ListRealmsPagedResponse>
      listRealmsSettings() {
    return ((RealmsServiceStubSettings) getStubSettings()).listRealmsSettings();
  }

  /** Returns the object with the settings used for calls to getRealm. */
  public UnaryCallSettings<GetRealmRequest, Realm> getRealmSettings() {
    return ((RealmsServiceStubSettings) getStubSettings()).getRealmSettings();
  }

  /** Returns the object with the settings used for calls to createRealm. */
  public UnaryCallSettings<CreateRealmRequest, Operation> createRealmSettings() {
    return ((RealmsServiceStubSettings) getStubSettings()).createRealmSettings();
  }

  /** Returns the object with the settings used for calls to createRealm. */
  public OperationCallSettings<CreateRealmRequest, Realm, OperationMetadata>
      createRealmOperationSettings() {
    return ((RealmsServiceStubSettings) getStubSettings()).createRealmOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteRealm. */
  public UnaryCallSettings<DeleteRealmRequest, Operation> deleteRealmSettings() {
    return ((RealmsServiceStubSettings) getStubSettings()).deleteRealmSettings();
  }

  /** Returns the object with the settings used for calls to deleteRealm. */
  public OperationCallSettings<DeleteRealmRequest, Empty, OperationMetadata>
      deleteRealmOperationSettings() {
    return ((RealmsServiceStubSettings) getStubSettings()).deleteRealmOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateRealm. */
  public UnaryCallSettings<UpdateRealmRequest, Operation> updateRealmSettings() {
    return ((RealmsServiceStubSettings) getStubSettings()).updateRealmSettings();
  }

  /** Returns the object with the settings used for calls to updateRealm. */
  public OperationCallSettings<UpdateRealmRequest, Realm, OperationMetadata>
      updateRealmOperationSettings() {
    return ((RealmsServiceStubSettings) getStubSettings()).updateRealmOperationSettings();
  }

  /** Returns the object with the settings used for calls to previewRealmUpdate. */
  public UnaryCallSettings<PreviewRealmUpdateRequest, PreviewRealmUpdateResponse>
      previewRealmUpdateSettings() {
    return ((RealmsServiceStubSettings) getStubSettings()).previewRealmUpdateSettings();
  }

  public static final RealmsServiceSettings create(RealmsServiceStubSettings stub)
      throws IOException {
    return new RealmsServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return RealmsServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return RealmsServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return RealmsServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return RealmsServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return RealmsServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return RealmsServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return RealmsServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RealmsServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected RealmsServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for RealmsServiceSettings. */
  public static class Builder extends ClientSettings.Builder<RealmsServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(RealmsServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(RealmsServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(RealmsServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(RealmsServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(RealmsServiceStubSettings.newHttpJsonBuilder());
    }

    public RealmsServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((RealmsServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listRealms. */
    public PagedCallSettings.Builder<ListRealmsRequest, ListRealmsResponse, ListRealmsPagedResponse>
        listRealmsSettings() {
      return getStubSettingsBuilder().listRealmsSettings();
    }

    /** Returns the builder for the settings used for calls to getRealm. */
    public UnaryCallSettings.Builder<GetRealmRequest, Realm> getRealmSettings() {
      return getStubSettingsBuilder().getRealmSettings();
    }

    /** Returns the builder for the settings used for calls to createRealm. */
    public UnaryCallSettings.Builder<CreateRealmRequest, Operation> createRealmSettings() {
      return getStubSettingsBuilder().createRealmSettings();
    }

    /** Returns the builder for the settings used for calls to createRealm. */
    public OperationCallSettings.Builder<CreateRealmRequest, Realm, OperationMetadata>
        createRealmOperationSettings() {
      return getStubSettingsBuilder().createRealmOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRealm. */
    public UnaryCallSettings.Builder<DeleteRealmRequest, Operation> deleteRealmSettings() {
      return getStubSettingsBuilder().deleteRealmSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRealm. */
    public OperationCallSettings.Builder<DeleteRealmRequest, Empty, OperationMetadata>
        deleteRealmOperationSettings() {
      return getStubSettingsBuilder().deleteRealmOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateRealm. */
    public UnaryCallSettings.Builder<UpdateRealmRequest, Operation> updateRealmSettings() {
      return getStubSettingsBuilder().updateRealmSettings();
    }

    /** Returns the builder for the settings used for calls to updateRealm. */
    public OperationCallSettings.Builder<UpdateRealmRequest, Realm, OperationMetadata>
        updateRealmOperationSettings() {
      return getStubSettingsBuilder().updateRealmOperationSettings();
    }

    /** Returns the builder for the settings used for calls to previewRealmUpdate. */
    public UnaryCallSettings.Builder<PreviewRealmUpdateRequest, PreviewRealmUpdateResponse>
        previewRealmUpdateSettings() {
      return getStubSettingsBuilder().previewRealmUpdateSettings();
    }

    @Override
    public RealmsServiceSettings build() throws IOException {
      return new RealmsServiceSettings(this);
    }
  }
}
