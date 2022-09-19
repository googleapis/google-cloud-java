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

import static com.google.cloud.compute.v1.InstanceTemplatesClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.stub.InstanceTemplatesStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link InstanceTemplatesClient}.
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
 * InstanceTemplatesSettings.Builder instanceTemplatesSettingsBuilder =
 *     InstanceTemplatesSettings.newBuilder();
 * instanceTemplatesSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         instanceTemplatesSettingsBuilder.getSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * InstanceTemplatesSettings instanceTemplatesSettings = instanceTemplatesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class InstanceTemplatesSettings extends ClientSettings<InstanceTemplatesSettings> {

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteInstanceTemplateRequest, Operation> deleteSettings() {
    return ((InstanceTemplatesStubSettings) getStubSettings()).deleteSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteInstanceTemplateRequest, Operation, Operation>
      deleteOperationSettings() {
    return ((InstanceTemplatesStubSettings) getStubSettings()).deleteOperationSettings();
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetInstanceTemplateRequest, InstanceTemplate> getSettings() {
    return ((InstanceTemplatesStubSettings) getStubSettings()).getSettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyInstanceTemplateRequest, Policy> getIamPolicySettings() {
    return ((InstanceTemplatesStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertInstanceTemplateRequest, Operation> insertSettings() {
    return ((InstanceTemplatesStubSettings) getStubSettings()).insertSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertInstanceTemplateRequest, Operation, Operation>
      insertOperationSettings() {
    return ((InstanceTemplatesStubSettings) getStubSettings()).insertOperationSettings();
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListInstanceTemplatesRequest, InstanceTemplateList, ListPagedResponse>
      listSettings() {
    return ((InstanceTemplatesStubSettings) getStubSettings()).listSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyInstanceTemplateRequest, Policy> setIamPolicySettings() {
    return ((InstanceTemplatesStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsInstanceTemplateRequest, TestPermissionsResponse>
      testIamPermissionsSettings() {
    return ((InstanceTemplatesStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final InstanceTemplatesSettings create(InstanceTemplatesStubSettings stub)
      throws IOException {
    return new InstanceTemplatesSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstanceTemplatesStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return InstanceTemplatesStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return InstanceTemplatesStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return InstanceTemplatesStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstanceTemplatesStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return InstanceTemplatesStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return InstanceTemplatesStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected InstanceTemplatesSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for InstanceTemplatesSettings. */
  public static class Builder extends ClientSettings.Builder<InstanceTemplatesSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(InstanceTemplatesStubSettings.newBuilder(clientContext));
    }

    protected Builder(InstanceTemplatesSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(InstanceTemplatesStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(InstanceTemplatesStubSettings.newBuilder());
    }

    public InstanceTemplatesStubSettings.Builder getStubSettingsBuilder() {
      return ((InstanceTemplatesStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteInstanceTemplateRequest, Operation> deleteSettings() {
      return getStubSettingsBuilder().deleteSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<DeleteInstanceTemplateRequest, Operation, Operation>
        deleteOperationSettings() {
      return getStubSettingsBuilder().deleteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetInstanceTemplateRequest, InstanceTemplate> getSettings() {
      return getStubSettingsBuilder().getSettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyInstanceTemplateRequest, Policy>
        getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertInstanceTemplateRequest, Operation> insertSettings() {
      return getStubSettingsBuilder().insertSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<InsertInstanceTemplateRequest, Operation, Operation>
        insertOperationSettings() {
      return getStubSettingsBuilder().insertOperationSettings();
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListInstanceTemplatesRequest, InstanceTemplateList, ListPagedResponse>
        listSettings() {
      return getStubSettingsBuilder().listSettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyInstanceTemplateRequest, Policy>
        setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<
            TestIamPermissionsInstanceTemplateRequest, TestPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public InstanceTemplatesSettings build() throws IOException {
      return new InstanceTemplatesSettings(this);
    }
  }
}
