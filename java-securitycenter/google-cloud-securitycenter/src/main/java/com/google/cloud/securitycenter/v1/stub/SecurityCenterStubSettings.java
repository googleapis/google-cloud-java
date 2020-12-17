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

package com.google.cloud.securitycenter.v1.stub;

import static com.google.cloud.securitycenter.v1.SecurityCenterClient.GroupAssetsPagedResponse;
import static com.google.cloud.securitycenter.v1.SecurityCenterClient.GroupFindingsPagedResponse;
import static com.google.cloud.securitycenter.v1.SecurityCenterClient.ListAssetsPagedResponse;
import static com.google.cloud.securitycenter.v1.SecurityCenterClient.ListFindingsPagedResponse;
import static com.google.cloud.securitycenter.v1.SecurityCenterClient.ListNotificationConfigsPagedResponse;
import static com.google.cloud.securitycenter.v1.SecurityCenterClient.ListSourcesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.securitycenter.v1.CreateFindingRequest;
import com.google.cloud.securitycenter.v1.CreateNotificationConfigRequest;
import com.google.cloud.securitycenter.v1.CreateSourceRequest;
import com.google.cloud.securitycenter.v1.DeleteNotificationConfigRequest;
import com.google.cloud.securitycenter.v1.Finding;
import com.google.cloud.securitycenter.v1.GetNotificationConfigRequest;
import com.google.cloud.securitycenter.v1.GetOrganizationSettingsRequest;
import com.google.cloud.securitycenter.v1.GetSourceRequest;
import com.google.cloud.securitycenter.v1.GroupAssetsRequest;
import com.google.cloud.securitycenter.v1.GroupAssetsResponse;
import com.google.cloud.securitycenter.v1.GroupFindingsRequest;
import com.google.cloud.securitycenter.v1.GroupFindingsResponse;
import com.google.cloud.securitycenter.v1.GroupResult;
import com.google.cloud.securitycenter.v1.ListAssetsRequest;
import com.google.cloud.securitycenter.v1.ListAssetsResponse;
import com.google.cloud.securitycenter.v1.ListFindingsRequest;
import com.google.cloud.securitycenter.v1.ListFindingsResponse;
import com.google.cloud.securitycenter.v1.ListNotificationConfigsRequest;
import com.google.cloud.securitycenter.v1.ListNotificationConfigsResponse;
import com.google.cloud.securitycenter.v1.ListSourcesRequest;
import com.google.cloud.securitycenter.v1.ListSourcesResponse;
import com.google.cloud.securitycenter.v1.NotificationConfig;
import com.google.cloud.securitycenter.v1.OrganizationSettings;
import com.google.cloud.securitycenter.v1.RunAssetDiscoveryRequest;
import com.google.cloud.securitycenter.v1.RunAssetDiscoveryResponse;
import com.google.cloud.securitycenter.v1.SecurityMarks;
import com.google.cloud.securitycenter.v1.SetFindingStateRequest;
import com.google.cloud.securitycenter.v1.Source;
import com.google.cloud.securitycenter.v1.UpdateFindingRequest;
import com.google.cloud.securitycenter.v1.UpdateNotificationConfigRequest;
import com.google.cloud.securitycenter.v1.UpdateOrganizationSettingsRequest;
import com.google.cloud.securitycenter.v1.UpdateSecurityMarksRequest;
import com.google.cloud.securitycenter.v1.UpdateSourceRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SecurityCenterStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (securitycenter.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createSource to 30 seconds:
 *
 * <pre>{@code
 * SecurityCenterStubSettings.Builder securityCenterSettingsBuilder =
 *     SecurityCenterStubSettings.newBuilder();
 * securityCenterSettingsBuilder
 *     .createSourceSettings()
 *     .setRetrySettings(
 *         securityCenterSettingsBuilder
 *             .createSourceSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * SecurityCenterStubSettings securityCenterSettings = securityCenterSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class SecurityCenterStubSettings extends StubSettings<SecurityCenterStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateSourceRequest, Source> createSourceSettings;
  private final UnaryCallSettings<CreateFindingRequest, Finding> createFindingSettings;
  private final UnaryCallSettings<CreateNotificationConfigRequest, NotificationConfig>
      createNotificationConfigSettings;
  private final UnaryCallSettings<DeleteNotificationConfigRequest, Empty>
      deleteNotificationConfigSettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<GetNotificationConfigRequest, NotificationConfig>
      getNotificationConfigSettings;
  private final UnaryCallSettings<GetOrganizationSettingsRequest, OrganizationSettings>
      getOrganizationSettingsSettings;
  private final UnaryCallSettings<GetSourceRequest, Source> getSourceSettings;
  private final PagedCallSettings<GroupAssetsRequest, GroupAssetsResponse, GroupAssetsPagedResponse>
      groupAssetsSettings;
  private final PagedCallSettings<
          GroupFindingsRequest, GroupFindingsResponse, GroupFindingsPagedResponse>
      groupFindingsSettings;
  private final PagedCallSettings<ListAssetsRequest, ListAssetsResponse, ListAssetsPagedResponse>
      listAssetsSettings;
  private final PagedCallSettings<
          ListFindingsRequest, ListFindingsResponse, ListFindingsPagedResponse>
      listFindingsSettings;
  private final PagedCallSettings<
          ListNotificationConfigsRequest,
          ListNotificationConfigsResponse,
          ListNotificationConfigsPagedResponse>
      listNotificationConfigsSettings;
  private final PagedCallSettings<ListSourcesRequest, ListSourcesResponse, ListSourcesPagedResponse>
      listSourcesSettings;
  private final UnaryCallSettings<RunAssetDiscoveryRequest, Operation> runAssetDiscoverySettings;
  private final OperationCallSettings<RunAssetDiscoveryRequest, RunAssetDiscoveryResponse, Empty>
      runAssetDiscoveryOperationSettings;
  private final UnaryCallSettings<SetFindingStateRequest, Finding> setFindingStateSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;
  private final UnaryCallSettings<UpdateFindingRequest, Finding> updateFindingSettings;
  private final UnaryCallSettings<UpdateNotificationConfigRequest, NotificationConfig>
      updateNotificationConfigSettings;
  private final UnaryCallSettings<UpdateOrganizationSettingsRequest, OrganizationSettings>
      updateOrganizationSettingsSettings;
  private final UnaryCallSettings<UpdateSourceRequest, Source> updateSourceSettings;
  private final UnaryCallSettings<UpdateSecurityMarksRequest, SecurityMarks>
      updateSecurityMarksSettings;

  private static final PagedListDescriptor<GroupAssetsRequest, GroupAssetsResponse, GroupResult>
      GROUP_ASSETS_PAGE_STR_DESC =
          new PagedListDescriptor<GroupAssetsRequest, GroupAssetsResponse, GroupResult>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public GroupAssetsRequest injectToken(GroupAssetsRequest payload, String token) {
              return GroupAssetsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public GroupAssetsRequest injectPageSize(GroupAssetsRequest payload, int pageSize) {
              return GroupAssetsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(GroupAssetsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(GroupAssetsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<GroupResult> extractResources(GroupAssetsResponse payload) {
              return payload.getGroupByResultsList() == null
                  ? ImmutableList.<GroupResult>of()
                  : payload.getGroupByResultsList();
            }
          };

  private static final PagedListDescriptor<GroupFindingsRequest, GroupFindingsResponse, GroupResult>
      GROUP_FINDINGS_PAGE_STR_DESC =
          new PagedListDescriptor<GroupFindingsRequest, GroupFindingsResponse, GroupResult>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public GroupFindingsRequest injectToken(GroupFindingsRequest payload, String token) {
              return GroupFindingsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public GroupFindingsRequest injectPageSize(GroupFindingsRequest payload, int pageSize) {
              return GroupFindingsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(GroupFindingsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(GroupFindingsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<GroupResult> extractResources(GroupFindingsResponse payload) {
              return payload.getGroupByResultsList() == null
                  ? ImmutableList.<GroupResult>of()
                  : payload.getGroupByResultsList();
            }
          };

  private static final PagedListDescriptor<
          ListAssetsRequest, ListAssetsResponse, ListAssetsResponse.ListAssetsResult>
      LIST_ASSETS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAssetsRequest, ListAssetsResponse, ListAssetsResponse.ListAssetsResult>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAssetsRequest injectToken(ListAssetsRequest payload, String token) {
              return ListAssetsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAssetsRequest injectPageSize(ListAssetsRequest payload, int pageSize) {
              return ListAssetsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAssetsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAssetsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ListAssetsResponse.ListAssetsResult> extractResources(
                ListAssetsResponse payload) {
              return payload.getListAssetsResultsList() == null
                  ? ImmutableList.<ListAssetsResponse.ListAssetsResult>of()
                  : payload.getListAssetsResultsList();
            }
          };

  private static final PagedListDescriptor<
          ListFindingsRequest, ListFindingsResponse, ListFindingsResponse.ListFindingsResult>
      LIST_FINDINGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListFindingsRequest,
              ListFindingsResponse,
              ListFindingsResponse.ListFindingsResult>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFindingsRequest injectToken(ListFindingsRequest payload, String token) {
              return ListFindingsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListFindingsRequest injectPageSize(ListFindingsRequest payload, int pageSize) {
              return ListFindingsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListFindingsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListFindingsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ListFindingsResponse.ListFindingsResult> extractResources(
                ListFindingsResponse payload) {
              return payload.getListFindingsResultsList() == null
                  ? ImmutableList.<ListFindingsResponse.ListFindingsResult>of()
                  : payload.getListFindingsResultsList();
            }
          };

  private static final PagedListDescriptor<
          ListNotificationConfigsRequest, ListNotificationConfigsResponse, NotificationConfig>
      LIST_NOTIFICATION_CONFIGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListNotificationConfigsRequest,
              ListNotificationConfigsResponse,
              NotificationConfig>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListNotificationConfigsRequest injectToken(
                ListNotificationConfigsRequest payload, String token) {
              return ListNotificationConfigsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListNotificationConfigsRequest injectPageSize(
                ListNotificationConfigsRequest payload, int pageSize) {
              return ListNotificationConfigsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListNotificationConfigsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListNotificationConfigsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<NotificationConfig> extractResources(
                ListNotificationConfigsResponse payload) {
              return payload.getNotificationConfigsList() == null
                  ? ImmutableList.<NotificationConfig>of()
                  : payload.getNotificationConfigsList();
            }
          };

  private static final PagedListDescriptor<ListSourcesRequest, ListSourcesResponse, Source>
      LIST_SOURCES_PAGE_STR_DESC =
          new PagedListDescriptor<ListSourcesRequest, ListSourcesResponse, Source>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSourcesRequest injectToken(ListSourcesRequest payload, String token) {
              return ListSourcesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSourcesRequest injectPageSize(ListSourcesRequest payload, int pageSize) {
              return ListSourcesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSourcesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSourcesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Source> extractResources(ListSourcesResponse payload) {
              return payload.getSourcesList() == null
                  ? ImmutableList.<Source>of()
                  : payload.getSourcesList();
            }
          };

  private static final PagedListResponseFactory<
          GroupAssetsRequest, GroupAssetsResponse, GroupAssetsPagedResponse>
      GROUP_ASSETS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              GroupAssetsRequest, GroupAssetsResponse, GroupAssetsPagedResponse>() {
            @Override
            public ApiFuture<GroupAssetsPagedResponse> getFuturePagedResponse(
                UnaryCallable<GroupAssetsRequest, GroupAssetsResponse> callable,
                GroupAssetsRequest request,
                ApiCallContext context,
                ApiFuture<GroupAssetsResponse> futureResponse) {
              PageContext<GroupAssetsRequest, GroupAssetsResponse, GroupResult> pageContext =
                  PageContext.create(callable, GROUP_ASSETS_PAGE_STR_DESC, request, context);
              return GroupAssetsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          GroupFindingsRequest, GroupFindingsResponse, GroupFindingsPagedResponse>
      GROUP_FINDINGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              GroupFindingsRequest, GroupFindingsResponse, GroupFindingsPagedResponse>() {
            @Override
            public ApiFuture<GroupFindingsPagedResponse> getFuturePagedResponse(
                UnaryCallable<GroupFindingsRequest, GroupFindingsResponse> callable,
                GroupFindingsRequest request,
                ApiCallContext context,
                ApiFuture<GroupFindingsResponse> futureResponse) {
              PageContext<GroupFindingsRequest, GroupFindingsResponse, GroupResult> pageContext =
                  PageContext.create(callable, GROUP_FINDINGS_PAGE_STR_DESC, request, context);
              return GroupFindingsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAssetsRequest, ListAssetsResponse, ListAssetsPagedResponse>
      LIST_ASSETS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAssetsRequest, ListAssetsResponse, ListAssetsPagedResponse>() {
            @Override
            public ApiFuture<ListAssetsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAssetsRequest, ListAssetsResponse> callable,
                ListAssetsRequest request,
                ApiCallContext context,
                ApiFuture<ListAssetsResponse> futureResponse) {
              PageContext<
                      ListAssetsRequest, ListAssetsResponse, ListAssetsResponse.ListAssetsResult>
                  pageContext =
                      PageContext.create(callable, LIST_ASSETS_PAGE_STR_DESC, request, context);
              return ListAssetsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListFindingsRequest, ListFindingsResponse, ListFindingsPagedResponse>
      LIST_FINDINGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFindingsRequest, ListFindingsResponse, ListFindingsPagedResponse>() {
            @Override
            public ApiFuture<ListFindingsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListFindingsRequest, ListFindingsResponse> callable,
                ListFindingsRequest request,
                ApiCallContext context,
                ApiFuture<ListFindingsResponse> futureResponse) {
              PageContext<
                      ListFindingsRequest,
                      ListFindingsResponse,
                      ListFindingsResponse.ListFindingsResult>
                  pageContext =
                      PageContext.create(callable, LIST_FINDINGS_PAGE_STR_DESC, request, context);
              return ListFindingsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListNotificationConfigsRequest,
          ListNotificationConfigsResponse,
          ListNotificationConfigsPagedResponse>
      LIST_NOTIFICATION_CONFIGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListNotificationConfigsRequest,
              ListNotificationConfigsResponse,
              ListNotificationConfigsPagedResponse>() {
            @Override
            public ApiFuture<ListNotificationConfigsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListNotificationConfigsRequest, ListNotificationConfigsResponse>
                    callable,
                ListNotificationConfigsRequest request,
                ApiCallContext context,
                ApiFuture<ListNotificationConfigsResponse> futureResponse) {
              PageContext<
                      ListNotificationConfigsRequest,
                      ListNotificationConfigsResponse,
                      NotificationConfig>
                  pageContext =
                      PageContext.create(
                          callable, LIST_NOTIFICATION_CONFIGS_PAGE_STR_DESC, request, context);
              return ListNotificationConfigsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListSourcesRequest, ListSourcesResponse, ListSourcesPagedResponse>
      LIST_SOURCES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSourcesRequest, ListSourcesResponse, ListSourcesPagedResponse>() {
            @Override
            public ApiFuture<ListSourcesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSourcesRequest, ListSourcesResponse> callable,
                ListSourcesRequest request,
                ApiCallContext context,
                ApiFuture<ListSourcesResponse> futureResponse) {
              PageContext<ListSourcesRequest, ListSourcesResponse, Source> pageContext =
                  PageContext.create(callable, LIST_SOURCES_PAGE_STR_DESC, request, context);
              return ListSourcesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createSource. */
  public UnaryCallSettings<CreateSourceRequest, Source> createSourceSettings() {
    return createSourceSettings;
  }

  /** Returns the object with the settings used for calls to createFinding. */
  public UnaryCallSettings<CreateFindingRequest, Finding> createFindingSettings() {
    return createFindingSettings;
  }

  /** Returns the object with the settings used for calls to createNotificationConfig. */
  public UnaryCallSettings<CreateNotificationConfigRequest, NotificationConfig>
      createNotificationConfigSettings() {
    return createNotificationConfigSettings;
  }

  /** Returns the object with the settings used for calls to deleteNotificationConfig. */
  public UnaryCallSettings<DeleteNotificationConfigRequest, Empty>
      deleteNotificationConfigSettings() {
    return deleteNotificationConfigSettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to getNotificationConfig. */
  public UnaryCallSettings<GetNotificationConfigRequest, NotificationConfig>
      getNotificationConfigSettings() {
    return getNotificationConfigSettings;
  }

  /** Returns the object with the settings used for calls to getOrganizationSettings. */
  public UnaryCallSettings<GetOrganizationSettingsRequest, OrganizationSettings>
      getOrganizationSettingsSettings() {
    return getOrganizationSettingsSettings;
  }

  /** Returns the object with the settings used for calls to getSource. */
  public UnaryCallSettings<GetSourceRequest, Source> getSourceSettings() {
    return getSourceSettings;
  }

  /** Returns the object with the settings used for calls to groupAssets. */
  public PagedCallSettings<GroupAssetsRequest, GroupAssetsResponse, GroupAssetsPagedResponse>
      groupAssetsSettings() {
    return groupAssetsSettings;
  }

  /** Returns the object with the settings used for calls to groupFindings. */
  public PagedCallSettings<GroupFindingsRequest, GroupFindingsResponse, GroupFindingsPagedResponse>
      groupFindingsSettings() {
    return groupFindingsSettings;
  }

  /** Returns the object with the settings used for calls to listAssets. */
  public PagedCallSettings<ListAssetsRequest, ListAssetsResponse, ListAssetsPagedResponse>
      listAssetsSettings() {
    return listAssetsSettings;
  }

  /** Returns the object with the settings used for calls to listFindings. */
  public PagedCallSettings<ListFindingsRequest, ListFindingsResponse, ListFindingsPagedResponse>
      listFindingsSettings() {
    return listFindingsSettings;
  }

  /** Returns the object with the settings used for calls to listNotificationConfigs. */
  public PagedCallSettings<
          ListNotificationConfigsRequest,
          ListNotificationConfigsResponse,
          ListNotificationConfigsPagedResponse>
      listNotificationConfigsSettings() {
    return listNotificationConfigsSettings;
  }

  /** Returns the object with the settings used for calls to listSources. */
  public PagedCallSettings<ListSourcesRequest, ListSourcesResponse, ListSourcesPagedResponse>
      listSourcesSettings() {
    return listSourcesSettings;
  }

  /** Returns the object with the settings used for calls to runAssetDiscovery. */
  public UnaryCallSettings<RunAssetDiscoveryRequest, Operation> runAssetDiscoverySettings() {
    return runAssetDiscoverySettings;
  }

  /** Returns the object with the settings used for calls to runAssetDiscovery. */
  public OperationCallSettings<RunAssetDiscoveryRequest, RunAssetDiscoveryResponse, Empty>
      runAssetDiscoveryOperationSettings() {
    return runAssetDiscoveryOperationSettings;
  }

  /** Returns the object with the settings used for calls to setFindingState. */
  public UnaryCallSettings<SetFindingStateRequest, Finding> setFindingStateSettings() {
    return setFindingStateSettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  /** Returns the object with the settings used for calls to updateFinding. */
  public UnaryCallSettings<UpdateFindingRequest, Finding> updateFindingSettings() {
    return updateFindingSettings;
  }

  /** Returns the object with the settings used for calls to updateNotificationConfig. */
  public UnaryCallSettings<UpdateNotificationConfigRequest, NotificationConfig>
      updateNotificationConfigSettings() {
    return updateNotificationConfigSettings;
  }

  /** Returns the object with the settings used for calls to updateOrganizationSettings. */
  public UnaryCallSettings<UpdateOrganizationSettingsRequest, OrganizationSettings>
      updateOrganizationSettingsSettings() {
    return updateOrganizationSettingsSettings;
  }

  /** Returns the object with the settings used for calls to updateSource. */
  public UnaryCallSettings<UpdateSourceRequest, Source> updateSourceSettings() {
    return updateSourceSettings;
  }

  /** Returns the object with the settings used for calls to updateSecurityMarks. */
  public UnaryCallSettings<UpdateSecurityMarksRequest, SecurityMarks>
      updateSecurityMarksSettings() {
    return updateSecurityMarksSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public SecurityCenterStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcSecurityCenterStub.create(this);
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
    return "securitycenter.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(SecurityCenterStubSettings.class))
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

  protected SecurityCenterStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createSourceSettings = settingsBuilder.createSourceSettings().build();
    createFindingSettings = settingsBuilder.createFindingSettings().build();
    createNotificationConfigSettings = settingsBuilder.createNotificationConfigSettings().build();
    deleteNotificationConfigSettings = settingsBuilder.deleteNotificationConfigSettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    getNotificationConfigSettings = settingsBuilder.getNotificationConfigSettings().build();
    getOrganizationSettingsSettings = settingsBuilder.getOrganizationSettingsSettings().build();
    getSourceSettings = settingsBuilder.getSourceSettings().build();
    groupAssetsSettings = settingsBuilder.groupAssetsSettings().build();
    groupFindingsSettings = settingsBuilder.groupFindingsSettings().build();
    listAssetsSettings = settingsBuilder.listAssetsSettings().build();
    listFindingsSettings = settingsBuilder.listFindingsSettings().build();
    listNotificationConfigsSettings = settingsBuilder.listNotificationConfigsSettings().build();
    listSourcesSettings = settingsBuilder.listSourcesSettings().build();
    runAssetDiscoverySettings = settingsBuilder.runAssetDiscoverySettings().build();
    runAssetDiscoveryOperationSettings =
        settingsBuilder.runAssetDiscoveryOperationSettings().build();
    setFindingStateSettings = settingsBuilder.setFindingStateSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
    updateFindingSettings = settingsBuilder.updateFindingSettings().build();
    updateNotificationConfigSettings = settingsBuilder.updateNotificationConfigSettings().build();
    updateOrganizationSettingsSettings =
        settingsBuilder.updateOrganizationSettingsSettings().build();
    updateSourceSettings = settingsBuilder.updateSourceSettings().build();
    updateSecurityMarksSettings = settingsBuilder.updateSecurityMarksSettings().build();
  }

  /** Builder for SecurityCenterStubSettings. */
  public static class Builder extends StubSettings.Builder<SecurityCenterStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateSourceRequest, Source> createSourceSettings;
    private final UnaryCallSettings.Builder<CreateFindingRequest, Finding> createFindingSettings;
    private final UnaryCallSettings.Builder<CreateNotificationConfigRequest, NotificationConfig>
        createNotificationConfigSettings;
    private final UnaryCallSettings.Builder<DeleteNotificationConfigRequest, Empty>
        deleteNotificationConfigSettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<GetNotificationConfigRequest, NotificationConfig>
        getNotificationConfigSettings;
    private final UnaryCallSettings.Builder<GetOrganizationSettingsRequest, OrganizationSettings>
        getOrganizationSettingsSettings;
    private final UnaryCallSettings.Builder<GetSourceRequest, Source> getSourceSettings;
    private final PagedCallSettings.Builder<
            GroupAssetsRequest, GroupAssetsResponse, GroupAssetsPagedResponse>
        groupAssetsSettings;
    private final PagedCallSettings.Builder<
            GroupFindingsRequest, GroupFindingsResponse, GroupFindingsPagedResponse>
        groupFindingsSettings;
    private final PagedCallSettings.Builder<
            ListAssetsRequest, ListAssetsResponse, ListAssetsPagedResponse>
        listAssetsSettings;
    private final PagedCallSettings.Builder<
            ListFindingsRequest, ListFindingsResponse, ListFindingsPagedResponse>
        listFindingsSettings;
    private final PagedCallSettings.Builder<
            ListNotificationConfigsRequest,
            ListNotificationConfigsResponse,
            ListNotificationConfigsPagedResponse>
        listNotificationConfigsSettings;
    private final PagedCallSettings.Builder<
            ListSourcesRequest, ListSourcesResponse, ListSourcesPagedResponse>
        listSourcesSettings;
    private final UnaryCallSettings.Builder<RunAssetDiscoveryRequest, Operation>
        runAssetDiscoverySettings;
    private final OperationCallSettings.Builder<
            RunAssetDiscoveryRequest, RunAssetDiscoveryResponse, Empty>
        runAssetDiscoveryOperationSettings;
    private final UnaryCallSettings.Builder<SetFindingStateRequest, Finding>
        setFindingStateSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
    private final UnaryCallSettings.Builder<UpdateFindingRequest, Finding> updateFindingSettings;
    private final UnaryCallSettings.Builder<UpdateNotificationConfigRequest, NotificationConfig>
        updateNotificationConfigSettings;
    private final UnaryCallSettings.Builder<UpdateOrganizationSettingsRequest, OrganizationSettings>
        updateOrganizationSettingsSettings;
    private final UnaryCallSettings.Builder<UpdateSourceRequest, Source> updateSourceSettings;
    private final UnaryCallSettings.Builder<UpdateSecurityMarksRequest, SecurityMarks>
        updateSecurityMarksSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_0_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_1_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "retry_policy_3_codes",
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
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_1_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(480000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(480000L))
              .setTotalTimeout(Duration.ofMillis(480000L))
              .build();
      definitions.put("retry_policy_3_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(480000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(480000L))
              .setTotalTimeout(Duration.ofMillis(480000L))
              .build();
      definitions.put("no_retry_2_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createSourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createFindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createNotificationConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteNotificationConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getNotificationConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getOrganizationSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getSourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      groupAssetsSettings = PagedCallSettings.newBuilder(GROUP_ASSETS_PAGE_STR_FACT);
      groupFindingsSettings = PagedCallSettings.newBuilder(GROUP_FINDINGS_PAGE_STR_FACT);
      listAssetsSettings = PagedCallSettings.newBuilder(LIST_ASSETS_PAGE_STR_FACT);
      listFindingsSettings = PagedCallSettings.newBuilder(LIST_FINDINGS_PAGE_STR_FACT);
      listNotificationConfigsSettings =
          PagedCallSettings.newBuilder(LIST_NOTIFICATION_CONFIGS_PAGE_STR_FACT);
      listSourcesSettings = PagedCallSettings.newBuilder(LIST_SOURCES_PAGE_STR_FACT);
      runAssetDiscoverySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      runAssetDiscoveryOperationSettings = OperationCallSettings.newBuilder();
      setFindingStateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateFindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateNotificationConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateOrganizationSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSecurityMarksSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createSourceSettings,
              createFindingSettings,
              createNotificationConfigSettings,
              deleteNotificationConfigSettings,
              getIamPolicySettings,
              getNotificationConfigSettings,
              getOrganizationSettingsSettings,
              getSourceSettings,
              groupAssetsSettings,
              groupFindingsSettings,
              listAssetsSettings,
              listFindingsSettings,
              listNotificationConfigsSettings,
              listSourcesSettings,
              runAssetDiscoverySettings,
              setFindingStateSettings,
              setIamPolicySettings,
              testIamPermissionsSettings,
              updateFindingSettings,
              updateNotificationConfigSettings,
              updateOrganizationSettingsSettings,
              updateSourceSettings,
              updateSecurityMarksSettings);
      initDefaults(this);
    }

    protected Builder(SecurityCenterStubSettings settings) {
      super(settings);

      createSourceSettings = settings.createSourceSettings.toBuilder();
      createFindingSettings = settings.createFindingSettings.toBuilder();
      createNotificationConfigSettings = settings.createNotificationConfigSettings.toBuilder();
      deleteNotificationConfigSettings = settings.deleteNotificationConfigSettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      getNotificationConfigSettings = settings.getNotificationConfigSettings.toBuilder();
      getOrganizationSettingsSettings = settings.getOrganizationSettingsSettings.toBuilder();
      getSourceSettings = settings.getSourceSettings.toBuilder();
      groupAssetsSettings = settings.groupAssetsSettings.toBuilder();
      groupFindingsSettings = settings.groupFindingsSettings.toBuilder();
      listAssetsSettings = settings.listAssetsSettings.toBuilder();
      listFindingsSettings = settings.listFindingsSettings.toBuilder();
      listNotificationConfigsSettings = settings.listNotificationConfigsSettings.toBuilder();
      listSourcesSettings = settings.listSourcesSettings.toBuilder();
      runAssetDiscoverySettings = settings.runAssetDiscoverySettings.toBuilder();
      runAssetDiscoveryOperationSettings = settings.runAssetDiscoveryOperationSettings.toBuilder();
      setFindingStateSettings = settings.setFindingStateSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();
      updateFindingSettings = settings.updateFindingSettings.toBuilder();
      updateNotificationConfigSettings = settings.updateNotificationConfigSettings.toBuilder();
      updateOrganizationSettingsSettings = settings.updateOrganizationSettingsSettings.toBuilder();
      updateSourceSettings = settings.updateSourceSettings.toBuilder();
      updateSecurityMarksSettings = settings.updateSecurityMarksSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createSourceSettings,
              createFindingSettings,
              createNotificationConfigSettings,
              deleteNotificationConfigSettings,
              getIamPolicySettings,
              getNotificationConfigSettings,
              getOrganizationSettingsSettings,
              getSourceSettings,
              groupAssetsSettings,
              groupFindingsSettings,
              listAssetsSettings,
              listFindingsSettings,
              listNotificationConfigsSettings,
              listSourcesSettings,
              runAssetDiscoverySettings,
              setFindingStateSettings,
              setIamPolicySettings,
              testIamPermissionsSettings,
              updateFindingSettings,
              updateNotificationConfigSettings,
              updateOrganizationSettingsSettings,
              updateSourceSettings,
              updateSecurityMarksSettings);
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
          .createSourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createFindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createNotificationConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteNotificationConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getNotificationConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getOrganizationSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getSourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .groupAssetsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .groupFindingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .listAssetsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .listFindingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .listNotificationConfigsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listSourcesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .runAssetDiscoverySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .setFindingStateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .updateFindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateNotificationConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateOrganizationSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateSourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateSecurityMarksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .runAssetDiscoveryOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RunAssetDiscoveryRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  RunAssetDiscoveryResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Empty.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

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

    /** Returns the builder for the settings used for calls to createSource. */
    public UnaryCallSettings.Builder<CreateSourceRequest, Source> createSourceSettings() {
      return createSourceSettings;
    }

    /** Returns the builder for the settings used for calls to createFinding. */
    public UnaryCallSettings.Builder<CreateFindingRequest, Finding> createFindingSettings() {
      return createFindingSettings;
    }

    /** Returns the builder for the settings used for calls to createNotificationConfig. */
    public UnaryCallSettings.Builder<CreateNotificationConfigRequest, NotificationConfig>
        createNotificationConfigSettings() {
      return createNotificationConfigSettings;
    }

    /** Returns the builder for the settings used for calls to deleteNotificationConfig. */
    public UnaryCallSettings.Builder<DeleteNotificationConfigRequest, Empty>
        deleteNotificationConfigSettings() {
      return deleteNotificationConfigSettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to getNotificationConfig. */
    public UnaryCallSettings.Builder<GetNotificationConfigRequest, NotificationConfig>
        getNotificationConfigSettings() {
      return getNotificationConfigSettings;
    }

    /** Returns the builder for the settings used for calls to getOrganizationSettings. */
    public UnaryCallSettings.Builder<GetOrganizationSettingsRequest, OrganizationSettings>
        getOrganizationSettingsSettings() {
      return getOrganizationSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to getSource. */
    public UnaryCallSettings.Builder<GetSourceRequest, Source> getSourceSettings() {
      return getSourceSettings;
    }

    /** Returns the builder for the settings used for calls to groupAssets. */
    public PagedCallSettings.Builder<
            GroupAssetsRequest, GroupAssetsResponse, GroupAssetsPagedResponse>
        groupAssetsSettings() {
      return groupAssetsSettings;
    }

    /** Returns the builder for the settings used for calls to groupFindings. */
    public PagedCallSettings.Builder<
            GroupFindingsRequest, GroupFindingsResponse, GroupFindingsPagedResponse>
        groupFindingsSettings() {
      return groupFindingsSettings;
    }

    /** Returns the builder for the settings used for calls to listAssets. */
    public PagedCallSettings.Builder<ListAssetsRequest, ListAssetsResponse, ListAssetsPagedResponse>
        listAssetsSettings() {
      return listAssetsSettings;
    }

    /** Returns the builder for the settings used for calls to listFindings. */
    public PagedCallSettings.Builder<
            ListFindingsRequest, ListFindingsResponse, ListFindingsPagedResponse>
        listFindingsSettings() {
      return listFindingsSettings;
    }

    /** Returns the builder for the settings used for calls to listNotificationConfigs. */
    public PagedCallSettings.Builder<
            ListNotificationConfigsRequest,
            ListNotificationConfigsResponse,
            ListNotificationConfigsPagedResponse>
        listNotificationConfigsSettings() {
      return listNotificationConfigsSettings;
    }

    /** Returns the builder for the settings used for calls to listSources. */
    public PagedCallSettings.Builder<
            ListSourcesRequest, ListSourcesResponse, ListSourcesPagedResponse>
        listSourcesSettings() {
      return listSourcesSettings;
    }

    /** Returns the builder for the settings used for calls to runAssetDiscovery. */
    public UnaryCallSettings.Builder<RunAssetDiscoveryRequest, Operation>
        runAssetDiscoverySettings() {
      return runAssetDiscoverySettings;
    }

    /** Returns the builder for the settings used for calls to runAssetDiscovery. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<RunAssetDiscoveryRequest, RunAssetDiscoveryResponse, Empty>
        runAssetDiscoveryOperationSettings() {
      return runAssetDiscoveryOperationSettings;
    }

    /** Returns the builder for the settings used for calls to setFindingState. */
    public UnaryCallSettings.Builder<SetFindingStateRequest, Finding> setFindingStateSettings() {
      return setFindingStateSettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    /** Returns the builder for the settings used for calls to updateFinding. */
    public UnaryCallSettings.Builder<UpdateFindingRequest, Finding> updateFindingSettings() {
      return updateFindingSettings;
    }

    /** Returns the builder for the settings used for calls to updateNotificationConfig. */
    public UnaryCallSettings.Builder<UpdateNotificationConfigRequest, NotificationConfig>
        updateNotificationConfigSettings() {
      return updateNotificationConfigSettings;
    }

    /** Returns the builder for the settings used for calls to updateOrganizationSettings. */
    public UnaryCallSettings.Builder<UpdateOrganizationSettingsRequest, OrganizationSettings>
        updateOrganizationSettingsSettings() {
      return updateOrganizationSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to updateSource. */
    public UnaryCallSettings.Builder<UpdateSourceRequest, Source> updateSourceSettings() {
      return updateSourceSettings;
    }

    /** Returns the builder for the settings used for calls to updateSecurityMarks. */
    public UnaryCallSettings.Builder<UpdateSecurityMarksRequest, SecurityMarks>
        updateSecurityMarksSettings() {
      return updateSecurityMarksSettings;
    }

    @Override
    public SecurityCenterStubSettings build() throws IOException {
      return new SecurityCenterStubSettings(this);
    }
  }
}
