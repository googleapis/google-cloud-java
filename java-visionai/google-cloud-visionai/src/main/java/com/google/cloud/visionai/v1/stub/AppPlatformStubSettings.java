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

package com.google.cloud.visionai.v1.stub;

import static com.google.cloud.visionai.v1.AppPlatformClient.ListApplicationsPagedResponse;
import static com.google.cloud.visionai.v1.AppPlatformClient.ListDraftsPagedResponse;
import static com.google.cloud.visionai.v1.AppPlatformClient.ListInstancesPagedResponse;
import static com.google.cloud.visionai.v1.AppPlatformClient.ListProcessorsPagedResponse;

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
import com.google.cloud.visionai.v1.AddApplicationStreamInputRequest;
import com.google.cloud.visionai.v1.AddApplicationStreamInputResponse;
import com.google.cloud.visionai.v1.Application;
import com.google.cloud.visionai.v1.CreateApplicationInstancesRequest;
import com.google.cloud.visionai.v1.CreateApplicationInstancesResponse;
import com.google.cloud.visionai.v1.CreateApplicationRequest;
import com.google.cloud.visionai.v1.CreateDraftRequest;
import com.google.cloud.visionai.v1.CreateProcessorRequest;
import com.google.cloud.visionai.v1.DeleteApplicationInstancesRequest;
import com.google.cloud.visionai.v1.DeleteApplicationRequest;
import com.google.cloud.visionai.v1.DeleteDraftRequest;
import com.google.cloud.visionai.v1.DeleteProcessorRequest;
import com.google.cloud.visionai.v1.DeployApplicationRequest;
import com.google.cloud.visionai.v1.DeployApplicationResponse;
import com.google.cloud.visionai.v1.Draft;
import com.google.cloud.visionai.v1.GetApplicationRequest;
import com.google.cloud.visionai.v1.GetDraftRequest;
import com.google.cloud.visionai.v1.GetInstanceRequest;
import com.google.cloud.visionai.v1.GetProcessorRequest;
import com.google.cloud.visionai.v1.Instance;
import com.google.cloud.visionai.v1.ListApplicationsRequest;
import com.google.cloud.visionai.v1.ListApplicationsResponse;
import com.google.cloud.visionai.v1.ListDraftsRequest;
import com.google.cloud.visionai.v1.ListDraftsResponse;
import com.google.cloud.visionai.v1.ListInstancesRequest;
import com.google.cloud.visionai.v1.ListInstancesResponse;
import com.google.cloud.visionai.v1.ListPrebuiltProcessorsRequest;
import com.google.cloud.visionai.v1.ListPrebuiltProcessorsResponse;
import com.google.cloud.visionai.v1.ListProcessorsRequest;
import com.google.cloud.visionai.v1.ListProcessorsResponse;
import com.google.cloud.visionai.v1.OperationMetadata;
import com.google.cloud.visionai.v1.Processor;
import com.google.cloud.visionai.v1.RemoveApplicationStreamInputRequest;
import com.google.cloud.visionai.v1.RemoveApplicationStreamInputResponse;
import com.google.cloud.visionai.v1.UndeployApplicationRequest;
import com.google.cloud.visionai.v1.UndeployApplicationResponse;
import com.google.cloud.visionai.v1.UpdateApplicationInstancesRequest;
import com.google.cloud.visionai.v1.UpdateApplicationInstancesResponse;
import com.google.cloud.visionai.v1.UpdateApplicationRequest;
import com.google.cloud.visionai.v1.UpdateApplicationStreamInputRequest;
import com.google.cloud.visionai.v1.UpdateApplicationStreamInputResponse;
import com.google.cloud.visionai.v1.UpdateDraftRequest;
import com.google.cloud.visionai.v1.UpdateProcessorRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AppPlatformStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (visionai.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getApplication to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AppPlatformStubSettings.Builder appPlatformSettingsBuilder =
 *     AppPlatformStubSettings.newBuilder();
 * appPlatformSettingsBuilder
 *     .getApplicationSettings()
 *     .setRetrySettings(
 *         appPlatformSettingsBuilder
 *             .getApplicationSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AppPlatformStubSettings appPlatformSettings = appPlatformSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AppPlatformStubSettings extends StubSettings<AppPlatformStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListApplicationsRequest, ListApplicationsResponse, ListApplicationsPagedResponse>
      listApplicationsSettings;
  private final UnaryCallSettings<GetApplicationRequest, Application> getApplicationSettings;
  private final UnaryCallSettings<CreateApplicationRequest, Operation> createApplicationSettings;
  private final OperationCallSettings<CreateApplicationRequest, Application, OperationMetadata>
      createApplicationOperationSettings;
  private final UnaryCallSettings<UpdateApplicationRequest, Operation> updateApplicationSettings;
  private final OperationCallSettings<UpdateApplicationRequest, Application, OperationMetadata>
      updateApplicationOperationSettings;
  private final UnaryCallSettings<DeleteApplicationRequest, Operation> deleteApplicationSettings;
  private final OperationCallSettings<DeleteApplicationRequest, Empty, OperationMetadata>
      deleteApplicationOperationSettings;
  private final UnaryCallSettings<DeployApplicationRequest, Operation> deployApplicationSettings;
  private final OperationCallSettings<
          DeployApplicationRequest, DeployApplicationResponse, OperationMetadata>
      deployApplicationOperationSettings;
  private final UnaryCallSettings<UndeployApplicationRequest, Operation>
      undeployApplicationSettings;
  private final OperationCallSettings<
          UndeployApplicationRequest, UndeployApplicationResponse, OperationMetadata>
      undeployApplicationOperationSettings;
  private final UnaryCallSettings<AddApplicationStreamInputRequest, Operation>
      addApplicationStreamInputSettings;
  private final OperationCallSettings<
          AddApplicationStreamInputRequest, AddApplicationStreamInputResponse, OperationMetadata>
      addApplicationStreamInputOperationSettings;
  private final UnaryCallSettings<RemoveApplicationStreamInputRequest, Operation>
      removeApplicationStreamInputSettings;
  private final OperationCallSettings<
          RemoveApplicationStreamInputRequest,
          RemoveApplicationStreamInputResponse,
          OperationMetadata>
      removeApplicationStreamInputOperationSettings;
  private final UnaryCallSettings<UpdateApplicationStreamInputRequest, Operation>
      updateApplicationStreamInputSettings;
  private final OperationCallSettings<
          UpdateApplicationStreamInputRequest,
          UpdateApplicationStreamInputResponse,
          OperationMetadata>
      updateApplicationStreamInputOperationSettings;
  private final PagedCallSettings<
          ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
      listInstancesSettings;
  private final UnaryCallSettings<GetInstanceRequest, Instance> getInstanceSettings;
  private final UnaryCallSettings<CreateApplicationInstancesRequest, Operation>
      createApplicationInstancesSettings;
  private final OperationCallSettings<
          CreateApplicationInstancesRequest, CreateApplicationInstancesResponse, OperationMetadata>
      createApplicationInstancesOperationSettings;
  private final UnaryCallSettings<DeleteApplicationInstancesRequest, Operation>
      deleteApplicationInstancesSettings;
  private final OperationCallSettings<
          DeleteApplicationInstancesRequest, Instance, OperationMetadata>
      deleteApplicationInstancesOperationSettings;
  private final UnaryCallSettings<UpdateApplicationInstancesRequest, Operation>
      updateApplicationInstancesSettings;
  private final OperationCallSettings<
          UpdateApplicationInstancesRequest, UpdateApplicationInstancesResponse, OperationMetadata>
      updateApplicationInstancesOperationSettings;
  private final PagedCallSettings<ListDraftsRequest, ListDraftsResponse, ListDraftsPagedResponse>
      listDraftsSettings;
  private final UnaryCallSettings<GetDraftRequest, Draft> getDraftSettings;
  private final UnaryCallSettings<CreateDraftRequest, Operation> createDraftSettings;
  private final OperationCallSettings<CreateDraftRequest, Draft, OperationMetadata>
      createDraftOperationSettings;
  private final UnaryCallSettings<UpdateDraftRequest, Operation> updateDraftSettings;
  private final OperationCallSettings<UpdateDraftRequest, Draft, OperationMetadata>
      updateDraftOperationSettings;
  private final UnaryCallSettings<DeleteDraftRequest, Operation> deleteDraftSettings;
  private final OperationCallSettings<DeleteDraftRequest, Empty, OperationMetadata>
      deleteDraftOperationSettings;
  private final PagedCallSettings<
          ListProcessorsRequest, ListProcessorsResponse, ListProcessorsPagedResponse>
      listProcessorsSettings;
  private final UnaryCallSettings<ListPrebuiltProcessorsRequest, ListPrebuiltProcessorsResponse>
      listPrebuiltProcessorsSettings;
  private final UnaryCallSettings<GetProcessorRequest, Processor> getProcessorSettings;
  private final UnaryCallSettings<CreateProcessorRequest, Operation> createProcessorSettings;
  private final OperationCallSettings<CreateProcessorRequest, Processor, OperationMetadata>
      createProcessorOperationSettings;
  private final UnaryCallSettings<UpdateProcessorRequest, Operation> updateProcessorSettings;
  private final OperationCallSettings<UpdateProcessorRequest, Processor, OperationMetadata>
      updateProcessorOperationSettings;
  private final UnaryCallSettings<DeleteProcessorRequest, Operation> deleteProcessorSettings;
  private final OperationCallSettings<DeleteProcessorRequest, Empty, OperationMetadata>
      deleteProcessorOperationSettings;

  private static final PagedListDescriptor<
          ListApplicationsRequest, ListApplicationsResponse, Application>
      LIST_APPLICATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListApplicationsRequest, ListApplicationsResponse, Application>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListApplicationsRequest injectToken(
                ListApplicationsRequest payload, String token) {
              return ListApplicationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListApplicationsRequest injectPageSize(
                ListApplicationsRequest payload, int pageSize) {
              return ListApplicationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListApplicationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListApplicationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Application> extractResources(ListApplicationsResponse payload) {
              return payload.getApplicationsList() == null
                  ? ImmutableList.<Application>of()
                  : payload.getApplicationsList();
            }
          };

  private static final PagedListDescriptor<ListInstancesRequest, ListInstancesResponse, Instance>
      LIST_INSTANCES_PAGE_STR_DESC =
          new PagedListDescriptor<ListInstancesRequest, ListInstancesResponse, Instance>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListInstancesRequest injectToken(ListInstancesRequest payload, String token) {
              return ListInstancesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListInstancesRequest injectPageSize(ListInstancesRequest payload, int pageSize) {
              return ListInstancesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListInstancesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListInstancesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Instance> extractResources(ListInstancesResponse payload) {
              return payload.getInstancesList() == null
                  ? ImmutableList.<Instance>of()
                  : payload.getInstancesList();
            }
          };

  private static final PagedListDescriptor<ListDraftsRequest, ListDraftsResponse, Draft>
      LIST_DRAFTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListDraftsRequest, ListDraftsResponse, Draft>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDraftsRequest injectToken(ListDraftsRequest payload, String token) {
              return ListDraftsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDraftsRequest injectPageSize(ListDraftsRequest payload, int pageSize) {
              return ListDraftsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDraftsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDraftsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Draft> extractResources(ListDraftsResponse payload) {
              return payload.getDraftsList() == null
                  ? ImmutableList.<Draft>of()
                  : payload.getDraftsList();
            }
          };

  private static final PagedListDescriptor<ListProcessorsRequest, ListProcessorsResponse, Processor>
      LIST_PROCESSORS_PAGE_STR_DESC =
          new PagedListDescriptor<ListProcessorsRequest, ListProcessorsResponse, Processor>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListProcessorsRequest injectToken(ListProcessorsRequest payload, String token) {
              return ListProcessorsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListProcessorsRequest injectPageSize(
                ListProcessorsRequest payload, int pageSize) {
              return ListProcessorsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListProcessorsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListProcessorsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Processor> extractResources(ListProcessorsResponse payload) {
              return payload.getProcessorsList() == null
                  ? ImmutableList.<Processor>of()
                  : payload.getProcessorsList();
            }
          };

  private static final PagedListResponseFactory<
          ListApplicationsRequest, ListApplicationsResponse, ListApplicationsPagedResponse>
      LIST_APPLICATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListApplicationsRequest, ListApplicationsResponse, ListApplicationsPagedResponse>() {
            @Override
            public ApiFuture<ListApplicationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListApplicationsRequest, ListApplicationsResponse> callable,
                ListApplicationsRequest request,
                ApiCallContext context,
                ApiFuture<ListApplicationsResponse> futureResponse) {
              PageContext<ListApplicationsRequest, ListApplicationsResponse, Application>
                  pageContext =
                      PageContext.create(
                          callable, LIST_APPLICATIONS_PAGE_STR_DESC, request, context);
              return ListApplicationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
      LIST_INSTANCES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>() {
            @Override
            public ApiFuture<ListInstancesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListInstancesRequest, ListInstancesResponse> callable,
                ListInstancesRequest request,
                ApiCallContext context,
                ApiFuture<ListInstancesResponse> futureResponse) {
              PageContext<ListInstancesRequest, ListInstancesResponse, Instance> pageContext =
                  PageContext.create(callable, LIST_INSTANCES_PAGE_STR_DESC, request, context);
              return ListInstancesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDraftsRequest, ListDraftsResponse, ListDraftsPagedResponse>
      LIST_DRAFTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDraftsRequest, ListDraftsResponse, ListDraftsPagedResponse>() {
            @Override
            public ApiFuture<ListDraftsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDraftsRequest, ListDraftsResponse> callable,
                ListDraftsRequest request,
                ApiCallContext context,
                ApiFuture<ListDraftsResponse> futureResponse) {
              PageContext<ListDraftsRequest, ListDraftsResponse, Draft> pageContext =
                  PageContext.create(callable, LIST_DRAFTS_PAGE_STR_DESC, request, context);
              return ListDraftsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListProcessorsRequest, ListProcessorsResponse, ListProcessorsPagedResponse>
      LIST_PROCESSORS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListProcessorsRequest, ListProcessorsResponse, ListProcessorsPagedResponse>() {
            @Override
            public ApiFuture<ListProcessorsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListProcessorsRequest, ListProcessorsResponse> callable,
                ListProcessorsRequest request,
                ApiCallContext context,
                ApiFuture<ListProcessorsResponse> futureResponse) {
              PageContext<ListProcessorsRequest, ListProcessorsResponse, Processor> pageContext =
                  PageContext.create(callable, LIST_PROCESSORS_PAGE_STR_DESC, request, context);
              return ListProcessorsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listApplications. */
  public PagedCallSettings<
          ListApplicationsRequest, ListApplicationsResponse, ListApplicationsPagedResponse>
      listApplicationsSettings() {
    return listApplicationsSettings;
  }

  /** Returns the object with the settings used for calls to getApplication. */
  public UnaryCallSettings<GetApplicationRequest, Application> getApplicationSettings() {
    return getApplicationSettings;
  }

  /** Returns the object with the settings used for calls to createApplication. */
  public UnaryCallSettings<CreateApplicationRequest, Operation> createApplicationSettings() {
    return createApplicationSettings;
  }

  /** Returns the object with the settings used for calls to createApplication. */
  public OperationCallSettings<CreateApplicationRequest, Application, OperationMetadata>
      createApplicationOperationSettings() {
    return createApplicationOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateApplication. */
  public UnaryCallSettings<UpdateApplicationRequest, Operation> updateApplicationSettings() {
    return updateApplicationSettings;
  }

  /** Returns the object with the settings used for calls to updateApplication. */
  public OperationCallSettings<UpdateApplicationRequest, Application, OperationMetadata>
      updateApplicationOperationSettings() {
    return updateApplicationOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteApplication. */
  public UnaryCallSettings<DeleteApplicationRequest, Operation> deleteApplicationSettings() {
    return deleteApplicationSettings;
  }

  /** Returns the object with the settings used for calls to deleteApplication. */
  public OperationCallSettings<DeleteApplicationRequest, Empty, OperationMetadata>
      deleteApplicationOperationSettings() {
    return deleteApplicationOperationSettings;
  }

  /** Returns the object with the settings used for calls to deployApplication. */
  public UnaryCallSettings<DeployApplicationRequest, Operation> deployApplicationSettings() {
    return deployApplicationSettings;
  }

  /** Returns the object with the settings used for calls to deployApplication. */
  public OperationCallSettings<
          DeployApplicationRequest, DeployApplicationResponse, OperationMetadata>
      deployApplicationOperationSettings() {
    return deployApplicationOperationSettings;
  }

  /** Returns the object with the settings used for calls to undeployApplication. */
  public UnaryCallSettings<UndeployApplicationRequest, Operation> undeployApplicationSettings() {
    return undeployApplicationSettings;
  }

  /** Returns the object with the settings used for calls to undeployApplication. */
  public OperationCallSettings<
          UndeployApplicationRequest, UndeployApplicationResponse, OperationMetadata>
      undeployApplicationOperationSettings() {
    return undeployApplicationOperationSettings;
  }

  /** Returns the object with the settings used for calls to addApplicationStreamInput. */
  public UnaryCallSettings<AddApplicationStreamInputRequest, Operation>
      addApplicationStreamInputSettings() {
    return addApplicationStreamInputSettings;
  }

  /** Returns the object with the settings used for calls to addApplicationStreamInput. */
  public OperationCallSettings<
          AddApplicationStreamInputRequest, AddApplicationStreamInputResponse, OperationMetadata>
      addApplicationStreamInputOperationSettings() {
    return addApplicationStreamInputOperationSettings;
  }

  /** Returns the object with the settings used for calls to removeApplicationStreamInput. */
  public UnaryCallSettings<RemoveApplicationStreamInputRequest, Operation>
      removeApplicationStreamInputSettings() {
    return removeApplicationStreamInputSettings;
  }

  /** Returns the object with the settings used for calls to removeApplicationStreamInput. */
  public OperationCallSettings<
          RemoveApplicationStreamInputRequest,
          RemoveApplicationStreamInputResponse,
          OperationMetadata>
      removeApplicationStreamInputOperationSettings() {
    return removeApplicationStreamInputOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateApplicationStreamInput. */
  public UnaryCallSettings<UpdateApplicationStreamInputRequest, Operation>
      updateApplicationStreamInputSettings() {
    return updateApplicationStreamInputSettings;
  }

  /** Returns the object with the settings used for calls to updateApplicationStreamInput. */
  public OperationCallSettings<
          UpdateApplicationStreamInputRequest,
          UpdateApplicationStreamInputResponse,
          OperationMetadata>
      updateApplicationStreamInputOperationSettings() {
    return updateApplicationStreamInputOperationSettings;
  }

  /** Returns the object with the settings used for calls to listInstances. */
  public PagedCallSettings<ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
      listInstancesSettings() {
    return listInstancesSettings;
  }

  /** Returns the object with the settings used for calls to getInstance. */
  public UnaryCallSettings<GetInstanceRequest, Instance> getInstanceSettings() {
    return getInstanceSettings;
  }

  /** Returns the object with the settings used for calls to createApplicationInstances. */
  public UnaryCallSettings<CreateApplicationInstancesRequest, Operation>
      createApplicationInstancesSettings() {
    return createApplicationInstancesSettings;
  }

  /** Returns the object with the settings used for calls to createApplicationInstances. */
  public OperationCallSettings<
          CreateApplicationInstancesRequest, CreateApplicationInstancesResponse, OperationMetadata>
      createApplicationInstancesOperationSettings() {
    return createApplicationInstancesOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteApplicationInstances. */
  public UnaryCallSettings<DeleteApplicationInstancesRequest, Operation>
      deleteApplicationInstancesSettings() {
    return deleteApplicationInstancesSettings;
  }

  /** Returns the object with the settings used for calls to deleteApplicationInstances. */
  public OperationCallSettings<DeleteApplicationInstancesRequest, Instance, OperationMetadata>
      deleteApplicationInstancesOperationSettings() {
    return deleteApplicationInstancesOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateApplicationInstances. */
  public UnaryCallSettings<UpdateApplicationInstancesRequest, Operation>
      updateApplicationInstancesSettings() {
    return updateApplicationInstancesSettings;
  }

  /** Returns the object with the settings used for calls to updateApplicationInstances. */
  public OperationCallSettings<
          UpdateApplicationInstancesRequest, UpdateApplicationInstancesResponse, OperationMetadata>
      updateApplicationInstancesOperationSettings() {
    return updateApplicationInstancesOperationSettings;
  }

  /** Returns the object with the settings used for calls to listDrafts. */
  public PagedCallSettings<ListDraftsRequest, ListDraftsResponse, ListDraftsPagedResponse>
      listDraftsSettings() {
    return listDraftsSettings;
  }

  /** Returns the object with the settings used for calls to getDraft. */
  public UnaryCallSettings<GetDraftRequest, Draft> getDraftSettings() {
    return getDraftSettings;
  }

  /** Returns the object with the settings used for calls to createDraft. */
  public UnaryCallSettings<CreateDraftRequest, Operation> createDraftSettings() {
    return createDraftSettings;
  }

  /** Returns the object with the settings used for calls to createDraft. */
  public OperationCallSettings<CreateDraftRequest, Draft, OperationMetadata>
      createDraftOperationSettings() {
    return createDraftOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateDraft. */
  public UnaryCallSettings<UpdateDraftRequest, Operation> updateDraftSettings() {
    return updateDraftSettings;
  }

  /** Returns the object with the settings used for calls to updateDraft. */
  public OperationCallSettings<UpdateDraftRequest, Draft, OperationMetadata>
      updateDraftOperationSettings() {
    return updateDraftOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteDraft. */
  public UnaryCallSettings<DeleteDraftRequest, Operation> deleteDraftSettings() {
    return deleteDraftSettings;
  }

  /** Returns the object with the settings used for calls to deleteDraft. */
  public OperationCallSettings<DeleteDraftRequest, Empty, OperationMetadata>
      deleteDraftOperationSettings() {
    return deleteDraftOperationSettings;
  }

  /** Returns the object with the settings used for calls to listProcessors. */
  public PagedCallSettings<
          ListProcessorsRequest, ListProcessorsResponse, ListProcessorsPagedResponse>
      listProcessorsSettings() {
    return listProcessorsSettings;
  }

  /** Returns the object with the settings used for calls to listPrebuiltProcessors. */
  public UnaryCallSettings<ListPrebuiltProcessorsRequest, ListPrebuiltProcessorsResponse>
      listPrebuiltProcessorsSettings() {
    return listPrebuiltProcessorsSettings;
  }

  /** Returns the object with the settings used for calls to getProcessor. */
  public UnaryCallSettings<GetProcessorRequest, Processor> getProcessorSettings() {
    return getProcessorSettings;
  }

  /** Returns the object with the settings used for calls to createProcessor. */
  public UnaryCallSettings<CreateProcessorRequest, Operation> createProcessorSettings() {
    return createProcessorSettings;
  }

  /** Returns the object with the settings used for calls to createProcessor. */
  public OperationCallSettings<CreateProcessorRequest, Processor, OperationMetadata>
      createProcessorOperationSettings() {
    return createProcessorOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateProcessor. */
  public UnaryCallSettings<UpdateProcessorRequest, Operation> updateProcessorSettings() {
    return updateProcessorSettings;
  }

  /** Returns the object with the settings used for calls to updateProcessor. */
  public OperationCallSettings<UpdateProcessorRequest, Processor, OperationMetadata>
      updateProcessorOperationSettings() {
    return updateProcessorOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteProcessor. */
  public UnaryCallSettings<DeleteProcessorRequest, Operation> deleteProcessorSettings() {
    return deleteProcessorSettings;
  }

  /** Returns the object with the settings used for calls to deleteProcessor. */
  public OperationCallSettings<DeleteProcessorRequest, Empty, OperationMetadata>
      deleteProcessorOperationSettings() {
    return deleteProcessorOperationSettings;
  }

  public AppPlatformStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcAppPlatformStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonAppPlatformStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "visionai";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "visionai.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "visionai.mtls.googleapis.com:443";
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
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(AppPlatformStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(AppPlatformStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AppPlatformStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected AppPlatformStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listApplicationsSettings = settingsBuilder.listApplicationsSettings().build();
    getApplicationSettings = settingsBuilder.getApplicationSettings().build();
    createApplicationSettings = settingsBuilder.createApplicationSettings().build();
    createApplicationOperationSettings =
        settingsBuilder.createApplicationOperationSettings().build();
    updateApplicationSettings = settingsBuilder.updateApplicationSettings().build();
    updateApplicationOperationSettings =
        settingsBuilder.updateApplicationOperationSettings().build();
    deleteApplicationSettings = settingsBuilder.deleteApplicationSettings().build();
    deleteApplicationOperationSettings =
        settingsBuilder.deleteApplicationOperationSettings().build();
    deployApplicationSettings = settingsBuilder.deployApplicationSettings().build();
    deployApplicationOperationSettings =
        settingsBuilder.deployApplicationOperationSettings().build();
    undeployApplicationSettings = settingsBuilder.undeployApplicationSettings().build();
    undeployApplicationOperationSettings =
        settingsBuilder.undeployApplicationOperationSettings().build();
    addApplicationStreamInputSettings = settingsBuilder.addApplicationStreamInputSettings().build();
    addApplicationStreamInputOperationSettings =
        settingsBuilder.addApplicationStreamInputOperationSettings().build();
    removeApplicationStreamInputSettings =
        settingsBuilder.removeApplicationStreamInputSettings().build();
    removeApplicationStreamInputOperationSettings =
        settingsBuilder.removeApplicationStreamInputOperationSettings().build();
    updateApplicationStreamInputSettings =
        settingsBuilder.updateApplicationStreamInputSettings().build();
    updateApplicationStreamInputOperationSettings =
        settingsBuilder.updateApplicationStreamInputOperationSettings().build();
    listInstancesSettings = settingsBuilder.listInstancesSettings().build();
    getInstanceSettings = settingsBuilder.getInstanceSettings().build();
    createApplicationInstancesSettings =
        settingsBuilder.createApplicationInstancesSettings().build();
    createApplicationInstancesOperationSettings =
        settingsBuilder.createApplicationInstancesOperationSettings().build();
    deleteApplicationInstancesSettings =
        settingsBuilder.deleteApplicationInstancesSettings().build();
    deleteApplicationInstancesOperationSettings =
        settingsBuilder.deleteApplicationInstancesOperationSettings().build();
    updateApplicationInstancesSettings =
        settingsBuilder.updateApplicationInstancesSettings().build();
    updateApplicationInstancesOperationSettings =
        settingsBuilder.updateApplicationInstancesOperationSettings().build();
    listDraftsSettings = settingsBuilder.listDraftsSettings().build();
    getDraftSettings = settingsBuilder.getDraftSettings().build();
    createDraftSettings = settingsBuilder.createDraftSettings().build();
    createDraftOperationSettings = settingsBuilder.createDraftOperationSettings().build();
    updateDraftSettings = settingsBuilder.updateDraftSettings().build();
    updateDraftOperationSettings = settingsBuilder.updateDraftOperationSettings().build();
    deleteDraftSettings = settingsBuilder.deleteDraftSettings().build();
    deleteDraftOperationSettings = settingsBuilder.deleteDraftOperationSettings().build();
    listProcessorsSettings = settingsBuilder.listProcessorsSettings().build();
    listPrebuiltProcessorsSettings = settingsBuilder.listPrebuiltProcessorsSettings().build();
    getProcessorSettings = settingsBuilder.getProcessorSettings().build();
    createProcessorSettings = settingsBuilder.createProcessorSettings().build();
    createProcessorOperationSettings = settingsBuilder.createProcessorOperationSettings().build();
    updateProcessorSettings = settingsBuilder.updateProcessorSettings().build();
    updateProcessorOperationSettings = settingsBuilder.updateProcessorOperationSettings().build();
    deleteProcessorSettings = settingsBuilder.deleteProcessorSettings().build();
    deleteProcessorOperationSettings = settingsBuilder.deleteProcessorOperationSettings().build();
  }

  /** Builder for AppPlatformStubSettings. */
  public static class Builder extends StubSettings.Builder<AppPlatformStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListApplicationsRequest, ListApplicationsResponse, ListApplicationsPagedResponse>
        listApplicationsSettings;
    private final UnaryCallSettings.Builder<GetApplicationRequest, Application>
        getApplicationSettings;
    private final UnaryCallSettings.Builder<CreateApplicationRequest, Operation>
        createApplicationSettings;
    private final OperationCallSettings.Builder<
            CreateApplicationRequest, Application, OperationMetadata>
        createApplicationOperationSettings;
    private final UnaryCallSettings.Builder<UpdateApplicationRequest, Operation>
        updateApplicationSettings;
    private final OperationCallSettings.Builder<
            UpdateApplicationRequest, Application, OperationMetadata>
        updateApplicationOperationSettings;
    private final UnaryCallSettings.Builder<DeleteApplicationRequest, Operation>
        deleteApplicationSettings;
    private final OperationCallSettings.Builder<DeleteApplicationRequest, Empty, OperationMetadata>
        deleteApplicationOperationSettings;
    private final UnaryCallSettings.Builder<DeployApplicationRequest, Operation>
        deployApplicationSettings;
    private final OperationCallSettings.Builder<
            DeployApplicationRequest, DeployApplicationResponse, OperationMetadata>
        deployApplicationOperationSettings;
    private final UnaryCallSettings.Builder<UndeployApplicationRequest, Operation>
        undeployApplicationSettings;
    private final OperationCallSettings.Builder<
            UndeployApplicationRequest, UndeployApplicationResponse, OperationMetadata>
        undeployApplicationOperationSettings;
    private final UnaryCallSettings.Builder<AddApplicationStreamInputRequest, Operation>
        addApplicationStreamInputSettings;
    private final OperationCallSettings.Builder<
            AddApplicationStreamInputRequest, AddApplicationStreamInputResponse, OperationMetadata>
        addApplicationStreamInputOperationSettings;
    private final UnaryCallSettings.Builder<RemoveApplicationStreamInputRequest, Operation>
        removeApplicationStreamInputSettings;
    private final OperationCallSettings.Builder<
            RemoveApplicationStreamInputRequest,
            RemoveApplicationStreamInputResponse,
            OperationMetadata>
        removeApplicationStreamInputOperationSettings;
    private final UnaryCallSettings.Builder<UpdateApplicationStreamInputRequest, Operation>
        updateApplicationStreamInputSettings;
    private final OperationCallSettings.Builder<
            UpdateApplicationStreamInputRequest,
            UpdateApplicationStreamInputResponse,
            OperationMetadata>
        updateApplicationStreamInputOperationSettings;
    private final PagedCallSettings.Builder<
            ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
        listInstancesSettings;
    private final UnaryCallSettings.Builder<GetInstanceRequest, Instance> getInstanceSettings;
    private final UnaryCallSettings.Builder<CreateApplicationInstancesRequest, Operation>
        createApplicationInstancesSettings;
    private final OperationCallSettings.Builder<
            CreateApplicationInstancesRequest,
            CreateApplicationInstancesResponse,
            OperationMetadata>
        createApplicationInstancesOperationSettings;
    private final UnaryCallSettings.Builder<DeleteApplicationInstancesRequest, Operation>
        deleteApplicationInstancesSettings;
    private final OperationCallSettings.Builder<
            DeleteApplicationInstancesRequest, Instance, OperationMetadata>
        deleteApplicationInstancesOperationSettings;
    private final UnaryCallSettings.Builder<UpdateApplicationInstancesRequest, Operation>
        updateApplicationInstancesSettings;
    private final OperationCallSettings.Builder<
            UpdateApplicationInstancesRequest,
            UpdateApplicationInstancesResponse,
            OperationMetadata>
        updateApplicationInstancesOperationSettings;
    private final PagedCallSettings.Builder<
            ListDraftsRequest, ListDraftsResponse, ListDraftsPagedResponse>
        listDraftsSettings;
    private final UnaryCallSettings.Builder<GetDraftRequest, Draft> getDraftSettings;
    private final UnaryCallSettings.Builder<CreateDraftRequest, Operation> createDraftSettings;
    private final OperationCallSettings.Builder<CreateDraftRequest, Draft, OperationMetadata>
        createDraftOperationSettings;
    private final UnaryCallSettings.Builder<UpdateDraftRequest, Operation> updateDraftSettings;
    private final OperationCallSettings.Builder<UpdateDraftRequest, Draft, OperationMetadata>
        updateDraftOperationSettings;
    private final UnaryCallSettings.Builder<DeleteDraftRequest, Operation> deleteDraftSettings;
    private final OperationCallSettings.Builder<DeleteDraftRequest, Empty, OperationMetadata>
        deleteDraftOperationSettings;
    private final PagedCallSettings.Builder<
            ListProcessorsRequest, ListProcessorsResponse, ListProcessorsPagedResponse>
        listProcessorsSettings;
    private final UnaryCallSettings.Builder<
            ListPrebuiltProcessorsRequest, ListPrebuiltProcessorsResponse>
        listPrebuiltProcessorsSettings;
    private final UnaryCallSettings.Builder<GetProcessorRequest, Processor> getProcessorSettings;
    private final UnaryCallSettings.Builder<CreateProcessorRequest, Operation>
        createProcessorSettings;
    private final OperationCallSettings.Builder<
            CreateProcessorRequest, Processor, OperationMetadata>
        createProcessorOperationSettings;
    private final UnaryCallSettings.Builder<UpdateProcessorRequest, Operation>
        updateProcessorSettings;
    private final OperationCallSettings.Builder<
            UpdateProcessorRequest, Processor, OperationMetadata>
        updateProcessorOperationSettings;
    private final UnaryCallSettings.Builder<DeleteProcessorRequest, Operation>
        deleteProcessorSettings;
    private final OperationCallSettings.Builder<DeleteProcessorRequest, Empty, OperationMetadata>
        deleteProcessorOperationSettings;
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

      listApplicationsSettings = PagedCallSettings.newBuilder(LIST_APPLICATIONS_PAGE_STR_FACT);
      getApplicationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createApplicationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createApplicationOperationSettings = OperationCallSettings.newBuilder();
      updateApplicationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateApplicationOperationSettings = OperationCallSettings.newBuilder();
      deleteApplicationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteApplicationOperationSettings = OperationCallSettings.newBuilder();
      deployApplicationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deployApplicationOperationSettings = OperationCallSettings.newBuilder();
      undeployApplicationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      undeployApplicationOperationSettings = OperationCallSettings.newBuilder();
      addApplicationStreamInputSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      addApplicationStreamInputOperationSettings = OperationCallSettings.newBuilder();
      removeApplicationStreamInputSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      removeApplicationStreamInputOperationSettings = OperationCallSettings.newBuilder();
      updateApplicationStreamInputSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateApplicationStreamInputOperationSettings = OperationCallSettings.newBuilder();
      listInstancesSettings = PagedCallSettings.newBuilder(LIST_INSTANCES_PAGE_STR_FACT);
      getInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createApplicationInstancesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createApplicationInstancesOperationSettings = OperationCallSettings.newBuilder();
      deleteApplicationInstancesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteApplicationInstancesOperationSettings = OperationCallSettings.newBuilder();
      updateApplicationInstancesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateApplicationInstancesOperationSettings = OperationCallSettings.newBuilder();
      listDraftsSettings = PagedCallSettings.newBuilder(LIST_DRAFTS_PAGE_STR_FACT);
      getDraftSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDraftSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDraftOperationSettings = OperationCallSettings.newBuilder();
      updateDraftSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDraftOperationSettings = OperationCallSettings.newBuilder();
      deleteDraftSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDraftOperationSettings = OperationCallSettings.newBuilder();
      listProcessorsSettings = PagedCallSettings.newBuilder(LIST_PROCESSORS_PAGE_STR_FACT);
      listPrebuiltProcessorsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getProcessorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createProcessorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createProcessorOperationSettings = OperationCallSettings.newBuilder();
      updateProcessorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateProcessorOperationSettings = OperationCallSettings.newBuilder();
      deleteProcessorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteProcessorOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listApplicationsSettings,
              getApplicationSettings,
              createApplicationSettings,
              updateApplicationSettings,
              deleteApplicationSettings,
              deployApplicationSettings,
              undeployApplicationSettings,
              addApplicationStreamInputSettings,
              removeApplicationStreamInputSettings,
              updateApplicationStreamInputSettings,
              listInstancesSettings,
              getInstanceSettings,
              createApplicationInstancesSettings,
              deleteApplicationInstancesSettings,
              updateApplicationInstancesSettings,
              listDraftsSettings,
              getDraftSettings,
              createDraftSettings,
              updateDraftSettings,
              deleteDraftSettings,
              listProcessorsSettings,
              listPrebuiltProcessorsSettings,
              getProcessorSettings,
              createProcessorSettings,
              updateProcessorSettings,
              deleteProcessorSettings);
      initDefaults(this);
    }

    protected Builder(AppPlatformStubSettings settings) {
      super(settings);

      listApplicationsSettings = settings.listApplicationsSettings.toBuilder();
      getApplicationSettings = settings.getApplicationSettings.toBuilder();
      createApplicationSettings = settings.createApplicationSettings.toBuilder();
      createApplicationOperationSettings = settings.createApplicationOperationSettings.toBuilder();
      updateApplicationSettings = settings.updateApplicationSettings.toBuilder();
      updateApplicationOperationSettings = settings.updateApplicationOperationSettings.toBuilder();
      deleteApplicationSettings = settings.deleteApplicationSettings.toBuilder();
      deleteApplicationOperationSettings = settings.deleteApplicationOperationSettings.toBuilder();
      deployApplicationSettings = settings.deployApplicationSettings.toBuilder();
      deployApplicationOperationSettings = settings.deployApplicationOperationSettings.toBuilder();
      undeployApplicationSettings = settings.undeployApplicationSettings.toBuilder();
      undeployApplicationOperationSettings =
          settings.undeployApplicationOperationSettings.toBuilder();
      addApplicationStreamInputSettings = settings.addApplicationStreamInputSettings.toBuilder();
      addApplicationStreamInputOperationSettings =
          settings.addApplicationStreamInputOperationSettings.toBuilder();
      removeApplicationStreamInputSettings =
          settings.removeApplicationStreamInputSettings.toBuilder();
      removeApplicationStreamInputOperationSettings =
          settings.removeApplicationStreamInputOperationSettings.toBuilder();
      updateApplicationStreamInputSettings =
          settings.updateApplicationStreamInputSettings.toBuilder();
      updateApplicationStreamInputOperationSettings =
          settings.updateApplicationStreamInputOperationSettings.toBuilder();
      listInstancesSettings = settings.listInstancesSettings.toBuilder();
      getInstanceSettings = settings.getInstanceSettings.toBuilder();
      createApplicationInstancesSettings = settings.createApplicationInstancesSettings.toBuilder();
      createApplicationInstancesOperationSettings =
          settings.createApplicationInstancesOperationSettings.toBuilder();
      deleteApplicationInstancesSettings = settings.deleteApplicationInstancesSettings.toBuilder();
      deleteApplicationInstancesOperationSettings =
          settings.deleteApplicationInstancesOperationSettings.toBuilder();
      updateApplicationInstancesSettings = settings.updateApplicationInstancesSettings.toBuilder();
      updateApplicationInstancesOperationSettings =
          settings.updateApplicationInstancesOperationSettings.toBuilder();
      listDraftsSettings = settings.listDraftsSettings.toBuilder();
      getDraftSettings = settings.getDraftSettings.toBuilder();
      createDraftSettings = settings.createDraftSettings.toBuilder();
      createDraftOperationSettings = settings.createDraftOperationSettings.toBuilder();
      updateDraftSettings = settings.updateDraftSettings.toBuilder();
      updateDraftOperationSettings = settings.updateDraftOperationSettings.toBuilder();
      deleteDraftSettings = settings.deleteDraftSettings.toBuilder();
      deleteDraftOperationSettings = settings.deleteDraftOperationSettings.toBuilder();
      listProcessorsSettings = settings.listProcessorsSettings.toBuilder();
      listPrebuiltProcessorsSettings = settings.listPrebuiltProcessorsSettings.toBuilder();
      getProcessorSettings = settings.getProcessorSettings.toBuilder();
      createProcessorSettings = settings.createProcessorSettings.toBuilder();
      createProcessorOperationSettings = settings.createProcessorOperationSettings.toBuilder();
      updateProcessorSettings = settings.updateProcessorSettings.toBuilder();
      updateProcessorOperationSettings = settings.updateProcessorOperationSettings.toBuilder();
      deleteProcessorSettings = settings.deleteProcessorSettings.toBuilder();
      deleteProcessorOperationSettings = settings.deleteProcessorOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listApplicationsSettings,
              getApplicationSettings,
              createApplicationSettings,
              updateApplicationSettings,
              deleteApplicationSettings,
              deployApplicationSettings,
              undeployApplicationSettings,
              addApplicationStreamInputSettings,
              removeApplicationStreamInputSettings,
              updateApplicationStreamInputSettings,
              listInstancesSettings,
              getInstanceSettings,
              createApplicationInstancesSettings,
              deleteApplicationInstancesSettings,
              updateApplicationInstancesSettings,
              listDraftsSettings,
              getDraftSettings,
              createDraftSettings,
              updateDraftSettings,
              deleteDraftSettings,
              listProcessorsSettings,
              listPrebuiltProcessorsSettings,
              getProcessorSettings,
              createProcessorSettings,
              updateProcessorSettings,
              deleteProcessorSettings);
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
          .listApplicationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getApplicationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createApplicationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateApplicationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteApplicationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deployApplicationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .undeployApplicationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .addApplicationStreamInputSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .removeApplicationStreamInputSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateApplicationStreamInputSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listInstancesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createApplicationInstancesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteApplicationInstancesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateApplicationInstancesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listDraftsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getDraftSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createDraftSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateDraftSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteDraftSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listProcessorsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listPrebuiltProcessorsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getProcessorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createProcessorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateProcessorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteProcessorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createApplicationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateApplicationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Application.class))
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
          .updateApplicationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateApplicationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Application.class))
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
          .deleteApplicationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteApplicationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
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
          .deployApplicationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeployApplicationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  DeployApplicationResponse.class))
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
          .undeployApplicationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UndeployApplicationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  UndeployApplicationResponse.class))
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
          .addApplicationStreamInputOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<AddApplicationStreamInputRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  AddApplicationStreamInputResponse.class))
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
          .removeApplicationStreamInputOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RemoveApplicationStreamInputRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  RemoveApplicationStreamInputResponse.class))
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
          .updateApplicationStreamInputOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateApplicationStreamInputRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  UpdateApplicationStreamInputResponse.class))
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
          .createApplicationInstancesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateApplicationInstancesRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  CreateApplicationInstancesResponse.class))
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
          .deleteApplicationInstancesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteApplicationInstancesRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Instance.class))
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
          .updateApplicationInstancesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateApplicationInstancesRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  UpdateApplicationInstancesResponse.class))
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
          .createDraftOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CreateDraftRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Draft.class))
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
          .updateDraftOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<UpdateDraftRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Draft.class))
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
          .deleteDraftOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteDraftRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
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
          .createProcessorOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateProcessorRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Processor.class))
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
          .updateProcessorOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateProcessorRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Processor.class))
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
          .deleteProcessorOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteProcessorRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
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

    /** Returns the builder for the settings used for calls to listApplications. */
    public PagedCallSettings.Builder<
            ListApplicationsRequest, ListApplicationsResponse, ListApplicationsPagedResponse>
        listApplicationsSettings() {
      return listApplicationsSettings;
    }

    /** Returns the builder for the settings used for calls to getApplication. */
    public UnaryCallSettings.Builder<GetApplicationRequest, Application> getApplicationSettings() {
      return getApplicationSettings;
    }

    /** Returns the builder for the settings used for calls to createApplication. */
    public UnaryCallSettings.Builder<CreateApplicationRequest, Operation>
        createApplicationSettings() {
      return createApplicationSettings;
    }

    /** Returns the builder for the settings used for calls to createApplication. */
    public OperationCallSettings.Builder<CreateApplicationRequest, Application, OperationMetadata>
        createApplicationOperationSettings() {
      return createApplicationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateApplication. */
    public UnaryCallSettings.Builder<UpdateApplicationRequest, Operation>
        updateApplicationSettings() {
      return updateApplicationSettings;
    }

    /** Returns the builder for the settings used for calls to updateApplication. */
    public OperationCallSettings.Builder<UpdateApplicationRequest, Application, OperationMetadata>
        updateApplicationOperationSettings() {
      return updateApplicationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteApplication. */
    public UnaryCallSettings.Builder<DeleteApplicationRequest, Operation>
        deleteApplicationSettings() {
      return deleteApplicationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteApplication. */
    public OperationCallSettings.Builder<DeleteApplicationRequest, Empty, OperationMetadata>
        deleteApplicationOperationSettings() {
      return deleteApplicationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deployApplication. */
    public UnaryCallSettings.Builder<DeployApplicationRequest, Operation>
        deployApplicationSettings() {
      return deployApplicationSettings;
    }

    /** Returns the builder for the settings used for calls to deployApplication. */
    public OperationCallSettings.Builder<
            DeployApplicationRequest, DeployApplicationResponse, OperationMetadata>
        deployApplicationOperationSettings() {
      return deployApplicationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to undeployApplication. */
    public UnaryCallSettings.Builder<UndeployApplicationRequest, Operation>
        undeployApplicationSettings() {
      return undeployApplicationSettings;
    }

    /** Returns the builder for the settings used for calls to undeployApplication. */
    public OperationCallSettings.Builder<
            UndeployApplicationRequest, UndeployApplicationResponse, OperationMetadata>
        undeployApplicationOperationSettings() {
      return undeployApplicationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to addApplicationStreamInput. */
    public UnaryCallSettings.Builder<AddApplicationStreamInputRequest, Operation>
        addApplicationStreamInputSettings() {
      return addApplicationStreamInputSettings;
    }

    /** Returns the builder for the settings used for calls to addApplicationStreamInput. */
    public OperationCallSettings.Builder<
            AddApplicationStreamInputRequest, AddApplicationStreamInputResponse, OperationMetadata>
        addApplicationStreamInputOperationSettings() {
      return addApplicationStreamInputOperationSettings;
    }

    /** Returns the builder for the settings used for calls to removeApplicationStreamInput. */
    public UnaryCallSettings.Builder<RemoveApplicationStreamInputRequest, Operation>
        removeApplicationStreamInputSettings() {
      return removeApplicationStreamInputSettings;
    }

    /** Returns the builder for the settings used for calls to removeApplicationStreamInput. */
    public OperationCallSettings.Builder<
            RemoveApplicationStreamInputRequest,
            RemoveApplicationStreamInputResponse,
            OperationMetadata>
        removeApplicationStreamInputOperationSettings() {
      return removeApplicationStreamInputOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateApplicationStreamInput. */
    public UnaryCallSettings.Builder<UpdateApplicationStreamInputRequest, Operation>
        updateApplicationStreamInputSettings() {
      return updateApplicationStreamInputSettings;
    }

    /** Returns the builder for the settings used for calls to updateApplicationStreamInput. */
    public OperationCallSettings.Builder<
            UpdateApplicationStreamInputRequest,
            UpdateApplicationStreamInputResponse,
            OperationMetadata>
        updateApplicationStreamInputOperationSettings() {
      return updateApplicationStreamInputOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listInstances. */
    public PagedCallSettings.Builder<
            ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
        listInstancesSettings() {
      return listInstancesSettings;
    }

    /** Returns the builder for the settings used for calls to getInstance. */
    public UnaryCallSettings.Builder<GetInstanceRequest, Instance> getInstanceSettings() {
      return getInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to createApplicationInstances. */
    public UnaryCallSettings.Builder<CreateApplicationInstancesRequest, Operation>
        createApplicationInstancesSettings() {
      return createApplicationInstancesSettings;
    }

    /** Returns the builder for the settings used for calls to createApplicationInstances. */
    public OperationCallSettings.Builder<
            CreateApplicationInstancesRequest,
            CreateApplicationInstancesResponse,
            OperationMetadata>
        createApplicationInstancesOperationSettings() {
      return createApplicationInstancesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteApplicationInstances. */
    public UnaryCallSettings.Builder<DeleteApplicationInstancesRequest, Operation>
        deleteApplicationInstancesSettings() {
      return deleteApplicationInstancesSettings;
    }

    /** Returns the builder for the settings used for calls to deleteApplicationInstances. */
    public OperationCallSettings.Builder<
            DeleteApplicationInstancesRequest, Instance, OperationMetadata>
        deleteApplicationInstancesOperationSettings() {
      return deleteApplicationInstancesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateApplicationInstances. */
    public UnaryCallSettings.Builder<UpdateApplicationInstancesRequest, Operation>
        updateApplicationInstancesSettings() {
      return updateApplicationInstancesSettings;
    }

    /** Returns the builder for the settings used for calls to updateApplicationInstances. */
    public OperationCallSettings.Builder<
            UpdateApplicationInstancesRequest,
            UpdateApplicationInstancesResponse,
            OperationMetadata>
        updateApplicationInstancesOperationSettings() {
      return updateApplicationInstancesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listDrafts. */
    public PagedCallSettings.Builder<ListDraftsRequest, ListDraftsResponse, ListDraftsPagedResponse>
        listDraftsSettings() {
      return listDraftsSettings;
    }

    /** Returns the builder for the settings used for calls to getDraft. */
    public UnaryCallSettings.Builder<GetDraftRequest, Draft> getDraftSettings() {
      return getDraftSettings;
    }

    /** Returns the builder for the settings used for calls to createDraft. */
    public UnaryCallSettings.Builder<CreateDraftRequest, Operation> createDraftSettings() {
      return createDraftSettings;
    }

    /** Returns the builder for the settings used for calls to createDraft. */
    public OperationCallSettings.Builder<CreateDraftRequest, Draft, OperationMetadata>
        createDraftOperationSettings() {
      return createDraftOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateDraft. */
    public UnaryCallSettings.Builder<UpdateDraftRequest, Operation> updateDraftSettings() {
      return updateDraftSettings;
    }

    /** Returns the builder for the settings used for calls to updateDraft. */
    public OperationCallSettings.Builder<UpdateDraftRequest, Draft, OperationMetadata>
        updateDraftOperationSettings() {
      return updateDraftOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDraft. */
    public UnaryCallSettings.Builder<DeleteDraftRequest, Operation> deleteDraftSettings() {
      return deleteDraftSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDraft. */
    public OperationCallSettings.Builder<DeleteDraftRequest, Empty, OperationMetadata>
        deleteDraftOperationSettings() {
      return deleteDraftOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listProcessors. */
    public PagedCallSettings.Builder<
            ListProcessorsRequest, ListProcessorsResponse, ListProcessorsPagedResponse>
        listProcessorsSettings() {
      return listProcessorsSettings;
    }

    /** Returns the builder for the settings used for calls to listPrebuiltProcessors. */
    public UnaryCallSettings.Builder<ListPrebuiltProcessorsRequest, ListPrebuiltProcessorsResponse>
        listPrebuiltProcessorsSettings() {
      return listPrebuiltProcessorsSettings;
    }

    /** Returns the builder for the settings used for calls to getProcessor. */
    public UnaryCallSettings.Builder<GetProcessorRequest, Processor> getProcessorSettings() {
      return getProcessorSettings;
    }

    /** Returns the builder for the settings used for calls to createProcessor. */
    public UnaryCallSettings.Builder<CreateProcessorRequest, Operation> createProcessorSettings() {
      return createProcessorSettings;
    }

    /** Returns the builder for the settings used for calls to createProcessor. */
    public OperationCallSettings.Builder<CreateProcessorRequest, Processor, OperationMetadata>
        createProcessorOperationSettings() {
      return createProcessorOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateProcessor. */
    public UnaryCallSettings.Builder<UpdateProcessorRequest, Operation> updateProcessorSettings() {
      return updateProcessorSettings;
    }

    /** Returns the builder for the settings used for calls to updateProcessor. */
    public OperationCallSettings.Builder<UpdateProcessorRequest, Processor, OperationMetadata>
        updateProcessorOperationSettings() {
      return updateProcessorOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteProcessor. */
    public UnaryCallSettings.Builder<DeleteProcessorRequest, Operation> deleteProcessorSettings() {
      return deleteProcessorSettings;
    }

    /** Returns the builder for the settings used for calls to deleteProcessor. */
    public OperationCallSettings.Builder<DeleteProcessorRequest, Empty, OperationMetadata>
        deleteProcessorOperationSettings() {
      return deleteProcessorOperationSettings;
    }

    @Override
    public AppPlatformStubSettings build() throws IOException {
      return new AppPlatformStubSettings(this);
    }
  }
}
