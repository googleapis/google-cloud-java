/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.secretmanager.v1beta1;

import static com.google.cloud.secretmanager.v1beta1.SecretManagerServiceClient.ListSecretVersionsPagedResponse;
import static com.google.cloud.secretmanager.v1beta1.SecretManagerServiceClient.ListSecretsPagedResponse;

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
import com.google.cloud.secretmanager.v1beta1.stub.SecretManagerServiceStubSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SecretManagerServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (secretmanager.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of createSecret:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SecretManagerServiceSettings.Builder secretManagerServiceSettingsBuilder =
 *     SecretManagerServiceSettings.newBuilder();
 * secretManagerServiceSettingsBuilder
 *     .createSecretSettings()
 *     .setRetrySettings(
 *         secretManagerServiceSettingsBuilder
 *             .createSecretSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * SecretManagerServiceSettings secretManagerServiceSettings =
 *     secretManagerServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class SecretManagerServiceSettings extends ClientSettings<SecretManagerServiceSettings> {

  /** Returns the object with the settings used for calls to listSecrets. */
  public PagedCallSettings<ListSecretsRequest, ListSecretsResponse, ListSecretsPagedResponse>
      listSecretsSettings() {
    return ((SecretManagerServiceStubSettings) getStubSettings()).listSecretsSettings();
  }

  /** Returns the object with the settings used for calls to createSecret. */
  public UnaryCallSettings<CreateSecretRequest, Secret> createSecretSettings() {
    return ((SecretManagerServiceStubSettings) getStubSettings()).createSecretSettings();
  }

  /** Returns the object with the settings used for calls to addSecretVersion. */
  public UnaryCallSettings<AddSecretVersionRequest, SecretVersion> addSecretVersionSettings() {
    return ((SecretManagerServiceStubSettings) getStubSettings()).addSecretVersionSettings();
  }

  /** Returns the object with the settings used for calls to getSecret. */
  public UnaryCallSettings<GetSecretRequest, Secret> getSecretSettings() {
    return ((SecretManagerServiceStubSettings) getStubSettings()).getSecretSettings();
  }

  /** Returns the object with the settings used for calls to updateSecret. */
  public UnaryCallSettings<UpdateSecretRequest, Secret> updateSecretSettings() {
    return ((SecretManagerServiceStubSettings) getStubSettings()).updateSecretSettings();
  }

  /** Returns the object with the settings used for calls to deleteSecret. */
  public UnaryCallSettings<DeleteSecretRequest, Empty> deleteSecretSettings() {
    return ((SecretManagerServiceStubSettings) getStubSettings()).deleteSecretSettings();
  }

  /** Returns the object with the settings used for calls to listSecretVersions. */
  public PagedCallSettings<
          ListSecretVersionsRequest, ListSecretVersionsResponse, ListSecretVersionsPagedResponse>
      listSecretVersionsSettings() {
    return ((SecretManagerServiceStubSettings) getStubSettings()).listSecretVersionsSettings();
  }

  /** Returns the object with the settings used for calls to getSecretVersion. */
  public UnaryCallSettings<GetSecretVersionRequest, SecretVersion> getSecretVersionSettings() {
    return ((SecretManagerServiceStubSettings) getStubSettings()).getSecretVersionSettings();
  }

  /** Returns the object with the settings used for calls to accessSecretVersion. */
  public UnaryCallSettings<AccessSecretVersionRequest, AccessSecretVersionResponse>
      accessSecretVersionSettings() {
    return ((SecretManagerServiceStubSettings) getStubSettings()).accessSecretVersionSettings();
  }

  /** Returns the object with the settings used for calls to disableSecretVersion. */
  public UnaryCallSettings<DisableSecretVersionRequest, SecretVersion>
      disableSecretVersionSettings() {
    return ((SecretManagerServiceStubSettings) getStubSettings()).disableSecretVersionSettings();
  }

  /** Returns the object with the settings used for calls to enableSecretVersion. */
  public UnaryCallSettings<EnableSecretVersionRequest, SecretVersion>
      enableSecretVersionSettings() {
    return ((SecretManagerServiceStubSettings) getStubSettings()).enableSecretVersionSettings();
  }

  /** Returns the object with the settings used for calls to destroySecretVersion. */
  public UnaryCallSettings<DestroySecretVersionRequest, SecretVersion>
      destroySecretVersionSettings() {
    return ((SecretManagerServiceStubSettings) getStubSettings()).destroySecretVersionSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((SecretManagerServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((SecretManagerServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((SecretManagerServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final SecretManagerServiceSettings create(SecretManagerServiceStubSettings stub)
      throws IOException {
    return new SecretManagerServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return SecretManagerServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return SecretManagerServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return SecretManagerServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return SecretManagerServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return SecretManagerServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return SecretManagerServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return SecretManagerServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SecretManagerServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected SecretManagerServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for SecretManagerServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<SecretManagerServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(SecretManagerServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(SecretManagerServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(SecretManagerServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(SecretManagerServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(SecretManagerServiceStubSettings.newHttpJsonBuilder());
    }

    public SecretManagerServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((SecretManagerServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listSecrets. */
    public PagedCallSettings.Builder<
            ListSecretsRequest, ListSecretsResponse, ListSecretsPagedResponse>
        listSecretsSettings() {
      return getStubSettingsBuilder().listSecretsSettings();
    }

    /** Returns the builder for the settings used for calls to createSecret. */
    public UnaryCallSettings.Builder<CreateSecretRequest, Secret> createSecretSettings() {
      return getStubSettingsBuilder().createSecretSettings();
    }

    /** Returns the builder for the settings used for calls to addSecretVersion. */
    public UnaryCallSettings.Builder<AddSecretVersionRequest, SecretVersion>
        addSecretVersionSettings() {
      return getStubSettingsBuilder().addSecretVersionSettings();
    }

    /** Returns the builder for the settings used for calls to getSecret. */
    public UnaryCallSettings.Builder<GetSecretRequest, Secret> getSecretSettings() {
      return getStubSettingsBuilder().getSecretSettings();
    }

    /** Returns the builder for the settings used for calls to updateSecret. */
    public UnaryCallSettings.Builder<UpdateSecretRequest, Secret> updateSecretSettings() {
      return getStubSettingsBuilder().updateSecretSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSecret. */
    public UnaryCallSettings.Builder<DeleteSecretRequest, Empty> deleteSecretSettings() {
      return getStubSettingsBuilder().deleteSecretSettings();
    }

    /** Returns the builder for the settings used for calls to listSecretVersions. */
    public PagedCallSettings.Builder<
            ListSecretVersionsRequest, ListSecretVersionsResponse, ListSecretVersionsPagedResponse>
        listSecretVersionsSettings() {
      return getStubSettingsBuilder().listSecretVersionsSettings();
    }

    /** Returns the builder for the settings used for calls to getSecretVersion. */
    public UnaryCallSettings.Builder<GetSecretVersionRequest, SecretVersion>
        getSecretVersionSettings() {
      return getStubSettingsBuilder().getSecretVersionSettings();
    }

    /** Returns the builder for the settings used for calls to accessSecretVersion. */
    public UnaryCallSettings.Builder<AccessSecretVersionRequest, AccessSecretVersionResponse>
        accessSecretVersionSettings() {
      return getStubSettingsBuilder().accessSecretVersionSettings();
    }

    /** Returns the builder for the settings used for calls to disableSecretVersion. */
    public UnaryCallSettings.Builder<DisableSecretVersionRequest, SecretVersion>
        disableSecretVersionSettings() {
      return getStubSettingsBuilder().disableSecretVersionSettings();
    }

    /** Returns the builder for the settings used for calls to enableSecretVersion. */
    public UnaryCallSettings.Builder<EnableSecretVersionRequest, SecretVersion>
        enableSecretVersionSettings() {
      return getStubSettingsBuilder().enableSecretVersionSettings();
    }

    /** Returns the builder for the settings used for calls to destroySecretVersion. */
    public UnaryCallSettings.Builder<DestroySecretVersionRequest, SecretVersion>
        destroySecretVersionSettings() {
      return getStubSettingsBuilder().destroySecretVersionSettings();
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
    public SecretManagerServiceSettings build() throws IOException {
      return new SecretManagerServiceSettings(this);
    }
  }
}
