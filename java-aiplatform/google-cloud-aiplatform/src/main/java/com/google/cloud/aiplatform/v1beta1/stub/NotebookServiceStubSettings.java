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

package com.google.cloud.aiplatform.v1beta1.stub;

import static com.google.cloud.aiplatform.v1beta1.NotebookServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.NotebookServiceClient.ListNotebookExecutionJobsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.NotebookServiceClient.ListNotebookRuntimeTemplatesPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.NotebookServiceClient.ListNotebookRuntimesPagedResponse;

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
import com.google.cloud.aiplatform.v1beta1.AssignNotebookRuntimeOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.AssignNotebookRuntimeRequest;
import com.google.cloud.aiplatform.v1beta1.CreateNotebookRuntimeTemplateOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateNotebookRuntimeTemplateRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteNotebookExecutionJobRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteNotebookRuntimeRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteNotebookRuntimeTemplateRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.GetNotebookExecutionJobRequest;
import com.google.cloud.aiplatform.v1beta1.GetNotebookRuntimeRequest;
import com.google.cloud.aiplatform.v1beta1.GetNotebookRuntimeTemplateRequest;
import com.google.cloud.aiplatform.v1beta1.ListNotebookExecutionJobsRequest;
import com.google.cloud.aiplatform.v1beta1.ListNotebookExecutionJobsResponse;
import com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimeTemplatesRequest;
import com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimeTemplatesResponse;
import com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimesRequest;
import com.google.cloud.aiplatform.v1beta1.ListNotebookRuntimesResponse;
import com.google.cloud.aiplatform.v1beta1.NotebookExecutionJob;
import com.google.cloud.aiplatform.v1beta1.NotebookRuntime;
import com.google.cloud.aiplatform.v1beta1.NotebookRuntimeTemplate;
import com.google.cloud.aiplatform.v1beta1.StartNotebookRuntimeOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.StartNotebookRuntimeRequest;
import com.google.cloud.aiplatform.v1beta1.StartNotebookRuntimeResponse;
import com.google.cloud.aiplatform.v1beta1.UpgradeNotebookRuntimeOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.UpgradeNotebookRuntimeRequest;
import com.google.cloud.aiplatform.v1beta1.UpgradeNotebookRuntimeResponse;
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
 * Settings class to configure an instance of {@link NotebookServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (aiplatform.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getNotebookRuntimeTemplate to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * NotebookServiceStubSettings.Builder notebookServiceSettingsBuilder =
 *     NotebookServiceStubSettings.newBuilder();
 * notebookServiceSettingsBuilder
 *     .getNotebookRuntimeTemplateSettings()
 *     .setRetrySettings(
 *         notebookServiceSettingsBuilder
 *             .getNotebookRuntimeTemplateSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * NotebookServiceStubSettings notebookServiceSettings = notebookServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class NotebookServiceStubSettings extends StubSettings<NotebookServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateNotebookRuntimeTemplateRequest, Operation>
      createNotebookRuntimeTemplateSettings;
  private final OperationCallSettings<
          CreateNotebookRuntimeTemplateRequest,
          NotebookRuntimeTemplate,
          CreateNotebookRuntimeTemplateOperationMetadata>
      createNotebookRuntimeTemplateOperationSettings;
  private final UnaryCallSettings<GetNotebookRuntimeTemplateRequest, NotebookRuntimeTemplate>
      getNotebookRuntimeTemplateSettings;
  private final PagedCallSettings<
          ListNotebookRuntimeTemplatesRequest,
          ListNotebookRuntimeTemplatesResponse,
          ListNotebookRuntimeTemplatesPagedResponse>
      listNotebookRuntimeTemplatesSettings;
  private final UnaryCallSettings<DeleteNotebookRuntimeTemplateRequest, Operation>
      deleteNotebookRuntimeTemplateSettings;
  private final OperationCallSettings<
          DeleteNotebookRuntimeTemplateRequest, Empty, DeleteOperationMetadata>
      deleteNotebookRuntimeTemplateOperationSettings;
  private final UnaryCallSettings<AssignNotebookRuntimeRequest, Operation>
      assignNotebookRuntimeSettings;
  private final OperationCallSettings<
          AssignNotebookRuntimeRequest, NotebookRuntime, AssignNotebookRuntimeOperationMetadata>
      assignNotebookRuntimeOperationSettings;
  private final UnaryCallSettings<GetNotebookRuntimeRequest, NotebookRuntime>
      getNotebookRuntimeSettings;
  private final PagedCallSettings<
          ListNotebookRuntimesRequest,
          ListNotebookRuntimesResponse,
          ListNotebookRuntimesPagedResponse>
      listNotebookRuntimesSettings;
  private final UnaryCallSettings<DeleteNotebookRuntimeRequest, Operation>
      deleteNotebookRuntimeSettings;
  private final OperationCallSettings<DeleteNotebookRuntimeRequest, Empty, DeleteOperationMetadata>
      deleteNotebookRuntimeOperationSettings;
  private final UnaryCallSettings<UpgradeNotebookRuntimeRequest, Operation>
      upgradeNotebookRuntimeSettings;
  private final OperationCallSettings<
          UpgradeNotebookRuntimeRequest,
          UpgradeNotebookRuntimeResponse,
          UpgradeNotebookRuntimeOperationMetadata>
      upgradeNotebookRuntimeOperationSettings;
  private final UnaryCallSettings<StartNotebookRuntimeRequest, Operation>
      startNotebookRuntimeSettings;
  private final OperationCallSettings<
          StartNotebookRuntimeRequest,
          StartNotebookRuntimeResponse,
          StartNotebookRuntimeOperationMetadata>
      startNotebookRuntimeOperationSettings;
  private final UnaryCallSettings<GetNotebookExecutionJobRequest, NotebookExecutionJob>
      getNotebookExecutionJobSettings;
  private final PagedCallSettings<
          ListNotebookExecutionJobsRequest,
          ListNotebookExecutionJobsResponse,
          ListNotebookExecutionJobsPagedResponse>
      listNotebookExecutionJobsSettings;
  private final UnaryCallSettings<DeleteNotebookExecutionJobRequest, Operation>
      deleteNotebookExecutionJobSettings;
  private final OperationCallSettings<
          DeleteNotebookExecutionJobRequest, Empty, DeleteOperationMetadata>
      deleteNotebookExecutionJobOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListNotebookRuntimeTemplatesRequest,
          ListNotebookRuntimeTemplatesResponse,
          NotebookRuntimeTemplate>
      LIST_NOTEBOOK_RUNTIME_TEMPLATES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListNotebookRuntimeTemplatesRequest,
              ListNotebookRuntimeTemplatesResponse,
              NotebookRuntimeTemplate>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListNotebookRuntimeTemplatesRequest injectToken(
                ListNotebookRuntimeTemplatesRequest payload, String token) {
              return ListNotebookRuntimeTemplatesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListNotebookRuntimeTemplatesRequest injectPageSize(
                ListNotebookRuntimeTemplatesRequest payload, int pageSize) {
              return ListNotebookRuntimeTemplatesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListNotebookRuntimeTemplatesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListNotebookRuntimeTemplatesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<NotebookRuntimeTemplate> extractResources(
                ListNotebookRuntimeTemplatesResponse payload) {
              return payload.getNotebookRuntimeTemplatesList() == null
                  ? ImmutableList.<NotebookRuntimeTemplate>of()
                  : payload.getNotebookRuntimeTemplatesList();
            }
          };

  private static final PagedListDescriptor<
          ListNotebookRuntimesRequest, ListNotebookRuntimesResponse, NotebookRuntime>
      LIST_NOTEBOOK_RUNTIMES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListNotebookRuntimesRequest, ListNotebookRuntimesResponse, NotebookRuntime>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListNotebookRuntimesRequest injectToken(
                ListNotebookRuntimesRequest payload, String token) {
              return ListNotebookRuntimesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListNotebookRuntimesRequest injectPageSize(
                ListNotebookRuntimesRequest payload, int pageSize) {
              return ListNotebookRuntimesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListNotebookRuntimesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListNotebookRuntimesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<NotebookRuntime> extractResources(
                ListNotebookRuntimesResponse payload) {
              return payload.getNotebookRuntimesList() == null
                  ? ImmutableList.<NotebookRuntime>of()
                  : payload.getNotebookRuntimesList();
            }
          };

  private static final PagedListDescriptor<
          ListNotebookExecutionJobsRequest, ListNotebookExecutionJobsResponse, NotebookExecutionJob>
      LIST_NOTEBOOK_EXECUTION_JOBS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListNotebookExecutionJobsRequest,
              ListNotebookExecutionJobsResponse,
              NotebookExecutionJob>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListNotebookExecutionJobsRequest injectToken(
                ListNotebookExecutionJobsRequest payload, String token) {
              return ListNotebookExecutionJobsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListNotebookExecutionJobsRequest injectPageSize(
                ListNotebookExecutionJobsRequest payload, int pageSize) {
              return ListNotebookExecutionJobsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListNotebookExecutionJobsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListNotebookExecutionJobsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<NotebookExecutionJob> extractResources(
                ListNotebookExecutionJobsResponse payload) {
              return payload.getNotebookExecutionJobsList() == null
                  ? ImmutableList.<NotebookExecutionJob>of()
                  : payload.getNotebookExecutionJobsList();
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
          ListNotebookRuntimeTemplatesRequest,
          ListNotebookRuntimeTemplatesResponse,
          ListNotebookRuntimeTemplatesPagedResponse>
      LIST_NOTEBOOK_RUNTIME_TEMPLATES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListNotebookRuntimeTemplatesRequest,
              ListNotebookRuntimeTemplatesResponse,
              ListNotebookRuntimeTemplatesPagedResponse>() {
            @Override
            public ApiFuture<ListNotebookRuntimeTemplatesPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListNotebookRuntimeTemplatesRequest, ListNotebookRuntimeTemplatesResponse>
                    callable,
                ListNotebookRuntimeTemplatesRequest request,
                ApiCallContext context,
                ApiFuture<ListNotebookRuntimeTemplatesResponse> futureResponse) {
              PageContext<
                      ListNotebookRuntimeTemplatesRequest,
                      ListNotebookRuntimeTemplatesResponse,
                      NotebookRuntimeTemplate>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_NOTEBOOK_RUNTIME_TEMPLATES_PAGE_STR_DESC,
                          request,
                          context);
              return ListNotebookRuntimeTemplatesPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListNotebookRuntimesRequest,
          ListNotebookRuntimesResponse,
          ListNotebookRuntimesPagedResponse>
      LIST_NOTEBOOK_RUNTIMES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListNotebookRuntimesRequest,
              ListNotebookRuntimesResponse,
              ListNotebookRuntimesPagedResponse>() {
            @Override
            public ApiFuture<ListNotebookRuntimesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListNotebookRuntimesRequest, ListNotebookRuntimesResponse> callable,
                ListNotebookRuntimesRequest request,
                ApiCallContext context,
                ApiFuture<ListNotebookRuntimesResponse> futureResponse) {
              PageContext<
                      ListNotebookRuntimesRequest, ListNotebookRuntimesResponse, NotebookRuntime>
                  pageContext =
                      PageContext.create(
                          callable, LIST_NOTEBOOK_RUNTIMES_PAGE_STR_DESC, request, context);
              return ListNotebookRuntimesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListNotebookExecutionJobsRequest,
          ListNotebookExecutionJobsResponse,
          ListNotebookExecutionJobsPagedResponse>
      LIST_NOTEBOOK_EXECUTION_JOBS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListNotebookExecutionJobsRequest,
              ListNotebookExecutionJobsResponse,
              ListNotebookExecutionJobsPagedResponse>() {
            @Override
            public ApiFuture<ListNotebookExecutionJobsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListNotebookExecutionJobsRequest, ListNotebookExecutionJobsResponse>
                    callable,
                ListNotebookExecutionJobsRequest request,
                ApiCallContext context,
                ApiFuture<ListNotebookExecutionJobsResponse> futureResponse) {
              PageContext<
                      ListNotebookExecutionJobsRequest,
                      ListNotebookExecutionJobsResponse,
                      NotebookExecutionJob>
                  pageContext =
                      PageContext.create(
                          callable, LIST_NOTEBOOK_EXECUTION_JOBS_PAGE_STR_DESC, request, context);
              return ListNotebookExecutionJobsPagedResponse.createAsync(
                  pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to createNotebookRuntimeTemplate. */
  public UnaryCallSettings<CreateNotebookRuntimeTemplateRequest, Operation>
      createNotebookRuntimeTemplateSettings() {
    return createNotebookRuntimeTemplateSettings;
  }

  /** Returns the object with the settings used for calls to createNotebookRuntimeTemplate. */
  public OperationCallSettings<
          CreateNotebookRuntimeTemplateRequest,
          NotebookRuntimeTemplate,
          CreateNotebookRuntimeTemplateOperationMetadata>
      createNotebookRuntimeTemplateOperationSettings() {
    return createNotebookRuntimeTemplateOperationSettings;
  }

  /** Returns the object with the settings used for calls to getNotebookRuntimeTemplate. */
  public UnaryCallSettings<GetNotebookRuntimeTemplateRequest, NotebookRuntimeTemplate>
      getNotebookRuntimeTemplateSettings() {
    return getNotebookRuntimeTemplateSettings;
  }

  /** Returns the object with the settings used for calls to listNotebookRuntimeTemplates. */
  public PagedCallSettings<
          ListNotebookRuntimeTemplatesRequest,
          ListNotebookRuntimeTemplatesResponse,
          ListNotebookRuntimeTemplatesPagedResponse>
      listNotebookRuntimeTemplatesSettings() {
    return listNotebookRuntimeTemplatesSettings;
  }

  /** Returns the object with the settings used for calls to deleteNotebookRuntimeTemplate. */
  public UnaryCallSettings<DeleteNotebookRuntimeTemplateRequest, Operation>
      deleteNotebookRuntimeTemplateSettings() {
    return deleteNotebookRuntimeTemplateSettings;
  }

  /** Returns the object with the settings used for calls to deleteNotebookRuntimeTemplate. */
  public OperationCallSettings<DeleteNotebookRuntimeTemplateRequest, Empty, DeleteOperationMetadata>
      deleteNotebookRuntimeTemplateOperationSettings() {
    return deleteNotebookRuntimeTemplateOperationSettings;
  }

  /** Returns the object with the settings used for calls to assignNotebookRuntime. */
  public UnaryCallSettings<AssignNotebookRuntimeRequest, Operation>
      assignNotebookRuntimeSettings() {
    return assignNotebookRuntimeSettings;
  }

  /** Returns the object with the settings used for calls to assignNotebookRuntime. */
  public OperationCallSettings<
          AssignNotebookRuntimeRequest, NotebookRuntime, AssignNotebookRuntimeOperationMetadata>
      assignNotebookRuntimeOperationSettings() {
    return assignNotebookRuntimeOperationSettings;
  }

  /** Returns the object with the settings used for calls to getNotebookRuntime. */
  public UnaryCallSettings<GetNotebookRuntimeRequest, NotebookRuntime>
      getNotebookRuntimeSettings() {
    return getNotebookRuntimeSettings;
  }

  /** Returns the object with the settings used for calls to listNotebookRuntimes. */
  public PagedCallSettings<
          ListNotebookRuntimesRequest,
          ListNotebookRuntimesResponse,
          ListNotebookRuntimesPagedResponse>
      listNotebookRuntimesSettings() {
    return listNotebookRuntimesSettings;
  }

  /** Returns the object with the settings used for calls to deleteNotebookRuntime. */
  public UnaryCallSettings<DeleteNotebookRuntimeRequest, Operation>
      deleteNotebookRuntimeSettings() {
    return deleteNotebookRuntimeSettings;
  }

  /** Returns the object with the settings used for calls to deleteNotebookRuntime. */
  public OperationCallSettings<DeleteNotebookRuntimeRequest, Empty, DeleteOperationMetadata>
      deleteNotebookRuntimeOperationSettings() {
    return deleteNotebookRuntimeOperationSettings;
  }

  /** Returns the object with the settings used for calls to upgradeNotebookRuntime. */
  public UnaryCallSettings<UpgradeNotebookRuntimeRequest, Operation>
      upgradeNotebookRuntimeSettings() {
    return upgradeNotebookRuntimeSettings;
  }

  /** Returns the object with the settings used for calls to upgradeNotebookRuntime. */
  public OperationCallSettings<
          UpgradeNotebookRuntimeRequest,
          UpgradeNotebookRuntimeResponse,
          UpgradeNotebookRuntimeOperationMetadata>
      upgradeNotebookRuntimeOperationSettings() {
    return upgradeNotebookRuntimeOperationSettings;
  }

  /** Returns the object with the settings used for calls to startNotebookRuntime. */
  public UnaryCallSettings<StartNotebookRuntimeRequest, Operation> startNotebookRuntimeSettings() {
    return startNotebookRuntimeSettings;
  }

  /** Returns the object with the settings used for calls to startNotebookRuntime. */
  public OperationCallSettings<
          StartNotebookRuntimeRequest,
          StartNotebookRuntimeResponse,
          StartNotebookRuntimeOperationMetadata>
      startNotebookRuntimeOperationSettings() {
    return startNotebookRuntimeOperationSettings;
  }

  /** Returns the object with the settings used for calls to getNotebookExecutionJob. */
  public UnaryCallSettings<GetNotebookExecutionJobRequest, NotebookExecutionJob>
      getNotebookExecutionJobSettings() {
    return getNotebookExecutionJobSettings;
  }

  /** Returns the object with the settings used for calls to listNotebookExecutionJobs. */
  public PagedCallSettings<
          ListNotebookExecutionJobsRequest,
          ListNotebookExecutionJobsResponse,
          ListNotebookExecutionJobsPagedResponse>
      listNotebookExecutionJobsSettings() {
    return listNotebookExecutionJobsSettings;
  }

  /** Returns the object with the settings used for calls to deleteNotebookExecutionJob. */
  public UnaryCallSettings<DeleteNotebookExecutionJobRequest, Operation>
      deleteNotebookExecutionJobSettings() {
    return deleteNotebookExecutionJobSettings;
  }

  /** Returns the object with the settings used for calls to deleteNotebookExecutionJob. */
  public OperationCallSettings<DeleteNotebookExecutionJobRequest, Empty, DeleteOperationMetadata>
      deleteNotebookExecutionJobOperationSettings() {
    return deleteNotebookExecutionJobOperationSettings;
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

  public NotebookServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcNotebookServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "aiplatform";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "aiplatform.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "aiplatform.mtls.googleapis.com:443";
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

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(NotebookServiceStubSettings.class))
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

  protected NotebookServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createNotebookRuntimeTemplateSettings =
        settingsBuilder.createNotebookRuntimeTemplateSettings().build();
    createNotebookRuntimeTemplateOperationSettings =
        settingsBuilder.createNotebookRuntimeTemplateOperationSettings().build();
    getNotebookRuntimeTemplateSettings =
        settingsBuilder.getNotebookRuntimeTemplateSettings().build();
    listNotebookRuntimeTemplatesSettings =
        settingsBuilder.listNotebookRuntimeTemplatesSettings().build();
    deleteNotebookRuntimeTemplateSettings =
        settingsBuilder.deleteNotebookRuntimeTemplateSettings().build();
    deleteNotebookRuntimeTemplateOperationSettings =
        settingsBuilder.deleteNotebookRuntimeTemplateOperationSettings().build();
    assignNotebookRuntimeSettings = settingsBuilder.assignNotebookRuntimeSettings().build();
    assignNotebookRuntimeOperationSettings =
        settingsBuilder.assignNotebookRuntimeOperationSettings().build();
    getNotebookRuntimeSettings = settingsBuilder.getNotebookRuntimeSettings().build();
    listNotebookRuntimesSettings = settingsBuilder.listNotebookRuntimesSettings().build();
    deleteNotebookRuntimeSettings = settingsBuilder.deleteNotebookRuntimeSettings().build();
    deleteNotebookRuntimeOperationSettings =
        settingsBuilder.deleteNotebookRuntimeOperationSettings().build();
    upgradeNotebookRuntimeSettings = settingsBuilder.upgradeNotebookRuntimeSettings().build();
    upgradeNotebookRuntimeOperationSettings =
        settingsBuilder.upgradeNotebookRuntimeOperationSettings().build();
    startNotebookRuntimeSettings = settingsBuilder.startNotebookRuntimeSettings().build();
    startNotebookRuntimeOperationSettings =
        settingsBuilder.startNotebookRuntimeOperationSettings().build();
    getNotebookExecutionJobSettings = settingsBuilder.getNotebookExecutionJobSettings().build();
    listNotebookExecutionJobsSettings = settingsBuilder.listNotebookExecutionJobsSettings().build();
    deleteNotebookExecutionJobSettings =
        settingsBuilder.deleteNotebookExecutionJobSettings().build();
    deleteNotebookExecutionJobOperationSettings =
        settingsBuilder.deleteNotebookExecutionJobOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for NotebookServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<NotebookServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateNotebookRuntimeTemplateRequest, Operation>
        createNotebookRuntimeTemplateSettings;
    private final OperationCallSettings.Builder<
            CreateNotebookRuntimeTemplateRequest,
            NotebookRuntimeTemplate,
            CreateNotebookRuntimeTemplateOperationMetadata>
        createNotebookRuntimeTemplateOperationSettings;
    private final UnaryCallSettings.Builder<
            GetNotebookRuntimeTemplateRequest, NotebookRuntimeTemplate>
        getNotebookRuntimeTemplateSettings;
    private final PagedCallSettings.Builder<
            ListNotebookRuntimeTemplatesRequest,
            ListNotebookRuntimeTemplatesResponse,
            ListNotebookRuntimeTemplatesPagedResponse>
        listNotebookRuntimeTemplatesSettings;
    private final UnaryCallSettings.Builder<DeleteNotebookRuntimeTemplateRequest, Operation>
        deleteNotebookRuntimeTemplateSettings;
    private final OperationCallSettings.Builder<
            DeleteNotebookRuntimeTemplateRequest, Empty, DeleteOperationMetadata>
        deleteNotebookRuntimeTemplateOperationSettings;
    private final UnaryCallSettings.Builder<AssignNotebookRuntimeRequest, Operation>
        assignNotebookRuntimeSettings;
    private final OperationCallSettings.Builder<
            AssignNotebookRuntimeRequest, NotebookRuntime, AssignNotebookRuntimeOperationMetadata>
        assignNotebookRuntimeOperationSettings;
    private final UnaryCallSettings.Builder<GetNotebookRuntimeRequest, NotebookRuntime>
        getNotebookRuntimeSettings;
    private final PagedCallSettings.Builder<
            ListNotebookRuntimesRequest,
            ListNotebookRuntimesResponse,
            ListNotebookRuntimesPagedResponse>
        listNotebookRuntimesSettings;
    private final UnaryCallSettings.Builder<DeleteNotebookRuntimeRequest, Operation>
        deleteNotebookRuntimeSettings;
    private final OperationCallSettings.Builder<
            DeleteNotebookRuntimeRequest, Empty, DeleteOperationMetadata>
        deleteNotebookRuntimeOperationSettings;
    private final UnaryCallSettings.Builder<UpgradeNotebookRuntimeRequest, Operation>
        upgradeNotebookRuntimeSettings;
    private final OperationCallSettings.Builder<
            UpgradeNotebookRuntimeRequest,
            UpgradeNotebookRuntimeResponse,
            UpgradeNotebookRuntimeOperationMetadata>
        upgradeNotebookRuntimeOperationSettings;
    private final UnaryCallSettings.Builder<StartNotebookRuntimeRequest, Operation>
        startNotebookRuntimeSettings;
    private final OperationCallSettings.Builder<
            StartNotebookRuntimeRequest,
            StartNotebookRuntimeResponse,
            StartNotebookRuntimeOperationMetadata>
        startNotebookRuntimeOperationSettings;
    private final UnaryCallSettings.Builder<GetNotebookExecutionJobRequest, NotebookExecutionJob>
        getNotebookExecutionJobSettings;
    private final PagedCallSettings.Builder<
            ListNotebookExecutionJobsRequest,
            ListNotebookExecutionJobsResponse,
            ListNotebookExecutionJobsPagedResponse>
        listNotebookExecutionJobsSettings;
    private final UnaryCallSettings.Builder<DeleteNotebookExecutionJobRequest, Operation>
        deleteNotebookExecutionJobSettings;
    private final OperationCallSettings.Builder<
            DeleteNotebookExecutionJobRequest, Empty, DeleteOperationMetadata>
        deleteNotebookExecutionJobOperationSettings;
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

      createNotebookRuntimeTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createNotebookRuntimeTemplateOperationSettings = OperationCallSettings.newBuilder();
      getNotebookRuntimeTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listNotebookRuntimeTemplatesSettings =
          PagedCallSettings.newBuilder(LIST_NOTEBOOK_RUNTIME_TEMPLATES_PAGE_STR_FACT);
      deleteNotebookRuntimeTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteNotebookRuntimeTemplateOperationSettings = OperationCallSettings.newBuilder();
      assignNotebookRuntimeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      assignNotebookRuntimeOperationSettings = OperationCallSettings.newBuilder();
      getNotebookRuntimeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listNotebookRuntimesSettings =
          PagedCallSettings.newBuilder(LIST_NOTEBOOK_RUNTIMES_PAGE_STR_FACT);
      deleteNotebookRuntimeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteNotebookRuntimeOperationSettings = OperationCallSettings.newBuilder();
      upgradeNotebookRuntimeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      upgradeNotebookRuntimeOperationSettings = OperationCallSettings.newBuilder();
      startNotebookRuntimeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      startNotebookRuntimeOperationSettings = OperationCallSettings.newBuilder();
      getNotebookExecutionJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listNotebookExecutionJobsSettings =
          PagedCallSettings.newBuilder(LIST_NOTEBOOK_EXECUTION_JOBS_PAGE_STR_FACT);
      deleteNotebookExecutionJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteNotebookExecutionJobOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createNotebookRuntimeTemplateSettings,
              getNotebookRuntimeTemplateSettings,
              listNotebookRuntimeTemplatesSettings,
              deleteNotebookRuntimeTemplateSettings,
              assignNotebookRuntimeSettings,
              getNotebookRuntimeSettings,
              listNotebookRuntimesSettings,
              deleteNotebookRuntimeSettings,
              upgradeNotebookRuntimeSettings,
              startNotebookRuntimeSettings,
              getNotebookExecutionJobSettings,
              listNotebookExecutionJobsSettings,
              deleteNotebookExecutionJobSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(NotebookServiceStubSettings settings) {
      super(settings);

      createNotebookRuntimeTemplateSettings =
          settings.createNotebookRuntimeTemplateSettings.toBuilder();
      createNotebookRuntimeTemplateOperationSettings =
          settings.createNotebookRuntimeTemplateOperationSettings.toBuilder();
      getNotebookRuntimeTemplateSettings = settings.getNotebookRuntimeTemplateSettings.toBuilder();
      listNotebookRuntimeTemplatesSettings =
          settings.listNotebookRuntimeTemplatesSettings.toBuilder();
      deleteNotebookRuntimeTemplateSettings =
          settings.deleteNotebookRuntimeTemplateSettings.toBuilder();
      deleteNotebookRuntimeTemplateOperationSettings =
          settings.deleteNotebookRuntimeTemplateOperationSettings.toBuilder();
      assignNotebookRuntimeSettings = settings.assignNotebookRuntimeSettings.toBuilder();
      assignNotebookRuntimeOperationSettings =
          settings.assignNotebookRuntimeOperationSettings.toBuilder();
      getNotebookRuntimeSettings = settings.getNotebookRuntimeSettings.toBuilder();
      listNotebookRuntimesSettings = settings.listNotebookRuntimesSettings.toBuilder();
      deleteNotebookRuntimeSettings = settings.deleteNotebookRuntimeSettings.toBuilder();
      deleteNotebookRuntimeOperationSettings =
          settings.deleteNotebookRuntimeOperationSettings.toBuilder();
      upgradeNotebookRuntimeSettings = settings.upgradeNotebookRuntimeSettings.toBuilder();
      upgradeNotebookRuntimeOperationSettings =
          settings.upgradeNotebookRuntimeOperationSettings.toBuilder();
      startNotebookRuntimeSettings = settings.startNotebookRuntimeSettings.toBuilder();
      startNotebookRuntimeOperationSettings =
          settings.startNotebookRuntimeOperationSettings.toBuilder();
      getNotebookExecutionJobSettings = settings.getNotebookExecutionJobSettings.toBuilder();
      listNotebookExecutionJobsSettings = settings.listNotebookExecutionJobsSettings.toBuilder();
      deleteNotebookExecutionJobSettings = settings.deleteNotebookExecutionJobSettings.toBuilder();
      deleteNotebookExecutionJobOperationSettings =
          settings.deleteNotebookExecutionJobOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createNotebookRuntimeTemplateSettings,
              getNotebookRuntimeTemplateSettings,
              listNotebookRuntimeTemplatesSettings,
              deleteNotebookRuntimeTemplateSettings,
              assignNotebookRuntimeSettings,
              getNotebookRuntimeSettings,
              listNotebookRuntimesSettings,
              deleteNotebookRuntimeSettings,
              upgradeNotebookRuntimeSettings,
              startNotebookRuntimeSettings,
              getNotebookExecutionJobSettings,
              listNotebookExecutionJobsSettings,
              deleteNotebookExecutionJobSettings,
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

    private static Builder initDefaults(Builder builder) {
      builder
          .createNotebookRuntimeTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getNotebookRuntimeTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listNotebookRuntimeTemplatesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteNotebookRuntimeTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .assignNotebookRuntimeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getNotebookRuntimeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listNotebookRuntimesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteNotebookRuntimeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .upgradeNotebookRuntimeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .startNotebookRuntimeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getNotebookExecutionJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listNotebookExecutionJobsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteNotebookExecutionJobSettings()
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
          .createNotebookRuntimeTemplateOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateNotebookRuntimeTemplateRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(NotebookRuntimeTemplate.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  CreateNotebookRuntimeTemplateOperationMetadata.class))
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
          .deleteNotebookRuntimeTemplateOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteNotebookRuntimeTemplateRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(DeleteOperationMetadata.class))
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
          .assignNotebookRuntimeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<AssignNotebookRuntimeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(NotebookRuntime.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  AssignNotebookRuntimeOperationMetadata.class))
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
          .deleteNotebookRuntimeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteNotebookRuntimeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(DeleteOperationMetadata.class))
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
          .upgradeNotebookRuntimeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpgradeNotebookRuntimeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  UpgradeNotebookRuntimeResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  UpgradeNotebookRuntimeOperationMetadata.class))
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
          .startNotebookRuntimeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<StartNotebookRuntimeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  StartNotebookRuntimeResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  StartNotebookRuntimeOperationMetadata.class))
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
          .deleteNotebookExecutionJobOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteNotebookExecutionJobRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(DeleteOperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to createNotebookRuntimeTemplate. */
    public UnaryCallSettings.Builder<CreateNotebookRuntimeTemplateRequest, Operation>
        createNotebookRuntimeTemplateSettings() {
      return createNotebookRuntimeTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to createNotebookRuntimeTemplate. */
    public OperationCallSettings.Builder<
            CreateNotebookRuntimeTemplateRequest,
            NotebookRuntimeTemplate,
            CreateNotebookRuntimeTemplateOperationMetadata>
        createNotebookRuntimeTemplateOperationSettings() {
      return createNotebookRuntimeTemplateOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getNotebookRuntimeTemplate. */
    public UnaryCallSettings.Builder<GetNotebookRuntimeTemplateRequest, NotebookRuntimeTemplate>
        getNotebookRuntimeTemplateSettings() {
      return getNotebookRuntimeTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to listNotebookRuntimeTemplates. */
    public PagedCallSettings.Builder<
            ListNotebookRuntimeTemplatesRequest,
            ListNotebookRuntimeTemplatesResponse,
            ListNotebookRuntimeTemplatesPagedResponse>
        listNotebookRuntimeTemplatesSettings() {
      return listNotebookRuntimeTemplatesSettings;
    }

    /** Returns the builder for the settings used for calls to deleteNotebookRuntimeTemplate. */
    public UnaryCallSettings.Builder<DeleteNotebookRuntimeTemplateRequest, Operation>
        deleteNotebookRuntimeTemplateSettings() {
      return deleteNotebookRuntimeTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to deleteNotebookRuntimeTemplate. */
    public OperationCallSettings.Builder<
            DeleteNotebookRuntimeTemplateRequest, Empty, DeleteOperationMetadata>
        deleteNotebookRuntimeTemplateOperationSettings() {
      return deleteNotebookRuntimeTemplateOperationSettings;
    }

    /** Returns the builder for the settings used for calls to assignNotebookRuntime. */
    public UnaryCallSettings.Builder<AssignNotebookRuntimeRequest, Operation>
        assignNotebookRuntimeSettings() {
      return assignNotebookRuntimeSettings;
    }

    /** Returns the builder for the settings used for calls to assignNotebookRuntime. */
    public OperationCallSettings.Builder<
            AssignNotebookRuntimeRequest, NotebookRuntime, AssignNotebookRuntimeOperationMetadata>
        assignNotebookRuntimeOperationSettings() {
      return assignNotebookRuntimeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getNotebookRuntime. */
    public UnaryCallSettings.Builder<GetNotebookRuntimeRequest, NotebookRuntime>
        getNotebookRuntimeSettings() {
      return getNotebookRuntimeSettings;
    }

    /** Returns the builder for the settings used for calls to listNotebookRuntimes. */
    public PagedCallSettings.Builder<
            ListNotebookRuntimesRequest,
            ListNotebookRuntimesResponse,
            ListNotebookRuntimesPagedResponse>
        listNotebookRuntimesSettings() {
      return listNotebookRuntimesSettings;
    }

    /** Returns the builder for the settings used for calls to deleteNotebookRuntime. */
    public UnaryCallSettings.Builder<DeleteNotebookRuntimeRequest, Operation>
        deleteNotebookRuntimeSettings() {
      return deleteNotebookRuntimeSettings;
    }

    /** Returns the builder for the settings used for calls to deleteNotebookRuntime. */
    public OperationCallSettings.Builder<
            DeleteNotebookRuntimeRequest, Empty, DeleteOperationMetadata>
        deleteNotebookRuntimeOperationSettings() {
      return deleteNotebookRuntimeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to upgradeNotebookRuntime. */
    public UnaryCallSettings.Builder<UpgradeNotebookRuntimeRequest, Operation>
        upgradeNotebookRuntimeSettings() {
      return upgradeNotebookRuntimeSettings;
    }

    /** Returns the builder for the settings used for calls to upgradeNotebookRuntime. */
    public OperationCallSettings.Builder<
            UpgradeNotebookRuntimeRequest,
            UpgradeNotebookRuntimeResponse,
            UpgradeNotebookRuntimeOperationMetadata>
        upgradeNotebookRuntimeOperationSettings() {
      return upgradeNotebookRuntimeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to startNotebookRuntime. */
    public UnaryCallSettings.Builder<StartNotebookRuntimeRequest, Operation>
        startNotebookRuntimeSettings() {
      return startNotebookRuntimeSettings;
    }

    /** Returns the builder for the settings used for calls to startNotebookRuntime. */
    public OperationCallSettings.Builder<
            StartNotebookRuntimeRequest,
            StartNotebookRuntimeResponse,
            StartNotebookRuntimeOperationMetadata>
        startNotebookRuntimeOperationSettings() {
      return startNotebookRuntimeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getNotebookExecutionJob. */
    public UnaryCallSettings.Builder<GetNotebookExecutionJobRequest, NotebookExecutionJob>
        getNotebookExecutionJobSettings() {
      return getNotebookExecutionJobSettings;
    }

    /** Returns the builder for the settings used for calls to listNotebookExecutionJobs. */
    public PagedCallSettings.Builder<
            ListNotebookExecutionJobsRequest,
            ListNotebookExecutionJobsResponse,
            ListNotebookExecutionJobsPagedResponse>
        listNotebookExecutionJobsSettings() {
      return listNotebookExecutionJobsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteNotebookExecutionJob. */
    public UnaryCallSettings.Builder<DeleteNotebookExecutionJobRequest, Operation>
        deleteNotebookExecutionJobSettings() {
      return deleteNotebookExecutionJobSettings;
    }

    /** Returns the builder for the settings used for calls to deleteNotebookExecutionJob. */
    public OperationCallSettings.Builder<
            DeleteNotebookExecutionJobRequest, Empty, DeleteOperationMetadata>
        deleteNotebookExecutionJobOperationSettings() {
      return deleteNotebookExecutionJobOperationSettings;
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
    public NotebookServiceStubSettings build() throws IOException {
      return new NotebookServiceStubSettings(this);
    }
  }
}
