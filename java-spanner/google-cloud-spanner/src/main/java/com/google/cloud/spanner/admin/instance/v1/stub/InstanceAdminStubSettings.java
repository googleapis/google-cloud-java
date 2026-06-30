/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.spanner.admin.instance.v1.stub;

import static com.google.cloud.spanner.admin.instance.v1.InstanceAdminClient.ListInstanceConfigOperationsPagedResponse;
import static com.google.cloud.spanner.admin.instance.v1.InstanceAdminClient.ListInstanceConfigsPagedResponse;
import static com.google.cloud.spanner.admin.instance.v1.InstanceAdminClient.ListInstancePartitionOperationsPagedResponse;
import static com.google.cloud.spanner.admin.instance.v1.InstanceAdminClient.ListInstancePartitionsPagedResponse;
import static com.google.cloud.spanner.admin.instance.v1.InstanceAdminClient.ListInstancesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.core.ObsoleteApi;
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
import com.google.api.gax.rpc.LibraryMetadata;
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
import com.google.spanner.admin.instance.v1.CreateInstanceConfigMetadata;
import com.google.spanner.admin.instance.v1.CreateInstanceConfigRequest;
import com.google.spanner.admin.instance.v1.CreateInstanceMetadata;
import com.google.spanner.admin.instance.v1.CreateInstancePartitionMetadata;
import com.google.spanner.admin.instance.v1.CreateInstancePartitionRequest;
import com.google.spanner.admin.instance.v1.CreateInstanceRequest;
import com.google.spanner.admin.instance.v1.DeleteInstanceConfigRequest;
import com.google.spanner.admin.instance.v1.DeleteInstancePartitionRequest;
import com.google.spanner.admin.instance.v1.DeleteInstanceRequest;
import com.google.spanner.admin.instance.v1.GetInstanceConfigRequest;
import com.google.spanner.admin.instance.v1.GetInstancePartitionRequest;
import com.google.spanner.admin.instance.v1.GetInstanceRequest;
import com.google.spanner.admin.instance.v1.Instance;
import com.google.spanner.admin.instance.v1.InstanceConfig;
import com.google.spanner.admin.instance.v1.InstancePartition;
import com.google.spanner.admin.instance.v1.ListInstanceConfigOperationsRequest;
import com.google.spanner.admin.instance.v1.ListInstanceConfigOperationsResponse;
import com.google.spanner.admin.instance.v1.ListInstanceConfigsRequest;
import com.google.spanner.admin.instance.v1.ListInstanceConfigsResponse;
import com.google.spanner.admin.instance.v1.ListInstancePartitionOperationsRequest;
import com.google.spanner.admin.instance.v1.ListInstancePartitionOperationsResponse;
import com.google.spanner.admin.instance.v1.ListInstancePartitionsRequest;
import com.google.spanner.admin.instance.v1.ListInstancePartitionsResponse;
import com.google.spanner.admin.instance.v1.ListInstancesRequest;
import com.google.spanner.admin.instance.v1.ListInstancesResponse;
import com.google.spanner.admin.instance.v1.MoveInstanceMetadata;
import com.google.spanner.admin.instance.v1.MoveInstanceRequest;
import com.google.spanner.admin.instance.v1.MoveInstanceResponse;
import com.google.spanner.admin.instance.v1.UpdateInstanceConfigMetadata;
import com.google.spanner.admin.instance.v1.UpdateInstanceConfigRequest;
import com.google.spanner.admin.instance.v1.UpdateInstanceMetadata;
import com.google.spanner.admin.instance.v1.UpdateInstancePartitionMetadata;
import com.google.spanner.admin.instance.v1.UpdateInstancePartitionRequest;
import com.google.spanner.admin.instance.v1.UpdateInstanceRequest;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link InstanceAdminStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (spanner.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getInstanceConfig:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * InstanceAdminStubSettings.Builder instanceAdminSettingsBuilder =
 *     InstanceAdminStubSettings.newBuilder();
 * instanceAdminSettingsBuilder
 *     .getInstanceConfigSettings()
 *     .setRetrySettings(
 *         instanceAdminSettingsBuilder
 *             .getInstanceConfigSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * InstanceAdminStubSettings instanceAdminSettings = instanceAdminSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createInstanceConfig:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * InstanceAdminStubSettings.Builder instanceAdminSettingsBuilder =
 *     InstanceAdminStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * instanceAdminSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class InstanceAdminStubSettings extends StubSettings<InstanceAdminStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/spanner.admin")
          .build();

  private final PagedCallSettings<
          ListInstanceConfigsRequest, ListInstanceConfigsResponse, ListInstanceConfigsPagedResponse>
      listInstanceConfigsSettings;
  private final UnaryCallSettings<GetInstanceConfigRequest, InstanceConfig>
      getInstanceConfigSettings;
  private final UnaryCallSettings<CreateInstanceConfigRequest, Operation>
      createInstanceConfigSettings;
  private final OperationCallSettings<
          CreateInstanceConfigRequest, InstanceConfig, CreateInstanceConfigMetadata>
      createInstanceConfigOperationSettings;
  private final UnaryCallSettings<UpdateInstanceConfigRequest, Operation>
      updateInstanceConfigSettings;
  private final OperationCallSettings<
          UpdateInstanceConfigRequest, InstanceConfig, UpdateInstanceConfigMetadata>
      updateInstanceConfigOperationSettings;
  private final UnaryCallSettings<DeleteInstanceConfigRequest, Empty> deleteInstanceConfigSettings;
  private final PagedCallSettings<
          ListInstanceConfigOperationsRequest,
          ListInstanceConfigOperationsResponse,
          ListInstanceConfigOperationsPagedResponse>
      listInstanceConfigOperationsSettings;
  private final PagedCallSettings<
          ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
      listInstancesSettings;
  private final PagedCallSettings<
          ListInstancePartitionsRequest,
          ListInstancePartitionsResponse,
          ListInstancePartitionsPagedResponse>
      listInstancePartitionsSettings;
  private final UnaryCallSettings<GetInstanceRequest, Instance> getInstanceSettings;
  private final UnaryCallSettings<CreateInstanceRequest, Operation> createInstanceSettings;
  private final OperationCallSettings<CreateInstanceRequest, Instance, CreateInstanceMetadata>
      createInstanceOperationSettings;
  private final UnaryCallSettings<UpdateInstanceRequest, Operation> updateInstanceSettings;
  private final OperationCallSettings<UpdateInstanceRequest, Instance, UpdateInstanceMetadata>
      updateInstanceOperationSettings;
  private final UnaryCallSettings<DeleteInstanceRequest, Empty> deleteInstanceSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;
  private final UnaryCallSettings<GetInstancePartitionRequest, InstancePartition>
      getInstancePartitionSettings;
  private final UnaryCallSettings<CreateInstancePartitionRequest, Operation>
      createInstancePartitionSettings;
  private final OperationCallSettings<
          CreateInstancePartitionRequest, InstancePartition, CreateInstancePartitionMetadata>
      createInstancePartitionOperationSettings;
  private final UnaryCallSettings<DeleteInstancePartitionRequest, Empty>
      deleteInstancePartitionSettings;
  private final UnaryCallSettings<UpdateInstancePartitionRequest, Operation>
      updateInstancePartitionSettings;
  private final OperationCallSettings<
          UpdateInstancePartitionRequest, InstancePartition, UpdateInstancePartitionMetadata>
      updateInstancePartitionOperationSettings;
  private final PagedCallSettings<
          ListInstancePartitionOperationsRequest,
          ListInstancePartitionOperationsResponse,
          ListInstancePartitionOperationsPagedResponse>
      listInstancePartitionOperationsSettings;
  private final UnaryCallSettings<MoveInstanceRequest, Operation> moveInstanceSettings;
  private final OperationCallSettings<
          MoveInstanceRequest, MoveInstanceResponse, MoveInstanceMetadata>
      moveInstanceOperationSettings;

  private static final PagedListDescriptor<
          ListInstanceConfigsRequest, ListInstanceConfigsResponse, InstanceConfig>
      LIST_INSTANCE_CONFIGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListInstanceConfigsRequest, ListInstanceConfigsResponse, InstanceConfig>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListInstanceConfigsRequest injectToken(
                ListInstanceConfigsRequest payload, String token) {
              return ListInstanceConfigsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListInstanceConfigsRequest injectPageSize(
                ListInstanceConfigsRequest payload, int pageSize) {
              return ListInstanceConfigsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListInstanceConfigsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListInstanceConfigsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<InstanceConfig> extractResources(ListInstanceConfigsResponse payload) {
              return payload.getInstanceConfigsList();
            }
          };

  private static final PagedListDescriptor<
          ListInstanceConfigOperationsRequest, ListInstanceConfigOperationsResponse, Operation>
      LIST_INSTANCE_CONFIG_OPERATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListInstanceConfigOperationsRequest,
              ListInstanceConfigOperationsResponse,
              Operation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListInstanceConfigOperationsRequest injectToken(
                ListInstanceConfigOperationsRequest payload, String token) {
              return ListInstanceConfigOperationsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListInstanceConfigOperationsRequest injectPageSize(
                ListInstanceConfigOperationsRequest payload, int pageSize) {
              return ListInstanceConfigOperationsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListInstanceConfigOperationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListInstanceConfigOperationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Operation> extractResources(
                ListInstanceConfigOperationsResponse payload) {
              return payload.getOperationsList();
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
              return payload.getInstancesList();
            }
          };

  private static final PagedListDescriptor<
          ListInstancePartitionsRequest, ListInstancePartitionsResponse, InstancePartition>
      LIST_INSTANCE_PARTITIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListInstancePartitionsRequest, ListInstancePartitionsResponse, InstancePartition>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListInstancePartitionsRequest injectToken(
                ListInstancePartitionsRequest payload, String token) {
              return ListInstancePartitionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListInstancePartitionsRequest injectPageSize(
                ListInstancePartitionsRequest payload, int pageSize) {
              return ListInstancePartitionsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListInstancePartitionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListInstancePartitionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<InstancePartition> extractResources(
                ListInstancePartitionsResponse payload) {
              return payload.getInstancePartitionsList();
            }
          };

  private static final PagedListDescriptor<
          ListInstancePartitionOperationsRequest,
          ListInstancePartitionOperationsResponse,
          Operation>
      LIST_INSTANCE_PARTITION_OPERATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListInstancePartitionOperationsRequest,
              ListInstancePartitionOperationsResponse,
              Operation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListInstancePartitionOperationsRequest injectToken(
                ListInstancePartitionOperationsRequest payload, String token) {
              return ListInstancePartitionOperationsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListInstancePartitionOperationsRequest injectPageSize(
                ListInstancePartitionOperationsRequest payload, int pageSize) {
              return ListInstancePartitionOperationsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListInstancePartitionOperationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListInstancePartitionOperationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Operation> extractResources(
                ListInstancePartitionOperationsResponse payload) {
              return payload.getOperationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListInstanceConfigsRequest, ListInstanceConfigsResponse, ListInstanceConfigsPagedResponse>
      LIST_INSTANCE_CONFIGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListInstanceConfigsRequest,
              ListInstanceConfigsResponse,
              ListInstanceConfigsPagedResponse>() {
            @Override
            public ApiFuture<ListInstanceConfigsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListInstanceConfigsRequest, ListInstanceConfigsResponse> callable,
                ListInstanceConfigsRequest request,
                ApiCallContext context,
                ApiFuture<ListInstanceConfigsResponse> futureResponse) {
              PageContext<ListInstanceConfigsRequest, ListInstanceConfigsResponse, InstanceConfig>
                  pageContext =
                      PageContext.create(
                          callable, LIST_INSTANCE_CONFIGS_PAGE_STR_DESC, request, context);
              return ListInstanceConfigsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListInstanceConfigOperationsRequest,
          ListInstanceConfigOperationsResponse,
          ListInstanceConfigOperationsPagedResponse>
      LIST_INSTANCE_CONFIG_OPERATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListInstanceConfigOperationsRequest,
              ListInstanceConfigOperationsResponse,
              ListInstanceConfigOperationsPagedResponse>() {
            @Override
            public ApiFuture<ListInstanceConfigOperationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListInstanceConfigOperationsRequest, ListInstanceConfigOperationsResponse>
                    callable,
                ListInstanceConfigOperationsRequest request,
                ApiCallContext context,
                ApiFuture<ListInstanceConfigOperationsResponse> futureResponse) {
              PageContext<
                      ListInstanceConfigOperationsRequest,
                      ListInstanceConfigOperationsResponse,
                      Operation>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_INSTANCE_CONFIG_OPERATIONS_PAGE_STR_DESC,
                          request,
                          context);
              return ListInstanceConfigOperationsPagedResponse.createAsync(
                  pageContext, futureResponse);
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
          ListInstancePartitionsRequest,
          ListInstancePartitionsResponse,
          ListInstancePartitionsPagedResponse>
      LIST_INSTANCE_PARTITIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListInstancePartitionsRequest,
              ListInstancePartitionsResponse,
              ListInstancePartitionsPagedResponse>() {
            @Override
            public ApiFuture<ListInstancePartitionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListInstancePartitionsRequest, ListInstancePartitionsResponse>
                    callable,
                ListInstancePartitionsRequest request,
                ApiCallContext context,
                ApiFuture<ListInstancePartitionsResponse> futureResponse) {
              PageContext<
                      ListInstancePartitionsRequest,
                      ListInstancePartitionsResponse,
                      InstancePartition>
                  pageContext =
                      PageContext.create(
                          callable, LIST_INSTANCE_PARTITIONS_PAGE_STR_DESC, request, context);
              return ListInstancePartitionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListInstancePartitionOperationsRequest,
          ListInstancePartitionOperationsResponse,
          ListInstancePartitionOperationsPagedResponse>
      LIST_INSTANCE_PARTITION_OPERATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListInstancePartitionOperationsRequest,
              ListInstancePartitionOperationsResponse,
              ListInstancePartitionOperationsPagedResponse>() {
            @Override
            public ApiFuture<ListInstancePartitionOperationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListInstancePartitionOperationsRequest,
                        ListInstancePartitionOperationsResponse>
                    callable,
                ListInstancePartitionOperationsRequest request,
                ApiCallContext context,
                ApiFuture<ListInstancePartitionOperationsResponse> futureResponse) {
              PageContext<
                      ListInstancePartitionOperationsRequest,
                      ListInstancePartitionOperationsResponse,
                      Operation>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_INSTANCE_PARTITION_OPERATIONS_PAGE_STR_DESC,
                          request,
                          context);
              return ListInstancePartitionOperationsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listInstanceConfigs. */
  public PagedCallSettings<
          ListInstanceConfigsRequest, ListInstanceConfigsResponse, ListInstanceConfigsPagedResponse>
      listInstanceConfigsSettings() {
    return listInstanceConfigsSettings;
  }

  /** Returns the object with the settings used for calls to getInstanceConfig. */
  public UnaryCallSettings<GetInstanceConfigRequest, InstanceConfig> getInstanceConfigSettings() {
    return getInstanceConfigSettings;
  }

  /** Returns the object with the settings used for calls to createInstanceConfig. */
  public UnaryCallSettings<CreateInstanceConfigRequest, Operation> createInstanceConfigSettings() {
    return createInstanceConfigSettings;
  }

  /** Returns the object with the settings used for calls to createInstanceConfig. */
  public OperationCallSettings<
          CreateInstanceConfigRequest, InstanceConfig, CreateInstanceConfigMetadata>
      createInstanceConfigOperationSettings() {
    return createInstanceConfigOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateInstanceConfig. */
  public UnaryCallSettings<UpdateInstanceConfigRequest, Operation> updateInstanceConfigSettings() {
    return updateInstanceConfigSettings;
  }

  /** Returns the object with the settings used for calls to updateInstanceConfig. */
  public OperationCallSettings<
          UpdateInstanceConfigRequest, InstanceConfig, UpdateInstanceConfigMetadata>
      updateInstanceConfigOperationSettings() {
    return updateInstanceConfigOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteInstanceConfig. */
  public UnaryCallSettings<DeleteInstanceConfigRequest, Empty> deleteInstanceConfigSettings() {
    return deleteInstanceConfigSettings;
  }

  /** Returns the object with the settings used for calls to listInstanceConfigOperations. */
  public PagedCallSettings<
          ListInstanceConfigOperationsRequest,
          ListInstanceConfigOperationsResponse,
          ListInstanceConfigOperationsPagedResponse>
      listInstanceConfigOperationsSettings() {
    return listInstanceConfigOperationsSettings;
  }

  /** Returns the object with the settings used for calls to listInstances. */
  public PagedCallSettings<ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
      listInstancesSettings() {
    return listInstancesSettings;
  }

  /** Returns the object with the settings used for calls to listInstancePartitions. */
  public PagedCallSettings<
          ListInstancePartitionsRequest,
          ListInstancePartitionsResponse,
          ListInstancePartitionsPagedResponse>
      listInstancePartitionsSettings() {
    return listInstancePartitionsSettings;
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
  public OperationCallSettings<CreateInstanceRequest, Instance, CreateInstanceMetadata>
      createInstanceOperationSettings() {
    return createInstanceOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateInstance. */
  public UnaryCallSettings<UpdateInstanceRequest, Operation> updateInstanceSettings() {
    return updateInstanceSettings;
  }

  /** Returns the object with the settings used for calls to updateInstance. */
  public OperationCallSettings<UpdateInstanceRequest, Instance, UpdateInstanceMetadata>
      updateInstanceOperationSettings() {
    return updateInstanceOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteInstance. */
  public UnaryCallSettings<DeleteInstanceRequest, Empty> deleteInstanceSettings() {
    return deleteInstanceSettings;
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

  /** Returns the object with the settings used for calls to getInstancePartition. */
  public UnaryCallSettings<GetInstancePartitionRequest, InstancePartition>
      getInstancePartitionSettings() {
    return getInstancePartitionSettings;
  }

  /** Returns the object with the settings used for calls to createInstancePartition. */
  public UnaryCallSettings<CreateInstancePartitionRequest, Operation>
      createInstancePartitionSettings() {
    return createInstancePartitionSettings;
  }

  /** Returns the object with the settings used for calls to createInstancePartition. */
  public OperationCallSettings<
          CreateInstancePartitionRequest, InstancePartition, CreateInstancePartitionMetadata>
      createInstancePartitionOperationSettings() {
    return createInstancePartitionOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteInstancePartition. */
  public UnaryCallSettings<DeleteInstancePartitionRequest, Empty>
      deleteInstancePartitionSettings() {
    return deleteInstancePartitionSettings;
  }

  /** Returns the object with the settings used for calls to updateInstancePartition. */
  public UnaryCallSettings<UpdateInstancePartitionRequest, Operation>
      updateInstancePartitionSettings() {
    return updateInstancePartitionSettings;
  }

  /** Returns the object with the settings used for calls to updateInstancePartition. */
  public OperationCallSettings<
          UpdateInstancePartitionRequest, InstancePartition, UpdateInstancePartitionMetadata>
      updateInstancePartitionOperationSettings() {
    return updateInstancePartitionOperationSettings;
  }

  /** Returns the object with the settings used for calls to listInstancePartitionOperations. */
  public PagedCallSettings<
          ListInstancePartitionOperationsRequest,
          ListInstancePartitionOperationsResponse,
          ListInstancePartitionOperationsPagedResponse>
      listInstancePartitionOperationsSettings() {
    return listInstancePartitionOperationsSettings;
  }

  /** Returns the object with the settings used for calls to moveInstance. */
  public UnaryCallSettings<MoveInstanceRequest, Operation> moveInstanceSettings() {
    return moveInstanceSettings;
  }

  /** Returns the object with the settings used for calls to moveInstance. */
  public OperationCallSettings<MoveInstanceRequest, MoveInstanceResponse, MoveInstanceMetadata>
      moveInstanceOperationSettings() {
    return moveInstanceOperationSettings;
  }

  public InstanceAdminStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcInstanceAdminStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonInstanceAdminStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "spanner";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "spanner.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "spanner.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(InstanceAdminStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(InstanceAdminStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return InstanceAdminStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected InstanceAdminStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listInstanceConfigsSettings = settingsBuilder.listInstanceConfigsSettings().build();
    getInstanceConfigSettings = settingsBuilder.getInstanceConfigSettings().build();
    createInstanceConfigSettings = settingsBuilder.createInstanceConfigSettings().build();
    createInstanceConfigOperationSettings =
        settingsBuilder.createInstanceConfigOperationSettings().build();
    updateInstanceConfigSettings = settingsBuilder.updateInstanceConfigSettings().build();
    updateInstanceConfigOperationSettings =
        settingsBuilder.updateInstanceConfigOperationSettings().build();
    deleteInstanceConfigSettings = settingsBuilder.deleteInstanceConfigSettings().build();
    listInstanceConfigOperationsSettings =
        settingsBuilder.listInstanceConfigOperationsSettings().build();
    listInstancesSettings = settingsBuilder.listInstancesSettings().build();
    listInstancePartitionsSettings = settingsBuilder.listInstancePartitionsSettings().build();
    getInstanceSettings = settingsBuilder.getInstanceSettings().build();
    createInstanceSettings = settingsBuilder.createInstanceSettings().build();
    createInstanceOperationSettings = settingsBuilder.createInstanceOperationSettings().build();
    updateInstanceSettings = settingsBuilder.updateInstanceSettings().build();
    updateInstanceOperationSettings = settingsBuilder.updateInstanceOperationSettings().build();
    deleteInstanceSettings = settingsBuilder.deleteInstanceSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
    getInstancePartitionSettings = settingsBuilder.getInstancePartitionSettings().build();
    createInstancePartitionSettings = settingsBuilder.createInstancePartitionSettings().build();
    createInstancePartitionOperationSettings =
        settingsBuilder.createInstancePartitionOperationSettings().build();
    deleteInstancePartitionSettings = settingsBuilder.deleteInstancePartitionSettings().build();
    updateInstancePartitionSettings = settingsBuilder.updateInstancePartitionSettings().build();
    updateInstancePartitionOperationSettings =
        settingsBuilder.updateInstancePartitionOperationSettings().build();
    listInstancePartitionOperationsSettings =
        settingsBuilder.listInstancePartitionOperationsSettings().build();
    moveInstanceSettings = settingsBuilder.moveInstanceSettings().build();
    moveInstanceOperationSettings = settingsBuilder.moveInstanceOperationSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.cloud:google-cloud-spanner")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for InstanceAdminStubSettings. */
  public static class Builder extends StubSettings.Builder<InstanceAdminStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListInstanceConfigsRequest,
            ListInstanceConfigsResponse,
            ListInstanceConfigsPagedResponse>
        listInstanceConfigsSettings;
    private final UnaryCallSettings.Builder<GetInstanceConfigRequest, InstanceConfig>
        getInstanceConfigSettings;
    private final UnaryCallSettings.Builder<CreateInstanceConfigRequest, Operation>
        createInstanceConfigSettings;
    private final OperationCallSettings.Builder<
            CreateInstanceConfigRequest, InstanceConfig, CreateInstanceConfigMetadata>
        createInstanceConfigOperationSettings;
    private final UnaryCallSettings.Builder<UpdateInstanceConfigRequest, Operation>
        updateInstanceConfigSettings;
    private final OperationCallSettings.Builder<
            UpdateInstanceConfigRequest, InstanceConfig, UpdateInstanceConfigMetadata>
        updateInstanceConfigOperationSettings;
    private final UnaryCallSettings.Builder<DeleteInstanceConfigRequest, Empty>
        deleteInstanceConfigSettings;
    private final PagedCallSettings.Builder<
            ListInstanceConfigOperationsRequest,
            ListInstanceConfigOperationsResponse,
            ListInstanceConfigOperationsPagedResponse>
        listInstanceConfigOperationsSettings;
    private final PagedCallSettings.Builder<
            ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
        listInstancesSettings;
    private final PagedCallSettings.Builder<
            ListInstancePartitionsRequest,
            ListInstancePartitionsResponse,
            ListInstancePartitionsPagedResponse>
        listInstancePartitionsSettings;
    private final UnaryCallSettings.Builder<GetInstanceRequest, Instance> getInstanceSettings;
    private final UnaryCallSettings.Builder<CreateInstanceRequest, Operation>
        createInstanceSettings;
    private final OperationCallSettings.Builder<
            CreateInstanceRequest, Instance, CreateInstanceMetadata>
        createInstanceOperationSettings;
    private final UnaryCallSettings.Builder<UpdateInstanceRequest, Operation>
        updateInstanceSettings;
    private final OperationCallSettings.Builder<
            UpdateInstanceRequest, Instance, UpdateInstanceMetadata>
        updateInstanceOperationSettings;
    private final UnaryCallSettings.Builder<DeleteInstanceRequest, Empty> deleteInstanceSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
    private final UnaryCallSettings.Builder<GetInstancePartitionRequest, InstancePartition>
        getInstancePartitionSettings;
    private final UnaryCallSettings.Builder<CreateInstancePartitionRequest, Operation>
        createInstancePartitionSettings;
    private final OperationCallSettings.Builder<
            CreateInstancePartitionRequest, InstancePartition, CreateInstancePartitionMetadata>
        createInstancePartitionOperationSettings;
    private final UnaryCallSettings.Builder<DeleteInstancePartitionRequest, Empty>
        deleteInstancePartitionSettings;
    private final UnaryCallSettings.Builder<UpdateInstancePartitionRequest, Operation>
        updateInstancePartitionSettings;
    private final OperationCallSettings.Builder<
            UpdateInstancePartitionRequest, InstancePartition, UpdateInstancePartitionMetadata>
        updateInstancePartitionOperationSettings;
    private final PagedCallSettings.Builder<
            ListInstancePartitionOperationsRequest,
            ListInstancePartitionOperationsResponse,
            ListInstancePartitionOperationsPagedResponse>
        listInstancePartitionOperationsSettings;
    private final UnaryCallSettings.Builder<MoveInstanceRequest, Operation> moveInstanceSettings;
    private final OperationCallSettings.Builder<
            MoveInstanceRequest, MoveInstanceResponse, MoveInstanceMetadata>
        moveInstanceOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNAVAILABLE, StatusCode.Code.DEADLINE_EXCEEDED)));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "no_retry_2_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "no_retry_3_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_1_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNAVAILABLE, StatusCode.Code.DEADLINE_EXCEEDED)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(32000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(3600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(3600000L))
              .setTotalTimeoutDuration(Duration.ofMillis(3600000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(3600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(3600000L))
              .setTotalTimeoutDuration(Duration.ofMillis(3600000L))
              .build();
      definitions.put("no_retry_2_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(30000L))
              .setTotalTimeoutDuration(Duration.ofMillis(30000L))
              .build();
      definitions.put("no_retry_3_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(32000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(30000L))
              .setTotalTimeoutDuration(Duration.ofMillis(30000L))
              .build();
      definitions.put("retry_policy_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listInstanceConfigsSettings =
          PagedCallSettings.newBuilder(LIST_INSTANCE_CONFIGS_PAGE_STR_FACT);
      getInstanceConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createInstanceConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createInstanceConfigOperationSettings = OperationCallSettings.newBuilder();
      updateInstanceConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateInstanceConfigOperationSettings = OperationCallSettings.newBuilder();
      deleteInstanceConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listInstanceConfigOperationsSettings =
          PagedCallSettings.newBuilder(LIST_INSTANCE_CONFIG_OPERATIONS_PAGE_STR_FACT);
      listInstancesSettings = PagedCallSettings.newBuilder(LIST_INSTANCES_PAGE_STR_FACT);
      listInstancePartitionsSettings =
          PagedCallSettings.newBuilder(LIST_INSTANCE_PARTITIONS_PAGE_STR_FACT);
      getInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createInstanceOperationSettings = OperationCallSettings.newBuilder();
      updateInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateInstanceOperationSettings = OperationCallSettings.newBuilder();
      deleteInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getInstancePartitionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createInstancePartitionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createInstancePartitionOperationSettings = OperationCallSettings.newBuilder();
      deleteInstancePartitionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateInstancePartitionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateInstancePartitionOperationSettings = OperationCallSettings.newBuilder();
      listInstancePartitionOperationsSettings =
          PagedCallSettings.newBuilder(LIST_INSTANCE_PARTITION_OPERATIONS_PAGE_STR_FACT);
      moveInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      moveInstanceOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listInstanceConfigsSettings,
              getInstanceConfigSettings,
              createInstanceConfigSettings,
              updateInstanceConfigSettings,
              deleteInstanceConfigSettings,
              listInstanceConfigOperationsSettings,
              listInstancesSettings,
              listInstancePartitionsSettings,
              getInstanceSettings,
              createInstanceSettings,
              updateInstanceSettings,
              deleteInstanceSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings,
              getInstancePartitionSettings,
              createInstancePartitionSettings,
              deleteInstancePartitionSettings,
              updateInstancePartitionSettings,
              listInstancePartitionOperationsSettings,
              moveInstanceSettings);
      initDefaults(this);
    }

    protected Builder(InstanceAdminStubSettings settings) {
      super(settings);

      listInstanceConfigsSettings = settings.listInstanceConfigsSettings.toBuilder();
      getInstanceConfigSettings = settings.getInstanceConfigSettings.toBuilder();
      createInstanceConfigSettings = settings.createInstanceConfigSettings.toBuilder();
      createInstanceConfigOperationSettings =
          settings.createInstanceConfigOperationSettings.toBuilder();
      updateInstanceConfigSettings = settings.updateInstanceConfigSettings.toBuilder();
      updateInstanceConfigOperationSettings =
          settings.updateInstanceConfigOperationSettings.toBuilder();
      deleteInstanceConfigSettings = settings.deleteInstanceConfigSettings.toBuilder();
      listInstanceConfigOperationsSettings =
          settings.listInstanceConfigOperationsSettings.toBuilder();
      listInstancesSettings = settings.listInstancesSettings.toBuilder();
      listInstancePartitionsSettings = settings.listInstancePartitionsSettings.toBuilder();
      getInstanceSettings = settings.getInstanceSettings.toBuilder();
      createInstanceSettings = settings.createInstanceSettings.toBuilder();
      createInstanceOperationSettings = settings.createInstanceOperationSettings.toBuilder();
      updateInstanceSettings = settings.updateInstanceSettings.toBuilder();
      updateInstanceOperationSettings = settings.updateInstanceOperationSettings.toBuilder();
      deleteInstanceSettings = settings.deleteInstanceSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();
      getInstancePartitionSettings = settings.getInstancePartitionSettings.toBuilder();
      createInstancePartitionSettings = settings.createInstancePartitionSettings.toBuilder();
      createInstancePartitionOperationSettings =
          settings.createInstancePartitionOperationSettings.toBuilder();
      deleteInstancePartitionSettings = settings.deleteInstancePartitionSettings.toBuilder();
      updateInstancePartitionSettings = settings.updateInstancePartitionSettings.toBuilder();
      updateInstancePartitionOperationSettings =
          settings.updateInstancePartitionOperationSettings.toBuilder();
      listInstancePartitionOperationsSettings =
          settings.listInstancePartitionOperationsSettings.toBuilder();
      moveInstanceSettings = settings.moveInstanceSettings.toBuilder();
      moveInstanceOperationSettings = settings.moveInstanceOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listInstanceConfigsSettings,
              getInstanceConfigSettings,
              createInstanceConfigSettings,
              updateInstanceConfigSettings,
              deleteInstanceConfigSettings,
              listInstanceConfigOperationsSettings,
              listInstancesSettings,
              listInstancePartitionsSettings,
              getInstanceSettings,
              createInstanceSettings,
              updateInstanceSettings,
              deleteInstanceSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings,
              getInstancePartitionSettings,
              createInstancePartitionSettings,
              deleteInstancePartitionSettings,
              updateInstancePartitionSettings,
              listInstancePartitionOperationsSettings,
              moveInstanceSettings);
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
          .listInstanceConfigsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getInstanceConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createInstanceConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateInstanceConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteInstanceConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listInstanceConfigOperationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listInstancesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listInstancePartitionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .updateInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .deleteInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .getInstancePartitionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createInstancePartitionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteInstancePartitionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateInstancePartitionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listInstancePartitionOperationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .moveInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createInstanceConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateInstanceConfigRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(InstanceConfig.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  CreateInstanceConfigMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateInstanceConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateInstanceConfigRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(InstanceConfig.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  UpdateInstanceConfigMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createInstanceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Instance.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(CreateInstanceMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(20000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(86400000L))
                      .build()));

      builder
          .updateInstanceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Instance.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(UpdateInstanceMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(20000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(86400000L))
                      .build()));

      builder
          .createInstancePartitionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateInstancePartitionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(InstancePartition.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  CreateInstancePartitionMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateInstancePartitionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateInstancePartitionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(InstancePartition.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  UpdateInstancePartitionMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .moveInstanceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<MoveInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(MoveInstanceResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(MoveInstanceMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
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

    /** Returns the builder for the settings used for calls to listInstanceConfigs. */
    public PagedCallSettings.Builder<
            ListInstanceConfigsRequest,
            ListInstanceConfigsResponse,
            ListInstanceConfigsPagedResponse>
        listInstanceConfigsSettings() {
      return listInstanceConfigsSettings;
    }

    /** Returns the builder for the settings used for calls to getInstanceConfig. */
    public UnaryCallSettings.Builder<GetInstanceConfigRequest, InstanceConfig>
        getInstanceConfigSettings() {
      return getInstanceConfigSettings;
    }

    /** Returns the builder for the settings used for calls to createInstanceConfig. */
    public UnaryCallSettings.Builder<CreateInstanceConfigRequest, Operation>
        createInstanceConfigSettings() {
      return createInstanceConfigSettings;
    }

    /** Returns the builder for the settings used for calls to createInstanceConfig. */
    public OperationCallSettings.Builder<
            CreateInstanceConfigRequest, InstanceConfig, CreateInstanceConfigMetadata>
        createInstanceConfigOperationSettings() {
      return createInstanceConfigOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateInstanceConfig. */
    public UnaryCallSettings.Builder<UpdateInstanceConfigRequest, Operation>
        updateInstanceConfigSettings() {
      return updateInstanceConfigSettings;
    }

    /** Returns the builder for the settings used for calls to updateInstanceConfig. */
    public OperationCallSettings.Builder<
            UpdateInstanceConfigRequest, InstanceConfig, UpdateInstanceConfigMetadata>
        updateInstanceConfigOperationSettings() {
      return updateInstanceConfigOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteInstanceConfig. */
    public UnaryCallSettings.Builder<DeleteInstanceConfigRequest, Empty>
        deleteInstanceConfigSettings() {
      return deleteInstanceConfigSettings;
    }

    /** Returns the builder for the settings used for calls to listInstanceConfigOperations. */
    public PagedCallSettings.Builder<
            ListInstanceConfigOperationsRequest,
            ListInstanceConfigOperationsResponse,
            ListInstanceConfigOperationsPagedResponse>
        listInstanceConfigOperationsSettings() {
      return listInstanceConfigOperationsSettings;
    }

    /** Returns the builder for the settings used for calls to listInstances. */
    public PagedCallSettings.Builder<
            ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
        listInstancesSettings() {
      return listInstancesSettings;
    }

    /** Returns the builder for the settings used for calls to listInstancePartitions. */
    public PagedCallSettings.Builder<
            ListInstancePartitionsRequest,
            ListInstancePartitionsResponse,
            ListInstancePartitionsPagedResponse>
        listInstancePartitionsSettings() {
      return listInstancePartitionsSettings;
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
    public OperationCallSettings.Builder<CreateInstanceRequest, Instance, CreateInstanceMetadata>
        createInstanceOperationSettings() {
      return createInstanceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateInstance. */
    public UnaryCallSettings.Builder<UpdateInstanceRequest, Operation> updateInstanceSettings() {
      return updateInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to updateInstance. */
    public OperationCallSettings.Builder<UpdateInstanceRequest, Instance, UpdateInstanceMetadata>
        updateInstanceOperationSettings() {
      return updateInstanceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteInstance. */
    public UnaryCallSettings.Builder<DeleteInstanceRequest, Empty> deleteInstanceSettings() {
      return deleteInstanceSettings;
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

    /** Returns the builder for the settings used for calls to getInstancePartition. */
    public UnaryCallSettings.Builder<GetInstancePartitionRequest, InstancePartition>
        getInstancePartitionSettings() {
      return getInstancePartitionSettings;
    }

    /** Returns the builder for the settings used for calls to createInstancePartition. */
    public UnaryCallSettings.Builder<CreateInstancePartitionRequest, Operation>
        createInstancePartitionSettings() {
      return createInstancePartitionSettings;
    }

    /** Returns the builder for the settings used for calls to createInstancePartition. */
    public OperationCallSettings.Builder<
            CreateInstancePartitionRequest, InstancePartition, CreateInstancePartitionMetadata>
        createInstancePartitionOperationSettings() {
      return createInstancePartitionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteInstancePartition. */
    public UnaryCallSettings.Builder<DeleteInstancePartitionRequest, Empty>
        deleteInstancePartitionSettings() {
      return deleteInstancePartitionSettings;
    }

    /** Returns the builder for the settings used for calls to updateInstancePartition. */
    public UnaryCallSettings.Builder<UpdateInstancePartitionRequest, Operation>
        updateInstancePartitionSettings() {
      return updateInstancePartitionSettings;
    }

    /** Returns the builder for the settings used for calls to updateInstancePartition. */
    public OperationCallSettings.Builder<
            UpdateInstancePartitionRequest, InstancePartition, UpdateInstancePartitionMetadata>
        updateInstancePartitionOperationSettings() {
      return updateInstancePartitionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listInstancePartitionOperations. */
    public PagedCallSettings.Builder<
            ListInstancePartitionOperationsRequest,
            ListInstancePartitionOperationsResponse,
            ListInstancePartitionOperationsPagedResponse>
        listInstancePartitionOperationsSettings() {
      return listInstancePartitionOperationsSettings;
    }

    /** Returns the builder for the settings used for calls to moveInstance. */
    public UnaryCallSettings.Builder<MoveInstanceRequest, Operation> moveInstanceSettings() {
      return moveInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to moveInstance. */
    public OperationCallSettings.Builder<
            MoveInstanceRequest, MoveInstanceResponse, MoveInstanceMetadata>
        moveInstanceOperationSettings() {
      return moveInstanceOperationSettings;
    }

    @Override
    public InstanceAdminStubSettings build() throws IOException {
      return new InstanceAdminStubSettings(this);
    }
  }
}
