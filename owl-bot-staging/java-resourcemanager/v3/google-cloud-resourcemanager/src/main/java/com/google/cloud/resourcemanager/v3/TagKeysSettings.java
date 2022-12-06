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

package com.google.cloud.resourcemanager.v3;

import static com.google.cloud.resourcemanager.v3.TagKeysClient.ListTagKeysPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.resourcemanager.v3.stub.TagKeysStubSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link TagKeysClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudresourcemanager.googleapis.com) and default port (443)
 *       are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getTagKey to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TagKeysSettings.Builder tagKeysSettingsBuilder = TagKeysSettings.newBuilder();
 * tagKeysSettingsBuilder
 *     .getTagKeySettings()
 *     .setRetrySettings(
 *         tagKeysSettingsBuilder.getTagKeySettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * TagKeysSettings tagKeysSettings = tagKeysSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class TagKeysSettings extends ClientSettings<TagKeysSettings> {

  /** Returns the object with the settings used for calls to listTagKeys. */
  public PagedCallSettings<ListTagKeysRequest, ListTagKeysResponse, ListTagKeysPagedResponse>
      listTagKeysSettings() {
    return ((TagKeysStubSettings) getStubSettings()).listTagKeysSettings();
  }

  /** Returns the object with the settings used for calls to getTagKey. */
  public UnaryCallSettings<GetTagKeyRequest, TagKey> getTagKeySettings() {
    return ((TagKeysStubSettings) getStubSettings()).getTagKeySettings();
  }

  /** Returns the object with the settings used for calls to createTagKey. */
  public UnaryCallSettings<CreateTagKeyRequest, Operation> createTagKeySettings() {
    return ((TagKeysStubSettings) getStubSettings()).createTagKeySettings();
  }

  /** Returns the object with the settings used for calls to createTagKey. */
  public OperationCallSettings<CreateTagKeyRequest, TagKey, CreateTagKeyMetadata>
      createTagKeyOperationSettings() {
    return ((TagKeysStubSettings) getStubSettings()).createTagKeyOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateTagKey. */
  public UnaryCallSettings<UpdateTagKeyRequest, Operation> updateTagKeySettings() {
    return ((TagKeysStubSettings) getStubSettings()).updateTagKeySettings();
  }

  /** Returns the object with the settings used for calls to updateTagKey. */
  public OperationCallSettings<UpdateTagKeyRequest, TagKey, UpdateTagKeyMetadata>
      updateTagKeyOperationSettings() {
    return ((TagKeysStubSettings) getStubSettings()).updateTagKeyOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteTagKey. */
  public UnaryCallSettings<DeleteTagKeyRequest, Operation> deleteTagKeySettings() {
    return ((TagKeysStubSettings) getStubSettings()).deleteTagKeySettings();
  }

  /** Returns the object with the settings used for calls to deleteTagKey. */
  public OperationCallSettings<DeleteTagKeyRequest, TagKey, DeleteTagKeyMetadata>
      deleteTagKeyOperationSettings() {
    return ((TagKeysStubSettings) getStubSettings()).deleteTagKeyOperationSettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((TagKeysStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((TagKeysStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((TagKeysStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final TagKeysSettings create(TagKeysStubSettings stub) throws IOException {
    return new TagKeysSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return TagKeysStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return TagKeysStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return TagKeysStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return TagKeysStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return TagKeysStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return TagKeysStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return TagKeysStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return TagKeysStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected TagKeysSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for TagKeysSettings. */
  public static class Builder extends ClientSettings.Builder<TagKeysSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(TagKeysStubSettings.newBuilder(clientContext));
    }

    protected Builder(TagKeysSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(TagKeysStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(TagKeysStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(TagKeysStubSettings.newHttpJsonBuilder());
    }

    public TagKeysStubSettings.Builder getStubSettingsBuilder() {
      return ((TagKeysStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listTagKeys. */
    public PagedCallSettings.Builder<
            ListTagKeysRequest, ListTagKeysResponse, ListTagKeysPagedResponse>
        listTagKeysSettings() {
      return getStubSettingsBuilder().listTagKeysSettings();
    }

    /** Returns the builder for the settings used for calls to getTagKey. */
    public UnaryCallSettings.Builder<GetTagKeyRequest, TagKey> getTagKeySettings() {
      return getStubSettingsBuilder().getTagKeySettings();
    }

    /** Returns the builder for the settings used for calls to createTagKey. */
    public UnaryCallSettings.Builder<CreateTagKeyRequest, Operation> createTagKeySettings() {
      return getStubSettingsBuilder().createTagKeySettings();
    }

    /** Returns the builder for the settings used for calls to createTagKey. */
    public OperationCallSettings.Builder<CreateTagKeyRequest, TagKey, CreateTagKeyMetadata>
        createTagKeyOperationSettings() {
      return getStubSettingsBuilder().createTagKeyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateTagKey. */
    public UnaryCallSettings.Builder<UpdateTagKeyRequest, Operation> updateTagKeySettings() {
      return getStubSettingsBuilder().updateTagKeySettings();
    }

    /** Returns the builder for the settings used for calls to updateTagKey. */
    public OperationCallSettings.Builder<UpdateTagKeyRequest, TagKey, UpdateTagKeyMetadata>
        updateTagKeyOperationSettings() {
      return getStubSettingsBuilder().updateTagKeyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTagKey. */
    public UnaryCallSettings.Builder<DeleteTagKeyRequest, Operation> deleteTagKeySettings() {
      return getStubSettingsBuilder().deleteTagKeySettings();
    }

    /** Returns the builder for the settings used for calls to deleteTagKey. */
    public OperationCallSettings.Builder<DeleteTagKeyRequest, TagKey, DeleteTagKeyMetadata>
        deleteTagKeyOperationSettings() {
      return getStubSettingsBuilder().deleteTagKeyOperationSettings();
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
    public TagKeysSettings build() throws IOException {
      return new TagKeysSettings(this);
    }
  }
}
