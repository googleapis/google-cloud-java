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

package com.google.cloud.accessapproval.v1;

import static com.google.cloud.accessapproval.v1.AccessApprovalAdminClient.ListApprovalRequestsPagedResponse;

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
import com.google.cloud.accessapproval.v1.stub.AccessApprovalStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AccessApprovalAdminClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (accessapproval.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getApprovalRequest to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AccessApprovalAdminSettings.Builder accessApprovalAdminSettingsBuilder =
 *     AccessApprovalAdminSettings.newBuilder();
 * accessApprovalAdminSettingsBuilder
 *     .getApprovalRequestSettings()
 *     .setRetrySettings(
 *         accessApprovalAdminSettingsBuilder
 *             .getApprovalRequestSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AccessApprovalAdminSettings accessApprovalAdminSettings =
 *     accessApprovalAdminSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AccessApprovalAdminSettings extends ClientSettings<AccessApprovalAdminSettings> {

  /** Returns the object with the settings used for calls to listApprovalRequests. */
  public PagedCallSettings<
          ListApprovalRequestsMessage,
          ListApprovalRequestsResponse,
          ListApprovalRequestsPagedResponse>
      listApprovalRequestsSettings() {
    return ((AccessApprovalStubSettings) getStubSettings()).listApprovalRequestsSettings();
  }

  /** Returns the object with the settings used for calls to getApprovalRequest. */
  public UnaryCallSettings<GetApprovalRequestMessage, ApprovalRequest>
      getApprovalRequestSettings() {
    return ((AccessApprovalStubSettings) getStubSettings()).getApprovalRequestSettings();
  }

  /** Returns the object with the settings used for calls to approveApprovalRequest. */
  public UnaryCallSettings<ApproveApprovalRequestMessage, ApprovalRequest>
      approveApprovalRequestSettings() {
    return ((AccessApprovalStubSettings) getStubSettings()).approveApprovalRequestSettings();
  }

  /** Returns the object with the settings used for calls to dismissApprovalRequest. */
  public UnaryCallSettings<DismissApprovalRequestMessage, ApprovalRequest>
      dismissApprovalRequestSettings() {
    return ((AccessApprovalStubSettings) getStubSettings()).dismissApprovalRequestSettings();
  }

  /** Returns the object with the settings used for calls to invalidateApprovalRequest. */
  public UnaryCallSettings<InvalidateApprovalRequestMessage, ApprovalRequest>
      invalidateApprovalRequestSettings() {
    return ((AccessApprovalStubSettings) getStubSettings()).invalidateApprovalRequestSettings();
  }

  /** Returns the object with the settings used for calls to getAccessApprovalSettings. */
  public UnaryCallSettings<GetAccessApprovalSettingsMessage, AccessApprovalSettings>
      getAccessApprovalSettingsSettings() {
    return ((AccessApprovalStubSettings) getStubSettings()).getAccessApprovalSettingsSettings();
  }

  /** Returns the object with the settings used for calls to updateAccessApprovalSettings. */
  public UnaryCallSettings<UpdateAccessApprovalSettingsMessage, AccessApprovalSettings>
      updateAccessApprovalSettingsSettings() {
    return ((AccessApprovalStubSettings) getStubSettings()).updateAccessApprovalSettingsSettings();
  }

  /** Returns the object with the settings used for calls to deleteAccessApprovalSettings. */
  public UnaryCallSettings<DeleteAccessApprovalSettingsMessage, Empty>
      deleteAccessApprovalSettingsSettings() {
    return ((AccessApprovalStubSettings) getStubSettings()).deleteAccessApprovalSettingsSettings();
  }

  /** Returns the object with the settings used for calls to getAccessApprovalServiceAccount. */
  public UnaryCallSettings<GetAccessApprovalServiceAccountMessage, AccessApprovalServiceAccount>
      getAccessApprovalServiceAccountSettings() {
    return ((AccessApprovalStubSettings) getStubSettings())
        .getAccessApprovalServiceAccountSettings();
  }

  public static final AccessApprovalAdminSettings create(AccessApprovalStubSettings stub)
      throws IOException {
    return new AccessApprovalAdminSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return AccessApprovalStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return AccessApprovalStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return AccessApprovalStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return AccessApprovalStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return AccessApprovalStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return AccessApprovalStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return AccessApprovalStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AccessApprovalStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected AccessApprovalAdminSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for AccessApprovalAdminSettings. */
  public static class Builder extends ClientSettings.Builder<AccessApprovalAdminSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(AccessApprovalStubSettings.newBuilder(clientContext));
    }

    protected Builder(AccessApprovalAdminSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(AccessApprovalStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(AccessApprovalStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(AccessApprovalStubSettings.newHttpJsonBuilder());
    }

    public AccessApprovalStubSettings.Builder getStubSettingsBuilder() {
      return ((AccessApprovalStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listApprovalRequests. */
    public PagedCallSettings.Builder<
            ListApprovalRequestsMessage,
            ListApprovalRequestsResponse,
            ListApprovalRequestsPagedResponse>
        listApprovalRequestsSettings() {
      return getStubSettingsBuilder().listApprovalRequestsSettings();
    }

    /** Returns the builder for the settings used for calls to getApprovalRequest. */
    public UnaryCallSettings.Builder<GetApprovalRequestMessage, ApprovalRequest>
        getApprovalRequestSettings() {
      return getStubSettingsBuilder().getApprovalRequestSettings();
    }

    /** Returns the builder for the settings used for calls to approveApprovalRequest. */
    public UnaryCallSettings.Builder<ApproveApprovalRequestMessage, ApprovalRequest>
        approveApprovalRequestSettings() {
      return getStubSettingsBuilder().approveApprovalRequestSettings();
    }

    /** Returns the builder for the settings used for calls to dismissApprovalRequest. */
    public UnaryCallSettings.Builder<DismissApprovalRequestMessage, ApprovalRequest>
        dismissApprovalRequestSettings() {
      return getStubSettingsBuilder().dismissApprovalRequestSettings();
    }

    /** Returns the builder for the settings used for calls to invalidateApprovalRequest. */
    public UnaryCallSettings.Builder<InvalidateApprovalRequestMessage, ApprovalRequest>
        invalidateApprovalRequestSettings() {
      return getStubSettingsBuilder().invalidateApprovalRequestSettings();
    }

    /** Returns the builder for the settings used for calls to getAccessApprovalSettings. */
    public UnaryCallSettings.Builder<GetAccessApprovalSettingsMessage, AccessApprovalSettings>
        getAccessApprovalSettingsSettings() {
      return getStubSettingsBuilder().getAccessApprovalSettingsSettings();
    }

    /** Returns the builder for the settings used for calls to updateAccessApprovalSettings. */
    public UnaryCallSettings.Builder<UpdateAccessApprovalSettingsMessage, AccessApprovalSettings>
        updateAccessApprovalSettingsSettings() {
      return getStubSettingsBuilder().updateAccessApprovalSettingsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAccessApprovalSettings. */
    public UnaryCallSettings.Builder<DeleteAccessApprovalSettingsMessage, Empty>
        deleteAccessApprovalSettingsSettings() {
      return getStubSettingsBuilder().deleteAccessApprovalSettingsSettings();
    }

    /** Returns the builder for the settings used for calls to getAccessApprovalServiceAccount. */
    public UnaryCallSettings.Builder<
            GetAccessApprovalServiceAccountMessage, AccessApprovalServiceAccount>
        getAccessApprovalServiceAccountSettings() {
      return getStubSettingsBuilder().getAccessApprovalServiceAccountSettings();
    }

    @Override
    public AccessApprovalAdminSettings build() throws IOException {
      return new AccessApprovalAdminSettings(this);
    }
  }
}
