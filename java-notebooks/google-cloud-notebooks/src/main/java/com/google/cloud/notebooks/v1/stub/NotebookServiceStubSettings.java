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

package com.google.cloud.notebooks.v1.stub;

import static com.google.cloud.notebooks.v1.NotebookServiceClient.ListEnvironmentsPagedResponse;
import static com.google.cloud.notebooks.v1.NotebookServiceClient.ListExecutionsPagedResponse;
import static com.google.cloud.notebooks.v1.NotebookServiceClient.ListInstancesPagedResponse;
import static com.google.cloud.notebooks.v1.NotebookServiceClient.ListSchedulesPagedResponse;

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
import com.google.cloud.notebooks.v1.CreateEnvironmentRequest;
import com.google.cloud.notebooks.v1.CreateExecutionRequest;
import com.google.cloud.notebooks.v1.CreateInstanceRequest;
import com.google.cloud.notebooks.v1.CreateScheduleRequest;
import com.google.cloud.notebooks.v1.DeleteEnvironmentRequest;
import com.google.cloud.notebooks.v1.DeleteExecutionRequest;
import com.google.cloud.notebooks.v1.DeleteInstanceRequest;
import com.google.cloud.notebooks.v1.DeleteScheduleRequest;
import com.google.cloud.notebooks.v1.Environment;
import com.google.cloud.notebooks.v1.Execution;
import com.google.cloud.notebooks.v1.GetEnvironmentRequest;
import com.google.cloud.notebooks.v1.GetExecutionRequest;
import com.google.cloud.notebooks.v1.GetInstanceHealthRequest;
import com.google.cloud.notebooks.v1.GetInstanceHealthResponse;
import com.google.cloud.notebooks.v1.GetInstanceRequest;
import com.google.cloud.notebooks.v1.GetScheduleRequest;
import com.google.cloud.notebooks.v1.Instance;
import com.google.cloud.notebooks.v1.IsInstanceUpgradeableRequest;
import com.google.cloud.notebooks.v1.IsInstanceUpgradeableResponse;
import com.google.cloud.notebooks.v1.ListEnvironmentsRequest;
import com.google.cloud.notebooks.v1.ListEnvironmentsResponse;
import com.google.cloud.notebooks.v1.ListExecutionsRequest;
import com.google.cloud.notebooks.v1.ListExecutionsResponse;
import com.google.cloud.notebooks.v1.ListInstancesRequest;
import com.google.cloud.notebooks.v1.ListInstancesResponse;
import com.google.cloud.notebooks.v1.ListSchedulesRequest;
import com.google.cloud.notebooks.v1.ListSchedulesResponse;
import com.google.cloud.notebooks.v1.OperationMetadata;
import com.google.cloud.notebooks.v1.RegisterInstanceRequest;
import com.google.cloud.notebooks.v1.ReportInstanceInfoRequest;
import com.google.cloud.notebooks.v1.ResetInstanceRequest;
import com.google.cloud.notebooks.v1.RollbackInstanceRequest;
import com.google.cloud.notebooks.v1.Schedule;
import com.google.cloud.notebooks.v1.SetInstanceAcceleratorRequest;
import com.google.cloud.notebooks.v1.SetInstanceLabelsRequest;
import com.google.cloud.notebooks.v1.SetInstanceMachineTypeRequest;
import com.google.cloud.notebooks.v1.StartInstanceRequest;
import com.google.cloud.notebooks.v1.StopInstanceRequest;
import com.google.cloud.notebooks.v1.TriggerScheduleRequest;
import com.google.cloud.notebooks.v1.UpdateInstanceConfigRequest;
import com.google.cloud.notebooks.v1.UpdateInstanceMetadataItemsRequest;
import com.google.cloud.notebooks.v1.UpdateInstanceMetadataItemsResponse;
import com.google.cloud.notebooks.v1.UpdateShieldedInstanceConfigRequest;
import com.google.cloud.notebooks.v1.UpgradeInstanceInternalRequest;
import com.google.cloud.notebooks.v1.UpgradeInstanceRequest;
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
 * Settings class to configure an instance of {@link NotebookServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (notebooks.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getInstance to 30 seconds:
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
 *     .getInstanceSettings()
 *     .setRetrySettings(
 *         notebookServiceSettingsBuilder.getInstanceSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * NotebookServiceStubSettings notebookServiceSettings = notebookServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class NotebookServiceStubSettings extends StubSettings<NotebookServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
      listInstancesSettings;
  private final UnaryCallSettings<GetInstanceRequest, Instance> getInstanceSettings;
  private final UnaryCallSettings<CreateInstanceRequest, Operation> createInstanceSettings;
  private final OperationCallSettings<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationSettings;
  private final UnaryCallSettings<RegisterInstanceRequest, Operation> registerInstanceSettings;
  private final OperationCallSettings<RegisterInstanceRequest, Instance, OperationMetadata>
      registerInstanceOperationSettings;
  private final UnaryCallSettings<SetInstanceAcceleratorRequest, Operation>
      setInstanceAcceleratorSettings;
  private final OperationCallSettings<SetInstanceAcceleratorRequest, Instance, OperationMetadata>
      setInstanceAcceleratorOperationSettings;
  private final UnaryCallSettings<SetInstanceMachineTypeRequest, Operation>
      setInstanceMachineTypeSettings;
  private final OperationCallSettings<SetInstanceMachineTypeRequest, Instance, OperationMetadata>
      setInstanceMachineTypeOperationSettings;
  private final UnaryCallSettings<UpdateInstanceConfigRequest, Operation>
      updateInstanceConfigSettings;
  private final OperationCallSettings<UpdateInstanceConfigRequest, Instance, OperationMetadata>
      updateInstanceConfigOperationSettings;
  private final UnaryCallSettings<UpdateShieldedInstanceConfigRequest, Operation>
      updateShieldedInstanceConfigSettings;
  private final OperationCallSettings<
          UpdateShieldedInstanceConfigRequest, Instance, OperationMetadata>
      updateShieldedInstanceConfigOperationSettings;
  private final UnaryCallSettings<SetInstanceLabelsRequest, Operation> setInstanceLabelsSettings;
  private final OperationCallSettings<SetInstanceLabelsRequest, Instance, OperationMetadata>
      setInstanceLabelsOperationSettings;
  private final UnaryCallSettings<
          UpdateInstanceMetadataItemsRequest, UpdateInstanceMetadataItemsResponse>
      updateInstanceMetadataItemsSettings;
  private final UnaryCallSettings<DeleteInstanceRequest, Operation> deleteInstanceSettings;
  private final OperationCallSettings<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationSettings;
  private final UnaryCallSettings<StartInstanceRequest, Operation> startInstanceSettings;
  private final OperationCallSettings<StartInstanceRequest, Instance, OperationMetadata>
      startInstanceOperationSettings;
  private final UnaryCallSettings<StopInstanceRequest, Operation> stopInstanceSettings;
  private final OperationCallSettings<StopInstanceRequest, Instance, OperationMetadata>
      stopInstanceOperationSettings;
  private final UnaryCallSettings<ResetInstanceRequest, Operation> resetInstanceSettings;
  private final OperationCallSettings<ResetInstanceRequest, Instance, OperationMetadata>
      resetInstanceOperationSettings;
  private final UnaryCallSettings<ReportInstanceInfoRequest, Operation> reportInstanceInfoSettings;
  private final OperationCallSettings<ReportInstanceInfoRequest, Instance, OperationMetadata>
      reportInstanceInfoOperationSettings;
  private final UnaryCallSettings<IsInstanceUpgradeableRequest, IsInstanceUpgradeableResponse>
      isInstanceUpgradeableSettings;
  private final UnaryCallSettings<GetInstanceHealthRequest, GetInstanceHealthResponse>
      getInstanceHealthSettings;
  private final UnaryCallSettings<UpgradeInstanceRequest, Operation> upgradeInstanceSettings;
  private final OperationCallSettings<UpgradeInstanceRequest, Instance, OperationMetadata>
      upgradeInstanceOperationSettings;
  private final UnaryCallSettings<RollbackInstanceRequest, Operation> rollbackInstanceSettings;
  private final OperationCallSettings<RollbackInstanceRequest, Instance, OperationMetadata>
      rollbackInstanceOperationSettings;
  private final UnaryCallSettings<UpgradeInstanceInternalRequest, Operation>
      upgradeInstanceInternalSettings;
  private final OperationCallSettings<UpgradeInstanceInternalRequest, Instance, OperationMetadata>
      upgradeInstanceInternalOperationSettings;
  private final PagedCallSettings<
          ListEnvironmentsRequest, ListEnvironmentsResponse, ListEnvironmentsPagedResponse>
      listEnvironmentsSettings;
  private final UnaryCallSettings<GetEnvironmentRequest, Environment> getEnvironmentSettings;
  private final UnaryCallSettings<CreateEnvironmentRequest, Operation> createEnvironmentSettings;
  private final OperationCallSettings<CreateEnvironmentRequest, Environment, OperationMetadata>
      createEnvironmentOperationSettings;
  private final UnaryCallSettings<DeleteEnvironmentRequest, Operation> deleteEnvironmentSettings;
  private final OperationCallSettings<DeleteEnvironmentRequest, Empty, OperationMetadata>
      deleteEnvironmentOperationSettings;
  private final PagedCallSettings<
          ListSchedulesRequest, ListSchedulesResponse, ListSchedulesPagedResponse>
      listSchedulesSettings;
  private final UnaryCallSettings<GetScheduleRequest, Schedule> getScheduleSettings;
  private final UnaryCallSettings<DeleteScheduleRequest, Operation> deleteScheduleSettings;
  private final OperationCallSettings<DeleteScheduleRequest, Empty, OperationMetadata>
      deleteScheduleOperationSettings;
  private final UnaryCallSettings<CreateScheduleRequest, Operation> createScheduleSettings;
  private final OperationCallSettings<CreateScheduleRequest, Schedule, OperationMetadata>
      createScheduleOperationSettings;
  private final UnaryCallSettings<TriggerScheduleRequest, Operation> triggerScheduleSettings;
  private final OperationCallSettings<TriggerScheduleRequest, Schedule, OperationMetadata>
      triggerScheduleOperationSettings;
  private final PagedCallSettings<
          ListExecutionsRequest, ListExecutionsResponse, ListExecutionsPagedResponse>
      listExecutionsSettings;
  private final UnaryCallSettings<GetExecutionRequest, Execution> getExecutionSettings;
  private final UnaryCallSettings<DeleteExecutionRequest, Operation> deleteExecutionSettings;
  private final OperationCallSettings<DeleteExecutionRequest, Empty, OperationMetadata>
      deleteExecutionOperationSettings;
  private final UnaryCallSettings<CreateExecutionRequest, Operation> createExecutionSettings;
  private final OperationCallSettings<CreateExecutionRequest, Execution, OperationMetadata>
      createExecutionOperationSettings;

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

  private static final PagedListDescriptor<
          ListEnvironmentsRequest, ListEnvironmentsResponse, Environment>
      LIST_ENVIRONMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListEnvironmentsRequest, ListEnvironmentsResponse, Environment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEnvironmentsRequest injectToken(
                ListEnvironmentsRequest payload, String token) {
              return ListEnvironmentsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListEnvironmentsRequest injectPageSize(
                ListEnvironmentsRequest payload, int pageSize) {
              return ListEnvironmentsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListEnvironmentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEnvironmentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Environment> extractResources(ListEnvironmentsResponse payload) {
              return payload.getEnvironmentsList() == null
                  ? ImmutableList.<Environment>of()
                  : payload.getEnvironmentsList();
            }
          };

  private static final PagedListDescriptor<ListSchedulesRequest, ListSchedulesResponse, Schedule>
      LIST_SCHEDULES_PAGE_STR_DESC =
          new PagedListDescriptor<ListSchedulesRequest, ListSchedulesResponse, Schedule>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSchedulesRequest injectToken(ListSchedulesRequest payload, String token) {
              return ListSchedulesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSchedulesRequest injectPageSize(ListSchedulesRequest payload, int pageSize) {
              return ListSchedulesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSchedulesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSchedulesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Schedule> extractResources(ListSchedulesResponse payload) {
              return payload.getSchedulesList() == null
                  ? ImmutableList.<Schedule>of()
                  : payload.getSchedulesList();
            }
          };

  private static final PagedListDescriptor<ListExecutionsRequest, ListExecutionsResponse, Execution>
      LIST_EXECUTIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListExecutionsRequest, ListExecutionsResponse, Execution>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListExecutionsRequest injectToken(ListExecutionsRequest payload, String token) {
              return ListExecutionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListExecutionsRequest injectPageSize(
                ListExecutionsRequest payload, int pageSize) {
              return ListExecutionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListExecutionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListExecutionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Execution> extractResources(ListExecutionsResponse payload) {
              return payload.getExecutionsList() == null
                  ? ImmutableList.<Execution>of()
                  : payload.getExecutionsList();
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
          ListEnvironmentsRequest, ListEnvironmentsResponse, ListEnvironmentsPagedResponse>
      LIST_ENVIRONMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEnvironmentsRequest, ListEnvironmentsResponse, ListEnvironmentsPagedResponse>() {
            @Override
            public ApiFuture<ListEnvironmentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListEnvironmentsRequest, ListEnvironmentsResponse> callable,
                ListEnvironmentsRequest request,
                ApiCallContext context,
                ApiFuture<ListEnvironmentsResponse> futureResponse) {
              PageContext<ListEnvironmentsRequest, ListEnvironmentsResponse, Environment>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ENVIRONMENTS_PAGE_STR_DESC, request, context);
              return ListEnvironmentsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListSchedulesRequest, ListSchedulesResponse, ListSchedulesPagedResponse>
      LIST_SCHEDULES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSchedulesRequest, ListSchedulesResponse, ListSchedulesPagedResponse>() {
            @Override
            public ApiFuture<ListSchedulesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSchedulesRequest, ListSchedulesResponse> callable,
                ListSchedulesRequest request,
                ApiCallContext context,
                ApiFuture<ListSchedulesResponse> futureResponse) {
              PageContext<ListSchedulesRequest, ListSchedulesResponse, Schedule> pageContext =
                  PageContext.create(callable, LIST_SCHEDULES_PAGE_STR_DESC, request, context);
              return ListSchedulesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListExecutionsRequest, ListExecutionsResponse, ListExecutionsPagedResponse>
      LIST_EXECUTIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListExecutionsRequest, ListExecutionsResponse, ListExecutionsPagedResponse>() {
            @Override
            public ApiFuture<ListExecutionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListExecutionsRequest, ListExecutionsResponse> callable,
                ListExecutionsRequest request,
                ApiCallContext context,
                ApiFuture<ListExecutionsResponse> futureResponse) {
              PageContext<ListExecutionsRequest, ListExecutionsResponse, Execution> pageContext =
                  PageContext.create(callable, LIST_EXECUTIONS_PAGE_STR_DESC, request, context);
              return ListExecutionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listInstances. */
  public PagedCallSettings<ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
      listInstancesSettings() {
    return listInstancesSettings;
  }

  /** Returns the object with the settings used for calls to getInstance. */
  public UnaryCallSettings<GetInstanceRequest, Instance> getInstanceSettings() {
    return getInstanceSettings;
  }

  /** Returns the object with the settings used for calls to createInstance. */
  public UnaryCallSettings<CreateInstanceRequest, Operation> createInstanceSettings() {
    return createInstanceSettings;
  }

  /** Returns the object with the settings used for calls to createInstance. */
  public OperationCallSettings<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationSettings() {
    return createInstanceOperationSettings;
  }

  /** Returns the object with the settings used for calls to registerInstance. */
  public UnaryCallSettings<RegisterInstanceRequest, Operation> registerInstanceSettings() {
    return registerInstanceSettings;
  }

  /** Returns the object with the settings used for calls to registerInstance. */
  public OperationCallSettings<RegisterInstanceRequest, Instance, OperationMetadata>
      registerInstanceOperationSettings() {
    return registerInstanceOperationSettings;
  }

  /** Returns the object with the settings used for calls to setInstanceAccelerator. */
  public UnaryCallSettings<SetInstanceAcceleratorRequest, Operation>
      setInstanceAcceleratorSettings() {
    return setInstanceAcceleratorSettings;
  }

  /** Returns the object with the settings used for calls to setInstanceAccelerator. */
  public OperationCallSettings<SetInstanceAcceleratorRequest, Instance, OperationMetadata>
      setInstanceAcceleratorOperationSettings() {
    return setInstanceAcceleratorOperationSettings;
  }

  /** Returns the object with the settings used for calls to setInstanceMachineType. */
  public UnaryCallSettings<SetInstanceMachineTypeRequest, Operation>
      setInstanceMachineTypeSettings() {
    return setInstanceMachineTypeSettings;
  }

  /** Returns the object with the settings used for calls to setInstanceMachineType. */
  public OperationCallSettings<SetInstanceMachineTypeRequest, Instance, OperationMetadata>
      setInstanceMachineTypeOperationSettings() {
    return setInstanceMachineTypeOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateInstanceConfig. */
  public UnaryCallSettings<UpdateInstanceConfigRequest, Operation> updateInstanceConfigSettings() {
    return updateInstanceConfigSettings;
  }

  /** Returns the object with the settings used for calls to updateInstanceConfig. */
  public OperationCallSettings<UpdateInstanceConfigRequest, Instance, OperationMetadata>
      updateInstanceConfigOperationSettings() {
    return updateInstanceConfigOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateShieldedInstanceConfig. */
  public UnaryCallSettings<UpdateShieldedInstanceConfigRequest, Operation>
      updateShieldedInstanceConfigSettings() {
    return updateShieldedInstanceConfigSettings;
  }

  /** Returns the object with the settings used for calls to updateShieldedInstanceConfig. */
  public OperationCallSettings<UpdateShieldedInstanceConfigRequest, Instance, OperationMetadata>
      updateShieldedInstanceConfigOperationSettings() {
    return updateShieldedInstanceConfigOperationSettings;
  }

  /** Returns the object with the settings used for calls to setInstanceLabels. */
  public UnaryCallSettings<SetInstanceLabelsRequest, Operation> setInstanceLabelsSettings() {
    return setInstanceLabelsSettings;
  }

  /** Returns the object with the settings used for calls to setInstanceLabels. */
  public OperationCallSettings<SetInstanceLabelsRequest, Instance, OperationMetadata>
      setInstanceLabelsOperationSettings() {
    return setInstanceLabelsOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateInstanceMetadataItems. */
  public UnaryCallSettings<UpdateInstanceMetadataItemsRequest, UpdateInstanceMetadataItemsResponse>
      updateInstanceMetadataItemsSettings() {
    return updateInstanceMetadataItemsSettings;
  }

  /** Returns the object with the settings used for calls to deleteInstance. */
  public UnaryCallSettings<DeleteInstanceRequest, Operation> deleteInstanceSettings() {
    return deleteInstanceSettings;
  }

  /** Returns the object with the settings used for calls to deleteInstance. */
  public OperationCallSettings<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationSettings() {
    return deleteInstanceOperationSettings;
  }

  /** Returns the object with the settings used for calls to startInstance. */
  public UnaryCallSettings<StartInstanceRequest, Operation> startInstanceSettings() {
    return startInstanceSettings;
  }

  /** Returns the object with the settings used for calls to startInstance. */
  public OperationCallSettings<StartInstanceRequest, Instance, OperationMetadata>
      startInstanceOperationSettings() {
    return startInstanceOperationSettings;
  }

  /** Returns the object with the settings used for calls to stopInstance. */
  public UnaryCallSettings<StopInstanceRequest, Operation> stopInstanceSettings() {
    return stopInstanceSettings;
  }

  /** Returns the object with the settings used for calls to stopInstance. */
  public OperationCallSettings<StopInstanceRequest, Instance, OperationMetadata>
      stopInstanceOperationSettings() {
    return stopInstanceOperationSettings;
  }

  /** Returns the object with the settings used for calls to resetInstance. */
  public UnaryCallSettings<ResetInstanceRequest, Operation> resetInstanceSettings() {
    return resetInstanceSettings;
  }

  /** Returns the object with the settings used for calls to resetInstance. */
  public OperationCallSettings<ResetInstanceRequest, Instance, OperationMetadata>
      resetInstanceOperationSettings() {
    return resetInstanceOperationSettings;
  }

  /** Returns the object with the settings used for calls to reportInstanceInfo. */
  public UnaryCallSettings<ReportInstanceInfoRequest, Operation> reportInstanceInfoSettings() {
    return reportInstanceInfoSettings;
  }

  /** Returns the object with the settings used for calls to reportInstanceInfo. */
  public OperationCallSettings<ReportInstanceInfoRequest, Instance, OperationMetadata>
      reportInstanceInfoOperationSettings() {
    return reportInstanceInfoOperationSettings;
  }

  /** Returns the object with the settings used for calls to isInstanceUpgradeable. */
  public UnaryCallSettings<IsInstanceUpgradeableRequest, IsInstanceUpgradeableResponse>
      isInstanceUpgradeableSettings() {
    return isInstanceUpgradeableSettings;
  }

  /** Returns the object with the settings used for calls to getInstanceHealth. */
  public UnaryCallSettings<GetInstanceHealthRequest, GetInstanceHealthResponse>
      getInstanceHealthSettings() {
    return getInstanceHealthSettings;
  }

  /** Returns the object with the settings used for calls to upgradeInstance. */
  public UnaryCallSettings<UpgradeInstanceRequest, Operation> upgradeInstanceSettings() {
    return upgradeInstanceSettings;
  }

  /** Returns the object with the settings used for calls to upgradeInstance. */
  public OperationCallSettings<UpgradeInstanceRequest, Instance, OperationMetadata>
      upgradeInstanceOperationSettings() {
    return upgradeInstanceOperationSettings;
  }

  /** Returns the object with the settings used for calls to rollbackInstance. */
  public UnaryCallSettings<RollbackInstanceRequest, Operation> rollbackInstanceSettings() {
    return rollbackInstanceSettings;
  }

  /** Returns the object with the settings used for calls to rollbackInstance. */
  public OperationCallSettings<RollbackInstanceRequest, Instance, OperationMetadata>
      rollbackInstanceOperationSettings() {
    return rollbackInstanceOperationSettings;
  }

  /** Returns the object with the settings used for calls to upgradeInstanceInternal. */
  public UnaryCallSettings<UpgradeInstanceInternalRequest, Operation>
      upgradeInstanceInternalSettings() {
    return upgradeInstanceInternalSettings;
  }

  /** Returns the object with the settings used for calls to upgradeInstanceInternal. */
  public OperationCallSettings<UpgradeInstanceInternalRequest, Instance, OperationMetadata>
      upgradeInstanceInternalOperationSettings() {
    return upgradeInstanceInternalOperationSettings;
  }

  /** Returns the object with the settings used for calls to listEnvironments. */
  public PagedCallSettings<
          ListEnvironmentsRequest, ListEnvironmentsResponse, ListEnvironmentsPagedResponse>
      listEnvironmentsSettings() {
    return listEnvironmentsSettings;
  }

  /** Returns the object with the settings used for calls to getEnvironment. */
  public UnaryCallSettings<GetEnvironmentRequest, Environment> getEnvironmentSettings() {
    return getEnvironmentSettings;
  }

  /** Returns the object with the settings used for calls to createEnvironment. */
  public UnaryCallSettings<CreateEnvironmentRequest, Operation> createEnvironmentSettings() {
    return createEnvironmentSettings;
  }

  /** Returns the object with the settings used for calls to createEnvironment. */
  public OperationCallSettings<CreateEnvironmentRequest, Environment, OperationMetadata>
      createEnvironmentOperationSettings() {
    return createEnvironmentOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteEnvironment. */
  public UnaryCallSettings<DeleteEnvironmentRequest, Operation> deleteEnvironmentSettings() {
    return deleteEnvironmentSettings;
  }

  /** Returns the object with the settings used for calls to deleteEnvironment. */
  public OperationCallSettings<DeleteEnvironmentRequest, Empty, OperationMetadata>
      deleteEnvironmentOperationSettings() {
    return deleteEnvironmentOperationSettings;
  }

  /** Returns the object with the settings used for calls to listSchedules. */
  public PagedCallSettings<ListSchedulesRequest, ListSchedulesResponse, ListSchedulesPagedResponse>
      listSchedulesSettings() {
    return listSchedulesSettings;
  }

  /** Returns the object with the settings used for calls to getSchedule. */
  public UnaryCallSettings<GetScheduleRequest, Schedule> getScheduleSettings() {
    return getScheduleSettings;
  }

  /** Returns the object with the settings used for calls to deleteSchedule. */
  public UnaryCallSettings<DeleteScheduleRequest, Operation> deleteScheduleSettings() {
    return deleteScheduleSettings;
  }

  /** Returns the object with the settings used for calls to deleteSchedule. */
  public OperationCallSettings<DeleteScheduleRequest, Empty, OperationMetadata>
      deleteScheduleOperationSettings() {
    return deleteScheduleOperationSettings;
  }

  /** Returns the object with the settings used for calls to createSchedule. */
  public UnaryCallSettings<CreateScheduleRequest, Operation> createScheduleSettings() {
    return createScheduleSettings;
  }

  /** Returns the object with the settings used for calls to createSchedule. */
  public OperationCallSettings<CreateScheduleRequest, Schedule, OperationMetadata>
      createScheduleOperationSettings() {
    return createScheduleOperationSettings;
  }

  /** Returns the object with the settings used for calls to triggerSchedule. */
  public UnaryCallSettings<TriggerScheduleRequest, Operation> triggerScheduleSettings() {
    return triggerScheduleSettings;
  }

  /** Returns the object with the settings used for calls to triggerSchedule. */
  public OperationCallSettings<TriggerScheduleRequest, Schedule, OperationMetadata>
      triggerScheduleOperationSettings() {
    return triggerScheduleOperationSettings;
  }

  /** Returns the object with the settings used for calls to listExecutions. */
  public PagedCallSettings<
          ListExecutionsRequest, ListExecutionsResponse, ListExecutionsPagedResponse>
      listExecutionsSettings() {
    return listExecutionsSettings;
  }

  /** Returns the object with the settings used for calls to getExecution. */
  public UnaryCallSettings<GetExecutionRequest, Execution> getExecutionSettings() {
    return getExecutionSettings;
  }

  /** Returns the object with the settings used for calls to deleteExecution. */
  public UnaryCallSettings<DeleteExecutionRequest, Operation> deleteExecutionSettings() {
    return deleteExecutionSettings;
  }

  /** Returns the object with the settings used for calls to deleteExecution. */
  public OperationCallSettings<DeleteExecutionRequest, Empty, OperationMetadata>
      deleteExecutionOperationSettings() {
    return deleteExecutionOperationSettings;
  }

  /** Returns the object with the settings used for calls to createExecution. */
  public UnaryCallSettings<CreateExecutionRequest, Operation> createExecutionSettings() {
    return createExecutionSettings;
  }

  /** Returns the object with the settings used for calls to createExecution. */
  public OperationCallSettings<CreateExecutionRequest, Execution, OperationMetadata>
      createExecutionOperationSettings() {
    return createExecutionOperationSettings;
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

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "notebooks.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "notebooks.mtls.googleapis.com:443";
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

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
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

    listInstancesSettings = settingsBuilder.listInstancesSettings().build();
    getInstanceSettings = settingsBuilder.getInstanceSettings().build();
    createInstanceSettings = settingsBuilder.createInstanceSettings().build();
    createInstanceOperationSettings = settingsBuilder.createInstanceOperationSettings().build();
    registerInstanceSettings = settingsBuilder.registerInstanceSettings().build();
    registerInstanceOperationSettings = settingsBuilder.registerInstanceOperationSettings().build();
    setInstanceAcceleratorSettings = settingsBuilder.setInstanceAcceleratorSettings().build();
    setInstanceAcceleratorOperationSettings =
        settingsBuilder.setInstanceAcceleratorOperationSettings().build();
    setInstanceMachineTypeSettings = settingsBuilder.setInstanceMachineTypeSettings().build();
    setInstanceMachineTypeOperationSettings =
        settingsBuilder.setInstanceMachineTypeOperationSettings().build();
    updateInstanceConfigSettings = settingsBuilder.updateInstanceConfigSettings().build();
    updateInstanceConfigOperationSettings =
        settingsBuilder.updateInstanceConfigOperationSettings().build();
    updateShieldedInstanceConfigSettings =
        settingsBuilder.updateShieldedInstanceConfigSettings().build();
    updateShieldedInstanceConfigOperationSettings =
        settingsBuilder.updateShieldedInstanceConfigOperationSettings().build();
    setInstanceLabelsSettings = settingsBuilder.setInstanceLabelsSettings().build();
    setInstanceLabelsOperationSettings =
        settingsBuilder.setInstanceLabelsOperationSettings().build();
    updateInstanceMetadataItemsSettings =
        settingsBuilder.updateInstanceMetadataItemsSettings().build();
    deleteInstanceSettings = settingsBuilder.deleteInstanceSettings().build();
    deleteInstanceOperationSettings = settingsBuilder.deleteInstanceOperationSettings().build();
    startInstanceSettings = settingsBuilder.startInstanceSettings().build();
    startInstanceOperationSettings = settingsBuilder.startInstanceOperationSettings().build();
    stopInstanceSettings = settingsBuilder.stopInstanceSettings().build();
    stopInstanceOperationSettings = settingsBuilder.stopInstanceOperationSettings().build();
    resetInstanceSettings = settingsBuilder.resetInstanceSettings().build();
    resetInstanceOperationSettings = settingsBuilder.resetInstanceOperationSettings().build();
    reportInstanceInfoSettings = settingsBuilder.reportInstanceInfoSettings().build();
    reportInstanceInfoOperationSettings =
        settingsBuilder.reportInstanceInfoOperationSettings().build();
    isInstanceUpgradeableSettings = settingsBuilder.isInstanceUpgradeableSettings().build();
    getInstanceHealthSettings = settingsBuilder.getInstanceHealthSettings().build();
    upgradeInstanceSettings = settingsBuilder.upgradeInstanceSettings().build();
    upgradeInstanceOperationSettings = settingsBuilder.upgradeInstanceOperationSettings().build();
    rollbackInstanceSettings = settingsBuilder.rollbackInstanceSettings().build();
    rollbackInstanceOperationSettings = settingsBuilder.rollbackInstanceOperationSettings().build();
    upgradeInstanceInternalSettings = settingsBuilder.upgradeInstanceInternalSettings().build();
    upgradeInstanceInternalOperationSettings =
        settingsBuilder.upgradeInstanceInternalOperationSettings().build();
    listEnvironmentsSettings = settingsBuilder.listEnvironmentsSettings().build();
    getEnvironmentSettings = settingsBuilder.getEnvironmentSettings().build();
    createEnvironmentSettings = settingsBuilder.createEnvironmentSettings().build();
    createEnvironmentOperationSettings =
        settingsBuilder.createEnvironmentOperationSettings().build();
    deleteEnvironmentSettings = settingsBuilder.deleteEnvironmentSettings().build();
    deleteEnvironmentOperationSettings =
        settingsBuilder.deleteEnvironmentOperationSettings().build();
    listSchedulesSettings = settingsBuilder.listSchedulesSettings().build();
    getScheduleSettings = settingsBuilder.getScheduleSettings().build();
    deleteScheduleSettings = settingsBuilder.deleteScheduleSettings().build();
    deleteScheduleOperationSettings = settingsBuilder.deleteScheduleOperationSettings().build();
    createScheduleSettings = settingsBuilder.createScheduleSettings().build();
    createScheduleOperationSettings = settingsBuilder.createScheduleOperationSettings().build();
    triggerScheduleSettings = settingsBuilder.triggerScheduleSettings().build();
    triggerScheduleOperationSettings = settingsBuilder.triggerScheduleOperationSettings().build();
    listExecutionsSettings = settingsBuilder.listExecutionsSettings().build();
    getExecutionSettings = settingsBuilder.getExecutionSettings().build();
    deleteExecutionSettings = settingsBuilder.deleteExecutionSettings().build();
    deleteExecutionOperationSettings = settingsBuilder.deleteExecutionOperationSettings().build();
    createExecutionSettings = settingsBuilder.createExecutionSettings().build();
    createExecutionOperationSettings = settingsBuilder.createExecutionOperationSettings().build();
  }

  /** Builder for NotebookServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<NotebookServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
        listInstancesSettings;
    private final UnaryCallSettings.Builder<GetInstanceRequest, Instance> getInstanceSettings;
    private final UnaryCallSettings.Builder<CreateInstanceRequest, Operation>
        createInstanceSettings;
    private final OperationCallSettings.Builder<CreateInstanceRequest, Instance, OperationMetadata>
        createInstanceOperationSettings;
    private final UnaryCallSettings.Builder<RegisterInstanceRequest, Operation>
        registerInstanceSettings;
    private final OperationCallSettings.Builder<
            RegisterInstanceRequest, Instance, OperationMetadata>
        registerInstanceOperationSettings;
    private final UnaryCallSettings.Builder<SetInstanceAcceleratorRequest, Operation>
        setInstanceAcceleratorSettings;
    private final OperationCallSettings.Builder<
            SetInstanceAcceleratorRequest, Instance, OperationMetadata>
        setInstanceAcceleratorOperationSettings;
    private final UnaryCallSettings.Builder<SetInstanceMachineTypeRequest, Operation>
        setInstanceMachineTypeSettings;
    private final OperationCallSettings.Builder<
            SetInstanceMachineTypeRequest, Instance, OperationMetadata>
        setInstanceMachineTypeOperationSettings;
    private final UnaryCallSettings.Builder<UpdateInstanceConfigRequest, Operation>
        updateInstanceConfigSettings;
    private final OperationCallSettings.Builder<
            UpdateInstanceConfigRequest, Instance, OperationMetadata>
        updateInstanceConfigOperationSettings;
    private final UnaryCallSettings.Builder<UpdateShieldedInstanceConfigRequest, Operation>
        updateShieldedInstanceConfigSettings;
    private final OperationCallSettings.Builder<
            UpdateShieldedInstanceConfigRequest, Instance, OperationMetadata>
        updateShieldedInstanceConfigOperationSettings;
    private final UnaryCallSettings.Builder<SetInstanceLabelsRequest, Operation>
        setInstanceLabelsSettings;
    private final OperationCallSettings.Builder<
            SetInstanceLabelsRequest, Instance, OperationMetadata>
        setInstanceLabelsOperationSettings;
    private final UnaryCallSettings.Builder<
            UpdateInstanceMetadataItemsRequest, UpdateInstanceMetadataItemsResponse>
        updateInstanceMetadataItemsSettings;
    private final UnaryCallSettings.Builder<DeleteInstanceRequest, Operation>
        deleteInstanceSettings;
    private final OperationCallSettings.Builder<DeleteInstanceRequest, Empty, OperationMetadata>
        deleteInstanceOperationSettings;
    private final UnaryCallSettings.Builder<StartInstanceRequest, Operation> startInstanceSettings;
    private final OperationCallSettings.Builder<StartInstanceRequest, Instance, OperationMetadata>
        startInstanceOperationSettings;
    private final UnaryCallSettings.Builder<StopInstanceRequest, Operation> stopInstanceSettings;
    private final OperationCallSettings.Builder<StopInstanceRequest, Instance, OperationMetadata>
        stopInstanceOperationSettings;
    private final UnaryCallSettings.Builder<ResetInstanceRequest, Operation> resetInstanceSettings;
    private final OperationCallSettings.Builder<ResetInstanceRequest, Instance, OperationMetadata>
        resetInstanceOperationSettings;
    private final UnaryCallSettings.Builder<ReportInstanceInfoRequest, Operation>
        reportInstanceInfoSettings;
    private final OperationCallSettings.Builder<
            ReportInstanceInfoRequest, Instance, OperationMetadata>
        reportInstanceInfoOperationSettings;
    private final UnaryCallSettings.Builder<
            IsInstanceUpgradeableRequest, IsInstanceUpgradeableResponse>
        isInstanceUpgradeableSettings;
    private final UnaryCallSettings.Builder<GetInstanceHealthRequest, GetInstanceHealthResponse>
        getInstanceHealthSettings;
    private final UnaryCallSettings.Builder<UpgradeInstanceRequest, Operation>
        upgradeInstanceSettings;
    private final OperationCallSettings.Builder<UpgradeInstanceRequest, Instance, OperationMetadata>
        upgradeInstanceOperationSettings;
    private final UnaryCallSettings.Builder<RollbackInstanceRequest, Operation>
        rollbackInstanceSettings;
    private final OperationCallSettings.Builder<
            RollbackInstanceRequest, Instance, OperationMetadata>
        rollbackInstanceOperationSettings;
    private final UnaryCallSettings.Builder<UpgradeInstanceInternalRequest, Operation>
        upgradeInstanceInternalSettings;
    private final OperationCallSettings.Builder<
            UpgradeInstanceInternalRequest, Instance, OperationMetadata>
        upgradeInstanceInternalOperationSettings;
    private final PagedCallSettings.Builder<
            ListEnvironmentsRequest, ListEnvironmentsResponse, ListEnvironmentsPagedResponse>
        listEnvironmentsSettings;
    private final UnaryCallSettings.Builder<GetEnvironmentRequest, Environment>
        getEnvironmentSettings;
    private final UnaryCallSettings.Builder<CreateEnvironmentRequest, Operation>
        createEnvironmentSettings;
    private final OperationCallSettings.Builder<
            CreateEnvironmentRequest, Environment, OperationMetadata>
        createEnvironmentOperationSettings;
    private final UnaryCallSettings.Builder<DeleteEnvironmentRequest, Operation>
        deleteEnvironmentSettings;
    private final OperationCallSettings.Builder<DeleteEnvironmentRequest, Empty, OperationMetadata>
        deleteEnvironmentOperationSettings;
    private final PagedCallSettings.Builder<
            ListSchedulesRequest, ListSchedulesResponse, ListSchedulesPagedResponse>
        listSchedulesSettings;
    private final UnaryCallSettings.Builder<GetScheduleRequest, Schedule> getScheduleSettings;
    private final UnaryCallSettings.Builder<DeleteScheduleRequest, Operation>
        deleteScheduleSettings;
    private final OperationCallSettings.Builder<DeleteScheduleRequest, Empty, OperationMetadata>
        deleteScheduleOperationSettings;
    private final UnaryCallSettings.Builder<CreateScheduleRequest, Operation>
        createScheduleSettings;
    private final OperationCallSettings.Builder<CreateScheduleRequest, Schedule, OperationMetadata>
        createScheduleOperationSettings;
    private final UnaryCallSettings.Builder<TriggerScheduleRequest, Operation>
        triggerScheduleSettings;
    private final OperationCallSettings.Builder<TriggerScheduleRequest, Schedule, OperationMetadata>
        triggerScheduleOperationSettings;
    private final PagedCallSettings.Builder<
            ListExecutionsRequest, ListExecutionsResponse, ListExecutionsPagedResponse>
        listExecutionsSettings;
    private final UnaryCallSettings.Builder<GetExecutionRequest, Execution> getExecutionSettings;
    private final UnaryCallSettings.Builder<DeleteExecutionRequest, Operation>
        deleteExecutionSettings;
    private final OperationCallSettings.Builder<DeleteExecutionRequest, Empty, OperationMetadata>
        deleteExecutionOperationSettings;
    private final UnaryCallSettings.Builder<CreateExecutionRequest, Operation>
        createExecutionSettings;
    private final OperationCallSettings.Builder<
            CreateExecutionRequest, Execution, OperationMetadata>
        createExecutionOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
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
      definitions.put("no_retry_1_params", settings);
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
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listInstancesSettings = PagedCallSettings.newBuilder(LIST_INSTANCES_PAGE_STR_FACT);
      getInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createInstanceOperationSettings = OperationCallSettings.newBuilder();
      registerInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      registerInstanceOperationSettings = OperationCallSettings.newBuilder();
      setInstanceAcceleratorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setInstanceAcceleratorOperationSettings = OperationCallSettings.newBuilder();
      setInstanceMachineTypeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setInstanceMachineTypeOperationSettings = OperationCallSettings.newBuilder();
      updateInstanceConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateInstanceConfigOperationSettings = OperationCallSettings.newBuilder();
      updateShieldedInstanceConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateShieldedInstanceConfigOperationSettings = OperationCallSettings.newBuilder();
      setInstanceLabelsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setInstanceLabelsOperationSettings = OperationCallSettings.newBuilder();
      updateInstanceMetadataItemsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteInstanceOperationSettings = OperationCallSettings.newBuilder();
      startInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      startInstanceOperationSettings = OperationCallSettings.newBuilder();
      stopInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      stopInstanceOperationSettings = OperationCallSettings.newBuilder();
      resetInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      resetInstanceOperationSettings = OperationCallSettings.newBuilder();
      reportInstanceInfoSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      reportInstanceInfoOperationSettings = OperationCallSettings.newBuilder();
      isInstanceUpgradeableSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getInstanceHealthSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      upgradeInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      upgradeInstanceOperationSettings = OperationCallSettings.newBuilder();
      rollbackInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      rollbackInstanceOperationSettings = OperationCallSettings.newBuilder();
      upgradeInstanceInternalSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      upgradeInstanceInternalOperationSettings = OperationCallSettings.newBuilder();
      listEnvironmentsSettings = PagedCallSettings.newBuilder(LIST_ENVIRONMENTS_PAGE_STR_FACT);
      getEnvironmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEnvironmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEnvironmentOperationSettings = OperationCallSettings.newBuilder();
      deleteEnvironmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteEnvironmentOperationSettings = OperationCallSettings.newBuilder();
      listSchedulesSettings = PagedCallSettings.newBuilder(LIST_SCHEDULES_PAGE_STR_FACT);
      getScheduleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteScheduleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteScheduleOperationSettings = OperationCallSettings.newBuilder();
      createScheduleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createScheduleOperationSettings = OperationCallSettings.newBuilder();
      triggerScheduleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      triggerScheduleOperationSettings = OperationCallSettings.newBuilder();
      listExecutionsSettings = PagedCallSettings.newBuilder(LIST_EXECUTIONS_PAGE_STR_FACT);
      getExecutionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteExecutionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteExecutionOperationSettings = OperationCallSettings.newBuilder();
      createExecutionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createExecutionOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listInstancesSettings,
              getInstanceSettings,
              createInstanceSettings,
              registerInstanceSettings,
              setInstanceAcceleratorSettings,
              setInstanceMachineTypeSettings,
              updateInstanceConfigSettings,
              updateShieldedInstanceConfigSettings,
              setInstanceLabelsSettings,
              updateInstanceMetadataItemsSettings,
              deleteInstanceSettings,
              startInstanceSettings,
              stopInstanceSettings,
              resetInstanceSettings,
              reportInstanceInfoSettings,
              isInstanceUpgradeableSettings,
              getInstanceHealthSettings,
              upgradeInstanceSettings,
              rollbackInstanceSettings,
              upgradeInstanceInternalSettings,
              listEnvironmentsSettings,
              getEnvironmentSettings,
              createEnvironmentSettings,
              deleteEnvironmentSettings,
              listSchedulesSettings,
              getScheduleSettings,
              deleteScheduleSettings,
              createScheduleSettings,
              triggerScheduleSettings,
              listExecutionsSettings,
              getExecutionSettings,
              deleteExecutionSettings,
              createExecutionSettings);
      initDefaults(this);
    }

    protected Builder(NotebookServiceStubSettings settings) {
      super(settings);

      listInstancesSettings = settings.listInstancesSettings.toBuilder();
      getInstanceSettings = settings.getInstanceSettings.toBuilder();
      createInstanceSettings = settings.createInstanceSettings.toBuilder();
      createInstanceOperationSettings = settings.createInstanceOperationSettings.toBuilder();
      registerInstanceSettings = settings.registerInstanceSettings.toBuilder();
      registerInstanceOperationSettings = settings.registerInstanceOperationSettings.toBuilder();
      setInstanceAcceleratorSettings = settings.setInstanceAcceleratorSettings.toBuilder();
      setInstanceAcceleratorOperationSettings =
          settings.setInstanceAcceleratorOperationSettings.toBuilder();
      setInstanceMachineTypeSettings = settings.setInstanceMachineTypeSettings.toBuilder();
      setInstanceMachineTypeOperationSettings =
          settings.setInstanceMachineTypeOperationSettings.toBuilder();
      updateInstanceConfigSettings = settings.updateInstanceConfigSettings.toBuilder();
      updateInstanceConfigOperationSettings =
          settings.updateInstanceConfigOperationSettings.toBuilder();
      updateShieldedInstanceConfigSettings =
          settings.updateShieldedInstanceConfigSettings.toBuilder();
      updateShieldedInstanceConfigOperationSettings =
          settings.updateShieldedInstanceConfigOperationSettings.toBuilder();
      setInstanceLabelsSettings = settings.setInstanceLabelsSettings.toBuilder();
      setInstanceLabelsOperationSettings = settings.setInstanceLabelsOperationSettings.toBuilder();
      updateInstanceMetadataItemsSettings =
          settings.updateInstanceMetadataItemsSettings.toBuilder();
      deleteInstanceSettings = settings.deleteInstanceSettings.toBuilder();
      deleteInstanceOperationSettings = settings.deleteInstanceOperationSettings.toBuilder();
      startInstanceSettings = settings.startInstanceSettings.toBuilder();
      startInstanceOperationSettings = settings.startInstanceOperationSettings.toBuilder();
      stopInstanceSettings = settings.stopInstanceSettings.toBuilder();
      stopInstanceOperationSettings = settings.stopInstanceOperationSettings.toBuilder();
      resetInstanceSettings = settings.resetInstanceSettings.toBuilder();
      resetInstanceOperationSettings = settings.resetInstanceOperationSettings.toBuilder();
      reportInstanceInfoSettings = settings.reportInstanceInfoSettings.toBuilder();
      reportInstanceInfoOperationSettings =
          settings.reportInstanceInfoOperationSettings.toBuilder();
      isInstanceUpgradeableSettings = settings.isInstanceUpgradeableSettings.toBuilder();
      getInstanceHealthSettings = settings.getInstanceHealthSettings.toBuilder();
      upgradeInstanceSettings = settings.upgradeInstanceSettings.toBuilder();
      upgradeInstanceOperationSettings = settings.upgradeInstanceOperationSettings.toBuilder();
      rollbackInstanceSettings = settings.rollbackInstanceSettings.toBuilder();
      rollbackInstanceOperationSettings = settings.rollbackInstanceOperationSettings.toBuilder();
      upgradeInstanceInternalSettings = settings.upgradeInstanceInternalSettings.toBuilder();
      upgradeInstanceInternalOperationSettings =
          settings.upgradeInstanceInternalOperationSettings.toBuilder();
      listEnvironmentsSettings = settings.listEnvironmentsSettings.toBuilder();
      getEnvironmentSettings = settings.getEnvironmentSettings.toBuilder();
      createEnvironmentSettings = settings.createEnvironmentSettings.toBuilder();
      createEnvironmentOperationSettings = settings.createEnvironmentOperationSettings.toBuilder();
      deleteEnvironmentSettings = settings.deleteEnvironmentSettings.toBuilder();
      deleteEnvironmentOperationSettings = settings.deleteEnvironmentOperationSettings.toBuilder();
      listSchedulesSettings = settings.listSchedulesSettings.toBuilder();
      getScheduleSettings = settings.getScheduleSettings.toBuilder();
      deleteScheduleSettings = settings.deleteScheduleSettings.toBuilder();
      deleteScheduleOperationSettings = settings.deleteScheduleOperationSettings.toBuilder();
      createScheduleSettings = settings.createScheduleSettings.toBuilder();
      createScheduleOperationSettings = settings.createScheduleOperationSettings.toBuilder();
      triggerScheduleSettings = settings.triggerScheduleSettings.toBuilder();
      triggerScheduleOperationSettings = settings.triggerScheduleOperationSettings.toBuilder();
      listExecutionsSettings = settings.listExecutionsSettings.toBuilder();
      getExecutionSettings = settings.getExecutionSettings.toBuilder();
      deleteExecutionSettings = settings.deleteExecutionSettings.toBuilder();
      deleteExecutionOperationSettings = settings.deleteExecutionOperationSettings.toBuilder();
      createExecutionSettings = settings.createExecutionSettings.toBuilder();
      createExecutionOperationSettings = settings.createExecutionOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listInstancesSettings,
              getInstanceSettings,
              createInstanceSettings,
              registerInstanceSettings,
              setInstanceAcceleratorSettings,
              setInstanceMachineTypeSettings,
              updateInstanceConfigSettings,
              updateShieldedInstanceConfigSettings,
              setInstanceLabelsSettings,
              updateInstanceMetadataItemsSettings,
              deleteInstanceSettings,
              startInstanceSettings,
              stopInstanceSettings,
              resetInstanceSettings,
              reportInstanceInfoSettings,
              isInstanceUpgradeableSettings,
              getInstanceHealthSettings,
              upgradeInstanceSettings,
              rollbackInstanceSettings,
              upgradeInstanceInternalSettings,
              listEnvironmentsSettings,
              getEnvironmentSettings,
              createEnvironmentSettings,
              deleteEnvironmentSettings,
              listSchedulesSettings,
              getScheduleSettings,
              deleteScheduleSettings,
              createScheduleSettings,
              triggerScheduleSettings,
              listExecutionsSettings,
              getExecutionSettings,
              deleteExecutionSettings,
              createExecutionSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .listInstancesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .registerInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setInstanceAcceleratorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setInstanceMachineTypeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateInstanceConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateShieldedInstanceConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setInstanceLabelsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateInstanceMetadataItemsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .startInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .stopInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .resetInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .reportInstanceInfoSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .isInstanceUpgradeableSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getInstanceHealthSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .upgradeInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .rollbackInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .upgradeInstanceInternalSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listEnvironmentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getEnvironmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createEnvironmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteEnvironmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listSchedulesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getScheduleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteScheduleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createScheduleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .triggerScheduleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listExecutionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getExecutionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteExecutionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createExecutionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createInstanceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
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
          .registerInstanceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RegisterInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
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
          .setInstanceAcceleratorOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SetInstanceAcceleratorRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
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
          .setInstanceMachineTypeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SetInstanceMachineTypeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
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
          .updateInstanceConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateInstanceConfigRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
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
          .updateShieldedInstanceConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateShieldedInstanceConfigRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
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
          .setInstanceLabelsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SetInstanceLabelsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
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
          .deleteInstanceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
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
          .startInstanceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<StartInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
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
          .stopInstanceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<StopInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
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
          .resetInstanceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ResetInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
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
          .reportInstanceInfoOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ReportInstanceInfoRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
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
          .upgradeInstanceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpgradeInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
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
          .rollbackInstanceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RollbackInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
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
          .upgradeInstanceInternalOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpgradeInstanceInternalRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
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
          .createEnvironmentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateEnvironmentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Environment.class))
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
          .deleteEnvironmentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteEnvironmentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
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
          .deleteScheduleOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteScheduleRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
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
          .createScheduleOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateScheduleRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Schedule.class))
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
          .triggerScheduleOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<TriggerScheduleRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Schedule.class))
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
          .deleteExecutionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteExecutionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
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
          .createExecutionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateExecutionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Execution.class))
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

    /** Returns the builder for the settings used for calls to createInstance. */
    public UnaryCallSettings.Builder<CreateInstanceRequest, Operation> createInstanceSettings() {
      return createInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to createInstance. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateInstanceRequest, Instance, OperationMetadata>
        createInstanceOperationSettings() {
      return createInstanceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to registerInstance. */
    public UnaryCallSettings.Builder<RegisterInstanceRequest, Operation>
        registerInstanceSettings() {
      return registerInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to registerInstance. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<RegisterInstanceRequest, Instance, OperationMetadata>
        registerInstanceOperationSettings() {
      return registerInstanceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to setInstanceAccelerator. */
    public UnaryCallSettings.Builder<SetInstanceAcceleratorRequest, Operation>
        setInstanceAcceleratorSettings() {
      return setInstanceAcceleratorSettings;
    }

    /** Returns the builder for the settings used for calls to setInstanceAccelerator. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<SetInstanceAcceleratorRequest, Instance, OperationMetadata>
        setInstanceAcceleratorOperationSettings() {
      return setInstanceAcceleratorOperationSettings;
    }

    /** Returns the builder for the settings used for calls to setInstanceMachineType. */
    public UnaryCallSettings.Builder<SetInstanceMachineTypeRequest, Operation>
        setInstanceMachineTypeSettings() {
      return setInstanceMachineTypeSettings;
    }

    /** Returns the builder for the settings used for calls to setInstanceMachineType. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<SetInstanceMachineTypeRequest, Instance, OperationMetadata>
        setInstanceMachineTypeOperationSettings() {
      return setInstanceMachineTypeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateInstanceConfig. */
    public UnaryCallSettings.Builder<UpdateInstanceConfigRequest, Operation>
        updateInstanceConfigSettings() {
      return updateInstanceConfigSettings;
    }

    /** Returns the builder for the settings used for calls to updateInstanceConfig. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateInstanceConfigRequest, Instance, OperationMetadata>
        updateInstanceConfigOperationSettings() {
      return updateInstanceConfigOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateShieldedInstanceConfig. */
    public UnaryCallSettings.Builder<UpdateShieldedInstanceConfigRequest, Operation>
        updateShieldedInstanceConfigSettings() {
      return updateShieldedInstanceConfigSettings;
    }

    /** Returns the builder for the settings used for calls to updateShieldedInstanceConfig. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            UpdateShieldedInstanceConfigRequest, Instance, OperationMetadata>
        updateShieldedInstanceConfigOperationSettings() {
      return updateShieldedInstanceConfigOperationSettings;
    }

    /** Returns the builder for the settings used for calls to setInstanceLabels. */
    public UnaryCallSettings.Builder<SetInstanceLabelsRequest, Operation>
        setInstanceLabelsSettings() {
      return setInstanceLabelsSettings;
    }

    /** Returns the builder for the settings used for calls to setInstanceLabels. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<SetInstanceLabelsRequest, Instance, OperationMetadata>
        setInstanceLabelsOperationSettings() {
      return setInstanceLabelsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateInstanceMetadataItems. */
    public UnaryCallSettings.Builder<
            UpdateInstanceMetadataItemsRequest, UpdateInstanceMetadataItemsResponse>
        updateInstanceMetadataItemsSettings() {
      return updateInstanceMetadataItemsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteInstance. */
    public UnaryCallSettings.Builder<DeleteInstanceRequest, Operation> deleteInstanceSettings() {
      return deleteInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to deleteInstance. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteInstanceRequest, Empty, OperationMetadata>
        deleteInstanceOperationSettings() {
      return deleteInstanceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to startInstance. */
    public UnaryCallSettings.Builder<StartInstanceRequest, Operation> startInstanceSettings() {
      return startInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to startInstance. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<StartInstanceRequest, Instance, OperationMetadata>
        startInstanceOperationSettings() {
      return startInstanceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to stopInstance. */
    public UnaryCallSettings.Builder<StopInstanceRequest, Operation> stopInstanceSettings() {
      return stopInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to stopInstance. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<StopInstanceRequest, Instance, OperationMetadata>
        stopInstanceOperationSettings() {
      return stopInstanceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to resetInstance. */
    public UnaryCallSettings.Builder<ResetInstanceRequest, Operation> resetInstanceSettings() {
      return resetInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to resetInstance. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<ResetInstanceRequest, Instance, OperationMetadata>
        resetInstanceOperationSettings() {
      return resetInstanceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to reportInstanceInfo. */
    public UnaryCallSettings.Builder<ReportInstanceInfoRequest, Operation>
        reportInstanceInfoSettings() {
      return reportInstanceInfoSettings;
    }

    /** Returns the builder for the settings used for calls to reportInstanceInfo. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<ReportInstanceInfoRequest, Instance, OperationMetadata>
        reportInstanceInfoOperationSettings() {
      return reportInstanceInfoOperationSettings;
    }

    /** Returns the builder for the settings used for calls to isInstanceUpgradeable. */
    public UnaryCallSettings.Builder<IsInstanceUpgradeableRequest, IsInstanceUpgradeableResponse>
        isInstanceUpgradeableSettings() {
      return isInstanceUpgradeableSettings;
    }

    /** Returns the builder for the settings used for calls to getInstanceHealth. */
    public UnaryCallSettings.Builder<GetInstanceHealthRequest, GetInstanceHealthResponse>
        getInstanceHealthSettings() {
      return getInstanceHealthSettings;
    }

    /** Returns the builder for the settings used for calls to upgradeInstance. */
    public UnaryCallSettings.Builder<UpgradeInstanceRequest, Operation> upgradeInstanceSettings() {
      return upgradeInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to upgradeInstance. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpgradeInstanceRequest, Instance, OperationMetadata>
        upgradeInstanceOperationSettings() {
      return upgradeInstanceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to rollbackInstance. */
    public UnaryCallSettings.Builder<RollbackInstanceRequest, Operation>
        rollbackInstanceSettings() {
      return rollbackInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to rollbackInstance. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<RollbackInstanceRequest, Instance, OperationMetadata>
        rollbackInstanceOperationSettings() {
      return rollbackInstanceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to upgradeInstanceInternal. */
    public UnaryCallSettings.Builder<UpgradeInstanceInternalRequest, Operation>
        upgradeInstanceInternalSettings() {
      return upgradeInstanceInternalSettings;
    }

    /** Returns the builder for the settings used for calls to upgradeInstanceInternal. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            UpgradeInstanceInternalRequest, Instance, OperationMetadata>
        upgradeInstanceInternalOperationSettings() {
      return upgradeInstanceInternalOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listEnvironments. */
    public PagedCallSettings.Builder<
            ListEnvironmentsRequest, ListEnvironmentsResponse, ListEnvironmentsPagedResponse>
        listEnvironmentsSettings() {
      return listEnvironmentsSettings;
    }

    /** Returns the builder for the settings used for calls to getEnvironment. */
    public UnaryCallSettings.Builder<GetEnvironmentRequest, Environment> getEnvironmentSettings() {
      return getEnvironmentSettings;
    }

    /** Returns the builder for the settings used for calls to createEnvironment. */
    public UnaryCallSettings.Builder<CreateEnvironmentRequest, Operation>
        createEnvironmentSettings() {
      return createEnvironmentSettings;
    }

    /** Returns the builder for the settings used for calls to createEnvironment. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateEnvironmentRequest, Environment, OperationMetadata>
        createEnvironmentOperationSettings() {
      return createEnvironmentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEnvironment. */
    public UnaryCallSettings.Builder<DeleteEnvironmentRequest, Operation>
        deleteEnvironmentSettings() {
      return deleteEnvironmentSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEnvironment. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteEnvironmentRequest, Empty, OperationMetadata>
        deleteEnvironmentOperationSettings() {
      return deleteEnvironmentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listSchedules. */
    public PagedCallSettings.Builder<
            ListSchedulesRequest, ListSchedulesResponse, ListSchedulesPagedResponse>
        listSchedulesSettings() {
      return listSchedulesSettings;
    }

    /** Returns the builder for the settings used for calls to getSchedule. */
    public UnaryCallSettings.Builder<GetScheduleRequest, Schedule> getScheduleSettings() {
      return getScheduleSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSchedule. */
    public UnaryCallSettings.Builder<DeleteScheduleRequest, Operation> deleteScheduleSettings() {
      return deleteScheduleSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSchedule. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteScheduleRequest, Empty, OperationMetadata>
        deleteScheduleOperationSettings() {
      return deleteScheduleOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createSchedule. */
    public UnaryCallSettings.Builder<CreateScheduleRequest, Operation> createScheduleSettings() {
      return createScheduleSettings;
    }

    /** Returns the builder for the settings used for calls to createSchedule. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateScheduleRequest, Schedule, OperationMetadata>
        createScheduleOperationSettings() {
      return createScheduleOperationSettings;
    }

    /** Returns the builder for the settings used for calls to triggerSchedule. */
    public UnaryCallSettings.Builder<TriggerScheduleRequest, Operation> triggerScheduleSettings() {
      return triggerScheduleSettings;
    }

    /** Returns the builder for the settings used for calls to triggerSchedule. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<TriggerScheduleRequest, Schedule, OperationMetadata>
        triggerScheduleOperationSettings() {
      return triggerScheduleOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listExecutions. */
    public PagedCallSettings.Builder<
            ListExecutionsRequest, ListExecutionsResponse, ListExecutionsPagedResponse>
        listExecutionsSettings() {
      return listExecutionsSettings;
    }

    /** Returns the builder for the settings used for calls to getExecution. */
    public UnaryCallSettings.Builder<GetExecutionRequest, Execution> getExecutionSettings() {
      return getExecutionSettings;
    }

    /** Returns the builder for the settings used for calls to deleteExecution. */
    public UnaryCallSettings.Builder<DeleteExecutionRequest, Operation> deleteExecutionSettings() {
      return deleteExecutionSettings;
    }

    /** Returns the builder for the settings used for calls to deleteExecution. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteExecutionRequest, Empty, OperationMetadata>
        deleteExecutionOperationSettings() {
      return deleteExecutionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createExecution. */
    public UnaryCallSettings.Builder<CreateExecutionRequest, Operation> createExecutionSettings() {
      return createExecutionSettings;
    }

    /** Returns the builder for the settings used for calls to createExecution. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateExecutionRequest, Execution, OperationMetadata>
        createExecutionOperationSettings() {
      return createExecutionOperationSettings;
    }

    @Override
    public NotebookServiceStubSettings build() throws IOException {
      return new NotebookServiceStubSettings(this);
    }
  }
}
