/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.agentidentity.v1beta;

import static com.google.cloud.agentidentity.v1beta.AuthProviderServiceClient.ListAccessSummariesPagedResponse;
import static com.google.cloud.agentidentity.v1beta.AuthProviderServiceClient.ListAuthProvidersPagedResponse;
import static com.google.cloud.agentidentity.v1beta.AuthProviderServiceClient.ListAuthorizationsPagedResponse;
import static com.google.cloud.agentidentity.v1beta.AuthProviderServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.agentidentity.v1beta.AuthProviderServiceClient.QueryAuthProvidersPagedResponse;
import static com.google.cloud.agentidentity.v1beta.AuthProviderServiceClient.QueryWorkloadsPagedResponse;

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
import com.google.cloud.agentidentity.v1beta.stub.AuthProviderServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AuthProviderServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (agentidentity.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getAuthProvider:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AuthProviderServiceSettings.Builder authProviderServiceSettingsBuilder =
 *     AuthProviderServiceSettings.newBuilder();
 * authProviderServiceSettingsBuilder
 *     .getAuthProviderSettings()
 *     .setRetrySettings(
 *         authProviderServiceSettingsBuilder
 *             .getAuthProviderSettings()
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
 * AuthProviderServiceSettings authProviderServiceSettings =
 *     authProviderServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class AuthProviderServiceSettings extends ClientSettings<AuthProviderServiceSettings> {

  /** Returns the object with the settings used for calls to listAuthProviders. */
  public PagedCallSettings<
          ListAuthProvidersRequest, ListAuthProvidersResponse, ListAuthProvidersPagedResponse>
      listAuthProvidersSettings() {
    return ((AuthProviderServiceStubSettings) getStubSettings()).listAuthProvidersSettings();
  }

  /** Returns the object with the settings used for calls to getAuthProvider. */
  public UnaryCallSettings<GetAuthProviderRequest, AuthProvider> getAuthProviderSettings() {
    return ((AuthProviderServiceStubSettings) getStubSettings()).getAuthProviderSettings();
  }

  /** Returns the object with the settings used for calls to createAuthProvider. */
  public UnaryCallSettings<CreateAuthProviderRequest, AuthProvider> createAuthProviderSettings() {
    return ((AuthProviderServiceStubSettings) getStubSettings()).createAuthProviderSettings();
  }

  /** Returns the object with the settings used for calls to updateAuthProvider. */
  public UnaryCallSettings<UpdateAuthProviderRequest, AuthProvider> updateAuthProviderSettings() {
    return ((AuthProviderServiceStubSettings) getStubSettings()).updateAuthProviderSettings();
  }

  /** Returns the object with the settings used for calls to deleteAuthProvider. */
  public UnaryCallSettings<DeleteAuthProviderRequest, Empty> deleteAuthProviderSettings() {
    return ((AuthProviderServiceStubSettings) getStubSettings()).deleteAuthProviderSettings();
  }

  /** Returns the object with the settings used for calls to undeleteAuthProvider. */
  public UnaryCallSettings<UndeleteAuthProviderRequest, AuthProvider>
      undeleteAuthProviderSettings() {
    return ((AuthProviderServiceStubSettings) getStubSettings()).undeleteAuthProviderSettings();
  }

  /** Returns the object with the settings used for calls to queryAuthProviders. */
  public PagedCallSettings<
          QueryAuthProvidersRequest, QueryAuthProvidersResponse, QueryAuthProvidersPagedResponse>
      queryAuthProvidersSettings() {
    return ((AuthProviderServiceStubSettings) getStubSettings()).queryAuthProvidersSettings();
  }

  /** Returns the object with the settings used for calls to queryWorkloads. */
  public PagedCallSettings<
          QueryWorkloadsRequest, QueryWorkloadsResponse, QueryWorkloadsPagedResponse>
      queryWorkloadsSettings() {
    return ((AuthProviderServiceStubSettings) getStubSettings()).queryWorkloadsSettings();
  }

  /** Returns the object with the settings used for calls to listAuthorizations. */
  public PagedCallSettings<
          ListAuthorizationsRequest, ListAuthorizationsResponse, ListAuthorizationsPagedResponse>
      listAuthorizationsSettings() {
    return ((AuthProviderServiceStubSettings) getStubSettings()).listAuthorizationsSettings();
  }

  /** Returns the object with the settings used for calls to getAuthorization. */
  public UnaryCallSettings<GetAuthorizationRequest, Authorization> getAuthorizationSettings() {
    return ((AuthProviderServiceStubSettings) getStubSettings()).getAuthorizationSettings();
  }

  /** Returns the object with the settings used for calls to deleteAuthorization. */
  public UnaryCallSettings<DeleteAuthorizationRequest, Empty> deleteAuthorizationSettings() {
    return ((AuthProviderServiceStubSettings) getStubSettings()).deleteAuthorizationSettings();
  }

  /** Returns the object with the settings used for calls to listAccessSummaries. */
  public PagedCallSettings<
          ListAccessSummariesRequest, ListAccessSummariesResponse, ListAccessSummariesPagedResponse>
      listAccessSummariesSettings() {
    return ((AuthProviderServiceStubSettings) getStubSettings()).listAccessSummariesSettings();
  }

  /** Returns the object with the settings used for calls to getAccessSummary. */
  public UnaryCallSettings<GetAccessSummaryRequest, AccessSummary> getAccessSummarySettings() {
    return ((AuthProviderServiceStubSettings) getStubSettings()).getAccessSummarySettings();
  }

  /** Returns the object with the settings used for calls to revokeAuthorization. */
  public UnaryCallSettings<RevokeAuthorizationRequest, RevokeAuthorizationResponse>
      revokeAuthorizationSettings() {
    return ((AuthProviderServiceStubSettings) getStubSettings()).revokeAuthorizationSettings();
  }

  /** Returns the object with the settings used for calls to enableAuthProvider. */
  public UnaryCallSettings<EnableAuthProviderRequest, AuthProvider> enableAuthProviderSettings() {
    return ((AuthProviderServiceStubSettings) getStubSettings()).enableAuthProviderSettings();
  }

  /** Returns the object with the settings used for calls to disableAuthProvider. */
  public UnaryCallSettings<DisableAuthProviderRequest, AuthProvider> disableAuthProviderSettings() {
    return ((AuthProviderServiceStubSettings) getStubSettings()).disableAuthProviderSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((AuthProviderServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((AuthProviderServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((AuthProviderServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((AuthProviderServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((AuthProviderServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final AuthProviderServiceSettings create(AuthProviderServiceStubSettings stub)
      throws IOException {
    return new AuthProviderServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return AuthProviderServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return AuthProviderServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return AuthProviderServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return AuthProviderServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return AuthProviderServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return AuthProviderServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return AuthProviderServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AuthProviderServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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
  public static Builder newBuilder(@Nullable ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected AuthProviderServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for AuthProviderServiceSettings. */
  public static class Builder extends ClientSettings.Builder<AuthProviderServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(AuthProviderServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(AuthProviderServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(AuthProviderServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(AuthProviderServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(AuthProviderServiceStubSettings.newHttpJsonBuilder());
    }

    public AuthProviderServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((AuthProviderServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listAuthProviders. */
    public PagedCallSettings.Builder<
            ListAuthProvidersRequest, ListAuthProvidersResponse, ListAuthProvidersPagedResponse>
        listAuthProvidersSettings() {
      return getStubSettingsBuilder().listAuthProvidersSettings();
    }

    /** Returns the builder for the settings used for calls to getAuthProvider. */
    public UnaryCallSettings.Builder<GetAuthProviderRequest, AuthProvider>
        getAuthProviderSettings() {
      return getStubSettingsBuilder().getAuthProviderSettings();
    }

    /** Returns the builder for the settings used for calls to createAuthProvider. */
    public UnaryCallSettings.Builder<CreateAuthProviderRequest, AuthProvider>
        createAuthProviderSettings() {
      return getStubSettingsBuilder().createAuthProviderSettings();
    }

    /** Returns the builder for the settings used for calls to updateAuthProvider. */
    public UnaryCallSettings.Builder<UpdateAuthProviderRequest, AuthProvider>
        updateAuthProviderSettings() {
      return getStubSettingsBuilder().updateAuthProviderSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAuthProvider. */
    public UnaryCallSettings.Builder<DeleteAuthProviderRequest, Empty>
        deleteAuthProviderSettings() {
      return getStubSettingsBuilder().deleteAuthProviderSettings();
    }

    /** Returns the builder for the settings used for calls to undeleteAuthProvider. */
    public UnaryCallSettings.Builder<UndeleteAuthProviderRequest, AuthProvider>
        undeleteAuthProviderSettings() {
      return getStubSettingsBuilder().undeleteAuthProviderSettings();
    }

    /** Returns the builder for the settings used for calls to queryAuthProviders. */
    public PagedCallSettings.Builder<
            QueryAuthProvidersRequest, QueryAuthProvidersResponse, QueryAuthProvidersPagedResponse>
        queryAuthProvidersSettings() {
      return getStubSettingsBuilder().queryAuthProvidersSettings();
    }

    /** Returns the builder for the settings used for calls to queryWorkloads. */
    public PagedCallSettings.Builder<
            QueryWorkloadsRequest, QueryWorkloadsResponse, QueryWorkloadsPagedResponse>
        queryWorkloadsSettings() {
      return getStubSettingsBuilder().queryWorkloadsSettings();
    }

    /** Returns the builder for the settings used for calls to listAuthorizations. */
    public PagedCallSettings.Builder<
            ListAuthorizationsRequest, ListAuthorizationsResponse, ListAuthorizationsPagedResponse>
        listAuthorizationsSettings() {
      return getStubSettingsBuilder().listAuthorizationsSettings();
    }

    /** Returns the builder for the settings used for calls to getAuthorization. */
    public UnaryCallSettings.Builder<GetAuthorizationRequest, Authorization>
        getAuthorizationSettings() {
      return getStubSettingsBuilder().getAuthorizationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAuthorization. */
    public UnaryCallSettings.Builder<DeleteAuthorizationRequest, Empty>
        deleteAuthorizationSettings() {
      return getStubSettingsBuilder().deleteAuthorizationSettings();
    }

    /** Returns the builder for the settings used for calls to listAccessSummaries. */
    public PagedCallSettings.Builder<
            ListAccessSummariesRequest,
            ListAccessSummariesResponse,
            ListAccessSummariesPagedResponse>
        listAccessSummariesSettings() {
      return getStubSettingsBuilder().listAccessSummariesSettings();
    }

    /** Returns the builder for the settings used for calls to getAccessSummary. */
    public UnaryCallSettings.Builder<GetAccessSummaryRequest, AccessSummary>
        getAccessSummarySettings() {
      return getStubSettingsBuilder().getAccessSummarySettings();
    }

    /** Returns the builder for the settings used for calls to revokeAuthorization. */
    public UnaryCallSettings.Builder<RevokeAuthorizationRequest, RevokeAuthorizationResponse>
        revokeAuthorizationSettings() {
      return getStubSettingsBuilder().revokeAuthorizationSettings();
    }

    /** Returns the builder for the settings used for calls to enableAuthProvider. */
    public UnaryCallSettings.Builder<EnableAuthProviderRequest, AuthProvider>
        enableAuthProviderSettings() {
      return getStubSettingsBuilder().enableAuthProviderSettings();
    }

    /** Returns the builder for the settings used for calls to disableAuthProvider. */
    public UnaryCallSettings.Builder<DisableAuthProviderRequest, AuthProvider>
        disableAuthProviderSettings() {
      return getStubSettingsBuilder().disableAuthProviderSettings();
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
    public AuthProviderServiceSettings build() throws IOException {
      return new AuthProviderServiceSettings(this);
    }
  }
}
