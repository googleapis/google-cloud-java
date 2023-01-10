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

package com.google.api.apikeys.v2;

import static com.google.api.apikeys.v2.ApiKeysClient.ListKeysPagedResponse;

import com.google.api.apikeys.v2.stub.ApiKeysStubSettings;
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
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ApiKeysClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (apikeys.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getKey to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ApiKeysSettings.Builder apiKeysSettingsBuilder = ApiKeysSettings.newBuilder();
 * apiKeysSettingsBuilder
 *     .getKeySettings()
 *     .setRetrySettings(
 *         apiKeysSettingsBuilder
 *             .getKeySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ApiKeysSettings apiKeysSettings = apiKeysSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ApiKeysSettings extends ClientSettings<ApiKeysSettings> {

  /** Returns the object with the settings used for calls to createKey. */
  public UnaryCallSettings<CreateKeyRequest, Operation> createKeySettings() {
    return ((ApiKeysStubSettings) getStubSettings()).createKeySettings();
  }

  /** Returns the object with the settings used for calls to createKey. */
  public OperationCallSettings<CreateKeyRequest, Key, Empty> createKeyOperationSettings() {
    return ((ApiKeysStubSettings) getStubSettings()).createKeyOperationSettings();
  }

  /** Returns the object with the settings used for calls to listKeys. */
  public PagedCallSettings<ListKeysRequest, ListKeysResponse, ListKeysPagedResponse>
      listKeysSettings() {
    return ((ApiKeysStubSettings) getStubSettings()).listKeysSettings();
  }

  /** Returns the object with the settings used for calls to getKey. */
  public UnaryCallSettings<GetKeyRequest, Key> getKeySettings() {
    return ((ApiKeysStubSettings) getStubSettings()).getKeySettings();
  }

  /** Returns the object with the settings used for calls to getKeyString. */
  public UnaryCallSettings<GetKeyStringRequest, GetKeyStringResponse> getKeyStringSettings() {
    return ((ApiKeysStubSettings) getStubSettings()).getKeyStringSettings();
  }

  /** Returns the object with the settings used for calls to updateKey. */
  public UnaryCallSettings<UpdateKeyRequest, Operation> updateKeySettings() {
    return ((ApiKeysStubSettings) getStubSettings()).updateKeySettings();
  }

  /** Returns the object with the settings used for calls to updateKey. */
  public OperationCallSettings<UpdateKeyRequest, Key, Empty> updateKeyOperationSettings() {
    return ((ApiKeysStubSettings) getStubSettings()).updateKeyOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteKey. */
  public UnaryCallSettings<DeleteKeyRequest, Operation> deleteKeySettings() {
    return ((ApiKeysStubSettings) getStubSettings()).deleteKeySettings();
  }

  /** Returns the object with the settings used for calls to deleteKey. */
  public OperationCallSettings<DeleteKeyRequest, Key, Empty> deleteKeyOperationSettings() {
    return ((ApiKeysStubSettings) getStubSettings()).deleteKeyOperationSettings();
  }

  /** Returns the object with the settings used for calls to undeleteKey. */
  public UnaryCallSettings<UndeleteKeyRequest, Operation> undeleteKeySettings() {
    return ((ApiKeysStubSettings) getStubSettings()).undeleteKeySettings();
  }

  /** Returns the object with the settings used for calls to undeleteKey. */
  public OperationCallSettings<UndeleteKeyRequest, Key, Empty> undeleteKeyOperationSettings() {
    return ((ApiKeysStubSettings) getStubSettings()).undeleteKeyOperationSettings();
  }

  /** Returns the object with the settings used for calls to lookupKey. */
  public UnaryCallSettings<LookupKeyRequest, LookupKeyResponse> lookupKeySettings() {
    return ((ApiKeysStubSettings) getStubSettings()).lookupKeySettings();
  }

  public static final ApiKeysSettings create(ApiKeysStubSettings stub) throws IOException {
    return new ApiKeysSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ApiKeysStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ApiKeysStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ApiKeysStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ApiKeysStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ApiKeysStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ApiKeysStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ApiKeysStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiKeysStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ApiKeysSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ApiKeysSettings. */
  public static class Builder extends ClientSettings.Builder<ApiKeysSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ApiKeysStubSettings.newBuilder(clientContext));
    }

    protected Builder(ApiKeysSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ApiKeysStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ApiKeysStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(ApiKeysStubSettings.newHttpJsonBuilder());
    }

    public ApiKeysStubSettings.Builder getStubSettingsBuilder() {
      return ((ApiKeysStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createKey. */
    public UnaryCallSettings.Builder<CreateKeyRequest, Operation> createKeySettings() {
      return getStubSettingsBuilder().createKeySettings();
    }

    /** Returns the builder for the settings used for calls to createKey. */
    public OperationCallSettings.Builder<CreateKeyRequest, Key, Empty>
        createKeyOperationSettings() {
      return getStubSettingsBuilder().createKeyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listKeys. */
    public PagedCallSettings.Builder<ListKeysRequest, ListKeysResponse, ListKeysPagedResponse>
        listKeysSettings() {
      return getStubSettingsBuilder().listKeysSettings();
    }

    /** Returns the builder for the settings used for calls to getKey. */
    public UnaryCallSettings.Builder<GetKeyRequest, Key> getKeySettings() {
      return getStubSettingsBuilder().getKeySettings();
    }

    /** Returns the builder for the settings used for calls to getKeyString. */
    public UnaryCallSettings.Builder<GetKeyStringRequest, GetKeyStringResponse>
        getKeyStringSettings() {
      return getStubSettingsBuilder().getKeyStringSettings();
    }

    /** Returns the builder for the settings used for calls to updateKey. */
    public UnaryCallSettings.Builder<UpdateKeyRequest, Operation> updateKeySettings() {
      return getStubSettingsBuilder().updateKeySettings();
    }

    /** Returns the builder for the settings used for calls to updateKey. */
    public OperationCallSettings.Builder<UpdateKeyRequest, Key, Empty>
        updateKeyOperationSettings() {
      return getStubSettingsBuilder().updateKeyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteKey. */
    public UnaryCallSettings.Builder<DeleteKeyRequest, Operation> deleteKeySettings() {
      return getStubSettingsBuilder().deleteKeySettings();
    }

    /** Returns the builder for the settings used for calls to deleteKey. */
    public OperationCallSettings.Builder<DeleteKeyRequest, Key, Empty>
        deleteKeyOperationSettings() {
      return getStubSettingsBuilder().deleteKeyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to undeleteKey. */
    public UnaryCallSettings.Builder<UndeleteKeyRequest, Operation> undeleteKeySettings() {
      return getStubSettingsBuilder().undeleteKeySettings();
    }

    /** Returns the builder for the settings used for calls to undeleteKey. */
    public OperationCallSettings.Builder<UndeleteKeyRequest, Key, Empty>
        undeleteKeyOperationSettings() {
      return getStubSettingsBuilder().undeleteKeyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to lookupKey. */
    public UnaryCallSettings.Builder<LookupKeyRequest, LookupKeyResponse> lookupKeySettings() {
      return getStubSettingsBuilder().lookupKeySettings();
    }

    @Override
    public ApiKeysSettings build() throws IOException {
      return new ApiKeysSettings(this);
    }
  }
}
