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

package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.NetworkAttachmentsClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.NetworkAttachmentsClient.ListPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.compute.v1.stub.NetworkAttachmentsStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link NetworkAttachmentsClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (compute.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of get to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * NetworkAttachmentsSettings.Builder networkAttachmentsSettingsBuilder =
 *     NetworkAttachmentsSettings.newBuilder();
 * networkAttachmentsSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         networkAttachmentsSettingsBuilder.getSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * NetworkAttachmentsSettings networkAttachmentsSettings =
 *     networkAttachmentsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class NetworkAttachmentsSettings extends ClientSettings<NetworkAttachmentsSettings> {

  /** Returns the object with the settings used for calls to aggregatedList. */
  public PagedCallSettings<
          AggregatedListNetworkAttachmentsRequest,
          NetworkAttachmentAggregatedList,
          AggregatedListPagedResponse>
      aggregatedListSettings() {
    return ((NetworkAttachmentsStubSettings) getStubSettings()).aggregatedListSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteNetworkAttachmentRequest, Operation> deleteSettings() {
    return ((NetworkAttachmentsStubSettings) getStubSettings()).deleteSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteNetworkAttachmentRequest, Operation, Operation>
      deleteOperationSettings() {
    return ((NetworkAttachmentsStubSettings) getStubSettings()).deleteOperationSettings();
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetNetworkAttachmentRequest, NetworkAttachment> getSettings() {
    return ((NetworkAttachmentsStubSettings) getStubSettings()).getSettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyNetworkAttachmentRequest, Policy> getIamPolicySettings() {
    return ((NetworkAttachmentsStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertNetworkAttachmentRequest, Operation> insertSettings() {
    return ((NetworkAttachmentsStubSettings) getStubSettings()).insertSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertNetworkAttachmentRequest, Operation, Operation>
      insertOperationSettings() {
    return ((NetworkAttachmentsStubSettings) getStubSettings()).insertOperationSettings();
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListNetworkAttachmentsRequest, NetworkAttachmentList, ListPagedResponse>
      listSettings() {
    return ((NetworkAttachmentsStubSettings) getStubSettings()).listSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyNetworkAttachmentRequest, Policy> setIamPolicySettings() {
    return ((NetworkAttachmentsStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsNetworkAttachmentRequest, TestPermissionsResponse>
      testIamPermissionsSettings() {
    return ((NetworkAttachmentsStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final NetworkAttachmentsSettings create(NetworkAttachmentsStubSettings stub)
      throws IOException {
    return new NetworkAttachmentsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return NetworkAttachmentsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return NetworkAttachmentsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return NetworkAttachmentsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return NetworkAttachmentsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return NetworkAttachmentsStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return NetworkAttachmentsStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return NetworkAttachmentsStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected NetworkAttachmentsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for NetworkAttachmentsSettings. */
  public static class Builder extends ClientSettings.Builder<NetworkAttachmentsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(NetworkAttachmentsStubSettings.newBuilder(clientContext));
    }

    protected Builder(NetworkAttachmentsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(NetworkAttachmentsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(NetworkAttachmentsStubSettings.newBuilder());
    }

    public NetworkAttachmentsStubSettings.Builder getStubSettingsBuilder() {
      return ((NetworkAttachmentsStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to aggregatedList. */
    public PagedCallSettings.Builder<
            AggregatedListNetworkAttachmentsRequest,
            NetworkAttachmentAggregatedList,
            AggregatedListPagedResponse>
        aggregatedListSettings() {
      return getStubSettingsBuilder().aggregatedListSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteNetworkAttachmentRequest, Operation> deleteSettings() {
      return getStubSettingsBuilder().deleteSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<DeleteNetworkAttachmentRequest, Operation, Operation>
        deleteOperationSettings() {
      return getStubSettingsBuilder().deleteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetNetworkAttachmentRequest, NetworkAttachment> getSettings() {
      return getStubSettingsBuilder().getSettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyNetworkAttachmentRequest, Policy>
        getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertNetworkAttachmentRequest, Operation> insertSettings() {
      return getStubSettingsBuilder().insertSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<InsertNetworkAttachmentRequest, Operation, Operation>
        insertOperationSettings() {
      return getStubSettingsBuilder().insertOperationSettings();
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListNetworkAttachmentsRequest, NetworkAttachmentList, ListPagedResponse>
        listSettings() {
      return getStubSettingsBuilder().listSettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyNetworkAttachmentRequest, Policy>
        setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<
            TestIamPermissionsNetworkAttachmentRequest, TestPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public NetworkAttachmentsSettings build() throws IOException {
      return new NetworkAttachmentsSettings(this);
    }
  }
}
