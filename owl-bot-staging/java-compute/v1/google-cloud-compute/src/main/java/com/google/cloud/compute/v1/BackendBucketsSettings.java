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

import static com.google.cloud.compute.v1.BackendBucketsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.stub.BackendBucketsStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link BackendBucketsClient}.
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
 * BackendBucketsSettings.Builder backendBucketsSettingsBuilder =
 *     BackendBucketsSettings.newBuilder();
 * backendBucketsSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         backendBucketsSettingsBuilder.getSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * BackendBucketsSettings backendBucketsSettings = backendBucketsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class BackendBucketsSettings extends ClientSettings<BackendBucketsSettings> {

  /** Returns the object with the settings used for calls to addSignedUrlKey. */
  public UnaryCallSettings<AddSignedUrlKeyBackendBucketRequest, Operation>
      addSignedUrlKeySettings() {
    return ((BackendBucketsStubSettings) getStubSettings()).addSignedUrlKeySettings();
  }

  /** Returns the object with the settings used for calls to addSignedUrlKey. */
  public OperationCallSettings<AddSignedUrlKeyBackendBucketRequest, Operation, Operation>
      addSignedUrlKeyOperationSettings() {
    return ((BackendBucketsStubSettings) getStubSettings()).addSignedUrlKeyOperationSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteBackendBucketRequest, Operation> deleteSettings() {
    return ((BackendBucketsStubSettings) getStubSettings()).deleteSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteBackendBucketRequest, Operation, Operation>
      deleteOperationSettings() {
    return ((BackendBucketsStubSettings) getStubSettings()).deleteOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteSignedUrlKey. */
  public UnaryCallSettings<DeleteSignedUrlKeyBackendBucketRequest, Operation>
      deleteSignedUrlKeySettings() {
    return ((BackendBucketsStubSettings) getStubSettings()).deleteSignedUrlKeySettings();
  }

  /** Returns the object with the settings used for calls to deleteSignedUrlKey. */
  public OperationCallSettings<DeleteSignedUrlKeyBackendBucketRequest, Operation, Operation>
      deleteSignedUrlKeyOperationSettings() {
    return ((BackendBucketsStubSettings) getStubSettings()).deleteSignedUrlKeyOperationSettings();
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetBackendBucketRequest, BackendBucket> getSettings() {
    return ((BackendBucketsStubSettings) getStubSettings()).getSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertBackendBucketRequest, Operation> insertSettings() {
    return ((BackendBucketsStubSettings) getStubSettings()).insertSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertBackendBucketRequest, Operation, Operation>
      insertOperationSettings() {
    return ((BackendBucketsStubSettings) getStubSettings()).insertOperationSettings();
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListBackendBucketsRequest, BackendBucketList, ListPagedResponse>
      listSettings() {
    return ((BackendBucketsStubSettings) getStubSettings()).listSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<PatchBackendBucketRequest, Operation> patchSettings() {
    return ((BackendBucketsStubSettings) getStubSettings()).patchSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public OperationCallSettings<PatchBackendBucketRequest, Operation, Operation>
      patchOperationSettings() {
    return ((BackendBucketsStubSettings) getStubSettings()).patchOperationSettings();
  }

  /** Returns the object with the settings used for calls to setEdgeSecurityPolicy. */
  public UnaryCallSettings<SetEdgeSecurityPolicyBackendBucketRequest, Operation>
      setEdgeSecurityPolicySettings() {
    return ((BackendBucketsStubSettings) getStubSettings()).setEdgeSecurityPolicySettings();
  }

  /** Returns the object with the settings used for calls to setEdgeSecurityPolicy. */
  public OperationCallSettings<SetEdgeSecurityPolicyBackendBucketRequest, Operation, Operation>
      setEdgeSecurityPolicyOperationSettings() {
    return ((BackendBucketsStubSettings) getStubSettings())
        .setEdgeSecurityPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to update. */
  public UnaryCallSettings<UpdateBackendBucketRequest, Operation> updateSettings() {
    return ((BackendBucketsStubSettings) getStubSettings()).updateSettings();
  }

  /** Returns the object with the settings used for calls to update. */
  public OperationCallSettings<UpdateBackendBucketRequest, Operation, Operation>
      updateOperationSettings() {
    return ((BackendBucketsStubSettings) getStubSettings()).updateOperationSettings();
  }

  public static final BackendBucketsSettings create(BackendBucketsStubSettings stub)
      throws IOException {
    return new BackendBucketsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return BackendBucketsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return BackendBucketsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return BackendBucketsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return BackendBucketsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return BackendBucketsStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return BackendBucketsStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return BackendBucketsStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected BackendBucketsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for BackendBucketsSettings. */
  public static class Builder extends ClientSettings.Builder<BackendBucketsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(BackendBucketsStubSettings.newBuilder(clientContext));
    }

    protected Builder(BackendBucketsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(BackendBucketsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(BackendBucketsStubSettings.newBuilder());
    }

    public BackendBucketsStubSettings.Builder getStubSettingsBuilder() {
      return ((BackendBucketsStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to addSignedUrlKey. */
    public UnaryCallSettings.Builder<AddSignedUrlKeyBackendBucketRequest, Operation>
        addSignedUrlKeySettings() {
      return getStubSettingsBuilder().addSignedUrlKeySettings();
    }

    /** Returns the builder for the settings used for calls to addSignedUrlKey. */
    public OperationCallSettings.Builder<AddSignedUrlKeyBackendBucketRequest, Operation, Operation>
        addSignedUrlKeyOperationSettings() {
      return getStubSettingsBuilder().addSignedUrlKeyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteBackendBucketRequest, Operation> deleteSettings() {
      return getStubSettingsBuilder().deleteSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<DeleteBackendBucketRequest, Operation, Operation>
        deleteOperationSettings() {
      return getStubSettingsBuilder().deleteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSignedUrlKey. */
    public UnaryCallSettings.Builder<DeleteSignedUrlKeyBackendBucketRequest, Operation>
        deleteSignedUrlKeySettings() {
      return getStubSettingsBuilder().deleteSignedUrlKeySettings();
    }

    /** Returns the builder for the settings used for calls to deleteSignedUrlKey. */
    public OperationCallSettings.Builder<
            DeleteSignedUrlKeyBackendBucketRequest, Operation, Operation>
        deleteSignedUrlKeyOperationSettings() {
      return getStubSettingsBuilder().deleteSignedUrlKeyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetBackendBucketRequest, BackendBucket> getSettings() {
      return getStubSettingsBuilder().getSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertBackendBucketRequest, Operation> insertSettings() {
      return getStubSettingsBuilder().insertSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<InsertBackendBucketRequest, Operation, Operation>
        insertOperationSettings() {
      return getStubSettingsBuilder().insertOperationSettings();
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListBackendBucketsRequest, BackendBucketList, ListPagedResponse>
        listSettings() {
      return getStubSettingsBuilder().listSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<PatchBackendBucketRequest, Operation> patchSettings() {
      return getStubSettingsBuilder().patchSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public OperationCallSettings.Builder<PatchBackendBucketRequest, Operation, Operation>
        patchOperationSettings() {
      return getStubSettingsBuilder().patchOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setEdgeSecurityPolicy. */
    public UnaryCallSettings.Builder<SetEdgeSecurityPolicyBackendBucketRequest, Operation>
        setEdgeSecurityPolicySettings() {
      return getStubSettingsBuilder().setEdgeSecurityPolicySettings();
    }

    /** Returns the builder for the settings used for calls to setEdgeSecurityPolicy. */
    public OperationCallSettings.Builder<
            SetEdgeSecurityPolicyBackendBucketRequest, Operation, Operation>
        setEdgeSecurityPolicyOperationSettings() {
      return getStubSettingsBuilder().setEdgeSecurityPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to update. */
    public UnaryCallSettings.Builder<UpdateBackendBucketRequest, Operation> updateSettings() {
      return getStubSettingsBuilder().updateSettings();
    }

    /** Returns the builder for the settings used for calls to update. */
    public OperationCallSettings.Builder<UpdateBackendBucketRequest, Operation, Operation>
        updateOperationSettings() {
      return getStubSettingsBuilder().updateOperationSettings();
    }

    @Override
    public BackendBucketsSettings build() throws IOException {
      return new BackendBucketsSettings(this);
    }
  }
}
