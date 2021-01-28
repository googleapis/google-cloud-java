/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.monitoring.v3.stub;

import static com.google.cloud.monitoring.v3.GroupServiceClient.ListGroupMembersPagedResponse;
import static com.google.cloud.monitoring.v3.GroupServiceClient.ListGroupsPagedResponse;

import com.google.api.MonitoredResource;
import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
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
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link GroupServiceStub}.
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
 * GroupServiceStubSettings.Builder groupServiceSettingsBuilder =
 *     GroupServiceStubSettings.newBuilder();
 * groupServiceSettingsBuilder
 *     .getGroupSettings()
 *     .setRetrySettings(
 *         groupServiceSettingsBuilder
 *             .getGroupSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * GroupServiceStubSettings groupServiceSettings = groupServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GroupServiceStubSettings extends StubSettings<GroupServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/monitoring")
          .add("https://www.googleapis.com/auth/monitoring.read")
          .build();

  private final PagedCallSettings<ListGroupsRequest, ListGroupsResponse, ListGroupsPagedResponse>
      listGroupsSettings;
  private final UnaryCallSettings<GetGroupRequest, Group> getGroupSettings;
  private final UnaryCallSettings<CreateGroupRequest, Group> createGroupSettings;
  private final UnaryCallSettings<UpdateGroupRequest, Group> updateGroupSettings;
  private final UnaryCallSettings<DeleteGroupRequest, Empty> deleteGroupSettings;
  private final PagedCallSettings<
          ListGroupMembersRequest, ListGroupMembersResponse, ListGroupMembersPagedResponse>
      listGroupMembersSettings;

  private static final PagedListDescriptor<ListGroupsRequest, ListGroupsResponse, Group>
      LIST_GROUPS_PAGE_STR_DESC =
          new PagedListDescriptor<ListGroupsRequest, ListGroupsResponse, Group>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListGroupsRequest injectToken(ListGroupsRequest payload, String token) {
              return ListGroupsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListGroupsRequest injectPageSize(ListGroupsRequest payload, int pageSize) {
              return ListGroupsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListGroupsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListGroupsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Group> extractResources(ListGroupsResponse payload) {
              return payload.getGroupList() == null
                  ? ImmutableList.<Group>of()
                  : payload.getGroupList();
            }
          };

  private static final PagedListDescriptor<
          ListGroupMembersRequest, ListGroupMembersResponse, MonitoredResource>
      LIST_GROUP_MEMBERS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListGroupMembersRequest, ListGroupMembersResponse, MonitoredResource>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListGroupMembersRequest injectToken(
                ListGroupMembersRequest payload, String token) {
              return ListGroupMembersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListGroupMembersRequest injectPageSize(
                ListGroupMembersRequest payload, int pageSize) {
              return ListGroupMembersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListGroupMembersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListGroupMembersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<MonitoredResource> extractResources(ListGroupMembersResponse payload) {
              return payload.getMembersList() == null
                  ? ImmutableList.<MonitoredResource>of()
                  : payload.getMembersList();
            }
          };

  private static final PagedListResponseFactory<
          ListGroupsRequest, ListGroupsResponse, ListGroupsPagedResponse>
      LIST_GROUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListGroupsRequest, ListGroupsResponse, ListGroupsPagedResponse>() {
            @Override
            public ApiFuture<ListGroupsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListGroupsRequest, ListGroupsResponse> callable,
                ListGroupsRequest request,
                ApiCallContext context,
                ApiFuture<ListGroupsResponse> futureResponse) {
              PageContext<ListGroupsRequest, ListGroupsResponse, Group> pageContext =
                  PageContext.create(callable, LIST_GROUPS_PAGE_STR_DESC, request, context);
              return ListGroupsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListGroupMembersRequest, ListGroupMembersResponse, ListGroupMembersPagedResponse>
      LIST_GROUP_MEMBERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListGroupMembersRequest, ListGroupMembersResponse, ListGroupMembersPagedResponse>() {
            @Override
            public ApiFuture<ListGroupMembersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListGroupMembersRequest, ListGroupMembersResponse> callable,
                ListGroupMembersRequest request,
                ApiCallContext context,
                ApiFuture<ListGroupMembersResponse> futureResponse) {
              PageContext<ListGroupMembersRequest, ListGroupMembersResponse, MonitoredResource>
                  pageContext =
                      PageContext.create(
                          callable, LIST_GROUP_MEMBERS_PAGE_STR_DESC, request, context);
              return ListGroupMembersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listGroups. */
  public PagedCallSettings<ListGroupsRequest, ListGroupsResponse, ListGroupsPagedResponse>
      listGroupsSettings() {
    return listGroupsSettings;
  }

  /** Returns the object with the settings used for calls to getGroup. */
  public UnaryCallSettings<GetGroupRequest, Group> getGroupSettings() {
    return getGroupSettings;
  }

  /** Returns the object with the settings used for calls to createGroup. */
  public UnaryCallSettings<CreateGroupRequest, Group> createGroupSettings() {
    return createGroupSettings;
  }

  /** Returns the object with the settings used for calls to updateGroup. */
  public UnaryCallSettings<UpdateGroupRequest, Group> updateGroupSettings() {
    return updateGroupSettings;
  }

  /** Returns the object with the settings used for calls to deleteGroup. */
  public UnaryCallSettings<DeleteGroupRequest, Empty> deleteGroupSettings() {
    return deleteGroupSettings;
  }

  /** Returns the object with the settings used for calls to listGroupMembers. */
  public PagedCallSettings<
          ListGroupMembersRequest, ListGroupMembersResponse, ListGroupMembersPagedResponse>
      listGroupMembersSettings() {
    return listGroupMembersSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public GroupServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcGroupServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "monitoring.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder().setScopesToApply(DEFAULT_SERVICE_SCOPES);
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(GroupServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
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

  protected GroupServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listGroupsSettings = settingsBuilder.listGroupsSettings().build();
    getGroupSettings = settingsBuilder.getGroupSettings().build();
    createGroupSettings = settingsBuilder.createGroupSettings().build();
    updateGroupSettings = settingsBuilder.updateGroupSettings().build();
    deleteGroupSettings = settingsBuilder.deleteGroupSettings().build();
    listGroupMembersSettings = settingsBuilder.listGroupMembersSettings().build();
  }

  /** Builder for GroupServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<GroupServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListGroupsRequest, ListGroupsResponse, ListGroupsPagedResponse>
        listGroupsSettings;
    private final UnaryCallSettings.Builder<GetGroupRequest, Group> getGroupSettings;
    private final UnaryCallSettings.Builder<CreateGroupRequest, Group> createGroupSettings;
    private final UnaryCallSettings.Builder<UpdateGroupRequest, Group> updateGroupSettings;
    private final UnaryCallSettings.Builder<DeleteGroupRequest, Empty> deleteGroupSettings;
    private final PagedCallSettings.Builder<
            ListGroupMembersRequest, ListGroupMembersResponse, ListGroupMembersPagedResponse>
        listGroupMembersSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_1_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_2_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(30000L))
              .setInitialRpcTimeout(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(30000L))
              .setTotalTimeout(Duration.ofMillis(30000L))
              .build();
      definitions.put("retry_policy_1_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(30000L))
              .setTotalTimeout(Duration.ofMillis(30000L))
              .build();
      definitions.put("no_retry_2_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listGroupsSettings = PagedCallSettings.newBuilder(LIST_GROUPS_PAGE_STR_FACT);
      getGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listGroupMembersSettings = PagedCallSettings.newBuilder(LIST_GROUP_MEMBERS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listGroupsSettings,
              getGroupSettings,
              createGroupSettings,
              updateGroupSettings,
              deleteGroupSettings,
              listGroupMembersSettings);
      initDefaults(this);
    }

    protected Builder(GroupServiceStubSettings settings) {
      super(settings);

      listGroupsSettings = settings.listGroupsSettings.toBuilder();
      getGroupSettings = settings.getGroupSettings.toBuilder();
      createGroupSettings = settings.createGroupSettings.toBuilder();
      updateGroupSettings = settings.updateGroupSettings.toBuilder();
      deleteGroupSettings = settings.deleteGroupSettings.toBuilder();
      listGroupMembersSettings = settings.listGroupMembersSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listGroupsSettings,
              getGroupSettings,
              createGroupSettings,
              updateGroupSettings,
              deleteGroupSettings,
              listGroupMembersSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .listGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .createGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .updateGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .deleteGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listGroupMembersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      return builder;
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to listGroups. */
    public PagedCallSettings.Builder<ListGroupsRequest, ListGroupsResponse, ListGroupsPagedResponse>
        listGroupsSettings() {
      return listGroupsSettings;
    }

    /** Returns the builder for the settings used for calls to getGroup. */
    public UnaryCallSettings.Builder<GetGroupRequest, Group> getGroupSettings() {
      return getGroupSettings;
    }

    /** Returns the builder for the settings used for calls to createGroup. */
    public UnaryCallSettings.Builder<CreateGroupRequest, Group> createGroupSettings() {
      return createGroupSettings;
    }

    /** Returns the builder for the settings used for calls to updateGroup. */
    public UnaryCallSettings.Builder<UpdateGroupRequest, Group> updateGroupSettings() {
      return updateGroupSettings;
    }

    /** Returns the builder for the settings used for calls to deleteGroup. */
    public UnaryCallSettings.Builder<DeleteGroupRequest, Empty> deleteGroupSettings() {
      return deleteGroupSettings;
    }

    /** Returns the builder for the settings used for calls to listGroupMembers. */
    public PagedCallSettings.Builder<
            ListGroupMembersRequest, ListGroupMembersResponse, ListGroupMembersPagedResponse>
        listGroupMembersSettings() {
      return listGroupMembersSettings;
    }

    @Override
    public GroupServiceStubSettings build() throws IOException {
      return new GroupServiceStubSettings(this);
    }
  }
}
