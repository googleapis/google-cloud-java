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

package com.google.cloud.monitoring.v3;

import static com.google.cloud.monitoring.v3.GroupServiceClient.ListGroupMembersPagedResponse;
import static com.google.cloud.monitoring.v3.GroupServiceClient.ListGroupsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.monitoring.v3.stub.GroupServiceStubSettings;
import com.google.monitoring.v3.CreateGroupRequest;
import com.google.monitoring.v3.DeleteGroupRequest;
import com.google.monitoring.v3.GetGroupRequest;
import com.google.monitoring.v3.Group;
import com.google.monitoring.v3.ListGroupMembersRequest;
import com.google.monitoring.v3.ListGroupMembersResponse;
import com.google.monitoring.v3.ListGroupsRequest;
import com.google.monitoring.v3.ListGroupsResponse;
import com.google.monitoring.v3.UpdateGroupRequest;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link GroupServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (monitoring.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getGroup to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * GroupServiceSettings.Builder groupServiceSettingsBuilder = GroupServiceSettings.newBuilder();
 * groupServiceSettingsBuilder
 *     .getGroupSettings()
 *     .setRetrySettings(
 *         groupServiceSettingsBuilder.getGroupSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * GroupServiceSettings groupServiceSettings = groupServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class GroupServiceSettings extends ClientSettings<GroupServiceSettings> {

  /** Returns the object with the settings used for calls to listGroups. */
  public PagedCallSettings<ListGroupsRequest, ListGroupsResponse, ListGroupsPagedResponse>
      listGroupsSettings() {
    return ((GroupServiceStubSettings) getStubSettings()).listGroupsSettings();
  }

  /** Returns the object with the settings used for calls to getGroup. */
  public UnaryCallSettings<GetGroupRequest, Group> getGroupSettings() {
    return ((GroupServiceStubSettings) getStubSettings()).getGroupSettings();
  }

  /** Returns the object with the settings used for calls to createGroup. */
  public UnaryCallSettings<CreateGroupRequest, Group> createGroupSettings() {
    return ((GroupServiceStubSettings) getStubSettings()).createGroupSettings();
  }

  /** Returns the object with the settings used for calls to updateGroup. */
  public UnaryCallSettings<UpdateGroupRequest, Group> updateGroupSettings() {
    return ((GroupServiceStubSettings) getStubSettings()).updateGroupSettings();
  }

  /** Returns the object with the settings used for calls to deleteGroup. */
  public UnaryCallSettings<DeleteGroupRequest, Empty> deleteGroupSettings() {
    return ((GroupServiceStubSettings) getStubSettings()).deleteGroupSettings();
  }

  /** Returns the object with the settings used for calls to listGroupMembers. */
  public PagedCallSettings<
          ListGroupMembersRequest, ListGroupMembersResponse, ListGroupMembersPagedResponse>
      listGroupMembersSettings() {
    return ((GroupServiceStubSettings) getStubSettings()).listGroupMembersSettings();
  }

  public static final GroupServiceSettings create(GroupServiceStubSettings stub)
      throws IOException {
    return new GroupServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return GroupServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return GroupServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return GroupServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GroupServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return GroupServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return GroupServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return GroupServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected GroupServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for GroupServiceSettings. */
  public static class Builder extends ClientSettings.Builder<GroupServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(GroupServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(GroupServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(GroupServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(GroupServiceStubSettings.newBuilder());
    }

    public GroupServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((GroupServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listGroups. */
    public PagedCallSettings.Builder<ListGroupsRequest, ListGroupsResponse, ListGroupsPagedResponse>
        listGroupsSettings() {
      return getStubSettingsBuilder().listGroupsSettings();
    }

    /** Returns the builder for the settings used for calls to getGroup. */
    public UnaryCallSettings.Builder<GetGroupRequest, Group> getGroupSettings() {
      return getStubSettingsBuilder().getGroupSettings();
    }

    /** Returns the builder for the settings used for calls to createGroup. */
    public UnaryCallSettings.Builder<CreateGroupRequest, Group> createGroupSettings() {
      return getStubSettingsBuilder().createGroupSettings();
    }

    /** Returns the builder for the settings used for calls to updateGroup. */
    public UnaryCallSettings.Builder<UpdateGroupRequest, Group> updateGroupSettings() {
      return getStubSettingsBuilder().updateGroupSettings();
    }

    /** Returns the builder for the settings used for calls to deleteGroup. */
    public UnaryCallSettings.Builder<DeleteGroupRequest, Empty> deleteGroupSettings() {
      return getStubSettingsBuilder().deleteGroupSettings();
    }

    /** Returns the builder for the settings used for calls to listGroupMembers. */
    public PagedCallSettings.Builder<
            ListGroupMembersRequest, ListGroupMembersResponse, ListGroupMembersPagedResponse>
        listGroupMembersSettings() {
      return getStubSettingsBuilder().listGroupMembersSettings();
    }

    @Override
    public GroupServiceSettings build() throws IOException {
      return new GroupServiceSettings(this);
    }
  }
}
