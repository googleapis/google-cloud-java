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

package com.google.cloud.config.v1.stub;

import static com.google.cloud.config.v1.ConfigClient.ListDeploymentsPagedResponse;
import static com.google.cloud.config.v1.ConfigClient.ListLocationsPagedResponse;
import static com.google.cloud.config.v1.ConfigClient.ListPreviewsPagedResponse;
import static com.google.cloud.config.v1.ConfigClient.ListResourcesPagedResponse;
import static com.google.cloud.config.v1.ConfigClient.ListRevisionsPagedResponse;
import static com.google.cloud.config.v1.ConfigClient.ListTerraformVersionsPagedResponse;

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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
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
import com.google.cloud.config.v1.CreateDeploymentRequest;
import com.google.cloud.config.v1.CreatePreviewRequest;
import com.google.cloud.config.v1.DeleteDeploymentRequest;
import com.google.cloud.config.v1.DeletePreviewRequest;
import com.google.cloud.config.v1.DeleteStatefileRequest;
import com.google.cloud.config.v1.Deployment;
import com.google.cloud.config.v1.ExportDeploymentStatefileRequest;
import com.google.cloud.config.v1.ExportLockInfoRequest;
import com.google.cloud.config.v1.ExportPreviewResultRequest;
import com.google.cloud.config.v1.ExportPreviewResultResponse;
import com.google.cloud.config.v1.ExportRevisionStatefileRequest;
import com.google.cloud.config.v1.GetDeploymentRequest;
import com.google.cloud.config.v1.GetPreviewRequest;
import com.google.cloud.config.v1.GetResourceRequest;
import com.google.cloud.config.v1.GetRevisionRequest;
import com.google.cloud.config.v1.GetTerraformVersionRequest;
import com.google.cloud.config.v1.ImportStatefileRequest;
import com.google.cloud.config.v1.ListDeploymentsRequest;
import com.google.cloud.config.v1.ListDeploymentsResponse;
import com.google.cloud.config.v1.ListPreviewsRequest;
import com.google.cloud.config.v1.ListPreviewsResponse;
import com.google.cloud.config.v1.ListResourcesRequest;
import com.google.cloud.config.v1.ListResourcesResponse;
import com.google.cloud.config.v1.ListRevisionsRequest;
import com.google.cloud.config.v1.ListRevisionsResponse;
import com.google.cloud.config.v1.ListTerraformVersionsRequest;
import com.google.cloud.config.v1.ListTerraformVersionsResponse;
import com.google.cloud.config.v1.LockDeploymentRequest;
import com.google.cloud.config.v1.LockInfo;
import com.google.cloud.config.v1.OperationMetadata;
import com.google.cloud.config.v1.Preview;
import com.google.cloud.config.v1.Resource;
import com.google.cloud.config.v1.Revision;
import com.google.cloud.config.v1.Statefile;
import com.google.cloud.config.v1.TerraformVersion;
import com.google.cloud.config.v1.UnlockDeploymentRequest;
import com.google.cloud.config.v1.UpdateDeploymentRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * Settings class to configure an instance of {@link ConfigStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (config.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getDeployment to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ConfigStubSettings.Builder configSettingsBuilder = ConfigStubSettings.newBuilder();
 * configSettingsBuilder
 *     .getDeploymentSettings()
 *     .setRetrySettings(
 *         configSettingsBuilder
 *             .getDeploymentSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ConfigStubSettings configSettings = configSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ConfigStubSettings extends StubSettings<ConfigStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>
      listDeploymentsSettings;
  private final UnaryCallSettings<GetDeploymentRequest, Deployment> getDeploymentSettings;
  private final UnaryCallSettings<CreateDeploymentRequest, Operation> createDeploymentSettings;
  private final OperationCallSettings<CreateDeploymentRequest, Deployment, OperationMetadata>
      createDeploymentOperationSettings;
  private final UnaryCallSettings<UpdateDeploymentRequest, Operation> updateDeploymentSettings;
  private final OperationCallSettings<UpdateDeploymentRequest, Deployment, OperationMetadata>
      updateDeploymentOperationSettings;
  private final UnaryCallSettings<DeleteDeploymentRequest, Operation> deleteDeploymentSettings;
  private final OperationCallSettings<DeleteDeploymentRequest, Deployment, OperationMetadata>
      deleteDeploymentOperationSettings;
  private final PagedCallSettings<
          ListRevisionsRequest, ListRevisionsResponse, ListRevisionsPagedResponse>
      listRevisionsSettings;
  private final UnaryCallSettings<GetRevisionRequest, Revision> getRevisionSettings;
  private final UnaryCallSettings<GetResourceRequest, Resource> getResourceSettings;
  private final PagedCallSettings<
          ListResourcesRequest, ListResourcesResponse, ListResourcesPagedResponse>
      listResourcesSettings;
  private final UnaryCallSettings<ExportDeploymentStatefileRequest, Statefile>
      exportDeploymentStatefileSettings;
  private final UnaryCallSettings<ExportRevisionStatefileRequest, Statefile>
      exportRevisionStatefileSettings;
  private final UnaryCallSettings<ImportStatefileRequest, Statefile> importStatefileSettings;
  private final UnaryCallSettings<DeleteStatefileRequest, Empty> deleteStatefileSettings;
  private final UnaryCallSettings<LockDeploymentRequest, Operation> lockDeploymentSettings;
  private final OperationCallSettings<LockDeploymentRequest, Deployment, OperationMetadata>
      lockDeploymentOperationSettings;
  private final UnaryCallSettings<UnlockDeploymentRequest, Operation> unlockDeploymentSettings;
  private final OperationCallSettings<UnlockDeploymentRequest, Deployment, OperationMetadata>
      unlockDeploymentOperationSettings;
  private final UnaryCallSettings<ExportLockInfoRequest, LockInfo> exportLockInfoSettings;
  private final UnaryCallSettings<CreatePreviewRequest, Operation> createPreviewSettings;
  private final OperationCallSettings<CreatePreviewRequest, Preview, OperationMetadata>
      createPreviewOperationSettings;
  private final UnaryCallSettings<GetPreviewRequest, Preview> getPreviewSettings;
  private final PagedCallSettings<
          ListPreviewsRequest, ListPreviewsResponse, ListPreviewsPagedResponse>
      listPreviewsSettings;
  private final UnaryCallSettings<DeletePreviewRequest, Operation> deletePreviewSettings;
  private final OperationCallSettings<DeletePreviewRequest, Preview, OperationMetadata>
      deletePreviewOperationSettings;
  private final UnaryCallSettings<ExportPreviewResultRequest, ExportPreviewResultResponse>
      exportPreviewResultSettings;
  private final PagedCallSettings<
          ListTerraformVersionsRequest,
          ListTerraformVersionsResponse,
          ListTerraformVersionsPagedResponse>
      listTerraformVersionsSettings;
  private final UnaryCallSettings<GetTerraformVersionRequest, TerraformVersion>
      getTerraformVersionSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListDeploymentsRequest, ListDeploymentsResponse, Deployment>
      LIST_DEPLOYMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListDeploymentsRequest, ListDeploymentsResponse, Deployment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDeploymentsRequest injectToken(
                ListDeploymentsRequest payload, String token) {
              return ListDeploymentsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDeploymentsRequest injectPageSize(
                ListDeploymentsRequest payload, int pageSize) {
              return ListDeploymentsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDeploymentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDeploymentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Deployment> extractResources(ListDeploymentsResponse payload) {
              return payload.getDeploymentsList() == null
                  ? ImmutableList.<Deployment>of()
                  : payload.getDeploymentsList();
            }
          };

  private static final PagedListDescriptor<ListRevisionsRequest, ListRevisionsResponse, Revision>
      LIST_REVISIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListRevisionsRequest, ListRevisionsResponse, Revision>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRevisionsRequest injectToken(ListRevisionsRequest payload, String token) {
              return ListRevisionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRevisionsRequest injectPageSize(ListRevisionsRequest payload, int pageSize) {
              return ListRevisionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListRevisionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListRevisionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Revision> extractResources(ListRevisionsResponse payload) {
              return payload.getRevisionsList() == null
                  ? ImmutableList.<Revision>of()
                  : payload.getRevisionsList();
            }
          };

  private static final PagedListDescriptor<ListResourcesRequest, ListResourcesResponse, Resource>
      LIST_RESOURCES_PAGE_STR_DESC =
          new PagedListDescriptor<ListResourcesRequest, ListResourcesResponse, Resource>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListResourcesRequest injectToken(ListResourcesRequest payload, String token) {
              return ListResourcesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListResourcesRequest injectPageSize(ListResourcesRequest payload, int pageSize) {
              return ListResourcesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListResourcesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListResourcesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Resource> extractResources(ListResourcesResponse payload) {
              return payload.getResourcesList() == null
                  ? ImmutableList.<Resource>of()
                  : payload.getResourcesList();
            }
          };

  private static final PagedListDescriptor<ListPreviewsRequest, ListPreviewsResponse, Preview>
      LIST_PREVIEWS_PAGE_STR_DESC =
          new PagedListDescriptor<ListPreviewsRequest, ListPreviewsResponse, Preview>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPreviewsRequest injectToken(ListPreviewsRequest payload, String token) {
              return ListPreviewsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPreviewsRequest injectPageSize(ListPreviewsRequest payload, int pageSize) {
              return ListPreviewsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListPreviewsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPreviewsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Preview> extractResources(ListPreviewsResponse payload) {
              return payload.getPreviewsList() == null
                  ? ImmutableList.<Preview>of()
                  : payload.getPreviewsList();
            }
          };

  private static final PagedListDescriptor<
          ListTerraformVersionsRequest, ListTerraformVersionsResponse, TerraformVersion>
      LIST_TERRAFORM_VERSIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListTerraformVersionsRequest, ListTerraformVersionsResponse, TerraformVersion>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTerraformVersionsRequest injectToken(
                ListTerraformVersionsRequest payload, String token) {
              return ListTerraformVersionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTerraformVersionsRequest injectPageSize(
                ListTerraformVersionsRequest payload, int pageSize) {
              return ListTerraformVersionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTerraformVersionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTerraformVersionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<TerraformVersion> extractResources(
                ListTerraformVersionsResponse payload) {
              return payload.getTerraformVersionsList() == null
                  ? ImmutableList.<TerraformVersion>of()
                  : payload.getTerraformVersionsList();
            }
          };

  private static final PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>
      LIST_LOCATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLocationsRequest injectToken(ListLocationsRequest payload, String token) {
              return ListLocationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLocationsRequest injectPageSize(ListLocationsRequest payload, int pageSize) {
              return ListLocationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLocationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLocationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Location> extractResources(ListLocationsResponse payload) {
              return payload.getLocationsList() == null
                  ? ImmutableList.<Location>of()
                  : payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>
      LIST_DEPLOYMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>() {
            @Override
            public ApiFuture<ListDeploymentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDeploymentsRequest, ListDeploymentsResponse> callable,
                ListDeploymentsRequest request,
                ApiCallContext context,
                ApiFuture<ListDeploymentsResponse> futureResponse) {
              PageContext<ListDeploymentsRequest, ListDeploymentsResponse, Deployment> pageContext =
                  PageContext.create(callable, LIST_DEPLOYMENTS_PAGE_STR_DESC, request, context);
              return ListDeploymentsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListRevisionsRequest, ListRevisionsResponse, ListRevisionsPagedResponse>
      LIST_REVISIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRevisionsRequest, ListRevisionsResponse, ListRevisionsPagedResponse>() {
            @Override
            public ApiFuture<ListRevisionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRevisionsRequest, ListRevisionsResponse> callable,
                ListRevisionsRequest request,
                ApiCallContext context,
                ApiFuture<ListRevisionsResponse> futureResponse) {
              PageContext<ListRevisionsRequest, ListRevisionsResponse, Revision> pageContext =
                  PageContext.create(callable, LIST_REVISIONS_PAGE_STR_DESC, request, context);
              return ListRevisionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListResourcesRequest, ListResourcesResponse, ListResourcesPagedResponse>
      LIST_RESOURCES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListResourcesRequest, ListResourcesResponse, ListResourcesPagedResponse>() {
            @Override
            public ApiFuture<ListResourcesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListResourcesRequest, ListResourcesResponse> callable,
                ListResourcesRequest request,
                ApiCallContext context,
                ApiFuture<ListResourcesResponse> futureResponse) {
              PageContext<ListResourcesRequest, ListResourcesResponse, Resource> pageContext =
                  PageContext.create(callable, LIST_RESOURCES_PAGE_STR_DESC, request, context);
              return ListResourcesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListPreviewsRequest, ListPreviewsResponse, ListPreviewsPagedResponse>
      LIST_PREVIEWS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPreviewsRequest, ListPreviewsResponse, ListPreviewsPagedResponse>() {
            @Override
            public ApiFuture<ListPreviewsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPreviewsRequest, ListPreviewsResponse> callable,
                ListPreviewsRequest request,
                ApiCallContext context,
                ApiFuture<ListPreviewsResponse> futureResponse) {
              PageContext<ListPreviewsRequest, ListPreviewsResponse, Preview> pageContext =
                  PageContext.create(callable, LIST_PREVIEWS_PAGE_STR_DESC, request, context);
              return ListPreviewsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListTerraformVersionsRequest,
          ListTerraformVersionsResponse,
          ListTerraformVersionsPagedResponse>
      LIST_TERRAFORM_VERSIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTerraformVersionsRequest,
              ListTerraformVersionsResponse,
              ListTerraformVersionsPagedResponse>() {
            @Override
            public ApiFuture<ListTerraformVersionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTerraformVersionsRequest, ListTerraformVersionsResponse> callable,
                ListTerraformVersionsRequest request,
                ApiCallContext context,
                ApiFuture<ListTerraformVersionsResponse> futureResponse) {
              PageContext<
                      ListTerraformVersionsRequest, ListTerraformVersionsResponse, TerraformVersion>
                  pageContext =
                      PageContext.create(
                          callable, LIST_TERRAFORM_VERSIONS_PAGE_STR_DESC, request, context);
              return ListTerraformVersionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      LIST_LOCATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>() {
            @Override
            public ApiFuture<ListLocationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLocationsRequest, ListLocationsResponse> callable,
                ListLocationsRequest request,
                ApiCallContext context,
                ApiFuture<ListLocationsResponse> futureResponse) {
              PageContext<ListLocationsRequest, ListLocationsResponse, Location> pageContext =
                  PageContext.create(callable, LIST_LOCATIONS_PAGE_STR_DESC, request, context);
              return ListLocationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listDeployments. */
  public PagedCallSettings<
          ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>
      listDeploymentsSettings() {
    return listDeploymentsSettings;
  }

  /** Returns the object with the settings used for calls to getDeployment. */
  public UnaryCallSettings<GetDeploymentRequest, Deployment> getDeploymentSettings() {
    return getDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to createDeployment. */
  public UnaryCallSettings<CreateDeploymentRequest, Operation> createDeploymentSettings() {
    return createDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to createDeployment. */
  public OperationCallSettings<CreateDeploymentRequest, Deployment, OperationMetadata>
      createDeploymentOperationSettings() {
    return createDeploymentOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateDeployment. */
  public UnaryCallSettings<UpdateDeploymentRequest, Operation> updateDeploymentSettings() {
    return updateDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to updateDeployment. */
  public OperationCallSettings<UpdateDeploymentRequest, Deployment, OperationMetadata>
      updateDeploymentOperationSettings() {
    return updateDeploymentOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteDeployment. */
  public UnaryCallSettings<DeleteDeploymentRequest, Operation> deleteDeploymentSettings() {
    return deleteDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to deleteDeployment. */
  public OperationCallSettings<DeleteDeploymentRequest, Deployment, OperationMetadata>
      deleteDeploymentOperationSettings() {
    return deleteDeploymentOperationSettings;
  }

  /** Returns the object with the settings used for calls to listRevisions. */
  public PagedCallSettings<ListRevisionsRequest, ListRevisionsResponse, ListRevisionsPagedResponse>
      listRevisionsSettings() {
    return listRevisionsSettings;
  }

  /** Returns the object with the settings used for calls to getRevision. */
  public UnaryCallSettings<GetRevisionRequest, Revision> getRevisionSettings() {
    return getRevisionSettings;
  }

  /** Returns the object with the settings used for calls to getResource. */
  public UnaryCallSettings<GetResourceRequest, Resource> getResourceSettings() {
    return getResourceSettings;
  }

  /** Returns the object with the settings used for calls to listResources. */
  public PagedCallSettings<ListResourcesRequest, ListResourcesResponse, ListResourcesPagedResponse>
      listResourcesSettings() {
    return listResourcesSettings;
  }

  /** Returns the object with the settings used for calls to exportDeploymentStatefile. */
  public UnaryCallSettings<ExportDeploymentStatefileRequest, Statefile>
      exportDeploymentStatefileSettings() {
    return exportDeploymentStatefileSettings;
  }

  /** Returns the object with the settings used for calls to exportRevisionStatefile. */
  public UnaryCallSettings<ExportRevisionStatefileRequest, Statefile>
      exportRevisionStatefileSettings() {
    return exportRevisionStatefileSettings;
  }

  /** Returns the object with the settings used for calls to importStatefile. */
  public UnaryCallSettings<ImportStatefileRequest, Statefile> importStatefileSettings() {
    return importStatefileSettings;
  }

  /** Returns the object with the settings used for calls to deleteStatefile. */
  public UnaryCallSettings<DeleteStatefileRequest, Empty> deleteStatefileSettings() {
    return deleteStatefileSettings;
  }

  /** Returns the object with the settings used for calls to lockDeployment. */
  public UnaryCallSettings<LockDeploymentRequest, Operation> lockDeploymentSettings() {
    return lockDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to lockDeployment. */
  public OperationCallSettings<LockDeploymentRequest, Deployment, OperationMetadata>
      lockDeploymentOperationSettings() {
    return lockDeploymentOperationSettings;
  }

  /** Returns the object with the settings used for calls to unlockDeployment. */
  public UnaryCallSettings<UnlockDeploymentRequest, Operation> unlockDeploymentSettings() {
    return unlockDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to unlockDeployment. */
  public OperationCallSettings<UnlockDeploymentRequest, Deployment, OperationMetadata>
      unlockDeploymentOperationSettings() {
    return unlockDeploymentOperationSettings;
  }

  /** Returns the object with the settings used for calls to exportLockInfo. */
  public UnaryCallSettings<ExportLockInfoRequest, LockInfo> exportLockInfoSettings() {
    return exportLockInfoSettings;
  }

  /** Returns the object with the settings used for calls to createPreview. */
  public UnaryCallSettings<CreatePreviewRequest, Operation> createPreviewSettings() {
    return createPreviewSettings;
  }

  /** Returns the object with the settings used for calls to createPreview. */
  public OperationCallSettings<CreatePreviewRequest, Preview, OperationMetadata>
      createPreviewOperationSettings() {
    return createPreviewOperationSettings;
  }

  /** Returns the object with the settings used for calls to getPreview. */
  public UnaryCallSettings<GetPreviewRequest, Preview> getPreviewSettings() {
    return getPreviewSettings;
  }

  /** Returns the object with the settings used for calls to listPreviews. */
  public PagedCallSettings<ListPreviewsRequest, ListPreviewsResponse, ListPreviewsPagedResponse>
      listPreviewsSettings() {
    return listPreviewsSettings;
  }

  /** Returns the object with the settings used for calls to deletePreview. */
  public UnaryCallSettings<DeletePreviewRequest, Operation> deletePreviewSettings() {
    return deletePreviewSettings;
  }

  /** Returns the object with the settings used for calls to deletePreview. */
  public OperationCallSettings<DeletePreviewRequest, Preview, OperationMetadata>
      deletePreviewOperationSettings() {
    return deletePreviewOperationSettings;
  }

  /** Returns the object with the settings used for calls to exportPreviewResult. */
  public UnaryCallSettings<ExportPreviewResultRequest, ExportPreviewResultResponse>
      exportPreviewResultSettings() {
    return exportPreviewResultSettings;
  }

  /** Returns the object with the settings used for calls to listTerraformVersions. */
  public PagedCallSettings<
          ListTerraformVersionsRequest,
          ListTerraformVersionsResponse,
          ListTerraformVersionsPagedResponse>
      listTerraformVersionsSettings() {
    return listTerraformVersionsSettings;
  }

  /** Returns the object with the settings used for calls to getTerraformVersion. */
  public UnaryCallSettings<GetTerraformVersionRequest, TerraformVersion>
      getTerraformVersionSettings() {
    return getTerraformVersionSettings;
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return listLocationsSettings;
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return getLocationSettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  public ConfigStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcConfigStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonConfigStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "config";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "config.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "config.mtls.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder()
        .setScopesToApply(DEFAULT_SERVICE_SCOPES)
        .setUseJwtAccessWithScope(true);
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(ConfigStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(ConfigStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ConfigStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
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

  protected ConfigStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listDeploymentsSettings = settingsBuilder.listDeploymentsSettings().build();
    getDeploymentSettings = settingsBuilder.getDeploymentSettings().build();
    createDeploymentSettings = settingsBuilder.createDeploymentSettings().build();
    createDeploymentOperationSettings = settingsBuilder.createDeploymentOperationSettings().build();
    updateDeploymentSettings = settingsBuilder.updateDeploymentSettings().build();
    updateDeploymentOperationSettings = settingsBuilder.updateDeploymentOperationSettings().build();
    deleteDeploymentSettings = settingsBuilder.deleteDeploymentSettings().build();
    deleteDeploymentOperationSettings = settingsBuilder.deleteDeploymentOperationSettings().build();
    listRevisionsSettings = settingsBuilder.listRevisionsSettings().build();
    getRevisionSettings = settingsBuilder.getRevisionSettings().build();
    getResourceSettings = settingsBuilder.getResourceSettings().build();
    listResourcesSettings = settingsBuilder.listResourcesSettings().build();
    exportDeploymentStatefileSettings = settingsBuilder.exportDeploymentStatefileSettings().build();
    exportRevisionStatefileSettings = settingsBuilder.exportRevisionStatefileSettings().build();
    importStatefileSettings = settingsBuilder.importStatefileSettings().build();
    deleteStatefileSettings = settingsBuilder.deleteStatefileSettings().build();
    lockDeploymentSettings = settingsBuilder.lockDeploymentSettings().build();
    lockDeploymentOperationSettings = settingsBuilder.lockDeploymentOperationSettings().build();
    unlockDeploymentSettings = settingsBuilder.unlockDeploymentSettings().build();
    unlockDeploymentOperationSettings = settingsBuilder.unlockDeploymentOperationSettings().build();
    exportLockInfoSettings = settingsBuilder.exportLockInfoSettings().build();
    createPreviewSettings = settingsBuilder.createPreviewSettings().build();
    createPreviewOperationSettings = settingsBuilder.createPreviewOperationSettings().build();
    getPreviewSettings = settingsBuilder.getPreviewSettings().build();
    listPreviewsSettings = settingsBuilder.listPreviewsSettings().build();
    deletePreviewSettings = settingsBuilder.deletePreviewSettings().build();
    deletePreviewOperationSettings = settingsBuilder.deletePreviewOperationSettings().build();
    exportPreviewResultSettings = settingsBuilder.exportPreviewResultSettings().build();
    listTerraformVersionsSettings = settingsBuilder.listTerraformVersionsSettings().build();
    getTerraformVersionSettings = settingsBuilder.getTerraformVersionSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for ConfigStubSettings. */
  public static class Builder extends StubSettings.Builder<ConfigStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>
        listDeploymentsSettings;
    private final UnaryCallSettings.Builder<GetDeploymentRequest, Deployment> getDeploymentSettings;
    private final UnaryCallSettings.Builder<CreateDeploymentRequest, Operation>
        createDeploymentSettings;
    private final OperationCallSettings.Builder<
            CreateDeploymentRequest, Deployment, OperationMetadata>
        createDeploymentOperationSettings;
    private final UnaryCallSettings.Builder<UpdateDeploymentRequest, Operation>
        updateDeploymentSettings;
    private final OperationCallSettings.Builder<
            UpdateDeploymentRequest, Deployment, OperationMetadata>
        updateDeploymentOperationSettings;
    private final UnaryCallSettings.Builder<DeleteDeploymentRequest, Operation>
        deleteDeploymentSettings;
    private final OperationCallSettings.Builder<
            DeleteDeploymentRequest, Deployment, OperationMetadata>
        deleteDeploymentOperationSettings;
    private final PagedCallSettings.Builder<
            ListRevisionsRequest, ListRevisionsResponse, ListRevisionsPagedResponse>
        listRevisionsSettings;
    private final UnaryCallSettings.Builder<GetRevisionRequest, Revision> getRevisionSettings;
    private final UnaryCallSettings.Builder<GetResourceRequest, Resource> getResourceSettings;
    private final PagedCallSettings.Builder<
            ListResourcesRequest, ListResourcesResponse, ListResourcesPagedResponse>
        listResourcesSettings;
    private final UnaryCallSettings.Builder<ExportDeploymentStatefileRequest, Statefile>
        exportDeploymentStatefileSettings;
    private final UnaryCallSettings.Builder<ExportRevisionStatefileRequest, Statefile>
        exportRevisionStatefileSettings;
    private final UnaryCallSettings.Builder<ImportStatefileRequest, Statefile>
        importStatefileSettings;
    private final UnaryCallSettings.Builder<DeleteStatefileRequest, Empty> deleteStatefileSettings;
    private final UnaryCallSettings.Builder<LockDeploymentRequest, Operation>
        lockDeploymentSettings;
    private final OperationCallSettings.Builder<
            LockDeploymentRequest, Deployment, OperationMetadata>
        lockDeploymentOperationSettings;
    private final UnaryCallSettings.Builder<UnlockDeploymentRequest, Operation>
        unlockDeploymentSettings;
    private final OperationCallSettings.Builder<
            UnlockDeploymentRequest, Deployment, OperationMetadata>
        unlockDeploymentOperationSettings;
    private final UnaryCallSettings.Builder<ExportLockInfoRequest, LockInfo> exportLockInfoSettings;
    private final UnaryCallSettings.Builder<CreatePreviewRequest, Operation> createPreviewSettings;
    private final OperationCallSettings.Builder<CreatePreviewRequest, Preview, OperationMetadata>
        createPreviewOperationSettings;
    private final UnaryCallSettings.Builder<GetPreviewRequest, Preview> getPreviewSettings;
    private final PagedCallSettings.Builder<
            ListPreviewsRequest, ListPreviewsResponse, ListPreviewsPagedResponse>
        listPreviewsSettings;
    private final UnaryCallSettings.Builder<DeletePreviewRequest, Operation> deletePreviewSettings;
    private final OperationCallSettings.Builder<DeletePreviewRequest, Preview, OperationMetadata>
        deletePreviewOperationSettings;
    private final UnaryCallSettings.Builder<ExportPreviewResultRequest, ExportPreviewResultResponse>
        exportPreviewResultSettings;
    private final PagedCallSettings.Builder<
            ListTerraformVersionsRequest,
            ListTerraformVersionsResponse,
            ListTerraformVersionsPagedResponse>
        listTerraformVersionsSettings;
    private final UnaryCallSettings.Builder<GetTerraformVersionRequest, TerraformVersion>
        getTerraformVersionSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listDeploymentsSettings = PagedCallSettings.newBuilder(LIST_DEPLOYMENTS_PAGE_STR_FACT);
      getDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDeploymentOperationSettings = OperationCallSettings.newBuilder();
      updateDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDeploymentOperationSettings = OperationCallSettings.newBuilder();
      deleteDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDeploymentOperationSettings = OperationCallSettings.newBuilder();
      listRevisionsSettings = PagedCallSettings.newBuilder(LIST_REVISIONS_PAGE_STR_FACT);
      getRevisionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getResourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listResourcesSettings = PagedCallSettings.newBuilder(LIST_RESOURCES_PAGE_STR_FACT);
      exportDeploymentStatefileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      exportRevisionStatefileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importStatefileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteStatefileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      lockDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      lockDeploymentOperationSettings = OperationCallSettings.newBuilder();
      unlockDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      unlockDeploymentOperationSettings = OperationCallSettings.newBuilder();
      exportLockInfoSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createPreviewSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createPreviewOperationSettings = OperationCallSettings.newBuilder();
      getPreviewSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listPreviewsSettings = PagedCallSettings.newBuilder(LIST_PREVIEWS_PAGE_STR_FACT);
      deletePreviewSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deletePreviewOperationSettings = OperationCallSettings.newBuilder();
      exportPreviewResultSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listTerraformVersionsSettings =
          PagedCallSettings.newBuilder(LIST_TERRAFORM_VERSIONS_PAGE_STR_FACT);
      getTerraformVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listDeploymentsSettings,
              getDeploymentSettings,
              createDeploymentSettings,
              updateDeploymentSettings,
              deleteDeploymentSettings,
              listRevisionsSettings,
              getRevisionSettings,
              getResourceSettings,
              listResourcesSettings,
              exportDeploymentStatefileSettings,
              exportRevisionStatefileSettings,
              importStatefileSettings,
              deleteStatefileSettings,
              lockDeploymentSettings,
              unlockDeploymentSettings,
              exportLockInfoSettings,
              createPreviewSettings,
              getPreviewSettings,
              listPreviewsSettings,
              deletePreviewSettings,
              exportPreviewResultSettings,
              listTerraformVersionsSettings,
              getTerraformVersionSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(ConfigStubSettings settings) {
      super(settings);

      listDeploymentsSettings = settings.listDeploymentsSettings.toBuilder();
      getDeploymentSettings = settings.getDeploymentSettings.toBuilder();
      createDeploymentSettings = settings.createDeploymentSettings.toBuilder();
      createDeploymentOperationSettings = settings.createDeploymentOperationSettings.toBuilder();
      updateDeploymentSettings = settings.updateDeploymentSettings.toBuilder();
      updateDeploymentOperationSettings = settings.updateDeploymentOperationSettings.toBuilder();
      deleteDeploymentSettings = settings.deleteDeploymentSettings.toBuilder();
      deleteDeploymentOperationSettings = settings.deleteDeploymentOperationSettings.toBuilder();
      listRevisionsSettings = settings.listRevisionsSettings.toBuilder();
      getRevisionSettings = settings.getRevisionSettings.toBuilder();
      getResourceSettings = settings.getResourceSettings.toBuilder();
      listResourcesSettings = settings.listResourcesSettings.toBuilder();
      exportDeploymentStatefileSettings = settings.exportDeploymentStatefileSettings.toBuilder();
      exportRevisionStatefileSettings = settings.exportRevisionStatefileSettings.toBuilder();
      importStatefileSettings = settings.importStatefileSettings.toBuilder();
      deleteStatefileSettings = settings.deleteStatefileSettings.toBuilder();
      lockDeploymentSettings = settings.lockDeploymentSettings.toBuilder();
      lockDeploymentOperationSettings = settings.lockDeploymentOperationSettings.toBuilder();
      unlockDeploymentSettings = settings.unlockDeploymentSettings.toBuilder();
      unlockDeploymentOperationSettings = settings.unlockDeploymentOperationSettings.toBuilder();
      exportLockInfoSettings = settings.exportLockInfoSettings.toBuilder();
      createPreviewSettings = settings.createPreviewSettings.toBuilder();
      createPreviewOperationSettings = settings.createPreviewOperationSettings.toBuilder();
      getPreviewSettings = settings.getPreviewSettings.toBuilder();
      listPreviewsSettings = settings.listPreviewsSettings.toBuilder();
      deletePreviewSettings = settings.deletePreviewSettings.toBuilder();
      deletePreviewOperationSettings = settings.deletePreviewOperationSettings.toBuilder();
      exportPreviewResultSettings = settings.exportPreviewResultSettings.toBuilder();
      listTerraformVersionsSettings = settings.listTerraformVersionsSettings.toBuilder();
      getTerraformVersionSettings = settings.getTerraformVersionSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listDeploymentsSettings,
              getDeploymentSettings,
              createDeploymentSettings,
              updateDeploymentSettings,
              deleteDeploymentSettings,
              listRevisionsSettings,
              getRevisionSettings,
              getResourceSettings,
              listResourcesSettings,
              exportDeploymentStatefileSettings,
              exportRevisionStatefileSettings,
              importStatefileSettings,
              deleteStatefileSettings,
              lockDeploymentSettings,
              unlockDeploymentSettings,
              exportLockInfoSettings,
              createPreviewSettings,
              getPreviewSettings,
              listPreviewsSettings,
              deletePreviewSettings,
              exportPreviewResultSettings,
              listTerraformVersionsSettings,
              getTerraformVersionSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .listDeploymentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listRevisionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getRevisionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getResourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listResourcesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .exportDeploymentStatefileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .exportRevisionStatefileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .importStatefileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteStatefileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .lockDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .unlockDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .exportLockInfoSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createPreviewSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getPreviewSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listPreviewsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deletePreviewSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .exportPreviewResultSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listTerraformVersionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getTerraformVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createDeploymentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateDeploymentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Deployment.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(300000L))
                      .setRetryDelayMultiplier(1.3)
                      .setMaxRetryDelay(Duration.ofMillis(3600000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(43200000L))
                      .build()));

      builder
          .updateDeploymentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateDeploymentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Deployment.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(300000L))
                      .setRetryDelayMultiplier(1.3)
                      .setMaxRetryDelay(Duration.ofMillis(3600000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(43200000L))
                      .build()));

      builder
          .deleteDeploymentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteDeploymentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Deployment.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(300000L))
                      .setRetryDelayMultiplier(1.3)
                      .setMaxRetryDelay(Duration.ofMillis(3600000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(43200000L))
                      .build()));

      builder
          .lockDeploymentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<LockDeploymentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Deployment.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

      builder
          .unlockDeploymentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UnlockDeploymentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Deployment.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

      builder
          .createPreviewOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreatePreviewRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Preview.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(300000L))
                      .setRetryDelayMultiplier(1.3)
                      .setMaxRetryDelay(Duration.ofMillis(3600000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(43200000L))
                      .build()));

      builder
          .deletePreviewOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeletePreviewRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Preview.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(300000L))
                      .setRetryDelayMultiplier(1.3)
                      .setMaxRetryDelay(Duration.ofMillis(3600000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(43200000L))
                      .build()));

      return builder;
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to listDeployments. */
    public PagedCallSettings.Builder<
            ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>
        listDeploymentsSettings() {
      return listDeploymentsSettings;
    }

    /** Returns the builder for the settings used for calls to getDeployment. */
    public UnaryCallSettings.Builder<GetDeploymentRequest, Deployment> getDeploymentSettings() {
      return getDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to createDeployment. */
    public UnaryCallSettings.Builder<CreateDeploymentRequest, Operation>
        createDeploymentSettings() {
      return createDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to createDeployment. */
    public OperationCallSettings.Builder<CreateDeploymentRequest, Deployment, OperationMetadata>
        createDeploymentOperationSettings() {
      return createDeploymentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateDeployment. */
    public UnaryCallSettings.Builder<UpdateDeploymentRequest, Operation>
        updateDeploymentSettings() {
      return updateDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to updateDeployment. */
    public OperationCallSettings.Builder<UpdateDeploymentRequest, Deployment, OperationMetadata>
        updateDeploymentOperationSettings() {
      return updateDeploymentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDeployment. */
    public UnaryCallSettings.Builder<DeleteDeploymentRequest, Operation>
        deleteDeploymentSettings() {
      return deleteDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDeployment. */
    public OperationCallSettings.Builder<DeleteDeploymentRequest, Deployment, OperationMetadata>
        deleteDeploymentOperationSettings() {
      return deleteDeploymentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listRevisions. */
    public PagedCallSettings.Builder<
            ListRevisionsRequest, ListRevisionsResponse, ListRevisionsPagedResponse>
        listRevisionsSettings() {
      return listRevisionsSettings;
    }

    /** Returns the builder for the settings used for calls to getRevision. */
    public UnaryCallSettings.Builder<GetRevisionRequest, Revision> getRevisionSettings() {
      return getRevisionSettings;
    }

    /** Returns the builder for the settings used for calls to getResource. */
    public UnaryCallSettings.Builder<GetResourceRequest, Resource> getResourceSettings() {
      return getResourceSettings;
    }

    /** Returns the builder for the settings used for calls to listResources. */
    public PagedCallSettings.Builder<
            ListResourcesRequest, ListResourcesResponse, ListResourcesPagedResponse>
        listResourcesSettings() {
      return listResourcesSettings;
    }

    /** Returns the builder for the settings used for calls to exportDeploymentStatefile. */
    public UnaryCallSettings.Builder<ExportDeploymentStatefileRequest, Statefile>
        exportDeploymentStatefileSettings() {
      return exportDeploymentStatefileSettings;
    }

    /** Returns the builder for the settings used for calls to exportRevisionStatefile. */
    public UnaryCallSettings.Builder<ExportRevisionStatefileRequest, Statefile>
        exportRevisionStatefileSettings() {
      return exportRevisionStatefileSettings;
    }

    /** Returns the builder for the settings used for calls to importStatefile. */
    public UnaryCallSettings.Builder<ImportStatefileRequest, Statefile> importStatefileSettings() {
      return importStatefileSettings;
    }

    /** Returns the builder for the settings used for calls to deleteStatefile. */
    public UnaryCallSettings.Builder<DeleteStatefileRequest, Empty> deleteStatefileSettings() {
      return deleteStatefileSettings;
    }

    /** Returns the builder for the settings used for calls to lockDeployment. */
    public UnaryCallSettings.Builder<LockDeploymentRequest, Operation> lockDeploymentSettings() {
      return lockDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to lockDeployment. */
    public OperationCallSettings.Builder<LockDeploymentRequest, Deployment, OperationMetadata>
        lockDeploymentOperationSettings() {
      return lockDeploymentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to unlockDeployment. */
    public UnaryCallSettings.Builder<UnlockDeploymentRequest, Operation>
        unlockDeploymentSettings() {
      return unlockDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to unlockDeployment. */
    public OperationCallSettings.Builder<UnlockDeploymentRequest, Deployment, OperationMetadata>
        unlockDeploymentOperationSettings() {
      return unlockDeploymentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to exportLockInfo. */
    public UnaryCallSettings.Builder<ExportLockInfoRequest, LockInfo> exportLockInfoSettings() {
      return exportLockInfoSettings;
    }

    /** Returns the builder for the settings used for calls to createPreview. */
    public UnaryCallSettings.Builder<CreatePreviewRequest, Operation> createPreviewSettings() {
      return createPreviewSettings;
    }

    /** Returns the builder for the settings used for calls to createPreview. */
    public OperationCallSettings.Builder<CreatePreviewRequest, Preview, OperationMetadata>
        createPreviewOperationSettings() {
      return createPreviewOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getPreview. */
    public UnaryCallSettings.Builder<GetPreviewRequest, Preview> getPreviewSettings() {
      return getPreviewSettings;
    }

    /** Returns the builder for the settings used for calls to listPreviews. */
    public PagedCallSettings.Builder<
            ListPreviewsRequest, ListPreviewsResponse, ListPreviewsPagedResponse>
        listPreviewsSettings() {
      return listPreviewsSettings;
    }

    /** Returns the builder for the settings used for calls to deletePreview. */
    public UnaryCallSettings.Builder<DeletePreviewRequest, Operation> deletePreviewSettings() {
      return deletePreviewSettings;
    }

    /** Returns the builder for the settings used for calls to deletePreview. */
    public OperationCallSettings.Builder<DeletePreviewRequest, Preview, OperationMetadata>
        deletePreviewOperationSettings() {
      return deletePreviewOperationSettings;
    }

    /** Returns the builder for the settings used for calls to exportPreviewResult. */
    public UnaryCallSettings.Builder<ExportPreviewResultRequest, ExportPreviewResultResponse>
        exportPreviewResultSettings() {
      return exportPreviewResultSettings;
    }

    /** Returns the builder for the settings used for calls to listTerraformVersions. */
    public PagedCallSettings.Builder<
            ListTerraformVersionsRequest,
            ListTerraformVersionsResponse,
            ListTerraformVersionsPagedResponse>
        listTerraformVersionsSettings() {
      return listTerraformVersionsSettings;
    }

    /** Returns the builder for the settings used for calls to getTerraformVersion. */
    public UnaryCallSettings.Builder<GetTerraformVersionRequest, TerraformVersion>
        getTerraformVersionSettings() {
      return getTerraformVersionSettings;
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return listLocationsSettings;
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getLocationSettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public ConfigStubSettings build() throws IOException {
      return new ConfigStubSettings(this);
    }
  }
}
