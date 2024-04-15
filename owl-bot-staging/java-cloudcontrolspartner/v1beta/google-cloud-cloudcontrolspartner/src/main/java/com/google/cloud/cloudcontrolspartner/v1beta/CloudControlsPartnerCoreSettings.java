/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.cloudcontrolspartner.v1beta;

import static com.google.cloud.cloudcontrolspartner.v1beta.CloudControlsPartnerCoreClient.ListAccessApprovalRequestsPagedResponse;
import static com.google.cloud.cloudcontrolspartner.v1beta.CloudControlsPartnerCoreClient.ListCustomersPagedResponse;
import static com.google.cloud.cloudcontrolspartner.v1beta.CloudControlsPartnerCoreClient.ListWorkloadsPagedResponse;

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
import com.google.cloud.cloudcontrolspartner.v1beta.stub.CloudControlsPartnerCoreStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link CloudControlsPartnerCoreClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudcontrolspartner.googleapis.com) and default port (443)
 *       are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getWorkload to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CloudControlsPartnerCoreSettings.Builder cloudControlsPartnerCoreSettingsBuilder =
 *     CloudControlsPartnerCoreSettings.newBuilder();
 * cloudControlsPartnerCoreSettingsBuilder
 *     .getWorkloadSettings()
 *     .setRetrySettings(
 *         cloudControlsPartnerCoreSettingsBuilder
 *             .getWorkloadSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * CloudControlsPartnerCoreSettings cloudControlsPartnerCoreSettings =
 *     cloudControlsPartnerCoreSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class CloudControlsPartnerCoreSettings
    extends ClientSettings<CloudControlsPartnerCoreSettings> {

  /** Returns the object with the settings used for calls to getWorkload. */
  public UnaryCallSettings<GetWorkloadRequest, Workload> getWorkloadSettings() {
    return ((CloudControlsPartnerCoreStubSettings) getStubSettings()).getWorkloadSettings();
  }

  /** Returns the object with the settings used for calls to listWorkloads. */
  public PagedCallSettings<ListWorkloadsRequest, ListWorkloadsResponse, ListWorkloadsPagedResponse>
      listWorkloadsSettings() {
    return ((CloudControlsPartnerCoreStubSettings) getStubSettings()).listWorkloadsSettings();
  }

  /** Returns the object with the settings used for calls to getCustomer. */
  public UnaryCallSettings<GetCustomerRequest, Customer> getCustomerSettings() {
    return ((CloudControlsPartnerCoreStubSettings) getStubSettings()).getCustomerSettings();
  }

  /** Returns the object with the settings used for calls to listCustomers. */
  public PagedCallSettings<ListCustomersRequest, ListCustomersResponse, ListCustomersPagedResponse>
      listCustomersSettings() {
    return ((CloudControlsPartnerCoreStubSettings) getStubSettings()).listCustomersSettings();
  }

  /** Returns the object with the settings used for calls to getEkmConnections. */
  public UnaryCallSettings<GetEkmConnectionsRequest, EkmConnections> getEkmConnectionsSettings() {
    return ((CloudControlsPartnerCoreStubSettings) getStubSettings()).getEkmConnectionsSettings();
  }

  /** Returns the object with the settings used for calls to getPartnerPermissions. */
  public UnaryCallSettings<GetPartnerPermissionsRequest, PartnerPermissions>
      getPartnerPermissionsSettings() {
    return ((CloudControlsPartnerCoreStubSettings) getStubSettings())
        .getPartnerPermissionsSettings();
  }

  /** Returns the object with the settings used for calls to listAccessApprovalRequests. */
  public PagedCallSettings<
          ListAccessApprovalRequestsRequest,
          ListAccessApprovalRequestsResponse,
          ListAccessApprovalRequestsPagedResponse>
      listAccessApprovalRequestsSettings() {
    return ((CloudControlsPartnerCoreStubSettings) getStubSettings())
        .listAccessApprovalRequestsSettings();
  }

  /** Returns the object with the settings used for calls to getPartner. */
  public UnaryCallSettings<GetPartnerRequest, Partner> getPartnerSettings() {
    return ((CloudControlsPartnerCoreStubSettings) getStubSettings()).getPartnerSettings();
  }

  public static final CloudControlsPartnerCoreSettings create(
      CloudControlsPartnerCoreStubSettings stub) throws IOException {
    return new CloudControlsPartnerCoreSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return CloudControlsPartnerCoreStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return CloudControlsPartnerCoreStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return CloudControlsPartnerCoreStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return CloudControlsPartnerCoreStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return CloudControlsPartnerCoreStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return CloudControlsPartnerCoreStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return CloudControlsPartnerCoreStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CloudControlsPartnerCoreStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected CloudControlsPartnerCoreSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for CloudControlsPartnerCoreSettings. */
  public static class Builder
      extends ClientSettings.Builder<CloudControlsPartnerCoreSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(CloudControlsPartnerCoreStubSettings.newBuilder(clientContext));
    }

    protected Builder(CloudControlsPartnerCoreSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(CloudControlsPartnerCoreStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(CloudControlsPartnerCoreStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(CloudControlsPartnerCoreStubSettings.newHttpJsonBuilder());
    }

    public CloudControlsPartnerCoreStubSettings.Builder getStubSettingsBuilder() {
      return ((CloudControlsPartnerCoreStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getWorkload. */
    public UnaryCallSettings.Builder<GetWorkloadRequest, Workload> getWorkloadSettings() {
      return getStubSettingsBuilder().getWorkloadSettings();
    }

    /** Returns the builder for the settings used for calls to listWorkloads. */
    public PagedCallSettings.Builder<
            ListWorkloadsRequest, ListWorkloadsResponse, ListWorkloadsPagedResponse>
        listWorkloadsSettings() {
      return getStubSettingsBuilder().listWorkloadsSettings();
    }

    /** Returns the builder for the settings used for calls to getCustomer. */
    public UnaryCallSettings.Builder<GetCustomerRequest, Customer> getCustomerSettings() {
      return getStubSettingsBuilder().getCustomerSettings();
    }

    /** Returns the builder for the settings used for calls to listCustomers. */
    public PagedCallSettings.Builder<
            ListCustomersRequest, ListCustomersResponse, ListCustomersPagedResponse>
        listCustomersSettings() {
      return getStubSettingsBuilder().listCustomersSettings();
    }

    /** Returns the builder for the settings used for calls to getEkmConnections. */
    public UnaryCallSettings.Builder<GetEkmConnectionsRequest, EkmConnections>
        getEkmConnectionsSettings() {
      return getStubSettingsBuilder().getEkmConnectionsSettings();
    }

    /** Returns the builder for the settings used for calls to getPartnerPermissions. */
    public UnaryCallSettings.Builder<GetPartnerPermissionsRequest, PartnerPermissions>
        getPartnerPermissionsSettings() {
      return getStubSettingsBuilder().getPartnerPermissionsSettings();
    }

    /** Returns the builder for the settings used for calls to listAccessApprovalRequests. */
    public PagedCallSettings.Builder<
            ListAccessApprovalRequestsRequest,
            ListAccessApprovalRequestsResponse,
            ListAccessApprovalRequestsPagedResponse>
        listAccessApprovalRequestsSettings() {
      return getStubSettingsBuilder().listAccessApprovalRequestsSettings();
    }

    /** Returns the builder for the settings used for calls to getPartner. */
    public UnaryCallSettings.Builder<GetPartnerRequest, Partner> getPartnerSettings() {
      return getStubSettingsBuilder().getPartnerSettings();
    }

    @Override
    public CloudControlsPartnerCoreSettings build() throws IOException {
      return new CloudControlsPartnerCoreSettings(this);
    }
  }
}
