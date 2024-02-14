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

package com.google.cloud.resourcemanager.v3;

import static com.google.cloud.resourcemanager.v3.TagHoldsClient.ListTagHoldsPagedResponse;

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
import com.google.cloud.resourcemanager.v3.stub.TagHoldsStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link TagHoldsClient}.
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
 * <p>For example, to set the total timeout of createTagHold to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TagHoldsSettings.Builder tagHoldsSettingsBuilder = TagHoldsSettings.newBuilder();
 * tagHoldsSettingsBuilder
 *     .createTagHoldSettings()
 *     .setRetrySettings(
 *         tagHoldsSettingsBuilder
 *             .createTagHoldSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * TagHoldsSettings tagHoldsSettings = tagHoldsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class TagHoldsSettings extends ClientSettings<TagHoldsSettings> {

  /** Returns the object with the settings used for calls to createTagHold. */
  public UnaryCallSettings<CreateTagHoldRequest, Operation> createTagHoldSettings() {
    return ((TagHoldsStubSettings) getStubSettings()).createTagHoldSettings();
  }

  /** Returns the object with the settings used for calls to createTagHold. */
  public OperationCallSettings<CreateTagHoldRequest, TagHold, CreateTagHoldMetadata>
      createTagHoldOperationSettings() {
    return ((TagHoldsStubSettings) getStubSettings()).createTagHoldOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteTagHold. */
  public UnaryCallSettings<DeleteTagHoldRequest, Operation> deleteTagHoldSettings() {
    return ((TagHoldsStubSettings) getStubSettings()).deleteTagHoldSettings();
  }

  /** Returns the object with the settings used for calls to deleteTagHold. */
  public OperationCallSettings<DeleteTagHoldRequest, Empty, DeleteTagHoldMetadata>
      deleteTagHoldOperationSettings() {
    return ((TagHoldsStubSettings) getStubSettings()).deleteTagHoldOperationSettings();
  }

  /** Returns the object with the settings used for calls to listTagHolds. */
  public PagedCallSettings<ListTagHoldsRequest, ListTagHoldsResponse, ListTagHoldsPagedResponse>
      listTagHoldsSettings() {
    return ((TagHoldsStubSettings) getStubSettings()).listTagHoldsSettings();
  }

  public static final TagHoldsSettings create(TagHoldsStubSettings stub) throws IOException {
    return new TagHoldsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return TagHoldsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return TagHoldsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return TagHoldsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return TagHoldsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return TagHoldsStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return TagHoldsStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return TagHoldsStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return TagHoldsStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected TagHoldsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for TagHoldsSettings. */
  public static class Builder extends ClientSettings.Builder<TagHoldsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(TagHoldsStubSettings.newBuilder(clientContext));
    }

    protected Builder(TagHoldsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(TagHoldsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(TagHoldsStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(TagHoldsStubSettings.newHttpJsonBuilder());
    }

    public TagHoldsStubSettings.Builder getStubSettingsBuilder() {
      return ((TagHoldsStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createTagHold. */
    public UnaryCallSettings.Builder<CreateTagHoldRequest, Operation> createTagHoldSettings() {
      return getStubSettingsBuilder().createTagHoldSettings();
    }

    /** Returns the builder for the settings used for calls to createTagHold. */
    public OperationCallSettings.Builder<CreateTagHoldRequest, TagHold, CreateTagHoldMetadata>
        createTagHoldOperationSettings() {
      return getStubSettingsBuilder().createTagHoldOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTagHold. */
    public UnaryCallSettings.Builder<DeleteTagHoldRequest, Operation> deleteTagHoldSettings() {
      return getStubSettingsBuilder().deleteTagHoldSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTagHold. */
    public OperationCallSettings.Builder<DeleteTagHoldRequest, Empty, DeleteTagHoldMetadata>
        deleteTagHoldOperationSettings() {
      return getStubSettingsBuilder().deleteTagHoldOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listTagHolds. */
    public PagedCallSettings.Builder<
            ListTagHoldsRequest, ListTagHoldsResponse, ListTagHoldsPagedResponse>
        listTagHoldsSettings() {
      return getStubSettingsBuilder().listTagHoldsSettings();
    }

    @Override
    public TagHoldsSettings build() throws IOException {
      return new TagHoldsSettings(this);
    }
  }
}
