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

import static com.google.cloud.resourcemanager.v3.TagValuesClient.ListTagValuesPagedResponse;

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
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.resourcemanager.v3.stub.TagValuesStubSettings;
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
 * Settings class to configure an instance of {@link TagValuesClient}.
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
 * <p>For example, to set the total timeout of getTagValue to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TagValuesSettings.Builder tagValuesSettingsBuilder = TagValuesSettings.newBuilder();
 * tagValuesSettingsBuilder
 *     .getTagValueSettings()
 *     .setRetrySettings(
 *         tagValuesSettingsBuilder.getTagValueSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * TagValuesSettings tagValuesSettings = tagValuesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class TagValuesSettings extends ClientSettings<TagValuesSettings> {

  /** Returns the object with the settings used for calls to listTagValues. */
  public PagedCallSettings<ListTagValuesRequest, ListTagValuesResponse, ListTagValuesPagedResponse>
      listTagValuesSettings() {
    return ((TagValuesStubSettings) getStubSettings()).listTagValuesSettings();
  }

  /** Returns the object with the settings used for calls to getTagValue. */
  public UnaryCallSettings<GetTagValueRequest, TagValue> getTagValueSettings() {
    return ((TagValuesStubSettings) getStubSettings()).getTagValueSettings();
  }

  /** Returns the object with the settings used for calls to createTagValue. */
  public UnaryCallSettings<CreateTagValueRequest, Operation> createTagValueSettings() {
    return ((TagValuesStubSettings) getStubSettings()).createTagValueSettings();
  }

  /** Returns the object with the settings used for calls to createTagValue. */
  public OperationCallSettings<CreateTagValueRequest, TagValue, CreateTagValueMetadata>
      createTagValueOperationSettings() {
    return ((TagValuesStubSettings) getStubSettings()).createTagValueOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateTagValue. */
  public UnaryCallSettings<UpdateTagValueRequest, Operation> updateTagValueSettings() {
    return ((TagValuesStubSettings) getStubSettings()).updateTagValueSettings();
  }

  /** Returns the object with the settings used for calls to updateTagValue. */
  public OperationCallSettings<UpdateTagValueRequest, TagValue, UpdateTagValueMetadata>
      updateTagValueOperationSettings() {
    return ((TagValuesStubSettings) getStubSettings()).updateTagValueOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteTagValue. */
  public UnaryCallSettings<DeleteTagValueRequest, Operation> deleteTagValueSettings() {
    return ((TagValuesStubSettings) getStubSettings()).deleteTagValueSettings();
  }

  /** Returns the object with the settings used for calls to deleteTagValue. */
  public OperationCallSettings<DeleteTagValueRequest, TagValue, DeleteTagValueMetadata>
      deleteTagValueOperationSettings() {
    return ((TagValuesStubSettings) getStubSettings()).deleteTagValueOperationSettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((TagValuesStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((TagValuesStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((TagValuesStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final TagValuesSettings create(TagValuesStubSettings stub) throws IOException {
    return new TagValuesSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return TagValuesStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return TagValuesStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return TagValuesStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return TagValuesStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return TagValuesStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return TagValuesStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return TagValuesStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return TagValuesStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected TagValuesSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for TagValuesSettings. */
  public static class Builder extends ClientSettings.Builder<TagValuesSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(TagValuesStubSettings.newBuilder(clientContext));
    }

    protected Builder(TagValuesSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(TagValuesStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(TagValuesStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(TagValuesStubSettings.newHttpJsonBuilder());
    }

    public TagValuesStubSettings.Builder getStubSettingsBuilder() {
      return ((TagValuesStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listTagValues. */
    public PagedCallSettings.Builder<
            ListTagValuesRequest, ListTagValuesResponse, ListTagValuesPagedResponse>
        listTagValuesSettings() {
      return getStubSettingsBuilder().listTagValuesSettings();
    }

    /** Returns the builder for the settings used for calls to getTagValue. */
    public UnaryCallSettings.Builder<GetTagValueRequest, TagValue> getTagValueSettings() {
      return getStubSettingsBuilder().getTagValueSettings();
    }

    /** Returns the builder for the settings used for calls to createTagValue. */
    public UnaryCallSettings.Builder<CreateTagValueRequest, Operation> createTagValueSettings() {
      return getStubSettingsBuilder().createTagValueSettings();
    }

    /** Returns the builder for the settings used for calls to createTagValue. */
    public OperationCallSettings.Builder<CreateTagValueRequest, TagValue, CreateTagValueMetadata>
        createTagValueOperationSettings() {
      return getStubSettingsBuilder().createTagValueOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateTagValue. */
    public UnaryCallSettings.Builder<UpdateTagValueRequest, Operation> updateTagValueSettings() {
      return getStubSettingsBuilder().updateTagValueSettings();
    }

    /** Returns the builder for the settings used for calls to updateTagValue. */
    public OperationCallSettings.Builder<UpdateTagValueRequest, TagValue, UpdateTagValueMetadata>
        updateTagValueOperationSettings() {
      return getStubSettingsBuilder().updateTagValueOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTagValue. */
    public UnaryCallSettings.Builder<DeleteTagValueRequest, Operation> deleteTagValueSettings() {
      return getStubSettingsBuilder().deleteTagValueSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTagValue. */
    public OperationCallSettings.Builder<DeleteTagValueRequest, TagValue, DeleteTagValueMetadata>
        deleteTagValueOperationSettings() {
      return getStubSettingsBuilder().deleteTagValueOperationSettings();
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
    public TagValuesSettings build() throws IOException {
      return new TagValuesSettings(this);
    }
  }
}
