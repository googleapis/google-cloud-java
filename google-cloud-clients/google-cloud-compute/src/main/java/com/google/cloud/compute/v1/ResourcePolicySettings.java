/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.ResourcePolicyClient.AggregatedListResourcePoliciesPagedResponse;
import static com.google.cloud.compute.v1.ResourcePolicyClient.ListResourcePoliciesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.compute.v1.stub.ResourcePolicyStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link ResourcePolicyClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (https://compute.googleapis.com/compute/v1/projects/) and
 *       default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of deleteResourcePolicy to 30 seconds:
 *
 * <pre>
 * <code>
 * ResourcePolicySettings.Builder resourcePolicySettingsBuilder =
 *     ResourcePolicySettings.newBuilder();
 * resourcePolicySettingsBuilder.deleteResourcePolicySettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * ResourcePolicySettings resourcePolicySettings = resourcePolicySettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class ResourcePolicySettings extends ClientSettings<ResourcePolicySettings> {
  /** Returns the object with the settings used for calls to aggregatedListResourcePolicies. */
  public PagedCallSettings<
          AggregatedListResourcePoliciesHttpRequest,
          ResourcePolicyAggregatedList,
          AggregatedListResourcePoliciesPagedResponse>
      aggregatedListResourcePoliciesSettings() {
    return ((ResourcePolicyStubSettings) getStubSettings())
        .aggregatedListResourcePoliciesSettings();
  }

  /** Returns the object with the settings used for calls to deleteResourcePolicy. */
  public UnaryCallSettings<DeleteResourcePolicyHttpRequest, Operation>
      deleteResourcePolicySettings() {
    return ((ResourcePolicyStubSettings) getStubSettings()).deleteResourcePolicySettings();
  }

  /** Returns the object with the settings used for calls to getResourcePolicy. */
  public UnaryCallSettings<GetResourcePolicyHttpRequest, ResourcePolicy>
      getResourcePolicySettings() {
    return ((ResourcePolicyStubSettings) getStubSettings()).getResourcePolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicyResourcePolicy. */
  public UnaryCallSettings<GetIamPolicyResourcePolicyHttpRequest, Policy>
      getIamPolicyResourcePolicySettings() {
    return ((ResourcePolicyStubSettings) getStubSettings()).getIamPolicyResourcePolicySettings();
  }

  /** Returns the object with the settings used for calls to insertResourcePolicy. */
  public UnaryCallSettings<InsertResourcePolicyHttpRequest, Operation>
      insertResourcePolicySettings() {
    return ((ResourcePolicyStubSettings) getStubSettings()).insertResourcePolicySettings();
  }

  /** Returns the object with the settings used for calls to listResourcePolicies. */
  public PagedCallSettings<
          ListResourcePoliciesHttpRequest, ResourcePolicyList, ListResourcePoliciesPagedResponse>
      listResourcePoliciesSettings() {
    return ((ResourcePolicyStubSettings) getStubSettings()).listResourcePoliciesSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicyResourcePolicy. */
  public UnaryCallSettings<SetIamPolicyResourcePolicyHttpRequest, Policy>
      setIamPolicyResourcePolicySettings() {
    return ((ResourcePolicyStubSettings) getStubSettings()).setIamPolicyResourcePolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissionsResourcePolicy. */
  public UnaryCallSettings<TestIamPermissionsResourcePolicyHttpRequest, TestPermissionsResponse>
      testIamPermissionsResourcePolicySettings() {
    return ((ResourcePolicyStubSettings) getStubSettings())
        .testIamPermissionsResourcePolicySettings();
  }

  public static final ResourcePolicySettings create(ResourcePolicyStubSettings stub)
      throws IOException {
    return new ResourcePolicySettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ResourcePolicyStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ResourcePolicyStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return ResourcePolicyStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ResourcePolicyStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ResourcePolicyStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ResourcePolicyStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ResourcePolicyStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ResourcePolicyStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ResourcePolicySettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ResourcePolicySettings. */
  public static class Builder extends ClientSettings.Builder<ResourcePolicySettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(ResourcePolicyStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(ResourcePolicyStubSettings.newBuilder());
    }

    protected Builder(ResourcePolicySettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ResourcePolicyStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public ResourcePolicyStubSettings.Builder getStubSettingsBuilder() {
      return ((ResourcePolicyStubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to aggregatedListResourcePolicies. */
    public PagedCallSettings.Builder<
            AggregatedListResourcePoliciesHttpRequest,
            ResourcePolicyAggregatedList,
            AggregatedListResourcePoliciesPagedResponse>
        aggregatedListResourcePoliciesSettings() {
      return getStubSettingsBuilder().aggregatedListResourcePoliciesSettings();
    }

    /** Returns the builder for the settings used for calls to deleteResourcePolicy. */
    public UnaryCallSettings.Builder<DeleteResourcePolicyHttpRequest, Operation>
        deleteResourcePolicySettings() {
      return getStubSettingsBuilder().deleteResourcePolicySettings();
    }

    /** Returns the builder for the settings used for calls to getResourcePolicy. */
    public UnaryCallSettings.Builder<GetResourcePolicyHttpRequest, ResourcePolicy>
        getResourcePolicySettings() {
      return getStubSettingsBuilder().getResourcePolicySettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicyResourcePolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyResourcePolicyHttpRequest, Policy>
        getIamPolicyResourcePolicySettings() {
      return getStubSettingsBuilder().getIamPolicyResourcePolicySettings();
    }

    /** Returns the builder for the settings used for calls to insertResourcePolicy. */
    public UnaryCallSettings.Builder<InsertResourcePolicyHttpRequest, Operation>
        insertResourcePolicySettings() {
      return getStubSettingsBuilder().insertResourcePolicySettings();
    }

    /** Returns the builder for the settings used for calls to listResourcePolicies. */
    public PagedCallSettings.Builder<
            ListResourcePoliciesHttpRequest, ResourcePolicyList, ListResourcePoliciesPagedResponse>
        listResourcePoliciesSettings() {
      return getStubSettingsBuilder().listResourcePoliciesSettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicyResourcePolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyResourcePolicyHttpRequest, Policy>
        setIamPolicyResourcePolicySettings() {
      return getStubSettingsBuilder().setIamPolicyResourcePolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissionsResourcePolicy. */
    public UnaryCallSettings.Builder<
            TestIamPermissionsResourcePolicyHttpRequest, TestPermissionsResponse>
        testIamPermissionsResourcePolicySettings() {
      return getStubSettingsBuilder().testIamPermissionsResourcePolicySettings();
    }

    @Override
    public ResourcePolicySettings build() throws IOException {
      return new ResourcePolicySettings(this);
    }
  }
}
