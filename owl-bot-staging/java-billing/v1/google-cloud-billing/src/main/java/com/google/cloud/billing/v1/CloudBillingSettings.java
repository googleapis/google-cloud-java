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

package com.google.cloud.billing.v1;

import static com.google.cloud.billing.v1.CloudBillingClient.ListBillingAccountsPagedResponse;
import static com.google.cloud.billing.v1.CloudBillingClient.ListProjectBillingInfoPagedResponse;

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
import com.google.cloud.billing.v1.stub.CloudBillingStubSettings;
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
 * Settings class to configure an instance of {@link CloudBillingClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudbilling.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getBillingAccount to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CloudBillingSettings.Builder cloudBillingSettingsBuilder = CloudBillingSettings.newBuilder();
 * cloudBillingSettingsBuilder
 *     .getBillingAccountSettings()
 *     .setRetrySettings(
 *         cloudBillingSettingsBuilder
 *             .getBillingAccountSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * CloudBillingSettings cloudBillingSettings = cloudBillingSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class CloudBillingSettings extends ClientSettings<CloudBillingSettings> {

  /** Returns the object with the settings used for calls to getBillingAccount. */
  public UnaryCallSettings<GetBillingAccountRequest, BillingAccount> getBillingAccountSettings() {
    return ((CloudBillingStubSettings) getStubSettings()).getBillingAccountSettings();
  }

  /** Returns the object with the settings used for calls to listBillingAccounts. */
  public PagedCallSettings<
          ListBillingAccountsRequest, ListBillingAccountsResponse, ListBillingAccountsPagedResponse>
      listBillingAccountsSettings() {
    return ((CloudBillingStubSettings) getStubSettings()).listBillingAccountsSettings();
  }

  /** Returns the object with the settings used for calls to updateBillingAccount. */
  public UnaryCallSettings<UpdateBillingAccountRequest, BillingAccount>
      updateBillingAccountSettings() {
    return ((CloudBillingStubSettings) getStubSettings()).updateBillingAccountSettings();
  }

  /** Returns the object with the settings used for calls to createBillingAccount. */
  public UnaryCallSettings<CreateBillingAccountRequest, BillingAccount>
      createBillingAccountSettings() {
    return ((CloudBillingStubSettings) getStubSettings()).createBillingAccountSettings();
  }

  /** Returns the object with the settings used for calls to listProjectBillingInfo. */
  public PagedCallSettings<
          ListProjectBillingInfoRequest,
          ListProjectBillingInfoResponse,
          ListProjectBillingInfoPagedResponse>
      listProjectBillingInfoSettings() {
    return ((CloudBillingStubSettings) getStubSettings()).listProjectBillingInfoSettings();
  }

  /** Returns the object with the settings used for calls to getProjectBillingInfo. */
  public UnaryCallSettings<GetProjectBillingInfoRequest, ProjectBillingInfo>
      getProjectBillingInfoSettings() {
    return ((CloudBillingStubSettings) getStubSettings()).getProjectBillingInfoSettings();
  }

  /** Returns the object with the settings used for calls to updateProjectBillingInfo. */
  public UnaryCallSettings<UpdateProjectBillingInfoRequest, ProjectBillingInfo>
      updateProjectBillingInfoSettings() {
    return ((CloudBillingStubSettings) getStubSettings()).updateProjectBillingInfoSettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((CloudBillingStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((CloudBillingStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((CloudBillingStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final CloudBillingSettings create(CloudBillingStubSettings stub)
      throws IOException {
    return new CloudBillingSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return CloudBillingStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return CloudBillingStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return CloudBillingStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return CloudBillingStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return CloudBillingStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return CloudBillingStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return CloudBillingStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CloudBillingStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected CloudBillingSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for CloudBillingSettings. */
  public static class Builder extends ClientSettings.Builder<CloudBillingSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(CloudBillingStubSettings.newBuilder(clientContext));
    }

    protected Builder(CloudBillingSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(CloudBillingStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(CloudBillingStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(CloudBillingStubSettings.newHttpJsonBuilder());
    }

    public CloudBillingStubSettings.Builder getStubSettingsBuilder() {
      return ((CloudBillingStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getBillingAccount. */
    public UnaryCallSettings.Builder<GetBillingAccountRequest, BillingAccount>
        getBillingAccountSettings() {
      return getStubSettingsBuilder().getBillingAccountSettings();
    }

    /** Returns the builder for the settings used for calls to listBillingAccounts. */
    public PagedCallSettings.Builder<
            ListBillingAccountsRequest,
            ListBillingAccountsResponse,
            ListBillingAccountsPagedResponse>
        listBillingAccountsSettings() {
      return getStubSettingsBuilder().listBillingAccountsSettings();
    }

    /** Returns the builder for the settings used for calls to updateBillingAccount. */
    public UnaryCallSettings.Builder<UpdateBillingAccountRequest, BillingAccount>
        updateBillingAccountSettings() {
      return getStubSettingsBuilder().updateBillingAccountSettings();
    }

    /** Returns the builder for the settings used for calls to createBillingAccount. */
    public UnaryCallSettings.Builder<CreateBillingAccountRequest, BillingAccount>
        createBillingAccountSettings() {
      return getStubSettingsBuilder().createBillingAccountSettings();
    }

    /** Returns the builder for the settings used for calls to listProjectBillingInfo. */
    public PagedCallSettings.Builder<
            ListProjectBillingInfoRequest,
            ListProjectBillingInfoResponse,
            ListProjectBillingInfoPagedResponse>
        listProjectBillingInfoSettings() {
      return getStubSettingsBuilder().listProjectBillingInfoSettings();
    }

    /** Returns the builder for the settings used for calls to getProjectBillingInfo. */
    public UnaryCallSettings.Builder<GetProjectBillingInfoRequest, ProjectBillingInfo>
        getProjectBillingInfoSettings() {
      return getStubSettingsBuilder().getProjectBillingInfoSettings();
    }

    /** Returns the builder for the settings used for calls to updateProjectBillingInfo. */
    public UnaryCallSettings.Builder<UpdateProjectBillingInfoRequest, ProjectBillingInfo>
        updateProjectBillingInfoSettings() {
      return getStubSettingsBuilder().updateProjectBillingInfoSettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public CloudBillingSettings build() throws IOException {
      return new CloudBillingSettings(this);
    }
  }
}
