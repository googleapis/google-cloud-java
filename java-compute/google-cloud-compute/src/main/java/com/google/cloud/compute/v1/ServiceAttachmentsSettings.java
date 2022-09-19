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

import static com.google.cloud.compute.v1.ServiceAttachmentsClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.ServiceAttachmentsClient.ListPagedResponse;

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
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.compute.v1.stub.ServiceAttachmentsStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ServiceAttachmentsClient}.
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
 * ServiceAttachmentsSettings.Builder serviceAttachmentsSettingsBuilder =
 *     ServiceAttachmentsSettings.newBuilder();
 * serviceAttachmentsSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         serviceAttachmentsSettingsBuilder.getSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ServiceAttachmentsSettings serviceAttachmentsSettings =
 *     serviceAttachmentsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ServiceAttachmentsSettings extends ClientSettings<ServiceAttachmentsSettings> {

  /** Returns the object with the settings used for calls to aggregatedList. */
  public PagedCallSettings<
          AggregatedListServiceAttachmentsRequest,
          ServiceAttachmentAggregatedList,
          AggregatedListPagedResponse>
      aggregatedListSettings() {
    return ((ServiceAttachmentsStubSettings) getStubSettings()).aggregatedListSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteServiceAttachmentRequest, Operation> deleteSettings() {
    return ((ServiceAttachmentsStubSettings) getStubSettings()).deleteSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteServiceAttachmentRequest, Operation, Operation>
      deleteOperationSettings() {
    return ((ServiceAttachmentsStubSettings) getStubSettings()).deleteOperationSettings();
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetServiceAttachmentRequest, ServiceAttachment> getSettings() {
    return ((ServiceAttachmentsStubSettings) getStubSettings()).getSettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyServiceAttachmentRequest, Policy> getIamPolicySettings() {
    return ((ServiceAttachmentsStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertServiceAttachmentRequest, Operation> insertSettings() {
    return ((ServiceAttachmentsStubSettings) getStubSettings()).insertSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertServiceAttachmentRequest, Operation, Operation>
      insertOperationSettings() {
    return ((ServiceAttachmentsStubSettings) getStubSettings()).insertOperationSettings();
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListServiceAttachmentsRequest, ServiceAttachmentList, ListPagedResponse>
      listSettings() {
    return ((ServiceAttachmentsStubSettings) getStubSettings()).listSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<PatchServiceAttachmentRequest, Operation> patchSettings() {
    return ((ServiceAttachmentsStubSettings) getStubSettings()).patchSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public OperationCallSettings<PatchServiceAttachmentRequest, Operation, Operation>
      patchOperationSettings() {
    return ((ServiceAttachmentsStubSettings) getStubSettings()).patchOperationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyServiceAttachmentRequest, Policy> setIamPolicySettings() {
    return ((ServiceAttachmentsStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsServiceAttachmentRequest, TestPermissionsResponse>
      testIamPermissionsSettings() {
    return ((ServiceAttachmentsStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final ServiceAttachmentsSettings create(ServiceAttachmentsStubSettings stub)
      throws IOException {
    return new ServiceAttachmentsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ServiceAttachmentsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ServiceAttachmentsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ServiceAttachmentsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ServiceAttachmentsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ServiceAttachmentsStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ServiceAttachmentsStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ServiceAttachmentsStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ServiceAttachmentsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ServiceAttachmentsSettings. */
  public static class Builder extends ClientSettings.Builder<ServiceAttachmentsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ServiceAttachmentsStubSettings.newBuilder(clientContext));
    }

    protected Builder(ServiceAttachmentsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ServiceAttachmentsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ServiceAttachmentsStubSettings.newBuilder());
    }

    public ServiceAttachmentsStubSettings.Builder getStubSettingsBuilder() {
      return ((ServiceAttachmentsStubSettings.Builder) getStubSettings());
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
            AggregatedListServiceAttachmentsRequest,
            ServiceAttachmentAggregatedList,
            AggregatedListPagedResponse>
        aggregatedListSettings() {
      return getStubSettingsBuilder().aggregatedListSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteServiceAttachmentRequest, Operation> deleteSettings() {
      return getStubSettingsBuilder().deleteSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<DeleteServiceAttachmentRequest, Operation, Operation>
        deleteOperationSettings() {
      return getStubSettingsBuilder().deleteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetServiceAttachmentRequest, ServiceAttachment> getSettings() {
      return getStubSettingsBuilder().getSettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyServiceAttachmentRequest, Policy>
        getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertServiceAttachmentRequest, Operation> insertSettings() {
      return getStubSettingsBuilder().insertSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<InsertServiceAttachmentRequest, Operation, Operation>
        insertOperationSettings() {
      return getStubSettingsBuilder().insertOperationSettings();
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListServiceAttachmentsRequest, ServiceAttachmentList, ListPagedResponse>
        listSettings() {
      return getStubSettingsBuilder().listSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<PatchServiceAttachmentRequest, Operation> patchSettings() {
      return getStubSettingsBuilder().patchSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public OperationCallSettings.Builder<PatchServiceAttachmentRequest, Operation, Operation>
        patchOperationSettings() {
      return getStubSettingsBuilder().patchOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyServiceAttachmentRequest, Policy>
        setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<
            TestIamPermissionsServiceAttachmentRequest, TestPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public ServiceAttachmentsSettings build() throws IOException {
      return new ServiceAttachmentsSettings(this);
    }
  }
}
