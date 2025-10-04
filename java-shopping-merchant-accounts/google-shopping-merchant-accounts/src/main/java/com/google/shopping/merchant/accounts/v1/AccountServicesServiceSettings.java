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

package com.google.shopping.merchant.accounts.v1;

import static com.google.shopping.merchant.accounts.v1.AccountServicesServiceClient.ListAccountServicesPagedResponse;

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
import com.google.protobuf.Empty;
import com.google.shopping.merchant.accounts.v1.stub.AccountServicesServiceStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AccountServicesServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (merchantapi.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getAccountService:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AccountServicesServiceSettings.Builder accountServicesServiceSettingsBuilder =
 *     AccountServicesServiceSettings.newBuilder();
 * accountServicesServiceSettingsBuilder
 *     .getAccountServiceSettings()
 *     .setRetrySettings(
 *         accountServicesServiceSettingsBuilder
 *             .getAccountServiceSettings()
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
 * AccountServicesServiceSettings accountServicesServiceSettings =
 *     accountServicesServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class AccountServicesServiceSettings extends ClientSettings<AccountServicesServiceSettings> {

  /** Returns the object with the settings used for calls to getAccountService. */
  public UnaryCallSettings<GetAccountServiceRequest, AccountService> getAccountServiceSettings() {
    return ((AccountServicesServiceStubSettings) getStubSettings()).getAccountServiceSettings();
  }

  /** Returns the object with the settings used for calls to listAccountServices. */
  public PagedCallSettings<
          ListAccountServicesRequest, ListAccountServicesResponse, ListAccountServicesPagedResponse>
      listAccountServicesSettings() {
    return ((AccountServicesServiceStubSettings) getStubSettings()).listAccountServicesSettings();
  }

  /** Returns the object with the settings used for calls to proposeAccountService. */
  public UnaryCallSettings<ProposeAccountServiceRequest, AccountService>
      proposeAccountServiceSettings() {
    return ((AccountServicesServiceStubSettings) getStubSettings()).proposeAccountServiceSettings();
  }

  /** Returns the object with the settings used for calls to approveAccountService. */
  public UnaryCallSettings<ApproveAccountServiceRequest, AccountService>
      approveAccountServiceSettings() {
    return ((AccountServicesServiceStubSettings) getStubSettings()).approveAccountServiceSettings();
  }

  /** Returns the object with the settings used for calls to rejectAccountService. */
  public UnaryCallSettings<RejectAccountServiceRequest, Empty> rejectAccountServiceSettings() {
    return ((AccountServicesServiceStubSettings) getStubSettings()).rejectAccountServiceSettings();
  }

  public static final AccountServicesServiceSettings create(AccountServicesServiceStubSettings stub)
      throws IOException {
    return new AccountServicesServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return AccountServicesServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return AccountServicesServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return AccountServicesServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return AccountServicesServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return AccountServicesServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return AccountServicesServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return AccountServicesServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AccountServicesServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected AccountServicesServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for AccountServicesServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<AccountServicesServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(AccountServicesServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(AccountServicesServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(AccountServicesServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(AccountServicesServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(AccountServicesServiceStubSettings.newHttpJsonBuilder());
    }

    public AccountServicesServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((AccountServicesServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getAccountService. */
    public UnaryCallSettings.Builder<GetAccountServiceRequest, AccountService>
        getAccountServiceSettings() {
      return getStubSettingsBuilder().getAccountServiceSettings();
    }

    /** Returns the builder for the settings used for calls to listAccountServices. */
    public PagedCallSettings.Builder<
            ListAccountServicesRequest,
            ListAccountServicesResponse,
            ListAccountServicesPagedResponse>
        listAccountServicesSettings() {
      return getStubSettingsBuilder().listAccountServicesSettings();
    }

    /** Returns the builder for the settings used for calls to proposeAccountService. */
    public UnaryCallSettings.Builder<ProposeAccountServiceRequest, AccountService>
        proposeAccountServiceSettings() {
      return getStubSettingsBuilder().proposeAccountServiceSettings();
    }

    /** Returns the builder for the settings used for calls to approveAccountService. */
    public UnaryCallSettings.Builder<ApproveAccountServiceRequest, AccountService>
        approveAccountServiceSettings() {
      return getStubSettingsBuilder().approveAccountServiceSettings();
    }

    /** Returns the builder for the settings used for calls to rejectAccountService. */
    public UnaryCallSettings.Builder<RejectAccountServiceRequest, Empty>
        rejectAccountServiceSettings() {
      return getStubSettingsBuilder().rejectAccountServiceSettings();
    }

    @Override
    public AccountServicesServiceSettings build() throws IOException {
      return new AccountServicesServiceSettings(this);
    }
  }
}
