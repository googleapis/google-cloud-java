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

package com.google.cloud.kms.v1;

import static com.google.cloud.kms.v1.KeyManagementServiceClient.ListCryptoKeyVersionsPagedResponse;
import static com.google.cloud.kms.v1.KeyManagementServiceClient.ListCryptoKeysPagedResponse;
import static com.google.cloud.kms.v1.KeyManagementServiceClient.ListImportJobsPagedResponse;
import static com.google.cloud.kms.v1.KeyManagementServiceClient.ListKeyRingsPagedResponse;
import static com.google.cloud.kms.v1.KeyManagementServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.kms.v1.stub.KeyManagementServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link KeyManagementServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudkms.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getKeyRing to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * KeyManagementServiceSettings.Builder keyManagementServiceSettingsBuilder =
 *     KeyManagementServiceSettings.newBuilder();
 * keyManagementServiceSettingsBuilder
 *     .getKeyRingSettings()
 *     .setRetrySettings(
 *         keyManagementServiceSettingsBuilder.getKeyRingSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * KeyManagementServiceSettings keyManagementServiceSettings =
 *     keyManagementServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class KeyManagementServiceSettings extends ClientSettings<KeyManagementServiceSettings> {

  /** Returns the object with the settings used for calls to listKeyRings. */
  public PagedCallSettings<ListKeyRingsRequest, ListKeyRingsResponse, ListKeyRingsPagedResponse>
      listKeyRingsSettings() {
    return ((KeyManagementServiceStubSettings) getStubSettings()).listKeyRingsSettings();
  }

  /** Returns the object with the settings used for calls to listCryptoKeys. */
  public PagedCallSettings<
          ListCryptoKeysRequest, ListCryptoKeysResponse, ListCryptoKeysPagedResponse>
      listCryptoKeysSettings() {
    return ((KeyManagementServiceStubSettings) getStubSettings()).listCryptoKeysSettings();
  }

  /** Returns the object with the settings used for calls to listCryptoKeyVersions. */
  public PagedCallSettings<
          ListCryptoKeyVersionsRequest,
          ListCryptoKeyVersionsResponse,
          ListCryptoKeyVersionsPagedResponse>
      listCryptoKeyVersionsSettings() {
    return ((KeyManagementServiceStubSettings) getStubSettings()).listCryptoKeyVersionsSettings();
  }

  /** Returns the object with the settings used for calls to listImportJobs. */
  public PagedCallSettings<
          ListImportJobsRequest, ListImportJobsResponse, ListImportJobsPagedResponse>
      listImportJobsSettings() {
    return ((KeyManagementServiceStubSettings) getStubSettings()).listImportJobsSettings();
  }

  /** Returns the object with the settings used for calls to getKeyRing. */
  public UnaryCallSettings<GetKeyRingRequest, KeyRing> getKeyRingSettings() {
    return ((KeyManagementServiceStubSettings) getStubSettings()).getKeyRingSettings();
  }

  /** Returns the object with the settings used for calls to getCryptoKey. */
  public UnaryCallSettings<GetCryptoKeyRequest, CryptoKey> getCryptoKeySettings() {
    return ((KeyManagementServiceStubSettings) getStubSettings()).getCryptoKeySettings();
  }

  /** Returns the object with the settings used for calls to getCryptoKeyVersion. */
  public UnaryCallSettings<GetCryptoKeyVersionRequest, CryptoKeyVersion>
      getCryptoKeyVersionSettings() {
    return ((KeyManagementServiceStubSettings) getStubSettings()).getCryptoKeyVersionSettings();
  }

  /** Returns the object with the settings used for calls to getPublicKey. */
  public UnaryCallSettings<GetPublicKeyRequest, PublicKey> getPublicKeySettings() {
    return ((KeyManagementServiceStubSettings) getStubSettings()).getPublicKeySettings();
  }

  /** Returns the object with the settings used for calls to getImportJob. */
  public UnaryCallSettings<GetImportJobRequest, ImportJob> getImportJobSettings() {
    return ((KeyManagementServiceStubSettings) getStubSettings()).getImportJobSettings();
  }

  /** Returns the object with the settings used for calls to createKeyRing. */
  public UnaryCallSettings<CreateKeyRingRequest, KeyRing> createKeyRingSettings() {
    return ((KeyManagementServiceStubSettings) getStubSettings()).createKeyRingSettings();
  }

  /** Returns the object with the settings used for calls to createCryptoKey. */
  public UnaryCallSettings<CreateCryptoKeyRequest, CryptoKey> createCryptoKeySettings() {
    return ((KeyManagementServiceStubSettings) getStubSettings()).createCryptoKeySettings();
  }

  /** Returns the object with the settings used for calls to createCryptoKeyVersion. */
  public UnaryCallSettings<CreateCryptoKeyVersionRequest, CryptoKeyVersion>
      createCryptoKeyVersionSettings() {
    return ((KeyManagementServiceStubSettings) getStubSettings()).createCryptoKeyVersionSettings();
  }

  /** Returns the object with the settings used for calls to importCryptoKeyVersion. */
  public UnaryCallSettings<ImportCryptoKeyVersionRequest, CryptoKeyVersion>
      importCryptoKeyVersionSettings() {
    return ((KeyManagementServiceStubSettings) getStubSettings()).importCryptoKeyVersionSettings();
  }

  /** Returns the object with the settings used for calls to createImportJob. */
  public UnaryCallSettings<CreateImportJobRequest, ImportJob> createImportJobSettings() {
    return ((KeyManagementServiceStubSettings) getStubSettings()).createImportJobSettings();
  }

  /** Returns the object with the settings used for calls to updateCryptoKey. */
  public UnaryCallSettings<UpdateCryptoKeyRequest, CryptoKey> updateCryptoKeySettings() {
    return ((KeyManagementServiceStubSettings) getStubSettings()).updateCryptoKeySettings();
  }

  /** Returns the object with the settings used for calls to updateCryptoKeyVersion. */
  public UnaryCallSettings<UpdateCryptoKeyVersionRequest, CryptoKeyVersion>
      updateCryptoKeyVersionSettings() {
    return ((KeyManagementServiceStubSettings) getStubSettings()).updateCryptoKeyVersionSettings();
  }

  /** Returns the object with the settings used for calls to updateCryptoKeyPrimaryVersion. */
  public UnaryCallSettings<UpdateCryptoKeyPrimaryVersionRequest, CryptoKey>
      updateCryptoKeyPrimaryVersionSettings() {
    return ((KeyManagementServiceStubSettings) getStubSettings())
        .updateCryptoKeyPrimaryVersionSettings();
  }

  /** Returns the object with the settings used for calls to destroyCryptoKeyVersion. */
  public UnaryCallSettings<DestroyCryptoKeyVersionRequest, CryptoKeyVersion>
      destroyCryptoKeyVersionSettings() {
    return ((KeyManagementServiceStubSettings) getStubSettings()).destroyCryptoKeyVersionSettings();
  }

  /** Returns the object with the settings used for calls to restoreCryptoKeyVersion. */
  public UnaryCallSettings<RestoreCryptoKeyVersionRequest, CryptoKeyVersion>
      restoreCryptoKeyVersionSettings() {
    return ((KeyManagementServiceStubSettings) getStubSettings()).restoreCryptoKeyVersionSettings();
  }

  /** Returns the object with the settings used for calls to encrypt. */
  public UnaryCallSettings<EncryptRequest, EncryptResponse> encryptSettings() {
    return ((KeyManagementServiceStubSettings) getStubSettings()).encryptSettings();
  }

  /** Returns the object with the settings used for calls to decrypt. */
  public UnaryCallSettings<DecryptRequest, DecryptResponse> decryptSettings() {
    return ((KeyManagementServiceStubSettings) getStubSettings()).decryptSettings();
  }

  /** Returns the object with the settings used for calls to asymmetricSign. */
  public UnaryCallSettings<AsymmetricSignRequest, AsymmetricSignResponse> asymmetricSignSettings() {
    return ((KeyManagementServiceStubSettings) getStubSettings()).asymmetricSignSettings();
  }

  /** Returns the object with the settings used for calls to asymmetricDecrypt. */
  public UnaryCallSettings<AsymmetricDecryptRequest, AsymmetricDecryptResponse>
      asymmetricDecryptSettings() {
    return ((KeyManagementServiceStubSettings) getStubSettings()).asymmetricDecryptSettings();
  }

  /** Returns the object with the settings used for calls to macSign. */
  public UnaryCallSettings<MacSignRequest, MacSignResponse> macSignSettings() {
    return ((KeyManagementServiceStubSettings) getStubSettings()).macSignSettings();
  }

  /** Returns the object with the settings used for calls to macVerify. */
  public UnaryCallSettings<MacVerifyRequest, MacVerifyResponse> macVerifySettings() {
    return ((KeyManagementServiceStubSettings) getStubSettings()).macVerifySettings();
  }

  /** Returns the object with the settings used for calls to generateRandomBytes. */
  public UnaryCallSettings<GenerateRandomBytesRequest, GenerateRandomBytesResponse>
      generateRandomBytesSettings() {
    return ((KeyManagementServiceStubSettings) getStubSettings()).generateRandomBytesSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((KeyManagementServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((KeyManagementServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((KeyManagementServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((KeyManagementServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((KeyManagementServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final KeyManagementServiceSettings create(KeyManagementServiceStubSettings stub)
      throws IOException {
    return new KeyManagementServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return KeyManagementServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return KeyManagementServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return KeyManagementServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return KeyManagementServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return KeyManagementServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return KeyManagementServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return KeyManagementServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return KeyManagementServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected KeyManagementServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for KeyManagementServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<KeyManagementServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(KeyManagementServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(KeyManagementServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(KeyManagementServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(KeyManagementServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(KeyManagementServiceStubSettings.newHttpJsonBuilder());
    }

    public KeyManagementServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((KeyManagementServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listKeyRings. */
    public PagedCallSettings.Builder<
            ListKeyRingsRequest, ListKeyRingsResponse, ListKeyRingsPagedResponse>
        listKeyRingsSettings() {
      return getStubSettingsBuilder().listKeyRingsSettings();
    }

    /** Returns the builder for the settings used for calls to listCryptoKeys. */
    public PagedCallSettings.Builder<
            ListCryptoKeysRequest, ListCryptoKeysResponse, ListCryptoKeysPagedResponse>
        listCryptoKeysSettings() {
      return getStubSettingsBuilder().listCryptoKeysSettings();
    }

    /** Returns the builder for the settings used for calls to listCryptoKeyVersions. */
    public PagedCallSettings.Builder<
            ListCryptoKeyVersionsRequest,
            ListCryptoKeyVersionsResponse,
            ListCryptoKeyVersionsPagedResponse>
        listCryptoKeyVersionsSettings() {
      return getStubSettingsBuilder().listCryptoKeyVersionsSettings();
    }

    /** Returns the builder for the settings used for calls to listImportJobs. */
    public PagedCallSettings.Builder<
            ListImportJobsRequest, ListImportJobsResponse, ListImportJobsPagedResponse>
        listImportJobsSettings() {
      return getStubSettingsBuilder().listImportJobsSettings();
    }

    /** Returns the builder for the settings used for calls to getKeyRing. */
    public UnaryCallSettings.Builder<GetKeyRingRequest, KeyRing> getKeyRingSettings() {
      return getStubSettingsBuilder().getKeyRingSettings();
    }

    /** Returns the builder for the settings used for calls to getCryptoKey. */
    public UnaryCallSettings.Builder<GetCryptoKeyRequest, CryptoKey> getCryptoKeySettings() {
      return getStubSettingsBuilder().getCryptoKeySettings();
    }

    /** Returns the builder for the settings used for calls to getCryptoKeyVersion. */
    public UnaryCallSettings.Builder<GetCryptoKeyVersionRequest, CryptoKeyVersion>
        getCryptoKeyVersionSettings() {
      return getStubSettingsBuilder().getCryptoKeyVersionSettings();
    }

    /** Returns the builder for the settings used for calls to getPublicKey. */
    public UnaryCallSettings.Builder<GetPublicKeyRequest, PublicKey> getPublicKeySettings() {
      return getStubSettingsBuilder().getPublicKeySettings();
    }

    /** Returns the builder for the settings used for calls to getImportJob. */
    public UnaryCallSettings.Builder<GetImportJobRequest, ImportJob> getImportJobSettings() {
      return getStubSettingsBuilder().getImportJobSettings();
    }

    /** Returns the builder for the settings used for calls to createKeyRing. */
    public UnaryCallSettings.Builder<CreateKeyRingRequest, KeyRing> createKeyRingSettings() {
      return getStubSettingsBuilder().createKeyRingSettings();
    }

    /** Returns the builder for the settings used for calls to createCryptoKey. */
    public UnaryCallSettings.Builder<CreateCryptoKeyRequest, CryptoKey> createCryptoKeySettings() {
      return getStubSettingsBuilder().createCryptoKeySettings();
    }

    /** Returns the builder for the settings used for calls to createCryptoKeyVersion. */
    public UnaryCallSettings.Builder<CreateCryptoKeyVersionRequest, CryptoKeyVersion>
        createCryptoKeyVersionSettings() {
      return getStubSettingsBuilder().createCryptoKeyVersionSettings();
    }

    /** Returns the builder for the settings used for calls to importCryptoKeyVersion. */
    public UnaryCallSettings.Builder<ImportCryptoKeyVersionRequest, CryptoKeyVersion>
        importCryptoKeyVersionSettings() {
      return getStubSettingsBuilder().importCryptoKeyVersionSettings();
    }

    /** Returns the builder for the settings used for calls to createImportJob. */
    public UnaryCallSettings.Builder<CreateImportJobRequest, ImportJob> createImportJobSettings() {
      return getStubSettingsBuilder().createImportJobSettings();
    }

    /** Returns the builder for the settings used for calls to updateCryptoKey. */
    public UnaryCallSettings.Builder<UpdateCryptoKeyRequest, CryptoKey> updateCryptoKeySettings() {
      return getStubSettingsBuilder().updateCryptoKeySettings();
    }

    /** Returns the builder for the settings used for calls to updateCryptoKeyVersion. */
    public UnaryCallSettings.Builder<UpdateCryptoKeyVersionRequest, CryptoKeyVersion>
        updateCryptoKeyVersionSettings() {
      return getStubSettingsBuilder().updateCryptoKeyVersionSettings();
    }

    /** Returns the builder for the settings used for calls to updateCryptoKeyPrimaryVersion. */
    public UnaryCallSettings.Builder<UpdateCryptoKeyPrimaryVersionRequest, CryptoKey>
        updateCryptoKeyPrimaryVersionSettings() {
      return getStubSettingsBuilder().updateCryptoKeyPrimaryVersionSettings();
    }

    /** Returns the builder for the settings used for calls to destroyCryptoKeyVersion. */
    public UnaryCallSettings.Builder<DestroyCryptoKeyVersionRequest, CryptoKeyVersion>
        destroyCryptoKeyVersionSettings() {
      return getStubSettingsBuilder().destroyCryptoKeyVersionSettings();
    }

    /** Returns the builder for the settings used for calls to restoreCryptoKeyVersion. */
    public UnaryCallSettings.Builder<RestoreCryptoKeyVersionRequest, CryptoKeyVersion>
        restoreCryptoKeyVersionSettings() {
      return getStubSettingsBuilder().restoreCryptoKeyVersionSettings();
    }

    /** Returns the builder for the settings used for calls to encrypt. */
    public UnaryCallSettings.Builder<EncryptRequest, EncryptResponse> encryptSettings() {
      return getStubSettingsBuilder().encryptSettings();
    }

    /** Returns the builder for the settings used for calls to decrypt. */
    public UnaryCallSettings.Builder<DecryptRequest, DecryptResponse> decryptSettings() {
      return getStubSettingsBuilder().decryptSettings();
    }

    /** Returns the builder for the settings used for calls to asymmetricSign. */
    public UnaryCallSettings.Builder<AsymmetricSignRequest, AsymmetricSignResponse>
        asymmetricSignSettings() {
      return getStubSettingsBuilder().asymmetricSignSettings();
    }

    /** Returns the builder for the settings used for calls to asymmetricDecrypt. */
    public UnaryCallSettings.Builder<AsymmetricDecryptRequest, AsymmetricDecryptResponse>
        asymmetricDecryptSettings() {
      return getStubSettingsBuilder().asymmetricDecryptSettings();
    }

    /** Returns the builder for the settings used for calls to macSign. */
    public UnaryCallSettings.Builder<MacSignRequest, MacSignResponse> macSignSettings() {
      return getStubSettingsBuilder().macSignSettings();
    }

    /** Returns the builder for the settings used for calls to macVerify. */
    public UnaryCallSettings.Builder<MacVerifyRequest, MacVerifyResponse> macVerifySettings() {
      return getStubSettingsBuilder().macVerifySettings();
    }

    /** Returns the builder for the settings used for calls to generateRandomBytes. */
    public UnaryCallSettings.Builder<GenerateRandomBytesRequest, GenerateRandomBytesResponse>
        generateRandomBytesSettings() {
      return getStubSettingsBuilder().generateRandomBytesSettings();
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
    public KeyManagementServiceSettings build() throws IOException {
      return new KeyManagementServiceSettings(this);
    }
  }
}
